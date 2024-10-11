package com.exp.ucmp.smp.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ReserveDto", description = "预约List")
public class ReserveDto {

	@ApiModelProperty(value = "预约单编码")
	private String orderReserveCode;
	
	@ApiModelProperty(value = "预约状态")
    private String reserveStatus;
	
	@ApiModelProperty(value = "预约形式")
    private String reserveType;
	
	@ApiModelProperty(value = "预约时间")
    private String reserveTime;
	
	@ApiModelProperty(value = "预约地点")
    private String reservePlace;
	
	@ApiModelProperty(value = "交付省份Id")
    private String provinceId;
	
	@ApiModelProperty(value = "交付省份名称")
    private String provinceName;
	
	@ApiModelProperty(value = "交付城市Id")
    private String cityId;
	
	@ApiModelProperty(value = "交付城市名称")
    private String cityName;
	
	@ApiModelProperty(value = "交付地区Id")
    private String areaId;
	
	@ApiModelProperty(value = "交付地区名称")
    private String areaName;
	
	@ApiModelProperty(value = "交付地点")
    private String address;
	
	@ApiModelProperty(value = "验车方式 预约形式为验车时必填,1线上验车,2线下验车")
    private String checkType;

	public String getOrderReserveCode() {
		return orderReserveCode;
	}

	public void setOrderReserveCode(String orderReserveCode) {
		this.orderReserveCode = orderReserveCode;
	}

	public String getReserveStatus() {
		return reserveStatus;
	}

	public void setReserveStatus(String reserveStatus) {
		this.reserveStatus = reserveStatus;
	}

	public String getReserveType() {
		return reserveType;
	}

	public void setReserveType(String reserveType) {
		this.reserveType = reserveType;
	}

	public String getReserveTime() {
		return reserveTime;
	}

	public void setReserveTime(String reserveTime) {
		this.reserveTime = reserveTime;
	}

	public String getReservePlace() {
		return reservePlace;
	}

	public void setReservePlace(String reservePlace) {
		this.reservePlace = reservePlace;
	}

	public String getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getAreaId() {
		return areaId;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCheckType() {
		return checkType;
	}

	public void setCheckType(String checkType) {
		this.checkType = checkType;
	}
	
}
