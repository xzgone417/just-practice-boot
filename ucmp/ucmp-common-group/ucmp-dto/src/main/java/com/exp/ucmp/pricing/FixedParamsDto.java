package com.exp.ucmp.pricing;

import com.egrid.core.base.model.BaseModel;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author GeYiJiang
 * @Description:
 * @date 2023/1/13 14:44
 */
@ApiModel(value = "FixedParamsDto", description = "参数")
public class FixedParamsDto extends BaseModel {
    /**
     * 策略详情id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "策略详情id",required = true)
    private Long strategyDetailsId;

    /**
     * 详情值
     */
    @ApiModelProperty(value = "详情值",required = true)
    private String detailsValue;

    public Long getStrategyDetailsId() {
        return strategyDetailsId;
    }

    public void setStrategyDetailsId(Long strategyDetailsId) {
        this.strategyDetailsId = strategyDetailsId;
    }

    public String getDetailsValue() {
        return detailsValue;
    }

    public void setDetailsValue(String detailsValue) {
        this.detailsValue = detailsValue;
    }
}
