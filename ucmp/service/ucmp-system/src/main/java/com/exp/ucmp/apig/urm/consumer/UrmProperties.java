package com.exp.ucmp.apig.urm.consumer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@Configuration
@RefreshScope
public class UrmProperties {
	@Value("${adapter.apigateway.key}")
	private String key;
	@Value("${adapter.apigateway.secret}")
	private String secret;
	@Value("${adapter.apigateway.urm.uri}")
	private String uri;
	
	@Value("${adapter.apigateway.urm.platform}")
	private String platform;

	@Value("${adapter.apigateway.urm.token}")
	private String token;
	
	@Value("${adapter.apigateway.urm.code}")
	private String code;
	
	
	public String getKey() {
		return key;
	}

	public String getSecret() {
		return secret;
	}

	public String getUri() {
		return uri;
	}

	public String getPlatform() {
		return platform;
	}

	public String getToken() {
		return token;
	}
	
	public String getCode() {
		return code;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder().append("UrmProperties的参数: {key:").append(key).append(", secret:").append(secret).append(", uri:").append(uri)
				.append(", platform:").append(platform).append(", token:").append(token).append("}");
		return sb.toString();
	}
}
