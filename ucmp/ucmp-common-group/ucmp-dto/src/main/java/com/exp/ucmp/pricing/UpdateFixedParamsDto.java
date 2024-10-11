package com.exp.ucmp.pricing;

import com.egrid.core.base.model.BaseModel;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author GeYiJiang
 * @Description: 更新定值DTO
 * @date 2023/1/13 14:12
 */
@ApiModel(value = "UpdateFixedParamsDto", description = "更新定值策略参数")
public class UpdateFixedParamsDto{

    @ApiModelProperty(required = true)
    List<FixedParamsDto> list;

    public List<FixedParamsDto> getList() {
        return list;
    }

    public void setList(List<FixedParamsDto> list) {
        this.list = list;
    }
}
