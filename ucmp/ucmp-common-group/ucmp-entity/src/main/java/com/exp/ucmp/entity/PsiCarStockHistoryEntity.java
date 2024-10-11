/**
 * PsiCarStockHistoryEntity
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

@ApiModel(value = "PsiCarStockHistoryEntity", description = "出入库历史表(二期)")
@GroupSequence({PsiCarStockHistoryEntity.class, PsiCarStockHistoryEntity.PsiCarStockHistoryEntityValidGroup.class,PsiCarStockHistoryEntity.HistoryIdValidGroup.class,PsiCarStockHistoryEntity.StockIdValidGroup.class,PsiCarStockHistoryEntity.StorageNameValidGroup.class,PsiCarStockHistoryEntity.StockTypeValidGroup.class,PsiCarStockHistoryEntity.CreateNameValidGroup.class,PsiCarStockHistoryEntity.CreatedByValidGroup.class,PsiCarStockHistoryEntity.UpdatedByValidGroup.class}) 
public class PsiCarStockHistoryEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 历史表id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "历史表id 不能是Null", groups = {PsiCarStockHistoryEntityValidGroup.class, HistoryIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="历史表id 数字精度必须符合(19,0)", groups = {PsiCarStockHistoryEntityValidGroup.class, HistoryIdValidGroup.class})
    @ApiModelProperty(value = "历史表id")
    private Long historyId;
    
    
    /**
     * 库存车辆id
     */
    @Digits(integer=19, fraction=0, message="库存车辆id 数字精度必须符合(19,0)", groups = {PsiCarStockHistoryEntityValidGroup.class, StockIdValidGroup.class})
    @ApiModelProperty(value = "库存车辆id")
    private Long stockId;
    
    /**
     * 仓储点名称
     */
    @Size(min=0, max=100, message="仓储点名称 字符长度必须小于等于100", groups = {PsiCarStockHistoryEntityValidGroup.class, StorageNameValidGroup.class})
    @ApiModelProperty(value = "仓储点名称")
    private String storageName;
    
    /**
     * 出入库类型
     */
    @Size(min=0, max=20, message="出入库类型 字符长度必须小于等于20", groups = {PsiCarStockHistoryEntityValidGroup.class, StockTypeValidGroup.class})
    @ApiModelProperty(value = "出入库类型")
    private String stockType;
    
    /**
     * 出入库日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "出入库日期")
    private Date stockDate;
    
    /**
     * 操作人名称
     */
    @Size(min=0, max=100, message="操作人名称 字符长度必须小于等于100", groups = {PsiCarStockHistoryEntityValidGroup.class, CreateNameValidGroup.class})
    @ApiModelProperty(value = "操作人名称")
    private String createName;
    
    /**
     * 创建人id
     */
    @Digits(integer=19, fraction=0, message="创建人id 数字精度必须符合(19,0)", groups = {PsiCarStockHistoryEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人id")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 更新人
     */
    @Digits(integer=19, fraction=0, message="更新人 数字精度必须符合(19,0)", groups = {PsiCarStockHistoryEntityValidGroup.class, UpdatedByValidGroup.class})
    @ApiModelProperty(value = "更新人")
    private Long updatedBy;
    
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间")
    private Date updatedDate;
    
    public PsiCarStockHistoryEntity() {
    }
    
    public PsiCarStockHistoryEntity(Long historyId) {
        this.historyId = historyId;
    }

    public void setHistoryId(Long historyId) {
        this.historyId = historyId;
    }
    public Long getHistoryId() {
        return this.historyId;
    }
    

    public void setStockId(Long stockId) {
        this.stockId = stockId;
    }
    public Long getStockId() {
        return this.stockId;
    }
    
    public void setStorageName(String storageName) {
        this.storageName = storageName;
    }
    public String getStorageName() {
        return this.storageName;
    }
    
    public void setStockType(String stockType) {
        this.stockType = stockType;
    }
    public String getStockType() {
        return this.stockType;
    }
    
    public void setStockDate(Date stockDate) {
        this.stockDate = stockDate;
    }
    public Date getStockDate() {
        return this.stockDate;
    }
    
    public void setCreateName(String createName) {
        this.createName = createName;
    }
    public String getCreateName() {
        return this.createName;
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
              (historyId == null)
           
               ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
                historyId = RandomIDGennerator.get().generate();
    }

    public interface PsiCarStockHistoryEntityValidGroup {}
    public interface HistoryIdValidGroup {}
    public interface StockIdValidGroup {}
    public interface StorageNameValidGroup {}
    public interface StockTypeValidGroup {}
    public interface CreateNameValidGroup {}
    public interface CreatedByValidGroup {}
    public interface UpdatedByValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            HistoryIdValidGroup.class
            , StockIdValidGroup.class
            , StorageNameValidGroup.class
            , StockTypeValidGroup.class
            , CreateNameValidGroup.class
            , CreatedByValidGroup.class
            , UpdatedByValidGroup.class
        };
    }
}
