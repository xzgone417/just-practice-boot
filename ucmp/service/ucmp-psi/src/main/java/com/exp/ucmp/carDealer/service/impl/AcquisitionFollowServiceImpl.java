package com.exp.ucmp.carDealer.service.impl;

import com.alibaba.cloud.commons.lang.StringUtils;
import com.egrid.core.base.id.RandomIDGennerator;
import com.egrid.core.copiers.Copiers;
import com.egrid.core.shiro.context.AuthContext;
import com.exp.ucmp.PageDto;
import com.exp.ucmp.carDealer.dao.AcquisitionFollowDao;
import com.exp.ucmp.carDealer.dao.InquiryQuotingDao;
import com.exp.ucmp.carDealer.dto.*;
import com.exp.ucmp.carDealer.service.AcquisitionFollowService;
import com.exp.ucmp.config.TemplateIdConfig;
import com.exp.ucmp.config.UcmpAesConfig;
import com.exp.ucmp.constant.Constants;
import com.exp.ucmp.consumer.ISystemConsumer;
import com.exp.ucmp.dao.*;
import com.exp.ucmp.entity.*;
import com.exp.ucmp.eos.dto.GiveMessageParamDto;
import com.exp.ucmp.eos.dto.MessageParamDto;
import com.exp.ucmp.file.dto.MaterialParamDto;
import com.exp.ucmp.huawei.dto.SmsParamsDto;
import com.exp.ucmp.jPush.dto.JPushReqDto;
import com.exp.ucmp.jpush.service.JPushService;
import com.exp.ucmp.model.Person;
import com.exp.ucmp.pk.*;
import com.exp.ucmp.salesDelivery.service.SalesDelivryService;
import com.exp.ucmp.storeApp.dto.OneselfAcquirerDto;
import com.exp.ucmp.storeApp.dto.ReplaceCluesCloseDto;
import com.exp.ucmp.storeApp.service.PsiReplaceManageService;
import com.exp.ucmp.usc.dto.CreateEvaluationDto;
import com.exp.ucmp.util.AesUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.xiaoymin.knife4j.core.util.CollectionUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author GeYiJiang
 * @Description: 收购跟进实现
 * @date 2022/10/16 10:41
 */
@Service
@Transactional
public class AcquisitionFollowServiceImpl implements AcquisitionFollowService {
	
