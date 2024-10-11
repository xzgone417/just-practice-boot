package com.exp.ucmp.servicing.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "OrderPartsDto", description = "isp报价单申请返回类")
public class OrderPartsDto {
	
	@ApiModelProperty(value = "配件代码")
    private String spCode;
	
	@ApiModelProperty(value = "配件名称")
    private String spName;
	
	@ApiModelProperty(value = "销售价格")
    private Double salePrice;
	
	@ApiModelProperty(value = "数量")
    private int amount;
	
	@ApiModelProperty(value = "总价")
    private Double totalPrice;
	
	@ApiModelProperty(value = "应收金额")
    private Double receivePrice;

	public String getSpCode() {
		return spCode;
	}

	public void setSpCode(String spCode) {
		this.spCode = spCode;
	}

	public String getSpName() {
		return spName;
	}

	public void setSpName(String spName) {
		this.spName = spName;
	}

	public Double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(Double salePrice) {
		this.salePrice = salePrice;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
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
