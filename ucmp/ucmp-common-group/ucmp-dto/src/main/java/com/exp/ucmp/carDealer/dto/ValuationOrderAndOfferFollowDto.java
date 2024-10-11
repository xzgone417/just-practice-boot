package com.exp.ucmp.carDealer.dto;

import com.egrid.core.base.model.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author GeYiJiang
 * @Description:
 * @date 2022/10/13 16:05
 */
@ApiModel(value = "ValuationOrderAndOfferFollowDto", description = "接单、报价数量统计对象")
public class ValuationOrderAndOfferFollowDto extends BaseModel {

    private static final long serialVersionUID = 4651866629295558700L;

    @ApiModelProperty("待接单")
    private Integer pendingOrders;

    @ApiModelProperty("我的接单")
    private Integer myOrders;

    @ApiModelProperty("未接单")
    private Integer unOrders;

    @ApiModelProperty("待报价")
    private Integer pendingOffers;

    @ApiModelProperty("我的报价")
    private Integer myOffers;

    @ApiModelProperty("未报价")
    private Integer unOffers;


    public ValuationOrderAndOfferFollowDto() {
    }

    public ValuationOrderAndOfferFollowDto(Integer pendingOrders, Integer myOrders, Integer unOrders, Integer pendingOffers, Integer myOffers, Integer unOffers) {
        this.pendingOrders = pendingOrders;
        this.myOrders = myOrders;
        this.unOrders = unOrders;
        this.pendingOffers = pendingOffers;
        this.myOffers = myOffers;
        this.unOffers = unOffers;
    }

    /**
     * 获取
     * @return pendingOrders
     */
    public Integer getPendingOrders() {
        return pendingOrders;
    }

    /**
     * 设置
     * @param pendingOrders
     */
    public void setPendingOrders(Integer pendingOrders) {
        this.pendingOrders = pendingOrders;
    }

    /**
     * 获取
     * @return myOrders
     */
    public Integer getMyOrders() {
        return myOrders;
    }

    /**
     * 设置
     * @param myOrders
     */
    public void setMyOrders(Integer myOrders) {
        this.myOrders = myOrders;
    }

    /**
     * 获取
     * @return unOrders
     */
    public Integer getUnOrders() {
        return unOrders;
    }

    /**
     * 设置
     * @param unOrders
     */
    public void setUnOrders(Integer unOrders) {
        this.unOrders = unOrders;
    }

    /**
     * 获取
     * @return pendingOffers
     */
    public Integer getPendingOffers() {
        return pendingOffers;
    }

    /**
     * 设置
     * @param pendingOffers
     */
    public void setPendingOffers(Integer pendingOffers) {
        this.pendingOffers = pendingOffers;
    }

    /**
     * 获取
     * @return myOffers
     */
    public Integer getMyOffers() {
        return myOffers;
    }

    /**
     * 设置
     * @param myOffers
     */
    public void setMyOffers(Integer myOffers) {
        this.myOffers = myOffers;
    }

    /**
     * 获取
     * @return unOffers
     */
    public Integer getUnOffers() {
        return unOffers;
    }

    /**
     * 设置
     * @param unOffers
     */
    public void setUnOffers(Integer unOffers) {
        this.unOffers = unOffers;
    }

    public String toString() {
        return "ValuationOrderAndOfferFollowDto{pendingOrders = " + pendingOrders + ", myOrders = " + myOrders + ", unOrders = " + unOrders + ", pendingOffers = " + pendingOffers + ", myOffers = " + myOffers + ", unOffers = " + unOffers + "}";
    }
}
