package com.exp.ucmp.iautos.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "AssessReturnDto", description = "估价返回类")
public class AssessReturnDto {
	
	@ApiModelProperty(value = "估价信息")
	private AssessInfoDto data;
	
	@ApiModelProperty(value = "响应码")
    private Integer code;
	
	@ApiModelProperty(value = "响应时间")
    private String message;
	
	@ApiModelProperty(value = "响应时间")
    private String datetime;

	public AssessInfoDto getData() {
		return data;
	}

	public void setData(AssessInfoDto data) {
		this.data = data;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
}
