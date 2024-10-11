package com.exp.ucmp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

import com.alibaba.cloud.commons.lang.StringUtils;

@Configuration
@RefreshScope
public class UcmpAesConfig {
	
	@Value("${adapter.ucmp.secret}")
	private String secret;
	
	@Value("${adapter.ucmp.white}")
	private Long white;

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}
	
	public Long getWhite() {
		return white;
	}

	public void setWhite(Long white) {
		this.white = white;
	}

	/**
     * 加*操作
     */

    public static String dataMask(String data, int start, int end, String starCount) {
        String res = "";
        if (!StringUtils.isEmpty(data)) {
            StringBuilder stringBuilder = new StringBuilder(data);
            res = stringBuilder.replace(start, end, starCount).toString();
        }
        return res;
    }
}
