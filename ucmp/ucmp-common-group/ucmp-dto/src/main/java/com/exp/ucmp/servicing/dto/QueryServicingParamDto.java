/*
 * Copyright (C) 2013 SHANGHAI VOLKSWAGEN, All rights reserved.
 * License version 1.0, a copy of which has been included with this.
 * @File  name: com.svw.newsvwuc.auth.modules.dlrauth.dto.AuthVo
 * @Create  on: 2021/11/2
 * @Author    : hong
 */
package com.exp.ucmp.servicing.dto;

import java.util.List;

import com.exp.ucmp.PageDto;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(value = "QueryServicingParamDto对象", description = "整备工单列表查询参数")
public class QueryServicingParamDto extends PageDto {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "当前用户的orgId")
    private Long orgId;

    @ApiModelProperty(value = "列表type(1已发起待反馈;2生成工单待实施;3实施完成待验收)", required = true)
    private Integer type;

    @ApiModelProperty(value = "仓储点名称")
    private String storageName;

    @ApiModelProperty(value = "仓储点id")
    @JsonSerialize(using = ToStringSerializer.class)
    private List<Long> storageId;

    @ApiModelProperty(value = "车源批次")
    private String sourceBatch;

    @ApiModelProperty(value = "vin")
    private String vin;

    @ApiModelProperty(value = "发起人")
    private String startPeople;

    @ApiModelProperty(value = "服务中心")
    private String servicePlace;

    @ApiModelProperty(value = "完工时间(开始)")
    private String startCompleteDate;

    @ApiModelProperty(value = "完工时间(结束)")
    private String endCompleteDate;

    @ApiModelProperty(value = "是否总部")
    private String isFlag;

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public List<Long> getStorageId() {
        return storageId;
    }

    public void setStorageId(List<Long> storageId) {
        this.storageId = storageId;
    }

    public String getIsFlag() {
        return isFlag;
    }

    public void setIsFlag(String isFlag) {
        this.isFlag = isFlag;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getStorageName() {
        return storageName;
    }

    public void setStorageName(String storageName) {
        this.storageName = storageName;
    }

    public String getSourceBatch() {
        return sourceBatch;
    }

    public void setSourceBatch(String sourceBatch) {
        this.sourceBatch = sourceBatch;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getStartPeople() {
        return startPeople;
    }

    public void setStartPeople(String startPeople) {
        this.startPeople = startPeople;
    }

    public String getServicePlace() {
        return servicePlace;
    }

    public void setServicePlace(String servicePlace) {
        this.servicePlace = servicePlace;
    }

    public String getStartCompleteDate() {
        return startCompleteDate;
    }

    public void setStartCompleteDate(String startCompleteDate) {
        this.startCompleteDate = startCompleteDate;
    }

    public String getEndCompleteDate() {
        return endCompleteDate;
    }

    public void setEndCompleteDate(String endCompleteDate) {
        this.endCompleteDate = endCompleteDate;
    }
}
