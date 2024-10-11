package com.exp.ucmp.carDealer.service.impl;

import com.egrid.core.copiers.Copiers;
import com.egrid.core.web.response.RestResponse;
import com.exp.ucmp.carDealer.dao.AcquisitionFollowDao;
import com.exp.ucmp.carDealer.dao.InquiryReceivingDao;
import com.exp.ucmp.carDealer.dao.MessagePushDao;
import com.exp.ucmp.carDealer.dto.InquiryStatusCountDto;
import com.exp.ucmp.carDealer.dto.JobHandlerResult;
import com.exp.ucmp.carDealer.dto.RepOrderNeedDto;
import com.exp.ucmp.carDealer.service.MessagePushService;
import com.exp.ucmp.config.TemplateIdConfig;
import com.exp.ucmp.config.UcmpAesConfig;
import com.exp.ucmp.config.dto.SysParamConfigDto;
import com.exp.ucmp.constant.Constants;
import com.exp.ucmp.consumer.ISystemConsumer;
import com.exp.ucmp.dao.*;
import com.exp.ucmp.entity.*;
import com.exp.ucmp.eos.dto.GiveMessageParamDto;
import com.exp.ucmp.eos.dto.MessageParamDto;
import com.exp.ucmp.huawei.dto.SmsParamsDto;
import com.exp.ucmp.pk.PsiCreateOrderAccountInfoPk;
import com.exp.ucmp.pk.PsiCustomerBasicInformationPk;
import com.exp.ucmp.pk.PsiCustomerReservationMsgPk;
import com.exp.ucmp.util.AesUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 询价单，和接单有关的操作
 *
 * @author Administrator
 */
@Service
public class MessagePushServiceImpl implements MessagePushService {
	@Autowired
	private TemplateIdConfig templateIdConfig;
    @Autowired
    private InquiryReceivingDao inquiryReceivingDao;
    @Autowired
    private IPsiMessageInfoDao iPsiMessageInfoDao;
    @Autowired
    private IPsiCreateOrderAccountInfoDao iPsiCreateOrderAccountInfoDao;
    @Autowired
    private ISystemConsumer iSystemConsumer;
    @Autowired
    private MessagePushDao messagePushDao;
    @Autowired
    private IPsiCustomerBasicInformationDao customerBasicInformationDao;
    @Autowired
    private AcquisitionFollowDao acquisitionFollowDao;
    @Autowired
    private IPsiCustomerReservationMsgDao reservationMsgDao;
    @Autowired
    private ISysDatadictDao sysDatadictDao;
    @Autowired
    UcmpAesConfig ucmpAesConfig;

