package com.exp.ucmp.storeApp.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.cloud.commons.lang.StringUtils;
import com.egrid.core.shiro.context.AuthContext;
import com.egrid.core.util.JsonBeanUtil;
import com.exp.ucmp.carDealer.dao.AcquisitionFollowDao;
import com.exp.ucmp.carDealer.dto.AcquisitionMaterialsDto;
import com.exp.ucmp.carDealer.dto.RepOrderNeedDto;
import com.exp.ucmp.carDealer.dto.TransferMaterialsDto;
import com.exp.ucmp.carDealer.service.impl.MessagePushServiceImpl;
import com.exp.ucmp.config.HwOBSConfig;
import com.exp.ucmp.config.UcmpAesConfig;
import com.exp.ucmp.constant.Constants;
import com.exp.ucmp.consumer.ISystemConsumer;
import com.exp.ucmp.dao.IPsiAcquisitionMaterialDao;
import com.exp.ucmp.dao.IPsiCustomerReservationTrackDao;
import com.exp.ucmp.dao.IPsiOrderReceivingRecordDao;
import com.exp.ucmp.dao.IRepReplacementApprovalDao;
import com.exp.ucmp.entity.PsiAcquisitionMaterialEntity;
import com.exp.ucmp.entity.PsiCustomerReservationMsgEntity;
import com.exp.ucmp.entity.PsiCustomerReservationTrackEntity;
import com.exp.ucmp.entity.PsiMessageInfoEntity;
import com.exp.ucmp.entity.PsiOrderReceivingRecordEntity;
import com.exp.ucmp.entity.RepReplacementApprovalEntity;
import com.exp.ucmp.entity.SysDatadictEntity;
import com.exp.ucmp.eos.dto.ReservationDto;
import com.exp.ucmp.eos.dto.ReservationParamDto;
import com.exp.ucmp.huawei.dto.SmsParamsDto;
import com.exp.ucmp.jPush.dto.JPushReqDto;
import com.exp.ucmp.jpush.service.JPushService;
import com.exp.ucmp.model.Person;
import com.exp.ucmp.pk.PsiCustomerReservationMsgPk;
import com.exp.ucmp.pk.PsiCustomerReservationTrackPk;
import com.exp.ucmp.storeApp.dao.ReservationDao;
import com.exp.ucmp.storeApp.dto.AcquisitionWarehousingDto;
import com.exp.ucmp.storeApp.dto.OneselfAcquirerDto;
import com.exp.ucmp.storeApp.dto.OneselfAcquisitionDto;
import com.exp.ucmp.storeApp.dto.OneselfAcquisitionParamDto;
import com.exp.ucmp.storeApp.dto.OneselfCarPicDto;
import com.exp.ucmp.storeApp.dto.OneselfOrderDetailsDto;
import com.exp.ucmp.storeApp.dto.OneselfOrderPicsDto;
import com.exp.ucmp.storeApp.dto.OneselfStatisticsDto;
import com.exp.ucmp.storeApp.dto.TransferOwnershipDto;
import com.exp.ucmp.storeApp.service.ReservationService;
import com.exp.ucmp.usc.dto.CreateEvaluationDto;
import com.exp.ucmp.util.AesUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.xiaoymin.knife4j.core.util.CollectionUtils;

@Service
public class ReservationServiceImpl implements ReservationService{
	
