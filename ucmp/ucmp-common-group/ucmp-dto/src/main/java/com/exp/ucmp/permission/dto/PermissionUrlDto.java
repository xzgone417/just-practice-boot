/**
 * 
 * 初米网络
 * Copyright (C) 2018 Egridcloud, Inc, All rights reserved.
 */
package com.exp.ucmp.permission.dto;

import com.egrid.core.base.model.BaseModel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author Yiyongfei
 * @date 2018年9月29日
 */
@ApiModel(value = "PermissionUrlDto", description = "权限URL，用于批量生成")
public class PermissionUrlDto extends BaseModel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * 权限内容
     */
    @ApiModelProperty(value = "权限名称")
    private String name;
    
    /**
     * 权限内容
     */
    @ApiModelProperty(value = "权限内容")
    private String permission;
    /**
     * Url内容
     */
    @ApiModelProperty(value = "URL内容")
    private String url;
    /**
     * 访问类型
     */
    @ApiModelProperty(value = "访问类型(01匿名访问,02基于用户,03登录验证,04鉴权)")
    private String accessType;
    
    public String getPermission() {
        return permission;
    }
    public void setPermission(String permission) {
        this.permission = permission;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAccessType() {
        return accessType;
    }
    public void setAccessType(String accessType) {
        this.accessType = accessType;
    }
    
}
