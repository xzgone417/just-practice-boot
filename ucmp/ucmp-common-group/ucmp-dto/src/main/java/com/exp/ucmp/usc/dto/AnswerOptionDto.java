package com.exp.ucmp.usc.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "AnswerOptionDto", description = "评价问题选项类")
public class AnswerOptionDto {
	
	@ApiModelProperty(value = "选项类型")
	private String type;
	
	@ApiModelProperty(value = "选项代码")
    private List<ValueDto> value;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<ValueDto> getValue() {
		return value;
	}

	public void setValue(List<ValueDto> value) {
		this.value = value;
	}
	
	
}
