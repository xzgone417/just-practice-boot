package com.exp.ucmp.clues.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>@ClassName: salesConsultantDto</p>
 * <p>@Description: </p>
 * <p>@Author: fxy</p>
 * <p>@Date: 2023/7/21 15:06<p>
 */
public class SalesConsultantDto {
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty("门店ID")
    private Long storeId;
    @ApiModelProperty("门店名称")
    private String storeName;
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty("人员标识")
    private Long partyId;
    @ApiModelProperty("人员编号")
    private String staffCode;
    @ApiModelProperty("人员姓名")
    private String staffName;
    @ApiModelProperty("人员手机号")
    private String staffIphone;
    @ApiModelProperty("人员手机号")
    private String encryptionStaffIphone;
    @ApiModelProperty("人员状态:启用00/禁用01")
    private String staffStatus;
    @ApiModelProperty("官二资质状态（启用01/禁用00）")
    private String qualificationStatus;

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Long getPartyId() {
        return partyId;
    }

    public void setPartyId(Long partyId) {
        this.partyId = partyId;
    }

    public String getStaffCode() {
        return staffCode;
    }

    public void setStaffCode(String staffCode) {
        this.staffCode = staffCode;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffIphone() {
        return staffIphone;
    }

    public void setStaffIphone(String staffIphone) {
        this.staffIphone = staffIphone;
    }

    public String getEncryptionStaffIphone() {
        return encryptionStaffIphone;
    }

    public void setEncryptionStaffIphone(String encryptionStaffIphone) {
        this.encryptionStaffIphone = encryptionStaffIphone;
    }

    public String getStaffStatus() {
        return staffStatus;
    }

    public void setStaffStatus(String staffStatus) {
        this.staffStatus = staffStatus;
    }

    public String getQualificationStatus() {
        return qualificationStatus;
    }

    public void setQualificationStatus(String qualificationStatus) {
        this.qualificationStatus = qualificationStatus;
    }
}
