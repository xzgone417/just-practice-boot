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
import javax.validation.constraints.Size;
import java.util.Date;

@ApiModel(value = "SysFileMsgDto", description = "文件信息")
public class SysFileMsgDto extends BaseModel {

    private static final long serialVersionUID = 1L;
    /**
     * 文件ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "文件ID")
    private Long fileId;


    /**
     * 文件类型
     */
    @ApiModelProperty(value = "文件类型")
    private String fileType;

    /**
     * 文件名
     */
    @ApiModelProperty(value = "文件名")
    private String fileName;

    /**
     * 文件路径
     */
    @ApiModelProperty(value = "文件路径")
    private String filePath;

    /**
     * 文件状态：01、使用中，02、未使用，09、已删除
     */
    @ApiModelProperty(value = "文件状态：01、使用中，02、未使用，09、已删除")
    private String fileStatuss;


    private Date updatedDate;

    public SysFileMsgDto() {
    }

    public SysFileMsgDto(Long fileId) {
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
    

}
