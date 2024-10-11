package com.exp.ucmp.store.dto;

import com.egrid.core.base.model.BaseModel;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>@ClassName: SysStoreStaffQualificationStatusDto</p>
 * <p>@Description: </p>
 * <p>@Author: fxy</p>
 * <p>@Date: 2023/6/19 13:35<p>
 */
@ApiModel(value = "SysStoreStaffQualificationStatusDto", description = "门店员工官二资质状态信息")
public class SysStoreStaffQualificationStatusDto extends BaseModel {

    private static final long serialVersionUID = 1L;

    /**
     * 当事人标识
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "当事人标识")
    private Long partyId;

    /**
     * 官二资质状态（启用01/禁用00）
     */
    @ApiModelProperty(value = "官二资质状态（启用01/禁用00）")
    private String qualificationStatus;


    public Long getPartyId() {
        return partyId;
    }

    public void setPartyId(Long partyId) {
        this.partyId = partyId;
    }

    public String getQualificationStatus() {
        return qualificationStatus;
    }

    public void getQualificationStatus(String qualificationStatus) {
        this.qualificationStatus = qualificationStatus;
    }
}
