package com.exp.ucmp.isp.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "QuoteComponentDto", description = "isp预估报价单维修项目维修配件实体类")
public class QuoteComponentDto {
	
	@ApiModelProperty(value = "维修项目id")
	private Long projectId;
	
	@ApiModelProperty(value = "维修配件id")
	private Long componentId;
	
	@ApiModelProperty(value = "维修配件代码")
	private String componentCode;
	
	@ApiModelProperty(value = "维修配件")
    private String componentName;
	
	@ApiModelProperty(value = "配件价格")
    private int componentPrice;
	
	@ApiModelProperty(value = "收费区分")
    private String differentiate;
	
	@ApiModelProperty(value = "收费区分代码")
    private String differentiateCode;
	
	@ApiModelProperty(value = "是否维修(0 是 1 否)")
	private Integer isRepair;
	
	@ApiModelProperty(value = "驳回原因")
	private String rejectReasons;

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public Long getComponentId() {
		return componentId;
	}

	public void setComponentId(Long componentId) {
		this.componentId = componentId;
	}

	public String getComponentCode() {
		return componentCode;
	}

	public void setComponentCode(String componentCode) {
		this.componentCode = componentCode;
	}

	public String getComponentName() {
		return componentName;
	}

	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}

	public int getComponentPrice() {
		return componentPrice;
	}

	public void setComponentPrice(int componentPrice) {
		this.componentPrice = componentPrice;
	}

	public String getDifferentiate() {
		return differentiate;
	}

	public void setDifferentiate(String differentiate) {
		this.differentiate = differentiate;
	}

	public String getDifferentiateCode() {
		return differentiateCode;
	}

	public void setDifferentiateCode(String differentiateCode) {
		this.differentiateCode = differentiateCode;
	}

	public Integer getIsRepair() {
		return isRepair;
	}

	public void setIsRepair(Integer isRepair) {
		this.isRepair = isRepair;
	}

	public String getRejectReasons() {
		return rejectReasons;
	}

	public void setRejectReasons(String rejectReasons) {
		this.rejectReasons = rejectReasons;
	}

}
