package com.exp.ucmp.isp.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ServicePointDto", description = "服务点实体类")
public class ServicePointDto {
	
	@ApiModelProperty(value = "服务点代码")
	private String pointCode;
	
	@ApiModelProperty(value = "服务点名称")
	private String pointName;
	
	@ApiModelProperty(value = "服务点类型")
	private String pointType;

	public String getPointCode() {
		return pointCode;
	}

	public void setPointCode(String pointCode) {
		this.pointCode = pointCode;
	}

	public String getPointName() {
		return pointName;
	}

	public void setPointName(String pointName) {
		this.pointName = pointName;
	}

	public String getPointType() {
		return pointType;
	}

	public void setPointType(String pointType) {
		this.pointType = pointType;
	}
}
