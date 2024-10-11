package com.exp.ucmp.pay.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "PayMatchingDto", description = "匹配/解绑收款参数类")
public class PayMatchingDto {
	
	@ApiModelProperty(value = "收款单号")
	private String recordCode;
	
	@ApiModelProperty(value = "银行流水号")
	private String zbiiln;
	
	@ApiModelProperty(value = "变更人")
	private Long partyId;

	public String getRecordCode() {
		return recordCode;
	}

	public void setRecordCode(String recordCode) {
		this.recordCode = recordCode;
	}

	public String getZbiiln() {
		return zbiiln;
	}

	public void setZbiiln(String zbiiln) {
		this.zbiiln = zbiiln;
	}

	public Long getPartyId() {
		return partyId;
	}

	public void setPartyId(Long partyId) {
		this.partyId = partyId;
	}
	
}
