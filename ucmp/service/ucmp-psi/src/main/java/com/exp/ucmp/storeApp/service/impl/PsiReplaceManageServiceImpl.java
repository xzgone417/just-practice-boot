package com.exp.ucmp.storeApp.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.alibaba.cloud.commons.lang.StringUtils;
import com.egrid.cache.redisson.cache.RedissonCache;
import com.egrid.core.copiers.Copiers;
import com.egrid.core.shiro.context.AuthContext;
import com.egrid.core.util.JsonBeanUtil;
import com.egrid.core.util.StringUtil;
import com.exp.ucmp.carDealer.dao.AcquisitionFollowDao;
import com.exp.ucmp.carDealer.dto.RepOrderNeedDto;
import com.exp.ucmp.carDealer.service.impl.MessagePushServiceImpl;
import com.exp.ucmp.config.UcmpAesConfig;
import com.exp.ucmp.constant.Constants;
import com.exp.ucmp.dao.*;
import com.exp.ucmp.entity.*;
import com.exp.ucmp.exception.IllegalParameterException;
import com.exp.ucmp.huawei.dto.SmsParamsDto;
import com.exp.ucmp.model.Person;
import com.exp.ucmp.pk.PsiCreateOrderAccountInfoPk;
import com.exp.ucmp.pk.PsiCustomerReservationMsgPk;
import com.exp.ucmp.pk.PsiCustomerReservationTrackPk;
import com.exp.ucmp.storeApp.dao.PsiReplaceManageDao;
import com.exp.ucmp.storeApp.dto.*;
import com.exp.ucmp.storeApp.fegin.SendMessageFegin;
import com.exp.ucmp.storeApp.fegin.SendMessageHistoryFegin;
import com.exp.ucmp.storeApp.fegin.SendSmsFegin;
import com.exp.ucmp.storeApp.properties.UcmpTestProperties;
import com.exp.ucmp.storeApp.service.PsiReplaceManageService;

import com.exp.ucmp.util.AesUtils;
import com.github.xiaoymin.knife4j.core.util.CollectionUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;


/**
 * @author zhouchengwei
 * @date 2022年09月22日
 */
@Service
public class PsiReplaceManageServiceImpl implements PsiReplaceManageService {

    /**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(PsiReplaceManageServiceImpl.class);

    @Autowired
    UcmpTestProperties ucmpTestProperties;
    @Autowired
    PsiReplaceManageDao psiReplaceManageDao;
    @Autowired
    IPsiCustomerBasicInformationDao iPsiCustomerBasicInformationDao;
    @Autowired
    IPsiCustomerReservationTrackDao iPsiCustomerReservationTrackDao;
    @Autowired
    IPsiCustomerCarsDao iPsiCustomerCarsDao;
    @Autowired
    IPsiCustomerReservationMsgDao iPsiCustomerReservationMsgDao;
    @Autowired
    IPsiCarDealerInquiryDao iPsiCarDealerInquiryDao;
    @Autowired
    IPsiInquiryCarsDao iPsiInquiryCarsDao;
    @Autowired
    ISysStoreInfoDao iSysStoreInfoDao;
    @Autowired
    ISysStoreStaffInfoDao iSysStoreStaffInfoDao;
    @Autowired
    ISysStoreStaffDetailsDao iSysStoreStaffDetailsDao;
    
    @Autowired
    IPsiNewCarOrderDao iPsiNewCarOrderDao;
    @Autowired
    IPsiCarAcquisitionDao iPsiCarAcquisitionDao;
    @Autowired
    IRepReplacementApprovalDao repReplacementApprovalDao;
    @Autowired
    SendMessageFegin sendMessageFegin;
    @Autowired
    IPsiCreateOrderAccountInfoDao iPsiCreateOrderAccountInfoDao;

    @Autowired
    SendMessageHistoryFegin sendMessageHistoryFegin;
    @Autowired
    SendSmsFegin sendSmsFegin;
    @Autowired
    ISysPartnerStaffInfoDao iSysPartnerStaffInfoDao;
    @Autowired
    AcquisitionFollowDao acquisitionFollowDao;
    @Autowired
    ISysDatadictDao sysDatadictDao;
    
    @Autowired
    RedissonCache<?> redissonCache;

    @Autowired
    UcmpAesConfig ucmpAesConfig;

    @Autowired
    ISysParamConfigDao configDao;
    
    @Autowired
    IPsiOrderReceivingRecordDao iPsiOrderReceivingRecordDao;
    
    @Autowired
    private MessagePushServiceImpl messagePushService;
    /**
     * Description: 置换线索详情
     *
     * @param replaceCluesDetailsQueryDto 查询条件
     * @return 实体集合
     * @throws Exception 
     */
    @Override
    public List<ReplaceCluesDetailsDto> queryReplaceCluesDetails(ReplaceCluesDetailsQueryDto replaceCluesDetailsQueryDto) throws Exception {
    	try {
	        List<ReplaceCluesDetailsDto> replaceCluesDetailsDtos = psiReplaceManageDao.selectReplaceCluesDetails(replaceCluesDetailsQueryDto);
	        for (ReplaceCluesDetailsDto replaceCluesDetailsDto : replaceCluesDetailsDtos) {
	            //密文手机号
	            replaceCluesDetailsDto.setEnCustomerIphone(replaceCluesDetailsDto.getCustomerIphone());
	            //手机号解密
	                replaceCluesDetailsDto.setCustomerIphone(AesUtils.decryptHex(replaceCluesDetailsDto.getCustomerIphone(),ucmpAesConfig.getSecret()));
	            replaceCluesDetailsDto.setCustomerIphone(dataMask(replaceCluesDetailsDto.getCustomerIphone(), 3, 7, "****"));
	            replaceCluesDetailsDto.setCustomerName(dataMask(replaceCluesDetailsDto.getCustomerName(), 1, replaceCluesDetailsDto.getCustomerName().length(), "***"));
	
	        }
	        return replaceCluesDetailsDtos;
    	} catch (Exception e) {
    		throw new Exception("服务异常，请联系系统管理员");
    	}
    }


