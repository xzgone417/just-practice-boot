/*
 * Copyright (C) 2013 SHANGHAI VOLKSWAGEN, All rights reserved.
 * License version 1.0, a copy of which has been included with this.
 * @File  name: com.svw.newsvwuc.auth.modules.dlrauth.dto.AuthVo
 * @Create  on: 2021/11/2
 * @Author    : hong
 */
package com.exp.ucmp.stock.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;


@ApiModel(value = "SaveExpenseCostParamDto对象", description = "保存车辆费用参数")
public class SaveExpenseCostParamDto {

    @ApiModelProperty(value = "库存车辆id")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long stockId;

    @ApiModelProperty(value = "美容款")
    private BigDecimal facialCost;

    @ApiModelProperty(value = "物流费用")
    private BigDecimal logisticsCost;

    @ApiModelProperty(value = "检测费用")
    private BigDecimal testCost;

    @ApiModelProperty(value = "保全费用")
    private BigDecimal retainCost;

    @ApiModelProperty(value = "亲善费用")
    private BigDecimal friendlyCost;

    @ApiModelProperty(value = "权益")
    private BigDecimal rightCost;

    @ApiModelProperty(value = "贴息")
    private BigDecimal interestCost;

    @ApiModelProperty(value = "礼品")
    private BigDecimal giftCost;

    @ApiModelProperty(value = "佣金")
    private BigDecimal brokerageCost;

    @ApiModelProperty(value = "其他")
    private BigDecimal otherCost;

    public Long getStockId() {
        return stockId;
    }

    public void setStockId(Long stockId) {
        this.stockId = stockId;
    }

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
}
