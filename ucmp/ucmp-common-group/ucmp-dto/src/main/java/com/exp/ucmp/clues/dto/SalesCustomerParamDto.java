package com.exp.ucmp.clues.dto;

import com.exp.ucmp.PageDto;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>@ClassName: SalesCustomerParamDto</p>
 * <p>@Description: </p>
 * <p>@Author: fxy</p>
 * <p>@Date: 2023/7/7 15:59<p>
 */
public class SalesCustomerParamDto extends PageDto {
    @ApiModelProperty("客户ID")
    private Long customerId;
    @ApiModelProperty("角色")
    private String role;
    @ApiModelProperty("员工ID")
    private Long partyId;
    @ApiModelProperty("除店长外其他人线索：01")
    private String otherPartyId;
    @ApiModelProperty("门店ID")
    private Long storeId;
    @ApiModelProperty("客户手机号/客户姓名/意向VIN")
    private String multiField;
    @ApiModelProperty("加密的客户手机号/客户姓名/意向VIN")
    private String encryptionMultiField;
    @ApiModelProperty("客户手机号")
    private String customerPhone;

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

    public Long getPartyId() {
        return partyId;
    }

    public void setPartyId(Long partyId) {
        this.partyId = partyId;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
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

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getOtherPartyId() {
        return otherPartyId;
    }

    public void setOtherPartyId(String otherPartyId) {
        this.otherPartyId = otherPartyId;
    }
}
