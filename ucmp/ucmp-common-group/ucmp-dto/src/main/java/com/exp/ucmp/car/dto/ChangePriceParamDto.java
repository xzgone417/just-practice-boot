package com.exp.ucmp.car.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ChangePriceParamDto", description = "改价记录参数")
public class ChangePriceParamDto {
	
    @ApiModelProperty(value = "改价记录ID")
    private Long recordId;
    
    @ApiModelProperty(value = "库存车辆ID")
    private Long stockId;
    
    @ApiModelProperty(value = "订单改价记录ID")
    private Long orderRecordId;
    
    @ApiModelProperty(value = "模型建议价")
    private Double suggestedPrice;
    
    @ApiModelProperty(value = "当前价格")
    private Double curPrice;
    
    @ApiModelProperty(value = "修改后价格")
    private Double changePrice;
    
    @ApiModelProperty(value = "改价原因")
    private String changeReason;
    
    @ApiModelProperty(value = "OA编号 ")
    private String oaCode;
    
    @ApiModelProperty(value = "改价申请审批状态 0 待审批 1 审批通过 2 审批驳回")
    private int approveStatus;
    
    @ApiModelProperty(value = "改价申请审批时间")
    private String approveDate;
    
    @ApiModelProperty(value = "驳回原因")
    private String rejectReason;
    
    @ApiModelProperty(value = "创建人ID")
    private Long createdBy;
    
    @ApiModelProperty(value = "更新人ID")
    private Long updatedBy;

	public Long getRecordId() {
		return recordId;
	}

	public void setRecordId(Long recordId) {
		this.recordId = recordId;
	}

	public Long getStockId() {
		return stockId;
	}

	public void setStockId(Long stockId) {
		this.stockId = stockId;
	}

	public Long getOrderRecordId() {
		return orderRecordId;
	}

	public void setOrderRecordId(Long orderRecordId) {
		this.orderRecordId = orderRecordId;
	}

	public Double getSuggestedPrice() {
		return suggestedPrice;
	}

	public void setSuggestedPrice(Double suggestedPrice) {
		this.suggestedPrice = suggestedPrice;
	}

	public Double getCurPrice() {
		return curPrice;
	}

	public void setCurPrice(Double curPrice) {
		this.curPrice = curPrice;
	}

	public Double getChangePrice() {
		return changePrice;
	}

	public void setChangePrice(Double changePrice) {
		this.changePrice = changePrice;
	}

	public String getChangeReason() {
		return changeReason;
	}

	public void setChangeReason(String changeReason) {
		this.changeReason = changeReason;
	}

	public String getOaCode() {
		return oaCode;
	}

	public void setOaCode(String oaCode) {
		this.oaCode = oaCode;
	}

	public int getApproveStatus() {
		return approveStatus;
	}

	public void setApproveStatus(int approveStatus) {
		this.approveStatus = approveStatus;
	}

	public String getApproveDate() {
		return approveDate;
	}

	public void setApproveDate(String approveDate) {
		this.approveDate = approveDate;
	}

	public String getRejectReason() {
		return rejectReason;
	}

	public void setRejectReason(String rejectReason) {
		this.rejectReason = rejectReason;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Long getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}
}
