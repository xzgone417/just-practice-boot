package com.exp.ucmp.apig.idm.web;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.egrid.core.json.body.JsonPropFilter;
import com.egrid.core.web.response.RestResponse;
import com.egrid.core.web.response.RestStatusCode;
import com.exp.ucmp.apig.idm.consumer.IdmConsumer;
import com.exp.ucmp.idm.dto.IdmAccountStatusDto;
import com.exp.ucmp.idm.dto.IdmUserDto;
import com.exp.ucmp.idm.dto.IdmUserStatusDto;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;


/**
 * 
 * @author xiongneng
 * @date 2022年07月12日
 */
@Api(value = "idmApig.API", tags = "idmApig接口调试")
@RefreshScope
@Controller
public class IdmController {

	/**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(IdmController.class);
    
    @Autowired
	private IdmConsumer idmConsumer;
    

    /**
     * <p>Description: 创建idm用户</p>
     */
    @ApiOperation(value = "创建idm用户", notes = "创建idm用户", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/apig/idm/createUser", method = RequestMethod.POST)
    @ApiOperationSupport(order = 1)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "idmUserDto", value = "用户创建参数信息", required = true, paramType ="body", dataType = "IdmUserDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<String> createUser(@RequestBody IdmUserDto idmUserDto) {
        try {
        	String result = idmConsumer.createUser(idmUserDto);
            return new RestResponse<>(result);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }
    
    /**
     * <p>Description: 更新idm用户</p>
     */
    @ApiOperation(value = "更新idm用户", notes = "更新idm用户", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/apig/idm/updateUser", method = RequestMethod.POST)
    @ApiOperationSupport(order = 1)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "idmUserDto", value = "用户创建参数信息", required = true, paramType ="body", dataType = "IdmUserDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<String> updateUser(@RequestBody IdmUserDto idmUserDto) {
        try {
        	String result = idmConsumer.updateUser(idmUserDto);
            return new RestResponse<>(result);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }
    
    /**
     * <p>Description: 更新idm用户状态</p>
     */
    @ApiOperation(value = "更新idm用户状态", notes = "更新idm用户状态", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/apig/idm/updateUserStatus", method = RequestMethod.POST)
    @ApiOperationSupport(order = 1)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "idmUserStatusDto", value = "用户状态参数信息", required = true, paramType ="body", dataType = "IdmUserStatusDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<String> updateUserStatus(@RequestBody IdmUserStatusDto idmUserStatusDto) {
        try {
        	String result = idmConsumer.updateUserStatus(idmUserStatusDto);
            return new RestResponse<>(result);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }
    
    /**
     * <p>Description: 更新idm账号状态</p>
     */
    @ApiOperation(value = "更新idm账号状态", notes = "更新idm账号状态", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/apig/idm/updateAccountStatus", method = RequestMethod.POST)
    @ApiOperationSupport(order = 1)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "idmAccountStatusDto", value = "账号状态参数信息", required = true, paramType ="body", dataType = "IdmAccountStatusDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<String> updateAccountStatus(@RequestBody IdmAccountStatusDto idmAccountStatusDto) {
        try {
        	String result = idmConsumer.updateAccountStatus(idmAccountStatusDto);
            return new RestResponse<>(result);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }
}
