package com.exp.ucmp.storeApp.dto;

import com.egrid.core.base.model.BaseModel;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "LoginUserInfoQueryDto", description = "查询登录用户的入参")
public class LoginUserInfoQueryDto extends BaseModel {

    private static final long serialVersionUID = 1L;
    /**
     * 登录token
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "登录token")
    private String token;
}
