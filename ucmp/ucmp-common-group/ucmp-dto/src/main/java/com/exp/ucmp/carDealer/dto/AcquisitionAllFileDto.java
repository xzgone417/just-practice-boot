package com.exp.ucmp.carDealer.dto;

import com.egrid.core.base.model.BaseModel;
import com.exp.ucmp.entity.PsiAcquisitionMaterialFileEntity;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author GeYiJiang
 * @Description:
 * @date 2022/10/19 14:14
 */
public class AcquisitionAllFileDto extends BaseModel {

    private static final long serialVersionUID = -3713422215823573795L;
    /**
     * 材料ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "材料ID")
    private Long materialId;


    /**
     * 预约ID
     */
    @ApiModelProperty(value = "预约ID")
    private Long reservationId;

    /**
     * 材料类型
     */
    @ApiModelProperty(value = "材料类型")
    private String materialType;

    /**
     * 文件列表
     */
    @ApiModelProperty(value = "文件列表")
    private List<PsiAcquisitionMaterialFileEntity> materialFileEntityList;

    public AcquisitionAllFileDto() {
    }

    public AcquisitionAllFileDto(Long materialId, Long reservationId, String materialType, List<PsiAcquisitionMaterialFileEntity> materialFileEntityList) {
        this.materialId = materialId;
        this.reservationId = reservationId;
        this.materialType = materialType;
        this.materialFileEntityList = materialFileEntityList;
    }

    /**
     * 获取
     * @return materialId
     */
    public Long getMaterialId() {
        return materialId;
    }

    /**
     * 设置
     * @param materialId
     */
    public void setMaterialId(Long materialId) {
        this.materialId = materialId;
    }

    /**
     * 获取
     * @return reservationId
     */
    public Long getReservationId() {
        return reservationId;
    }

    /**
     * 设置
     * @param reservationId
     */
    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }

    /**
     * 获取
     * @return materialType
     */
    public String getMaterialType() {
        return materialType;
    }

    /**
     * 设置
     * @param materialType
     */
    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

    /**
     * 获取
     * @return materialFileEntityList
     */
    public List<PsiAcquisitionMaterialFileEntity> getMaterialFileEntityList() {
        return materialFileEntityList;
    }

    /**
     * 设置
     * @param materialFileEntityList
     */
    public void setMaterialFileEntityList(List<PsiAcquisitionMaterialFileEntity> materialFileEntityList) {
        this.materialFileEntityList = materialFileEntityList;
    }

    public String toString() {
        return "AcquisitionAllFileDto{materialId = " + materialId + ", reservationId = " + reservationId + ", materialType = " + materialType + ", materialFileEntityList = " + materialFileEntityList + "}";
    }
}
