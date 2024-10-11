package com.exp.ucmp.store.dto;

import com.exp.ucmp.PageDto;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SysPartnerStaffInfoDto", description = "车商人员信息表")
public class SysPartnerStaffInfoDto extends PageDto {

    private static final long serialVersionUID = 1L;

    /**
     * 主键标识
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "主键标识")
    private Long partyId;
    /**
     * 合作商名称
     */
    @ApiModelProperty(value = "合作商名称")
    private String partnerName;
    /**
     * 合作商编码
     */
    @ApiModelProperty(value = "合作商编码")
    private String partnerCode;

    /**
     * 车商指定人姓名
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "车商指定人姓名")
    private String partnerStaffName;


    /**
     * 车上指定人手机
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "车上指定人手机")
    private String partnerStaffIphone;

    /**
     * 性别
     */
    @ApiModelProperty(value = "性别")
    @JsonSerialize(using = ToStringSerializer.class)
    private String partnerStaffSex;


    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱")
    @JsonSerialize(using = ToStringSerializer.class)
    private String partnerStaffEmail;

    /**
     * 是否可用
     */
    @ApiModelProperty(value = "是否可用00、无效，01、有效")
    @JsonSerialize(using = ToStringSerializer.class)
    private String isEnable;


    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    public String getPartnerCode() {
        return partnerCode;
    }

    public void setPartnerCode(String partnerCode) {
        this.partnerCode = partnerCode;
    }

    public SysPartnerStaffInfoDto() {
    }

    public String getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(String isEnable) {
        this.isEnable = isEnable;
    }

    public Long getPartyId() {
        return partyId;
    }

    public void setPartyId(Long partyId) {
        this.partyId = partyId;
    }

    public String getPartnerStaffName() {
        return partnerStaffName;
    }

    public void setPartnerStaffName(String partnerStaffName) {
        this.partnerStaffName = partnerStaffName;
    }

    public String getPartnerStaffIphone() {
        return partnerStaffIphone;
    }

    public void setPartnerStaffIphone(String partnerStaffIphone) {
        this.partnerStaffIphone = partnerStaffIphone;
    }

    public String getPartnerStaffSex() {
        return partnerStaffSex;
    }

    public void setPartnerStaffSex(String partnerStaffSex) {
        this.partnerStaffSex = partnerStaffSex;
    }

    public String getPartnerStaffEmail() {
        return partnerStaffEmail;
    }

    public void setPartnerStaffEmail(String partnerStaffEmail) {
        this.partnerStaffEmail = partnerStaffEmail;
    }
}

