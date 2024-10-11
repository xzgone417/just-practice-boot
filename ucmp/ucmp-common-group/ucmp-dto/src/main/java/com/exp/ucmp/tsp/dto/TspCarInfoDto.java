package com.exp.ucmp.tsp.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "TspCarInfoDto", description = "tsp车辆信息")
public class TspCarInfoDto {
	
	@ApiModelProperty(value = "激活状态1:已激活0:未激活")
	private int activeStatus;
	
	@ApiModelProperty(value = "vin码")
    private String vin;
	
	@ApiModelProperty(value = "车型年 Code")
    private String modelYearCode;
	
	@ApiModelProperty(value = "销售车型 Code")
    private String salModelCode;
	
	@ApiModelProperty(value = "销售车型名称")
    private String salModelName;
	
	@ApiModelProperty(value = "车型年名称")
    private String modelYearName;

	public int getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(int activeStatus) {
		this.activeStatus = activeStatus;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getModelYearCode() {
		return modelYearCode;
	}

	public void setModelYearCode(String modelYearCode) {
		this.modelYearCode = modelYearCode;
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

	public String getModelYearName() {
		return modelYearName;
	}

	public void setModelYearName(String modelYearName) {
		this.modelYearName = modelYearName;
	}
}
