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
import com.exp.ucmp.entity.SysRightActivitiesDistributeDetailsEntity.DistributeDetailIdValidGroup;
import com.exp.ucmp.entity.SysRightActivitiesDistributeDetailsEntity.SysRightActivitiesDistributeDetailsEntityValidGroup;

@ApiModel(value = "RepReplacementApprovalEntity", description = "置换审批表")
@GroupSequence({RepReplacementApprovalEntity.class, RepReplacementApprovalEntity.RepReplacementApprovalEntityValidGroup.class,RepReplacementApprovalEntity.ReplacementIdValidGroup.class,RepReplacementApprovalEntity.ReservationIdValidGroup.class,RepReplacementApprovalEntity.CustomerIdValidGroup.class,RepReplacementApprovalEntity.StoreIdValidGroup.class,RepReplacementApprovalEntity.StoreNameValidGroup.class,RepReplacementApprovalEntity.MakeOrderPersonIdValidGroup.class,RepReplacementApprovalEntity.MakeOrderPersonNameValidGroup.class,RepReplacementApprovalEntity.BusinessTypeValidGroup.class,RepReplacementApprovalEntity.BusinessOrderNoValidGroup.class,RepReplacementApprovalEntity.BusinessClassifyValidGroup.class,RepReplacementApprovalEntity.OldCarCustomerNameValidGroup.class,RepReplacementApprovalEntity.OldCarCustomerIphoneValidGroup.class,RepReplacementApprovalEntity.OldCarModelDescribeValidGroup.class,RepReplacementApprovalEntity.ReportingDateEndValidGroup.class,RepReplacementApprovalEntity.RightsIssueSignValidGroup.class,RepReplacementApprovalEntity.OldCarConfirmSignValidGroup.class,RepReplacementApprovalEntity.ApprovalStatusValidGroup.class,RepReplacementApprovalEntity.CreatedPersonNameValidGroup.class,RepReplacementApprovalEntity.IsDeleteValidGroup.class,RepReplacementApprovalEntity.CreatedByValidGroup.class,RepReplacementApprovalEntity.CreatedDateValidGroup.class,RepReplacementApprovalEntity.UpdatedByValidGroup.class,RepReplacementApprovalEntity.UpdatedDateValidGroup.class}) 
public class RepReplacementApprovalEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 置换ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "置换ID 不能是Null", groups = {RepReplacementApprovalEntityValidGroup.class, ReplacementIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="置换ID 数字精度必须符合(19,0)", groups = {RepReplacementApprovalEntityValidGroup.class, ReplacementIdValidGroup.class})
    @ApiModelProperty(value = "置换ID")
    private Long replacementId;
    
    
    /**
     * 预约ID
     */
    @NotNull(message = "预约ID 不能是Null", groups = {RepReplacementApprovalEntityValidGroup.class, ReservationIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="预约ID 数字精度必须符合(19,0)", groups = {RepReplacementApprovalEntityValidGroup.class, ReservationIdValidGroup.class})
    @ApiModelProperty(value = "预约ID")
    private Long reservationId;
    
    /**
     * 客户ID
     */
    @NotNull(message = "客户ID 不能是Null", groups = {RepReplacementApprovalEntityValidGroup.class, CustomerIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="客户ID 数字精度必须符合(19,0)", groups = {RepReplacementApprovalEntityValidGroup.class, CustomerIdValidGroup.class})
    @ApiModelProperty(value = "客户ID")
    private Long customerId;
    
    /**
     * 门店ID
     */
    @NotNull(message = "门店ID 不能是Null", groups = {RepReplacementApprovalEntityValidGroup.class, StoreIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="门店ID 数字精度必须符合(19,0)", groups = {RepReplacementApprovalEntityValidGroup.class, StoreIdValidGroup.class})
    @ApiModelProperty(value = "门店ID")
    private Long storeId;
    
    /**
     * 门店名
     */
    @Size(min=0, max=50, message="门店名 字符长度必须小于等于50", groups = {RepReplacementApprovalEntityValidGroup.class, StoreNameValidGroup.class})
    @ApiModelProperty(value = "门店名")
    private String storeName;
    
    /**
     * 制单人ID
     */
    @NotNull(message = "制单人ID 不能是Null", groups = {RepReplacementApprovalEntityValidGroup.class, MakeOrderPersonIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="制单人ID 数字精度必须符合(19,0)", groups = {RepReplacementApprovalEntityValidGroup.class, MakeOrderPersonIdValidGroup.class})
    @ApiModelProperty(value = "制单人ID")
    private Long makeOrderPersonId;
    
    /**
     * 制单人姓名
     */
    @Size(min=0, max=20, message="制单人姓名 字符长度必须小于等于20", groups = {RepReplacementApprovalEntityValidGroup.class, MakeOrderPersonNameValidGroup.class})
    @ApiModelProperty(value = "制单人姓名")
    private String makeOrderPersonName;
    
    /**
     * 业务类型：01、他品，02、本品
     */
    @NotNull(message = "业务类型：01、他品，02、本品 不能是Null", groups = {RepReplacementApprovalEntityValidGroup.class, BusinessTypeValidGroup.class})
    @Size(min=0, max=4, message="业务类型：01、他品，02、本品 字符长度必须小于等于4", groups = {RepReplacementApprovalEntityValidGroup.class, BusinessTypeValidGroup.class})
    @ApiModelProperty(value = "业务类型：01、他品，02、本品")
    private String businessType;
    
    /**
     * 业务单号(同线索单号)
     */
    @NotNull(message = "业务单号(同线索单号) 不能是Null", groups = {RepReplacementApprovalEntityValidGroup.class, BusinessOrderNoValidGroup.class})
    @Size(min=0, max=20, message="业务单号(同线索单号) 字符长度必须小于等于20", groups = {RepReplacementApprovalEntityValidGroup.class, BusinessOrderNoValidGroup.class})
    @ApiModelProperty(value = "业务单号(同线索单号)")
    private String businessOrderNo;
    
    /**
     * 1601置换/1602销售   业务标识
     */
    @NotNull(message = "1601置换/1602销售   业务标识 不能是Null", groups = {RepReplacementApprovalEntityValidGroup.class, BusinessClassifyValidGroup.class})
    @Size(min=0, max=4, message="1601置换/1602销售   业务标识 字符长度必须小于等于4", groups = {RepReplacementApprovalEntityValidGroup.class, BusinessClassifyValidGroup.class})
    @ApiModelProperty(value = "1601置换/1602销售   业务标识")
    private String businessClassify;
    
    /**
     * 旧车客户姓名
     */
    @Size(min=0, max=20, message="旧车客户姓名 字符长度必须小于等于20", groups = {RepReplacementApprovalEntityValidGroup.class, OldCarCustomerNameValidGroup.class})
    @ApiModelProperty(value = "旧车客户姓名")
    private String oldCarCustomerName;
    
    /**
     * 旧车客户手机号
     */
    @Size(min=0, max=20, message="旧车客户手机号 字符长度必须小于等于20", groups = {RepReplacementApprovalEntityValidGroup.class, OldCarCustomerIphoneValidGroup.class})
    @ApiModelProperty(value = "旧车客户手机号")
    private String oldCarCustomerIphone;
    
    /**
     * 旧车车型描述
     */
    @NotNull(message = "旧车车型描述 不能是Null", groups = {RepReplacementApprovalEntityValidGroup.class, OldCarModelDescribeValidGroup.class})
    @Size(min=0, max=200, message="旧车车型描述 字符长度必须小于等于200", groups = {RepReplacementApprovalEntityValidGroup.class, OldCarModelDescribeValidGroup.class})
    @ApiModelProperty(value = "旧车车型描述")
    private String oldCarModelDescribe;
    
    /**
     * 最后交易上报时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "最后交易上报时间 不能是Null", groups = {RepReplacementApprovalEntityValidGroup.class, ReportingDateEndValidGroup.class})
    @ApiModelProperty(value = "最后交易上报时间")
    private Date reportingDateEnd;
    
    /**
     * 最后审批时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "最后审批时间")
    private Date approvalDateEnd;
    
    /**
     * 权益发放标志：01、发放，02、不发放
     */
    @Size(min=0, max=4, message="权益发放标志：01、发放，02、不发放 字符长度必须小于等于4", groups = {RepReplacementApprovalEntityValidGroup.class, RightsIssueSignValidGroup.class})
    @ApiModelProperty(value = "权益发放标志：01、发放，02、不发放")
    private String rightsIssueSign;
    
    /**
     * 旧车确认状态：01、未确认，02、已确认
     */
    @NotNull(message = "旧车确认状态：01、未确认，02、已确认 不能是Null", groups = {RepReplacementApprovalEntityValidGroup.class, OldCarConfirmSignValidGroup.class})
    @Size(min=0, max=4, message="旧车确认状态：01、未确认，02、已确认 字符长度必须小于等于4", groups = {RepReplacementApprovalEntityValidGroup.class, OldCarConfirmSignValidGroup.class})
    @ApiModelProperty(value = "旧车确认状态：01、未确认，02、已确认")
    private String oldCarConfirmSign;
    
    /**
     * 审批状态：01、待确认，02、确认通过，03、待审批，04、审批通过，05、驳回，09、关闭
     */
    @NotNull(message = "审批状态：01、待确认，02、确认通过，03、待审批，04、审批通过，05、驳回，09、关闭 不能是Null", groups = {RepReplacementApprovalEntityValidGroup.class, ApprovalStatusValidGroup.class})
    @Size(min=0, max=4, message="审批状态：01、待确认，02、确认通过，03、待审批，04、审批通过，05、驳回，09、关闭 字符长度必须小于等于4", groups = {RepReplacementApprovalEntityValidGroup.class, ApprovalStatusValidGroup.class})
    @ApiModelProperty(value = "审批状态：01、待确认，02、确认通过，03、待审批，04、审批通过，05、驳回，09、关闭")
    private String approvalStatus;
    
    /**
     * 创建人姓名
     */
    @Size(min=0, max=50, message="创建人姓名 字符长度必须小于等于50", groups = {RepReplacementApprovalEntityValidGroup.class, CreatedPersonNameValidGroup.class})
    @ApiModelProperty(value = "创建人姓名")
    private String createdPersonName;
    
    /**
     * 是否被删除：00、删除，01、未删除
     */
    @NotNull(message = "是否被删除：00、删除，01、未删除 不能是Null", groups = {RepReplacementApprovalEntityValidGroup.class, IsDeleteValidGroup.class})
    @Size(min=0, max=2, message="是否被删除：00、删除，01、未删除 字符长度必须小于等于2", groups = {RepReplacementApprovalEntityValidGroup.class, IsDeleteValidGroup.class})
    @ApiModelProperty(value = "是否被删除：00、删除，01、未删除")
    private String isDelete;
    
    /**
     * 创建人ID
     */
    @NotNull(message = "创建人ID 不能是Null", groups = {RepReplacementApprovalEntityValidGroup.class, CreatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人ID 数字精度必须符合(19,0)", groups = {RepReplacementApprovalEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人ID")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {RepReplacementApprovalEntityValidGroup.class, CreatedDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 更新人ID
     */
    @NotNull(message = "更新人ID 不能是Null", groups = {RepReplacementApprovalEntityValidGroup.class, UpdatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="更新人ID 数字精度必须符合(19,0)", groups = {RepReplacementApprovalEntityValidGroup.class, UpdatedByValidGroup.class})
    @ApiModelProperty(value = "更新人ID")
    private Long updatedBy;
    
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "更新时间 不能是Null", groups = {RepReplacementApprovalEntityValidGroup.class, UpdatedDateValidGroup.class})
    @ApiModelProperty(value = "更新时间")
    private Date updatedDate;
    
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
     * 权益发放时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "权益发放时间")
    private Date grantBenefitsTime;
    
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
    
    public RepReplacementApprovalEntity() {
    }
    
    public RepReplacementApprovalEntity(Long replacementId) {
        this.replacementId = replacementId;
    }

    public void setReplacementId(Long replacementId) {
        this.replacementId = replacementId;
    }
    public Long getReplacementId() {
        return this.replacementId;
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
    
    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
    public String getStoreName() {
        return this.storeName;
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
    
    public void setOldCarCustomerName(String oldCarCustomerName) {
        this.oldCarCustomerName = oldCarCustomerName;
    }
    public String getOldCarCustomerName() {
        return this.oldCarCustomerName;
    }
    
    public void setOldCarCustomerIphone(String oldCarCustomerIphone) {
        this.oldCarCustomerIphone = oldCarCustomerIphone;
    }
    public String getOldCarCustomerIphone() {
        return this.oldCarCustomerIphone;
    }
    
    public void setOldCarModelDescribe(String oldCarModelDescribe) {
        this.oldCarModelDescribe = oldCarModelDescribe;
    }
    public String getOldCarModelDescribe() {
        return this.oldCarModelDescribe;
    }
    
    public void setReportingDateEnd(Date reportingDateEnd) {
        this.reportingDateEnd = reportingDateEnd;
    }
    public Date getReportingDateEnd() {
        return this.reportingDateEnd;
    }
    
    public void setApprovalDateEnd(Date approvalDateEnd) {
        this.approvalDateEnd = approvalDateEnd;
    }
    public Date getApprovalDateEnd() {
        return this.approvalDateEnd;
    }
    
    public void setRightsIssueSign(String rightsIssueSign) {
        this.rightsIssueSign = rightsIssueSign;
    }
    public String getRightsIssueSign() {
        return this.rightsIssueSign;
    }
    
	public void setOldCarConfirmSign(String oldCarConfirmSign) {
        this.oldCarConfirmSign = oldCarConfirmSign;
    }
    public String getOldCarConfirmSign() {
        return this.oldCarConfirmSign;
    }
    
    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }
    public String getApprovalStatus() {
        return this.approvalStatus;
    }
    
    public void setCreatedPersonName(String createdPersonName) {
        this.createdPersonName = createdPersonName;
    }
    public String getCreatedPersonName() {
        return this.createdPersonName;
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
    
    public void setGrantBenefitsTime(Date grantBenefitsTime) {
        this.grantBenefitsTime = grantBenefitsTime;
    }
    public Date getGrantBenefitsTime() {
        return this.grantBenefitsTime;
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
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (replacementId == null)
           
               ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
                replacementId = RandomIDGennerator.get().generate();
    }

    public interface RepReplacementApprovalEntityValidGroup {}
    public interface ReplacementIdValidGroup {}
    public interface ReservationIdValidGroup {}
    public interface CustomerIdValidGroup {}
    public interface StoreIdValidGroup {}
    public interface StoreNameValidGroup {}
    public interface MakeOrderPersonIdValidGroup {}
    public interface MakeOrderPersonNameValidGroup {}
    public interface BusinessTypeValidGroup {}
    public interface BusinessOrderNoValidGroup {}
    public interface BusinessClassifyValidGroup {}
    public interface OldCarCustomerNameValidGroup {}
    public interface OldCarCustomerIphoneValidGroup {}
    public interface OldCarModelDescribeValidGroup {}
    public interface ReportingDateEndValidGroup {}
    public interface RightsIssueSignValidGroup {}
    public interface OldCarConfirmSignValidGroup {}
    public interface ApprovalStatusValidGroup {}
    public interface CreatedPersonNameValidGroup {}
    public interface IsDeleteValidGroup {}
    public interface CreatedByValidGroup {}
    public interface CreatedDateValidGroup {}
    public interface UpdatedByValidGroup {}
    public interface UpdatedDateValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            ReplacementIdValidGroup.class
            , ReservationIdValidGroup.class
            , CustomerIdValidGroup.class
            , StoreIdValidGroup.class
            , StoreNameValidGroup.class
            , MakeOrderPersonIdValidGroup.class
            , MakeOrderPersonNameValidGroup.class
            , BusinessTypeValidGroup.class
            , BusinessOrderNoValidGroup.class
            , BusinessClassifyValidGroup.class
            , OldCarCustomerNameValidGroup.class
            , OldCarCustomerIphoneValidGroup.class
            , OldCarModelDescribeValidGroup.class
            , ReportingDateEndValidGroup.class
            , RightsIssueSignValidGroup.class
            , OldCarConfirmSignValidGroup.class
            , ApprovalStatusValidGroup.class
            , CreatedPersonNameValidGroup.class
            , IsDeleteValidGroup.class
            , CreatedByValidGroup.class
            , CreatedDateValidGroup.class
            , UpdatedByValidGroup.class
            , UpdatedDateValidGroup.class
        };
    }
}
