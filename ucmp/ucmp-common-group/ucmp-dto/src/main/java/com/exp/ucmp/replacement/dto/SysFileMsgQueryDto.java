package com.exp.ucmp.replacement.dto;

import com.egrid.core.base.model.BaseModel;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value = "SysFileMsgQueryDto", description = "文件信息查询")
public class SysFileMsgQueryDto extends BaseModel {

    private static final long serialVersionUID = 1L;
    /**
     * 文件ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "文件ID")
    private Long fileId;





    private Date updatedDate;

    public SysFileMsgQueryDto() {
    }

    public SysFileMsgQueryDto(Long fileId) {
        this.fileId = fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }
    public Long getFileId() {
        return this.fileId;
    }
    


    

}
