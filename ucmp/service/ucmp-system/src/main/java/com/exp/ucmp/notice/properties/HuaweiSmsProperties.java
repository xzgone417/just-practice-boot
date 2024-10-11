package com.exp.ucmp.notice.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@Configuration
@RefreshScope
public class HuaweiSmsProperties {
	
	@Value("${adapter.huawei.sms.appkey}")
	private String appKey;
	
	@Value("${adapter.huawei.sms.appSecret}")
	private String appSecret;
	
	@Value("${adapter.huawei.sms.uri}")
	private String uri;
	
	@Value("${adapter.huawei.sms.signature}")
	private String signature;
	
	@Value("${adapter.huawei.sms.from}")
	private String from;

	public String getAppKey() {
		return appKey;
	}

	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}

	public String getAppSecret() {
		return appSecret;
	}

	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}
	
}
