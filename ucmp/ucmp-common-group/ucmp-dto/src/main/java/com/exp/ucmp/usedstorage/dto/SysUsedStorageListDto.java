package com.exp.ucmp.usedstorage.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

@ApiModel(value = "SysUsedStorageListDto", description = "仓储点列表查询Dto")
public class SysUsedStorageListDto {

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
    @ApiModelProperty(value = "类型(1:总公司;4:交付中心)")
    private String orgType;


    /**
     * 所属的交付中心
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "所属的交付中心")
    private List<SysUsedStorageDeliveryListDto> childList = new ArrayList<>();


    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getOrgType() {
        return orgType;
    }

    public void setOrgType(String orgType) {
        this.orgType = orgType;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }


    public List<SysUsedStorageDeliveryListDto> getChildList() {
        return childList;
    }

    public void setChildList(List<SysUsedStorageDeliveryListDto> childList) {
        this.childList = childList;
    }

}