	/**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ReservationServiceImpl.class);

	@Autowired
	private ReservationDao reservationDao;
	
	@Autowired
	private UcmpAesConfig ucmpAesConfig;
	
	@Autowired
    private IPsiAcquisitionMaterialDao materialDao;
	
	@Autowired
    private AcquisitionFollowDao acquisitionFollowDao;
	
	@Autowired
    private IRepReplacementApprovalDao repReplacementApprovalDao;
	
	@Autowired
    private HwOBSConfig hwOBSConfig;
	
	@Autowired
    IPsiOrderReceivingRecordDao iPsiOrderReceivingRecordDao;
	
	@Autowired
    JPushService jPushService;
	
	@Autowired
    private IPsiCustomerReservationTrackDao customerReservationTrackDao;
	
	@Autowired
    private ISystemConsumer systemConsumer;
	
	@Autowired
    private MessagePushServiceImpl messagePushService;
	
	@Override
	public List<ReservationDto> reservationList(ReservationParamDto reservationparamdto) {
		return this.reservationDao.reservationList(reservationparamdto);
	}

	@Override
	public OneselfStatisticsDto statistics(String userId,String departmentId, String roleCode) {
		OneselfStatisticsDto returnDto = new OneselfStatisticsDto();
		
		//根据userId查询用户信息
		Long partyId = this.reservationDao.queryPartyId(userId);
		//根据 departmentId 查询 storeId
		Long storeId = this.reservationDao.queryStoreId(departmentId);
		//查询待分配数量
		Integer unAllocatedNum = this.reservationDao.countUnAllocatedNum(storeId);
		//查询待收购数量
		Integer unAcquisitionNum;
		//查询待审批数量
		Integer unApproveNum;
		//查询审批驳回数量
		Integer approvalRejectionNum;
		//查询待入库数量
		Integer pendingStockNum;
		//查询已入库待过户数量
		Integer warehousedNum;
		if(roleCode.equals(Constants.smpRole.SH.value())){
			unAcquisitionNum = this.reservationDao.countUnAcquisitionNum(null,storeId);
			unApproveNum = this.reservationDao.countUnApproveNum(null,storeId);
			approvalRejectionNum = this.reservationDao.countApprovalRejectionNum(null,storeId);
			pendingStockNum = this.reservationDao.countPendingStockNum(null,storeId);
			warehousedNum =  this.reservationDao.countWarehousedNumm(null,storeId);
			returnDto.setUnAllocatedNum(unAllocatedNum);
		}else{
			unAcquisitionNum = this.reservationDao.countUnAcquisitionNum(partyId,storeId);
			unApproveNum = this.reservationDao.countUnApproveNum(partyId,storeId);
			approvalRejectionNum = this.reservationDao.countApprovalRejectionNum(partyId,storeId);
			pendingStockNum = this.reservationDao.countPendingStockNum(partyId,storeId);
			warehousedNum =  this.reservationDao.countWarehousedNumm(partyId,storeId);
		}
		
		returnDto.setUnAcquisitionNum(unAcquisitionNum);
		returnDto.setUnApproveNum(unApproveNum);
		returnDto.setApprovalRejectionNum(approvalRejectionNum);
		returnDto.setPendingStockNum(pendingStockNum);
		returnDto.setWarehousedNum(warehousedNum);
		return returnDto;
	}

	@Override
	public PageInfo<OneselfAcquisitionDto> acquisitionList(OneselfAcquisitionParamDto paramDto) throws Exception {
		PageHelper.startPage(paramDto.getPageNum(), paramDto.getPageSize());
		String roleCode = ucmpAesConfig.getRoleCode();
		List<String> roleList = Arrays.asList(roleCode.split(","));
		if(roleList.contains(paramDto.getRoleCode())){
			paramDto.setIsAll(2);
		}else{
			paramDto.setIsAll(1);
		}
		
		if(StringUtils.isNotEmpty(paramDto.getSearchWord())){
			paramDto.setCustomerIphone(AesUtils.encryptHex(paramDto.getSearchWord(), ucmpAesConfig.getSecret()));
			paramDto.setSearchWord("%"+paramDto.getSearchWord()+"%");
		}
		LOGGER.info("=====查询本品收购订单列表参数====="+JsonBeanUtil.beanToJson(paramDto));
		List<OneselfAcquisitionDto> list =this.reservationDao.acquisitionList(paramDto);
		if(!list.isEmpty()){
			for (OneselfAcquisitionDto oneselfAcquisitionDto : list) {
				oneselfAcquisitionDto.setCustomerName(ucmpAesConfig.dataMask(oneselfAcquisitionDto.getCustomerName(), 1, oneselfAcquisitionDto.getCustomerName().length(), "***"));
				oneselfAcquisitionDto.setCustomerIphone(ucmpAesConfig.dataMask(AesUtils.decryptHex(oneselfAcquisitionDto.getEnCustomerIphone(),ucmpAesConfig.getSecret()),3,7, "****"));
			}
		}
		return  new PageInfo<>(list);
	}

	@Override
	public List<OneselfAcquirerDto> acquirerList(Long storeId,String searchWord) throws Exception {
		String roleCode = ucmpAesConfig.getRoleCode();
		List<String> roleList = Arrays.asList(roleCode.split(","));
		String phoneNumber = AesUtils.encryptHex(searchWord, ucmpAesConfig.getSecret());
		List<OneselfAcquirerDto> list=this.reservationDao.acquirerList(storeId,roleList,searchWord,phoneNumber);
		if(!list.isEmpty()){
			for (OneselfAcquirerDto oneselfAcquirerDto : list) {
				oneselfAcquirerDto.setUndone(this.reservationDao.countUndoneNum(oneselfAcquirerDto));
				oneselfAcquirerDto.setConsultantTel(AesUtils.decryptHex(oneselfAcquirerDto.getConsultantTel(),ucmpAesConfig.getSecret()));
			}
		}
		return list;
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println("->"+AesUtils.encryptHex("17612147473","JC3x2hZiNp"));
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public int allotAcquirer(Long inquiryId, Long partyId) {
		Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
		String roleCode = ucmpAesConfig.getRoleCode();
		List<String> roleList = Arrays.asList(roleCode.split(","));
		//校验车辆支持是否存在，并且和收购单是同一家门店，以及收购单是否处于待分配车辆支持状态
		 int check = this.reservationDao.check(partyId,inquiryId,roleList);
		 if(check == 0){
			 return 1;
		 }
		//修改收购表信息
		int count = this.reservationDao.allotAcquirer(inquiryId,partyId,user.getPartyId());
		if(count != 1){
			return 2;
		}
		//本品收购添加操作记录
		PsiOrderReceivingRecordEntity psiOrderReceivingRecordEntity = new PsiOrderReceivingRecordEntity();
    	psiOrderReceivingRecordEntity.generatePk();
    	psiOrderReceivingRecordEntity.setOperation("分配车辆支持");
    	psiOrderReceivingRecordEntity.setOrderStatus("待收购");
    	psiOrderReceivingRecordEntity.setRecordType("03");
    	Long reservationId = this.reservationDao.getReservationId(inquiryId);
    	psiOrderReceivingRecordEntity.setReservationId(reservationId);
    	psiOrderReceivingRecordEntity.setOperationBy(user.getPartyId());
    	psiOrderReceivingRecordEntity.setOperationDate(new Date());
    	this.iPsiOrderReceivingRecordDao.insert(psiOrderReceivingRecordEntity);
    	
    	//推送消息
    	//查询需要推送的人员
    	List<String> alias=this.reservationDao.queryAlias(partyId);
    	//查询订单号
    	String orderNum=this.reservationDao.queryOrderNum(inquiryId);
    	JPushReqDto jPushReqDto = new JPushReqDto();
        jPushReqDto.setAlias(alias.toArray(new String[alias.size()]));
        jPushReqDto.setjPushtemplateId(Constants.jPushtemplateId.JPUSHSECOND.value());
        jPushReqDto.setRelevanceId(reservationId);
        jPushReqDto.setParams(orderNum);
    	jPushService.sendJPush(jPushReqDto);
		return 0;
	}

	@Override
	public OneselfOrderDetailsDto orderDetails(Long inquiryId,String roleCode) {
		Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
		Integer isAll = null;
		if(roleCode.equals(Constants.smpRole.SH.value())){
			isAll=1;
		}
		//查询收购订单详情
		OneselfOrderDetailsDto dto = this.reservationDao.queryOrderDetails(inquiryId,user.getPartyId(),isAll);
		if(dto != null){
			//订单处于审批驳回或审批关闭时查询驳回/关闭原因
			if(dto.getStatus().equals(Constants.approvalStatus.reject.value())||dto.getStatus().equals(Constants.approvalStatus.close.value())){
				dto.setReason(this.reservationDao.getReason(dto.getReservationId()).get(0));
			}
			LOGGER.info("dto="+JsonBeanUtil.beanToJson(dto));
			List<String> typeList=new ArrayList<>();
			typeList.add("9009");
			typeList.add("9010");
			
			LOGGER.info("typeList="+JsonBeanUtil.beanToJson(typeList));
			//查询图片集合
			List<OneselfCarPicDto> pic=this.reservationDao.queryPic(dto.getReservationId(),typeList,null);
			this.appendUrl(pic);
			LOGGER.info("pic="+JsonBeanUtil.beanToJson(pic));
			dto.setPic(pic);
			typeList.clear();
			//查询检测报告集合
			typeList.add("9011");
			List<OneselfCarPicDto> testReportList=this.reservationDao.queryPic(dto.getReservationId(),typeList,null);
			this.appendUrl(testReportList);
			LOGGER.info("testReportList="+JsonBeanUtil.beanToJson(testReportList));
			dto.setTestReportList(testReportList);
		}
		return dto;
	}
	
	@Override
	public OneselfOrderPicsDto orderPics(Long reservationId) {
		OneselfOrderPicsDto dto = new OneselfOrderPicsDto();
		//收购材料
		AcquisitionMaterialsDto acquisitionMaterialsDto =new AcquisitionMaterialsDto();
		List<String> typeList=new ArrayList<>();
		String tag=null;
		//查询最终成交价
		Double dealPriceEnd = this.reservationDao.queryDealPriceEnd(reservationId);
		acquisitionMaterialsDto.setDealPriceEnd(dealPriceEnd);
		//查询车辆主体
	    String revertBody = this.reservationDao.queryRevertBody(reservationId);
	    acquisitionMaterialsDto.setRevertBody(revertBody);
		//查询付款凭证
		typeList.add("9006");
		List<OneselfCarPicDto> paymentEvidenceList = this.reservationDao.queryPic(reservationId,typeList,tag);
		this.appendUrl(paymentEvidenceList);
		acquisitionMaterialsDto.setPaymentEvidenceList(paymentEvidenceList);
		typeList.clear();
		//查询合同材料集合
		typeList.add("9007");
		List<OneselfCarPicDto> contractList = this.reservationDao.queryPic(reservationId,typeList,tag);
		this.appendUrl(contractList);
		acquisitionMaterialsDto.setContractList(contractList);
		typeList.clear();
		//查询车辆材料集合
		tag="97";
		List<OneselfCarPicDto> carList = this.reservationDao.queryPic(reservationId,null,tag);
		this.appendUrl(carList);
		acquisitionMaterialsDto.setCarList(carList);
		//查询车辆照片集合
		tag="98";
		List<OneselfCarPicDto> carPicList = this.reservationDao.queryPic(reservationId,null,tag);
		this.appendUrl(carPicList);
		acquisitionMaterialsDto.setCarPicList(carPicList);
		//查询随车附件集合
		tag="99";
		List<OneselfCarPicDto> attachmentList = this.reservationDao.queryPic(reservationId,null,tag);
		this.appendUrl(attachmentList);
		acquisitionMaterialsDto.setAttachmentList(attachmentList);
		dto.setAcquisitionMaterialsDto(acquisitionMaterialsDto);
		
		//过户材料
		TransferMaterialsDto transferMaterialsDto = new TransferMaterialsDto();
		//查询登记证照片
		typeList.add("9002");
		typeList.add("9003");
		typeList.add("9004");
		typeList.add("9012");
		typeList.add("9013");
		typeList.add("9014");
		List<OneselfCarPicDto> registerList = this.reservationDao.queryPic(reservationId,typeList,null);
		this.appendUrl(registerList);
		transferMaterialsDto.setRegisterList(registerList);
		typeList.clear();
		//查询二手车销售发票
		typeList.add("9005");
		List<OneselfCarPicDto> invoicePic = this.reservationDao.queryPic(reservationId,typeList,null);
		this.appendUrl(invoicePic);
		transferMaterialsDto.setInvoicePic(invoicePic);
		typeList.clear();
		dto.setTransferMaterialsDto(transferMaterialsDto);
		return dto;
	}

	private void appendUrl(List<OneselfCarPicDto> picDtoList) {
		if(picDtoList != null && !picDtoList.isEmpty()){
			for (OneselfCarPicDto oneselfCarPicDto : picDtoList) {
				oneselfCarPicDto.setFileUrl(hwOBSConfig.getFileUri()+oneselfCarPicDto.getFileUrl());
			}
		}
	}

	@Override
	@Transactional
	public void acquisitionWarehousing(AcquisitionWarehousingDto dto) throws Exception {
		Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
		dto.setUpdateBy(user.getPartyId());
		//本品收购材料保存
		List<PsiAcquisitionMaterialEntity> materialEntityList = new ArrayList<>();
		//清空收购材料
		this.reservationDao.clearAcquisitionMaterial(dto.getReservationId(),1);
		//更新合同材料
		if(!dto.getContractList().isEmpty()){
    		for (OneselfCarPicDto oneselfCarPicDto : dto.getContractList()) {
    			PsiAcquisitionMaterialEntity materialEntity = new PsiAcquisitionMaterialEntity();
    			materialEntity.setMaterialId(oneselfCarPicDto.getMaterialId());
                materialEntity.setMaterialType(oneselfCarPicDto.getMaterialType());
                materialEntity.setReservationId(dto.getReservationId());
                materialEntity.setUploadDate(new Date());
                materialEntity.setUploadPerson(user.getPartyId());
                materialEntityList.add(materialEntity);
			}
		}
		//更新车辆材料
		if(!dto.getCarList().isEmpty()){
			for (OneselfCarPicDto oneselfCarPicDto : dto.getCarList()) {
				PsiAcquisitionMaterialEntity materialEntity = new PsiAcquisitionMaterialEntity();
				materialEntity.setMaterialId(oneselfCarPicDto.getMaterialId());
				materialEntity.setMaterialType(oneselfCarPicDto.getMaterialType());
				materialEntity.setReservationId(dto.getReservationId());
				materialEntity.setUploadDate(new Date());
				materialEntity.setUploadPerson(user.getPartyId());
				materialEntityList.add(materialEntity);
			}
		}
		
		//更新车辆照片
		if(!dto.getCarPicList().isEmpty()){
			for (OneselfCarPicDto oneselfCarPicDto : dto.getCarPicList()) {
				PsiAcquisitionMaterialEntity materialEntity = new PsiAcquisitionMaterialEntity();
				materialEntity.setMaterialId(oneselfCarPicDto.getMaterialId());
				materialEntity.setMaterialType(oneselfCarPicDto.getMaterialType());
				materialEntity.setReservationId(dto.getReservationId());
				materialEntity.setUploadDate(new Date());
				materialEntity.setUploadPerson(user.getPartyId());
				materialEntityList.add(materialEntity);
			}
		}
		
		//提交变更订单信息和状态,保存只变更订单信息
		//更新收购表状态
		this.reservationDao.updateAcquisitionStatus(dto);
		//更新询价表状态
		this.reservationDao.updateInquiryStatus(dto);
		
		//更新随车附件
		if(!dto.getAttachmentList().isEmpty()){
			for (OneselfCarPicDto oneselfCarPicDto : dto.getAttachmentList()) {
				PsiAcquisitionMaterialEntity materialEntity = new PsiAcquisitionMaterialEntity();
				materialEntity.setMaterialId(oneselfCarPicDto.getMaterialId());
				materialEntity.setMaterialType(oneselfCarPicDto.getMaterialType());
				materialEntity.setReservationId(dto.getReservationId());
				materialEntity.setUploadDate(new Date());
				materialEntity.setUploadPerson(user.getPartyId());
				materialEntityList.add(materialEntity);
			}
		}
		
		//更新收购材料表
		if(!materialEntityList.isEmpty()){
			materialDao.batchInsert(materialEntityList);
		}
        
        if(dto.getOperationType()==1){
        	//查询审批表数据是否存在
        	int count=this.reservationDao.countReplaceNum(dto.getReservationId());
        	if(count == 0){
        		//生成置换审批表数据
        		RepReplacementApprovalEntity repReplacementApprovalEntity = new RepReplacementApprovalEntity();
        		repReplacementApprovalEntity.generatePk();
        		repReplacementApprovalEntity.setReservationId(dto.getReservationId());
        		repReplacementApprovalEntity.setReportingDateEnd(new Date());
        		//置换单所需信息
        		RepOrderNeedDto repOrderNeedDto = acquisitionFollowDao.queryReplacementOrderInfo(dto.getReservationId());
        		if (repOrderNeedDto == null){
        			throw new Exception("置换预约信息不存在");
        		}
        		BeanUtils.copyProperties(repOrderNeedDto,repReplacementApprovalEntity);
        		//旧车确认状态
        		repReplacementApprovalEntity.setOldCarConfirmSign(Constants.oldCarConfirme.confirme.value());
        		//置换表审批状态
        		repReplacementApprovalEntity.setApprovalStatus(Constants.approvalStatus.unApproval.value());
        		repReplacementApprovalEntity.setCreatedBy(user.getPartyId());
        		repReplacementApprovalEntity.setCreatedPersonName(repOrderNeedDto.getMakeOrderPersonName());
        		repReplacementApprovalEntity.setCreatedDate(new Date());
        		repReplacementApprovalEntity.setUpdatedDate(new Date());
        		repReplacementApprovalEntity.setUpdatedBy(repOrderNeedDto.getMakeOrderPersonId());
        		repReplacementApprovalEntity.setIsDelete("01");
        		repReplacementApprovalDao.insert(repReplacementApprovalEntity);
        	}
        	
        	//本品收购添加操作记录
        	PsiOrderReceivingRecordEntity psiOrderReceivingRecordEntity = new PsiOrderReceivingRecordEntity();
        	psiOrderReceivingRecordEntity.generatePk();
        	psiOrderReceivingRecordEntity.setOperation("收购材料提交");
        	psiOrderReceivingRecordEntity.setOrderStatus("待审批");
        	psiOrderReceivingRecordEntity.setRecordType("03");
        	psiOrderReceivingRecordEntity.setReservationId(dto.getReservationId());
        	psiOrderReceivingRecordEntity.setOperationBy(user.getPartyId());
        	psiOrderReceivingRecordEntity.setOperationDate(new Date());
        	this.iPsiOrderReceivingRecordDao.insert(psiOrderReceivingRecordEntity);
        	
        	//推送短信提醒
        	//接收人
        	PsiCustomerReservationTrackEntity trackEntity = customerReservationTrackDao.load(new PsiCustomerReservationTrackPk(dto.getReservationId()));
            List<String> carSupervisorList = acquisitionFollowDao.queryUsedCarSupervisor(trackEntity.getStoreId());
            if (CollectionUtils.isNotEmpty(carSupervisorList)){
                for (String carSupervisor : carSupervisorList) {
                    SmsParamsDto smsParamsDto = new SmsParamsDto();
                    smsParamsDto.setTemplateId(Constants.sendMessage.sendMessageFourteenth.value());
                    smsParamsDto.setTemplateParas(new String[]{trackEntity.getBusinessOrderNo()});
                    //二手车主管手机号解密
                    try {
                        carSupervisor = AesUtils.decryptHex(carSupervisor,ucmpAesConfig.getSecret());
                    } catch (Exception e) {
                        LOGGER.info("===二手车主管手机号解密异常===",e);
                    }
                    smsParamsDto.setTo(carSupervisor);
                    systemConsumer.batchSendSms(smsParamsDto);

                    //插入信息表
                    PsiMessageInfoEntity messageInfoEntity =new PsiMessageInfoEntity();
                    messageInfoEntity.setMessageType(Constants.MessageType.Sms.value());
                    messageInfoEntity.setReservationId(dto.getReservationId());
                    messageInfoEntity.setTemplateId(Constants.sendMessage.sendMessageFourteenth.value());
                    messageInfoEntity.setRecipient(AesUtils.encryptHex(carSupervisor,ucmpAesConfig.getSecret()));
                    messagePushService.insertMessage(messageInfoEntity);
                }
            }
        }
	}

	@Override
	public void transferOwnership(TransferOwnershipDto dto) {
		Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
		dto.setUpdateBy(user.getPartyId());
		//本品过户材料保存
		List<PsiAcquisitionMaterialEntity> materialEntityList = new ArrayList<>();
		//清空过户材料
		this.reservationDao.clearAcquisitionMaterial(dto.getReservationId(),2);
		//更新登记证
		if(!dto.getRegisterList().isEmpty()){
			for (OneselfCarPicDto oneselfCarPicDto : dto.getRegisterList()) {
				//删除已存在的合同材料
				PsiAcquisitionMaterialEntity materialEntity = new PsiAcquisitionMaterialEntity();
				PsiAcquisitionMaterialEntity query = new PsiAcquisitionMaterialEntity();
				query.setMaterialType(oneselfCarPicDto.getMaterialType());
				query.setReservationId(dto.getReservationId());
				materialDao.deleteBySelective(query);
				
				materialEntity.setMaterialId(oneselfCarPicDto.getMaterialId());
				materialEntity.setMaterialType(oneselfCarPicDto.getMaterialType());
				materialEntity.setReservationId(dto.getReservationId());
				materialEntity.setUploadDate(new Date());
				materialEntity.setUploadPerson(user.getPartyId());
				materialEntityList.add(materialEntity);
			}
		}
		//更新二手车发票
		if(!dto.getInvoicePic().isEmpty()){
			for (OneselfCarPicDto oneselfCarPicDto : dto.getInvoicePic()) {
				//删除已存在的合同材料
				PsiAcquisitionMaterialEntity materialEntity = new PsiAcquisitionMaterialEntity();
				PsiAcquisitionMaterialEntity query = new PsiAcquisitionMaterialEntity();
				query.setMaterialType(oneselfCarPicDto.getMaterialType());
				query.setReservationId(dto.getReservationId());
				materialDao.deleteBySelective(query);
				
				materialEntity.setMaterialId(oneselfCarPicDto.getMaterialId());
				materialEntity.setMaterialType(oneselfCarPicDto.getMaterialType());
				materialEntity.setReservationId(dto.getReservationId());
				materialEntity.setUploadDate(new Date());
				materialEntity.setUploadPerson(user.getPartyId());
				materialEntityList.add(materialEntity);
			}
		}
		
		//更新收购材料表
		if(!materialEntityList.isEmpty()){
			materialDao.batchInsert(materialEntityList);
		}
		
		if(dto.getOperationType() == 1){
			//本品收购添加操作记录
			PsiOrderReceivingRecordEntity psiOrderReceivingRecordEntity = new PsiOrderReceivingRecordEntity();
			psiOrderReceivingRecordEntity.generatePk();
			psiOrderReceivingRecordEntity.setOperation("过户材料提交");
			psiOrderReceivingRecordEntity.setOrderStatus("已完成");
			psiOrderReceivingRecordEntity.setRecordType("03");
			psiOrderReceivingRecordEntity.setReservationId(dto.getReservationId());
			psiOrderReceivingRecordEntity.setOperationBy(user.getPartyId());
			psiOrderReceivingRecordEntity.setOperationDate(new Date());
			this.iPsiOrderReceivingRecordDao.insert(psiOrderReceivingRecordEntity);
			//变更询价表状态为收购完成
			this.reservationDao.updateInquiry(dto.getReservationId());
		}
		
		
	}
	

}
