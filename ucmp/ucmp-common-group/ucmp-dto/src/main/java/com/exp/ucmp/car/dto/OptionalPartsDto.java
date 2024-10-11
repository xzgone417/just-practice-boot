package com.exp.ucmp.car.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "OptionalPartsDto", description = "车辆选装件实体类")
public class OptionalPartsDto {
	
	@ApiModelProperty(value = "选装id")
	private String optionId;
	
	@ApiModelProperty(value = "车辆id")
	private String stockId;
	
	@ApiModelProperty(value = "序号")
	private String serialNumber;
	
	@ApiModelProperty(value = "选装件编码")
	private String optionalPartsCode;
	
	@ApiModelProperty(value = "vin码")
	private String optionalPartsName;
	
	@ApiModelProperty(value = "选装件编码")
	private Long createdBy;

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getOptionalPartsCode() {
		return optionalPartsCode;
	}

	public void setOptionalPartsCode(String optionalPartsCode) {
		this.optionalPartsCode = optionalPartsCode;
	}

	public String getOptionalPartsName() {
		return optionalPartsName;
	}

	public void setOptionalPartsName(String optionalPartsName) {
		this.optionalPartsName = optionalPartsName;
	}
	
}
