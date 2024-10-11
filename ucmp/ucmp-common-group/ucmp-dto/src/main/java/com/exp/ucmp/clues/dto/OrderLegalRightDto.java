package com.exp.ucmp.clues.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * <p>@ClassName: OrderLegalRightDto</p>
 * <p>@Description: </p>
 * <p>@Author: fxy</p>
 * <p>@Date: 2023/6/28 15:31<p>
 */
public class OrderLegalRightDto {
    @ApiModelProperty("订单号")
    private Long orderInfoId;
    @ApiModelProperty("客户ID")
    private Long customerId;
    @ApiModelProperty("库存车辆ID")
    private Long stockId;
    @ApiModelProperty("发放权益(01.权益发放 02权益不发放)")
    private String legalRight;

    public Long getOrderInfoId() {
        return orderInfoId;
    }

    public void setOrderInfoId(Long orderInfoId) {
        this.orderInfoId = orderInfoId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getStockId() {
        return stockId;
    }

    public void setStockId(Long stockId) {
        this.stockId = stockId;
    }

    public String getLegalRight() {
        return legalRight;
    }

    public void setLegalRight(String legalRight) {
        this.legalRight = legalRight;
    }
}
