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
	
	@Value("${adapter.ucmp.endTime}")
	private String endTime;
	
	@Value("${adapter.ucmp.tspCarVin}")
	private String tspCarVin;
	
	@Value("${adapter.ucmp.smpCarVin}")
	private String smpCarVin;
	
	@Value("${adapter.ucmp.roleId}")
	private String roleId;
	
	@Value("${adapter.ucmp.white}")
	private Long white;
	
	@Value("${adapter.ucmp.filePath}")
	private String filePath;
	
	@Value("${adapter.ucmp.contractPath}")
	private String contractPath;

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}
	
	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getTspCarVin() {
		return tspCarVin;
	}

	public void setTspCarVin(String tspCarVin) {
		this.tspCarVin = tspCarVin;
	}

	public String getSmpCarVin() {
		return smpCarVin;
	}

	public void setSmpCarVin(String smpCarVin) {
		this.smpCarVin = smpCarVin;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public Long getWhite() {
		return white;
	}

	public void setWhite(Long white) {
		this.white = white;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getContractPath() {
		return contractPath;
	}

	public void setContractPath(String contractPath) {
		this.contractPath = contractPath;
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