	 /**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(AcquisitionFollowServiceImpl.class);
	
	@Autowired
	private TemplateIdConfig templateIdConfig;

    @Autowired
    private ISystemConsumer systemConsumer;

    @Autowired
    private AcquisitionFollowDao acquisitionFollowDao;

    @Autowired
    private IPsiCarAcquisitionDao iPsiCarAcquisitionDao;

    @Autowired
    private IPsiCustomerReservationTrackDao iPsiCustomerReservationTrackDao;

    @Autowired
    private IPsiAcquisitionMaterialDao materialDao;

    @Autowired
    private IPsiAcquisitionMaterialFileDao materialFileDao;

    @Autowired
    private IPsiBusinessNodesMaterialDao businessNodesMaterialDao;

    @Autowired
    private IPsiCustomerCarsDao iPsiCustomerCarsDao;

    @Autowired
    private IPsiCarDealerInquiryDao carDealerInquiryDao;

    @Autowired
    private IPsiInquiryCarsDao iPsiInquiryCarsDao;

    @Autowired
    private IPsiNewCarOrderDao newCarOrderDao;

    @Autowired
    private ISysFileMsgDao sysFileMsgDao;

    @Autowired
    private IRepReplacementApprovalDao repReplacementApprovalDao;

    @Autowired
    private IRepReplacementMaterialDao repReplacementMaterialDao;

    @Autowired
    private IRepReplacementMaterialFileDao repReplacementMaterialFileDao;

    @Autowired
    private IPsiCustomerReservationTrackDao customerReservationTrackDao;

    @Autowired
    private IPsiCustomerReservationMsgDao customerReservationMsgDao;

    @Autowired
    private IPsiCreateOrderAccountInfoDao createOrderAccountInfoDao;

    @Autowired
    private MessagePushServiceImpl messagePushService;

    @Autowired
    private ISysDatadictDao sysDatadictDao;

    @Autowired
    private UcmpAesConfig ucmpAesConfig;

    @Autowired
    private IPsiCustomerBasicInformationDao customerBasicInformationDao;

    @Autowired
    PsiReplaceManageService psiReplaceManageService;
    
    @Autowired
    IPsiOrderReceivingRecordDao iPsiOrderReceivingRecordDao;
    
    @Autowired
    JPushService jPushService;
    
    @Autowired
    private SalesDelivryService salesDelivryService;
    
    @Autowired
    private InquiryQuotingDao inquiryQuotingDao;

    @Override
    public PageInfo<AcquisitionQueryResultDto> queryUnAcquired(PageDto pageDto) {
        PageHelper.startPage(pageDto.getPageNum(), pageDto.getPageSize());
        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
        Long organId = user.getOrganId();
        Long partyId = user.getPartyId();
        return new PageInfo<>(acquisitionFollowDao.queryAcquisitionFollowByAwait(1,organId,partyId,""));
    }

    @Override
    public PageInfo<AcquisitionQueryResultDto> queryUnNegotiated(PageDto pageDto) {
        PageHelper.startPage(pageDto.getPageNum(), pageDto.getPageSize());
        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
        Long organId = user.getOrganId();
        Long partyId = user.getPartyId();
        return new PageInfo<>(acquisitionFollowDao.queryAcquisitionFollowByAwait(2,organId,partyId,""));
    }

    @Override
    public PageInfo<AcquisitionQueryResultDto> queryAcquired(PageDto pageDto) {
        PageHelper.startPage(pageDto.getPageNum(), pageDto.getPageSize());
        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
        Long organId = user.getOrganId();
        Long partyId = user.getPartyId();
        return new PageInfo<>(acquisitionFollowDao.queryAcquisitionFollowByAwait(3,organId,partyId,""));
    }

    @Override
    public PageInfo<AcquisitionQueryResultDto> queryNotAcquired(PageDto pageDto) {
        PageHelper.startPage(pageDto.getPageNum(), pageDto.getPageSize());
        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
        Long organId = user.getOrganId();
        Long partyId = user.getPartyId();
        return new PageInfo<>(acquisitionFollowDao.queryAcquisitionFollowByAwait(4,organId,partyId,""));
    }

    @Override
    public PageInfo<AcquisitionQueryResultDto> queryRejected(AcquisitionQueryParamDto pageDto) {
        PageHelper.startPage(pageDto.getPageNum(), pageDto.getPageSize());
        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
        Long organId = user.getOrganId();
        Long partyId = user.getPartyId();
        List<String> status = new ArrayList<>();
        status.add(AcquisitionQueryParamDto.AcquisitionQueryTypeEnum.rejected.name());
        List<AcquisitionQueryResultDto> rejectedList = acquisitionFollowDao.newQueryAcquisitionFollow(status, organId, partyId,pageDto.getBusinessOrderNo());
        if (CollectionUtils.isNotEmpty(rejectedList)){
            for (AcquisitionQueryResultDto resultDto : rejectedList) {
                //密文手机号
                resultDto.setEnCustomerIphone(resultDto.getCustomerIphone());
                resultDto.setEnMakeOrderPersonIphone(resultDto.getMakeOrderPersonIphone());
                //手机号解密
                try {
                    resultDto.setCustomerIphone(AesUtils.decryptHex(resultDto.getCustomerIphone(),ucmpAesConfig.getSecret()));
                    resultDto.setMakeOrderPersonIphone(AesUtils.decryptHex(resultDto.getMakeOrderPersonIphone(),ucmpAesConfig.getSecret()));
                } catch (Exception e) {
                	LOGGER.error("====queryRejected手机号解密异常===",e);
                }
              //查询是否有外呼门店记录
                String userData = resultDto.getReservationId()+"_"+resultDto.getMakeOrderPersonIphone();
                int count = this.inquiryQuotingDao.countRecord(userData);
                if(count == 0){
                	resultDto.setIsCallStore(false);
        		}else{
        			resultDto.setIsCallStore(true);
        		}
                //驳回原因
                String rejectedReason = acquisitionFollowDao.queryRejectedReason(resultDto.getReservationId());
                if(Objects.nonNull(rejectedReason)){
                    resultDto.setRejectedReason(rejectedReason);
                }
            }
        }
        return new PageInfo<>(rejectedList);
    }

    @Override
    public Boolean abandonAcquisition(Long reservationId,String acquisitionAbandonedReason) {
        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
        //修改收购状态
        PsiCarAcquisitionEntity psiCarAcquisitionEntity = new PsiCarAcquisitionEntity();
        psiCarAcquisitionEntity.setReservationId(reservationId);
        psiCarAcquisitionEntity.setAcquisitionAbandonedReason(acquisitionAbandonedReason);
        psiCarAcquisitionEntity.setAcquisitionStatus(Constants.acquisitionStatus.abandonAcquisition.value());
        psiCarAcquisitionEntity.setUpdatedBy(user.getPartyId());
        psiCarAcquisitionEntity.setUpdatedDate(new Date());
        int rows = iPsiCarAcquisitionDao.updateSelective(psiCarAcquisitionEntity);
        //修改预约跟踪表状态
        PsiCustomerReservationTrackEntity psiCustomerReservationTrackEntity = new PsiCustomerReservationTrackEntity();
        psiCustomerReservationTrackEntity.setReservationId(reservationId);
        psiCustomerReservationTrackEntity.setTrackStatus(Constants.trackStatus.noAcquisition.value());
        psiCustomerReservationTrackEntity.setUpdatedBy(user.getPartyId());
        psiCustomerReservationTrackEntity.setUpdatedDate(new Date());
        int i1 = iPsiCustomerReservationTrackDao.updateSelective(psiCustomerReservationTrackEntity);
        if (rows > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public PageInfo<AcquisitionQueryResultDto> newQueryUnAcquired(AcquisitionQueryParamDto pageDto) {
        PageHelper.startPage(pageDto.getPageNum(), pageDto.getPageSize());
        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
        List<String> status = new ArrayList<>();
        //待收购
        status.add(Constants.inquiryStatus.unAcquired.value());
        List<AcquisitionQueryResultDto> acquisitionQueryResultDtos = acquisitionFollowDao.newQueryAcquisitionFollow(status, user.getOrganId(), user.getPartyId(), pageDto.getBusinessOrderNo());
        //客户手机号解密
        if (CollectionUtils.isNotEmpty(acquisitionQueryResultDtos)){
            for (AcquisitionQueryResultDto acquisitionQueryResultDto : acquisitionQueryResultDtos) {
                //密文手机号
                acquisitionQueryResultDto.setEnCustomerIphone(acquisitionQueryResultDto.getCustomerIphone());
                acquisitionQueryResultDto.setEnMakeOrderPersonIphone(acquisitionQueryResultDto.getMakeOrderPersonIphone());
                try {
                    acquisitionQueryResultDto.setCustomerIphone(AesUtils.decryptHex(acquisitionQueryResultDto.getCustomerIphone(),ucmpAesConfig.getSecret()));
                    acquisitionQueryResultDto.setMakeOrderPersonIphone(AesUtils.decryptHex(acquisitionQueryResultDto.getEnMakeOrderPersonIphone(),ucmpAesConfig.getSecret()));
                } catch (Exception e) {
                    LOGGER.error("====newQueryUnAcquired手机号解密异常===",e);
                }
              //查询是否有外呼门店记录
                String userData = acquisitionQueryResultDto.getReservationId()+"_"+acquisitionQueryResultDto.getMakeOrderPersonIphone();
                int count = this.inquiryQuotingDao.countRecord(userData);
                if(count == 0){
                	acquisitionQueryResultDto.setIsCallStore(false);
        		}else{
        			acquisitionQueryResultDto.setIsCallStore(true);
        		}
            }
        }
        return new PageInfo<>(acquisitionQueryResultDtos);
    }

    @Override
    public PageInfo<AcquisitionQueryResultDto> queryUnTransfer(AcquisitionQueryParamDto pageDto) {
        PageHelper.startPage(pageDto.getPageNum(), pageDto.getPageSize());
        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
        List<String> status = new ArrayList<>();
        //待过户
        status.add(Constants.inquiryStatus.unTransfer.value());
        List<AcquisitionQueryResultDto> acquisitionQueryResultDtos = acquisitionFollowDao.newQueryAcquisitionFollow(status, user.getOrganId(), user.getPartyId(), pageDto.getBusinessOrderNo());
        //客户手机号解密
        if (CollectionUtils.isNotEmpty(acquisitionQueryResultDtos)){
            for (AcquisitionQueryResultDto acquisitionQueryResultDto : acquisitionQueryResultDtos) {
                //密文手机号
                acquisitionQueryResultDto.setEnCustomerIphone(acquisitionQueryResultDto.getCustomerIphone());
                acquisitionQueryResultDto.setEnMakeOrderPersonIphone(acquisitionQueryResultDto.getMakeOrderPersonIphone());
                try {
                    acquisitionQueryResultDto.setCustomerIphone(AesUtils.decryptHex(acquisitionQueryResultDto.getCustomerIphone(),ucmpAesConfig.getSecret()));
                    acquisitionQueryResultDto.setMakeOrderPersonIphone(AesUtils.decryptHex(acquisitionQueryResultDto.getEnMakeOrderPersonIphone(),ucmpAesConfig.getSecret()));
                } catch (Exception e) {
                	LOGGER.error("====queryUnTransfer手机号解密异常===",e);
                }
              //查询是否有外呼门店记录
                String userData = acquisitionQueryResultDto.getReservationId()+"_"+acquisitionQueryResultDto.getMakeOrderPersonIphone();
                int count = this.inquiryQuotingDao.countRecord(userData);
                if(count == 0){
                	acquisitionQueryResultDto.setIsCallStore(false);
        		}else{
        			acquisitionQueryResultDto.setIsCallStore(true);
        		}
            }
        }
        return new PageInfo<>(acquisitionQueryResultDtos);
    }

    @Override
    public PageInfo<AcquisitionQueryResultDto> QueryCompleted(AcquisitionQueryParamDto pageDto) {
        PageHelper.startPage(pageDto.getPageNum(), pageDto.getPageSize());
        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
        List<String> status = new ArrayList<>();
        //已完成
        status.add(Constants.inquiryStatus.Acquired.value());
        List<AcquisitionQueryResultDto> acquisitionQueryResultDtos = acquisitionFollowDao.newQueryAcquisitionFollow(status, user.getOrganId(), user.getPartyId(), pageDto.getBusinessOrderNo());
        //客户手机号解密
        if (CollectionUtils.isNotEmpty(acquisitionQueryResultDtos)){
            for (AcquisitionQueryResultDto acquisitionQueryResultDto : acquisitionQueryResultDtos) {
                //密文手机号
                acquisitionQueryResultDto.setEnCustomerIphone(acquisitionQueryResultDto.getCustomerIphone());
                acquisitionQueryResultDto.setEnMakeOrderPersonIphone(acquisitionQueryResultDto.getMakeOrderPersonIphone());
                try {
                    acquisitionQueryResultDto.setCustomerIphone(AesUtils.decryptHex(acquisitionQueryResultDto.getCustomerIphone(),ucmpAesConfig.getSecret()));
                    acquisitionQueryResultDto.setMakeOrderPersonIphone(AesUtils.decryptHex(acquisitionQueryResultDto.getEnMakeOrderPersonIphone(),ucmpAesConfig.getSecret()));
                } catch (Exception e) {
                	LOGGER.error("====QueryCompleted手机号解密异常===",e);
                }
              //查询是否有外呼门店记录
                String userData = acquisitionQueryResultDto.getReservationId()+"_"+acquisitionQueryResultDto.getMakeOrderPersonIphone();
                int count = this.inquiryQuotingDao.countRecord(userData);
                if(count == 0){
                	acquisitionQueryResultDto.setIsCallStore(false);
        		}else{
        			acquisitionQueryResultDto.setIsCallStore(true);
        		}
            }
        }
        return new PageInfo<>(acquisitionQueryResultDtos);
    }

    @Override
    public PageInfo<AcquisitionQueryResultDto> QueryReported(AcquisitionQueryParamDto pageDto) {
        PageHelper.startPage(pageDto.getPageNum(), pageDto.getPageSize());
        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
        List<String> status = new ArrayList<>();
        //已上报
        status.add(AcquisitionQueryParamDto.AcquisitionQueryTypeEnum.reported.name());
        List<AcquisitionQueryResultDto> acquisitionQueryResultDtos = acquisitionFollowDao.newQueryAcquisitionFollow(status, user.getOrganId(), user.getPartyId(), pageDto.getBusinessOrderNo());
        //客户手机号解密
        if (CollectionUtils.isNotEmpty(acquisitionQueryResultDtos)){
            for (AcquisitionQueryResultDto acquisitionQueryResultDto : acquisitionQueryResultDtos) {
                //密文手机号
                acquisitionQueryResultDto.setEnCustomerIphone(acquisitionQueryResultDto.getCustomerIphone());
                acquisitionQueryResultDto.setEnMakeOrderPersonIphone(acquisitionQueryResultDto.getMakeOrderPersonIphone());
                try {
                    acquisitionQueryResultDto.setCustomerIphone(AesUtils.decryptHex(acquisitionQueryResultDto.getCustomerIphone(),ucmpAesConfig.getSecret()));
                    acquisitionQueryResultDto.setMakeOrderPersonIphone(AesUtils.decryptHex(acquisitionQueryResultDto.getEnMakeOrderPersonIphone(),ucmpAesConfig.getSecret()));
                } catch (Exception e) {
                	LOGGER.error("====QueryReported手机号解密异常===",e);
                }
              //查询是否有外呼门店记录
                String userData = acquisitionQueryResultDto.getReservationId()+"_"+acquisitionQueryResultDto.getMakeOrderPersonIphone();
                int count = this.inquiryQuotingDao.countRecord(userData);
                if(count == 0){
                	acquisitionQueryResultDto.setIsCallStore(false);
        		}else{
        			acquisitionQueryResultDto.setIsCallStore(true);
        		}
            }
        }
        return new PageInfo<>(acquisitionQueryResultDtos);
    }

    @Override
    public PageInfo<AcquisitionQueryResultDto> QueryClosedOrInvalid(AcquisitionQueryParamDto pageDto) {
        PageHelper.startPage(pageDto.getPageNum(), pageDto.getPageSize());
        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
        List<String> status = new ArrayList<>();
        //关闭/放弃
        status.add(Constants.inquiryStatus.abandonAcquisition.value());
        status.add(Constants.inquiryStatus.overdueUnOffer.value());
        status.add(Constants.inquiryStatus.abandonOffer.value());
        status.add(Constants.inquiryStatus.abandonOrderReceiving.value());
        status.add(Constants.inquiryStatus.laterOffer.value());
        List<AcquisitionQueryResultDto> acquisitionQueryResultDtos = acquisitionFollowDao.newQueryAcquisitionFollow(status, user.getOrganId(), user.getPartyId(), pageDto.getBusinessOrderNo());
        if (CollectionUtils.isNotEmpty(acquisitionQueryResultDtos)){
            for (AcquisitionQueryResultDto resultDto : acquisitionQueryResultDtos) {
                //驳回原因
                if (Objects.nonNull(resultDto.getReservationId())){
                    String rejectedReason = acquisitionFollowDao.queryRejectedReason(resultDto.getReservationId());
                    if(Objects.nonNull(rejectedReason)){
                        resultDto.setRejectedReason(rejectedReason);
                    }
                }
                //密文手机号
                resultDto.setEnCustomerIphone(resultDto.getCustomerIphone());
                resultDto.setEnMakeOrderPersonIphone(resultDto.getMakeOrderPersonIphone());
                try {
                    resultDto.setCustomerIphone(AesUtils.decryptHex(resultDto.getCustomerIphone(),ucmpAesConfig.getSecret()));
                    resultDto.setMakeOrderPersonIphone(AesUtils.decryptHex(resultDto.getEnMakeOrderPersonIphone(),ucmpAesConfig.getSecret()));
                } catch (Exception e) {
                	LOGGER.error("====QueryClosedOrInvalid手机号解密异常===",e);
                }
              //查询是否有外呼门店记录
                String userData = resultDto.getReservationId()+"_"+resultDto.getMakeOrderPersonIphone();
                int count = this.inquiryQuotingDao.countRecord(userData);
                if(count == 0){
                	resultDto.setIsCallStore(false);
        		}else{
        			resultDto.setIsCallStore(true);
        		}
                if ( !resultDto.getInquiryStatus().equals(Constants.inquiryStatus.abandonAcquisition.value())
                || !Constants.approvalStatus.close.value().equals( resultDto.getApprovalStatus() ) ){
                    resultDto.setCustomerIphone(dataMask(resultDto.getCustomerIphone(),3,7,"****"));
                    resultDto.setCustomerName(dataMask(resultDto.getCustomerName(),1,resultDto.getCustomerName().length(),"***"));
                }
            }
        }
        return new PageInfo<>(acquisitionQueryResultDtos);
    }

    @Override
    public Boolean newAbandonAcquisition(Long reservationId, String acquisitionAbandonedReason) throws Exception {
    	//查询置换预约信息
    	PsiCustomerReservationTrackPk psiCustomerReservationTrackPk = new PsiCustomerReservationTrackPk(reservationId);
    	PsiCustomerReservationTrackEntity trackEntity = this.customerReservationTrackDao.load(psiCustomerReservationTrackPk);
    	if(trackEntity != null){
    		Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
    		PsiCarDealerInquiryEntity psiCarDealerInquiryEntity = new PsiCarDealerInquiryEntity();
    		//修改询价表状态
    		if(trackEntity.getBusinessType().equals(Constants.businessType.oneselfBrand.value())){
    			PsiCarDealerInquiryEntity inquiryEntity = new PsiCarDealerInquiryEntity();
    			inquiryEntity.setReservationId(reservationId);
    			List<PsiCarDealerInquiryEntity> list = this.carDealerInquiryDao.selectBySelective(inquiryEntity);
    			psiCarDealerInquiryEntity.setCarDealerId(list.get(0).getCarDealerId());
    			psiCarDealerInquiryEntity.setCarDealerStaffId(list.get(0).getCarDealerStaffId());
    		}else{
    			psiCarDealerInquiryEntity.setCarDealerId(user.getOrganId());
    			psiCarDealerInquiryEntity.setCarDealerStaffId(user.getPartyId());
    		}
    		psiCarDealerInquiryEntity.setReservationId(reservationId);
    		psiCarDealerInquiryEntity.setInquiryStatus(Constants.inquiryStatus.abandonAcquisition.value());
    		psiCarDealerInquiryEntity.setOrderAbandonedReason(acquisitionAbandonedReason);
    		psiCarDealerInquiryEntity.setUpdatedBy(user.getPartyId());
    		psiCarDealerInquiryEntity.setUpdatedDate(new Date());
    		int rows = acquisitionFollowDao.updateInquirySelective(psiCarDealerInquiryEntity);
    		//修改收购状态
    		PsiCarAcquisitionEntity psiCarAcquisitionEntity = new PsiCarAcquisitionEntity();
    		psiCarAcquisitionEntity.setReservationId(reservationId);
    		psiCarAcquisitionEntity.setAcquisitionAbandonedReason(acquisitionAbandonedReason);
    		psiCarAcquisitionEntity.setAcquisitionStatus(Constants.acquisitionStatus.abandonAcquisition.value());
    		psiCarAcquisitionEntity.setUpdatedBy(user.getPartyId());
    		psiCarAcquisitionEntity.setUpdatedDate(new Date());
    		int i = iPsiCarAcquisitionDao.updateSelective(psiCarAcquisitionEntity);
    		//修改预约跟踪表状态
    		PsiCustomerReservationTrackEntity psiCustomerReservationTrackEntity = new PsiCustomerReservationTrackEntity();
    		psiCustomerReservationTrackEntity.setReservationId(reservationId);
    		psiCustomerReservationTrackEntity.setTrackStatus(Constants.trackStatus.noAcquisition.value());
    		psiCustomerReservationTrackEntity.setUpdatedBy(user.getPartyId());
    		psiCustomerReservationTrackEntity.setUpdatedDate(new Date());
    		int i1 = iPsiCustomerReservationTrackDao.updateSelective(psiCustomerReservationTrackEntity);
    		
    		/** start 无车商收购 自动关闭 */
    		ReplaceCluesCloseDto replaceCluesCloseDto = new ReplaceCluesCloseDto();
    		replaceCluesCloseDto.setReservationId(reservationId);
    		replaceCluesCloseDto.setShutDescribe("无车商收购");
    		psiReplaceManageService.updateReplaceClues(replaceCluesCloseDto);
    		/** end 无车商收购 自动关闭 */
    		
