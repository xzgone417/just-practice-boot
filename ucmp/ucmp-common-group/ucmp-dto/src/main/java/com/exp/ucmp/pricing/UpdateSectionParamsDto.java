package com.exp.ucmp.pricing;

import com.egrid.core.base.model.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author GeYiJiang
 * @Description: 更新定值DTO
 * @date 2023/1/13 14:12
 */
@ApiModel(value = "UpdateSectionParamsDto", description = "更新区间策略参数")
public class UpdateSectionParamsDto{

    @ApiModelProperty(required = true)
    List<SectionParamsDto> list;

    public List<SectionParamsDto> getList() {
        return list;
    }

    public void setList(List<SectionParamsDto> list) {
        this.list = list;
    }
}