    /**
     * Description: 创建预约单
     *
     * @param replaceOrderInsertDto 入参
     * @throws Exception 
     */

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ReplaceOrderInsertReturnDto insertReplaceOrder(ReplaceOrderInsertDto replaceOrderInsertDto) throws Exception {
    	try{
		    //客户车辆表
		    PsiCustomerCarsEntity psiCustomerCarsEntity = new PsiCustomerCarsEntity();
		    //客户信息
		    PsiCustomerBasicInformationEntity psiCustomerBasicInformationEntity = new PsiCustomerBasicInformationEntity();
		    //客户预约跟踪表
		    PsiCustomerReservationTrackEntity psiCustomerReservationTrackEntity = new PsiCustomerReservationTrackEntity();
		    //客户预约信息表
		    PsiCustomerReservationMsgEntity psiCustomerReservationMsgEntity = new PsiCustomerReservationMsgEntity();
		
		
		    //接单截止时间
		  //接单截止时间
	        if(StringUtils.isNotEmpty(replaceOrderInsertDto.getOrderReceivingDeadline())){
	        	Date orderReceivingDeadline = transferStringDate(replaceOrderInsertDto.getOrderReceivingDeadline());
	        	//设置接单截止时间
	            psiCustomerReservationTrackEntity.setOrderReceivingDeadline(orderReceivingDeadline);
	            psiCustomerReservationMsgEntity.setOrderReceivingDeadline(orderReceivingDeadline);
	        }
		    //预约检测时间
		    Date reservationDetectionDate = transferStringDate(replaceOrderInsertDto.getReservationDetectionDate());
		
		    //客户基本信息表插入
		    psiCustomerBasicInformationEntity =
		            Copiers.beanToBean(replaceOrderInsertDto, ReplaceOrderInsertDto.class, PsiCustomerBasicInformationEntity.class);
		    //客户手机号加密存储
		//        psiCustomerBasicInformationEntity.setCustomerIphone(AesUtils.encryptHex(psiCustomerBasicInformationEntity.getCustomerIphone(),ucmpAesConfig.getSecret()));
//		    if(replaceOrderInsertDto.getBrand().equals(ucmpTestProperties.getHipiBrandId())){
//	    		psiCustomerBasicInformationEntity.setCluesType(Constants.cluesType.acquisition.value());//高合车辆 属于收购线索
//	    	}else{
	    		psiCustomerBasicInformationEntity.setCluesType(Constants.cluesType.replace.value());//非高合车辆 属于置换线索
//	    	}
		    
		    psiCustomerBasicInformationEntity.setCluesStatus(Constants.cluesStatus.reserved.value());
		    psiCustomerBasicInformationEntity.setCreationTime(new Date());
		    String orderNo = String.format("%03d", redissonCache.incrBy("orderNo", 1L));
		    String businessOrderNo = new SimpleDateFormat("yyMMdd").format(new Date()).concat(orderNo);
		    psiCustomerBasicInformationEntity.setCluesOrderNo(businessOrderNo);
		    psiCustomerBasicInformationEntity.generatePk();
		    psiCustomerBasicInformationEntity.setCreatedBy(AuthContext.getInstance(Person.class).getCurrentUser().getPartyId());
		    psiCustomerBasicInformationEntity.setUpdatedBy(psiCustomerBasicInformationEntity.getCreatedBy());
		    iPsiCustomerBasicInformationDao.insertSelective(psiCustomerBasicInformationEntity);
		
		
		    //客户预约跟踪表插入
		
		    psiCustomerReservationTrackEntity =
		            Copiers.beanToBean(replaceOrderInsertDto, ReplaceOrderInsertDto.class, PsiCustomerReservationTrackEntity.class);
		    //制单人手机号加密存储
		//        psiCustomerReservationTrackEntity.setMakeOrderPersonIphone(AesUtils.encryptHex(psiCustomerReservationTrackEntity.getMakeOrderPersonIphone(),ucmpAesConfig.getSecret()));
		    psiCustomerReservationTrackEntity.setCustomerId(psiCustomerBasicInformationEntity.getCustomerId());
		    
		    
//		    if(replaceOrderInsertDto.getBrand().equals(ucmpTestProperties.getHipiBrandId())){
//	        	psiCustomerReservationTrackEntity.setBusinessType(Constants.businessType.oneselfBrand.value());//本品
//	        }else{
	        	psiCustomerReservationTrackEntity.setBusinessType(Constants.businessType.otherBrand.value());//他品
//	        }
		    
		    psiCustomerReservationTrackEntity.setBusinessOrderNo(psiCustomerBasicInformationEntity.getCluesOrderNo());
		    psiCustomerReservationTrackEntity.setTrackStatus(Constants.trackStatus.toBeAllocated.value());
		    psiCustomerReservationTrackEntity.generatePk();
		    if (
		            Constants.slfRole.MO.value().equals(replaceOrderInsertDto.getRole()) ||
		            Constants.slfRole.PMO.value().equals(replaceOrderInsertDto.getRole()) ||
		            Constants.slfRole.ME.value().equals(replaceOrderInsertDto.getRole()) ||
		            Constants.smpRole.MO.value().equals(replaceOrderInsertDto.getRole())
		    ) {
		        SysStoreStaffInfoEntity sysStoreStaffInfoEntity = new SysStoreStaffInfoEntity();
		        sysStoreStaffInfoEntity.setIdmAccountName(replaceOrderInsertDto.getIdmAccountName());
		        sysStoreStaffInfoEntity.setRoleCode(replaceOrderInsertDto.getRole());
		        List<SysStoreStaffInfoEntity> sysStoreStaffInfoEntities = iSysStoreStaffInfoDao.selectBySelective(sysStoreStaffInfoEntity);
		        psiCustomerReservationTrackEntity.setManagerId(sysStoreStaffInfoEntities.get(0).getPartyId());
		        psiCustomerReservationTrackEntity.setMakeOrderPersonRole(replaceOrderInsertDto.getRole());
		        LOGGER.info(JsonBeanUtil.beanToJson(sysStoreStaffInfoEntities.get(0)));
		    }
		    if (Constants.slfRole.MC.value().equals(replaceOrderInsertDto.getRole())) {
		        SysStoreStaffInfoEntity sysStoreStaffInfoEntity = new SysStoreStaffInfoEntity();
		        sysStoreStaffInfoEntity.setIdmAccountName(replaceOrderInsertDto.getIdmAccountName());
		        sysStoreStaffInfoEntity.setRoleCode(replaceOrderInsertDto.getRole());
		        List<SysStoreStaffInfoEntity> sysStoreStaffInfoEntities = iSysStoreStaffInfoDao.selectBySelective(sysStoreStaffInfoEntity);
		        if (sysStoreStaffInfoEntities != null && !sysStoreStaffInfoEntities.isEmpty()) {
		            psiCustomerReservationTrackEntity.setConsultantId(sysStoreStaffInfoEntities.get(0).getPartyId());
		        }
		        psiCustomerReservationTrackEntity.setMakeOrderPersonRole(Constants.slfRole.MC.value());
//		        sysStoreStaffInfoEntity.setIdmAccountName(replaceOrderInsertDto.getIdmAccountUpName());
		        
		        PsiCreateOrderAccountInfoEntity accountInfo = new PsiCreateOrderAccountInfoEntity();
		        accountInfo.setRoleCode(Constants.slfRole.MC.value());
		        accountInfo.setIdmAccountName(replaceOrderInsertDto.getIdmAccountName());
		        LOGGER.info("===accountInfo=="+JsonBeanUtil.beanToJson(accountInfo));
		        PsiCreateOrderAccountInfoEntity load = iPsiCreateOrderAccountInfoDao.load(new PsiCreateOrderAccountInfoPk(replaceOrderInsertDto.getInfoId()));
		        LOGGER.info("===load=="+JsonBeanUtil.beanToJson(load));
//		        sysStoreStaffInfoEntity.setRoleCode(load.getSuperiorRoleCode());
//		        List<SysStoreStaffInfoEntity> sysStoreStaffInfoEntitie = iSysStoreStaffInfoDao.selectBySelective(sysStoreStaffInfoEntity);
		        SysStoreStaffDetailsEntity sysStoreStaffDetailsEntity = new SysStoreStaffDetailsEntity();
		        sysStoreStaffDetailsEntity.setStaffCode(load.getSuperiorUserId().toString());
		        List<SysStoreStaffDetailsEntity> list = iSysStoreStaffDetailsDao.selectBySelective(sysStoreStaffDetailsEntity);
		        if (list != null && !list.isEmpty()) {
		            psiCustomerReservationTrackEntity.setManagerId(list.get(0).getPartyId());
		        }
		    }
		
		    if (Constants.slfRole.SH.value().equals(replaceOrderInsertDto.getRole())||Constants.smpRole.SH.value().equals(replaceOrderInsertDto.getRole())) {
		        SysStoreStaffInfoEntity sysStoreStaffInfoEntity = new SysStoreStaffInfoEntity();
		        sysStoreStaffInfoEntity.setIdmAccountName(replaceOrderInsertDto.getIdmAccountName());
		        sysStoreStaffInfoEntity.setRoleCode(replaceOrderInsertDto.getRole());
		        List<SysStoreStaffInfoEntity> sysStoreStaffInfoEntities = iSysStoreStaffInfoDao.selectBySelective(sysStoreStaffInfoEntity);
		        psiCustomerReservationTrackEntity.setStoreManagerId(sysStoreStaffInfoEntities.get(0).getPartyId());
		        psiCustomerReservationTrackEntity.setMakeOrderPersonRole(replaceOrderInsertDto.getRole());
		
		    }
		    if (replaceOrderInsertDto.getStoreId() != null) {
		        SysStoreInfoEntity sysStoreInfoEntity = new SysStoreInfoEntity();
		        sysStoreInfoEntity.setOrgId(String.valueOf(replaceOrderInsertDto.getStoreId()));
		        List<SysStoreInfoEntity> sysStoreInfoEntities = iSysStoreInfoDao.selectBySelective(sysStoreInfoEntity);
		        psiCustomerReservationTrackEntity.setStoreId(sysStoreInfoEntities.get(0).getStoreId());
		
		    }
		    psiCustomerReservationTrackEntity.setBusinessClassify(Constants.businessLogo.substitution.value());
		    psiCustomerReservationTrackEntity.setInfoId(replaceOrderInsertDto.getInfoId());
		    psiCustomerReservationTrackEntity.setCreatedBy(AuthContext.getInstance(Person.class).getCurrentUser().getPartyId());
		    psiCustomerReservationTrackEntity.setUpdatedBy(psiCustomerReservationTrackEntity.getCreatedBy());
		    iPsiCustomerReservationTrackDao.insertSelective(psiCustomerReservationTrackEntity);
		
		
		    //客户车辆表插入
		    psiCustomerCarsEntity =
		            Copiers.beanToBean(replaceOrderInsertDto, ReplaceOrderInsertDto.class, PsiCustomerCarsEntity.class);
		    psiCustomerCarsEntity.setReservationId(psiCustomerReservationTrackEntity.getReservationId());
		    //设置上牌时间
		    if (StringUtils.isNotBlank(replaceOrderInsertDto.getLicensingDate())){
		        psiCustomerCarsEntity.setLicensingDate(transferStringDate(replaceOrderInsertDto.getLicensingDate()));
		    }
		    psiCustomerCarsEntity.setCustomerId(psiCustomerBasicInformationEntity.getCustomerId());
		    psiCustomerCarsEntity.setReservationId(psiCustomerReservationTrackEntity.getReservationId());
		    psiCustomerCarsEntity.setCreatedBy(AuthContext.getInstance(Person.class).getCurrentUser().getPartyId());
		    psiCustomerCarsEntity.setUpdatedBy(psiCustomerCarsEntity.getCreatedBy());
		    iPsiCustomerCarsDao.insertSelective(psiCustomerCarsEntity);
		
		    //客户预约信息表插入
		
		    psiCustomerReservationMsgEntity =
		            Copiers.beanToBean(replaceOrderInsertDto, ReplaceOrderInsertDto.class, PsiCustomerReservationMsgEntity.class);
		    
		    //设置预约检测时间
		    psiCustomerReservationMsgEntity.setReservationDetectionDate(reservationDetectionDate);
		    psiCustomerReservationMsgEntity.setReservationId(psiCustomerReservationTrackEntity.getReservationId());
		    psiCustomerReservationMsgEntity.setCreatedBy(AuthContext.getInstance(Person.class).getCurrentUser().getPartyId());
		    psiCustomerReservationMsgEntity.setUpdatedBy(psiCustomerReservationMsgEntity.getCreatedBy());
		    iPsiCustomerReservationMsgDao.insertSelective(psiCustomerReservationMsgEntity);
		
		    ReplaceOrderInsertReturnDto replaceOrderInsertReturnDto = new ReplaceOrderInsertReturnDto();
		    replaceOrderInsertReturnDto.setReservationId(psiCustomerReservationTrackEntity.getReservationId());
		    replaceOrderInsertReturnDto.setBusinessOrderNo(psiCustomerReservationTrackEntity.getBusinessOrderNo());
		    replaceOrderInsertReturnDto.setStoreId(psiCustomerReservationTrackEntity.getStoreId());
		
		
		    /*if (Constants.slfRole.MC.value().equals(replaceOrderInsertDto.getRole())) {
		        //预约单创建 mc发送短信 提醒mo
		        MessageParamDto messageParamDto = new MessageParamDto();
		        messageParamDto.setOriginalChannel("UCMP");
		        messageParamDto.setReceiverType(0);
		        messageParamDto.setSenderType(0);
		        messageParamDto.setTemplateId(templateIdConfig.getTemplateTitleFirst());
		        List<String> params = new ArrayList<>();
		        params.add(replaceOrderInsertDto.getMakeOrderPersonName());
		        params.add(replaceOrderInsertDto.getUid());
		        messageParamDto.setParams(params);
		        PsiCreateOrderAccountInfoEntity psiCreateOrderAccountInfoEntity = new PsiCreateOrderAccountInfoEntity();
		        psiCreateOrderAccountInfoEntity.setInfoId(replaceOrderInsertDto.getInfoId());
		        List<PsiCreateOrderAccountInfoEntity> psiCreateOrderAccountInfoEntities = iPsiCreateOrderAccountInfoDao.selectBySelective(psiCreateOrderAccountInfoEntity);
		        List<String> receiver = new ArrayList<>();
		        //信息发送记录
		        PsiMessageInfoEntity psiMessageInfoEntity = new PsiMessageInfoEntity();
		        psiMessageInfoEntity.setTemplateId(templateIdConfig.getTemplateTitleFirst());
		        psiMessageInfoEntity.setReservationId(psiCustomerReservationTrackEntity.getReservationId());
		        psiMessageInfoEntity.setMessageType(Constants.MessageType.message.value());
		
		        if (!StringUtil.isEmpty(psiCreateOrderAccountInfoEntities.get(0).getSuperiorUserId())) {
		            //mc创建预约单后会消息推送给mo
		            receiver.add(String.valueOf(psiCreateOrderAccountInfoEntities.get(0).getSuperiorUserId()));
		            messageParamDto.setReceiverId(receiver);
		            GiveMessageParamDto giveMessageParamDto = Copiers.beanToBean(messageParamDto, MessageParamDto.class,GiveMessageParamDto.class);
		            giveMessageParamDto.setReceiverId(receiver.get(0));
		            sendMessageFegin.giveMessage(giveMessageParamDto);
		
		            psiMessageInfoEntity.setRecipient(String.valueOf(psiCreateOrderAccountInfoEntities.get(0).getSuperiorUserId()));
		            sendMessageHistoryFegin.updateInquiryApprovalStatus(psiMessageInfoEntity);
		        } else {
		            //若无mo，则推送给店长
		            //获取当前登陆账号的门店id
		            SysStoreInfoEntity sysStoreInfoEntity = new SysStoreInfoEntity();
		            sysStoreInfoEntity.setOrgId(String.valueOf(replaceOrderInsertDto.getStoreId()));
		            List<SysStoreInfoEntity> sysStoreInfoEntities = iSysStoreInfoDao.selectBySelective(sysStoreInfoEntity);
		            //查找店长的userId
		            SysStoreStaffInfoEntity entity = new SysStoreStaffInfoEntity();
		            entity.setStoreId(sysStoreInfoEntities.get(0).getStoreId());
		            entity.setRoleCode(Constants.slfRole.SH.value());
		            List<SysStoreStaffInfoEntity> sysStoreStaffInfoEntities = iSysStoreStaffInfoDao.selectBySelective(entity);
		            if (!StringUtil.isEmpty(sysStoreStaffInfoEntities.get(0).getUserId())) {
		                receiver.add(String.valueOf(sysStoreStaffInfoEntities.get(0).getUserId()));
		                messageParamDto.setReceiverId(receiver);
		                GiveMessageParamDto giveMessageParamDto = Copiers.beanToBean(messageParamDto, MessageParamDto.class,GiveMessageParamDto.class);
		                giveMessageParamDto.setReceiverId(receiver.get(0));
		                sendMessageFegin.giveMessage(giveMessageParamDto);
		
		                psiMessageInfoEntity.setRecipient(String.valueOf(sysStoreStaffInfoEntities.get(0).getUserId()));
		                sendMessageHistoryFegin.updateInquiryApprovalStatus(psiMessageInfoEntity);
		            }
		        }
		    }*/
		    return replaceOrderInsertReturnDto;
    	}catch (Exception e) {
    		LOGGER.error("==服务异常===",e);
            throw new Exception("服务异常，请联系系统管理员");
		}
    }


