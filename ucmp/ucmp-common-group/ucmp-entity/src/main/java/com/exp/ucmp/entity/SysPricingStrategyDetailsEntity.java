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

@ApiModel(value = "SysPricingStrategyDetailsEntity", description = "定价策略详情表(v2)")
@GroupSequence({SysPricingStrategyDetailsEntity.class, SysPricingStrategyDetailsEntity.SysPricingStrategyDetailsEntityValidGroup.class,SysPricingStrategyDetailsEntity.StrategyDetailsIdValidGroup.class,SysPricingStrategyDetailsEntity.StrategyIdValidGroup.class,SysPricingStrategyDetailsEntity.DetailsNameValidGroup.class,SysPricingStrategyDetailsEntity.DetailsTypeValidGroup.class,SysPricingStrategyDetailsEntity.DetailsValueValidGroup.class,SysPricingStrategyDetailsEntity.CreatedByValidGroup.class,SysPricingStrategyDetailsEntity.CreatedDateValidGroup.class,SysPricingStrategyDetailsEntity.UpdatedByValidGroup.class,SysPricingStrategyDetailsEntity.UpdatedDateValidGroup.class,SysPricingStrategyDetailsEntity.IsEnableValidGroup.class,SysPricingStrategyDetailsEntity.IsDeleteValidGroup.class}) 
public class SysPricingStrategyDetailsEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 策略详情id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "策略详情id 不能是Null", groups = {SysPricingStrategyDetailsEntityValidGroup.class, StrategyDetailsIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="策略详情id 数字精度必须符合(19,0)", groups = {SysPricingStrategyDetailsEntityValidGroup.class, StrategyDetailsIdValidGroup.class})
    @ApiModelProperty(value = "策略详情id")
    private Long strategyDetailsId;
    
    
    /**
     * 策略id
     */
    @NotNull(message = "策略id 不能是Null", groups = {SysPricingStrategyDetailsEntityValidGroup.class, StrategyIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="策略id 数字精度必须符合(19,0)", groups = {SysPricingStrategyDetailsEntityValidGroup.class, StrategyIdValidGroup.class})
    @ApiModelProperty(value = "策略id")
    private Long strategyId;
    
    /**
     * 详情名称
     */
    @NotNull(message = "详情名称 不能是Null", groups = {SysPricingStrategyDetailsEntityValidGroup.class, DetailsNameValidGroup.class})
    @Size(min=0, max=50, message="详情名称 字符长度必须小于等于50", groups = {SysPricingStrategyDetailsEntityValidGroup.class, DetailsNameValidGroup.class})
    @ApiModelProperty(value = "详情名称")
    private String detailsName;
    
    /**
     * 详情类型
     */
    @NotNull(message = "详情类型 不能是Null", groups = {SysPricingStrategyDetailsEntityValidGroup.class, DetailsTypeValidGroup.class})
    @Size(min=0, max=4, message="详情类型 字符长度必须小于等于4", groups = {SysPricingStrategyDetailsEntityValidGroup.class, DetailsTypeValidGroup.class})
    @ApiModelProperty(value = "详情类型")
    private String detailsType;
    
    /**
     * 详情值
     */
    @NotNull(message = "详情值 不能是Null", groups = {SysPricingStrategyDetailsEntityValidGroup.class, DetailsValueValidGroup.class})
    @Size(min=0, max=20, message="详情值 字符长度必须小于等于20", groups = {SysPricingStrategyDetailsEntityValidGroup.class, DetailsValueValidGroup.class})
    @ApiModelProperty(value = "详情值")
    private String detailsValue;
    
    /**
     * 创建人ID
     */
    @NotNull(message = "创建人ID 不能是Null", groups = {SysPricingStrategyDetailsEntityValidGroup.class, CreatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人ID 数字精度必须符合(19,0)", groups = {SysPricingStrategyDetailsEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人ID")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {SysPricingStrategyDetailsEntityValidGroup.class, CreatedDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 更新人ID
     */
    @NotNull(message = "更新人ID 不能是Null", groups = {SysPricingStrategyDetailsEntityValidGroup.class, UpdatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="更新人ID 数字精度必须符合(19,0)", groups = {SysPricingStrategyDetailsEntityValidGroup.class, UpdatedByValidGroup.class})
    @ApiModelProperty(value = "更新人ID")
    private Long updatedBy;
    
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "更新时间 不能是Null", groups = {SysPricingStrategyDetailsEntityValidGroup.class, UpdatedDateValidGroup.class})
    @ApiModelProperty(value = "更新时间")
    private Date updatedDate;
    
    /**
     * 是否可用00、无效，01、有效
     */
    @Size(min=0, max=2, message="是否可用00、无效，01、有效 字符长度必须小于等于2", groups = {SysPricingStrategyDetailsEntityValidGroup.class, IsEnableValidGroup.class})
    @ApiModelProperty(value = "是否可用00、无效，01、有效")
    private String isEnable;
    
    /**
     * 是否已删除(00：未删除/01：已删除)
     */
    @Size(min=0, max=2, message="是否已删除(00：未删除/01：已删除) 字符长度必须小于等于2", groups = {SysPricingStrategyDetailsEntityValidGroup.class, IsDeleteValidGroup.class})
    @ApiModelProperty(value = "是否已删除(00：未删除/01：已删除)")
    private String isDelete;
    
    public SysPricingStrategyDetailsEntity() {
    }
    
    public SysPricingStrategyDetailsEntity(Long strategyDetailsId) {
        this.strategyDetailsId = strategyDetailsId;
    }

    public void setStrategyDetailsId(Long strategyDetailsId) {
        this.strategyDetailsId = strategyDetailsId;
    }
    public Long getStrategyDetailsId() {
        return this.strategyDetailsId;
    }
    

    public void setStrategyId(Long strategyId) {
        this.strategyId = strategyId;
    }
    public Long getStrategyId() {
        return this.strategyId;
    }
    
    public void setDetailsName(String detailsName) {
        this.detailsName = detailsName;
    }
    public String getDetailsName() {
        return this.detailsName;
    }
    
    public void setDetailsType(String detailsType) {
        this.detailsType = detailsType;
    }
    public String getDetailsType() {
        return this.detailsType;
    }
    
    public void setDetailsValue(String detailsValue) {
        this.detailsValue = detailsValue;
    }
    public String getDetailsValue() {
        return this.detailsValue;
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
              (strategyDetailsId == null)
           
               ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
                strategyDetailsId = RandomIDGennerator.get().generate();
    }

    public interface SysPricingStrategyDetailsEntityValidGroup {}
    public interface StrategyDetailsIdValidGroup {}
    public interface StrategyIdValidGroup {}
    public interface DetailsNameValidGroup {}
    public interface DetailsTypeValidGroup {}
    public interface DetailsValueValidGroup {}
    public interface CreatedByValidGroup {}
    public interface CreatedDateValidGroup {}
    public interface UpdatedByValidGroup {}
    public interface UpdatedDateValidGroup {}
    public interface IsEnableValidGroup {}
    public interface IsDeleteValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            StrategyDetailsIdValidGroup.class
            , StrategyIdValidGroup.class
            , DetailsNameValidGroup.class
            , DetailsTypeValidGroup.class
            , DetailsValueValidGroup.class
            , CreatedByValidGroup.class
            , CreatedDateValidGroup.class
            , UpdatedByValidGroup.class
            , UpdatedDateValidGroup.class
            , IsEnableValidGroup.class
            , IsDeleteValidGroup.class
        };
    }
}
