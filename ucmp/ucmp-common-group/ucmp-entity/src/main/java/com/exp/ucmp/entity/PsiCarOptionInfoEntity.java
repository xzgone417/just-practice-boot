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

@ApiModel(value = "PsiCarOptionInfoEntity", description = "车辆选装件表")
@GroupSequence({PsiCarOptionInfoEntity.class, PsiCarOptionInfoEntity.PsiCarOptionInfoEntityValidGroup.class,PsiCarOptionInfoEntity.OptionIdValidGroup.class,PsiCarOptionInfoEntity.StockIdValidGroup.class,PsiCarOptionInfoEntity.OptionCodeValidGroup.class,PsiCarOptionInfoEntity.OptionNameValidGroup.class,PsiCarOptionInfoEntity.CreatedByValidGroup.class,PsiCarOptionInfoEntity.CreatedDateValidGroup.class,PsiCarOptionInfoEntity.UpdatedByValidGroup.class,PsiCarOptionInfoEntity.UpdatedDateValidGroup.class}) 
public class PsiCarOptionInfoEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 选装id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "选装id 不能是Null", groups = {PsiCarOptionInfoEntityValidGroup.class, OptionIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="选装id 数字精度必须符合(19,0)", groups = {PsiCarOptionInfoEntityValidGroup.class, OptionIdValidGroup.class})
    @ApiModelProperty(value = "选装id")
    private Long optionId;
    
    
    /**
     * 车辆id
     */
    @Digits(integer=19, fraction=0, message="车辆id 数字精度必须符合(19,0)", groups = {PsiCarOptionInfoEntityValidGroup.class, StockIdValidGroup.class})
    @ApiModelProperty(value = "车辆id")
    private Long stockId;
    
    /**
     * 选装编码
     */
    @Size(min=0, max=255, message="选装编码 字符长度必须小于等于255", groups = {PsiCarOptionInfoEntityValidGroup.class, OptionCodeValidGroup.class})
    @ApiModelProperty(value = "选装编码")
    private String optionCode;
    
    /**
     * 选装名称
     */
    @Size(min=0, max=255, message="选装名称 字符长度必须小于等于255", groups = {PsiCarOptionInfoEntityValidGroup.class, OptionNameValidGroup.class})
    @ApiModelProperty(value = "选装名称")
    private String optionName;
    
    /**
     * 创建人ID
     */
    @NotNull(message = "创建人ID 不能是Null", groups = {PsiCarOptionInfoEntityValidGroup.class, CreatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人ID 数字精度必须符合(19,0)", groups = {PsiCarOptionInfoEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人ID")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {PsiCarOptionInfoEntityValidGroup.class, CreatedDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 更新人ID
     */
    @NotNull(message = "更新人ID 不能是Null", groups = {PsiCarOptionInfoEntityValidGroup.class, UpdatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="更新人ID 数字精度必须符合(19,0)", groups = {PsiCarOptionInfoEntityValidGroup.class, UpdatedByValidGroup.class})
    @ApiModelProperty(value = "更新人ID")
    private Long updatedBy;
    
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "更新时间 不能是Null", groups = {PsiCarOptionInfoEntityValidGroup.class, UpdatedDateValidGroup.class})
    @ApiModelProperty(value = "更新时间")
    private Date updatedDate;
    
    public PsiCarOptionInfoEntity() {
    }
    
    public PsiCarOptionInfoEntity(Long optionId) {
        this.optionId = optionId;
    }

    public void setOptionId(Long optionId) {
        this.optionId = optionId;
    }
    public Long getOptionId() {
        return this.optionId;
    }
    

    public void setStockId(Long stockId) {
        this.stockId = stockId;
    }
    public Long getStockId() {
        return this.stockId;
    }
    
    public void setOptionCode(String optionCode) {
        this.optionCode = optionCode;
    }
    public String getOptionCode() {
        return this.optionCode;
    }
    
    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }
    public String getOptionName() {
        return this.optionName;
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
              (optionId == null)
           
               ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
                optionId = RandomIDGennerator.get().generate();
    }

    public interface PsiCarOptionInfoEntityValidGroup {}
    public interface OptionIdValidGroup {}
    public interface StockIdValidGroup {}
    public interface OptionCodeValidGroup {}
    public interface OptionNameValidGroup {}
    public interface CreatedByValidGroup {}
    public interface CreatedDateValidGroup {}
    public interface UpdatedByValidGroup {}
    public interface UpdatedDateValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            PsiCarOptionInfoEntity.OptionIdValidGroup.class
            , PsiCarOptionInfoEntity.StockIdValidGroup.class
            , PsiCarOptionInfoEntity.OptionCodeValidGroup.class
            , PsiCarOptionInfoEntity.OptionNameValidGroup.class
            , PsiCarOptionInfoEntity.CreatedByValidGroup.class
            , PsiCarOptionInfoEntity.CreatedDateValidGroup.class
            , PsiCarOptionInfoEntity.UpdatedByValidGroup.class
            , PsiCarOptionInfoEntity.UpdatedDateValidGroup.class
        };
    }
}
