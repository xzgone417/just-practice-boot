package com.exp.ucmp.carService.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "QuoteOtherFeesDto", description = "isp预估报价单维修项目其他费用实体类")
public class QuoteOtherFeesApproveDto {
	
	@ApiModelProperty(value = "维修项目其他费用id")
	private Long otherFeesId;
	
	@ApiModelProperty(value = "是否维修(0 是 1 否)")
	private int isRepair;
	
	@ApiModelProperty(value = "驳回原因")
	private String rejectReasons;
	
	@ApiModelProperty(value = "更新人")
	private Long updateBy;

	public Long getOtherFeesId() {
		return otherFeesId;
	}

	public void setOtherFeesId(Long otherFeesId) {
		this.otherFeesId = otherFeesId;
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
