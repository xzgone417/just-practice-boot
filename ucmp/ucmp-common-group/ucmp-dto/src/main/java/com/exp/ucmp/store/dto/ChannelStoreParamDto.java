package com.exp.ucmp.store.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ChannelStoreParamDto", description = "查询营销渠道门店列表参数类")
public class ChannelStoreParamDto{

    @ApiModelProperty(value = "组织code，不传返回全量")
    private String orgCode;

    @ApiModelProperty(value = "门店状态，传多个用‘,’分隔，不传默认全部")
    private String storeStatus;
    
    @ApiModelProperty(value = "门店大类，传多个用‘,’分隔，不传默认全部")
    private String storeMainType;
    
    @ApiModelProperty(value = "门店类型，传多个用‘,’分隔，不传默认全部")
    private String storeType;
    
    @ApiModelProperty(value = "门店经营类型，传多个用‘,’分隔，不传默认全部")
    private String storeServiceType;
    
    @ApiModelProperty(value = "合作公司代码，传多个用‘,’分隔，不传默认全部")
    private String cpCode;
    
    @ApiModelProperty(value = "门店所在省份")
    private String storeProvince;
    
    @ApiModelProperty(value = "门店所在城市")
    private String storeCity;
    
    @ApiModelProperty(value = "是否C端露出，1:是 0:否")
    private String isClientShow;
    
    @ApiModelProperty(value = "是否可预约试驾，1:是 0:否")
    private String isReserveTestDrive;
    
    @ApiModelProperty(value = "是否可预约售后，1:是 0:否")
    private String isReserveCustomerService;

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getStoreStatus() {
		return storeStatus;
	}

	public void setStoreStatus(String storeStatus) {
		this.storeStatus = storeStatus;
	}

	public String getStoreMainType() {
		return storeMainType;
	}

	public void setStoreMainType(String storeMainType) {
		this.storeMainType = storeMainType;
	}

	public String getStoreType() {
		return storeType;
	}

	public void setStoreType(String storeType) {
		this.storeType = storeType;
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

	public String getStoreProvince() {
		return storeProvince;
	}

	public void setStoreProvince(String storeProvince) {
		this.storeProvince = storeProvince;
	}

	public String getStoreCity() {
		return storeCity;
	}

	public void setStoreCity(String storeCity) {
		this.storeCity = storeCity;
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
}
