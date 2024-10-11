package com.exp.ucmp.role.dto;


import com.exp.ucmp.PageDto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * @author zhouchengwei
 * @date 2022年8月11日
 */
@ApiModel(value = "SysRoleDetailsDto", description = "角色信息详情表")
public class SysRoleDetailsDto extends PageDto {

    private static final long serialVersionUID = 1L;
    /**
     * 角色标识
     */
    @JsonSerialize(using = ToStringSerializer.class)
   @ApiModelProperty(value = "角色标识")
    private Long roleId;


    /**
     * 角色编码
     */
    @ApiModelProperty(value = "角色编码")
    private String roleCode;

    /**
     * 角色类型（门店0020、总部0010.......）
     */
    @ApiModelProperty(value = "角色类型（门店0020、总部0010.......）")
    private String roleDetailsType;

    /**
     * 角色名称
     */
    @ApiModelProperty(value = "角色名称")
    private String roleDetailsName;





    public SysRoleDetailsDto() {
    }

    public SysRoleDetailsDto(Long roleId) {
        this.roleId = roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
    public Long getRoleId() {
        return this.roleId;
    }


    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }
    public String getRoleCode() {
        return this.roleCode;
    }

    public void setRoleDetailsType(String roleDetailsType) {
        this.roleDetailsType = roleDetailsType;
    }
    public String getRoleDetailsType() {
        return this.roleDetailsType;
    }

    public void setRoleDetailsName(String roleDetailsName) {
        this.roleDetailsName = roleDetailsName;
    }
    public String getRoleDetailsName() {
        return this.roleDetailsName;
    }



    }

