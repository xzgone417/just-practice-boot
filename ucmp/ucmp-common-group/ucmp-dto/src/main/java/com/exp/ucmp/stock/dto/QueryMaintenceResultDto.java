/*
 * Copyright (C) 2013 SHANGHAI VOLKSWAGEN, All rights reserved.
 * License version 1.0, a copy of which has been included with this.
 * @File  name: com.svw.newsvwuc.auth.modules.dlrauth.dto.AuthVo
 * @Create  on: 2021/11/2
 * @Author    : hong
 */
package com.exp.ucmp.stock.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;


@ApiModel(value = "QueryMaintenceResutDto", description = "维修项目调整记录")
public class QueryMaintenceResultDto {


    @ApiModelProperty(value = "库存车辆ID")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long stockId;

    @ApiModelProperty(value = "收费类型")
    private String collectFees;
    
    @ApiModelProperty(value = "收费类型名称")
    private String collectFeesName;

    @ApiModelProperty(value = "项目数据")
    private List<QueryMaintenceDto> data;


    public Long getStockId() {
        return stockId;
    }

    public void setStockId(Long stockId) {
        this.stockId = stockId;
    }

    public String getCollectFees() {
        return collectFees;
    }

    public void setCollectFees(String collectFees) {
        this.collectFees = collectFees;
    }

	public String getCollectFeesName() {
		return collectFeesName;
	}

	public void setCollectFeesName(String collectFeesName) {
		this.collectFeesName = collectFeesName;
	}

	public List<QueryMaintenceDto> getData() {
		return data;
	}

	public void setData(List<QueryMaintenceDto> data) {
		this.data = data;
	}


}
