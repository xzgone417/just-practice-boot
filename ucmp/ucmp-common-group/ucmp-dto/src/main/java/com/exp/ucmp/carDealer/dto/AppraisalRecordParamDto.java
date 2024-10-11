package com.exp.ucmp.carDealer.dto;

import com.exp.ucmp.PageDto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "AppraisalRecordParamDto", description = "估价记录查询参数")
public class AppraisalRecordParamDto extends PageDto {

	private static final long serialVersionUID = 6437836749108288882L;

	@ApiModelProperty(value = "车商人员Id")
	private Long appraisalStaffId;

	@ApiModelProperty(value = "估价记录Id")
	private Long appraisalId;

	public Long getAppraisalStaffId() {
		return appraisalStaffId;
	}

	public void setAppraisalStaffId(Long appraisalStaffId) {
		this.appraisalStaffId = appraisalStaffId;
	}

	public Long getAppraisalId() {
		return appraisalId;
	}

	public void setAppraisalId(Long appraisalId) {
		this.appraisalId = appraisalId;
	}
	
}
