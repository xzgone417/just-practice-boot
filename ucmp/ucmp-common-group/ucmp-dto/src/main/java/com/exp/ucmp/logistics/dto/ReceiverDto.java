package com.exp.ucmp.logistics.dto;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ReceiverDto", description = "收货人信息")
public class ReceiverDto {
	
	@NotNull
	@ApiModelProperty(value = "收货人")
    private String receiver;
	
	@NotNull
	@ApiModelProperty(value = "联系方式")
    private String receiverContact;

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getReceiverContact() {
		return receiverContact;
	}

	public void setReceiverContact(String receiverContact) {
		this.receiverContact = receiverContact;
	}

}
