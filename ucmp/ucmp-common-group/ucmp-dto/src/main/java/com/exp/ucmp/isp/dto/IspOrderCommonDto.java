package com.exp.ucmp.isp.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "IspOrderHistoryDto", description = "isp维修配件查询返回类")
public class IspOrderCommonDto{
	
	@ApiModelProperty(value = "id")
	private Long id;
	
	@ApiModelProperty(value = "维修工单号")
    private String workOrderNo;
	
	@ApiModelProperty(value = "预约单号")
    private String reservationNo;
	
	@ApiModelProperty(value = "维修类型")
    private String maintenanceTypeCode;
	
	@ApiModelProperty(value = "修改人")
    private String updateBy;
	
	@ApiModelProperty(value = "创建人")
    private String createBy;
	
	@ApiModelProperty(value = "创建时间")
    private Long createTime;
	
	@ApiModelProperty(value = "修改时间")
    private Long updateTime;
	
	@ApiModelProperty(value = "维修点的标识，IM代码")
    private String imId;
	
	@ApiModelProperty(value = "预计交车时间")
    private Long estimatedDeliveryTime;
	
	@ApiModelProperty(value = "工时费")
    private Integer manHourFee;
	
	@ApiModelProperty(value = "维修材料费")
    private Integer maintenanceMaterialCost;
	
	@ApiModelProperty(value = "")
    private Integer additionalProjectFee;
	
	@ApiModelProperty(value = "服务顾问")
    private String serviceConsultant;
	
	@ApiModelProperty(value = "工单状态 1、待派工、2、已派工、3、已竣工、4：待结算、5：已结算、6：已交车")
    private int status;
	
	@ApiModelProperty(value = "车架号")
    private String vin;
	
	@ApiModelProperty(value = "车牌号")
    private String plateNo;
	
	@ApiModelProperty(value = "车主姓名")
    private String ownerName;
	
	@ApiModelProperty(value = "送修人")
    private String senderName;
	
	@ApiModelProperty(value = "送修人手机号")
    private String senderPhone;
	
	@ApiModelProperty(value = "故障描述最多500个字符")
    private String faultDesc;
	
	@ApiModelProperty(value = "备注最多500个字符")
    private String remark;
	
	@ApiModelProperty(value = "入厂行驶里程")
    private long inMileage;
	
	@ApiModelProperty(value = "出厂行驶里程")
    private long outMileage;
	
	@ApiModelProperty(value = "预计下次保养")
    private String nextMaintenance;
	
	@ApiModelProperty(value = "上次维修日期")
    private String preRepair;
    
	@ApiModelProperty(value = "事故类型，1：小；2:中；3：大")
    private String accidentType;
	
	@ApiModelProperty(value = "保险公司（人保、平安、国寿、太保、其他【备注】）")
    private String insurancCompany;
	
	@ApiModelProperty(value = "保险有效期")
    private String insuranceValidity;
	
	@ApiModelProperty(value = "客户来源（保险公司、客户进店、其他【备注】）")
    private String customersSource;
	
	@ApiModelProperty(value = "终检员")
    private String finalInspector;
	
	@ApiModelProperty(value = "领料状态")
    private int pickingStatus;
	
	@ApiModelProperty(value = "提交结算时间")
    private long submitSettlementTime;
	
	@ApiModelProperty(value = "是否预打印")
    private boolean preprint;
	
	@ApiModelProperty(value = "乐观锁版本")
    private int version;
	
	@ApiModelProperty(value = "购车时间")
    private long buyTime;
	
	@ApiModelProperty(value = "电机号")
    private String motorNo;
	
	@ApiModelProperty(value = "车辆用途")
    private String vehicleUse;
	
	@ApiModelProperty(value = "车型名称")
    private String vehicleModelName;
	
	@ApiModelProperty(value = "车主编号")
    private String ownerCode;
	
	@ApiModelProperty(value = "是否签署免责条款")
    private String exemptionClause;
	
	@ApiModelProperty(value = "交车时间")
    private Long deliveryTime;
	
	@ApiModelProperty(value = "结算单号")
    private String settlementOrderNo;
	
	@ApiModelProperty(value = "最终的金额，去零的金额")
    private int lastMoney;
	
	@ApiModelProperty(value = "三包标识")
    private boolean threeGuarantees;
	
