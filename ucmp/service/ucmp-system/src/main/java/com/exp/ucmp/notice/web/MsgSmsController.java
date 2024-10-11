package com.exp.ucmp.notice.web;

import javax.validation.Valid;

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
import com.exp.ucmp.huawei.dto.SmsParamsDto;
import com.exp.ucmp.notice.service.MsgSmsService;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "MsgSmsController", tags = "华为云发送短信")
@RefreshScope
@Controller
public class MsgSmsController {
	
	/**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(MsgSmsController.class);

	@Autowired
	private MsgSmsService msgSmsService;
	
	/**
     * <p>Description: 华为云发送短信</p>
     * @return 
     */
    @ApiOperation(value = "发送短信", notes = "发送短信", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/huawei/batchSendSms", method = RequestMethod.POST)
    @ApiOperationSupport(order = 1)
    @JsonPropFilter(type = String.class)
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "smsParamsDto", value = "华为云短信消息", required = false, paramType ="body", dataType = "SmsParamsDto")
    })
    public RestResponse<String> batchSendSms(@RequestBody @Valid SmsParamsDto smsParamsDto) {
        try {
        	msgSmsService.batchSendSms(smsParamsDto);
			return new RestResponse<>(RestStatusCode.OK);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }
	
}
