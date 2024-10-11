/*
 * Copyright (C) 2013 SHANGHAI VOLKSWAGEN, All rights reserved.
 * License version 1.0, a copy of which has been included with this.
 * @File  name: com.svw.newsvwuc.auth.modules.dlrauth.dto.AuthVo
 * @Create  on: 2021/11/2
 * @Author    : hong
 */
package com.exp.ucmp.stock.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MaintenceParamDto", description = "维修项目查询参数")
public class MaintenceRecordDto{

    @ApiModelProperty(value = "维修项目类型 001维修工单项目002整备工单项目")
    private String type;
    
    @ApiModelProperty(value = "维修项目类型名称")
    private String typeName;

    @ApiModelProperty(value = "数据")
    private List<QueryMaintenceResultDto> data;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public List<QueryMaintenceResultDto> getData() {
		return data;
	}

	public void setData(List<QueryMaintenceResultDto> data) {
		this.data = data;
	}
    
}
