package com.exp.ucmp.isp.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "IspReturnDto", description = "isp信息返回类")
public class IspSiteReturnDto {
	
	@ApiModelProperty(value = "状态码")
	private String code;
	
	@ApiModelProperty(value = "数据")
    private List<IspSiteDto> data;
	
	@ApiModelProperty(value = "状态信息")
    private String msg;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<IspSiteDto> getData() {
		return data;
	}

	public void setData(List<IspSiteDto> data) {
		this.data = data;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
