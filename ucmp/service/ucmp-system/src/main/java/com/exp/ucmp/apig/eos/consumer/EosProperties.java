package com.exp.ucmp.apig.eos.consumer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@Configuration
@RefreshScope
public class EosProperties {
	
	@Value("${adapter.apigateway.eos.uri}")
	private String uri;
	
	@Value("${adapter.apigateway.key}")
	private String key;
	
	@Value("${adapter.apigateway.secret}")
	private String secret;
	
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
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
	
}
