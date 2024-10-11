package com.exp.ucmp.entity;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;
import javax.validation.GroupSequence;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import com.egrid.core.base.entity.AbstractBaseEntity;
import com.egrid.core.base.id.RandomIDGennerator;

@ApiModel(value = "PsiCarDealerInquiryEntity", description = "车商询价表")
@GroupSequence({PsiCarDealerInquiryEntity.class, PsiCarDealerInquiryEntity.PsiCarDealerInquiryEntityValidGroup.class,PsiCarDealerInquiryEntity.InquiryIdValidGroup.class,PsiCarDealerInquiryEntity.ReservationIdValidGroup.class,PsiCarDealerInquiryEntity.CustomerIdValidGroup.class,PsiCarDealerInquiryEntity.StoreIdValidGroup.class,PsiCarDealerInquiryEntity.CarDealerIdValidGroup.class,PsiCarDealerInquiryEntity.CarDealerStaffIdValidGroup.class,PsiCarDealerInquiryEntity.BusinessOrderNoValidGroup.class,PsiCarDealerInquiryEntity.MakeOrderPersonIdValidGroup.class,PsiCarDealerInquiryEntity.MakeOrderPersonNameValidGroup.class,PsiCarDealerInquiryEntity.MakeOrderPersonIphoneValidGroup.class,PsiCarDealerInquiryEntity.MakeOrderPersonRoleValidGroup.class,PsiCarDealerInquiryEntity.CustomerNameValidGroup.class,PsiCarDealerInquiryEntity.CustomerIphoneValidGroup.class,PsiCarDealerInquiryEntity.IssuedCarDealerDateValidGroup.class,PsiCarDealerInquiryEntity.OrderReceivingDeadlineValidGroup.class,PsiCarDealerInquiryEntity.QuoteEndPriceValidGroup.class,PsiCarDealerInquiryEntity.VehicleRegistrationFileIdValidGroup.class,PsiCarDealerInquiryEntity.IsDeleteValidGroup.class,PsiCarDealerInquiryEntity.OrderAbandonedReasonValidGroup.class,PsiCarDealerInquiryEntity.CustomerIntentionValidGroup.class,PsiCarDealerInquiryEntity.DealPriceEndValidGroup.class,PsiCarDealerInquiryEntity.InquiryStatusValidGroup.class,PsiCarDealerInquiryEntity.ApprovalStatusValidGroup.class,PsiCarDealerInquiryEntity.CreatedByValidGroup.class,PsiCarDealerInquiryEntity.CreatedDateValidGroup.class,PsiCarDealerInquiryEntity.UpdatedByValidGroup.class,PsiCarDealerInquiryEntity.UpdatedDateValidGroup.class,PsiCarDealerInquiryEntity.RemarksValidGroup.class}) 
public class PsiCarDealerInquiryEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 询价ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "询价ID 不能是Null", groups = {PsiCarDealerInquiryEntityValidGroup.class, InquiryIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="询价ID 数字精度必须符合(19,0)", groups = {PsiCarDealerInquiryEntityValidGroup.class, InquiryIdValidGroup.class})
    @ApiModelProperty(value = "询价ID")
    private Long inquiryId;
    
    
    /**
     * 预约ID
     */
    @NotNull(message = "预约ID 不能是Null", groups = {PsiCarDealerInquiryEntityValidGroup.class, ReservationIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="预约ID 数字精度必须符合(19,0)", groups = {PsiCarDealerInquiryEntityValidGroup.class, ReservationIdValidGroup.class})
    @ApiModelProperty(value = "预约ID")
    private Long reservationId;
    
    /**
     * 客户ID
     */
    @NotNull(message = "客户ID 不能是Null", groups = {PsiCarDealerInquiryEntityValidGroup.class, CustomerIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="客户ID 数字精度必须符合(19,0)", groups = {PsiCarDealerInquiryEntityValidGroup.class, CustomerIdValidGroup.class})
    @ApiModelProperty(value = "客户ID")
    private Long customerId;
    
    /**
     * 门店ID
     */
    @NotNull(message = "门店ID 不能是Null", groups = {PsiCarDealerInquiryEntityValidGroup.class, StoreIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="门店ID 数字精度必须符合(19,0)", groups = {PsiCarDealerInquiryEntityValidGroup.class, StoreIdValidGroup.class})
    @ApiModelProperty(value = "门店ID")
    private Long storeId;
    
    /**
     * 车商ID
     */
    @NotNull(message = "车商ID 不能是Null", groups = {PsiCarDealerInquiryEntityValidGroup.class, CarDealerIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="车商ID 数字精度必须符合(19,0)", groups = {PsiCarDealerInquiryEntityValidGroup.class, CarDealerIdValidGroup.class})
    @ApiModelProperty(value = "车商ID")
    private Long carDealerId;
    
    /**
     * 车商人员ID
     */
    @Digits(integer=19, fraction=0, message="车商人员ID 数字精度必须符合(19,0)", groups = {PsiCarDealerInquiryEntityValidGroup.class, CarDealerStaffIdValidGroup.class})
    @ApiModelProperty(value = "车商人员ID")
    private Long carDealerStaffId;
    
    /**
     * 业务单号(同线索单号)
     */
    @NotNull(message = "业务单号(同线索单号) 不能是Null", groups = {PsiCarDealerInquiryEntityValidGroup.class, BusinessOrderNoValidGroup.class})
    @Size(min=0, max=20, message="业务单号(同线索单号) 字符长度必须小于等于20", groups = {PsiCarDealerInquiryEntityValidGroup.class, BusinessOrderNoValidGroup.class})
    @ApiModelProperty(value = "业务单号(同线索单号)")
    private String businessOrderNo;
    
    /**
     * 制单人ID(指的是预约表里面的顾问或者经理、店长)
     */
    @NotNull(message = "制单人ID(指的是预约表里面的顾问或者经理、店长) 不能是Null", groups = {PsiCarDealerInquiryEntityValidGroup.class, MakeOrderPersonIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="制单人ID(指的是预约表里面的顾问或者经理、店长) 数字精度必须符合(19,0)", groups = {PsiCarDealerInquiryEntityValidGroup.class, MakeOrderPersonIdValidGroup.class})
    @ApiModelProperty(value = "制单人ID(指的是预约表里面的顾问或者经理、店长)")
    private Long makeOrderPersonId;
    
    /**
     * 制单人姓名(指的是预约表里面的顾问或者经理、店长)
     */
    @NotNull(message = "制单人姓名(指的是预约表里面的顾问或者经理、店长) 不能是Null", groups = {PsiCarDealerInquiryEntityValidGroup.class, MakeOrderPersonNameValidGroup.class})
    @Size(min=0, max=20, message="制单人姓名(指的是预约表里面的顾问或者经理、店长) 字符长度必须小于等于20", groups = {PsiCarDealerInquiryEntityValidGroup.class, MakeOrderPersonNameValidGroup.class})
    @ApiModelProperty(value = "制单人姓名(指的是预约表里面的顾问或者经理、店长)")
    private String makeOrderPersonName;
    
    /**
     * 制单人联系电话(指的是预约表里面的顾问或者经理、店长)
     */
    @NotNull(message = "制单人联系电话(指的是预约表里面的顾问或者经理、店长) 不能是Null", groups = {PsiCarDealerInquiryEntityValidGroup.class, MakeOrderPersonIphoneValidGroup.class})
    @Size(min=0, max=20, message="制单人联系电话(指的是预约表里面的顾问或者经理、店长) 字符长度必须小于等于20", groups = {PsiCarDealerInquiryEntityValidGroup.class, MakeOrderPersonIphoneValidGroup.class})
    @ApiModelProperty(value = "制单人联系电话(指的是预约表里面的顾问或者经理、店长)")
    private String makeOrderPersonIphone;
    
    /**
     * 制单人角色(指的是预约表里面的顾问或者经理、店长)
     */
    @Size(min=0, max=20, message="制单人角色(指的是预约表里面的顾问或者经理、店长) 字符长度必须小于等于20", groups = {PsiCarDealerInquiryEntityValidGroup.class, MakeOrderPersonRoleValidGroup.class})
    @ApiModelProperty(value = "制单人角色(指的是预约表里面的顾问或者经理、店长)")
    private String makeOrderPersonRole;
    
    /**
     * 姓名
     */
    @NotNull(message = "姓名 不能是Null", groups = {PsiCarDealerInquiryEntityValidGroup.class, CustomerNameValidGroup.class})
    @Size(min=0, max=20, message="姓名 字符长度必须小于等于20", groups = {PsiCarDealerInquiryEntityValidGroup.class, CustomerNameValidGroup.class})
    @ApiModelProperty(value = "姓名")
    private String customerName;
    
    /**
     * 手机号
     */
    @NotNull(message = "手机号 不能是Null", groups = {PsiCarDealerInquiryEntityValidGroup.class, CustomerIphoneValidGroup.class})
    @Size(min=0, max=20, message="手机号 字符长度必须小于等于20", groups = {PsiCarDealerInquiryEntityValidGroup.class, CustomerIphoneValidGroup.class})
    @ApiModelProperty(value = "手机号")
    private String customerIphone;
    
    /**
     * 下发给车商时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "下发给车商时间 不能是Null", groups = {PsiCarDealerInquiryEntityValidGroup.class, IssuedCarDealerDateValidGroup.class})
    @ApiModelProperty(value = "下发给车商时间")
    private Date issuedCarDealerDate;
    
    /**
     * 接单时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "接单时间")
    private Date orderReceivingDate;
    
    /**
     * 接单截止时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "接单截止时间 不能是Null", groups = {PsiCarDealerInquiryEntityValidGroup.class, OrderReceivingDeadlineValidGroup.class})
    @ApiModelProperty(value = "接单截止时间")
    private Date orderReceivingDeadline;
    
    /**
     * 最后报价价格
     */
    @Digits(integer=9, fraction=0, message="最后报价价格 数字精度必须符合(9,0)", groups = {PsiCarDealerInquiryEntityValidGroup.class, QuoteEndPriceValidGroup.class})
    @ApiModelProperty(value = "最后报价价格")
    private Long quoteEndPrice;
    
    /**
     * 最后报价时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "最后报价时间")
    private Date quoteEndDate;
    
    /**
     * 签到时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "签到时间")
    private Date signInDate;
    
    /**
     * 报价截止时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "报价截止时间")
    private Date quoteDeadline;
    
    /**
     * 行驶证文件ID
     */
    @Digits(integer=19, fraction=0, message="行驶证文件ID 数字精度必须符合(19,0)", groups = {PsiCarDealerInquiryEntityValidGroup.class, VehicleRegistrationFileIdValidGroup.class})
    @ApiModelProperty(value = "行驶证文件ID")
    private Long vehicleRegistrationFileId;
    
    /**
     * 是否被删除：00、删除，01、未删除
     */
    @NotNull(message = "是否被删除：00、删除，01、未删除 不能是Null", groups = {PsiCarDealerInquiryEntityValidGroup.class, IsDeleteValidGroup.class})
    @Size(min=0, max=2, message="是否被删除：00、删除，01、未删除 字符长度必须小于等于2", groups = {PsiCarDealerInquiryEntityValidGroup.class, IsDeleteValidGroup.class})
    @ApiModelProperty(value = "是否被删除：00、删除，01、未删除")
    private String isDelete;
    
    /**
     * 放弃原因
     */
    @Size(min=0, max=200, message="放弃原因 字符长度必须小于等于200", groups = {PsiCarDealerInquiryEntityValidGroup.class, OrderAbandonedReasonValidGroup.class})
    @ApiModelProperty(value = "放弃原因")
    private String orderAbandonedReason;
    
    /**
     * 客户意向：01、同意，02、要求议价、03、客户拒绝
     */
    @Size(min=0, max=4, message="客户意向：01、同意，02、要求议价、03、客户拒绝 字符长度必须小于等于4", groups = {PsiCarDealerInquiryEntityValidGroup.class, CustomerIntentionValidGroup.class})
    @ApiModelProperty(value = "客户意向：01、同意，02、要求议价、03、客户拒绝")
    private String customerIntention;
    
    /**
     * 最终成交价
     */
    @Digits(integer=9, fraction=0, message="最终成交价 数字精度必须符合(9,0)", groups = {PsiCarDealerInquiryEntityValidGroup.class, DealPriceEndValidGroup.class})
    @ApiModelProperty(value = "最终成交价")
    private Long dealPriceEnd;
    
    /**
     * 预计过户时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "预计过户时间")
    private Date estimatedTransferTime;
    
    /**
     * 询价单状态：01、待接单，02、已接单，09、放弃接单，11、待报价，12、已报价，17、报价失效，18、逾期未报价，19、放弃报价,21、待收购，22、待过户、23、收购完成、29、放弃收购
     */
    @NotNull(message = "询价单状态：01、待接单，02、已接单，09、放弃接单，11、待报价，12、已报价，17、报价失效，18、逾期未报价，19、放弃报价,21、待收购，22、待过户、23、收购完成、29、放弃收购 不能是Null", groups = {PsiCarDealerInquiryEntityValidGroup.class, InquiryStatusValidGroup.class})
    @Size(min=0, max=4, message="询价单状态：01、待接单，02、已接单，09、放弃接单，11、待报价，12、已报价，17、报价失效，18、逾期未报价，19、放弃报价,21、待收购，22、待过户、23、收购完成、29、放弃收购 字符长度必须小于等于4", groups = {PsiCarDealerInquiryEntityValidGroup.class, InquiryStatusValidGroup.class})
    @ApiModelProperty(value = "询价单状态：01、待接单，02、已接单，09、放弃接单，11、待报价，12、已报价，17、报价失效，18、逾期未报价，19、放弃报价,21、待收购，22、待过户、23、收购完成、29、放弃收购")
    private String inquiryStatus;
    
    /**
     * 审批状态：01、待确认，02、确认通过，03、待审批，04、审批通过，05、驳回，09、关闭
     */
    @Size(min=0, max=4, message="审批状态：01、待确认，02、确认通过，03、待审批，04、审批通过，05、驳回，09、关闭 字符长度必须小于等于4", groups = {PsiCarDealerInquiryEntityValidGroup.class, ApprovalStatusValidGroup.class})
    @ApiModelProperty(value = "审批状态：01、待确认，02、确认通过，03、待审批，04、审批通过，05、驳回，09、关闭")
    private String approvalStatus;
    
    /**
     * 文件上传时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "文件上传时间")
    private Date uploadFileTime;
    
    /**
     * 创建人ID
     */
    @NotNull(message = "创建人ID 不能是Null", groups = {PsiCarDealerInquiryEntityValidGroup.class, CreatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人ID 数字精度必须符合(19,0)", groups = {PsiCarDealerInquiryEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人ID")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {PsiCarDealerInquiryEntityValidGroup.class, CreatedDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 更新人ID
     */
    @NotNull(message = "更新人ID 不能是Null", groups = {PsiCarDealerInquiryEntityValidGroup.class, UpdatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="更新人ID 数字精度必须符合(19,0)", groups = {PsiCarDealerInquiryEntityValidGroup.class, UpdatedByValidGroup.class})
    @ApiModelProperty(value = "更新人ID")
    private Long updatedBy;
    
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "更新时间 不能是Null", groups = {PsiCarDealerInquiryEntityValidGroup.class, UpdatedDateValidGroup.class})
    @ApiModelProperty(value = "更新时间")
    private Date updatedDate;
    
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
    @Size(min=0, max=500, message="备注 字符长度必须小于等于500", groups = {PsiCarDealerInquiryEntityValidGroup.class, RemarksValidGroup.class})
    @ApiModelProperty(value = "备注")
    private String remarks;
    
    public PsiCarDealerInquiryEntity() {
    }
    
    public PsiCarDealerInquiryEntity(Long inquiryId) {
        this.inquiryId = inquiryId;
    }

    public void setInquiryId(Long inquiryId) {
        this.inquiryId = inquiryId;
    }
    public Long getInquiryId() {
        return this.inquiryId;
    }
    

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }
    public Long getReservationId() {
        return this.reservationId;
    }
    
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
    public Long getCustomerId() {
        return this.customerId;
    }
    
    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }
    public Long getStoreId() {
        return this.storeId;
    }
    
    public void setCarDealerId(Long carDealerId) {
        this.carDealerId = carDealerId;
    }
    public Long getCarDealerId() {
        return this.carDealerId;
    }
    
    public void setCarDealerStaffId(Long carDealerStaffId) {
        this.carDealerStaffId = carDealerStaffId;
    }
    public Long getCarDealerStaffId() {
        return this.carDealerStaffId;
    }
    
    public void setBusinessOrderNo(String businessOrderNo) {
        this.businessOrderNo = businessOrderNo;
    }
    public String getBusinessOrderNo() {
        return this.businessOrderNo;
    }
    
    public void setMakeOrderPersonId(Long makeOrderPersonId) {
        this.makeOrderPersonId = makeOrderPersonId;
    }
    public Long getMakeOrderPersonId() {
        return this.makeOrderPersonId;
    }
    
    public void setMakeOrderPersonName(String makeOrderPersonName) {
        this.makeOrderPersonName = makeOrderPersonName;
    }
    public String getMakeOrderPersonName() {
        return this.makeOrderPersonName;
    }
    
    public void setMakeOrderPersonIphone(String makeOrderPersonIphone) {
        this.makeOrderPersonIphone = makeOrderPersonIphone;
    }
    public String getMakeOrderPersonIphone() {
        return this.makeOrderPersonIphone;
    }
    
    public void setMakeOrderPersonRole(String makeOrderPersonRole) {
        this.makeOrderPersonRole = makeOrderPersonRole;
    }
    public String getMakeOrderPersonRole() {
        return this.makeOrderPersonRole;
    }
    
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public String getCustomerName() {
        return this.customerName;
    }
    
    public void setCustomerIphone(String customerIphone) {
        this.customerIphone = customerIphone;
    }
    public String getCustomerIphone() {
        return this.customerIphone;
    }
    
    public void setIssuedCarDealerDate(Date issuedCarDealerDate) {
        this.issuedCarDealerDate = issuedCarDealerDate;
    }
    public Date getIssuedCarDealerDate() {
        return this.issuedCarDealerDate;
    }
    
    public void setOrderReceivingDate(Date orderReceivingDate) {
        this.orderReceivingDate = orderReceivingDate;
    }
    public Date getOrderReceivingDate() {
        return this.orderReceivingDate;
    }
    
    public void setOrderReceivingDeadline(Date orderReceivingDeadline) {
        this.orderReceivingDeadline = orderReceivingDeadline;
    }
    public Date getOrderReceivingDeadline() {
        return this.orderReceivingDeadline;
    }
    
    public void setQuoteEndPrice(Long quoteEndPrice) {
        this.quoteEndPrice = quoteEndPrice;
    }
    public Long getQuoteEndPrice() {
        return this.quoteEndPrice;
    }
    
    public void setQuoteEndDate(Date quoteEndDate) {
        this.quoteEndDate = quoteEndDate;
    }
    public Date getQuoteEndDate() {
        return this.quoteEndDate;
    }
    
    public void setSignInDate(Date signInDate) {
        this.signInDate = signInDate;
    }
    public Date getSignInDate() {
        return this.signInDate;
    }
    
    public void setQuoteDeadline(Date quoteDeadline) {
        this.quoteDeadline = quoteDeadline;
    }
    public Date getQuoteDeadline() {
        return this.quoteDeadline;
    }
    
    public void setVehicleRegistrationFileId(Long vehicleRegistrationFileId) {
        this.vehicleRegistrationFileId = vehicleRegistrationFileId;
    }
    public Long getVehicleRegistrationFileId() {
        return this.vehicleRegistrationFileId;
    }
    
    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }
    public String getIsDelete() {
        return this.isDelete;
    }
    
    public void setOrderAbandonedReason(String orderAbandonedReason) {
        this.orderAbandonedReason = orderAbandonedReason;
    }
    public String getOrderAbandonedReason() {
        return this.orderAbandonedReason;
    }
    
    public void setCustomerIntention(String customerIntention) {
        this.customerIntention = customerIntention;
    }
    public String getCustomerIntention() {
        return this.customerIntention;
    }
    
    public void setDealPriceEnd(Long dealPriceEnd) {
        this.dealPriceEnd = dealPriceEnd;
    }
    public Long getDealPriceEnd() {
        return this.dealPriceEnd;
    }
    
    public void setEstimatedTransferTime(Date estimatedTransferTime) {
        this.estimatedTransferTime = estimatedTransferTime;
    }
    public Date getEstimatedTransferTime() {
        return this.estimatedTransferTime;
    }
    
    public void setInquiryStatus(String inquiryStatus) {
        this.inquiryStatus = inquiryStatus;
    }
    public String getInquiryStatus() {
        return this.inquiryStatus;
    }
    
    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }
    public String getApprovalStatus() {
        return this.approvalStatus;
    }
    
    public void setUploadFileTime(Date uploadFileTime) {
        this.uploadFileTime = uploadFileTime;
    }
    public Date getUploadFileTime() {
        return this.uploadFileTime;
    }
    
    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }
    public Long getCreatedBy() {
        return this.createdBy;
    }
    
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    public Date getCreatedDate() {
        return this.createdDate;
    }
    
    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }
    public Long getUpdatedBy() {
        return this.updatedBy;
    }
    
    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
    public Date getUpdatedDate() {
        return this.updatedDate;
    }
    
    public void setGenerateAcquisitionsTime(Date generateAcquisitionsTime) {
        this.generateAcquisitionsTime = generateAcquisitionsTime;
    }
    public Date getGenerateAcquisitionsTime() {
        return this.generateAcquisitionsTime;
    }
    
    public void setFirstEscalationTime(Date firstEscalationTime) {
        this.firstEscalationTime = firstEscalationTime;
    }
    public Date getFirstEscalationTime() {
        return this.firstEscalationTime;
    }
    
    public void setSecondEscalationTime(Date secondEscalationTime) {
        this.secondEscalationTime = secondEscalationTime;
    }
    public Date getSecondEscalationTime() {
        return this.secondEscalationTime;
    }
    
    public void setOldCarConfirmationTime(Date oldCarConfirmationTime) {
        this.oldCarConfirmationTime = oldCarConfirmationTime;
    }
    public Date getOldCarConfirmationTime() {
        return this.oldCarConfirmationTime;
    }
    
    public void setApprovedTime(Date approvedTime) {
        this.approvedTime = approvedTime;
    }
    public Date getApprovedTime() {
        return this.approvedTime;
    }
    
    public void setOverruleTime(Date overruleTime) {
        this.overruleTime = overruleTime;
    }
    public Date getOverruleTime() {
        return this.overruleTime;
    }
    
    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
    }
    public Date getCloseTime() {
        return this.closeTime;
    }
    
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    public String getRemarks() {
        return this.remarks;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (inquiryId == null)
           
               ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
                inquiryId = RandomIDGennerator.get().generate();
    }

    public interface PsiCarDealerInquiryEntityValidGroup {}
    public interface InquiryIdValidGroup {}
    public interface ReservationIdValidGroup {}
    public interface CustomerIdValidGroup {}
    public interface StoreIdValidGroup {}
    public interface CarDealerIdValidGroup {}
    public interface CarDealerStaffIdValidGroup {}
    public interface BusinessOrderNoValidGroup {}
    public interface MakeOrderPersonIdValidGroup {}
    public interface MakeOrderPersonNameValidGroup {}
    public interface MakeOrderPersonIphoneValidGroup {}
    public interface MakeOrderPersonRoleValidGroup {}
    public interface CustomerNameValidGroup {}
    public interface CustomerIphoneValidGroup {}
    public interface IssuedCarDealerDateValidGroup {}
    public interface OrderReceivingDeadlineValidGroup {}
    public interface QuoteEndPriceValidGroup {}
    public interface VehicleRegistrationFileIdValidGroup {}
    public interface IsDeleteValidGroup {}
    public interface OrderAbandonedReasonValidGroup {}
    public interface CustomerIntentionValidGroup {}
    public interface DealPriceEndValidGroup {}
    public interface InquiryStatusValidGroup {}
    public interface ApprovalStatusValidGroup {}
    public interface CreatedByValidGroup {}
    public interface CreatedDateValidGroup {}
    public interface UpdatedByValidGroup {}
    public interface UpdatedDateValidGroup {}
    public interface RemarksValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            InquiryIdValidGroup.class
            , ReservationIdValidGroup.class
            , CustomerIdValidGroup.class
            , StoreIdValidGroup.class
            , CarDealerIdValidGroup.class
            , CarDealerStaffIdValidGroup.class
            , BusinessOrderNoValidGroup.class
            , MakeOrderPersonIdValidGroup.class
            , MakeOrderPersonNameValidGroup.class
            , MakeOrderPersonIphoneValidGroup.class
            , MakeOrderPersonRoleValidGroup.class
            , CustomerNameValidGroup.class
            , CustomerIphoneValidGroup.class
            , IssuedCarDealerDateValidGroup.class
            , OrderReceivingDeadlineValidGroup.class
            , QuoteEndPriceValidGroup.class
            , VehicleRegistrationFileIdValidGroup.class
            , IsDeleteValidGroup.class
            , OrderAbandonedReasonValidGroup.class
            , CustomerIntentionValidGroup.class
            , DealPriceEndValidGroup.class
            , InquiryStatusValidGroup.class
            , ApprovalStatusValidGroup.class
            , CreatedByValidGroup.class
            , CreatedDateValidGroup.class
            , UpdatedByValidGroup.class
            , UpdatedDateValidGroup.class
            , RemarksValidGroup.class
        };
    }
}
