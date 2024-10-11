package com.exp.ucmp.apig.urc.web;

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
import org.springframework.web.bind.annotation.RequestParam;

import com.egrid.core.json.body.JsonPropFilter;
import com.egrid.core.web.response.RestResponse;
import com.egrid.core.web.response.RestStatusCode;
import com.exp.ucmp.apig.urc.consumer.UrcConsumer;
import com.exp.ucmp.urc.dto.RightPackSaveDto;
import com.exp.ucmp.urc.dto.RightsGrantDto;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author xiongneng
 * @date 2022年10月23日
 */
@Api(value = "UrcController.API", tags = "UrcController接口调试")
@RefreshScope
@Controller
public class UrcController {

	/**
	 * <p>
	 * Field LOGGER: log
	 * </p>
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(UrcController.class);

	@Autowired
	private UrcConsumer urcConsumer;

	/**
	 * <p>
	 * Description: 权益包创建
	 * </p>
	 * 
	 */
	@ApiOperation(value = "URC(权益主数据列表查询)", notes = "权益主数据列表查询", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/api/apig/urc/rightQueryByCondition", method = RequestMethod.GET)
	@ApiOperationSupport(order = 1)
	@ApiImplicitParams({
		 @ApiImplicitParam(name = "rightTypeName", value = "权益类型名称 权益类型(服务内容)名称。支持模糊查询", required = false, paramType ="query", dataType = "String") ,
		 @ApiImplicitParam(name = "grantType", value = "发放类型 文本类00、电度类01、卡券类02、积分类03、流量类04", required = false, paramType ="query", dataType = "String")
		 })
	@JsonPropFilter(type = String.class)
	public RestResponse<String> rightQueryByCondition(@RequestParam(value = "rightTypeName", required = false)String rightTypeName,
			@RequestParam(value = "grantType", required = false)String grantType) {
		try {
			String result = urcConsumer.rightQueryByCondition(rightTypeName, grantType);
			return new RestResponse<>(result);
		} catch (Exception e) {
			LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
			return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
		}
	}
	
	/**
	 * <p>
	 * Description: 权益包创建
	 * </p>
	 * 
	 */
	@ApiOperation(value = "URC(权益包创建)", notes = "权益包创建", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/api/apig/urc/rightPackSave", method = RequestMethod.POST)
	@ApiOperationSupport(order = 2)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "rightPackSaveDto", value = "权益包创建参数类", required = true, paramType = "body", dataType = "RightPackSaveDto")})
	@JsonPropFilter(type = String.class)
	public RestResponse<String> rightPackSave(@RequestBody @Valid RightPackSaveDto rightPackSaveDto) {
		try {
			String result = urcConsumer.rightPackSave(rightPackSaveDto);
			return new RestResponse<>(result);
		} catch (Exception e) {
			LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
			return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
		}
	}
	
	/**
	 * <p>
	 * Description: 权益发放
	 * </p>
	 * 
	 */
	@ApiOperation(value = "URC(权益发放)", notes = "权益发放", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/api/apig/urc/rightsGrant", method = RequestMethod.POST)
	@ApiOperationSupport(order = 3)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "rightsGrantDto", value = "权益发放参数类", required = true, paramType = "body", dataType = "RightsGrantDto")})
	@JsonPropFilter(type = String.class)
	public RestResponse<String> rightsGrant(@RequestBody @Valid RightsGrantDto rightsGrantDto) {
		try {
			String result = urcConsumer.rightsGrant(rightsGrantDto);
			return new RestResponse<>(result);
		} catch (Exception e) {
			LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
			return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
		}
	}
	
}