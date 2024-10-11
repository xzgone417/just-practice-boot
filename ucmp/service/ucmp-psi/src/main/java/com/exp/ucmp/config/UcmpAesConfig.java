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
	
	@Value("${adapter.ucmp.roleCode}")
	private String roleCode;
	
	@Value("${adapter.ucmp.deliveryRole}")
	private String deliveryRole;
	
	@Value("${adapter.ucmp.transfersAmount}")
	private Double transfersAmount;

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}
	
	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getDeliveryRole() {
		return deliveryRole;
	}

	public void setDeliveryRole(String deliveryRole) {
		this.deliveryRole = deliveryRole;
	}

	public Double getTransfersAmount() {
		return transfersAmount;
	}

	public void setTransfersAmount(Double transfersAmount) {
		this.transfersAmount = transfersAmount;
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