    @Override
    public JobHandlerResult deadlineTimeBeforeTime() {
        JobHandlerResult result = new JobHandlerResult();
        Map<String, List<Long>> mapStaff = new HashMap<>();
        Map<String, Object> params = new HashMap<>();
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MINUTE, 30);
        params.put("detectionDate", cal.getTime());
        params.put("status", new String[]{Constants.trackStatus.toBeTested.value()});
        List<PsiCustomerReservationTrackEntity> listTrack = messagePushDao.selectTrackByDeadlineTime(params);
        if (listTrack.size() > 0) {
            for (PsiCustomerReservationTrackEntity trackEntity : listTrack) {
                Map<String, Integer> mapInquiryStatusCount = new HashMap<>();
                List<InquiryStatusCountDto> countDtos = inquiryReceivingDao.countInquiryByStatus(trackEntity.getReservationId());
                for (InquiryStatusCountDto dto : countDtos) {
                    mapInquiryStatusCount.put(dto.getInquiryStatus(), dto.getInquiryStatusCount());
                }
                messagePush(trackEntity, 3);
                /** 发送短信给新二手车主管 */
                List<String> strings = acquisitionFollowDao.queryUsedCarSupervisor(trackEntity.getStoreId());
                if (strings.size() > 0) {
                    for (String string : strings) {
                        //插入消息记录表
                        PsiMessageInfoEntity psiMessageInfoEntity = new PsiMessageInfoEntity();
                        //预约ID
                        psiMessageInfoEntity.setReservationId(trackEntity.getReservationId());
                        //信息类型
                        psiMessageInfoEntity.setMessageType(Constants.MessageType.Sms.value());
                        //模板id
                        psiMessageInfoEntity.setTemplateId(Constants.sendMessage.sendMessageTwelfth.value());
                        //获取接收人
                        psiMessageInfoEntity.setRecipient(string);
                        //二手车主管手机号解密
                        try {
                            string = AesUtils.decryptHex(string,ucmpAesConfig.getSecret());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        if (insertMessage(psiMessageInfoEntity)) {
                            //发送短信
                            SmsParamsDto smsParamsDto = new SmsParamsDto();
                            //模板id
                            smsParamsDto.setTemplateId(Constants.sendMessage.sendMessageTwelfth.value());
                            //接收人
                            smsParamsDto.setTo(string);
                            //检测时间和检测地点
                            PsiCustomerReservationMsgPk pk = new PsiCustomerReservationMsgPk();
                            pk.setReservationId(trackEntity.getReservationId());
                            PsiCustomerReservationMsgEntity load = reservationMsgDao.load(pk);
                            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                            String format = formatter.format(load.getReservationDetectionDate());
                            //将时间切片
                            String[] s = format.split(" ");
                            RepOrderNeedDto dto = acquisitionFollowDao.queryReplacementOrderInfo(trackEntity.getReservationId());
                            SysDatadictEntity sysDatadictEntity = new SysDatadictEntity();
                            sysDatadictEntity.setDictCode(dto.getMakeOrderPersonRole());
                            List<SysDatadictEntity> select = sysDatadictDao.selectBySelective(sysDatadictEntity);
                            //手机号解密
                            try {
                                dto.setMakeOrderPersonIphone(AesUtils.decryptHex(dto.getMakeOrderPersonIphone(),ucmpAesConfig.getSecret()));
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            smsParamsDto.setTemplateParas(new String[]{
                                    dto.getBusinessOrderNo(),
                                    dto.getStoreName(),
                                    dto.getMakeOrderPersonName(),
                                    select.get(0).getDictValue(),
                                    dto.getMakeOrderPersonIphone(),
                                    s[0], s[1],
                                    load.getReservationDetectionAddress()});
                            iSystemConsumer.batchSendSms(smsParamsDto);
                        }
                    }
                }
            }
        }
        result.setHandlerCount(listTrack.size());
        return result;
    }

    @Override
    public JobHandlerResult quotingDeadlineBefore() {
        JobHandlerResult result = new JobHandlerResult();
        Map<String, List<Long>> mapStaff = new HashMap<>();
        Map<String, Object> params = new HashMap<>();
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MINUTE, 30);
        params.put("quoteDeadline", cal.getTime());
        params.put("status", new String[]{Constants.trackStatus.testing.value()});
        List<PsiCustomerReservationTrackEntity> listTrack = inquiryReceivingDao.selectTrackByDeadlineTime(params);
        if (listTrack.size() > 0) {
            for (PsiCustomerReservationTrackEntity trackEntity : listTrack) {
                Map<String, Integer> mapInquiryStatusCount = new HashMap<>();
                List<InquiryStatusCountDto> countDtos = inquiryReceivingDao.countInquiryByStatus(trackEntity.getReservationId());
                for (InquiryStatusCountDto dto : countDtos) {
                    mapInquiryStatusCount.put(dto.getInquiryStatus(), dto.getInquiryStatusCount());
                }
                if (!mapInquiryStatusCount.containsKey(Constants.inquiryStatus.alreadyOffer.value())) {
                    messagePush(trackEntity, 4);
                }
            }
        }
        result.setHandlerCount(listTrack.size());
        return result;
    }

    @Override
    public JobHandlerResult customerAgreeTimeLater() {
        JobHandlerResult result = new JobHandlerResult();
        Map<String, List<Long>> mapStaff = new HashMap<>();
        Map<String, Object> params = new HashMap<>();

        RestResponse<SysParamConfigDto> byType = iSystemConsumer.findByType(Constants.SysParamConfigType.FIRST_REMINDER_TIME.value());
        SysParamConfigDto typeResult = byType.getResult();

        params.put("generateAcquisitionsTime", getSysTime(typeResult));
        params.put("status", new String[]{Constants.inquiryStatus.unAcquired.value()});

        List<PsiCustomerReservationTrackEntity> listTrack = messagePushDao.selectTrackBySysTime(params);
        if (listTrack.size() > 0) {
            for (PsiCustomerReservationTrackEntity trackEntity : listTrack) {
                messagePush(trackEntity, 5);
            }
        }
        result.setHandlerCount(listTrack.size());
        return result;
    }

    @Override
    public JobHandlerResult firstEscalationTimeLater() {
        JobHandlerResult result = new JobHandlerResult();
        Map<String, List<Long>> mapStaff = new HashMap<>();
        Map<String, Object> params = new HashMap<>();
        RestResponse<SysParamConfigDto> byType = iSystemConsumer.findByType(Constants.SysParamConfigType.FIRST_REMINDER_TIME.value());
        SysParamConfigDto typeResult = byType.getResult();
        params.put("firstEscalationTime", getSysTime(typeResult));
        params.put("status", new String[]{Constants.inquiryStatus.unTransfer.value()});
        List<PsiCustomerReservationTrackEntity> listTrack = messagePushDao.selectTrackBySysTime(params);
        if (listTrack.size() > 0) {
            for (PsiCustomerReservationTrackEntity trackEntity : listTrack) {
                messagePush(trackEntity, 7);
            }
        }
        result.setHandlerCount(listTrack.size());
        return result;
    }


