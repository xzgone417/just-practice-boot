package com.exp.ucmp.usedstorage.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "UsedStorageInfoDto", description = "仓储点信息Dto")
public class UsedStorageInfoDto {

    @ApiModelProperty(value = "仓储点id")
    private Long storageId;

    @ApiModelProperty(value = "仓储点名称")
    private String storageName;

    @ApiModelProperty(value = "仓库编码")
    private String storageCode;

    @ApiModelProperty(value = "城市")
    private String city;

    @ApiModelProperty(value = "城市(ID)")
    private String cityId;

    @ApiModelProperty(value = "省份")
    private String province;

    @ApiModelProperty(value = "省份ID")
    private String provinceId;

	public Long getStorageId() {
		return storageId;
	}

	public void setStorageId(Long storageId) {
		this.storageId = storageId;
	}

	public String getStorageName() {
		return storageName;
	}

	public void setStorageName(String storageName) {
		this.storageName = storageName;
	}

	public String getStorageCode() {
		return storageCode;
	}

	public void setStorageCode(String storageCode) {
		this.storageCode = storageCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}

}
