package com.exp.ucmp.iautos.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "AssessForReplaceDto", description = "估价信息置换单参数类")
public class AssessForReplaceDto {
	
	@ApiModelProperty(value = "品牌id")
	private String brandId;
	
	@ApiModelProperty(value = "品牌名称")
	private String brandName;
	
	@ApiModelProperty(value = "车系id")
	private String seriesId;
	
	@ApiModelProperty(value = "车系名称")
	private String seriesName;

	@ApiModelProperty(value = "年款")
	private String year;
	
	@ApiModelProperty(value = "车型id")
    private String modelId;
	
	@ApiModelProperty(value = "车型名称")
    private String modelName;
	
	@ApiModelProperty(value = "上牌城市行政编码")
    private String provinceId;
	
	@ApiModelProperty(value = "上牌城市名称")
    private String provinceName;
	
	@ApiModelProperty(value = "上牌城市行政编码")
    private String cityId;
	
	@ApiModelProperty(value = "上牌城市名称")
    private String cityName;
	
	@ApiModelProperty(value = "指导价/万元")
    private double guidePrice;
	
	@ApiModelProperty(value = "里程/公里")
    private double km;

	public String getBrandId() {
		return brandId;
	}

	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getSeriesId() {
		return seriesId;
	}

	public void setSeriesId(String seriesId) {
		this.seriesId = seriesId;
	}

	public String getSeriesName() {
		return seriesName;
	}

	public void setSeriesName(String seriesName) {
		this.seriesName = seriesName;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getModelId() {
		return modelId;
	}

	public void setModelId(String modelId) {
		this.modelId = modelId;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
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

	public double getGuidePrice() {
		return guidePrice;
	}

	public void setGuidePrice(double guidePrice) {
		this.guidePrice = guidePrice;
	}

	public double getKm() {
		return km;
	}

	public void setKm(double km) {
		this.km = km;
	}
	
}
