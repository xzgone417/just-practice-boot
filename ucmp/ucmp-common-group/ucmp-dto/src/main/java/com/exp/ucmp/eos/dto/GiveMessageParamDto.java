package com.exp.ucmp.eos.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.List;

@ApiModel(value = "GiveMessageParamDto", description = "slf消息推送参数类")
public class GiveMessageParamDto {
	
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
    private String receiverId;
	
	@ApiModelProperty(value = "发送方人员类型 0.系统;1.员工;2.客户")
    private int senderType;
	
	@ApiModelProperty(value = "发送方人员 系统不填，员工填员工号，客户填客户号")
    private String senderId;
	
	
	@ApiModelProperty(value = "消息中的变量值 需按模版中的顺序填值")
    private List<String> params;

	@Override
	public String toString() {
		return "GiveMessageParamDto{" +
				"templateId='" + templateId + '\'' +
				", originalChannel='" + originalChannel + '\'' +
				", receiverType=" + receiverType +
				", receiverId='" + receiverId + '\'' +
				", senderType=" + senderType +
				", senderId='" + senderId + '\'' +
				", params=" + params +
				'}';
	}

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

	public int getReceiverType() {
		return receiverType;
	}

	public void setReceiverType(int receiverType) {
		this.receiverType = receiverType;
	}

	public String getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(String receiverId) {
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

	public List<String> getParams() {
		return params;
	}

	public void setParams(List<String> params) {
		this.params = params;
	}
}
