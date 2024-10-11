package com.exp.ucmp.warehouse.dto;

import com.egrid.core.base.model.BaseModel;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * @author hailele
 * @Description: 验收入库列表结果dto
 * @date 2023/2/20 10:10
 */
@ApiModel(value = "CheckWarehouseResultDto", description = "验收入库列表结果dto")
public class CheckWarehouseResultDto extends BaseModel {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("整备信息id")
    @JsonSerialize(using = ToStringSerializer.class)
    private String serviceId;

    @ApiModelProperty("库存id")
    private String stockId;

    @ApiModelProperty("整备单号")
    private String serviceNumber;

    @ApiModelProperty("仓储点名称")
    private String storageName;

    @ApiModelProperty("库存类型")
    private String stockType;

    @ApiModelProperty("归属主体")
    private String revertBody;
    
    @ApiModelProperty("库存类型名称")
    private String stockTypeName;

    @ApiModelProperty("归属主体名称")
    private String revertBodyName;

    @ApiModelProperty("VIN")
    private String vinCode;

    @ApiModelProperty("采购价格/收入价")
    private BigDecimal purchasePrice;

    @ApiModelProperty("工程车型名称")
    private String carSeriesName;

    @ApiModelProperty("基础车型名称")
    private String baseCarTypeName;

    @ApiModelProperty("外色")
    private String carColour;

    @ApiModelProperty("整备单状态")
    private String serviceState;

    public String getStockId() {
        return stockId;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceNumber() {
        return serviceNumber;
    }

    public void setServiceNumber(String serviceNumber) {
        this.serviceNumber = serviceNumber;
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

    public String getServiceState() {
        return serviceState;
    }

    public void setServiceState(String serviceState) {
        this.serviceState = serviceState;
    }

    public void setCarColour(String carColour) {
        this.carColour = carColour;
    }

}
