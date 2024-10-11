package com.exp.ucmp.replacement.dto;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.egrid.core.base.model.BaseModel;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author GeYiJiang
 * @Description: 导出置换单查询dto
 * @date 2022/11/2 14:18
 */
@ApiModel(value = "ReplacementOrderExportDto", description = "导出置换单查询dto")
public class ReplacementOrderExportDto extends BaseModel {

    /**
     * 预约ID
     */
    @ApiModelProperty(value = "预约ID")
    @ExcelIgnore
    private Long reservationId;

    /**
     * 门店名
     */
    @ApiModelProperty(value = "门店名")
    @ExcelProperty(value = "门店", index = 4)
    private String storeName;

    /**
     * 门店ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "门店ID")
    @ExcelIgnore
    private Long storeId;

    /**
     * 业务类型：01、他品，02、本品
     */
    @ApiModelProperty(value = "业务类型：01、他品，02、本品")
    @ExcelIgnore
    private String businessType;


    /**
     * 业务标识：1601、置换，1602、销售
     */
    @ApiModelProperty(value = "业务标识：1601、置换，1602、销售")
    @ExcelIgnore
    private String businessClassify;

    /**
     * 业务单号(同线索单号)
     */
    @ApiModelProperty(value = "业务单号(同线索单号)")
    @ExcelProperty(value = "置换单编号", index = 0)
    private String businessOrderNo;

    /**
     * '旧车客户姓名'
     */
    @ApiModelProperty(value = "客户姓名")
    @ExcelProperty(value = "姓名", index = 1)
    private String customerName;

    /**
     * '旧车车型描述'
     */
    @ApiModelProperty(value = "客户手机号")
    @ExcelProperty(value = "手机号", index = 2)
    private String customerIphone;

    /**
     * '旧车车型描述'
     */
    @ApiModelProperty(value = "'车型描述'")
    @ExcelProperty(value = "车型", index = 3)
    private String carTypeChineseDescribe;

    /**
     * 制单人ID(指的是预约表里面的顾问或者经理、店长)
     */
    @ApiModelProperty(value = "制单人ID(指的是预约表里面的顾问或者经理、店长)")
    @ExcelIgnore
    private Long makeOrderPersonId;

    /**
     * 制单人姓名(指的是预约表里面的顾问或者经理、店长)
     */
    @ApiModelProperty(value = "制单人姓名(指的是预约表里面的顾问或者经理、店长)")
    @ExcelProperty(value = "创建人", index = 5)
    private String makeOrderPersonName;

    /**
     * 制单人姓名(指的是预约表里面的顾问或者经理、店长)
     */
    @ApiModelProperty(value = "制单人角色(指的是预约表里面的顾问或者经理、店长)")
    @ExcelIgnore
    private String makeOrderPersonRole;

    /**
     * 审批状态
     */
    @ApiModelProperty(value = "审批状态(" +
            "进行中(1301,null)" +
            "待审核(1303)" +
            "已驳回(1305)" +
            "已通过(1302,1304)" +
            "审核关闭(1309))")
    @ExcelProperty(value = "状态", index = 6)
    private String approvalStatus;

    /**
     * 创建预约时间
     */
    @ApiModelProperty(value = "创建预约时间")
    @ExcelProperty(value = "创建预约时间", index = 7)
    private String exCreatedDate;

    /**
     * 预约检测时间
     */
    @ApiModelProperty(value = "预约检测时间")
    @ExcelProperty(value = "预约检测时间", index = 8)
    private String exReservationDetectionDate;

    /**
     * 预约检测地点
     */
    @ApiModelProperty(value = "预约检测地点")
    @ExcelIgnore
    private String reservationDetectionAddress;

    /**
     * 线索类型：01、置换线索，02、收购线索，03、销售线索
     */
    @ApiModelProperty(value = "线索类型：01、置换线索，02、收购线索，03、销售线索")
    @ExcelIgnore
    private String cluesType;

    /**
     * 线索来源：01、录入，02、小程序，03、高合APP，04、官网
     */
    @ApiModelProperty(value = "线索来源：01、录入，02、小程序，03、高合APP，04、官网")
    @ExcelProperty(value = "来源", index = 9)
    private String cluesSource;

    /**
     * 分派车商数
     */
    @ApiModelProperty(value = "分派车商数")
    @ExcelProperty(value = "分派车商数", index = 10)
    private Integer dispatcherCount;

    /**
     * 放弃接单
     */
    @ApiModelProperty(value = "放弃接单")
    @ExcelProperty(value = "放弃接单", index = 11)
    private Integer abandonReceivingOrdersCount;

    /**
     * 已接单-待报价
     */
    @ApiModelProperty(value = "已接单-待报价")
    @ExcelProperty(value = "已接单-待报价", index = 12)
    private Integer ordersReceivedAndToBeQuotedCount;

    /**
     * 到期未报价
     */
    @ApiModelProperty(value = "到期未报价")
    @ExcelProperty(value = "到期未报价", index = 13)
    private Integer noQuotationDueCount;

