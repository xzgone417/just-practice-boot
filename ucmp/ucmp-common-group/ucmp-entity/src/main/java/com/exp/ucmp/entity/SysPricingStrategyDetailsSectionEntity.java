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

@ApiModel(value = "SysPricingStrategyDetailsSectionEntity", description = "定价策略详情区间表(v2)")
@GroupSequence({SysPricingStrategyDetailsSectionEntity.class, SysPricingStrategyDetailsSectionEntity.SysPricingStrategyDetailsSectionEntityValidGroup.class,SysPricingStrategyDetailsSectionEntity.StrategyDetailsIdValidGroup.class,SysPricingStrategyDetailsSectionEntity.StrategyIdValidGroup.class,SysPricingStrategyDetailsSectionEntity.DetailsTypeValidGroup.class,SysPricingStrategyDetailsSectionEntity.LeftValueValidGroup.class,SysPricingStrategyDetailsSectionEntity.RightValueValidGroup.class,SysPricingStrategyDetailsSectionEntity.DetailsValueValidGroup.class,SysPricingStrategyDetailsSectionEntity.IsSourceValidGroup.class,SysPricingStrategyDetailsSectionEntity.CreatedByValidGroup.class,SysPricingStrategyDetailsSectionEntity.CreatedDateValidGroup.class,SysPricingStrategyDetailsSectionEntity.UpdatedByValidGroup.class,SysPricingStrategyDetailsSectionEntity.UpdatedDateValidGroup.class,SysPricingStrategyDetailsSectionEntity.IsEnableValidGroup.class,SysPricingStrategyDetailsSectionEntity.IsDeleteValidGroup.class}) 
public class SysPricingStrategyDetailsSectionEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 策略详情id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "策略详情id 不能是Null", groups = {SysPricingStrategyDetailsSectionEntityValidGroup.class, StrategyDetailsIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="策略详情id 数字精度必须符合(19,0)", groups = {SysPricingStrategyDetailsSectionEntityValidGroup.class, StrategyDetailsIdValidGroup.class})
    @ApiModelProperty(value = "策略详情id")
    private Long strategyDetailsId;
    
    
    /**
     * 策略id
     */
    @NotNull(message = "策略id 不能是Null", groups = {SysPricingStrategyDetailsSectionEntityValidGroup.class, StrategyIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="策略id 数字精度必须符合(19,0)", groups = {SysPricingStrategyDetailsSectionEntityValidGroup.class, StrategyIdValidGroup.class})
    @ApiModelProperty(value = "策略id")
    private Long strategyId;
    
    /**
     * 详情类型00公里数（公里）、01使用月份
     */
    @NotNull(message = "详情类型00公里数（公里）、01使用月份 不能是Null", groups = {SysPricingStrategyDetailsSectionEntityValidGroup.class, DetailsTypeValidGroup.class})
    @Size(min=0, max=4, message="详情类型00公里数（公里）、01使用月份 字符长度必须小于等于4", groups = {SysPricingStrategyDetailsSectionEntityValidGroup.class, DetailsTypeValidGroup.class})
    @ApiModelProperty(value = "详情类型00公里数（公里）、01使用月份")
    private String detailsType;
    
    /**
     * 左
     */
    @NotNull(message = "左 不能是Null", groups = {SysPricingStrategyDetailsSectionEntityValidGroup.class, LeftValueValidGroup.class})
    @Digits(integer=10, fraction=0, message="左 数字精度必须符合(10,0)", groups = {SysPricingStrategyDetailsSectionEntityValidGroup.class, LeftValueValidGroup.class})
    @ApiModelProperty(value = "左")
    private Integer leftValue;
    
    /**
     * 右
     */
    @NotNull(message = "右 不能是Null", groups = {SysPricingStrategyDetailsSectionEntityValidGroup.class, RightValueValidGroup.class})
    @Digits(integer=10, fraction=0, message="右 数字精度必须符合(10,0)", groups = {SysPricingStrategyDetailsSectionEntityValidGroup.class, RightValueValidGroup.class})
    @ApiModelProperty(value = "右")
    private Integer rightValue;
    
    /**
     * 详情值
     */
    @Size(min=0, max=10, message="详情值 字符长度必须小于等于10", groups = {SysPricingStrategyDetailsSectionEntityValidGroup.class, DetailsValueValidGroup.class})
    @ApiModelProperty(value = "详情值")
    private String detailsValue;
    
    /**
     * 是否是源字段(0源数据,只能修改折扣比例,1手动增加)
     */
    @NotNull(message = "是否是源字段(0源数据,只能修改折扣比例,1手动增加) 不能是Null", groups = {SysPricingStrategyDetailsSectionEntityValidGroup.class, IsSourceValidGroup.class})
    @Digits(integer=10, fraction=0, message="是否是源字段(0源数据,只能修改折扣比例,1手动增加) 数字精度必须符合(10,0)", groups = {SysPricingStrategyDetailsSectionEntityValidGroup.class, IsSourceValidGroup.class})
    @ApiModelProperty(value = "是否是源字段(0源数据,只能修改折扣比例,1手动增加)")
    private Integer isSource;
    
    /**
     * 创建人ID
     */
    @NotNull(message = "创建人ID 不能是Null", groups = {SysPricingStrategyDetailsSectionEntityValidGroup.class, CreatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人ID 数字精度必须符合(19,0)", groups = {SysPricingStrategyDetailsSectionEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人ID")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {SysPricingStrategyDetailsSectionEntityValidGroup.class, CreatedDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 更新人ID
     */
    @NotNull(message = "更新人ID 不能是Null", groups = {SysPricingStrategyDetailsSectionEntityValidGroup.class, UpdatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="更新人ID 数字精度必须符合(19,0)", groups = {SysPricingStrategyDetailsSectionEntityValidGroup.class, UpdatedByValidGroup.class})
    @ApiModelProperty(value = "更新人ID")
    private Long updatedBy;
    
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "更新时间 不能是Null", groups = {SysPricingStrategyDetailsSectionEntityValidGroup.class, UpdatedDateValidGroup.class})
    @ApiModelProperty(value = "更新时间")
    private Date updatedDate;
    
    /**
     * 是否可用00、无效，01、有效
     */
    @Size(min=0, max=2, message="是否可用00、无效，01、有效 字符长度必须小于等于2", groups = {SysPricingStrategyDetailsSectionEntityValidGroup.class, IsEnableValidGroup.class})
    @ApiModelProperty(value = "是否可用00、无效，01、有效")
    private String isEnable;
    
    /**
     * 是否已删除(00：未删除/01：已删除)
     */
    @Size(min=0, max=2, message="是否已删除(00：未删除/01：已删除) 字符长度必须小于等于2", groups = {SysPricingStrategyDetailsSectionEntityValidGroup.class, IsDeleteValidGroup.class})
    @ApiModelProperty(value = "是否已删除(00：未删除/01：已删除)")
    private String isDelete;
    
    public SysPricingStrategyDetailsSectionEntity() {
    }
    
    public SysPricingStrategyDetailsSectionEntity(Long strategyDetailsId) {
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
    
    public void setDetailsType(String detailsType) {
        this.detailsType = detailsType;
    }
    public String getDetailsType() {
        return this.detailsType;
    }
    
    public void setLeftValue(Integer leftValue) {
        this.leftValue = leftValue;
    }
    public Integer getLeftValue() {
        return this.leftValue;
    }
    
    public void setRightValue(Integer rightValue) {
        this.rightValue = rightValue;
    }
    public Integer getRightValue() {
        return this.rightValue;
    }
    
    public void setDetailsValue(String detailsValue) {
        this.detailsValue = detailsValue;
    }
    public String getDetailsValue() {
        return this.detailsValue;
    }
    
    public void setIsSource(Integer isSource) {
        this.isSource = isSource;
    }
    public Integer getIsSource() {
        return this.isSource;
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

    public interface SysPricingStrategyDetailsSectionEntityValidGroup {}
    public interface StrategyDetailsIdValidGroup {}
    public interface StrategyIdValidGroup {}
    public interface DetailsTypeValidGroup {}
    public interface LeftValueValidGroup {}
    public interface RightValueValidGroup {}
    public interface DetailsValueValidGroup {}
    public interface IsSourceValidGroup {}
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
            , DetailsTypeValidGroup.class
            , LeftValueValidGroup.class
            , RightValueValidGroup.class
            , DetailsValueValidGroup.class
            , IsSourceValidGroup.class
            , CreatedByValidGroup.class
            , CreatedDateValidGroup.class
            , UpdatedByValidGroup.class
            , UpdatedDateValidGroup.class
            , IsEnableValidGroup.class
            , IsDeleteValidGroup.class
        };
    }
}
