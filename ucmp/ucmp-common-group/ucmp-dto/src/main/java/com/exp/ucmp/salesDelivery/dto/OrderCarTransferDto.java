package com.exp.ucmp.salesDelivery.dto;


import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "OrderCarTransferDto", description = "订单车辆调拨申请参数")
public class OrderCarTransferDto {
	
	@NotNull
	@ApiModelProperty(value = "订单id")
	private Long orderInfoId;
	
	@NotNull
	@ApiModelProperty(value = "目标仓储id")
	private Long goalStorageId;
	
	@ApiModelProperty(value = "期望开始调拨日期")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startTime;
	
	@ApiModelProperty(value = "期望到达日期")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date expectedTime;
	
	@ApiModelProperty(value = "调拨类型")
	private String transferType;
	
	@ApiModelProperty(value = "调拨理由")
	private String marks;
	
	@ApiModelProperty(value = "操作类型 1 提交 2 保存")
    private Integer operationType = 1;

	public Long getOrderInfoId() {
		return orderInfoId;
	}

	public void setOrderInfoId(Long orderInfoId) {
		this.orderInfoId = orderInfoId;
	}

	public Long getGoalStorageId() {
		return goalStorageId;
	}

	public void setGoalStorageId(Long goalStorageId) {
		this.goalStorageId = goalStorageId;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getExpectedTime() {
		return expectedTime;
	}

	public void setExpectedTime(Date expectedTime) {
		this.expectedTime = expectedTime;
	}

	public String getTransferType() {
		return transferType;
	}

	public void setTransferType(String transferType) {
		this.transferType = transferType;
	}

	public String getMarks() {
		return marks;
	}

	public void setMarks(String marks) {
		this.marks = marks;
	}

	public Integer getOperationType() {
		return operationType;
	}

	public void setOperationType(Integer operationType) {
		this.operationType = operationType;
	}
	
}
