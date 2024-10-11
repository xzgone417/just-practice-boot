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

@ApiModel(value = "SysPricingStrategyEntity", description = "定价策略表(v2)")
@GroupSequence({SysPricingStrategyEntity.class, SysPricingStrategyEntity.SysPricingStrategyEntityValidGroup.class,SysPricingStrategyEntity.StrategyIdValidGroup.class,SysPricingStrategyEntity.RuleIdValidGroup.class,SysPricingStrategyEntity.StrategyNameValidGroup.class,SysPricingStrategyEntity.StrategyTypeValidGroup.class,SysPricingStrategyEntity.StrategyNoValidGroup.class,SysPricingStrategyEntity.ValueTypeValidGroup.class,SysPricingStrategyEntity.CreatedByValidGroup.class,SysPricingStrategyEntity.CreatedDateValidGroup.class,SysPricingStrategyEntity.UpdatedByValidGroup.class,SysPricingStrategyEntity.UpdatedDateValidGroup.class,SysPricingStrategyEntity.IsEnableValidGroup.class,SysPricingStrategyEntity.IsDeleteValidGroup.class}) 
public class SysPricingStrategyEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 策略id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "策略id 不能是Null", groups = {SysPricingStrategyEntityValidGroup.class, StrategyIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="策略id 数字精度必须符合(19,0)", groups = {SysPricingStrategyEntityValidGroup.class, StrategyIdValidGroup.class})
    @ApiModelProperty(value = "策略id")
    private Long strategyId;
    
    
    /**
     * 规则id
     */
    @NotNull(message = "规则id 不能是Null", groups = {SysPricingStrategyEntityValidGroup.class, RuleIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="规则id 数字精度必须符合(19,0)", groups = {SysPricingStrategyEntityValidGroup.class, RuleIdValidGroup.class})
    @ApiModelProperty(value = "规则id")
    private Long ruleId;
    
    /**
     * 策略名称
     */
    @NotNull(message = "策略名称 不能是Null", groups = {SysPricingStrategyEntityValidGroup.class, StrategyNameValidGroup.class})
    @Size(min=0, max=10, message="策略名称 字符长度必须小于等于10", groups = {SysPricingStrategyEntityValidGroup.class, StrategyNameValidGroup.class})
    @ApiModelProperty(value = "策略名称")
    private String strategyName;
    
    /**
     * 策略类型01里程折旧02使用月份03适用类型04维修折扣05过户次数06生产年份
     */
    @NotNull(message = "策略类型01里程折旧02使用月份03适用类型04维修折扣05过户次数06生产年份 不能是Null", groups = {SysPricingStrategyEntityValidGroup.class, StrategyTypeValidGroup.class})
    @Size(min=0, max=4, message="策略类型01里程折旧02使用月份03适用类型04维修折扣05过户次数06生产年份 字符长度必须小于等于4", groups = {SysPricingStrategyEntityValidGroup.class, StrategyTypeValidGroup.class})
    @ApiModelProperty(value = "策略类型01里程折旧02使用月份03适用类型04维修折扣05过户次数06生产年份")
    private String strategyType;
    
    /**
     * 策略编号
     */
    @NotNull(message = "策略编号 不能是Null", groups = {SysPricingStrategyEntityValidGroup.class, StrategyNoValidGroup.class})
    @Size(min=0, max=20, message="策略编号 字符长度必须小于等于20", groups = {SysPricingStrategyEntityValidGroup.class, StrategyNoValidGroup.class})
    @ApiModelProperty(value = "策略编号")
    private String strategyNo;
    
    /**
     * 策略类型00定值01区间
     */
    @NotNull(message = "策略类型00定值01区间 不能是Null", groups = {SysPricingStrategyEntityValidGroup.class, ValueTypeValidGroup.class})
    @Size(min=0, max=2, message="策略类型00定值01区间 字符长度必须小于等于2", groups = {SysPricingStrategyEntityValidGroup.class, ValueTypeValidGroup.class})
    @ApiModelProperty(value = "策略类型00定值01区间")
    private String valueType;
    
    /**
     * 创建人ID
     */
    @NotNull(message = "创建人ID 不能是Null", groups = {SysPricingStrategyEntityValidGroup.class, CreatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人ID 数字精度必须符合(19,0)", groups = {SysPricingStrategyEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人ID")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {SysPricingStrategyEntityValidGroup.class, CreatedDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 更新人ID
     */
    @NotNull(message = "更新人ID 不能是Null", groups = {SysPricingStrategyEntityValidGroup.class, UpdatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="更新人ID 数字精度必须符合(19,0)", groups = {SysPricingStrategyEntityValidGroup.class, UpdatedByValidGroup.class})
    @ApiModelProperty(value = "更新人ID")
    private Long updatedBy;
    
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "更新时间 不能是Null", groups = {SysPricingStrategyEntityValidGroup.class, UpdatedDateValidGroup.class})
    @ApiModelProperty(value = "更新时间")
    private Date updatedDate;
    
    /**
     * 是否可用00、无效，01、有效
     */
    @Size(min=0, max=2, message="是否可用00、无效，01、有效 字符长度必须小于等于2", groups = {SysPricingStrategyEntityValidGroup.class, IsEnableValidGroup.class})
    @ApiModelProperty(value = "是否可用00、无效，01、有效")
    private String isEnable;
    
    /**
     * 是否已删除(00：未删除/01：已删除)
     */
    @Size(min=0, max=2, message="是否已删除(00：未删除/01：已删除) 字符长度必须小于等于2", groups = {SysPricingStrategyEntityValidGroup.class, IsDeleteValidGroup.class})
    @ApiModelProperty(value = "是否已删除(00：未删除/01：已删除)")
    private String isDelete;
    
    public SysPricingStrategyEntity() {
    }
    
    public SysPricingStrategyEntity(Long strategyId) {
        this.strategyId = strategyId;
    }

    public void setStrategyId(Long strategyId) {
        this.strategyId = strategyId;
    }
    public Long getStrategyId() {
        return this.strategyId;
    }
    

    public void setRuleId(Long ruleId) {
        this.ruleId = ruleId;
    }
    public Long getRuleId() {
        return this.ruleId;
    }
    
    public void setStrategyName(String strategyName) {
        this.strategyName = strategyName;
    }
    public String getStrategyName() {
        return this.strategyName;
    }
    
    public void setStrategyType(String strategyType) {
        this.strategyType = strategyType;
    }
    public String getStrategyType() {
        return this.strategyType;
    }
    
    public void setStrategyNo(String strategyNo) {
        this.strategyNo = strategyNo;
    }
    public String getStrategyNo() {
        return this.strategyNo;
    }
    
    public void setValueType(String valueType) {
        this.valueType = valueType;
    }
    public String getValueType() {
        return this.valueType;
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
              (strategyId == null)
           
               ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
                strategyId = RandomIDGennerator.get().generate();
    }

    public interface SysPricingStrategyEntityValidGroup {}
    public interface StrategyIdValidGroup {}
    public interface RuleIdValidGroup {}
    public interface StrategyNameValidGroup {}
    public interface StrategyTypeValidGroup {}
    public interface StrategyNoValidGroup {}
    public interface ValueTypeValidGroup {}
    public interface CreatedByValidGroup {}
    public interface CreatedDateValidGroup {}
    public interface UpdatedByValidGroup {}
    public interface UpdatedDateValidGroup {}
    public interface IsEnableValidGroup {}
    public interface IsDeleteValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            StrategyIdValidGroup.class
            , RuleIdValidGroup.class
            , StrategyNameValidGroup.class
            , StrategyTypeValidGroup.class
            , StrategyNoValidGroup.class
            , ValueTypeValidGroup.class
            , CreatedByValidGroup.class
            , CreatedDateValidGroup.class
            , UpdatedByValidGroup.class
            , UpdatedDateValidGroup.class
            , IsEnableValidGroup.class
            , IsDeleteValidGroup.class
        };
    }
}
