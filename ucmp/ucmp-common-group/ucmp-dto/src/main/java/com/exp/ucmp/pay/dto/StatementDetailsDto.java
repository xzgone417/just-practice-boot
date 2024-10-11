package com.exp.ucmp.pay.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "StatementDetailsDto", description = "收款详情")
public class StatementDetailsDto {
	
	@ApiModelProperty(value = "匹配记录ID")
	private Long recordId;
	
	@ApiModelProperty(value = "付款记录code，必传")
	private String recordCode;
	
	@ApiModelProperty(value = "流水号")
	private String zbiiln;
	
	@ApiModelProperty(value = "账号名称")
	private String zdname;
	
	@ApiModelProperty(value = "付款账号")
	private String zdbankn;

	@ApiModelProperty(value = "到账方式，必传")
	private String receiptMethod;
	
	@ApiModelProperty(value = "到账金额，必传")
	private Double zcrtrsamt;

	@ApiModelProperty(value = "到账时间，必传")
	private String receiptDate;
	
	@ApiModelProperty(value = "可匹配金额")
	private Double matchingAmount;
	
	@ApiModelProperty(value = "票据URL，必传")
	private String fileUrl;
	
	@ApiModelProperty(value = "缩略图")
	private String thumbnail;
	
	@ApiModelProperty(value = "材料文件id，必传")
	private Long materialId;
	
	@ApiModelProperty(value = "财务审批操作，01 匹配 02 确认 03 解绑，不用传")
	private String approvalOperation;
	
	@ApiModelProperty(value = "变更人")
	private Long partyId;

	public Long getRecordId() {
		return recordId;
	}

	public void setRecordId(Long recordId) {
		this.recordId = recordId;
	}

	public String getRecordCode() {
		return recordCode;
	}

	public void setRecordCode(String recordCode) {
		this.recordCode = recordCode;
	}

	public String getZbiiln() {
		return zbiiln;
	}

	public void setZbiiln(String zbiiln) {
		this.zbiiln = zbiiln;
	}

	public String getZdname() {
		return zdname;
	}

	public void setZdname(String zdname) {
		this.zdname = zdname;
	}

	public String getZdbankn() {
		return zdbankn;
	}

	public void setZdbankn(String zdbankn) {
		this.zdbankn = zdbankn;
	}

	public String getReceiptMethod() {
		return receiptMethod;
	}

	public void setReceiptMethod(String receiptMethod) {
		this.receiptMethod = receiptMethod;
	}

	public Double getZcrtrsamt() {
		return zcrtrsamt;
	}

	public void setZcrtrsamt(Double zcrtrsamt) {
		this.zcrtrsamt = zcrtrsamt;
	}

	public String getReceiptDate() {
		return receiptDate;
	}

	public void setReceiptDate(String receiptDate) {
		this.receiptDate = receiptDate;
	}

	public Double getMatchingAmount() {
		return matchingAmount;
	}

	public void setMatchingAmount(Double matchingAmount) {
		this.matchingAmount = matchingAmount;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public Long getMaterialId() {
		return materialId;
	}

	public void setMaterialId(Long materialId) {
		this.materialId = materialId;
	}

	public Long getPartyId() {
		return partyId;
	}

	public void setPartyId(Long partyId) {
		this.partyId = partyId;
	}

	public String getApprovalOperation() {
		return approvalOperation;
	}

	public void setApprovalOperation(String approvalOperation) {
		this.approvalOperation = approvalOperation;
	}
	
}
