package com.exp.ucmp.usedstorage.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "UsedStorageListParamDto", description = "仓储点列表查询Dto")
public class UsedStorageListParamDto{

    private static final long serialVersionUID = 1L;

    /**
     * 交付中心名称
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "交付中心名称 ")
    private String orgName;

    /**
     * 交付中心id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "交付中心id ")
    private String orgId;

    /**
     * 类型(1:总公司;2:大区;3:子公司;4:交付中心;5:高合中心)
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "类型(1:总公司;4:交付中心)",required = true)
    private String orgType;

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public String getOrgType() {
        return orgType;
    }

    public void setOrgType(String orgType) {
        this.orgType = orgType;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }
}