    /**
     * Description: 分配车商
     *
     * @param divisionCarDealerDto 入参
     * @throws Exception 
     */

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void divisionCarDealer(DivisionCarDealerDto divisionCarDealerDto) throws Exception {
    	try {
	    	Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
	        LOGGER.info(divisionCarDealerDto.getBusinessOrderNo() + "--------------------------------------");
	        //通过预约id获取车商询价表信息
	        PsiCustomerReservationTrackEntity psiCustomerReservationTrack = new PsiCustomerReservationTrackEntity();
	        psiCustomerReservationTrack.setReservationId(divisionCarDealerDto.getReservationId());
	        List<PsiCustomerReservationTrackEntity> psiCustomerReservationTrackEntities = iPsiCustomerReservationTrackDao.selectBySelective(psiCustomerReservationTrack);
	        PsiCustomerReservationTrackEntity psiCustomerReservationTrackEntity = psiCustomerReservationTrackEntities.get(0);
	
	
	        //通过预约id获取询价车辆信息
	        PsiCustomerCarsEntity psiCustomerCarsEntity = new PsiCustomerCarsEntity();
	        psiCustomerCarsEntity.setReservationId(divisionCarDealerDto.getReservationId());
	        List<PsiCustomerCarsEntity> psiCustomerCarsEntities = iPsiCustomerCarsDao.selectBySelective(psiCustomerCarsEntity);
	        PsiCustomerCarsEntity psiCustomerCars = psiCustomerCarsEntities.get(0);
	        if (Constants.trackStatus.toBeAllocated.value().equals(psiCustomerReservationTrackEntity.getTrackStatus())) {
	            for (int i = 0; i < divisionCarDealerDto.getCarDealerId().size(); i++) {
	                //车商询价表
	                PsiCarDealerInquiryEntity psiCarDealerInquiryEntity = new PsiCarDealerInquiryEntity();
	                //车商询价表插入
	                psiCarDealerInquiryEntity =
	                        Copiers.beanToBean(psiCustomerReservationTrackEntity, PsiCustomerReservationTrackEntity.class, PsiCarDealerInquiryEntity.class);
	                //获取客户id
	                psiCarDealerInquiryEntity.setCustomerId(psiCustomerReservationTrackEntity.getCustomerId());
	                /*if (psiCustomerReservationTrackEntity.getConsultantId() != null && psiCustomerReservationTrackEntity.getManagerId() != null) {
	                    psiCarDealerInquiryEntity.setMakeOrderPersonId(psiCustomerReservationTrackEntity.getConsultantId());
	                }
	                if (psiCustomerReservationTrackEntity.getConsultantId() == null && psiCustomerReservationTrackEntity.getManagerId() != null) {
	                    psiCarDealerInquiryEntity.setMakeOrderPersonId(psiCustomerReservationTrackEntity.getManagerId());
	                }
	                if ((psiCustomerReservationTrackEntity.getConsultantId() == null
	                        && psiCustomerReservationTrackEntity.getManagerId() == null)
	                        && psiCustomerReservationTrackEntity.getStoreManagerId() != null) {
	                    psiCarDealerInquiryEntity.setMakeOrderPersonId(psiCustomerReservationTrackEntity.getStoreManagerId());
	                }*/
	                SysStoreStaffInfoEntity sysStoreStaffInfoEntity = new SysStoreStaffInfoEntity();
	                sysStoreStaffInfoEntity.setPartyId(user.getPartyId());
	                sysStoreStaffInfoEntity.setStoreId(divisionCarDealerDto.getStoreId());
	                List<SysStoreStaffInfoEntity> staffInfoList = this.iSysStoreStaffInfoDao.selectBySelective(sysStoreStaffInfoEntity);
	                psiCarDealerInquiryEntity.setMakeOrderPersonId(staffInfoList.get(0).getPartyId());
	                psiCarDealerInquiryEntity.setMakeOrderPersonIphone(staffInfoList.get(0).getPhoneNumber());
	                psiCarDealerInquiryEntity.setMakeOrderPersonName(staffInfoList.get(0).getUserName());
	                psiCarDealerInquiryEntity.setMakeOrderPersonRole(staffInfoList.get(0).getRoleCode());
	
	                //获取客户名称和客户手机
	                PsiCustomerBasicInformationEntity psiCustomerBasicInformationEntity = new PsiCustomerBasicInformationEntity();
	                psiCustomerBasicInformationEntity.setCustomerId(psiCustomerReservationTrackEntity.getCustomerId());
	                List<PsiCustomerBasicInformationEntity> psiCustomerBasicInformationEntities = iPsiCustomerBasicInformationDao.selectBySelective(psiCustomerBasicInformationEntity);
	                psiCarDealerInquiryEntity.setCustomerIphone(psiCustomerBasicInformationEntities.get(0).getCustomerIphone());
	                psiCarDealerInquiryEntity.setCustomerName(psiCustomerBasicInformationEntities.get(0).getCustomerName());
	
	                psiCarDealerInquiryEntity.setCreatedDate(new Date());
	                psiCarDealerInquiryEntity.setUpdatedDate(new Date());
	                psiCarDealerInquiryEntity.setIssuedCarDealerDate(new Date());
	                psiCarDealerInquiryEntity.setCarDealerId(divisionCarDealerDto.getCarDealerId().get(i));
	                psiCarDealerInquiryEntity.setOrderReceivingDeadline(divisionCarDealerDto.getOrderReceivingDeadline());
	                psiCarDealerInquiryEntity.setInquiryStatus(Constants.inquiryStatus.unOrderReceiving.value());
	                psiCarDealerInquiryEntity.generatePk();
	                psiCarDealerInquiryEntity.setCreatedBy(AuthContext.getInstance(Person.class).getCurrentUser().getPartyId());
	                psiCarDealerInquiryEntity.setUpdatedBy(psiCarDealerInquiryEntity.getCreatedBy());
	                psiCarDealerInquiryEntity.setBusinessOrderNo(divisionCarDealerDto.getBusinessOrderNo());
	
	                iPsiCarDealerInquiryDao.insertSelective(psiCarDealerInquiryEntity);
	
	                //询价车辆表插入
	                PsiInquiryCarsEntity psiInquiryCarsEntity = new PsiInquiryCarsEntity();
	                psiInquiryCarsEntity =
	                        Copiers.beanToBean(psiCustomerCars, PsiCustomerCarsEntity.class, PsiInquiryCarsEntity.class);
	                if (StringUtils.isNotBlank(psiCustomerCars.getDrivingMileage())){
	                    psiInquiryCarsEntity.setDrivingMileage(Long.valueOf(psiCustomerCars.getDrivingMileage()));
	                }
	                psiInquiryCarsEntity.setInquiryId(psiCarDealerInquiryEntity.getInquiryId());
	                psiInquiryCarsEntity.setCreatedBy(AuthContext.getInstance(Person.class).getCurrentUser().getPartyId());
	                psiInquiryCarsEntity.setUpdatedBy(psiInquiryCarsEntity.getCreatedBy());
	                iPsiInquiryCarsDao.insertSelective(psiInquiryCarsEntity);
	            }
	
	            //客户预约跟踪表更改状态为已分配
	            PsiCustomerReservationTrackEntity psiCustomerReservationTracks = new PsiCustomerReservationTrackEntity();
	            psiCustomerReservationTrack.setReservationId(divisionCarDealerDto.getReservationId());
	            psiCustomerReservationTrack.setTrackStatus(Constants.trackStatus.assigned.value());
	            //修改截止接单时间
	            psiCustomerReservationTrack.setOrderReceivingDeadline(divisionCarDealerDto.getOrderReceivingDeadline());
	            psiCustomerReservationTrack.setUpdatedDate(new Date());
	            psiCustomerReservationTrack.setUpdatedBy(AuthContext.getInstance(Person.class).getCurrentUser().getPartyId());
	            int row = psiReplaceManageDao.updateSelective(psiCustomerReservationTrack);
	            if(row==0){
	                throw new IllegalParameterException("已分配车商，不能重复分配");
	            }
	
	            //客户预约信息表修改预约检测时间
	            PsiCustomerReservationMsgEntity psiCustomerReservationMsgEntity = new PsiCustomerReservationMsgEntity();
	            psiCustomerReservationMsgEntity.setReservationId(divisionCarDealerDto.getReservationId());
	            psiCustomerReservationMsgEntity.setOrderReceivingDeadline(divisionCarDealerDto.getOrderReceivingDeadline());
	            psiCustomerReservationMsgEntity.setReservationDetectionDate(divisionCarDealerDto.getReservationDetectionDate());
	            psiCustomerReservationMsgEntity.setUpdatedBy(AuthContext.getInstance(Person.class).getCurrentUser().getPartyId());
	            iPsiCustomerReservationMsgDao.updateSelective(psiCustomerReservationMsgEntity);
	            for (int i = 0; i < divisionCarDealerDto.getCarDealerId().size(); i++) {
	                SmsParamsDto smsParamsDto = new SmsParamsDto();
	                smsParamsDto.setTemplateId(Constants.sendMessage.sendMessageThird.value());
	                HashMap map = new HashMap();
	                map.put("storeId", divisionCarDealerDto.getStoreId());
	                map.put("partnerId", divisionCarDealerDto.getCarDealerId().get(i));
	                List<HashMap> hashMaps = sendMessagePerson(map);
	                for (HashMap hashMap : hashMaps) {
	                    if (StringUtil.isEmpty(hashMap.get("partnerStaffIphone"))) {
	                        throw new IllegalParameterException("该车商下面没有对应的员工");
	                    } else {
	                    	//插入信息表
	                    	PsiMessageInfoEntity messageInfoEntity =new PsiMessageInfoEntity();
	                    	messageInfoEntity.setMessageType(Constants.MessageType.Sms.value());
	                    	messageInfoEntity.setReservationId(divisionCarDealerDto.getReservationId());
	                    	messageInfoEntity.setTemplateId(Constants.sendMessage.sendMessageThird.value());
	                        Object partnerStaffIphone = hashMap.get("partnerStaffIphone");
	                        String value = String.valueOf(partnerStaffIphone);
	                        messageInfoEntity.setRecipient(value);
	                        //解密
	                        try {
	                            value = AesUtils.decryptHex(value,ucmpAesConfig.getSecret());
	                        } catch (Exception e) {
	                            e.printStackTrace();
	                        }
	                        smsParamsDto.setTo(value);
	                        sendSmsFegin.batchSendSms(smsParamsDto);
	                        messagePushService.insertMessage(messageInfoEntity);
	                    }
	                }
	            }
	            
	            //本品收购添加接单记录
	            if(psiCustomerReservationTrackEntities.get(0).getBusinessType().equals(Constants.businessType.oneselfBrand.value())){
	            	PsiOrderReceivingRecordEntity psiOrderReceivingRecordEntity = new PsiOrderReceivingRecordEntity();
	            	psiOrderReceivingRecordEntity.generatePk();
	            	psiOrderReceivingRecordEntity.setOperation("分配车商");
	            	psiOrderReceivingRecordEntity.setOrderStatus("待接单");
	            	psiOrderReceivingRecordEntity.setRecordType("01");
	            	psiOrderReceivingRecordEntity.setReservationId(divisionCarDealerDto.getReservationId());
	            	psiOrderReceivingRecordEntity.setOperationBy(user.getPartyId());
	            	psiOrderReceivingRecordEntity.setOperationDate(new Date());
	            	this.iPsiOrderReceivingRecordDao.insert(psiOrderReceivingRecordEntity);
	            }
	            
	            //二手车主管电话
	            List<String> strings = acquisitionFollowDao.queryUsedCarSupervisor(divisionCarDealerDto.getStoreId());
	
	            //二手车主管相关信息
	            RepOrderNeedDto repOrderNeedDto = acquisitionFollowDao.queryReplacementOrderInfo(divisionCarDealerDto.getReservationId());
	            LOGGER.info("====二手车主管相关信息 repOrderNeedDto===" + JsonBeanUtil.beanToJson(repOrderNeedDto));
	            //检测时间和地点
	            PsiCustomerReservationMsgPk pk = new PsiCustomerReservationMsgPk();
	            pk.setReservationId(divisionCarDealerDto.getReservationId());
	            PsiCustomerReservationMsgEntity load = iPsiCustomerReservationMsgDao.load(pk);
	            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	            String format = formatter.format(load.getReservationDetectionDate());
	            String[] s = format.split(" ");
	
	            //短信发送
	            for (String string : strings) {
	                SmsParamsDto smsParamsDto = new SmsParamsDto();
	                smsParamsDto.setTemplateId(Constants.sendMessage.sendMessageTenth.value());
	                //二手车主管手机号解密
	                try {
	                    string = AesUtils.decryptHex(string,ucmpAesConfig.getSecret());
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	                smsParamsDto.setTo(string);
	                SysDatadictEntity sysDatadictEntity = new SysDatadictEntity();
	                sysDatadictEntity.setDictCode(repOrderNeedDto.getMakeOrderPersonRole());
	                List<SysDatadictEntity> select = sysDatadictDao.selectBySelective(sysDatadictEntity);
	                //插入信息表
	                PsiMessageInfoEntity messageInfoEntity =new PsiMessageInfoEntity();
	                messageInfoEntity.setMessageType(Constants.MessageType.Sms.value());
	                messageInfoEntity.setReservationId(divisionCarDealerDto.getReservationId());
	                messageInfoEntity.setTemplateId(Constants.sendMessage.sendMessageTenth.value());
	                messageInfoEntity.setRecipient(repOrderNeedDto.getMakeOrderPersonIphone());
	                try {
	                    //制单人手机号解密
	                    repOrderNeedDto.setMakeOrderPersonIphone(AesUtils.decryptHex(repOrderNeedDto.getMakeOrderPersonIphone(), ucmpAesConfig.getSecret()));
	                } catch (Exception e) {
	                    LOGGER.info(e.getMessage());
	                }
	                smsParamsDto.setTemplateParas(new String[]{
	                        repOrderNeedDto.getStoreName(),//门店名称
	                        repOrderNeedDto.getBusinessOrderNo(),//业务单号
	                        repOrderNeedDto.getMakeOrderPersonName(),//制单人姓名
	                        select.get(0).getDictValue(),//角色名称
	                        repOrderNeedDto.getMakeOrderPersonIphone(),//制单人电话
	                        s[0],//时间前段
	                        s[1],//时间后段
	                        load.getReservationDetectionAddress()});//检测地址
	                sendSmsFegin.batchSendSms(smsParamsDto);
	                messagePushService.insertMessage(messageInfoEntity);
	            }
	        } else {
	            throw new IllegalParameterException("已分配车商，不能重复分配");
	        }
    	} catch (Exception e) {
    		LOGGER.error("==服务异常===",e);
    		throw new Exception("服务异常，请联系系统管理员");
    	}
    }
    
    public static void main(String[] args) throws Exception {
		String phone="64648734772DEA87AD6F3F8B52866EE4";
		LOGGER.info("------"+AesUtils.decryptHex(phone, "Hn9AQTUAYuMFNbUw"));
	}

    /**
     * Description: 分配车商信息查询
     *
     * @param carDealerMsgQueryDto 入参
     * @throws Exception 
     */
    @Override
    public List<CarDealerMsgDto> queryCarDealer(CarDealerMsgQueryDto carDealerMsgQueryDto) throws Exception {
        /**一期优化功能，现已去掉
        //先查询出排名前三的合作商
        List<SysPartnerDetailsDto> sysPartnerDetailsOrders = psiReplaceManageDao.selectPartnerDetailsOrderSort();
        Map<Long,Integer> detailsSortMap = new HashMap();
        for (int i = 0; i < sysPartnerDetailsOrders.size(); i++) {
            if(detailsSortMap.size() >= 3 || Objects.isNull(sysPartnerDetailsOrders.get(i).getPartnerOrder())){
                break;
            }
            detailsSortMap.put(sysPartnerDetailsOrders.get(i).getPartnerId(),i + 1);
        } **/
    	 try {
    		//查询预约单业务类型
	    	PsiCustomerReservationTrackPk psiCustomerReservationTrackPk=new PsiCustomerReservationTrackPk();
	    	psiCustomerReservationTrackPk.setReservationId(carDealerMsgQueryDto.getReservationId());
	    	PsiCustomerReservationTrackEntity psiCustomerReservationTrackEntity =this.iPsiCustomerReservationTrackDao.load(psiCustomerReservationTrackPk);
	    	List<CarDealerMsgDto> carDealerMsgDtos;
    		 //根据当前登录用户名查询本地库中的partyId
	        SysStoreStaffInfoEntity sysStoreStaffInfoEntity = new SysStoreStaffInfoEntity();
	        sysStoreStaffInfoEntity.setIdmAccountName(carDealerMsgQueryDto.getIdmAccountName());
	        List<SysStoreStaffInfoEntity> sysStoreStaffInfoEntities = iSysStoreStaffInfoDao.selectBySelective(sysStoreStaffInfoEntity);
	        carDealerMsgQueryDto.setPartyId(sysStoreStaffInfoEntities.get(0).getPartyId());
	      //本品收购只查询 合作商为 高合官方
	    	if(psiCustomerReservationTrackEntity.getBusinessType().equals(Constants.businessType.oneselfBrand.value())){
	    		carDealerMsgQueryDto.setPartnerAbbreviation(ucmpTestProperties.getPartnerAbbreviation());
	    	}
	        
	        carDealerMsgDtos = psiReplaceManageDao.selectCarDealer(carDealerMsgQueryDto);
	        if (CollUtil.isNotEmpty(carDealerMsgDtos)){
	            for (CarDealerMsgDto carDealerMsgDto : carDealerMsgDtos) {
	                //密文负责人手机号
	                carDealerMsgDto.setEnChargePersonIphone(carDealerMsgDto.getChargePersonIphone());
	                //手机号解密
	                carDealerMsgDto.setChargePersonIphone(AesUtils.decryptHex(carDealerMsgDto.getChargePersonIphone(),ucmpAesConfig.getSecret()));
	                carDealerMsgDto.setPartnerChargePerson(dataMask(carDealerMsgDto.getPartnerChargePerson(),1,carDealerMsgDto.getPartnerChargePerson().length(),"***"));
	                carDealerMsgDto.setChargePersonIphone(dataMask(carDealerMsgDto.getChargePersonIphone(), 3, 7, "****"));
	                //排名赋值
	//                if(detailsSortMap.containsKey(carDealerMsgDto.getPartnerId())){
	//                    carDealerMsgDto.setPartnerSort(detailsSortMap.get(carDealerMsgDto.getPartnerId()));
	//                }
	            }
	        }
	        return carDealerMsgDtos;
    	 } catch (Exception e) {
             LOGGER.error("==手机号解密异常===",e);
             throw new Exception("服务异常，请联系系统管理员");
         }
    }


    /**
     * Description: 不同状态下的置换线索列表
     *
     * @param replaceCluesDetailsQueryDto 查询条件
     * @return 实体集合
     * @throws Exception 
     */
    @Override
    public List<ReplaceCluesDetailsDto> queryReplaceClues(ReplaceCluesDetailsQueryDto replaceCluesDetailsQueryDto) throws Exception {
    	 try {
	        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
	        if (Constants.slfRole.MC.value().equals(replaceCluesDetailsQueryDto.getRole())) {
	            SysStoreStaffInfoEntity sysStoreStaffInfoEntity = new SysStoreStaffInfoEntity();
	            sysStoreStaffInfoEntity.setIdmAccountName(replaceCluesDetailsQueryDto.getIdmAccountName());
	            sysStoreStaffInfoEntity.setRoleCode(replaceCluesDetailsQueryDto.getRole());
	            List<SysStoreStaffInfoEntity> sysStoreStaffInfoEntities = iSysStoreStaffInfoDao.selectBySelective(sysStoreStaffInfoEntity);
	            replaceCluesDetailsQueryDto.setConsultantId(sysStoreStaffInfoEntities.get(0).getPartyId());
	            replaceCluesDetailsQueryDto.setStoreId(user.getOrganId());
	        } else if (Constants.slfRole.MO.value().equals(replaceCluesDetailsQueryDto.getRole())||
	                Constants.slfRole.PMO.value().equals(replaceCluesDetailsQueryDto.getRole())||
	                Constants.slfRole.ME.value().equals(replaceCluesDetailsQueryDto.getRole())||
	                Constants.smpRole.MO.value().equals(replaceCluesDetailsQueryDto.getRole()) ) {
	            SysStoreStaffInfoEntity sysStoreStaffInfoEntity = new SysStoreStaffInfoEntity();
	            sysStoreStaffInfoEntity.setIdmAccountName(replaceCluesDetailsQueryDto.getIdmAccountName());
	            sysStoreStaffInfoEntity.setRoleCode(replaceCluesDetailsQueryDto.getRole());
	            List<SysStoreStaffInfoEntity> sysStoreStaffInfoEntities = iSysStoreStaffInfoDao.selectBySelective(sysStoreStaffInfoEntity);
	            replaceCluesDetailsQueryDto.setManagerId(sysStoreStaffInfoEntities.get(0).getPartyId());
	            replaceCluesDetailsQueryDto.setStoreId(user.getOrganId());
	        }else if (Constants.slfRole.SH.value().equals(replaceCluesDetailsQueryDto.getRole())||
	        		Constants.smpRole.SH.value().equals(replaceCluesDetailsQueryDto.getRole())) {
	            replaceCluesDetailsQueryDto.setStoreId(user.getOrganId());
	        }
	
	        LOGGER.info("====replaceCluesDetailsQueryDto====" + JsonBeanUtil.beanToJson(replaceCluesDetailsQueryDto));
	        List<String> test = new ArrayList<>();
	        if(CollUtil.isEmpty(replaceCluesDetailsQueryDto.getFilterStatus())){
	            replaceCluesDetailsQueryDto.setFilterStatus(test);
	        }
	        List<ReplaceCluesDetailsDto> replaceCluesDetailsDtos = psiReplaceManageDao.selectReplaceClues(replaceCluesDetailsQueryDto);
	        LOGGER.info("====replaceCluesDetailsDtos====" + JsonBeanUtil.beanToJson(replaceCluesDetailsDtos));
	        for (ReplaceCluesDetailsDto replaceCluesDetailsDto : replaceCluesDetailsDtos) {
	            //密文手机号
	            replaceCluesDetailsDto.setEnCustomerIphone(replaceCluesDetailsDto.getCustomerIphone());
	            replaceCluesDetailsDto.setEnMakeOrderPersonIphone(replaceCluesDetailsDto.getMakeOrderPersonIphone());
	            //手机号解密
	           
	                replaceCluesDetailsDto.setMakeOrderPersonIphone(AesUtils.decryptHex(replaceCluesDetailsDto.getMakeOrderPersonIphone(),ucmpAesConfig.getSecret()));
	                replaceCluesDetailsDto.setCustomerIphone(AesUtils.decryptHex(replaceCluesDetailsDto.getCustomerIphone(),ucmpAesConfig.getSecret()));
	            
	            replaceCluesDetailsDto.setCustomerIphone(dataMask(replaceCluesDetailsDto.getCustomerIphone(), 3, 7, "****"));
	            replaceCluesDetailsDto.setCustomerName(dataMask(replaceCluesDetailsDto.getCustomerName(), 1, replaceCluesDetailsDto.getCustomerName().length(), "***"));
	            PsiNewCarOrderEntity psiNewCarOrderEntity = new PsiNewCarOrderEntity();
	            psiNewCarOrderEntity.setReservationId(replaceCluesDetailsDto.getReservationId());
	            List<PsiNewCarOrderEntity> psiNewCarOrderEntities = iPsiNewCarOrderDao.selectBySelective(psiNewCarOrderEntity);
	            if (!psiNewCarOrderEntities.isEmpty()) {
	                replaceCluesDetailsDto.setLinkFlag(true);
	            } else {
	                replaceCluesDetailsDto.setLinkFlag(false);
	            }
	        }
	        //未link
	        if (Objects.nonNull(replaceCluesDetailsQueryDto.getLink()) && StringUtils.isNotBlank( replaceCluesDetailsQueryDto.getLink() ) ){
	            if (replaceCluesDetailsQueryDto.getLink().equals("00")){
	                replaceCluesDetailsDtos = replaceCluesDetailsDtos.stream().filter(x-> x.getLinkFlag().equals(Boolean.FALSE)).collect(Collectors.toList());
	            }
	            //已link
	            if (replaceCluesDetailsQueryDto.getLink().equals("01") && StringUtils.isNotBlank( replaceCluesDetailsQueryDto.getLink() ) ){
	                replaceCluesDetailsDtos = replaceCluesDetailsDtos.stream().filter(x-> x.getLinkFlag().equals(Boolean.TRUE)).collect(Collectors.toList());
	            }
	        }
	        //未sign
	        if (Objects.nonNull(replaceCluesDetailsQueryDto.getSign()) && StringUtils.isNotBlank( replaceCluesDetailsQueryDto.getSign() ) ){
	            if (replaceCluesDetailsQueryDto.getSign().equals("00")){
	                replaceCluesDetailsDtos = replaceCluesDetailsDtos.stream().filter(x-> !x.getSignAll().equals("0")).collect(Collectors.toList());
	            }
	            //已sign
	            if (replaceCluesDetailsQueryDto.getSign().equals("01") && StringUtils.isNotBlank( replaceCluesDetailsQueryDto.getSign() ) ){
	                replaceCluesDetailsDtos = replaceCluesDetailsDtos.stream().filter(x-> x.getSignAll().equals("0")).collect(Collectors.toList());
	            }
	        }
	
	        return replaceCluesDetailsDtos;
    	 } catch (Exception e) {
             LOGGER.error("=手机号解密=",e);
             throw new Exception("服务异常，请联系系统管理员");
         }
    }


    /**
     * Description: 关闭预约单
     *
     * @param replaceCluesCloseDto 查询条件
     * @return 实体集合
     * @throws Exception 
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateReplaceClues(ReplaceCluesCloseDto replaceCluesCloseDto) throws Exception {
    	try {
	        PsiCustomerReservationTrackEntity psiCustomerReservationTrackEntity = new PsiCustomerReservationTrackEntity();
	        psiCustomerReservationTrackEntity =
	                Copiers.beanToBean(replaceCluesCloseDto, ReplaceCluesCloseDto.class, PsiCustomerReservationTrackEntity.class);
	        psiCustomerReservationTrackEntity.setUpdatedBy(AuthContext.getInstance(Person.class).getCurrentUser().getPartyId());
	        PsiCustomerReservationTrackEntity reservationTrackEntity = new PsiCustomerReservationTrackEntity();
	        reservationTrackEntity.setReservationId(replaceCluesCloseDto.getReservationId());
	        List<PsiCustomerReservationTrackEntity> psiCustomerReservationTrackEntities = iPsiCustomerReservationTrackDao.selectBySelective(reservationTrackEntity);
	        if (Constants.trackStatus.noReceiving.value().equals(psiCustomerReservationTrackEntities.get(0).getTrackStatus())) {
	            psiCustomerReservationTrackEntity.setShutCause(Constants.shutCause.noReceiving.value());
	            psiCustomerReservationTrackEntity.setShutCauseDetails(Constants.shutCauseDetails.noReceiving.value());
	
	        }
	
	        if (Constants.trackStatus.noQuote.value().equals(psiCustomerReservationTrackEntities.get(0).getTrackStatus())) {
	            psiCustomerReservationTrackEntity.setShutCause(Constants.shutCause.noQuoting.value());
	            psiCustomerReservationTrackEntity.setShutCauseDetails(Constants.shutCauseDetails.noQuoting.value());
	
	        }
	
	        if (Constants.trackStatus.noAcquisition.value().equals(psiCustomerReservationTrackEntities.get(0).getTrackStatus())) {
	            psiCustomerReservationTrackEntity.setShutCause(Constants.shutCause.noAcquisitions.value());
	            psiCustomerReservationTrackEntity.setShutCauseDetails(Constants.shutCauseDetails.noAcquisitions.value());
	
	        }
	
	        if (!StringUtil.isEmpty(replaceCluesCloseDto.getShutDescribe())) {
	            psiCustomerReservationTrackEntity.setShutDescribe(replaceCluesCloseDto.getShutDescribe());
	        }
	        psiCustomerReservationTrackEntity.setTrackStatus(Constants.trackStatus.closed.value());
	        psiCustomerReservationTrackEntity.setShutDate(new Date());
	        iPsiCustomerReservationTrackDao.updateSelective(psiCustomerReservationTrackEntity);
    	} catch (Exception e) {
			 LOGGER.error("=手机号解密=",e);
	         throw new Exception("服务异常，请联系系统管理员");
		}
    }


    /**
     * Description: 车商签到
     *
     * @param carDealerSignIn 条件
     * @return 实体集合
     * @throws Exception 
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateCarDealerSignIn(CarDealerSignIn carDealerSignIn) throws Exception {
    	try{
	        PsiCarDealerInquiryEntity psiCarDealerInquiry = new PsiCarDealerInquiryEntity();
	        psiCarDealerInquiry.setCarDealerId(carDealerSignIn.getCarDealerId());
	        psiCarDealerInquiry.setReservationId(carDealerSignIn.getReservationId());
	        List<PsiCarDealerInquiryEntity> psiCarDealerInquiryList = iPsiCarDealerInquiryDao.selectBySelective(psiCarDealerInquiry);
	
	        //车商询价表签到时间以及状态,最后报价时间修改
	        PsiCarDealerInquiryEntity psiCarDealerInquiryEntity = new PsiCarDealerInquiryEntity();
	        psiCarDealerInquiryEntity.setCarDealerId(carDealerSignIn.getCarDealerId());
	        psiCarDealerInquiryEntity.setReservationId(carDealerSignIn.getReservationId());
	        List<PsiCarDealerInquiryEntity> psiCarDealerInquiryEntities = iPsiCarDealerInquiryDao.selectBySelective(psiCarDealerInquiryEntity);
	        psiCarDealerInquiryEntity.setInquiryId(psiCarDealerInquiryEntities.get(0).getInquiryId());
	        //报价截止时间改为接单后7天
	        if (carDealerSignIn.getQuoteDeadline() == null) {
	
	            /** start 报价截止时间取检测时间+7天 **/
	            Date date = new Date();
	            Calendar cal = Calendar.getInstance();
//	            PsiCustomerReservationMsgEntity msgEntity = iPsiCustomerReservationMsgDao.load(new PsiCustomerReservationMsgPk(carDealerSignIn.getReservationId()));
//	            if (Objects.nonNull(msgEntity.getReservationDetectionDate())){
//	                cal.setTime(msgEntity.getReservationDetectionDate());
//	            }else {
	                cal.setTime(date);
//	            }
	//            报价截止时间取检测时间+7天
	            cal.add(Calendar.HOUR, 168 );
	
	            //方便测试改小 一分钟
	//            cal.add(Calendar.MINUTE,5);
	
	            /** end **/
	
	            psiCarDealerInquiryEntity.setQuoteDeadline(cal.getTime());
	        } else {
	            psiCarDealerInquiryEntity.setQuoteDeadline(carDealerSignIn.getQuoteDeadline());
	        }
	
