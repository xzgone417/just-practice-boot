package com.exp.ucmp.apig.tsp.consumer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@Configuration
@RefreshScope
public class TspProperties {
	
	@Value("${adapter.apigateway.key}")
	private String key;
	
	@Value("${adapter.apigateway.secret}")
	private String secret;
	
	@Value("${adapter.apigateway.tsp.uri}")
	private String uri;
	
	@Value("${adapter.apigateway.tsp.accessKeyId}")
	private String accessKeyId;
	
	@Value("${adapter.apigateway.tsp.accessSecret}")
	private String accessSecret;
	
	@Value("${adapter.apigateway.tsp.businessCode}")
	private String businessCode;
	
	@Value("${adapter.apigateway.tsp.level1Code}")
	private String level1Code;
	
	@Value("${adapter.apigateway.tsp.level2Code}")
	private String level2Code;
	
	public String getBusinessCode() {
		return businessCode;
	}

	public void setBusinessCode(String businessCode) {
		this.businessCode = businessCode;
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

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getAccessKeyId() {
		return accessKeyId;
	}

	public void setAccessKeyId(String accessKeyId) {
		this.accessKeyId = accessKeyId;
	}

	public String getAccessSecret() {
		return accessSecret;
	}

	public void setAccessSecret(String accessSecret) {
		this.accessSecret = accessSecret;
	}

	public String getLevel1Code() {
		return level1Code;
	}

	public void setLevel1Code(String level1Code) {
		this.level1Code = level1Code;
	}

	public String getLevel2Code() {
		return level2Code;
	}

	public void setLevel2Code(String level2Code) {
		this.level2Code = level2Code;
	}
	
	
}
