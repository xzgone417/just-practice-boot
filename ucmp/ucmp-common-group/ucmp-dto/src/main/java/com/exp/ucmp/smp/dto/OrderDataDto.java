package com.exp.ucmp.smp.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "OrderDataDto", description = "订单数据")
public class OrderDataDto {
	
	@ApiModelProperty(value = "订单号")
	private String orderNum;
	
	@ApiModelProperty(value = "urm 用户id")
    private String uid;
	
	@ApiModelProperty(value = "用户的superId")
    private String superId;
	
	@ApiModelProperty(value = "订单状态")
    private String status;
	
	@ApiModelProperty(value = "姓名")
    private String name;
	
	@ApiModelProperty(value = "手机号")
    private String mobile;
	
	@ApiModelProperty(value = "渠道码")
	private String channel;
	
	@ApiModelProperty(value = "上牌省份")
    private String province;
	
	@ApiModelProperty(value = "上牌省份名称")
    private String provinceName;
	
	@ApiModelProperty(value = "上牌城市")
    private String city;
	
	@ApiModelProperty(value = "上牌城市名称")
    private String cityName;
	
	@ApiModelProperty(value = "交付省份编码")
	private String licenseLocationProvinceId;
	
	@ApiModelProperty(value = "交付省份名称")
	private String licenseLocationProvinceName;
	
	@ApiModelProperty(value = "交付城市编码")
	private String licenseLocationCityId;
	
	@ApiModelProperty(value = "交付城市名称")
	private String licenseLocationCity;
	
	@ApiModelProperty(value = "创建时间")
    private String createdTime;
	
	@ApiModelProperty(value = "购车类型")
    private String purchaseType;
	
	@ApiModelProperty(value = "预计最晚交付日期（客户端）")
	private Integer expectDeliveryDate2C;
	
	@ApiModelProperty(value = "收款银行户名")
	private String receiptBankUname;
	
	@ApiModelProperty(value = "收款银行名称")
	private String receiptBankName;
	
	@ApiModelProperty(value = "收款银行机构编号")
	private String receiptBankOrg;
	
	@ApiModelProperty(value = "小订阶段预车型数据")
	private List<PreVehicleDataDto> preVehicleData;
	
	@ApiModelProperty(value = "工程车型编码")
    private String carSeriesCode;
    
    @ApiModelProperty(value = "工程车型名称")
    private String carSeries;
    
    @ApiModelProperty(value = "基础车型编码")
    private String carTypeCode;
    
    @ApiModelProperty(value = "基础车型名称")
    private String carType;
    
    @ApiModelProperty(value = "车型组合(ID)")
    private String carCombinationId;
    
    @ApiModelProperty(value = "外色编码")
    private String carColorCode;
    
    @ApiModelProperty(value = "外色名称")
    private String carColor;
    
    @ApiModelProperty(value = "内饰色编码")
    private String carIncolorCode;
    
    @ApiModelProperty(value = "内饰色名称")
    private String carIncolor;
    
    @ApiModelProperty(value = "选装List")
    private List<FeatureDto> featureList;
    
    @ApiModelProperty(value = "车身价格 :车辆销售价格")
    private String price;
    
    @ApiModelProperty(value = "MSRP=车身价+选装价+内饰+外色")
    private String acutalPrice;
    
    @ApiModelProperty(value = "统一折扣")
    private String discountUniteTotal;
    
    @ApiModelProperty(value = "订单内特殊折扣总额")
    private String discountSpecialTotal;
    
    @ApiModelProperty(value = "发票金额=MSRP-统一折扣-订单内特殊折扣总额")
    private String invoicePrice;
    
    @ApiModelProperty(value = "按揭首付")
    private String loanBankPay;
    
    @ApiModelProperty(value = "已收金额")
    private String receivedAmount;
    
    @ApiModelProperty(value = "待收金额")
    private String gatheringAmount;
    
    @ApiModelProperty(value = "应收定金")
    private String depositAmount;
    