	        psiCarDealerInquiryEntity.setSignInDate(new Date());
	        psiCarDealerInquiryEntity.setInquiryStatus(Constants.inquiryStatus.unOffer.value());
	        psiCarDealerInquiryEntity.setUpdatedBy(AuthContext.getInstance(Person.class).getCurrentUser().getPartyId());
	        psiCarDealerInquiryEntity.setReservationId(null);
	        psiCarDealerInquiryEntity.setCarDealerId(null);
	        //修改
	        iPsiCarDealerInquiryDao.updateSelective(psiCarDealerInquiryEntity);
	
	
	        if (Constants.inquiryStatus.orderReceiving.value().equals(psiCarDealerInquiryList.get(0).getInquiryStatus())) {
	            //预约单状态以及报价时间修改
	            PsiCustomerReservationTrackEntity psiCustomerReservationTrackEntity = new PsiCustomerReservationTrackEntity();
	            psiCustomerReservationTrackEntity.setReservationId(carDealerSignIn.getReservationId());
	            psiCustomerReservationTrackEntity.setUpdatedBy(AuthContext.getInstance(Person.class).getCurrentUser().getPartyId());
	            psiCustomerReservationTrackEntity.setUpdatedDate(new Date());
	
	            //车商首次签到更改预约表状态为检测中
	            PsiCustomerReservationTrackPk psiCustomerReservationTrackPk = new PsiCustomerReservationTrackPk();
	            psiCustomerReservationTrackPk.setReservationId(carDealerSignIn.getReservationId());
	            PsiCustomerReservationTrackEntity load = iPsiCustomerReservationTrackDao.load(psiCustomerReservationTrackPk);
	            if (load.getTrackStatus().equals(Constants.trackStatus.toBeTested.value())) {
	                psiCustomerReservationTrackEntity.setQuoteDeadline(psiCarDealerInquiryEntity.getQuoteDeadline());
	                psiCustomerReservationTrackEntity.setTrackStatus(Constants.trackStatus.testing.value());
	            }
	            if (load.getTrackStatus().equals(Constants.trackStatus.assigned.value())) {
	                psiCustomerReservationTrackEntity.setQuoteDeadline(psiCarDealerInquiryEntity.getQuoteDeadline());
	                psiCustomerReservationTrackEntity.setTrackStatus(Constants.trackStatus.testing.value());
	            }
	
	            iPsiCustomerReservationTrackDao.updateSelective(psiCustomerReservationTrackEntity);
	        } else {
	            throw new IllegalParameterException("签到失败,该车商不能签到，状态为" + psiCarDealerInquiryList.get(0).getInquiryStatus());
	        }
    	}catch (Exception e) {
    		LOGGER.error("=手机号解密=",e);
	         throw new Exception("服务异常，请联系系统管理员");
		}
    }


    /**
     * Description: 车商信息查询(参与车商)
     *
     * @param carDealerMsgQueryDto 入参
     * @throws Exception 
     */
    @Override
    public List<CarDealerMsgDto> queryCarDealerInfo(CarDealerMsgQueryDto carDealerMsgQueryDto) throws Exception {
        /**一期优化功能，现已去掉
        //先查询出排名前三的合作商
        List<SysPartnerDetailsDto> sysPartnerDetailsOrders = psiReplaceManageDao.selectPartnerDetailsOrderSort();
        Map<Long,Integer> detailsSortMap = new HashMap();
        for (int i = 0; i < sysPartnerDetailsOrders.size(); i++) {
            if(detailsSortMap.size() >= 3 || Objects.isNull(sysPartnerDetailsOrders.get(i).getPartnerOrder())){
                break;
            }
            detailsSortMap.put(sysPartnerDetailsOrders.get(i).getPartnerId(),i + 1);
        }**/
    	try {
	        List<CarDealerMsgDto> carDealerMsgDtos = new ArrayList<>();
	        carDealerMsgDtos = psiReplaceManageDao.selectCarDealerInfo(carDealerMsgQueryDto);
	        if (CollUtil.isEmpty(carDealerMsgDtos)){
	            carDealerMsgDtos = psiReplaceManageDao.selectCarDealerInfoPendingOrder(carDealerMsgQueryDto);
	        }
	        if (CollUtil.isNotEmpty(carDealerMsgDtos)){
	            for (CarDealerMsgDto carDealerMsgDto : carDealerMsgDtos) {
	                //密文负责人手机号
	                carDealerMsgDto.setEnChargePersonIphone(carDealerMsgDto.getChargePersonIphone());
	                //手机号解密
                    carDealerMsgDto.setChargePersonIphone(AesUtils.decryptHex(carDealerMsgDto.getChargePersonIphone(),ucmpAesConfig.getSecret()));
	                carDealerMsgDto.setPartnerChargePerson(dataMask(carDealerMsgDto.getPartnerChargePerson(),1,carDealerMsgDto.getPartnerChargePerson().length(),"***"));
	                carDealerMsgDto.setChargePersonIphone(dataMask(carDealerMsgDto.getChargePersonIphone(), 3, 7, "****"));
	                //排名赋值
	//                if(detailsSortMap.containsKey(carDealerMsgDto.getPartnerId())){
	//                    carDealerMsgDto.setPartnerSort(detailsSortMap.get(carDealerMsgDto.getPartnerId()));
	//                }
	            }
	        }
	        return carDealerMsgDtos;
    	} catch (Exception e) {
    		LOGGER.error("==服务异常===",e);
            throw new Exception("服务异常，请联系系统管理员");
        }
    }

    /**
     * Description: 客户操作(同意/接洽/拒绝)
     *
     * @param customerOperationDto 入参
     * @throws Exception 
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void customerOperation(CustomerOperationDto customerOperationDto,int type) throws Exception {
    	LOGGER.info("====报价后 默认客户同意===");
    	try {
    		PsiCustomerReservationTrackEntity psiCustomerReservationTrackEntity = new PsiCustomerReservationTrackEntity();
            if (Constants.customerIntention.customerRefuse.value().equals(customerOperationDto.getCustomerIntention())) {
                if (!StringUtil.isEmpty(customerOperationDto.getShutDescribe())) {
                    psiCustomerReservationTrackEntity.setShutDescribe(customerOperationDto.getShutDescribe());
                }
                psiCustomerReservationTrackEntity.setShutCauseDetails(Constants.shutCauseDetails.customerRefuses.value());
                psiCustomerReservationTrackEntity.setShutCause(Constants.shutCause.customerRefuses.value());
                psiCustomerReservationTrackEntity.setShutDate(new Date());
                psiCustomerReservationTrackEntity.setTrackStatus(Constants.trackStatus.closed.value());
            } else {
                if (!StringUtil.isEmpty(customerOperationDto.getShutDescribe())) {
                    psiCustomerReservationTrackEntity.setAgreeDescribe(customerOperationDto.getShutDescribe());
                }
                if(type == 1){
                	psiCustomerReservationTrackEntity.setTrackStatus(Constants.trackStatus.testing.value());
                }else{
                	psiCustomerReservationTrackEntity.setTrackStatus(Constants.trackStatus.completed.value());
                }
            }

            //修改预约跟踪表的状态
            psiCustomerReservationTrackEntity.setReservationId(customerOperationDto.getReservationId());
            psiCustomerReservationTrackEntity.setCustomerIntention(customerOperationDto.getCustomerIntention());
            psiCustomerReservationTrackEntity.setUpdatedBy(AuthContext.getInstance(Person.class).getCurrentUser().getPartyId());

            LOGGER.info("====报价后 updateSelective客户同意==="+JsonBeanUtil.beanToJson(psiCustomerReservationTrackEntity));
            iPsiCustomerReservationTrackDao.updateSelective(psiCustomerReservationTrackEntity);

            if (!Constants.customerIntention.customerRefuse.value().equals(customerOperationDto.getCustomerIntention()) && type == 0) {
                //修改收购表的状态
                PsiCarAcquisitionEntity psiCarAcquisitionEntity = new PsiCarAcquisitionEntity();
                PsiCustomerReservationTrackEntity reservationTrackEntity = new PsiCustomerReservationTrackEntity();
                reservationTrackEntity.setReservationId(customerOperationDto.getReservationId());
                List<PsiCustomerReservationTrackEntity> psiCustomerReservationTrackEntities = iPsiCustomerReservationTrackDao.selectBySelective(reservationTrackEntity);

                psiCarAcquisitionEntity.setReservationId(customerOperationDto.getReservationId());
                if (psiCustomerReservationTrackEntities.get(0).getOtherBrandInquiryId() != null) {
                    psiCarAcquisitionEntity.setOtherBrandInquiryId(psiCustomerReservationTrackEntities.get(0).getOtherBrandInquiryId());
                }
                psiCarAcquisitionEntity.setCustomerIntention(psiCustomerReservationTrackEntities.get(0).getCustomerIntention());
                psiCarAcquisitionEntity.setEstimateDealPrice(psiCustomerReservationTrackEntities.get(0).getEstimateDealPrice());
                if (psiCustomerReservationTrackEntities.get(0).getDealPriceEnd() != null) {
                    psiCarAcquisitionEntity.setDealPriceEnd(psiCustomerReservationTrackEntities.get(0).getDealPriceEnd());
                }
                psiCarAcquisitionEntity.setMaterialStatus(Constants.materialStatus.notUpload.value());

                psiCarAcquisitionEntity.setAcquisitionStatus(Constants.acquisitionStatus.unAcquired.value());
                psiCarAcquisitionEntity.setCreatedBy(AuthContext.getInstance(Person.class).getCurrentUser().getPartyId());
                psiCarAcquisitionEntity.setUpdatedBy(psiCarAcquisitionEntity.getCreatedBy());
                iPsiCarAcquisitionDao.insertSelective(psiCarAcquisitionEntity);
            }


            //获取询价id
            PsiCustomerReservationTrackEntity trackEntity = new PsiCustomerReservationTrackEntity();
            trackEntity.setReservationId(customerOperationDto.getReservationId());
            List<PsiCustomerReservationTrackEntity> trackEntities = iPsiCustomerReservationTrackDao.selectBySelective(trackEntity);
            Long inquiryId = null;
            if (trackEntities.get(0).getOtherBrandInquiryId() != null) {
                inquiryId = trackEntities.get(0).getOtherBrandInquiryId();
            }
            if (trackEntities.get(0).getOneselfBrandInquiryId() != null) {
                inquiryId = trackEntities.get(0).getOneselfBrandInquiryId();
            }
            //修改询价表的状态
            PsiCarDealerInquiryEntity inquiryEntity = new PsiCarDealerInquiryEntity();
            inquiryEntity.setInquiryId(inquiryId);
            inquiryEntity.setCustomerIntention(customerOperationDto.getCustomerIntention());
            if ((Constants.customerIntention.customerAgrees.value().equals(customerOperationDto.getCustomerIntention())
                    || Constants.customerIntention.customerBargaining.value().equals(customerOperationDto.getCustomerIntention()))) {
            	if(type==0){
            		inquiryEntity.setInquiryStatus(Constants.inquiryStatus.unAcquired.value());
            	}else{
            		inquiryEntity.setInquiryStatus(Constants.inquiryStatus.unAllotDeliveryCenter.value());
            	}
                inquiryEntity.setRemarks(customerOperationDto.getShutDescribe());
            } else {
                inquiryEntity.setCloseTime(new Date());
                inquiryEntity.setRemarks(customerOperationDto.getShutDescribe());
            }
            inquiryEntity.setGenerateAcquisitionsTime(new Date());
            inquiryEntity.setUpdatedBy(AuthContext.getInstance(Person.class).getCurrentUser().getPartyId());
            LOGGER.info("====报价后iPsiCarDealerInquiryDao.updateSelective客户同意==="+JsonBeanUtil.beanToJson(psiCustomerReservationTrackEntity));
            iPsiCarDealerInquiryDao.updateSelective(inquiryEntity);
		} catch (Exception e) {
			LOGGER.error("==服务异常===",e);
            throw new Exception("服务异常，请联系系统管理员");
		}
    }

    /**
     * Description: 车商信息查询(车商签到)
     * @param carDealerMsgQueryDto 入参
     * @throws Exception 
     */
    @Override
    public List<CarDealerMsgDto> queryCarDealerSignIn(CarDealerMsgQueryDto carDealerMsgQueryDto) throws Exception {
        /**一期优化功能，现已去掉
        //先查询出排名前三的合作商
        List<SysPartnerDetailsDto> sysPartnerDetailsOrders = psiReplaceManageDao.selectPartnerDetailsOrderSort();
        Map<Long,Integer> detailsSortMap = new HashMap();
        for (int i = 0; i < sysPartnerDetailsOrders.size(); i++) {
            if(detailsSortMap.size() >= 3 || Objects.isNull(sysPartnerDetailsOrders.get(i).getPartnerOrder())){
                break;
            }
            detailsSortMap.put(sysPartnerDetailsOrders.get(i).getPartnerId(),i + 1);
        }**/
    	try {
	        List<CarDealerMsgDto> carDealerMsgDtos = psiReplaceManageDao.selectCarDealerSignIn(carDealerMsgQueryDto);
	        if (CollUtil.isNotEmpty(carDealerMsgDtos)){
	            for (CarDealerMsgDto carDealerMsgDto : carDealerMsgDtos) {
	                //密文负责人手机号
	                carDealerMsgDto.setEnChargePersonIphone(carDealerMsgDto.getChargePersonIphone());
	                //手机号解密
	                    carDealerMsgDto.setChargePersonIphone(AesUtils.decryptHex(carDealerMsgDto.getChargePersonIphone(),ucmpAesConfig.getSecret()));
	                carDealerMsgDto.setPartnerChargePerson(dataMask(carDealerMsgDto.getPartnerChargePerson(),1,carDealerMsgDto.getPartnerChargePerson().length(),"***"));
	                carDealerMsgDto.setChargePersonIphone(dataMask(carDealerMsgDto.getChargePersonIphone(), 3, 7, "****"));
	                //排名赋值
	//                if(detailsSortMap.containsKey(carDealerMsgDto.getPartnerId())){
	//                    carDealerMsgDto.setPartnerSort(detailsSortMap.get(carDealerMsgDto.getPartnerId()));
	//                }
	            }
	        }
	        /*int row = 0;
	        for (CarDealerMsgDto carDealerMsgDto : carDealerMsgDtos) {
	            if (Constants.inquiryStatus.unOffer.value().equals(carDealerMsgDto.getInquiryStatus())){
	                row = row+1;
	            }
	            if (row>=0){
	                Date quoteEndDate = carDealerMsgDto.getQuoteEndDate();
	                Calendar cal = Calendar.getInstance();
	                cal.setTime(quoteEndDate);
	                cal.add(Calendar.HOUR, 4);
	                carDealerMsgDto.setQuoteEndDate(cal.getTime());
	                break;
	
	            }
	        }*/
	        return carDealerMsgDtos;
    	} catch (Exception e) {
    		LOGGER.error("==服务异常===",e);
            throw new Exception("服务异常，请联系系统管理员");
    	}
    }

    /**
     * Description: 关联新车订单信息(link订单)
     *
     * @param psiNewCarOrderDto 入参
     * @throws Exception 
     */
    @Transactional(rollbackFor = Exception.class)

    public void linkNewCarOrder(PsiNewCarOrderDto psiNewCarOrderDto) throws Exception {
    	try {
    		Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
	        LOGGER.info("=====psiNewCarOrderDto===" + JsonBeanUtil.beanToJson(psiNewCarOrderDto));
	        PsiNewCarOrderEntity psiNewCarOrderEntity = new PsiNewCarOrderEntity();
	        psiNewCarOrderEntity = Copiers.beanToBean(psiNewCarOrderDto, PsiNewCarOrderDto.class, PsiNewCarOrderEntity.class);
	        //主用车人手机号加密
	        if(StringUtils.isNotBlank(psiNewCarOrderDto.getMainUserPhone())){
	                psiNewCarOrderEntity.setMainUserPhone(AesUtils.encryptHex(psiNewCarOrderEntity.getMainUserPhone(),ucmpAesConfig.getSecret()));
	        }
	        //新车交付时间转换
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	        try {
	            if (StringUtils.isNotBlank(psiNewCarOrderDto.getNewCarDeliveryDate())){
	                psiNewCarOrderEntity.setNewCarDeliveryDate(sdf.parse(psiNewCarOrderDto.getNewCarDeliveryDate()));
	            }
	        } catch (ParseException e) {
	            throw new RuntimeException(e);
	        }
	        //手机号加密
	        psiNewCarOrderEntity.setOwnerPhone(AesUtils.encryptHex(psiNewCarOrderEntity.getOwnerPhone(),ucmpAesConfig.getSecret()));
	        //身份证加密
	        psiNewCarOrderEntity.setOwnerCardNo(AesUtils.encryptHex(psiNewCarOrderEntity.getOwnerCardNo(),ucmpAesConfig.getSecret()));
	        psiNewCarOrderEntity.generatePk();
	        psiNewCarOrderEntity.setCreatedBy(AuthContext.getInstance(Person.class).getCurrentUser().getPartyId());
	        psiNewCarOrderEntity.setUpdatedBy(psiNewCarOrderEntity.getCreatedBy());
	        LOGGER.info("=====psiNewCarOrderEntity===" + JsonBeanUtil.beanToJson(psiNewCarOrderEntity));
	        iPsiNewCarOrderDao.insertSelective(psiNewCarOrderEntity);
	
	        //查询订单业务类型
	        PsiCustomerReservationTrackPk psiCustomerReservationTrackPk = new PsiCustomerReservationTrackPk(psiNewCarOrderDto.getReservationId());
	        PsiCustomerReservationTrackEntity entity = this.iPsiCustomerReservationTrackDao.load(psiCustomerReservationTrackPk);
	        if(entity.getBusinessType().equals(Constants.businessType.otherBrand.value())){
	        	//他品逻辑
	        	RepReplacementApprovalEntity repReplacementApprovalEntity = new RepReplacementApprovalEntity();
		        repReplacementApprovalEntity.setReservationId(psiNewCarOrderDto.getReservationId());
		        List<RepReplacementApprovalEntity> repReplacementApprovalEntities = repReplacementApprovalDao.selectBySelective(repReplacementApprovalEntity);
		        if (CollectionUtils.isNotEmpty(repReplacementApprovalEntities)) {
		            if (!Constants.approvalStatus.reject.value().equals(repReplacementApprovalEntities.get(0).getApprovalStatus())) {
		                RepReplacementApprovalEntity repReplacementApproval = new RepReplacementApprovalEntity();
		                repReplacementApproval.setReplacementId(repReplacementApprovalEntities.get(0).getReplacementId());
		                repReplacementApproval.setApprovalStatus(Constants.approvalStatus.unApproval.value());
		                repReplacementApprovalDao.updateSelective(repReplacementApproval);
		                //更新收购表
		                PsiCarAcquisitionEntity acquisitionEntity = new PsiCarAcquisitionEntity();
		                acquisitionEntity.setReservationId(psiNewCarOrderDto.getReservationId());
		                acquisitionEntity.setApprovalStatus(Constants.approvalStatus.unApproval.value());
		                iPsiCarAcquisitionDao.updateSelective(acquisitionEntity);
		                //更新车商询价表
		                PsiCustomerReservationTrackEntity trackEntity = new PsiCustomerReservationTrackEntity();
		                PsiCarDealerInquiryEntity carDealerInquiryEntity = new PsiCarDealerInquiryEntity();
		                trackEntity.setReservationId(psiNewCarOrderDto.getReservationId());
		                PsiCustomerReservationTrackEntity customerReservationTrack = iPsiCustomerReservationTrackDao.selectBySelective(trackEntity).get(0);
		                if (Objects.nonNull(customerReservationTrack)){
		                    Long oneselfBrandInquiryId = customerReservationTrack.getOneselfBrandInquiryId();
		                    Long otherBrandInquiryId = customerReservationTrack.getOtherBrandInquiryId();
		                    if (Objects.nonNull(oneselfBrandInquiryId)){
		                        carDealerInquiryEntity.setInquiryId(oneselfBrandInquiryId);
		                    }
		                    if (Objects.nonNull(otherBrandInquiryId)){
		                        carDealerInquiryEntity.setInquiryId(otherBrandInquiryId);
		                    }
		                    carDealerInquiryEntity.setUpdatedDate(new Date());
		                    carDealerInquiryEntity.setApprovalStatus(Constants.approvalStatus.unApproval.value());
		                    iPsiCarDealerInquiryDao.updateSelective(carDealerInquiryEntity);
		                }
		            }
		
		        }
	        }else{
	        	//本品逻辑
	        	//更新询价表的审批状态
	        	this.psiReplaceManageDao.updateDealerApprovalStatus(psiNewCarOrderDto.getReservationId(),user.getPartyId());
	        	//更新收购表的审批状态
	        	this.psiReplaceManageDao.updateAcquisitionApprovalStatus(psiNewCarOrderDto.getReservationId(),user.getPartyId());
	        	//更新审批表的状态
	        	this.psiReplaceManageDao.updateApprovalStatus(psiNewCarOrderDto.getReservationId(),user.getPartyId());
	        }
    	} catch (Exception e) {
			LOGGER.error("==服务异常===",e);
            throw new Exception("服务异常，请联系系统管理员");
		}
    }

    /**
     * 信息发送接收人查询
     *
     * @param map 入参
     * @return
     */
    @Override
    public List<HashMap> sendMessagePerson(HashMap map) {
        return psiReplaceManageDao.sendMessagePerson(map);
    }


    /**
     * Description: 时间类型转换
     */

    public static Date transferStringDate(String s) {
        Date date = new Date();
        try {
            date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }


    /**
     * 加*操作
     */

    public static String dataMask(String data, int start, int end, String starCount) {
        String res = "";
        if (!StringUtils.isEmpty(data)) {
            StringBuilder stringBuilder = new StringBuilder(data);
            res = stringBuilder.replace(start, end, starCount).toString();
        }
        return res;
    }
}
