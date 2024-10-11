/*
 * Copyright (C) 2013 SHANGHAI VOLKSWAGEN, All rights reserved.
 * License version 1.0, a copy of which has been included with this.
 * @File  name: com.svw.newsvwuc.auth.modules.dlrauth.dto.AuthVo
 * @Create  on: 2021/11/2
 * @Author    : hong
 */
package com.exp.ucmp.stock.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;


@ApiModel(value = "QueryMaintenceResutDto", description = "维修项目调整记录")
public class QueryMaintenceResutDto {

    @ApiModelProperty(value = "收费类型")
    private String collectFees;

    @ApiModelProperty(value = "维修时间")
    private String times;

    @ApiModelProperty(value = "项目信息")
    private List<SaveMaintenceParamDto> list;

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public String getCollectFees() {
        return collectFees;
    }

    public void setCollectFees(String collectFees) {
        this.collectFees = collectFees;
    }

    public List<SaveMaintenceParamDto> getList() {
        return list;
    }

    public void setList(List<SaveMaintenceParamDto> list) {
        this.list = list;
    }
}