    @ApiModelProperty(value = "应收意向金")
    private String intentionAmount;
    
    @ApiModelProperty(value = "销售顾问编码")
    private String consultantId;
    
    @ApiModelProperty(value = "销售顾问姓名")
    private String consultantName;
    
    @ApiModelProperty(value = "销售顾问手机")
    private String consultantMobile;
    
    @ApiModelProperty(value = "VIP码")
    private String vipCode;
    
    @ApiModelProperty(value = "邀请人Uid")
    private String invitationUid;
    
    @ApiModelProperty(value = "邀请码/下单码")
    private String invitationCode;
    
    @ApiModelProperty(value = "企业名称,购车类型=01-企业时，必填；购车类型=00-个人时，不填")
    private String enterpriseName;
    
    @ApiModelProperty(value = "企业信用证代码,购车类型=01-企业时，必填；购车类型=00-个人时，不填")
    private String enterpriseCode;
    
    @ApiModelProperty(value = "企业地址")
    private String enterpriseAddr;
    
    @ApiModelProperty(value = "订单类型 1:客户订单,2:到店订单,3:大客户订单")
    private String orderType;
    
    @ApiModelProperty(value = "订单分类标识 值会变化：1小订,2 DR(销售下的),3大定,4 DR2C(客户下的)")
    private String orderClass;
    
    @ApiModelProperty(value = "订单来源标识 值不变化：1小订,2 DR(销售下的),3大定,4 DR2C(客户下的)")
    private String blindFlag;
    
    @ApiModelProperty(value = "历史小订订单标识 1=历史小订订单 0 否")
    private String oldDeposit;
    
    @ApiModelProperty(value = "销售门店(ID)")
    private String saleDlrId;
    
    @ApiModelProperty(value = "销售门店名称")
    private String saleDlr;
    
    @ApiModelProperty(value = "意向金支付时间")
    private String paymentTime;
    
    @ApiModelProperty(value = "转大定时间")
    private String orderDate;
    
    @ApiModelProperty(value = "大定支付时间")
    private String orderPaymentTime;
    
    @ApiModelProperty(value = "HandOff日期")
    private String saleConfirmDate;
    
    @ApiModelProperty(value = "预计销售确认日期")
    private String preSaleConfirmDate;
    
    @ApiModelProperty(value = "预计提车时间")
    private String preDeliveryDate;
    
    @ApiModelProperty(value = "订单失效时间")
    private String invalidTime;
    
    @ApiModelProperty(value = "交付中心(ID)")
    private String dcDlrId;
    
    @ApiModelProperty(value = "交付中心名称")
    private String dcDlr;
    
    @ApiModelProperty(value = "交付专员(ID)")
    private String deliverEmpId;
    
    @ApiModelProperty(value = "交付专员姓名")
    private String deliverEmpName;
    
    @ApiModelProperty(value = "下单顾问(ID)")
    private String createEmpId;
    
    @ApiModelProperty(value = "下单顾问姓名")
    private String createEmpName;
    
    @ApiModelProperty(value = "订单交付状态")
    private String orderStatus;
    
    @ApiModelProperty(value = "冻结状态 0:订单未冻结,1:订单已冻结（返回中文）")
    private String frozenStatus;
    
    @ApiModelProperty(value = "发运状态 0:已做发运指令,1:VDC已出库,2:已入库,9:发运指令取消")
    private String sendStatus;
    
    @ApiModelProperty(value = "发运人(ID)")
    private String sendPersionId;
    
    @ApiModelProperty(value = "发运人名称")
    private String sendPersionName;
    
    @ApiModelProperty(value = "发运时间")
    private String sendPersionDate;
    
    @ApiModelProperty(value = "配车状态")
    private String assignStatus;
    
    @ApiModelProperty(value = "配车时间")
    private String assignDate;
    
    @ApiModelProperty(value = "配车人(ID)")
    private String assignEmpId;
    
    @ApiModelProperty(value = "配车人姓名")
    private String assignEmpName;
    
