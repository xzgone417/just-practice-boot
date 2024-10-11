package com.exp.ucmp.isp.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "QuoteOtherFeesDto", description = "isp预估报价单维修项目其他费用实体类")
public class QuoteOtherFeesDto {
	
	@ApiModelProperty(value = "维修项目id")
	private Long projectId;
	
	@ApiModelProperty(value = "维修项目其他费用id")
	private Long otherFeesId;
	
	@ApiModelProperty(value = "维修工时名称")
	private String repairTimeName;
	
	@ApiModelProperty(value = "维修工时代码")
    private String repairTimeCode;
	
	@ApiModelProperty(value = "其他费用名称")
    private String otherFeesName;
	
	@ApiModelProperty(value = "其他费用代码")
    private String otherFeesCode;
	
	@ApiModelProperty(value = "收费区分")
    private String differentiate;
	
	@ApiModelProperty(value = "收费区分代码")
    private String differentiateCode;
	
	@ApiModelProperty(value = "费用")
    private String fees;
	
	@ApiModelProperty(value = "应收金额")
    private String receivableAmount;
	
	@ApiModelProperty(value = "备注")
    private String remark;
	
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

	public Long getOtherFeesId() {
		return otherFeesId;
	}

	public void setOtherFeesId(Long otherFeesId) {
		this.otherFeesId = otherFeesId;
	}

	public String getRepairTimeName() {
		return repairTimeName;
	}

	public void setRepairTimeName(String repairTimeName) {
		this.repairTimeName = repairTimeName;
	}

	public String getRepairTimeCode() {
		return repairTimeCode;
	}

	public void setRepairTimeCode(String repairTimeCode) {
		this.repairTimeCode = repairTimeCode;
	}

	public String getOtherFeesName() {
		return otherFeesName;
	}

	public void setOtherFeesName(String otherFeesName) {
		this.otherFeesName = otherFeesName;
	}

	public String getOtherFeesCode() {
		return otherFeesCode;
	}

	public void setOtherFeesCode(String otherFeesCode) {
		this.otherFeesCode = otherFeesCode;
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

	public String getFees() {
		return fees;
	}

	public void setFees(String fees) {
		this.fees = fees;
	}

	public String getReceivableAmount() {
		return receivableAmount;
	}

	public void setReceivableAmount(String receivableAmount) {
		this.receivableAmount = receivableAmount;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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
