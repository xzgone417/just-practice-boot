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

@ApiModel(value = "SysPricingRulesEntity", description = "定价信息表")
@GroupSequence({SysPricingRulesEntity.class, SysPricingRulesEntity.SysPricingRulesEntityValidGroup.class,SysPricingRulesEntity.RuleIdValidGroup.class,SysPricingRulesEntity.RuleNumberValidGroup.class,SysPricingRulesEntity.RuleNameValidGroup.class,SysPricingRulesEntity.RuleDescriptionValidGroup.class,SysPricingRulesEntity.StartTimeValidGroup.class,SysPricingRulesEntity.EndTimeValidGroup.class,SysPricingRulesEntity.CreatedByValidGroup.class,SysPricingRulesEntity.CreatedDateValidGroup.class,SysPricingRulesEntity.UpdatedByValidGroup.class,SysPricingRulesEntity.UpdatedDateValidGroup.class,SysPricingRulesEntity.IsEnableValidGroup.class,SysPricingRulesEntity.IsDeleteValidGroup.class}) 
public class SysPricingRulesEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 规则id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "规则id 不能是Null", groups = {SysPricingRulesEntityValidGroup.class, RuleIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="规则id 数字精度必须符合(19,0)", groups = {SysPricingRulesEntityValidGroup.class, RuleIdValidGroup.class})
    @ApiModelProperty(value = "规则id")
    private Long ruleId;
    
    
    /**
     * 规则编号
     */
    @NotNull(message = "规则编号 不能是Null", groups = {SysPricingRulesEntityValidGroup.class, RuleNumberValidGroup.class})
    @Size(min=0, max=20, message="规则编号 字符长度必须小于等于20", groups = {SysPricingRulesEntityValidGroup.class, RuleNumberValidGroup.class})
    @ApiModelProperty(value = "规则编号")
    private String ruleNumber;
    
    /**
     * 规则名称
     */
    @NotNull(message = "规则名称 不能是Null", groups = {SysPricingRulesEntityValidGroup.class, RuleNameValidGroup.class})
    @Size(min=0, max=10, message="规则名称 字符长度必须小于等于10", groups = {SysPricingRulesEntityValidGroup.class, RuleNameValidGroup.class})
    @ApiModelProperty(value = "规则名称")
    private String ruleName;
    
    /**
     * 规则描述
     */
    @Size(min=0, max=50, message="规则描述 字符长度必须小于等于50", groups = {SysPricingRulesEntityValidGroup.class, RuleDescriptionValidGroup.class})
    @ApiModelProperty(value = "规则描述")
    private String ruleDescription;
    
    /**
     * 生效开始时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "生效开始时间 不能是Null", groups = {SysPricingRulesEntityValidGroup.class, StartTimeValidGroup.class})
    @ApiModelProperty(value = "生效开始时间")
    private Date startTime;
    
    /**
     * 生效结束时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "生效结束时间 不能是Null", groups = {SysPricingRulesEntityValidGroup.class, EndTimeValidGroup.class})
    @ApiModelProperty(value = "生效结束时间")
    private Date endTime;
    
    /**
     * 创建人ID
     */
    @NotNull(message = "创建人ID 不能是Null", groups = {SysPricingRulesEntityValidGroup.class, CreatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人ID 数字精度必须符合(19,0)", groups = {SysPricingRulesEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人ID")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {SysPricingRulesEntityValidGroup.class, CreatedDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 更新人ID
     */
    @NotNull(message = "更新人ID 不能是Null", groups = {SysPricingRulesEntityValidGroup.class, UpdatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="更新人ID 数字精度必须符合(19,0)", groups = {SysPricingRulesEntityValidGroup.class, UpdatedByValidGroup.class})
    @ApiModelProperty(value = "更新人ID")
    private Long updatedBy;
    
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "更新时间 不能是Null", groups = {SysPricingRulesEntityValidGroup.class, UpdatedDateValidGroup.class})
    @ApiModelProperty(value = "更新时间")
    private Date updatedDate;
    
    /**
     * 是否可用00、无效，01、有效
     */
    @Size(min=0, max=2, message="是否可用00、无效，01、有效 字符长度必须小于等于2", groups = {SysPricingRulesEntityValidGroup.class, IsEnableValidGroup.class})
    @ApiModelProperty(value = "是否可用00、无效，01、有效")
    private String isEnable;
    
    /**
     * 是否已删除(00：未删除/01：已删除)
     */
    @Size(min=0, max=2, message="是否已删除(00：未删除/01：已删除) 字符长度必须小于等于2", groups = {SysPricingRulesEntityValidGroup.class, IsDeleteValidGroup.class})
    @ApiModelProperty(value = "是否已删除(00：未删除/01：已删除)")
    private String isDelete;
    
    public SysPricingRulesEntity() {
    }
    
    public SysPricingRulesEntity(Long ruleId) {
        this.ruleId = ruleId;
    }

    public void setRuleId(Long ruleId) {
        this.ruleId = ruleId;
    }
    public Long getRuleId() {
        return this.ruleId;
    }
    

    public void setRuleNumber(String ruleNumber) {
        this.ruleNumber = ruleNumber;
    }
    public String getRuleNumber() {
        return this.ruleNumber;
    }
    
    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }
    public String getRuleName() {
        return this.ruleName;
    }
    
    public void setRuleDescription(String ruleDescription) {
        this.ruleDescription = ruleDescription;
    }
    public String getRuleDescription() {
        return this.ruleDescription;
    }
    
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
    public Date getStartTime() {
        return this.startTime;
    }
    
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
    public Date getEndTime() {
        return this.endTime;
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
              (ruleId == null)
           
               ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
                ruleId = RandomIDGennerator.get().generate();
    }

    public interface SysPricingRulesEntityValidGroup {}
    public interface RuleIdValidGroup {}
    public interface RuleNumberValidGroup {}
    public interface RuleNameValidGroup {}
    public interface RuleDescriptionValidGroup {}
    public interface StartTimeValidGroup {}
    public interface EndTimeValidGroup {}
    public interface CreatedByValidGroup {}
    public interface CreatedDateValidGroup {}
    public interface UpdatedByValidGroup {}
    public interface UpdatedDateValidGroup {}
    public interface IsEnableValidGroup {}
    public interface IsDeleteValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            RuleIdValidGroup.class
            , RuleNumberValidGroup.class
            , RuleNameValidGroup.class
            , RuleDescriptionValidGroup.class
            , StartTimeValidGroup.class
            , EndTimeValidGroup.class
            , CreatedByValidGroup.class
            , CreatedDateValidGroup.class
            , UpdatedByValidGroup.class
            , UpdatedDateValidGroup.class
            , IsEnableValidGroup.class
            , IsDeleteValidGroup.class
        };
    }
}
