/**
 * OperationInfoEntity.java
 * Created at 2018年09月29日
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

/**
 * ClassName: OperationInfoEntity
 * Description: TODO
 * @author TODO
 * @date 2018年09月29日
 * @since 1.0
 */
@ApiModel(value = "OperationInfoEntity", description = "操作信息")
@GroupSequence({OperationInfoEntity.class, OperationInfoEntity.OperationInfoEntityValidGroup.class,OperationInfoEntity.OperationIdValidGroup.class,OperationInfoEntity.OperationNameValidGroup.class,OperationInfoEntity.OperationDescValidGroup.class,OperationInfoEntity.CreatedByValidGroup.class,OperationInfoEntity.CreatedDateValidGroup.class,OperationInfoEntity.UpdatedByValidGroup.class,OperationInfoEntity.UpdatedDateValidGroup.class}) 
public class OperationInfoEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 操作标识
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "操作标识 不能是Null", groups = {OperationInfoEntityValidGroup.class, OperationIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="操作标识 数字精度必须符合(19,0)", groups = {OperationInfoEntityValidGroup.class, OperationIdValidGroup.class})
    @ApiModelProperty(value = "操作标识")
    private Long operationId;
    
    
    /**
     * 操作名
     */
    @NotNull(message = "操作名 不能是Null", groups = {OperationInfoEntityValidGroup.class, OperationNameValidGroup.class})
    @Size(min=0, max=10, message="操作名 字符长度必须小于等于10", groups = {OperationInfoEntityValidGroup.class, OperationNameValidGroup.class})
    @ApiModelProperty(value = "操作名")
    private String operationName;
    
    /**
     * 操作描述
     */
    @Size(min=0, max=45, message="操作描述 字符长度必须小于等于45", groups = {OperationInfoEntityValidGroup.class, OperationDescValidGroup.class})
    @ApiModelProperty(value = "操作描述")
    private String operationDesc;
    
    /**
     * 创建人ID
     */
    @NotNull(message = "创建人ID 不能是Null", groups = {OperationInfoEntityValidGroup.class, CreatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人ID 数字精度必须符合(19,0)", groups = {OperationInfoEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人ID")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {OperationInfoEntityValidGroup.class, CreatedDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 更新人ID
     */
    @NotNull(message = "更新人ID 不能是Null", groups = {OperationInfoEntityValidGroup.class, UpdatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="更新人ID 数字精度必须符合(19,0)", groups = {OperationInfoEntityValidGroup.class, UpdatedByValidGroup.class})
    @ApiModelProperty(value = "更新人ID")
    private Long updatedBy;
    
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "更新时间 不能是Null", groups = {OperationInfoEntityValidGroup.class, UpdatedDateValidGroup.class})
    @ApiModelProperty(value = "更新时间")
    private Date updatedDate;
    
    public OperationInfoEntity() {
    }
    
    public OperationInfoEntity(Long operationId) {
        this.operationId = operationId;
    }

    public void setOperationId(Long operationId) {
        this.operationId = operationId;
    }
    public Long getOperationId() {
        return this.operationId;
    }
    

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }
    public String getOperationName() {
        return this.operationName;
    }
    
    public void setOperationDesc(String operationDesc) {
        this.operationDesc = operationDesc;
    }
    public String getOperationDesc() {
        return this.operationDesc;
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
              (operationId == null)
           
               ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
                operationId = RandomIDGennerator.get().generate();
    }

    public interface OperationInfoEntityValidGroup {}
    public interface OperationIdValidGroup {}
    public interface OperationNameValidGroup {}
    public interface OperationDescValidGroup {}
    public interface CreatedByValidGroup {}
    public interface CreatedDateValidGroup {}
    public interface UpdatedByValidGroup {}
    public interface UpdatedDateValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            OperationInfoEntity.OperationIdValidGroup.class
            , OperationInfoEntity.OperationNameValidGroup.class
            , OperationInfoEntity.OperationDescValidGroup.class
            , OperationInfoEntity.CreatedByValidGroup.class
            , OperationInfoEntity.CreatedDateValidGroup.class
            , OperationInfoEntity.UpdatedByValidGroup.class
            , OperationInfoEntity.UpdatedDateValidGroup.class
        };
    }
}
