package com.exp.ucmp.eos.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ReservationDto", description = "置换单实体类")
public class ReservationDto {
	
	@ApiModelProperty(value = "置换预约单的跟踪ID")
	private String trackId;
	
	@ApiModelProperty(value = "置换预约单的业务单号")
	private String businessOrderNo;
	
	@ApiModelProperty(value = "品牌")
    private String vehicleBrand;
	
	@ApiModelProperty(value = "车系")
    private String vehicleSeries;
	
	@ApiModelProperty(value = "年款")
    private String vehicleYear;
	
	@ApiModelProperty(value = "车型")
    private String vehicleModel;
	
	@ApiModelProperty(value = "上牌城市")
    private String licensedCity;
	
	@ApiModelProperty(value = "上牌时间")
    private String licensedTime;
	
	@ApiModelProperty(value = "期望报价")
    private String expectedPrice;
	
	@ApiModelProperty(value = "最优报价")
    private String bestPrice;
	
	@ApiModelProperty(value = "预约检测地点")
    private String detectionLocation;
	
	@ApiModelProperty(value = "预约检测时间")
    private String detectionTime;
	
	@ApiModelProperty(value = "跟踪单状态")
    private String trackStatus;
	
	@ApiModelProperty(value = "跟踪单状态描述")
    private String trackStatusDesc;
	
	@ApiModelProperty(value = "用户所属门店smp-code")
	private String departmentId;
	
	@ApiModelProperty(value = "组织id")
	private String organizationId;

	public String getTrackId() {
		return trackId;
	}

	public void setTrackId(String trackId) {
		this.trackId = trackId;
	}

	public String getBusinessOrderNo() {
		return businessOrderNo;
	}

	public void setBusinessOrderNo(String businessOrderNo) {
		this.businessOrderNo = businessOrderNo;
	}

	public String getVehicleBrand() {
		return vehicleBrand;
	}

	public void setVehicleBrand(String vehicleBrand) {
		this.vehicleBrand = vehicleBrand;
	}

	public String getVehicleSeries() {
		return vehicleSeries;
	}

	public void setVehicleSeries(String vehicleSeries) {
		this.vehicleSeries = vehicleSeries;
	}

	public String getVehicleYear() {
		return vehicleYear;
	}

	public void setVehicleYear(String vehicleYear) {
		this.vehicleYear = vehicleYear;
	}

	public String getVehicleModel() {
		return vehicleModel;
	}

	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}

	public String getLicensedCity() {
		return licensedCity;
	}

	public void setLicensedCity(String licensedCity) {
		this.licensedCity = licensedCity;
	}

	public String getLicensedTime() {
		return licensedTime;
	}

	public void setLicensedTime(String licensedTime) {
		this.licensedTime = licensedTime;
	}

	public String getExpectedPrice() {
		return expectedPrice;
	}

	public void setExpectedPrice(String expectedPrice) {
		this.expectedPrice = expectedPrice;
	}

	public String getBestPrice() {
		return bestPrice;
	}

	public void setBestPrice(String bestPrice) {
		this.bestPrice = bestPrice;
	}

	public String getDetectionLocation() {
		return detectionLocation;
	}

	public void setDetectionLocation(String detectionLocation) {
		this.detectionLocation = detectionLocation;
	}

	public String getDetectionTime() {
		return detectionTime;
	}

	public void setDetectionTime(String detectionTime) {
		this.detectionTime = detectionTime;
	}

	public String getTrackStatus() {
		return trackStatus;
	}

	public void setTrackStatus(String trackStatus) {
		this.trackStatus = trackStatus;
	}

	public String getTrackStatusDesc() {
		return trackStatusDesc;
	}

	public void setTrackStatusDesc(String trackStatusDesc) {
		this.trackStatusDesc = trackStatusDesc;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}
	
}
