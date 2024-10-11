package com.exp.ucmp.idm.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "IdmUserStatusDto", description = "idm用户状态")
public class IdmUserStatusDto {
	
	@ApiModelProperty(value = "用户登录账号")
	private String uid;
	
	@ApiModelProperty(value = "状态 (1:启用 0:停用)")
    private String status;
	
	@ApiModelProperty(value = "1 发送 0 不发送 1 代表需要将用户的初始化密码 发送到对应的邮箱（用户创建接 口中的用户企业邮箱）")
    private String isSendEmail;
	
	@ApiModelProperty(value = "默认")
    private String secretId;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getIsSendEmail() {
		return isSendEmail;
	}

	public void setIsSendEmail(String isSendEmail) {
		this.isSendEmail = isSendEmail;
	}

	public String getSecretId() {
		return secretId;
	}

	public void setSecretId(String secretId) {
		this.secretId = secretId;
	}
}
