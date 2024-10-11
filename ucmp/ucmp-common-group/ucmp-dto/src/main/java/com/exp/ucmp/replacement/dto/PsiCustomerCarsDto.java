package com.exp.ucmp.replacement.dto;

import com.egrid.core.base.model.BaseModel;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value = "PsiCustomerCarsDto", description = "客户车辆表")
public class PsiCustomerCarsDto extends BaseModel {

    private static final long serialVersionUID = 1L;
    /**
     * 预约ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "预约ID")
    private Long reservationId;


    /**
     * 客户ID
     */
    @ApiModelProperty(value = "客户ID")
    private Long customerId;

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
     * 年款
     */
    @ApiModelProperty(value = "年款")
    private String carYear;

    /**
     * 年款中文描述
     */
    @ApiModelProperty(value = "年款中文描述")
    private String carYearChineseDescribe;

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

    @ApiModelProperty(value = "派单人")
    private String allotPerson;
    
    @ApiModelProperty(value = "派单人ID")
    private String allotPersonId;

    public PsiCustomerCarsDto() {
    }

    public PsiCustomerCarsDto(Long reservationId) {
        this.reservationId = reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }
    public Long getReservationId() {
        return this.reservationId;
    }
    

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
    public Long getCustomerId() {
        return this.customerId;
    }
    
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getBrand() {
        return this.brand;
    }
    
    public void setBrandChineseDescribe(String brandChineseDescribe) {
        this.brandChineseDescribe = brandChineseDescribe;
    }
    public String getBrandChineseDescribe() {
        return this.brandChineseDescribe;
    }
    
    public void setCarSeries(String carSeries) {
        this.carSeries = carSeries;
    }
    public String getCarSeries() {
        return this.carSeries;
    }
    
    public void setCarSeriesChineseDescribe(String carSeriesChineseDescribe) {
        this.carSeriesChineseDescribe = carSeriesChineseDescribe;
    }
    public String getCarSeriesChineseDescribe() {
        return this.carSeriesChineseDescribe;
    }
    
    public void setCarYear(String carYear) {
        this.carYear = carYear;
    }
    public String getCarYear() {
        return this.carYear;
    }
    
    public void setCarYearChineseDescribe(String carYearChineseDescribe) {
        this.carYearChineseDescribe = carYearChineseDescribe;
    }
    public String getCarYearChineseDescribe() {
        return this.carYearChineseDescribe;
    }
    
    public void setCarType(String carType) {
        this.carType = carType;
    }
    public String getCarType() {
        return this.carType;
    }
    
    public void setCarTypeChineseDescribe(String carTypeChineseDescribe) {
        this.carTypeChineseDescribe = carTypeChineseDescribe;
    }
    public String getCarTypeChineseDescribe() {
        return this.carTypeChineseDescribe;
    }
    
    public void setLicensingCity(String licensingCity) {
        this.licensingCity = licensingCity;
    }
    public String getLicensingCity() {
        return this.licensingCity;
    }
    
    public void setLicensingProvince(String licensingProvince) {
        this.licensingProvince = licensingProvince;
    }
    public String getLicensingProvince() {
        return this.licensingProvince;
    }
    
    public void setLicensingDate(Date licensingDate) {
        this.licensingDate = licensingDate;
    }
    public Date getLicensingDate() {
        return this.licensingDate;
    }
    
    public void setDrivingMileage(String drivingMileage) {
        this.drivingMileage = drivingMileage;
    }
    public String getDrivingMileage() {
        return this.drivingMileage;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    public String getColor() {
        return this.color;
    }
    
    public void setLicensePlateNum(String licensePlateNum) {
        this.licensePlateNum = licensePlateNum;
    }
    public String getLicensePlateNum() {
        return this.licensePlateNum;
    }
    
    public void setVinCode(String vinCode) {
        this.vinCode = vinCode;
    }
    public String getVinCode() {
        return this.vinCode;
    }
    
    public void setTransferTimes(String transferTimes) {
        this.transferTimes = transferTimes;
    }
    public String getTransferTimes() {
        return this.transferTimes;
    }
    
    public void setUsingNature(String usingNature) {
        this.usingNature = usingNature;
    }
    public String getUsingNature() {
        return this.usingNature;
    }

	public String getAllotPerson() {
		return allotPerson;
	}

	public void setAllotPerson(String allotPerson) {
		this.allotPerson = allotPerson;
	}

	public String getAllotPersonId() {
		return allotPersonId;
	}

	public void setAllotPersonId(String allotPersonId) {
		this.allotPersonId = allotPersonId;
	}
    

}
