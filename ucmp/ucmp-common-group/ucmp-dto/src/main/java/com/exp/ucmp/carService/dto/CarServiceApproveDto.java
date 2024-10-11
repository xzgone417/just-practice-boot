package com.exp.ucmp.carService.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(value = "CarServiceApproveDto", description = "车辆整备报价审批DTO")
public class CarServiceApproveDto {

    @ApiModelProperty(value = "整备信息id")
    private Long serviceId;
    
    @ApiModelProperty(value = "整备单号")
    private String serviceNumber;
    
    @ApiModelProperty(value = "审批结果:0-通过,1-驳回,2-放弃整备")
    private int approveResult;
    
    @ApiModelProperty(value = "审批备注")
    private String approveRemark;

    @ApiModelProperty(value = "维修项目数据")
    private List<QuoteProjectApproveDto> projectList;

	public Long getServiceId() {
		return serviceId;
	}

	public void setServiceId(Long serviceId) {
		this.serviceId = serviceId;
	}

	public String getServiceNumber() {
		return serviceNumber;
	}

	public void setServiceNumber(String serviceNumber) {
		this.serviceNumber = serviceNumber;
	}

	public int getApproveResult() {
		return approveResult;
	}

	public void setApproveResult(int approveResult) {
		this.approveResult = approveResult;
	}

	public String getApproveRemark() {
		return approveRemark;
	}

	public void setApproveRemark(String approveRemark) {
		this.approveRemark = approveRemark;
	}

	public List<QuoteProjectApproveDto> getProjectList() {
		return projectList;
	}

	public void setProjectList(List<QuoteProjectApproveDto> projectList) {
		this.projectList = projectList;
	}
}
