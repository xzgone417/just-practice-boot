package com.exp.ucmp.carDealer.service.impl;

import com.egrid.core.util.JsonBeanUtil;
import com.exp.ucmp.carDealer.dao.AcquisitionFollowDao;
import com.exp.ucmp.carDealer.dao.InquiryReceivingDao;
import com.exp.ucmp.carDealer.dao.ScheduledTasksDao;
import com.exp.ucmp.carDealer.dto.*;
import com.exp.ucmp.carDealer.service.MessagePushService;
import com.exp.ucmp.carDealer.service.ScheduledTasksService;
import com.exp.ucmp.config.UcmpAesConfig;
import com.exp.ucmp.constant.Constants;
import com.exp.ucmp.consumer.ISystemConsumer;
import com.exp.ucmp.dao.IPsiCustomerReservationMsgDao;
import com.exp.ucmp.dao.ISysDatadictDao;
import com.exp.ucmp.dao.ISysPartnerStaffInfoDao;
import com.exp.ucmp.dao.ISysPartnerStaffStoreRelaDao;
import com.exp.ucmp.entity.*;
import com.exp.ucmp.huawei.dto.SmsParamsDto;
import com.exp.ucmp.pk.PsiCustomerReservationMsgPk;
import com.exp.ucmp.pk.SysPartnerStaffInfoPk;
import com.exp.ucmp.util.AesUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 询价单，和接单有关的操作
 *
 * @author Administrator
 */
