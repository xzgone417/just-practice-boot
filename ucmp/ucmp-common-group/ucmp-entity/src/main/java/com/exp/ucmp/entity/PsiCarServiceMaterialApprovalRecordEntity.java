/**
 * PsiCarServiceMaterialApprovalRecordEntity
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO EgridCloud, Inc, All rights reserved.
 */
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

@ApiModel(value = "PsiCarServiceMaterialApprovalRecordEntity", description = "整备车辆材料审批记录表(二期)")
@GroupSequence({PsiCarServiceMaterialApprovalRecordEntity.class, PsiCarServiceMaterialApprovalRecordEntity.PsiCarServiceMaterialApprovalRecordEntityValidGroup.class,PsiCarServiceMaterialApprovalRecordEntity.MaterialApprovalRecordIdValidGroup.class,PsiCarServiceMaterialApprovalRecordEntity.ServiceIdValidGroup.class,PsiCarServiceMaterialApprovalRecordEntity.ApprovalDateValidGroup.class,PsiCarServiceMaterialApprovalRecordEntity.ApprovalResultValidGroup.class,PsiCarServiceMaterialApprovalRecordEntity.ApprovalRemarkValidGroup.class,PsiCarServiceMaterialApprovalRecordEntity.ApprovalPeopleIdValidGroup.class,PsiCarServiceMaterialApprovalRecordEntity.CreatedByValidGroup.class,PsiCarServiceMaterialApprovalRecordEntity.CreatedDateValidGroup.class,PsiCarServiceMaterialApprovalRecordEntity.UpdatedByValidGroup.class,PsiCarServiceMaterialApprovalRecordEntity.UpdatedDateValidGroup.class,PsiCarServiceMaterialApprovalRecordEntity.IsEnableValidGroup.class,PsiCarServiceMaterialApprovalRecordEntity.IsDeleteValidGroup.class}) 
public class PsiCarServiceMaterialApprovalRecordEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 业务id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "业务id 不能是Null", groups = {PsiCarServiceMaterialApprovalRecordEntityValidGroup.class, MaterialApprovalRecordIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="业务id 数字精度必须符合(19,0)", groups = {PsiCarServiceMaterialApprovalRecordEntityValidGroup.class, MaterialApprovalRecordIdValidGroup.class})
    @ApiModelProperty(value = "业务id")
    private Long materialApprovalRecordId;
    
    
    /**
     * 整备信息id
     */
    @NotNull(message = "整备信息id 不能是Null", groups = {PsiCarServiceMaterialApprovalRecordEntityValidGroup.class, ServiceIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="整备信息id 数字精度必须符合(19,0)", groups = {PsiCarServiceMaterialApprovalRecordEntityValidGroup.class, ServiceIdValidGroup.class})
    @ApiModelProperty(value = "整备信息id")
    private Long serviceId;
    
    /**
     * 审批日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "审批日期 不能是Null", groups = {PsiCarServiceMaterialApprovalRecordEntityValidGroup.class, ApprovalDateValidGroup.class})
    @ApiModelProperty(value = "审批日期")
    private Date approvalDate;
    
    /**
     * 审批结果00:驳回/01:通过
     */
    @NotNull(message = "审批结果00:驳回/01:通过 不能是Null", groups = {PsiCarServiceMaterialApprovalRecordEntityValidGroup.class, ApprovalResultValidGroup.class})
    @Size(min=0, max=2, message="审批结果00:驳回/01:通过 字符长度必须小于等于2", groups = {PsiCarServiceMaterialApprovalRecordEntityValidGroup.class, ApprovalResultValidGroup.class})
    @ApiModelProperty(value = "审批结果00:驳回/01:通过")
    private String approvalResult;
    
    /**
     * 审批备注
     */
    @Size(min=0, max=40, message="审批备注 字符长度必须小于等于40", groups = {PsiCarServiceMaterialApprovalRecordEntityValidGroup.class, ApprovalRemarkValidGroup.class})
    @ApiModelProperty(value = "审批备注")
    private String approvalRemark;
    
    /**
     * 审批人id
     */
    @NotNull(message = "审批人id 不能是Null", groups = {PsiCarServiceMaterialApprovalRecordEntityValidGroup.class, ApprovalPeopleIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="审批人id 数字精度必须符合(19,0)", groups = {PsiCarServiceMaterialApprovalRecordEntityValidGroup.class, ApprovalPeopleIdValidGroup.class})
    @ApiModelProperty(value = "审批人id")
    private Long approvalPeopleId;
    
    /**
     * 创建人ID
     */
    @NotNull(message = "创建人ID 不能是Null", groups = {PsiCarServiceMaterialApprovalRecordEntityValidGroup.class, CreatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人ID 数字精度必须符合(19,0)", groups = {PsiCarServiceMaterialApprovalRecordEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人ID")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {PsiCarServiceMaterialApprovalRecordEntityValidGroup.class, CreatedDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 更新人ID
     */
    @NotNull(message = "更新人ID 不能是Null", groups = {PsiCarServiceMaterialApprovalRecordEntityValidGroup.class, UpdatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="更新人ID 数字精度必须符合(19,0)", groups = {PsiCarServiceMaterialApprovalRecordEntityValidGroup.class, UpdatedByValidGroup.class})
    @ApiModelProperty(value = "更新人ID")
    private Long updatedBy;
    
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "更新时间 不能是Null", groups = {PsiCarServiceMaterialApprovalRecordEntityValidGroup.class, UpdatedDateValidGroup.class})
    @ApiModelProperty(value = "更新时间")
    private Date updatedDate;
    
    /**
     * 是否可用00、无效，01、有效
     */
    @Size(min=0, max=2, message="是否可用00、无效，01、有效 字符长度必须小于等于2", groups = {PsiCarServiceMaterialApprovalRecordEntityValidGroup.class, IsEnableValidGroup.class})
    @ApiModelProperty(value = "是否可用00、无效，01、有效")
    private String isEnable;
    
    /**
     * 是否已删除(00：未删除/01：已删除)
     */
    @NotNull(message = "是否已删除(00：未删除/01：已删除) 不能是Null", groups = {PsiCarServiceMaterialApprovalRecordEntityValidGroup.class, IsDeleteValidGroup.class})
    @Size(min=0, max=2, message="是否已删除(00：未删除/01：已删除) 字符长度必须小于等于2", groups = {PsiCarServiceMaterialApprovalRecordEntityValidGroup.class, IsDeleteValidGroup.class})
    @ApiModelProperty(value = "是否已删除(00：未删除/01：已删除)")
    private String isDelete;
    
    public PsiCarServiceMaterialApprovalRecordEntity() {
    }
    
    public PsiCarServiceMaterialApprovalRecordEntity(Long materialApprovalRecordId) {
        this.materialApprovalRecordId = materialApprovalRecordId;
    }

    public void setMaterialApprovalRecordId(Long materialApprovalRecordId) {
        this.materialApprovalRecordId = materialApprovalRecordId;
    }
    public Long getMaterialApprovalRecordId() {
        return this.materialApprovalRecordId;
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
    
    public void setApprovalRemark(String approvalRemark) {
        this.approvalRemark = approvalRemark;
    }
    public String getApprovalRemark() {
        return this.approvalRemark;
    }
    
    public void setApprovalPeopleId(Long approvalPeopleId) {
        this.approvalPeopleId = approvalPeopleId;
    }
    public Long getApprovalPeopleId() {
        return this.approvalPeopleId;
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
              (materialApprovalRecordId == null)
           
               ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
                materialApprovalRecordId = RandomIDGennerator.get().generate();
    }

    public interface PsiCarServiceMaterialApprovalRecordEntityValidGroup {}
    public interface MaterialApprovalRecordIdValidGroup {}
    public interface ServiceIdValidGroup {}
    public interface ApprovalDateValidGroup {}
    public interface ApprovalResultValidGroup {}
    public interface ApprovalRemarkValidGroup {}
    public interface ApprovalPeopleIdValidGroup {}
    public interface CreatedByValidGroup {}
    public interface CreatedDateValidGroup {}
    public interface UpdatedByValidGroup {}
    public interface UpdatedDateValidGroup {}
    public interface IsEnableValidGroup {}
    public interface IsDeleteValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            MaterialApprovalRecordIdValidGroup.class
            , ServiceIdValidGroup.class
            , ApprovalDateValidGroup.class
            , ApprovalResultValidGroup.class
            , ApprovalRemarkValidGroup.class
            , ApprovalPeopleIdValidGroup.class
            , CreatedByValidGroup.class
            , CreatedDateValidGroup.class
            , UpdatedByValidGroup.class
            , UpdatedDateValidGroup.class
            , IsEnableValidGroup.class
            , IsDeleteValidGroup.class
        };
    }
}
