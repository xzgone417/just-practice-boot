/*
 * Copyright (C) 2013 SHANGHAI VOLKSWAGEN, All rights reserved.
 * License version 1.0, a copy of which has been included with this.
 * @File  name: com.svw.newsvwuc.auth.modules.dlrauth.dto.AuthVo
 * @Create  on: 2021/11/2
 * @Author    : hong
 */
package com.exp.ucmp.stock.dto;

import com.exp.ucmp.PageDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@ApiModel(value = "MaintenceParamDto", description = "维修项目查询参数")
public class MaintenceParamDto extends PageDto {
    @ApiModelProperty(value = "列表带出来的vin(必填)")
    private String vinCode;

    @ApiModelProperty(value = "关键字")
    private String keyWords;

    @ApiModelProperty(value = "收费类型")
    private String collectFees;

    @ApiModelProperty(value = "查询类型(001维修工单项目002整备工单项目),必填")
    private String type;

    public String getVinCode() {
        return vinCode;
    }

    public void setVinCode(String vinCode) {
        this.vinCode = vinCode;
    }

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }

    public String getCollectFees() {
        return collectFees;
    }

    public void setCollectFees(String collectFees) {
        this.collectFees = collectFees;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
