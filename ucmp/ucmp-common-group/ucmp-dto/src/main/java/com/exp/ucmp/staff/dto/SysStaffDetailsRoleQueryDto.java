package com.exp.ucmp.staff.dto;

import com.exp.ucmp.PageDto;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(value = "SysStaffDetailsRoleQueryDto", description = "所有角色信息")
public class SysStaffDetailsRoleQueryDto extends PageDto {

    private static final long serialVersionUID = 1L;


    /**
     * 权限标识
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "权限标识")
    private Long roleId;


    /**
     * 员工ID
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "员工ID")
    private Long partyId;





    /**
     * 角色名称
     */
    @ApiModelProperty(value = "角色名称")
    private String roleName;


    /**
     * 角色类型(0010总部,0020门店,0030车商.....)
     */
    @ApiModelProperty(value = "角色类型(0010总部,0020门店,0030车商.....)")
    private String roleType;

    /**
     * 角色类型字符串显示
     */
    @ApiModelProperty(value = "角色类型字符串显示")
    private String roleTypeStr;
    /**
     * 角色代码
     */
    @ApiModelProperty(value = "角色代码")
    private String roleCode;

    /**
     * 该人员是否存在该角色
     */
    @ApiModelProperty(value = "该人员是否存在该角色")
    private Boolean staffRoleFlag;



    public SysStaffDetailsRoleQueryDto() {
    }

    public SysStaffDetailsRoleQueryDto(Long partyId) {
        this.partyId = partyId;
    }

    public void setPartyId(Long partyId) {
        this.partyId = partyId;
    }
    public Long getPartyId() {
        return this.partyId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public Boolean getStaffRoleFlag() {
        return staffRoleFlag;
    }

    public void setStaffRoleFlag(Boolean staffRoleFlag) {
        this.staffRoleFlag = staffRoleFlag;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleTypeStr() {
        return RoleType.getDesc(roleType);
    }

    public void setRoleTypeStr(String roleTypeStr) {

        this.roleTypeStr = roleTypeStr;
    }

    public String getRoleType() {
        return roleType;
    }

    public enum RoleType { //角色类型
        headquarters("0010","总部"),
        store("0020","门店"),
        carDealer("0030","车商");

        private String value;
        private String desc;
        private RoleType(String value,String desc) {
            this.value = value;
            this.desc = desc;
        }
        public static String getDesc(String value) {
            for (RoleType item : RoleType.values()) {
                if(item.value.equals(value)){
                    return item.desc;
                }
            }
            return  "";
        }
        public String value() {
            return this.value;
        }
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }
}
