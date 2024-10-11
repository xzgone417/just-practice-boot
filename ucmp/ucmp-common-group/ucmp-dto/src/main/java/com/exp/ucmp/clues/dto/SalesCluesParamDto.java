package com.exp.ucmp.clues.dto;

import com.exp.ucmp.PageDto;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(value = "SalesCluesParamDto", description = "官二销售线索列表查询参数")
public class SalesCluesParamDto extends PageDto {
    @ApiModelProperty(value = "客户ID")
    private Long customerId;

    @ApiModelProperty(value = "角色")
    private String role;

    @ApiModelProperty(value = "门店ID")
    private Long storeId;

    @ApiModelProperty(value = "员工ID")
    private Long partyId;

    @ApiModelProperty(value = "员工ID（01:为空）")
    private String emptyFollowPerson;

    @ApiModelProperty("除店长外其他人线索：01")
    private String otherPartyId;

    @ApiModelProperty("客户手机号/客户姓名/意向VIN")
    private String multiField;

    @ApiModelProperty("加密的客户手机号/客户姓名/意向VIN")
    private String encryptionMultiField;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Long getPartyId() {
        return partyId;
    }

    public void setPartyId(Long partyId) {
        this.partyId = partyId;
    }

    public String getEmptyFollowPerson() {
        return emptyFollowPerson;
    }

    public void setEmptyFollowPerson(String emptyFollowPerson) {
        this.emptyFollowPerson = emptyFollowPerson;
    }

    public String getOtherPartyId() {
        return otherPartyId;
    }

    public void setOtherPartyId(String otherPartyId) {
        this.otherPartyId = otherPartyId;
    }

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
}
