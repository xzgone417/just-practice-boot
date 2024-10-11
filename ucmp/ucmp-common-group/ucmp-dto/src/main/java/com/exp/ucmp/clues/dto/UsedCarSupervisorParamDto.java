package com.exp.ucmp.clues.dto;

/**
 * <p>@ClassName: UsedCarSupervisorParamDto</p>
 * <p>@Description: </p>
 * <p>@Author: fxy</p>
 * <p>@Date: 2023/7/25 19:21<p>
 */
public class UsedCarSupervisorParamDto {
    private Long storeId;
    private Long partyId;

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