	@ApiModelProperty(value = "上次维修日期")
    private Long lastRepairDate;
	
	@ApiModelProperty(value = "进店方式key")
    private Long enterWay;
	
	@ApiModelProperty(value = "工单类型，To C/To B:11850090/11850095")
    private Long type;
	
	@ApiModelProperty(value = "工单类型，展示/不展示:true/false")
    private boolean displayStatus;
	
	@ApiModelProperty(value = "结算时间")
    private Long settlementTime;
	
	@ApiModelProperty(value = "to_b 工单的 网点编码")
    private String bSc;
	
	@ApiModelProperty(value = "是否质量问题")
    private boolean qualityProblem;
	
	@ApiModelProperty(value = "to_c 工单时的网点编码，暂时系统指驿站")
    private String cSc;
	
	@ApiModelProperty(value = "客户自费的维修材料费")
    private Double cMaintenanceMaterialCost;
	
	@ApiModelProperty(value = "客户自费的附加项目费用")
    private Double cAdditionalProjectFee;
	
	@ApiModelProperty(value = "客户自费的总金额")
    private Double cTotalAmount;
	
	@ApiModelProperty(value = "非保修的维修材料费")
    private Double noneWarrantyMaintenanceMaterialIncome;
	
	@ApiModelProperty(value = "客户自费的工时费")
    private Double cManHourFee;
	
	@ApiModelProperty(value = "工时数量")
    private Double stdTimeAmount;
	
	@ApiModelProperty(value = "配件总成本")
    private Double spTotalCost;
	
	@ApiModelProperty(value = "配件非索赔总成本")
    private Double spNoneGuaranteeCost;
	
	@ApiModelProperty(value = "内部结算工时总费用")
    private Double interWorkHourTotalFee;
	
	@ApiModelProperty(value = "内部结算配件总费用")
    private Double interSpTotalFee;
	
	@ApiModelProperty(value = "索赔类型总金额")
    private Double claimTotalFee;
	
	@ApiModelProperty(value = "GoodWill成本")
    private Double goodwillCost;
	
	@ApiModelProperty(value = "收款状态，待收款、已收款、部分收款")
    private long collectionStatus;
	
	@ApiModelProperty(value = "开票状态（未开票、已开票、申请中）")
    private long invoiceStatus;
	
	@ApiModelProperty(value = "剩余待付金额")
    private int remainingAmount;
	
	@ApiModelProperty(value = "支付中状态（非支付状态 1;支付中状态 2）")
    private String payStatus;
	
	@ApiModelProperty(value = "工单类型")
    private String typeLabel;
	
	@ApiModelProperty(value = "原始单号")
    private String originNo;
	
	@ApiModelProperty(value = "工单状态")
    private String statusLabel;
	
	@ApiModelProperty(value = "维修类型")
    private String maintenanceTypeLabel;
	
	@ApiModelProperty(value = "工时总数")
    private String maintenanceTimeSum;
	
	@ApiModelProperty(value = "总金额")
    private int totalAmount;
	
	@ApiModelProperty(value = "活动数组")
    private String activitys;
	
	@ApiModelProperty(value = "电池包序号")
    private String batterySn;
	
	@ApiModelProperty(value = "电池序列号")
    private String batterySerial;
	
	@ApiModelProperty(value = "电池包型号")
    private String batteryModel;
	
	@ApiModelProperty(value = "网点类型")
    private String siteType;
	
	@ApiModelProperty(value = "颜色")
    private String color;
	
	@ApiModelProperty(value = "打印中的总金额")
    private int bwdAmount;
	
	@ApiModelProperty(value = "")
    private boolean guaranteeOrder;
	
	@ApiModelProperty(value = "内部结算总费用")
    private int interTotalFee;
	
	@ApiModelProperty(value = "保险总费用")
    private int insuranceFee;
	
	@ApiModelProperty(value = "GoodWill总费用")
    private int goodWillFee;
	
	@ApiModelProperty(value = "客户自费总费用")
    private int customerPayFee;
	
	@ApiModelProperty(value = "外采配件收入")
    private int outSpIncome;
	
	@ApiModelProperty(value = "竣工时间")
    private long completeTime;
	
	@ApiModelProperty(value = "可开票金额")
    private int invoicedAmount;
	
	@ApiModelProperty(value = "确认状态 已确认--true; 未确认 -- false")
    private boolean confirmStatus;
	
