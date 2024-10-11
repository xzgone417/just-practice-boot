package com.exp.ucmp.idm.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "IdmAccountStatusDto", description = "idm账号状态")
public class IdmAccountStatusDto {
	
	@ApiModelProperty(value = "应用秘钥(idm 提供)")
	private String clientId;
	
	@ApiModelProperty(value = "状态 (1:启用 0:停用)")
    private String status;
	
	@ApiModelProperty(value = "登录账号")
    private String accountNo;
	
	@ApiModelProperty(value = "默认")
    private String secretId="3F905477A8B9BECC15B018A";

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getSecretId() {
		return secretId;
	}

	public void setSecretId(String secretId) {
		this.secretId = secretId;
	}

}
