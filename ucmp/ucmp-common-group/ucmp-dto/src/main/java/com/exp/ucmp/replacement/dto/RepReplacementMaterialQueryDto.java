package com.exp.ucmp.replacement.dto;


import com.egrid.core.base.model.BaseModel;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@ApiModel(value = "RepReplacementMaterialQueryDto", description = "材料信息查询")
public class RepReplacementMaterialQueryDto extends BaseModel {

    private static final long serialVersionUID = 1L;



    /**
     * 置换ID
     */
    @ApiModelProperty(value = "置换ID")
    private Long replacementId;



    public RepReplacementMaterialQueryDto() {
    }

    public Long getReplacementId() {
        return replacementId;
    }

    public void setReplacementId(Long replacementId) {
        this.replacementId = replacementId;
    }
}
