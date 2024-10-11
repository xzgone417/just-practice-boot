package com.exp.ucmp.pricing;

import com.egrid.core.base.model.BaseModel;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author GeYiJiang
 * @Description:
 * @date 2023/1/13 14:44
 */
@ApiModel(value = "SectionParamsDto", description = "区间参数")
public class SectionParamsDto extends BaseModel {
//    /**
//     * 策略详情id
//     */
//    @JsonSerialize(using = ToStringSerializer.class)
//    @ApiModelProperty(value = "策略详情id(更新传)")
//    private Long strategyDetailsId;

    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "策略id",required = true)
    private Long strategyId;
    /**
     * 左
     */
    @ApiModelProperty(value = "详情类型(00公里数 01使用月份)",required = true)
    private String detailsType;

    @ApiModelProperty(value = "左",required = true)
    @JsonSerialize(using = ToStringSerializer.class)
    private Integer leftValue;
    /**
     * 右
     */
    @ApiModelProperty(value = "右",required = true)
    @JsonSerialize(using = ToStringSerializer.class)
    private Integer rightValue;
    /**
     * 详情值
     */
    @ApiModelProperty(value = "详情值",required = true)
    private String detailsValue;

    @ApiModelProperty(value = "是否是源字段(0源数据,只能修改折扣比例,1手动增加)")
    private Integer isSource;

    public Integer getIsSource() {
        return isSource;
    }

    public void setIsSource(Integer isSource) {
        this.isSource = isSource;
    }
//    public Long getStrategyDetailsId() {
//        return strategyDetailsId;
//    }
//
//    public void setStrategyDetailsId(Long strategyDetailsId) {
//        this.strategyDetailsId = strategyDetailsId;
//    }

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

    public Long getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(Long strategyId) {
        this.strategyId = strategyId;
    }

    public String getDetailsType() {
        return detailsType;
    }

    public void setDetailsType(String detailsType) {
        this.detailsType = detailsType;
    }
}
