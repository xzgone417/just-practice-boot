package com.exp.ucmp.iautos.dto;

import java.util.Map;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "CarDetailDto", description = "车辆详细信息")
public class CarDetailDto {
	
	@ApiModelProperty(value = "品牌信息")
	private CarBrandDto brand;
	
	@ApiModelProperty(value = "厂商信息")
    private Map<String,String> carMfrs;
	
	@ApiModelProperty(value = "车系信息")
    private CarSeriesDto carSeries;
	
	@ApiModelProperty(value = "车型详情")
    private Map<String,Object> detail;
	
	@ApiModelProperty(value = "车型信息")
    private CarModelDto model;

	public CarBrandDto getBrand() {
		return brand;
	}

	public void setBrand(CarBrandDto brand) {
		this.brand = brand;
	}

	public Map<String, String> getCarMfrs() {
		return carMfrs;
	}

	public void setCarMfrs(Map<String, String> carMfrs) {
		this.carMfrs = carMfrs;
	}

	public CarSeriesDto getCarSeries() {
		return carSeries;
	}

	public void setCarSeries(CarSeriesDto carSeries) {
		this.carSeries = carSeries;
	}

	public Map<String, Object> getDetail() {
		return detail;
	}

	public void setDetail(Map<String, Object> detail) {
		this.detail = detail;
	}

	public CarModelDto getModel() {
		return model;
	}

	public void setModel(CarModelDto model) {
		this.model = model;
	}
	
	
}
