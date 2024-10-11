package com.exp.ucmp.car.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ApproveChangePriceDto", description = "改价审批参数类")
public class ApproveChangePriceDto {
	
	@ApiModelProperty(value = "改价记录id,必传")
    private Long recordId;
	
	@ApiModelProperty(value = "审批状态 1 审批通过 2 审批驳回，必传")
    private Integer approveStatus;
	
	@ApiModelProperty(value = "驳回原因")
    private String rejectReason;

	@ApiModelProperty(value = "审批人，不用传")
    private Long updateBy;

	public Long getRecordId() {
		return recordId;
	}

	public void setRecordId(Long recordId) {
		this.recordId = recordId;
	}

	public Integer getApproveStatus() {
		return approveStatus;
	}

	public void setApproveStatus(Integer approveStatus) {
		this.approveStatus = approveStatus;
	}

	public String getRejectReason() {
		return rejectReason;
	}

	public void setRejectReason(String rejectReason) {
		this.rejectReason = rejectReason;
	}

	public Long getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(Long updateBy) {
		this.updateBy = updateBy;
	}
	
}
