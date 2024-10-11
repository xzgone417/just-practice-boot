package com.exp.ucmp.user.web;

import java.util.List;

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
import com.exp.ucmp.eos.dto.AccountInfoDto;
import com.exp.ucmp.user.service.EosUserService;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author xiongneng
 * 2022.10.16
 *
 */
@Api(value = "APP查询用户信息", tags = "查询顾问信息")
@RefreshScope
@Controller
public class EosUserController {
	
	/**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(EosUserController.class);
    
    @Autowired
    private EosUserService eosUserService;
    
    /**
     * <p>Description: 查询单个顾问信息以及上级信息</p>
     * @return 
     */
    @ApiOperation(value = "查询单个顾问信息以及上级信息", notes = "查询单个顾问信息以及上级信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/eos/getUserAndSuperiorInfo", method = RequestMethod.GET)
    @ApiOperationSupport(order = 1)
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "token", value = "当前用户token", required = true, paramType ="query", dataType = "String"),
    	@ApiImplicitParam(name = "idmAccountName", value = "当前用户登录名", required = true, paramType ="query", dataType = "String"),
    	@ApiImplicitParam(name = "isCreate", value = "是否是创建预约单页面 0 否 1 是", required = false, paramType ="query", dataType = "String")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<AccountInfoDto> getUserAndSuperiorInfo(@RequestParam(value="token", required=true) String token,
    		@RequestParam(value="idmAccountName", required=true) String idmAccountName,
    		@RequestParam(value="isCreate", required=false,defaultValue="0") int isCreate) {
        try {
        	AccountInfoDto dto=this.eosUserService.getUserAndSuperiorInfo(token,idmAccountName,isCreate);
        	return new RestResponse<>(dto);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }
    
    /**
     * <p>Description: 查询门店下所有顾问信息</p>
     * @return 
     */
    @ApiOperation(value = "查询门店下所有顾问信息", notes = "查询门店下所有顾问信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/eos/allUsersInTheDepartment", method = RequestMethod.GET)
    @ApiOperationSupport(order = 2)
    @JsonPropFilter(type = AccountInfoDto.class)
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "departmentCode", value = "门店code", required = true, paramType ="query", dataType = "String")
    })
    public RestResponse<List<AccountInfoDto>> allUsersInTheDepartment(@RequestParam(value="departmentCode", required=true) String departmentCode) {
        try {
        	List<AccountInfoDto> dtoList=this.eosUserService.allUsersInTheDepartment(departmentCode);
        		return new RestResponse<>(dtoList);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }
}
