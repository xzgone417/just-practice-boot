package com.exp.ucmp.carService.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;

@ApiModel(value = "CarServiceInfoDto", description = "车辆整备信息DTO")
public class CarServiceInfoDto {

    private static final long serialVersionUID = 1L;
    /**
     * 整备信息id
     */
    @ApiModelProperty(value = "整备信息id")
    private Long serviceId;

    /**
     * 库存车辆id
     */
    @ApiModelProperty("库存车辆id 创建时必传")
    private Long stockId;

    /**
     * 车辆类型
     */
    @ApiModelProperty(value = "车辆类型")
    private String carType;

    /**
     * 库存类型
     */
    @ApiModelProperty(value = "库存类型")
    private String stockType;

    /**
     * 工程车型名称
     */
    @ApiModelProperty(value = "工程车型名称")
    private String carSeriesName;

    /**
     * 基础车型名称
     */
    @ApiModelProperty(value = "基础车型名称")
    private String baseCarTypeName;

    /**
     * VIN
     */
    @ApiModelProperty(value = "VIN 创建时必传")
    private String vinCode;

    /**
     * 采购价格
     */
    @ApiModelProperty(value = "采购价格")
    private BigDecimal purchasePrice;

    /**
     * 所在仓储点
     */
    @ApiModelProperty(value = "所在仓储点")
    private String storageName;

    /**
     * 整备单号
     */
    @ApiModelProperty(value = "整备单号 创建时必传")
    private String serviceNumber;

    /**
     * 整备发起人
     */
    @ApiModelProperty(value = "整备发起人姓名")
    private String startPeople;
    /**
     * 整备发起人ID
     */
    @ApiModelProperty(value = "整备发起人ID")
    private Long startPeopleId;

    /**
     * 整备发起时间
     */
    @ApiModelProperty(value = "整备发起时间")
    private Date startDate;


    /**
     * 服务点类型
     */
    @ApiModelProperty(value = "服务点类型 创建时必传")
    private String placeType;

    /**
     * 服务点类型编码
     */
    @ApiModelProperty(value = "服务点类型编码 创建时必传")
    private String placeTypeCode;

    /**
     * 服务点
     */
    @ApiModelProperty(value = "服务点名称 创建时必传")
    private String servicePlace;

    /**
     * 服务点编码
     */
    @ApiModelProperty(value = "服务点编码 创建时必传")
    private String servicePlaceCode;

    /**
     * 期望整备结束时间
     */
    @ApiModelProperty(value = "期望整备结束时间")
    private Date expectEndTime;


    public CarServiceInfoDto() {
    }

    public String getStockType() {
        return stockType;
    }

    public void setStockType(String stockType) {
        this.stockType = stockType;
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

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getVinCode() {
        return vinCode;
    }

    public void setVinCode(String vinCode) {
        this.vinCode = vinCode;
    }

    public String getPlaceTypeCode() {
        return placeTypeCode;
    }

    public void setPlaceTypeCode(String placeTypeCode) {
        this.placeTypeCode = placeTypeCode;
    }

    public String getServicePlaceCode() {
        return servicePlaceCode;
    }

    public void setServicePlaceCode(String servicePlaceCode) {
        this.servicePlaceCode = servicePlaceCode;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public Long getStockId() {
        return stockId;
    }

    public void setStockId(Long stockId) {
        this.stockId = stockId;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public String getStorageName() {
        return storageName;
    }

    public void setStorageName(String storageName) {
        this.storageName = storageName;
    }

    public String getServiceNumber() {
        return serviceNumber;
    }

    public void setServiceNumber(String serviceNumber) {
        this.serviceNumber = serviceNumber;
    }

    public String getStartPeople() {
        return startPeople;
    }

    public void setStartPeople(String startPeople) {
        this.startPeople = startPeople;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getPlaceType() {
        return placeType;
    }

    public void setPlaceType(String placeType) {
        this.placeType = placeType;
    }

    public String getServicePlace() {
        return servicePlace;
    }

    public void setServicePlace(String servicePlace) {
        this.servicePlace = servicePlace;
    }

    public Date getExpectEndTime() {
        return expectEndTime;
    }

    public void setExpectEndTime(Date expectEndTime) {
        this.expectEndTime = expectEndTime;
    }

    public Long getStartPeopleId() {
        return startPeopleId;
    }

    public void setStartPeopleId(Long startPeopleId) {
        this.startPeopleId = startPeopleId;
    }

}
