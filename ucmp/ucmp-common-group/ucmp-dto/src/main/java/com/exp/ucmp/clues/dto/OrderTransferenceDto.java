package com.exp.ucmp.clues.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * <p>@ClassName: OrderTransferenceDto</p>
 * <p>@Description: </p>
 * <p>@Author: fxy</p>
 * <p>@Date: 2023/7/21 15:24<p>
 */
public class OrderTransferenceDto {
    @ApiModelProperty("订单id")
    private Long orderInfoId;

    @ApiModelProperty("跟进门店")
    private Long salesStore;

    @ApiModelProperty("跟进人")
    private Long followPerson;

    public Long getOrderInfoId() {
        return orderInfoId;
    }

    public void setOrderInfoId(Long orderInfoId) {
        this.orderInfoId = orderInfoId;
    }

    public Long getSalesStore() {
        return salesStore;
    }

    public void setSalesStore(Long salesStore) {
        this.salesStore = salesStore;
    }

    public Long getFollowPerson() {
        return followPerson;
    }

    public void setFollowPerson(Long followPerson) {
        this.followPerson = followPerson;
    }
}
