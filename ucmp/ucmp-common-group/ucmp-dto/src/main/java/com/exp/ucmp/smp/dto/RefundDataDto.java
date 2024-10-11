package com.exp.ucmp.smp.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "CancelDataDto", description = "取消订单数据体")
public class RefundDataDto {
	
	@ApiModelProperty(value = "申请退款时间")
	private String refundTime;
	
	@ApiModelProperty(value = "退款原因")
	private String refundReason;
	
	@ApiModelProperty(value = "取消退款时间")
	private String refundCanceledTime;

	public String getRefundTime() {
		return refundTime;
	}

	public void setRefundTime(String refundTime) {
		this.refundTime = refundTime;
	}

	public String getRefundReason() {
		return refundReason;
	}

	public void setRefundReason(String refundReason) {
		this.refundReason = refundReason;
	}

	public String getRefundCanceledTime() {
		return refundCanceledTime;
	}

	public void setRefundCanceledTime(String refundCanceledTime) {
		this.refundCanceledTime = refundCanceledTime;
	}
	
}
