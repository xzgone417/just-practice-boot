/*
 * Copyright (C) 2013 SHANGHAI VOLKSWAGEN, All rights reserved.
 * License version 1.0, a copy of which has been included with this.
 * @File  name: com.svw.newsvwuc.auth.modules.dlrauth.dto.AuthVo
 * @Create  on: 2021/11/2
 * @Author    : hong
 */
package com.exp.ucmp.servicing.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;


@ApiModel(value = "OfflineServiceDto", description = "线下整备批量参数")
public class OfflineServiceDto {

    @ApiModelProperty(value = "库存车辆ID")
    private List<Long> stockId;

    @ApiModelProperty(value = "vin")
    private Long updateBy;

	public List<Long> getStockId() {
		return stockId;
	}

	public void setStockId(List<Long> stockId) {
		this.stockId = stockId;
	}

	public Long getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(Long updateBy) {
		this.updateBy = updateBy;
	}

}
