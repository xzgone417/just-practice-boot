package com.exp.ucmp.carDealer.dto;

import com.egrid.core.base.model.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@ApiModel(value = "AcquisitionQueryResultDto", description = "收购查询记录结果对象")
public class AcquisitionQueryResultDto extends BaseModel {

    private static final long serialVersionUID = -7596575229921988761L;
    /**
     * 预约ID
     */
    @ApiModelProperty(value = "预约ID")
    private Long reservationId;

    /**
     * 询价ID
     */
    @ApiModelProperty(value = "询价ID")
    private Long inquiryId;

    /**
     * 他品询价ID
     */
    @ApiModelProperty(value = "他品询价ID")
    private Long otherBrandInquiryId;

    /**
     * 客户姓名
     */
    @ApiModelProperty(value = "客户姓名")
    private String customerName;

    /**
     * 客户联系电话
     */
    @ApiModelProperty(value = "客户联系电话")
    private String customerIphone;

    /**
     * 密文客户联系电话
     */
    @ApiModelProperty(value = "密文客户联系电话")
    private String enCustomerIphone;

    /**
     * 材料状态：01、待上传，02、重新上传，03、已上传
     */
    @ApiModelProperty(value = "材料状态：01、待上传，02、重新上传，03、已上传")
    private String materialStatus;

    /**
     * 收购状态：01、待收购，02、已收购，09、放弃收购
     */
    @ApiModelProperty(value = "收购状态：01、待收购，02、已收购，09、放弃收购")
    private String acquisitionStatus;

    /**
     * 审批状态：01、待确认，02、确认通过，03、待审批，04、审批通过，05、驳回，09、关闭
     */
    @ApiModelProperty(value = "审批状态：01、待确认，02、确认通过，03、待审批，04、审批通过，05、驳回，09、关闭")
    private String approvalStatus;

    /**
     * 询价单状态：01、待接单，02、已接单，09、放弃接单，11、待报价，12、已报价，17、报价失效，18、逾期未报价，19、放弃报价,21、待收购，22、待过户、23、收购完成、29、放弃收购
     */
    @ApiModelProperty(value = "询价单状态：01、待接单，02、已接单，09、放弃接单，11、待报价，12、已报价，17、报价失效，18、逾期未报价，19、放弃报价,21、待收购，22、待过户、23、收购完成、29、放弃收购")
    private String inquiryStatus;

    /**
     * 收购放弃原因
     */
    @ApiModelProperty(value = "收购放弃原因")
    private String acquisitionAbandonedReason;

    /**
     * 放弃原因
     */
    @ApiModelProperty(value = "放弃原因")
    private String orderAbandonedReason;

    /**
     * 驳回原因
     */
    @ApiModelProperty(value = "驳回原因")
    private String rejectedReason;

    /**
     * 品牌
     */
    @ApiModelProperty(value = "品牌")
    private String brand;

    /**
     * 品牌中文描述
     */
    @ApiModelProperty(value = "品牌中文描述")
    private String brandChineseDescribe;

    /**
     * 车系
     */
    @ApiModelProperty(value = "车系")
    private String carSeries;

    /**
     * 车系中文描述
     */
    @ApiModelProperty(value = "车系中文描述")
    private String carSeriesChineseDescribe;

    /**
     * 车型
     */
    @ApiModelProperty(value = "车型")
    private String carType;

    /**
     * 车型中文描述
     */
    @ApiModelProperty(value = "车型中文描述")
    private String carTypeChineseDescribe;

    /**
     * 年款
     */
    @ApiModelProperty(value = "车型")
    private String carYear;

    /**
     * 年款中文描述
     */
    @ApiModelProperty(value = "车型中文描述")
    private String carYearChineseDescribe;

    /**
     * 颜色
     */
    @ApiModelProperty(value = "颜色")
    private String color;

    /**
     * 车牌号
     */
    @ApiModelProperty(value = "车牌号")
    private String licensePlateNum;

