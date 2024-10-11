package com.exp.ucmp.carService.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "QuoteComponentDto", description = "isp预估报价单维修项目维修配件实体类")
public class QuoteComponentApproveDto {
	
	@ApiModelProperty(value = "维修配件id")
	private Long componentId;
	
	@ApiModelProperty(value = "是否维修(0 是 1 否)")
	private int isRepair;
	
	@ApiModelProperty(value = "驳回原因")
	private String rejectReasons;
	
	@ApiModelProperty(value = "更新人")
	private Long updateBy;

	public Long getComponentId() {
		return componentId;
	}

	public void setComponentId(Long componentId) {
		this.componentId = componentId;
	}

	public int getIsRepair() {
		return isRepair;
	}

	public void setIsRepair(int isRepair) {
		this.isRepair = isRepair;
	}

	public String getRejectReasons() {
		return rejectReasons;
	}

	public void setRejectReasons(String rejectReasons) {
		this.rejectReasons = rejectReasons;
	}

	public Long getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(Long updateBy) {
		this.updateBy = updateBy;
	}

}
