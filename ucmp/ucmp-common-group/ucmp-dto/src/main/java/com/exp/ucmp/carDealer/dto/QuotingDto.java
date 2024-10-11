package com.exp.ucmp.carDealer.dto;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;

public class QuotingDto {
    /**
     * 询价id
     */
    private Long inquiryId;

    /**
     * 预约id
     */
    private Long reservationId;

    /**
     * 最后报价价格
     */
    private BigDecimal quoteEndPrice;

    /**
     *车商ID
     */
    private Long carDealerId;

    /**
     * 品牌
     */
    private String brand;

    /**
     * 品牌中文描述
     */
    private String brandChineseDescribe;

    /**
     * 车型
     */
    private String carType;

    /**
     * 车型中文描述
     */
    private String carTypeChineseDescribe;

    /**
     * 上牌城市
     */
    private String licensingCity;

    /**
     * 上牌时间
     */
    private Date licensingDate;

    /**
     * 行驶里程
     */
    private Long drivingMileage;

    /**
     * 颜色
     */
    private String color;

    /**
     * 车牌号
     */
    private String licensePlateNum;

    /**
     * VIN码
     */
    private String vinCode;

    /**
     * 过户次数
     */
    private String transferTimes;

    /**
     * 使用性质
     */
    private String usingNature;

    /**
     * 客户手机号
     */
    private String customerIphone;

    /**
     * 询价状态
     */
    private String inquiryStatus;

    public Long getInquiryId() {
        return inquiryId;
    }

    public void setInquiryId(Long inquiryId) {
        this.inquiryId = inquiryId;
    }

    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrandChineseDescribe() {
        return brandChineseDescribe;
    }

    public void setBrandChineseDescribe(String brandChineseDescribe) {
        this.brandChineseDescribe = brandChineseDescribe;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCarTypeChineseDescribe() {
        return carTypeChineseDescribe;
    }

    public void setCarTypeChineseDescribe(String carTypeChineseDescribe) {
        this.carTypeChineseDescribe = carTypeChineseDescribe;
    }

    public String getLicensingCity() {
        return licensingCity;
    }

    public void setLicensingCity(String licensingCity) {
        this.licensingCity = licensingCity;
    }

    public Date getLicensingDate() {
        return licensingDate;
    }

    public void setLicensingDate(Date licensingDate) {
        this.licensingDate = licensingDate;
    }

    public Long getDrivingMileage() {
        return drivingMileage;
    }

    public void setDrivingMileage(Long drivingMileage) {
        this.drivingMileage = drivingMileage;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getLicensePlateNum() {
        return licensePlateNum;
    }

    public void setLicensePlateNum(String licensePlateNum) {
        this.licensePlateNum = licensePlateNum;
    }

    public String getVinCode() {
        return vinCode;
    }

    public void setVinCode(String vinCode) {
        this.vinCode = vinCode;
    }

    public String getTransferTimes() {
        return transferTimes;
    }

    public void setTransferTimes(String transferTimes) {
        this.transferTimes = transferTimes;
    }

    public String getUsingNature() {
        return usingNature;
    }

    public void setUsingNature(String usingNature) {
        this.usingNature = usingNature;
    }

    public BigDecimal getQuoteEndPrice() {
        return quoteEndPrice;
    }

    public void setQuoteEndPrice(BigDecimal quoteEndPrice) {
        this.quoteEndPrice = quoteEndPrice;
    }

    public Long getCarDealerId() {
        return carDealerId;
    }

    public void setCarDealerId(Long carDealerId) {
        this.carDealerId = carDealerId;
    }

    public String getCustomerIphone() {
        return customerIphone;
    }

    public void setCustomerIphone(String customerIphone) {
        this.customerIphone = customerIphone;
    }

    public String getInquiryStatus() {
        return inquiryStatus;
    }

    public void setInquiryStatus(String inquiryStatus) {
        this.inquiryStatus = inquiryStatus;
    }
}
