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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
 * @date 2023年08月22日
 */
@Api(tags = "同步VLMS物流数据")
@RestController
@RequestMapping("/api/vlms")
public class LogisticsNewController {

	/**
	 * <p>
	 * Field LOGGER: log
	 * </p>
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(LogisticsNewController.class);

	@Autowired
	private LogisticsService logisticsService;
	
	/**
	 * <p>
	 * Description: 同步物流状态
	 * </p>
	 * @throws ParseException 
	 * 
	 */
	@ApiOperation(value = "同步发运状态接口", notes = "同步发运状态接口", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/syn/transit/point/info", method = RequestMethod.POST)
	@ApiOperationSupport(order = 1)
	public Map<String,String> synTransitPointInfo(@RequestBody @Valid TransitPointInfoDto transitPointInfoDto) throws ParseException {
		LOGGER.info("===同步VLMS物流状态===,[调试参数]="+JsonBeanUtil.beanToJson(transitPointInfoDto));
		return logisticsService.synTransitPointInfo(transitPointInfoDto);
	}
	
}
