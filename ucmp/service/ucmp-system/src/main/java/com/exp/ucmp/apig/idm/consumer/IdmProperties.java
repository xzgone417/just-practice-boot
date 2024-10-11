package com.exp.ucmp.apig.idm.consumer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@Configuration
@RefreshScope
public class IdmProperties {
	
	@Value("${adapter.esb.key}")
	private String key;
	
	@Value("${adapter.esb.userId}")
	private String userId;
	
	@Value("${adapter.esb.uri}")
	private String uri;
	
	@Value("${adapter.esb.idm.secretId}")
	private String secretId;
	
	@Value("${adapter.esb.idm.orgId}")
	private String orgId;
	
	@Value("${adapter.esb.idm.userTypeCode}")
	private String userTypeCode;
	
	@Value("${adapter.esb.idm.applet.secretId}")
	private String appletSecretId;
	
	@Value("${adapter.esb.idm.applet.clientId}")
	private String clientId;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getSecretId() {
		return secretId;
	}

	public void setSecretId(String secretId) {
		this.secretId = secretId;
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

	public String getAppletSecretId() {
		return appletSecretId;
	}

	public void setAppletSecretId(String appletSecretId) {
		this.appletSecretId = appletSecretId;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	
}
