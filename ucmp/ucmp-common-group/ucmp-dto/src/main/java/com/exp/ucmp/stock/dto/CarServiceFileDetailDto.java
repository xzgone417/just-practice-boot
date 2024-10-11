package com.exp.ucmp.stock.dto;

import com.egrid.core.base.model.BaseModel;
import com.exp.ucmp.entity.PsiCarServiceMaterialFileEntity;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

/**
 * @author GeYiJiang
 * @Description:
 * @date 2023/2/10 11:07
 */
@ApiModel(value = "CarServiceFileDetailDto对象", description = "车辆整备图片详情")
public class CarServiceFileDetailDto extends BaseModel {

    @ApiModelProperty(value = "业务id(查大图传)")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long materialFileId;

    @ApiModelProperty(value = "材料文件类型(方向盘/仪表盘)")
    private String materialFileType;

    @ApiModelProperty(value = "材料文件类型(中文)")
    private String materialFileTypeName;

    @ApiModelProperty(value = "排序")
    private Byte fileSort;

    @ApiModelProperty(value = "驳回原因")
    private String rejectReason;

    @ApiModelProperty(value = "中文描述")
    private String chineseDescription;

    @ApiModelProperty(value = "缩略图")
    private String thumbnail;

    @ApiModelProperty(value = "文件路径")
    private String fileUrl;

    public String getMaterialFileTypeName() {
        return materialFileTypeName;
    }

    public void setMaterialFileTypeName(String materialFileTypeName) {
        this.materialFileTypeName = materialFileTypeName;
    }

    public String getMaterialFileType() {
        return materialFileType;
    }

    public void setMaterialFileType(String materialFileType) {
        this.materialFileType = materialFileType;
    }

    public Byte getFileSort() {
        return fileSort;
    }

    public void setFileSort(Byte fileSort) {
        this.fileSort = fileSort;
    }

    public String getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason;
    }

    public String getChineseDescription() {
        return chineseDescription;
    }

    public void setChineseDescription(String chineseDescription) {
        this.chineseDescription = chineseDescription;
    }

    public Long getMaterialFileId() {
        return materialFileId;
    }

    public void setMaterialFileId(Long materialFileId) {
        this.materialFileId = materialFileId;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }
}
