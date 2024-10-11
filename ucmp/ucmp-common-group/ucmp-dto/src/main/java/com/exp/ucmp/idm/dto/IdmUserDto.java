package com.exp.ucmp.idm.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "IdmUserDto", description = "idm用户信息")
public class IdmUserDto {
	
	@ApiModelProperty(value = "用户登录账号")
	private String uid;
	
	@ApiModelProperty(value = "用户个人邮箱")
    private String userEmail;
	
	@ApiModelProperty(value = "用户名称")
    private String userName;
	
	@ApiModelProperty(value = "默认")
    private String secretId;
	
	@ApiModelProperty(value = "1:男 0:女")
    private String sex;
	
	@ApiModelProperty(value = "组织 id(idm 提供)")
    private String orgId;
	
	@ApiModelProperty(value = "用户类型编码(idm 提供)")
    private String userTypeCode;
	
	@ApiModelProperty(value = "用户企业邮箱")
    private String email;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSecretId() {
		return secretId;
	}

	public void setSecretId(String secretId) {
		this.secretId = secretId;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getUserTypeCode() {
		return userTypeCode;
	}

	public void setUserTypeCode(String userTypeCode) {
		this.userTypeCode = userTypeCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
