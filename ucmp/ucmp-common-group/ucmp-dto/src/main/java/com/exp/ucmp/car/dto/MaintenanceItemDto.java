package com.exp.ucmp.car.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MaintenanceItemDto", description = "维修项目实体类")
public class MaintenanceItemDto {
	
	@ApiModelProperty(value = "项目代码")
	private String itemCode;
	
	@ApiModelProperty(value = "项目名称")
	private String itemName;
	
	@ApiModelProperty(value = "工时单价")
	private String timePrice;
	
	@ApiModelProperty(value = "工时数")
	private String timeNum;
	
	@ApiModelProperty(value = "总金额")
	private String amount;

	@ApiModelProperty(value = "应收金额")
	private String receivableAmount ;

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getTimePrice() {
		return timePrice;
	}

	public void setTimePrice(String timePrice) {
		this.timePrice = timePrice;
	}

	public String getTimeNum() {
		return timeNum;
	}

	public void setTimeNum(String timeNum) {
		this.timeNum = timeNum;
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
