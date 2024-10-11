package com.exp.ucmp.storeApp.dto;

import com.egrid.core.base.model.BaseModel;
import com.exp.ucmp.entity.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Digits;
import java.util.Date;



@ApiModel(value = "ReplaceCluesDetailsDto", description = "客户置换单信息")
public class ReplaceCluesDetailsDto extends BaseModel {
    private static final long serialVersionUID = 1L;
    /**
     * 询价单状态
     */
    @ApiModelProperty(value = "询价单状态")
    private String inquiryStatus;
    
    @ApiModelProperty(value = "询价单状态")
    private String inquiryStatusName;

    /**
     * 签到状态
     */
    @ApiModelProperty(value = "签到状态(0-全签到，1-未)")
    private String signAll;

    /**
     * 预约ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "预约ID")
    private Long reservationId;


    /**
     * 车商ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "车商ID")
    private Long carDealerId;



    /**
     * 门店ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "门店ID")
    private Long storeId;


    /**
     * 车商名字
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "车商名字")
    private String carDealerName;


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
     * 年款
     */
    @ApiModelProperty(value = "年款")
    private String carYear;



    /**
     * 年款中文描述
     */
    @ApiModelProperty(value = "年款中文描述")
    private String carYearChineseDescribe;

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
     * 行驶里程
     */
   @ApiModelProperty(value = "行驶里程")
    private String drivingMileage;


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
     * 出价车商
     */
    @ApiModelProperty(value = "出价车商")
    private String quoteMerchantsName;


    /**
     * 客户期望价格
     */
    @Digits(integer=9, fraction=0, message="客户期望价格 数字精度必须符合(9,0)", groups = {PsiCustomerReservationMsgEntity.PsiCustomerReservationMsgEntityValidGroup.class, PsiCustomerReservationMsgEntity.CustomerExpectPriceValidGroup.class})
    @ApiModelProperty(value = "客户期望价格")
    private Long customerExpectPrice;


    /**
     * 最优价
     */
    @Digits(integer=9, fraction=0, message="最优价 数字精度必须符合(9,0)", groups = {PsiCustomerReservationMsgEntity.PsiCustomerReservationMsgEntityValidGroup.class, PsiCustomerReservationMsgEntity.CustomerExpectPriceValidGroup.class})
    @ApiModelProperty(value = "最优价")
    private Long estimateDealPrice;

    /**
     * 最优价
     */
    @Digits(integer=9, fraction=0, message="客户期望价格 数字精度必须符合(9,0)", groups = {PsiCustomerReservationMsgEntity.PsiCustomerReservationMsgEntityValidGroup.class, PsiCustomerReservationMsgEntity.CustomerExpectPriceValidGroup.class})
    @ApiModelProperty(value = "最优价")
    private Long quoteEndPrice;


    /**
     * 接单截止时间(录入)
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "接单截止时间(录入)")
    private Date orderReceivingDeadline;


    /**
     * 预约单创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "预约单创建时间")
    private Date createdDate;


    /**
     * 报价截止时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "报价截止时间")
        private Date quoteDeadline;


    /**
     * 制单人姓名(指的是预约表里面的顾问或者经理、店长)
     */
    @ApiModelProperty(value = "制单人姓名(指的是预约表里面的顾问或者经理、店长)")
    private String makeOrderPersonName;

    /**
     * 制单人电话(指的是预约表里面的顾问或者经理、店长)
     */
    @ApiModelProperty(value = "制单人电话(指的是预约表里面的顾问或者经理、店长)")
    private String makeOrderPersonIphone;

    /**
     * 密文制单人电话
     */
    @ApiModelProperty(value = "密文制单人电话")
    private String enMakeOrderPersonIphone;


    /**
     * 客户姓名
     */
    @ApiModelProperty(value = "客户姓名")
    private String customerName;


    /**
     * 客户电话
     */
    @ApiModelProperty(value = "客户电话")
    private String customerIphone;

    /**
     * 密文客户电话
     */
    @ApiModelProperty(value = "密文客户电话")
    private String enCustomerIphone;