    @ApiModelProperty(value = "车籍(ID)")
    private String carId;
    
    @ApiModelProperty(value = "VIN码")
    private String vin;
    
    @ApiModelProperty(value = "内部号")
    private String batchNo;
    
    @ApiModelProperty(value = "预生产订单号")
    private String preOrderNo;
    
    @ApiModelProperty(value = "金融贷款审核状态")
    private String isAudited;
    
    @ApiModelProperty(value = "是否融资贷款")
    private String isLoan;
    
    @ApiModelProperty(value = "交付时间")
    private String deliveryDate;
    
    @ApiModelProperty(value = "上牌资质")
    private String licenseFlag;
    
    @ApiModelProperty(value = "付款方式(金融意向)")
    private String loanFlag;
    
    @ApiModelProperty(value = "客户交付预期")
    private String deliverExpectedFlag;
    
    @ApiModelProperty(value = "延迟交付原因")
    private String delayDeliverReason;
    
    @ApiModelProperty(value = "家充桩")
    private String chargingPileFlag;
    
    @ApiModelProperty(value = "上牌资质(额度)")
    private String licenseQuotaFlag;
    
    @ApiModelProperty(value = "上牌资质(指标-北京)")
    private String licenseBJFlag;
    
    @ApiModelProperty(value = "上牌资质(指标-广深)")
    private String licenseGSFlag;
    
    @ApiModelProperty(value = "订单合同签署状态")
    private String orderContractStatus;
    
    @ApiModelProperty(value = "下单顾问ID")
    private String placConsultantId;
    
    @ApiModelProperty(value = "订单备注")
    private String remark;
    
    @ApiModelProperty(value = "开票日期")
    private String invoiceDate;
    
    @ApiModelProperty(value = "发票号")
    private String invoiceNo;
    
    @ApiModelProperty(value = "开票人")
    private String invoiceName;
    
    @ApiModelProperty(value = "开票状态")
    private String invoiceStatus;
    
    @ApiModelProperty(value = "车辆所有人类型")
    private String ownerType;
    
    @ApiModelProperty(value = "车辆所有人名称")
    private String ownerName;
    
    @ApiModelProperty(value = "车辆所有人电话")
    private String ownerPhone;
    
    @ApiModelProperty(value = "车辆所有人证件类型")
    private String ownerCardType;
    
    @ApiModelProperty(value = "车辆所有人证件号")
    private String ownerCardNo;
    
    @ApiModelProperty(value = "主用车人")
    private String mainUserName;
    
    @ApiModelProperty(value = "主用车人证件号")
    private String mainUserCardNo;
    
    @ApiModelProperty(value = "主用车人电话号码")
    private String mainUserPhone;
    
    @ApiModelProperty(value = "车牌号")
    private String carLincense;
    
    @ApiModelProperty(value = "购车协议确认状态")
    private int orderAgreementStatus;
    
    @ApiModelProperty(value = "顾问代码 高大麦自己生成的用户ID")
    private String consultantCode;
    
    @ApiModelProperty(value = "vccid 小订/盲定没有")
    private String skuId;
    
    @ApiModelProperty(value = "注册登记日期")
    private String registerDate;
    
    @ApiModelProperty(value = "车辆登记证书提交日期")
    private String certificationDate;
    
    @ApiModelProperty(value = "VRI状态 1:VRI OK,2:VIR NOT OK")
    private String vriStatus;
    
    @ApiModelProperty(value = "VRI时间")
    private String vriTime;
	
    @ApiModelProperty(value = "权益数据体")
    private List<BenefitDataDto> benefitData;
    
    @ApiModelProperty(value = "预约List")
    private List<ReserveDto> reserveList;
    
    @ApiModelProperty(value = "PDI单List")
    private List<PdiDto> pdiList;
    
    @ApiModelProperty(value = "收款流水List")
    private List<PayDto> payList;
    
    @ApiModelProperty(value = "取消订单数据体")
    private List<CancelDataDto> cancelData;
    
