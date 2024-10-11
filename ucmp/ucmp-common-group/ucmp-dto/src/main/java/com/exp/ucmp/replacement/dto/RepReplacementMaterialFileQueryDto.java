package com.exp.ucmp.replacement.dto;

import com.egrid.core.base.model.BaseModel;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value = "RepReplacementMaterialFileQueryDto", description = "置换材料文件查询")
public class RepReplacementMaterialFileQueryDto extends BaseModel {

    private static final long serialVersionUID = 1L;



    /**
     * 材料ID
     */
    @ApiModelProperty(value = "材料ID")
    private Long materialId;






    public RepReplacementMaterialFileQueryDto() {
    }




}
