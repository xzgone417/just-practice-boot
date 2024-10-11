package com.exp.ucmp.keywords.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "KeyWordsDto", description = "关键字实体类")
public class KeyWordsDto {

	@ApiModelProperty(value = "关键字类型")
	private Integer keyWordsType;
	
	@ApiModelProperty(value = "添加的关键字集合")
	private List<String> addLsit;
	
	public Integer getKeyWordsType() {
		return keyWordsType;
	}

	public void setKeyWordsType(Integer keyWordsType) {
		this.keyWordsType = keyWordsType;
	}

	public List<String> getAddLsit() {
		return addLsit;
	}

	public void setAddLsit(List<String> addLsit) {
		this.addLsit = addLsit;
	}

}
