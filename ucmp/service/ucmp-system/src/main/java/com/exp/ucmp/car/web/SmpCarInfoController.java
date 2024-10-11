package com.exp.ucmp.car.web;

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
import com.exp.ucmp.apig.smp.web.SmpController;
import com.exp.ucmp.car.service.SmpCarInfoService;
import com.exp.ucmp.smp.dto.CarModelDto;
import com.exp.ucmp.smp.dto.CarSeriesDto;
import com.exp.ucmp.smp.dto.VehicleproductDto;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author xiongneng
 * @date 2022年10月25日
 */
@Api(value = "SmpApig.API", tags = "SMP车型数据")
@RefreshScope
@Controller
public class SmpCarInfoController {
	
	/**
	 * <p>
	 * Field LOGGER: log
	 * </p>
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(SmpController.class);

	@Autowired
	private SmpCarInfoService smpCarInfoService;
	
	/**
	 * <p>
	 * Description: 车型产品-工程车型
	 * </p>
	 * 
	 */
	@ApiOperation(value = "SMP获取车型产品-工程车型", notes = "获取车型产品-工程车型", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/api/otd/getCarseries", method = RequestMethod.GET)
	@ApiOperationSupport(order = 1)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "channel", value = "渠道码", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "carSeriesCode", value = "工程车型编码,不传查全量", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "allVcc", value = "是否查询全量信息,不传默认false，true查全部工程车型，false查默认销售配置下工程车型", required = false, paramType = "query", dataType = "Boolean"),
			@ApiImplicitParam(name = "saleConfId", value = "销售配置ID，不传查默认销售配置下工程车型", required = false, paramType = "query", dataType = "String")})
	@JsonPropFilter(type = CarSeriesDto.class)
	public RestResponse<List<CarSeriesDto>> getCarseries(@RequestParam(value = "channel", required = false) String channel,
			@RequestParam(value = "carSeriesCode", required = false) String carSeriesCode,
			@RequestParam(value = "allVcc", required = false) Boolean allVcc,
			@RequestParam(value = "saleConfId", required = false) String saleConfId) {
		try {
			List<CarSeriesDto> result = smpCarInfoService.getCarseries(channel, carSeriesCode, allVcc, saleConfId);
			return new RestResponse<>(result);
		} catch (Exception e) {
			LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
			return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
		}
	}
	
	/**
	 * <p>
	 * Description: 车型产品-基础车型
	 * </p>
	 * 
	 */
	@ApiOperation(value = "SMP获取车型产品-基础车型", notes = "获取车型产品-基础车型", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/api/otd/getCartype", method = RequestMethod.GET)
	@ApiOperationSupport(order = 2)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "channel", value = "渠道码", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "carSeriesCode", value = "工程车型编码", required = true, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "allVcc", value = "是否查询全量信息,不传默认false，true查全部工程车型，false查默认销售配置下工程车型", required = false, paramType = "query", dataType = "Boolean"),
			@ApiImplicitParam(name = "saleConfId", value = "销售配置ID，不传查默认销售配置下工程车型", required = false, paramType = "query", dataType = "String")})
	@JsonPropFilter(type = CarModelDto.class)
	public RestResponse<List<CarModelDto>> getCartype(@RequestParam(value = "channel", required = false) String channel,
			@RequestParam(value = "carSeriesCode", required = true) String carSeriesCode,
			@RequestParam(value = "allVcc", required = false) Boolean allVcc,
			@RequestParam(value = "saleConfId", required = false) String saleConfId) {
		try {
			List<CarModelDto> result = smpCarInfoService.getCartype(channel, carSeriesCode, allVcc, saleConfId);
			return new RestResponse<>(result);
		} catch (Exception e) {
			LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
			return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
		}
	}
	
	/**
	 * <p>
	 * Description: 车型产品
	 * </p>
	 * 
	 */
	@ApiOperation(value = "SMP获取车型产品", notes = "获取车型产品", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/api/otd/getVehicleproduct", method = RequestMethod.GET)
	@ApiOperationSupport(order = 3)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "channel", value = "渠道码", required = true, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "saleConfId", value = "销售配置ID，不传查默认销售配置下工程车型", required = false, paramType = "query", dataType = "String")})
	@JsonPropFilter(type = String.class)
	public RestResponse<List<VehicleproductDto>> getVehicleproduct(@RequestParam(value = "channel", required = true) String channel,
			@RequestParam(value = "saleConfId", required = false) String saleConfId) {
		try {
			List<VehicleproductDto> result = smpCarInfoService.getVehicleproduct(channel, saleConfId);
			return new RestResponse<>(result);
		} catch (Exception e) {
			LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
			return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
		}
	}
}
