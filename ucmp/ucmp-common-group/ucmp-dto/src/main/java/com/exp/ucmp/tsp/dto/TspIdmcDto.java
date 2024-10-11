package com.exp.ucmp.tsp.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "TspIdmcDto", description = "注册信息实体类")
public class TspIdmcDto {
	
	@ApiModelProperty(value = "车型年 Code")
	private Integer isRegister;
	
	@ApiModelProperty(value = "loginId")
	private String loginId;
	
	@ApiModelProperty(value = "signKey")
	private String signKey;
	
	@ApiModelProperty(value = "superId")
	private String superId;
	
	@ApiModelProperty(value = "token")
	private String token;

	@ApiModelProperty(value = "tokenExpire")
	private String tokenExpire;
	
	@ApiModelProperty(value = "UID")
	private String urmId;

	public Integer getIsRegister() {
		return isRegister;
	}

	public void setIsRegister(Integer isRegister) {
		this.isRegister = isRegister;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getSignKey() {
		return signKey;
	}

	public void setSignKey(String signKey) {
		this.signKey = signKey;
	}

	public String getSuperId() {
		return superId;
	}

	public void setSuperId(String superId) {
		this.superId = superId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getTokenExpire() {
		return tokenExpire;
	}

	public void setTokenExpire(String tokenExpire) {
		this.tokenExpire = tokenExpire;
	}

	public String getUrmId() {
		return urmId;
	}

	public void setUrmId(String urmId) {
		this.urmId = urmId;
	}
	
}
