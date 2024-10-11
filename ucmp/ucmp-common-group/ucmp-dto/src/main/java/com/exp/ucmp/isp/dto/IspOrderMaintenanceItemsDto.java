package com.exp.ucmp.isp.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "IspOrderMaintenanceItemsDto", description = "isp报价单申请返回类")
public class IspOrderMaintenanceItemsDto {
	
	@ApiModelProperty(value = "concern号")
	private String concernCode;
	
	@ApiModelProperty(value = "索赔，客户付费，内部结算、保险")
    private Integer feeDifferentiation;
	
	@ApiModelProperty(value = "服务活动")
    private String activityNo;
	
	@ApiModelProperty(value = "费用区分中文")
    private String feeDifferentiationLabel;
	
	@ApiModelProperty(value = "主键")
    private Long id;
	
	@ApiModelProperty(value = "项目代码")
    private String code;
	
	@ApiModelProperty(value = "项目名称")
    private String name;
	
	@ApiModelProperty(value = "维修分类代码")
    private String maintenanceTypeCode;
	
	@ApiModelProperty(value = "标准工时")
    private Float stdTime;
	
	@ApiModelProperty(value = "工时单价")
    private Double manHour;
	
	@ApiModelProperty(value = "工时费")
    private Double manHourFee;
	
	@ApiModelProperty(value = "技师")
    private String technician;
	
	@ApiModelProperty(value = "维修分类中文")
    private String maintenanceTypeLabel;
	
	@ApiModelProperty(value = "折扣")
    private Double discount;
	
	@ApiModelProperty(value = "总价")
    private Double totalPrice;
	
	@ApiModelProperty(value = "工单号")
    private String workOrderNo;
	
	@ApiModelProperty(value = "应收金额")
    private Double receivePrice;
	
	@ApiModelProperty(value = "优惠金额")
    private Double preferentialPrice;
	
	@ApiModelProperty(value = "开工时间")
    private long beginTime;
	
	@ApiModelProperty(value = "预计完成时间")
    private long expectedFinishTime;
	
	@ApiModelProperty(value = "实际完成时间")
    private long realFinishTime;
	
	@ApiModelProperty(value = "质检员")
    private String qualityInspector;
	
	@ApiModelProperty(value = "质检员代码")
    private String qualityInspectorCode;
	
	@ApiModelProperty(value = "派工工位")
    private String stationName;
	
	@ApiModelProperty(value = "技工代码")
    private String technicianCode;
	
	@ApiModelProperty(value = "维修项目状态 1、待派工、2、已派工、3、已完工")
    private int status;
	
	@ApiModelProperty(value = "是否增项")
    private boolean addItem;
	
	@ApiModelProperty(value = "派工时间")
    private long assignTime;
	
	@ApiModelProperty(value = "工作描述")
    private String workDesc;
	
	@ApiModelProperty(value = "根本原因")
    private String rootCause;
	
	@ApiModelProperty(value = "组合代码")
    private String mType;
	
	@ApiModelProperty(value = "组合代码")
    private String groupCode;
	
	@ApiModelProperty(value = "行号")
    private String posnr;
	
    private String cDesc;
    
    @ApiModelProperty(value = "主损件代码")
    private String mainHarmCode;
    
    @ApiModelProperty(value = "主损件名称")
    private String mainHarmName;
    
    @ApiModelProperty(value = "活动分类")
    private String activityCategory;
    
    @ApiModelProperty(value = "折扣金额")
    private Double discountMoney;
    
    @ApiModelProperty(value = "卡券主数据ID")
    private String couponMetaId;
    
    @ApiModelProperty(value = "卡券ID")
    private String couponId;
    
    @ApiModelProperty(value = "自动索赔单号")
    private String autoClaimNo;
    
    @ApiModelProperty(value = "卡券名称")
    private String couponName;
    
    @ApiModelProperty(value = "卡券用户ID")
    private String userId;
    
    @ApiModelProperty(value = "卡券用户姓名")
    private String userName;
    
    @ApiModelProperty(value = "")
    private long mtype;
    
    @ApiModelProperty(value = "")
    private String mtypeLabel;
    
    @ApiModelProperty(value = "")
    private String cdesc;

	public String getConcernCode() {
		return concernCode;
	}

	public void setConcernCode(String concernCode) {
		this.concernCode = concernCode;
	}

	public Integer getFeeDifferentiation() {
		return feeDifferentiation;
	}

	public void setFeeDifferentiation(Integer feeDifferentiation) {
		this.feeDifferentiation = feeDifferentiation;
	}

	public String getActivityNo() {
		return activityNo;
	}

	public void setActivityNo(String activityNo) {
		this.activityNo = activityNo;
	}

	public String getFeeDifferentiationLabel() {
		return feeDifferentiationLabel;
	}

