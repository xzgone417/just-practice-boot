package com.exp.ucmp.carService.dto;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.exp.ucmp.carDealer.dto.PicDto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "OneselfPutIntoStorageDto", description = "本品收购入库参数")
public class OneselfPutIntoStorageDto{
	
	@NotNull
	@ApiModelProperty(value = "预约ID")
	private Long reservationId;
	
	@ApiModelProperty(value = "更新人ID")
	private Long updateBy;
	
	@ApiModelProperty(value = "收购状态 1104:待入库,1105:已入库")
	private String acquisitionStatus;
	
	@ApiModelProperty("最终成交价")
	private Double dealPriceEnd;
	
	@ApiModelProperty(value = "车辆主体")
    private String revertBody;

	@ApiModelProperty("付款凭证材料信息")
	private List<PicDto> picDto;
	
	@ApiModelProperty(value = "操作类型 1 入库 2 保存")
    private Integer operationType = 2; 

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

	public String getAcquisitionStatus() {
		return acquisitionStatus;
	}

	public void setAcquisitionStatus(String acquisitionStatus) {
		this.acquisitionStatus = acquisitionStatus;
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

	public Integer getOperationType() {
		return operationType;
	}

	public void setOperationType(Integer operationType) {
		this.operationType = operationType;
	}

}
