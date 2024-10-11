package com.exp.ucmp.carDealer.service.impl;

import java.text.SimpleDateFormat;
import java.util.*;

import com.alibaba.cloud.commons.lang.StringUtils;
import com.alibaba.nacos.common.utils.CollectionUtils;
import com.egrid.core.copiers.Copiers;
import com.exp.ucmp.carDealer.dto.InquiryQueryParamDto;
import com.exp.ucmp.carDealer.service.MessagePushService;
import com.exp.ucmp.config.TemplateIdConfig;
import com.exp.ucmp.config.UcmpAesConfig;
import com.exp.ucmp.dao.IPsiCreateOrderAccountInfoDao;
import com.exp.ucmp.dao.IPsiCustomerReservationMsgDao;
import com.exp.ucmp.dao.IPsiCustomerReservationTrackDao;
import com.exp.ucmp.dao.IPsiOrderReceivingRecordDao;
import com.exp.ucmp.entity.*;
import com.exp.ucmp.eos.dto.GiveMessageParamDto;
import com.exp.ucmp.eos.dto.MessageParamDto;
import com.exp.ucmp.pk.PsiCreateOrderAccountInfoPk;
import com.exp.ucmp.pk.PsiCustomerReservationMsgPk;
import com.exp.ucmp.pk.PsiCustomerReservationTrackPk;
import com.exp.ucmp.storeApp.dto.CarDealerSignIn;
import com.exp.ucmp.storeApp.dto.ReplaceCluesCloseDto;
import com.exp.ucmp.storeApp.service.PsiReplaceManageService;
import com.exp.ucmp.util.AesUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.egrid.core.shiro.context.AuthContext;
import com.egrid.core.util.JsonBeanUtil;
import com.egrid.core.web.response.RestResponse;
import com.exp.ucmp.PageDto;
import com.exp.ucmp.carDealer.dao.InquiryQuotingDao;
import com.exp.ucmp.carDealer.dao.InquiryReceivingDao;
import com.exp.ucmp.carDealer.dto.InquiryQueryResultDto;
import com.exp.ucmp.carDealer.dto.InquiryStatusCountDto;
import com.exp.ucmp.carDealer.dto.JobHandlerResult;
import com.exp.ucmp.carDealer.service.InquiryReceivingService;
import com.exp.ucmp.constant.Constants;
import com.exp.ucmp.consumer.ISystemConsumer;
import com.exp.ucmp.dao.IPsiCarDealerInquiryDao;
import com.exp.ucmp.model.Person;
import com.exp.ucmp.pertner.dto.SysPartnerStoreDto;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 询价单，和接单有关的操作
 * @author Administrator
 *
 */
