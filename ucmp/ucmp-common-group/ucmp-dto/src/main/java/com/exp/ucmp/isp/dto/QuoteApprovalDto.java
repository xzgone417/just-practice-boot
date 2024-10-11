package com.exp.ucmp.isp.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "QuoteApprovalDto", description = "isp预估报价单审批实体类")
public class QuoteApprovalDto {
	
	@ApiModelProperty(value = "UCMP的整备单号")
	private String ucmpOrderNo;
	
	@ApiModelProperty(value = "审批状态 PASS:通过，REJECT:驳回，GIVE_UP:放弃整备")
	private String status;
	
	@ApiModelProperty(value = "备注")
	private String remark;
	
	@ApiModelProperty(value = "审批人姓名")
	private String approvalName;
	
	@ApiModelProperty(value = "审批人工号")
	private String approvalEmpId;
	

	public String getUcmpOrderNo() {
		return ucmpOrderNo;
	}

	public void setUcmpOrderNo(String ucmpOrderNo) {
		this.ucmpOrderNo = ucmpOrderNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getApprovalName() {
		return approvalName;
	}

	public void setApprovalName(String approvalName) {
		this.approvalName = approvalName;
	}

	public String getApprovalEmpId() {
		return approvalEmpId;
	}

	public void setApprovalEmpId(String approvalEmpId) {
		this.approvalEmpId = approvalEmpId;
	}

}
