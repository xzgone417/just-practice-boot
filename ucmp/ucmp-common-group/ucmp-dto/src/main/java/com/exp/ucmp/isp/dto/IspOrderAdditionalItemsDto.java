package com.exp.ucmp.isp.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "IspOrderMaintenanceItemsDto", description = "isp报价单申请返回类")
public class IspOrderAdditionalItemsDto {
	
	@ApiModelProperty(value = "concern号")
	private String concernCode;
	
	@ApiModelProperty(value = "索赔，客户付费，内部结算、保险")
	private Integer feeDifferentiation;
	
	@ApiModelProperty(value = "服务活动")
	private String activityNo;
	
	@ApiModelProperty(value = "费用区分中文")
	private String feeDifferentiationLabel;
	
	@ApiModelProperty(value = "主键")
	private Long id;
	
	@ApiModelProperty(value = "附加项代码")
	private String code;
	
	@ApiModelProperty(value = "附加项名称")
	private String name;
	
	@ApiModelProperty(value = "总价")
	private Double totalPrice;
	
	@ApiModelProperty(value = "应收金额")
	private Double receivePrice;
	
	@ApiModelProperty(value = "优惠金额")
	private Double preferentialPrice;
	
	@ApiModelProperty(value = "工单号")
	private String workOrderNo;
	
	@ApiModelProperty(value = "备注")
	private String remark;
	
	@ApiModelProperty(value = "行号")
	private String posnr;
	
	@ApiModelProperty(value = "")
	private String maintenanceItemCode;
	
	@ApiModelProperty(value = "")
	private String maintenanceItemName;

	public String getConcernCode() {
		return concernCode;
	}

	public void setConcernCode(String concernCode) {
		this.concernCode = concernCode;
	}

	public Integer getFeeDifferentiation() {
		return feeDifferentiation;
	}

	public void setFeeDifferentiation(Integer feeDifferentiation) {
		this.feeDifferentiation = feeDifferentiation;
	}

	public String getActivityNo() {
		return activityNo;
	}

	public void setActivityNo(String activityNo) {
		this.activityNo = activityNo;
	}

	public String getFeeDifferentiationLabel() {
		return feeDifferentiationLabel;
	}

	public void setFeeDifferentiationLabel(String feeDifferentiationLabel) {
		this.feeDifferentiationLabel = feeDifferentiationLabel;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Double getReceivePrice() {
		return receivePrice;
	}

	public void setReceivePrice(Double receivePrice) {
		this.receivePrice = receivePrice;
	}

	public Double getPreferentialPrice() {
		return preferentialPrice;
	}

	public void setPreferentialPrice(Double preferentialPrice) {
		this.preferentialPrice = preferentialPrice;
	}

	public String getWorkOrderNo() {
		return workOrderNo;
	}

	public void setWorkOrderNo(String workOrderNo) {
		this.workOrderNo = workOrderNo;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getPosnr() {
		return posnr;
	}

	public void setPosnr(String posnr) {
		this.posnr = posnr;
	}

	public String getMaintenanceItemCode() {
		return maintenanceItemCode;
	}

	public void setMaintenanceItemCode(String maintenanceItemCode) {
		this.maintenanceItemCode = maintenanceItemCode;
	}

	public String getMaintenanceItemName() {
		return maintenanceItemName;
	}

	public void setMaintenanceItemName(String maintenanceItemName) {
		this.maintenanceItemName = maintenanceItemName;
	}

}
