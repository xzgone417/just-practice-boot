package com.exp.ucmp.apig.eos.consumer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@Configuration
@RefreshScope
public class SlfProperties {
	
	@Value("${adapter.slf.uri}")
	private String uri;

	@Value("${adapter.slf.username}")
	private String username;

	@Value("${adapter.slf.password}")
	private String password;

	@Value("${adapter.slf.clientId}")
	private String clientId;

	@Value("${adapter.slf.clientSecret}")
	private String clientSecret;

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}


}
