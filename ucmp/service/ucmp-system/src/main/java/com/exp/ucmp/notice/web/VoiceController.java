package com.exp.ucmp.notice.web;


import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.egrid.core.json.body.JsonPropFilter;
import com.egrid.core.util.JsonBeanUtil;
import com.egrid.core.web.response.RestResponse;
import com.egrid.core.web.response.RestStatusCode;
import com.exp.ucmp.huawei.dto.RelationNumDto;
import com.exp.ucmp.huawei.dto.VoiceCallDto;
import com.exp.ucmp.huawei.dto.VoiceCallbackDto;
import com.exp.ucmp.notice.service.VoiceService;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "MsgSmsController", tags = "华为云语音")
@RefreshScope
@Controller
public class VoiceController {

	/**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(VoiceController.class);
    
    @Autowired
    private VoiceService voiceService;
    
    /**
     * <p>Description: 华为云语音 AXB</p>
     * @return 
     */
    @ApiOperation(value = "绑定虚拟号码", notes = "绑定虚拟号码", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/voice/relationnumber", method = RequestMethod.POST)
    @ApiOperationSupport(order = 1)
    @ApiImplicitParams({
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<RelationNumDto> relationnumber(@RequestBody VoiceCallDto voiceCallDto) {
        try {
        	LOGGER.info("=====绑定虚拟号码入参===="+JsonBeanUtil.beanToJson(voiceCallDto));
        	RelationNumDto result = voiceService.voiceCall(voiceCallDto);
			return new RestResponse<>(RestStatusCode.OK,result);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }
    
    /**
     * <p>Description: 华为云语音 AXB</p>
     * @return 
     */
    @ApiOperation(value = "解除绑定虚拟号码", notes = "解除绑定虚拟号码", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/voice/axbUnbindNumber", method = RequestMethod.POST)
    @ApiOperationSupport(order = 2, includeParameters = {"voiceCallDto.subscriptionId"})
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "voiceCallDto", value = "语音呼叫参数", required = true, paramType ="body", dataType = "VoiceCallDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<Map<String, String>> axbUnbindNumber(@RequestBody VoiceCallDto voiceCallDto) {
        try {
        	Map<String, String> result = voiceService.axbUnbindNumber(voiceCallDto);
			return new RestResponse<>(RestStatusCode.OK,result);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }
    
    /**
     * <p>Description: 华为云语音 AXB</p>
     * @return 
     */
    @ApiOperation(value = "绑定信息查询", notes = "绑定信息查询", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/voice/axbQueryBindRelation", method = RequestMethod.POST)
    @ApiOperationSupport(order = 3, includeParameters = {"voiceCallDto.subscriptionId","voiceCallDto.relationNum","voiceCallDto.caller",
    		"voiceCallDto.called","voiceCallDto.pageIndex", "voiceCallDto.pageSize"})
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "voiceCallDto", value = "语音呼叫参数", required = true, paramType ="body", dataType = "VoiceCallDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<Map<String, String>> axbQueryBindRelation(@RequestBody VoiceCallDto voiceCallDto) {
        try {
        	Map<String, String> result = voiceService.axbQueryBindRelation(voiceCallDto);
			return new RestResponse<>(RestStatusCode.OK,result);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }
    
    /**
     * <p>Description: 华为云语音 AXB</p>
     * @return 
     */
    @ApiOperation(value = "事件通知接口", notes = "事件通知接口", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/voice/callback", method = RequestMethod.POST)
    @ApiOperationSupport(order = 4)
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "voiceCallbackDto", value = "接收华为云语音通知事件参数", required = true, paramType ="body", dataType = "VoiceCallbackDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<String> callback(@RequestBody VoiceCallbackDto voiceCallbackDto) {
        try {
        	voiceService.callback(voiceCallbackDto);
			return new RestResponse<>(RestStatusCode.OK);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }
    
    /**
     * <p>Description: 华为云语音 AXB</p>
     * @return 
     */
    @ApiOperation(value = "终止呼叫", notes = "终止呼叫", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/voice/stopCall", method = RequestMethod.GET)
    @ApiOperationSupport(order = 5)
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "sessionid", value = "号码绑定的sessionid", required = true, paramType ="query", dataType = "String")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<String> stopCall(@RequestParam("sessionid") String sessionid) {
        try {
        	voiceService.stopCall(sessionid);
			return new RestResponse<>(RestStatusCode.OK);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }
    
    @ApiOperation(value = "查询置换单呼出记录", notes = "查询置换单呼出记录", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/query/call/out/info", method = RequestMethod.GET)
    @ApiOperationSupport(order = 6)
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "reservationId", value = "置换id", required = true, paramType ="query", dataType = "Long")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<Object> callOutInfo(@RequestParam("reservationId") Long reservationId) {
        try {
        	Boolean flag = voiceService.callOutInfo(reservationId);
			return new RestResponse<>(RestStatusCode.OK,flag);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e.getMessage());
        }
    }
    
}
