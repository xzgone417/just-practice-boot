package com.exp.ucmp.salesDelivery.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "OrderCarTransferInfoDto", description = "订单车辆调拨申请详情")
public class OrderCarTransferInfoDto {
	
	@ApiModelProperty(value = "订单id")
	private Long orderInfoId;
	
	@ApiModelProperty(value = "调拨申请id")
	private Long transferApplyId;
	
	@ApiModelProperty(value = "目标仓储id")
	private Long goalStorageId;
	
	@ApiModelProperty(value = "目标仓储名称")
	private String goalStorageName;
	
	@ApiModelProperty(value = "期望开始调拨日期")
	private String startTime;
	
	@ApiModelProperty(value = "期望到达日期")
	private String expectedTime;
	
	@ApiModelProperty(value = "调拨类型")
	private String transferType;
	
	@ApiModelProperty(value = "调拨类型名称")
	private String transferTypeName;
	
	@ApiModelProperty(value = "调拨理由")
	private String marks;
	
	@ApiModelProperty(value = "是否已提交总部 03保存 其它 交付端已提交")
    private String isSubmit;
	
	@ApiModelProperty(value = "调拨状态(5201:待发运/5202:已调度/5203:待发运出库/5204:已出库/5205:运输中/5206:到达待入库/5207:已入库/5208:等待取消中/5209:已取消)")
	private String transferStatus;
	
	@ApiModelProperty(value = "调拨状态名称")
	private String transferStatusName;

	public Long getOrderInfoId() {
		return orderInfoId;
	}

	public void setOrderInfoId(Long orderInfoId) {
		this.orderInfoId = orderInfoId;
	}

	public Long getTransferApplyId() {
		return transferApplyId;
	}

	public void setTransferApplyId(Long transferApplyId) {
		this.transferApplyId = transferApplyId;
	}

	public Long getGoalStorageId() {
		return goalStorageId;
	}

	public void setGoalStorageId(Long goalStorageId) {
		this.goalStorageId = goalStorageId;
	}

	public String getGoalStorageName() {
		return goalStorageName;
	}

	public void setGoalStorageName(String goalStorageName) {
		this.goalStorageName = goalStorageName;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getExpectedTime() {
		return expectedTime;
	}

	public void setExpectedTime(String expectedTime) {
		this.expectedTime = expectedTime;
	}

	public String getTransferType() {
		return transferType;
	}

	public void setTransferType(String transferType) {
		this.transferType = transferType;
	}

	public String getTransferTypeName() {
		return transferTypeName;
	}

	public void setTransferTypeName(String transferTypeName) {
		this.transferTypeName = transferTypeName;
	}

	public String getMarks() {
		return marks;
	}

	public void setMarks(String marks) {
		this.marks = marks;
	}

	public String getIsSubmit() {
		return isSubmit;
	}

	public void setIsSubmit(String isSubmit) {
		this.isSubmit = isSubmit;
	}

	public String getTransferStatus() {
		return transferStatus;
	}

	public void setTransferStatus(String transferStatus) {
		this.transferStatus = transferStatus;
	}

	public String getTransferStatusName() {
		return transferStatusName;
	}

	public void setTransferStatusName(String transferStatusName) {
		this.transferStatusName = transferStatusName;
	}
}
