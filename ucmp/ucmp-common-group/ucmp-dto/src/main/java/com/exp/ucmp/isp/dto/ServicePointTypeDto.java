package com.exp.ucmp.isp.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ServicePointTypeDto", description = "服务点类型实体类")
public class ServicePointTypeDto {
	
	@ApiModelProperty(value = "服务点类型代码")
	private String pointTypeCode;
	
	@ApiModelProperty(value = "服务点类型名称")
	private String pointTypeName;

	public String getPointTypeCode() {
		return pointTypeCode;
	}

	public void setPointTypeCode(String pointTypeCode) {
		this.pointTypeCode = pointTypeCode;
	}

	public String getPointTypeName() {
		return pointTypeName;
	}

	public void setPointTypeName(String pointTypeName) {
		this.pointTypeName = pointTypeName;
	}
	
}
