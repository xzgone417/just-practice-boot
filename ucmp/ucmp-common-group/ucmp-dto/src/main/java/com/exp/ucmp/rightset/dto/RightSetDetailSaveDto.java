package com.exp.ucmp.rightset.dto;

import com.egrid.core.base.model.BaseModel;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @author GeYiJiang
 * @Description:
 * @date 2022/11/21 16:28
 */
public class RightSetDetailSaveDto extends BaseModel {

    /**
     * 权益ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "权益ID")
    private Long id;

    /**
     * 权益名称
     */
    @ApiModelProperty(value = "权益名称")
    private String name;

    /**
     * 权益状态
     */
    @ApiModelProperty(value = "权益状态")
    private Integer status;

    /**
     * 权益类型名称，即服务内容名称
     */
    @ApiModelProperty(value = "权益类型名称，即服务内容名称")
    private String rightTypeName;

    /**
     * 展示分类名称(说明)
     */
    @ApiModelProperty(value = "展示分类名称(说明)")
    private String subTypeName;

    /**
     * 计量单位
     */
    @ApiModelProperty(value = "计量单位")
    private String unit;

    /**
     * 权益备注
     */
    @ApiModelProperty(value = "权益备注")
    private String meno;

    /**
     * 卡券池编号
     */
    @ApiModelProperty(value = "卡券池编号")
    private String coupon;

    /**
     * 积分池编号
     */
    @ApiModelProperty(value = "积分池编号")
    private String pool;

    /**
     * 卡券池名称
     */
    @ApiModelProperty(value = "卡券池名称")
    private String couponName;

    /**
     * 积分池名称
     */
    @ApiModelProperty(value = "积分池名称")
    private String poolName;

    /**
     * 计量上限
     */
    @ApiModelProperty(value = "计量上限")
    private Integer limited;

    /**
     * 兑换积分数量
     */
    @ApiModelProperty(value = "兑换积分数量")
    private Long integral;

    /**
     * 生效后有效期：天
     */
    @ApiModelProperty(value = "生效后有效期：天")
    private Long deadline;

    /**
     * 计量：1-计量/0-不限量
     */
    @ApiModelProperty(value = "计量：1-计量/0-不限量")
    private Integer countless;

    /**
     * 权益对象：0-车辆/1-客户
     */
    @ApiModelProperty(value = "权益对象：0-车辆/1-客户")
    private Integer target;

    /**
     * 工程车型代码
     */
    @ApiModelProperty(value = "工程车型代码")
    private String modelCode;

    /**
     * 工程车型名称
     */
    @ApiModelProperty(value = "工程车型名称")
    private String modelName;

    /**
     * 基本车型代码
     */
    @ApiModelProperty(value = "基本车型代码")
    private String shapeCode;

    /**
     * 基本车型名称
     */
    @ApiModelProperty(value = "基本车型名称")
    private String shapeName;

    /**
     * 有效期限制：0-不限时，1-动态时间，2-区间时间
     */
    @ApiModelProperty(value = "有效期限制：0-不限时，1-动态时间，2-区间时间")
    private Integer timeless;

    /**
     * 生效规则: 0-立即生效/1-车辆激活
     */
    @ApiModelProperty(value = "生效规则: 0-立即生效/1-车辆激活")
    private Integer trigger;

    /**
     * 生效时间
     */
    @ApiModelProperty(value = "生效时间")
    private Date effectTime;

    /**
     * 失效时间
     */
    @ApiModelProperty(value = "失效时间")
    private Date expireTime;

    public RightSetDetailSaveDto() {
    }

