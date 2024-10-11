package com.exp.ucmp.stock.dto;

import com.egrid.core.base.model.BaseModel;
import com.exp.ucmp.entity.PsiCarServiceMaterialFileEntity;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author GeYiJiang
 * @Description:
 * @date 2023/2/10 11:07
 */
@ApiModel(value = "CarServiceFileDto对象", description = "车辆整备图片")
public class CarServiceFileDto extends BaseModel {
    /**
     * 材料ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "材料ID")
    private Long materialId;
    /**
     * 材料类型
     */
    @ApiModelProperty(value = "材料类型")
    private String materialType;

    @ApiModelProperty(value = "材料类型中文")
    private String materialTypeName;

    /**
     * 文件列表
     */
    @ApiModelProperty(value = "文件列表")
    private List<CarServiceFileDetailDto> detailDtos;

    public CarServiceFileDto() {
    }

    public Long getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Long materialId) {
        this.materialId = materialId;
    }

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

    public List<CarServiceFileDetailDto> getDetailDtos() {
        return detailDtos;
    }

    public void setDetailDtos(List<CarServiceFileDetailDto> detailDtos) {
        this.detailDtos = detailDtos;
    }

    public String getMaterialTypeName() {
        return materialTypeName;
    }

    public void setMaterialTypeName(String materialTypeName) {
        this.materialTypeName = materialTypeName;
    }
}
