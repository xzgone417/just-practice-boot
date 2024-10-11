package com.exp.ucmp.car.web;

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
import com.exp.ucmp.car.dto.CarMainInfoDto;
import com.exp.ucmp.car.service.BasicsCarInfoService;
import com.exp.ucmp.smp.dto.CarSeriesDto;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author xiongneng
 * @date 2023年02月11日
 */
@Api(value = "车辆基础数据", tags = "车辆基础数据")
@RefreshScope
@Controller
public class BasicsCarInfoController {
	
	/**
	 * <p>
	 * Field LOGGER: log
	 * </p>
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(BasicsCarInfoController.class);

	@Autowired
	private BasicsCarInfoService basicsCarInfoService;
	
	/**
	 * <p>
	 * Description: 车型产品-工程车型
	 * </p>
	 * 
	 */
	@ApiOperation(value = "获取车辆基础数据", notes = "车辆基础数据", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/api/basics/getCarseries", method = RequestMethod.GET)
	@ApiOperationSupport(order = 1)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "stockId", value = "车辆ID", required = false, paramType = "query", dataType = "Long"),
			@ApiImplicitParam(name = "carVin", value = "vin码", required = true, paramType = "query", dataType = "String")})
	@JsonPropFilter(type = CarSeriesDto.class)
	public RestResponse<CarMainInfoDto> getCarMainInfo(@RequestParam(value = "stockId", required = false)Long stockId,
			@RequestParam(value = "carVin", required = true) String carVin) {
		try {
			CarMainInfoDto result = basicsCarInfoService.getCarMainInfo(stockId,carVin);
			return new RestResponse<>(result);
		} catch (Exception e) {
			LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
			return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
		}
	}
}
