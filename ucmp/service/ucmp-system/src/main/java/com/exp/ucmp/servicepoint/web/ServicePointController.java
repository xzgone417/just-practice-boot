package com.exp.ucmp.servicepoint.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.egrid.core.json.body.JsonPropFilter;
import com.egrid.core.web.response.RestResponse;
import com.egrid.core.web.response.RestStatusCode;
import com.exp.ucmp.isp.dto.ServicePointDto;
import com.exp.ucmp.isp.dto.ServicePointTypeDto;
import com.exp.ucmp.servicepoint.service.ServicePointService;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author xiongneng
 * @date 2023年02月14日
 */
@Api(value = "服务点数据", tags = "服务点数据")
@RefreshScope
@Controller
public class ServicePointController {
	
	/**
	 * <p>
	 * Field LOGGER: log
	 * </p>
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(ServicePointController.class);

	@Autowired
	private ServicePointService servicePointService;
	
	/**
	 * <p>
	 * Description: 服务点类型
	 * </p>
	 * 
	 */
	@ApiOperation(value = "获取服务点类型数据", notes = "服务点类型数据", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/api/service/point/getPointType", method = RequestMethod.GET)
	@ApiOperationSupport(order = 1)
	@ApiImplicitParams({})
	@JsonPropFilter(type = ServicePointTypeDto.class)
	public RestResponse<List<ServicePointTypeDto>> getPointType() {
		try {
			List<ServicePointTypeDto> resultList = servicePointService.getPointType();
			return new RestResponse<>(resultList);
		} catch (Exception e) {
			LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
			return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
		}
	}
	
	/**
	 * <p>
	 * Description: 服务点
	 * </p>
	 * 
	 */
	@ApiOperation(value = "获取服务点数据", notes = "服务点数据", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/api/service/point/getPoint", method = RequestMethod.GET)
	@ApiOperationSupport(order = 2)
	@ApiImplicitParams({@ApiImplicitParam(name = "pointTypeCode", value = "服务点类型", required = false, paramType ="query", dataType = "String"),
		@ApiImplicitParam(name = "pointName", value = "服务点名称(支持模糊查询))", required = false, paramType ="query", dataType = "String")})
	@JsonPropFilter(type = ServicePointDto.class)
	public RestResponse<List<ServicePointDto>> getPoint(@RequestParam(value = "pointTypeCode", required = false)String pointTypeCode,
			@RequestParam(value = "pointName", required = false)String pointName) {
		try {
			List<ServicePointDto> resultList = servicePointService.getPoint(pointTypeCode,pointName);
			return new RestResponse<>(resultList);
		} catch (Exception e) {
			LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
			return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
		}
	}
}
