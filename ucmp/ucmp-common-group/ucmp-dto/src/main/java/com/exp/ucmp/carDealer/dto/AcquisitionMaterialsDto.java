package com.exp.ucmp.carDealer.dto;

import java.util.List;

import com.exp.ucmp.storeApp.dto.OneselfCarPicDto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "AcquisitionMaterialsDto", description = "收购材料")
public class AcquisitionMaterialsDto{
	
	@ApiModelProperty("最终成交价")
	private Double dealPriceEnd;
	
	@ApiModelProperty(value = "车辆主体")
    private String revertBody;
	
	@ApiModelProperty("付款凭证材料信息")
	private List<OneselfCarPicDto> paymentEvidenceList;

	@ApiModelProperty(value = "合同材料")
    private List<OneselfCarPicDto> contractList;
    
    @ApiModelProperty(value = "车辆材料")
    private List<OneselfCarPicDto> carList;
    
    @ApiModelProperty(value = "车辆照片")
    private List<OneselfCarPicDto> carPicList;
    
    @ApiModelProperty(value = "随车附件")
    private List<OneselfCarPicDto> attachmentList;

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

	public List<OneselfCarPicDto> getPaymentEvidenceList() {
		return paymentEvidenceList;
	}

	public void setPaymentEvidenceList(List<OneselfCarPicDto> paymentEvidenceList) {
		this.paymentEvidenceList = paymentEvidenceList;
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
    
}

