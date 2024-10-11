package com.exp.ucmp.servicing.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "OrderDetailDto", description = "isp报价单申请返回类")
public class OrderDetailDto {
	
	@ApiModelProperty(value = "维修项目")
    private List<OrderMaintenanceItemsDto> maintenanceItems;
	
	@ApiModelProperty(value = "维修配件")
    private List<OrderPartsDto> parts;
	
	@ApiModelProperty(value = "其他费用")
    private List<OrderAdditionalItemsDto> additionalItems;
	
    @ApiModelProperty(value = "维修工单号")
    private String workOrderNo;
    
    @ApiModelProperty(value = "工单总价")
	private Double orderTotalPrice;
    
    @ApiModelProperty(value = "项目总价")
	private Double itemsTotalPrice;
    
    @ApiModelProperty(value = "配件总价")
	private Double partsTotalPrice;
    
    @ApiModelProperty(value = "其他费用总价")
	private Double addTotalPrice;

	public List<OrderMaintenanceItemsDto> getMaintenanceItems() {
		return maintenanceItems;
	}

	public void setMaintenanceItems(List<OrderMaintenanceItemsDto> maintenanceItems) {
		this.maintenanceItems = maintenanceItems;
	}

	public List<OrderPartsDto> getParts() {
		return parts;
	}

	public void setParts(List<OrderPartsDto> parts) {
		this.parts = parts;
	}

	public List<OrderAdditionalItemsDto> getAdditionalItems() {
		return additionalItems;
	}

	public void setAdditionalItems(List<OrderAdditionalItemsDto> additionalItems) {
		this.additionalItems = additionalItems;
	}

	public String getWorkOrderNo() {
		return workOrderNo;
	}

	public void setWorkOrderNo(String workOrderNo) {
		this.workOrderNo = workOrderNo;
	}

	public Double getOrderTotalPrice() {
		return orderTotalPrice;
	}

	public void setOrderTotalPrice(Double orderTotalPrice) {
		this.orderTotalPrice = orderTotalPrice;
	}

	public Double getItemsTotalPrice() {
		return itemsTotalPrice;
	}

	public void setItemsTotalPrice(Double itemsTotalPrice) {
		this.itemsTotalPrice = itemsTotalPrice;
	}

	public Double getPartsTotalPrice() {
		return partsTotalPrice;
	}

	public void setPartsTotalPrice(Double partsTotalPrice) {
		this.partsTotalPrice = partsTotalPrice;
	}

	public Double getAddTotalPrice() {
		return addTotalPrice;
	}

	public void setAddTotalPrice(Double addTotalPrice) {
		this.addTotalPrice = addTotalPrice;
	}

}
