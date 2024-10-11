package com.exp.ucmp.jpush.web;

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
import com.egrid.core.web.RestStatus;
import com.egrid.core.web.response.RestResponse;
import com.egrid.core.web.response.RestStatusCode;
import com.exp.ucmp.jPush.dto.JPushReqDto;
import com.exp.ucmp.jpush.service.JPushService;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;

import cn.jpush.api.push.PushResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;


/**
 * 
 * @author xiongneng
 * @date 2023年08月01日
 */
@Api(value = "JPush.API", tags = "JPush接口调试")
@RefreshScope
@Controller
public class JPushController {

    private static final Logger LOGGER = LoggerFactory.getLogger(JPushController.class);
    
    @Autowired
    private JPushService jPushService;
    
    @ApiOperation(value = "推送极光信息测试接口", notes = "推送极光信息测试接口", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/apig/jPush/sendMessage", method = RequestMethod.POST)
    @ApiOperationSupport(order = 1)
    @JsonPropFilter(type = String.class)
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "jPushReqDto", value = "jPush消息推送参数类", required = false, paramType ="body", dataType = "JPushReqDto")
    })
    public PushResult sendJPushMessage(@RequestBody JPushReqDto jPushReqDto) {
        try {
        	PushResult result = jPushService.jPushAll(jPushReqDto);
        	LOGGER.info("推送展厅站内信息="+result);
        		return result;
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return null;
        }
    }
    
    @ApiOperation(value = "推送极光信息测试接口", notes = "推送极光信息测试接口", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/jPush/sendMessage", method = RequestMethod.POST)
    @ApiOperationSupport(order = 2)
    @JsonPropFilter(type = String.class)
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "jPushReqDto", value = "jPush消息推送参数类", required = false, paramType ="body", dataType = "JPushReqDto")
    })
    public RestResponse<String> sendJPush(@RequestBody JPushReqDto jPushReqDto) {
        try {
        	jPushService.sendJPush(jPushReqDto);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
        }
		return new RestResponse<>(RestStatusCode.OK);
    }
}