	@ApiModelProperty(value = "是否已评价 已确认--true; 未确认 -- false")
    private String evaluationStatus;
	
	@ApiModelProperty(value = "确认人")
    private String confirmUser;
	
	@ApiModelProperty(value = "确认人时间")
    private long confirmTime;
	
	@ApiModelProperty(value = "下单人")
    private String orderer;
	
	@ApiModelProperty(value = "下单人姓名")
    private String ordererName;
	
	@ApiModelProperty(value = "下单人电话")
    private String orderPhone;
	
	@ApiModelProperty(value = "主用车人")
    private String mainUser;
	
	@ApiModelProperty(value = "主用车人")
    private String mainUserName;
	
	@ApiModelProperty(value = "主用车人电话")
    private String mainUserPhone;
	
	@ApiModelProperty(value = "授权人")
    private String authorizer;
	
	@ApiModelProperty(value = "授权人姓名")
    private String authorizerName;
	
	@ApiModelProperty(value = "授权人电话")
    private String authorizerPhone;
	
	@ApiModelProperty(value = "实付金额")
    private Double paidAmount;
	
	@ApiModelProperty(value = "折扣金额")
    private String discountAmount;
	
	@ApiModelProperty(value = "内部客户代码：钣喷或服务中心代码")
    private String innerCustomerCode;
	
	@ApiModelProperty(value = "B-APP轨迹ID")
    private String instantId;
	
	@ApiModelProperty(value = "工单区分来源")
    private String workOrderFlag;
	
	@ApiModelProperty(value = "维修项目")
    private String maintenanceItems;
	
	@ApiModelProperty(value = "首次提报日期")
    private String firstDate;
	
	@ApiModelProperty(value = "最新提报日期")
    private String updateDate;
	
	@ApiModelProperty(value = "剩余开票金额")
    private String residueAmount;
	
	@ApiModelProperty(value = "结算确认人")
    private String affirmBy;
	
	@ApiModelProperty(value = "结算确认时间")
    private long affirmTime;
	
	@ApiModelProperty(value = "结算备注")
    private String balanceRemark;
	
	@ApiModelProperty(value = "反结算操作标识 1反结算/0未反结算")
    private int inverseSettlementFlag;
	
	@ApiModelProperty(value = "反结算操作时间")
    private String inverseSettlementTime;
	
	@ApiModelProperty(value = "反结算操作人")
    private String inverseSettlementBy;
	
	@ApiModelProperty(value = "反结算操作人工号")
    private String inverseSettlementEmp;
	
	@ApiModelProperty(value = "反结算操作记录数")
    private int inverseSettlementCount;
	
	@ApiModelProperty(value = "负工单序号")
    private String negativeWorkOrderSort;
	
	@ApiModelProperty(value = "负工单完结操作标识")
    private String negativeOrderFinishFlag;
	
	@ApiModelProperty(value = "授信周期")
    private String creditCycle;
	
	@ApiModelProperty(value = "评价状态")
    private int appraiseStatus;
	
	@ApiModelProperty(value = "满意度中心评价ID")
    private String uscCommentId;
	
	@ApiModelProperty(value = "是否黑名单（ISP的黑名单）")
    private int vehicleBlackFlag;
	
	@ApiModelProperty(value = "关联环检单号")
    private String envOrderNo;
	
	@ApiModelProperty(value = "报价单号")
    private String quoteOrderNo;
	
	@ApiModelProperty(value = "APP是否确认标识")
    private String customerConfirmFlag;
	
	@ApiModelProperty(value = "工单配件的数量")
    private String partsNumber;
	
	@ApiModelProperty(value = "")
    private long invoiceDate;
	
	@ApiModelProperty(value = "")
    private String enterWayLabel;
	
	@ApiModelProperty(value = "")
    private String collectionStatusLabel;
	
	@ApiModelProperty(value = "")
    private String invoiceStatusLabel;
	
	@ApiModelProperty(value = "")
    private String displayStatusLabel;
	
	@ApiModelProperty(value = "")
    private String maintenanceTypeStr;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getWorkOrderNo() {
		return workOrderNo;
	}

	public void setWorkOrderNo(String workOrderNo) {
		this.workOrderNo = workOrderNo;
	}

	public String getReservationNo() {
		return reservationNo;
	}