    /**
     * vin码
     */
    @ApiModelProperty(value = "vin码")
    private String vinCode;

    /**
     * 过户次数
     */
    @ApiModelProperty(value = "过户次数")
    private String transferTimes;

    /**
     * 使用性质
     */
    @ApiModelProperty(value = "使用性质")
    private String usingNature;

    /**
     * 上牌城市
     */
    @ApiModelProperty(value = "上牌城市")
    private String licensingCity;

    /**
     * 上牌时间
     */
    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
    @ApiModelProperty(value = "上牌时间")
    private Date licensingDate;

    /**
     * 预计过户时间
     */
    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
    @ApiModelProperty(value = "预计过户时间")
    private Date estimatedTransferTime;

    /**
     * 行驶里程
     */
    @ApiModelProperty(value = "行驶里程")
    private Long drivingMileage;

    /**
     * 车商报价
     */
    @ApiModelProperty(value = "预计成交价")
    private Long estimateDealPrice;

    /**
     * 最后报价价格
     */
    @ApiModelProperty(value = "最后报价价格")
    private Long quoteEndPrice;

    /**
     * 最终成交价
     */
    @ApiModelProperty(value = "最终成交价")
    private Long dealPriceEnd;

    /**
     * 客户意向：01、同意，02、要求议价、03、客户拒绝
     */
    @ApiModelProperty(value = "客户意向：01、同意，02、要求议价、03、客户拒绝")
    private String customerIntention;

    /**
     * 发票号
     */
    @ApiModelProperty(value = "发票号")
    private String invoiceNum;

    /**
     * 支付方式
     */
    @ApiModelProperty(value = "支付方式")
    private String payType;

    /**
     * 预约检测时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "预约检测时间")
    private Date reservationDetectionDate;

    /**
     * 预约检测地点
     */
    @ApiModelProperty(value = "预约检测地点")
    private String reservationDetectionAddress;

    /**
     * 客户期望价格
     */
    @ApiModelProperty(value = "客户期望价格")
    private Long customerExpectPrice;

    /**
     * 制单人ID(指的是预约表里面的顾问或者经理、店长)
     */
    @ApiModelProperty(value = "制单人ID(指的是预约表里面的顾问或者经理、店长)")
    private Long makeOrderPersonId;

    /**
     * 制单人姓名(指的是预约表里面的顾问或者经理、店长)
     */
    @ApiModelProperty(value = "制单人姓名(指的是预约表里面的顾问或者经理、店长)")
    private String makeOrderPersonName;

    /**
     * 制单人角色
     */
    @ApiModelProperty(value = "制单人角色")
    private String makeOrderPersonRole;

    /**
     * 制单人联系电话(指的是预约表里面的顾问或者经理、店长)
     */
    @ApiModelProperty(value = "制单人联系电话(指的是预约表里面的顾问或者经理、店长)")
    private String makeOrderPersonIphone;

    /**
     * 密文
     */
    @ApiModelProperty(value = "密文制单人联系电话")
    private String enMakeOrderPersonIphone;

    /**
     * 业务单号
     */
    @ApiModelProperty(value = "业务单号")
    private String businessOrderNo;

    /**
     * 收购产生时间
     */
    @ApiModelProperty(value = "收购产生时间")
    private Date generateAcquisitionsTime;

    /**
     *首次上报时间
     */
    @ApiModelProperty(value = "首次上报时间")
    private Date firstEscalationTime;

    /**
     *二次上报时间
     */
    @ApiModelProperty(value = "二次上报时间")
    private Date secondEscalationTime;

    /**
     *旧车确认时间
     */
    @ApiModelProperty(value = "旧车确认时间")
    private Date oldCarConfirmationTime;

    /**
     * 审批通过时间
     */
    @ApiModelProperty(value = "审批通过时间")
    private Date approvedTime;

