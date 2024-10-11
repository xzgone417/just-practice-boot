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

@ApiModel(value = "SysFileMsgEntity", description = "文件信息表")
@GroupSequence({SysFileMsgEntity.class, SysFileMsgEntity.SysFileMsgEntityValidGroup.class,SysFileMsgEntity.FileIdValidGroup.class,SysFileMsgEntity.FileTypeValidGroup.class,SysFileMsgEntity.FileNameValidGroup.class,SysFileMsgEntity.FilePathValidGroup.class,SysFileMsgEntity.FileStatussValidGroup.class,SysFileMsgEntity.CreatedByValidGroup.class,SysFileMsgEntity.CreatedDateValidGroup.class,SysFileMsgEntity.UpdatedByValidGroup.class,SysFileMsgEntity.UpdatedDateValidGroup.class}) 
public class SysFileMsgEntity extends AbstractBaseEntity {

    private static final long serialVersionUID = 1L;
    /**
     * 文件ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @NotNull(message = "文件ID 不能是Null", groups = {SysFileMsgEntityValidGroup.class, FileIdValidGroup.class})
    @Digits(integer=19, fraction=0, message="文件ID 数字精度必须符合(19,0)", groups = {SysFileMsgEntityValidGroup.class, FileIdValidGroup.class})
    @ApiModelProperty(value = "文件ID")
    private Long fileId;
    
    
    /**
     * 文件类型
     */
    @Size(min=0, max=20, message="文件类型 字符长度必须小于等于20", groups = {SysFileMsgEntityValidGroup.class, FileTypeValidGroup.class})
    @ApiModelProperty(value = "文件类型")
    private String fileType;
    
    /**
     * 文件名
     */
    @Size(min=0, max=200, message="文件名 字符长度必须小于等于200", groups = {SysFileMsgEntityValidGroup.class, FileNameValidGroup.class})
    @ApiModelProperty(value = "文件名")
    private String fileName;
    
    /**
     * 文件路径
     */
    @NotNull(message = "文件路径 不能是Null", groups = {SysFileMsgEntityValidGroup.class, FilePathValidGroup.class})
    @Size(min=0, max=200, message="文件路径 字符长度必须小于等于200", groups = {SysFileMsgEntityValidGroup.class, FilePathValidGroup.class})
    @ApiModelProperty(value = "文件路径")
    private String filePath;
    
    /**
     * 文件状态：01、使用中，02、未使用，09、已删除
     */
    @Size(min=0, max=4, message="文件状态：01、使用中，02、未使用，09、已删除 字符长度必须小于等于4", groups = {SysFileMsgEntityValidGroup.class, FileStatussValidGroup.class})
    @ApiModelProperty(value = "文件状态：01、使用中，02、未使用，09、已删除")
    private String fileStatuss;
    
    /**
     * 创建人ID
     */
    @NotNull(message = "创建人ID 不能是Null", groups = {SysFileMsgEntityValidGroup.class, CreatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="创建人ID 数字精度必须符合(19,0)", groups = {SysFileMsgEntityValidGroup.class, CreatedByValidGroup.class})
    @ApiModelProperty(value = "创建人ID")
    private Long createdBy;
    
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "创建时间 不能是Null", groups = {SysFileMsgEntityValidGroup.class, CreatedDateValidGroup.class})
    @ApiModelProperty(value = "创建时间")
    private Date createdDate;
    
    /**
     * 更新人ID
     */
    @NotNull(message = "更新人ID 不能是Null", groups = {SysFileMsgEntityValidGroup.class, UpdatedByValidGroup.class})
    @Digits(integer=19, fraction=0, message="更新人ID 数字精度必须符合(19,0)", groups = {SysFileMsgEntityValidGroup.class, UpdatedByValidGroup.class})
    @ApiModelProperty(value = "更新人ID")
    private Long updatedBy;
    
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "更新时间 不能是Null", groups = {SysFileMsgEntityValidGroup.class, UpdatedDateValidGroup.class})
    @ApiModelProperty(value = "更新时间")
    private Date updatedDate;
    
    public SysFileMsgEntity() {
    }
    
    public SysFileMsgEntity(Long fileId) {
        this.fileId = fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }
    public Long getFileId() {
        return this.fileId;
    }
    

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
    public String getFileType() {
        return this.fileType;
    }
    
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public String getFileName() {
        return this.fileName;
    }
    
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
    public String getFilePath() {
        return this.filePath;
    }
    
    public void setFileStatuss(String fileStatuss) {
        this.fileStatuss = fileStatuss;
    }
    public String getFileStatuss() {
        return this.fileStatuss;
    }
    
    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }
    public Long getCreatedBy() {
        return this.createdBy;
    }
    
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    public Date getCreatedDate() {
        return this.createdDate;
    }
    
    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }
    public Long getUpdatedBy() {
        return this.updatedBy;
    }
    
    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
    public Date getUpdatedDate() {
        return this.updatedDate;
    }
    
    /**
     * <p>Description: 主键是否为空</p>
     */
    @Override
    public boolean isEmptyPk() {
        return
              (fileId == null)
           
               ? true : false;
    }
    /**
     * <p>Description: 自动生成主键</p>
     */
    @Override
    public void generatePk() {
                fileId = RandomIDGennerator.get().generate();
    }

    public interface SysFileMsgEntityValidGroup {}
    public interface FileIdValidGroup {}
    public interface FileTypeValidGroup {}
    public interface FileNameValidGroup {}
    public interface FilePathValidGroup {}
    public interface FileStatussValidGroup {}
    public interface CreatedByValidGroup {}
    public interface CreatedDateValidGroup {}
    public interface UpdatedByValidGroup {}
    public interface UpdatedDateValidGroup {}

    @Override
    protected Class<?>[] validGroups() {
        return new Class[] {
            FileIdValidGroup.class
            , FileTypeValidGroup.class
            , FileNameValidGroup.class
            , FilePathValidGroup.class
            , FileStatussValidGroup.class
            , CreatedByValidGroup.class
            , CreatedDateValidGroup.class
            , UpdatedByValidGroup.class
            , UpdatedDateValidGroup.class
        };
    }
}
