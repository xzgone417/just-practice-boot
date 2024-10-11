package com.exp.ucmp.smp.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "BenefitDataDto", description = "权益数据体")
public class BenefitDataDto {
	
	@ApiModelProperty(value = "权益名称")
	private String benefitName;
	
	@ApiModelProperty(value = "权益对象")
    private String benefitObject;
	
	@ApiModelProperty(value = "权益详情")
    private String benefitDesc;
	
	@ApiModelProperty(value = "权益图标链接")
    private String benefitlcon;
	
	@ApiModelProperty(value = "权益排序")
    private String sort;
	
	public String getBenefitName() {
		return benefitName;
	}
	public void setBenefitName(String benefitName) {
		this.benefitName = benefitName;
	}
	public String getBenefitObject() {
		return benefitObject;
	}
	public void setBenefitObject(String benefitObject) {
		this.benefitObject = benefitObject;
	}
	public String getBenefitDesc() {
		return benefitDesc;
	}
	public void setBenefitDesc(String benefitDesc) {
		this.benefitDesc = benefitDesc;
	}
	public String getBenefitlcon() {
		return benefitlcon;
	}
	public void setBenefitlcon(String benefitlcon) {
		this.benefitlcon = benefitlcon;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
}
