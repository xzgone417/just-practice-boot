/**
 * ResourceInfoEntity.java
 * Created at 2018年09月29日
 * Created by TODO
 * Copyright (C) TODO EgridCloud, Inc, All rights reserved.
 */
package com.exp.ucmp.role.dto;

import com.egrid.core.base.model.BaseModel;
import com.exp.ucmp.PageDto;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author zhouchengwei
 * @date 2022年8月30日
 */
@ApiModel(value = "RolePermissionRelaDto", description = "角色权限信息")
public class RolePermissionRelaDto extends BaseModel {

    private static final long serialVersionUID = 1L;
    /**
     * 资源标识
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "角色权限标识")
    private Long rolePermissionId;


    /**
     * 角色标识
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "角色标识")

    private Long roleId;



    /**
     * 权限标识，按照资源+操作的通配符方式定义角色可操作的资源时，该字段为空
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "权限标识")
    private Long permissionId;

    /**
     * 通配符权限，由资源+操作组成，资源和操作可能都存在通配符
     */
    @ApiModelProperty(value = "通配符权限")
    private String permissionWildcards;

    /**
     * 角色权限信息集合
     */
    @ApiModelProperty(value = "角色权限信息集合")
    private List<RolePermissionRelaDto> rolePermissionRelaList;




    public RolePermissionRelaDto() {
    }

    public Long getRolePermissionId() {
        return rolePermissionId;
    }

    public void setRolePermissionId(Long rolePermissionId) {
        this.rolePermissionId = rolePermissionId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermissionWildcards() {
        return permissionWildcards;
    }

    public void setPermissionWildcards(String permissionWildcards) {
        this.permissionWildcards = permissionWildcards;
    }

    public List<RolePermissionRelaDto> getRolePermissionRelaList() {
        return rolePermissionRelaList;
    }

    public void setRolePermissionRelaList(List<RolePermissionRelaDto> rolePermissionRelaList) {
        this.rolePermissionRelaList = rolePermissionRelaList;
    }
}
