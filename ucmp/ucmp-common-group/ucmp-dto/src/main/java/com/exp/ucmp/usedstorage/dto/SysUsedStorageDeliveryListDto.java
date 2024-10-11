package com.exp.ucmp.usedstorage.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(value = "SysUsedStorageListDto", description = "仓储点列表交付中心Dto")
public class SysUsedStorageDeliveryListDto {

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
    @ApiModelProperty(value = "类型(1:总公司;4:交付中心;6:直属仓储点)")
    private String orgType;

    /**
     * 仓储点id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "仓储点id（只有类型属于6:直属仓储点时才有值）")
    private String storageId;


    /**
     * 所属的仓储点
     * @return
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "所属的仓储点")
    private List<SysUsedStorageListInfoDto> storageInfoList;

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgId() {
        return orgId;
    }

    public String getStorageId() {
        return storageId;
    }

    public void setStorageId(String storageId) {
        this.storageId = storageId;
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

    public List<SysUsedStorageListInfoDto> getStorageInfoList() {
        return storageInfoList;
    }

    public void setStorageInfoList(List<SysUsedStorageListInfoDto> storageInfoList) {
        this.storageInfoList = storageInfoList;
    }

}
