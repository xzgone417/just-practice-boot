/**
 * PsiCarSaleRecordFileEntity
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
import javax.validation.GroupSequence;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import com.egrid.core.base.entity.AbstractBaseEntity;
import com.egrid.core.base.id.RandomIDGennerator;

@ApiModel(value = "PsiCarSaleRecordFileEntity", description = "批售记录文件表")
@GroupSequence({PsiCarSaleRecordFileEntity.class, PsiCarSaleRecordFileEntity.PsiCarSaleRecordFileEntityValidGroup.class,PsiCarSaleRecordFileEntity.RecordFileIdValidGroup.class,PsiCarSaleRecordFileEntity.SaleRecordIdValidGroup.class,PsiCarSaleRecordFileEntity.FileIdValidGroup.class,PsiCarSaleRecordFileEntity.FileOrderValidGroup.class,PsiCarSaleRecordFileEntity.CreatedByValidGroup.class,PsiCarSaleRecordFileEntity.CreatedDateValidGroup.class,PsiCarSaleRecordFileEntity.UpdatedByValidGroup.class,PsiCarSaleRecordFileEntity.UpdatedDateValidGroup.class,PsiCarSaleRecordFileEntity.ThumbnailValidGroup.class}) 
public class PsiCarSaleRecordFileEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 业务主键
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "业务主键 不能是Null", groups = {PsiCarSaleRecordFileEntityValidGroup.class, RecordFileIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="业务主键 数字精度必须符合(19,0)", groups = {PsiCarSaleRecordFileEntityValidGroup.class, RecordFileIdValidGroup.class})
    @ApiModelProperty(value = "业务主键")
    private Long recordFileId;
    
    
    /**
     * 车辆批售记录id
     */
    @NotNull(message = "车辆批售记录id 不能是Null", groups = {PsiCarSaleRecordFileEntityValidGroup.class, SaleRecordIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="车辆批售记录id 数字精度必须符合(19,0)", groups = {PsiCarSaleRecordFileEntityValidGroup.class, SaleRecordIdValidGroup.class})
    @ApiModelProperty(value = "车辆批售记录id")
    private Long saleRecordId;
    
    /**
     * 文件id
     */
    @NotNull(message = "文件id 不能是Null", groups = {PsiCarSaleRecordFileEntityValidGroup.class, FileIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="文件id 数字精度必须符合(19,0)", groups = {PsiCarSaleRecordFileEntityValidGroup.class, FileIdValidGroup.class})
    @ApiModelProperty(value = "文件id")
    private Long fileId;
    
    /**
     * 排序
     */
    @NotNull(message = "排序 不能是Null", groups = {PsiCarSaleRecordFileEntityValidGroup.class, FileOrderValidGroup.class})
    @Digits(integer=10, fraction=0, message="排序 数字精度必须符合(10,0)", groups = {PsiCarSaleRecordFileEntityValidGroup.class, FileOrderValidGroup.class})
    @ApiModelProperty(value = "排序")
    private Integer fileOrder;
    
    /**
     * 创建人ID
     */
    @NotNull(message = "创建人ID 不能是Null", groups = {PsiCarSaleRecordFileEntityValidGroup.class, CreatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人ID 数字精度必须符合(19,0)", groups = {PsiCarSaleRecordFileEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人ID")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {PsiCarSaleRecordFileEntityValidGroup.class, CreatedDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 更新人ID
     */
    @NotNull(message = "更新人ID 不能是Null", groups = {PsiCarSaleRecordFileEntityValidGroup.class, UpdatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="更新人ID 数字精度必须符合(19,0)", groups = {PsiCarSaleRecordFileEntityValidGroup.class, UpdatedByValidGroup.class})
    @ApiModelProperty(value = "更新人ID")
    private Long updatedBy;
    
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "更新时间 不能是Null", groups = {PsiCarSaleRecordFileEntityValidGroup.class, UpdatedDateValidGroup.class})
    @ApiModelProperty(value = "更新时间")
    private Date updatedDate;
    
    /**
     * 缩略图
     */
    @NotNull(message = "缩略图 不能是Null", groups = {PsiCarSaleRecordFileEntityValidGroup.class, ThumbnailValidGroup.class})
    @ApiModelProperty(value = "缩略图")
    private String thumbnail;
    
    public PsiCarSaleRecordFileEntity() {
    }
    
    public PsiCarSaleRecordFileEntity(Long recordFileId) {
        this.recordFileId = recordFileId;
    }

    public void setRecordFileId(Long recordFileId) {
        this.recordFileId = recordFileId;
    }
    public Long getRecordFileId() {
        return this.recordFileId;
    }
    

    public void setSaleRecordId(Long saleRecordId) {
        this.saleRecordId = saleRecordId;
    }
    public Long getSaleRecordId() {
        return this.saleRecordId;
    }
    
    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }
    public Long getFileId() {
        return this.fileId;
    }
    
    public void setFileOrder(Integer fileOrder) {
        this.fileOrder = fileOrder;
    }
    public Integer getFileOrder() {
        return this.fileOrder;
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
              (recordFileId == null)
           
               ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
                recordFileId = RandomIDGennerator.get().generate();
    }

    public interface PsiCarSaleRecordFileEntityValidGroup {}
    public interface RecordFileIdValidGroup {}
    public interface SaleRecordIdValidGroup {}
    public interface FileIdValidGroup {}
    public interface FileOrderValidGroup {}
    public interface CreatedByValidGroup {}
    public interface CreatedDateValidGroup {}
    public interface UpdatedByValidGroup {}
    public interface UpdatedDateValidGroup {}
    public interface ThumbnailValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            RecordFileIdValidGroup.class
            , SaleRecordIdValidGroup.class
            , FileIdValidGroup.class
            , FileOrderValidGroup.class
            , CreatedByValidGroup.class
            , CreatedDateValidGroup.class
            , UpdatedByValidGroup.class
            , UpdatedDateValidGroup.class
            , ThumbnailValidGroup.class
        };
    }
}
