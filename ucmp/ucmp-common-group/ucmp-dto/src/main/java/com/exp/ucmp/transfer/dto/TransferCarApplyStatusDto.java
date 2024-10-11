package com.exp.ucmp.transfer.dto;

import com.egrid.core.base.model.BaseModel;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author GeYiJiang
 * @Description: 调拨发运状态
 * @date 2023/2/13 13:51
 */
@ApiModel(value = "TransferCarApplyResultDto", description = "调拨发运状态查询结果")
public class TransferCarApplyStatusDto extends BaseModel {

    @ApiModelProperty(value = "调度编号")
    private String dispatchNumber;

    @ApiModelProperty(value = "所在仓储点id")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long storageId;

    @ApiModelProperty(value = "所在仓储点")
    private String storageName;

    @ApiModelProperty(value = "调往仓储点id")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long transferStorageId;

    @ApiModelProperty(value = "调往仓储点")
    private String transferStorageName;

    @ApiModelProperty(value = "vin")
    private String vinCode;

    @ApiModelProperty(value = "车辆来源")
    private String carSource;

    @ApiModelProperty(value = "调拨状态(00:待发运/01:已调度/02:待发运出库/03:已出库/04:运输中/05:到达待入库/06:已入库/07:等待取消中/08:已取消)")
    private String transferStatus;

    @ApiModelProperty(value = "库存类型")
    private String stockType;

    @ApiModelProperty(value = "收入价格")
    private BigDecimal purchasePrice;

    @ApiModelProperty(value = "车龄(天)")
    private Integer carAge;

    @ApiModelProperty(value = "库龄(天)")
    private Integer stockAge;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "新车开票日")
    private Date invoicingDate;

    @ApiModelProperty(value = "调拨类型")
    private String transferType;

    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "调度申请id")
    private Long transferApplyId;

    @ApiModelProperty(value = "库存车辆id")
    private Long stockId;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "调拨入库时间")
    private Date warehousDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "入库时间")
    private Date outDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "调拨出库时间")
    private Date deliveryTime;

    @ApiModelProperty(value = "工程车型")
    private String carSeriesName;

    @ApiModelProperty(value = "基础车型")
    private String baseCarTypeName;

    @ApiModelProperty(value = "外色")
    private String carColour;

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

    public Long getStorageId() {
        return storageId;
    }

    public void setStorageId(Long storageId) {
        this.storageId = storageId;
    }

    public Long getTransferStorageId() {
        return transferStorageId;
    }

    public void setTransferStorageId(Long transferStorageId) {
        this.transferStorageId = transferStorageId;
    }

    public String getTransferStatus() {
        return transferStatus;
    }

    public void setTransferStatus(String transferStatus) {
        this.transferStatus = transferStatus;
    }

    public String getTransferType() {
        return transferType;
    }

    public void setTransferType(String transferType) {
        this.transferType = transferType;
    }

    public Long getTransferApplyId() {
        return transferApplyId;
    }

    public void setTransferApplyId(Long transferApplyId) {
        this.transferApplyId = transferApplyId;
    }

    public Long getStockId() {
        return stockId;
    }

    public void setStockId(Long stockId) {
        this.stockId = stockId;
    }

    public Date getWarehousDate() {
        return warehousDate;
    }

    public void setWarehousDate(Date warehousDate) {
        this.warehousDate = warehousDate;
    }

    public String getDispatchNumber() {
        return dispatchNumber;
    }

    public void setDispatchNumber(String dispatchNumber) {
        this.dispatchNumber = dispatchNumber;
    }

    public String getVinCode() {
        return vinCode;
    }

    public void setVinCode(String vinCode) {
        this.vinCode = vinCode;
    }

    public String getStockType() {
        return stockType;
    }

    public void setStockType(String stockType) {
        this.stockType = stockType;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Integer getCarAge() {
        return carAge;
    }

    public void setCarAge(Integer carAge) {
        this.carAge = carAge;
    }

    public Integer getStockAge() {
        return stockAge;
    }

    public void setStockAge(Integer stockAge) {
        this.stockAge = stockAge;
    }

    public Date getInvoicingDate() {
        return invoicingDate;
    }

    public Date getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public void setInvoicingDate(Date invoicingDate) {
        this.invoicingDate = invoicingDate;
    }

    public String getStorageName() {
        return storageName;
    }

    public void setStorageName(String storageName) {
        this.storageName = storageName;
    }

    public String getTransferStorageName() {
        return transferStorageName;
    }

    public void setTransferStorageName(String transferStorageName) {
        this.transferStorageName = transferStorageName;
    }

    public String getCarSource() {
        return carSource;
    }

    public void setCarSource(String carSource) {
        this.carSource = carSource;
    }

    public Date getOutDate() {
        return outDate;
    }

    public void setOutDate(Date outDate) {
        this.outDate = outDate;
    }
}