    /**
     * 来源
     * 0201	录入
     * 0202	小程序
     * 0203	高合APP
     * 0204	官网
     */
    @ApiModelProperty(value = "来源" +
            "0201\tEOS\n" +
            "     * 0202\t小程序\n" +
            "     * 0203\t高合APP\n" +
            "     * 0204\t官网")
    private String cluesSource;



    /**
     * 关闭原因
     * 0601	无车商接单
     * 0602	无车商报价
     * 0603	无车商收购
     * 0604	客户拒绝
     */

    @ApiModelProperty(value = "关闭原因0601\t无车商接单\n" +
            "0602\t无车商报价\n" +
            "0603\t无车商收购\n" +
            "0604\t客户拒绝\n")
    private String shutCause;


    @ApiModelProperty(value = "是否link新车")
    private Boolean linkFlag;


    @ApiModelProperty(value = "最终成交价")
    private String dealPriceEnd;


    /**
     * 关闭时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "关闭时间")
    private Date shutDate;

    /**
     * 跟踪状态
     * 0701	待分配
     * 0702	已分配
     * 0703	待检测
     * 0704	检测中
     * 0705	已报价
     * 0706	已完成
     * 0709	已关闭
     * 0711 无车商接单
     * 0712 无车商报价
     * 0713 无车商收购
     */
    @ApiModelProperty(value = "跟踪状态：0701\t待分配\n" +
            "0702\t已分配\n" +
            "0703\t待检测\n" +
            "0704\t检测中\n" +
            "0705\t已报价\n" +
            "0706\t已完成\n" +
            "0709\t已关闭\n/" +
            "0711\t无车商接单\n/" +
            "0712\t无车商报价\n/" +
            "0713\t无车商收购\n/" +
            "置换模块查询四个tab需要传的参数(预约单传0701,0702,0711/已报价传0703,0704,0712/已完成传0705,0706,0713/已关闭传0709)")
    private String trackStatus;


    /**
     * 业务单号
     */
    @ApiModelProperty(value = "业务单号")
    private String businessOrderNo;



    /**
     * 关闭原因描述
     */
    @ApiModelProperty(value = "关闭原因描述")
    private String shutDescribe;

    public String getSignAll() {
        return signAll;
    }

    public void setSignAll(String signAll) {
        this.signAll = signAll;
    }
    
    public String getInquiryStatus() {
        return inquiryStatus;
    }

    public void setInquiryStatus(String inquiryStatus) {
        this.inquiryStatus = inquiryStatus;
    }

    public String getInquiryStatusName() {
		return inquiryStatusName;
	}

