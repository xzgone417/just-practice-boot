package com.exp.ucmp.replacement.dto;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(value = "CarStorageInfoDto", description = "车辆仓库信息")
public class CarStorageInfoDto {
	
    @ApiModelProperty(value = "最终成交价")
    private BigDecimal dealPriceEnd;

    @ApiModelProperty(value = "仓库ID")
    private Long storageId;

    @ApiModelProperty(value = "仓库名称")
    private String storageName;

    @ApiModelProperty(value = "仓库编码")
    private String storageCode;
    
    @ApiModelProperty(value = "收购订单号")
    private String businessOrderNo;

	public BigDecimal getDealPriceEnd() {
		return dealPriceEnd;
	}

	public void setDealPriceEnd(BigDecimal dealPriceEnd) {
		this.dealPriceEnd = dealPriceEnd;
	}

	public Long getStorageId() {
		return storageId;
	}

	public void setStorageId(Long storageId) {
		this.storageId = storageId;
	}

	public String getStorageName() {
		return storageName;
	}

	public void setStorageName(String storageName) {
		this.storageName = storageName;
	}

	public String getStorageCode() {
		return storageCode;
	}

	public void setStorageCode(String storageCode) {
		this.storageCode = storageCode;
	}

	public String getBusinessOrderNo() {
		return businessOrderNo;
	}

	public void setBusinessOrderNo(String businessOrderNo) {
		this.businessOrderNo = businessOrderNo;
	}

}
