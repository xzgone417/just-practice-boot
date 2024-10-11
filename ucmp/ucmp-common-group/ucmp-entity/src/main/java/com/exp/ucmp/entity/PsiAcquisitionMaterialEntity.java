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

@ApiModel(value = "PsiAcquisitionMaterialEntity", description = "收购材料表")
@GroupSequence({PsiAcquisitionMaterialEntity.class, PsiAcquisitionMaterialEntity.PsiAcquisitionMaterialEntityValidGroup.class,PsiAcquisitionMaterialEntity.MaterialIdValidGroup.class,PsiAcquisitionMaterialEntity.ReservationIdValidGroup.class,PsiAcquisitionMaterialEntity.MaterialTypeValidGroup.class,PsiAcquisitionMaterialEntity.UploadPersonValidGroup.class,PsiAcquisitionMaterialEntity.UploadDateValidGroup.class}) 
public class PsiAcquisitionMaterialEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 材料ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "材料ID 不能是Null", groups = {PsiAcquisitionMaterialEntityValidGroup.class, MaterialIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="材料ID 数字精度必须符合(19,0)", groups = {PsiAcquisitionMaterialEntityValidGroup.class, MaterialIdValidGroup.class})
    @ApiModelProperty(value = "材料ID")
    private Long materialId;
    
    
    /**
     * 预约ID
     */
    @NotNull(message = "预约ID 不能是Null", groups = {PsiAcquisitionMaterialEntityValidGroup.class, ReservationIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="预约ID 数字精度必须符合(19,0)", groups = {PsiAcquisitionMaterialEntityValidGroup.class, ReservationIdValidGroup.class})
    @ApiModelProperty(value = "预约ID")
    private Long reservationId;
    
    /**
     * 材料类型
     */
    @NotNull(message = "材料类型 不能是Null", groups = {PsiAcquisitionMaterialEntityValidGroup.class, MaterialTypeValidGroup.class})
    @Size(min=0, max=4, message="材料类型 字符长度必须小于等于4", groups = {PsiAcquisitionMaterialEntityValidGroup.class, MaterialTypeValidGroup.class})
    @ApiModelProperty(value = "材料类型")
    private String materialType;
    
    /**
     * 上传人
     */
    @NotNull(message = "上传人 不能是Null", groups = {PsiAcquisitionMaterialEntityValidGroup.class, UploadPersonValidGroup.class})
    @Digits(integer=19, fraction=0, message="上传人 数字精度必须符合(19,0)", groups = {PsiAcquisitionMaterialEntityValidGroup.class, UploadPersonValidGroup.class})
    @ApiModelProperty(value = "上传人")
    private Long uploadPerson;
    
    /**
     * 上传时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "上传时间 不能是Null", groups = {PsiAcquisitionMaterialEntityValidGroup.class, UploadDateValidGroup.class})
    @ApiModelProperty(value = "上传时间")
    private Date uploadDate;
    
    public PsiAcquisitionMaterialEntity() {
    }
    
    public PsiAcquisitionMaterialEntity(Long materialId) {
        this.materialId = materialId;
    }

    public void setMaterialId(Long materialId) {
        this.materialId = materialId;
    }
    public Long getMaterialId() {
        return this.materialId;
    }
    

    public void setReservationId(Long reservationId) {
        this.reservationId = reservationId;
    }
    public Long getReservationId() {
        return this.reservationId;
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

    public interface PsiAcquisitionMaterialEntityValidGroup {}
    public interface MaterialIdValidGroup {}
    public interface ReservationIdValidGroup {}
    public interface MaterialTypeValidGroup {}
    public interface UploadPersonValidGroup {}
    public interface UploadDateValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            PsiAcquisitionMaterialEntity.MaterialIdValidGroup.class
            , PsiAcquisitionMaterialEntity.ReservationIdValidGroup.class
            , PsiAcquisitionMaterialEntity.MaterialTypeValidGroup.class
            , PsiAcquisitionMaterialEntity.UploadPersonValidGroup.class
            , PsiAcquisitionMaterialEntity.UploadDateValidGroup.class
        };
    }
}
