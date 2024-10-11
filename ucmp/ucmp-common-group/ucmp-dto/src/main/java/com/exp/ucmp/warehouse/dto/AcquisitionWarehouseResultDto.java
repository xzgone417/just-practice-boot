package com.exp.ucmp.warehouse.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * <p>@ClassName: AcquisitionWarehouseResultDto</p>
 * <p>@Description: </p>
 * <p>@Author: fxy</p>
 * <p>@Date: 2023/6/9 14:11<p>
 */
@ApiModel(value = "AcquisitionWarehouseResultDto", description = "收购入库列表结果dto")
public class AcquisitionWarehouseResultDto {


    @ApiModelProperty(value = "业务单号")
    private String businessOrderNo;

    @ApiModelProperty(value = "库存id")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long stockId;

    @ApiModelProperty(value = "所在仓储点")
    private String storageName;

    @ApiModelProperty(value = "库存类型")
    private String stockType;

    @ApiModelProperty(value = "归属主体")
    private String revertBody;
    
    @ApiModelProperty(value = "库存类型名称")
    private String stockTypeName;

    @ApiModelProperty(value = "归属主体名称")
    private String revertBodyName;

    @ApiModelProperty(value = "vin")
    private String vinCode;

    @ApiModelProperty(value = "采购价格")
    private BigDecimal purchasePrice;

    @ApiModelProperty(value = "工程车型")
    private String carSeriesName;

    @ApiModelProperty(value = "基础车型")
    private String baseCarTypeName;

    @ApiModelProperty(value = "外色")
    private String carColour;

    public String getBusinessOrderNo() {
        return businessOrderNo;
    }

    public void setBusinessOrderNo(String businessOrderNo) {
        this.businessOrderNo = businessOrderNo;
    }

    public Long getStockId() {
        return stockId;
    }

    public void setStockId(Long stockId) {
        this.stockId = stockId;
    }

    public String getStorageName() {
        return storageName;
    }

    public void setStorageName(String storageName) {
        this.storageName = storageName;
    }

    public String getStockType() {
        return stockType;
    }

    public void setStockType(String stockType) {
        this.stockType = stockType;
    }

    public String getRevertBody() {
        return revertBody;
    }

    public void setRevertBody(String revertBody) {
        this.revertBody = revertBody;
    }

    public String getStockTypeName() {
		return stockTypeName;
	}

	public void setStockTypeName(String stockTypeName) {
		this.stockTypeName = stockTypeName;
	}

	public String getRevertBodyName() {
		return revertBodyName;
	}

	public void setRevertBodyName(String revertBodyName) {
		this.revertBodyName = revertBodyName;
	}

	public String getVinCode() {
        return vinCode;
    }

    public void setVinCode(String vinCode) {
        this.vinCode = vinCode;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public String getCarSeriesName() {
        return carSeriesName;
    }

    public void setCarSeriesName(String carSeriesName) {
        this.carSeriesName = carSeriesName;
    }

    public String getBaseCarTypeName() {
        return baseCarTypeName;
    }

    public void setBaseCarTypeName(String baseCarTypeName) {
        this.baseCarTypeName = baseCarTypeName;
    }

    public String getCarColour() {
        return carColour;
    }

    public void setCarColour(String carColour) {
        this.carColour = carColour;
    }
}
