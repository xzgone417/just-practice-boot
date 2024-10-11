package com.exp.ucmp.Import.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ImportReturnDto", description = "导入返回类")
public class ImportReturnDto {
	
	@ApiModelProperty(value = "导入结果")
	private String result;
	
	@ApiModelProperty(value = "1 全部成功 2全部失败 3 部分成功")
    private Integer flag;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}
}
