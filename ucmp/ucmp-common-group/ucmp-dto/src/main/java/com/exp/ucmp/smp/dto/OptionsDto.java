package com.exp.ucmp.smp.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "OptionsDto", description = "小订阶段预车型数据-选配值表")
public class OptionsDto {
	
	@ApiModelProperty(value = "选配项编码")
	private String optionCode;
	
	@ApiModelProperty(value = "选配项名称")
	private String optionName;
	
	@ApiModelProperty(value = "选配值编码")
	private String optionValCode;
	
	@ApiModelProperty(value = "选配值名称")
	private String optionValName;
	
	@ApiModelProperty(value = "选配值价格")
	private String optionValPrice;

	public String getOptionCode() {
		return optionCode;
	}

	public void setOptionCode(String optionCode) {
		this.optionCode = optionCode;
	}

	public String getOptionName() {
		return optionName;
	}

	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}

	public String getOptionValCode() {
		return optionValCode;
	}

	public void setOptionValCode(String optionValCode) {
		this.optionValCode = optionValCode;
	}

	public String getOptionValName() {
		return optionValName;
	}

	public void setOptionValName(String optionValName) {
		this.optionValName = optionValName;
	}

	public String getOptionValPrice() {
		return optionValPrice;
	}

	public void setOptionValPrice(String optionValPrice) {
		this.optionValPrice = optionValPrice;
	}

}
