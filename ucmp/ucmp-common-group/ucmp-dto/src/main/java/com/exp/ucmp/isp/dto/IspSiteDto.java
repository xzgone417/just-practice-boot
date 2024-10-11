package com.exp.ucmp.isp.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "IspSiteDto", description = "isp服务点信息类")
public class IspSiteDto {
	
	@ApiModelProperty(value = "网点ID")
	private String siteId;
	
	@ApiModelProperty(value = "省编码")
    private String provinceCode;
	
	@ApiModelProperty(value = "省名称")
    private String provinceName;
	
	@ApiModelProperty(value = "市编码")
    private String cityCode;
	
	@ApiModelProperty(value = "市名称")
    private String cityName;
	
	@ApiModelProperty(value = "网点编码")
    private String siteCode;
	
	@ApiModelProperty(value = "网点类型")
    private String siteType;
	
	@ApiModelProperty(value = "网点全称")
    private String fullName;
	
	@ApiModelProperty(value = "网点简称")
    private String shortName;
	
	@ApiModelProperty(value = "网点门头照")
    private String sitePictureUrl;
	
	@ApiModelProperty(value = "负责人")
    private String ownerName;
	
	@ApiModelProperty(value = "负责人手机号")
    private String ownerPhone;
	
	@ApiModelProperty(value = "经度")
    private String lng;
	
	@ApiModelProperty(value = "维度")
    private String lat;
	
	@ApiModelProperty(value = "营业开始时间")
    private String openingTimes;
	
	@ApiModelProperty(value = "营业结束时间")
    private String closingTimes;
	
	@ApiModelProperty(value = "网点地址")
    private String address;
	
	@ApiModelProperty(value = "营业状态")
    private String operatingStatus;
	
	@ApiModelProperty(value = "不营业时间")
    private String nonBusinessDay;
	
	@ApiModelProperty(value = "")
    private String businessType;
	
	@ApiModelProperty(value = "是否C端显示")
    private String isCShow;
	
	@ApiModelProperty(value = "是否可以预约")
    private String isReserve;

	public String getSiteId() {
		return siteId;
	}

	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getSiteCode() {
		return siteCode;
	}

	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}

	public String getSiteType() {
		return siteType;
	}

	public void setSiteType(String siteType) {
		this.siteType = siteType;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getSitePictureUrl() {
		return sitePictureUrl;
	}

	public void setSitePictureUrl(String sitePictureUrl) {
		this.sitePictureUrl = sitePictureUrl;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getOwnerPhone() {
		return ownerPhone;
	}

	public void setOwnerPhone(String ownerPhone) {
		this.ownerPhone = ownerPhone;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getOpeningTimes() {
		return openingTimes;
	}

	public void setOpeningTimes(String openingTimes) {
		this.openingTimes = openingTimes;
	}

	public String getClosingTimes() {
		return closingTimes;
	}

	public void setClosingTimes(String closingTimes) {
		this.closingTimes = closingTimes;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getOperatingStatus() {
		return operatingStatus;
	}

	public void setOperatingStatus(String operatingStatus) {
		this.operatingStatus = operatingStatus;
	}

	public String getNonBusinessDay() {
		return nonBusinessDay;
	}

	public void setNonBusinessDay(String nonBusinessDay) {
		this.nonBusinessDay = nonBusinessDay;
	}

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	public String getIsCShow() {
		return isCShow;
	}

	public void setIsCShow(String isCShow) {
		this.isCShow = isCShow;
	}

	public String getIsReserve() {
		return isReserve;
	}

	public void setIsReserve(String isReserve) {
		this.isReserve = isReserve;
	}

}
