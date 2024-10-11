package com.exp.ucmp.entity;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Digits;
import javax.validation.GroupSequence;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import com.egrid.core.base.entity.AbstractBaseEntity;
import com.egrid.core.base.id.RandomIDGennerator;

@ApiModel(value = "PsiAcquisitionMaterialFileEntity", description = "收购材料文件表")
@GroupSequence({PsiAcquisitionMaterialFileEntity.class, PsiAcquisitionMaterialFileEntity.PsiAcquisitionMaterialFileEntityValidGroup.class,PsiAcquisitionMaterialFileEntity.MaterialFileIdValidGroup.class,PsiAcquisitionMaterialFileEntity.MaterialIdValidGroup.class,PsiAcquisitionMaterialFileEntity.MaterialOrderValidGroup.class,PsiAcquisitionMaterialFileEntity.UploadPersonValidGroup.class,PsiAcquisitionMaterialFileEntity.UploadDateValidGroup.class,PsiAcquisitionMaterialFileEntity.ThumbnailValidGroup.class}) 
public class PsiAcquisitionMaterialFileEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 材料文件ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "材料文件ID 不能是Null", groups = {PsiAcquisitionMaterialFileEntityValidGroup.class, MaterialFileIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="材料文件ID 数字精度必须符合(19,0)", groups = {PsiAcquisitionMaterialFileEntityValidGroup.class, MaterialFileIdValidGroup.class})
    @ApiModelProperty(value = "材料文件ID")
    private Long materialFileId;
    
    
    /**
     * 材料ID
     */
    @NotNull(message = "材料ID 不能是Null", groups = {PsiAcquisitionMaterialFileEntityValidGroup.class, MaterialIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="材料ID 数字精度必须符合(19,0)", groups = {PsiAcquisitionMaterialFileEntityValidGroup.class, MaterialIdValidGroup.class})
    @ApiModelProperty(value = "材料ID")
    private Long materialId;
    
    /**
     * 次序
     */
    @NotNull(message = "次序 不能是Null", groups = {PsiAcquisitionMaterialFileEntityValidGroup.class, MaterialOrderValidGroup.class})
    @Digits(integer=10, fraction=0, message="次序 数字精度必须符合(10,0)", groups = {PsiAcquisitionMaterialFileEntityValidGroup.class, MaterialOrderValidGroup.class})
    @ApiModelProperty(value = "次序")
    private Integer materialOrder;
    
    /**
     * 上传人
     */
    @NotNull(message = "上传人 不能是Null", groups = {PsiAcquisitionMaterialFileEntityValidGroup.class, UploadPersonValidGroup.class})
    @Digits(integer=19, fraction=0, message="上传人 数字精度必须符合(19,0)", groups = {PsiAcquisitionMaterialFileEntityValidGroup.class, UploadPersonValidGroup.class})
    @ApiModelProperty(value = "上传人")
    private Long uploadPerson;
    
    /**
     * 上传时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "上传时间 不能是Null", groups = {PsiAcquisitionMaterialFileEntityValidGroup.class, UploadDateValidGroup.class})
    @ApiModelProperty(value = "上传时间")
    private Date uploadDate;
    
    /**
     * 缩略图
     */
    @NotNull(message = "缩略图 不能是Null", groups = {PsiAcquisitionMaterialFileEntityValidGroup.class, ThumbnailValidGroup.class})
    @ApiModelProperty(value = "缩略图")
    private String thumbnail;
    
    public PsiAcquisitionMaterialFileEntity() {
    }
    
    public PsiAcquisitionMaterialFileEntity(Long materialFileId) {
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
    
    public void setMaterialOrder(Integer materialOrder) {
        this.materialOrder = materialOrder;
    }
    public Integer getMaterialOrder() {
        return this.materialOrder;
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
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (materialFileId == null)
           
               ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
                materialFileId = RandomIDGennerator.get().generate();
    }

    public interface PsiAcquisitionMaterialFileEntityValidGroup {}
    public interface MaterialFileIdValidGroup {}
    public interface MaterialIdValidGroup {}
    public interface MaterialOrderValidGroup {}
    public interface UploadPersonValidGroup {}
    public interface UploadDateValidGroup {}
    public interface ThumbnailValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            MaterialFileIdValidGroup.class
            , MaterialIdValidGroup.class
            , MaterialOrderValidGroup.class
            , UploadPersonValidGroup.class
            , UploadDateValidGroup.class
            , ThumbnailValidGroup.class
        };
    }
}
