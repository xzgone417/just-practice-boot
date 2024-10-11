package com.exp.ucmp.carService.dto;

import java.util.List;

import com.exp.ucmp.isp.dto.QuoteProjectDto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "QueryServiceDetailsDto", description = "整备单详情Dto")
public class QueryServiceDetailsDto{
	
	@ApiModelProperty(value = "整备id")
	private Long serviceId;
	
	@ApiModelProperty(value = "库存车辆id")
	private Long stockId;
	
	@ApiModelProperty(value = "报价单id")
	private Long quoteOrderId;

    @ApiModelProperty(value = "整备单号")
    private String serviceNumber;
    
    @ApiModelProperty(value = "基础车型")
    private String baseCarTypeName;
    
    @ApiModelProperty(value = "VIN")
    private String vinCode;
    
    @ApiModelProperty(value = "车辆类型名称")
    private String carTypeName;
    
    @ApiModelProperty(value = "车辆所在仓库名称")
    private String storageName;
    
    @ApiModelProperty(value = "整备发起人姓名")
    private String startPeople;
    
    @ApiModelProperty(value = "整备发起开始时间")
    private String startDate;
    
    @ApiModelProperty(value = "网点名称")
	private String siteName;
    
    @ApiModelProperty(value = "期望交车时间")
	private String expectDeliveryTime;
    
    @ApiModelProperty(value = "ISP反馈时间")
    private String feedbackDate;
    
    @ApiModelProperty(value = "ISP的报价单号")
    private String quoteOrderNo;
    
    @ApiModelProperty(value = "预估交车时间")
    private String planCompleteDate;
    
    @ApiModelProperty(value = "实际完工时间")
    private String completeDate;

    @ApiModelProperty(value = "整备入库时间")
    private String warehousDate;

    @ApiModelProperty(value = "入库人")
    private String warehousPeopleName;
    
    @ApiModelProperty(value = "整备单状态(5301:待反馈 5302:已反馈-待审批 5303:已通过-施工中 5304:有增项-待审批 5306:整备完成 5308:驳回 5309:放弃整备-转批售  5311:反结算)")
    private String serviceState;
    
    @ApiModelProperty(value = "整备单状态名称")
    private String serviceStateName;
    
    @ApiModelProperty(value = "整备总金额")
    private Double totalPrice;
    
    @ApiModelProperty(value = "审批结果:0-通过,1-驳回,2-放弃整备,3-没有审批结果")
    private int approveResult;
    
    @ApiModelProperty(value = "审批备注")
    private String approveRemark;
    
    @ApiModelProperty(value = "最后一次审批时的状态")
    private String preApprovalStatus;

    @ApiModelProperty(value = "维修项目数据")
    private List<QuoteProjectDto> projectList;
    
    @ApiModelProperty(value = "审批记录")
    private List<ServiceApproveRecordDto> recordList;
    
    @ApiModelProperty(value = "维修工单号")
    private String workOrderNo;

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

	public Long getQuoteOrderId() {
		return quoteOrderId;
	}

	public void setQuoteOrderId(Long quoteOrderId) {
		this.quoteOrderId = quoteOrderId;
	}

	public String getServiceNumber() {
		return serviceNumber;
	}

	public void setServiceNumber(String serviceNumber) {
		this.serviceNumber = serviceNumber;
	}

	public String getBaseCarTypeName() {
		return baseCarTypeName;
	}

	public void setBaseCarTypeName(String baseCarTypeName) {
		this.baseCarTypeName = baseCarTypeName;
	}

	public String getVinCode() {
		return vinCode;
	}

	public void setVinCode(String vinCode) {
		this.vinCode = vinCode;
	}

	public String getCarTypeName() {
		return carTypeName;
	}

	public void setCarTypeName(String carTypeName) {
		this.carTypeName = carTypeName;
	}

	public String getStorageName() {
		return storageName;
	}

	public void setStorageName(String storageName) {
		this.storageName = storageName;
	}

	public String getStartPeople() {
		return startPeople;
	}

	public void setStartPeople(String startPeople) {
		this.startPeople = startPeople;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public String getExpectDeliveryTime() {
		return expectDeliveryTime;
	}

	public void setExpectDeliveryTime(String expectDeliveryTime) {
		this.expectDeliveryTime = expectDeliveryTime;
	}

	public String getFeedbackDate() {
		return feedbackDate;
	}

	public void setFeedbackDate(String feedbackDate) {
		this.feedbackDate = feedbackDate;
	}

	public String getQuoteOrderNo() {
		return quoteOrderNo;
	}

	public void setQuoteOrderNo(String quoteOrderNo) {
		this.quoteOrderNo = quoteOrderNo;
	}

	public String getPlanCompleteDate() {
		return planCompleteDate;
	}

	public void setPlanCompleteDate(String planCompleteDate) {
		this.planCompleteDate = planCompleteDate;
	}

	public String getCompleteDate() {
		return completeDate;
	}

	public void setCompleteDate(String completeDate) {
		this.completeDate = completeDate;
	}

	public String getWarehousDate() {
		return warehousDate;
	}

	public void setWarehousDate(String warehousDate) {
		this.warehousDate = warehousDate;
	}

	public String getWarehousPeopleName() {
		return warehousPeopleName;
	}

	public void setWarehousPeopleName(String warehousPeopleName) {
		this.warehousPeopleName = warehousPeopleName;
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

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getApproveResult() {
		return approveResult;
	}

	public void setApproveResult(int approveResult) {
		this.approveResult = approveResult;
	}

	public String getApproveRemark() {
		return approveRemark;
	}

	public void setApproveRemark(String approveRemark) {
		this.approveRemark = approveRemark;
	}

	public String getPreApprovalStatus() {
		return preApprovalStatus;
	}

	public void setPreApprovalStatus(String preApprovalStatus) {
		this.preApprovalStatus = preApprovalStatus;
	}

	public List<QuoteProjectDto> getProjectList() {
		return projectList;
	}

	public void setProjectList(List<QuoteProjectDto> projectList) {
		this.projectList = projectList;
	}

	public List<ServiceApproveRecordDto> getRecordList() {
		return recordList;
	}

	public void setRecordList(List<ServiceApproveRecordDto> recordList) {
		this.recordList = recordList;
	}

	public String getWorkOrderNo() {
		return workOrderNo;
	}

	public void setWorkOrderNo(String workOrderNo) {
		this.workOrderNo = workOrderNo;
	}
    
}
