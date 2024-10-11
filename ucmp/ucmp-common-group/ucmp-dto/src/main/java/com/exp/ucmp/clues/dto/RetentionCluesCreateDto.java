package com.exp.ucmp.clues.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * <p>@ClassName: RetentionCluesCreateDto</p>
 * <p>@Description: </p>
 * <p>@Author: fxy</p>
 * <p>@Date: 2023/6/29 9:56<p>
 */
public class RetentionCluesCreateDto {

    /**
     * 门店ID
     */
    @ApiModelProperty(value = "门店ID")
    private Long storeId;

    /**
     * vin
     */
    @ApiModelProperty(value = "vin")
    private String vin;

    /**
     * 工程车型代码
     */
    @ApiModelProperty(value = "工程车型代码")
    private String modelCode;

    /**
     * 工程车型名称
     */
    @ApiModelProperty(value = "工程车型名称")
    private String modelName;

    /**
     * 基本车型代码
     */
    @ApiModelProperty(value = "基本车型代码")
    private String shapeCode;

    /**
     * 基本车型名称
     */
    @ApiModelProperty(value = "基本车型名称")
    private String shapeName;

    /**
     * 客户ID
     */
    @ApiModelProperty(value = "客户ID")
    private Long customerId;

    /**
     * 客户姓名
     */
    @ApiModelProperty(value = "客户姓名")
    private String customerName;

    /**
     * 客户手机号
     */
    @ApiModelProperty(value = "客户手机号")
    private String customerPhone;

    /**
     * 客户性格(00外向 01内向)
     */
    @ApiModelProperty(value = "客户性格(00外向 01内向)")
    private String customerCharacter;

    /**
     * 购车时间
     */
    @ApiModelProperty(value = "购车时间")
    private String purchaseTime;

    /**
     * 家庭情况
     */
    @ApiModelProperty(value = "家庭情况")
    private String familySituation;

    /**
     * 意向交付地
     */
    @ApiModelProperty(value = "意向交付地")
    private String deliveryPlace;

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
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

    public String getShapeCode() {
        return shapeCode;
    }

    public void setShapeCode(String shapeCode) {
        this.shapeCode = shapeCode;
    }

    public String getShapeName() {
        return shapeName;
    }

    public void setShapeName(String shapeName) {
        this.shapeName = shapeName;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

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

    public String getCustomerCharacter() {
        return customerCharacter;
    }

    public void setCustomerCharacter(String customerCharacter) {
        this.customerCharacter = customerCharacter;
    }

    public String getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(String purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    public String getFamilySituation() {
        return familySituation;
    }

    public void setFamilySituation(String familySituation) {
        this.familySituation = familySituation;
    }

    public String getDeliveryPlace() {
        return deliveryPlace;
    }

    public void setDeliveryPlace(String deliveryPlace) {
        this.deliveryPlace = deliveryPlace;
    }
}
