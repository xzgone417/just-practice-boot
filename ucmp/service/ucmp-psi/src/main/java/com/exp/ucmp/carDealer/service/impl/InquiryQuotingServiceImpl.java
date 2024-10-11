package com.exp.ucmp.carDealer.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.alibaba.cloud.commons.lang.StringUtils;
import com.egrid.core.shiro.context.AuthContext;
import com.egrid.core.util.JsonBeanUtil;
import com.egrid.core.web.response.RestResponse;
import com.exp.ucmp.PageDto;
import com.exp.ucmp.carDealer.dao.AcquisitionFollowDao;
import com.exp.ucmp.carDealer.dao.InquiryQuotingDao;
import com.exp.ucmp.carDealer.dao.InquiryReceivingDao;
import com.exp.ucmp.carDealer.dto.*;
import com.exp.ucmp.carDealer.service.InquiryQuotingService;
import com.exp.ucmp.carDealer.service.MessagePushService;
import com.exp.ucmp.config.UcmpAesConfig;
import com.exp.ucmp.constant.Constants;
import com.exp.ucmp.consumer.ISystemConsumer;
import com.exp.ucmp.dao.*;
import com.exp.ucmp.entity.*;
import com.exp.ucmp.huawei.dto.SmsParamsDto;
import com.exp.ucmp.model.Person;
import com.exp.ucmp.pk.PsiCustomerReservationMsgPk;
import com.exp.ucmp.pk.PsiCustomerReservationTrackPk;
import com.exp.ucmp.pk.SysPartnerDetailsPk;
import com.exp.ucmp.storeApp.dto.CustomerOperationDto;
import com.exp.ucmp.storeApp.dto.ReplaceCluesCloseDto;
import com.exp.ucmp.storeApp.properties.UcmpTestProperties;
import com.exp.ucmp.storeApp.service.PsiReplaceManageService;
import com.exp.ucmp.util.AesUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class InquiryQuotingServiceImpl implements InquiryQuotingService {

    /**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(InquiryQuotingServiceImpl.class);
    
    @Autowired
    UcmpTestProperties ucmpTestProperties;

    @Autowired
    private InquiryQuotingDao inquiryQuotingDao;

    @Autowired
    private IPsiCarDealerInquiryDao psiCarDealerInquiryDao;

    @Autowired
    private IPsiCustomerReservationTrackDao psiCustomerReservationTrackDao;

    @Autowired
    private IPsiInquiryCarsDao psiInquiryCarsDao;

    @Autowired
    private IPsiAppraisalRecordDao psiAppraisalRecordDao;

    @Autowired
    private ISystemConsumer systemConsumer;

    @Autowired
    private AcquisitionFollowDao acquisitionFollowDao;

    @Autowired
    private InquiryReceivingDao inquiryReceivingDao;

    @Autowired
    private IPsiCustomerCarsDao iPsiCustomerCarsDao;

    @Autowired
    private ISysPartnerDetailsDao iSysPartnerDetailsDao;

    @Autowired
    private MessagePushService messagePushService;

    @Autowired
    private ISysDatadictDao sysDatadictDao;

    @Autowired
    private IPsiCustomerReservationMsgDao reservationMsgDao;

    @Autowired
    UcmpAesConfig ucmpAesConfig;

    @Autowired
    private IPsiAcquisitionMaterialFileDao materialFileDao;

    @Autowired
    PsiReplaceManageService psiReplaceManageService;
    
    @Autowired
    private IPsiAcquisitionMaterialDao materialDao;
    
    @Autowired
    IPsiOrderReceivingRecordDao iPsiOrderReceivingRecordDao;

    /**
     * 查询已报价的订单
     *
     * @param pageDto
     * @return
     */
    @Override
    public PageInfo<InquiryQuotingResultDto> queryInquiryQuotingByAccept(PageDto pageDto) {
        PageHelper.startPage(pageDto.getPageNum(), pageDto.getPageSize());
        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
        Map<String, Object> params = new HashMap<>();
        if (user.getOrganId() != null) {
            params.put("carDealerId", user.getOrganId());
        }
        params.put("carDealerStaffId", user.getPartyId());
        params.put("status", new String[]{Constants.inquiryStatus.alreadyOffer.value(), Constants.inquiryStatus.unAcquired.value(), Constants.inquiryStatus.unTransfer.value(), Constants.inquiryStatus.Acquired.value(), Constants.inquiryStatus.abandonAcquisition.value()});
        return new PageInfo<>(inquiryQuotingDao.queryInquiryQuoting(params));
    }

    @Override
    public PageInfo<InquiryQuotingResultDto> queryInquiryQuotingByGiveup(PageDto pageDto) {
        PageHelper.startPage(pageDto.getPageNum(), pageDto.getPageSize());
        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
        Map<String, Object> params = new HashMap<>();
        if (user.getOrganId() != null) {
            params.put("carDealerId", user.getOrganId());
        }
        params.put("carDealerStaffId", user.getPartyId());
        params.put("status", new String[]{Constants.inquiryStatus.overdueUnOffer.value(), Constants.inquiryStatus.abandonOffer.value()});
        return new PageInfo<>(inquiryQuotingDao.queryInquiryQuoting(params));
    }

    @Override
    public PageInfo<InquiryQuotingResultDto> queryInquiryQuotingByAwait(PageDto pageDto) {
        PageHelper.startPage(pageDto.getPageNum(), pageDto.getPageSize());
        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
        Map<String, Object> params = new HashMap<>();
        if (user.getOrganId() != null) {
            params.put("carDealerId", user.getOrganId());
        }
        params.put("carDealerStaffId", user.getPartyId());
        params.put("status", new String[]{Constants.inquiryStatus.unOffer.value()});
        return new PageInfo<>(inquiryQuotingDao.queryInquiryQuoting(params));
    }

    @Override
    public PageInfo<InquiryQuotingResultDto> queryInquiryQuotingAccept(QuotingQueryParamDto paramDto) {
        PageHelper.startPage(paramDto.getPageNum(), paramDto.getPageSize());
        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
        Map<String, Object> params = new HashMap<>();
        if (user.getOrganId() != null) {
            params.put("carDealerId", user.getOrganId());
        }
        params.put("carDealerStaffId", user.getPartyId());
        params.put("customerIntention", Constants.customerIntention.customerRefuse.value());
        params.put("status", new String[]{Constants.inquiryStatus.alreadyOffer.value()});
        params.put("businessOrderNo", paramDto.getBusinessOrderNo());
        List<InquiryQuotingResultDto> resultDtos = inquiryQuotingDao.queryInquiryQuotingAccept(params);
        for (InquiryQuotingResultDto resultDto : resultDtos) {
            //密文手机号
            resultDto.setEnCustomerIphone(resultDto.getCustomerIphone());
            resultDto.setEnMakeOrderPersonIphone(resultDto.getMakeOrderPersonIphone());
            //手机号解密
            try {
                resultDto.setCustomerIphone(AesUtils.decryptHex(resultDto.getCustomerIphone(),ucmpAesConfig.getSecret()));
                resultDto.setMakeOrderPersonIphone(AesUtils.decryptHex(resultDto.getMakeOrderPersonIphone(),ucmpAesConfig.getSecret()));
            } catch (Exception e) {
            	LOGGER.error("====手机号解密异常====",e);
            }
            //查询是否有外呼门店记录
            String userData = resultDto.getReservationId()+"_"+resultDto.getMakeOrderPersonIphone();
            int count = this.inquiryQuotingDao.countRecord(userData);
            if(count == 0){
            	resultDto.setIsCallStore(false);
    		}else{
    			resultDto.setIsCallStore(true);
    		}
            resultDto.setCustomerIphone(dataMask(resultDto.getCustomerIphone(), 3, 7, "****"));
            resultDto.setCustomerName(dataMask(resultDto.getCustomerName(), 1, resultDto.getCustomerName().length(), "***"));
        }
        return new PageInfo<>(resultDtos);
    }

    @Override
    public PageInfo<InquiryQuotingResultDto> queryInquiryQuotingByRefusal(QuotingQueryParamDto paramDto) {
        PageHelper.startPage(paramDto.getPageNum(), paramDto.getPageSize());
        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
        Map<String, Object> params = new HashMap<>();
        if (user.getOrganId() != null) {
            params.put("carDealerId", user.getOrganId());
        }
        params.put("carDealerStaffId", user.getPartyId());
        params.put("customerIntention", Constants.customerIntention.customerRefuse.value());
        params.put("status", new String[]{Constants.inquiryStatus.alreadyOffer.value()});
        params.put("businessOrderNo", paramDto.getBusinessOrderNo());
        List<InquiryQuotingResultDto> inquiryQuotingResultDtos = inquiryQuotingDao.queryInquiryQuote(params);
        for (InquiryQuotingResultDto resultDto : inquiryQuotingResultDtos) {
            //密文手机号
            resultDto.setEnCustomerIphone(resultDto.getCustomerIphone());
            resultDto.setEnMakeOrderPersonIphone(resultDto.getMakeOrderPersonIphone());
            //手机号解密
            try {
                resultDto.setCustomerIphone(AesUtils.decryptHex(resultDto.getCustomerIphone(),ucmpAesConfig.getSecret()));
                resultDto.setMakeOrderPersonIphone(AesUtils.decryptHex(resultDto.getMakeOrderPersonIphone(),ucmpAesConfig.getSecret()));
            } catch (Exception e) {
            	LOGGER.error("=====手机号解密异常=====",e);
            }
            //查询是否有外呼门店记录
            String userData = resultDto.getReservationId()+"_"+resultDto.getMakeOrderPersonIphone();
            int count = this.inquiryQuotingDao.countRecord(userData);
            if(count == 0){
            	resultDto.setIsCallStore(false);
    		}else{
    			resultDto.setIsCallStore(true);
    		}
            resultDto.setCustomerIphone(dataMask(resultDto.getCustomerIphone(), 3, 7, "****"));
            resultDto.setCustomerName(dataMask(resultDto.getCustomerName(), 1, resultDto.getCustomerName().length(), "***"));
        }
        return new PageInfo<>(inquiryQuotingResultDtos);
    }


    @Override
    public PageInfo<InquiryQuotingResultDto> queryInquiryQuotingAwait(QuotingQueryParamDto paramDto) {
        PageHelper.startPage(paramDto.getPageNum(), paramDto.getPageSize());
        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
        Map<String, Object> params = new HashMap<>();
        if (user.getOrganId() != null) {
            params.put("carDealerId", user.getOrganId());
        }
        params.put("carDealerStaffId", user.getPartyId());
        params.put("status", new String[]{Constants.inquiryStatus.unOffer.value(), Constants.inquiryStatus.orderReceiving.value()});
        params.put("businessOrderNo", paramDto.getBusinessOrderNo());
        List<InquiryQuotingResultDto> resultDtos = inquiryQuotingDao.queryInquiryQuote(params);
        for (InquiryQuotingResultDto resultDto : resultDtos) {
            //密文手机号
            resultDto.setEnCustomerIphone(resultDto.getCustomerIphone());
            resultDto.setEnMakeOrderPersonIphone(resultDto.getMakeOrderPersonIphone());
            //手机号解密
            try {
                resultDto.setCustomerIphone(AesUtils.decryptHex(resultDto.getCustomerIphone(),ucmpAesConfig.getSecret()));
                resultDto.setMakeOrderPersonIphone(AesUtils.decryptHex(resultDto.getMakeOrderPersonIphone(),ucmpAesConfig.getSecret()));
            } catch (Exception e) {
                LOGGER.error("===queryInquiryQuotingAwait手机号解密异常===",e);
            }
            //查询是否有外呼门店记录
            String userData = resultDto.getReservationId()+"_"+resultDto.getMakeOrderPersonIphone();
            int count = this.inquiryQuotingDao.countRecord(userData);
            if(count == 0){
            	resultDto.setIsCallStore(false);
    		}else{
    			resultDto.setIsCallStore(true);
    		}
            resultDto.setCustomerIphone(dataMask(resultDto.getCustomerIphone(), 3, 7, "****"));
            resultDto.setCustomerName(dataMask(resultDto.getCustomerName(), 1, resultDto.getCustomerName().length(), "***"));
        }
        return new PageInfo<>(resultDtos);
    }

    @Override
    public PageInfo<InquiryQuotingResultDto> queryInquiryQuotingByAll(QuotingQueryParamDto paramDto) {
        PageHelper.startPage(paramDto.getPageNum(), paramDto.getPageSize());
        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
        Map<String, Object> params = new HashMap<>();
        if (user.getOrganId() != null) {
            params.put("carDealerId", user.getOrganId());
        }
        params.put("carDealerStaffId", user.getPartyId());
        params.put("businessOrderNo", paramDto.getBusinessOrderNo());

        /*查询当前车商人员管辖的所有门店*/
        RestResponse<List<Long>> restResponse = systemConsumer.findStoreByCurrPartnerStaff();
        if (!restResponse.getResult().isEmpty()) {
            /*设置可管辖的门店*/
            params.put("storeIds", restResponse.getResult().toArray(new Long[restResponse.getResult().size()]));
        } else {
            /*该车商人员无管辖门店，不可接单*/
        }
        List<InquiryQuotingResultDto> quotingResult = inquiryQuotingDao.queryInquiryByAll(params);
        for (InquiryQuotingResultDto inquiryQuotingResultDto : quotingResult) {
            //密文手机号
            inquiryQuotingResultDto.setEnCustomerIphone(inquiryQuotingResultDto.getCustomerIphone());
            inquiryQuotingResultDto.setEnMakeOrderPersonIphone(inquiryQuotingResultDto.getMakeOrderPersonIphone());
            //手机号解密
            try {
                inquiryQuotingResultDto.setCustomerIphone(AesUtils.decryptHex(inquiryQuotingResultDto.getCustomerIphone(),ucmpAesConfig.getSecret()));
                inquiryQuotingResultDto.setMakeOrderPersonIphone(AesUtils.decryptHex(inquiryQuotingResultDto.getMakeOrderPersonIphone(),ucmpAesConfig.getSecret()));
            } catch (Exception e) {
            	LOGGER.error("===手机号解密异常===",e);
            }
          //查询是否有外呼门店记录
            String userData = inquiryQuotingResultDto.getReservationId()+"_"+inquiryQuotingResultDto.getMakeOrderPersonIphone();
            int count = this.inquiryQuotingDao.countRecord(userData);
            if(count == 0){
            	inquiryQuotingResultDto.setIsCallStore(false);
    		}else{
    			inquiryQuotingResultDto.setIsCallStore(true);
    		}
            //驳回原因
            String rejectedReason = acquisitionFollowDao.queryRejectedReason(inquiryQuotingResultDto.getReservationId());
            if (Objects.nonNull(rejectedReason)) {
                inquiryQuotingResultDto.setOrderAbandonedReason(rejectedReason);
            }
            String status = inquiryQuotingResultDto.getInquiryStatus();
            if (!status.equals("0922") && !status.equals("0923") && !status.equals("0921")) {
                inquiryQuotingResultDto.setCustomerIphone(dataMask(inquiryQuotingResultDto.getCustomerIphone(), 3, 7, "****"));
                inquiryQuotingResultDto.setCustomerName(dataMask(inquiryQuotingResultDto.getCustomerName(), 1, inquiryQuotingResultDto.getCustomerName().length(), "***"));
            }
        }
        return new PageInfo<>(quotingResult);
    }

    public static void main(String[] args) throws Exception {
		LOGGER.info("====="+AesUtils.decryptHex("0F092C92FD0383247B35F8E288465FBE", "JC3x2hZiNp"));
		LOGGER.info("====="+AesUtils.encryptHex("13783505096", "JC3x2hZiNp"));
	}
    
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean giveupInquiryQuoting(InquiryQuotingDto paramDto) throws Exception {
    	//查询置换预约信息
    	PsiCustomerReservationTrackPk psiCustomerReservationTrackPk = new PsiCustomerReservationTrackPk(paramDto.getReservationId());
    	PsiCustomerReservationTrackEntity trackEntity = this.psiCustomerReservationTrackDao.load(psiCustomerReservationTrackPk);
        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
        if(trackEntity != null){
        	PsiCarDealerInquiryEntity entity = new PsiCarDealerInquiryEntity();
        	if(trackEntity.getBusinessType().equals(Constants.businessType.oneselfBrand.value())){
        		PsiCarDealerInquiryEntity inquiryEntity = new PsiCarDealerInquiryEntity();
    			inquiryEntity.setReservationId(paramDto.getReservationId());
    			List<PsiCarDealerInquiryEntity> list = this.psiCarDealerInquiryDao.selectBySelective(inquiryEntity);
        		entity.setCarDealerId(list.get(0).getCarDealerId());
            	entity.setCarDealerStaffId(list.get(0).getCarDealerStaffId());
        	}else{
        		entity.setCarDealerId(user.getOrganId());
            	entity.setCarDealerStaffId(user.getPartyId());
        	}
        	entity.setInquiryId(paramDto.getInquiryId());
        	entity.setReservationId(paramDto.getReservationId());
        	entity.setInquiryStatus(Constants.inquiryStatus.abandonOffer.value());
        	entity.setUpdatedBy(user.getPartyId());
        	entity.setOrderAbandonedReason(paramDto.getOrderAbandonedReason());
        	entity.setUpdatedDate(new Date());
        	int rows = inquiryQuotingDao.updateQuotingStatus(entity);
        	
        	/**
        	 * 根据预约id查询询价单数量，若已放弃的数量等于询价单数量，更改跟踪单状态
        	 */
        	entity = new PsiCarDealerInquiryEntity();
        	entity.setReservationId(paramDto.getReservationId());
        	int counts = psiCarDealerInquiryDao.selectBySelectiveCount(entity);
        	entity.setInquiryStatus(Constants.inquiryStatus.abandonOffer.value());
        	int giveUpCounts = psiCarDealerInquiryDao.selectBySelectiveCount(entity);
        	if (giveUpCounts == counts) {
        		PsiCustomerReservationTrackEntity trackingEntity = new PsiCustomerReservationTrackEntity();
        		trackingEntity.setReservationId(paramDto.getReservationId());
        		trackingEntity.setUpdatedBy(user.getPartyId());
        		trackingEntity.setUpdatedDate(new Date());
        		trackingEntity.setTrackStatus(Constants.trackStatus.noQuote.value());
        		psiCustomerReservationTrackDao.updateSelective(trackingEntity);
        		
        		/** start 无车商报价 自动关闭 */
        		ReplaceCluesCloseDto replaceCluesCloseDto = new ReplaceCluesCloseDto();
        		replaceCluesCloseDto.setReservationId(paramDto.getReservationId());
        		replaceCluesCloseDto.setShutDescribe("无车商报价");
        		psiReplaceManageService.updateReplaceClues(replaceCluesCloseDto);
        		/** end 无车商报价 自动关闭 */
        		
        	}
        	
        	//本品收购添加接单记录
            if(trackEntity.getBusinessType().equals(Constants.businessType.oneselfBrand.value())){
            	PsiOrderReceivingRecordEntity psiOrderReceivingRecordEntity = new PsiOrderReceivingRecordEntity();
            	psiOrderReceivingRecordEntity.generatePk();
            	psiOrderReceivingRecordEntity.setOperation("放弃报价");
            	psiOrderReceivingRecordEntity.setOrderStatus("战败");
            	psiOrderReceivingRecordEntity.setRecordType("02");
            	psiOrderReceivingRecordEntity.setReason(paramDto.getOrderAbandonedReason());
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
    @Transactional(rollbackFor = Exception.class)
    public void acceptInquiryQuoting(InquiryQuotingAcceptDto paramDto) throws Exception {
        Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
        int sign = 0;
        if(paramDto.getInquiryId() == null || paramDto.getInquiryId() == 0){
        	PsiCarDealerInquiryEntity inquiryEntity = new PsiCarDealerInquiryEntity();
        	inquiryEntity.setReservationId(paramDto.getReservationId());
        	List<PsiCarDealerInquiryEntity> reList=this.psiCarDealerInquiryDao.selectBySelective(inquiryEntity);
        	if(!reList.isEmpty()){
        		paramDto.setInquiryId(reList.get(0).getInquiryId());
        		if(reList.get(0).getInquiryStatus().equals(Constants.inquiryStatus.unAllotDeliveryCenter.value())){
        			sign=1;
        		}
        	}else{
        		throw new Exception("置换单不存在");
        	}
        }
        PsiCustomerReservationTrackEntity trackEntity= this.psiCustomerReservationTrackDao.load(new PsiCustomerReservationTrackPk(paramDto.getReservationId()));
        //修改询价表信息
        PsiCarDealerInquiryEntity entity = new PsiCarDealerInquiryEntity();
        entity.setQuoteEndDate(new Date());
        if(paramDto.getOperationType() == 1){
        	entity.setInquiryStatus(Constants.inquiryStatus.alreadyOffer.value());
        }
        entity.setQuoteEndPrice(paramDto.getQuoteEndPrice());
        entity.setUpdatedBy(user.getPartyId());
        entity.setUpdatedDate(new Date());
        entity.setInquiryId(paramDto.getInquiryId());
        entity.setReservationId(paramDto.getReservationId());
        psiCarDealerInquiryDao.updateSelective(entity);

        //修改客户车辆表信息
        PsiCustomerCarsEntity psiCustomerCarsEntity = new PsiCustomerCarsEntity();
        BeanUtils.copyProperties(paramDto, psiCustomerCarsEntity);
        if(paramDto.getDrivingMileage() !=null){
        	psiCustomerCarsEntity.setDrivingMileage(paramDto.getDrivingMileage().toString());
        }
        if(StringUtils.isNotEmpty(paramDto.getColorName())){
        	psiCustomerCarsEntity.setColor(paramDto.getColorName());
        }
        
        if(StringUtils.isNotEmpty(paramDto.getUsingNatureName())){
        	psiCustomerCarsEntity.setUsingNature(paramDto.getUsingNature());
        }
        psiCustomerCarsEntity.setUpdatedBy(user.getPartyId());
        psiCustomerCarsEntity.setUpdatedDate(new Date());
        psiCustomerCarsEntity.setReservationId(paramDto.getReservationId());
        iPsiCustomerCarsDao.updateSelective(psiCustomerCarsEntity);

        //修改询价车辆表信息
        PsiInquiryCarsEntity psiInquiryCarsEntity = new PsiInquiryCarsEntity();
        BeanUtils.copyProperties(paramDto, psiInquiryCarsEntity);
        if(StringUtils.isNotEmpty(paramDto.getColorName())){
        	psiInquiryCarsEntity.setColor(paramDto.getColorName());
        }
        
        if(StringUtils.isNotEmpty(paramDto.getUsingNatureName())){
        	psiInquiryCarsEntity.setUsingNature(paramDto.getUsingNature());
        }
        psiInquiryCarsEntity.setUpdatedBy(user.getPartyId());
        psiInquiryCarsEntity.setUpdatedDate(new Date());
        psiInquiryCarsEntity.setInquiryId(paramDto.getInquiryId());
        psiInquiryCarsDao.updateSelective(psiInquiryCarsEntity);
        
        int type=0;
        if(trackEntity.getBusinessType().equals(Constants.businessType.oneselfBrand.value())){
        	type=1;
        	if(paramDto.getPicList() != null && !paramDto.getPicList().isEmpty()){
        		//本品收购车辆图片保存
        		List<PsiAcquisitionMaterialEntity> materialEntityList = new ArrayList<>();
        		for (PicDto picDto : paramDto.getPicList()) {
        			PsiAcquisitionMaterialEntity materialEntity = new PsiAcquisitionMaterialEntity();
        			PsiAcquisitionMaterialEntity query = new PsiAcquisitionMaterialEntity();
        			query.setMaterialType(picDto.getMaterialType());
        			query.setReservationId(paramDto.getReservationId());
        			materialDao.deleteBySelective(query);
        			
        			materialEntity.setMaterialId(picDto.getMaterialId());
                    materialEntity.setMaterialType(picDto.getMaterialType());
                    materialEntity.setReservationId(paramDto.getReservationId());
                    materialEntity.setUploadDate(new Date());
                    materialEntity.setUploadPerson(user.getPartyId());
                    materialEntityList.add(materialEntity);
				}
        		materialDao.batchInsert(materialEntityList);
        	}else{
        		//车辆图片为空时删除之前上传的图片
    			PsiAcquisitionMaterialEntity query = new PsiAcquisitionMaterialEntity();
    			query.setMaterialType("9010");
    			query.setReservationId(paramDto.getReservationId());
    			materialDao.deleteBySelective(query);
    			query.setMaterialType("9009");
    			materialDao.deleteBySelective(query);
        	}
        	if(paramDto.getTestReportList() != null && !paramDto.getTestReportList().isEmpty()){
        		//本品收购检测报告保存
        		List<PsiAcquisitionMaterialEntity> materialEntityList = new ArrayList<>();
        		for (PicDto picDto : paramDto.getTestReportList()) {
        			PsiAcquisitionMaterialEntity materialEntity = new PsiAcquisitionMaterialEntity();
        			PsiAcquisitionMaterialEntity query = new PsiAcquisitionMaterialEntity();
        			query.setMaterialType(picDto.getMaterialType());
        			query.setReservationId(paramDto.getReservationId());
        			materialDao.deleteBySelective(query);
        			
        			materialEntity.setMaterialId(picDto.getMaterialId());
                    materialEntity.setMaterialType(picDto.getMaterialType());
                    materialEntity.setReservationId(paramDto.getReservationId());
                    materialEntity.setUploadDate(new Date());
                    materialEntity.setUploadPerson(user.getPartyId());
                    materialEntityList.add(materialEntity);
				}
        		materialDao.batchInsert(materialEntityList);
        	}else{
        		//检测报告为空时删除之前上传的图片
    			PsiAcquisitionMaterialEntity query = new PsiAcquisitionMaterialEntity();
    			query.setMaterialType("9011");
    			query.setReservationId(paramDto.getReservationId());
    			materialDao.deleteBySelective(query);
        	}
        }

        //提交的报价才会有以下逻辑
        if(paramDto.getOperationType() == 1){
        	LOGGER.info("====提交报价===");
        	//插入估价记录表
        	PsiAppraisalRecordEntity psiAppraisalRecordEntity = new PsiAppraisalRecordEntity();
        	BeanUtils.copyProperties(paramDto, psiAppraisalRecordEntity);
        	psiAppraisalRecordEntity.setAppraisalPrice(paramDto.getQuoteEndPrice());
        	psiAppraisalRecordEntity.setAppraisalDate(new Date());
        	psiAppraisalRecordEntity.setAppraisalStaffId(user.getPartyId());
        	psiAppraisalRecordEntity.generatePk();
        	psiAppraisalRecordDao.insertSelective(psiAppraisalRecordEntity);
        	//判断是否修改跟踪表的状态
        	PsiCustomerReservationTrackPk trackPk = new PsiCustomerReservationTrackPk();
        	trackPk.setReservationId(paramDto.getReservationId());
        	PsiCustomerReservationTrackEntity load = psiCustomerReservationTrackDao.load(trackPk);
        	completeInquiryReceiving(load);
        	/** start 报价后 默认客户同意 直接变为待收购 **/
        	CustomerOperationDto customerOperationDto = new CustomerOperationDto();
        	customerOperationDto.setReservationId(paramDto.getReservationId());
        	customerOperationDto.setCustomerIntention(Constants.customerIntention.customerAgrees.value());
        	psiReplaceManageService.customerOperation(customerOperationDto,type);
        	/** end  报价后 默认客户同意 直接变为待收购 **/
        	
        	//本品收购添加接单记录
            if(type == 1){
            	PsiOrderReceivingRecordEntity psiOrderReceivingRecordEntity = new PsiOrderReceivingRecordEntity();
            	psiOrderReceivingRecordEntity.generatePk();
            	psiOrderReceivingRecordEntity.setOperation("评估报价");
            	psiOrderReceivingRecordEntity.setOrderStatus("待分配");
            	psiOrderReceivingRecordEntity.setRecordType("02");
            	psiOrderReceivingRecordEntity.setReservationId(paramDto.getReservationId());
            	psiOrderReceivingRecordEntity.setOperationBy(user.getPartyId());
            	psiOrderReceivingRecordEntity.setOperationDate(new Date());
            	this.iPsiOrderReceivingRecordDao.insert(psiOrderReceivingRecordEntity);
            }
        }else if(sign == 1 && paramDto.getOperationType() == 2){
        	//待分配保存评估价和材料，需更新预约表里的估价
        	PsiCustomerReservationTrackEntity psiCustomerReservationTrackEntity = new PsiCustomerReservationTrackEntity();
        	psiCustomerReservationTrackEntity.setEstimateDealPrice(paramDto.getQuoteEndPrice());
        	psiCustomerReservationTrackEntity.setReservationId(paramDto.getReservationId());
        	psiCustomerReservationTrackEntity.setUpdatedBy(user.getPartyId());
        	psiCustomerReservationTrackEntity.setUpdatedDate(new Date());
        	this.psiCustomerReservationTrackDao.updateSelective(psiCustomerReservationTrackEntity);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public JobHandlerResult quotingDeadline() throws Exception {
        JobHandlerResult result = new JobHandlerResult();
        Map<String, Object> params = new HashMap<>();
        params.put("quoteDeadline", new Date());
        params.put("status", new String[]{Constants.trackStatus.testing.value()});
        /*查询状态是已分配，截止报价时间早于系统当前时间的预约跟踪单*/
        List<PsiCustomerReservationTrackEntity> listTrack = inquiryReceivingDao.selectTrackByDeadlineTime(params);
        if (listTrack.size() > 0) {
            for (PsiCustomerReservationTrackEntity trackEntity : listTrack) {
                /*开始处理每一条预约跟踪单里尚未报价的询价单*/
                Map<String, Object> param = new HashMap<>();
                param.put("reservationId", trackEntity.getReservationId());
                param.put("status", new String[]{Constants.inquiryStatus.unOffer.value(), Constants.inquiryStatus.orderReceiving.value()});
                List<PsiCarDealerInquiryEntity> listInquiry = inquiryQuotingDao.selectByReservationId(param);
                result.addMessasge("预约单[" + trackEntity.getBusinessOrderNo() + "]有" + listInquiry.size() + "条待报价的询价单待处理");
                for (PsiCarDealerInquiryEntity inquiryEntity : listInquiry) {
                    /*过了报价截止时间，默认放弃报价*/
                    inquiryEntity.setInquiryStatus(Constants.inquiryStatus.overdueUnOffer.value());
                    inquiryEntity.setInquiryId(inquiryEntity.getInquiryId());
                    inquiryEntity.setUpdatedDate(new Date());
                    inquiryEntity.setOrderAbandonedReason("逾期未报价");
                    psiCarDealerInquiryDao.updateSelective(inquiryEntity);
                }
                completeInquiryReceiving(trackEntity);
            }
        }
        result.setHandlerCount(listTrack.size());
        return result;
    }

    @Override
    public List<AcquisitionAllFileDto> quotingPics(AcquisitionDetailQueryDto paramDto) {
        List<AcquisitionAllFileDto> acquisitionAllFileDtos = inquiryQuotingDao.quotedMaterialList(paramDto.getReservationId());
        if (CollUtil.isNotEmpty(acquisitionAllFileDtos)){
            for (AcquisitionAllFileDto acquisitionAllFileDto : acquisitionAllFileDtos) {
                PsiAcquisitionMaterialFileEntity fileEntity = new PsiAcquisitionMaterialFileEntity();
                fileEntity.setMaterialId(acquisitionAllFileDto.getMaterialId());
                List<PsiAcquisitionMaterialFileEntity> fileList = materialFileDao.selectBySelective(fileEntity);
                acquisitionAllFileDto.setMaterialFileEntityList(fileList);
            }
        }
        return acquisitionAllFileDtos;
    }

    /**
     * 完成接单的逻辑
     * 如果所有车商都已经有了选择（无论是选择放弃还是接受），那将修改预约跟踪单的状态（如果有车商选择报价，那跟踪状态为已报价）
     *
     * @param trackEntity
     * @throws Exception 
     */
    @Transactional(rollbackFor = Exception.class)
    void completeInquiryReceiving(PsiCustomerReservationTrackEntity trackEntity) throws Exception {
        /*检查指定询价单对应跟踪单所有询价单是否存在待接单的询价单，若没有的话，修改跟踪单状态*/
        Map<String, Integer> mapInquiryStatusCount = new HashMap<>();
        List<InquiryStatusCountDto> list = inquiryReceivingDao.countInquiryByStatus(trackEntity.getReservationId());
        for (InquiryStatusCountDto dto : list) {
            mapInquiryStatusCount.put(dto.getInquiryStatus(), dto.getInquiryStatusCount());
        }

        if (mapInquiryStatusCount.containsKey(Constants.inquiryStatus.unOffer.value()) || mapInquiryStatusCount.containsKey(Constants.inquiryStatus.orderReceiving.value())) {
            /*如果存在未报价的车商，不更新预约跟踪的信息，直接返回*/
            return;
        } else if (mapInquiryStatusCount.containsKey(Constants.inquiryStatus.alreadyOffer.value())) {
            /*存在已报价的车商，预约跟踪的状态变成已报价*/
            //根据预约id查询报价单详情及车辆信息
            List<QuotingDto> quotingDtos = inquiryQuotingDao.quotingById(trackEntity.getReservationId());

            boolean max = true;
            for (QuotingDto quotingDto : quotingDtos) {
                if (max) {
                    //更新跟踪表
                    PsiCustomerReservationTrackEntity psiCustomerReservationTrackEntity = new PsiCustomerReservationTrackEntity();
                    psiCustomerReservationTrackEntity.setReservationId(trackEntity.getReservationId());
                    if (trackEntity.getBusinessType().equals(Constants.businessType.oneselfBrand.value())) {
                        psiCustomerReservationTrackEntity.setOneselfBrandInquiryId(quotingDto.getInquiryId());//本品
                        psiCustomerReservationTrackEntity.setTrackStatus(Constants.trackStatus.testing.value());//状态
                    } else {
                        psiCustomerReservationTrackEntity.setOtherBrandInquiryId(quotingDto.getInquiryId());//他品
                        psiCustomerReservationTrackEntity.setTrackStatus(Constants.trackStatus.quoted.value());//状态
                    }
                    psiCustomerReservationTrackEntity.setEstimateDealPrice(quotingDto.getQuoteEndPrice().longValue());//预计成交价
                    
                    //根据商户id查询商户名称
                    SysPartnerDetailsPk sysPartnerDetailsPk = new SysPartnerDetailsPk();
                    sysPartnerDetailsPk.setPartnerId(quotingDto.getCarDealerId());
                    SysPartnerDetailsEntity entity = iSysPartnerDetailsDao.load(sysPartnerDetailsPk);
                    psiCustomerReservationTrackEntity.setQuoteMerchantsName(entity.getPartnerName());//报价商户名称
                    psiCustomerReservationTrackEntity.setUpdatedDate(new Date());//更新时间
                    psiCustomerReservationTrackDao.updateSelective(psiCustomerReservationTrackEntity);

                    //更新客户车辆表
                    PsiCustomerCarsEntity psiCustomerCarsEntity = new PsiCustomerCarsEntity();
                    BeanUtils.copyProperties(quotingDto, psiCustomerCarsEntity);
                    psiCustomerCarsEntity.setReservationId(quotingDto.getReservationId());
                    iPsiCustomerCarsDao.updateSelective(psiCustomerCarsEntity);

                    /**
                     * 给客户发送最优价短信，先判断是否发过信息，若无，发送信息给客户
                     */
                    //插入消息记录表
                    PsiMessageInfoEntity infoEntity = new PsiMessageInfoEntity();
                    //预约ID
                    infoEntity.setReservationId(trackEntity.getReservationId());
                    //信息类型
                    infoEntity.setMessageType(Constants.MessageType.Sms.value());
                    //模板id
                    infoEntity.setTemplateId(Constants.sendMessage.sendMessageSecond.value());
                    //获取接收人
                    infoEntity.setRecipient(quotingDto.getCustomerIphone());
                    //手机号解密
                    try {
                        quotingDto.setCustomerIphone(AesUtils.decryptHex(quotingDto.getCustomerIphone(),ucmpAesConfig.getSecret()));
                    } catch (Exception e) {
                        LOGGER.error("===手机号解密异常===",e);
                    }


                    if (messagePushService.insertMessage(infoEntity)) {
                        //发送短信
                        SmsParamsDto smsParamsDto = new SmsParamsDto();
                        //模板id
                        smsParamsDto.setTemplateId(Constants.sendMessage.sendMessageSecond.value());
                        //接收人
                        smsParamsDto.setTo(quotingDto.getCustomerIphone());
                        //参数
                        smsParamsDto.setTemplateParas(new String[]{quotingDto.getLicensePlateNum()});
                        LOGGER.info("smsParamsDto========" + JsonBeanUtil.beanToJson(smsParamsDto));
                        systemConsumer.batchSendSms(smsParamsDto);
                    }

                    /**
                     * 给二手车主管发送最优价短信，先判断是否发过信息，若无，发送信息给二手车主管
                     */
                    List<String> strings = acquisitionFollowDao.queryUsedCarSupervisor(trackEntity.getStoreId());
                    if (!strings.isEmpty()) {
                        for (String string : strings) {
                            PsiMessageInfoEntity psiMessageInfoEntity = new PsiMessageInfoEntity();
                            psiMessageInfoEntity.setReservationId(trackEntity.getReservationId());
                            psiMessageInfoEntity.setMessageType(Constants.MessageType.Sms.value());
                            psiMessageInfoEntity.setTemplateId(Constants.sendMessage.sendMessageThirteenth.value());
                            //获取接收人
                            psiMessageInfoEntity.setRecipient(string);
                            if (messagePushService.insertMessage(psiMessageInfoEntity)) {
                                //发送短信
                                SmsParamsDto smsParamsDto = new SmsParamsDto();
                                //模板id
                                smsParamsDto.setTemplateId(Constants.sendMessage.sendMessageThirteenth.value());
                                //接收人
                                RepOrderNeedDto dto = acquisitionFollowDao.queryReplacementOrderInfo(trackEntity.getReservationId());
                                try {
                                    string = AesUtils.decryptHex(string,ucmpAesConfig.getSecret());
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                smsParamsDto.setTo(string);
                                //参数
                                SysDatadictEntity sysDatadictEntity = new SysDatadictEntity();
                                sysDatadictEntity.setDictCode(dto.getMakeOrderPersonRole());
                                List<SysDatadictEntity> select = sysDatadictDao.selectBySelective(sysDatadictEntity);

                                //检测时间和检测地点
                                PsiCustomerReservationMsgPk pk = new PsiCustomerReservationMsgPk();
                                pk.setReservationId(trackEntity.getReservationId());
                                PsiCustomerReservationMsgEntity load = reservationMsgDao.load(pk);
                                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                                String format = formatter.format(load.getReservationDetectionDate());
                                //将时间切片
                                String[] s = format.split(" ");
                                //手机号解密
                                try {
                                    dto.setMakeOrderPersonIphone(AesUtils.decryptHex(dto.getMakeOrderPersonIphone(),ucmpAesConfig.getSecret()));
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                smsParamsDto.setTemplateParas(new String[]{
                                        dto.getBusinessOrderNo(),
                                        String.valueOf(quotingDto.getQuoteEndPrice()),
                                        dto.getStoreName(),
                                        dto.getMakeOrderPersonName(),
                                        select.get(0).getDictValue(),
                                        dto.getMakeOrderPersonIphone(),
                                        s[0], s[1],
                                        load.getReservationDetectionAddress()
                                });
                                systemConsumer.batchSendSms(smsParamsDto);
                            }
                        }
                    }
                    max = false;
                } else {
                    if (quotingDto.getInquiryStatus().equals("0912")) {
                        //更改不是最高价的询价单状态
                        PsiCarDealerInquiryEntity psiCarDealerInquiryEntity = new PsiCarDealerInquiryEntity();
                        psiCarDealerInquiryEntity.setInquiryId(quotingDto.getInquiryId());
                        psiCarDealerInquiryEntity.setInquiryStatus(Constants.inquiryStatus.laterOffer.value());
                        psiCarDealerInquiryEntity.setUpdatedDate(new Date());
                        psiCarDealerInquiryEntity.setOrderAbandonedReason("您的报价不是最优价");
                        psiCarDealerInquiryDao.updateSelective(psiCarDealerInquiryEntity);
                    }
                }

            }

            return;
        } else {
            /*所有车商都放弃报价，预约跟踪的状态变成放弃报价*/
            PsiCustomerReservationTrackEntity trackingEntity = new PsiCustomerReservationTrackEntity();
            trackingEntity.setReservationId(trackEntity.getReservationId());
            trackingEntity.setUpdatedDate(new Date());
            trackingEntity.setTrackStatus(Constants.trackStatus.noQuote.value());
            psiCustomerReservationTrackDao.updateSelective(trackingEntity);

            /** start 无车商报价 自动关闭 */
            ReplaceCluesCloseDto replaceCluesCloseDto = new ReplaceCluesCloseDto();
            replaceCluesCloseDto.setReservationId(trackEntity.getReservationId());
            replaceCluesCloseDto.setShutDescribe("无车商报价");
            psiReplaceManageService.updateReplaceClues(replaceCluesCloseDto);
            /** end 无车商报价 自动关闭 */

            return;
        }
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

