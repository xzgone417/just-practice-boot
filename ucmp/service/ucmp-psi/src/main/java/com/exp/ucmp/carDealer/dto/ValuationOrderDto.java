package com.exp.ucmp.carDealer.dto;

import io.swagger.annotations.ApiModelProperty;

public class ValuationOrderDto {
	
	@ApiModelProperty("待接单数")
	private Integer pendingOrders;
	
	@ApiModelProperty("接单数")
	private Integer myOrders;
	
	@ApiModelProperty("未接单接单数")
	private Integer unOrders;

	public Integer getPendingOrders() {
		return pendingOrders;
	}

	public void setPendingOrders(Integer pendingOrders) {
		this.pendingOrders = pendingOrders;
	}

	public Integer getMyOrders() {
		return myOrders;
	}

	public void setMyOrders(Integer myOrders) {
		this.myOrders = myOrders;
	}

	public Integer getUnOrders() {
		return unOrders;
	}

	public void setUnOrders(Integer unOrders) {
		this.unOrders = unOrders;
	}


}
