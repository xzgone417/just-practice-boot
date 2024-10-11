package com.exp.ucmp.carDealer.dto;

import com.egrid.core.base.model.BaseModel;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author GeYiJiang
 * @Description: 收购材料上报
 * @date 2022/10/20 16:21
 */
@ApiModel(value = "AcquisitionMaterialUploadDto", description = "收购材料上报对象")
public class AcquisitionMaterialUploadDto extends BaseModel {
    private static final long serialVersionUID = -2412028086283321601L;
    /**
     * 询价id
     */
    @ApiModelProperty(value = "询价id",required = true)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long inquiryId;

    /**
     * 预约id
     */
    @ApiModelProperty(value = "预约id",required = true)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long reservationId;

    /**
     * 品牌
     */
    @ApiModelProperty(value = "品牌")
    private String brand;

    /**
     * 品牌中文描述
     */
    @ApiModelProperty(value = "品牌中文描述")
    private String brandChineseDescribe;

    /**
     * 车系
     */
    @ApiModelProperty(value = "车系")
    private String carSeries;

    /**
     * 车系中文描述
     */
    @ApiModelProperty(value = "车系中文描述")
    private String carSeriesChineseDescribe;

    /**
     * 车型
     */
    @ApiModelProperty(value = "车型")
    private String carType;

    /**
     * 车型中文描述
     */
    @ApiModelProperty(value = "车型中文描述")
    private String carTypeChineseDescribe;

    /**
     * 年款
     */
    @ApiModelProperty(value = "车型")
    private String carYear;

    /**
     * 年款中文描述
     */
    @ApiModelProperty(value = "车型中文描述")
    private String carYearChineseDescribe;

    /**
     * 车牌号
     */
    @ApiModelProperty(value = "车牌号")
    private String licensePlateNum;

    /**
     * vin码
     */
    @ApiModelProperty(value = "vin码")
    private String vinCode;

    /**
     * 上牌时间
     */
    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
    @ApiModelProperty(value = "上牌时间")
    private Date licensingDate;

    /**
     * 上牌城市
     */
    @ApiModelProperty(value = "上牌城市")
    private String licensingCity;

    /**
     * 颜色
     */
    @ApiModelProperty(value = "颜色")
    private String color;

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
     * 行驶里程
     */
    @ApiModelProperty(value = "行驶里程")
    private Long drivingMileage;

    /**
     * 发票号
     */
    @ApiModelProperty(value = "发票号")
    private String invoiceNum;

    /**
     * 最终成交价
     */
    @ApiModelProperty(value = "最终成交价")
    private Long dealPriceEnd;

    /**
     * 预计过户时间
     */
    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
    @ApiModelProperty(value = "预计过户时间")
    private Date estimatedTransferTime;

    /**
     * 上传动作
     */
    @ApiModelProperty(value = "上传动作(save(保存)、report(交易上报))",required = true)
    private String uploadAction;

    /**
     * 业务节点
     */
    @ApiModelProperty(value = "业务节点",required = true)
    private String businessNodes;

    public AcquisitionMaterialUploadDto() {
    }

    public AcquisitionMaterialUploadDto(Long inquiryId, Long reservationId, String brand, String brandChineseDescribe, String carSeries, String carSeriesChineseDescribe, String carType, String carTypeChineseDescribe, String carYear, String carYearChineseDescribe, String licensePlateNum, String vinCode, Date licensingDate, String licensingCity, String color, String transferTimes, String usingNature, Long drivingMileage, String invoiceNum, Long dealPriceEnd, Date estimatedTransferTime, String uploadAction, String businessNodes) {
        this.inquiryId = inquiryId;
        this.reservationId = reservationId;
        this.brand = brand;
        this.brandChineseDescribe = brandChineseDescribe;
        this.carSeries = carSeries;
        this.carSeriesChineseDescribe = carSeriesChineseDescribe;
        this.carType = carType;
        this.carTypeChineseDescribe = carTypeChineseDescribe;
        this.carYear = carYear;
        this.carYearChineseDescribe = carYearChineseDescribe;
        this.licensePlateNum = licensePlateNum;
        this.vinCode = vinCode;
        this.licensingDate = licensingDate;
        this.licensingCity = licensingCity;
        this.color = color;
        this.transferTimes = transferTimes;
        this.usingNature = usingNature;
        this.drivingMileage = drivingMileage;
        this.invoiceNum = invoiceNum;
        this.dealPriceEnd = dealPriceEnd;
        this.estimatedTransferTime = estimatedTransferTime;
        this.uploadAction = uploadAction;
        this.businessNodes = businessNodes;
    }

