package com.exp.ucmp.behavior.web;

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
import com.exp.ucmp.behavior.dto.BehaviorDto;
import com.exp.ucmp.behavior.service.IBehaviorService;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "Behavior.API", tags = "行为记录接口")
@RefreshScope
@Controller
public class BehaviorController {
    private static final Logger LOGGER = LoggerFactory.getLogger(BehaviorController.class);
	@Autowired
    private IBehaviorService behaviorService;
    
	/**
	 * 行为记录
	 */
	@ApiOperation(value = "行为记录", notes = "行为记录", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperationSupport(order = 1)
	@RequestMapping(value = "/api/sys/behavior/record", method = RequestMethod.POST)
	@ApiImplicitParams({
        @ApiImplicitParam(name = "behaviorDto", value = "行为记录请求信息", required = true, paramType ="body", dataType = "BehaviorDto")
    })
	@JsonPropFilter(type = String.class)
	public RestResponse<String> record(@RequestBody BehaviorDto behaviorDto) {
		try {
			LOGGER.info("UserID: {}, BehaviorTarget: {}, BehaviorTargetUrl: {}", behaviorDto.getPartyId(), behaviorDto.getBehaviorTarget(), behaviorDto.getBehaviorTargetUrl());
			if(behaviorDto.getBehaviorTargetUrl().indexOf("/api/sys/behavior") < 0) {
				behaviorService.recordBehavior(behaviorDto.getPartyId(),behaviorDto.getBehaviorType() , behaviorDto.getBehaviorTarget(), behaviorDto.getBehaviorTargetUrl(), behaviorDto.getBehaviorEndpoint(), behaviorDto.getRequestId(), behaviorDto.getQueryParams(), behaviorDto.getBodyParams(), behaviorDto.getBodyResponse(), behaviorDto.getBehaviorTags());
			}
			return new RestResponse<>(RestStatusCode.OK);
		} catch (Exception e) {
			LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
			return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
		}
	}
	

    /**
     * 行为记录
     */
    @ApiOperation(value = "行为响应记录", notes = "响应记录", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperationSupport(order = 2, includeParameters = {"behaviorDto.requestId", "behaviorDto.bodyResponse"})
    @RequestMapping(value = "/api/sys/behavior/record/response", method = RequestMethod.POST)
	@ApiImplicitParams({
        @ApiImplicitParam(name = "behaviorDto", value = "行为记录响应信息", required = true, paramType ="body", dataType = "BehaviorDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<String> recordResponse(@RequestBody BehaviorDto behaviorDto) {
        try {
        	behaviorService.recordBehaviorResponse(behaviorDto.getHttpStatus(), behaviorDto.getRequestId(), behaviorDto.getBodyResponse());
        	return new RestResponse<>(RestStatusCode.OK);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }
}
