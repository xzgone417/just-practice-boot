package com.exp.ucmp.logistics.dto;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SenderDto", description = "发货人信息")
public class SenderDto {
	
	@NotNull
	@ApiModelProperty(value = "发货人")
    private String sender;
	
	@NotNull
	@ApiModelProperty(value = "联系方式")
    private String senderContact;

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getSenderContact() {
		return senderContact;
	}

	public void setSenderContact(String senderContact) {
		this.senderContact = senderContact;
	}

}
