package com.exp.ucmp.apig.usc.web;

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
import com.egrid.core.web.response.RestResponse;
import com.egrid.core.web.response.RestStatusCode;
import com.exp.ucmp.apig.usc.consumer.UscConsumer;
import com.exp.ucmp.usc.dto.CreateEvaluationDto;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author xiongneng
 * @date 2022年10月12日
 */
@Api(value = "UscController.API", tags = "UscController接口调试")
@RefreshScope
@Controller
public class UscController {

	/**
	 * <p>
	 * Field LOGGER: log
	 * </p>
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(UscController.class);

	@Autowired
	private UscConsumer uscConsumer;

	/**
	 * <p>
	 * Description: 创建评价单
	 * </p>
	 * 
	 */
	@ApiOperation(value = "USC(创建评价单)", notes = "创建评价单", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/api/apig/usc/createEvaluation", method = RequestMethod.POST)
	@ApiOperationSupport(order = 1)
	@ApiImplicitParams({
		 @ApiImplicitParam(name = "dto", value = "参数信息", required = true, paramType ="body", dataType = "CreateEvaluationDto") })
	@JsonPropFilter(type = String.class)
	public RestResponse<String> createEvaluation(@RequestBody CreateEvaluationDto dto) {
		try {
			String result = uscConsumer.createEvaluation(dto);
			return new RestResponse<>(result);
		} catch (Exception e) {
			LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
			return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
		}
	}
	
	/**
	 * <p>
	 * Description: 通知客户评价
	 * </p>
	 * 
	 */
	@ApiOperation(value = "USC(通知客户评价)", notes = "通知客户评价", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/api/apig/usc/notifyEvaluation", method = RequestMethod.POST)
	@ApiOperationSupport(order = 2)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "businessNo", value = "业务编码", required = true, paramType = "query", dataType = "String")})
	@JsonPropFilter(type = String.class)
	public RestResponse<String> notifyEvaluation(@RequestParam(value = "businessNo", required = true) String businessNo) {
		try {
			String result = uscConsumer.notifyEvaluation(businessNo);
			return new RestResponse<>(result);
		} catch (Exception e) {
			LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
			return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
		}
	}
	
	/**
	 * <p>
	 * Description: 门店信息
	 * </p>
	 * 
	 */
	@ApiOperation(value = "USC(查询评价详情)", notes = "查询评价详情", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/api/apig/usc/getEvaluationDetail", method = RequestMethod.GET)
	@ApiOperationSupport(order = 3)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "businessNo", value = "业务编码", required = true, paramType = "query", dataType = "String")})
	@JsonPropFilter(type = String.class)
	public RestResponse<String> getEvaluationDetail(@RequestParam(value = "businessNo", required = true) String businessNo) {
		try {
			String result = uscConsumer.getEvaluationDetail(businessNo);
			return new RestResponse<>(result);
		} catch (Exception e) {
			LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
			return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
		}
	}
	
}
