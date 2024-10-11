package com.exp.ucmp.carDealer.dto;

import java.util.List;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SaveTransactionPriceDto", description = "保存成交价和付款凭证参数")
public class SaveTransactionPriceDto{
	
	@NotNull
	@ApiModelProperty(value = "预约ID")
	private Long reservationId;
	
	@ApiModelProperty(value = "更新人ID")
	private Long updateBy;

	@ApiModelProperty("最终成交价")
	private Double dealPriceEnd;
	
	@ApiModelProperty(value = "车辆主体")
    private String revertBody;
	
	@ApiModelProperty("付款凭证材料信息")
	private List<PicDto> picDto;

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

	public Double getDealPriceEnd() {
		return dealPriceEnd;
	}

	public void setDealPriceEnd(Double dealPriceEnd) {
		this.dealPriceEnd = dealPriceEnd;
	}

	public String getRevertBody() {
		return revertBody;
	}

	public void setRevertBody(String revertBody) {
		this.revertBody = revertBody;
	}

	public List<PicDto> getPicDto() {
		return picDto;
	}

	public void setPicDto(List<PicDto> picDto) {
		this.picDto = picDto;
	}

}
