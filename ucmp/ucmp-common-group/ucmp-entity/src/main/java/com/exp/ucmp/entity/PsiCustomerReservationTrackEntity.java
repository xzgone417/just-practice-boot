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

@ApiModel(value = "PsiCustomerReservationTrackEntity", description = "客户预约跟踪表")
@GroupSequence({PsiCustomerReservationTrackEntity.class, PsiCustomerReservationTrackEntity.PsiCustomerReservationTrackEntityValidGroup.class,PsiCustomerReservationTrackEntity.ReservationIdValidGroup.class,PsiCustomerReservationTrackEntity.InfoIdValidGroup.class,PsiCustomerReservationTrackEntity.CustomerIdValidGroup.class,PsiCustomerReservationTrackEntity.StoreIdValidGroup.class,PsiCustomerReservationTrackEntity.ConsultantIdValidGroup.class,PsiCustomerReservationTrackEntity.ManagerIdValidGroup.class,PsiCustomerReservationTrackEntity.StoreManagerIdValidGroup.class,PsiCustomerReservationTrackEntity.MakeOrderPersonNameValidGroup.class,PsiCustomerReservationTrackEntity.MakeOrderPersonIphoneValidGroup.class,PsiCustomerReservationTrackEntity.MakeOrderPersonRoleValidGroup.class,PsiCustomerReservationTrackEntity.QuoteMerchantsNameValidGroup.class,PsiCustomerReservationTrackEntity.BusinessTypeValidGroup.class,PsiCustomerReservationTrackEntity.BusinessOrderNoValidGroup.class,PsiCustomerReservationTrackEntity.BusinessClassifyValidGroup.class,PsiCustomerReservationTrackEntity.AgreeDescribeValidGroup.class,PsiCustomerReservationTrackEntity.OtherBrandInquiryIdValidGroup.class,PsiCustomerReservationTrackEntity.OneselfBrandInquiryIdValidGroup.class,PsiCustomerReservationTrackEntity.EstimateDealPriceValidGroup.class,PsiCustomerReservationTrackEntity.DealPriceEndValidGroup.class,PsiCustomerReservationTrackEntity.CustomerIntentionValidGroup.class,PsiCustomerReservationTrackEntity.ShutCauseValidGroup.class,PsiCustomerReservationTrackEntity.ShutCauseDetailsValidGroup.class,PsiCustomerReservationTrackEntity.ShutDescribeValidGroup.class,PsiCustomerReservationTrackEntity.TrackStatusValidGroup.class,PsiCustomerReservationTrackEntity.IsDeleteValidGroup.class,PsiCustomerReservationTrackEntity.CreatedByValidGroup.class,PsiCustomerReservationTrackEntity.CreatedDateValidGroup.class,PsiCustomerReservationTrackEntity.UpdatedByValidGroup.class,PsiCustomerReservationTrackEntity.UpdatedDateValidGroup.class}) 
public class PsiCustomerReservationTrackEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 预约ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "预约ID 不能是Null", groups = {PsiCustomerReservationTrackEntityValidGroup.class, ReservationIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="预约ID 数字精度必须符合(19,0)", groups = {PsiCustomerReservationTrackEntityValidGroup.class, ReservationIdValidGroup.class})
    @ApiModelProperty(value = "预约ID")
    private Long reservationId;
    
    
    /**
     * 顾问信息标识
     */
    @Digits(integer=19, fraction=0, message="顾问信息标识 数字精度必须符合(19,0)", groups = {PsiCustomerReservationTrackEntityValidGroup.class, InfoIdValidGroup.class})
    @ApiModelProperty(value = "顾问信息标识")
    private Long infoId;
    
    /**
     * 客户ID
     */
    @NotNull(message = "客户ID 不能是Null", groups = {PsiCustomerReservationTrackEntityValidGroup.class, CustomerIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="客户ID 数字精度必须符合(19,0)", groups = {PsiCustomerReservationTrackEntityValidGroup.class, CustomerIdValidGroup.class})
    @ApiModelProperty(value = "客户ID")
    private Long customerId;
    
    /**
     * 门店ID
     */
    @NotNull(message = "门店ID 不能是Null", groups = {PsiCustomerReservationTrackEntityValidGroup.class, StoreIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="门店ID 数字精度必须符合(19,0)", groups = {PsiCustomerReservationTrackEntityValidGroup.class, StoreIdValidGroup.class})
    @ApiModelProperty(value = "门店ID")
    private Long storeId;
    
    /**
     * 跟进顾问ID
     */
    @Digits(integer=19, fraction=0, message="跟进顾问ID 数字精度必须符合(19,0)", groups = {PsiCustomerReservationTrackEntityValidGroup.class, ConsultantIdValidGroup.class})
    @ApiModelProperty(value = "跟进顾问ID")
    private Long consultantId;
    
    /**
     * 经理ID
     */
    @Digits(integer=19, fraction=0, message="经理ID 数字精度必须符合(19,0)", groups = {PsiCustomerReservationTrackEntityValidGroup.class, ManagerIdValidGroup.class})
    @ApiModelProperty(value = "经理ID")
    private Long managerId;
    
    /**
     * 店长ID
     */
    @Digits(integer=19, fraction=0, message="店长ID 数字精度必须符合(19,0)", groups = {PsiCustomerReservationTrackEntityValidGroup.class, StoreManagerIdValidGroup.class})
    @ApiModelProperty(value = "店长ID")
    private Long storeManagerId;
    
    /**
     * 制单人姓名(指的是预约表里面的顾问或者经理、店长)
     */
    @NotNull(message = "制单人姓名(指的是预约表里面的顾问或者经理、店长) 不能是Null", groups = {PsiCustomerReservationTrackEntityValidGroup.class, MakeOrderPersonNameValidGroup.class})
    @Size(min=0, max=20, message="制单人姓名(指的是预约表里面的顾问或者经理、店长) 字符长度必须小于等于20", groups = {PsiCustomerReservationTrackEntityValidGroup.class, MakeOrderPersonNameValidGroup.class})
    @ApiModelProperty(value = "制单人姓名(指的是预约表里面的顾问或者经理、店长)")
    private String makeOrderPersonName;
    
    /**
     * 制单人联系电话(指的是预约表里面的顾问或者经理、店长)
     */
    @NotNull(message = "制单人联系电话(指的是预约表里面的顾问或者经理、店长) 不能是Null", groups = {PsiCustomerReservationTrackEntityValidGroup.class, MakeOrderPersonIphoneValidGroup.class})
    @Size(min=0, max=20, message="制单人联系电话(指的是预约表里面的顾问或者经理、店长) 字符长度必须小于等于20", groups = {PsiCustomerReservationTrackEntityValidGroup.class, MakeOrderPersonIphoneValidGroup.class})
    @ApiModelProperty(value = "制单人联系电话(指的是预约表里面的顾问或者经理、店长)")
    private String makeOrderPersonIphone;
    
    /**
     * 制单人角色(指的是预约表里面的顾问或者经理、店长)
     */
    @Size(min=0, max=20, message="制单人角色(指的是预约表里面的顾问或者经理、店长) 字符长度必须小于等于20", groups = {PsiCustomerReservationTrackEntityValidGroup.class, MakeOrderPersonRoleValidGroup.class})
    @ApiModelProperty(value = "制单人角色(指的是预约表里面的顾问或者经理、店长)")
    private String makeOrderPersonRole;
    
    /**
     * 报价商户名称
     */
    @Size(min=0, max=50, message="报价商户名称 字符长度必须小于等于50", groups = {PsiCustomerReservationTrackEntityValidGroup.class, QuoteMerchantsNameValidGroup.class})
    @ApiModelProperty(value = "报价商户名称")
    private String quoteMerchantsName;
    
    /**
     * 业务类型：01、他品，02、本品
     */
    @NotNull(message = "业务类型：01、他品，02、本品 不能是Null", groups = {PsiCustomerReservationTrackEntityValidGroup.class, BusinessTypeValidGroup.class})
    @Size(min=0, max=4, message="业务类型：01、他品，02、本品 字符长度必须小于等于4", groups = {PsiCustomerReservationTrackEntityValidGroup.class, BusinessTypeValidGroup.class})
    @ApiModelProperty(value = "业务类型：01、他品，02、本品")
    private String businessType;
    
    /**
     * 业务单号(同线索单号)
     */
    @NotNull(message = "业务单号(同线索单号) 不能是Null", groups = {PsiCustomerReservationTrackEntityValidGroup.class, BusinessOrderNoValidGroup.class})
    @Size(min=0, max=20, message="业务单号(同线索单号) 字符长度必须小于等于20", groups = {PsiCustomerReservationTrackEntityValidGroup.class, BusinessOrderNoValidGroup.class})
    @ApiModelProperty(value = "业务单号(同线索单号)")
    private String businessOrderNo;
    
    /**
     * 1601置换/1602销售(业务标识)
     */
    @NotNull(message = "1601置换/1602销售(业务标识) 不能是Null", groups = {PsiCustomerReservationTrackEntityValidGroup.class, BusinessClassifyValidGroup.class})
    @Size(min=0, max=4, message="1601置换/1602销售(业务标识) 字符长度必须小于等于4", groups = {PsiCustomerReservationTrackEntityValidGroup.class, BusinessClassifyValidGroup.class})
    @ApiModelProperty(value = "1601置换/1602销售(业务标识)")
    private String businessClassify;
    
    /**
     * 客户同意描述
     */
    @Size(min=0, max=200, message="客户同意描述 字符长度必须小于等于200", groups = {PsiCustomerReservationTrackEntityValidGroup.class, AgreeDescribeValidGroup.class})
    @ApiModelProperty(value = "客户同意描述")
    private String agreeDescribe;
    
    /**
     * 接单截止时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "接单截止时间")
    private Date orderReceivingDeadline;
    
    /**
     * 报价截止时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "报价截止时间")
    private Date quoteDeadline;
    
    /**
     * 他品询价ID
     */
    @Digits(integer=19, fraction=0, message="他品询价ID 数字精度必须符合(19,0)", groups = {PsiCustomerReservationTrackEntityValidGroup.class, OtherBrandInquiryIdValidGroup.class})
    @ApiModelProperty(value = "他品询价ID")
    private Long otherBrandInquiryId;
    
    /**
     * 本品询价ID
     */
    @Digits(integer=19, fraction=0, message="本品询价ID 数字精度必须符合(19,0)", groups = {PsiCustomerReservationTrackEntityValidGroup.class, OneselfBrandInquiryIdValidGroup.class})
    @ApiModelProperty(value = "本品询价ID")
    private Long oneselfBrandInquiryId;
    
    /**
     * 预计成交价(估价)
     */
    @Digits(integer=9, fraction=0, message="预计成交价(估价) 数字精度必须符合(9,0)", groups = {PsiCustomerReservationTrackEntityValidGroup.class, EstimateDealPriceValidGroup.class})
    @ApiModelProperty(value = "预计成交价(估价)")
    private Long estimateDealPrice;
    
    /**
     * 最终成交价
     */
    @Digits(integer=9, fraction=0, message="最终成交价 数字精度必须符合(9,0)", groups = {PsiCustomerReservationTrackEntityValidGroup.class, DealPriceEndValidGroup.class})
    @ApiModelProperty(value = "最终成交价")
    private Long dealPriceEnd;
    
    /**
     * 客户意向：01、同意，02、要求议价、03、客户拒绝
     */
    @Size(min=0, max=4, message="客户意向：01、同意，02、要求议价、03、客户拒绝 字符长度必须小于等于4", groups = {PsiCustomerReservationTrackEntityValidGroup.class, CustomerIntentionValidGroup.class})
    @ApiModelProperty(value = "客户意向：01、同意，02、要求议价、03、客户拒绝")
    private String customerIntention;
    
    /**
     * 关闭原因
     */
    @Size(min=0, max=4, message="关闭原因 字符长度必须小于等于4", groups = {PsiCustomerReservationTrackEntityValidGroup.class, ShutCauseValidGroup.class})
    @ApiModelProperty(value = "关闭原因")
    private String shutCause;
    
    /**
     * 关闭原因细项
     */
    @Size(min=0, max=6, message="关闭原因细项 字符长度必须小于等于6", groups = {PsiCustomerReservationTrackEntityValidGroup.class, ShutCauseDetailsValidGroup.class})
    @ApiModelProperty(value = "关闭原因细项")
    private String shutCauseDetails;
    
    /**
     * 关闭描述
     */
    @Size(min=0, max=500, message="关闭描述 字符长度必须小于等于500", groups = {PsiCustomerReservationTrackEntityValidGroup.class, ShutDescribeValidGroup.class})
    @ApiModelProperty(value = "关闭描述")
    private String shutDescribe;
    
    /**
     * 关闭时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "关闭时间")
    private Date shutDate;
    
    /**
     * 跟踪状态：01、待分配，02、已分配，03、待检测，04、检测中，05、已报价，06、已完成，09、已关闭
     */
    @NotNull(message = "跟踪状态：01、待分配，02、已分配，03、待检测，04、检测中，05、已报价，06、已完成，09、已关闭 不能是Null", groups = {PsiCustomerReservationTrackEntityValidGroup.class, TrackStatusValidGroup.class})
    @Size(min=0, max=4, message="跟踪状态：01、待分配，02、已分配，03、待检测，04、检测中，05、已报价，06、已完成，09、已关闭 字符长度必须小于等于4", groups = {PsiCustomerReservationTrackEntityValidGroup.class, TrackStatusValidGroup.class})
    @ApiModelProperty(value = "跟踪状态：01、待分配，02、已分配，03、待检测，04、检测中，05、已报价，06、已完成，09、已关闭")
    private String trackStatus;
    
    /**
     * 是否被删除：00、删除，01、未删除
     */
    @NotNull(message = "是否被删除：00、删除，01、未删除 不能是Null", groups = {PsiCustomerReservationTrackEntityValidGroup.class, IsDeleteValidGroup.class})
    @Size(min=0, max=2, message="是否被删除：00、删除，01、未删除 字符长度必须小于等于2", groups = {PsiCustomerReservationTrackEntityValidGroup.class, IsDeleteValidGroup.class})
    @ApiModelProperty(value = "是否被删除：00、删除，01、未删除")
    private String isDelete;
    
    /**
     * 创建人ID
     */
    @NotNull(message = "创建人ID 不能是Null", groups = {PsiCustomerReservationTrackEntityValidGroup.class, CreatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人ID 数字精度必须符合(19,0)", groups = {PsiCustomerReservationTrackEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人ID")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {PsiCustomerReservationTrackEntityValidGroup.class, CreatedDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 更新人ID
     */
    @NotNull(message = "更新人ID 不能是Null", groups = {PsiCustomerReservationTrackEntityValidGroup.class, UpdatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="更新人ID 数字精度必须符合(19,0)", groups = {PsiCustomerReservationTrackEntityValidGroup.class, UpdatedByValidGroup.class})
    @ApiModelProperty(value = "更新人ID")
    private Long updatedBy;
    
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "更新时间 不能是Null", groups = {PsiCustomerReservationTrackEntityValidGroup.class, UpdatedDateValidGroup.class})
    @ApiModelProperty(value = "更新时间")
    private Date updatedDate;
    
    public PsiCustomerReservationTrackEntity() {
    }
    
    public PsiCustomerReservationTrackEntity(Long reservationId) {
        this.reservationId = reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }
    public Long getReservationId() {
        return this.reservationId;
    }
    

    public void setInfoId(Long infoId) {
        this.infoId = infoId;
    }
    public Long getInfoId() {
        return this.infoId;
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
    
    public void setConsultantId(Long consultantId) {
        this.consultantId = consultantId;
    }
    public Long getConsultantId() {
        return this.consultantId;
    }
    
    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }
    public Long getManagerId() {
        return this.managerId;
    }
    
    public void setStoreManagerId(Long storeManagerId) {
        this.storeManagerId = storeManagerId;
    }
    public Long getStoreManagerId() {
        return this.storeManagerId;
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
    
    public void setQuoteMerchantsName(String quoteMerchantsName) {
        this.quoteMerchantsName = quoteMerchantsName;
    }
    public String getQuoteMerchantsName() {
        return this.quoteMerchantsName;
    }
    
    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }
    public String getBusinessType() {
        return this.businessType;
    }
    
    public void setBusinessOrderNo(String businessOrderNo) {
        this.businessOrderNo = businessOrderNo;
    }
    public String getBusinessOrderNo() {
        return this.businessOrderNo;
    }
    
    public void setBusinessClassify(String businessClassify) {
        this.businessClassify = businessClassify;
    }
    public String getBusinessClassify() {
        return this.businessClassify;
    }
    
    public void setAgreeDescribe(String agreeDescribe) {
        this.agreeDescribe = agreeDescribe;
    }
    public String getAgreeDescribe() {
        return this.agreeDescribe;
    }
    
    public void setOrderReceivingDeadline(Date orderReceivingDeadline) {
        this.orderReceivingDeadline = orderReceivingDeadline;
    }
    public Date getOrderReceivingDeadline() {
        return this.orderReceivingDeadline;
    }
    
    public void setQuoteDeadline(Date quoteDeadline) {
        this.quoteDeadline = quoteDeadline;
    }
    public Date getQuoteDeadline() {
        return this.quoteDeadline;
    }
    
    public void setOtherBrandInquiryId(Long otherBrandInquiryId) {
        this.otherBrandInquiryId = otherBrandInquiryId;
    }
    public Long getOtherBrandInquiryId() {
        return this.otherBrandInquiryId;
    }
    
    public void setOneselfBrandInquiryId(Long oneselfBrandInquiryId) {
        this.oneselfBrandInquiryId = oneselfBrandInquiryId;
    }
    public Long getOneselfBrandInquiryId() {
        return this.oneselfBrandInquiryId;
    }
    
    public void setEstimateDealPrice(Long estimateDealPrice) {
        this.estimateDealPrice = estimateDealPrice;
    }
    public Long getEstimateDealPrice() {
        return this.estimateDealPrice;
    }
    
    public void setDealPriceEnd(Long dealPriceEnd) {
        this.dealPriceEnd = dealPriceEnd;
    }
    public Long getDealPriceEnd() {
        return this.dealPriceEnd;
    }
    
    public void setCustomerIntention(String customerIntention) {
        this.customerIntention = customerIntention;
    }
    public String getCustomerIntention() {
        return this.customerIntention;
    }
    
    public void setShutCause(String shutCause) {
        this.shutCause = shutCause;
    }
    public String getShutCause() {
        return this.shutCause;
    }
    
    public void setShutCauseDetails(String shutCauseDetails) {
        this.shutCauseDetails = shutCauseDetails;
    }
    public String getShutCauseDetails() {
        return this.shutCauseDetails;
    }
    
    public void setShutDescribe(String shutDescribe) {
        this.shutDescribe = shutDescribe;
    }
    public String getShutDescribe() {
        return this.shutDescribe;
    }
    
    public void setShutDate(Date shutDate) {
        this.shutDate = shutDate;
    }
    public Date getShutDate() {
        return this.shutDate;
    }
    
    public void setTrackStatus(String trackStatus) {
        this.trackStatus = trackStatus;
    }
    public String getTrackStatus() {
        return this.trackStatus;
    }
    
    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }
    public String getIsDelete() {
        return this.isDelete;
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
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (reservationId == null)
           
               ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
                reservationId = RandomIDGennerator.get().generate();
    }

    public interface PsiCustomerReservationTrackEntityValidGroup {}
    public interface ReservationIdValidGroup {}
    public interface InfoIdValidGroup {}
    public interface CustomerIdValidGroup {}
    public interface StoreIdValidGroup {}
    public interface ConsultantIdValidGroup {}
    public interface ManagerIdValidGroup {}
    public interface StoreManagerIdValidGroup {}
    public interface MakeOrderPersonNameValidGroup {}
    public interface MakeOrderPersonIphoneValidGroup {}
    public interface MakeOrderPersonRoleValidGroup {}
    public interface QuoteMerchantsNameValidGroup {}
    public interface BusinessTypeValidGroup {}
    public interface BusinessOrderNoValidGroup {}
    public interface BusinessClassifyValidGroup {}
    public interface AgreeDescribeValidGroup {}
    public interface OtherBrandInquiryIdValidGroup {}
    public interface OneselfBrandInquiryIdValidGroup {}
    public interface EstimateDealPriceValidGroup {}
    public interface DealPriceEndValidGroup {}
    public interface CustomerIntentionValidGroup {}
    public interface ShutCauseValidGroup {}
    public interface ShutCauseDetailsValidGroup {}
    public interface ShutDescribeValidGroup {}
    public interface TrackStatusValidGroup {}
    public interface IsDeleteValidGroup {}
    public interface CreatedByValidGroup {}
    public interface CreatedDateValidGroup {}
    public interface UpdatedByValidGroup {}
    public interface UpdatedDateValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            ReservationIdValidGroup.class
            , InfoIdValidGroup.class
            , CustomerIdValidGroup.class
            , StoreIdValidGroup.class
            , ConsultantIdValidGroup.class
            , ManagerIdValidGroup.class
            , StoreManagerIdValidGroup.class
            , MakeOrderPersonNameValidGroup.class
            , MakeOrderPersonIphoneValidGroup.class
            , MakeOrderPersonRoleValidGroup.class
            , QuoteMerchantsNameValidGroup.class
            , BusinessTypeValidGroup.class
            , BusinessOrderNoValidGroup.class
            , BusinessClassifyValidGroup.class
            , AgreeDescribeValidGroup.class
            , OtherBrandInquiryIdValidGroup.class
            , OneselfBrandInquiryIdValidGroup.class
            , EstimateDealPriceValidGroup.class
            , DealPriceEndValidGroup.class
            , CustomerIntentionValidGroup.class
            , ShutCauseValidGroup.class
            , ShutCauseDetailsValidGroup.class
            , ShutDescribeValidGroup.class
            , TrackStatusValidGroup.class
            , IsDeleteValidGroup.class
            , CreatedByValidGroup.class
            , CreatedDateValidGroup.class
            , UpdatedByValidGroup.class
            , UpdatedDateValidGroup.class
        };
    }
}
