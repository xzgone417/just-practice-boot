package com.exp.ucmp.servicing.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "OrderAdditionalItemsDto", description = "isp报价单申请返回类")
public class OrderAdditionalItemsDto {
	
	@ApiModelProperty(value = "附加项代码")
	private String code;
	
	@ApiModelProperty(value = "附加项名称")
	private String name;
	
	@ApiModelProperty(value = "总价")
	private Double totalPrice;
	
	@ApiModelProperty(value = "应收金额")
	private Double receivePrice;

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

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Double getReceivePrice() {
		return receivePrice;
	}

	public void setReceivePrice(Double receivePrice) {
		this.receivePrice = receivePrice;
	}
}
