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
@ApiModel(value = "RoleDto", description = "角色，用于批量生成")
public class RoleDto extends BaseModel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * 角色类型
     */
    @ApiModelProperty(value = "角色类型")
    private String roleType;
    
    /**
     * 角色名称
     */
    @ApiModelProperty(value = "角色名称")
    private String roleName;

    /**
     * 角色描述
     */
    @ApiModelProperty(value = "角色描述")
    private String roleDesc;
    
    /**
     * 权限内容
     */
    @ApiModelProperty(value = "权限内容")
    private List<String> permissions;
    
    /**
     * 权限内容
     */
    @ApiModelProperty(value = "权限是否全量覆盖")
    private Boolean isCover = true;

	public Boolean getIsCover() {
		return isCover;
	}

	public void setIsCover(Boolean isCover) {
		this.isCover = isCover;
	}

	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	public List<String> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<String> permissions) {
		this.permissions = permissions;
	}
    
}
