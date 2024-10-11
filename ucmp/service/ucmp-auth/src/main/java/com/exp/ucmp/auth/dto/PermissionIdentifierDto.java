package com.exp.ucmp.auth.dto;

import com.egrid.core.base.model.BaseModel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "PermissionIdentifierDto", description = "权限信息")
public class PermissionIdentifierDto extends BaseModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3919738576691942911L;

	@ApiModelProperty(value = "权限ID")
	private String permissionId;
	@ApiModelProperty(value = "权限名称")
	private String permissionName;
	@ApiModelProperty(value = "权限内容")
	private String permissionContent;
	@ApiModelProperty(value = "权限资源路径")
	private String identifierPath;
	@ApiModelProperty(value = "访问类型")
	private String accessType;
	
	public String getPermissionId() {
		return permissionId;
	}
	public void setPermissionId(String permissionId) {
		this.permissionId = permissionId;
	}
	public String getPermissionName() {
		return permissionName;
	}
	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}
	public String getPermissionContent() {
		return permissionContent;
	}
	public void setPermissionContent(String permissionContent) {
		this.permissionContent = permissionContent;
	}
	public String getIdentifierPath() {
		return identifierPath;
	}
	public void setIdentifierPath(String identifierPath) {
		this.identifierPath = identifierPath;
	}
	public String getAccessType() {
		return accessType;
	}
	public void setAccessType(String accessType) {
		this.accessType = accessType;
	}
}
