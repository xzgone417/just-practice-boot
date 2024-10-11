package com.exp.ucmp.store.dto;

import com.egrid.core.base.model.BaseModel;
import com.exp.ucmp.PageDto;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SysFindStoreByNameDto", description = "门店信息")
public class SysFindStoreByNameDto extends BaseModel {

    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "门店标识 ")
    private Long storeId;

    @ApiModelProperty(value = "门店名称")
    private String storeName;

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
}
