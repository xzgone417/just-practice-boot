package com.exp.ucmp.clues.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * <p>@ClassName: PsiSalesModifyConfigDto</p>
 * <p>@Description: </p>
 * <p>@Author: fxy</p>
 * <p>@Date: 2023/6/27 15:48<p>
 */
public class PsiSalesModifyConfigCreateDto {


    /**
     * 销售订单ID
     */
    @ApiModelProperty(value = "销售订单ID")
    private Long orderInfoId;

    /**
     * 订单当前状态
     */
    @ApiModelProperty(value = "订单当前状态")
    private String orderStatus;

    /**
     * 目前配车vin码
     */
    @ApiModelProperty(value = "目前配车vin码")
    private String vin;

    /**
     * 变更vin码
     */
    @ApiModelProperty(value = "变更vin码")
    private String changeVin;

    public Long getOrderInfoId() {
        return orderInfoId;
    }

    public void setOrderInfoId(Long orderInfoId) {
        this.orderInfoId = orderInfoId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getChangeVin() {
        return changeVin;
    }

    public void setChangeVin(String changeVin) {
        this.changeVin = changeVin;
    }

}
