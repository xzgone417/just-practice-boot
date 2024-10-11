package com.exp.ucmp.usc.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "TagDto", description = "评价标签类")
public class TagDto {
	
	@ApiModelProperty(value = "标签id")
	private String name;
	
	@ApiModelProperty(value = "标签名字")
    private String tagId;
	
    private boolean selected;
    
    private String level;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTagId() {
		return tagId;
	}

	public void setTagId(String tagId) {
		this.tagId = tagId;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}
}
