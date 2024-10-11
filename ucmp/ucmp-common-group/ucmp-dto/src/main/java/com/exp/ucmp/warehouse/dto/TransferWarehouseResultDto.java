package com.exp.ucmp.warehouse.dto;

import com.egrid.core.base.model.BaseModel;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * @author GeYiJiang
 * @Description: 出入库列表结果dto
 * @date 2023/2/17 10:10
 */
@ApiModel(value = "TransferWarehouseResultDto", description = "出入库列表结果dto")
public class TransferWarehouseResultDto extends BaseModel {

    @ApiModelProperty(value = "库存id")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long stockId;

    @ApiModelProperty(value = "调拨申请id")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long transferApplyId;

    @ApiModelProperty(value = "车辆批售记录id")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long saleRecordId;

    @ApiModelProperty(value = "订单信息id")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long orderInfoId;

    @ApiModelProperty(value = "调度编号")
    private String dispatchNumber;

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

    public String getDispatchNumber() {
        return dispatchNumber;
    }

    public void setDispatchNumber(String dispatchNumber) {
        this.dispatchNumber = dispatchNumber;
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

	public String getRevertBody() {
        return revertBody;
    }

    public void setRevertBody(String revertBody) {
        this.revertBody = revertBody;
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

    public Long getTransferApplyId() {
        return transferApplyId;
    }

    public Long getSaleRecordId() {
        return saleRecordId;
    }

    public void setSaleRecordId(Long saleRecordId) {
        this.saleRecordId = saleRecordId;
    }

    public Long getStockId() {
        return stockId;
    }

    public void setStockId(Long stockId) {
        this.stockId = stockId;
    }

    public void setTransferApplyId(Long transferApplyId) {
        this.transferApplyId = transferApplyId;
    }

    public Long getOrderInfoId() {
        return orderInfoId;
    }

    public void setOrderInfoId(Long orderInfoId) {
        this.orderInfoId = orderInfoId;
    }
}
