package com.exp.ucmp.servicing.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ApprovalItemsPartsDto",description = "整备项目配件审批结果")
public class ApprovalItemsPartsDto {

	@ApiModelProperty(value = "维修项目配件id",required = true)
	private Long componentId;
	
	@ApiModelProperty(value = "是否维修(0 是 1 否)",required = true)
	private int isRepair;
	
	@ApiModelProperty(value = "创建人")
    private Long createBy;
	    
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

	public Long getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Long createBy) {
		this.createBy = createBy;
	}

	public Long getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(Long updateBy) {
		this.updateBy = updateBy;
	}
	
}
