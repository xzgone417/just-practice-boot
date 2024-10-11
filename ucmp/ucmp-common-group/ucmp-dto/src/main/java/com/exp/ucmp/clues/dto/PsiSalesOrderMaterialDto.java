package com.exp.ucmp.clues.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * <p>@ClassName: Pso</p>
 * <p>@Description: </p>
 * <p>@Author: fxy</p>
 * <p>@Date: 2023/6/27 19:08<p>
 */
public class PsiSalesOrderMaterialDto {
    @ApiModelProperty("材料ID")
    private Long materialId;
    @ApiModelProperty(value = "材料文件id")
    private String materialFileId;
    @ApiModelProperty("次序")
    private Integer materialOrder;
    @ApiModelProperty("缩略图")
    private String thumbnail;
    @ApiModelProperty("材料类型")
    private String materialType;
    @ApiModelProperty("材料类型名称")
    private String materialTypeName;
    @ApiModelProperty("文件链接")
    private String fileUrl;

    public Long getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Long materialId) {
        this.materialId = materialId;
    }

    public String getMaterialFileId() {
        return materialFileId;
    }

    public void setMaterialFileId(String materialFileId) {
        this.materialFileId = materialFileId;
    }

    public Integer getMaterialOrder() {
        return materialOrder;
    }

    public void setMaterialOrder(Integer materialOrder) {
        this.materialOrder = materialOrder;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

    public String getMaterialTypeName() {
        return materialTypeName;
    }

    public void setMaterialTypeName(String materialTypeName) {
        this.materialTypeName = materialTypeName;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }
}
