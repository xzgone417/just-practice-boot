package com.exp.ucmp.apig.urc.consumer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@Configuration
@RefreshScope
public class UrcProperties {
	
	@Value("${adapter.apigateway.key}")
	private String key;
	
	@Value("${adapter.apigateway.secret}")
	private String secret;
	
	@Value("${adapter.apigateway.urc.uri}")
	private String uri;
	
	@Value("${adapter.apigateway.urc.channel}")
	private String channle;
	
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

	public String getChannle() {
		return channle;
	}

	public void setChannle(String channle) {
		this.channle = channle;
	}

	@Override
	public String toString() {
		return "UrcProperties [key=" + key + ", secret=" + secret + ", uri=" + uri + ", channle=" + channle + "]";
	}

}