    /**
     * 放弃报价
     */
    @ApiModelProperty(value = "放弃报价")
    @ExcelProperty(value = "放弃报价", index = 14)
    private Integer abandonQuotationCount;

    /**
     * 已报价
     */
    @ApiModelProperty(value = "已报价")
    @ExcelProperty(value = "已报价", index = 15)
    private Integer quotedCount;

    /**
     * 客户是否同意价格
     */
    @ApiModelProperty(value = "客户是否同意价格(0501-是 0502-否)")
//    @ExcelProperty(value = "客户是否同意价格", index = 16)
    @ExcelIgnore
    private String customerIntention;

    /**
     * 是否收购
     */
    @ApiModelProperty(value = "是否收购(有值-是 NULL-否)")
    @ExcelProperty(value = "是否收购", index = 16)
    private String generateAcquisitionsTime;

    public ReplacementOrderExportDto() {
    }

    public ReplacementOrderExportDto(Long reservationId, String storeName, Long storeId, String businessType, String businessClassify, String businessOrderNo, String customerName, String customerIphone, String carTypeChineseDescribe, Long makeOrderPersonId, String makeOrderPersonName, String makeOrderPersonRole, String approvalStatus, String exCreatedDate, String exReservationDetectionDate, String reservationDetectionAddress, String cluesType, String cluesSource, Integer dispatcherCount, Integer abandonReceivingOrdersCount, Integer ordersReceivedAndToBeQuotedCount, Integer noQuotationDueCount, Integer abandonQuotationCount, Integer quotedCount, String customerIntention, String generateAcquisitionsTime) {
        this.reservationId = reservationId;
        this.storeName = storeName;
        this.storeId = storeId;
        this.businessType = businessType;
        this.businessClassify = businessClassify;
        this.businessOrderNo = businessOrderNo;
        this.customerName = customerName;
        this.customerIphone = customerIphone;
        this.carTypeChineseDescribe = carTypeChineseDescribe;
        this.makeOrderPersonId = makeOrderPersonId;
        this.makeOrderPersonName = makeOrderPersonName;
        this.makeOrderPersonRole = makeOrderPersonRole;
        this.approvalStatus = approvalStatus;
        this.exCreatedDate = exCreatedDate;
        this.exReservationDetectionDate = exReservationDetectionDate;
        this.reservationDetectionAddress = reservationDetectionAddress;
        this.cluesType = cluesType;
        this.cluesSource = cluesSource;
        this.dispatcherCount = dispatcherCount;
        this.abandonReceivingOrdersCount = abandonReceivingOrdersCount;
        this.ordersReceivedAndToBeQuotedCount = ordersReceivedAndToBeQuotedCount;
        this.noQuotationDueCount = noQuotationDueCount;
        this.abandonQuotationCount = abandonQuotationCount;
        this.quotedCount = quotedCount;
        this.customerIntention = customerIntention;
        this.generateAcquisitionsTime = generateAcquisitionsTime;
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
     * @return customerName
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * 设置
     * @param customerName
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * 获取
     * @return customerIphone
     */
    public String getCustomerIphone() {
        return customerIphone;
    }

    /**
     * 设置
     * @param customerIphone
     */
    public void setCustomerIphone(String customerIphone) {
        this.customerIphone = customerIphone;
    }

    /**
     * 获取
     * @return carTypeChineseDescribe
     */
    public String getCarTypeChineseDescribe() {
        return carTypeChineseDescribe;
    }

    /**
     * 设置
     * @param carTypeChineseDescribe
     */
    public void setCarTypeChineseDescribe(String carTypeChineseDescribe) {
        this.carTypeChineseDescribe = carTypeChineseDescribe;
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
     * @return approvalStatus
     */
    public String getApprovalStatus() {
        return approvalStatus;
    }

    /**
     * 设置
     * @param approvalStatus
     */
    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    /**
     * 获取
     * @return exCreatedDate
     */
    public String getExCreatedDate() {
        return exCreatedDate;
    }

    /**
     * 设置
     * @param exCreatedDate
     */
    public void setExCreatedDate(String exCreatedDate) {
        this.exCreatedDate = exCreatedDate;
    }

    /**
     * 获取
     * @return exReservationDetectionDate
     */
    public String getExReservationDetectionDate() {
        return exReservationDetectionDate;
    }

    /**
     * 设置
     * @param exReservationDetectionDate
     */
    public void setExReservationDetectionDate(String exReservationDetectionDate) {
        this.exReservationDetectionDate = exReservationDetectionDate;
    }

    /**
     * 获取
     * @return reservationDetectionAddress
     */
    public String getReservationDetectionAddress() {
        return reservationDetectionAddress;
    }

    /**
     * 设置
     * @param reservationDetectionAddress
     */
    public void setReservationDetectionAddress(String reservationDetectionAddress) {
        this.reservationDetectionAddress = reservationDetectionAddress;
    }

    /**
     * 获取
     * @return cluesType
     */
    public String getCluesType() {
        return cluesType;
    }

    /**
     * 设置
     * @param cluesType
     */
    public void setCluesType(String cluesType) {
        this.cluesType = cluesType;
    }

    /**
     * 获取
     * @return cluesSource
     */
    public String getCluesSource() {
        return cluesSource;
    }

    /**
     * 设置
     * @param cluesSource
     */
    public void setCluesSource(String cluesSource) {
        this.cluesSource = cluesSource;
    }

    /**
     * 获取
     * @return dispatcherCount
     */
    public Integer getDispatcherCount() {
        return dispatcherCount;
    }

    /**
     * 设置
     * @param dispatcherCount
     */
    public void setDispatcherCount(Integer dispatcherCount) {
        this.dispatcherCount = dispatcherCount;
    }

    /**
     * 获取
     * @return abandonReceivingOrdersCount
     */
    public Integer getAbandonReceivingOrdersCount() {
        return abandonReceivingOrdersCount;
    }

    /**
     * 设置
     * @param abandonReceivingOrdersCount
     */
    public void setAbandonReceivingOrdersCount(Integer abandonReceivingOrdersCount) {
        this.abandonReceivingOrdersCount = abandonReceivingOrdersCount;
    }

    /**
     * 获取
     * @return ordersReceivedAndToBeQuotedCount
     */
    public Integer getOrdersReceivedAndToBeQuotedCount() {
        return ordersReceivedAndToBeQuotedCount;
    }

    /**
     * 设置
     * @param ordersReceivedAndToBeQuotedCount
     */
    public void setOrdersReceivedAndToBeQuotedCount(Integer ordersReceivedAndToBeQuotedCount) {
        this.ordersReceivedAndToBeQuotedCount = ordersReceivedAndToBeQuotedCount;
    }

    /**
     * 获取
     * @return noQuotationDueCount
     */
    public Integer getNoQuotationDueCount() {
        return noQuotationDueCount;
    }

    /**
     * 设置
     * @param noQuotationDueCount
     */
    public void setNoQuotationDueCount(Integer noQuotationDueCount) {
        this.noQuotationDueCount = noQuotationDueCount;
    }

    /**
     * 获取
     * @return abandonQuotationCount
     */
    public Integer getAbandonQuotationCount() {
        return abandonQuotationCount;
    }

    /**
     * 设置
     * @param abandonQuotationCount
     */
    public void setAbandonQuotationCount(Integer abandonQuotationCount) {
        this.abandonQuotationCount = abandonQuotationCount;
    }

    /**
     * 获取
     * @return quotedCount
     */
    public Integer getQuotedCount() {
        return quotedCount;
    }

    /**
     * 设置
     * @param quotedCount
     */
    public void setQuotedCount(Integer quotedCount) {
        this.quotedCount = quotedCount;
    }

    /**
     * 获取
     * @return customerIntention
     */
    public String getCustomerIntention() {
        return customerIntention;
    }

    /**
     * 设置
     * @param customerIntention
     */
    public void setCustomerIntention(String customerIntention) {
        this.customerIntention = customerIntention;
    }

    /**
     * 获取
     * @return generateAcquisitionsTime
     */
    public String getGenerateAcquisitionsTime() {
        return generateAcquisitionsTime;
    }

    /**
     * 设置
     * @param generateAcquisitionsTime
     */
    public void setGenerateAcquisitionsTime(String generateAcquisitionsTime) {
        this.generateAcquisitionsTime = generateAcquisitionsTime;
    }

    public String toString() {
        return "ReplacementOrderExportDto{reservationId = " + reservationId + ", storeName = " + storeName + ", storeId = " + storeId + ", businessType = " + businessType + ", businessClassify = " + businessClassify + ", businessOrderNo = " + businessOrderNo + ", customerName = " + customerName + ", customerIphone = " + customerIphone + ", carTypeChineseDescribe = " + carTypeChineseDescribe + ", makeOrderPersonId = " + makeOrderPersonId + ", makeOrderPersonName = " + makeOrderPersonName + ", makeOrderPersonRole = " + makeOrderPersonRole + ", approvalStatus = " + approvalStatus + ", exCreatedDate = " + exCreatedDate + ", exReservationDetectionDate = " + exReservationDetectionDate + ", reservationDetectionAddress = " + reservationDetectionAddress + ", cluesType = " + cluesType + ", cluesSource = " + cluesSource + ", dispatcherCount = " + dispatcherCount + ", abandonReceivingOrdersCount = " + abandonReceivingOrdersCount + ", ordersReceivedAndToBeQuotedCount = " + ordersReceivedAndToBeQuotedCount + ", noQuotationDueCount = " + noQuotationDueCount + ", abandonQuotationCount = " + abandonQuotationCount + ", quotedCount = " + quotedCount + ", customerIntention = " + customerIntention + ", generateAcquisitionsTime = " + generateAcquisitionsTime + "}";
    }
}
