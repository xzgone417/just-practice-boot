package com.exp.ucmp.entity;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Digits;
import javax.validation.GroupSequence;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import com.egrid.core.base.entity.AbstractBaseEntity;
import com.egrid.core.base.id.RandomIDGennerator;

@ApiModel(value = "SysConfigTopPicEntity", description = "车辆配置亮点顶部图材料文件表")
@GroupSequence({SysConfigTopPicEntity.class, SysConfigTopPicEntity.SysConfigTopPicEntityValidGroup.class,SysConfigTopPicEntity.CarSeriesCodeValidGroup.class,SysConfigTopPicEntity.FileIdValidGroup.class,SysConfigTopPicEntity.UploadPersonValidGroup.class,SysConfigTopPicEntity.UploadDateValidGroup.class}) 
public class SysConfigTopPicEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 工程车型编码
     */
    @NotNull(message = "工程车型编码 不能是Null", groups = {SysConfigTopPicEntityValidGroup.class, CarSeriesCodeValidGroup.class})
    @Size(min=0, max=30, message="工程车型编码 字符长度必须小于等于30", groups = {SysConfigTopPicEntityValidGroup.class, CarSeriesCodeValidGroup.class})
    @ApiModelProperty(value = "工程车型编码")
    private String carSeriesCode;
    
    
    /**
     * 材料ID
     */
    @NotNull(message = "材料ID 不能是Null", groups = {SysConfigTopPicEntityValidGroup.class, FileIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="材料ID 数字精度必须符合(19,0)", groups = {SysConfigTopPicEntityValidGroup.class, FileIdValidGroup.class})
    @ApiModelProperty(value = "材料ID")
    private Long fileId;
    
    /**
     * 上传人
     */
    @NotNull(message = "上传人 不能是Null", groups = {SysConfigTopPicEntityValidGroup.class, UploadPersonValidGroup.class})
    @Digits(integer=19, fraction=0, message="上传人 数字精度必须符合(19,0)", groups = {SysConfigTopPicEntityValidGroup.class, UploadPersonValidGroup.class})
    @ApiModelProperty(value = "上传人")
    private Long uploadPerson;
    
    /**
     * 上传时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "上传时间 不能是Null", groups = {SysConfigTopPicEntityValidGroup.class, UploadDateValidGroup.class})
    @ApiModelProperty(value = "上传时间")
    private Date uploadDate;
    
    /**
     * 缩略图
     */
    @ApiModelProperty(value = "缩略图")
    private String thumbnail;
    
    public SysConfigTopPicEntity() {
    }
    
    public SysConfigTopPicEntity(String carSeriesCode) {
        this.carSeriesCode = carSeriesCode;
    }

    public void setCarSeriesCode(String carSeriesCode) {
        this.carSeriesCode = carSeriesCode;
    }
    public String getCarSeriesCode() {
        return this.carSeriesCode;
    }
    

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }
    public Long getFileId() {
        return this.fileId;
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
              (carSeriesCode == null || carSeriesCode.trim().length() == 0)
           
               ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
                carSeriesCode = null;
    }

    public interface SysConfigTopPicEntityValidGroup {}
    public interface CarSeriesCodeValidGroup {}
    public interface FileIdValidGroup {}
    public interface UploadPersonValidGroup {}
    public interface UploadDateValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            SysConfigTopPicEntity.CarSeriesCodeValidGroup.class
            , SysConfigTopPicEntity.FileIdValidGroup.class
            , SysConfigTopPicEntity.UploadPersonValidGroup.class
            , SysConfigTopPicEntity.UploadDateValidGroup.class
        };
    }
}
