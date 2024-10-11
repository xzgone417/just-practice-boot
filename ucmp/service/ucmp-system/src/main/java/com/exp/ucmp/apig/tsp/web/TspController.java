package com.exp.ucmp.apig.tsp.web;

import java.util.HashMap;
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
import com.exp.ucmp.apig.tsp.consumer.TspConsumer;
import com.exp.ucmp.pay.dto.PayRefundDto;
import com.exp.ucmp.tsp.dto.RegAndLoginDto;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author xiongneng
 * @date 2023年02月23日
 */
@Api(value = "TspApig.API", tags = "TspApig接口调试")
@RefreshScope
@Controller
public class TspController {

	/**
	 * <p>
	 * Field LOGGER: log
	 * </p>
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(TspController.class);

	@Autowired
	private TspConsumer tspConsumer;

	/**
	 * <p>
	 * Description: 二手车系统查询车辆、车况信息及激活数据
	 * </p>
	 * 
	 */
	@ApiOperation(value = "TSP(二手车系统查询车辆、车况信息及激活数据)", notes = "二手车系统查询车辆、车况信息及激活数据", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/api/apig/tsp/queryVehicleBasicInfo", method = RequestMethod.GET)
	@ApiOperationSupport(order = 1)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "vin", value = "vin码", required = true, paramType = "query", dataType = "String")})
	@JsonPropFilter(type = String.class)
	public RestResponse<String> queryVehicleBasicInfo(@RequestParam(value = "vin", required = true) String vin) {
		try {
			String result = tspConsumer.queryVehicleBasicInfo(vin);
			return new RestResponse<>(result);
		} catch (Exception e) {
			LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
			return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
		}
	}
	
	/**
	 * <p>
	 * Description: 二手车系统查询车辆累计里程
	 * </p>
	 * 
	 */
	@ApiOperation(value = "TSP(二手车系统查询车辆累计里程)", notes = "二手车系统查询车辆累计里程", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/api/apig/tsp/queryVehicleStatus", method = RequestMethod.GET)
	@ApiOperationSupport(order = 2)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "vin", value = "vin码", required = true, paramType = "query", dataType = "String")})
	@JsonPropFilter(type = String.class)
	public RestResponse<String> queryVehicleStatus(@RequestParam(value = "vin", required = true) String vin) {
		try {
			Map<String,Object> paramsMap=new HashMap<>();
			paramsMap.put("vin", vin);
			String result = tspConsumer.queryVehicleStatus(paramsMap);
			return new RestResponse<>(result);
		} catch (Exception e) {
			LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
			return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
		}
	}
	
	@ApiOperation(value = "手机号直接注册登入", notes = "手机号直接注册登入", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/api/apig/idmc/mobilePhoneRegAndLogin", method = RequestMethod.POST)
	@ApiOperationSupport(order = 3)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "regAndLoginDto", value = "手机号直接注册登入", required = true, paramType = "body", dataType = "RegAndLoginDto")})
	@JsonPropFilter(type = String.class)
	public RestResponse<String> mobilePhoneRegAndLogin(@RequestBody RegAndLoginDto regAndLoginDto) {
		LOGGER.info("====手机号直接注册登入===="+JsonBeanUtil.beanToJson(regAndLoginDto));
		try {
			String result = tspConsumer.mobilePhoneRegAndLogin(regAndLoginDto);
			return new RestResponse<>(RestStatusCode.OK,result);
		} catch (Exception e) {
			LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
			return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, "服务异常，请联系系统管理员");
		}
	}
	
}
