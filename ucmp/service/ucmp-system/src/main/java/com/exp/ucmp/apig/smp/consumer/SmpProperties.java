package com.exp.ucmp.apig.smp.consumer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@Configuration
@RefreshScope
public class SmpProperties {
	
	@Value("${adapter.apigateway.key}")
	private String key;
	
	@Value("${adapter.apigateway.secret}")
	private String secret;
	
	@Value("${adapter.apigateway.smp.uri}")
	private String uri;
	
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

	@Override
	public String toString() {
		return "OtdProperties [key=" + key + ", secret=" + secret + ", uri=" + uri + "]";
	}
	
}
