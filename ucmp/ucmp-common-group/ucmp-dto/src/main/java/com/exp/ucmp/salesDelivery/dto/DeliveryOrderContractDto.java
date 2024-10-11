package com.exp.ucmp.salesDelivery.dto;


import java.util.List;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "DeliveryOrderContractDto", description = "销售交付订单合同材料参数")
public class DeliveryOrderContractDto {
	
	@NotNull
	@ApiModelProperty(value = "订单ID")
	private Long orderInfoId;
	
	@ApiModelProperty(value = "更新人ID 不用传")
	private Long updateBy;
	
	@NotNull
	@ApiModelProperty(value = "合同材料")
    private List<DeliveryOrderPicDto> contractList;

	public Long getOrderInfoId() {
		return orderInfoId;
	}

	public void setOrderInfoId(Long orderInfoId) {
		this.orderInfoId = orderInfoId;
	}

	public Long getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(Long updateBy) {
		this.updateBy = updateBy;
	}

	public List<DeliveryOrderPicDto> getContractList() {
		return contractList;
	}

	public void setContractList(List<DeliveryOrderPicDto> contractList) {
		this.contractList = contractList;
	}
    
}
