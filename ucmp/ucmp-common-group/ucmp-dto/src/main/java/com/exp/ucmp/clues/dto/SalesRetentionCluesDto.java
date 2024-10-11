package com.exp.ucmp.clues.dto;

import com.exp.ucmp.entity.PsiCarStockInfoEntity;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * <p>@ClassName: SalesRetentionCluesDto</p>
 * <p>@Description: </p>
 * <p>@Author: fxy</p>
 * <p>@Date: 2023/6/30 16:12<p>
 */
public class SalesRetentionCluesDto {
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "线索id")
    private Long cluesId;

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
     * 库存车辆id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "库存车辆id")
    private Long stockId;

    /**
     * 仓储点id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "仓储点id")
    private Long storageId;

    @ApiModelProperty(value = "vin")
    private String vin;

    @ApiModelProperty(value = "工程车型名称")
    private String modelName;

    /**
     * 意向交付地
     */
    @ApiModelProperty(value = "意向交付地")
    private String deliveryPlace;

    @ApiModelProperty(value = "跟进状态")
    private String followStatus;

    /**
     * 跟进记录id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "跟进记录id")
    private Long followId;

    /**
     * 跟进时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "跟进时间")
    private Date followTime;

    /**
     * 跟进信息
     */
    @ApiModelProperty(value = "跟进信息")
    private String followInfo;

    /**
     * 上次跟进时间
     */
    @ApiModelProperty(value = "上次跟进时间")
    private Date lastFollowTime;

    /**
     * 跟进方式
     */
    @ApiModelProperty(value = "跟进方式")
    private String followType;

    /**
     * 是否到店(00不到店 01到店)
     */
    @ApiModelProperty(value = "是否到店(00不到店 01到店)")
    private String isArrival;

    /**
     * 跟进门店
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "跟进门店")
    private Long followStore;

    /**
     * 跟进人
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "跟进人")
    private Long followPerson;

    /**
     * 上一次跟进人名称
     */
    @ApiModelProperty(value = "上一次跟进人名称")
    private String followRecordPersonName;

    public Long getCluesId() {
        return cluesId;
    }

    public void setCluesId(Long cluesId) {
        this.cluesId = cluesId;
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

    public String getEncryptionCustomerPhone() {
        return encryptionCustomerPhone;
    }

    public void setEncryptionCustomerPhone(String encryptionCustomerPhone) {
        this.encryptionCustomerPhone = encryptionCustomerPhone;
    }

    public Long getStockId() {
        return stockId;
    }

    public void setStockId(Long stockId) {
        this.stockId = stockId;
    }

    public Long getStorageId() {
        return storageId;
    }

    public void setStorageId(Long storageId) {
        this.storageId = storageId;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getFollowStatus() {
        return followStatus;
    }

    public void setFollowStatus(String followStatus) {
        this.followStatus = followStatus;
    }

    public Long getFollowId() {
        return followId;
    }

    public void setFollowId(Long followId) {
        this.followId = followId;
    }

    public Date getFollowTime() {
        return followTime;
    }

    public void setFollowTime(Date followTime) {
        this.followTime = followTime;
    }

    public String getFollowInfo() {
        return followInfo;
    }

    public void setFollowInfo(String followInfo) {
        this.followInfo = followInfo;
    }

    public Date getLastFollowTime() {
        return lastFollowTime;
    }

    public void setLastFollowTime(Date lastFollowTime) {
        this.lastFollowTime = lastFollowTime;
    }

    public String getFollowType() {
        return followType;
    }

    public void setFollowType(String followType) {
        this.followType = followType;
    }

    public String getIsArrival() {
        return isArrival;
    }

    public void setIsArrival(String isArrival) {
        this.isArrival = isArrival;
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

    public String getFollowRecordPersonName() {
        return followRecordPersonName;
    }

    public void setFollowRecordPersonName(String followRecordPersonName) {
        this.followRecordPersonName = followRecordPersonName;
    }

    public String getDeliveryPlace() {
        return deliveryPlace;
    }

    public void setDeliveryPlace(String deliveryPlace) {
        this.deliveryPlace = deliveryPlace;
    }
}
