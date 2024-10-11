package com.exp.ucmp.carService.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "QuoteProjecDto", description = "isp预估报价单维修项目实体类")
public class QuoteProjectApproveDto {
	
	@ApiModelProperty(value = "维修项目id")
	private Long projectId;
	
	@ApiModelProperty(value = "是否维修(0 是 1 否)")
	private int isRepair;
	
	@ApiModelProperty(value = "驳回原因")
	private String rejectReasons;
	
	@ApiModelProperty(value = "更新人")
	private Long updateBy;
	
	@ApiModelProperty(value = "维修配件集合")
    private List<QuoteComponentApproveDto> componentList;
	
	@ApiModelProperty(value = "其他费用数据")
    private List<QuoteOtherFeesApproveDto> otherFeesList;

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
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

	public List<QuoteComponentApproveDto> getComponentList() {
		return componentList;
	}

	public void setComponentList(List<QuoteComponentApproveDto> componentList) {
		this.componentList = componentList;
	}

	public List<QuoteOtherFeesApproveDto> getOtherFeesList() {
		return otherFeesList;
	}

	public void setOtherFeesList(List<QuoteOtherFeesApproveDto> otherFeesList) {
		this.otherFeesList = otherFeesList;
	}

}
