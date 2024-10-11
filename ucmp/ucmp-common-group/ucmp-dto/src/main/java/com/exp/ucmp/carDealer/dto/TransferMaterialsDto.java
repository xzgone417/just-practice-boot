package com.exp.ucmp.carDealer.dto;

import java.util.List;

import com.exp.ucmp.storeApp.dto.OneselfCarPicDto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "TransferMaterialsDto", description = "过户材料")
public class TransferMaterialsDto{

	@ApiModelProperty(value = "登记证照片")
    private List<OneselfCarPicDto> registerList;
	    
    @ApiModelProperty(value = "二手车销售发票")
    private List<OneselfCarPicDto> invoicePic;

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
}

