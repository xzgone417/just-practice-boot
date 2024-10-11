package com.exp.ucmp.clues.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * <p>@ClassName: SalesCustomerDto</p>
 * <p>@Description: </p>
 * <p>@Author: fxy</p>
 * <p>@Date: 2023/6/28 15:04<p>
 */
public class SalesCustomerDto {
    /**
     * 客户id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "客户id")
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
     * 意向车型代码
     */
    @ApiModelProperty(value = "意向车型代码")
    private String modelCode;

    /**
     * 意向车型名称
     */
    @ApiModelProperty(value = "意向车型名称")
    private String modelName;

    /**
     * 意向交付地
     */
    @ApiModelProperty(value = "意向交付地")
    private String deliveryPlace;

    /**
     * 意向VIN
     */
    @ApiModelProperty(value = "意向VIN")
    private String vin;

    /**
     * 上次跟进时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "上次跟进时间")
    private Date followTime;

    /**
     * 上次跟人
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "上次跟人")
    private Long followBy;

    /**
     * 上次跟人姓名
     */
    @ApiModelProperty(value = "上次跟人姓名")
    private String followName;

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
    private String family;

    /**
     * 创建人ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "创建人ID")
    private Long createdBy;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;

    /**
     * 更新人ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "更新人ID")
    private Long updatedBy;

    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间")
    private Date updatedDate;

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

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Date getFollowTime() {
        return followTime;
    }

    public void setFollowTime(Date followTime) {
        this.followTime = followTime;
    }

    public Long getFollowBy() {
        return followBy;
    }

    public void setFollowBy(Long followBy) {
        this.followBy = followBy;
    }

    public String getFollowName() {
        return followName;
    }

    public void setFollowName(String followName) {
        this.followName = followName;
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

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Long getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
}
