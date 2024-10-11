package com.exp.ucmp.clues.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * <p>@ClassName: CustomerTransferenceDto</p>
 * <p>@Description: </p>
 * <p>@Author: fxy</p>
 * <p>@Date: 2023/7/31 13:34<p>
 */
public class CustomerTransferenceDto {
    @ApiModelProperty(value = "客户ID")
    private Long customerId;

    @ApiModelProperty(value = "门店ID")
    private Long storeId;

    @ApiModelProperty(value = "员工ID")
    private Long partyId;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
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
}
