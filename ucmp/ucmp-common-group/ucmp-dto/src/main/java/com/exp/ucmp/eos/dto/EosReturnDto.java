package com.exp.ucmp.eos.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "EosReturnDto", description = "eos返回类")
public class EosReturnDto<T> {
	
	@ApiModelProperty(value = "响应状态码")
	private String code;
	
	@ApiModelProperty(value = "响应状态说明")
	private String msg;
	
	@ApiModelProperty(value = "消息体")
	private T data;

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

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
}
