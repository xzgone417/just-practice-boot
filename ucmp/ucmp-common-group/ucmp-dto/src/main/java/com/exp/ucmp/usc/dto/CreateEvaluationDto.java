package com.exp.ucmp.usc.dto;


import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "CreateEvaluationDto", description = "创建评价单参数类")
public class CreateEvaluationDto {
	
	@NotNull(message="业务编码，必须保证唯一性，不能为空")
	@ApiModelProperty(value = "业务编码，必须保证唯一性，必传")
	private String businessNo;
	
	@ApiModelProperty(value = "业务类别")
    private String categoryCode;
	
	@NotNull(message="用户编号,用户唯一标识 URM-UID，不能为空")
	@ApiModelProperty(value = "用户编号,用户唯一标识 URM-UID")
    private String userId;
	
	@ApiModelProperty(value = "车辆VIN码")
    private String vinNo;
	
	@ApiModelProperty(value = "车型编号")
    private String materialCode;
	
	@ApiModelProperty(value = "车型名称")
    private String materialName;
	
	@ApiModelProperty(value = "大区编码")
    private String bigAreaCode;
	
	@ApiModelProperty(value = "大区名称")
    private String bigAreaName;
	
	@ApiModelProperty(value = "服务门店编号")
    private String storeCode;
	
	@ApiModelProperty(value = "服务门店名称")
    private String storeName;
	
	@NotNull(message="服务单结束时间，timestamp，不能为空")
	@ApiModelProperty(value = "服务单结束时间，timestamp")
    private String serviceEndTime;
	
	@ApiModelProperty(value = "服务所在城市编码")
    private String cityCode;
	
	@ApiModelProperty(value = "服务所在城市")
    private String cityName;
	
	@ApiModelProperty(value = "服务人员编号")
    private String servicePersonnelCode;
	
	@ApiModelProperty(value = "服务人员名称")
    private String servicePersonnelName;
	
	@NotNull(message="事务Id，不能为空")
	@ApiModelProperty(value = "事务Id")
    private String traceId;

	public String getBusinessNo() {
		return businessNo;
	}

	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
	}

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String isVinNo() {
		return vinNo;
	}

	public void setVinNo(String vinNo) {
		this.vinNo = vinNo;
	}

	public String getMaterialCode() {
		return materialCode;
	}

	public void setMaterialCode(String materialCode) {
		this.materialCode = materialCode;
	}

	public String getMaterialName() {
		return materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	public String getBigAreaCode() {
		return bigAreaCode;
	}

	public void setBigAreaCode(String bigAreaCode) {
		this.bigAreaCode = bigAreaCode;
	}

	public String getBigAreaName() {
		return bigAreaName;
	}

	public void setBigAreaName(String bigAreaName) {
		this.bigAreaName = bigAreaName;
	}

	public String getStoreCode() {
		return storeCode;
	}

	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getServiceEndTime() {
		return serviceEndTime;
	}

	public void setServiceEndTime(String serviceEndTime) {
		this.serviceEndTime = serviceEndTime;
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

	public String getServicePersonnelCode() {
		return servicePersonnelCode;
	}

	public void setServicePersonnelCode(String servicePersonnelCode) {
		this.servicePersonnelCode = servicePersonnelCode;
	}

	public String getServicePersonnelName() {
		return servicePersonnelName;
	}

	public void setServicePersonnelName(String servicePersonnelName) {
		this.servicePersonnelName = servicePersonnelName;
	}

	public String getTraceId() {
		return traceId;
	}

	public void setTraceId(String traceId) {
		this.traceId = traceId;
	}
	
}
