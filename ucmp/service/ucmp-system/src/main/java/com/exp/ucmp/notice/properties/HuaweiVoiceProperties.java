package com.exp.ucmp.notice.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@Configuration
@RefreshScope
public class HuaweiVoiceProperties {
	
	@Value("${adapter.huawei.voice.appkey}")
	private String appKey;
	
	@Value("${adapter.huawei.voice.appSecret}")
	private String appSecret;
	
	@Value("${adapter.huawei.voice.uri}")
	private String uri;
	
	@Value("${adapter.huawei.voice.relationNum}")
	private String relationNum;
	
	@Value("${adapter.huawei.voice.cityAreaCode}")
	private String cityAreaCode;
	
	@Value("${adapter.huawei.voice.duration}")
	private String duration;

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

	public String getRelationNum() {
		return relationNum;
	}

	public void setRelationNum(String relationNum) {
		this.relationNum = relationNum;
	}

	public String getCityAreaCode() {
		return cityAreaCode;
	}

	public void setCityAreaCode(String cityAreaCode) {
		this.cityAreaCode = cityAreaCode;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}
	
}
