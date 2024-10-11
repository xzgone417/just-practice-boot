package com.exp.ucmp.auth.fegin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.egrid.core.json.body.JsonPropFilter;
import com.egrid.core.web.response.RestResponse;
import com.exp.ucmp.model.LoginDto;
import com.exp.ucmp.model.LoginResult;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@FeignClient(value="ucmp-auth", contextId="LoginFegin")
public interface LoginFegin {
	
	/**
     * <p>
     * Description: 查询
     * </p>
     * 
     * @param loginDto   用户登录信息
     * @param request  请求对象
     * @param response 响应对象
     * @return 查询结果
     */
    @ApiOperation(value = "用户登录", notes = "用户登录", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperationSupport(ignoreParameters = {"loginDto.userParameters"})
    @RequestMapping(value = "/api/auth/login", method = RequestMethod.POST)
    @JsonPropFilter(type = LoginResult.class)
    public RestResponse<LoginResult> login(
            @ApiParam(name = "loginDto", value = "用户登录请求信息", required = true) @RequestBody LoginDto loginDto) ;
}
