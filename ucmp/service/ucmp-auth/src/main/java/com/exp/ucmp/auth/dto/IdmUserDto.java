package com.exp.ucmp.auth.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "IdmUserInfoDto", description = "idm token获取到的用户信息")
public class IdmUserDto {
	
	@ApiModelProperty(value = "状态")
	private String status;
	
	@ApiModelProperty(value = "idm 账号")
	private String id;
	
	@ApiModelProperty(value = "信息")
	private String msg;
	
	@ApiModelProperty(value = "idm 账号MD5加密")
	private String md5Id;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getMd5Id() {
		return md5Id;
	}

	public void setMd5Id(String md5Id) {
		this.md5Id = md5Id;
	}
}
