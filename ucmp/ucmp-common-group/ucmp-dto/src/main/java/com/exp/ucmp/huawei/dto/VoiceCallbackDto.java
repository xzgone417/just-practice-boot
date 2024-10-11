package com.exp.ucmp.huawei.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "VoiceCallbackDto", description = "接收华为云语音通知事件参数")
public class VoiceCallbackDto {
	
	@ApiModelProperty(value = "通知的事件类型")
	private String eventType;
	
	@ApiModelProperty(value = "呼叫状态事件的信息")
	private VoiceCallDto statusInfo;

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public VoiceCallDto getStatusInfo() {
		return statusInfo;
	}

	public void setStatusInfo(VoiceCallDto statusInfo) {
		this.statusInfo = statusInfo;
	}
	
	
}