	public void setReservationNo(String reservationNo) {
		this.reservationNo = reservationNo;
	}

	public String getMaintenanceTypeCode() {
		return maintenanceTypeCode;
	}

	public void setMaintenanceTypeCode(String maintenanceTypeCode) {
		this.maintenanceTypeCode = maintenanceTypeCode;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	public Long getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Long updateTime) {
		this.updateTime = updateTime;
	}

	public String getImId() {
		return imId;
	}

	public void setImId(String imId) {
		this.imId = imId;
	}

	public Long getEstimatedDeliveryTime() {
		return estimatedDeliveryTime;
	}

	public void setEstimatedDeliveryTime(Long estimatedDeliveryTime) {
		this.estimatedDeliveryTime = estimatedDeliveryTime;
	}

	public Integer getManHourFee() {
		return manHourFee;
	}

	public void setManHourFee(Integer manHourFee) {
		this.manHourFee = manHourFee;
	}

	public Integer getMaintenanceMaterialCost() {
		return maintenanceMaterialCost;
	}

	public void setMaintenanceMaterialCost(Integer maintenanceMaterialCost) {
		this.maintenanceMaterialCost = maintenanceMaterialCost;
	}

	public Integer getAdditionalProjectFee() {
		return additionalProjectFee;
	}

	public void setAdditionalProjectFee(Integer additionalProjectFee) {
		this.additionalProjectFee = additionalProjectFee;
	}

	public String getServiceConsultant() {
		return serviceConsultant;
	}

