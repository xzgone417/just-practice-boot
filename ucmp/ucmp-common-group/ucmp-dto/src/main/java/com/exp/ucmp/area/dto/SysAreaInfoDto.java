package com.exp.ucmp.area.dto;

import com.egrid.core.base.model.BaseModel;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SysAreaInfoDto", description = "区域信息表")
public class SysAreaInfoDto extends BaseModel {

    private static final long serialVersionUID = 1L;
    /**
     * 区域标识
     */
    @JsonSerialize(using = ToStringSerializer.class)
   @ApiModelProperty(value = "区域标识")
    private Long areaId;


    /**
     * 当事人标识
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "当事人标识")
    private Long partyId;


    /**
     * 区域编码
     */
   @ApiModelProperty(value = "区域编码")
    private String areaCode;

    /**
     * 区域名称
     */
    @ApiModelProperty(value = "区域名称")
    private String areaName;

    public Boolean getStaffAreaFlag() {
        return staffAreaFlag;
    }

    public void setStaffAreaFlag(Boolean staffAreaFlag) {
        this.staffAreaFlag = staffAreaFlag;
    }

    /**
     * 该人员是否存在该区域
     */
    @ApiModelProperty(value = "该人员是否存在该区域")
    private Boolean staffAreaFlag;

    public SysAreaInfoDto() {
    }

    public SysAreaInfoDto(Long areaId) {
        this.areaId = areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }
    public Long getAreaId() {
        return this.areaId;
    }
    

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }
    public String getAreaCode() {
        return this.areaCode;
    }
    
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }
    public String getAreaName() {
        return this.areaName;
    }


    public Long getPartyId() {
        return partyId;
    }

    public void setPartyId(Long partyId) {
        this.partyId = partyId;
    }
}
