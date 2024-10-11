package com.exp.ucmp.replacement.dto;


import com.egrid.core.base.model.BaseModel;
import com.exp.ucmp.entity.RepReplacementMaterialFileEntity;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;


import java.util.Date;
import java.util.List;

@ApiModel(value = "RepReplacementMaterialDto", description = "置换材料信息")
public class RepReplacementMaterialDto extends BaseModel {

    private static final long serialVersionUID = 1L;
    /**
     * 材料ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "材料ID")
    private Long materialId;


    /**
     * 置换ID
     */
    @ApiModelProperty(value = "置换ID")
    private Long replacementId;

    /**
     * 材料类型
     */
   @ApiModelProperty(value = "材料类型")
    private String materialType;

    /**
     * 上传人
     */
    @ApiModelProperty(value = "上传人")
    private Long uploadPerson;

    /**
     * 上传时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "上传时间")
    private Date uploadDate;

    /**
     * 文件材料列表
     */
    @ApiModelProperty(value = "文件材料列表")
    private List<RepReplacementMaterialFileEntity>  repReplacementMaterialFileEntity;

    public RepReplacementMaterialDto() {
    }

    public RepReplacementMaterialDto(Long materialId) {
        this.materialId = materialId;
    }

    public void setMaterialId(Long materialId) {
        this.materialId = materialId;
    }
    public Long getMaterialId() {
        return this.materialId;
    }
    

    public void setReplacementId(Long replacementId) {
        this.replacementId = replacementId;
    }
    public Long getReplacementId() {
        return this.replacementId;
    }
    
    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }
    public String getMaterialType() {
        return this.materialType;
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

    public List<RepReplacementMaterialFileEntity> getRepReplacementMaterialFileEntity() {
        return repReplacementMaterialFileEntity;
    }

    public void setRepReplacementMaterialFileEntity(List<RepReplacementMaterialFileEntity> repReplacementMaterialFileEntity) {
        this.repReplacementMaterialFileEntity = repReplacementMaterialFileEntity;
    }
}
