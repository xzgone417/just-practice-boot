package com.exp.ucmp.pay.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "RecordDetailsDto", description = "收款详情")
public class RecordDetailsDto {
	
	@ApiModelProperty(value = "收款单信息")
	private PayDetailsDto payDetailsDto;
	
	@ApiModelProperty(value = "流水确认信息")
	private StatementDetailsDto statementDetailsDto;

	public PayDetailsDto getPayDetailsDto() {
		return payDetailsDto;
	}

	public void setPayDetailsDto(PayDetailsDto payDetailsDto) {
		this.payDetailsDto = payDetailsDto;
	}

	public StatementDetailsDto getStatementDetailsDto() {
		return statementDetailsDto;
	}

	public void setStatementDetailsDto(StatementDetailsDto statementDetailsDto) {
		this.statementDetailsDto = statementDetailsDto;
	}
}
