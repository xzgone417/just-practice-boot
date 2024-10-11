/**
 * 
 * 初米网络
 * Copyright (C) 2022 Egridcloud, Inc, All rights reserved.
 */
package com.exp.ucmp.model;

import java.util.Map;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import com.egrid.core.base.model.BaseModel;


/**
 * @author Yiyongfei
 * @date 2022年07月12日
 */
@ApiModel(value = "LoginDto", description = "登录请求信息")
public class LoginDto extends BaseModel {
	private static final long serialVersionUID = 1L;

	/**
	 * <p>
	 * Field username: 用户名称
	 * </p>
	 */
	@ApiModelProperty(value = "用户名称，登录名")
	private String username;

	/**
	 * <p>
	 * Field password: 用户密码
	 * </p>
	 */
	@ApiModelProperty(value = "密码，验证码")
	private String password;

	/**
	 * <p>
	 * Field factoryParameters: 用户信息参数
	 * </p>
	 */
	@ApiModelProperty(value = "用户信息参数")
	private Map<String, String> userParameters;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Map<String, String> getUserParameters() {
		return userParameters;
	}

	public void setUserParameters(Map<String, String> userParameters) {
		this.userParameters = userParameters;
	}
}

