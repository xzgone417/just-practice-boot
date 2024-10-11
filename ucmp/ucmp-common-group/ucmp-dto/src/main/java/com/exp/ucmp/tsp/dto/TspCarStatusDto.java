package com.exp.ucmp.tsp.dto;

import java.util.Map;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "TspCarStatusDto", description = "tsp累计里程")
public class TspCarStatusDto {
	
	@ApiModelProperty(value = "状态码")
	private String code;
	
	@ApiModelProperty(value = "车辆信息")
    private Map<String, Object> data;
	
	@ApiModelProperty(value = "状态信息")
    private String msg;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
