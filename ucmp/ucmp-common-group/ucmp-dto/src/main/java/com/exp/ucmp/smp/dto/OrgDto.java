package com.exp.ucmp.smp.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "OrgDto", description = "门店组织信息")
public class OrgDto {
	
	@ApiModelProperty(value = "组织ID")
	private String orgId;
	
	@ApiModelProperty(value = "组织编码")
    private String orgCode;
	
	@ApiModelProperty(value = "组织名称")
    private String orgName;
	
	@ApiModelProperty(value = "组织类型")
    private String orgType;
	
	@ApiModelProperty(value = "上级组织(ID)")
    private String parentOrgId;
	
	@ApiModelProperty(value = "组织描述")
    private String remark;
	
	@ApiModelProperty(value = "详细地址")
    private String linkAddr;
	
	@ApiModelProperty(value = "经度")
    private String lng;
	
	@ApiModelProperty(value = "纬度")
    private String lat;
	
	@ApiModelProperty(value = "省份编码")
    private String provinceId;
	
	@ApiModelProperty(value = "城市编码")
    private String cityId;
	
	@ApiModelProperty(value = "营业时间")
    private String businessTime;
	
	@ApiModelProperty(value = "排序(ID)")
    private String orderNo;
	
	@ApiModelProperty(value = "是否可用")
    private String isEnable;

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getOrgType() {
		return orgType;
	}

	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}

	public String getParentOrgId() {
		return parentOrgId;
	}

	public void setParentOrgId(String parentOrgId) {
		this.parentOrgId = parentOrgId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getLinkAddr() {
		return linkAddr;
	}

	public void setLinkAddr(String linkAddr) {
		this.linkAddr = linkAddr;
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

	public String getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getBusinessTime() {
		return businessTime;
	}

	public void setBusinessTime(String businessTime) {
		this.businessTime = businessTime;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getIsEnable() {
		return isEnable;
	}

	public void setIsEnable(String isEnable) {
		this.isEnable = isEnable;
	}
	
}
