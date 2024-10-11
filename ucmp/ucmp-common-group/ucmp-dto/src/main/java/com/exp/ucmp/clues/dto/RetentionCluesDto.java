/*
 * Copyright (C) 2013 SHANGHAI VOLKSWAGEN, All rights reserved.
 * License version 1.0, a copy of which has been included with this.
 * @File  name: com.svw.newsvwuc.auth.modules.dlrauth.dto.AuthVo
 * @Create  on: 2021/11/2
 * @Author    : hong
 */
package com.exp.ucmp.clues.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;


@ApiModel(value = "RetentionCluesDto对象", description = "商城留资线索列表")
public class RetentionCluesDto {
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "线索id")
    private Long cluesId;

    @ApiModelProperty(value = "客户名称")
    private String customerName;

    @ApiModelProperty(value = "手机号")
    private String customerPhone;

    @ApiModelProperty(value = "意向交付地")
    private String deliveryPlace;

    @ApiModelProperty(value = "留资日期")
    private Date retentionTime;

    @ApiModelProperty(value = "vin")
    private String vin;

    @ApiModelProperty(value = "工程车型名称")
    private String carSeriesName;

    @ApiModelProperty(value = "基础车型名称")
    private String baseCarTypeName;

    @ApiModelProperty(value = "归属仓储")
    private String storageName;

    @ApiModelProperty(value = "销售定价")
    private BigDecimal salePrice;

    @ApiModelProperty(value = "跟进人")
    private String followPerson;

    @ApiModelProperty(value = "跟进日期")
    private Date followTime;

    @ApiModelProperty(value = "来源")
    private String cluesSource;

    @ApiModelProperty(value = "跟进状态")
    private String followStatus;

    public String getDeliveryPlace() {
        return deliveryPlace;
    }

    public void setDeliveryPlace(String deliveryPlace) {
        this.deliveryPlace = deliveryPlace;
    }

    public Long getCluesId() {
        return cluesId;
    }

    public void setCluesId(Long cluesId) {
        this.cluesId = cluesId;
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

    public Date getRetentionTime() {
        return retentionTime;
    }

    public void setRetentionTime(Date retentionTime) {
        this.retentionTime = retentionTime;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getCarSeriesName() {
        return carSeriesName;
    }

    public void setCarSeriesName(String carSeriesName) {
        this.carSeriesName = carSeriesName;
    }

    public String getBaseCarTypeName() {
        return baseCarTypeName;
    }

    public void setBaseCarTypeName(String baseCarTypeName) {
        this.baseCarTypeName = baseCarTypeName;
    }

    public String getStorageName() {
        return storageName;
    }

    public void setStorageName(String storageName) {
        this.storageName = storageName;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public String getFollowPerson() {
        return followPerson;
    }

    public void setFollowPerson(String followPerson) {
        this.followPerson = followPerson;
    }

    public Date getFollowTime() {
        return followTime;
    }

    public void setFollowTime(Date followTime) {
        this.followTime = followTime;
    }

    public String getCluesSource() {
        return cluesSource;
    }

    public void setCluesSource(String cluesSource) {
        this.cluesSource = cluesSource;
    }

    public String getFollowStatus() {
        return followStatus;
    }

    public void setFollowStatus(String followStatus) {
        this.followStatus = followStatus;
    }

}
