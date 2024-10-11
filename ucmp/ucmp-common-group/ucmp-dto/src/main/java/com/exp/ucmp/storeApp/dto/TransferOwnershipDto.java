package com.exp.ucmp.storeApp.dto;


import java.util.List;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "TransferOwnershipDto", description = "过户参数")
public class TransferOwnershipDto {
	
	@NotNull
	@ApiModelProperty(value = "预约ID")
	private Long reservationId;
	
	@ApiModelProperty(value = "更新人ID")
	private Long updateBy;
	
    @ApiModelProperty(value = "登记证照片")
    private List<OneselfCarPicDto> registerList;
    
    @ApiModelProperty(value = "二手车销售发票")
    private List<OneselfCarPicDto> invoicePic;
    
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

	public List<OneselfCarPicDto> getRegisterList() {
		return registerList;
	}

	public void setRegisterList(List<OneselfCarPicDto> registerList) {
		this.registerList = registerList;
	}

	public List<OneselfCarPicDto> getInvoicePic() {
		return invoicePic;
	}

	public void setInvoicePic(List<OneselfCarPicDto> invoicePic) {
		this.invoicePic = invoicePic;
	}

	public Integer getOperationType() {
		return operationType;
	}

	public void setOperationType(Integer operationType) {
		this.operationType = operationType;
	}
}
