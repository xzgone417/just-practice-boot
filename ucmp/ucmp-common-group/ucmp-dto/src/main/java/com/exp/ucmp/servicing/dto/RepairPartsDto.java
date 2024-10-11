package com.exp.ucmp.servicing.dto;

import com.egrid.core.base.model.BaseModel;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

/**
 * @author GeYiJiang
 * @Description: 维修配件dto
 * @date 2023/2/18 15:42
 */
@ApiModel(value = "RepairPartsDto",description = "维修配件")
public class RepairPartsDto extends BaseModel {
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "配件id")
    private Long componentId;

    @ApiModelProperty(value = "维修项目id")
    private Long projectId;

    @ApiModelProperty(value = "配件代码")
    private String componentCode;

    @ApiModelProperty(value = "配件名称")
    private String componentName;

    @ApiModelProperty(value = "配件费用")
    private BigDecimal componentPrice;

    @ApiModelProperty(value = "是否维修(0 是 1 否)")
    private Integer isRepair;

    public Long getComponentId() {
        return componentId;
    }

    public void setComponentId(Long componentId) {
        this.componentId = componentId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getComponentCode() {
        return componentCode;
    }

    public void setComponentCode(String componentCode) {
        this.componentCode = componentCode;
    }

    public String getComponentName() {
        return componentName;
    }

    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    public BigDecimal getComponentPrice() {
        return componentPrice;
    }

    public void setComponentPrice(BigDecimal componentPrice) {
        this.componentPrice = componentPrice;
    }

    public Integer getIsRepair() {
        return isRepair;
    }

    public void setIsRepair(Integer isRepair) {
        this.isRepair = isRepair;
    }
}