    /**
     * 获取
     * @return inquiryId
     */
    public Long getInquiryId() {
        return inquiryId;
    }

    /**
     * 设置
     * @param inquiryId
     */
    public void setInquiryId(Long inquiryId) {
        this.inquiryId = inquiryId;
    }

    /**
     * 获取
     * @return reservationId
     */
    public Long getReservationId() {
        return reservationId;
    }

    /**
     * 设置
     * @param reservationId
     */
    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

    /**
     * 获取
     * @return brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * 设置
     * @param brand
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * 获取
     * @return brandChineseDescribe
     */
    public String getBrandChineseDescribe() {
        return brandChineseDescribe;
    }

    /**
     * 设置
     * @param brandChineseDescribe
     */
    public void setBrandChineseDescribe(String brandChineseDescribe) {
        this.brandChineseDescribe = brandChineseDescribe;
    }

    /**
     * 获取
     * @return carSeries
     */
    public String getCarSeries() {
        return carSeries;
    }

    /**
     * 设置
     * @param carSeries
     */
    public void setCarSeries(String carSeries) {
        this.carSeries = carSeries;
    }

    /**
     * 获取
     * @return carSeriesChineseDescribe
     */
    public String getCarSeriesChineseDescribe() {
        return carSeriesChineseDescribe;
    }

    /**
     * 设置
     * @param carSeriesChineseDescribe
     */
    public void setCarSeriesChineseDescribe(String carSeriesChineseDescribe) {
        this.carSeriesChineseDescribe = carSeriesChineseDescribe;
    }

    /**
     * 获取
     * @return carType
     */
    public String getCarType() {
        return carType;
    }

    /**
     * 设置
     * @param carType
     */
    public void setCarType(String carType) {
        this.carType = carType;
    }

    /**
     * 获取
     * @return carTypeChineseDescribe
     */
    public String getCarTypeChineseDescribe() {
        return carTypeChineseDescribe;
    }

    /**
     * 设置
     * @param carTypeChineseDescribe
     */
    public void setCarTypeChineseDescribe(String carTypeChineseDescribe) {
        this.carTypeChineseDescribe = carTypeChineseDescribe;
    }

    /**
     * 获取
     * @return carYear
     */
    public String getCarYear() {
        return carYear;
    }

    /**
     * 设置
     * @param carYear
     */
    public void setCarYear(String carYear) {
        this.carYear = carYear;
    }

    /**
     * 获取
     * @return carYearChineseDescribe
     */
    public String getCarYearChineseDescribe() {
        return carYearChineseDescribe;
    }

    /**
     * 设置
     * @param carYearChineseDescribe
     */
    public void setCarYearChineseDescribe(String carYearChineseDescribe) {
        this.carYearChineseDescribe = carYearChineseDescribe;
    }

    /**
     * 获取
     * @return licensePlateNum
     */
    public String getLicensePlateNum() {
        return licensePlateNum;
    }

    /**
     * 设置
     * @param licensePlateNum
     */
    public void setLicensePlateNum(String licensePlateNum) {
        this.licensePlateNum = licensePlateNum;
    }

    /**
     * 获取
     * @return vinCode
     */
    public String getVinCode() {
        return vinCode;
    }

    /**
     * 设置
     * @param vinCode
     */
    public void setVinCode(String vinCode) {
        this.vinCode = vinCode;
    }

    /**
     * 获取
     * @return licensingDate
     */
    public Date getLicensingDate() {
        return licensingDate;
    }

