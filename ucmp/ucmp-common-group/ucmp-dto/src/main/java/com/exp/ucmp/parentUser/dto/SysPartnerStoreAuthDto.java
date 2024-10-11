package com.exp.ucmp.parentUser.dto;

import com.egrid.core.base.model.BaseModel;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author hailele
 * @date 2022年10月28日
 */
@ApiModel(value = "SysPartnerStoreAuthDto", description = "合作商门店授权Dto")
public class SysPartnerStoreAuthDto extends BaseModel {

    private static final long serialVersionUID = 1L;


    /**
     * 合作商主键id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "合作商主键id")
    private Long partnerId;


    /**
     * 选中的门店id
     */
    @ApiModelProperty(value = "选中的门店id")
    private Long selectStoreId;

    /**
     * 选中标记
     */
    @ApiModelProperty(value = "true是选中，false是取消选中")
    private boolean storeFlag;


    public SysPartnerStoreAuthDto() {
    }

    public Long getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(Long partnerId) {
        this.partnerId = partnerId;
    }

    public Long getSelectStoreId() {
        return selectStoreId;
    }

    public void setSelectStoreId(Long selectStoreId) {
        this.selectStoreId = selectStoreId;
    }

    public boolean isStoreFlag() {
        return storeFlag;
    }

    public void setStoreFlag(boolean storeFlag) {
        this.storeFlag = storeFlag;
    }
}
