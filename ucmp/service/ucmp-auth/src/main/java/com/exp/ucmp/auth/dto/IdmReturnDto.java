package com.exp.ucmp.auth.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "IdmReturnDto", description = "idm返回信息类")
public class IdmReturnDto<T> {
	
	@JsonSerialize(using = ToStringSerializer.class)
	@ApiModelProperty(value = "返回响应code")
	private String code;
	
	@JsonSerialize(using = ToStringSerializer.class)
	@ApiModelProperty(value = "返回响应信息")
	private String msg;
	
	@JsonSerialize(using = ToStringSerializer.class)
	@ApiModelProperty(value = "返回数据")
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
