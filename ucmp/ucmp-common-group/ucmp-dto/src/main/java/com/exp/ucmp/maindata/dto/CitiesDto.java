package com.exp.ucmp.maindata.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(value = "CitiesDto", description = "市 行政区实体类")
public class CitiesDto {
	
	@ApiModelProperty(value = "城市编码")
	private String cityId;
	
	@ApiModelProperty(value = "城市名称")
    private String cityName;

	@ApiModelProperty(value = "下辖区县")
	private List<DistrictDto> districts;

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

	public List<DistrictDto> getDistricts() {
		return districts;
	}

	public void setDistricts(List<DistrictDto> districts) {
		this.districts = districts;
	}
}
