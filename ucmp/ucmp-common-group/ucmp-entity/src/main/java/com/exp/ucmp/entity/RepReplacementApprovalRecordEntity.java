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

@ApiModel(value = "RepReplacementApprovalRecordEntity", description = "置换审批记录表")
@GroupSequence({RepReplacementApprovalRecordEntity.class, RepReplacementApprovalRecordEntity.RepReplacementApprovalRecordEntityValidGroup.class,RepReplacementApprovalRecordEntity.ApprovalIdValidGroup.class,RepReplacementApprovalRecordEntity.ReplacementIdValidGroup.class,RepReplacementApprovalRecordEntity.ApprovalResultValidGroup.class,RepReplacementApprovalRecordEntity.ApprovalRemarkValidGroup.class,RepReplacementApprovalRecordEntity.ApprovalPersonValidGroup.class,RepReplacementApprovalRecordEntity.ApprovalPersonNameValidGroup.class,RepReplacementApprovalRecordEntity.ApprovalDateValidGroup.class,RepReplacementApprovalRecordEntity.ReportingDateValidGroup.class,RepReplacementApprovalRecordEntity.ReplacementBeforeStatusValidGroup.class}) 
public class RepReplacementApprovalRecordEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 审批ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "审批ID 不能是Null", groups = {RepReplacementApprovalRecordEntityValidGroup.class, ApprovalIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="审批ID 数字精度必须符合(19,0)", groups = {RepReplacementApprovalRecordEntityValidGroup.class, ApprovalIdValidGroup.class})
    @ApiModelProperty(value = "审批ID")
    private Long approvalId;
    
    
    /**
     * 置换ID
     */
    @NotNull(message = "置换ID 不能是Null", groups = {RepReplacementApprovalRecordEntityValidGroup.class, ReplacementIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="置换ID 数字精度必须符合(19,0)", groups = {RepReplacementApprovalRecordEntityValidGroup.class, ReplacementIdValidGroup.class})
    @ApiModelProperty(value = "置换ID")
    private Long replacementId;
    
    /**
     * 审批结果：01、审批通过，02、审批驳回，03、审批关闭
     */
    @NotNull(message = "审批结果：01、审批通过，02、审批驳回，03、审批关闭 不能是Null", groups = {RepReplacementApprovalRecordEntityValidGroup.class, ApprovalResultValidGroup.class})
    @Size(min=0, max=4, message="审批结果：01、审批通过，02、审批驳回，03、审批关闭 字符长度必须小于等于4", groups = {RepReplacementApprovalRecordEntityValidGroup.class, ApprovalResultValidGroup.class})
    @ApiModelProperty(value = "审批结果：01、审批通过，02、审批驳回，03、审批关闭")
    private String approvalResult;
    
    /**
     * 审批备注
     */
    @Size(min=0, max=500, message="审批备注 字符长度必须小于等于500", groups = {RepReplacementApprovalRecordEntityValidGroup.class, ApprovalRemarkValidGroup.class})
    @ApiModelProperty(value = "审批备注")
    private String approvalRemark;
    
    /**
     * 审批人
     */
    @NotNull(message = "审批人 不能是Null", groups = {RepReplacementApprovalRecordEntityValidGroup.class, ApprovalPersonValidGroup.class})
    @Digits(integer=19, fraction=0, message="审批人 数字精度必须符合(19,0)", groups = {RepReplacementApprovalRecordEntityValidGroup.class, ApprovalPersonValidGroup.class})
    @ApiModelProperty(value = "审批人")
    private Long approvalPerson;
    
    /**
     * 
     */
    @Size(min=0, max=50, message=" 字符长度必须小于等于50", groups = {RepReplacementApprovalRecordEntityValidGroup.class, ApprovalPersonNameValidGroup.class})
    @ApiModelProperty(value = "")
    private String approvalPersonName;
    
    /**
     * 审批时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "审批时间 不能是Null", groups = {RepReplacementApprovalRecordEntityValidGroup.class, ApprovalDateValidGroup.class})
    @ApiModelProperty(value = "审批时间")
    private Date approvalDate;
    
    /**
     * 上报时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "上报时间 不能是Null", groups = {RepReplacementApprovalRecordEntityValidGroup.class, ReportingDateValidGroup.class})
    @ApiModelProperty(value = "上报时间")
    private Date reportingDate;
    
    /**
     * 置换单操作之前状态
     */
    @Size(min=0, max=4, message="置换单操作之前状态 字符长度必须小于等于4", groups = {RepReplacementApprovalRecordEntityValidGroup.class, ReplacementBeforeStatusValidGroup.class})
    @ApiModelProperty(value = "置换单操作之前状态")
    private String replacementBeforeStatus;
    
    public RepReplacementApprovalRecordEntity() {
    }
    
    public RepReplacementApprovalRecordEntity(Long approvalId) {
        this.approvalId = approvalId;
    }

    public void setApprovalId(Long approvalId) {
        this.approvalId = approvalId;
    }
    public Long getApprovalId() {
        return this.approvalId;
    }
    

    public void setReplacementId(Long replacementId) {
        this.replacementId = replacementId;
    }
    public Long getReplacementId() {
        return this.replacementId;
    }
    
    public void setApprovalResult(String approvalResult) {
        this.approvalResult = approvalResult;
    }
    public String getApprovalResult() {
        return this.approvalResult;
    }
    
    public void setApprovalRemark(String approvalRemark) {
        this.approvalRemark = approvalRemark;
    }
    public String getApprovalRemark() {
        return this.approvalRemark;
    }
    
    public void setApprovalPerson(Long approvalPerson) {
        this.approvalPerson = approvalPerson;
    }
    public Long getApprovalPerson() {
        return this.approvalPerson;
    }
    
    public void setApprovalPersonName(String approvalPersonName) {
        this.approvalPersonName = approvalPersonName;
    }
    public String getApprovalPersonName() {
        return this.approvalPersonName;
    }
    
    public void setApprovalDate(Date approvalDate) {
        this.approvalDate = approvalDate;
    }
    public Date getApprovalDate() {
        return this.approvalDate;
    }
    
    public void setReportingDate(Date reportingDate) {
        this.reportingDate = reportingDate;
    }
    public Date getReportingDate() {
        return this.reportingDate;
    }
    
    public void setReplacementBeforeStatus(String replacementBeforeStatus) {
        this.replacementBeforeStatus = replacementBeforeStatus;
    }
    public String getReplacementBeforeStatus() {
        return this.replacementBeforeStatus;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (approvalId == null)
           
               ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
                approvalId = RandomIDGennerator.get().generate();
    }

    public interface RepReplacementApprovalRecordEntityValidGroup {}
    public interface ApprovalIdValidGroup {}
    public interface ReplacementIdValidGroup {}
    public interface ApprovalResultValidGroup {}
    public interface ApprovalRemarkValidGroup {}
    public interface ApprovalPersonValidGroup {}
    public interface ApprovalPersonNameValidGroup {}
    public interface ApprovalDateValidGroup {}
    public interface ReportingDateValidGroup {}
    public interface ReplacementBeforeStatusValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            ApprovalIdValidGroup.class
            , ReplacementIdValidGroup.class
            , ApprovalResultValidGroup.class
            , ApprovalRemarkValidGroup.class
            , ApprovalPersonValidGroup.class
            , ApprovalPersonNameValidGroup.class
            , ApprovalDateValidGroup.class
            , ReportingDateValidGroup.class
            , ReplacementBeforeStatusValidGroup.class
        };
    }
}