    		//本品收购添加接单记录
            if(trackEntity.getBusinessType().equals(Constants.businessType.oneselfBrand.value())){
            	PsiOrderReceivingRecordEntity psiOrderReceivingRecordEntity = new PsiOrderReceivingRecordEntity();
            	psiOrderReceivingRecordEntity.generatePk();
            	psiOrderReceivingRecordEntity.setOperation("放弃收购");
            	psiOrderReceivingRecordEntity.setOrderStatus("战败");
            	psiOrderReceivingRecordEntity.setRecordType("02");
            	psiOrderReceivingRecordEntity.setReason(acquisitionAbandonedReason);
            	psiOrderReceivingRecordEntity.setReservationId(trackEntity.getReservationId());
            	psiOrderReceivingRecordEntity.setOperationBy(user.getPartyId());
            	psiOrderReceivingRecordEntity.setOperationDate(new Date());
            	this.iPsiOrderReceivingRecordDao.insert(psiOrderReceivingRecordEntity);
            }
    		
    		if (rows > 0) {
    			return true;
    		} else {
    			return false;
    		}
    	}else{
    		return false;
    	}
    }

    @Override
    public AcquisitionDetailsDto acquisitionDetails(Long reservationId) {

        //详情对象
        AcquisitionDetailsDto acquisitionDetailsDto = acquisitionFollowDao.acquisitionDetails(reservationId);

        if (Objects.nonNull(acquisitionDetailsDto)){
            //所有文件类型集合
            List<AcquisitionAllFileDto> allFileList = acquisitionFollowDao.acquisitionMaterialList(reservationId);

            if (CollectionUtils.isNotEmpty(allFileList)){

                for (AcquisitionAllFileDto acquisitionAllFileDto : allFileList) {
                    PsiAcquisitionMaterialFileEntity fileEntity = new PsiAcquisitionMaterialFileEntity();
                    fileEntity.setMaterialId(acquisitionAllFileDto.getMaterialId());
                    List<PsiAcquisitionMaterialFileEntity> fileList = materialFileDao.selectBySelective(fileEntity);
                    acquisitionAllFileDto.setMaterialFileEntityList(fileList);
                }
                acquisitionDetailsDto.setFileList(allFileList);
            }
        }
        return acquisitionDetailsDto;
    }

    @Override
    public PageInfo<PsiBusinessNodesMaterialEntity> queryBusinessNodesMaterialEntity(BusinessNodesQueryDto businessNodesQueryDto) {
        PsiBusinessNodesMaterialEntity businessNodesMaterialEntity = new PsiBusinessNodesMaterialEntity();
        List<PsiBusinessNodesMaterialEntity> list = null;
        if (businessNodesQueryDto.getBusinessNodesType().equals(BusinessNodesQueryDto.BusinessNodesQueryTypeEnum.acquisitionMaterial.name())) {
            businessNodesMaterialEntity.setBusinessNodes(Constants.businessNodes.acquisitionMaterial.value());
            list = businessNodesMaterialDao.selectBySelective(businessNodesMaterialEntity);
        }else if (businessNodesQueryDto.getBusinessNodesType().equals(BusinessNodesQueryDto.BusinessNodesQueryTypeEnum.transferMaterial.name())){
            businessNodesMaterialEntity.setBusinessNodes(Constants.businessNodes.transferMaterial.value());
            list = businessNodesMaterialDao.selectBySelective(businessNodesMaterialEntity);
        }else if (businessNodesQueryDto.getBusinessNodesType().equals(BusinessNodesQueryDto.BusinessNodesQueryTypeEnum.approvalRejection.name())){
            businessNodesMaterialEntity.setBusinessNodes(Constants.businessNodes.approvalRejection.value());
            list = businessNodesMaterialDao.selectBySelective(businessNodesMaterialEntity);
        }else if (businessNodesQueryDto.getBusinessNodesType().equals(BusinessNodesQueryDto.BusinessNodesQueryTypeEnum.quotedMaterial.name())){
            businessNodesMaterialEntity.setBusinessNodes(Constants.businessNodes.quotedMaterial.value());
            list = businessNodesMaterialDao.selectBySelective(businessNodesMaterialEntity);
        }
        return new PageInfo<>(list);
    }

    @Override
    public Boolean batchDeleteFile(BatchDeleteFileDto fileDto) {
        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
        List<Long> materialFileIdList = fileDto.getMaterialFileIdList();
        if (CollectionUtils.isNotEmpty(materialFileIdList)){
            for (Long fileId : materialFileIdList) {
                PsiAcquisitionMaterialFileEntity materialFileEntity = new PsiAcquisitionMaterialFileEntity();
                materialFileEntity.setMaterialFileId(fileId);
                int i1 = materialFileDao.deleteBySelective(materialFileEntity);
                SysFileMsgEntity sysFileMsgEntity = new SysFileMsgEntity();
                sysFileMsgEntity.setFileId(fileId);
                sysFileMsgEntity.setFileStatuss(Constants.fileStatus.deleted.value());
                sysFileMsgEntity.setUpdatedBy(user.getPartyId());
                sysFileMsgEntity.setUpdatedDate(new Date());
                int i = sysFileMsgDao.updateSelective(sysFileMsgEntity);
                if (i<0){
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public Long savaMaterials(MaterialParamDto paramDto) {

        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
        //材料表插入
        PsiAcquisitionMaterialEntity materialEntity = new PsiAcquisitionMaterialEntity();
        long materialId = RandomIDGennerator.get().generate();

        PsiAcquisitionMaterialEntity query = new PsiAcquisitionMaterialEntity();
        query.setMaterialType(paramDto.getMaterialType());
        query.setReservationId(paramDto.getReservationId());
        List<PsiAcquisitionMaterialEntity> mList = materialDao.selectBySelective(query);
        if (mList.size() == 0 ){
            materialEntity.setMaterialId(materialId);
            materialEntity.setMaterialType(paramDto.getMaterialType());
            materialEntity.setReservationId(paramDto.getReservationId());
            materialEntity.setUploadDate(new Date());
            materialEntity.setUploadPerson(user.getPartyId());
            materialDao.insert(materialEntity);
        }else {
            PsiAcquisitionMaterialEntity update = new PsiAcquisitionMaterialEntity();
            update.setMaterialType(paramDto.getMaterialType());
            update.setUploadPerson(update.getUploadPerson());
            update.setUploadDate(new Date());
            update.setMaterialId(mList.get(0).getMaterialId());
            materialDao.updateSelective(update);
        }

        //写入文件材料表
        PsiAcquisitionMaterialFileEntity fileEntity = new PsiAcquisitionMaterialFileEntity();
        Long fileId = RandomIDGennerator.get().generate();
        fileEntity.setMaterialFileId(fileId);
        fileEntity.setMaterialId(materialId);
        if (mList.size()>0){
            fileEntity.setMaterialId(mList.get(0).getMaterialId());
        }
        fileEntity.setThumbnail(paramDto.getThumbnailFile());
        fileEntity.setMaterialOrder(paramDto.getMaterialOrder());
        fileEntity.setUploadPerson(user.getPartyId());
        fileEntity.setUploadDate(new Date());
        materialFileDao.insert(fileEntity);

        //写入文件底表
        SysFileMsgEntity sysFileMsgEntity = new SysFileMsgEntity();
        sysFileMsgEntity.setFileId(fileId);
        sysFileMsgEntity.setFilePath(paramDto.getObjKey());
        sysFileMsgEntity.setFileStatuss(Constants.fileStatus.used.value());
        sysFileMsgEntity.setFileName(paramDto.getOriginalFilename());
        sysFileMsgEntity.setFileType(paramDto.getContentType());
        sysFileMsgEntity.setCreatedBy(user.getPartyId());
        sysFileMsgEntity.setCreatedDate(new Date());
        sysFileMsgEntity.setUpdatedDate(new Date());
        sysFileMsgEntity.setUpdatedBy(user.getPartyId());
        sysFileMsgDao.insert(sysFileMsgEntity);

        return fileId;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean saveAcquisitionMaterial(AcquisitionMaterialUploadDto materialUploadDto) {
        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();

        //首次上报修改信息
        if (materialUploadDto.getBusinessNodes().equals(Constants.businessNodes.acquisitionMaterial.value())){

            //更新车辆信息到客户车辆表
            PsiCustomerCarsEntity customerCarsEntity = new PsiCustomerCarsEntity();
            BeanUtils.copyProperties(materialUploadDto,customerCarsEntity);
            customerCarsEntity.setDrivingMileage(materialUploadDto.getDrivingMileage().toString());
            customerCarsEntity.setUpdatedBy(user.getPartyId());
            customerCarsEntity.setUpdatedDate(new Date());
            iPsiCustomerCarsDao.updateSelective(customerCarsEntity);

            //更新询价车辆表
            PsiInquiryCarsEntity inquiryCarsEntity = new PsiInquiryCarsEntity();
            BeanUtils.copyProperties(materialUploadDto,inquiryCarsEntity);
            inquiryCarsEntity.setUpdatedBy(user.getPartyId());
            inquiryCarsEntity.setUpdatedDate(new Date());
            iPsiInquiryCarsDao.updateSelective(inquiryCarsEntity);

            //更改车商询价表
            PsiCarDealerInquiryEntity carDealerInquiryEntity = new PsiCarDealerInquiryEntity();
            PsiCarAcquisitionEntity carAcquisitionEntity = new PsiCarAcquisitionEntity();

            carDealerInquiryEntity.setInquiryId(materialUploadDto.getInquiryId());
            carDealerInquiryEntity.setUploadFileTime(new Date());
            if (Objects.nonNull(materialUploadDto.getEstimatedTransferTime())){
                carDealerInquiryEntity.setEstimatedTransferTime(materialUploadDto.getEstimatedTransferTime());
                carAcquisitionEntity.setEstimatedTransferTime(materialUploadDto.getEstimatedTransferTime());
            }
            carDealerInquiryEntity.setDealPriceEnd(materialUploadDto.getDealPriceEnd());
            carDealerInquiryEntity.setUpdatedBy(user.getPartyId());
            carDealerInquiryEntity.setUpdatedDate(new Date());
            carDealerInquiryDao.updateSelective(carDealerInquiryEntity);

            //保存收购信息到车辆收购表
            carAcquisitionEntity.setMaterialStatus(Constants.materialStatus.notUpload.value());
            carAcquisitionEntity.setReservationId(materialUploadDto.getReservationId());
            carAcquisitionEntity.setInvoiceNum(materialUploadDto.getInvoiceNum());
            carAcquisitionEntity.setDealPriceEnd(materialUploadDto.getDealPriceEnd());
            iPsiCarAcquisitionDao.updateSelective(carAcquisitionEntity);

        }

        //交易上报
        if (AcquisitionMaterialUploadDto.uploadActionTypeEnum.report.name().equals(materialUploadDto.getUploadAction())){

            //判断是否有新车订单
            PsiNewCarOrderEntity newCarOrderEntity = new PsiNewCarOrderEntity();
            newCarOrderEntity.setReservationId(materialUploadDto.getReservationId());
            int count = newCarOrderDao.selectBySelectiveCount(newCarOrderEntity);

            //首次
            if (materialUploadDto.getBusinessNodes().equals(Constants.businessNodes.acquisitionMaterial.value())){

                //更新客户跟踪表信息
                PsiCustomerReservationTrackEntity customerReservationTrackEntity = new PsiCustomerReservationTrackEntity();
                customerReservationTrackEntity.setReservationId(materialUploadDto.getReservationId());
                customerReservationTrackEntity.setDealPriceEnd(materialUploadDto.getDealPriceEnd());
                customerReservationTrackEntity.setUpdatedDate(new Date());
                customerReservationTrackEntity.setUpdatedBy(user.getPartyId());
                customerReservationTrackDao.updateSelective(customerReservationTrackEntity);

                //修改询价表状态 为待过户
                PsiCarDealerInquiryEntity unTransferStatus = new PsiCarDealerInquiryEntity();
                unTransferStatus.setInquiryId(materialUploadDto.getInquiryId());
                unTransferStatus.setInquiryStatus(Constants.inquiryStatus.unTransfer.value());
                //首次上报时间
                unTransferStatus.setFirstEscalationTime(new Date());
                unTransferStatus.setUpdatedDate(new Date());
                unTransferStatus.setUpdatedBy(user.getPartyId());
                carDealerInquiryDao.updateSelective(unTransferStatus);

                //车商首次上传收购材料完成后，需要提醒对应的单号创建人去link新车订单
                //app 消息通知
                MessageParamDto paramDto = new MessageParamDto();
                paramDto.setTemplateId(templateIdConfig.getTemplateTitleSixth());
                paramDto.setOriginalChannel("UCMP");
                paramDto.setReceiverType(0);
                paramDto.setSenderType(0);
                PsiCustomerReservationTrackEntity trackEntity = customerReservationTrackDao.load(new PsiCustomerReservationTrackPk(materialUploadDto.getReservationId()));
                PsiCreateOrderAccountInfoPk infoPk = new PsiCreateOrderAccountInfoPk();
                infoPk.setInfoId(trackEntity.getInfoId());
                PsiCreateOrderAccountInfoEntity load = createOrderAccountInfoDao.load(infoPk);
                List<String> receiverId = new ArrayList<>();
                receiverId.add(load.getUserId().toString());
                paramDto.setReceiverId(receiverId);
                List <String> params = new ArrayList<>();
                //插入业务编号
                RepOrderNeedDto dto = acquisitionFollowDao.queryReplacementOrderInfo(materialUploadDto.getReservationId());
                if (Objects.nonNull(dto)){
                    params.add(dto.getBusinessOrderNo());
                }
                String uid = messagePushService.selectUid(trackEntity);
                params.add(uid);
                paramDto.setParams(params);
                GiveMessageParamDto giveMessageParamDto = Copiers.beanToBean(paramDto, MessageParamDto.class,GiveMessageParamDto.class);
                giveMessageParamDto.setReceiverId(receiverId.get(0));
                systemConsumer.giveMessage(giveMessageParamDto);

                //所需信息
                RepOrderNeedDto needDto = acquisitionFollowDao.queryReplacementOrderInfo(materialUploadDto.getReservationId());

                //短信信息
                //接收人
                List<String> carSupervisorList = acquisitionFollowDao.queryUsedCarSupervisor(trackEntity.getStoreId());
                if (CollectionUtils.isNotEmpty(carSupervisorList)){
                    for (String carSupervisor : carSupervisorList) {

                        SmsParamsDto smsParamsDto = new SmsParamsDto();
                        smsParamsDto.setTemplateId(Constants.sendMessage.sendMessageFourteenth.value());
                        //查询检测时间、地点
                        PsiCustomerReservationMsgEntity load1 = customerReservationMsgDao.load(new PsiCustomerReservationMsgPk(materialUploadDto.getReservationId()));
                        //查询制单人角色
                        String personRole = "" ;
                        SysDatadictEntity find = new SysDatadictEntity();
                        find.setDictTag("19");
                        find.setDictCode(needDto.getMakeOrderPersonRole());
                        SysDatadictEntity query = sysDatadictDao.selectBySelective(find).get(0);
                        if (Objects.nonNull(query)){
                            String dictValue = query.getDictValue();
                            if (Objects.nonNull(dictValue)){
                                personRole = dictValue;
                            }
                        }
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                        String format = formatter.format(load1.getReservationDetectionDate());
                        String[] s = format.split(" ");
                        try {
                            //制单人手机号解密
                            needDto.setMakeOrderPersonIphone(AesUtils.decryptHex(needDto.getMakeOrderPersonIphone(),ucmpAesConfig.getSecret()));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        smsParamsDto.setTemplateParas(new String[]{
                                needDto.getBusinessOrderNo(),
                                needDto.getStoreName(),
                                needDto.getMakeOrderPersonName(),
                                personRole,
                                needDto.getMakeOrderPersonIphone(),
                                s[0],s[1],
                                load1.getReservationDetectionAddress()
                        });
                        //二手车主管手机号解密
                        try {
                            carSupervisor = AesUtils.decryptHex(carSupervisor,ucmpAesConfig.getSecret());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        smsParamsDto.setTo(carSupervisor);
                        systemConsumer.batchSendSms(smsParamsDto);

                        //插入信息表
                        PsiMessageInfoEntity messageInfoEntity =new PsiMessageInfoEntity();
                        messageInfoEntity.setMessageType(Constants.MessageType.Sms.value());
                        messageInfoEntity.setReservationId(materialUploadDto.getReservationId());
                        messageInfoEntity.setTemplateId(Constants.sendMessage.sendMessageFourteenth.value());
                        messageInfoEntity.setRecipient(AesUtils.encryptHex(carSupervisor,ucmpAesConfig.getSecret()));
                        messagePushService.insertMessage(messageInfoEntity);
                    }
                }

//              //创建评价单
                CreateEvaluationDto evaluationDto = new CreateEvaluationDto();
                //业务编号
                evaluationDto.setBusinessNo(needDto.getBusinessOrderNo());
                //用户编号
                evaluationDto.setUserId(uid);
                //服务单结束时间
                long time = new Date().getTime();
                evaluationDto.setServiceEndTime(String.valueOf(time));
                systemConsumer.createEvaluation(evaluationDto);

                //发送记录
                //消息
                PsiMessageInfoEntity messageInfoEntity = new PsiMessageInfoEntity();
                messageInfoEntity.setMessageType(Constants.MessageType.message.value());
                messageInfoEntity.setReservationId(materialUploadDto.getReservationId());
                messageInfoEntity.setTemplateId(templateIdConfig.getTemplateTitleSixth());
                messageInfoEntity.setRecipient(load.getUserId().toString());
                messagePushService.insertMessage(messageInfoEntity);
            }

            //过户
            if (materialUploadDto.getBusinessNodes().equals(Constants.businessNodes.transferMaterial.value())){

                //生成置换表初始状态
                RepReplacementApprovalEntity repReplacementApprovalEntity = new RepReplacementApprovalEntity();
                Long replacementId = RandomIDGennerator.get().generate();
                repReplacementApprovalEntity.setReplacementId(replacementId);
                repReplacementApprovalEntity.setReportingDateEnd(new Date());
                //置换单所需信息
                RepOrderNeedDto repOrderNeedDto = acquisitionFollowDao.queryReplacementOrderInfo(materialUploadDto.getReservationId());
                if (Objects.nonNull(repOrderNeedDto)){
                    BeanUtils.copyProperties(repOrderNeedDto,repReplacementApprovalEntity);
                }
                //旧车确认状态
                repReplacementApprovalEntity.setOldCarConfirmSign(Constants.oldCarConfirme.unConfirme.value());
                //置换表审批状态
                repReplacementApprovalEntity.setApprovalStatus(Constants.approvalStatus.unConfirmed.value());
                //修改询价表状态 已完成
                PsiCarDealerInquiryEntity acquiredStatus = new PsiCarDealerInquiryEntity();
                acquiredStatus.setInquiryId(materialUploadDto.getInquiryId());
                acquiredStatus.setInquiryStatus(Constants.inquiryStatus.Acquired.value());
                //二次上报时间
                acquiredStatus.setSecondEscalationTime(new Date());
                acquiredStatus.setUpdatedDate(new Date());
                acquiredStatus.setUpdatedBy(user.getPartyId());

                //修改收购状态
                PsiCarAcquisitionEntity transfer = new PsiCarAcquisitionEntity();
                transfer.setReservationId(materialUploadDto.getReservationId());
                transfer.setAcquisitionStatus(Constants.acquisitionStatus.Acquired.value());
                transfer.setMaterialStatus(Constants.materialStatus.uploaded.value());
                transfer.setUpdatedBy(user.getPartyId());
                transfer.setUpdatedDate(new Date());
                //同步审批状态
                acquiredStatus.setApprovalStatus(Constants.approvalStatus.unConfirmed.value());
                transfer.setApprovalStatus(Constants.approvalStatus.unConfirmed.value());
                repReplacementApprovalEntity.setApprovalStatus(Constants.approvalStatus.unConfirmed.value());
                if (count > 0){
                    transfer.setApprovalStatus(Constants.approvalStatus.unApproval.value());
                    acquiredStatus.setApprovalStatus(Constants.approvalStatus.unApproval.value());
                    repReplacementApprovalEntity.setApprovalStatus(Constants.approvalStatus.unApproval.value());
                }
                repReplacementApprovalEntity.setCreatedBy(repOrderNeedDto.getMakeOrderPersonId());
                repReplacementApprovalEntity.setCreatedPersonName(repOrderNeedDto.getMakeOrderPersonName());
                //拿到创建预约单的时间
                PsiCustomerReservationTrackEntity trackEntity1 = customerReservationTrackDao.load(new PsiCustomerReservationTrackPk(materialUploadDto.getReservationId()));
                repReplacementApprovalEntity.setCreatedDate(new Date());
                repReplacementApprovalEntity.setUpdatedDate(new Date());
                if (Objects.nonNull(trackEntity1)){
                    repReplacementApprovalEntity.setCreatedDate(trackEntity1.getCreatedDate());
                    repReplacementApprovalEntity.setUpdatedDate(trackEntity1.getCreatedDate());
                }
                repReplacementApprovalEntity.setUpdatedBy(repOrderNeedDto.getMakeOrderPersonId());
                repReplacementApprovalEntity.setIsDelete("01");
                repReplacementApprovalDao.insert(repReplacementApprovalEntity);
                carDealerInquiryDao.updateSelective(acquiredStatus);
                iPsiCarAcquisitionDao.updateSelective(transfer);

                //插入置换材料表数据
                //查出收购表数据
                PsiAcquisitionMaterialEntity materialEntity = new PsiAcquisitionMaterialEntity();
                materialEntity.setReservationId(materialUploadDto.getReservationId());
                List<PsiAcquisitionMaterialEntity> materialList = materialDao.selectBySelective(materialEntity);
                if (CollectionUtils.isNotEmpty(materialList)){
                    RepReplacementMaterialEntity replacementMaterialEntity = new RepReplacementMaterialEntity();
                    for (PsiAcquisitionMaterialEntity psiAcquisitionMaterialEntity : materialList) {
                        BeanUtils.copyProperties(psiAcquisitionMaterialEntity,replacementMaterialEntity);
                        replacementMaterialEntity.setReplacementId(replacementId);
                        repReplacementMaterialDao.insert(replacementMaterialEntity);
                    }
                    //材料id列表
                    List<Long> collect = materialList.stream().map(PsiAcquisitionMaterialEntity::getMaterialId).collect(Collectors.toList());
                    if (CollectionUtils.isNotEmpty(collect)){
                        for (Long materialId : collect) {
                            RepReplacementMaterialFileEntity file = new RepReplacementMaterialFileEntity();
                            PsiAcquisitionMaterialFileEntity acquisitionMaterialFileEntity = new PsiAcquisitionMaterialFileEntity();
                            acquisitionMaterialFileEntity.setMaterialId(materialId);
                            List<PsiAcquisitionMaterialFileEntity> psiAcquisitionMaterialFileEntities = materialFileDao.selectBySelective(acquisitionMaterialFileEntity);
                            if (CollectionUtils.isNotEmpty(psiAcquisitionMaterialFileEntities)){
                                for (PsiAcquisitionMaterialFileEntity psiAcquisitionMaterialFileEntity : psiAcquisitionMaterialFileEntities) {
                                    if (Objects.nonNull(psiAcquisitionMaterialFileEntity)){
                                        BeanUtils.copyProperties(psiAcquisitionMaterialFileEntity,file);
                                        repReplacementMaterialFileDao.insert(file);
                                    }
                                }
                            }
                        }
                    }
                }
            }

            //驳回
            if (materialUploadDto.getBusinessNodes().equals(Constants.businessNodes.approvalRejection.value())){
                PsiCarDealerInquiryEntity acquiredStatus = new PsiCarDealerInquiryEntity();
                PsiCarAcquisitionEntity rejected = new PsiCarAcquisitionEntity();
                RepReplacementApprovalEntity replace = new RepReplacementApprovalEntity();

                //修改询价表状态 已完成
                acquiredStatus.setInquiryId(materialUploadDto.getInquiryId());
                acquiredStatus.setInquiryStatus(Constants.inquiryStatus.Acquired.value());
                //二次上报时间
                acquiredStatus.setSecondEscalationTime(new Date());
                acquiredStatus.setUpdatedDate(new Date());
                acquiredStatus.setUpdatedBy(user.getPartyId());


                //修改收购状态
                rejected.setReservationId(materialUploadDto.getReservationId());
                rejected.setAcquisitionStatus(Constants.acquisitionStatus.Acquired.value());
                rejected.setMaterialStatus(Constants.materialStatus.uploaded.value());
                rejected.setUpdatedBy(user.getPartyId());
                rejected.setUpdatedDate(new Date());

                //置换审批表
                //查询置换id
                RepReplacementApprovalEntity replacementId = new RepReplacementApprovalEntity();
                replacementId.setReservationId(materialUploadDto.getReservationId());
                Long replacementId1 = repReplacementApprovalDao.selectBySelective(replacementId).get(0).getReplacementId();
                replace.setReplacementId(replacementId1);
                replace.setReportingDateEnd(new Date());
                //同步审批状态
                acquiredStatus.setApprovalStatus(Constants.approvalStatus.unConfirmed.value());
                rejected.setApprovalStatus(Constants.approvalStatus.unConfirmed.value());
                replace.setApprovalStatus(Constants.approvalStatus.unConfirmed.value());
                if (count > 0){
                    rejected.setApprovalStatus(Constants.approvalStatus.unApproval.value());
                    acquiredStatus.setApprovalStatus(Constants.approvalStatus.unApproval.value());
                    replace.setApprovalStatus(Constants.approvalStatus.unApproval.value());
                }
                repReplacementApprovalDao.updateSelective(replace);
                carDealerInquiryDao.updateSelective(acquiredStatus);
                iPsiCarAcquisitionDao.updateSelective(rejected);


                //更新置换表材料
                RepReplacementMaterialEntity select = new RepReplacementMaterialEntity();
                select.setReplacementId(replacementId1);
                List<RepReplacementMaterialEntity> materialList = repReplacementMaterialDao.selectBySelective(select);
                if (CollectionUtils.isNotEmpty(materialList)){
                    List<Long> mIdList = materialList.stream().map(RepReplacementMaterialEntity::getMaterialId).collect(Collectors.toList());
                    for (Long mId : mIdList) {
                        RepReplacementMaterialFileEntity deleteRep = new RepReplacementMaterialFileEntity();
                        deleteRep.setMaterialId(mId);
                        repReplacementMaterialFileDao.deleteBySelective(deleteRep);
                    }
                }
                //删除置换材料文件表
                RepReplacementMaterialEntity delete = new RepReplacementMaterialEntity();
                delete.setReplacementId(replacementId1);
                repReplacementMaterialDao.deleteBySelective(delete);

                //插入置换材料表数据
                //查出收购表数据
                PsiAcquisitionMaterialEntity materialEntity = new PsiAcquisitionMaterialEntity();
                materialEntity.setReservationId(materialUploadDto.getReservationId());
                List<PsiAcquisitionMaterialEntity> materialList1 = materialDao.selectBySelective(materialEntity);
                if (CollectionUtils.isNotEmpty(materialList1)){
                    RepReplacementMaterialEntity replacementMaterialEntity = new RepReplacementMaterialEntity();
                    for (PsiAcquisitionMaterialEntity psiAcquisitionMaterialEntity : materialList1) {
                        BeanUtils.copyProperties(psiAcquisitionMaterialEntity,replacementMaterialEntity);
                        replacementMaterialEntity.setReplacementId(replacementId1);
                        repReplacementMaterialDao.insert(replacementMaterialEntity);
                    }
                    //材料id列表
                    List<Long> collect1 = materialList1.stream().map(PsiAcquisitionMaterialEntity::getMaterialId).collect(Collectors.toList());
                    if (CollectionUtils.isNotEmpty(collect1)){
                        for (Long materialId : collect1) {
                            RepReplacementMaterialFileEntity file = new RepReplacementMaterialFileEntity();
                            PsiAcquisitionMaterialFileEntity acquisitionMaterialFileEntity = new PsiAcquisitionMaterialFileEntity();
                            acquisitionMaterialFileEntity.setMaterialId(materialId);
                            List<PsiAcquisitionMaterialFileEntity> psiAcquisitionMaterialFileEntities = materialFileDao.selectBySelective(acquisitionMaterialFileEntity);
                            if (CollectionUtils.isNotEmpty(psiAcquisitionMaterialFileEntities)){
                                for (PsiAcquisitionMaterialFileEntity psiAcquisitionMaterialFileEntity : psiAcquisitionMaterialFileEntities) {
                                    if (Objects.nonNull(psiAcquisitionMaterialFileEntity)){
                                        BeanUtils.copyProperties(psiAcquisitionMaterialFileEntity,file);
                                        repReplacementMaterialFileDao.insert(file);
                                    }
                                }
                            }
                        }
                    }
                }

            }

        }
        return true;
    }

    @Override
    public String getObjKey(String fileId,String materialId) {
        String objKey = "";
        Long fileMsgId;
        if(StringUtils.isEmpty(fileId)){
        	fileMsgId = this.acquisitionFollowDao.getFileId(Long.parseLong(materialId));
        }else{
        	fileMsgId = Long.parseLong(fileId);
        }
        SysFileMsgEntity fileMsgEntity = sysFileMsgDao.load(new SysFileMsgPk(fileMsgId));
        if (fileMsgEntity != null){
            objKey = fileMsgEntity.getFilePath();
        }
        return objKey;
    }

    @Override
    public Boolean updateInquiryApprovalStatus(Long reservationId, String approvalStatus) {
        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
        PsiCustomerReservationTrackEntity trackEntity = new PsiCustomerReservationTrackEntity();
        PsiCarDealerInquiryEntity carDealerInquiryEntity = new PsiCarDealerInquiryEntity();
        trackEntity.setReservationId(reservationId);
        PsiCustomerReservationTrackEntity customerReservationTrack = customerReservationTrackDao.selectBySelective(trackEntity).get(0);
        if (Objects.nonNull(customerReservationTrack)){
            Long oneselfBrandInquiryId = customerReservationTrack.getOneselfBrandInquiryId();
            Long otherBrandInquiryId = customerReservationTrack.getOtherBrandInquiryId();
            if (Objects.nonNull(oneselfBrandInquiryId)){
                carDealerInquiryEntity.setInquiryId(oneselfBrandInquiryId);
            }
            if (Objects.nonNull(otherBrandInquiryId)){
                carDealerInquiryEntity.setInquiryId(otherBrandInquiryId);
            }
            carDealerInquiryEntity.setUpdatedBy(user.getPartyId());
            carDealerInquiryEntity.setUpdatedDate(new Date());
            carDealerInquiryEntity.setApprovalStatus(approvalStatus);

            //旧车确认通过
            if (approvalStatus.equals(Constants.approvalStatus.confirmed.value())){
                carDealerInquiryEntity.setOldCarConfirmationTime(new Date());
            }
            //审批通过
            if (approvalStatus.equals(Constants.approvalStatus.approval.value())){
                carDealerInquiryEntity.setApprovedTime(new Date());
            }
            //驳回
            if (approvalStatus.equals(Constants.approvalStatus.reject.value())){
                carDealerInquiryEntity.setOverruleTime(new Date());
            }

            int rows = carDealerInquiryDao.updateSelective(carDealerInquiryEntity);
            if (rows > 0){
                return true;
            }
        }
        return false;
    }

    /**
     * 加*操作
     */

    public static String dataMask(String data,int start,int end,String starCount) {
        String res = "";
        if (!StringUtils.isEmpty(data)) {
            StringBuilder stringBuilder = new StringBuilder(data);
            res = stringBuilder.replace(start, end, starCount).toString();
        }
        return res;
    }
    @Override
    public String decryptionPhone(String phone) {
        return AesUtils.encryptHex(phone,ucmpAesConfig.getSecret());
    }

    @Override
    public void updateData() {
        //预约单创建人信息
        List<PsiCreateOrderAccountInfoEntity> createOrderAccountInfoEntities = createOrderAccountInfoDao.selectBySelective(new PsiCreateOrderAccountInfoEntity());
        if (CollectionUtils.isNotEmpty(createOrderAccountInfoEntities)){
            for (PsiCreateOrderAccountInfoEntity entity : createOrderAccountInfoEntities) {
                if (StringUtils.isNotBlank(entity.getPhoneNumber()) && entity.getPhoneNumber().length()==11){
                    entity.setPhoneNumber(AesUtils.encryptHex(entity.getPhoneNumber(),ucmpAesConfig.getSecret()));
                }
                if (StringUtils.isNotBlank(entity.getSuperiorPhoneNumber()) && entity.getSuperiorPhoneNumber().length()==11){
                    entity.setSuperiorPhoneNumber(AesUtils.encryptHex(entity.getSuperiorPhoneNumber(),ucmpAesConfig.getSecret()));
                }
                createOrderAccountInfoDao.updateSelective(entity);
            }
        }
        //车商询价表
        List<PsiCarDealerInquiryEntity> psiCarDealerInquiryEntities = carDealerInquiryDao.selectBySelective(new PsiCarDealerInquiryEntity());
        if (CollectionUtils.isNotEmpty(psiCarDealerInquiryEntities)){
            for (PsiCarDealerInquiryEntity entity : psiCarDealerInquiryEntities) {
                if (StringUtils.isNotBlank(entity.getCustomerIphone()) && entity.getCustomerIphone().length()==11) {
                    entity.setCustomerIphone(AesUtils.encryptHex(entity.getCustomerIphone(),ucmpAesConfig.getSecret()));
                }
                if (StringUtils.isNotBlank(entity.getMakeOrderPersonIphone()) && entity.getMakeOrderPersonIphone().length()==11) {
                    entity.setMakeOrderPersonIphone(AesUtils.encryptHex(entity.getMakeOrderPersonIphone(),ucmpAesConfig.getSecret()));
                }
                carDealerInquiryDao.updateSelective(entity);
            }
        }
        //客户预约跟踪表
        List<PsiCustomerReservationTrackEntity> psiCustomerReservationTrackEntities = iPsiCustomerReservationTrackDao.selectBySelective(new PsiCustomerReservationTrackEntity());
        if (CollectionUtils.isNotEmpty(psiCustomerReservationTrackEntities)){
            for (PsiCustomerReservationTrackEntity entity : psiCustomerReservationTrackEntities) {
                if (StringUtils.isNotBlank(entity.getMakeOrderPersonIphone()) && entity.getMakeOrderPersonIphone().length()==11) {
                    entity.setMakeOrderPersonIphone(AesUtils.encryptHex(entity.getMakeOrderPersonIphone(),ucmpAesConfig.getSecret()));
                }
                iPsiCustomerReservationTrackDao.updateSelective(entity);
            }
        }
        //客户基本信息表
        List<PsiCustomerBasicInformationEntity> psiCustomerBasicInformationEntities = customerBasicInformationDao.selectBySelective(new PsiCustomerBasicInformationEntity());
        if (CollectionUtils.isNotEmpty(psiCustomerBasicInformationEntities)){
            for (PsiCustomerBasicInformationEntity entity : psiCustomerBasicInformationEntities) {
                if (StringUtils.isNotBlank(entity.getCustomerIphone()) && entity.getCustomerIphone().length()==11) {
                    entity.setCustomerIphone(AesUtils.encryptHex(entity.getCustomerIphone(),ucmpAesConfig.getSecret()));
                }
                customerBasicInformationDao.updateSelective(entity);
            }
        }
        //新车订单表
        List<PsiNewCarOrderEntity> psiNewCarOrderEntities = newCarOrderDao.selectBySelective(new PsiNewCarOrderEntity());
        if (CollectionUtils.isNotEmpty(psiNewCarOrderEntities)){
            for (PsiNewCarOrderEntity entity : psiNewCarOrderEntities) {
                if (StringUtils.isNotBlank(entity.getOwnerPhone()) && entity.getOwnerPhone().length()==11) {
                    entity.setOwnerPhone(AesUtils.encryptHex(entity.getOwnerPhone(),ucmpAesConfig.getSecret()));
                }
                if (StringUtils.isNotBlank(entity.getOwnerCardNo()) && entity.getOwnerCardNo().length()==18) {
                    entity.setOwnerCardNo(AesUtils.encryptHex(entity.getOwnerCardNo(),ucmpAesConfig.getSecret()));
                }
                newCarOrderDao.updateSelective(entity);
            }
        }
        //置换审批表
        List<RepReplacementApprovalEntity> repReplacementApprovalEntities = repReplacementApprovalDao.selectBySelective(new RepReplacementApprovalEntity());
        if (CollectionUtils.isNotEmpty(repReplacementApprovalEntities)){
            for (RepReplacementApprovalEntity entity : repReplacementApprovalEntities) {
                if (StringUtils.isNotBlank(entity.getOldCarCustomerIphone()) && entity.getOldCarCustomerIphone().length()==11) {
                    entity.setOldCarCustomerIphone(AesUtils.encryptHex(entity.getOldCarCustomerIphone(),ucmpAesConfig.getSecret()));
                }
                repReplacementApprovalDao.updateSelective(entity);
            }
        }
    }

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean allotDeliveryCenter(AllotDeliveryCenterDto paramDto) {
		try{
			Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
			//查询需要推送的人员
        	List<String> alias=this.acquisitionFollowDao.queryAlias(Long.parseLong(paramDto.getStoreId()));
        	JPushReqDto jPushReqDto = new JPushReqDto();
        	jPushReqDto.setRelevanceId(paramDto.getReservationId());
        	 //有的交付中心没有交付主管，需要随机分配给某个交付顾问
            if(CollectionUtils.isEmpty(alias)){
            	//查询交付顾问
            	List<OneselfAcquirerDto> oneselfAcquirerDto = this.salesDelivryService.delivryConsultantList(Long.parseLong(paramDto.getStoreId()),null,null);
            	Random random = new Random();
            	int r=random.nextInt(oneselfAcquirerDto.size());
            	paramDto.setDeliveryPerson(oneselfAcquirerDto.get(r).getPartyId());
            	String[] alias1={oneselfAcquirerDto.get(r).getIdmAccountName()};
            	jPushReqDto.setAlias(alias1);
            	jPushReqDto.setjPushtemplateId(Constants.jPushtemplateId.JPUSHSECOND.value());
            }else{
            	//总部分配本品收购订单
            	jPushReqDto.setAlias(alias.toArray(new String[alias.size()]));
            	jPushReqDto.setjPushtemplateId(Constants.jPushtemplateId.JPUSHFIRST.value());
            }
            
            
			paramDto.setUpdateBy(user.getPartyId());
			//修改询价表的状态
			int count = this.acquisitionFollowDao.allotDeliveryCenter(paramDto);
			
			PsiCarAcquisitionEntity psiCarAcquisitionEntity = new PsiCarAcquisitionEntity();
			
			PsiCustomerReservationTrackPk psiCustomerReservationTrackPk = new PsiCustomerReservationTrackPk(paramDto.getReservationId());
			PsiCustomerReservationTrackEntity psiCustomerReservationTrackEntities = iPsiCustomerReservationTrackDao.load(psiCustomerReservationTrackPk);
			
			psiCarAcquisitionEntity.setReservationId(paramDto.getReservationId());
			if (psiCustomerReservationTrackEntities.getOneselfBrandInquiryId() != null) {
				psiCarAcquisitionEntity.setOneselfBrandInquiryid(psiCustomerReservationTrackEntities.getOneselfBrandInquiryId());
			}
			psiCarAcquisitionEntity.setCustomerIntention(psiCustomerReservationTrackEntities.getCustomerIntention());
			psiCarAcquisitionEntity.setEstimateDealPrice(psiCustomerReservationTrackEntities.getEstimateDealPrice());
			if (psiCustomerReservationTrackEntities.getDealPriceEnd() != null) {
				psiCarAcquisitionEntity.setDealPriceEnd(psiCustomerReservationTrackEntities.getDealPriceEnd());
			}
			psiCarAcquisitionEntity.setMaterialStatus(Constants.materialStatus.notUpload.value());
			
			psiCarAcquisitionEntity.setAcquisitionStatus(Constants.acquisitionStatus.toBeAllocated.value());
			psiCarAcquisitionEntity.setCreatedBy(AuthContext.getInstance(Person.class).getCurrentUser().getPartyId());
			psiCarAcquisitionEntity.setUpdatedBy(psiCarAcquisitionEntity.getCreatedBy());
			iPsiCarAcquisitionDao.insertSelective(psiCarAcquisitionEntity);
			
			//修改预约表状态
			this.acquisitionFollowDao.updateTrackStatus(paramDto.getReservationId());
			
			//本品收购添加操作记录
			PsiOrderReceivingRecordEntity psiOrderReceivingRecordEntity = new PsiOrderReceivingRecordEntity();
        	psiOrderReceivingRecordEntity.generatePk();
        	psiOrderReceivingRecordEntity.setOperation("收购订单分配");
        	psiOrderReceivingRecordEntity.setOrderStatus("待收购");
        	psiOrderReceivingRecordEntity.setRecordType("03");
        	psiOrderReceivingRecordEntity.setReservationId(paramDto.getReservationId());
        	psiOrderReceivingRecordEntity.setOperationBy(user.getPartyId());
        	psiOrderReceivingRecordEntity.setOperationDate(new Date());
        	this.iPsiOrderReceivingRecordDao.insert(psiOrderReceivingRecordEntity);
        	
        	//推送消息
        	jPushReqDto.setParams(psiCustomerReservationTrackEntities.getBusinessOrderNo());
        	jPushService.sendJPush(jPushReqDto);
			if(count==1){
				return true;
			}else{
				return false;
			}
		}catch (Exception e) {
			LOGGER.error("===分配交付中心异常===",e);
			return false;
		}
	}
}
