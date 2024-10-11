package com.exp.ucmp.eos.dto;

import java.util.List;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MessageParamDto", description = "eos消息推送参数类")
public class MessageParamDto {
	
	@NotNull
	@ApiModelProperty(value = "消息模版id 需联系EOS申请配置消息模板后EOS提供")
	private String templateId;
	
	@NotNull
	@ApiModelProperty(value = "消息发送来源 1.EOS;2.SMP;3.400客满;4.高合Hiphi，5.UCMP")
    private String originalChannel;
	
	@NotNull
	@ApiModelProperty(value = "消息接收方类型  0.员工id；1.员工编号")
	private int receiverType;
	
	@NotNull
	@ApiModelProperty(value = "消息接收方 员工标识数组")
    private List<String> receiverId;
	
	@ApiModelProperty(value = "发送方人员类型 0.系统;1.员工;2.客户")
    private int senderType;
	
	@ApiModelProperty(value = "发送方人员 系统不填，员工填员工号，客户填客户号")
    private String senderId;
	
	@ApiModelProperty(value = "极光推送跳转地址")
    private String jpushUrl;
	
	
	@ApiModelProperty(value = "消息中的变量值 需按模版中的顺序填值")
    private List<String> params;

	public String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	public String getOriginalChannel() {
		return originalChannel;
	}

	public void setOriginalChannel(String originalChannel) {
		this.originalChannel = originalChannel;
	}

	public List<String> getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(List<String> receiverId) {
		this.receiverId = receiverId;
	}

	public int getSenderType() {
		return senderType;
	}

	public void setSenderType(int senderType) {
		this.senderType = senderType;
	}

	public String getSenderId() {
		return senderId;
	}

	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}

	public String getJpushUrl() {
		return jpushUrl;
	}

	public void setJpushUrl(String jpushUrl) {
		this.jpushUrl = jpushUrl;
	}

	public int getReceiverType() {
		return receiverType;
	}

	public void setReceiverType(int receiverType) {
		this.receiverType = receiverType;
	}

	public List<String> getParams() {
		return params;
	}

	public void setParams(List<String> params) {
		this.params = params;
	}


	@Override
	public String toString() {
		return "MessageParamDto{" +
				"templateId='" + templateId + '\'' +
				", originalChannel='" + originalChannel + '\'' +
				", receiverType=" + receiverType +
				", receiverId=" + receiverId +
				", senderType=" + senderType +
				", senderId='" + senderId + '\'' +
				", jpushUrl='" + jpushUrl + '\'' +
				", params=" + params +
				'}';
	}
}
