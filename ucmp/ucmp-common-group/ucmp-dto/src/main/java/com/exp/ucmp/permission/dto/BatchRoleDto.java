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
@ApiModel(value = "BatchRoleDto", description = "角色，用于批量生成")
public class BatchRoleDto extends BaseModel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * 权限内容
     */
    @ApiModelProperty(value = "角色内容")
    private List<RoleDto> listRole;

    public List<RoleDto> getListRole() {
        return listRole;
    }
    public void setListRole(List<RoleDto> listRole) {
        this.listRole = listRole;
    }
    
    
}
