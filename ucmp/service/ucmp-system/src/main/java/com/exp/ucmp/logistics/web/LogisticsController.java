package com.exp.ucmp.logistics.web;

import java.text.ParseException;
import java.util.Map;

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
import com.egrid.core.util.JsonBeanUtil;
import com.egrid.core.web.response.RestResponse;
import com.egrid.core.web.response.RestStatusCode;
import com.exp.ucmp.logistics.dto.DispatchRequestDto;
import com.exp.ucmp.logistics.dto.TransitPointInfoDto;
import com.exp.ucmp.logistics.service.LogisticsService;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author xiongneng
 * @date 2023年01月15日
 */
@Api(value = "LogisticsController.API", tags = "物流信息同步接口")
@RefreshScope
@Controller
public class LogisticsController {

	/**
	 * <p>
	 * Field LOGGER: log
	 * </p>
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(LogisticsController.class);

	@Autowired
	private LogisticsService logisticsService;

	/**
	 * <p>
	 * Description: 提交调拨申请
	 * </p>
	 * 
	 */
	@ApiOperation(value = "提交调拨申请到VLMS", notes = "提交调拨申请", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/api/vlms/submit/transfer/application", method = RequestMethod.POST)
	@ApiOperationSupport(order = 1)
	@ApiImplicitParams({
		 @ApiImplicitParam(name = "dispatchRequestDto", value = "发运请求信息", required = true, paramType ="body", dataType = "DispatchRequestDto")})
	@JsonPropFilter(type = DispatchRequestDto.class)
	public RestResponse<String> submitTransferApplication(@RequestBody @Valid DispatchRequestDto dispatchRequestDto) {
		LOGGER.info("===提交调拨申请到VLMS===,[调试参数]="+JsonBeanUtil.beanToJson(dispatchRequestDto));
		try {
			String result = logisticsService.submitTransferApplication(dispatchRequestDto);
			return new RestResponse<>(result);
		} catch (Exception e) {
			LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
			return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
		}
	}
	
	/**
	 * <p>
	 * Description: 同步物流状态
	 * </p>
	 * @throws ParseException 
	 * 
	 *//*
	@ApiOperation(value = "同步VLMS物流状态", notes = "同步物流状态", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/api/vlms/syn/transit/point/info", method = RequestMethod.POST)
	@ApiOperationSupport(order = 2)
	@ApiImplicitParams({
		 @ApiImplicitParam(name = "transitPointInfoDto", value = "发运请求信息", required = true, paramType ="body", dataType = "TransitPointInfoDto")})
	@JsonPropFilter(type = Map.class)
	public Map<String,String> synTransitPointInfo(@RequestBody @Valid TransitPointInfoDto transitPointInfoDto) throws ParseException {
		LOGGER.info("===同步VLMS物流状态===,[调试参数]="+JsonBeanUtil.beanToJson(transitPointInfoDto));
		return logisticsService.synTransitPointInfo(transitPointInfoDto);
	}*/
	
	/**
	 * <p>
	 * Description: 同步物流状态
	 * </p>
	 * @throws ParseException 
	 * 
	 */
	@ApiOperation(value = "同步VLMS物流状态", notes = "同步物流状态", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/api/vlms/test/transit/point/info", method = RequestMethod.POST)
	@ApiOperationSupport(order = 3)
	@ApiImplicitParams({
		 @ApiImplicitParam(name = "transitPointInfoDto", value = "发运请求信息", required = true, paramType ="body", dataType = "TransitPointInfoDto")})
	@JsonPropFilter(type = Map.class)
	public RestResponse<Map<String,String>> transitPointInfo(@RequestBody @Valid TransitPointInfoDto transitPointInfoDto) throws ParseException {
		LOGGER.info("===同步VLMS物流状态test===,[调试参数]="+JsonBeanUtil.beanToJson(transitPointInfoDto));
		Map<String,String> resultMap = logisticsService.synTransitPointInfo(transitPointInfoDto);
		return new RestResponse<>(resultMap);
	}
	
}
