package com.exp.ucmp.eos.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "AccountInfoDto", description = "顾问信息")
public class AccountInfoDto {
	
	@ApiModelProperty(value = "用户登录名")
	private String idmAccountName;
	
	@ApiModelProperty(value = "用户id")
	private Integer userId;
	
	@ApiModelProperty(value = "用户姓名")
	private String userName;
	
	@ApiModelProperty(value = "用户手机号")
	private String phoneNumber;
	
	@ApiModelProperty(value = "加密用户手机号")
	private String enPhoneNumber;
	
	@ApiModelProperty(value = "角色code")
	private String roleCode;
	
	@ApiModelProperty(value = "角色名称")
	private String roleName;
	
	@ApiModelProperty(value = "用户所属门店smp-code")
	private String departmentId;
	
	@ApiModelProperty(value = "上级用户登录名")
	private String superiorIdmAccountName;
	
	@ApiModelProperty(value = "上级用户id")
	private Integer superiorUserId;
	
	@ApiModelProperty(value = "上级用户名")
	private String superiorName;
	
	@ApiModelProperty(value = "上级用户手机号")
	private String superiorPhoneNumber;
	
	@ApiModelProperty(value = "加密上级用户手机号")
	private String enSuperiorPhoneNumber;
	
	@ApiModelProperty(value = "上级用户角色code")
	private String superiorRoleCode;
	
	@ApiModelProperty(value = "上级用户角色名称")
	private String superiorRoleName;
	
	@ApiModelProperty(value = "用户userId的MD5加密")
	private String userIdMd5;
	
	@ApiModelProperty(value = "组织id")
    private Integer organizationId;
	
	@ApiModelProperty(value = "上级组织id")
    private Integer superiorOrganizationId;
	
	@ApiModelProperty(value = "创建预约单的顾问信息id")
    private long createAccountInfoId;

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

	public String getEnPhoneNumber() {
		return enPhoneNumber;
	}

	public void setEnPhoneNumber(String enPhoneNumber) {
		this.enPhoneNumber = enPhoneNumber;
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

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getSuperiorIdmAccountName() {
		return superiorIdmAccountName;
	}

	public void setSuperiorIdmAccountName(String superiorIdmAccountName) {
		this.superiorIdmAccountName = superiorIdmAccountName;
	}

	public Integer getSuperiorUserId() {
		return superiorUserId;
	}

	public void setSuperiorUserId(Integer superiorUserId) {
		this.superiorUserId = superiorUserId;
	}

	public String getSuperiorName() {
		return superiorName;
	}

	public void setSuperiorName(String superiorName) {
		this.superiorName = superiorName;
	}

	public String getSuperiorPhoneNumber() {
		return superiorPhoneNumber;
	}

	public void setSuperiorPhoneNumber(String superiorPhoneNumber) {
		this.superiorPhoneNumber = superiorPhoneNumber;
	}

	public String getEnSuperiorPhoneNumber() {
		return enSuperiorPhoneNumber;
	}

	public void setEnSuperiorPhoneNumber(String enSuperiorPhoneNumber) {
		this.enSuperiorPhoneNumber = enSuperiorPhoneNumber;
	}

	public String getSuperiorRoleCode() {
		return superiorRoleCode;
	}

	public void setSuperiorRoleCode(String superiorRoleCode) {
		this.superiorRoleCode = superiorRoleCode;
	}

	public String getSuperiorRoleName() {
		return superiorRoleName;
	}

	public void setSuperiorRoleName(String superiorRoleName) {
		this.superiorRoleName = superiorRoleName;
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

	public Integer getSuperiorOrganizationId() {
		return superiorOrganizationId;
	}

	public void setSuperiorOrganizationId(Integer superiorOrganizationId) {
		this.superiorOrganizationId = superiorOrganizationId;
	}

	public long getCreateAccountInfoId() {
		return createAccountInfoId;
	}

	public void setCreateAccountInfoId(long createAccountInfoId) {
		this.createAccountInfoId = createAccountInfoId;
	}
	
}