    /**
     * 驳回时间
     */
    @ApiModelProperty(value = "驳回时间")
    private Date overruleTime;

    /**
     * 关闭时间
     */
    @ApiModelProperty(value = "关闭时间")
    private Date closeTime;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remarks;
    
    @ApiModelProperty(value = "派单门店名称")
    private String storeName;
    
    @ApiModelProperty(value = "是否联系过门店人员")
    private Boolean isCallStore;

    public AcquisitionQueryResultDto() {
    }

    public AcquisitionQueryResultDto(Long reservationId, Long inquiryId, Long otherBrandInquiryId, String customerName, String customerIphone, String enCustomerIphone, String materialStatus, String acquisitionStatus, String approvalStatus, String inquiryStatus, String acquisitionAbandonedReason, String orderAbandonedReason, String rejectedReason, String brand, String brandChineseDescribe, String carSeries, String carSeriesChineseDescribe, String carType, String carTypeChineseDescribe, String carYear, String carYearChineseDescribe, String color, String licensePlateNum, String vinCode, String transferTimes, String usingNature, String licensingCity, Date licensingDate, Date estimatedTransferTime, Long drivingMileage, Long estimateDealPrice, Long quoteEndPrice, Long dealPriceEnd, String customerIntention, String invoiceNum, String payType, Date reservationDetectionDate, String reservationDetectionAddress, Long customerExpectPrice, Long makeOrderPersonId, String makeOrderPersonName, String makeOrderPersonRole, String makeOrderPersonIphone, String enMakeOrderPersonIphone, String businessOrderNo, Date generateAcquisitionsTime, Date firstEscalationTime, Date secondEscalationTime, Date oldCarConfirmationTime, Date approvedTime, Date overruleTime, Date closeTime, String remarks) {
        this.reservationId = reservationId;
        this.inquiryId = inquiryId;
        this.otherBrandInquiryId = otherBrandInquiryId;
        this.customerName = customerName;
        this.customerIphone = customerIphone;
        this.enCustomerIphone = enCustomerIphone;
        this.materialStatus = materialStatus;
        this.acquisitionStatus = acquisitionStatus;
        this.approvalStatus = approvalStatus;
        this.inquiryStatus = inquiryStatus;
        this.acquisitionAbandonedReason = acquisitionAbandonedReason;
        this.orderAbandonedReason = orderAbandonedReason;
        this.rejectedReason = rejectedReason;
        this.brand = brand;
        this.brandChineseDescribe = brandChineseDescribe;
        this.carSeries = carSeries;
        this.carSeriesChineseDescribe = carSeriesChineseDescribe;
        this.carType = carType;
        this.carTypeChineseDescribe = carTypeChineseDescribe;
        this.carYear = carYear;
        this.carYearChineseDescribe = carYearChineseDescribe;
        this.color = color;
        this.licensePlateNum = licensePlateNum;
        this.vinCode = vinCode;
        this.transferTimes = transferTimes;
        this.usingNature = usingNature;
        this.licensingCity = licensingCity;
        this.licensingDate = licensingDate;
        this.estimatedTransferTime = estimatedTransferTime;
        this.drivingMileage = drivingMileage;
        this.estimateDealPrice = estimateDealPrice;
        this.quoteEndPrice = quoteEndPrice;
        this.dealPriceEnd = dealPriceEnd;
        this.customerIntention = customerIntention;
        this.invoiceNum = invoiceNum;
        this.payType = payType;
        this.reservationDetectionDate = reservationDetectionDate;
        this.reservationDetectionAddress = reservationDetectionAddress;
        this.customerExpectPrice = customerExpectPrice;
        this.makeOrderPersonId = makeOrderPersonId;
        this.makeOrderPersonName = makeOrderPersonName;
        this.makeOrderPersonRole = makeOrderPersonRole;
        this.makeOrderPersonIphone = makeOrderPersonIphone;
        this.enMakeOrderPersonIphone = enMakeOrderPersonIphone;
        this.businessOrderNo = businessOrderNo;
        this.generateAcquisitionsTime = generateAcquisitionsTime;
        this.firstEscalationTime = firstEscalationTime;
        this.secondEscalationTime = secondEscalationTime;
        this.oldCarConfirmationTime = oldCarConfirmationTime;
        this.approvedTime = approvedTime;
        this.overruleTime = overruleTime;
        this.closeTime = closeTime;
        this.remarks = remarks;
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
     * @return inquiryId
     */
    public Long getInquiryId() {
        return inquiryId;
    }

    /**
     * 设置
     * @param inquiryId
     */
    public void setInquiryId(Long inquiryId) {
        this.inquiryId = inquiryId;
    }

    /**
     * 获取
     * @return otherBrandInquiryId
     */
    public Long getOtherBrandInquiryId() {
        return otherBrandInquiryId;
    }

    /**
     * 设置
     * @param otherBrandInquiryId
     */
    public void setOtherBrandInquiryId(Long otherBrandInquiryId) {
        this.otherBrandInquiryId = otherBrandInquiryId;
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
     * @return materialStatus
     */
    public String getMaterialStatus() {
        return materialStatus;
    }

    /**
     * 设置
     * @param materialStatus
     */
    public void setMaterialStatus(String materialStatus) {
        this.materialStatus = materialStatus;
    }

    /**
     * 获取
     * @return acquisitionStatus
     */
    public String getAcquisitionStatus() {
        return acquisitionStatus;
    }

    /**
     * 设置
     * @param acquisitionStatus
     */
    public void setAcquisitionStatus(String acquisitionStatus) {
        this.acquisitionStatus = acquisitionStatus;
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
     * @return inquiryStatus
     */
    public String getInquiryStatus() {
        return inquiryStatus;
    }

    /**
     * 设置
     * @param inquiryStatus
     */
    public void setInquiryStatus(String inquiryStatus) {
        this.inquiryStatus = inquiryStatus;
    }

    /**
     * 获取
     * @return acquisitionAbandonedReason
     */
    public String getAcquisitionAbandonedReason() {
        return acquisitionAbandonedReason;
    }

    /**
     * 设置
     * @param acquisitionAbandonedReason
     */
    public void setAcquisitionAbandonedReason(String acquisitionAbandonedReason) {
        this.acquisitionAbandonedReason = acquisitionAbandonedReason;
    }

    /**
     * 获取
     * @return orderAbandonedReason
     */
    public String getOrderAbandonedReason() {
        return orderAbandonedReason;
    }

    /**
     * 设置
     * @param orderAbandonedReason
     */
    public void setOrderAbandonedReason(String orderAbandonedReason) {
        this.orderAbandonedReason = orderAbandonedReason;
    }

    /**
     * 获取
     * @return rejectedReason
     */
    public String getRejectedReason() {
        return rejectedReason;
    }

    /**
     * 设置
     * @param rejectedReason
     */
    public void setRejectedReason(String rejectedReason) {
        this.rejectedReason = rejectedReason;
    }

    /**
     * 获取
     * @return brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * 设置
     * @param brand
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * 获取
     * @return brandChineseDescribe
     */
    public String getBrandChineseDescribe() {
        return brandChineseDescribe;
    }

    /**
     * 设置
     * @param brandChineseDescribe
     */
    public void setBrandChineseDescribe(String brandChineseDescribe) {
        this.brandChineseDescribe = brandChineseDescribe;
    }

    /**
     * 获取
     * @return carSeries
     */
    public String getCarSeries() {
        return carSeries;
    }

    /**
     * 设置
     * @param carSeries
     */
    public void setCarSeries(String carSeries) {
        this.carSeries = carSeries;
    }

    /**
     * 获取
     * @return carSeriesChineseDescribe
     */
    public String getCarSeriesChineseDescribe() {
        return carSeriesChineseDescribe;
    }

    /**
     * 设置
     * @param carSeriesChineseDescribe
     */
    public void setCarSeriesChineseDescribe(String carSeriesChineseDescribe) {
        this.carSeriesChineseDescribe = carSeriesChineseDescribe;
    }

    /**
     * 获取
     * @return carType
     */
    public String getCarType() {
        return carType;
    }

    /**
     * 设置
     * @param carType
     */
    public void setCarType(String carType) {
        this.carType = carType;
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
     * @return carYear
     */
    public String getCarYear() {
        return carYear;
    }

    /**
     * 设置
     * @param carYear
     */
    public void setCarYear(String carYear) {
        this.carYear = carYear;
    }

    /**
     * 获取
     * @return carYearChineseDescribe
     */
    public String getCarYearChineseDescribe() {
        return carYearChineseDescribe;
    }

    /**
     * 设置
     * @param carYearChineseDescribe
     */
    public void setCarYearChineseDescribe(String carYearChineseDescribe) {
        this.carYearChineseDescribe = carYearChineseDescribe;
    }

    /**
     * 获取
     * @return color
     */
    public String getColor() {
        return color;
    }

    /**
     * 设置
     * @param color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * 获取
     * @return licensePlateNum
     */
    public String getLicensePlateNum() {
        return licensePlateNum;
    }

    /**
     * 设置
     * @param licensePlateNum
     */
    public void setLicensePlateNum(String licensePlateNum) {
        this.licensePlateNum = licensePlateNum;
    }

    /**
     * 获取
     * @return vinCode
     */
    public String getVinCode() {
        return vinCode;
    }

    /**
     * 设置
     * @param vinCode
     */
    public void setVinCode(String vinCode) {
        this.vinCode = vinCode;
    }

    /**
     * 获取
     * @return transferTimes
     */
    public String getTransferTimes() {
        return transferTimes;
    }

    /**
     * 设置
     * @param transferTimes
     */
    public void setTransferTimes(String transferTimes) {
        this.transferTimes = transferTimes;
    }

    /**
     * 获取
     * @return usingNature
     */
    public String getUsingNature() {
        return usingNature;
    }

    /**
     * 设置
     * @param usingNature
     */
    public void setUsingNature(String usingNature) {
        this.usingNature = usingNature;
    }

    /**
     * 获取
     * @return licensingCity
     */
    public String getLicensingCity() {
        return licensingCity;
    }

    /**
     * 设置
     * @param licensingCity
     */
    public void setLicensingCity(String licensingCity) {
        this.licensingCity = licensingCity;
    }

    /**
     * 获取
     * @return licensingDate
     */
    public Date getLicensingDate() {
        return licensingDate;
    }

    /**
     * 设置
     * @param licensingDate
     */
    public void setLicensingDate(Date licensingDate) {
        this.licensingDate = licensingDate;
    }

    /**
     * 获取
     * @return estimatedTransferTime
     */
    public Date getEstimatedTransferTime() {
        return estimatedTransferTime;
    }

    /**
     * 设置
     * @param estimatedTransferTime
     */
    public void setEstimatedTransferTime(Date estimatedTransferTime) {
        this.estimatedTransferTime = estimatedTransferTime;
    }

    /**
     * 获取
     * @return drivingMileage
     */
    public Long getDrivingMileage() {
        return drivingMileage;
    }

    /**
     * 设置
     * @param drivingMileage
     */
    public void setDrivingMileage(Long drivingMileage) {
        this.drivingMileage = drivingMileage;
    }

    /**
     * 获取
     * @return estimateDealPrice
     */
    public Long getEstimateDealPrice() {
        return estimateDealPrice;
    }

    /**
     * 设置
     * @param estimateDealPrice
     */
    public void setEstimateDealPrice(Long estimateDealPrice) {
        this.estimateDealPrice = estimateDealPrice;
    }

    /**
     * 获取
     * @return quoteEndPrice
     */
    public Long getQuoteEndPrice() {
        return quoteEndPrice;
    }

    /**
     * 设置
     * @param quoteEndPrice
     */
    public void setQuoteEndPrice(Long quoteEndPrice) {
        this.quoteEndPrice = quoteEndPrice;
    }

    /**
     * 获取
     * @return dealPriceEnd
     */
    public Long getDealPriceEnd() {
        return dealPriceEnd;
    }

    /**
     * 设置
     * @param dealPriceEnd
     */
    public void setDealPriceEnd(Long dealPriceEnd) {
        this.dealPriceEnd = dealPriceEnd;
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
     * @return invoiceNum
     */
    public String getInvoiceNum() {
        return invoiceNum;
    }

    /**
     * 设置
     * @param invoiceNum
     */
    public void setInvoiceNum(String invoiceNum) {
        this.invoiceNum = invoiceNum;
    }

    /**
     * 获取
     * @return payType
     */
    public String getPayType() {
        return payType;
    }

    /**
     * 设置
     * @param payType
     */
    public void setPayType(String payType) {
        this.payType = payType;
    }

    /**
     * 获取
     * @return reservationDetectionDate
     */
    public Date getReservationDetectionDate() {
        return reservationDetectionDate;
    }

    /**
     * 设置
     * @param reservationDetectionDate
     */
    public void setReservationDetectionDate(Date reservationDetectionDate) {
        this.reservationDetectionDate = reservationDetectionDate;
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
     * @return customerExpectPrice
     */
    public Long getCustomerExpectPrice() {
        return customerExpectPrice;
    }

    /**
     * 设置
     * @param customerExpectPrice
     */
    public void setCustomerExpectPrice(Long customerExpectPrice) {
        this.customerExpectPrice = customerExpectPrice;
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
     * @return generateAcquisitionsTime
     */
    public Date getGenerateAcquisitionsTime() {
        return generateAcquisitionsTime;
    }

    /**
     * 设置
     * @param generateAcquisitionsTime
     */
    public void setGenerateAcquisitionsTime(Date generateAcquisitionsTime) {
        this.generateAcquisitionsTime = generateAcquisitionsTime;
    }

    /**
     * 获取
     * @return firstEscalationTime
     */
    public Date getFirstEscalationTime() {
        return firstEscalationTime;
    }

    /**
     * 设置
     * @param firstEscalationTime
     */
    public void setFirstEscalationTime(Date firstEscalationTime) {
        this.firstEscalationTime = firstEscalationTime;
    }

    /**
     * 获取
     * @return secondEscalationTime
     */
    public Date getSecondEscalationTime() {
        return secondEscalationTime;
    }

    /**
     * 设置
     * @param secondEscalationTime
     */
    public void setSecondEscalationTime(Date secondEscalationTime) {
        this.secondEscalationTime = secondEscalationTime;
    }

    /**
     * 获取
     * @return oldCarConfirmationTime
     */
    public Date getOldCarConfirmationTime() {
        return oldCarConfirmationTime;
    }

    /**
     * 设置
     * @param oldCarConfirmationTime
     */
    public void setOldCarConfirmationTime(Date oldCarConfirmationTime) {
        this.oldCarConfirmationTime = oldCarConfirmationTime;
    }

    /**
     * 获取
     * @return approvedTime
     */
    public Date getApprovedTime() {
        return approvedTime;
    }

    /**
     * 设置
     * @param approvedTime
     */
    public void setApprovedTime(Date approvedTime) {
        this.approvedTime = approvedTime;
    }

    /**
     * 获取
     * @return overruleTime
     */
    public Date getOverruleTime() {
        return overruleTime;
    }

    /**
     * 设置
     * @param overruleTime
     */
    public void setOverruleTime(Date overruleTime) {
        this.overruleTime = overruleTime;
    }

    /**
     * 获取
     * @return closeTime
     */
    public Date getCloseTime() {
        return closeTime;
    }

    /**
     * 设置
     * @param closeTime
     */
    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
    }

    /**
     * 获取
     * @return remarks
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置
     * @param remarks
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * 获取
     * @return enCustomerIphone
     */
    public String getEnCustomerIphone() {
        return enCustomerIphone;
    }

    /**
     * 设置
     * @param enCustomerIphone
     */
    public void setEnCustomerIphone(String enCustomerIphone) {
        this.enCustomerIphone = enCustomerIphone;
    }

    /**
     * 获取
     * @return enMakeOrderPersonIphone
     */
    public String getEnMakeOrderPersonIphone() {
        return enMakeOrderPersonIphone;
    }

    /**
     * 设置
     * @param enMakeOrderPersonIphone
     */
    public void setEnMakeOrderPersonIphone(String enMakeOrderPersonIphone) {
        this.enMakeOrderPersonIphone = enMakeOrderPersonIphone;
    }

    public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public Boolean getIsCallStore() {
		return isCallStore;
	}

	public void setIsCallStore(Boolean isCallStore) {
		this.isCallStore = isCallStore;
	}

	public String toString() {
        return "AcquisitionQueryResultDto{reservationId = " + reservationId + ", inquiryId = " + inquiryId + ", otherBrandInquiryId = " + otherBrandInquiryId + ", customerName = " + customerName + ", customerIphone = " + customerIphone + ", enCustomerIphone = " + enCustomerIphone + ", materialStatus = " + materialStatus + ", acquisitionStatus = " + acquisitionStatus + ", approvalStatus = " + approvalStatus + ", inquiryStatus = " + inquiryStatus + ", acquisitionAbandonedReason = " + acquisitionAbandonedReason + ", orderAbandonedReason = " + orderAbandonedReason + ", rejectedReason = " + rejectedReason + ", brand = " + brand + ", brandChineseDescribe = " + brandChineseDescribe + ", carSeries = " + carSeries + ", carSeriesChineseDescribe = " + carSeriesChineseDescribe + ", carType = " + carType + ", carTypeChineseDescribe = " + carTypeChineseDescribe + ", carYear = " + carYear + ", carYearChineseDescribe = " + carYearChineseDescribe + ", color = " + color + ", licensePlateNum = " + licensePlateNum + ", vinCode = " + vinCode + ", transferTimes = " + transferTimes + ", usingNature = " + usingNature + ", licensingCity = " + licensingCity + ", licensingDate = " + licensingDate + ", estimatedTransferTime = " + estimatedTransferTime + ", drivingMileage = " + drivingMileage + ", estimateDealPrice = " + estimateDealPrice + ", quoteEndPrice = " + quoteEndPrice + ", dealPriceEnd = " + dealPriceEnd + ", customerIntention = " + customerIntention + ", invoiceNum = " + invoiceNum + ", payType = " + payType + ", reservationDetectionDate = " + reservationDetectionDate + ", reservationDetectionAddress = " + reservationDetectionAddress + ", customerExpectPrice = " + customerExpectPrice + ", makeOrderPersonId = " + makeOrderPersonId + ", makeOrderPersonName = " + makeOrderPersonName + ", makeOrderPersonRole = " + makeOrderPersonRole + ", makeOrderPersonIphone = " + makeOrderPersonIphone + ", enMakeOrderPersonIphone = " + enMakeOrderPersonIphone + ", businessOrderNo = " + businessOrderNo + ", generateAcquisitionsTime = " + generateAcquisitionsTime + ", firstEscalationTime = " + firstEscalationTime + ", secondEscalationTime = " + secondEscalationTime + ", oldCarConfirmationTime = " + oldCarConfirmationTime + ", approvedTime = " + approvedTime + ", overruleTime = " + overruleTime + ", closeTime = " + closeTime + ", remarks = " + remarks + "}";
    }
}
