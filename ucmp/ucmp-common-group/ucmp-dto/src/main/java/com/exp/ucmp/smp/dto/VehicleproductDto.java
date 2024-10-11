package com.exp.ucmp.smp.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "VehicleproductDto", description = "车型产品")
public class VehicleproductDto {
	
	@ApiModelProperty(value = "工程车型编码")
	private String carSeriesCode;
	
	@ApiModelProperty(value = "工程车型中文名称")
    private String carSeriesCn;
	
	@ApiModelProperty(value = "工程车型英文名称")
    private String carSeriesEn;
	
	@ApiModelProperty(value = "基础车型List")
    private List<CarModelDto> veTypeList;

	public String getCarSeriesCode() {
		return carSeriesCode;
	}

	public void setCarSeriesCode(String carSeriesCode) {
		this.carSeriesCode = carSeriesCode;
	}

	public String getCarSeriesCn() {
		return carSeriesCn;
	}

	public void setCarSeriesCn(String carSeriesCn) {
		this.carSeriesCn = carSeriesCn;
	}

	public String getCarSeriesEn() {
		return carSeriesEn;
	}

	public void setCarSeriesEn(String carSeriesEn) {
		this.carSeriesEn = carSeriesEn;
	}

	public List<CarModelDto> getVeTypeList() {
		return veTypeList;
	}

	public void setVeTypeList(List<CarModelDto> veTypeList) {
		this.veTypeList = veTypeList;
	}
	
}
