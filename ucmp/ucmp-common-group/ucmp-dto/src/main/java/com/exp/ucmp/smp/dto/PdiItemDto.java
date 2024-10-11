package com.exp.ucmp.smp.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "PdiItemDto", description = "PDI单项目")
public class PdiItemDto {

	@ApiModelProperty(value = "检测项目编码")
	private String pdiItemNo;
	
	@ApiModelProperty(value = "检测结果")
    private String pdiItemResult;
	
	@ApiModelProperty(value = "备注")
    private String remark;

	public String getPdiItemNo() {
		return pdiItemNo;
	}

	public void setPdiItemNo(String pdiItemNo) {
		this.pdiItemNo = pdiItemNo;
	}

	public String getPdiItemResult() {
		return pdiItemResult;
	}

	public void setPdiItemResult(String pdiItemResult) {
		this.pdiItemResult = pdiItemResult;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
