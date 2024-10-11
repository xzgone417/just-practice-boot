package com.exp.ucmp.carDealer.dto;

import com.egrid.core.base.model.BaseModel;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author GeYiJiang
 * @Description:
 * @date 2022/10/21 10:42
 */
@ApiModel(value = "BatchDeleteFileDto", description = "文件删除条件")
public class BatchDeleteFileDto extends BaseModel {

    private static final long serialVersionUID = -7851259074839030710L;
    /**
     * 材料文件ID
     */
    @ApiModelProperty(value = "材料文件ID")
    @JsonSerialize(using = ToStringSerializer.class)
    private List<Long> materialFileIdList;

    public BatchDeleteFileDto() {
    }

    public BatchDeleteFileDto(List<Long> materialFileIdList) {
        this.materialFileIdList = materialFileIdList;
    }

    /**
     * 获取
     * @return materialFileIdList
     */
    public List<Long> getMaterialFileIdList() {
        return materialFileIdList;
    }

    /**
     * 设置
     * @param materialFileIdList
     */
    public void setMaterialFileIdList(List<Long> materialFileIdList) {
        this.materialFileIdList = materialFileIdList;
    }

    public String toString() {
        return "BatchDeleteFileDto{materialFileIdList = " + materialFileIdList + "}";
    }
}
