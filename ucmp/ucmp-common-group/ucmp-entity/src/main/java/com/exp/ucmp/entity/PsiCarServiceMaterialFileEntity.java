/**
 * PsiCarServiceMaterialFileEntity
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

@ApiModel(value = "PsiCarServiceMaterialFileEntity", description = "整备材料文件表")
@GroupSequence({PsiCarServiceMaterialFileEntity.class, PsiCarServiceMaterialFileEntity.PsiCarServiceMaterialFileEntityValidGroup.class,PsiCarServiceMaterialFileEntity.MaterialFileIdValidGroup.class,PsiCarServiceMaterialFileEntity.MaterialIdValidGroup.class,PsiCarServiceMaterialFileEntity.MaterialFileTypeValidGroup.class,PsiCarServiceMaterialFileEntity.ApprovalPeopleIdValidGroup.class,PsiCarServiceMaterialFileEntity.RejectReasonValidGroup.class,PsiCarServiceMaterialFileEntity.ChineseDescriptionValidGroup.class,PsiCarServiceMaterialFileEntity.CreatedByValidGroup.class,PsiCarServiceMaterialFileEntity.CreatedDateValidGroup.class,PsiCarServiceMaterialFileEntity.UpdatedByValidGroup.class,PsiCarServiceMaterialFileEntity.UpdatedDateValidGroup.class,PsiCarServiceMaterialFileEntity.IsEnableValidGroup.class,PsiCarServiceMaterialFileEntity.IsDeleteValidGroup.class}) 
public class PsiCarServiceMaterialFileEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 业务id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "业务id 不能是Null", groups = {PsiCarServiceMaterialFileEntityValidGroup.class, MaterialFileIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="业务id 数字精度必须符合(19,0)", groups = {PsiCarServiceMaterialFileEntityValidGroup.class, MaterialFileIdValidGroup.class})
    @ApiModelProperty(value = "业务id")
    private Long materialFileId;
    
    
    /**
     * 材料id
     */
    @NotNull(message = "材料id 不能是Null", groups = {PsiCarServiceMaterialFileEntityValidGroup.class, MaterialIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="材料id 数字精度必须符合(19,0)", groups = {PsiCarServiceMaterialFileEntityValidGroup.class, MaterialIdValidGroup.class})
    @ApiModelProperty(value = "材料id")
    private Long materialId;
    
    /**
     * 材料文件类型(方向盘/仪表盘)
     */
    @Size(min=0, max=150, message="材料文件类型(方向盘/仪表盘) 字符长度必须小于等于150", groups = {PsiCarServiceMaterialFileEntityValidGroup.class, MaterialFileTypeValidGroup.class})
    @ApiModelProperty(value = "材料文件类型(方向盘/仪表盘)")
    private String materialFileType;
    
    /**
     * 排序
     */
    @ApiModelProperty(value = "排序")
    private Integer fileSort;
    
    /**
     * 审批人id
     */
    @Digits(integer=19, fraction=0, message="审批人id 数字精度必须符合(19,0)", groups = {PsiCarServiceMaterialFileEntityValidGroup.class, ApprovalPeopleIdValidGroup.class})
    @ApiModelProperty(value = "审批人id")
    private Long approvalPeopleId;
    
    /**
     * 审批时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "审批时间")
    private Date approvalDate;
    
    /**
     * 驳回原因
     */
    @Size(min=0, max=40, message="驳回原因 字符长度必须小于等于40", groups = {PsiCarServiceMaterialFileEntityValidGroup.class, RejectReasonValidGroup.class})
    @ApiModelProperty(value = "驳回原因")
    private String rejectReason;
    
    /**
     * 中文描述
     */
    @Size(min=0, max=50, message="中文描述 字符长度必须小于等于50", groups = {PsiCarServiceMaterialFileEntityValidGroup.class, ChineseDescriptionValidGroup.class})
    @ApiModelProperty(value = "中文描述")
    private String chineseDescription;
    
    /**
     * 创建人ID
     */
    @NotNull(message = "创建人ID 不能是Null", groups = {PsiCarServiceMaterialFileEntityValidGroup.class, CreatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人ID 数字精度必须符合(19,0)", groups = {PsiCarServiceMaterialFileEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人ID")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {PsiCarServiceMaterialFileEntityValidGroup.class, CreatedDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 更新人ID
     */
    @NotNull(message = "更新人ID 不能是Null", groups = {PsiCarServiceMaterialFileEntityValidGroup.class, UpdatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="更新人ID 数字精度必须符合(19,0)", groups = {PsiCarServiceMaterialFileEntityValidGroup.class, UpdatedByValidGroup.class})
    @ApiModelProperty(value = "更新人ID")
    private Long updatedBy;
    
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "更新时间 不能是Null", groups = {PsiCarServiceMaterialFileEntityValidGroup.class, UpdatedDateValidGroup.class})
    @ApiModelProperty(value = "更新时间")
    private Date updatedDate;
    
    /**
     * 是否可用00、无效，01、有效
     */
    @Size(min=0, max=2, message="是否可用00、无效，01、有效 字符长度必须小于等于2", groups = {PsiCarServiceMaterialFileEntityValidGroup.class, IsEnableValidGroup.class})
    @ApiModelProperty(value = "是否可用00、无效，01、有效")
    private String isEnable;
    
    /**
     * 是否已删除(00：未删除/01：已删除)
     */
    @NotNull(message = "是否已删除(00：未删除/01：已删除) 不能是Null", groups = {PsiCarServiceMaterialFileEntityValidGroup.class, IsDeleteValidGroup.class})
    @Size(min=0, max=2, message="是否已删除(00：未删除/01：已删除) 字符长度必须小于等于2", groups = {PsiCarServiceMaterialFileEntityValidGroup.class, IsDeleteValidGroup.class})
    @ApiModelProperty(value = "是否已删除(00：未删除/01：已删除)")
    private String isDelete;
    
    /**
     * 缩略图
     */
    @ApiModelProperty(value = "缩略图")
    private String thumbnail;
    
    public PsiCarServiceMaterialFileEntity() {
    }
    
    public PsiCarServiceMaterialFileEntity(Long materialFileId) {
        this.materialFileId = materialFileId;
    }

    public void setMaterialFileId(Long materialFileId) {
        this.materialFileId = materialFileId;
    }
    public Long getMaterialFileId() {
        return this.materialFileId;
    }
    

    public void setMaterialId(Long materialId) {
        this.materialId = materialId;
    }
    public Long getMaterialId() {
        return this.materialId;
    }
    
    public void setMaterialFileType(String materialFileType) {
        this.materialFileType = materialFileType;
    }
    public String getMaterialFileType() {
        return this.materialFileType;
    }
    
    public void setFileSort(Integer fileSort) {
        this.fileSort = fileSort;
    }
    public Integer getFileSort() {
        return this.fileSort;
    }
    
    public void setApprovalPeopleId(Long approvalPeopleId) {
        this.approvalPeopleId = approvalPeopleId;
    }
    public Long getApprovalPeopleId() {
        return this.approvalPeopleId;
    }
    
    public void setApprovalDate(Date approvalDate) {
        this.approvalDate = approvalDate;
    }
    public Date getApprovalDate() {
        return this.approvalDate;
    }
    
    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason;
    }
    public String getRejectReason() {
        return this.rejectReason;
    }
    
    public void setChineseDescription(String chineseDescription) {
        this.chineseDescription = chineseDescription;
    }
    public String getChineseDescription() {
        return this.chineseDescription;
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
    
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
    public String getThumbnail() {
        return this.thumbnail;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (materialFileId == null)
           
               ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
                materialFileId = RandomIDGennerator.get().generate();
    }

    public interface PsiCarServiceMaterialFileEntityValidGroup {}
    public interface MaterialFileIdValidGroup {}
    public interface MaterialIdValidGroup {}
    public interface MaterialFileTypeValidGroup {}
    public interface ApprovalPeopleIdValidGroup {}
    public interface RejectReasonValidGroup {}
    public interface ChineseDescriptionValidGroup {}
    public interface CreatedByValidGroup {}
    public interface CreatedDateValidGroup {}
    public interface UpdatedByValidGroup {}
    public interface UpdatedDateValidGroup {}
    public interface IsEnableValidGroup {}
    public interface IsDeleteValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            MaterialFileIdValidGroup.class
            , MaterialIdValidGroup.class
            , MaterialFileTypeValidGroup.class
            , ApprovalPeopleIdValidGroup.class
            , RejectReasonValidGroup.class
            , ChineseDescriptionValidGroup.class
            , CreatedByValidGroup.class
            , CreatedDateValidGroup.class
            , UpdatedByValidGroup.class
            , UpdatedDateValidGroup.class
            , IsEnableValidGroup.class
            , IsDeleteValidGroup.class
        };
    }
}
