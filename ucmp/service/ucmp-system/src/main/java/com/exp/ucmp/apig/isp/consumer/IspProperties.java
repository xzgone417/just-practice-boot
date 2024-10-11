package com.exp.ucmp.apig.isp.consumer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@Configuration
@RefreshScope
public class IspProperties {
	
	@Value("${adapter.apigateway.isp.key}")
	private String key;
	
	@Value("${adapter.apigateway.isp.secret}")
	private String secret;
	
	@Value("${adapter.apigateway.isp.uri}")
	private String uri;
	
	@Value("${adapter.apigateway.isp.warrantyCode}")
	private String warrantyCode;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
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

	public String getWarrantyCode() {
		return warrantyCode;
	}

	public void setWarrantyCode(String warrantyCode) {
		this.warrantyCode = warrantyCode;
	}
	
}
