package com.exp.ucmp.pay.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "PayRejectDto", description = "驳回收款参数类")
public class PayRejectDto {
	
	@ApiModelProperty(value = "收款单号")
	private String recordCode;
	
	@ApiModelProperty(value = "变更人")
	private Long partyId;

	public String getRecordCode() {
		return recordCode;
	}

	public void setRecordCode(String recordCode) {
		this.recordCode = recordCode;
	}

	public Long getPartyId() {
		return partyId;
	}

	public void setPartyId(Long partyId) {
		this.partyId = partyId;
	}
	
}
