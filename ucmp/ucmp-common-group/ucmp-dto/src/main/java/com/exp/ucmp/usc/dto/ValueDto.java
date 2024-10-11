package com.exp.ucmp.usc.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ValueDto", description = "问题选值")
public class ValueDto {

	@ApiModelProperty(value = "选项代码")
	private String code;
	
	@ApiModelProperty(value = "选项名称")
    private String name;
	
	@ApiModelProperty(value = "是否选中")
    private boolean selected;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
}
