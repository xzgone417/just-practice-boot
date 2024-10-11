package com.exp.ucmp.maindata.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ProvinceDto", description = "省 行政区实体类")
public class ProvinceDto {
	
	@ApiModelProperty(value = "省份编码")
	private String provinceId;
	
	@ApiModelProperty(value = "省份名称")
    private String provinceName;
	
	@ApiModelProperty(value = "下辖市行政区")
    private List<CitiesDto> cities;

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

	public List<CitiesDto> getCities() {
		return cities;
	}

	public void setCities(List<CitiesDto> cities) {
		this.cities = cities;
	}
	
}
