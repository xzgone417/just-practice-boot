package com.exp.ucmp.clues.dto;

/**
 * <p>@ClassName: UsedCarSupervisorDto</p>
 * <p>@Description: </p>
 * <p>@Author: fxy</p>
 * <p>@Date: 2023/7/25 19:21<p>
 */
public class UsedCarSupervisorDto {
    private Long storeId;
    private Long partyId;
    private String staffName;
    private String staffIphone;

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
}
