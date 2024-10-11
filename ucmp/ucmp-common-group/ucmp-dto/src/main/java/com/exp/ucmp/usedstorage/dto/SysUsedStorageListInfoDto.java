package com.exp.ucmp.usedstorage.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SysUsedStorageInfoDto", description = "仓储点信息Dto")
public class SysUsedStorageListInfoDto {

    private static final long serialVersionUID = 1L;

    /**
     * 所属交付中心id
     */
    @ApiModelProperty(value = "所属交付中心id")
    private Long orgId;
    /**
     * 所属交付中心id
     */
    @ApiModelProperty(value = "所属交付中心id(字符)")
    private String orgIdStr;

    /**
     * 仓储点id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "仓储点id")
    private Long storageId;
    /**
     * 所属交付中心id
     */
    @ApiModelProperty(value = "仓储点id(字符)")
    private String storageIdStr;

    /**
     * 仓储点名称
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "仓储点名称")
    private String storageName;

    public String getOrgIdStr() {
        return orgId.toString();
    }

    public void setOrgIdStr(String orgIdStr) {
        this.orgIdStr = orgIdStr;
    }

    public String getStorageIdStr() {
        return storageId.toString();
    }

    public void setStorageIdStr(String storageIdStr) {
        this.storageIdStr = storageIdStr;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public Long getStorageId() {
        return storageId;
    }

    public void setStorageId(Long storageId) {
        this.storageId = storageId;
    }

    public String getStorageName() {
        return storageName;
    }

    public void setStorageName(String storageName) {
        this.storageName = storageName;
    }



}
