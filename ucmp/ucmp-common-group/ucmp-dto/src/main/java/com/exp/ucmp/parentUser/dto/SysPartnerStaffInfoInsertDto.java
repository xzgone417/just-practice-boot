package com.exp.ucmp.parentUser.dto;

import com.exp.ucmp.PageDto;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author hailele
 * @date 2022年10月30日
 */
@ApiModel(value = "SysPartnerStaffInfoInsertDto", description = "合作商人员新增Dto")
public class SysPartnerStaffInfoInsertDto extends PageDto {

    private static final long serialVersionUID = 1L;
    /**
     * 员工ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "员工ID")
    private Long partyId;

    /**
     * 合作商id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "主键/合作商标识")
    private Long partnerId;

    /**
     * 人员编号
     */
    @ApiModelProperty(value = "人员编号")
    private String staffCode;

    /**
     * 人员姓名
     */
    @ApiModelProperty(value = "人员姓名")
    private String staffName;

    /**
     * 人员手机号
     */
    @ApiModelProperty(value = "人员手机号")
    private String staffIphone;


    /**
     * 人员邮箱
     */
    @ApiModelProperty(value = "人员邮箱")
    private String staffEmail;

    /**
     * 人员状态:启用00/禁用01
     */
    @ApiModelProperty(value = "人员状态:启用00/禁用01")
    private String staffStatus;

    /**
     * 人员性别
     */
    @ApiModelProperty(value = "人员性别")
    private String staffSex;



    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "选择的门店id数组")
    private String[] storeIds;

    public SysPartnerStaffInfoInsertDto() {
    }

    public SysPartnerStaffInfoInsertDto(Long partyId) {
        this.partyId = partyId;
    }

    public void setPartyId(Long partyId) {
        this.partyId = partyId;
    }

    public Long getPartyId() {
        return this.partyId;
    }

    public void setStaffCode(String staffCode) {
        this.staffCode = staffCode;
    }

    public String getStaffCode() {
        return this.staffCode;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffName() {
        return this.staffName;
    }

    public void setStaffIphone(String staffIphone) {
        this.staffIphone = staffIphone;
    }

    public String getStaffIphone() {
        return this.staffIphone;
    }

    public void setStaffStatus(String staffStatus) {
        this.staffStatus = staffStatus;
    }

    public String getStaffStatus() {
        return this.staffStatus;
    }

    public String getStaffSex() {
        return staffSex;
    }

    public void setStaffSex(String staffSex) {
        this.staffSex = staffSex;
    }

    public Long getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(Long partnerId) {
        this.partnerId = partnerId;
    }

    public String getStaffEmail() {
        return staffEmail;
    }

    public void setStaffEmail(String staffEmail) {
        this.staffEmail = staffEmail;
    }

    public String[] getStoreIds() {
        return storeIds;
    }

    public void setStoreIds(String[] storeIds) {
        this.storeIds = storeIds;
    }
}
