package com.exp.ucmp.carDealer.dto;

import com.egrid.core.base.model.BaseModel;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;

@ApiModel(value = "InquiryQuotingDetailResultDto", description = "询价查询报价结果对象")
public class InquiryQuotingDetailResultDto extends BaseModel {
    private static final long serialVersionUID = 6812270748133420222L;
    /**
     * 询价ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "询价ID")
    private Long inquiryId;

    /**
     * 预约ID
     */
    @ApiModelProperty(value = "预约ID")
    private Long reservationId;

    /**
     * 预约ID
     */
    @ApiModelProperty(value = "最后报价价格")
    private BigDecimal quoteEndPrice;

    /**
     * 预约ID
     */
    @ApiModelProperty(value = "最后报价时间")
    private Date quoteEndDate;

    /**
     * 年款
     */
    @ApiModelProperty(value = "年款")
    private String carYearChineseDescribe;

    /**
     * 预约ID
     */
    @ApiModelProperty(value = "品牌")
    private String brandChineseDescribe;

    /**
     * 车系
     */
    @ApiModelProperty(value = "车系")
    private String carSeriesChineseDescribe;

    /**
     * 车型
     */
    @ApiModelProperty(value = "车型")
    private String carTpeChineseDescribe;

    /**
     * 上牌城市
     */
    @ApiModelProperty(value = "上牌城市")
    private String licensingCity;

    /**
     * 上牌省份
     */
    @ApiModelProperty(value = "上牌省份")
    private String licensingProvince;

    /**
     * 上牌时间
     */
    @ApiModelProperty(value = "上牌时间")
    private Date licensingDate;

    /**
     * 行驶里程
     */
    @ApiModelProperty(value = "行驶里程")
    private String drivingMileage;

    /**
     * 颜色
     */
    @ApiModelProperty(value = "颜色")
    private String color;

    /**
     * 车牌号
     */
    @ApiModelProperty(value = "车牌号")
    private String licensePlateNum;

    /**
     * VIN码
     */
    @ApiModelProperty(value = "VIN码")
    private String vinCode;

    /**
     * 过户次数
     */
    @ApiModelProperty(value = "过户次数")
    private String transferTimes;

    /**
     * 使用性质
     */
    @ApiModelProperty(value = "使用性质")
    private String usingNature;

    /**
     * 姓名
     */
    @ApiModelProperty(value = "姓名")
    private String customerName;

    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号")
    private String customerIphone;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

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

    public BigDecimal getQuoteEndPrice() {
        return quoteEndPrice;
    }

    public void setQuoteEndPrice(BigDecimal quoteEndPrice) {
        this.quoteEndPrice = quoteEndPrice;
    }

    public Date getQuoteEndDate() {
        return quoteEndDate;
    }

    public void setQuoteEndDate(Date quoteEndDate) {
        this.quoteEndDate = quoteEndDate;
    }

    public String getCarYearChineseDescribe() {
        return carYearChineseDescribe;
    }

    public void setCarYearChineseDescribe(String carYearChineseDescribe) {
        this.carYearChineseDescribe = carYearChineseDescribe;
    }

    public String getBrandChineseDescribe() {
        return brandChineseDescribe;
    }

    public void setBrandChineseDescribe(String brandChineseDescribe) {
        this.brandChineseDescribe = brandChineseDescribe;
    }

    public String getCarSeriesChineseDescribe() {
        return carSeriesChineseDescribe;
    }

    public void setCarSeriesChineseDescribe(String carSeriesChineseDescribe) {
        this.carSeriesChineseDescribe = carSeriesChineseDescribe;
    }

    public String getCarTpeChineseDescribe() {
        return carTpeChineseDescribe;
    }

    public void setCarTpeChineseDescribe(String carTpeChineseDescribe) {
        this.carTpeChineseDescribe = carTpeChineseDescribe;
    }

    public String getLicensingCity() {
        return licensingCity;
    }

    public void setLicensingCity(String licensingCity) {
        this.licensingCity = licensingCity;
    }

    public String getLicensingProvince() {
        return licensingProvince;
    }

    public void setLicensingProvince(String licensingProvince) {
        this.licensingProvince = licensingProvince;
    }

    public Date getLicensingDate() {
        return licensingDate;
    }

    public void setLicensingDate(Date licensingDate) {
        this.licensingDate = licensingDate;
    }

    public String getDrivingMileage() {
        return drivingMileage;
    }

    public void setDrivingMileage(String drivingMileage) {
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

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerIphone() {
        return customerIphone;
    }

    public void setCustomerIphone(String customerIphone) {
        this.customerIphone = customerIphone;
    }
}
