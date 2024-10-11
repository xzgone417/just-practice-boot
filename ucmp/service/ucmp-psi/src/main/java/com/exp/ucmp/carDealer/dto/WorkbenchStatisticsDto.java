package com.exp.ucmp.carDealer.dto;


import com.egrid.core.base.model.BaseModel;

import io.swagger.annotations.ApiModelProperty;

public class WorkbenchStatisticsDto extends BaseModel{

	/**
	 * <p>Field serialVersionUID: 序列化ID</p>
	 */
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "人员id")
	private Long partyId;
	
	@ApiModelProperty(value = "人员姓名")
	private String personName;
	
	@ApiModelProperty(value = "估价接单数据统计")
	private ValuationOrderDto order;
	
	@ApiModelProperty(value = "报价跟进数据统计")
	private OfferFollowDto offer;
	
	@ApiModelProperty(value = "收购跟进数据统计")
	private AcquisitionFollowDto acquisition;
	
	@ApiModelProperty(value = "待重新上传审核材料的数量")
	private Integer rejected;

	public Long getPartyId() {
		return partyId;
	}

	public void setPartyId(Long partyId) {
		this.partyId = partyId;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public ValuationOrderDto getOrder() {
		return order;
	}

	public void setOrder(ValuationOrderDto order) {
		this.order = order;
	}

	public OfferFollowDto getOffer() {
		return offer;
	}

	public void setOffer(OfferFollowDto offer) {
		this.offer = offer;
	}

	public AcquisitionFollowDto getAcquisition() {
		return acquisition;
	}

	public void setAcquisition(AcquisitionFollowDto acquisition) {
		this.acquisition = acquisition;
	}
}
