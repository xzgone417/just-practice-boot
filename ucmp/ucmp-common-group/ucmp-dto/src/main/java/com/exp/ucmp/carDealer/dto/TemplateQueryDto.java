package com.exp.ucmp.carDealer.dto;

import com.egrid.core.base.model.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author GeYiJiang
 * @Description:
 * @date 2022/10/20 20:13
 */
@ApiModel(value = "TemplateQueryDto", description = "模板id对象")
public class TemplateQueryDto extends BaseModel {
    private static final long serialVersionUID = 6839836701542716059L;

    public enum TemplateQueryTypeEnum {
        toBeAllocated, noQuote, detectionDate,quoteDeadline,noUploadedAcquisition,noAssociated,noUploadedTransfer;
    }

    /**
     * 查询类型
     */
    @ApiModelProperty(value = "查询类型: toBeAllocated, noQuote, detectionDate,quoteDeadline,noUploadedAcquisition,noAssociated,noUploadedTransfer")
    private String TemplateQueryType;

    public String getTemplateQueryType() {
        return TemplateQueryType;
    }

    public void setTemplateQueryType(String templateQueryType) {
        TemplateQueryType = templateQueryType;
    }
}
