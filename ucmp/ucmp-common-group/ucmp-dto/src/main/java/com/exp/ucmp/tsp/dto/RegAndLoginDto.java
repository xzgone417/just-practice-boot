package com.exp.ucmp.tsp.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "RegAndLoginDto", description = "手机号直接注册登入参数")
public class RegAndLoginDto {
	
	@ApiModelProperty(value = "登录手机号，必填")
	private String mobilePhone;
	
	@ApiModelProperty(value = "活动编码，不必填")
    private String campaignCode;
	
	@ApiModelProperty(value = "活动名称，不必填")
    private String campaignName;
	
	@ApiModelProperty(value = "内部渠道编码一级，配置")
    private String level1Code;
	
	@ApiModelProperty(value = "内部渠道编码二级，配置")
    private String level2Code;

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getCampaignCode() {
		return campaignCode;
	}

	public void setCampaignCode(String campaignCode) {
		this.campaignCode = campaignCode;
	}

	public String getCampaignName() {
		return campaignName;
	}

	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}

	public String getLevel1Code() {
		return level1Code;
	}

	public void setLevel1Code(String level1Code) {
		this.level1Code = level1Code;
	}

	public String getLevel2Code() {
		return level2Code;
	}

	public void setLevel2Code(String level2Code) {
		this.level2Code = level2Code;
	}

}
