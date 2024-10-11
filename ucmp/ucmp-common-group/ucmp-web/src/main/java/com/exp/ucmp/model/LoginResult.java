/**
 * 
 * 初米网络
 * Copyright (C) 2022 Egridcloud, Inc, All rights reserved.
 */
package com.exp.ucmp.model;

import com.egrid.core.base.model.BaseModel;
import com.egrid.core.shiro.model.User;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author Yiyongfei
 * @date 2022年07月12日
 */
@ApiModel(value = "LoginResult", description = "登录结果")
public class LoginResult extends BaseModel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    
    @ApiModelProperty(value = "Token")
    private String token;
    @ApiModelProperty(value = "用户信息")
    private User user;
    
    @ApiModelProperty(value = "是否开放官二销售 00 没有限制 01 开放 02 不开放")
    private String isSales;
    
    public LoginResult() {
	}
    
    public LoginResult(String token, User user,String isSales) {
        this.token = token;
        this.user = user;
        this.isSales = isSales;
    }
    
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

	public String getIsSales() {
		return isSales;
	}

	public void setIsSales(String isSales) {
		this.isSales = isSales;
	}
    
}

