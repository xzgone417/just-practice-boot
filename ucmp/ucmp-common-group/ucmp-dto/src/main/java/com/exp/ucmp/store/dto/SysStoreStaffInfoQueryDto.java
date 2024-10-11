package com.exp.ucmp.store.dto;

import com.exp.ucmp.PageDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SysStoreStaffInfoQueryDto", description = "门店人员查询信息")
public class SysStoreStaffInfoQueryDto extends PageDto {

    private static final long serialVersionUID = 1L;

    /**
     * 门店标识
     */
    @ApiModelProperty(value = "门店标识")
    private Long storeId;

    /**
     * 人员姓名
     */
    @ApiModelProperty(value = "人员姓名")
    private String staffName;


    /**
     * 门店编码
     */
    @ApiModelProperty(value = "门店编码")
    private String storeCode;

    /**
     * 人员手机号
     */
    @ApiModelProperty(value = "人员手机号")
    private String staffIphone;


    /**
     * 人员状态:启用01/禁用00
     */
    @ApiModelProperty(value = "人员状态:启用01/禁用00")
    private String staffStatus;


    @ApiModelProperty("官二资质状态（启用01/禁用00）")
    private String qualificationStatus;



    /**
     * 部门名称
     */
    @ApiModelProperty(value = "部门名称")
    private String departmentName;


    public SysStoreStaffInfoQueryDto() {
    }

    public String getQualificationStatus() {
        return qualificationStatus;
    }

    public void setQualificationStatus(String qualificationStatus) {
        this.qualificationStatus = qualificationStatus;
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

    public String getStaffStatus() {
        return staffStatus;
    }

    public void setStaffStatus(String staffStatus) {
        this.staffStatus = staffStatus;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }
}