    public RightSetDetailSaveDto(Long id, String name, Integer status, String rightTypeName, String subTypeName, String unit, String meno, String coupon, String pool, String couponName, String poolName, Integer limited, Long integral, Long deadline, Integer countless, Integer target, String modelCode, String modelName, String shapeCode, String shapeName, Integer timeless, Integer trigger, Date effectTime, Date expireTime) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.rightTypeName = rightTypeName;
        this.subTypeName = subTypeName;
        this.unit = unit;
        this.meno = meno;
        this.coupon = coupon;
        this.pool = pool;
        this.couponName = couponName;
        this.poolName = poolName;
        this.limited = limited;
        this.integral = integral;
        this.deadline = deadline;
        this.countless = countless;
        this.target = target;
        this.modelCode = modelCode;
        this.modelName = modelName;
        this.shapeCode = shapeCode;
        this.shapeName = shapeName;
        this.timeless = timeless;
        this.trigger = trigger;
        this.effectTime = effectTime;
        this.expireTime = expireTime;
    }

    /**
     * 获取
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取
     * @return rightTypeName
     */
    public String getRightTypeName() {
        return rightTypeName;
    }

    /**
     * 设置
     * @param rightTypeName
     */
    public void setRightTypeName(String rightTypeName) {
        this.rightTypeName = rightTypeName;
    }

    /**
     * 获取
     * @return subTypeName
     */
    public String getSubTypeName() {
        return subTypeName;
    }

    /**
     * 设置
     * @param subTypeName
     */
    public void setSubTypeName(String subTypeName) {
        this.subTypeName = subTypeName;
    }

    /**
     * 获取
     * @return unit
     */
    public String getUnit() {
        return unit;
    }

    /**
     * 设置
     * @param unit
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }

    /**
     * 获取
     * @return meno
     */
    public String getMeno() {
        return meno;
    }

    /**
     * 设置
     * @param meno
     */
    public void setMeno(String meno) {
        this.meno = meno;
    }

    /**
     * 获取
     * @return coupon
     */
    public String getCoupon() {
        return coupon;
    }

    /**
     * 设置
     * @param coupon
     */
    public void setCoupon(String coupon) {
        this.coupon = coupon;
    }

    /**
     * 获取
     * @return pool
     */
    public String getPool() {
        return pool;
    }

    /**
     * 设置
     * @param pool
     */
    public void setPool(String pool) {
        this.pool = pool;
    }

    /**
     * 获取
     * @return couponName
     */
    public String getCouponName() {
        return couponName;
    }

    /**
     * 设置
     * @param couponName
     */
    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    /**
     * 获取
     * @return poolName
     */
    public String getPoolName() {
        return poolName;
    }

    /**
     * 设置
     * @param poolName
     */
    public void setPoolName(String poolName) {
        this.poolName = poolName;
    }

    /**
     * 获取
     * @return limited
     */
    public Integer getLimited() {
        return limited;
    }

    /**
     * 设置
     * @param limited
     */
    public void setLimited(Integer limited) {
        this.limited = limited;
    }

    /**
     * 获取
     * @return integral
     */
    public Long getIntegral() {
        return integral;
    }

    /**
     * 设置
     * @param integral
     */
    public void setIntegral(Long integral) {
        this.integral = integral;
    }

    /**
     * 获取
     * @return deadline
     */
    public Long getDeadline() {
        return deadline;
    }

    /**
     * 设置
     * @param deadline
     */
    public void setDeadline(Long deadline) {
        this.deadline = deadline;
    }

    /**
     * 获取
     * @return countless
     */
    public Integer getCountless() {
        return countless;
    }

    /**
     * 设置
     * @param countless
     */
    public void setCountless(Integer countless) {
        this.countless = countless;
    }

    /**
     * 获取
     * @return target
     */
    public Integer getTarget() {
        return target;
    }

    /**
     * 设置
     * @param target
     */
    public void setTarget(Integer target) {
        this.target = target;
    }

    /**
     * 获取
     * @return modelCode
     */
    public String getModelCode() {
        return modelCode;
    }

    /**
     * 设置
     * @param modelCode
     */
    public void setModelCode(String modelCode) {
        this.modelCode = modelCode;
    }

    /**
     * 获取
     * @return modelName
     */
    public String getModelName() {
        return modelName;
    }

    /**
     * 设置
     * @param modelName
     */
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    /**
     * 获取
     * @return shapeCode
     */
    public String getShapeCode() {
        return shapeCode;
    }

    /**
     * 设置
     * @param shapeCode
     */
    public void setShapeCode(String shapeCode) {
        this.shapeCode = shapeCode;
    }

    /**
     * 获取
     * @return shapeName
     */
    public String getShapeName() {
        return shapeName;
    }

    /**
     * 设置
     * @param shapeName
     */
    public void setShapeName(String shapeName) {
        this.shapeName = shapeName;
    }

    /**
     * 获取
     * @return timeless
     */
    public Integer getTimeless() {
        return timeless;
    }

    /**
     * 设置
     * @param timeless
     */
    public void setTimeless(Integer timeless) {
        this.timeless = timeless;
    }

    /**
     * 获取
     * @return trigger
     */
    public Integer getTrigger() {
        return trigger;
    }

    /**
     * 设置
     * @param trigger
     */
    public void setTrigger(Integer trigger) {
        this.trigger = trigger;
    }

    /**
     * 获取
     * @return effectTime
     */
    public Date getEffectTime() {
        return effectTime;
    }

    /**
     * 设置
     * @param effectTime
     */
    public void setEffectTime(Date effectTime) {
        this.effectTime = effectTime;
    }

    /**
     * 获取
     * @return expireTime
     */
    public Date getExpireTime() {
        return expireTime;
    }

    /**
     * 设置
     * @param expireTime
     */
    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public String toString() {
        return "RightSetDetailSaveDto{id = " + id + ", name = " + name + ", status = " + status + ", rightTypeName = " + rightTypeName + ", subTypeName = " + subTypeName + ", unit = " + unit + ", meno = " + meno + ", coupon = " + coupon + ", pool = " + pool + ", couponName = " + couponName + ", poolName = " + poolName + ", limited = " + limited + ", integral = " + integral + ", deadline = " + deadline + ", countless = " + countless + ", target = " + target + ", modelCode = " + modelCode + ", modelName = " + modelName + ", shapeCode = " + shapeCode + ", shapeName = " + shapeName + ", timeless = " + timeless + ", trigger = " + trigger + ", effectTime = " + effectTime + ", expireTime = " + expireTime + "}";
    }
}
