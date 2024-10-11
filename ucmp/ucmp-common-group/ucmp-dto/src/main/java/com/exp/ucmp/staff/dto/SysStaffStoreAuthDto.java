package com.exp.ucmp.staff.dto;

import com.egrid.core.base.model.BaseModel;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author hailele
 * @date 2022年10月28日
 */
@ApiModel(value = "SysStaffStoreAuthDto", description = "授权门店Dto")
public class SysStaffStoreAuthDto extends BaseModel {

    private static final long serialVersionUID = 1L;


    /**
     * 人员主键id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "人员主键id")
    private Long partyId;


    /**
     * 选中的门店id
     */
    @ApiModelProperty(value = "选中的门店id")
    private String[] selectStoreId;

    /**
     * 选中标记
     */
    @ApiModelProperty(value = "true是选中，false是取消选中")
    private boolean storeFlag;


    public SysStaffStoreAuthDto() {
    }

    public Long getPartyId() {
        return partyId;
    }

    public void setPartyId(Long partyId) {
        this.partyId = partyId;
    }

    public String[] getSelectStoreId() {
        return selectStoreId;
    }

    public void setSelectStoreId(String[] selectStoreId) {
        this.selectStoreId = selectStoreId;
    }

    public boolean isStoreFlag() {
        return storeFlag;
    }

    public void setStoreFlag(boolean storeFlag) {
        this.storeFlag = storeFlag;
    }
}
