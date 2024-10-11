package com.exp.ucmp.apig.usc.consumer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@Configuration
@RefreshScope
public class UscProperties {
	
	@Value("${adapter.apigateway.key}")
	private String key;
	
	@Value("${adapter.apigateway.secret}")
	private String secret;
	
	@Value("${adapter.apigateway.usc.uri}")
	private String uri;
	
	@Value("${adapter.apigateway.usc.categoryCode}")
	private String categoryCode;
	
	@Value("${adapter.apigateway.usc.channleCode}")
	private String channleCode;
	
	public String getKey() {
		return key;
	}

	public String getSecret() {
		return secret;
	}

	public String getUri() {
		return uri;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getChannleCode() {
		return channleCode;
	}

	public void setChannleCode(String channleCode) {
		this.channleCode = channleCode;
	}

	@Override
	public String toString() {
		return "UrcProperties [key=" + key + ", secret=" + secret + ", uri=" + uri + ", categoryCode=" + categoryCode
				+ ", channleCode=" + channleCode + "]";
	}
}
