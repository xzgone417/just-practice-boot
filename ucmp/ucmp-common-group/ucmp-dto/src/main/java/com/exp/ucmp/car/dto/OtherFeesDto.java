package com.exp.ucmp.car.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "OtherFeesDto", description = "其他费用实体类")
public class OtherFeesDto {
	
	@ApiModelProperty(value = "项目代码")
	private String itemCode;
	
	@ApiModelProperty(value = "项目名称")
	private String itemName;
	
	@ApiModelProperty(value = "项目费用")
	private String itemAmount;
	
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

	public String getItemAmount() {
		return itemAmount;
	}

	public void setItemAmount(String itemAmount) {
		this.itemAmount = itemAmount;
	}

	public String getReceivableAmount() {
		return receivableAmount;
	}

	public void setReceivableAmount(String receivableAmount) {
		this.receivableAmount = receivableAmount;
	}
	
}
