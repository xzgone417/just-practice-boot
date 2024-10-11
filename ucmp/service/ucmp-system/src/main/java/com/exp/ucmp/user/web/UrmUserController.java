package com.exp.ucmp.user.web;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.egrid.core.json.body.JsonPropFilter;
import com.egrid.core.web.response.RestResponse;
import com.egrid.core.web.response.RestStatusCode;
import com.exp.ucmp.urm.dto.UserDto;
import com.exp.ucmp.user.service.UrmUserService;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "APP查询客户信息", tags = "查询客户信息")
@RefreshScope
@Controller
public class UrmUserController {
	/**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(UrmUserController.class);
    
    @Autowired
    private UrmUserService urmUserService;
    
    /**
     * <p>Description: 用户ID查询用户档案</p>
     * @return 
     */
    @ApiOperation(value = "用户ID查询用户档案", notes = "用户ID查询用户档案", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/urm/userProfilesQuery", method = RequestMethod.GET)
    @ApiOperationSupport(order = 1)
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "superIds", value = "用户ID", required = true, paramType ="query", dataType = "String")
    })
    @JsonPropFilter(type = UserDto.class, include = "name, idmId, superId, mobile,enMobile")
    public RestResponse<UserDto> userProfilesQuery(@RequestParam(value="superIds", required=true) String superIds) {
        try {
//        	superIds="PA429284072688517120";
        	UserDto dto=this.urmUserService.userProfilesQuery(superIds);
        	return new RestResponse<>(dto);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }
    
    /**
     * <p>Description: 用户ID查询用户档案</p>
     * @return 
     */
    @ApiOperation(value = "URM(基于用户手机号获取用户ID)", notes = "基于用户手机号获取用户ID", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/urm/getTokenByAccount", method = RequestMethod.GET)
    @ApiOperationSupport(order = 2)
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "mobile", value = "手机号", required = true, paramType ="query", dataType = "String")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<String> urmUserUid(@RequestParam(value="mobile", required=true) String mobile) {
        try {
//        	superIds="PA429284072688517120";
        	String result=this.urmUserService.urmUserUid(mobile);
        	return new RestResponse<>(result);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }
    
    @ApiOperation(value = "根据积分任务发放积分", notes = "根据积分任务发放积分", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/urm/pointsTask/points/grant", method = RequestMethod.GET)
    @ApiOperationSupport(order = 3)
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "pointsValue", value = "积分值", required = false, paramType ="query", dataType = "int"),
    	@ApiImplicitParam(name = "superId", value = "superId", required = true, paramType ="query", dataType = "String")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<String> urmGrantPoints(@RequestParam(value="pointsValue", required=false) int pointsValue,
    		@RequestParam(value="superId", required=true) String superId) {
        try {
        	String result = this.urmUserService.urmGrantPoints(pointsValue,superId);
            return new RestResponse<>(result);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }
}
