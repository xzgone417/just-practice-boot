package com.exp.ucmp.clues.dto;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * <p>@ClassName: SalesOrderCreateDto</p>
 * <p>@Description: </p>
 * <p>@Author: fxy</p>
 * <p>@Date: 2023/7/4 14:53<p>
 */
public class SalesOrderCreateDto {

    /**
     * 销售客户id
     */
    @ApiModelProperty(value = "销售客户id")
    private Long customerId;

    /**
     * 线索id
     */
    @ApiModelProperty(value = "线索id")
    private Long cluesId;

    /**
     * 库存车辆id
     */
    @ApiModelProperty(value = "库存车辆id")
    private String stockId;

    /**
     * 交付中心
     */
    @ApiModelProperty(value = "交付中心")
    private Long deliveryStore;

    /**
     * vin码
     */
    @ApiModelProperty(value = "vin码")
    private String carVin;

    /**
     * 上牌城市
     */
    @ApiModelProperty(value = "上牌城市")
    private String licensingCity;

    /**
     * 订单价格
     */
    @ApiModelProperty(value = "订单价格")
    private BigDecimal orderPrice;

    /**
     * 定金
     */
    @ApiModelProperty(value = "定金")
    private BigDecimal deposit;

    /**
     * 订单状态:7401 待下定,7402 已下定待转交付,7403 已分配待付全款,7404  已全款待过户,7405 已过户待交付,7406 已交付,7407 订单取消,7408 改配申请中,7409 已转交付待分配
     */
    @ApiModelProperty(value = "订单状态:7401 待下定,7402 已下定待转交付,7403 已分配待付全款,7404  已全款待过户,7405 已过户待交付,7406 已交付,7407 订单取消,7408 改配申请中,7409 已转交付待分配")
    private String orderStatus;

    /**
     * 车辆价格
     */
    @ApiModelProperty(value = "车辆价格")
    private BigDecimal carPrice;

    /**
     * 销售门店ID
     */
    @ApiModelProperty(value = "销售门店ID")
    private Long salesStore;

    /**
     * 客户姓名
     */
    @ApiModelProperty(value = "客户姓名")
    private String customerName;

    /**
     * 客户手机号
     */
    @ApiModelProperty(value = "客户手机号")
    private String customerPhone;

    /**
     * 车主身份证
     */
    @ApiModelProperty(value = "车主身份证")
    private String ownerCardNo;

    /**
     * 跟进人（出行顾问）
     */
    @ApiModelProperty(value = "跟进人（出行顾问）")
    private Long followPerson;

    /**
     * 车辆所有人类型01个人02企业
     */
    @ApiModelProperty(value = "车辆所有人类型01个人02企业")
    private String carOwnerType;

    /**
     * 证件类型字典type81
     */
    @ApiModelProperty(value = "证件类型字典type81")
    private String typeId;

    /**
     * 订单备注
     */
    @ApiModelProperty(value = "订单备注")
    private String orderRemark;


    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getCluesId() {
        return cluesId;
    }

    public void setCluesId(Long cluesId) {
        this.cluesId = cluesId;
    }

    public String getStockId() {
        return stockId;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId;
    }

    public Long getDeliveryStore() {
        return deliveryStore;
    }

    public void setDeliveryStore(Long deliveryStore) {
        this.deliveryStore = deliveryStore;
    }

    public String getCarVin() {
        return carVin;
    }

    public void setCarVin(String carVin) {
        this.carVin = carVin;
    }

    public String getLicensingCity() {
        return licensingCity;
    }

    public void setLicensingCity(String licensingCity) {
        this.licensingCity = licensingCity;
    }

    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }

    public BigDecimal getDeposit() {
        return deposit;
    }

    public void setDeposit(BigDecimal deposit) {
        this.deposit = deposit;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public BigDecimal getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(BigDecimal carPrice) {
        this.carPrice = carPrice;
    }

    public Long getSalesStore() {
        return salesStore;
    }

    public void setSalesStore(Long salesStore) {
        this.salesStore = salesStore;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getOwnerCardNo() {
        return ownerCardNo;
    }

    public void setOwnerCardNo(String ownerCardNo) {
        this.ownerCardNo = ownerCardNo;
    }

    public Long getFollowPerson() {
        return followPerson;
    }

    public void setFollowPerson(Long followPerson) {
        this.followPerson = followPerson;
    }

    public String getCarOwnerType() {
        return carOwnerType;
    }

    public void setCarOwnerType(String carOwnerType) {
        this.carOwnerType = carOwnerType;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getOrderRemark() {
        return orderRemark;
    }

    public void setOrderRemark(String orderRemark) {
        this.orderRemark = orderRemark;
    }
}
