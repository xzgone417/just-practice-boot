package com.exp.ucmp.isp.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "QuoteOrderDto", description = "isp预估报价单实体类")
public class QuoteStatusDto {
	
	@ApiModelProperty(value = "UCMP的整备单号")
	private String ucmpOrderNo;
	
	@ApiModelProperty(value = "维修状态")
    private String status;
	
	@ApiModelProperty(value = "预估交车时间")
    private String completeDate;
	
	@ApiModelProperty(value = "维修工单号")
    private String workOrderNo;

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

	public String getCompleteDate() {
		return completeDate;
	}

	public void setCompleteDate(String completeDate) {
		this.completeDate = completeDate;
	}

	public String getWorkOrderNo() {
		return workOrderNo;
	}

	public void setWorkOrderNo(String workOrderNo) {
		this.workOrderNo = workOrderNo;
	}

}
