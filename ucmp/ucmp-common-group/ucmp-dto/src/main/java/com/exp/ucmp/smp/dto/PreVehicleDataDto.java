package com.exp.ucmp.smp.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "PreVehicleDataDto", description = "小订阶段预车型数据")
public class PreVehicleDataDto {
	
	@ApiModelProperty(value = "预工程车型编码")
	private String ppVehicleCode;
	
	@ApiModelProperty(value = "预工程车型名称")
	private String ppVehicleName;
	
	@ApiModelProperty(value = "预基础车型编码")
	private String pbVehicleCode;
	
	@ApiModelProperty(value = "预基础车型名称")
	private String pbVehicleName;
	
	@ApiModelProperty(value = "预基础车型价格")
	private String pbVehiclePrice;
	
	@ApiModelProperty(value = "选配值表")
	private List<OptionsDto> options;
	
	@ApiModelProperty(value = "预车型选配总价=预基础车型价格+选配值总价")
	private String preTotalPrice;

	public String getPpVehicleCode() {
		return ppVehicleCode;
	}

	public void setPpVehicleCode(String ppVehicleCode) {
		this.ppVehicleCode = ppVehicleCode;
	}

	public String getPpVehicleName() {
		return ppVehicleName;
	}

	public void setPpVehicleName(String ppVehicleName) {
		this.ppVehicleName = ppVehicleName;
	}

	public String getPbVehicleCode() {
		return pbVehicleCode;
	}

	public void setPbVehicleCode(String pbVehicleCode) {
		this.pbVehicleCode = pbVehicleCode;
	}

	public String getPbVehicleName() {
		return pbVehicleName;
	}

	public void setPbVehicleName(String pbVehicleName) {
		this.pbVehicleName = pbVehicleName;
	}

	public String getPbVehiclePrice() {
		return pbVehiclePrice;
	}

	public void setPbVehiclePrice(String pbVehiclePrice) {
		this.pbVehiclePrice = pbVehiclePrice;
	}

	public List<OptionsDto> getOptions() {
		return options;
	}

	public void setOptions(List<OptionsDto> options) {
		this.options = options;
	}

	public String getPreTotalPrice() {
		return preTotalPrice;
	}

	public void setPreTotalPrice(String preTotalPrice) {
		this.preTotalPrice = preTotalPrice;
	}
	
}
