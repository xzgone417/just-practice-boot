package com.exp.ucmp.salesDelivery.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "DeliveryOrderDto", description = "二手车销售交付列表数据")
public class DeliveryOrderDto {
	
	@ApiModelProperty(value = "业务单号")
	private String businessOrderNo;
	
	@ApiModelProperty(value = "车辆vin码")
	private String vin;
	
	@ApiModelProperty(value = "客户手机号")
	private String customerIphone;
	
	@ApiModelProperty(value = "密文手机号")
    private String enCustomerIphone;
	
	@ApiModelProperty(value = "客户姓名")
	private String customerName;
	
	@ApiModelProperty(value = "订单状态 7409 已转交付待分配;7403、7408 已转交付待全款;7404、7405已全款待交付;7406 已交付")
	private String status;
	
	@ApiModelProperty(value = "订单状态名称")
	private String statusName;

	@ApiModelProperty(value = "订单id")
	private Long orderInfoId;
	
	@ApiModelProperty(value = "是否可以跟进 1 可以 2 不可以")
	private Integer isFollow;
	
	public String getBusinessOrderNo() {
		return businessOrderNo;
	}

	public void setBusinessOrderNo(String businessOrderNo) {
		this.businessOrderNo = businessOrderNo;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getCustomerIphone() {
		return customerIphone;
	}

	public void setCustomerIphone(String customerIphone) {
		this.customerIphone = customerIphone;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getEnCustomerIphone() {
		return enCustomerIphone;
	}

	public void setEnCustomerIphone(String enCustomerIphone) {
		this.enCustomerIphone = enCustomerIphone;
	}

	public Long getOrderInfoId() {
		return orderInfoId;
	}

	public void setOrderInfoId(Long orderInfoId) {
		this.orderInfoId = orderInfoId;
	}

	public Integer getIsFollow() {
		return isFollow;
	}

	public void setIsFollow(Integer isFollow) {
		this.isFollow = isFollow;
	}

}
