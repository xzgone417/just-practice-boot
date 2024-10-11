package com.exp.ucmp.pricing;

import com.egrid.core.base.model.BaseModel;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * @author GeYiJiang
 * @Description:
 * @date 2023/1/12 16:50
 */
@ApiModel(value = "PricingStrategySectionDto", description = "区间值定价策略结果返回")
public class PricingStrategySectionDto extends BaseModel {
    /**
     * 策略id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "策略id")
    private Long strategyId;

    /**
     * 策略名称
     */
    @ApiModelProperty(value = "策略名称")
    private String strategyName;

    @ApiModelProperty(value = "策略类型4001里程折旧4002使用月份4003适用类型4004维修折扣4005过户次数4006生产年份")
    private String strategyType;
    /**
     * 策略编号
     */
    @ApiModelProperty(value = "策略编号")
    private String strategyNo;

    /**
     * 策略类型00定值01区间
     */
    @ApiModelProperty(value = "策略类型00定值01区间")
    private String valueType;

    /**
     * 策略详情id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "策略详情id")
    private Long strategyDetailsId;

    /**
     * 详情类型00公里数（公里）、01使用月份
     */
    @ApiModelProperty(value = "详情类型00公里数（公里）、01使用月份")
    private String detailsType;

    /**
     * 左
     */
    @ApiModelProperty(value = "左")
    private Integer leftValue;

    /**
     * 右
     */
    @ApiModelProperty(value = "右")
    private Integer rightValue;

    /**
     * 详情值
     */
    @ApiModelProperty(value = "详情值")
    private String detailsValue;

    @ApiModelProperty(value = "是否是源字段(0源数据,只能修改折扣比例,1手动增加)")
    private Integer isSource;

    public Integer getIsSource() {
        return isSource;
    }

    public void setIsSource(Integer isSource) {
        this.isSource = isSource;
    }

    public Long getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(Long strategyId) {
        this.strategyId = strategyId;
    }

    public String getStrategyName() {
        return strategyName;
    }

    public void setStrategyName(String strategyName) {
        this.strategyName = strategyName;
    }

    public String getStrategyType() {
        return strategyType;
    }

    public void setStrategyType(String strategyType) {
        this.strategyType = strategyType;
    }

    public String getStrategyNo() {
        return strategyNo;
    }

    public void setStrategyNo(String strategyNo) {
        this.strategyNo = strategyNo;
    }

    public String getValueType() {
        return valueType;
    }

    public void setValueType(String valueType) {
        this.valueType = valueType;
    }

    public Long getStrategyDetailsId() {
        return strategyDetailsId;
    }

    public void setStrategyDetailsId(Long strategyDetailsId) {
        this.strategyDetailsId = strategyDetailsId;
    }

    public String getDetailsType() {
        return detailsType;
    }

    public void setDetailsType(String detailsType) {
        this.detailsType = detailsType;
    }

    public Integer getLeftValue() {
        return leftValue;
    }

    public void setLeftValue(Integer leftValue) {
        this.leftValue = leftValue;
    }

    public Integer getRightValue() {
        return rightValue;
    }

    public void setRightValue(Integer rightValue) {
        this.rightValue = rightValue;
    }

    public String getDetailsValue() {
        return detailsValue;
    }

    public void setDetailsValue(String detailsValue) {
        this.detailsValue = detailsValue;
    }
}
