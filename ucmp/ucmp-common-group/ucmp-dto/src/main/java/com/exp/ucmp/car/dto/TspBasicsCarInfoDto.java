package com.exp.ucmp.car.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "OptionalPartsDto", description = "车辆选装件实体类")
public class TspBasicsCarInfoDto {
	
	@ApiModelProperty(value = "车型年 Code")
	private String modelYearCode;
	
	@ApiModelProperty(value = "车型年名称")
	private String modelYearName;
	
	@ApiModelProperty(value = "销售车型 Code")
	private String salModelCode;
	
	@ApiModelProperty(value = "销售车型名称")
	private String salModelName;
	
	@ApiModelProperty(value = "激活状态 1:已激活 0:未激活")
	private Integer activeStatus;

	@ApiModelProperty(value = "车辆颜色")
	private String vehicleColor;
	
	@ApiModelProperty(value = "内饰颜色")
	private String interiorColor;
	
	@ApiModelProperty(value = "电池容量")
	private String batteryCapacity;
	
	@ApiModelProperty(value = "出厂日期")
	private String manufactureTime;
	
	@ApiModelProperty(value = "首次激活时间")
	private String activeTime;

	public String getModelYearCode() {
		return modelYearCode;
	}

	public void setModelYearCode(String modelYearCode) {
		this.modelYearCode = modelYearCode;
	}

	public String getModelYearName() {
		return modelYearName;
	}

	public void setModelYearName(String modelYearName) {
		this.modelYearName = modelYearName;
	}

	public String getSalModelCode() {
		return salModelCode;
	}

	public void setSalModelCode(String salModelCode) {
		this.salModelCode = salModelCode;
	}

	public String getSalModelName() {
		return salModelName;
	}

	public void setSalModelName(String salModelName) {
		this.salModelName = salModelName;
	}

	public Integer getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(Integer activeStatus) {
		this.activeStatus = activeStatus;
	}

	public String getVehicleColor() {
		return vehicleColor;
	}

	public void setVehicleColor(String vehicleColor) {
		this.vehicleColor = vehicleColor;
	}

	public String getInteriorColor() {
		return interiorColor;
	}

	public void setInteriorColor(String interiorColor) {
		this.interiorColor = interiorColor;
	}

	public String getBatteryCapacity() {
		return batteryCapacity;
	}

	public void setBatteryCapacity(String batteryCapacity) {
		this.batteryCapacity = batteryCapacity;
	}

	public String getManufactureTime() {
		return manufactureTime;
	}

	public void setManufactureTime(String manufactureTime) {
		this.manufactureTime = manufactureTime;
	}

	public String getActiveTime() {
		return activeTime;
	}

	public void setActiveTime(String activeTime) {
		this.activeTime = activeTime;
	}
	
}
