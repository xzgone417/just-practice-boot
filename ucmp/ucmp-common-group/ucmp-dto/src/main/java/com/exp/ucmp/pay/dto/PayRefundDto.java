package com.exp.ucmp.pay.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "PayRefundDto", description = "退款参数类")
public class PayRefundDto {
	
	@ApiModelProperty(value = "订单号")
	private String orderNo;
	
	@ApiModelProperty(value = "退款金额 部分退款时候使用，分为单位")
	private String fee;
	
	@ApiModelProperty(value = "扩展字段")
	private String ext;
	
	@ApiModelProperty(value = "车辆主体code")
	private String revertBody;

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getFee() {
		return fee;
	}

	public void setFee(String fee) {
		this.fee = fee;
	}

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

	public String getRevertBody() {
		return revertBody;
	}

	public void setRevertBody(String revertBody) {
		this.revertBody = revertBody;
	}
	
}
