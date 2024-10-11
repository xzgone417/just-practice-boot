package com.exp.ucmp.parentUser.dto;

import com.exp.ucmp.PageDto;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SysParentUserInfoInsertDto", description = "合作商新增人员信息Dto")
public class SysParentUserInfoInsertDto extends PageDto {

    private static final long serialVersionUID = 1L;
    /**
     * 当前合作商partnerId
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "当前合作商partnerId")
    private Long partnerDetailsId;

    /**
     * 当前人员id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "当前人员id")
    private Long parentUserInfoId;


    /**
     * 姓名
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "姓名")
    private String hhrName;


    /**
     * 性别:M:男，F:女
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "性别:M:男，F:女")
    private String hhrGender;

    /**
     * 手机号码
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "手机号码")
    private String hhrPhoneNum;


    /**
     * 邮箱
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "邮箱")
    private String idmEmail;


    /**
     * 角色名称
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "角色名称")
    private String roleName;


    public Long getPartnerDetailsId() {
        return partnerDetailsId;
    }

    public void setPartnerDetailsId(Long partnerDetailsId) {
        this.partnerDetailsId = partnerDetailsId;
    }

    public String getHhrName() {
        return hhrName;
    }

    public void setHhrName(String hhrName) {
        this.hhrName = hhrName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getHhrGender() {
        return hhrGender;
    }

    public void setHhrGender(String hhrGender) {
        this.hhrGender = hhrGender;
    }

    public String getHhrPhoneNum() {
        return hhrPhoneNum;
    }

    public void setHhrPhoneNum(String hhrPhoneNum) {
        this.hhrPhoneNum = hhrPhoneNum;
    }

    public String getIdmEmail() {
        return idmEmail;
    }

    public void setIdmEmail(String idmEmail) {
        this.idmEmail = idmEmail;
    }

    public Long getParentUserInfoId() {
        return parentUserInfoId;
    }

    public void setParentUserInfoId(Long parentUserInfoId) {
        this.parentUserInfoId = parentUserInfoId;
    }
}