    @ApiModelProperty(value = "订单退款数据体")
    private List<RefundDataDto> refundData;
    
    @ApiModelProperty(value = "附件List")
    private List<AnnexDto> annexList;
    
    @ApiModelProperty(value = "基础车型ID")
    private String carTypeId;
    
    @ApiModelProperty(value = "交付省份编码")
    private String licenseLocationProvince;
    
    @ApiModelProperty(value = "下单顾问名称")
    private String placConsultantName;
    
    @ApiModelProperty(value = "合同list")
    private List<ContractDto> contractList;
    
    @ApiModelProperty(value = "保险List")
    private List<CarInsuranceDto> carInsurance;
    
    @ApiModelProperty(value = "订单锁配时间 秒级时间戳")
    private String orderLockTime;
    
    @ApiModelProperty(value = "销售配置ID")
    private String saleConfId;

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getSuperId() {
		return superId;
	}

	public void setSuperId(String superId) {
		this.superId = superId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getLicenseLocationProvinceId() {
		return licenseLocationProvinceId;
	}

	public void setLicenseLocationProvinceId(String licenseLocationProvinceId) {
		this.licenseLocationProvinceId = licenseLocationProvinceId;
	}

	public String getLicenseLocationProvinceName() {
		return licenseLocationProvinceName;
	}

	public void setLicenseLocationProvinceName(String licenseLocationProvinceName) {
		this.licenseLocationProvinceName = licenseLocationProvinceName;
	}

	public String getLicenseLocationCityId() {
		return licenseLocationCityId;
	}

	public void setLicenseLocationCityId(String licenseLocationCityId) {
		this.licenseLocationCityId = licenseLocationCityId;
	}

	public String getLicenseLocationCity() {
		return licenseLocationCity;
	}

	public void setLicenseLocationCity(String licenseLocationCity) {
		this.licenseLocationCity = licenseLocationCity;
	}

	public String getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}

	public String getPurchaseType() {
		return purchaseType;
	}

	public void setPurchaseType(String purchaseType) {
		this.purchaseType = purchaseType;
	}

	public Integer getExpectDeliveryDate2C() {
		return expectDeliveryDate2C;
	}

	public void setExpectDeliveryDate2C(Integer expectDeliveryDate2C) {
		this.expectDeliveryDate2C = expectDeliveryDate2C;
	}

	public String getReceiptBankUname() {
		return receiptBankUname;
	}

	public void setReceiptBankUname(String receiptBankUname) {
		this.receiptBankUname = receiptBankUname;
	}

	public String getReceiptBankName() {
		return receiptBankName;
	}

	public void setReceiptBankName(String receiptBankName) {
		this.receiptBankName = receiptBankName;
	}

	public String getReceiptBankOrg() {
		return receiptBankOrg;
	}

	public void setReceiptBankOrg(String receiptBankOrg) {
		this.receiptBankOrg = receiptBankOrg;
	}

	public List<PreVehicleDataDto> getPreVehicleData() {
		return preVehicleData;
	}

	public void setPreVehicleData(List<PreVehicleDataDto> preVehicleData) {
		this.preVehicleData = preVehicleData;
	}

	public String getCarSeriesCode() {
		return carSeriesCode;
	}

	public void setCarSeriesCode(String carSeriesCode) {
		this.carSeriesCode = carSeriesCode;
	}

	public String getCarSeries() {
		return carSeries;
	}

	public void setCarSeries(String carSeries) {
		this.carSeries = carSeries;
	}

	public String getCarTypeCode() {
		return carTypeCode;
	}

	public void setCarTypeCode(String carTypeCode) {
		this.carTypeCode = carTypeCode;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public String getCarCombinationId() {
		return carCombinationId;
	}

	public void setCarCombinationId(String carCombinationId) {
		this.carCombinationId = carCombinationId;
	}

	public String getCarColorCode() {
		return carColorCode;
	}

	public void setCarColorCode(String carColorCode) {
		this.carColorCode = carColorCode;
	}

	public String getCarColor() {
		return carColor;
	}

	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}

