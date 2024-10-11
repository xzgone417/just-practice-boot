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

@ApiModel(value = "SysRightActivitiesDetailsEntity", description = "权益活动明细表")
@GroupSequence({SysRightActivitiesDetailsEntity.class, SysRightActivitiesDetailsEntity.SysRightActivitiesDetailsEntityValidGroup.class,SysRightActivitiesDetailsEntity.DetailIdValidGroup.class,SysRightActivitiesDetailsEntity.EquityIdValidGroup.class,SysRightActivitiesDetailsEntity.RightIdValidGroup.class,SysRightActivitiesDetailsEntity.RightNameValidGroup.class,SysRightActivitiesDetailsEntity.RightTypeNameValidGroup.class,SysRightActivitiesDetailsEntity.SubTypeNameValidGroup.class,SysRightActivitiesDetailsEntity.StatusValidGroup.class,SysRightActivitiesDetailsEntity.UnitValidGroup.class,SysRightActivitiesDetailsEntity.MenoValidGroup.class,SysRightActivitiesDetailsEntity.CouponValidGroup.class,SysRightActivitiesDetailsEntity.PoolValidGroup.class,SysRightActivitiesDetailsEntity.CouponNameValidGroup.class,SysRightActivitiesDetailsEntity.PoolNameValidGroup.class,SysRightActivitiesDetailsEntity.LimitedValidGroup.class,SysRightActivitiesDetailsEntity.IntegralValidGroup.class,SysRightActivitiesDetailsEntity.DeadlineValidGroup.class,SysRightActivitiesDetailsEntity.CountlessValidGroup.class,SysRightActivitiesDetailsEntity.TargetValidGroup.class,SysRightActivitiesDetailsEntity.ModelCodeValidGroup.class,SysRightActivitiesDetailsEntity.ModelNameValidGroup.class,SysRightActivitiesDetailsEntity.ShapeCodeValidGroup.class,SysRightActivitiesDetailsEntity.ShapeNameValidGroup.class,SysRightActivitiesDetailsEntity.TimelessValidGroup.class,SysRightActivitiesDetailsEntity.DetailsTriggerValidGroup.class,SysRightActivitiesDetailsEntity.IsEnableValidGroup.class,SysRightActivitiesDetailsEntity.IsDeleteValidGroup.class,SysRightActivitiesDetailsEntity.CreatedByValidGroup.class,SysRightActivitiesDetailsEntity.CreatedDateValidGroup.class,SysRightActivitiesDetailsEntity.UpdatedByValidGroup.class,SysRightActivitiesDetailsEntity.UpdatedDateValidGroup.class}) 
public class SysRightActivitiesDetailsEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 明细主键ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "明细主键ID 不能是Null", groups = {SysRightActivitiesDetailsEntityValidGroup.class, DetailIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="明细主键ID 数字精度必须符合(19,0)", groups = {SysRightActivitiesDetailsEntityValidGroup.class, DetailIdValidGroup.class})
    @ApiModelProperty(value = "明细主键ID")
    private Long detailId;
    
    
    /**
     * 权益ID
     */
    @NotNull(message = "权益ID 不能是Null", groups = {SysRightActivitiesDetailsEntityValidGroup.class, EquityIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="权益ID 数字精度必须符合(19,0)", groups = {SysRightActivitiesDetailsEntityValidGroup.class, EquityIdValidGroup.class})
    @ApiModelProperty(value = "权益ID")
    private Long equityId;
    
    /**
     * 权益活动主键ID
     */
    @NotNull(message = "权益活动主键ID 不能是Null", groups = {SysRightActivitiesDetailsEntityValidGroup.class, RightIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="权益活动主键ID 数字精度必须符合(19,0)", groups = {SysRightActivitiesDetailsEntityValidGroup.class, RightIdValidGroup.class})
    @ApiModelProperty(value = "权益活动主键ID")
    private Long rightId;
    
    /**
     * 权益名称
     */
    @NotNull(message = "权益名称 不能是Null", groups = {SysRightActivitiesDetailsEntityValidGroup.class, RightNameValidGroup.class})
    @Size(min=0, max=50, message="权益名称 字符长度必须小于等于50", groups = {SysRightActivitiesDetailsEntityValidGroup.class, RightNameValidGroup.class})
    @ApiModelProperty(value = "权益名称")
    private String rightName;
    
    /**
     * 权益类型名称，即服务内容名称
     */
    @NotNull(message = "权益类型名称，即服务内容名称 不能是Null", groups = {SysRightActivitiesDetailsEntityValidGroup.class, RightTypeNameValidGroup.class})
    @Size(min=0, max=50, message="权益类型名称，即服务内容名称 字符长度必须小于等于50", groups = {SysRightActivitiesDetailsEntityValidGroup.class, RightTypeNameValidGroup.class})
    @ApiModelProperty(value = "权益类型名称，即服务内容名称")
    private String rightTypeName;
    
    /**
     * 展示分类名称(说明)
     */
    @NotNull(message = "展示分类名称(说明) 不能是Null", groups = {SysRightActivitiesDetailsEntityValidGroup.class, SubTypeNameValidGroup.class})
    @Size(min=0, max=50, message="展示分类名称(说明) 字符长度必须小于等于50", groups = {SysRightActivitiesDetailsEntityValidGroup.class, SubTypeNameValidGroup.class})
    @ApiModelProperty(value = "展示分类名称(说明)")
    private String subTypeName;
    
    /**
     * 权益状态：0-待启用/1-已启用/2-已停用
     */
    @NotNull(message = "权益状态：0-待启用/1-已启用/2-已停用 不能是Null", groups = {SysRightActivitiesDetailsEntityValidGroup.class, StatusValidGroup.class})
    @Digits(integer=10, fraction=0, message="权益状态：0-待启用/1-已启用/2-已停用 数字精度必须符合(10,0)", groups = {SysRightActivitiesDetailsEntityValidGroup.class, StatusValidGroup.class})
    @ApiModelProperty(value = "权益状态：0-待启用/1-已启用/2-已停用")
    private Integer status;
    
    /**
     * 计量单位
     */
    @NotNull(message = "计量单位 不能是Null", groups = {SysRightActivitiesDetailsEntityValidGroup.class, UnitValidGroup.class})
    @Size(min=0, max=10, message="计量单位 字符长度必须小于等于10", groups = {SysRightActivitiesDetailsEntityValidGroup.class, UnitValidGroup.class})
    @ApiModelProperty(value = "计量单位")
    private String unit;
    
    /**
     * 权益备注
     */
    @Size(min=0, max=50, message="权益备注 字符长度必须小于等于50", groups = {SysRightActivitiesDetailsEntityValidGroup.class, MenoValidGroup.class})
    @ApiModelProperty(value = "权益备注")
    private String meno;
    
    /**
     * 卡券池编号
     */
    @Size(min=0, max=50, message="卡券池编号 字符长度必须小于等于50", groups = {SysRightActivitiesDetailsEntityValidGroup.class, CouponValidGroup.class})
    @ApiModelProperty(value = "卡券池编号")
    private String coupon;
    
    /**
     * 积分池编号
     */
    @Size(min=0, max=50, message="积分池编号 字符长度必须小于等于50", groups = {SysRightActivitiesDetailsEntityValidGroup.class, PoolValidGroup.class})
    @ApiModelProperty(value = "积分池编号")
    private String pool;
    
    /**
     * 卡券池名称
     */
    @Size(min=0, max=50, message="卡券池名称 字符长度必须小于等于50", groups = {SysRightActivitiesDetailsEntityValidGroup.class, CouponNameValidGroup.class})
    @ApiModelProperty(value = "卡券池名称")
    private String couponName;
    
    /**
     * 积分池名称
     */
    @Size(min=0, max=50, message="积分池名称 字符长度必须小于等于50", groups = {SysRightActivitiesDetailsEntityValidGroup.class, PoolNameValidGroup.class})
    @ApiModelProperty(value = "积分池名称")
    private String poolName;
    
    /**
     * 计量上限
     */
    @Digits(integer=10, fraction=0, message="计量上限 数字精度必须符合(10,0)", groups = {SysRightActivitiesDetailsEntityValidGroup.class, LimitedValidGroup.class})
    @ApiModelProperty(value = "计量上限")
    private Integer limited;
    
    /**
     * 兑换积分数量
     */
    @Digits(integer=19, fraction=0, message="兑换积分数量 数字精度必须符合(19,0)", groups = {SysRightActivitiesDetailsEntityValidGroup.class, IntegralValidGroup.class})
    @ApiModelProperty(value = "兑换积分数量")
    private Long integral;
    
    /**
     * 生效后有效期：天
     */
    @Digits(integer=19, fraction=0, message="生效后有效期：天 数字精度必须符合(19,0)", groups = {SysRightActivitiesDetailsEntityValidGroup.class, DeadlineValidGroup.class})
    @ApiModelProperty(value = "生效后有效期：天")
    private Long deadline;
    
    /**
     * 计量：1-计量/0-不限量
     */
    @NotNull(message = "计量：1-计量/0-不限量 不能是Null", groups = {SysRightActivitiesDetailsEntityValidGroup.class, CountlessValidGroup.class})
    @Digits(integer=10, fraction=0, message="计量：1-计量/0-不限量 数字精度必须符合(10,0)", groups = {SysRightActivitiesDetailsEntityValidGroup.class, CountlessValidGroup.class})
    @ApiModelProperty(value = "计量：1-计量/0-不限量")
    private Integer countless;
    
    /**
     * 权益对象：0-车辆/1-客户
     */
    @NotNull(message = "权益对象：0-车辆/1-客户 不能是Null", groups = {SysRightActivitiesDetailsEntityValidGroup.class, TargetValidGroup.class})
    @Digits(integer=10, fraction=0, message="权益对象：0-车辆/1-客户 数字精度必须符合(10,0)", groups = {SysRightActivitiesDetailsEntityValidGroup.class, TargetValidGroup.class})
    @ApiModelProperty(value = "权益对象：0-车辆/1-客户")
    private Integer target;
    
    /**
     * 工程车型代码
     */
    @Size(min=0, max=200, message="工程车型代码 字符长度必须小于等于200", groups = {SysRightActivitiesDetailsEntityValidGroup.class, ModelCodeValidGroup.class})
    @ApiModelProperty(value = "工程车型代码")
    private String modelCode;
    
    /**
     * 工程车型名称
     */
    @Size(min=0, max=200, message="工程车型名称 字符长度必须小于等于200", groups = {SysRightActivitiesDetailsEntityValidGroup.class, ModelNameValidGroup.class})
    @ApiModelProperty(value = "工程车型名称")
    private String modelName;
    
    /**
     * 基本车型代码
     */
    @Size(min=0, max=200, message="基本车型代码 字符长度必须小于等于200", groups = {SysRightActivitiesDetailsEntityValidGroup.class, ShapeCodeValidGroup.class})
    @ApiModelProperty(value = "基本车型代码")
    private String shapeCode;
    
    /**
     * 基本车型名称
     */
    @Size(min=0, max=200, message="基本车型名称 字符长度必须小于等于200", groups = {SysRightActivitiesDetailsEntityValidGroup.class, ShapeNameValidGroup.class})
    @ApiModelProperty(value = "基本车型名称")
    private String shapeName;
    
    /**
     * 有效期限制：0-不限时，1-动态时间，2-区间时间
     */
    @NotNull(message = "有效期限制：0-不限时，1-动态时间，2-区间时间 不能是Null", groups = {SysRightActivitiesDetailsEntityValidGroup.class, TimelessValidGroup.class})
    @Digits(integer=10, fraction=0, message="有效期限制：0-不限时，1-动态时间，2-区间时间 数字精度必须符合(10,0)", groups = {SysRightActivitiesDetailsEntityValidGroup.class, TimelessValidGroup.class})
    @ApiModelProperty(value = "有效期限制：0-不限时，1-动态时间，2-区间时间")
    private Integer timeless;
    
    /**
     * 生效规则: 0-立即生效/1-车辆激活
     */
    @Digits(integer=10, fraction=0, message="生效规则: 0-立即生效/1-车辆激活 数字精度必须符合(10,0)", groups = {SysRightActivitiesDetailsEntityValidGroup.class, DetailsTriggerValidGroup.class})
    @ApiModelProperty(value = "生效规则: 0-立即生效/1-车辆激活")
    private Integer detailsTrigger;
    
    /**
     * 生效时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "生效时间")
    private Date effectTime;
    
    /**
     * 失效时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "失效时间")
    private Date expireTime;
    
    /**
     * 是否可用：00、不可用，01、可用
     */
    @NotNull(message = "是否可用：00、不可用，01、可用 不能是Null", groups = {SysRightActivitiesDetailsEntityValidGroup.class, IsEnableValidGroup.class})
    @Size(min=0, max=2, message="是否可用：00、不可用，01、可用 字符长度必须小于等于2", groups = {SysRightActivitiesDetailsEntityValidGroup.class, IsEnableValidGroup.class})
    @ApiModelProperty(value = "是否可用：00、不可用，01、可用")
    private String isEnable;
    
    /**
     * 是否被删除：00、未删除，01、删除
     */
    @NotNull(message = "是否被删除：00、未删除，01、删除 不能是Null", groups = {SysRightActivitiesDetailsEntityValidGroup.class, IsDeleteValidGroup.class})
    @Size(min=0, max=2, message="是否被删除：00、未删除，01、删除 字符长度必须小于等于2", groups = {SysRightActivitiesDetailsEntityValidGroup.class, IsDeleteValidGroup.class})
    @ApiModelProperty(value = "是否被删除：00、未删除，01、删除")
    private String isDelete;
    
    /**
     * 创建人ID
     */
    @NotNull(message = "创建人ID 不能是Null", groups = {SysRightActivitiesDetailsEntityValidGroup.class, CreatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人ID 数字精度必须符合(19,0)", groups = {SysRightActivitiesDetailsEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人ID")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {SysRightActivitiesDetailsEntityValidGroup.class, CreatedDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 更新人ID
     */
    @NotNull(message = "更新人ID 不能是Null", groups = {SysRightActivitiesDetailsEntityValidGroup.class, UpdatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="更新人ID 数字精度必须符合(19,0)", groups = {SysRightActivitiesDetailsEntityValidGroup.class, UpdatedByValidGroup.class})
    @ApiModelProperty(value = "更新人ID")
    private Long updatedBy;
    
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "更新时间 不能是Null", groups = {SysRightActivitiesDetailsEntityValidGroup.class, UpdatedDateValidGroup.class})
    @ApiModelProperty(value = "更新时间")
    private Date updatedDate;
    
    public SysRightActivitiesDetailsEntity() {
    }
    
    public SysRightActivitiesDetailsEntity(Long detailId) {
        this.detailId = detailId;
    }

    public void setDetailId(Long detailId) {
        this.detailId = detailId;
    }
    public Long getDetailId() {
        return this.detailId;
    }
    

    public void setEquityId(Long equityId) {
        this.equityId = equityId;
    }
    public Long getEquityId() {
        return this.equityId;
    }
    
    public void setRightId(Long rightId) {
        this.rightId = rightId;
    }
    public Long getRightId() {
        return this.rightId;
    }
    
    public void setRightName(String rightName) {
        this.rightName = rightName;
    }
    public String getRightName() {
        return this.rightName;
    }
    
    public void setRightTypeName(String rightTypeName) {
        this.rightTypeName = rightTypeName;
    }
    public String getRightTypeName() {
        return this.rightTypeName;
    }
    
    public void setSubTypeName(String subTypeName) {
        this.subTypeName = subTypeName;
    }
    public String getSubTypeName() {
        return this.subTypeName;
    }
    
    public void setStatus(Integer status) {
        this.status = status;
    }
    public Integer getStatus() {
        return this.status;
    }
    
    public void setUnit(String unit) {
        this.unit = unit;
    }
    public String getUnit() {
        return this.unit;
    }
    
    public void setMeno(String meno) {
        this.meno = meno;
    }
    public String getMeno() {
        return this.meno;
    }
    
    public void setCoupon(String coupon) {
        this.coupon = coupon;
    }
    public String getCoupon() {
        return this.coupon;
    }
    
    public void setPool(String pool) {
        this.pool = pool;
    }
    public String getPool() {
        return this.pool;
    }
    
    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }
    public String getCouponName() {
        return this.couponName;
    }
    
    public void setPoolName(String poolName) {
        this.poolName = poolName;
    }
    public String getPoolName() {
        return this.poolName;
    }
    
    public void setLimited(Integer limited) {
        this.limited = limited;
    }
    public Integer getLimited() {
        return this.limited;
    }
    
    public void setIntegral(Long integral) {
        this.integral = integral;
    }
    public Long getIntegral() {
        return this.integral;
    }
    
    public void setDeadline(Long deadline) {
        this.deadline = deadline;
    }
    public Long getDeadline() {
        return this.deadline;
    }
    
    public void setCountless(Integer countless) {
        this.countless = countless;
    }
    public Integer getCountless() {
        return this.countless;
    }
    
    public void setTarget(Integer target) {
        this.target = target;
    }
    public Integer getTarget() {
        return this.target;
    }
    
    public void setModelCode(String modelCode) {
        this.modelCode = modelCode;
    }
    public String getModelCode() {
        return this.modelCode;
    }
    
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
    public String getModelName() {
        return this.modelName;
    }
    
    public void setShapeCode(String shapeCode) {
        this.shapeCode = shapeCode;
    }
    public String getShapeCode() {
        return this.shapeCode;
    }
    
    public void setShapeName(String shapeName) {
        this.shapeName = shapeName;
    }
    public String getShapeName() {
        return this.shapeName;
    }
    
    public void setTimeless(Integer timeless) {
        this.timeless = timeless;
    }
    public Integer getTimeless() {
        return this.timeless;
    }
    
    public void setDetailsTrigger(Integer detailsTrigger) {
        this.detailsTrigger = detailsTrigger;
    }
    public Integer getDetailsTrigger() {
        return this.detailsTrigger;
    }
    
    public void setEffectTime(Date effectTime) {
        this.effectTime = effectTime;
    }
    public Date getEffectTime() {
        return this.effectTime;
    }
    
    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }
    public Date getExpireTime() {
        return this.expireTime;
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
              (detailId == null)
           
               ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
                detailId = RandomIDGennerator.get().generate();
    }

    public interface SysRightActivitiesDetailsEntityValidGroup {}
    public interface DetailIdValidGroup {}
    public interface EquityIdValidGroup {}
    public interface RightIdValidGroup {}
    public interface RightNameValidGroup {}
    public interface RightTypeNameValidGroup {}
    public interface SubTypeNameValidGroup {}
    public interface StatusValidGroup {}
    public interface UnitValidGroup {}
    public interface MenoValidGroup {}
    public interface CouponValidGroup {}
    public interface PoolValidGroup {}
    public interface CouponNameValidGroup {}
    public interface PoolNameValidGroup {}
    public interface LimitedValidGroup {}
    public interface IntegralValidGroup {}
    public interface DeadlineValidGroup {}
    public interface CountlessValidGroup {}
    public interface TargetValidGroup {}
    public interface ModelCodeValidGroup {}
    public interface ModelNameValidGroup {}
    public interface ShapeCodeValidGroup {}
    public interface ShapeNameValidGroup {}
    public interface TimelessValidGroup {}
    public interface DetailsTriggerValidGroup {}
    public interface IsEnableValidGroup {}
    public interface IsDeleteValidGroup {}
    public interface CreatedByValidGroup {}
    public interface CreatedDateValidGroup {}
    public interface UpdatedByValidGroup {}
    public interface UpdatedDateValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            DetailIdValidGroup.class
            , EquityIdValidGroup.class
            , RightIdValidGroup.class
            , RightNameValidGroup.class
            , RightTypeNameValidGroup.class
            , SubTypeNameValidGroup.class
            , StatusValidGroup.class
            , UnitValidGroup.class
            , MenoValidGroup.class
            , CouponValidGroup.class
            , PoolValidGroup.class
            , CouponNameValidGroup.class
            , PoolNameValidGroup.class
            , LimitedValidGroup.class
            , IntegralValidGroup.class
            , DeadlineValidGroup.class
            , CountlessValidGroup.class
            , TargetValidGroup.class
            , ModelCodeValidGroup.class
            , ModelNameValidGroup.class
            , ShapeCodeValidGroup.class
            , ShapeNameValidGroup.class
            , TimelessValidGroup.class
            , DetailsTriggerValidGroup.class
            , IsEnableValidGroup.class
            , IsDeleteValidGroup.class
            , CreatedByValidGroup.class
            , CreatedDateValidGroup.class
            , UpdatedByValidGroup.class
            , UpdatedDateValidGroup.class
        };
    }
}
