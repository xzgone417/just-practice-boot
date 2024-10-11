package com.exp.ucmp.servicing.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ApprovalItemsDto",description = "整备项目审批结果")
public class ApprovalItemsDto {

	@ApiModelProperty(value = "维修项目id",required = true)
	private Long projectId;
	
	@ApiModelProperty(value = "是否有配件(0 是 1 否)",required = true)
	private int isComponent;
	
	@ApiModelProperty(value = "是否维修(0 是 1 否)",required = true)
	private int isRepair;
	
	@ApiModelProperty(value = "配件审批结果集合",required = true)
	private List<ApprovalItemsPartsDto> partsList;
	
	@ApiModelProperty(value = "创建人")
    private Long createBy;
	    
    @ApiModelProperty(value = "更新人")
    private Long updateBy;

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public int getIsComponent() {
		return isComponent;
	}

	public void setIsComponent(int isComponent) {
		this.isComponent = isComponent;
	}

	public int getIsRepair() {
		return isRepair;
	}

	public void setIsRepair(int isRepair) {
		this.isRepair = isRepair;
	}

	public List<ApprovalItemsPartsDto> getPartsList() {
		return partsList;
	}

	public void setPartsDtoList(List<ApprovalItemsPartsDto> partsList) {
		this.partsList = partsList;
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
