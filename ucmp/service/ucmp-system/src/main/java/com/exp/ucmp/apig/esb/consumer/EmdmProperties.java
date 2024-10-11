package com.exp.ucmp.apig.esb.consumer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@Configuration
@RefreshScope
public class EmdmProperties {
	
	@Value("${adapter.esb.key}")
	private String key;
	
	@Value("${adapter.esb.userId}")
	private String userId;
	
	@Value("${adapter.esb.uri}")
	private String uri;

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
}
