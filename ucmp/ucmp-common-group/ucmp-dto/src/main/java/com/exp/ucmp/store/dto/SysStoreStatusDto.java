package com.exp.ucmp.store.dto;

import com.egrid.core.base.model.BaseModel;
import com.exp.ucmp.PageDto;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(value = "SysStoreStatusDto", description = "门店状态信息")
public class SysStoreStatusDto extends BaseModel {

    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "门店id")
    private Long storeId;

    @ApiModelProperty(value = "门店id集合")
    private List<Long> storeIds;

    @ApiModelProperty(value = "门店代码")
    private String storeCode;

    /**
     * 门店状态：启用1/禁用0（当前门店是否能在APP端可见）
     */
    @ApiModelProperty(value = "门店状态：启用1/禁用0（当前门店是否能在APP端可见）")
    private String isEnable;

    /**
     * 官二资质状态（启用01/禁用00）
     */
    @ApiModelProperty(value = "官二资质状态（启用01/禁用00）")
    private String qualificationStatus;

    /**
     * 是否被删除：00、删除，01、未删除
     */
    @ApiModelProperty(value = "是否被删除：00、删除，01、未删除")
    private String isDelete;



    public SysStoreStatusDto() {
    }


    

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }
    public String getStoreCode() {
        return this.storeCode;
    }

    public List<Long> getStoreIds() {
        return storeIds;
    }

    public void setStoreIds(List<Long> storeIds) {
        this.storeIds = storeIds;
    }

    public String getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(String isEnable) {
        this.isEnable = isEnable;
    }

    public String getQualificationStatus() {
        return qualificationStatus;
    }

    public void getQualificationStatus(String qualificationStatus) {
        this.qualificationStatus = qualificationStatus;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }
    public String getIsDelete() {
        return this.isDelete;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }
}
