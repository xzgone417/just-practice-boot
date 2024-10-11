package com.exp.ucmp.pay.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@Configuration
@RefreshScope
public class PayConfig {
	
	@Value("${adapter.ucmp.pay.apigKey}")
	private String key;
	
	@Value("${adapter.ucmp.pay.apigSecret}")
	private String secret;
	
	@Value("${adapter.ucmp.pay.url}")
	private String url;
	
	@Value("${adapter.ucmp.pay.subject}")
	private String subject;
	
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
}
