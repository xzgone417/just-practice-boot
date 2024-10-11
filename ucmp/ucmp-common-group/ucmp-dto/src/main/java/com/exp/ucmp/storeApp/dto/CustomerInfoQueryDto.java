package com.exp.ucmp.storeApp.dto;


import com.egrid.core.base.model.BaseModel;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "CustomerInfoQueryDto", description = "查询用户信息的入参")
public class CustomerInfoQueryDto extends BaseModel {

    private static final long serialVersionUID = 1L;
    /**
     * 客户id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "客户id")
    private Long customerId;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}
