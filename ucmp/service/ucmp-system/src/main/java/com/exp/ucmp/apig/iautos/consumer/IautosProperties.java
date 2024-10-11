package com.exp.ucmp.apig.iautos.consumer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@Configuration
@RefreshScope
public class IautosProperties {
	
	@Value("${adapter.iautos.car.key}")
	private String key;
	
	@Value("${adapter.iautos.car.secret}")
	private String secret;
	
	@Value("${adapter.iautos.car.uri}")
	private String uri;
	
	@Value("${adapter.iautos.assess.priavteSecret}")
	private String privateSecret;
	
	@Value("${adapter.iautos.assess.pubilcSecret}")
	private String pubilcSecret;
	
	@Value("${adapter.iautos.assess.uri}")
	private String assessUri;
	
	@Value("${adapter.iautos.car.hiphiBrandId}")
	private String hiphiBrandId;
	
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
	public String getPrivateSecret() {
		return privateSecret;
	}
	public void setPriavteSecret(String privateSecret) {
		this.privateSecret = privateSecret;
	}
	public String getPubilcSecret() {
		return pubilcSecret;
	}
	public void setPubilcSecret(String pubilcSecret) {
		this.pubilcSecret = pubilcSecret;
	}
	public String getAssessUri() {
		return assessUri;
	}
	public void setAssessUri(String assessUri) {
		this.assessUri = assessUri;
	}
	
	public String getHiphiBrandId() {
		return hiphiBrandId;
	}
	public void setHiphiBrandId(String hiphiBrandId) {
		this.hiphiBrandId = hiphiBrandId;
	}
	public void setPrivateSecret(String privateSecret) {
		this.privateSecret = privateSecret;
	}
	@Override
	public String toString() {
		return "IautosProperties [key=" + key + ", secret=" + secret + ", uri=" + uri + ", privateSecret="
				+ privateSecret + ", pubilcSecret=" + pubilcSecret + ", assessUri=" + assessUri + ", hiphiBrandId="
				+ hiphiBrandId + "]";
	}
	
	
}
