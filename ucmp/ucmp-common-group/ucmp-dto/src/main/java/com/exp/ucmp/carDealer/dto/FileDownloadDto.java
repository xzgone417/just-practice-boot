package com.exp.ucmp.carDealer.dto;

import com.egrid.core.base.model.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author GeYiJiang
 * @Description:
 * @date 2022/10/26 10:09
 */
@ApiModel(value = "FileDownloadDto", description = "文件下在参数")
public class FileDownloadDto extends BaseModel {

    private static final long serialVersionUID = -4830454347855862614L;
    @ApiModelProperty(value = "文件id",required = true)
    private String objKey;

    public FileDownloadDto() {
    }

    public FileDownloadDto(String objKey) {
        this.objKey = objKey;
    }

    /**
     * 获取
     * @return objKey
     */
    public String getObjKey() {
        return objKey;
    }

    /**
     * 设置
     * @param objKey
     */
    public void setObjKey(String objKey) {
        this.objKey = objKey;
    }

    public String toString() {
        return "FileDownloadDto{objKey = " + objKey + "}";
    }
}
