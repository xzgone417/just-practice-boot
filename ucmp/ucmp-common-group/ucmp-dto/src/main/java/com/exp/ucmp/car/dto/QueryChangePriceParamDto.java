package com.exp.ucmp.car.dto;

import com.exp.ucmp.PageDto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "QueryChangePriceParamDto", description = "查询改价审批参数类")
public class QueryChangePriceParamDto extends PageDto{
	
	@ApiModelProperty(value = "vin码")
	private String vin;
	
	@ApiModelProperty(value = "工程车型code")
	private String carSeriesCode;

	@ApiModelProperty(value = "基础车型code")
	private String baseCarTypeCode;
	
	@ApiModelProperty(value = "审批状态 0 待审批 1 审批通过 2 审批驳回")
    private Integer approveStatus;

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getCarSeriesCode() {
		return carSeriesCode;
	}

	public void setCarSeriesCode(String carSeriesCode) {
		this.carSeriesCode = carSeriesCode;
	}

	public String getBaseCarTypeCode() {
		return baseCarTypeCode;
	}

	public void setBaseCarTypeCode(String baseCarTypeCode) {
		this.baseCarTypeCode = baseCarTypeCode;
	}

	public Integer getApproveStatus() {
		return approveStatus;
	}

	public void setApproveStatus(Integer approveStatus) {
		this.approveStatus = approveStatus;
	}
	
}
