package com.exp.ucmp.clues.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * <p>@ClassName: SalesOrderCancelDto</p>
 * <p>@Description: </p>
 * <p>@Author: fxy</p>
 * <p>@Date: 2023/7/6 10:43<p>
 */
public class SalesOrderCancelDto {
    @ApiModelProperty(value = "订单信息id")
    private Long orderInfoId;

    @ApiModelProperty(value = "取消订单备注")
    private String cancelRemark;

    public Long getOrderInfoId() {
        return orderInfoId;
    }

    public void setOrderInfoId(Long orderInfoId) {
        this.orderInfoId = orderInfoId;
    }

    public String getCancelRemark() {
        return cancelRemark;
    }

    public void setCancelRemark(String cancelRemark) {
        this.cancelRemark = cancelRemark;
    }
}