	public void setInquiryStatusName(String inquiryStatusName) {
		this.inquiryStatusName = inquiryStatusName;
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
     * @return carDealerId
     */
    public Long getCarDealerId() {
        return carDealerId;
    }

    /**
     * 设置
     * @param carDealerId
     */
    public void setCarDealerId(Long carDealerId) {
        this.carDealerId = carDealerId;
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
     * @return carDealerName
     */
    public String getCarDealerName() {
        return carDealerName;
    }

    /**
     * 设置
     * @param carDealerName
     */
    public void setCarDealerName(String carDealerName) {
        this.carDealerName = carDealerName;
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
     * @return drivingMileage
     */
    public String getDrivingMileage() {
        return drivingMileage;
    }

    /**
     * 设置
     * @param drivingMileage
     */
    public void setDrivingMileage(String drivingMileage) {
        this.drivingMileage = drivingMileage;
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
     * @return quoteMerchantsName
     */
    public String getQuoteMerchantsName() {
        return quoteMerchantsName;
    }

    /**
     * 设置
     * @param quoteMerchantsName
     */
    public void setQuoteMerchantsName(String quoteMerchantsName) {
        this.quoteMerchantsName = quoteMerchantsName;
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
     * @return orderReceivingDeadline
     */
    public Date getOrderReceivingDeadline() {
        return orderReceivingDeadline;
    }

    /**
     * 设置
     * @param orderReceivingDeadline
     */
    public void setOrderReceivingDeadline(Date orderReceivingDeadline) {
        this.orderReceivingDeadline = orderReceivingDeadline;
    }

    /**
     * 获取
     * @return createdDate
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    /**
     * 设置
     * @param createdDate
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * 获取
     * @return quoteDeadline
     */
    public Date getQuoteDeadline() {
        return quoteDeadline;
    }

    /**
     * 设置
     * @param quoteDeadline
     */
    public void setQuoteDeadline(Date quoteDeadline) {
        this.quoteDeadline = quoteDeadline;
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
     * @return shutCause
     */
    public String getShutCause() {
        return shutCause;
    }

    /**
     * 设置
     * @param shutCause
     */
    public void setShutCause(String shutCause) {
        this.shutCause = shutCause;
    }

    /**
     * 获取
     * @return linkFlag
     */
    public Boolean getLinkFlag() {
        return linkFlag;
    }

    /**
     * 设置
     * @param linkFlag
     */
    public void setLinkFlag(Boolean linkFlag) {
        this.linkFlag = linkFlag;
    }

    /**
     * 获取
     * @return dealPriceEnd
     */
    public String getDealPriceEnd() {
        return dealPriceEnd;
    }

    /**
     * 设置
     * @param dealPriceEnd
     */
    public void setDealPriceEnd(String dealPriceEnd) {
        this.dealPriceEnd = dealPriceEnd;
    }

    /**
     * 获取
     * @return shutDate
     */
    public Date getShutDate() {
        return shutDate;
    }

    /**
     * 设置
     * @param shutDate
     */
    public void setShutDate(Date shutDate) {
        this.shutDate = shutDate;
    }

    /**
     * 获取
     * @return trackStatus
     */
    public String getTrackStatus() {
        return trackStatus;
    }

    /**
     * 设置
     * @param trackStatus
     */
    public void setTrackStatus(String trackStatus) {
        this.trackStatus = trackStatus;
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
     * @return shutDescribe
     */
    public String getShutDescribe() {
        return shutDescribe;
    }

    /**
     * 设置
     * @param shutDescribe
     */
    public void setShutDescribe(String shutDescribe) {
        this.shutDescribe = shutDescribe;
    }

    public String toString() {
        return "ReplaceCluesDetailsDto{reservationId = " + reservationId + ", carDealerId = " + carDealerId + ", storeId = " + storeId + ", carDealerName = " + carDealerName + ", carType = " + carType + ", carTypeChineseDescribe = " + carTypeChineseDescribe + ", brand = " + brand + ", brandChineseDescribe = " + brandChineseDescribe + ", carSeries = " + carSeries + ", carSeriesChineseDescribe = " + carSeriesChineseDescribe + ", carYear = " + carYear + ", carYearChineseDescribe = " + carYearChineseDescribe + ", licensingCity = " + licensingCity + ", licensingDate = " + licensingDate + ", drivingMileage = " + drivingMileage + ", reservationDetectionDate = " + reservationDetectionDate + ", reservationDetectionAddress = " + reservationDetectionAddress + ", quoteMerchantsName = " + quoteMerchantsName + ", customerExpectPrice = " + customerExpectPrice + ", estimateDealPrice = " + estimateDealPrice + ", quoteEndPrice = " + quoteEndPrice + ", orderReceivingDeadline = " + orderReceivingDeadline + ", createdDate = " + createdDate + ", quoteDeadline = " + quoteDeadline + ", makeOrderPersonName = " + makeOrderPersonName + ", makeOrderPersonIphone = " + makeOrderPersonIphone + ", enMakeOrderPersonIphone = " + enMakeOrderPersonIphone + ", customerName = " + customerName + ", customerIphone = " + customerIphone + ", enCustomerIphone = " + enCustomerIphone + ", cluesSource = " + cluesSource + ", shutCause = " + shutCause + ", linkFlag = " + linkFlag + ", dealPriceEnd = " + dealPriceEnd + ", shutDate = " + shutDate + ", trackStatus = " + trackStatus + ", businessOrderNo = " + businessOrderNo + ", shutDescribe = " + shutDescribe + "}";
    }
}
