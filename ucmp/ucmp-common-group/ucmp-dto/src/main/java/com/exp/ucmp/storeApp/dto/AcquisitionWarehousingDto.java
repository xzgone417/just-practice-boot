package com.exp.ucmp.storeApp.dto;


import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "AcquisitionWarehousingDto", description = "收购入库参数")
public class AcquisitionWarehousingDto {
	
	@NotNull
	@ApiModelProperty(value = "预约ID")
	private Long reservationId;
	
	@ApiModelProperty(value = "更新人ID")
	private Long updateBy;
	
	@NotNull
	@ApiModelProperty(value = "预计过户时间")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String estimatedTransferTime;
	
	@NotNull
	@ApiModelProperty(value = "入库仓储点ID")
	private Long storageId;
	
	@NotNull
	@ApiModelProperty(value = "合同材料")
    private List<OneselfCarPicDto> contractList;
    
	@NotNull
    @ApiModelProperty(value = "车辆材料")
    private List<OneselfCarPicDto> carList;
    
	@NotNull
    @ApiModelProperty(value = "车辆照片")
    private List<OneselfCarPicDto> carPicList;
    
    @ApiModelProperty(value = "随车附件")
    private List<OneselfCarPicDto> attachmentList;
    
    @ApiModelProperty(value = "操作类型 1 提交 2 保存")
    private Integer operationType = 1;

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

	public String getEstimatedTransferTime() {
		return estimatedTransferTime;
	}

	public void setEstimatedTransferTime(String estimatedTransferTime) {
		this.estimatedTransferTime = estimatedTransferTime;
	}

	public Long getStorageId() {
		return storageId;
	}

	public void setStorageId(Long storageId) {
		this.storageId = storageId;
	}

	public List<OneselfCarPicDto> getContractList() {
		return contractList;
	}

	public void setContractList(List<OneselfCarPicDto> contractList) {
		this.contractList = contractList;
	}

	public List<OneselfCarPicDto> getCarList() {
		return carList;
	}

	public void setCarList(List<OneselfCarPicDto> carList) {
		this.carList = carList;
	}

	public List<OneselfCarPicDto> getCarPicList() {
		return carPicList;
	}

	public void setCarPicList(List<OneselfCarPicDto> carPicList) {
		this.carPicList = carPicList;
	}

	public List<OneselfCarPicDto> getAttachmentList() {
		return attachmentList;
	}

	public void setAttachmentList(List<OneselfCarPicDto> attachmentList) {
		this.attachmentList = attachmentList;
	}

	public Integer getOperationType() {
		return operationType;
	}

	public void setOperationType(Integer operationType) {
		this.operationType = operationType;
	}
}