	public void setServiceConsultant(String serviceConsultant) {
		this.serviceConsultant = serviceConsultant;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getPlateNo() {
		return plateNo;
	}

	public void setPlateNo(String plateNo) {
		this.plateNo = plateNo;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getSenderPhone() {
		return senderPhone;
	}

	public void setSenderPhone(String senderPhone) {
		this.senderPhone = senderPhone;
	}

	public String getFaultDesc() {
		return faultDesc;
	}

	public void setFaultDesc(String faultDesc) {
		this.faultDesc = faultDesc;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public long getInMileage() {
		return inMileage;
	}

	public void setInMileage(long inMileage) {
		this.inMileage = inMileage;
	}

	public long getOutMileage() {
		return outMileage;
	}

	public void setOutMileage(long outMileage) {
		this.outMileage = outMileage;
	}

	public String getNextMaintenance() {
		return nextMaintenance;
	}

	public void setNextMaintenance(String nextMaintenance) {
		this.nextMaintenance = nextMaintenance;
	}

	public String getPreRepair() {
		return preRepair;
	}

	public void setPreRepair(String preRepair) {
		this.preRepair = preRepair;
	}

	public String getAccidentType() {
		return accidentType;
	}

	public void setAccidentType(String accidentType) {
		this.accidentType = accidentType;
	}

	public String getInsurancCompany() {
		return insurancCompany;
	}

	public void setInsurancCompany(String insurancCompany) {
		this.insurancCompany = insurancCompany;
	}

	public String getInsuranceValidity() {
		return insuranceValidity;
	}

	public void setInsuranceValidity(String insuranceValidity) {
		this.insuranceValidity = insuranceValidity;
	}

	public String getCustomersSource() {
		return customersSource;
	}

	public void setCustomersSource(String customersSource) {
		this.customersSource = customersSource;
	}

	public String getFinalInspector() {
		return finalInspector;
	}

	public void setFinalInspector(String finalInspector) {
		this.finalInspector = finalInspector;
	}

	public int getPickingStatus() {
		return pickingStatus;
	}

	public void setPickingStatus(int pickingStatus) {
		this.pickingStatus = pickingStatus;
	}

	public long getSubmitSettlementTime() {
		return submitSettlementTime;
	}

	public void setSubmitSettlementTime(long submitSettlementTime) {
		this.submitSettlementTime = submitSettlementTime;
	}

	public boolean isPreprint() {
		return preprint;
	}

	public void setPreprint(boolean preprint) {
		this.preprint = preprint;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public long getBuyTime() {
		return buyTime;
	}

	public void setBuyTime(long buyTime) {
		this.buyTime = buyTime;
	}

	public String getMotorNo() {
		return motorNo;
	}

	public void setMotorNo(String motorNo) {
		this.motorNo = motorNo;
	}

	public String getVehicleUse() {
		return vehicleUse;
	}

	public void setVehicleUse(String vehicleUse) {
		this.vehicleUse = vehicleUse;
	}

	public String getVehicleModelName() {
		return vehicleModelName;
	}

	public void setVehicleModelName(String vehicleModelName) {
		this.vehicleModelName = vehicleModelName;
	}

	public String getOwnerCode() {
		return ownerCode;
	}

	public void setOwnerCode(String ownerCode) {
		this.ownerCode = ownerCode;
	}

	public String getExemptionClause() {
		return exemptionClause;
	}

	public void setExemptionClause(String exemptionClause) {
		this.exemptionClause = exemptionClause;
	}

	public Long getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(Long deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public String getSettlementOrderNo() {
		return settlementOrderNo;
	}

	public void setSettlementOrderNo(String settlementOrderNo) {
		this.settlementOrderNo = settlementOrderNo;
	}

	public int getLastMoney() {
		return lastMoney;
	}

	public void setLastMoney(int lastMoney) {
		this.lastMoney = lastMoney;
	}

	public boolean isThreeGuarantees() {
		return threeGuarantees;
	}

	public void setThreeGuarantees(boolean threeGuarantees) {
		this.threeGuarantees = threeGuarantees;
	}

	public Long getLastRepairDate() {
		return lastRepairDate;
	}

	public void setLastRepairDate(Long lastRepairDate) {
		this.lastRepairDate = lastRepairDate;
	}

	public Long getEnterWay() {
		return enterWay;
	}

	public void setEnterWay(Long enterWay) {
		this.enterWay = enterWay;
	}

	public Long getType() {
		return type;
	}

	public void setType(Long type) {
		this.type = type;
	}

	public boolean isDisplayStatus() {
		return displayStatus;
	}

	public void setDisplayStatus(boolean displayStatus) {
		this.displayStatus = displayStatus;
	}

	public Long getSettlementTime() {
		return settlementTime;
	}

	public void setSettlementTime(Long settlementTime) {
		this.settlementTime = settlementTime;
	}

	public String getbSc() {
		return bSc;
	}

	public void setbSc(String bSc) {
		this.bSc = bSc;
	}

	public boolean isQualityProblem() {
		return qualityProblem;
	}

	public void setQualityProblem(boolean qualityProblem) {
		this.qualityProblem = qualityProblem;
	}

	public String getcSc() {
		return cSc;
	}

	public void setcSc(String cSc) {
		this.cSc = cSc;
	}

	public Double getcMaintenanceMaterialCost() {
		return cMaintenanceMaterialCost;
	}

	public void setcMaintenanceMaterialCost(Double cMaintenanceMaterialCost) {
		this.cMaintenanceMaterialCost = cMaintenanceMaterialCost;
	}

	public Double getcAdditionalProjectFee() {
		return cAdditionalProjectFee;
	}

	public void setcAdditionalProjectFee(Double cAdditionalProjectFee) {
		this.cAdditionalProjectFee = cAdditionalProjectFee;
	}

	public Double getcTotalAmount() {
		return cTotalAmount;
	}

	public void setcTotalAmount(Double cTotalAmount) {
		this.cTotalAmount = cTotalAmount;
	}

	public Double getNoneWarrantyMaintenanceMaterialIncome() {
		return noneWarrantyMaintenanceMaterialIncome;
	}

	public void setNoneWarrantyMaintenanceMaterialIncome(Double noneWarrantyMaintenanceMaterialIncome) {
		this.noneWarrantyMaintenanceMaterialIncome = noneWarrantyMaintenanceMaterialIncome;
	}

	public Double getcManHourFee() {
		return cManHourFee;
	}

	public void setcManHourFee(Double cManHourFee) {
		this.cManHourFee = cManHourFee;
	}

	public Double getStdTimeAmount() {
		return stdTimeAmount;
	}

	public void setStdTimeAmount(Double stdTimeAmount) {
		this.stdTimeAmount = stdTimeAmount;
	}

	public Double getSpTotalCost() {
		return spTotalCost;
	}

	public void setSpTotalCost(Double spTotalCost) {
		this.spTotalCost = spTotalCost;
	}

	public Double getSpNoneGuaranteeCost() {
		return spNoneGuaranteeCost;
	}

	public void setSpNoneGuaranteeCost(Double spNoneGuaranteeCost) {
		this.spNoneGuaranteeCost = spNoneGuaranteeCost;
	}

	public Double getInterWorkHourTotalFee() {
		return interWorkHourTotalFee;
	}

	public void setInterWorkHourTotalFee(Double interWorkHourTotalFee) {
		this.interWorkHourTotalFee = interWorkHourTotalFee;
	}

	public Double getInterSpTotalFee() {
		return interSpTotalFee;
	}

	public void setInterSpTotalFee(Double interSpTotalFee) {
		this.interSpTotalFee = interSpTotalFee;
	}

	public Double getClaimTotalFee() {
		return claimTotalFee;
	}

	public void setClaimTotalFee(Double claimTotalFee) {
		this.claimTotalFee = claimTotalFee;
	}

	public Double getGoodwillCost() {
		return goodwillCost;
	}

	public void setGoodwillCost(Double goodwillCost) {
		this.goodwillCost = goodwillCost;
	}

	public long getCollectionStatus() {
		return collectionStatus;
	}

	public void setCollectionStatus(long collectionStatus) {
		this.collectionStatus = collectionStatus;
	}

	public long getInvoiceStatus() {
		return invoiceStatus;
	}

	public void setInvoiceStatus(long invoiceStatus) {
		this.invoiceStatus = invoiceStatus;
	}

	public int getRemainingAmount() {
		return remainingAmount;
	}

	public void setRemainingAmount(int remainingAmount) {
		this.remainingAmount = remainingAmount;
	}

	public String getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}

	public String getTypeLabel() {
		return typeLabel;
	}

	public void setTypeLabel(String typeLabel) {
		this.typeLabel = typeLabel;
	}

	public String getOriginNo() {
		return originNo;
	}

	public void setOriginNo(String originNo) {
		this.originNo = originNo;
	}

	public String getStatusLabel() {
		return statusLabel;
	}

	public void setStatusLabel(String statusLabel) {
		this.statusLabel = statusLabel;
	}

	public String getMaintenanceTypeLabel() {
		return maintenanceTypeLabel;
	}

	public void setMaintenanceTypeLabel(String maintenanceTypeLabel) {
		this.maintenanceTypeLabel = maintenanceTypeLabel;
	}

	public String getMaintenanceTimeSum() {
		return maintenanceTimeSum;
	}

	public void setMaintenanceTimeSum(String maintenanceTimeSum) {
		this.maintenanceTimeSum = maintenanceTimeSum;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getActivitys() {
		return activitys;
	}

	public void setActivitys(String activitys) {
		this.activitys = activitys;
	}

	public String getBatterySn() {
		return batterySn;
	}

	public void setBatterySn(String batterySn) {
		this.batterySn = batterySn;
	}

	public String getBatterySerial() {
		return batterySerial;
	}

	public void setBatterySerial(String batterySerial) {
		this.batterySerial = batterySerial;
	}

	public String getBatteryModel() {
		return batteryModel;
	}

	public void setBatteryModel(String batteryModel) {
		this.batteryModel = batteryModel;
	}

	public String getSiteType() {
		return siteType;
	}

	public void setSiteType(String siteType) {
		this.siteType = siteType;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getBwdAmount() {
		return bwdAmount;
	}

	public void setBwdAmount(int bwdAmount) {
		this.bwdAmount = bwdAmount;
	}

	public boolean isGuaranteeOrder() {
		return guaranteeOrder;
	}

	public void setGuaranteeOrder(boolean guaranteeOrder) {
		this.guaranteeOrder = guaranteeOrder;
	}

	public int getInterTotalFee() {
		return interTotalFee;
	}

	public void setInterTotalFee(int interTotalFee) {
		this.interTotalFee = interTotalFee;
	}

	public int getInsuranceFee() {
		return insuranceFee;
	}

	public void setInsuranceFee(int insuranceFee) {
		this.insuranceFee = insuranceFee;
	}

	public int getGoodWillFee() {
		return goodWillFee;
	}

	public void setGoodWillFee(int goodWillFee) {
		this.goodWillFee = goodWillFee;
	}

	public int getCustomerPayFee() {
		return customerPayFee;
	}

	public void setCustomerPayFee(int customerPayFee) {
		this.customerPayFee = customerPayFee;
	}

	public int getOutSpIncome() {
		return outSpIncome;
	}

	public void setOutSpIncome(int outSpIncome) {
		this.outSpIncome = outSpIncome;
	}

	public long getCompleteTime() {
		return completeTime;
	}

	public void setCompleteTime(long completeTime) {
		this.completeTime = completeTime;
	}

	public int getInvoicedAmount() {
		return invoicedAmount;
	}

	public void setInvoicedAmount(int invoicedAmount) {
		this.invoicedAmount = invoicedAmount;
	}

	public boolean isConfirmStatus() {
		return confirmStatus;
	}

	public void setConfirmStatus(boolean confirmStatus) {
		this.confirmStatus = confirmStatus;
	}

	public String getEvaluationStatus() {
		return evaluationStatus;
	}

	public void setEvaluationStatus(String evaluationStatus) {
		this.evaluationStatus = evaluationStatus;
	}

	public String getConfirmUser() {
		return confirmUser;
	}

	public void setConfirmUser(String confirmUser) {
		this.confirmUser = confirmUser;
	}

	public long getConfirmTime() {
		return confirmTime;
	}

	public void setConfirmTime(long confirmTime) {
		this.confirmTime = confirmTime;
	}

	public String getOrderer() {
		return orderer;
	}

	public void setOrderer(String orderer) {
		this.orderer = orderer;
	}

	public String getOrdererName() {
		return ordererName;
	}

	public void setOrdererName(String ordererName) {
		this.ordererName = ordererName;
	}

	public String getOrderPhone() {
		return orderPhone;
	}

	public void setOrderPhone(String orderPhone) {
		this.orderPhone = orderPhone;
	}

	public String getMainUser() {
		return mainUser;
	}

	public void setMainUser(String mainUser) {
		this.mainUser = mainUser;
	}

	public String getMainUserName() {
		return mainUserName;
	}

	public void setMainUserName(String mainUserName) {
		this.mainUserName = mainUserName;
	}

	public String getMainUserPhone() {
		return mainUserPhone;
	}

	public void setMainUserPhone(String mainUserPhone) {
		this.mainUserPhone = mainUserPhone;
	}

	public String getAuthorizer() {
		return authorizer;
	}

	public void setAuthorizer(String authorizer) {
		this.authorizer = authorizer;
	}

	public String getAuthorizerName() {
		return authorizerName;
	}

	public void setAuthorizerName(String authorizerName) {
		this.authorizerName = authorizerName;
	}

	public String getAuthorizerPhone() {
		return authorizerPhone;
	}

	public void setAuthorizerPhone(String authorizerPhone) {
		this.authorizerPhone = authorizerPhone;
	}

	public Double getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(Double paidAmount) {
		this.paidAmount = paidAmount;
	}

	public String getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(String discountAmount) {
		this.discountAmount = discountAmount;
	}

	public String getInnerCustomerCode() {
		return innerCustomerCode;
	}

	public void setInnerCustomerCode(String innerCustomerCode) {
		this.innerCustomerCode = innerCustomerCode;
	}

	public String getInstantId() {
		return instantId;
	}

	public void setInstantId(String instantId) {
		this.instantId = instantId;
	}

	public String getWorkOrderFlag() {
		return workOrderFlag;
	}

	public void setWorkOrderFlag(String workOrderFlag) {
		this.workOrderFlag = workOrderFlag;
	}

	public String getMaintenanceItems() {
		return maintenanceItems;
	}

	public void setMaintenanceItems(String maintenanceItems) {
		this.maintenanceItems = maintenanceItems;
	}

	public String getFirstDate() {
		return firstDate;
	}

	public void setFirstDate(String firstDate) {
		this.firstDate = firstDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getResidueAmount() {
		return residueAmount;
	}

	public void setResidueAmount(String residueAmount) {
		this.residueAmount = residueAmount;
	}

	public String getAffirmBy() {
		return affirmBy;
	}

	public void setAffirmBy(String affirmBy) {
		this.affirmBy = affirmBy;
	}

	public long getAffirmTime() {
		return affirmTime;
	}

	public void setAffirmTime(long affirmTime) {
		this.affirmTime = affirmTime;
	}

	public String getBalanceRemark() {
		return balanceRemark;
	}

	public void setBalanceRemark(String balanceRemark) {
		this.balanceRemark = balanceRemark;
	}

	public int getInverseSettlementFlag() {
		return inverseSettlementFlag;
	}

	public void setInverseSettlementFlag(int inverseSettlementFlag) {
		this.inverseSettlementFlag = inverseSettlementFlag;
	}

	public String getInverseSettlementTime() {
		return inverseSettlementTime;
	}

	public void setInverseSettlementTime(String inverseSettlementTime) {
		this.inverseSettlementTime = inverseSettlementTime;
	}

	public String getInverseSettlementBy() {
		return inverseSettlementBy;
	}

	public void setInverseSettlementBy(String inverseSettlementBy) {
		this.inverseSettlementBy = inverseSettlementBy;
	}

	public String getInverseSettlementEmp() {
		return inverseSettlementEmp;
	}

	public void setInverseSettlementEmp(String inverseSettlementEmp) {
		this.inverseSettlementEmp = inverseSettlementEmp;
	}

	public int getInverseSettlementCount() {
		return inverseSettlementCount;
	}

	public void setInverseSettlementCount(int inverseSettlementCount) {
		this.inverseSettlementCount = inverseSettlementCount;
	}

	public String getNegativeWorkOrderSort() {
		return negativeWorkOrderSort;
	}

	public void setNegativeWorkOrderSort(String negativeWorkOrderSort) {
		this.negativeWorkOrderSort = negativeWorkOrderSort;
	}

	public String getNegativeOrderFinishFlag() {
		return negativeOrderFinishFlag;
	}

	public void setNegativeOrderFinishFlag(String negativeOrderFinishFlag) {
		this.negativeOrderFinishFlag = negativeOrderFinishFlag;
	}

	public String getCreditCycle() {
		return creditCycle;
	}

	public void setCreditCycle(String creditCycle) {
		this.creditCycle = creditCycle;
	}

	public int getAppraiseStatus() {
		return appraiseStatus;
	}

	public void setAppraiseStatus(int appraiseStatus) {
		this.appraiseStatus = appraiseStatus;
	}

	public String getUscCommentId() {
		return uscCommentId;
	}

	public void setUscCommentId(String uscCommentId) {
		this.uscCommentId = uscCommentId;
	}

	public int getVehicleBlackFlag() {
		return vehicleBlackFlag;
	}

	public void setVehicleBlackFlag(int vehicleBlackFlag) {
		this.vehicleBlackFlag = vehicleBlackFlag;
	}

	public String getEnvOrderNo() {
		return envOrderNo;
	}

	public void setEnvOrderNo(String envOrderNo) {
		this.envOrderNo = envOrderNo;
	}

	public String getQuoteOrderNo() {
		return quoteOrderNo;
	}

	public void setQuoteOrderNo(String quoteOrderNo) {
		this.quoteOrderNo = quoteOrderNo;
	}

	public String getCustomerConfirmFlag() {
		return customerConfirmFlag;
	}

	public void setCustomerConfirmFlag(String customerConfirmFlag) {
		this.customerConfirmFlag = customerConfirmFlag;
	}

	public String getPartsNumber() {
		return partsNumber;
	}

	public void setPartsNumber(String partsNumber) {
		this.partsNumber = partsNumber;
	}

	public long getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(long invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public String getEnterWayLabel() {
		return enterWayLabel;
	}

	public void setEnterWayLabel(String enterWayLabel) {
		this.enterWayLabel = enterWayLabel;
	}

	public String getCollectionStatusLabel() {
		return collectionStatusLabel;
	}

	public void setCollectionStatusLabel(String collectionStatusLabel) {
		this.collectionStatusLabel = collectionStatusLabel;
	}

	public String getInvoiceStatusLabel() {
		return invoiceStatusLabel;
	}

	public void setInvoiceStatusLabel(String invoiceStatusLabel) {
		this.invoiceStatusLabel = invoiceStatusLabel;
	}

	public String getDisplayStatusLabel() {
		return displayStatusLabel;
	}

	public void setDisplayStatusLabel(String displayStatusLabel) {
		this.displayStatusLabel = displayStatusLabel;
	}

	public String getMaintenanceTypeStr() {
		return maintenanceTypeStr;
	}

	public void setMaintenanceTypeStr(String maintenanceTypeStr) {
		this.maintenanceTypeStr = maintenanceTypeStr;
	}

}
