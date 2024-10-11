package com.exp.ucmp.storeApp.dto;


import com.exp.ucmp.carDealer.dto.AcquisitionMaterialsDto;
import com.exp.ucmp.carDealer.dto.TransferMaterialsDto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "OneselfOrderPicsDto", description = "本品订单材料信息")
public class OneselfOrderPicsDto {
	
    @ApiModelProperty(value = "合同材料")
    private AcquisitionMaterialsDto acquisitionMaterialsDto;
    
    @ApiModelProperty(value = "车辆材料")
    private TransferMaterialsDto transferMaterialsDto;

	public AcquisitionMaterialsDto getAcquisitionMaterialsDto() {
		return acquisitionMaterialsDto;
	}

	public void setAcquisitionMaterialsDto(AcquisitionMaterialsDto acquisitionMaterialsDto) {
		this.acquisitionMaterialsDto = acquisitionMaterialsDto;
	}

	public TransferMaterialsDto getTransferMaterialsDto() {
		return transferMaterialsDto;
	}

	public void setTransferMaterialsDto(TransferMaterialsDto transferMaterialsDto) {
		this.transferMaterialsDto = transferMaterialsDto;
	}
    
}
