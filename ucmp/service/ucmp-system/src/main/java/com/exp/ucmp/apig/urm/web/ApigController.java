package com.exp.ucmp.apig.urm.web;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;

import com.egrid.core.json.body.JsonPropFilter;
import com.egrid.core.web.response.RestResponse;
import com.egrid.core.web.response.RestStatusCode;
import com.exp.ucmp.apig.urm.consumer.UrmConsumer;

/**
 * 
 * @author Yiyongfei
 * @date 2022年07月12日
 */
@Api(value = "Apig.API", tags = "Apig接口调试")
@RefreshScope
@Controller
public class ApigController {

	/**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ApigController.class);
	
	@Autowired
	private UrmConsumer urmConsumer;
	
	/**
     * <p>Description: 用户档案查询</p>
     * @return 用户档案
     */
    @ApiOperation(value = "URM(用户档案查询)", notes = "用户档案查询", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/apig/urm/userProfilesQuery", method = RequestMethod.GET)
    @ApiOperationSupport(order = 1)
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "superIds", value = "用户ID", required = false, paramType ="query", dataType = "String")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<String> urmUserProfilesQuery(@RequestParam(value="superIds", required=true) String superIds) {
        try {
        	String result = urmConsumer.userProfilesQuery(superIds);
//        	String result="{\"name\":\"33333333\",\"idm_Id\":\"-R5AjMRBT5iKEVDskpukQw\",\"superId\":\"PA429284072688517120\",\"mobile\":15057933766}";
            return new RestResponse<>(result);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }
    
	/**
     * <p>Description: 基于用户手机号获取用户ID</p>
     * @return 用户档案
     */
    @ApiOperation(value = "URM(基于用户手机号获取用户ID)", notes = "基于用户手机号获取用户ID", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/apig/urm/getTokenByAccount", method = RequestMethod.GET)
    @ApiOperationSupport(order = 2)
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "mobile", value = "手机号", required = true, paramType ="query", dataType = "String")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<String> urmUserUid(@RequestParam(value="mobile", required=true) String mobile) {
        try {
        	String result = urmConsumer.urmUserUid(mobile);
//        	String result="{\"name\":\"33333333\",\"idm_Id\":\"-R5AjMRBT5iKEVDskpukQw\",\"superId\":\"PA429284072688517120\",\"mobile\":15057933766}";
            return new RestResponse<>(result);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }
    
    @ApiOperation(value = "根据积分任务发放积分", notes = "根据积分任务发放积分", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/apig/urm/pointsTask/points/grant", method = RequestMethod.GET)
    @ApiOperationSupport(order = 3)
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "pointsValue", value = "积分值", required = false, paramType ="query", dataType = "int"),
    	@ApiImplicitParam(name = "superId", value = "superId", required = true, paramType ="query", dataType = "String")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<String> urmGrantPoints(@RequestParam(value="pointsValue", required=false) int pointsValue,
    		@RequestParam(value="superId", required=true) String superId) {
        try {
        	String result = urmConsumer.urmGrantPoints(pointsValue,superId);
//        	String result="{\"name\":\"33333333\",\"idm_Id\":\"-R5AjMRBT5iKEVDskpukQw\",\"superId\":\"PA429284072688517120\",\"mobile\":15057933766}";
            return new RestResponse<>(result);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }
}


