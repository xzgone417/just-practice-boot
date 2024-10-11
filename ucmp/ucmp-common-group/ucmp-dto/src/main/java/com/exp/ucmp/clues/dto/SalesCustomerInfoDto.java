package com.exp.ucmp.clues.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * <p>@ClassName: SalesCustomerInfoDto</p>
 * <p>@Description: </p>
 * <p>@Author: fxy</p>
 * <p>@Date: 2023/7/7 17:57<p>
 */
public class SalesCustomerInfoDto {
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
     * 客户手机号（前三后四）
     */
    @ApiModelProperty(value = "客户手机号（前三后四）")
    private String customerPhone;

    /**
     * 加密客户手机号
     */
    @ApiModelProperty(value = "加密客户手机号")
    private String encryptionCustomerPhone;

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
     * 跟进时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "跟进时间")
    private Date followTime;


    /**
     * 上次跟进时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "上次跟进时间")
    private Date lastFollowTime;

    /**
     * 上次跟人
     */
    @ApiModelProperty(value = "上次跟人")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long followBy;

    /**
     * 跟进状态
     */
    @ApiModelProperty(value = "跟进状态")
    private String followStatus;


    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "跟进门店")
    private Long followStore;

    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "跟进人")
    private Long followPerson;

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

    public String getEncryptionCustomerPhone() {
        return encryptionCustomerPhone;
    }

    public void setEncryptionCustomerPhone(String encryptionCustomerPhone) {
        this.encryptionCustomerPhone = encryptionCustomerPhone;
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

    public Long getFollowStore() {
        return followStore;
    }

    public void setFollowStore(Long followStore) {
        this.followStore = followStore;
    }

    public Long getFollowPerson() {
        return followPerson;
    }

    public void setFollowPerson(Long followPerson) {
        this.followPerson = followPerson;
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

    public Date getLastFollowTime() {
        return lastFollowTime;
    }

    public void setLastFollowTime(Date lastFollowTime) {
        this.lastFollowTime = lastFollowTime;
    }

    public String getFollowStatus() {
        return followStatus;
    }

    public void setFollowStatus(String followStatus) {
        this.followStatus = followStatus;
    }
}
