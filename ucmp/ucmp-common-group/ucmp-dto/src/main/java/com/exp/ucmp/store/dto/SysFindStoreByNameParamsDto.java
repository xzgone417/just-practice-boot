package com.exp.ucmp.store.dto;

import com.egrid.core.base.model.BaseModel;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(value = "SysFindStoreByNameDto", description = "门店查询参数")
public class SysFindStoreByNameParamsDto extends BaseModel {

    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "合作商标识")
    private Long partnerId;

    @ApiModelProperty(value = "门店名称")
    private String storeName;

    public Long getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(Long partnerId) {
        this.partnerId = partnerId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
}
