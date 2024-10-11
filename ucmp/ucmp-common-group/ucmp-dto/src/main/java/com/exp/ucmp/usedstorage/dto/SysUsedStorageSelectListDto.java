package com.exp.ucmp.usedstorage.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SysUsedStorageSelectListDto", description = "仓储点下拉列表Dto")
public class SysUsedStorageSelectListDto {

    private static final long serialVersionUID = 1L;
    /**
     * 仓储点id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "仓储点id")
    private Long storageId;
    /**
     * 仓库编码
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "仓库编码")
    private String storageCode;

    /**
     * 仓储点名称
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "仓储点名称")
    private String storageName;

    public String getStorageCode() {
        return storageCode;
    }

    public void setStorageCode(String storageCode) {
        this.storageCode = storageCode;
    }

    public String getStorageName() {
        return storageName;
    }

    public Long getStorageId() {
        return storageId;
    }

    public void setStorageId(Long storageId) {
        this.storageId = storageId;
    }

    public void setStorageName(String storageName) {
        this.storageName = storageName;
    }

}
