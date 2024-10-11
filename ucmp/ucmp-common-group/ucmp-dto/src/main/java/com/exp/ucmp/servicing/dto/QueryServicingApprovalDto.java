/*
 * Copyright (C) 2013 SHANGHAI VOLKSWAGEN, All rights reserved.
 * License version 1.0, a copy of which has been included with this.
 * @File  name: com.svw.newsvwuc.auth.modules.dlrauth.dto.AuthVo
 * @Create  on: 2021/11/2
 * @Author    : hong
 */
package com.exp.ucmp.servicing.dto;

import com.exp.ucmp.PageDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(value = "QueryServicingApprovalDto对象", description = "整备审批列表查询参数")
public class QueryServicingApprovalDto extends PageDto {

    @ApiModelProperty(value = "列表type(1维修项目反馈;2维修工单反馈;)", required = true)
    private Integer type;

    @ApiModelProperty(value = "仓储点名称")
    private String storageCode;

    @ApiModelProperty(value = "VIN")
    private String vin;

    @ApiModelProperty(value = "整备单号")
    private String serviceNumber;

    @ApiModelProperty(value = "工单单号")
    private String singleNumber;

    @ApiModelProperty(value = "状态")
    private String status;

    @ApiModelProperty(value = "发起人")
    private String startPeople;

    @ApiModelProperty(value = "开始)")
    private String startDate;

    @ApiModelProperty(value = "(结束)")
    private String endDate;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getStorageCode() {
        return storageCode;
    }

    public void setStorageCode(String storageCode) {
        this.storageCode = storageCode;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getServiceNumber() {
        return serviceNumber;
    }

    public void setServiceNumber(String serviceNumber) {
        this.serviceNumber = serviceNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStartPeople() {
        return startPeople;
    }

    public void setStartPeople(String startPeople) {
        this.startPeople = startPeople;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getSingleNumber() {
        return singleNumber;
    }

    public void setSingleNumber(String singleNumber) {
        this.singleNumber = singleNumber;
    }
}
