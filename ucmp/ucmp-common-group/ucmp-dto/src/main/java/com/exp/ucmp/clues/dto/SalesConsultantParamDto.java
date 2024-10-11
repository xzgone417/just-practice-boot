package com.exp.ucmp.clues.dto;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * <p>@ClassName: SalesConsultantParamDto</p>
 * <p>@Description: </p>
 * <p>@Author: fxy</p>
 * <p>@Date: 2023/7/24 14:36<p>
 */
public class SalesConsultantParamDto {
    @ApiModelProperty("搜索，姓名/手机号")
    private String multiField;
    @ApiModelProperty("加密搜索，姓名/手机号")
    private String encryptionMultiField;
    @ApiModelProperty("门店ID")
    private Long storeId;
    @ApiModelProperty("门店ID")
    private List<Long> storeIdList;
    @ApiModelProperty("人员ID")
    private Long partyId;
    @ApiModelProperty("人员ID")
    private List<Long> partyIdList;
    @ApiModelProperty("人员状态:启用01/禁用00")
    private String staffStatus;
    @ApiModelProperty("官二资质状态:启用01/禁用00")
    private String qualificationStatus;
    @ApiModelProperty("角色")
    private String role;
    @ApiModelProperty("角色")
    private List<String> roleList;

    public String getMultiField() {
        return multiField;
    }

    public void setMultiField(String multiField) {
        this.multiField = multiField;
    }

    public String getEncryptionMultiField() {
        return encryptionMultiField;
    }

    public void setEncryptionMultiField(String encryptionMultiField) {
        this.encryptionMultiField = encryptionMultiField;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public List<Long> getStoreIdList() {
        return storeIdList;
    }

    public void setStoreIdList(List<Long> storeIdList) {
        this.storeIdList = storeIdList;
    }

    public Long getPartyId() {
        return partyId;
    }

    public void setPartyId(Long partyId) {
        this.partyId = partyId;
    }

    public List<Long> getPartyIdList() {
        return partyIdList;
    }

    public void setPartyIdList(List<Long> partyIdList) {
        this.partyIdList = partyIdList;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<String> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<String> roleList) {
        this.roleList = roleList;
    }
}
