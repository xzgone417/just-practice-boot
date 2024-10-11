package com.exp.ucmp.carService.dto;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.exp.ucmp.carDealer.dto.PicDto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "OneselfApproveDto", description = "本品收购审批参数")
public class OneselfApproveDto{
	
	@NotNull
	@ApiModelProperty(value = "预约ID")
	private Long reservationId;
	
	@ApiModelProperty(value = "更新人ID")
	private Long updateBy;
	
	@NotNull
	@ApiModelProperty(value = "审批状态 审批驳回:1305,审批通过:传1304,审核关闭:1309")
	private String approveStatus;
	
	@ApiModelProperty(value = "收购状态 1104:待入库,1105:已入库")
	private String acquisitionStatus;
	
	@ApiModelProperty(value = "材料状态：1501、待上传，1502、重新上传，1503、已上传")
	private String materialStatus;
	
	@ApiModelProperty(value = "驳回（关闭）原因")
	private String reason;
	
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

	public String getApproveStatus() {
		return approveStatus;
	}

	public void setApproveStatus(String approveStatus) {
		this.approveStatus = approveStatus;
	}

	public String getAcquisitionStatus() {
		return acquisitionStatus;
	}

	public void setAcquisitionStatus(String acquisitionStatus) {
		this.acquisitionStatus = acquisitionStatus;
	}

	public String getMaterialStatus() {
		return materialStatus;
	}

	public void setMaterialStatus(String materialStatus) {
		this.materialStatus = materialStatus;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
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
