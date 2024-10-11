package com.exp.ucmp.carDealer.dto;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "AllotDeliveryCenterDto", description = "分配交付中心参数类")
public class AllotDeliveryCenterDto{
	
	@NotNull
    @ApiModelProperty(value = "交付中心ID")
    private String storeId;
    
	@NotNull
    @ApiModelProperty(value = "置换预约ID")
    private Long reservationId;
	
	@ApiModelProperty(value = "修改人")
	private Long updateBy;
	
	@ApiModelProperty(value = "交付顾问 不用传")
	private Long deliveryPerson;

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}

	public Long getReservationId() {
		return reservationId;
	}

	public void setReservationId(Long reservationId) {
		this.reservationId = reservationId;
	}

	public Long getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(Long updateBy) {
		this.updateBy = updateBy;
	}

	public Long getDeliveryPerson() {
		return deliveryPerson;
	}

	public void setDeliveryPerson(Long deliveryPerson) {
		this.deliveryPerson = deliveryPerson;
	}
    
    
}