	public String getCarIncolorCode() {
		return carIncolorCode;
	}

	public void setCarIncolorCode(String carIncolorCode) {
		this.carIncolorCode = carIncolorCode;
	}

	public String getCarIncolor() {
		return carIncolor;
	}

	public void setCarIncolor(String carIncolor) {
		this.carIncolor = carIncolor;
	}

	public List<FeatureDto> getFeatureList() {
		return featureList;
	}

	public void setFeatureList(List<FeatureDto> featureList) {
		this.featureList = featureList;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getAcutalPrice() {
		return acutalPrice;
	}

	public void setAcutalPrice(String acutalPrice) {
		this.acutalPrice = acutalPrice;
	}

	public String getDiscountUniteTotal() {
		return discountUniteTotal;
	}

	public void setDiscountUniteTotal(String discountUniteTotal) {
		this.discountUniteTotal = discountUniteTotal;
	}

	public String getDiscountSpecialTotal() {
		return discountSpecialTotal;
	}

	public void setDiscountSpecialTotal(String discountSpecialTotal) {
		this.discountSpecialTotal = discountSpecialTotal;
	}

	public String getInvoicePrice() {
		return invoicePrice;
	}

	public void setInvoicePrice(String invoicePrice) {
		this.invoicePrice = invoicePrice;
	}

	public String getLoanBankPay() {
		return loanBankPay;
	}

	public void setLoanBankPay(String loanBankPay) {
		this.loanBankPay = loanBankPay;
	}

	public String getReceivedAmount() {
		return receivedAmount;
	}

	public void setReceivedAmount(String receivedAmount) {
		this.receivedAmount = receivedAmount;
	}

	public String getGatheringAmount() {
		return gatheringAmount;
	}

	public void setGatheringAmount(String gatheringAmount) {
		this.gatheringAmount = gatheringAmount;
	}

	public String getDepositAmount() {
		return depositAmount;
	}

	public void setDepositAmount(String depositAmount) {
		this.depositAmount = depositAmount;
	}

	public String getIntentionAmount() {
		return intentionAmount;
	}

	public void setIntentionAmount(String intentionAmount) {
		this.intentionAmount = intentionAmount;
	}

	public String getConsultantId() {
		return consultantId;
	}

	public void setConsultantId(String consultantId) {
		this.consultantId = consultantId;
	}

	public String getConsultantName() {
		return consultantName;
	}

	public void setConsultantName(String consultantName) {
		this.consultantName = consultantName;
	}

	public String getConsultantMobile() {
		return consultantMobile;
	}

	public void setConsultantMobile(String consultantMobile) {
		this.consultantMobile = consultantMobile;
	}

	public String getVipCode() {
		return vipCode;
	}

	public void setVipCode(String vipCode) {
		this.vipCode = vipCode;
	}

	public String getInvitationUid() {
		return invitationUid;
	}

	public void setInvitationUid(String invitationUid) {
		this.invitationUid = invitationUid;
	}

	public String getInvitationCode() {
		return invitationCode;
	}

	public void setInvitationCode(String invitationCode) {
		this.invitationCode = invitationCode;
	}

	public String getEnterpriseName() {
		return enterpriseName;
	}

	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}

	public String getEnterpriseCode() {
		return enterpriseCode;
	}

	public void setEnterpriseCode(String enterpriseCode) {
		this.enterpriseCode = enterpriseCode;
	}

	public String getEnterpriseAddr() {
		return enterpriseAddr;
	}

