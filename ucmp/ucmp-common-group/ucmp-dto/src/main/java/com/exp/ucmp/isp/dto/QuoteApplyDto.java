package com.exp.ucmp.isp.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "QuoteApplyDto", description = "isp预估报价单申请实体类")
public class QuoteApplyDto {
	
	@ApiModelProperty(value = "UCMP的整备单号")
	private String ucmpOrderNo;
	
	@ApiModelProperty(value = "网点类型，仅支持：SC/UC")
	private String siteType;
	
	@ApiModelProperty(value = "网点名称")
	private String siteName;
	
	@ApiModelProperty(value = "网点编码")
	private String siteCode;
	
	@ApiModelProperty(value = "车架号")
	private String vin;
	
	@ApiModelProperty(value = "车牌号")
	private String plateNo;
	
	@ApiModelProperty(value = "创建人姓名")
	private String creatorName;
	
	@ApiModelProperty(value = "创建人工号")
	private String creatorEmpId;
	
	@ApiModelProperty(value = "期望交车时间")
	private Long expectDeliveryTime;
	
	@ApiModelProperty(value = "来源,二手车:SECOND_HAND 内部车：INTERNAL_CAR")
	private String orderSource;
	
	@ApiModelProperty(value = "备注")
	private String remark;

	public String getUcmpOrderNo() {
		return ucmpOrderNo;
	}

	public void setUcmpOrderNo(String ucmpOrderNo) {
		this.ucmpOrderNo = ucmpOrderNo;
	}

	public String getSiteType() {
		return siteType;
	}

	public void setSiteType(String siteType) {
		this.siteType = siteType;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public String getSiteCode() {
		return siteCode;
	}

	public void setSiteCode(String siteCode) {
		this.siteCode = siteCode;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getPlateNo() {
		return plateNo;
	}

	public void setPlateNo(String plateNo) {
		this.plateNo = plateNo;
	}

	public String getCreatorName() {
		return creatorName;
	}

	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}

	public String getCreatorEmpId() {
		return creatorEmpId;
	}

	public void setCreatorEmpId(String creatorEmpId) {
		this.creatorEmpId = creatorEmpId;
	}

	public Long getExpectDeliveryTime() {
		return expectDeliveryTime;
	}

	public void setExpectDeliveryTime(Long expectDeliveryTime) {
		this.expectDeliveryTime = expectDeliveryTime;
	}

	public String getOrderSource() {
		return orderSource;
	}

	public void setOrderSource(String orderSource) {
		this.orderSource = orderSource;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
