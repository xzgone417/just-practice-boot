package com.exp.ucmp.sign.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@Configuration
@RefreshScope
public class UcmpSecretProperties {
	
	@Value("${adapter.ucmp.third.appsecret}")
	private String appsecret;

	public String getAppsecret() {
		return appsecret;
	}

	public void setAppsecret(String appsecret) {
		this.appsecret = appsecret;
	}

	
}
