package com.exp.ucmp.mall.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "InventoryInfoDto", description = "置换单实体类")
public class InventoryInfoDto {
	
	@ApiModelProperty(value = "库存车辆ID")
	private String stockId;

	public String getStockId() {
		return stockId;
	}

	public void setStockId(String stockId) {
		this.stockId = stockId;
	}
	
}
