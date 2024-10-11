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

@ApiModel(value = "PsiCarServiceMaterialEntity", description = "整备材料表(二期)")
@GroupSequence({PsiCarServiceMaterialEntity.class, PsiCarServiceMaterialEntity.PsiCarServiceMaterialEntityValidGroup.class,PsiCarServiceMaterialEntity.MaterialIdValidGroup.class,PsiCarServiceMaterialEntity.StockIdValidGroup.class,PsiCarServiceMaterialEntity.ServiceIdValidGroup.class,PsiCarServiceMaterialEntity.MaterialTypeValidGroup.class,PsiCarServiceMaterialEntity.CreatedByValidGroup.class,PsiCarServiceMaterialEntity.CreatedDateValidGroup.class,PsiCarServiceMaterialEntity.UpdatedByValidGroup.class,PsiCarServiceMaterialEntity.UpdatedDateValidGroup.class,PsiCarServiceMaterialEntity.IsEnableValidGroup.class,PsiCarServiceMaterialEntity.IsDeleteValidGroup.class}) 
public class PsiCarServiceMaterialEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 材料id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "材料id 不能是Null", groups = {PsiCarServiceMaterialEntityValidGroup.class, MaterialIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="材料id 数字精度必须符合(19,0)", groups = {PsiCarServiceMaterialEntityValidGroup.class, MaterialIdValidGroup.class})
    @ApiModelProperty(value = "材料id")
    private Long materialId;
    
    
    /**
     * 库存车辆ID
     */
    @Digits(integer=19, fraction=0, message="库存车辆ID 数字精度必须符合(19,0)", groups = {PsiCarServiceMaterialEntityValidGroup.class, StockIdValidGroup.class})
    @ApiModelProperty(value = "库存车辆ID")
    private Long stockId;
    
    /**
     * 整备ID
     */
    @Digits(integer=19, fraction=0, message="整备ID 数字精度必须符合(19,0)", groups = {PsiCarServiceMaterialEntityValidGroup.class, ServiceIdValidGroup.class})
    @ApiModelProperty(value = "整备ID")
    private Long serviceId;
    
    /**
     * 材料类型
     */
    @NotNull(message = "材料类型 不能是Null", groups = {PsiCarServiceMaterialEntityValidGroup.class, MaterialTypeValidGroup.class})
    @Size(min=0, max=10, message="材料类型 字符长度必须小于等于10", groups = {PsiCarServiceMaterialEntityValidGroup.class, MaterialTypeValidGroup.class})
    @ApiModelProperty(value = "材料类型")
    private String materialType;
    
    /**
     * 创建人ID
     */
    @NotNull(message = "创建人ID 不能是Null", groups = {PsiCarServiceMaterialEntityValidGroup.class, CreatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人ID 数字精度必须符合(19,0)", groups = {PsiCarServiceMaterialEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人ID")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {PsiCarServiceMaterialEntityValidGroup.class, CreatedDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 更新人ID
     */
    @NotNull(message = "更新人ID 不能是Null", groups = {PsiCarServiceMaterialEntityValidGroup.class, UpdatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="更新人ID 数字精度必须符合(19,0)", groups = {PsiCarServiceMaterialEntityValidGroup.class, UpdatedByValidGroup.class})
    @ApiModelProperty(value = "更新人ID")
    private Long updatedBy;
    
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "更新时间 不能是Null", groups = {PsiCarServiceMaterialEntityValidGroup.class, UpdatedDateValidGroup.class})
    @ApiModelProperty(value = "更新时间")
    private Date updatedDate;
    
    /**
     * 是否可用00、无效，01、有效
     */
    @Size(min=0, max=2, message="是否可用00、无效，01、有效 字符长度必须小于等于2", groups = {PsiCarServiceMaterialEntityValidGroup.class, IsEnableValidGroup.class})
    @ApiModelProperty(value = "是否可用00、无效，01、有效")
    private String isEnable;
    
    /**
     * 是否已删除(00：未删除/01：已删除)
     */
    @NotNull(message = "是否已删除(00：未删除/01：已删除) 不能是Null", groups = {PsiCarServiceMaterialEntityValidGroup.class, IsDeleteValidGroup.class})
    @Size(min=0, max=2, message="是否已删除(00：未删除/01：已删除) 字符长度必须小于等于2", groups = {PsiCarServiceMaterialEntityValidGroup.class, IsDeleteValidGroup.class})
    @ApiModelProperty(value = "是否已删除(00：未删除/01：已删除)")
    private String isDelete;
    
    public PsiCarServiceMaterialEntity() {
    }
    
    public PsiCarServiceMaterialEntity(Long materialId) {
        this.materialId = materialId;
    }

    public void setMaterialId(Long materialId) {
        this.materialId = materialId;
    }
    public Long getMaterialId() {
        return this.materialId;
    }
    

    public void setStockId(Long stockId) {
        this.stockId = stockId;
    }
    public Long getStockId() {
        return this.stockId;
    }
    
    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }
    public Long getServiceId() {
        return this.serviceId;
    }
    
    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }
    public String getMaterialType() {
        return this.materialType;
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
              (materialId == null)
           
               ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
                materialId = RandomIDGennerator.get().generate();
    }

    public interface PsiCarServiceMaterialEntityValidGroup {}
    public interface MaterialIdValidGroup {}
    public interface StockIdValidGroup {}
    public interface ServiceIdValidGroup {}
    public interface MaterialTypeValidGroup {}
    public interface CreatedByValidGroup {}
    public interface CreatedDateValidGroup {}
    public interface UpdatedByValidGroup {}
    public interface UpdatedDateValidGroup {}
    public interface IsEnableValidGroup {}
    public interface IsDeleteValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            PsiCarServiceMaterialEntity.MaterialIdValidGroup.class
            , PsiCarServiceMaterialEntity.StockIdValidGroup.class
            , PsiCarServiceMaterialEntity.ServiceIdValidGroup.class
            , PsiCarServiceMaterialEntity.MaterialTypeValidGroup.class
            , PsiCarServiceMaterialEntity.CreatedByValidGroup.class
            , PsiCarServiceMaterialEntity.CreatedDateValidGroup.class
            , PsiCarServiceMaterialEntity.UpdatedByValidGroup.class
            , PsiCarServiceMaterialEntity.UpdatedDateValidGroup.class
            , PsiCarServiceMaterialEntity.IsEnableValidGroup.class
            , PsiCarServiceMaterialEntity.IsDeleteValidGroup.class
        };
    }
}
