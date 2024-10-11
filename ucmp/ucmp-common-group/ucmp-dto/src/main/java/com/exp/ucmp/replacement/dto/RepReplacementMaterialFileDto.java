package com.exp.ucmp.replacement.dto;

import com.egrid.core.base.entity.AbstractBaseEntity;
import com.egrid.core.base.id.RandomIDGennerator;
import com.egrid.core.base.model.BaseModel;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.GroupSequence;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@ApiModel(value = "RepReplacementMaterialFileDto", description = "置换材料文件信息")
public class RepReplacementMaterialFileDto extends BaseModel {

    private static final long serialVersionUID = 1L;
    /**
     * 材料文件ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "材料文件ID")
    private Long materialFileId;


    /**
     * 材料ID
     */
    @ApiModelProperty(value = "材料ID")
    private Long materialId;

    /**
     * 次序
     */
    @ApiModelProperty(value = "次序")
    private Integer order;

    /**
     * 上传人
     */
    @ApiModelProperty(value = "上传人")
    private Long uploadPerson;

    /**
     * 上传时间
     */
    @ApiModelProperty(value = "上传时间")
    private Date uploadDate;

    /**
     * 缩略图
     */
    @ApiModelProperty(value = "缩略图")
    private String thumbnail;




    public RepReplacementMaterialFileDto() {
    }

    public RepReplacementMaterialFileDto(Long materialFileId) {
        this.materialFileId = materialFileId;
    }

    public void setMaterialFileId(Long materialFileId) {
        this.materialFileId = materialFileId;
    }
    public Long getMaterialFileId() {
        return this.materialFileId;
    }
    

    public void setMaterialId(Long materialId) {
        this.materialId = materialId;
    }
    public Long getMaterialId() {
        return this.materialId;
    }
    
    public void setOrder(Integer order) {
        this.order = order;
    }
    public Integer getOrder() {
        return this.order;
    }
    
    public void setUploadPerson(Long uploadPerson) {
        this.uploadPerson = uploadPerson;
    }
    public Long getUploadPerson() {
        return this.uploadPerson;
    }
    
    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }
    public Date getUploadDate() {
        return this.uploadDate;
    }
    
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
    public String getThumbnail() {
        return this.thumbnail;
    }
    

}