    /**
     * 设置
     * @param licensingDate
     */
    public void setLicensingDate(Date licensingDate) {
        this.licensingDate = licensingDate;
    }

    /**
     * 获取
     * @return licensingCity
     */
    public String getLicensingCity() {
        return licensingCity;
    }

    /**
     * 设置
     * @param licensingCity
     */
    public void setLicensingCity(String licensingCity) {
        this.licensingCity = licensingCity;
    }

    /**
     * 获取
     * @return color
     */
    public String getColor() {
        return color;
    }

    /**
     * 设置
     * @param color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * 获取
     * @return transferTimes
     */
    public String getTransferTimes() {
        return transferTimes;
    }

    /**
     * 设置
     * @param transferTimes
     */
    public void setTransferTimes(String transferTimes) {
        this.transferTimes = transferTimes;
    }

    /**
     * 获取
     * @return usingNature
     */
    public String getUsingNature() {
        return usingNature;
    }

    /**
     * 设置
     * @param usingNature
     */
    public void setUsingNature(String usingNature) {
        this.usingNature = usingNature;
    }

    /**
     * 获取
     * @return drivingMileage
     */
    public Long getDrivingMileage() {
        return drivingMileage;
    }

    /**
     * 设置
     * @param drivingMileage
     */
    public void setDrivingMileage(Long drivingMileage) {
        this.drivingMileage = drivingMileage;
    }

    /**
     * 获取
     * @return invoiceNum
     */
    public String getInvoiceNum() {
        return invoiceNum;
    }

    /**
     * 设置
     * @param invoiceNum
     */
    public void setInvoiceNum(String invoiceNum) {
        this.invoiceNum = invoiceNum;
    }

    /**
     * 获取
     * @return dealPriceEnd
     */
    public Long getDealPriceEnd() {
        return dealPriceEnd;
    }

    /**
     * 设置
     * @param dealPriceEnd
     */
    public void setDealPriceEnd(Long dealPriceEnd) {
        this.dealPriceEnd = dealPriceEnd;
    }

    /**
     * 获取
     * @return estimatedTransferTime
     */
    public Date getEstimatedTransferTime() {
        return estimatedTransferTime;
    }

    /**
     * 设置
     * @param estimatedTransferTime
     */
    public void setEstimatedTransferTime(Date estimatedTransferTime) {
        this.estimatedTransferTime = estimatedTransferTime;
    }

    /**
     * 获取
     * @return uploadAction
     */
    public String getUploadAction() {
        return uploadAction;
    }

    /**
     * 设置
     * @param uploadAction
     */
    public void setUploadAction(String uploadAction) {
        this.uploadAction = uploadAction;
    }

    /**
     * 获取
     * @return businessNodes
     */
    public String getBusinessNodes() {
        return businessNodes;
    }

    /**
     * 设置
     * @param businessNodes
     */
    public void setBusinessNodes(String businessNodes) {
        this.businessNodes = businessNodes;
    }

    public String toString() {
        return "AcquisitionMaterialUploadDto{inquiryId = " + inquiryId + ", reservationId = " + reservationId + ", brand = " + brand + ", brandChineseDescribe = " + brandChineseDescribe + ", carSeries = " + carSeries + ", carSeriesChineseDescribe = " + carSeriesChineseDescribe + ", carType = " + carType + ", carTypeChineseDescribe = " + carTypeChineseDescribe + ", carYear = " + carYear + ", carYearChineseDescribe = " + carYearChineseDescribe + ", licensePlateNum = " + licensePlateNum + ", vinCode = " + vinCode + ", licensingDate = " + licensingDate + ", licensingCity = " + licensingCity + ", color = " + color + ", transferTimes = " + transferTimes + ", usingNature = " + usingNature + ", drivingMileage = " + drivingMileage + ", invoiceNum = " + invoiceNum + ", dealPriceEnd = " + dealPriceEnd + ", estimatedTransferTime = " + estimatedTransferTime + ", uploadAction = " + uploadAction + ", businessNodes = " + businessNodes + "}";
    }

    public enum uploadActionTypeEnum {
        save, report;
    }
}
