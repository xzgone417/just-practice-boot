package com.exp.ucmp.car.dto;

import com.exp.ucmp.clues.dto.OrderChangePriceDto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ChangePriceDetailDto", description = "查询改价信息返回类")
public class ChangePriceDetailDto {
	
	@ApiModelProperty(value = "库存车辆基本信息")
    private CarMainInfoDto carMainInfoDto;
	
	@ApiModelProperty(value = "改价记录")
    private OrderChangePriceDto orderChangePriceDto;

	public CarMainInfoDto getCarMainInfoDto() {
		return carMainInfoDto;
	}

	public void setCarMainInfoDto(CarMainInfoDto carMainInfoDto) {
		this.carMainInfoDto = carMainInfoDto;
	}

	public OrderChangePriceDto getOrderChangePriceDto() {
		return orderChangePriceDto;
	}

	public void setOrderChangePriceDto(OrderChangePriceDto orderChangePriceDto) {
		this.orderChangePriceDto = orderChangePriceDto;
	}


}
