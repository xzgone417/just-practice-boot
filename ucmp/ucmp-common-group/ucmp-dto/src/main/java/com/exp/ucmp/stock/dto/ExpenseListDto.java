/*
 * Copyright (C) 2013 SHANGHAI VOLKSWAGEN, All rights reserved.
 * License version 1.0, a copy of which has been included with this.
 * @File  name: com.svw.newsvwuc.auth.modules.dlrauth.dto.AuthVo
 * @Create  on: 2021/11/2
 * @Author    : hong
 */
package com.exp.ucmp.stock.dto;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.egrid.core.base.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;


@ApiModel(value = "ExpenseListDto对象", description = "车辆费用清单信息")
public class ExpenseListDto extends BaseModel {
    @ApiModelProperty(value = "库存车辆id")
    @ExcelIgnore
    private String stockId;

    @ApiModelProperty(value = "仓储点")
    @ExcelProperty(value = "仓储点")
    private String storageName;

    @ApiModelProperty(value = "车辆来源")
    @ExcelProperty(value = "车辆来源")
    private String carSource;

    @ApiModelProperty(value = "库存类型")
    @ExcelProperty(value = "库存类型")
    private String stockType;

    @ApiModelProperty(value = "决策类型")
    @ExcelProperty(value = "决策类型")
    private String decisionType;

    @ApiModelProperty(value = "车源批次")
    @ExcelProperty(value = "车源批次")
    private String sourceBatch;

    @ApiModelProperty(value = "归属主体")
    @ExcelProperty(value = "归属主体")
    private String revertBody;

    @ApiModelProperty(value = "vin")
    @ExcelProperty(value = "vin")
    private String vin;

    @ApiModelProperty(value = "工程车型")
    @ExcelProperty(value = "工程车型")
    private String carSeriesName;

    @ApiModelProperty(value = "基础车型")
    @ExcelProperty(value = "基础车型")
    private String baseCarTypeName;

    @ApiModelProperty(value = "外色")
    @ExcelProperty(value = "外色")
    private String carColour;

    @ApiModelProperty(value = "收入价格")
    @ExcelProperty(value = "收入价格")
    private BigDecimal purchasePrice;

//    @ApiModelProperty(value = "整备价格")
//    @ExcelProperty(value = "整备价格")
//    private BigDecimal totalPrice;

    @ApiModelProperty(value = "美容款")
    @ExcelProperty(value = "美容款")
    private BigDecimal facialCost;

    @ApiModelProperty(value = "物流费用")
    @ExcelProperty(value = "物流费用")
    private BigDecimal logisticsCost;

    @ApiModelProperty(value = "检测费用")
    @ExcelProperty(value = "检测费用")
    private BigDecimal testCost;

    @ApiModelProperty(value = "保全费用")
    @ExcelProperty(value = "保全费用")
    private BigDecimal retainCost;

    @ApiModelProperty(value = "亲善费用")
    @ExcelProperty(value = "亲善费用")
    private BigDecimal friendlyCost;

    @ApiModelProperty(value = "权益")
    @ExcelProperty(value = "权益")
    private BigDecimal rightCost;

    @ApiModelProperty(value = "贴息")
    @ExcelProperty(value = "贴息")
    private BigDecimal interestCost;

    @ApiModelProperty(value = "礼品")
    @ExcelProperty(value = "礼品")
    private BigDecimal giftCost;

    @ApiModelProperty(value = "佣金")
    @ExcelProperty(value = "佣金")
    private BigDecimal brokerageCost;

    @ApiModelProperty(value = "其他")
    @ExcelProperty(value = "其他")
    private BigDecimal otherCost;


    @ApiModelProperty(value = "费用信息id")
//    @ExcelProperty(value = "费用信息ID")
    private Long costInfoId;

    @ApiModelProperty(value = "销售出库时间")
    @ExcelProperty(value = "销售出库时间")
    private Date checkoutDate;

    @ApiModelProperty(value = "收入价格")
    @ExcelProperty(value = "收入价格")
    private BigDecimal incomePrice;

    @ApiModelProperty(value = "整备价格")
    @ExcelProperty(value = "整备价格")
    private BigDecimal serviceCost;

