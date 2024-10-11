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

@ApiModel(value = "PsiWorkOrderApprovalHistoryEntity", description = "工单审批历史表(v2)")
@GroupSequence({PsiWorkOrderApprovalHistoryEntity.class, PsiWorkOrderApprovalHistoryEntity.PsiWorkOrderApprovalHistoryEntityValidGroup.class,PsiWorkOrderApprovalHistoryEntity.WordOrderApprovalIdValidGroup.class,PsiWorkOrderApprovalHistoryEntity.ServiceIdValidGroup.class,PsiWorkOrderApprovalHistoryEntity.ApprovalResultValidGroup.class,PsiWorkOrderApprovalHistoryEntity.ApprovalMarkValidGroup.class,PsiWorkOrderApprovalHistoryEntity.ApprovalPeopleValidGroup.class,PsiWorkOrderApprovalHistoryEntity.CreatedByValidGroup.class,PsiWorkOrderApprovalHistoryEntity.CreatedDateValidGroup.class,PsiWorkOrderApprovalHistoryEntity.UpdatedByValidGroup.class,PsiWorkOrderApprovalHistoryEntity.UpdatedDateValidGroup.class,PsiWorkOrderApprovalHistoryEntity.IsEnableValidGroup.class,PsiWorkOrderApprovalHistoryEntity.IsDeleteValidGroup.class}) 
public class PsiWorkOrderApprovalHistoryEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 工单审批记录id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "工单审批记录id 不能是Null", groups = {PsiWorkOrderApprovalHistoryEntityValidGroup.class, WordOrderApprovalIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="工单审批记录id 数字精度必须符合(19,0)", groups = {PsiWorkOrderApprovalHistoryEntityValidGroup.class, WordOrderApprovalIdValidGroup.class})
    @ApiModelProperty(value = "工单审批记录id")
    private Long wordOrderApprovalId;
    
    
    /**
     * 整备信息id
     */
    @NotNull(message = "整备信息id 不能是Null", groups = {PsiWorkOrderApprovalHistoryEntityValidGroup.class, ServiceIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="整备信息id 数字精度必须符合(19,0)", groups = {PsiWorkOrderApprovalHistoryEntityValidGroup.class, ServiceIdValidGroup.class})
    @ApiModelProperty(value = "整备信息id")
    private Long serviceId;
    
    /**
     * 审批日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "审批日期")
    private Date approvalDate;
    
    /**
     * 审批结果
     */
    @Size(min=0, max=255, message="审批结果 字符长度必须小于等于255", groups = {PsiWorkOrderApprovalHistoryEntityValidGroup.class, ApprovalResultValidGroup.class})
    @ApiModelProperty(value = "审批结果")
    private String approvalResult;
    
    /**
     * 审批备注
     */
    @Size(min=0, max=255, message="审批备注 字符长度必须小于等于255", groups = {PsiWorkOrderApprovalHistoryEntityValidGroup.class, ApprovalMarkValidGroup.class})
    @ApiModelProperty(value = "审批备注")
    private String approvalMark;
    
    /**
     * 审批人
     */
    @Size(min=0, max=20, message="审批人 字符长度必须小于等于20", groups = {PsiWorkOrderApprovalHistoryEntityValidGroup.class, ApprovalPeopleValidGroup.class})
    @ApiModelProperty(value = "审批人")
    private String approvalPeople;
    
    /**
     * 创建人ID
     */
    @NotNull(message = "创建人ID 不能是Null", groups = {PsiWorkOrderApprovalHistoryEntityValidGroup.class, CreatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人ID 数字精度必须符合(19,0)", groups = {PsiWorkOrderApprovalHistoryEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人ID")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {PsiWorkOrderApprovalHistoryEntityValidGroup.class, CreatedDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 更新人ID
     */
    @NotNull(message = "更新人ID 不能是Null", groups = {PsiWorkOrderApprovalHistoryEntityValidGroup.class, UpdatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="更新人ID 数字精度必须符合(19,0)", groups = {PsiWorkOrderApprovalHistoryEntityValidGroup.class, UpdatedByValidGroup.class})
    @ApiModelProperty(value = "更新人ID")
    private Long updatedBy;
    
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "更新时间 不能是Null", groups = {PsiWorkOrderApprovalHistoryEntityValidGroup.class, UpdatedDateValidGroup.class})
    @ApiModelProperty(value = "更新时间")
    private Date updatedDate;
    
    /**
     * 是否可用00、无效，01、有效
     */
    @Size(min=0, max=2, message="是否可用00、无效，01、有效 字符长度必须小于等于2", groups = {PsiWorkOrderApprovalHistoryEntityValidGroup.class, IsEnableValidGroup.class})
    @ApiModelProperty(value = "是否可用00、无效，01、有效")
    private String isEnable;
    
    /**
     * 是否已删除(00：未删除/01：已删除)
     */
    @Size(min=0, max=2, message="是否已删除(00：未删除/01：已删除) 字符长度必须小于等于2", groups = {PsiWorkOrderApprovalHistoryEntityValidGroup.class, IsDeleteValidGroup.class})
    @ApiModelProperty(value = "是否已删除(00：未删除/01：已删除)")
    private String isDelete;
    
    public PsiWorkOrderApprovalHistoryEntity() {
    }
    
    public PsiWorkOrderApprovalHistoryEntity(Long wordOrderApprovalId) {
        this.wordOrderApprovalId = wordOrderApprovalId;
    }

    public void setWordOrderApprovalId(Long wordOrderApprovalId) {
        this.wordOrderApprovalId = wordOrderApprovalId;
    }
    public Long getWordOrderApprovalId() {
        return this.wordOrderApprovalId;
    }
    

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }
    public Long getServiceId() {
        return this.serviceId;
    }
    
    public void setApprovalDate(Date approvalDate) {
        this.approvalDate = approvalDate;
    }
    public Date getApprovalDate() {
        return this.approvalDate;
    }
    
    public void setApprovalResult(String approvalResult) {
        this.approvalResult = approvalResult;
    }
    public String getApprovalResult() {
        return this.approvalResult;
    }
    
    public void setApprovalMark(String approvalMark) {
        this.approvalMark = approvalMark;
    }
    public String getApprovalMark() {
        return this.approvalMark;
    }
    
    public void setApprovalPeople(String approvalPeople) {
        this.approvalPeople = approvalPeople;
    }
    public String getApprovalPeople() {
        return this.approvalPeople;
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
    
    public void setIsEnable(String isEnable) {
        this.isEnable = isEnable;
    }
    public String getIsEnable() {
        return this.isEnable;
    }
    
    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }
    public String getIsDelete() {
        return this.isDelete;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (wordOrderApprovalId == null)
           
               ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
                wordOrderApprovalId = RandomIDGennerator.get().generate();
    }

    public interface PsiWorkOrderApprovalHistoryEntityValidGroup {}
    public interface WordOrderApprovalIdValidGroup {}
    public interface ServiceIdValidGroup {}
    public interface ApprovalResultValidGroup {}
    public interface ApprovalMarkValidGroup {}
    public interface ApprovalPeopleValidGroup {}
    public interface CreatedByValidGroup {}
    public interface CreatedDateValidGroup {}
    public interface UpdatedByValidGroup {}
    public interface UpdatedDateValidGroup {}
    public interface IsEnableValidGroup {}
    public interface IsDeleteValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            WordOrderApprovalIdValidGroup.class
            , ServiceIdValidGroup.class
            , ApprovalResultValidGroup.class
            , ApprovalMarkValidGroup.class
            , ApprovalPeopleValidGroup.class
            , CreatedByValidGroup.class
            , CreatedDateValidGroup.class
            , UpdatedByValidGroup.class
            , UpdatedDateValidGroup.class
            , IsEnableValidGroup.class
            , IsDeleteValidGroup.class
        };
    }
}