    //获取系统定义时间差
    private Date getSysTime(SysParamConfigDto typeResult) {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        //单位
        String unit = typeResult.getParamUnit();
        //时间差值
        int values = Integer.parseInt(typeResult.getParamValues());
        if (unit.equals("HOUR") ) {
            cal.add(Calendar.HOUR, -values);
        }
        if (unit.equals("MIN") ){
            cal.add(Calendar.MINUTE, -values);
        }
        if (unit.equals("DAYS") ) {
            cal.add(Calendar.HOUR, -(values * 24) );
        }
        if (unit.equals("SECOND") ) {
            cal.add(Calendar.SECOND, -values);
        }
        return cal.getTime();
    }

    //消息推送逻辑
    private void messagePush(PsiCustomerReservationTrackEntity trackEntity, int index) {
        PsiMessageInfoEntity psiMessageInfoEntity = new PsiMessageInfoEntity();
        //预约ID
        psiMessageInfoEntity.setReservationId(trackEntity.getReservationId());
        //信息类型
        psiMessageInfoEntity.setMessageType(Constants.MessageType.message.value());
        //模板ID
        if (index == 3) {
            psiMessageInfoEntity.setTemplateId(templateIdConfig.getTemplateTitleThird());
        } else if (index == 4) {
            psiMessageInfoEntity.setTemplateId(templateIdConfig.getTemplateTitleFourth());
        } else if (index == 5) {
            psiMessageInfoEntity.setTemplateId(templateIdConfig.getTemplateTitleFifth());
        } else if (index == 7) {
            psiMessageInfoEntity.setTemplateId(templateIdConfig.getTemplateTitleSeventh());
        }
        //获取接收人
        PsiCreateOrderAccountInfoPk infoPk = new PsiCreateOrderAccountInfoPk();
        infoPk.setInfoId(trackEntity.getInfoId());
        PsiCreateOrderAccountInfoEntity load = iPsiCreateOrderAccountInfoDao.load(infoPk);
        psiMessageInfoEntity.setRecipient(String.valueOf(load.getUserId()));
        if (insertMessage(psiMessageInfoEntity)) {
            MessageParamDto messageParamDto = new MessageParamDto();
            //模板id
           if (index == 3) {
                messageParamDto.setTemplateId(templateIdConfig.getTemplateTitleThird());
            } else if (index == 4) {
                messageParamDto.setTemplateId(templateIdConfig.getTemplateTitleFourth());
            } else if (index == 5) {
                messageParamDto.setTemplateId(templateIdConfig.getTemplateTitleFifth());
            } else if (index == 7) {
                messageParamDto.setTemplateId(templateIdConfig.getTemplateTitleSeventh());
            }
            messageParamDto.setOriginalChannel("UCMP");
            messageParamDto.setSenderType(0);
            messageParamDto.setReceiverType(0);
            List<String> strings = new ArrayList<>();
            //获取预约编号
            strings.add(trackEntity.getBusinessOrderNo());
            //获取uid

            strings.add(selectUid(trackEntity));
            messageParamDto.setParams(strings);

            messageParamDto.setReceiverId(Arrays.asList(new String[]{String.valueOf(load.getUserId())}));
            GiveMessageParamDto giveMessageParamDto = Copiers.beanToBean(messageParamDto, MessageParamDto.class,GiveMessageParamDto.class);
            giveMessageParamDto.setReceiverId(load.getUserId().toString());
            iSystemConsumer.giveMessage(giveMessageParamDto);
        }
    }


    public String selectUid(PsiCustomerReservationTrackEntity entity) {
        PsiCustomerBasicInformationPk informationPk = new PsiCustomerBasicInformationPk();
        informationPk.setCustomerId(entity.getCustomerId());
        PsiCustomerBasicInformationEntity load = customerBasicInformationDao.load(informationPk);
        return load.getUid();
    }


    @Transactional(rollbackFor = Exception.class)
    public Boolean insertMessage(PsiMessageInfoEntity entity) {
        //根据模板id、预约id、接收人进行判断是否插入
        List<PsiMessageInfoEntity> entities = iPsiMessageInfoDao.selectBySelective(entity);
        if (entities.size() == 0) {
            entity.generatePk();
            entity.setReceptionTime(new Date());
            iPsiMessageInfoDao.insert(entity);
            return true;
        } else {
            return false;
        }
    }
}
