package com.exp.ucmp.eos.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "UserAndSuperiorInfoDto", description = "顾问信息")
public class SmpUserInfoDto {

	@ApiModelProperty(value = "用户登录名")
	private String idmAccountName;

	@ApiModelProperty(value = "用户id")
	private String userId;

	@ApiModelProperty(value = "用户姓名")
	private String userName;

	@ApiModelProperty(value = "用户手机号")
	private String phoneNumber;

	@ApiModelProperty(value = "加密用户手机号")
	private String enPhoneNumber;

	@ApiModelProperty(value = "角色集合")
	private List<SmpRoleListDto> roleList;

	@ApiModelProperty(value = "用户userId的MD5加密")
	private String userIdMd5;

	@ApiModelProperty(value = "组织id")
	private Integer organizationId;
	
	@ApiModelProperty(value = "用户所属门店smp-code")
	private String departmentId;

	public String getIdmAccountName() {
		return idmAccountName;
	}

	public void setIdmAccountName(String idmAccountName) {
		this.idmAccountName = idmAccountName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
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

	public String getEnPhoneNumber() {
		return enPhoneNumber;
	}

	public void setEnPhoneNumber(String enPhoneNumber) {
		this.enPhoneNumber = enPhoneNumber;
	}

	public List<SmpRoleListDto> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<SmpRoleListDto> roleList) {
		this.roleList = roleList;
	}

	public String getUserIdMd5() {
		return userIdMd5;
	}

	public void setUserIdMd5(String userIdMd5) {
		this.userIdMd5 = userIdMd5;
	}

	public Integer getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

}
