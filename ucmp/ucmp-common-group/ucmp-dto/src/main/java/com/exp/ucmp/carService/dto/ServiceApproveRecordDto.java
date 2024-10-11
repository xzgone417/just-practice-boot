package com.exp.ucmp.carService.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ServiceApproveRecordDto", description = "整备审批记录Dto")
public class ServiceApproveRecordDto{
	
	@ApiModelProperty(value = "整备id")
	private Long serviceId;
	
	@ApiModelProperty(value = "整备记录id")
	private Long recordId;

    @ApiModelProperty(value = "审批时间")
    private String approvalDate;
    
    @ApiModelProperty(value = "审批结果:00-通过,01-驳回,02-放弃整备")
    private String approvalResult;
    
    @ApiModelProperty(value = "审批备注")
    private String approvalRemark;
    
    @ApiModelProperty(value = "审批人")
    private Long approvalPeopleId;
    
    @ApiModelProperty(value = "创建人")
	private Long createdBy;
	
	@ApiModelProperty(value = "更新人")
	private Long updateBy;

	public Long getServiceId() {
		return serviceId;
	}

	public void setServiceId(Long serviceId) {
		this.serviceId = serviceId;
	}

	public Long getRecordId() {
		return recordId;
	}

	public void setRecordId(Long recordId) {
		this.recordId = recordId;
	}

	public String getApprovalDate() {
		return approvalDate;
	}

	public void setApprovalDate(String approvalDate) {
		this.approvalDate = approvalDate;
	}

	public String getApprovalResult() {
		return approvalResult;
	}

	public void setApprovalResult(String approvalResult) {
		this.approvalResult = approvalResult;
	}

	public String getApprovalRemark() {
		return approvalRemark;
	}

	public void setApprovalRemark(String approvalRemark) {
		this.approvalRemark = approvalRemark;
	}

	public Long getApprovalPeopleId() {
		return approvalPeopleId;
	}

	public void setApprovalPeopleId(Long approvalPeopleId) {
		this.approvalPeopleId = approvalPeopleId;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Long getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(Long updateBy) {
		this.updateBy = updateBy;
	}
}
