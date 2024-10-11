package com.exp.ucmp.staff.dto;

import com.exp.ucmp.PageDto;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author zhouchengwei
 * @date 2022年8月12日
 */
@ApiModel(value = "SysStaffDetailsStatusDto", description = "人员状态修改")
public class SysStaffDetailsStatusDto extends PageDto {

    private static final long serialVersionUID = 1L;
    /**
     * 员工ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "员工ID")
    private Long partyId;




    /**
     * 人员状态:启用01/禁用00
     */
    @ApiModelProperty(value = "人员状态:启用01/禁用00")
    private String staffStatus;









    public SysStaffDetailsStatusDto() {
    }

    public SysStaffDetailsStatusDto(Long partyId) {
        this.partyId = partyId;
    }

    public void setPartyId(Long partyId) {
        this.partyId = partyId;
    }

    public Long getPartyId() {
        return this.partyId;
    }



    public void setStaffStatus(String staffStatus) {
        this.staffStatus = staffStatus;
    }

    public String getStaffStatus() {
        return this.staffStatus;
    }


}
