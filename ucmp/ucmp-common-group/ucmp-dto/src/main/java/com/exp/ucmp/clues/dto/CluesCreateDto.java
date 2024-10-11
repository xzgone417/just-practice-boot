package com.exp.ucmp.clues.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * <p>@ClassName: CluesCreateDto</p>
 * <p>@Description: </p>
 * <p>@Author: fxy</p>
 * <p>@Date: 2023/7/10 18:03<p>
 */
public class CluesCreateDto {
    @ApiModelProperty("客户姓名")
    private String customerName;

    @ApiModelProperty("客户手机号")
    private String customerPhone;

    @ApiModelProperty("意向vin")
    private String vin;
    
    @ApiModelProperty("意向车型code")
    private String modelCode;
    
    @ApiModelProperty("意向车型name")
    private String modelName;
    
    @ApiModelProperty("意向交付地code")
    private String deliveryPlace;
    
    @ApiModelProperty("用户编号(superId)")
    private String uid;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getModelCode() {
        return modelCode;
    }

    public void setModelCode(String modelCode) {
        this.modelCode = modelCode;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getDeliveryPlace() {
        return deliveryPlace;
    }

    public void setDeliveryPlace(String deliveryPlace) {
        this.deliveryPlace = deliveryPlace;
    }

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

}
