package com.exp.ucmp.huawei.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SmsParamsDto", description = "华为云短信参数信息")
public class SmsParamsDto {
	
	@ApiModelProperty(value = "短信发送方的号码,后端自动填入")
	private String from;
	
	@ApiModelProperty(value = "短信接收方的号码")
	private String to;
	
	@ApiModelProperty(value = "短信模板ID")
	private String templateId;
	
	@ApiModelProperty(value = "短信模板的变量值列表，用于依次填充“templateId”参数指定的模板内容中的变量")
	private String[] templateParas;
	
	@ApiModelProperty(value = "用户的回调地址，用于接收短信状态报告,后端自动填入")
	private String statusCallback;
	
	@ApiModelProperty(value = "扩展参数")
	private String extend;
	
	@ApiModelProperty(value = "签名名称，必须是已审核通过的，与模板类型一致的签名名称,后端自动填入")
	private String signature;

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	public String[] getTemplateParas() {
		return templateParas;
	}

	public void setTemplateParas(String[] templateParas) {
		this.templateParas = templateParas;
	}

	public String getStatusCallback() {
		return statusCallback;
	}

	public void setStatusCallback(String statusCallback) {
		this.statusCallback = statusCallback;
	}

	public String getExtend() {
		return extend;
	}

	public void setExtend(String extend) {
		this.extend = extend;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}
}
