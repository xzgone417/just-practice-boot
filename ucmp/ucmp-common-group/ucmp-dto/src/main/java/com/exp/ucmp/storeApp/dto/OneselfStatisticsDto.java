package com.exp.ucmp.storeApp.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "OneselfStatisticsDto", description = "本品收购首页数据统计")
public class OneselfStatisticsDto {
	
	@ApiModelProperty(value = "待分配数量")
	private Integer unAllocatedNum;
	
	@ApiModelProperty(value = "待收购数量")
	private Integer unAcquisitionNum;
	
	@ApiModelProperty(value = "待审批数量")
	private Integer unApproveNum;
	
	@ApiModelProperty(value = "审批驳回数量")
	private Integer approvalRejectionNum;
	
	@ApiModelProperty(value = "待入库数量")
	private Integer pendingStockNum;
	
	@ApiModelProperty(value = "已入库待过户数量")
	private Integer warehousedNum;

	public Integer getUnAllocatedNum() {
		return unAllocatedNum;
	}

	public void setUnAllocatedNum(Integer unAllocatedNum) {
		this.unAllocatedNum = unAllocatedNum;
	}

	public Integer getUnAcquisitionNum() {
		return unAcquisitionNum;
	}

	public void setUnAcquisitionNum(Integer unAcquisitionNum) {
		this.unAcquisitionNum = unAcquisitionNum;
	}

	public Integer getUnApproveNum() {
		return unApproveNum;
	}

	public void setUnApproveNum(Integer unApproveNum) {
		this.unApproveNum = unApproveNum;
	}

	public Integer getApprovalRejectionNum() {
		return approvalRejectionNum;
	}

	public void setApprovalRejectionNum(Integer approvalRejectionNum) {
		this.approvalRejectionNum = approvalRejectionNum;
	}

	public Integer getPendingStockNum() {
		return pendingStockNum;
	}

	public void setPendingStockNum(Integer pendingStockNum) {
		this.pendingStockNum = pendingStockNum;
	}

	public Integer getWarehousedNum() {
		return warehousedNum;
	}

	public void setWarehousedNum(Integer warehousedNum) {
		this.warehousedNum = warehousedNum;
	}
}
