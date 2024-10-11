package com.exp.ucmp.smp.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "CancelDataDto", description = "取消订单数据体")
public class CancelDataDto {
	
	@ApiModelProperty(value = "取消时间")
	private String cancelTime;
	
	@ApiModelProperty(value = "取消原因")
	private String cancelReason;

	public String getCancelTime() {
		return cancelTime;
	}

	public void setCancelTime(String cancelTime) {
		this.cancelTime = cancelTime;
	}

	public String getCancelReason() {
		return cancelReason;
	}

	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	}
	
}