	public void setFeeDifferentiationLabel(String feeDifferentiationLabel) {
		this.feeDifferentiationLabel = feeDifferentiationLabel;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMaintenanceTypeCode() {
		return maintenanceTypeCode;
	}

	public void setMaintenanceTypeCode(String maintenanceTypeCode) {
		this.maintenanceTypeCode = maintenanceTypeCode;
	}

	public Float getStdTime() {
		return stdTime;
	}

	public void setStdTime(Float stdTime) {
		this.stdTime = stdTime;
	}

	public Double getManHour() {
		return manHour;
	}

	public void setManHour(Double manHour) {
		this.manHour = manHour;
	}

	public Double getManHourFee() {
		return manHourFee;
	}

	public void setManHourFee(Double manHourFee) {
		this.manHourFee = manHourFee;
	}

	public String getTechnician() {
		return technician;
	}

	public void setTechnician(String technician) {
		this.technician = technician;
	}

	public String getMaintenanceTypeLabel() {
		return maintenanceTypeLabel;
	}

	public void setMaintenanceTypeLabel(String maintenanceTypeLabel) {
		this.maintenanceTypeLabel = maintenanceTypeLabel;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getWorkOrderNo() {
		return workOrderNo;
	}

	public void setWorkOrderNo(String workOrderNo) {
		this.workOrderNo = workOrderNo;
	}

	public Double getReceivePrice() {
		return receivePrice;
	}

	public void setReceivePrice(Double receivePrice) {
		this.receivePrice = receivePrice;
	}

	public Double getPreferentialPrice() {
		return preferentialPrice;
	}

	public void setPreferentialPrice(Double preferentialPrice) {
		this.preferentialPrice = preferentialPrice;
	}

	public long getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(long beginTime) {
		this.beginTime = beginTime;
	}

	public long getExpectedFinishTime() {
		return expectedFinishTime;
	}

	public void setExpectedFinishTime(long expectedFinishTime) {
		this.expectedFinishTime = expectedFinishTime;
	}

	public long getRealFinishTime() {
		return realFinishTime;
	}

	public void setRealFinishTime(long realFinishTime) {
		this.realFinishTime = realFinishTime;
	}

	public String getQualityInspector() {
		return qualityInspector;
	}

	public void setQualityInspector(String qualityInspector) {
		this.qualityInspector = qualityInspector;
	}

	public String getQualityInspectorCode() {
		return qualityInspectorCode;
	}

	public void setQualityInspectorCode(String qualityInspectorCode) {
		this.qualityInspectorCode = qualityInspectorCode;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public String getTechnicianCode() {
		return technicianCode;
	}

	public void setTechnicianCode(String technicianCode) {
		this.technicianCode = technicianCode;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public boolean isAddItem() {
		return addItem;
	}

	public void setAddItem(boolean addItem) {
		this.addItem = addItem;
	}

	public long getAssignTime() {
		return assignTime;
	}

	public void setAssignTime(long assignTime) {
		this.assignTime = assignTime;
	}

	public String getWorkDesc() {
		return workDesc;
	}

	public void setWorkDesc(String workDesc) {
		this.workDesc = workDesc;
	}

	public String getRootCause() {
		return rootCause;
	}

	public void setRootCause(String rootCause) {
		this.rootCause = rootCause;
	}

	public String getmType() {
		return mType;
	}

	public void setmType(String mType) {
		this.mType = mType;
	}

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	public String getPosnr() {
		return posnr;
	}

	public void setPosnr(String posnr) {
		this.posnr = posnr;
	}

	public String getcDesc() {
		return cDesc;
	}

	public void setcDesc(String cDesc) {
		this.cDesc = cDesc;
	}

	public String getMainHarmCode() {
		return mainHarmCode;
	}

	public void setMainHarmCode(String mainHarmCode) {
		this.mainHarmCode = mainHarmCode;
	}

	public String getMainHarmName() {
		return mainHarmName;
	}

	public void setMainHarmName(String mainHarmName) {
		this.mainHarmName = mainHarmName;
	}

	public String getActivityCategory() {
		return activityCategory;
	}

	public void setActivityCategory(String activityCategory) {
		this.activityCategory = activityCategory;
	}

	public Double getDiscountMoney() {
		return discountMoney;
	}

	public void setDiscountMoney(Double discountMoney) {
		this.discountMoney = discountMoney;
	}

	public String getCouponMetaId() {
		return couponMetaId;
	}

	public void setCouponMetaId(String couponMetaId) {
		this.couponMetaId = couponMetaId;
	}

	public String getCouponId() {
		return couponId;
	}

	public void setCouponId(String couponId) {
		this.couponId = couponId;
	}

	public String getAutoClaimNo() {
		return autoClaimNo;
	}

	public void setAutoClaimNo(String autoClaimNo) {
		this.autoClaimNo = autoClaimNo;
	}

	public String getCouponName() {
		return couponName;
	}

	public void setCouponName(String couponName) {
		this.couponName = couponName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public long getMtype() {
		return mtype;
	}

	public void setMtype(long mtype) {
		this.mtype = mtype;
	}

	public String getMtypeLabel() {
		return mtypeLabel;
	}

	public void setMtypeLabel(String mtypeLabel) {
		this.mtypeLabel = mtypeLabel;
	}

	public String getCdesc() {
		return cdesc;
	}

	public void setCdesc(String cdesc) {
		this.cdesc = cdesc;
	}

}
