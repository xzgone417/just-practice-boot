package com.exp.ucmp.pertner.dto;

import com.egrid.core.base.model.BaseModel;
import com.exp.ucmp.PageDto;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;
import java.util.Map;

@ApiModel(value = "SysAreaRegionDetailsDto", description = "区域省份城市信息")
public class SysAreaRegionDetailsDto extends BaseModel {

    private static final long serialVersionUID = 1L;
    /**
     * 数据集合
     */
    @ApiModelProperty(value = "数据集合")
    private List<Map> dataList;

    /**
     * 数据类型标记(A:区域/P:省份/C:城市)
     */
    @ApiModelProperty(value = "数据类型标记(A:区域/P:省份/C:城市)")
    private String dataTypeFlag;


    /**
     * 数据标识(区域标识/省份标识)
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "数据标识(区域标识/省份标识)")
    private Long dataId;






    public SysAreaRegionDetailsDto() {
    }

    public List<Map> getDataList() {
        return dataList;
    }

    public void setDataList(List<Map> dataList) {
        this.dataList = dataList;
    }

    public String getDataTypeFlag() {
        return dataTypeFlag;
    }

    public void setDataTypeFlag(String dataTypeFlag) {
        this.dataTypeFlag = dataTypeFlag;
    }

    public Long getDataId() {
        return dataId;
    }

    public void setDataId(Long dataId) {
        this.dataId = dataId;
    }
}
