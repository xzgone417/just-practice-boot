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
@ApiModel(value = "PricingStrategySectionDto", description = "定值定价策略结果返回")
public class PricingStrategyDto extends BaseModel {
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
     * 详情名称
     */
    @ApiModelProperty(value = "详情名称")
    private String detailsName;

    /**
     * 详情类型
     */
    @ApiModelProperty(value = "详情类型")
    private String detailsType;

    /**
     * 详情值
     */
    @ApiModelProperty(value = "详情值")
    private String detailsValue;
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

    public String getDetailsName() {
        return detailsName;
    }

    public void setDetailsName(String detailsName) {
        this.detailsName = detailsName;
    }

    public String getDetailsType() {
        return detailsType;
    }

    public void setDetailsType(String detailsType) {
        this.detailsType = detailsType;
    }

    public String getDetailsValue() {
        return detailsValue;
    }

    public void setDetailsValue(String detailsValue) {
        this.detailsValue = detailsValue;
    }
}
