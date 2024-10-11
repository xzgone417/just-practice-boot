package com.exp.ucmp.car.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "RepairPartsDto", description = "维修配件实体类")
public class RepairPartsDto {
	
	@ApiModelProperty(value = "配件代码")
	private String partsCode;
	
	@ApiModelProperty(value = "配件名称")
	private String partsName;
	
	@ApiModelProperty(value = "配件单价")
	private String partsPrice;
	
	@ApiModelProperty(value = "配件数量")
	private String partsNum;
	
	@ApiModelProperty(value = "总金额")
	private String amount;

	@ApiModelProperty(value = "应收金额")
	private String receivableAmount ;

	public String getPartsCode() {
		return partsCode;
	}

	public void setPartsCode(String partsCode) {
		this.partsCode = partsCode;
	}

	public String getPartsName() {
		return partsName;
	}

	public void setPartsName(String partsName) {
		this.partsName = partsName;
	}

	public String getPartsPrice() {
		return partsPrice;
	}

	public void setPartsPrice(String partsPrice) {
		this.partsPrice = partsPrice;
	}

	public String getPartsNum() {
		return partsNum;
	}

	public void setPartsNum(String partsNum) {
		this.partsNum = partsNum;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getReceivableAmount() {
		return receivableAmount;
	}

	public void setReceivableAmount(String receivableAmount) {
		this.receivableAmount = receivableAmount;
	}
	
}
