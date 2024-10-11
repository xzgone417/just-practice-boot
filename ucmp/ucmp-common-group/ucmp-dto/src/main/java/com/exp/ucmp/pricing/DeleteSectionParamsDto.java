package com.exp.ucmp.pricing;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author GeYiJiang
 * @Description: 删除区间DTO
 * @date 2023/1/13 14:12
 */
@ApiModel(value = "DeleteSectionParamsDto", description = "删除区间策略参数")
public class DeleteSectionParamsDto {
    /**
     * 策略详情id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "策略详情id",required = true)
    private Long strategyDetailsId;

    public Long getStrategyDetailsId() {
        return strategyDetailsId;
    }

    public void setStrategyDetailsId(Long strategyDetailsId) {
        this.strategyDetailsId = strategyDetailsId;
    }
}
