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

@ApiModel(value = "PsiCarAcquisitionEntity", description = "车辆收购表")
@GroupSequence({PsiCarAcquisitionEntity.class, PsiCarAcquisitionEntity.PsiCarAcquisitionEntityValidGroup.class,PsiCarAcquisitionEntity.ReservationIdValidGroup.class,PsiCarAcquisitionEntity.OtherBrandInquiryIdValidGroup.class,PsiCarAcquisitionEntity.CustomerIntentionValidGroup.class,PsiCarAcquisitionEntity.EstimateDealPriceValidGroup.class,PsiCarAcquisitionEntity.InvoiceNumValidGroup.class,PsiCarAcquisitionEntity.DealPriceEndValidGroup.class,PsiCarAcquisitionEntity.PayTypeValidGroup.class,PsiCarAcquisitionEntity.MaterialStatusValidGroup.class,PsiCarAcquisitionEntity.AcquisitionStatusValidGroup.class,PsiCarAcquisitionEntity.ApprovalStatusValidGroup.class,PsiCarAcquisitionEntity.AcquisitionAbandonedReasonValidGroup.class,PsiCarAcquisitionEntity.CreatedByValidGroup.class,PsiCarAcquisitionEntity.CreatedDateValidGroup.class,PsiCarAcquisitionEntity.UpdatedByValidGroup.class,PsiCarAcquisitionEntity.UpdatedDateValidGroup.class,PsiCarAcquisitionEntity.OneselfBrandInquiryidValidGroup.class,PsiCarAcquisitionEntity.AcquirerIdValidGroup.class,PsiCarAcquisitionEntity.StorageIdValidGroup.class}) 
public class PsiCarAcquisitionEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 预约ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "预约ID 不能是Null", groups = {PsiCarAcquisitionEntityValidGroup.class, ReservationIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="预约ID 数字精度必须符合(19,0)", groups = {PsiCarAcquisitionEntityValidGroup.class, ReservationIdValidGroup.class})
    @ApiModelProperty(value = "预约ID")
    private Long reservationId;
    
    
    /**
     * 他品询价ID
     */
    @Digits(integer=19, fraction=0, message="他品询价ID 数字精度必须符合(19,0)", groups = {PsiCarAcquisitionEntityValidGroup.class, OtherBrandInquiryIdValidGroup.class})
    @ApiModelProperty(value = "他品询价ID")
    private Long otherBrandInquiryId;
    
    /**
     * 客户意向：01、同意，02、要求议价、03、客户拒绝
     */
    @NotNull(message = "客户意向：01、同意，02、要求议价、03、客户拒绝 不能是Null", groups = {PsiCarAcquisitionEntityValidGroup.class, CustomerIntentionValidGroup.class})
    @Size(min=0, max=4, message="客户意向：01、同意，02、要求议价、03、客户拒绝 字符长度必须小于等于4", groups = {PsiCarAcquisitionEntityValidGroup.class, CustomerIntentionValidGroup.class})
    @ApiModelProperty(value = "客户意向：01、同意，02、要求议价、03、客户拒绝")
    private String customerIntention;
    
    /**
     * 预计成交价(估价)
     */
    @NotNull(message = "预计成交价(估价) 不能是Null", groups = {PsiCarAcquisitionEntityValidGroup.class, EstimateDealPriceValidGroup.class})
    @Digits(integer=9, fraction=0, message="预计成交价(估价) 数字精度必须符合(9,0)", groups = {PsiCarAcquisitionEntityValidGroup.class, EstimateDealPriceValidGroup.class})
    @ApiModelProperty(value = "预计成交价(估价)")
    private Long estimateDealPrice;
    
    /**
     * 发票号
     */
    @Size(min=0, max=30, message="发票号 字符长度必须小于等于30", groups = {PsiCarAcquisitionEntityValidGroup.class, InvoiceNumValidGroup.class})
    @ApiModelProperty(value = "发票号")
    private String invoiceNum;
    
    /**
     * 最终成交价
     */
    @Digits(integer=9, fraction=0, message="最终成交价 数字精度必须符合(9,0)", groups = {PsiCarAcquisitionEntityValidGroup.class, DealPriceEndValidGroup.class})
    @ApiModelProperty(value = "最终成交价")
    private Long dealPriceEnd;
    
    /**
     * 支付方式：01、全款，02、分批
     */
    @Size(min=0, max=4, message="支付方式：01、全款，02、分批 字符长度必须小于等于4", groups = {PsiCarAcquisitionEntityValidGroup.class, PayTypeValidGroup.class})
    @ApiModelProperty(value = "支付方式：01、全款，02、分批")
    private String payType;
    
    /**
     * 材料状态：01、待上传，02、重新上传，03、已上传
     */
    @NotNull(message = "材料状态：01、待上传，02、重新上传，03、已上传 不能是Null", groups = {PsiCarAcquisitionEntityValidGroup.class, MaterialStatusValidGroup.class})
    @Size(min=0, max=4, message="材料状态：01、待上传，02、重新上传，03、已上传 字符长度必须小于等于4", groups = {PsiCarAcquisitionEntityValidGroup.class, MaterialStatusValidGroup.class})
    @ApiModelProperty(value = "材料状态：01、待上传，02、重新上传，03、已上传")
    private String materialStatus;
    
    /**
     * 收购状态：01、待收购，02、已收购，09、放弃收购
     */
    @NotNull(message = "收购状态：01、待收购，02、已收购，09、放弃收购 不能是Null", groups = {PsiCarAcquisitionEntityValidGroup.class, AcquisitionStatusValidGroup.class})
    @Size(min=0, max=4, message="收购状态：01、待收购，02、已收购，09、放弃收购 字符长度必须小于等于4", groups = {PsiCarAcquisitionEntityValidGroup.class, AcquisitionStatusValidGroup.class})
    @ApiModelProperty(value = "收购状态：01、待收购，02、已收购，09、放弃收购")
    private String acquisitionStatus;
    
    /**
     * 审批状态：01、待确认，02、确认通过，03、待审批，04、审批通过，05、驳回，09、关闭
     */
    @Size(min=0, max=4, message="审批状态：01、待确认，02、确认通过，03、待审批，04、审批通过，05、驳回，09、关闭 字符长度必须小于等于4", groups = {PsiCarAcquisitionEntityValidGroup.class, ApprovalStatusValidGroup.class})
    @ApiModelProperty(value = "审批状态：01、待确认，02、确认通过，03、待审批，04、审批通过，05、驳回，09、关闭")
    private String approvalStatus;
    
    /**
     * 收购放弃原因
     */
    @Size(min=0, max=200, message="收购放弃原因 字符长度必须小于等于200", groups = {PsiCarAcquisitionEntityValidGroup.class, AcquisitionAbandonedReasonValidGroup.class})
    @ApiModelProperty(value = "收购放弃原因")
    private String acquisitionAbandonedReason;
    
    /**
     * 预计过户时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "预计过户时间")
    private Date estimatedTransferTime;
    
    /**
     * 创建人ID
     */
    @NotNull(message = "创建人ID 不能是Null", groups = {PsiCarAcquisitionEntityValidGroup.class, CreatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人ID 数字精度必须符合(19,0)", groups = {PsiCarAcquisitionEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人ID")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {PsiCarAcquisitionEntityValidGroup.class, CreatedDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 更新人ID
     */
    @NotNull(message = "更新人ID 不能是Null", groups = {PsiCarAcquisitionEntityValidGroup.class, UpdatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="更新人ID 数字精度必须符合(19,0)", groups = {PsiCarAcquisitionEntityValidGroup.class, UpdatedByValidGroup.class})
    @ApiModelProperty(value = "更新人ID")
    private Long updatedBy;
    
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "更新时间 不能是Null", groups = {PsiCarAcquisitionEntityValidGroup.class, UpdatedDateValidGroup.class})
    @ApiModelProperty(value = "更新时间")
    private Date updatedDate;
    
    /**
     * 本品询价ID
     */
    @Digits(integer=19, fraction=0, message="本品询价ID 数字精度必须符合(19,0)", groups = {PsiCarAcquisitionEntityValidGroup.class, OneselfBrandInquiryidValidGroup.class})
    @ApiModelProperty(value = "本品询价ID")
    private Long oneselfBrandInquiryid;
    
    /**
     * 收购人员id
     */
    @Digits(integer=19, fraction=0, message="收购人员id 数字精度必须符合(19,0)", groups = {PsiCarAcquisitionEntityValidGroup.class, AcquirerIdValidGroup.class})
    @ApiModelProperty(value = "收购人员id")
    private Long acquirerId;
    
    /**
     * 本品收购入库仓库id
     */
    @Digits(integer=19, fraction=0, message="本品收购入库仓库id 数字精度必须符合(19,0)", groups = {PsiCarAcquisitionEntityValidGroup.class, StorageIdValidGroup.class})
    @ApiModelProperty(value = "本品收购入库仓库id")
    private Long storageId;
    
    public PsiCarAcquisitionEntity() {
    }
    
    public PsiCarAcquisitionEntity(Long reservationId) {
        this.reservationId = reservationId;
    }

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }
    public Long getReservationId() {
        return this.reservationId;
    }
    

    public void setOtherBrandInquiryId(Long otherBrandInquiryId) {
        this.otherBrandInquiryId = otherBrandInquiryId;
    }
    public Long getOtherBrandInquiryId() {
        return this.otherBrandInquiryId;
    }
    
    public void setCustomerIntention(String customerIntention) {
        this.customerIntention = customerIntention;
    }
    public String getCustomerIntention() {
        return this.customerIntention;
    }
    
    public void setEstimateDealPrice(Long estimateDealPrice) {
        this.estimateDealPrice = estimateDealPrice;
    }
    public Long getEstimateDealPrice() {
        return this.estimateDealPrice;
    }
    
    public void setInvoiceNum(String invoiceNum) {
        this.invoiceNum = invoiceNum;
    }
    public String getInvoiceNum() {
        return this.invoiceNum;
    }
    
    public void setDealPriceEnd(Long dealPriceEnd) {
        this.dealPriceEnd = dealPriceEnd;
    }
    public Long getDealPriceEnd() {
        return this.dealPriceEnd;
    }
    
    public void setPayType(String payType) {
        this.payType = payType;
    }
    public String getPayType() {
        return this.payType;
    }
    
    public void setMaterialStatus(String materialStatus) {
        this.materialStatus = materialStatus;
    }
    public String getMaterialStatus() {
        return this.materialStatus;
    }
    
    public void setAcquisitionStatus(String acquisitionStatus) {
        this.acquisitionStatus = acquisitionStatus;
    }
    public String getAcquisitionStatus() {
        return this.acquisitionStatus;
    }
    
    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }
    public String getApprovalStatus() {
        return this.approvalStatus;
    }
    
    public void setAcquisitionAbandonedReason(String acquisitionAbandonedReason) {
        this.acquisitionAbandonedReason = acquisitionAbandonedReason;
    }
    public String getAcquisitionAbandonedReason() {
        return this.acquisitionAbandonedReason;
    }
    
    public void setEstimatedTransferTime(Date estimatedTransferTime) {
        this.estimatedTransferTime = estimatedTransferTime;
    }
    public Date getEstimatedTransferTime() {
        return this.estimatedTransferTime;
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
    
    public void setOneselfBrandInquiryid(Long oneselfBrandInquiryid) {
        this.oneselfBrandInquiryid = oneselfBrandInquiryid;
    }
    public Long getOneselfBrandInquiryid() {
        return this.oneselfBrandInquiryid;
    }
    
    public void setAcquirerId(Long acquirerId) {
        this.acquirerId = acquirerId;
    }
    public Long getAcquirerId() {
        return this.acquirerId;
    }
    
    public void setStorageId(Long storageId) {
        this.storageId = storageId;
    }
    public Long getStorageId() {
        return this.storageId;
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

    public interface PsiCarAcquisitionEntityValidGroup {}
    public interface ReservationIdValidGroup {}
    public interface OtherBrandInquiryIdValidGroup {}
    public interface CustomerIntentionValidGroup {}
    public interface EstimateDealPriceValidGroup {}
    public interface InvoiceNumValidGroup {}
    public interface DealPriceEndValidGroup {}
    public interface PayTypeValidGroup {}
    public interface MaterialStatusValidGroup {}
    public interface AcquisitionStatusValidGroup {}
    public interface ApprovalStatusValidGroup {}
    public interface AcquisitionAbandonedReasonValidGroup {}
    public interface CreatedByValidGroup {}
    public interface CreatedDateValidGroup {}
    public interface UpdatedByValidGroup {}
    public interface UpdatedDateValidGroup {}
    public interface OneselfBrandInquiryidValidGroup {}
    public interface AcquirerIdValidGroup {}
    public interface StorageIdValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            PsiCarAcquisitionEntity.ReservationIdValidGroup.class
            , PsiCarAcquisitionEntity.OtherBrandInquiryIdValidGroup.class
            , PsiCarAcquisitionEntity.CustomerIntentionValidGroup.class
            , PsiCarAcquisitionEntity.EstimateDealPriceValidGroup.class
            , PsiCarAcquisitionEntity.InvoiceNumValidGroup.class
            , PsiCarAcquisitionEntity.DealPriceEndValidGroup.class
            , PsiCarAcquisitionEntity.PayTypeValidGroup.class
            , PsiCarAcquisitionEntity.MaterialStatusValidGroup.class
            , PsiCarAcquisitionEntity.AcquisitionStatusValidGroup.class
            , PsiCarAcquisitionEntity.ApprovalStatusValidGroup.class
            , PsiCarAcquisitionEntity.AcquisitionAbandonedReasonValidGroup.class
            , PsiCarAcquisitionEntity.CreatedByValidGroup.class
            , PsiCarAcquisitionEntity.CreatedDateValidGroup.class
            , PsiCarAcquisitionEntity.UpdatedByValidGroup.class
            , PsiCarAcquisitionEntity.UpdatedDateValidGroup.class
            , PsiCarAcquisitionEntity.OneselfBrandInquiryidValidGroup.class
            , PsiCarAcquisitionEntity.AcquirerIdValidGroup.class
            , PsiCarAcquisitionEntity.StorageIdValidGroup.class
        };
    }
}
