package com.exp.ucmp.logistics.dto;

import java.util.List;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "TransitPointInfoDto", description = "发运状态实体类")
public class TransitPointInfoDto {
	
	@NotNull
	@ApiModelProperty(value = "Vin码")
	private String vin;
	
	@NotNull
	@ApiModelProperty(value = "渠道 UCMP")
    private String channel;
	
	@NotNull
	@ApiModelProperty(value = "物流状态 1：待发运、2：已调度、3：运输在途、4：车已送达、5：已取消")
    private String shippingStatus;
	
	@ApiModelProperty(value = "发运请求编号")
    private String requestNo;
	
	@ApiModelProperty(value = "承运商名称")
    private String carrierName;
	
	@ApiModelProperty(value = "司机姓名")
    private String driverName;
	
	@ApiModelProperty(value = "司机移动电话")
    private String driverMobile;
	
	@ApiModelProperty(value = "车牌号")
    private String licenseNumber;
	
	@ApiModelProperty(value = "预计送达时间")
    private String arrivingTime;
	
	@ApiModelProperty(value = "当前地址集合")
    private List<NowLocationDto> nowLocationList;

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getShippingStatus() {
		return shippingStatus;
	}

	public void setShippingStatus(String shippingStatus) {
		this.shippingStatus = shippingStatus;
	}

	public String getRequestNo() {
		return requestNo;
	}

	public void setRequestNo(String requestNo) {
		this.requestNo = requestNo;
	}

	public String getCarrierName() {
		return carrierName;
	}

	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getDriverMobile() {
		return driverMobile;
	}

	public void setDriverMobile(String driverMobile) {
		this.driverMobile = driverMobile;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public String getArrivingTime() {
		return arrivingTime;
	}

	public void setArrivingTime(String arrivingTime) {
		this.arrivingTime = arrivingTime;
	}

	public List<NowLocationDto> getNowLocationList() {
		return nowLocationList;
	}

	public void setNowLocationList(List<NowLocationDto> nowLocationList) {
		this.nowLocationList = nowLocationList;
	}
	
}
