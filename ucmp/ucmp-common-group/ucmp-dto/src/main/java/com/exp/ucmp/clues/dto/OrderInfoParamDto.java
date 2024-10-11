package com.exp.ucmp.clues.dto;

import com.exp.ucmp.PageDto;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.List;

/**
 * <p>@ClassName: OrderInfoParamDto</p>
 * <p>@Description: </p>
 * <p>@Author: fxy</p>
 * <p>@Date: 2023/6/26 11:22<p>
 */
public class OrderInfoParamDto extends PageDto {


    @ApiModelProperty(value = "角色")
    private String role;

    @ApiModelProperty(value = "vin")
    private String carVin;

    @ApiModelProperty(value = "当前跟进门店ID")
    private Long storeId;


    @ApiModelProperty(value = "当前跟进人员ID")
    private Long partyId;

    @ApiModelProperty(value = "销售门店ID")
    private Long salesStore;

    @ApiModelProperty(value = "销售门店ID")
    private List<Long> salesStoreList;

    @ApiModelProperty(value = "出行顾问")
    private Long followPerson;

    @ApiModelProperty(value = "客户ID")
    private String customerId;

    @ApiModelProperty(value = "客户姓名")
    private String customerName;

    @ApiModelProperty(value = "客户手机号")
    private String customerPhone;

    @ApiModelProperty(value = "交付中心CODE")
    private String storageCode;

    @ApiModelProperty(value = "交付门店")
    private String deliveryStore;

    @ApiModelProperty(value = "订单状态")
    private String orderStatus;

    @ApiModelProperty(value = "订单开始时间")
    private String startCreatedDate;

    @ApiModelProperty(value = "订单开始时间")
    private String endCreatedDate;

    @ApiModelProperty("除店长外其他人线索：01")
    private String otherPartyId;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getCarVin() {
        return carVin;
    }

    public void setCarVin(String carVin) {
        this.carVin = carVin;
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

    public String getStorageCode() {
        return storageCode;
    }

    public void setStorageCode(String storageCode) {
        this.storageCode = storageCode;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getStartCreatedDate() {
        return startCreatedDate;
    }

    public void setStartCreatedDate(String startCreatedDate) {
        this.startCreatedDate = startCreatedDate;
    }

    public String getEndCreatedDate() {
        return endCreatedDate;
    }

    public void setEndCreatedDate(String endCreatedDate) {
        this.endCreatedDate = endCreatedDate;
    }

    public String getDeliveryStore() {
        return deliveryStore;
    }

    public void setDeliveryStore(String deliveryStore) {
        this.deliveryStore = deliveryStore;
    }

    public List<Long> getSalesStoreList() {
        return salesStoreList;
    }

    public void setSalesStoreList(List<Long> salesStoreList) {
        this.salesStoreList = salesStoreList;
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

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getOtherPartyId() {
        return otherPartyId;
    }

    public void setOtherPartyId(String otherPartyId) {
        this.otherPartyId = otherPartyId;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Long getPartyId() {
        return partyId;
    }

    public void setPartyId(Long partyId) {
        this.partyId = partyId;
    }
}
