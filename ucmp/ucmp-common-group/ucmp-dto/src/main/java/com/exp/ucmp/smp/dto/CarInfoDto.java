package com.exp.ucmp.smp.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "CarInfoDto", description = "车辆信息返回类")
public class CarInfoDto {

	@ApiModelProperty(value = "车辆信息返回类")
	private VehicleInfoDto vehicleInfo;
	
	@ApiModelProperty(value = "车主信息返回类")
	private VehicleOwnerDto vehicleOwner;

	public VehicleInfoDto getVehicleInfo() {
		return vehicleInfo;
	}

	public void setVehicleInfo(VehicleInfoDto vehicleInfo) {
		this.vehicleInfo = vehicleInfo;
	}

	public VehicleOwnerDto getVehicleOwner() {
		return vehicleOwner;
	}

	public void setVehicleOwner(VehicleOwnerDto vehicleOwner) {
		this.vehicleOwner = vehicleOwner;
	}
	
}
