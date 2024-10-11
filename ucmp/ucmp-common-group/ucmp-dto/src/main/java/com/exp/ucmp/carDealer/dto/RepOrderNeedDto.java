package com.exp.ucmp.carDealer.dto;

import com.egrid.core.base.model.BaseModel;

/**
 * @author GeYiJiang
 * @Description:
 * @date 2022/10/23 17:44
 */
public class RepOrderNeedDto extends BaseModel {

    private static final long serialVersionUID = 7589715327547496659L;
    private Long reservationId;
    /**
     * 客户id
     */
    private Long customerId;
    /**
     * 门店id
     */
    private Long storeId;
    /**
     * 门店名称
     */
    private String storeName;
    /**
     * 制单人id
     */
    private Long makeOrderPersonId;
    /**
     * '制单人姓名'
     */
    private String makeOrderPersonName;
    /**
     * 制单人角色
     */
    private String makeOrderPersonRole;
    /**
     * 制单人手机
     */
    private String makeOrderPersonIphone;
    /**
     * '业务类型：01、他品，02、本品'
     */
    private String businessType;
    /**
     * '业务单号(同线索单号)'
     */
    private String businessOrderNo;
    /**
     * '1601置换/1602销售   业务标识'
     */
    private String businessClassify;
    /**
     * '旧车客户姓名'
     */
    private String oldCarCustomerName;
    /**
     * '旧车客户手机号'
     */
    private String oldCarCustomerIphone;
    /**
     * '旧车车型描述'
     */
    private String oldCarModelDescribe;

    public RepOrderNeedDto() {
    }

    public RepOrderNeedDto(Long reservationId, Long customerId, Long storeId, String storeName, Long makeOrderPersonId, String makeOrderPersonName, String makeOrderPersonRole, String makeOrderPersonIphone, String businessType, String businessOrderNo, String businessClassify, String oldCarCustomerName, String oldCarCustomerIphone, String oldCarModelDescribe) {
        this.reservationId = reservationId;
        this.customerId = customerId;
        this.storeId = storeId;
        this.storeName = storeName;
        this.makeOrderPersonId = makeOrderPersonId;
        this.makeOrderPersonName = makeOrderPersonName;
        this.makeOrderPersonRole = makeOrderPersonRole;
        this.makeOrderPersonIphone = makeOrderPersonIphone;
        this.businessType = businessType;
        this.businessOrderNo = businessOrderNo;
        this.businessClassify = businessClassify;
        this.oldCarCustomerName = oldCarCustomerName;
        this.oldCarCustomerIphone = oldCarCustomerIphone;
        this.oldCarModelDescribe = oldCarModelDescribe;
    }

    /**
     * 获取
     * @return reservationId
     */
    public Long getReservationId() {
        return reservationId;
    }

    /**
     * 设置
     * @param reservationId
     */
    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

    /**
     * 获取
     * @return customerId
     */
    public Long getCustomerId() {
        return customerId;
    }

    /**
     * 设置
     * @param customerId
     */
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    /**
     * 获取
     * @return storeId
     */
    public Long getStoreId() {
        return storeId;
    }

    /**
     * 设置
     * @param storeId
     */
    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    /**
     * 获取
     * @return storeName
     */
    public String getStoreName() {
        return storeName;
    }

    /**
     * 设置
     * @param storeName
     */
    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    /**
     * 获取
     * @return makeOrderPersonId
     */
    public Long getMakeOrderPersonId() {
        return makeOrderPersonId;
    }

    /**
     * 设置
     * @param makeOrderPersonId
     */
    public void setMakeOrderPersonId(Long makeOrderPersonId) {
        this.makeOrderPersonId = makeOrderPersonId;
    }

    /**
     * 获取
     * @return makeOrderPersonName
     */
    public String getMakeOrderPersonName() {
        return makeOrderPersonName;
    }

    /**
     * 设置
     * @param makeOrderPersonName
     */
    public void setMakeOrderPersonName(String makeOrderPersonName) {
        this.makeOrderPersonName = makeOrderPersonName;
    }

    /**
     * 获取
     * @return makeOrderPersonRole
     */
    public String getMakeOrderPersonRole() {
        return makeOrderPersonRole;
    }

    /**
     * 设置
     * @param makeOrderPersonRole
     */
    public void setMakeOrderPersonRole(String makeOrderPersonRole) {
        this.makeOrderPersonRole = makeOrderPersonRole;
    }

    /**
     * 获取
     * @return makeOrderPersonIphone
     */
    public String getMakeOrderPersonIphone() {
        return makeOrderPersonIphone;
    }

    /**
     * 设置
     * @param makeOrderPersonIphone
     */
    public void setMakeOrderPersonIphone(String makeOrderPersonIphone) {
        this.makeOrderPersonIphone = makeOrderPersonIphone;
    }

    /**
     * 获取
     * @return businessType
     */
    public String getBusinessType() {
        return businessType;
    }

    /**
     * 设置
     * @param businessType
     */
    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    /**
     * 获取
     * @return businessOrderNo
     */
    public String getBusinessOrderNo() {
        return businessOrderNo;
    }

    /**
     * 设置
     * @param businessOrderNo
     */
    public void setBusinessOrderNo(String businessOrderNo) {
        this.businessOrderNo = businessOrderNo;
    }

    /**
     * 获取
     * @return businessClassify
     */
    public String getBusinessClassify() {
        return businessClassify;
    }

    /**
     * 设置
     * @param businessClassify
     */
    public void setBusinessClassify(String businessClassify) {
        this.businessClassify = businessClassify;
    }

    /**
     * 获取
     * @return oldCarCustomerName
     */
    public String getOldCarCustomerName() {
        return oldCarCustomerName;
    }

    /**
     * 设置
     * @param oldCarCustomerName
     */
    public void setOldCarCustomerName(String oldCarCustomerName) {
        this.oldCarCustomerName = oldCarCustomerName;
    }

    /**
     * 获取
     * @return oldCarCustomerIphone
     */
    public String getOldCarCustomerIphone() {
        return oldCarCustomerIphone;
    }

    /**
     * 设置
     * @param oldCarCustomerIphone
     */
    public void setOldCarCustomerIphone(String oldCarCustomerIphone) {
        this.oldCarCustomerIphone = oldCarCustomerIphone;
    }

    /**
     * 获取
     * @return oldCarModelDescribe
     */
    public String getOldCarModelDescribe() {
        return oldCarModelDescribe;
    }

    /**
     * 设置
     * @param oldCarModelDescribe
     */
    public void setOldCarModelDescribe(String oldCarModelDescribe) {
        this.oldCarModelDescribe = oldCarModelDescribe;
    }

    public String toString() {
        return "RepOrderNeedDto{serialVersionUID = " + serialVersionUID + ", reservationId = " + reservationId + ", customerId = " + customerId + ", storeId = " + storeId + ", storeName = " + storeName + ", makeOrderPersonId = " + makeOrderPersonId + ", makeOrderPersonName = " + makeOrderPersonName + ", makeOrderPersonRole = " + makeOrderPersonRole + ", makeOrderPersonIphone = " + makeOrderPersonIphone + ", businessType = " + businessType + ", businessOrderNo = " + businessOrderNo + ", businessClassify = " + businessClassify + ", oldCarCustomerName = " + oldCarCustomerName + ", oldCarCustomerIphone = " + oldCarCustomerIphone + ", oldCarModelDescribe = " + oldCarModelDescribe + "}";
    }
}
