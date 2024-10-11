package com.exp.ucmp.salesDelivery.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "DeliveryOrderStatisticsDto", description = "官二交付首页数据统计")
public class DeliveryOrderStatisticsDto {
	
	@ApiModelProperty(value = "待分配数量")
	private Integer unAllocatedNum;
	
	@ApiModelProperty(value = "待全款数量")
	private Integer unFullPaymentNum;
	
	@ApiModelProperty(value = "待交付数量")
	private Integer unDeliveryNum;
	
	@ApiModelProperty(value = "已交付数量数量")
	private Integer deliveredNum;

	public Integer getUnAllocatedNum() {
		return unAllocatedNum;
	}

	public void setUnAllocatedNum(Integer unAllocatedNum) {
		this.unAllocatedNum = unAllocatedNum;
	}

	public Integer getUnFullPaymentNum() {
		return unFullPaymentNum;
	}

	public void setUnFullPaymentNum(Integer unFullPaymentNum) {
		this.unFullPaymentNum = unFullPaymentNum;
	}

	public Integer getUnDeliveryNum() {
		return unDeliveryNum;
	}

	public void setUnDeliveryNum(Integer unDeliveryNum) {
		this.unDeliveryNum = unDeliveryNum;
	}

	public Integer getDeliveredNum() {
		return deliveredNum;
	}

	public void setDeliveredNum(Integer deliveredNum) {
		this.deliveredNum = deliveredNum;
	}
	
}