@Service
public class ScheduledTasksServiceImpl implements ScheduledTasksService {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasksServiceImpl.class);

    @Autowired
    private ISystemConsumer systemConsumer;
    @Autowired
    private ISysPartnerStaffInfoDao sysPartnerStaffInfoDao;
    @Autowired
    private InquiryReceivingDao inquiryReceivingDao;
    @Autowired
    private ScheduledTasksDao scheduledTasksDao;
    @Autowired
    private ISysPartnerStaffStoreRelaDao sysPartnerStaffStoreRelaDao;
    @Autowired
    private MessagePushService messagePushService;
    @Autowired
    private AcquisitionFollowDao acquisitionFollowDao;
    @Autowired
    private ISysDatadictDao sysDatadictDao;
    @Autowired
    private IPsiCustomerReservationMsgDao reservationMsgDao;
    @Autowired
    UcmpAesConfig ucmpAesConfig;

    public JobHandlerResult receivingDeadlineSms() {
        JobHandlerResult result = new JobHandlerResult();
        Map<String, Object> params = new HashMap<>();
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR, 1);
        params.put("receivingDeadline", cal.getTime());
        params.put("status", new String[]{Constants.inquiryStatus.unOrderReceiving.value()});
        /**
         * 查询距离当前接单时间差有一小时，查询未接单的询价
         */
        List<PsiCarDealerInquiryEntity> inquiryEntities = scheduledTasksDao.selectByReservationId(params);
        //获取指定车商的人员手机号
        if (inquiryEntities.size() > 0) {
            for (PsiCarDealerInquiryEntity inquiryEntity : inquiryEntities) {
                SysPartnerStaffStoreRelaEntity relaEntity = new SysPartnerStaffStoreRelaEntity();
                relaEntity.setPartnerId(inquiryEntity.getCarDealerId());
                relaEntity.setStoreId(inquiryEntity.getStoreId());
                relaEntity.setIsEnable("01");//可用的车商门店人员关系
                List<SysPartnerStaffStoreRelaEntity> relaEntities = sysPartnerStaffStoreRelaDao.selectBySelective(relaEntity);
                for (SysPartnerStaffStoreRelaEntity entity : relaEntities) {
                    SysPartnerStaffInfoPk sysPartnerStaffInfoPk = new SysPartnerStaffInfoPk();
                    sysPartnerStaffInfoPk.setPartyId(entity.getPartyId());
                    SysPartnerStaffInfoEntity load = sysPartnerStaffInfoDao.load(sysPartnerStaffInfoPk);
                    //该车商人员是否被删除
                    if (load!=null&&load.getIsDelete()!="01"){
                        //插入消息记录表
                        PsiMessageInfoEntity psiMessageInfoEntity = new PsiMessageInfoEntity();
                        //预约ID
                        psiMessageInfoEntity.setReservationId(inquiryEntity.getReservationId());
                        //信息类型
                        psiMessageInfoEntity.setMessageType(Constants.MessageType.Sms.value());
                        //模板id
                        psiMessageInfoEntity.setTemplateId(Constants.sendMessage.sendMessageFourth.value());
                        //手机号解密
                        String partnerStaffIphone = load.getPartnerStaffIphone();
                        //获取接收人
                        psiMessageInfoEntity.setRecipient(partnerStaffIphone);
                        try {
                            partnerStaffIphone = AesUtils.decryptHex(partnerStaffIphone,ucmpAesConfig.getSecret());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if (messagePushService.insertMessage(psiMessageInfoEntity)) {
                            //发送短信
                            SmsParamsDto smsParamsDto = new SmsParamsDto();
                            //模板id
                            smsParamsDto.setTemplateId(Constants.sendMessage.sendMessageFourth.value());
                            //接收人
                            smsParamsDto.setTo(partnerStaffIphone);
                            //预约编号
                            smsParamsDto.setTemplateParas(new String[]{inquiryEntity.getBusinessOrderNo()});
                            systemConsumer.batchSendSms(smsParamsDto);
                        }
                    }
                }
            }
        }
        result.setHandlerCount(inquiryEntities.size());
        return result;
    }

    /**
     * 【高合汽车】尊敬的高合合作商，您的估价邀约编号***1小时后即将发起检测，
     * 请准备出发前往检测地址：***；回TD退订
     * <p>
     * 【高合汽车】尊敬的高合用户，您的估价预约即将到达检测时间，请准备前往检测地点：**；
     * 检测时间：**。回TD退订
     *
     * @return
     */
    @Override
    public JobHandlerResult detectionDate() {
        JobHandlerResult result = new JobHandlerResult();
        Map<String, Object> params = new HashMap<>();
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR, 1);
        params.put("detectionDate", cal.getTime());
        params.put("status", new String[]{Constants.trackStatus.toBeTested.value(), Constants.trackStatus.testing.value()});
        List<DetectionCustomerDto> customerDtos = scheduledTasksDao.selectMsgByDetectionDate(params);
        if (customerDtos.size() > 0) {
            for (DetectionCustomerDto customerDto : customerDtos) {
                //插入消息记录表
                PsiMessageInfoEntity psiMessageInfoEntity = new PsiMessageInfoEntity();
                //预约ID
                psiMessageInfoEntity.setReservationId(customerDto.getReservationId());
                //信息类型
                psiMessageInfoEntity.setMessageType(Constants.MessageType.Sms.value());
                //模板id
                psiMessageInfoEntity.setTemplateId(Constants.sendMessage.sendMessageFirst.value());
                //获取接收人
                String customerIphone = customerDto.getCustomerIphone();
                //手机号解密
                try {
                    customerIphone = AesUtils.decryptHex(customerIphone,ucmpAesConfig.getSecret());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                psiMessageInfoEntity.setRecipient(customerIphone);
                if (messagePushService.insertMessage(psiMessageInfoEntity)) {
                    //发送短信
                    SmsParamsDto smsParamsDto = new SmsParamsDto();
                    //模板id
                    smsParamsDto.setTemplateId(Constants.sendMessage.sendMessageFirst.value());
                    //接收人
                    smsParamsDto.setTo(customerIphone);
                    //参数
                    List<String> list = new ArrayList<String>();
                    list.add(customerDto.getReservationDetectionAddress());
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                    String format = formatter.format(customerDto.getReservationDetectionDate());
                    //将时间切片
                    String[] s = format.split(" ");
                    //参数
                    smsParamsDto.setTemplateParas(new String[]{customerDto.getReservationDetectionAddress(), s[0], s[1]});
                    systemConsumer.batchSendSms(smsParamsDto);
                }

                Map<String, Object> param = new HashMap<>();
                param.put("reservationId", customerDto.getReservationId());
                param.put("status", new String[]{Constants.inquiryStatus.orderReceiving.value(), Constants.inquiryStatus.unOffer.value()});
                List<PsiCarDealerInquiryEntity> inquiryEntities = scheduledTasksDao.selectByReservationId(param);
                for (PsiCarDealerInquiryEntity inquiryEntity : inquiryEntities) {
                    //插入消息记录表
                    PsiMessageInfoEntity infoEntity = new PsiMessageInfoEntity();
                    //预约ID
                    infoEntity.setReservationId(customerDto.getReservationId());
                    //信息类型
                    infoEntity.setMessageType(Constants.MessageType.Sms.value());
                    //模板id
                    infoEntity.setTemplateId(Constants.sendMessage.sendMessageFifth.value());
                    //获取接收人
                    SysPartnerStaffInfoPk sysPartnerStaffInfoPk = new SysPartnerStaffInfoPk();
                    sysPartnerStaffInfoPk.setPartyId(inquiryEntity.getCarDealerStaffId());
                    SysPartnerStaffInfoEntity load = sysPartnerStaffInfoDao.load(sysPartnerStaffInfoPk);
                    String partnerStaffIphone = load.getPartnerStaffIphone();
                    infoEntity.setRecipient(partnerStaffIphone);
                    try {
                        partnerStaffIphone = AesUtils.decryptHex(partnerStaffIphone,ucmpAesConfig.getSecret());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (messagePushService.insertMessage(infoEntity)) {
                        //发送短信
                        SmsParamsDto smsParamsDto = new SmsParamsDto();
                        //模板id
                        smsParamsDto.setTemplateId(Constants.sendMessage.sendMessageFifth.value());
                        //接收人
                        smsParamsDto.setTo(partnerStaffIphone);
                        //预约编号
                        smsParamsDto.setTemplateParas(new String[]{inquiryEntity.getBusinessOrderNo()+"，", customerDto.getReservationDetectionAddress()});
                        systemConsumer.batchSendSms(smsParamsDto);
                    }

                }
            }
        }
        result.setHandlerCount(customerDtos.size());
        return result;
    }

    /**
     * 【高合汽车】尊敬的高合合作商，您有条已收购的记录编号***还未上传过户材料，
     * 1小时后将超预计过户时间，请及时联系客户办理过户；回TD退订
     *
     * @return
     */
    @Override
    public JobHandlerResult estimatedTransferTime() {
        JobHandlerResult result = new JobHandlerResult();
        Map<String, Object> params = new HashMap<>();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String format = formatter.format(new Date());
        params.put("estimatedTransferTime", format);
        params.put("status", new String[]{Constants.inquiryStatus.unTransfer.value()});
        List<PsiCarDealerInquiryEntity> inquiryEntities = scheduledTasksDao.selectByReservationId(params);
        for (PsiCarDealerInquiryEntity inquiryEntity : inquiryEntities) {
            //插入消息记录表
            PsiMessageInfoEntity infoEntity = new PsiMessageInfoEntity();
            //预约ID
            infoEntity.setReservationId(inquiryEntity.getReservationId());
            //信息类型
            infoEntity.setMessageType(Constants.MessageType.Sms.value());
            //模板id
            infoEntity.setTemplateId(Constants.sendMessage.sendMessageEighth.value());
            //获取接收人
            SysPartnerStaffInfoPk sysPartnerStaffInfoPk = new SysPartnerStaffInfoPk();
            sysPartnerStaffInfoPk.setPartyId(inquiryEntity.getCarDealerStaffId());
            SysPartnerStaffInfoEntity load = sysPartnerStaffInfoDao.load(sysPartnerStaffInfoPk);
            String partnerStaffIphone = load.getPartnerStaffIphone();
            infoEntity.setRecipient(partnerStaffIphone);
            try {
                partnerStaffIphone = AesUtils.decryptHex(partnerStaffIphone,ucmpAesConfig.getSecret());
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (messagePushService.insertMessage(infoEntity)) {
                //发送短信
                SmsParamsDto smsParamsDto = new SmsParamsDto();
                //模板id
                smsParamsDto.setTemplateId(Constants.sendMessage.sendMessageEighth.value());
                //接收人
                smsParamsDto.setTo(partnerStaffIphone);
                //预约编号
                smsParamsDto.setTemplateParas(new String[]{inquiryEntity.getBusinessOrderNo()});
                systemConsumer.batchSendSms(smsParamsDto);
            }
        }
        log.info(JsonBeanUtil.beanToJson(inquiryEntities.size()));
        result.setHandlerCount(inquiryEntities.size());
        return result;
    }


    /**
     * 待接单截止半小时无车商接单提醒发送给二手车主管
     */
    public JobHandlerResult receivingDeadlineBeforeSms() {
        JobHandlerResult result = new JobHandlerResult();
        Map<String, List<Long>> mapStaff = new HashMap<>();
        Map<String, Object> params = new HashMap<>();
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MINUTE, 30);
        params.put("receivingDeadline", cal.getTime());
        params.put("status", new String[]{Constants.trackStatus.assigned.value()});
        /**
         * 查询距离当前接单时间差有半小时，查询未接单的询价
         */
        List<PsiCustomerReservationTrackEntity> trackEntities = inquiryReceivingDao.selectTrackByDeadlineTime(params);
        //获取指定车商的人员手机号
        if (trackEntities.size() > 0) {
            for (PsiCustomerReservationTrackEntity entity : trackEntities) {
                List<String> strings = acquisitionFollowDao.queryUsedCarSupervisor(entity.getStoreId());
                if (strings.size()>0){
                    for (String string : strings) {
                        //插入消息记录表
                        PsiMessageInfoEntity psiMessageInfoEntity = new PsiMessageInfoEntity();
                        //预约ID
                        psiMessageInfoEntity.setReservationId(entity.getReservationId());
                        //信息类型
                        psiMessageInfoEntity.setMessageType(Constants.MessageType.Sms.value());
                        //模板id
                        psiMessageInfoEntity.setTemplateId(Constants.sendMessage.sendMessageEleventh.value());
                        //获取接收人
                        psiMessageInfoEntity.setRecipient(string);
                        //手机号解密
                        try {
                            string = AesUtils.decryptHex(string,ucmpAesConfig.getSecret());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        if (messagePushService.insertMessage(psiMessageInfoEntity)) {
                            //发送短信
                            SmsParamsDto smsParamsDto = new SmsParamsDto();
                            //模板id
                            smsParamsDto.setTemplateId(Constants.sendMessage.sendMessageEleventh.value());
                            //接收人
                            smsParamsDto.setTo(string);
                            //检测时间和检测地点
                            PsiCustomerReservationMsgPk pk = new PsiCustomerReservationMsgPk();
                            pk.setReservationId(entity.getReservationId());
                            PsiCustomerReservationMsgEntity load = reservationMsgDao.load(pk);
                            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                            String format = formatter.format(load.getReservationDetectionDate());
                            //将时间切片
                            String[] s = format.split(" ");
                            RepOrderNeedDto dto = acquisitionFollowDao.queryReplacementOrderInfo(entity.getReservationId());
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
                            systemConsumer.batchSendSms(smsParamsDto);
                        }
                    }
                }
            }
        }
        result.setHandlerCount(trackEntities.size());
        return result;
    }
}
