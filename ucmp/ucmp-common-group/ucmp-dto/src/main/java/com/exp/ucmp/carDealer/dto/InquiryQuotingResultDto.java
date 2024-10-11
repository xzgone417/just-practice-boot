package com.exp.ucmp.carDealer.dto;

import com.egrid.core.base.model.BaseModel;
import com.exp.ucmp.entity.PsiCarDealerInquiryEntity;
import com.exp.ucmp.entity.PsiCarDealerInquiryEntity.PsiCarDealerInquiryEntityValidGroup;
import com.exp.ucmp.entity.PsiCarDealerInquiryEntity.RemarksValidGroup;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

@ApiModel(value = "InquiryQuotingResultDto", description = "询价查询报价结果对象")
public class InquiryQuotingResultDto extends BaseModel {

    /**
     *
     */
    private static final long serialVersionUID = 6985996612987118009L;

    /**
     * 询价ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "询价ID")
    private Long inquiryId;

    /**
     * 预约ID
     */
    @ApiModelProperty(value = "预约ID")
    private Long reservationId;

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
     * 制单人联系电话(指的是预约表里面的顾问或者经理、店长)
     */
    @ApiModelProperty(value = "制单人联系电话(指的是预约表里面的顾问或者经理、店长)")
    private String makeOrderPersonIphone;

    /**
     * 密文制单人联系电话
     */
    @ApiModelProperty(value = "密文制单人联系电话")
    private String enMakeOrderPersonIphone;

    /**
     * 制单人角色(指的是预约表里面的顾问或者经理、店长)
     */
    @ApiModelProperty(value = "制单人角色(指的是预约表里面的顾问或者经理、店长)")
    private String makeOrderPersonRole;

    /**
     * 报价截止时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "报价截止时间")
    private Date quoteDeadline;

    /**
     * 接单截止时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "接单截止时间")
    private Date orderReceivingDeadline;


    /**
     * 询价单状态：01、待接单，02、已接单，09、放弃接单，11、待报价，12、已报价，18、逾期未报价，19、放弃报价
     */
    @ApiModelProperty(value = "询价单状态：01、待接单，02、已接单，09、放弃接单，11、待报价，12、已报价，17、报价失效，18、逾期未报价，19、放弃报价")
    private String inquiryStatus;

    /**
     * 审批状态：01、待确认，02、确认通过，03、待审批，04、审批通过，05、驳回，09、关闭
     */
    @ApiModelProperty(value = "审批状态：01、待确认，02、确认通过，03、待审批，04、审批通过，05、驳回，09、关闭")
    private String approvalStatus;

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
     * 车系中文描述
     */
    @ApiModelProperty(value = "车系中文描述")
    private String carSeriesChineseDescribe;

    /**
     * 车系
     */
    @ApiModelProperty(value = "车系")
    private String carSeries;

    /**
     * 车型中文描述
     */
    @ApiModelProperty(value = "车型中文描述")
    private String carTypeChineseDescribe;

    /**
     * 车型
     */
    @ApiModelProperty(value = "车型")
    private String carType;

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
    private BigDecimal drivingMileage;


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
     * 姓名
     */
    @ApiModelProperty(value = "姓名")
    private String  customerName;

    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号")
    private String customerIphone;

    /**
     * 密文手机号
     */
    @ApiModelProperty(value = "密文手机号")
    private String enCustomerIphone;

    /**
     * 年款中文描述
     */
    @ApiModelProperty(value = "年款中文描述")
    private String carYearChineseDescribe;

    /**
     * 年款
     */
    @ApiModelProperty(value = "年款")
    private String carYear;

    /**
     * 上牌城市
     */
    @ApiModelProperty(value = "上牌城市")
    private String licensingCity;

    /**
     * 上牌省份
     */
    @ApiModelProperty(value = "上牌省份")
    private String licensingProvince;


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
     * VIN码
     */
    @ApiModelProperty(value = "VIN码")
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
     * 最后报价价格
     */
    @ApiModelProperty(value = "最后报价价格")
    private BigDecimal quoteEndPrice;

    /**
     * 最后报价时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "最后报价时间")
    private Date quoteEndDate;

    /**
     * 放弃原因
     */
    @ApiModelProperty(value = "放弃原因")
    private String orderAbandonedReason;

    /**
     * 客户意向
     */
    @ApiModelProperty(value = "客户意向:0601、同意，02、要求议价、03、客户拒绝")
    private String customerIntention;

    /**
     * 预约单号
     */
    @ApiModelProperty(value = "预约单号")
    private String businessOrderNo;

