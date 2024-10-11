package com.exp.ucmp.carService.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "QueryServiceDto", description = "整备列表查询Dto")
public class QueryServiceDto{
	
	@ApiModelProperty(value = "整备id")
	private Long serviceId;
	
	@ApiModelProperty(value = "库存车辆id")
	private Long stockId;

    @ApiModelProperty(value = "整备单号")
    private String serviceNumber;
    
    @ApiModelProperty(value = "车辆所在仓库名称")
    private String storageName;
    
    @ApiModelProperty(value = "车辆来源code")
    private String carSource;
    
    @ApiModelProperty(value = "车辆来源名称")
    private String carSourceName;
    
    @ApiModelProperty(value = "库存类型code")
    private String stockType;
    
    @ApiModelProperty(value = "库存类型名称")
    private String stockTypeName;
    
    @ApiModelProperty(value = "车源批次")
    private String sourceBatch;
    
    @ApiModelProperty(value = "归属主体code")
    private String revertBody;
    
    @ApiModelProperty(value = "归属主体名称")
    private String revertBodyName;
    
    @ApiModelProperty(value = "VIN")
    private String vinCode;
    
    @ApiModelProperty(value = "决策类型code")
    private String decisionType;
    
    @ApiModelProperty(value = "决策类型名称")
    private String decisionTypeName;
    
    @ApiModelProperty(value = "整备发起时间")
    private String startDate;

    @ApiModelProperty(value = "整备发起人姓名")
    private String startPeople;
    
    @ApiModelProperty(value = "预计交车时间")
    private String planCompleteDate;

    @ApiModelProperty(value = "工程车型")
    private String carSeriesName;
    
    @ApiModelProperty(value = "基础车型")
    private String baseCarTypeName;
    
    @ApiModelProperty(value = "基础车型")
    private String carColour;
    
    @ApiModelProperty(value = "整备单状态(5301:待反馈 5302:已反馈-待审批 5303:已通过-施工中 5304:有增项-待审批 5306:整备完成 5308:驳回 5309:放弃整备-转批售  5311:反结算)")
    private String serviceState;
    
    @ApiModelProperty(value = "整备单状态名称")
    private String serviceStateName;
    
    @ApiModelProperty(value = "是否反结算 1 否 2是")
    private int isSettlement;

	public Long getServiceId() {
		return serviceId;
	}

	public void setServiceId(Long serviceId) {
		this.serviceId = serviceId;
	}

	public Long getStockId() {
		return stockId;
	}

	public void setStockId(Long stockId) {
		this.stockId = stockId;
	}

	public String getServiceNumber() {
		return serviceNumber;
	}

	public void setServiceNumber(String serviceNumber) {
		this.serviceNumber = serviceNumber;
	}

	public String getStorageName() {
		return storageName;
	}

	public void setStorageName(String storageName) {
		this.storageName = storageName;
	}

	public String getCarSource() {
		return carSource;
	}

	public void setCarSource(String carSource) {
		this.carSource = carSource;
	}

	public String getCarSourceName() {
		return carSourceName;
	}

	public void setCarSourceName(String carSourceName) {
		this.carSourceName = carSourceName;
	}

	public String getStockType() {
		return stockType;
	}

	public void setStockType(String stockType) {
		this.stockType = stockType;
	}

	public String getStockTypeName() {
		return stockTypeName;
	}

	public void setStockTypeName(String stockTypeName) {
		this.stockTypeName = stockTypeName;
	}

	public String getSourceBatch() {
		return sourceBatch;
	}

	public void setSourceBatch(String sourceBatch) {
		this.sourceBatch = sourceBatch;
	}

	public String getRevertBody() {
		return revertBody;
	}

	public void setRevertBody(String revertBody) {
		this.revertBody = revertBody;
	}

	public String getRevertBodyName() {
		return revertBodyName;
	}

	public void setRevertBodyName(String revertBodyName) {
		this.revertBodyName = revertBodyName;
	}

	public String getVinCode() {
		return vinCode;
	}

	public void setVinCode(String vinCode) {
		this.vinCode = vinCode;
	}

	public String getDecisionType() {
		return decisionType;
	}

	public void setDecisionType(String decisionType) {
		this.decisionType = decisionType;
	}

	public String getDecisionTypeName() {
		return decisionTypeName;
	}

	public void setDecisionTypeName(String decisionTypeName) {
		this.decisionTypeName = decisionTypeName;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getStartPeople() {
		return startPeople;
	}

	public void setStartPeople(String startPeople) {
		this.startPeople = startPeople;
	}

	public String getPlanCompleteDate() {
		return planCompleteDate;
	}

	public void setPlanCompleteDate(String planCompleteDate) {
		this.planCompleteDate = planCompleteDate;
	}

	public String getCarSeriesName() {
		return carSeriesName;
	}

	public void setCarSeriesName(String carSeriesName) {
		this.carSeriesName = carSeriesName;
	}

	public String getBaseCarTypeName() {
		return baseCarTypeName;
	}

	public void setBaseCarTypeName(String baseCarTypeName) {
		this.baseCarTypeName = baseCarTypeName;
	}

	public String getCarColour() {
		return carColour;
	}

	public void setCarColour(String carColour) {
		this.carColour = carColour;
	}

	public String getServiceState() {
		return serviceState;
	}

	public void setServiceState(String serviceState) {
		this.serviceState = serviceState;
	}

	public String getServiceStateName() {
		return serviceStateName;
	}

	public void setServiceStateName(String serviceStateName) {
		this.serviceStateName = serviceStateName;
	}

	public int getIsSettlement() {
		return isSettlement;
	}

	public void setIsSettlement(int isSettlement) {
		this.isSettlement = isSettlement;
	}

}
