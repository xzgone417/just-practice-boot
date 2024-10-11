package com.exp.ucmp.eos.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SmpReturnDto", description = "smp返回类")
public class SmpReturnDto {
	
	@ApiModelProperty(value = "响应状态码")
	private String code;
	
	@ApiModelProperty(value = "响应状态说明")
	private String msg;
	
	@ApiModelProperty(value = "消息体")
	private List<SmpUserInfoDto> data;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public List<SmpUserInfoDto> getData() {
		return data;
	}

	public void setData(List<SmpUserInfoDto> data) {
		this.data = data;
	}
	
}