    /**
     * 预计过户时间
     */
    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
    @ApiModelProperty(value = "预计过户时间")
    private Date estimatedTransferTime;

    /**
     * 最终成交价
     */
    @ApiModelProperty(value = "最终成交价")
    private Long dealPriceEnd;

    /**
     * 收购产生时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "收购产生时间")
    private Date generateAcquisitionsTime;

    /**
     * 首次上报时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "首次上报时间")
    private Date firstEscalationTime;

    /**
     * 二次上报时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "二次上报时间")
    private Date secondEscalationTime;

    /**
     * 旧车确认时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "旧车确认时间")
    private Date oldCarConfirmationTime;

    /**
     * 审批通过时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "审批通过时间")
    private Date approvedTime;

    /**
     * 驳回时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "驳回时间")
    private Date overruleTime;

    /**
     * 关闭时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "关闭时间")
    private Date closeTime;

    /**
     * 备注
     */
    @Size(min=0, max=500, message="备注 字符长度必须小于等于500", groups = {PsiCarDealerInquiryEntity.PsiCarDealerInquiryEntityValidGroup.class, PsiCarDealerInquiryEntity.RemarksValidGroup.class})
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 文件上传时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "文件上传时间")
    private Date uploadFileTime;
    
    @ApiModelProperty(value = "派单门店名称")
    private String storeName;
    
    @ApiModelProperty(value = "是否联系过门店人员")
    private Boolean isCallStore;
    
    public InquiryQuotingResultDto(Long inquiryId, Long reservationId, Long makeOrderPersonId,
			String makeOrderPersonName, String makeOrderPersonIphone, String enMakeOrderPersonIphone,
			String makeOrderPersonRole, Date quoteDeadline, Date orderReceivingDeadline, String inquiryStatus,
			String approvalStatus, String brand, String brandChineseDescribe, String carSeriesChineseDescribe,
			String carSeries, String carTypeChineseDescribe, String carType, Date licensingDate,
			BigDecimal drivingMileage, Date reservationDetectionDate, String reservationDetectionAddress,
			Long customerExpectPrice, String customerName, String customerIphone, String enCustomerIphone,
			String carYearChineseDescribe, String carYear, String licensingCity, String licensingProvince, String color,
			String licensePlateNum, String vinCode, String transferTimes, String usingNature, BigDecimal quoteEndPrice,
			Date quoteEndDate, String orderAbandonedReason, String customerIntention, String businessOrderNo,
			Date estimatedTransferTime, Long dealPriceEnd, Date generateAcquisitionsTime, Date firstEscalationTime,
			Date secondEscalationTime, Date oldCarConfirmationTime, Date approvedTime, Date overruleTime,
			Date closeTime,
			@Size(min = 0, max = 500, message = "备注 字符长度必须小于等于500", groups = {
					PsiCarDealerInquiryEntityValidGroup.class, RemarksValidGroup.class }) String remarks,
			Date uploadFileTime, String storeName) {
		super();
		this.inquiryId = inquiryId;
		this.reservationId = reservationId;
		this.makeOrderPersonId = makeOrderPersonId;
		this.makeOrderPersonName = makeOrderPersonName;
		this.makeOrderPersonIphone = makeOrderPersonIphone;
		this.enMakeOrderPersonIphone = enMakeOrderPersonIphone;
		this.makeOrderPersonRole = makeOrderPersonRole;
		this.quoteDeadline = quoteDeadline;
		this.orderReceivingDeadline = orderReceivingDeadline;
		this.inquiryStatus = inquiryStatus;
		this.approvalStatus = approvalStatus;
		this.brand = brand;
		this.brandChineseDescribe = brandChineseDescribe;
		this.carSeriesChineseDescribe = carSeriesChineseDescribe;
		this.carSeries = carSeries;
		this.carTypeChineseDescribe = carTypeChineseDescribe;
		this.carType = carType;
		this.licensingDate = licensingDate;
		this.drivingMileage = drivingMileage;
		this.reservationDetectionDate = reservationDetectionDate;
		this.reservationDetectionAddress = reservationDetectionAddress;
		this.customerExpectPrice = customerExpectPrice;
		this.customerName = customerName;
		this.customerIphone = customerIphone;
		this.enCustomerIphone = enCustomerIphone;
		this.carYearChineseDescribe = carYearChineseDescribe;
		this.carYear = carYear;
		this.licensingCity = licensingCity;
		this.licensingProvince = licensingProvince;
		this.color = color;
		this.licensePlateNum = licensePlateNum;
		this.vinCode = vinCode;
		this.transferTimes = transferTimes;
		this.usingNature = usingNature;
		this.quoteEndPrice = quoteEndPrice;
		this.quoteEndDate = quoteEndDate;
		this.orderAbandonedReason = orderAbandonedReason;
		this.customerIntention = customerIntention;
		this.businessOrderNo = businessOrderNo;
		this.estimatedTransferTime = estimatedTransferTime;
		this.dealPriceEnd = dealPriceEnd;
		this.generateAcquisitionsTime = generateAcquisitionsTime;
		this.firstEscalationTime = firstEscalationTime;
		this.secondEscalationTime = secondEscalationTime;
		this.oldCarConfirmationTime = oldCarConfirmationTime;
		this.approvedTime = approvedTime;
		this.overruleTime = overruleTime;
		this.closeTime = closeTime;
		this.remarks = remarks;
		this.uploadFileTime = uploadFileTime;
		this.storeName = storeName;
	}

	public Long getInquiryId() {
        return inquiryId;
    }

    public void setInquiryId(Long inquiryId) {
        this.inquiryId = inquiryId;
    }

    public Long getReservationId() {
        return reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

    public Long getMakeOrderPersonId() {
        return makeOrderPersonId;
    }

    public void setMakeOrderPersonId(Long makeOrderPersonId) {
        this.makeOrderPersonId = makeOrderPersonId;
    }

    public String getMakeOrderPersonName() {
        return makeOrderPersonName;
    }

    public void setMakeOrderPersonName(String makeOrderPersonName) {
        this.makeOrderPersonName = makeOrderPersonName;
    }

    public String getMakeOrderPersonIphone() {
        return makeOrderPersonIphone;
    }

    public void setMakeOrderPersonIphone(String makeOrderPersonIphone) {
        this.makeOrderPersonIphone = makeOrderPersonIphone;
    }

    public String getMakeOrderPersonRole() {
        return makeOrderPersonRole;
    }

    public void setMakeOrderPersonRole(String makeOrderPersonRole) {
        this.makeOrderPersonRole = makeOrderPersonRole;
    }

    public Date getQuoteDeadline() {
        return quoteDeadline;
    }

    public void setQuoteDeadline(Date quoteDeadline) {
        this.quoteDeadline = quoteDeadline;
    }

    public String getInquiryStatus() {
        return inquiryStatus;
    }

    public void setInquiryStatus(String inquiryStatus) {
        this.inquiryStatus = inquiryStatus;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrandChineseDescribe() {
        return brandChineseDescribe;
    }

    public void setBrandChineseDescribe(String brandChineseDescribe) {
        this.brandChineseDescribe = brandChineseDescribe;
    }

    public String getCarSeriesChineseDescribe() {
        return carSeriesChineseDescribe;
    }

    public void setCarSeriesChineseDescribe(String carSeriesChineseDescribe) {
        this.carSeriesChineseDescribe = carSeriesChineseDescribe;
    }

    public String getCarSeries() {
        return carSeries;
    }

    public void setCarSeries(String carSeries) {
        this.carSeries = carSeries;
    }

    public String getCarTypeChineseDescribe() {
        return carTypeChineseDescribe;
    }

    public void setCarTypeChineseDescribe(String carTypeChineseDescribe) {
        this.carTypeChineseDescribe = carTypeChineseDescribe;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public Date getLicensingDate() {
        return licensingDate;
    }

    public void setLicensingDate(Date licensingDate) {
        this.licensingDate = licensingDate;
    }

    public BigDecimal getDrivingMileage() {
        return drivingMileage;
    }

    public void setDrivingMileage(BigDecimal drivingMileage) {
        this.drivingMileage = drivingMileage;
    }

    public Date getReservationDetectionDate() {
        return reservationDetectionDate;
    }

    public void setReservationDetectionDate(Date reservationDetectionDate) {
        this.reservationDetectionDate = reservationDetectionDate;
    }

    public String getReservationDetectionAddress() {
        return reservationDetectionAddress;
    }

    public void setReservationDetectionAddress(String reservationDetectionAddress) {
        this.reservationDetectionAddress = reservationDetectionAddress;
    }

    public Long getCustomerExpectPrice() {
        return customerExpectPrice;
    }

    public void setCustomerExpectPrice(Long customerExpectPrice) {
        this.customerExpectPrice = customerExpectPrice;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerIphone() {
        return customerIphone;
    }

    public void setCustomerIphone(String customerIphone) {
        this.customerIphone = customerIphone;
    }

    public String getCarYearChineseDescribe() {
        return carYearChineseDescribe;
    }

    public void setCarYearChineseDescribe(String carYearChineseDescribe) {
        this.carYearChineseDescribe = carYearChineseDescribe;
    }

    public String getCarYear() {
        return carYear;
    }

    public void setCarYear(String carYear) {
        this.carYear = carYear;
    }

    public String getLicensingCity() {
        return licensingCity;
    }

    public void setLicensingCity(String licensingCity) {
        this.licensingCity = licensingCity;
    }

    public String getLicensingProvince() {
        return licensingProvince;
    }

    public void setLicensingProvince(String licensingProvince) {
        this.licensingProvince = licensingProvince;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getLicensePlateNum() {
        return licensePlateNum;
    }

    public void setLicensePlateNum(String licensePlateNum) {
        this.licensePlateNum = licensePlateNum;
    }

    public String getVinCode() {
        return vinCode;
    }

    public void setVinCode(String vinCode) {
        this.vinCode = vinCode;
    }

    public String getTransferTimes() {
        return transferTimes;
    }

    public void setTransferTimes(String transferTimes) {
        this.transferTimes = transferTimes;
    }

    public String getUsingNature() {
        return usingNature;
    }

    public void setUsingNature(String usingNature) {
        this.usingNature = usingNature;
    }

    public BigDecimal getQuoteEndPrice() {
        return quoteEndPrice;
    }

    public void setQuoteEndPrice(BigDecimal quoteEndPrice) {
        this.quoteEndPrice = quoteEndPrice;
    }

    public Date getQuoteEndDate() {
        return quoteEndDate;
    }

    public void setQuoteEndDate(Date quoteEndDate) {
        this.quoteEndDate = quoteEndDate;
    }

    public String getOrderAbandonedReason() {
        return orderAbandonedReason;
    }

    public void setOrderAbandonedReason(String orderAbandonedReason) {
        this.orderAbandonedReason = orderAbandonedReason;
    }

    public String getCustomerIntention() {
        return customerIntention;
    }

    public void setCustomerIntention(String customerIntention) {
        this.customerIntention = customerIntention;
    }

    public Date getEstimatedTransferTime() {
        return estimatedTransferTime;
    }

    public void setEstimatedTransferTime(Date estimatedTransferTime) {
        this.estimatedTransferTime = estimatedTransferTime;
    }

    public Long getDealPriceEnd() {
        return dealPriceEnd;
    }

    public void setDealPriceEnd(Long dealPriceEnd) {
        this.dealPriceEnd = dealPriceEnd;
    }

    public String getBusinessOrderNo() {
        return businessOrderNo;
    }

    public void setBusinessOrderNo(String businessOrderNo) {
        this.businessOrderNo = businessOrderNo;
    }

    public InquiryQuotingResultDto(Long inquiryId) {
        this.inquiryId = inquiryId;
    }
    public InquiryQuotingResultDto() {
    }

    public Date getOrderReceivingDeadline() {
        return orderReceivingDeadline;
    }

    public void setOrderReceivingDeadline(Date orderReceivingDeadline) {
        this.orderReceivingDeadline = orderReceivingDeadline;
    }

    public Date getGenerateAcquisitionsTime() {
        return generateAcquisitionsTime;
    }

    public void setGenerateAcquisitionsTime(Date generateAcquisitionsTime) {
        this.generateAcquisitionsTime = generateAcquisitionsTime;
    }

    public Date getFirstEscalationTime() {
        return firstEscalationTime;
    }

    public void setFirstEscalationTime(Date firstEscalationTime) {
        this.firstEscalationTime = firstEscalationTime;
    }

    public Date getSecondEscalationTime() {
        return secondEscalationTime;
    }

    public void setSecondEscalationTime(Date secondEscalationTime) {
        this.secondEscalationTime = secondEscalationTime;
    }

    public Date getOldCarConfirmationTime() {
        return oldCarConfirmationTime;
    }

    public void setOldCarConfirmationTime(Date oldCarConfirmationTime) {
        this.oldCarConfirmationTime = oldCarConfirmationTime;
    }

    public Date getApprovedTime() {
        return approvedTime;
    }

    public void setApprovedTime(Date approvedTime) {
        this.approvedTime = approvedTime;
    }

    public Date getOverruleTime() {
        return overruleTime;
    }

    public void setOverruleTime(Date overruleTime) {
        this.overruleTime = overruleTime;
    }

    public Date getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Date getUploadFileTime() {
        return uploadFileTime;
    }

    public void setUploadFileTime(Date uploadFileTime) {
        this.uploadFileTime = uploadFileTime;
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
    
}
