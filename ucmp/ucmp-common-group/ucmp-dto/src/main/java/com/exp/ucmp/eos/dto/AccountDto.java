package com.exp.ucmp.eos.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "AccountDto", description = "顾问信息")
public class AccountDto {
	
	@ApiModelProperty(value = "用户登录名")
	private String idmAccountName;
	
	@ApiModelProperty(value = "用户id")
	private Integer userId;
	
	@ApiModelProperty(value = "用户姓名")
	private String userName;
	
	@ApiModelProperty(value = "用户手机号")
	private String phoneNumber;
	
	@ApiModelProperty(value = "角色code")
	private String roleCode;
	
	@ApiModelProperty(value = "角色名称")
	private String roleName;

	public String getIdmAccountName() {
		return idmAccountName;
	}

	public void setIdmAccountName(String idmAccountName) {
		this.idmAccountName = idmAccountName;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

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
