/**
 * 
 * 初米网络
 * Copyright (C) 2018 Egridcloud, Inc, All rights reserved.
 */
package com.exp.ucmp.permission.dto;

import java.util.List;

import com.egrid.core.base.model.BaseModel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author Yiyongfei
 * @date 2018年9月29日
 */
@ApiModel(value = "BatchPermissionUrlDto", description = "权限URL，用于批量生成")
public class BatchPermissionUrlDto extends BaseModel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * 权限内容
     */
    @ApiModelProperty(value = "权限内容")
    private List<PermissionUrlDto> listPermissionUrl;

    public List<PermissionUrlDto> getListPermissionUrl() {
        return listPermissionUrl;
    }
    public void setListPermissionUrl(List<PermissionUrlDto> listPermissionUrl) {
        this.listPermissionUrl = listPermissionUrl;
    }
    
    
}
