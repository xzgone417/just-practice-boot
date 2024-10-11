package com.exp.ucmp.idm.consumer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@Configuration
@RefreshScope
public class IdmProperties {
	
	@Value("${adapter.idm.clientid}")
	private String id;
	
	@Value("${adapter.idm.clientSecret}")
	private String secret;
	
	@Value("${adapter.callback.uri}")
	private String uri;
	
	@Value("${adapter.callback.targetUrl}")
	private String targetUrl;
	
	@Value("${adapter.callback.callbackUrl}")
	private String callbackUrl;
	
	@Value("${adapter.idm.uri}")
	private String idmUri;
	
	@Value("${adapter.idm.applet.secretId}")
	private String appletSecretId;
	
	@Value("${adapter.idm.applet.clientId}")
	private String appletClientId;
	
	@Value("${adapter.idm.applet.appkey}")
	private String appkey;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getTargetUrl() {
		return targetUrl;
	}

	public void setTargetUrl(String targetUrl) {
		this.targetUrl = targetUrl;
	}

	public String getCallbackUrl() {
		return callbackUrl;
	}

	public void setCallbackUrl(String callbackUrl) {
		this.callbackUrl = callbackUrl;
	}

	public String getIdmUri() {
		return idmUri;
	}

	public void setIdmUri(String idmUri) {
		this.idmUri = idmUri;
	}

	public String getAppletSecretId() {
		return appletSecretId;
	}

	public void setAppletSecretId(String appletSecretId) {
		this.appletSecretId = appletSecretId;
	}

	public String getAppletClientId() {
		return appletClientId;
	}

	public void setAppletClientId(String appletClientId) {
		this.appletClientId = appletClientId;
	}

	public String getAppkey() {
		return appkey;
	}

	public void setAppkey(String appkey) {
		this.appkey = appkey;
	}


}
