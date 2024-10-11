/**
 * PsiCarSaleRecordEntity
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO EgridCloud, Inc, All rights reserved.
 */
package com.exp.ucmp.entity;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.math.BigDecimal;

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

@ApiModel(value = "PsiCarSaleRecordEntity", description = "车辆批售记录表(二期)")
@GroupSequence({PsiCarSaleRecordEntity.class, PsiCarSaleRecordEntity.PsiCarSaleRecordEntityValidGroup.class,PsiCarSaleRecordEntity.SaleRecordIdValidGroup.class,PsiCarSaleRecordEntity.StockIdValidGroup.class,PsiCarSaleRecordEntity.VinCodeValidGroup.class,PsiCarSaleRecordEntity.PartnerNameValidGroup.class,PsiCarSaleRecordEntity.DeliverDateValidGroup.class,PsiCarSaleRecordEntity.RemarkValidGroup.class,PsiCarSaleRecordEntity.WholesalePriceValidGroup.class,PsiCarSaleRecordEntity.WholesaleNoValidGroup.class,PsiCarSaleRecordEntity.CreatedByValidGroup.class,PsiCarSaleRecordEntity.CreatedDateValidGroup.class,PsiCarSaleRecordEntity.UpdatedByValidGroup.class,PsiCarSaleRecordEntity.UpdatedDateValidGroup.class,PsiCarSaleRecordEntity.IsEnableValidGroup.class,PsiCarSaleRecordEntity.IsDeleteValidGroup.class}) 
public class PsiCarSaleRecordEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 车辆批售记录id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "车辆批售记录id 不能是Null", groups = {PsiCarSaleRecordEntityValidGroup.class, SaleRecordIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="车辆批售记录id 数字精度必须符合(19,0)", groups = {PsiCarSaleRecordEntityValidGroup.class, SaleRecordIdValidGroup.class})
    @ApiModelProperty(value = "车辆批售记录id")
    private Long saleRecordId;
    
    
    /**
     * 库存车辆id
     */
    @NotNull(message = "库存车辆id 不能是Null", groups = {PsiCarSaleRecordEntityValidGroup.class, StockIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="库存车辆id 数字精度必须符合(19,0)", groups = {PsiCarSaleRecordEntityValidGroup.class, StockIdValidGroup.class})
    @ApiModelProperty(value = "库存车辆id")
    private Long stockId;
    
    /**
     * VIN码
     */
    @NotNull(message = "VIN码 不能是Null", groups = {PsiCarSaleRecordEntityValidGroup.class, VinCodeValidGroup.class})
    @Size(min=0, max=20, message="VIN码 字符长度必须小于等于20", groups = {PsiCarSaleRecordEntityValidGroup.class, VinCodeValidGroup.class})
    @ApiModelProperty(value = "VIN码")
    private String vinCode;
    
    /**
     * 合作方
     */
    @Size(min=0, max=50, message="合作方 字符长度必须小于等于50", groups = {PsiCarSaleRecordEntityValidGroup.class, PartnerNameValidGroup.class})
    @ApiModelProperty(value = "合作方")
    private String partnerName;
    
    /**
     * 交付日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "交付日期 不能是Null", groups = {PsiCarSaleRecordEntityValidGroup.class, DeliverDateValidGroup.class})
    @ApiModelProperty(value = "交付日期")
    private Date deliverDate;
    
    /**
     * 备注
     */
    @Size(min=0, max=400, message="备注 字符长度必须小于等于400", groups = {PsiCarSaleRecordEntityValidGroup.class, RemarkValidGroup.class})
    @ApiModelProperty(value = "备注")
    private String remark;
    
    /**
     * 批售价
     */
    @NotNull(message = "批售价 不能是Null", groups = {PsiCarSaleRecordEntityValidGroup.class, WholesalePriceValidGroup.class})
    @Digits(integer=9, fraction=2, message="批售价 数字精度必须符合(9,2)", groups = {PsiCarSaleRecordEntityValidGroup.class, WholesalePriceValidGroup.class})
    @ApiModelProperty(value = "批售价")
    private BigDecimal wholesalePrice;
    
    /**
     * 批售单号
     */
    @NotNull(message = "批售单号 不能是Null", groups = {PsiCarSaleRecordEntityValidGroup.class, WholesaleNoValidGroup.class})
    @Size(min=0, max=50, message="批售单号 字符长度必须小于等于50", groups = {PsiCarSaleRecordEntityValidGroup.class, WholesaleNoValidGroup.class})
    @ApiModelProperty(value = "批售单号")
    private String wholesaleNo;
    
    /**
     * 创建人ID
     */
    @NotNull(message = "创建人ID 不能是Null", groups = {PsiCarSaleRecordEntityValidGroup.class, CreatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人ID 数字精度必须符合(19,0)", groups = {PsiCarSaleRecordEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人ID")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {PsiCarSaleRecordEntityValidGroup.class, CreatedDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 更新人ID
     */
    @NotNull(message = "更新人ID 不能是Null", groups = {PsiCarSaleRecordEntityValidGroup.class, UpdatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="更新人ID 数字精度必须符合(19,0)", groups = {PsiCarSaleRecordEntityValidGroup.class, UpdatedByValidGroup.class})
    @ApiModelProperty(value = "更新人ID")
    private Long updatedBy;
    
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "更新时间 不能是Null", groups = {PsiCarSaleRecordEntityValidGroup.class, UpdatedDateValidGroup.class})
    @ApiModelProperty(value = "更新时间")
    private Date updatedDate;
    
    /**
     * 是否可用00、无效，01、有效
     */
    @Size(min=0, max=2, message="是否可用00、无效，01、有效 字符长度必须小于等于2", groups = {PsiCarSaleRecordEntityValidGroup.class, IsEnableValidGroup.class})
    @ApiModelProperty(value = "是否可用00、无效，01、有效")
    private String isEnable;
    
    /**
     * 是否已删除(00：未删除/01：已删除)
     */
    @NotNull(message = "是否已删除(00：未删除/01：已删除) 不能是Null", groups = {PsiCarSaleRecordEntityValidGroup.class, IsDeleteValidGroup.class})
    @Size(min=0, max=2, message="是否已删除(00：未删除/01：已删除) 字符长度必须小于等于2", groups = {PsiCarSaleRecordEntityValidGroup.class, IsDeleteValidGroup.class})
    @ApiModelProperty(value = "是否已删除(00：未删除/01：已删除)")
    private String isDelete;
    
    public PsiCarSaleRecordEntity() {
    }
    
    public PsiCarSaleRecordEntity(Long saleRecordId) {
        this.saleRecordId = saleRecordId;
    }

    public void setSaleRecordId(Long saleRecordId) {
        this.saleRecordId = saleRecordId;
    }
    public Long getSaleRecordId() {
        return this.saleRecordId;
    }
    

    public void setStockId(Long stockId) {
        this.stockId = stockId;
    }
    public Long getStockId() {
        return this.stockId;
    }
    
    public void setVinCode(String vinCode) {
        this.vinCode = vinCode;
    }
    public String getVinCode() {
        return this.vinCode;
    }
    
    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }
    public String getPartnerName() {
        return this.partnerName;
    }
    
    public void setDeliverDate(Date deliverDate) {
        this.deliverDate = deliverDate;
    }
    public Date getDeliverDate() {
        return this.deliverDate;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }
    public String getRemark() {
        return this.remark;
    }
    
    public void setWholesalePrice(BigDecimal wholesalePrice) {
        this.wholesalePrice = wholesalePrice;
    }
    public BigDecimal getWholesalePrice() {
        return this.wholesalePrice;
    }
    
    public void setWholesaleNo(String wholesaleNo) {
        this.wholesaleNo = wholesaleNo;
    }
    public String getWholesaleNo() {
        return this.wholesaleNo;
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
              (saleRecordId == null)
           
               ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
                saleRecordId = RandomIDGennerator.get().generate();
    }

    public interface PsiCarSaleRecordEntityValidGroup {}
    public interface SaleRecordIdValidGroup {}
    public interface StockIdValidGroup {}
    public interface VinCodeValidGroup {}
    public interface PartnerNameValidGroup {}
    public interface DeliverDateValidGroup {}
    public interface RemarkValidGroup {}
    public interface WholesalePriceValidGroup {}
    public interface WholesaleNoValidGroup {}
    public interface CreatedByValidGroup {}
    public interface CreatedDateValidGroup {}
    public interface UpdatedByValidGroup {}
    public interface UpdatedDateValidGroup {}
    public interface IsEnableValidGroup {}
    public interface IsDeleteValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            SaleRecordIdValidGroup.class
            , StockIdValidGroup.class
            , VinCodeValidGroup.class
            , PartnerNameValidGroup.class
            , DeliverDateValidGroup.class
            , RemarkValidGroup.class
            , WholesalePriceValidGroup.class
            , WholesaleNoValidGroup.class
            , CreatedByValidGroup.class
            , CreatedDateValidGroup.class
            , UpdatedByValidGroup.class
            , UpdatedDateValidGroup.class
            , IsEnableValidGroup.class
            , IsDeleteValidGroup.class
        };
    }
}
