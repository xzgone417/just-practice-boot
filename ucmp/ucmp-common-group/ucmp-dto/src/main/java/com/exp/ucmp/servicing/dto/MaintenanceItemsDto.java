package com.exp.ucmp.servicing.dto;

import com.egrid.core.base.model.BaseModel;
import com.exp.ucmp.entity.PsiCarServiceRepairProjectEntity;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author GeYiJiang
 * @Description: 维修项目dto
 * @date 2023/2/18 15:42
 */
@ApiModel(value = "MaintenanceItemsDto",description = "维修项目")
public class MaintenanceItemsDto extends BaseModel {
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "项目id")
    private Long projectId;

    @ApiModelProperty(value = "整备信息id")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long serviceId;

    @ApiModelProperty(value = "维修项目类型")
    private String repairProjectType;

    @ApiModelProperty(value = "维修项目代码")
    private String repairProjectCode;

    @ApiModelProperty(value = "维修项目名称")
    private String repairProjectName;

    @ApiModelProperty(value = "工时费用")
    private BigDecimal timePrice;

    @ApiModelProperty(value = "是否有配件(0 是 1 否)")
    private Integer isComponent;

    @ApiModelProperty(value = "是否维修(0 是 1 否)")
    private Integer isRepair;

    @ApiModelProperty(value = "变更操作(0 无变更 1 新增 2 删除)")
    private Integer changeOperate;

    @ApiModelProperty(value = "配件列表")
    private List<RepairPartsDto> list;

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public String getRepairProjectType() {
        return repairProjectType;
    }

    public void setRepairProjectType(String repairProjectType) {
        this.repairProjectType = repairProjectType;
    }

    public String getRepairProjectCode() {
        return repairProjectCode;
    }

    public void setRepairProjectCode(String repairProjectCode) {
        this.repairProjectCode = repairProjectCode;
    }

    public String getRepairProjectName() {
        return repairProjectName;
    }

    public void setRepairProjectName(String repairProjectName) {
        this.repairProjectName = repairProjectName;
    }

    public BigDecimal getTimePrice() {
        return timePrice;
    }

    public void setTimePrice(BigDecimal timePrice) {
        this.timePrice = timePrice;
    }

    public Integer getIsComponent() {
        return isComponent;
    }

    public void setIsComponent(Integer isComponent) {
        this.isComponent = isComponent;
    }

    public Integer getIsRepair() {
        return isRepair;
    }

    public void setIsRepair(Integer isRepair) {
        this.isRepair = isRepair;
    }

    public Integer getChangeOperate() {
        return changeOperate;
    }

    public void setChangeOperate(Integer changeOperate) {
        this.changeOperate = changeOperate;
    }

    public List<RepairPartsDto> getList() {
        return list;
    }

    public void setList(List<RepairPartsDto> list) {
        this.list = list;
    }
}
