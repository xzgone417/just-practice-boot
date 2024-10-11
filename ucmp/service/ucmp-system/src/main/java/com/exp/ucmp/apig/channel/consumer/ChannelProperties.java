package com.exp.ucmp.apig.channel.consumer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@Configuration
@RefreshScope
public class ChannelProperties {
	
	@Value("${adapter.apigateway.channel.uri}")
	private String uri;
	
	@Value("${adapter.apigateway.channel.key}")
	private String key;
	
	@Value("${adapter.apigateway.channel.secret}")
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
