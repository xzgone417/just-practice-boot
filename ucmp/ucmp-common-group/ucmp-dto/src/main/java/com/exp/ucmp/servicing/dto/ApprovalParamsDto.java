package com.exp.ucmp.servicing.dto;

import com.egrid.core.base.model.BaseModel;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;
import java.util.Map;

/**
 * @author GeYiJiang
 * @Description: 整备审批参数
 * @date 2023/2/20 14:23
 */
@ApiModel(value = "ApprovalParamsDto",description = "整备审批参数")
public class ApprovalParamsDto{

    @ApiModelProperty(value = "整备信息id",required = true)
    private Long serviceId;

    @ApiModelProperty(value = "1-项目 2-工单",required = true)
    private Integer type;

    @ApiModelProperty(value = "审批状态 5307:审批驳回 5308:放弃整备-转批售 5310:审批通过",required = true)
    private String status;

    @ApiModelProperty(value = "审批备注")
    private String marks;

    @ApiModelProperty(value = "审批结果",required = true)
    private String result;

    @ApiModelProperty(value = "维修项目审批结果集合",required = true)
    private List<ApprovalItemsDto> projectList;

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }

    public List<ApprovalItemsDto> getProjectList() {
		return projectList;
	}

	public void setProjectList(List<ApprovalItemsDto> projectList) {
		this.projectList = projectList;
	}

	public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
