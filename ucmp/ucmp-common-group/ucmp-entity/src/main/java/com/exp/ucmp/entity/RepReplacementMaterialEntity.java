package com.exp.ucmp.entity;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;
import javax.validation.GroupSequence;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import com.egrid.core.base.entity.AbstractBaseEntity;
import com.egrid.core.base.id.RandomIDGennerator;

@ApiModel(value = "RepReplacementMaterialEntity", description = "置换材料表")
@GroupSequence({RepReplacementMaterialEntity.class, RepReplacementMaterialEntity.RepReplacementMaterialEntityValidGroup.class,RepReplacementMaterialEntity.MaterialIdValidGroup.class,RepReplacementMaterialEntity.ReplacementIdValidGroup.class,RepReplacementMaterialEntity.MaterialTypeValidGroup.class,RepReplacementMaterialEntity.UploadPersonValidGroup.class,RepReplacementMaterialEntity.UploadDateValidGroup.class}) 
public class RepReplacementMaterialEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 材料ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "材料ID 不能是Null", groups = {RepReplacementMaterialEntityValidGroup.class, MaterialIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="材料ID 数字精度必须符合(19,0)", groups = {RepReplacementMaterialEntityValidGroup.class, MaterialIdValidGroup.class})
    @ApiModelProperty(value = "材料ID")
    private Long materialId;
    
    
    /**
     * 置换ID
     */
    @NotNull(message = "置换ID 不能是Null", groups = {RepReplacementMaterialEntityValidGroup.class, ReplacementIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="置换ID 数字精度必须符合(19,0)", groups = {RepReplacementMaterialEntityValidGroup.class, ReplacementIdValidGroup.class})
    @ApiModelProperty(value = "置换ID")
    private Long replacementId;
    
    /**
     * 材料类型
     */
    @NotNull(message = "材料类型 不能是Null", groups = {RepReplacementMaterialEntityValidGroup.class, MaterialTypeValidGroup.class})
    @Size(min=0, max=4, message="材料类型 字符长度必须小于等于4", groups = {RepReplacementMaterialEntityValidGroup.class, MaterialTypeValidGroup.class})
    @ApiModelProperty(value = "材料类型")
    private String materialType;
    
    /**
     * 上传人
     */
    @NotNull(message = "上传人 不能是Null", groups = {RepReplacementMaterialEntityValidGroup.class, UploadPersonValidGroup.class})
    @Digits(integer=19, fraction=0, message="上传人 数字精度必须符合(19,0)", groups = {RepReplacementMaterialEntityValidGroup.class, UploadPersonValidGroup.class})
    @ApiModelProperty(value = "上传人")
    private Long uploadPerson;
    
    /**
     * 上传时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "上传时间 不能是Null", groups = {RepReplacementMaterialEntityValidGroup.class, UploadDateValidGroup.class})
    @ApiModelProperty(value = "上传时间")
    private Date uploadDate;
    
    public RepReplacementMaterialEntity() {
    }
    
    public RepReplacementMaterialEntity(Long materialId) {
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
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (materialId == null)
           
               ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
                materialId = RandomIDGennerator.get().generate();
    }

    public interface RepReplacementMaterialEntityValidGroup {}
    public interface MaterialIdValidGroup {}
    public interface ReplacementIdValidGroup {}
    public interface MaterialTypeValidGroup {}
    public interface UploadPersonValidGroup {}
    public interface UploadDateValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            MaterialIdValidGroup.class
            , ReplacementIdValidGroup.class
            , MaterialTypeValidGroup.class
            , UploadPersonValidGroup.class
            , UploadDateValidGroup.class
        };
    }
}