@Service
public class InquiryReceivingServiceImpl implements InquiryReceivingService {
	/**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(InquiryReceivingServiceImpl.class);
	
	@Autowired
	private TemplateIdConfig templateIdConfig;
	@Autowired
	private InquiryReceivingDao inquiryReceivingDao;
	@Autowired
	private IPsiCarDealerInquiryDao psiCarDealerInquiryDao;
	@Autowired
	private IPsiCustomerReservationTrackDao psiCustomerReservationTrackDao;
	@Autowired
	private ISystemConsumer systemConsumer;
	@Autowired
	private MessagePushService messagePushService;
	@Autowired
	private IPsiCreateOrderAccountInfoDao psiCreateOrderAccountInfoDao;
	@Autowired
	private IPsiCustomerReservationMsgDao reservationMsgDao;
	@Autowired
	UcmpAesConfig ucmpAesConfig;
	@Autowired
	PsiReplaceManageService psiReplaceManageService;
	
	@Autowired
    private InquiryQuotingDao inquiryQuotingDao;
	
	@Autowired
    IPsiOrderReceivingRecordDao iPsiOrderReceivingRecordDao;

	@Override
	public PageInfo<InquiryQueryResultDto> queryInquiryReceivingByAccept(PageDto pageDto) {
		PageHelper.startPage(pageDto.getPageNum(), pageDto.getPageSize());
		Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
		Map<String, Object> params = new HashMap<>();
		if (user.getOrganId() != null) {
			params.put("carDealerId", user.getOrganId());
		}
		params.put("carDealerStaffId", user.getPartyId());
		params.put("status", new String[]{Constants.inquiryStatus.orderReceiving.value(), Constants.inquiryStatus.unOffer.value(), Constants.inquiryStatus.alreadyOffer.value(), Constants.inquiryStatus.overdueUnOffer.value(), Constants.inquiryStatus.abandonOffer.value()});
		return new PageInfo<>(inquiryReceivingDao.queryInquiryReceivingByComplete(params));
	}
	
	@Override
	public PageInfo<InquiryQueryResultDto> queryInquiryReceivingByGiveup(PageDto pageDto) {
		PageHelper.startPage(pageDto.getPageNum(), pageDto.getPageSize());
		Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
		Map<String, Object> params = new HashMap<>();
		if (user.getOrganId() != null) {
			params.put("carDealerId", user.getOrganId());
		}
		params.put("carDealerStaffId", user.getPartyId());
		params.put("status", new String[]{Constants.inquiryStatus.abandonOrderReceiving.value()});
		return new PageInfo<>(inquiryReceivingDao.queryInquiryReceivingByComplete(params));
	}
	
	@Override
	public PageInfo<InquiryQueryResultDto> queryInquiryReceivingByAwait(InquiryQueryParamDto paramDto) {
		PageHelper.startPage(paramDto.getPageNum(), paramDto.getPageSize());
		Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
		Map<String, Object> params = new HashMap<>();
		if (user.getOrganId() != null) {
			params.put("carDealerId", user.getOrganId());
		}
		/*查询当前车商人员管辖的所有门店*/
		RestResponse<List<Long>> restResponse = systemConsumer.findStoreByCurrPartnerStaff();
		if (!restResponse.getResult().isEmpty()) {
			/*设置可管辖的门店*/
			params.put("storeIds", restResponse.getResult().toArray(new Long[restResponse.getResult().size()]));
			params.put("status", new String[]{Constants.inquiryStatus.unOrderReceiving.value()});
			params.put("businessOrderNo", paramDto.getBusinessOrderNo());
			List<InquiryQueryResultDto> inquiryQueryResultDtos = inquiryReceivingDao.queryInquiryReceivingByAwait(params);
			for (InquiryQueryResultDto resultDto : inquiryQueryResultDtos) {
				//密文手机号
				resultDto.setEnCustomerIphone(resultDto.getCustomerIphone());
				resultDto.setEnMakeOrderPersonIphone(resultDto.getMakeOrderPersonIphone());
				//手机号解密
				try {
					resultDto.setCustomerIphone(AesUtils.decryptHex(resultDto.getCustomerIphone(),ucmpAesConfig.getSecret()));
					resultDto.setMakeOrderPersonIphone(AesUtils.decryptHex(resultDto.getMakeOrderPersonIphone(),ucmpAesConfig.getSecret()));
				} catch (Exception e) {
					LOGGER.error("===queryInquiryReceivingByAwait手机号解密===",e);
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
			return new PageInfo<>(inquiryQueryResultDtos);
		} else {
			/*该车商人员无管辖门店，不可接单*/
			return new PageInfo<>(new ArrayList<>());
		}
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Boolean acceptInquiryReceiving(Long inquiryId, Long reservationId) throws Exception {
		Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
		/*更新指定询价单的车商人员和状态*/
		PsiCarDealerInquiryEntity entity = new PsiCarDealerInquiryEntity();
		/** start 接单后直接触发签到 **/
		CarDealerSignIn carDealerSign = new CarDealerSignIn();
		
		if(inquiryId == null || inquiryId == 0L){
			//本品收购，总部端操作
			PsiCarDealerInquiryEntity psiCarDealerInquiryEntity=new PsiCarDealerInquiryEntity();
			psiCarDealerInquiryEntity.setReservationId(reservationId);
			List<PsiCarDealerInquiryEntity> carDealerInquiryList = this.psiCarDealerInquiryDao.selectBySelective(psiCarDealerInquiryEntity);
			if(CollectionUtils.isNotEmpty(carDealerInquiryList)){
				entity.setInquiryId(carDealerInquiryList.get(0).getInquiryId());
				entity.setCarDealerId(carDealerInquiryList.get(0).getCarDealerId());
				carDealerSign.setCarDealerId(carDealerInquiryList.get(0).getCarDealerId());
			}else{
				return false;
			}
			//本品收购添加接单记录
        	PsiOrderReceivingRecordEntity psiOrderReceivingRecordEntity = new PsiOrderReceivingRecordEntity();
        	psiOrderReceivingRecordEntity.generatePk();
        	psiOrderReceivingRecordEntity.setOperation("接单");
        	psiOrderReceivingRecordEntity.setOrderStatus("待评估");
        	psiOrderReceivingRecordEntity.setRecordType("01");
        	psiOrderReceivingRecordEntity.setReservationId(reservationId);
        	psiOrderReceivingRecordEntity.setOperationBy(user.getPartyId());
        	psiOrderReceivingRecordEntity.setOperationDate(new Date());
        	this.iPsiOrderReceivingRecordDao.insert(psiOrderReceivingRecordEntity);
		}else{
			entity.setInquiryId(inquiryId);
			entity.setCarDealerId(user.getOrganId());
			carDealerSign.setCarDealerId(user.getOrganId());
		}
		entity.setCarDealerStaffId(user.getPartyId());
		entity.setOrderReceivingDate(new Date());
		entity.setInquiryStatus(Constants.inquiryStatus.orderReceiving.value());
		entity.setUpdatedBy(user.getPartyId());
		entity.setUpdatedDate(new Date());
		int rows = inquiryReceivingDao.completeReceiving(entity);

		/*检查指定询价单对应跟踪单所有询价单是否存在待接单的询价单，若没有的话，修改跟踪单状态*/
		completeInquiryReceiving(reservationId);

		carDealerSign.setReservationId(reservationId);
		psiReplaceManageService.updateCarDealerSignIn(carDealerSign);
		/** end **/

		if (rows > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public Boolean giveupInquiryReceiving(Long inquiryId, Long reservationId, String giveupReason) throws Exception {
		Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
		/*更新指定询价单的车商人员和状态*/
		PsiCarDealerInquiryEntity entity = new PsiCarDealerInquiryEntity();
		if(inquiryId == null || inquiryId == 0L){
			//本品收购，总部端操作
			PsiCarDealerInquiryEntity psiCarDealerInquiryEntity=new PsiCarDealerInquiryEntity();
			psiCarDealerInquiryEntity.setReservationId(reservationId);
			List<PsiCarDealerInquiryEntity> carDealerInquiryList = this.psiCarDealerInquiryDao.selectBySelective(psiCarDealerInquiryEntity);
			LOGGER.info("=====本品收购，总部端操作放弃接单查询到的询价单信息====="+JsonBeanUtil.beanToJson(carDealerInquiryList));
			if(CollectionUtils.isNotEmpty(carDealerInquiryList)){
				entity.setInquiryId(carDealerInquiryList.get(0).getInquiryId());
				entity.setCarDealerStaffId(carDealerInquiryList.get(0).getCarDealerStaffId());
				entity.setCarDealerId(carDealerInquiryList.get(0).getCarDealerId());
			}else{
				return false;
			}
			//本品收购添加接单记录
        	PsiOrderReceivingRecordEntity psiOrderReceivingRecordEntity = new PsiOrderReceivingRecordEntity();
        	psiOrderReceivingRecordEntity.generatePk();
        	psiOrderReceivingRecordEntity.setOperation("放弃接单");
        	psiOrderReceivingRecordEntity.setOrderStatus("已关闭");
        	psiOrderReceivingRecordEntity.setRecordType("01");
        	psiOrderReceivingRecordEntity.setReason(giveupReason);
        	psiOrderReceivingRecordEntity.setReservationId(reservationId);
        	psiOrderReceivingRecordEntity.setOperationBy(user.getPartyId());
        	psiOrderReceivingRecordEntity.setOperationDate(new Date());
        	this.iPsiOrderReceivingRecordDao.insert(psiOrderReceivingRecordEntity);
		}else{
			entity.setInquiryId(inquiryId);
			entity.setCarDealerStaffId(user.getPartyId());
			entity.setCarDealerId(user.getOrganId());
		}
		entity.setOrderReceivingDate(new Date());
		entity.setOrderAbandonedReason(giveupReason);
		entity.setInquiryStatus(Constants.inquiryStatus.abandonOrderReceiving.value());
		entity.setUpdatedBy(user.getPartyId());
		entity.setUpdatedDate(new Date());
		LOGGER.info("=====本品收购，总部端操作放弃接单修改询价单信息参数====="+JsonBeanUtil.beanToJson(entity));
		int rows = inquiryReceivingDao.completeReceiving(entity);
		
		/*检查指定询价单对应跟踪单所有询价单是否存在待接单的询价单，若没有的话，修改跟踪单状态*/
		completeInquiryReceiving(reservationId);;
		if (rows > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public JobHandlerResult receivingDeadline() throws Exception {
		JobHandlerResult result = new JobHandlerResult();
		Map<String, List<Long>> mapStaff = new HashMap<>();
		Map<String, Object> params = new HashMap<>();
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
        cal.add(Calendar.HOUR, -240 );
		params.put("receivingDeadline", cal.getTime());
		params.put("status", new String[]{Constants.trackStatus.assigned.value()});
		/*查询状态是已分配，截止接单时间晚于系统当前时间的预约跟踪单*/
		/*查询状态是已分配，已超过截止接单时间10天的预约跟踪单*/
		List<PsiCustomerReservationTrackEntity> listTrack = inquiryReceivingDao.selectTrackByDeadlineTime(params);
		if (!listTrack.isEmpty()) {
			for (PsiCustomerReservationTrackEntity trackEntity : listTrack) {
				/*开始处理每一条预约跟踪单里尚未接单的询价单*/
				PsiCarDealerInquiryEntity psiCarDealerInquiryEntity = new PsiCarDealerInquiryEntity();
				psiCarDealerInquiryEntity.setReservationId(trackEntity.getReservationId());
				psiCarDealerInquiryEntity.setInquiryStatus(Constants.inquiryStatus.unOrderReceiving.value());
				List<PsiCarDealerInquiryEntity> listInquiry = psiCarDealerInquiryDao.selectBySelective(psiCarDealerInquiryEntity);
				result.addMessasge("预约单[" + trackEntity.getBusinessOrderNo() + "]有" + listInquiry.size() + "条待接单的询价单待处理");
				for(PsiCarDealerInquiryEntity inquiryEntity : listInquiry) {
					Long partnerStaff = randomPartnerStaff(mapStaff, inquiryEntity.getStoreId(), inquiryEntity.getCarDealerId());
					/*过了接单截止时间，默认已接单*/
					inquiryEntity.setCarDealerStaffId(partnerStaff);
					inquiryEntity.setCarDealerId(inquiryEntity.getCarDealerId());
					inquiryEntity.setOrderReceivingDate(new Date());
					inquiryEntity.setInquiryStatus(Constants.inquiryStatus.orderReceiving.value());
					inquiryEntity.setUpdatedBy(partnerStaff);
					inquiryEntity.setUpdatedDate(new Date());
					inquiryReceivingDao.completeReceiving(inquiryEntity);

					/** start 接单后直接触发签到 **/
					CarDealerSignIn carDealerSign = new CarDealerSignIn();
					carDealerSign.setCarDealerId(inquiryEntity.getCarDealerId());
					carDealerSign.setReservationId(inquiryEntity.getReservationId());
					psiReplaceManageService.updateCarDealerSignIn(carDealerSign);
					/** end **/
				}
				completeInquiryReceiving(trackEntity.getReservationId());
			}
		}
		result.setHandlerCount(listTrack.size());
		return result;
	}
	
	private Long randomPartnerStaff(Map<String, List<Long>> mapStaff, Long storeId, Long partnerId) {
		String key = new StringBuilder().append(storeId).append("-").append(partnerId).toString();
		List<Long> staffs = null;
		if (mapStaff.containsKey(key)) {
			staffs = mapStaff.get(key);
		} else {
			SysPartnerStoreDto sysPartnerStoreDto = new SysPartnerStoreDto();
			sysPartnerStoreDto.setPartnerId(partnerId);
			sysPartnerStoreDto.setStoreId(storeId);
			RestResponse<List<Long>> restResponse = systemConsumer.findPartnerStaffByStoreByAuto(sysPartnerStoreDto);
//			RestResponse<List<Long>> restResponse = systemConsumer.findPartnerStaffByStore(sysPartnerStoreDto);
//			if (restResponse.getResult() == null  || restResponse.getResult().size() == 0) {
//				/*如果找不到指定门店的管辖车商人员，直接找指定车商的人员*/
//				restResponse = systemConsumer.findPartnerStaff(sysPartnerStoreDto);
//			}
			mapStaff.put(key, restResponse.getResult());
			staffs = restResponse.getResult();
		}
		
		if (staffs.size() > 0) {
//			int randomElementIndex  = ThreadLocalRandom.current().nextInt(staffs.size()) % staffs.size();
//			return staffs.get(randomElementIndex);
			return staffs.get(0);
		} else {
			throw new RuntimeException("车商[" + partnerId + "]必须要有车商人员");
		}
	}
	
	/**
	 * 完成接单的逻辑
	 * 如果所有车商都已经有了选择（无论是选择放弃还是接受），那将修改预约跟踪单的状态（如果有车商选择接单，那跟踪状态为待检测）
	 * 
	 * @param reservationId
	 * @throws Exception 
	 */
	private void completeInquiryReceiving(Long reservationId) throws Exception {
		Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
		/*检查指定询价单对应跟踪单所有询价单是否存在待接单的询价单，若没有的话，修改跟踪单状态*/
		Map<String, Integer> mapInquiryStatusCount = new HashMap<>();
		List<InquiryStatusCountDto> list= inquiryReceivingDao.countInquiryByStatus(reservationId);
		for(InquiryStatusCountDto dto : list) {
			mapInquiryStatusCount.put(dto.getInquiryStatus(), dto.getInquiryStatusCount());
		}
		
		if (mapInquiryStatusCount.containsKey(Constants.inquiryStatus.unOrderReceiving.value())) {
			/*如果存在未接单的车商，不更新预约跟踪的信息，直接返回*/
			return;
		} else if (mapInquiryStatusCount.containsKey(Constants.inquiryStatus.orderReceiving.value())) {
			/*存在已接单的车商，预约跟踪的状态变成待检测*/
			PsiCustomerReservationTrackEntity psiCustomerReservationTrackEntity = new PsiCustomerReservationTrackEntity();
			psiCustomerReservationTrackEntity.setReservationId(reservationId);
			psiCustomerReservationTrackEntity.setTrackStatus(Constants.trackStatus.toBeTested.value());
			psiCustomerReservationTrackEntity.setUpdatedBy(user.getPartyId());
			psiCustomerReservationTrackEntity.setUpdatedDate(new Date());
			psiCustomerReservationTrackDao.updateSelective(psiCustomerReservationTrackEntity);
			//发送消息推送
			messagePush(reservationId,1);
			return;
		}
		/** start 接单完成自动签到，增加判断条件*/
		else if (mapInquiryStatusCount.containsKey(Constants.inquiryStatus.unOffer.value())) {
			/*存在待报价的车商，预约跟踪的状态变成检测中*/
			PsiCustomerReservationTrackEntity psiCustomerReservationTrackEntity = new PsiCustomerReservationTrackEntity();
			psiCustomerReservationTrackEntity.setReservationId(reservationId);
			psiCustomerReservationTrackEntity.setTrackStatus(Constants.trackStatus.testing.value());
			psiCustomerReservationTrackEntity.setUpdatedBy(user.getPartyId());
			psiCustomerReservationTrackEntity.setUpdatedDate(new Date());
			psiCustomerReservationTrackDao.updateSelective(psiCustomerReservationTrackEntity);
			//发送消息推送
			messagePush(reservationId,1);
			return;
		}
		/** end */
		else if (mapInquiryStatusCount.size() == 1 && mapInquiryStatusCount.containsKey(Constants.inquiryStatus.abandonOrderReceiving.value())) {
			/*所有车商都放弃接单，预约跟踪的状态变成放弃接单*/
			PsiCustomerReservationTrackEntity psiCustomerReservationTrackEntity = new PsiCustomerReservationTrackEntity();
			psiCustomerReservationTrackEntity.setReservationId(reservationId);
			psiCustomerReservationTrackEntity.setTrackStatus(Constants.trackStatus.noReceiving.value());
			psiCustomerReservationTrackEntity.setUpdatedBy(user.getPartyId());
			psiCustomerReservationTrackEntity.setUpdatedDate(new Date());
			psiCustomerReservationTrackDao.updateSelective(psiCustomerReservationTrackEntity);

			/** start 无车商接单 自动关闭 */
			ReplaceCluesCloseDto replaceCluesCloseDto = new ReplaceCluesCloseDto();
			replaceCluesCloseDto.setReservationId(reservationId);
			replaceCluesCloseDto.setShutDescribe("无车商接单");
			psiReplaceManageService.updateReplaceClues(replaceCluesCloseDto);
			/** end 无车商接单 自动关闭 */

			//发送消息推送
			messagePush(reservationId,2);
			return;
		}
	}
	public static String dataMask(String data,int start,int end,String starCount) {
		String res = "";
		if (!StringUtils.isEmpty(data)) {
			StringBuilder stringBuilder = new StringBuilder(data);
			res = stringBuilder.replace(start, end, starCount).toString();
		}
		return res;
	}

	//消息推送
	private void messagePush(Long reservationId,int index){
		PsiCustomerReservationTrackPk pk = new PsiCustomerReservationTrackPk();
		pk.setReservationId(reservationId);
		PsiCustomerReservationTrackEntity load = psiCustomerReservationTrackDao.load(pk);
		PsiMessageInfoEntity psiMessageInfoEntity = new PsiMessageInfoEntity();
		//预约ID
		psiMessageInfoEntity.setReservationId(reservationId);
		//信息类型
		psiMessageInfoEntity.setMessageType(Constants.MessageType.message.value());
        //模板id
		if (index==1){
		psiMessageInfoEntity.setTemplateId(templateIdConfig.getTemplateTitleEighth());
		}else if(index==2){
			psiMessageInfoEntity.setTemplateId(templateIdConfig.getTemplateTitleSecond());
		}

		//获取接收人
		PsiCreateOrderAccountInfoPk infoPk = new PsiCreateOrderAccountInfoPk();
		infoPk.setInfoId(load.getInfoId());
		PsiCreateOrderAccountInfoEntity entity = psiCreateOrderAccountInfoDao.load(infoPk);
		psiMessageInfoEntity.setRecipient(String.valueOf(entity.getUserId()));

		if (messagePushService.insertMessage(psiMessageInfoEntity)){
			MessageParamDto messageParamDto = new MessageParamDto();
			//模板id
			if (index==1){
				messageParamDto.setTemplateId(templateIdConfig.getTemplateTitleEighth());
			}else if(index==2) {
				messageParamDto.setTemplateId(templateIdConfig.getTemplateTitleSecond());
			}
			messageParamDto.setOriginalChannel("UCMP");
			messageParamDto.setSenderType(0);
			messageParamDto.setReceiverType(0);
			List<String> strings = new ArrayList<>();
			//获取预约编号
			strings.add(load.getBusinessOrderNo());

			PsiCustomerReservationMsgPk psiCustomerReservationMsgPk = new PsiCustomerReservationMsgPk();
			psiCustomerReservationMsgPk.setReservationId(reservationId);
			if (index==1) {
				PsiCustomerReservationMsgEntity msgEntity = reservationMsgDao.load(psiCustomerReservationMsgPk);
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				String format = formatter.format(msgEntity.getReservationDetectionDate());
				strings.add(format);
				strings.add(msgEntity.getReservationDetectionAddress());
				//获取uid
			}
			strings.add(messagePushService.selectUid(load));
			messageParamDto.setParams(strings);

			messageParamDto.setReceiverId(Arrays.asList(new String[]{String.valueOf(entity.getUserId())}));
			GiveMessageParamDto giveMessageParamDto = Copiers.beanToBean(messageParamDto, MessageParamDto.class,GiveMessageParamDto.class);
			giveMessageParamDto.setReceiverId(entity.getUserId().toString());
			systemConsumer.giveMessage(giveMessageParamDto);
		}

	}
}

