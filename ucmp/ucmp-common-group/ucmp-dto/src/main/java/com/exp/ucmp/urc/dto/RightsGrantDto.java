package com.exp.ucmp.urc.dto;


import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "RightsGrantDto", description = "权益发放参数类")
public class RightsGrantDto {
	
	@NotNull(message="rightPackId不能为空")
	@ApiModelProperty(value = "权益包编号")
	private Long rightPackId;
	
	@NotNull(message="superId不能为空")
	@ApiModelProperty(value = "用户编号(superId)")
    private String superId;
	
//	@NotNull(message="idmId不能为空")
	@ApiModelProperty(value = "用户编号(idmId)")
    private String idmId;
	
	@NotNull(message="vin不能为空")
	@ApiModelProperty(value = "车辆VIN")
    private String vin;
	
	@ApiModelProperty(value = "销售订单号")
    private String orderId;
	
//	@NotNull(message="channel不能为空")
	@ApiModelProperty(value = "渠道码")
    private String channel;

	public Long getRightPackId() {
		return rightPackId;
	}

	public void setRightPackId(Long rightPackId) {
		this.rightPackId = rightPackId;
	}

	public String getSuperId() {
		return superId;
	}

	public void setSuperId(String superId) {
		this.superId = superId;
	}

	public String getIdmId() {
		return idmId;
	}

	public void setIdmId(String idmId) {
		this.idmId = idmId;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}
	
}