    @ApiModelProperty(value = "售出价格")
    @ExcelProperty(value = "售出价格")
    private BigDecimal sellPrice;

//    @ApiModelProperty(value = "售出价格")
//    @ExcelProperty(value = "售出价格")
//    private BigDecimal soldPrice;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ApiModelProperty(value = "入库日期")
    @ExcelProperty(value = "入库日期")
    private Date warehousDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ApiModelProperty(value = "销售出库日期")
    @ExcelProperty(value = "销售出库日期")
    private Date deliverDate;
//
//    @ApiModelProperty(value = "批售价格")
//    @ExcelIgnore
//    private BigDecimal wholesalePrice;

//    @ApiModelProperty(value = "车辆最终销售价")
//    @ExcelIgnore
//    private BigDecimal finalSalesPrice;

    public BigDecimal getFacialCost() {
        return facialCost;
    }

    public void setFacialCost(BigDecimal facialCost) {
        this.facialCost = facialCost;
    }

    public BigDecimal getLogisticsCost() {
        return logisticsCost;
    }

    public void setLogisticsCost(BigDecimal logisticsCost) {
        this.logisticsCost = logisticsCost;
    }

    public BigDecimal getTestCost() {
        return testCost;
    }

    public void setTestCost(BigDecimal testCost) {
        this.testCost = testCost;
    }

    public BigDecimal getRetainCost() {
        return retainCost;
    }

    public void setRetainCost(BigDecimal retainCost) {
        this.retainCost = retainCost;
    }

    public BigDecimal getFriendlyCost() {
        return friendlyCost;
    }

    public void setFriendlyCost(BigDecimal friendlyCost) {
        this.friendlyCost = friendlyCost;
    }

    public BigDecimal getRightCost() {
        return rightCost;
    }

    public void setRightCost(BigDecimal rightCost) {
        this.rightCost = rightCost;
    }

    public BigDecimal getInterestCost() {
        return interestCost;
    }

    public void setInterestCost(BigDecimal interestCost) {
        this.interestCost = interestCost;
    }

    public BigDecimal getGiftCost() {
        return giftCost;
    }

    public void setGiftCost(BigDecimal giftCost) {
        this.giftCost = giftCost;
    }

    public BigDecimal getBrokerageCost() {
        return brokerageCost;
    }

    public void setBrokerageCost(BigDecimal brokerageCost) {
        this.brokerageCost = brokerageCost;
    }

    public BigDecimal getOtherCost() {
        return otherCost;
    }

    public void setOtherCost(BigDecimal otherCost) {
        this.otherCost = otherCost;
    }

    public String getStockId() {
        return stockId;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId;
    }

    public String getStorageName() {
        return storageName;
    }

    public void setStorageName(String storageName) {
        this.storageName = storageName;
    }

    public String getCarSource() {
        return carSource;
    }

    public void setCarSource(String carSource) {
        this.carSource = carSource;
    }

    public String getStockType() {
        return stockType;
    }

    public void setStockType(String stockType) {
        this.stockType = stockType;
    }

    public String getDecisionType() {
        return decisionType;
    }

    public void setDecisionType(String decisionType) {
        this.decisionType = decisionType;
    }

    public String getSourceBatch() {
        return sourceBatch;
    }

    public void setSourceBatch(String sourceBatch) {
        this.sourceBatch = sourceBatch;
    }

    public String getRevertBody() {
        return revertBody;
    }

    public void setRevertBody(String revertBody) {
        this.revertBody = revertBody;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
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

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Date getWarehousDate() {
        return warehousDate;
    }

    public void setWarehousDate(Date warehousDate) {
        this.warehousDate = warehousDate;
    }

    public Date getDeliverDate() {
        return deliverDate;
    }

    public void setDeliverDate(Date deliverDate) {
        this.deliverDate = deliverDate;
    }

    public Long getCostInfoId() {
        return costInfoId;
    }

    public void setCostInfoId(Long costInfoId) {
        this.costInfoId = costInfoId;
    }

    public Date getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(Date checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public BigDecimal getIncomePrice() {
        return incomePrice;
    }

    public void setIncomePrice(BigDecimal incomePrice) {
        this.incomePrice = incomePrice;
    }

    public BigDecimal getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(BigDecimal serviceCost) {
        this.serviceCost = serviceCost;
    }

    public BigDecimal getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(BigDecimal sellPrice) {
        this.sellPrice = sellPrice;
    }
}
