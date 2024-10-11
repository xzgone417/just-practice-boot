package com.exp.ucmp.eos.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SmpRoleListDto", description = "smp角色信息")
public class SmpRoleListDto {
	
	@ApiModelProperty(value = "角色code")
	private String roleCode;
	
	@ApiModelProperty(value = "角色名称")
	private String roleName;

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
}
