package com.exp.ucmp.urm.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "UserDto", description = "客户信息")
public class UserDto {
	
	@ApiModelProperty(value = "客户姓名")
	private String name;
	
	@ApiModelProperty(value = "idmId")
	private String idmId;
	
	@ApiModelProperty(value = "uid")
	private String superId;
	
	@ApiModelProperty(value = "客户手机号")
	private String mobile;
	
	@ApiModelProperty(value = "加密客户手机号")
	private String enMobile;
	
	@ApiModelProperty(value = "idm_Id")
	private String idm_Id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdmId() {
		return idmId;
	}

	public void setIdmId(String idmId) {
		this.idmId = idmId;
	}

	public String getSuperId() {
		return superId;
	}

	public void setSuperId(String superId) {
		this.superId = superId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEnMobile() {
		return enMobile;
	}

	public void setEnMobile(String enMobile) {
		this.enMobile = enMobile;
	}

	public String getIdm_Id() {
		return idm_Id;
	}

	public void setIdm_Id(String idm_Id) {
		this.idm_Id = idm_Id;
	}
	
}
