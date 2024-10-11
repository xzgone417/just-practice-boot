package com.exp.ucmp.store.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "DeliveryCenterDto", description = "交付中心列表")
public class DeliveryCenterDto{

    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "交付中心id ")
    private Long storeId;

    @ApiModelProperty(value = "交付中心代码")
    private String storeCode;

    @ApiModelProperty(value = "交付中心名称")
    private String storeName;

	public Long getStoreId() {
		return storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public String getStoreCode() {
		return storeCode;
	}

	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

}
