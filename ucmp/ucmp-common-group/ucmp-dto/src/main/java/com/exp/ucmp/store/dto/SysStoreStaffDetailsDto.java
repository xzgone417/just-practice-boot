package com.exp.ucmp.store.dto;

import com.exp.ucmp.PageDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@ApiModel(value = "SysStoreStaffDetailsDto", description = "门店人员信息Dto")
public class SysStoreStaffDetailsDto extends PageDto {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("员工ID")
    private Long partyId;

    @ApiModelProperty("人员编号")
    private String staffCode;

    @ApiModelProperty("登录用户名")
    private String loginName;

    @ApiModelProperty("人员姓名")
    private String staffName;

    @ApiModelProperty("人员邮箱")
    private String staffEmail;

    @ApiModelProperty("人员性别")
    private String staffSex;

    @ApiModelProperty("人员手机号")
    private String staffIphone;

    @ApiModelProperty("人员状态:启用01/禁用00")
    private String staffStatus;

    @ApiModelProperty("人员类型(0020门店)")
    private String staffType;



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

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffEmail() {
        return staffEmail;
    }

    public void setStaffEmail(String staffEmail) {
        this.staffEmail = staffEmail;
    }

    public String getStaffSex() {
        return staffSex;
    }

    public void setStaffSex(String staffSex) {
        this.staffSex = staffSex;
    }

    public String getStaffIphone() {
        return staffIphone;
    }

    public void setStaffIphone(String staffIphone) {
        this.staffIphone = staffIphone;
    }

    public String getStaffStatus() {
        return staffStatus;
    }

    public void setStaffStatus(String staffStatus) {
        this.staffStatus = staffStatus;
    }

    public String getStaffType() {
        return staffType;
    }

    public void setStaffType(String staffType) {
        this.staffType = staffType;
    }


    public SysStoreStaffDetailsDto() {
    }

}
