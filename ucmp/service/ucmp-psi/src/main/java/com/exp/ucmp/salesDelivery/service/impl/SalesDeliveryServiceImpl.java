package com.exp.ucmp.salesDelivery.service.impl;

import java.math.BigDecimal;
import java.util.*;

import com.exp.ucmp.dao.IPsiOrderFollowRecordDao;
import com.exp.ucmp.entity.PsiOrderFollowRecordEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.cloud.commons.lang.StringUtils;
import com.egrid.core.shiro.context.AuthContext;
import com.egrid.core.util.JsonBeanUtil;
import com.exp.ucmp.config.HwOBSConfig;
import com.exp.ucmp.config.UcmpAesConfig;
import com.exp.ucmp.constant.Constants;
import com.exp.ucmp.dao.IPsiCarTransferApplyDao;
import com.exp.ucmp.dao.IPsiOrderInfoDao;
import com.exp.ucmp.dao.IPsiSalesOrderMaterialDao;
import com.exp.ucmp.entity.PsiCarTransferApplyEntity;
import com.exp.ucmp.entity.PsiOrderInfoEntity;
import com.exp.ucmp.entity.PsiSalesOrderMaterialEntity;
import com.exp.ucmp.jPush.dto.JPushReqDto;
import com.exp.ucmp.jpush.service.JPushService;
import com.exp.ucmp.model.Person;
import com.exp.ucmp.pk.PsiOrderInfoPk;
import com.exp.ucmp.salesDelivery.dao.SalesDeliveryDao;
import com.exp.ucmp.salesDelivery.dto.DeliveryOrderContractDto;
import com.exp.ucmp.salesDelivery.dto.DeliveryOrderDetailsDto;
import com.exp.ucmp.salesDelivery.dto.DeliveryOrderDto;
import com.exp.ucmp.salesDelivery.dto.DeliveryOrderFinancialDto;
import com.exp.ucmp.salesDelivery.dto.DeliveryOrderParamDto;
import com.exp.ucmp.salesDelivery.dto.DeliveryOrderPicDto;
import com.exp.ucmp.salesDelivery.dto.DeliveryOrderStatisticsDto;
import com.exp.ucmp.salesDelivery.dto.OrderCarTransferDto;
import com.exp.ucmp.salesDelivery.dto.OrderCarTransferInfoDto;
import com.exp.ucmp.salesDelivery.dto.OrderDeliveryProfileDto;
import com.exp.ucmp.salesDelivery.dto.OrderPaymentInfoDto;
import com.exp.ucmp.salesDelivery.dto.OrderPaymentRecordDto;
import com.exp.ucmp.salesDelivery.dto.OrderPdiInfoDto;
import com.exp.ucmp.salesDelivery.service.SalesDelivryService;
import com.exp.ucmp.storeApp.dto.OneselfAcquirerDto;
import com.exp.ucmp.storeApp.dto.OneselfStatisticsDto;
import com.exp.ucmp.transfer.service.TransferApplyService;
import com.exp.ucmp.util.AesUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class SalesDeliveryServiceImpl implements SalesDelivryService{
	
	/**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(SalesDeliveryServiceImpl.class);
	
	@Autowired
	private UcmpAesConfig ucmpAesConfig;
	
	@Autowired
	private SalesDeliveryDao salesDeliveryDao;
	
	@Autowired
	private IPsiSalesOrderMaterialDao iPsiSalesOrderMaterialDao;
	
	@Autowired
	private IPsiCarTransferApplyDao iPsiCarTransferApplyDao;
	
	@Autowired
    private HwOBSConfig hwOBSConfig;
	
	@Autowired
    private TransferApplyService transferApplyService;
	
	@Autowired
	private IPsiOrderInfoDao iPsiOrderInfoDao;
	
	@Autowired
    JPushService jPushService;

	@Autowired
	private IPsiOrderFollowRecordDao orderFollowRecordDao;
	
	@Override
	public PageInfo<DeliveryOrderDto> delivryOrderList(DeliveryOrderParamDto deliveryOrderParamDto) throws Exception {
		PageHelper.startPage(deliveryOrderParamDto.getPageNum(), deliveryOrderParamDto.getPageSize());
		//交付主管查全部门店订单
		if(Constants.smpRole.SH.value().contains(deliveryOrderParamDto.getRoleCode())){
			deliveryOrderParamDto.setIsAll(2);
		}else{
			deliveryOrderParamDto.setIsAll(1);
		}
		if(StringUtils.isNotEmpty(deliveryOrderParamDto.getSearchWord())){
			deliveryOrderParamDto.setCustomerIphone(AesUtils.encryptHex(deliveryOrderParamDto.getSearchWord(), ucmpAesConfig.getSecret()));
			deliveryOrderParamDto.setSearchWord("%"+deliveryOrderParamDto.getSearchWord()+"%");
		}
		LOGGER.info("=====查询门店销售交付订单列表参数====="+JsonBeanUtil.beanToJson(deliveryOrderParamDto));
		List<DeliveryOrderDto> list =this.salesDeliveryDao.delivryOrderList(deliveryOrderParamDto);
		if(!list.isEmpty()){
			for (DeliveryOrderDto deliveryOrderDto : list) {
				deliveryOrderDto.setCustomerName(ucmpAesConfig.dataMask(deliveryOrderDto.getCustomerName(), 1, deliveryOrderDto.getCustomerName().length(), "***"));
				deliveryOrderDto.setCustomerIphone(ucmpAesConfig.dataMask(AesUtils.decryptHex(deliveryOrderDto.getEnCustomerIphone(),ucmpAesConfig.getSecret()),3,7, "****"));
			}
		}
		return  new PageInfo<>(list);
	}

	@Override
	public List<OneselfAcquirerDto> delivryConsultantList(Long storeId, String searchWord, String staffType) throws Exception {
		String phoneNumber=null;
		if(StringUtils.isNotEmpty(searchWord)){
			phoneNumber = AesUtils.encryptHex(searchWord, ucmpAesConfig.getSecret());
		}
		List<String> roleList=null;
		String role = ucmpAesConfig.getDeliveryRole();
		if(StringUtils.isNotEmpty(role)){
			roleList=Arrays.asList(role.split(","));
		}
		LOGGER.info("==searchWord="+searchWord+"=role="+role);
		List<OneselfAcquirerDto> list =this.salesDeliveryDao.delivryConsultantList(storeId,searchWord,phoneNumber,roleList);
		if(!list.isEmpty()){
			for (OneselfAcquirerDto oneselfAcquirerDto : list) {
				oneselfAcquirerDto.setUndone(this.salesDeliveryDao.countUndoneNum(oneselfAcquirerDto));
				oneselfAcquirerDto.setConsultantTel(AesUtils.decryptHex(oneselfAcquirerDto.getConsultantTel(),ucmpAesConfig.getSecret()));
			}
		}
		return list;
	}

	@Override
	@Transactional
	public int allotDelivryConsultant(Long orderInfoId, Long partyId, Long storeId) {
		Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
		int isAll=1;
		if(storeId !=null){
			isAll =3;
		}
		//查询订单所属交付中心是否存在该顾问
		int check = this.salesDeliveryDao.checkConsultant(orderInfoId,partyId,storeId);
		if(check == 0){
			return 1;
		}
		//查询订单是否处于待分配状态
		/*check = this.salesDeliveryDao.checkOrderStatus(orderInfoId);
		if(check == 0){
			return 2;
		}*/
		//查询销售订单详情
		DeliveryOrderDetailsDto dto = this.salesDeliveryDao.orderDetails(orderInfoId,user.getPartyId(),isAll,user.getOrganId());
		//更新订单表信息
		 this.salesDeliveryDao.updateOrderInfo(orderInfoId,partyId,user.getPartyId(),dto.getStatus(),isAll,storeId);
		 
		//推送消息
     	//查询需要推送的人员
     	List<String> alias=this.salesDeliveryDao.queryAlias(partyId);
     	//查询订单号
     	String orderNum=this.salesDeliveryDao.queryOrderNum(orderInfoId);
     	JPushReqDto jPushReqDto = new JPushReqDto();
     	jPushReqDto.setAlias(alias.toArray(new String[alias.size()]));
     	jPushReqDto.setjPushtemplateId(Constants.jPushtemplateId.JPUSHSEVEN.value());
     	jPushReqDto.setRelevanceId(orderInfoId);
     	jPushReqDto.setParams(orderNum);
     	jPushService.sendJPush(jPushReqDto);
		return 0;
	}

	@Override
	public DeliveryOrderDetailsDto orderDetails(Long orderInfoId, String roleCode) throws Exception {
		Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
		Integer isAll = null;
		if(roleCode.equals(Constants.smpRole.SH.value())){
			isAll=1;
		}
		//查询销售订单详情
		DeliveryOrderDetailsDto dto = this.salesDeliveryDao.orderDetails(orderInfoId,user.getPartyId(),isAll,user.getOrganId());
		if(dto != null){
			dto.setCustomerIphone(AesUtils.decryptHex(dto.getEnCustomerIphone(), ucmpAesConfig.getSecret()));
		}
		return dto;
	}

	@Override
	@Transactional
	public void contractSave(DeliveryOrderContractDto dto) throws Exception {
		Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
		dto.setUpdateBy(user.getPartyId());
		//校验交付人员是否一致
		int count=this.salesDeliveryDao.checkOrderConsultant(user.getPartyId(),dto.getOrderInfoId(),user.getOrganId());
		if(count == 1){
			//清空合同材料
			List<String> materialType= new ArrayList<>();
			materialType.add("7301");
			materialType.add("7101");
			this.salesDeliveryDao.clearMaterial(dto.getOrderInfoId(),materialType);
			//销售材料保存
			List<PsiSalesOrderMaterialEntity> materialEntityList = new ArrayList<>();
			if(!dto.getContractList().isEmpty()){
				dto.getContractList().forEach(contratct ->{
					PsiSalesOrderMaterialEntity entity = new PsiSalesOrderMaterialEntity();
					entity.setMaterialId(contratct.getMaterialId());
					entity.setMaterialType(contratct.getMaterialType());
					entity.setOrderInfoId(dto.getOrderInfoId());
					entity.setUploadDate(new Date());
					entity.setUploadPerson(user.getPartyId());
					materialEntityList.add(entity);
				});
				//新增合同材料
				if(!materialEntityList.isEmpty()){
					this.iPsiSalesOrderMaterialDao.batchInsert(materialEntityList);
				}
			}
		}else {
			throw new Exception("当前人员无操作权限");
		}
	}

	@Override
	public List<DeliveryOrderPicDto> contractList(Long orderInfoId) {
		Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
		//查询订单是否是当前登录门店人员的门店的
		int count = this.salesDeliveryDao.checkStoreOrder(orderInfoId,user.getOrganId());
		LOGGER.info("======count===="+count);
		if(count>0){
			LOGGER.info("======1====");
			List<String> materialType= new ArrayList<>();
			materialType.add("7301");
			materialType.add("7101");
			List<DeliveryOrderPicDto> list =this.salesDeliveryDao.materialList(orderInfoId,materialType);
			LOGGER.info("======list===="+JsonBeanUtil.beanToJson(list));
			this.appendUrl(list);
			return list;
		}else{
			LOGGER.info("======2====");
			return null;
		}
	}
	
	private void appendUrl(List<DeliveryOrderPicDto> picDtoList) {
		if(picDtoList != null && !picDtoList.isEmpty()){
			for (DeliveryOrderPicDto oneselfCarPicDto : picDtoList) {
				oneselfCarPicDto.setFileUrl(hwOBSConfig.getFileUri()+oneselfCarPicDto.getFileUrl());
			}
		}
	}

	@Override
	@Transactional
	public Long transferApply(OrderCarTransferDto dto) throws Exception {
		Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
		//校验交付人员是否一致
		LOGGER.info("======判断1======"+ucmpAesConfig.getTransfersAmount());
		int count=this.salesDeliveryDao.checkOrderConsultant(user.getPartyId(),dto.getOrderInfoId(),user.getOrganId());
		//校验是否存在未完成的调拨
		Long transferApplyId=this.salesDeliveryDao.checkOrderTransferInfo(dto.getOrderInfoId());
		/*if(transferApplyId != null && dto.getOperationType() ==1){
			return -3L;
		}*/
		if(count==1){
			//查询订单车辆目前所在仓储点
			Map<String,String> map= this.salesDeliveryDao.getOrderCarInfo(dto.getOrderInfoId());
			LOGGER.info("======查询订单车辆目前所在仓储点map======"+JsonBeanUtil.beanToJson(map));
			if(map.get("storageId") != null){
				PsiCarTransferApplyEntity entity= new PsiCarTransferApplyEntity();
				entity.generatePk();
				entity.setCreatedBy(user.getPartyId());
				entity.setCreatedDate(new Date());
				entity.setUpdatedBy(user.getPartyId());
				entity.setUpdatedDate(entity.getCreatedDate());
				entity.setStockId(Long.valueOf(map.get("stockId")));
				entity.setOrderInfoId(dto.getOrderInfoId());
				entity.setStorageId(Long.valueOf(map.get("storageId")));
				entity.setTransferStorageId(dto.getGoalStorageId());
				entity.setStartTime(dto.getStartTime());
				entity.setExpectedTime(dto.getExpectedTime());
				entity.setTransferType(dto.getTransferType());
				entity.setMarks(dto.getMarks());
				entity.setInitiator(user.getPartyId());
				entity.setInitiatorTime(new Date());
				if(dto.getOperationType() ==1){
					LOGGER.info("======判断2======"+Double.parseDouble(map.get("receivedPrice")));
					if(map.get("receivedPrice")==null ||
							Double.compare(Double.parseDouble(map.get("receivedPrice")), ucmpAesConfig.getTransfersAmount())<0 ){
						return -1L;
					}
					entity.setIsSubmit("00");
				}else{
					entity.setIsSubmit("03");
				}
				entity.setIsDelete("00");
				entity.setIsEnable("01");
				if(transferApplyId != null){
					entity.setTransferApplyId(transferApplyId);
					this.iPsiCarTransferApplyDao.updateSelective(entity);
				}else{
					this.iPsiCarTransferApplyDao.insert(entity);
				}
			}else{
				return -2L;
			}
			return 1L;
		}else{
			throw new Exception("当前人员无操作权限");
		}
	}

	@Override
	public OrderCarTransferInfoDto transferApplyInfo(Long orderInfoId, String roleCode) {
		Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
		Integer isAll = null;
		if(roleCode.equals(Constants.smpRole.SH.value())){
			isAll=1;
		}
		//查询调拨申请信息
		return this.salesDeliveryDao.transferApplyInfo(orderInfoId,isAll,user.getOrganId(),user.getPartyId());
	}

	@Override
	@Transactional
	public Integer transferCancel(Long orderInfoId, String roleCode) {
		Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
		/*if(roleCode.equals(Constants.smpRole.SH.value())){
			return -1;
		}*/
		OrderCarTransferInfoDto dto = this.salesDeliveryDao.transferApplyInfo(orderInfoId,null,user.getOrganId(),user.getPartyId());
		if(dto==null){
			return -2;
		}
		//取消调拨申请
		if(!dto.getIsSubmit().equals(Constants.IS_SUBMIT.SUBMIT.value())){
			//总部还未提交调拨申请
			this.salesDeliveryDao.updateTransferApplyInfo(dto.getTransferApplyId(),user.getPartyId());
		}else{
			//总部已提交调拨申请
			List<Long> list=new ArrayList<>();
			list.add(dto.getTransferApplyId());
			this.transferApplyService.transferWarehousing(1,list);
		}
		return 0;
	}

	@Override
	public OrderPaymentInfoDto paymentInfo(Long orderInfoId, String roleCode) {
		Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
		Integer isAll = null;
		if(roleCode.equals(Constants.smpRole.SH.value())){
			isAll=1;
		}else if(!roleCode.equals(Constants.smpRole.MO.value())){
			isAll=2;
		}
		//查询订单金额信息和车辆主体
		OrderPaymentInfoDto dto =this.salesDeliveryDao.paymentInfo(orderInfoId,isAll,user.getOrganId(),user.getPartyId());
		if(dto != null){
			//查询金融凭证
			List<String> materialType= new ArrayList<>();
			materialType.add("6601");
			List<DeliveryOrderPicDto> financialProofList =this.salesDeliveryDao.materialList(orderInfoId,materialType);
			this.appendUrl(financialProofList);
			dto.setFinancialProofList(financialProofList);
			materialType.clear();
			//查询大定凭证
			materialType.add("6602");
			List<DeliveryOrderPicDto> setPaymentProofList =this.salesDeliveryDao.materialList(orderInfoId,materialType);
			this.appendUrl(setPaymentProofList);
			dto.setSetPaymentProofList(setPaymentProofList);
			materialType.clear();
			//查询尾款凭证
			materialType.add("6603");
			List<DeliveryOrderPicDto> balancePaymentProofList =this.salesDeliveryDao.materialList(orderInfoId,materialType);
			this.appendUrl(balancePaymentProofList);
			dto.setBalancePaymentProofList(balancePaymentProofList);
			materialType.clear();
			//查询其他款项凭证
			materialType.add("6604");
			List<DeliveryOrderPicDto> otherPaymentsProofList =this.salesDeliveryDao.materialList(orderInfoId,materialType);
			this.appendUrl(otherPaymentsProofList);
			dto.setOtherPaymentsProofList(otherPaymentsProofList);
			materialType.clear();
			
			//查询付款记录
			List<OrderPaymentRecordDto> paymentRecord = this.salesDeliveryDao.paymentRecord(orderInfoId,user.getOrganId(),roleCode);
			dto.setPaymentRecord(paymentRecord);
		}
		return dto;
	}

	@Override
	@Transactional
	public int submitFinancialProof(DeliveryOrderFinancialDto dto) throws Exception {
		Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
		dto.setUpdateBy(user.getPartyId());
		//校验交付人员是否一致
		int count=this.salesDeliveryDao.checkOrderConsultant(dto.getUpdateBy(),dto.getOrderInfoId(),user.getOrganId());
		if(count==1){
			//清空合同材料
			List<String> materialType= new ArrayList<>();
			materialType.add("6601");
			materialType.add("6602");
			materialType.add("6603");
			materialType.add("6604");
			this.salesDeliveryDao.clearMaterial(dto.getOrderInfoId(),materialType);
			//销售材料保存
			List<PsiSalesOrderMaterialEntity> materialEntityList = new ArrayList<>();
			//金融凭证
			if(!dto.getFinancialtList().isEmpty()){
				dto.getFinancialtList().forEach(contratct ->{
					PsiSalesOrderMaterialEntity entity = new PsiSalesOrderMaterialEntity();
					entity.setMaterialId(contratct.getMaterialId());
					entity.setMaterialType(contratct.getMaterialType());
					entity.setOrderInfoId(dto.getOrderInfoId());
					entity.setUploadDate(new Date());
					entity.setUploadPerson(user.getPartyId());
					materialEntityList.add(entity);
				});
			}
			//大定凭证
			if(!dto.getSetPaymentProofList().isEmpty()){
				dto.getSetPaymentProofList().forEach(contratct ->{
					PsiSalesOrderMaterialEntity entity = new PsiSalesOrderMaterialEntity();
					entity.setMaterialId(contratct.getMaterialId());
					entity.setMaterialType(contratct.getMaterialType());
					entity.setOrderInfoId(dto.getOrderInfoId());
					entity.setUploadDate(new Date());
					entity.setUploadPerson(user.getPartyId());
					materialEntityList.add(entity);
				});
			}
			//尾款凭证
			if(!dto.getBalancePaymentProofList().isEmpty()){
				dto.getBalancePaymentProofList().forEach(contratct ->{
					PsiSalesOrderMaterialEntity entity = new PsiSalesOrderMaterialEntity();
					entity.setMaterialId(contratct.getMaterialId());
					entity.setMaterialType(contratct.getMaterialType());
					entity.setOrderInfoId(dto.getOrderInfoId());
					entity.setUploadDate(new Date());
					entity.setUploadPerson(user.getPartyId());
					materialEntityList.add(entity);
				});
			}
			//其他款项凭证
			if(!dto.getOtherPaymentsProofList().isEmpty()){
				dto.getOtherPaymentsProofList().forEach(contratct ->{
					PsiSalesOrderMaterialEntity entity = new PsiSalesOrderMaterialEntity();
					entity.setMaterialId(contratct.getMaterialId());
					entity.setMaterialType(contratct.getMaterialType());
					entity.setOrderInfoId(dto.getOrderInfoId());
					entity.setUploadDate(new Date());
					entity.setUploadPerson(user.getPartyId());
					materialEntityList.add(entity);
				});
			}
			//新增材料
			if(!materialEntityList.isEmpty()){
				this.iPsiSalesOrderMaterialDao.batchInsert(materialEntityList);
			}
			//查询订单金额信息和车辆主体
			OrderPaymentInfoDto orderPaymentInfoDto =this.salesDeliveryDao.paymentInfo(dto.getOrderInfoId(),1,user.getOrganId(),user.getPartyId());
		/*	Double financialAmount = Objects.nonNull(orderPaymentInfoDto.getFinancialAmount()) ? orderPaymentInfoDto.getFinancialAmount() : 0;
			double price = orderPaymentInfoDto.getReceivablePrice() - orderPaymentInfoDto.getReceivedPrice() + financialAmount;
			if(orderPaymentInfoDto.getNotReceivedPrice() == null || Double.compare(dto.getAmount(), price)>0){
				return -1;
			}*/
			Double financialAmount;
			if(orderPaymentInfoDto.getFinancialAmount() == null){
				financialAmount=0.0;
			}else{
				financialAmount=orderPaymentInfoDto.getFinancialAmount();
			}
			Double setPaymentSum;
			Double balancePaymentSum;
			Double otherPayments;
			if(orderPaymentInfoDto.getRevertBody().equals(Constants.REVERT_BODY.GH.value())){
				setPaymentSum=0.0;
				balancePaymentSum=0.0;
				otherPayments=0.0;
			}else{
				if(orderPaymentInfoDto.getSetPaymentSum() == null){
					setPaymentSum=0.0;
				}else{
					setPaymentSum=orderPaymentInfoDto.getSetPaymentSum();
				}
				if(orderPaymentInfoDto.getBalancePaymentSum() == null){
					balancePaymentSum=0.0;
				}else{
					balancePaymentSum=orderPaymentInfoDto.getBalancePaymentSum();
				}
				
				if(orderPaymentInfoDto.getOtherPayments() == null){
					otherPayments=0.0;
				}else{
					otherPayments=orderPaymentInfoDto.getOtherPayments();
				}
			}
			
			Double receivedPrice = orderPaymentInfoDto.getReceivedPrice()+dto.getAmount()-financialAmount
					+dto.getSetPaymentSum()-setPaymentSum +dto.getBalancePaymentSum()-balancePaymentSum
					+dto.getOtherPayments()-otherPayments;
			
			Double notReceivedPrice  = orderPaymentInfoDto.getNotReceivedPrice() - dto.getAmount()+financialAmount
			- dto.getSetPaymentSum()+setPaymentSum - dto.getBalancePaymentSum()+balancePaymentSum
			- dto.getOtherPayments()+otherPayments;
			if(orderPaymentInfoDto.getNotReceivedPrice() == null||notReceivedPrice<0){
				return -1;
			}

			String orderStatus;
			if(Double.compare(receivedPrice,orderPaymentInfoDto.getReceivablePrice())==0){
				//更新订单为已全款待过户 7404状态
				orderStatus="7404";
			} else {
				orderStatus="7403";
			}
			//更新金融金额
			if(orderPaymentInfoDto.getRevertBody().equals(Constants.REVERT_BODY.GH.value())){
				this.salesDeliveryDao.updateFinancialLoan(dto.getOrderInfoId(),receivedPrice,notReceivedPrice,dto.getAmount(),dto.getUpdateBy(),
						orderStatus,null,null,null);
			}else{
				this.salesDeliveryDao.updateFinancialLoan(dto.getOrderInfoId(),receivedPrice,notReceivedPrice,dto.getAmount(),dto.getUpdateBy(),
						orderStatus,dto.getSetPaymentSum(),dto.getBalancePaymentSum(),dto.getOtherPayments());
			}
		}else{
			return -2;
		}
		return 1;
	}

	@Override
	public OrderPdiInfoDto pdiInfo(Long orderInfoId, String roleCode) {
		Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
		Integer isAll = null;
		if(roleCode.equals(Constants.smpRole.SH.value())){
			isAll=1;
		}
		//查询PDI状态和结果
		OrderPdiInfoDto dto =this.salesDeliveryDao.pdiInfo(orderInfoId,isAll,user.getOrganId(),user.getPartyId());
		if(dto != null){
			//查询PDI检测报告
			List<String> materialType= new ArrayList<>();
			materialType.add("6901");
			List<DeliveryOrderPicDto> pdiTestReportList =this.salesDeliveryDao.materialList(orderInfoId,materialType);
			this.appendUrl(pdiTestReportList);
			dto.setPdiTestReportList(pdiTestReportList);
			materialType.clear();
			
			//查询维修历史
			materialType.add("6902");
			List<DeliveryOrderPicDto> maintenanceHistoryList =this.salesDeliveryDao.materialList(orderInfoId,materialType);
			this.appendUrl(maintenanceHistoryList);
			dto.setMaintenanceHistoryList(maintenanceHistoryList);
			materialType.clear();
			
			//查询瑕疵图片
			materialType.add("6903");
			List<DeliveryOrderPicDto> defectivePicturesList =this.salesDeliveryDao.materialList(orderInfoId,materialType);
			this.appendUrl(defectivePicturesList);
			dto.setDefectivePicturesList(defectivePicturesList);
			materialType.clear();
		}
		return dto;
	}

	@Override
	@Transactional
	public void submitPdiInfo(OrderPdiInfoDto dto) throws Exception {
		Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
		//校验交付人员是否一致
		int count=this.salesDeliveryDao.checkOrderConsultant(user.getPartyId(),dto.getOrderInfoId(),user.getOrganId());
		if(count ==1){
			//清空PDI材料
			List<String> materialType= new ArrayList<>();
			materialType.add("6901");
			materialType.add("6902");
			materialType.add("6903");
			this.salesDeliveryDao.clearMaterial(dto.getOrderInfoId(),materialType);
			//PDI材料保存
			List<PsiSalesOrderMaterialEntity> materialEntityList = new ArrayList<>();
			//PDI检测报告
			if(!dto.getPdiTestReportList().isEmpty()){
				dto.getPdiTestReportList().forEach(pdiTest ->{
					PsiSalesOrderMaterialEntity entity = new PsiSalesOrderMaterialEntity();
					entity.setMaterialId(pdiTest.getMaterialId());
					entity.setMaterialType(pdiTest.getMaterialType());
					entity.setOrderInfoId(dto.getOrderInfoId());
					entity.setUploadDate(new Date());
					entity.setUploadPerson(user.getPartyId());
					materialEntityList.add(entity);
				});
			}
			//维修历史
			if(!dto.getMaintenanceHistoryList().isEmpty()){
				dto.getMaintenanceHistoryList().forEach(his ->{
					PsiSalesOrderMaterialEntity entity = new PsiSalesOrderMaterialEntity();
					entity.setMaterialId(his.getMaterialId());
					entity.setMaterialType(his.getMaterialType());
					entity.setOrderInfoId(dto.getOrderInfoId());
					entity.setUploadDate(new Date());
					entity.setUploadPerson(user.getPartyId());
					materialEntityList.add(entity);
				});
			}
			//瑕疵图片
			if(!dto.getDefectivePicturesList().isEmpty()){
				dto.getDefectivePicturesList().forEach(def ->{
					PsiSalesOrderMaterialEntity entity = new PsiSalesOrderMaterialEntity();
					entity.setMaterialId(def.getMaterialId());
					entity.setMaterialType(def.getMaterialType());
					entity.setOrderInfoId(dto.getOrderInfoId());
					entity.setUploadDate(new Date());
					entity.setUploadPerson(user.getPartyId());
					materialEntityList.add(entity);
				});
			}
			//新增PDI材料
			if(!materialEntityList.isEmpty()){
				this.iPsiSalesOrderMaterialDao.batchInsert(materialEntityList);
			}
			//更新订单PDI信息
			if(StringUtils.isNotBlank(dto.getPdiResult())){
				String pdiStatus=null;
				if(dto.getOperationType() ==1){
					if("6401".equals(dto.getPdiResult())){
						pdiStatus="6502";
					}else{
						pdiStatus="6503";
					}
				}
				this.salesDeliveryDao.updateOrderPdiInfo(dto.getOrderInfoId(),pdiStatus,dto.getPdiResult(),user.getPartyId());
			}
		}else{
			throw new Exception("当前人员无操作权限");
		}
	}

	@Override
	public OrderDeliveryProfileDto deliveryProfile(Long orderInfoId, String roleCode) {
		Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
		Integer isAll = null;
		if(roleCode.equals(Constants.smpRole.SH.value())){
			isAll=1;
		}
		//查询主用车人信息
		OrderDeliveryProfileDto dto=this.salesDeliveryDao.deliveryProfile(orderInfoId,isAll,user.getOrganId(),user.getPartyId());
		
		if(dto != null){
			//查询登记证图片
			List<String> materialType= new ArrayList<>();
			materialType.add("7001");
			materialType.add("7002");
			materialType.add("7003");
			List<DeliveryOrderPicDto> registrationCertificateList =this.salesDeliveryDao.materialList(orderInfoId,materialType);
			this.appendUrl(registrationCertificateList);
			dto.setRegistrationCertificateList(registrationCertificateList);
			materialType.clear();
			
			//行驶证图片
			materialType.add("7004");
			List<DeliveryOrderPicDto> drivingLicenseList =this.salesDeliveryDao.materialList(orderInfoId,materialType);
			this.appendUrl(drivingLicenseList);
			dto.setDrivingLicenseList(drivingLicenseList);
			materialType.clear();
			
			//交付确认书
			materialType.add("7005");
			List<DeliveryOrderPicDto> deliveryConfirmationList =this.salesDeliveryDao.materialList(orderInfoId,materialType);
			this.appendUrl(deliveryConfirmationList);
			dto.setDeliveryConfirmationList(deliveryConfirmationList);
			materialType.clear();
			
			//二手车交易发票
			materialType.add("7006");
			List<DeliveryOrderPicDto> deliveryInvoiceList =this.salesDeliveryDao.materialList(orderInfoId,materialType);
			this.appendUrl(deliveryInvoiceList);
			dto.setDeliveryInvoiceList(deliveryInvoiceList);
			materialType.clear();
			
			//增值税发票（邮件申请开票）
			materialType.add("7007");
			List<DeliveryOrderPicDto> vatInvoiceList =this.salesDeliveryDao.materialList(orderInfoId,materialType);
			this.appendUrl(vatInvoiceList);
			dto.setVatInvoiceList(vatInvoiceList);
			materialType.clear();
		}
		return dto;
	}

	@Override
	@Transactional
	public int submitDeliveryProfile(OrderDeliveryProfileDto dto) throws Exception {
		Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
		dto.setUpdateBy(user.getPartyId());
		//校验交付人员是否一致
		int count=this.salesDeliveryDao.checkOrderConsultant(user.getPartyId(),dto.getOrderInfoId(),user.getOrganId());
		if(count ==1){
			//清空交付材料
			List<String> materialType= new ArrayList<>();
			materialType.add("7001");
			materialType.add("7002");
			materialType.add("7003");
			materialType.add("7004");
			materialType.add("7005");
			materialType.add("7006");
			materialType.add("7007");
			this.salesDeliveryDao.clearMaterial(dto.getOrderInfoId(),materialType);
			//PDI材料保存
			List<PsiSalesOrderMaterialEntity> materialEntityList = new ArrayList<>();
			//登记证图片
			if(!dto.getRegistrationCertificateList().isEmpty()){
				dto.getRegistrationCertificateList().forEach(pdiTest ->{
					PsiSalesOrderMaterialEntity entity = new PsiSalesOrderMaterialEntity();
					entity.setMaterialId(pdiTest.getMaterialId());
					entity.setMaterialType(pdiTest.getMaterialType());
					entity.setOrderInfoId(dto.getOrderInfoId());
					entity.setUploadDate(new Date());
					entity.setUploadPerson(user.getPartyId());
					materialEntityList.add(entity);
				});
			}
			//行驶证图片
			if(!dto.getDrivingLicenseList().isEmpty()){
				dto.getDrivingLicenseList().forEach(his ->{
					PsiSalesOrderMaterialEntity entity = new PsiSalesOrderMaterialEntity();
					entity.setMaterialId(his.getMaterialId());
					entity.setMaterialType(his.getMaterialType());
					entity.setOrderInfoId(dto.getOrderInfoId());
					entity.setUploadDate(new Date());
					entity.setUploadPerson(user.getPartyId());
					materialEntityList.add(entity);
				});
			}
			//交付确认书
			if(!dto.getDeliveryConfirmationList().isEmpty()){
				dto.getDeliveryConfirmationList().forEach(def ->{
					PsiSalesOrderMaterialEntity entity = new PsiSalesOrderMaterialEntity();
					entity.setMaterialId(def.getMaterialId());
					entity.setMaterialType(def.getMaterialType());
					entity.setOrderInfoId(dto.getOrderInfoId());
					entity.setUploadDate(new Date());
					entity.setUploadPerson(user.getPartyId());
					materialEntityList.add(entity);
				});
			}
			//二手车交易发票
			if(!dto.getDeliveryInvoiceList().isEmpty()){
				dto.getDeliveryInvoiceList().forEach(def ->{
					PsiSalesOrderMaterialEntity entity = new PsiSalesOrderMaterialEntity();
					entity.setMaterialId(def.getMaterialId());
					entity.setMaterialType(def.getMaterialType());
					entity.setOrderInfoId(dto.getOrderInfoId());
					entity.setUploadDate(new Date());
					entity.setUploadPerson(user.getPartyId());
					materialEntityList.add(entity);
				});
			}
			//增值税发票（邮件申请开票）
			if(!dto.getVatInvoiceList().isEmpty()){
				dto.getVatInvoiceList().forEach(def ->{
					PsiSalesOrderMaterialEntity entity = new PsiSalesOrderMaterialEntity();
					entity.setMaterialId(def.getMaterialId());
					entity.setMaterialType(def.getMaterialType());
					entity.setOrderInfoId(dto.getOrderInfoId());
					entity.setUploadDate(new Date());
					entity.setUploadPerson(user.getPartyId());
					materialEntityList.add(entity);
				});
			}
			//新增交付确认材料
			if(!materialEntityList.isEmpty()){
				this.iPsiSalesOrderMaterialDao.batchInsert(materialEntityList);
			}
			//更新主用车人信息
			this.salesDeliveryDao.updateMainUserInfo(dto);
			//提交
			if(dto.getOperationType() == 1){
				//查询订单信息
				PsiOrderInfoPk psiOrderInfoPk = new PsiOrderInfoPk(dto.getOrderInfoId());
				PsiOrderInfoEntity psiOrderInfoEntity = this.iPsiOrderInfoDao.load(psiOrderInfoPk);
				//校验订单状态 未付全款不能交付
				if(psiOrderInfoEntity.getReceivedPrice() == null ||psiOrderInfoEntity.getReceivablePrice().compareTo(psiOrderInfoEntity.getReceivedPrice())!=0){
					return -1;
				}
				//校验PDI状态
				if(!psiOrderInfoEntity.getPdiStatus().equals(Constants.usedCarPdiStatus.completed.value())){
					return -2;
				}
				//校验交付材料
				if(dto.getRegistrationCertificateList().isEmpty()){
					return -3;
				}
				if(dto.getDrivingLicenseList().isEmpty()){
					return -4;
				}
				if(dto.getDeliveryConfirmationList().isEmpty()){
					return -5;
				}
				if(StringUtils.isEmpty(dto.getMainUserName())||StringUtils.isEmpty(dto.getMainUserPhone())){
					return -6;
				}
				//修改订单状态
				this.salesDeliveryDao.updateOderStatus(dto);
				PsiOrderFollowRecordEntity orderFollowRecordEntity = new PsiOrderFollowRecordEntity();
				orderFollowRecordEntity.generatePk();
				orderFollowRecordEntity.setOrderInfoId(dto.getOrderInfoId());
				orderFollowRecordEntity.setFollowStatus("7406");
				orderFollowRecordEntity.setCreatedBy(user.getPartyId());
				orderFollowRecordEntity.setCreatedDate(new Date());
				orderFollowRecordEntity.setIsEnable("01");
				orderFollowRecordEntity.setIsDelete("00");
				orderFollowRecordDao.insert(orderFollowRecordEntity);
				//修改库存车辆状态为已交付
				this.salesDeliveryDao.updateStockCarStatus(dto.getOrderInfoId(),user.getPartyId());
			}
			return 0;
		}else{
			throw new Exception("当前人员无操作权限");
		}
	}

	@Override
	public DeliveryOrderStatisticsDto statistics(String userId, String departmentId, String roleCode) {
		DeliveryOrderStatisticsDto returnDto = new DeliveryOrderStatisticsDto();
		
		//根据userId查询用户信息
		Long partyId = this.salesDeliveryDao.queryPartyId(userId);
		//根据 departmentId 查询 storeId
		Long storeId = this.salesDeliveryDao.queryStoreId(departmentId);
		//查询待分配数量
		Integer unAllocatedNum = this.salesDeliveryDao.countUnAllocatedNum(storeId);
		//查询待全款数量
		Integer unFullPaymentNum;
		//查询待交付数量
		Integer unDeliveryNum;
		//查询已交付数量
		Integer deliveredNum;
		if(roleCode.equals(Constants.smpRole.SH.value())){
			unFullPaymentNum = this.salesDeliveryDao.countUnFullPaymentNum(null,storeId);
			unDeliveryNum = this.salesDeliveryDao.countUnDeliveryNum(null,storeId);
			deliveredNum = this.salesDeliveryDao.countDeliveredNum(null,storeId);
			returnDto.setUnAllocatedNum(unAllocatedNum);
		}else{
			unFullPaymentNum = this.salesDeliveryDao.countUnFullPaymentNum(partyId,storeId);
			unDeliveryNum = this.salesDeliveryDao.countUnDeliveryNum(partyId,storeId);
			deliveredNum = this.salesDeliveryDao.countDeliveredNum(partyId,storeId);
		}
		
		returnDto.setUnFullPaymentNum(unFullPaymentNum);
		returnDto.setUnDeliveryNum(unDeliveryNum);
		returnDto.setDeliveredNum(deliveredNum);
		return returnDto;
	}

}

