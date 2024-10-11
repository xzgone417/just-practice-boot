package com.exp.ucmp.staff.dto;

import com.egrid.core.base.model.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SysStaffStatusEditDto", description = "人员状态编辑Dto")
public class SysStaffStatusEditDto extends BaseModel {

    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "员工id")
    private Long partyId;

    /**
     * 人员状态:启用01/禁用00
     */
    @ApiModelProperty(value = "人员类型(0010总部,0020门店,0030车商.....)")
    private String staffType;


    /**
     * 人员状态:启用01/禁用00
     */
    @ApiModelProperty(value = "人员状态:启用01/禁用00")
    private String isEnable;



    public SysStaffStatusEditDto() {
    }


    public Long getPartyId() {
        return partyId;
    }

    public void setPartyId(Long partyId) {
        this.partyId = partyId;
    }

    public String getStaffType() {
        return staffType;
    }

    public void setStaffType(String staffType) {
        this.staffType = staffType;
    }

    public String getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(String isEnable) {
        this.isEnable = isEnable;
    }
}
