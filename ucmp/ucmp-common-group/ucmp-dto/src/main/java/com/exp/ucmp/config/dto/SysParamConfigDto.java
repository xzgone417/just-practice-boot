package com.exp.ucmp.config.dto;

import com.exp.ucmp.PageDto;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SysParameterConfigurationDto", description = "参数配置信息")
public class SysParamConfigDto extends PageDto {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "主键id")
    private Long paramId;

    /**
     * 参数类型(001:报价截止时间/002:自动关闭时间/003:首次材料未上报提醒时间/004:过户材料未上报提醒时间)
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "参数类型(001:报价截止时间/002:自动关闭时间/003:首次材料未上报提醒时间/004:过户材料未上报提醒时间)")
    private String paramType;

    /**
     * 参数描述
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "参数描述")
    private String paramProfile;

    /**
     * 参数详细描述
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "参数详细描述")
    private String paramDetails;


    /**
     * 参数值
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "参数值")
    private String paramValues;

    /**
     * 参数单位(DAYS:天/HOUR:小时/MIN:分钟/SECOND:秒)
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "参数单位(DAYS:天/HOUR:小时/MIN:分钟/SECOND:秒)")
    private String paramUnit;

    /**
     * 参数单位描述
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "参数单位描述")
    private String paramUnitDetails;

    /**
     * 参数排序
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "参数排序")
    private Integer paramSort;

    public Integer getParamSort() {
        return paramSort;
    }

    public void setParamSort(Integer paramSort) {
        this.paramSort = paramSort;
    }

    public Long getParamId() {
        return paramId;
    }

    public void setParamId(Long paramId) {
        this.paramId = paramId;
    }

    public String getParamType() {
        return paramType;
    }

    public void setParamType(String paramType) {
        this.paramType = paramType;
    }

    public String getParamProfile() {
        return paramProfile;
    }

    public void setParamProfile(String paramProfile) {
        this.paramProfile = paramProfile;
    }

    public String getParamDetails() {
        return paramDetails;
    }

    public void setParamDetails(String paramDetails) {
        this.paramDetails = paramDetails;
    }

    public String getParamValues() {
        return paramValues;
    }

    public void setParamValues(String paramValues) {
        this.paramValues = paramValues;
    }

    public String getParamUnit() {
        return paramUnit;
    }

    public void setParamUnit(String paramUnit) {
        this.paramUnit = paramUnit;
    }

    public String getParamUnitDetails() {
        return paramUnitDetails;
    }

    public void setParamUnitDetails(String paramUnitDetails) {
        this.paramUnitDetails = paramUnitDetails;
    }
}