	public void setEnterpriseAddr(String enterpriseAddr) {
		this.enterpriseAddr = enterpriseAddr;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getOrderClass() {
		return orderClass;
	}

	public void setOrderClass(String orderClass) {
		this.orderClass = orderClass;
	}

	public String getBlindFlag() {
		return blindFlag;
	}

	public void setBlindFlag(String blindFlag) {
		this.blindFlag = blindFlag;
	}

	public String getOldDeposit() {
		return oldDeposit;
	}

	public void setOldDeposit(String oldDeposit) {
		this.oldDeposit = oldDeposit;
	}

	public String getSaleDlrId() {
		return saleDlrId;
	}

	public void setSaleDlrId(String saleDlrId) {
		this.saleDlrId = saleDlrId;
	}

	public String getSaleDlr() {
		return saleDlr;
	}

	public void setSaleDlr(String saleDlr) {
		this.saleDlr = saleDlr;
	}

	public String getPaymentTime() {
		return paymentTime;
	}

	public void setPaymentTime(String paymentTime) {
		this.paymentTime = paymentTime;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderPaymentTime() {
		return orderPaymentTime;
	}

	public void setOrderPaymentTime(String orderPaymentTime) {
		this.orderPaymentTime = orderPaymentTime;
	}

	public String getSaleConfirmDate() {
		return saleConfirmDate;
	}

	public void setSaleConfirmDate(String saleConfirmDate) {
		this.saleConfirmDate = saleConfirmDate;
	}

	public String getPreSaleConfirmDate() {
		return preSaleConfirmDate;
	}

	public void setPreSaleConfirmDate(String preSaleConfirmDate) {
		this.preSaleConfirmDate = preSaleConfirmDate;
	}

	public String getPreDeliveryDate() {
		return preDeliveryDate;
	}

	public void setPreDeliveryDate(String preDeliveryDate) {
		this.preDeliveryDate = preDeliveryDate;
	}

	public String getInvalidTime() {
		return invalidTime;
	}

	public void setInvalidTime(String invalidTime) {
		this.invalidTime = invalidTime;
	}

	public String getDcDlrId() {
		return dcDlrId;
	}

	public void setDcDlrId(String dcDlrId) {
		this.dcDlrId = dcDlrId;
	}

	public String getDcDlr() {
		return dcDlr;
	}

	public void setDcDlr(String dcDlr) {
		this.dcDlr = dcDlr;
	}

	public String getDeliverEmpId() {
		return deliverEmpId;
	}

	public void setDeliverEmpId(String deliverEmpId) {
		this.deliverEmpId = deliverEmpId;
	}

	public String getDeliverEmpName() {
		return deliverEmpName;
	}

	public void setDeliverEmpName(String deliverEmpName) {
		this.deliverEmpName = deliverEmpName;
	}

	public String getCreateEmpId() {
		return createEmpId;
	}

	public void setCreateEmpId(String createEmpId) {
		this.createEmpId = createEmpId;
	}

	public String getCreateEmpName() {
		return createEmpName;
	}

	public void setCreateEmpName(String createEmpName) {
		this.createEmpName = createEmpName;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getFrozenStatus() {
		return frozenStatus;
	}

	public void setFrozenStatus(String frozenStatus) {
		this.frozenStatus = frozenStatus;
	}

	public String getSendStatus() {
		return sendStatus;
	}

	public void setSendStatus(String sendStatus) {
		this.sendStatus = sendStatus;
	}

	public String getSendPersionId() {
		return sendPersionId;
	}

	public void setSendPersionId(String sendPersionId) {
		this.sendPersionId = sendPersionId;
	}

	public String getSendPersionName() {
		return sendPersionName;
	}

	public void setSendPersionName(String sendPersionName) {
		this.sendPersionName = sendPersionName;
	}

	public String getSendPersionDate() {
		return sendPersionDate;
	}

	public void setSendPersionDate(String sendPersionDate) {
		this.sendPersionDate = sendPersionDate;
	}

	public String getAssignStatus() {
		return assignStatus;
	}

	public void setAssignStatus(String assignStatus) {
		this.assignStatus = assignStatus;
	}

	public String getAssignDate() {
		return assignDate;
	}

	public void setAssignDate(String assignDate) {
		this.assignDate = assignDate;
	}

	public String getAssignEmpId() {
		return assignEmpId;
	}

	public void setAssignEmpId(String assignEmpId) {
		this.assignEmpId = assignEmpId;
	}

	public String getAssignEmpName() {
		return assignEmpName;
	}

	public void setAssignEmpName(String assignEmpName) {
		this.assignEmpName = assignEmpName;
	}

	public String getCarId() {
		return carId;
	}

	public void setCarId(String carId) {
		this.carId = carId;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public String getPreOrderNo() {
		return preOrderNo;
	}

	public void setPreOrderNo(String preOrderNo) {
		this.preOrderNo = preOrderNo;
	}

	public String getIsAudited() {
		return isAudited;
	}

	public void setIsAudited(String isAudited) {
		this.isAudited = isAudited;
	}

	public String getIsLoan() {
		return isLoan;
	}

	public void setIsLoan(String isLoan) {
		this.isLoan = isLoan;
	}

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getLicenseFlag() {
		return licenseFlag;
	}

	public void setLicenseFlag(String licenseFlag) {
		this.licenseFlag = licenseFlag;
	}

	public String getLoanFlag() {
		return loanFlag;
	}

	public void setLoanFlag(String loanFlag) {
		this.loanFlag = loanFlag;
	}

	public String getDeliverExpectedFlag() {
		return deliverExpectedFlag;
	}

	public void setDeliverExpectedFlag(String deliverExpectedFlag) {
		this.deliverExpectedFlag = deliverExpectedFlag;
	}

	public String getDelayDeliverReason() {
		return delayDeliverReason;
	}

	public void setDelayDeliverReason(String delayDeliverReason) {
		this.delayDeliverReason = delayDeliverReason;
	}

	public String getChargingPileFlag() {
		return chargingPileFlag;
	}

	public void setChargingPileFlag(String chargingPileFlag) {
		this.chargingPileFlag = chargingPileFlag;
	}

	public String getLicenseQuotaFlag() {
		return licenseQuotaFlag;
	}

	public void setLicenseQuotaFlag(String licenseQuotaFlag) {
		this.licenseQuotaFlag = licenseQuotaFlag;
	}

	public String getLicenseBJFlag() {
		return licenseBJFlag;
	}

	public void setLicenseBJFlag(String licenseBJFlag) {
		this.licenseBJFlag = licenseBJFlag;
	}

	public String getLicenseGSFlag() {
		return licenseGSFlag;
	}

	public void setLicenseGSFlag(String licenseGSFlag) {
		this.licenseGSFlag = licenseGSFlag;
	}

	public String getOrderContractStatus() {
		return orderContractStatus;
	}

	public void setOrderContractStatus(String orderContractStatus) {
		this.orderContractStatus = orderContractStatus;
	}

	public String getPlacConsultantId() {
		return placConsultantId;
	}

	public void setPlacConsultantId(String placConsultantId) {
		this.placConsultantId = placConsultantId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public String getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public String getInvoiceName() {
		return invoiceName;
	}

	public void setInvoiceName(String invoiceName) {
		this.invoiceName = invoiceName;
	}

	public String getInvoiceStatus() {
		return invoiceStatus;
	}

	public void setInvoiceStatus(String invoiceStatus) {
		this.invoiceStatus = invoiceStatus;
	}

	public String getOwnerType() {
		return ownerType;
	}

	public void setOwnerType(String ownerType) {
		this.ownerType = ownerType;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getOwnerPhone() {
		return ownerPhone;
	}

	public void setOwnerPhone(String ownerPhone) {
		this.ownerPhone = ownerPhone;
	}

	public String getOwnerCardType() {
		return ownerCardType;
	}

	public void setOwnerCardType(String ownerCardType) {
		this.ownerCardType = ownerCardType;
	}

	public String getOwnerCardNo() {
		return ownerCardNo;
	}

	public void setOwnerCardNo(String ownerCardNo) {
		this.ownerCardNo = ownerCardNo;
	}

	public String getMainUserName() {
		return mainUserName;
	}

	public void setMainUserName(String mainUserName) {
		this.mainUserName = mainUserName;
	}

	public String getMainUserCardNo() {
		return mainUserCardNo;
	}

	public void setMainUserCardNo(String mainUserCardNo) {
		this.mainUserCardNo = mainUserCardNo;
	}

	public String getMainUserPhone() {
		return mainUserPhone;
	}

	public void setMainUserPhone(String mainUserPhone) {
		this.mainUserPhone = mainUserPhone;
	}

	public String getCarLincense() {
		return carLincense;
	}

	public void setCarLincense(String carLincense) {
		this.carLincense = carLincense;
	}

	public int getOrderAgreementStatus() {
		return orderAgreementStatus;
	}

	public void setOrderAgreementStatus(int orderAgreementStatus) {
		this.orderAgreementStatus = orderAgreementStatus;
	}

	public String getConsultantCode() {
		return consultantCode;
	}

	public void setConsultantCode(String consultantCode) {
		this.consultantCode = consultantCode;
	}

	public String getSkuId() {
		return skuId;
	}

	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}

	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

	public String getCertificationDate() {
		return certificationDate;
	}

	public void setCertificationDate(String certificationDate) {
		this.certificationDate = certificationDate;
	}

	public String getVriStatus() {
		return vriStatus;
	}

	public void setVriStatus(String vriStatus) {
		this.vriStatus = vriStatus;
	}

	public String getVriTime() {
		return vriTime;
	}

	public void setVriTime(String vriTime) {
		this.vriTime = vriTime;
	}

	public List<BenefitDataDto> getBenefitData() {
		return benefitData;
	}

	public void setBenefitData(List<BenefitDataDto> benefitData) {
		this.benefitData = benefitData;
	}

	public List<ReserveDto> getReserveList() {
		return reserveList;
	}

	public void setReserveList(List<ReserveDto> reserveList) {
		this.reserveList = reserveList;
	}

	public List<PdiDto> getPdiList() {
		return pdiList;
	}

	public void setPdiList(List<PdiDto> pdiList) {
		this.pdiList = pdiList;
	}

	public List<PayDto> getPayList() {
		return payList;
	}

	public void setPayList(List<PayDto> payList) {
		this.payList = payList;
	}

	public List<CancelDataDto> getCancelData() {
		return cancelData;
	}

	public void setCancelData(List<CancelDataDto> cancelData) {
		this.cancelData = cancelData;
	}

	public List<RefundDataDto> getRefundData() {
		return refundData;
	}

	public void setRefundData(List<RefundDataDto> refundData) {
		this.refundData = refundData;
	}

	public List<AnnexDto> getAnnexList() {
		return annexList;
	}

	public void setAnnexList(List<AnnexDto> annexList) {
		this.annexList = annexList;
	}

	public String getCarTypeId() {
		return carTypeId;
	}

	public void setCarTypeId(String carTypeId) {
		this.carTypeId = carTypeId;
	}

	public String getLicenseLocationProvince() {
		return licenseLocationProvince;
	}

	public void setLicenseLocationProvince(String licenseLocationProvince) {
		this.licenseLocationProvince = licenseLocationProvince;
	}

	public String getPlacConsultantName() {
		return placConsultantName;
	}

	public void setPlacConsultantName(String placConsultantName) {
		this.placConsultantName = placConsultantName;
	}

	public List<ContractDto> getContractList() {
		return contractList;
	}

	public void setContractList(List<ContractDto> contractList) {
		this.contractList = contractList;
	}

	public List<CarInsuranceDto> getCarInsurance() {
		return carInsurance;
	}

	public void setCarInsurance(List<CarInsuranceDto> carInsurance) {
		this.carInsurance = carInsurance;
	}

	public String getOrderLockTime() {
		return orderLockTime;
	}

	public void setOrderLockTime(String orderLockTime) {
		this.orderLockTime = orderLockTime;
	}

	public String getSaleConfId() {
		return saleConfId;
	}

	public void setSaleConfId(String saleConfId) {
		this.saleConfId = saleConfId;
	}
}
