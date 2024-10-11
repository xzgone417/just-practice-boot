package com.exp.ucmp.smp.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SmpStoreDataDto", description = "smp返回类")
public class SmpStoreDataDto{
	
	@ApiModelProperty(value = "主键")
	private long id;
	
	@ApiModelProperty(value = "门店代码")
    private String storeCode;
	
	@ApiModelProperty(value = "门店名称")
    private String storeFullName;
	
	@ApiModelProperty(value = "门店简称")
    private String storeName;
	
	@ApiModelProperty(value = "SAP代码")
    private String sapCode;
	
	@ApiModelProperty(value = "门店状态 0：门店在建、1：正常营业、2：暂停营业、3：试营业、4：闭店")
    private String storeStatus;
	
	@ApiModelProperty(value = "门店类型S销售类：0：体验中心、1：POP、2、特展店、99：销售虚拟店、7：用户中心 D交付类：3：交付中心、98：交付虚拟店 A售后类：4、服务中心、5：钣喷中心、6：第三方服务商、97：售后虚拟店")
    private String storeType;
	
	@ApiModelProperty(value = "门店大类 S：销售类、D：交付类、A：售后类")
    private String storeMainType;
	
	@ApiModelProperty(value = "门店经营类型 H：直营、P：合作直营、D：经销")
    private String storeServiceType;
	
	@ApiModelProperty(value = "合作公司代码")
    private String cpCode;
	
	@ApiModelProperty(value = "合作公司名称")
    private String cpFullName;
	
	@ApiModelProperty(value = "组织id")
    private String orgId;
	
	@ApiModelProperty(value = "组织代码")
    private String orgCode;
	
	@ApiModelProperty(value = "组织名称")
    private String orgName;
	
	@ApiModelProperty(value = "门店所在省份")
    private String province;
	
	@ApiModelProperty(value = "门店所在城市")
    private String city;
	
	@ApiModelProperty(value = "")
    private String district;
	
	@ApiModelProperty(value = "是否C端露出")
    private String isClientShow;
	
	@ApiModelProperty(value = "是否可预约试驾")
    private String isReserveTestDrive;
	
	@ApiModelProperty(value = "是否可预约售后")
    private String isReserveCustomerService;
	
	@ApiModelProperty(value = "主键")
    private String isEnable;
	
	@ApiModelProperty(value = "主键")
    private String creator;
	
	@ApiModelProperty(value = "主键")
    private String modifier;
	
	@ApiModelProperty(value = "创建时间戳")
    private long createTimestamp;
	
	@ApiModelProperty(value = "最后更新时间戳")
    private long modifiedTimestamp;
	
	@ApiModelProperty(value = "SMP门店ID")
    private String smpStoreId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStoreCode() {
		return storeCode;
	}

	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}

	public String getStoreFullName() {
		return storeFullName;
	}

	public void setStoreFullName(String storeFullName) {
		this.storeFullName = storeFullName;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getSapCode() {
		return sapCode;
	}

	public void setSapCode(String sapCode) {
		this.sapCode = sapCode;
	}

	public String getStoreStatus() {
		return storeStatus;
	}

	public void setStoreStatus(String storeStatus) {
		this.storeStatus = storeStatus;
	}

	public String getStoreType() {
		return storeType;
	}

	public void setStoreType(String storeType) {
		this.storeType = storeType;
	}

	public String getStoreMainType() {
		return storeMainType;
	}

	public void setStoreMainType(String storeMainType) {
		this.storeMainType = storeMainType;
	}

	public String getStoreServiceType() {
		return storeServiceType;
	}

	public void setStoreServiceType(String storeServiceType) {
		this.storeServiceType = storeServiceType;
	}

	public String getCpCode() {
		return cpCode;
	}

	public void setCpCode(String cpCode) {
		this.cpCode = cpCode;
	}

	public String getCpFullName() {
		return cpFullName;
	}

	public void setCpFullName(String cpFullName) {
		this.cpFullName = cpFullName;
	}

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

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getIsClientShow() {
		return isClientShow;
	}

	public void setIsClientShow(String isClientShow) {
		this.isClientShow = isClientShow;
	}

	public String getIsReserveTestDrive() {
		return isReserveTestDrive;
	}

	public void setIsReserveTestDrive(String isReserveTestDrive) {
		this.isReserveTestDrive = isReserveTestDrive;
	}

	public String getIsReserveCustomerService() {
		return isReserveCustomerService;
	}

	public void setIsReserveCustomerService(String isReserveCustomerService) {
		this.isReserveCustomerService = isReserveCustomerService;
	}

	public String getIsEnable() {
		return isEnable;
	}

	public void setIsEnable(String isEnable) {
		this.isEnable = isEnable;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getModifier() {
		return modifier;
	}

	public void setModifier(String modifier) {
		this.modifier = modifier;
	}

	public long getCreateTimestamp() {
		return createTimestamp;
	}

	public void setCreateTimestamp(long createTimestamp) {
		this.createTimestamp = createTimestamp;
	}

	public long getModifiedTimestamp() {
		return modifiedTimestamp;
	}

	public void setModifiedTimestamp(long modifiedTimestamp) {
		this.modifiedTimestamp = modifiedTimestamp;
	}

	public String getSmpStoreId() {
		return smpStoreId;
	}

	public void setSmpStoreId(String smpStoreId) {
		this.smpStoreId = smpStoreId;
	}
}
