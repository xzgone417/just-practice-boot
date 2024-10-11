/*
 * Copyright (C) 2013 SHANGHAI VOLKSWAGEN, All rights reserved.
 * License version 1.0, a copy of which has been included with this.
 * @File  name: com.svw.newsvwuc.auth.modules.dlrauth.dto.AuthVo
 * @Create  on: 2021/11/2
 * @Author    : hong
 */
package com.exp.ucmp.clues.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.text.Bidi;
import java.util.Date;


@ApiModel(value = "SaveOrderDto", description = "保存订单参数")
public class SaveOrderDto {

    @ApiModelProperty(value = "订单id")
    private Long orderInfoId;

    @ApiModelProperty(value = "线索id")
    private Long cluesId;

    @ApiModelProperty(value = "大定支付时间")
    private Date setPaymentTime;

    @ApiModelProperty(value = "vin")
    private String carVin;

    @ApiModelProperty(value = "基础车型名称")
    private String baseCarTypeName;

    @ApiModelProperty(value = "内饰/外饰")
    private String interiorExteriorColor;

    @ApiModelProperty(value = "车辆价格")
    private BigDecimal carPrice;

    @ApiModelProperty(value = "订单跟进人")
    private String followPerson;

    @ApiModelProperty(value = "上牌资质01正常02待定03无资质")
    private String licensingQualification;

    @ApiModelProperty(value = "金融方案01有02待定03无")
    private String financialProgrammes;

    @ApiModelProperty(value = "交付门店")
    private String deliveryStore;

    @ApiModelProperty(value = "尾款支付时间")
    private Date balancePaymentTime;

    @ApiModelProperty(value = "订单客户姓名")
    private String customerName;

    @ApiModelProperty(value = "客户联系方式")
    private String customerPhone;

    @ApiModelProperty(value = "上牌城市")
    private String licensingCity;

    @ApiModelProperty(value = "上牌省份")
    private String licensingProvince;

    @ApiModelProperty(value = "车辆所有人类型01个人02公司")
    private String carOwnerType;

    @ApiModelProperty(value = "证件类型字典type81")
    private String typeId;

    @ApiModelProperty(value = "车主证件号")
    private String ownerCardNo;

    @ApiModelProperty(value = "企业名称")
    private String enterpriseName;

    @ApiModelProperty(value = "企业地址")
    private String enterpriseAddress;

    @ApiModelProperty(value = "主用车人")
    private String mainUserName;

    @ApiModelProperty(value = "主用车人手机号")
    private String mainUserPhone;

    @ApiModelProperty(value = "主用车人证件号")
    private String mainCardNo;

    @ApiModelProperty(value = "车辆最终销售价")
    private BigDecimal finalSalesPrice;

    @ApiModelProperty(value = "折扣合计")
    private BigDecimal totalDiscount;

    @ApiModelProperty(value = "应收总金额")
    private BigDecimal receivablePrice;

    @ApiModelProperty(value = "已收总金额")
    private BigDecimal receivedPrice;

    @ApiModelProperty(value = "未收总金额")
    private BigDecimal notReceivedPrice;

    public Long getCluesId() {
        return cluesId;
    }

    public void setCluesId(Long cluesId) {
        this.cluesId = cluesId;
    }

    public Long getOrderInfoId() {
        return orderInfoId;
    }

    public void setOrderInfoId(Long orderInfoId) {
        this.orderInfoId = orderInfoId;
    }

    public String getLicensingProvince() {
        return licensingProvince;
    }

    public void setLicensingProvince(String licensingProvince) {
        this.licensingProvince = licensingProvince;
    }

    public Date getSetPaymentTime() {
        return setPaymentTime;
    }

    public void setSetPaymentTime(Date setPaymentTime) {
        this.setPaymentTime = setPaymentTime;
    }

    public String getCarVin() {
        return carVin;
    }

    public void setCarVin(String carVin) {
        this.carVin = carVin;
    }

    public String getBaseCarTypeName() {
        return baseCarTypeName;
    }

    public void setBaseCarTypeName(String baseCarTypeName) {
        this.baseCarTypeName = baseCarTypeName;
    }

    public String getInteriorExteriorColor() {
        return interiorExteriorColor;
    }

    public void setInteriorExteriorColor(String interiorExteriorColor) {
        this.interiorExteriorColor = interiorExteriorColor;
    }

    public BigDecimal getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(BigDecimal carPrice) {
        this.carPrice = carPrice;
    }

    public String getFollowPerson() {
        return followPerson;
    }

    public void setFollowPerson(String followPerson) {
        this.followPerson = followPerson;
    }

    public String getLicensingQualification() {
        return licensingQualification;
    }

    public void setLicensingQualification(String licensingQualification) {
        this.licensingQualification = licensingQualification;
    }

    public String getFinancialProgrammes() {
        return financialProgrammes;
    }

    public void setFinancialProgrammes(String financialProgrammes) {
        this.financialProgrammes = financialProgrammes;
    }

    public String getDeliveryStore() {
        return deliveryStore;
    }

    public void setDeliveryStore(String deliveryStore) {
        this.deliveryStore = deliveryStore;
    }

    public Date getBalancePaymentTime() {
        return balancePaymentTime;
    }

    public void setBalancePaymentTime(Date balancePaymentTime) {
        this.balancePaymentTime = balancePaymentTime;
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

    public String getLicensingCity() {
        return licensingCity;
    }

    public void setLicensingCity(String licensingCity) {
        this.licensingCity = licensingCity;
    }

    public String getCarOwnerType() {
        return carOwnerType;
    }

    public void setCarOwnerType(String carOwnerType) {
        this.carOwnerType = carOwnerType;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getOwnerCardNo() {
        return ownerCardNo;
    }

    public void setOwnerCardNo(String ownerCardNo) {
        this.ownerCardNo = ownerCardNo;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getEnterpriseAddress() {
        return enterpriseAddress;
    }

    public void setEnterpriseAddress(String enterpriseAddress) {
        this.enterpriseAddress = enterpriseAddress;
    }

    public String getMainUserName() {
        return mainUserName;
    }

    public void setMainUserName(String mainUserName) {
        this.mainUserName = mainUserName;
    }

    public String getMainUserPhone() {
        return mainUserPhone;
    }

    public void setMainUserPhone(String mainUserPhone) {
        this.mainUserPhone = mainUserPhone;
    }

    public String getMainCardNo() {
        return mainCardNo;
    }

    public void setMainCardNo(String mainCardNo) {
        this.mainCardNo = mainCardNo;
    }

    public BigDecimal getFinalSalesPrice() {
        return finalSalesPrice;
    }

    public void setFinalSalesPrice(BigDecimal finalSalesPrice) {
        this.finalSalesPrice = finalSalesPrice;
    }

    public BigDecimal getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(BigDecimal totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public BigDecimal getReceivablePrice() {
        return receivablePrice;
    }

    public void setReceivablePrice(BigDecimal receivablePrice) {
        this.receivablePrice = receivablePrice;
    }

    public BigDecimal getReceivedPrice() {
        return receivedPrice;
    }

    public void setReceivedPrice(BigDecimal receivedPrice) {
        this.receivedPrice = receivedPrice;
    }

    public BigDecimal getNotReceivedPrice() {
        return notReceivedPrice;
    }

    public void setNotReceivedPrice(BigDecimal notReceivedPrice) {
        this.notReceivedPrice = notReceivedPrice;
    }
}
