package com.exp.ucmp.carDealer.dto;

import io.swagger.annotations.ApiModelProperty;

public class OfferFollowDto {
	
	@ApiModelProperty("待报价数")
	private Integer pendingOffers;
	
	@ApiModelProperty("接单数")
	private Integer myOffers;
	
	@ApiModelProperty("未报价数")
	private Integer unOffers;

	public Integer getPendingOffers() {
		return pendingOffers;
	}

	public void setPendingOffers(Integer pendingOffers) {
		this.pendingOffers = pendingOffers;
	}

	public Integer getMyOffers() {
		return myOffers;
	}

	public void setMyOffers(Integer myOffers) {
		this.myOffers = myOffers;
	}

	public Integer getUnOffers() {
		return unOffers;
	}

	public void setUnOffers(Integer unOffers) {
		this.unOffers = unOffers;
	}



}
