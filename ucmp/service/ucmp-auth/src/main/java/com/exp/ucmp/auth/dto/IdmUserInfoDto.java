package com.exp.ucmp.auth.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import io.swagger.annotations.ApiModelProperty;

public class IdmUserInfoDto {
	
	@JsonSerialize(using = ToStringSerializer.class)
	@ApiModelProperty(value = "账号，需要AES解密")
	private String uid;
	
	@JsonSerialize(using = ToStringSerializer.class)
	@ApiModelProperty(value = "10：内部用户；其他都是外部用户")
	private String usertypecode;
	
	@JsonSerialize(using = ToStringSerializer.class)
	@ApiModelProperty(value = "用户姓名")
	private String userName;
	
	@JsonSerialize(using = ToStringSerializer.class)
	@ApiModelProperty(value = "token")
	private String access_token;
	
	@JsonSerialize(using = ToStringSerializer.class)
	@ApiModelProperty(value = "token有效期")
	private String expire;
	
	@JsonSerialize(using = ToStringSerializer.class)
	@ApiModelProperty(value = "用户邮箱")
	private String accountEmail;
	
	@JsonSerialize(using = ToStringSerializer.class)
	@ApiModelProperty(value = "应用编码")
	private String appCode;
	
	@JsonSerialize(using = ToStringSerializer.class)
	@ApiModelProperty(value = "md5加密的账号，UCMP免密登录使用")
	private String uidMd5;
	
	@JsonSerialize(using = ToStringSerializer.class)
	@ApiModelProperty(value = "门店id")
	private String orgId;
	
	@JsonSerialize(using = ToStringSerializer.class)
	@ApiModelProperty(value = "门店code")
	private String orgCode;
	
	@JsonSerialize(using = ToStringSerializer.class)
	@ApiModelProperty(value = "门店名称")
	private String orgName;
	
	@JsonSerialize(using = ToStringSerializer.class)
	@ApiModelProperty(value = "上级")
	private String superior;
	
	@JsonSerialize(using = ToStringSerializer.class)
	@ApiModelProperty(value = "角色")
	private String role;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUsertypecode() {
		return usertypecode;
	}

	public void setUsertypecode(String usertypecode) {
		this.usertypecode = usertypecode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public String getExpire() {
		return expire;
	}

	public void setExpire(String expire) {
		this.expire = expire;
	}

	public String getAccountEmail() {
		return accountEmail;
	}

	public void setAccountEmail(String accountEmail) {
		this.accountEmail = accountEmail;
	}

	public String getAppCode() {
		return appCode;
	}

	public void setAppCode(String appCode) {
		this.appCode = appCode;
	}

	public String getUidMd5() {
		return uidMd5;
	}

	public void setUidMd5(String uidMd5) {
		this.uidMd5 = uidMd5;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getSuperior() {
		return superior;
	}

	public void setSuperior(String superior) {
		this.superior = superior;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
}
