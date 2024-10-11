package com.exp.ucmp.servicing.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "OrderMaintenanceItemsDto", description = "维修项目")
public class OrderMaintenanceItemsDto {
	
	@ApiModelProperty(value = "项目代码")
    private String code;
	
	@ApiModelProperty(value = "项目名称")
    private String name;
	
	@ApiModelProperty(value = "工时单价")
    private Double manHour;
	
	@ApiModelProperty(value = "标准工时")
	private Float stdTime;
	
	@ApiModelProperty(value = "工时费")
    private Double manHourFee;
	
	@ApiModelProperty(value = "总价")
	private Double totalPrice;
	
	@ApiModelProperty(value = "应收金额")
    private Double receivePrice;

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

	public Double getManHour() {
		return manHour;
	}

	public void setManHour(Double manHour) {
		this.manHour = manHour;
	}

	public Float getStdTime() {
		return stdTime;
	}

	public void setStdTime(Float stdTime) {
		this.stdTime = stdTime;
	}

	public Double getManHourFee() {
		return manHourFee;
	}

	public void setManHourFee(Double manHourFee) {
		this.manHourFee = manHourFee;
	}

	public Double getReceivePrice() {
		return receivePrice;
	}

	public void setReceivePrice(Double receivePrice) {
		this.receivePrice = receivePrice;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
}
