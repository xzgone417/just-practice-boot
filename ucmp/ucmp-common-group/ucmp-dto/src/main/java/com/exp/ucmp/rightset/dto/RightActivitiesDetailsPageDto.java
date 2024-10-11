package com.exp.ucmp.rightset.dto;

import com.egrid.core.base.model.BaseModel;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @author hailele
 * @Description: 权益明细项目列表Dto
 * @date 2022/11/21 14:19
 */
@ApiModel(value = "RightActivitiesDetailsPageDto", description = "权益明细项目列表分页结果对象")
public class RightActivitiesDetailsPageDto extends BaseModel {
    /**
     * 明细主键ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "明细主键ID")
    private Long detailId;
    /**
     * 权益ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "权益ID")
    private Long equityId;

    /**
     * 权益活动主键ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "权益活动主键ID")
    private Long rightId;

    /**
     * 权益名称
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "权益名称")
    private String rightName;

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
     * 有效期限制：0-不限时，1-动态时间，2-区间时间
     */
    @ApiModelProperty(value = "有效期限制：0-不限时，1-动态时间，2-区间时间")
    private Integer timeless;

    /**
     * 生效规则: 0-立即生效/1-车辆激活
     */
    @ApiModelProperty(value = "生效规则: 0-立即生效/1-车辆激活")
    private Integer detailsTrigger;

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

    public String getModelCode() {
        return modelCode;
    }

    public void setModelCode(String modelCode) {
        this.modelCode = modelCode;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getShapeCode() {
        return shapeCode;
    }

    public void setShapeCode(String shapeCode) {
        this.shapeCode = shapeCode;
    }

    public String getShapeName() {
        return shapeName;
    }

    public void setShapeName(String shapeName) {
        this.shapeName = shapeName;
    }

    public Long getEquityId() {
        return equityId;
    }

    public void setEquityId(Long equityId) {
        this.equityId = equityId;
    }

    public Long getDetailId() {
        return detailId;
    }

    public void setDetailId(Long detailId) {
        this.detailId = detailId;
    }

    public Long getRightId() {
        return rightId;
    }

    public void setRightId(Long rightId) {
        this.rightId = rightId;
    }

    public String getRightName() {
        return rightName;
    }

    public void setRightName(String rightName) {
        this.rightName = rightName;
    }

    public String getRightTypeName() {
        return rightTypeName;
    }

    public void setRightTypeName(String rightTypeName) {
        this.rightTypeName = rightTypeName;
    }

    public String getSubTypeName() {
        return subTypeName;
    }

    public void setSubTypeName(String subTypeName) {
        this.subTypeName = subTypeName;
    }

    public String getUnit() {
        return unit;
    }


    public Integer getDetailsTrigger() {
        return detailsTrigger;
    }

    public void setDetailsTrigger(Integer detailsTrigger) {
        this.detailsTrigger = detailsTrigger;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getMeno() {
        return meno;
    }

    public void setMeno(String meno) {
        this.meno = meno;
    }

    public String getCoupon() {
        return coupon;
    }

    public void setCoupon(String coupon) {
        this.coupon = coupon;
    }

    public String getPool() {
        return pool;
    }

    public void setPool(String pool) {
        this.pool = pool;
    }

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    public String getPoolName() {
        return poolName;
    }

    public void setPoolName(String poolName) {
        this.poolName = poolName;
    }

    public Integer getLimited() {
        return limited;
    }

    public void setLimited(Integer limited) {
        this.limited = limited;
    }

    public Long getIntegral() {
        return integral;
    }

    public void setIntegral(Long integral) {
        this.integral = integral;
    }

    public Long getDeadline() {
        return deadline;
    }

    public void setDeadline(Long deadline) {
        this.deadline = deadline;
    }

    public Integer getCountless() {
        return countless;
    }

    public void setCountless(Integer countless) {
        this.countless = countless;
    }

    public Integer getTarget() {
        return target;
    }

    public void setTarget(Integer target) {
        this.target = target;
    }

    public Integer getTimeless() {
        return timeless;
    }

    public void setTimeless(Integer timeless) {
        this.timeless = timeless;
    }

    public Date getEffectTime() {
        return effectTime;
    }

    public void setEffectTime(Date effectTime) {
        this.effectTime = effectTime;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }
}
