package com.exp.ucmp.clues.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "OrderChangePriceDto", description = "订单改价参数类")
public class OrderChangePriceDto {
	
	@ApiModelProperty("记录id，不传")
    private Long recordId;
	
    @ApiModelProperty("订单id，必传")
    private Long orderInfoId;

    @ApiModelProperty("原价，必传")
    private Double olderPrice;

    @ApiModelProperty("新价，必传")
    private Double newPrice;
    
    @ApiModelProperty("改价原因，必传")
    private String changeReasons;
    
    @ApiModelProperty(value = "OA编号")
	private String oaCode;
    
    @ApiModelProperty("改价凭证")
    List<OrderChangeFileDto> fileList;
    
    @ApiModelProperty("操作人，不用传")
    private Long partyId;
    
    @ApiModelProperty("模型建议价")
    private Double suggestedPrice;
    
    @ApiModelProperty(value = "审批状态 0 待审批 1 审批通过 2 审批驳回")
    private Integer approveStatus;
    
    @ApiModelProperty(value = "审批状态名称 0 待审批 1 审批通过 2 审批驳回")
    private String approveStatusName;
    
    @ApiModelProperty("驳回原因")
    private String rejectReason;
    
    @ApiModelProperty("是否有效 00 无效 01 有效")
    private String isEnable;
    
    @ApiModelProperty(value = "车辆id")
    private Long stockId;

	public Long getRecordId() {
		return recordId;
	}

	public void setRecordId(Long recordId) {
		this.recordId = recordId;
	}

	public Long getOrderInfoId() {
		return orderInfoId;
	}

	public void setOrderInfoId(Long orderInfoId) {
		this.orderInfoId = orderInfoId;
	}

	public Double getOlderPrice() {
		return olderPrice;
	}

	public void setOlderPrice(Double olderPrice) {
		this.olderPrice = olderPrice;
	}

	public Double getNewPrice() {
		return newPrice;
	}

	public void setNewPrice(Double newPrice) {
		this.newPrice = newPrice;
	}

	public String getChangeReasons() {
		return changeReasons;
	}

	public void setChangeReasons(String changeReasons) {
		this.changeReasons = changeReasons;
	}

	public String getOaCode() {
		return oaCode;
	}

	public void setOaCode(String oaCode) {
		this.oaCode = oaCode;
	}

	public List<OrderChangeFileDto> getFileList() {
		return fileList;
	}

	public void setFileList(List<OrderChangeFileDto> fileList) {
		this.fileList = fileList;
	}

	public Long getPartyId() {
		return partyId;
	}

	public void setPartyId(Long partyId) {
		this.partyId = partyId;
	}

	public Double getSuggestedPrice() {
		return suggestedPrice;
	}

	public void setSuggestedPrice(Double suggestedPrice) {
		this.suggestedPrice = suggestedPrice;
	}

	public Integer getApproveStatus() {
		return approveStatus;
	}

	public void setApproveStatus(Integer approveStatus) {
		this.approveStatus = approveStatus;
	}

	public String getApproveStatusName() {
		return approveStatusName;
	}

	public void setApproveStatusName(String approveStatusName) {
		this.approveStatusName = approveStatusName;
	}

	public String getRejectReason() {
		return rejectReason;
	}

	public void setRejectReason(String rejectReason) {
		this.rejectReason = rejectReason;
	}

	public String getIsEnable() {
		return isEnable;
	}

	public void setIsEnable(String isEnable) {
		this.isEnable = isEnable;
	}

	public Long getStockId() {
		return stockId;
	}

	public void setStockId(Long stockId) {
		this.stockId = stockId;
	}

}
