package com.exp.ucmp.apig.smp.web;

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
import com.exp.ucmp.apig.smp.consumer.SmpConsumer;
import com.exp.ucmp.dao.ISysPayConfigDao;
import com.exp.ucmp.entity.SysPayConfigEntity;
import com.exp.ucmp.mall.dto.MallReturnDto;
import com.exp.ucmp.pay.dto.PayDto;
import com.exp.ucmp.pay.dto.PayRefundDto;
import com.exp.ucmp.pk.SysPayConfigPk;
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
@Api(value = "SmpApig.API", tags = "SmpApig接口调试")
@RefreshScope
@Controller
public class SmpController {

	/**
	 * <p>
	 * Field LOGGER: log
	 * </p>
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(SmpController.class);

	@Autowired
	private SmpConsumer smpConsumer;
	@Autowired
	private ISysPayConfigDao iSysPayConfigDao;

	/**
	 * <p>
	 * Description: 门店组织List
	 * </p>
	 * 
	 */
	@ApiOperation(value = "SMP(门店组织List)", notes = "门店组织List", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/api/apig/otd/getOrglist", method = RequestMethod.GET)
	@ApiOperationSupport(order = 1)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "channel", value = "渠道码", required = true, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "orgType", value = "组织类型,组织类型:DB0018 1:总公司;2:大区;3:子公司;4:交付中心;5:高合中心", required = false, paramType = "query", dataType = "String") })
	@JsonPropFilter(type = String.class)
	public RestResponse<String> getOrglist(@RequestParam(value = "channel", required = true) String channel,
			@RequestParam(value = "orgType", required = false) String orgType) {
		try {
			String result = smpConsumer.getOrglist(channel, orgType);
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
	@ApiOperation(value = "SMP(门店信息)", notes = " 门店信息", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/api/apig/otd/getOrginfo", method = RequestMethod.GET)
	@ApiOperationSupport(order = 2)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "channel", value = "渠道码", required = true, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "orgCode", value = "orgCode和dcDlrId必传其一", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "dcDlrId", value = "orgCode和dcDlrId必传其一", required = false, paramType = "query", dataType = "String") })
	@JsonPropFilter(type = String.class)
	public RestResponse<String> getOrginfo(@RequestParam(value = "channel", required = true) String channel,
			@RequestParam(value = "orgCode", required = false) String orgCode,
			@RequestParam(value = "dcDlrId", required = false) String dcDlrId) {
		try {
			String result = smpConsumer.getOrginfo(channel, orgCode,dcDlrId);
			return new RestResponse<>(result);
		} catch (Exception e) {
			LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
			return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
		}
	}
	
	/**
	 * <p>
	 * Description: 外围系统获取订单详情
	 * </p>
	 * 
	 */
	@ApiOperation(value = "SMP获取订单详情", notes = "获取订单详情", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/api/apig/otd/order/detailed", method = RequestMethod.GET)
	@ApiOperationSupport(order = 3)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "channel", value = "渠道码", required = true, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "orderNum", value = "订单号", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "vin", value = "VIN码，订单号和VIN码必填一项", required = false, paramType = "query", dataType = "String") })
	@JsonPropFilter(type = String.class)
	public RestResponse<String> getOrderDetail(@RequestParam(value = "channel", required = true) String channel,
			@RequestParam(value = "orderNum", required = false) String orderNum,
			@RequestParam(value = "vin", required = false) String vin) {
		try {
			String result = smpConsumer.getOrderDetail(channel, orderNum,vin);
			return new RestResponse<>(result);
		} catch (Exception e) {
			LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
			return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
		}
	}
	
	/**
	 * <p>
	 * Description: 车型产品-工程车型
	 * </p>
	 * 
	 */
	@ApiOperation(value = "SMP获取车型产品-工程车型", notes = "获取车型产品-工程车型", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/api/apig/otd/getCarseries", method = RequestMethod.GET)
	@ApiOperationSupport(order = 4)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "channel", value = "渠道码", required = true, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "carSeriesCode", value = "工程车型编码,不传查全量", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "allVcc", value = "是否查询全量信息,不传默认false，true查全部工程车型，false查默认销售配置下工程车型", required = false, paramType = "query", dataType = "Boolean"),
			@ApiImplicitParam(name = "saleConfId", value = "销售配置ID，不传查默认销售配置下工程车型", required = false, paramType = "query", dataType = "String")})
	@JsonPropFilter(type = String.class)
	public RestResponse<String> getCarseries(@RequestParam(value = "channel", required = true) String channel,
			@RequestParam(value = "carSeriesCode", required = false) String carSeriesCode,
			@RequestParam(value = "allVcc", required = false) Boolean allVcc,
			@RequestParam(value = "saleConfId", required = false) String saleConfId) {
		try {
			String result = smpConsumer.getCarseries(channel, carSeriesCode, allVcc, saleConfId);
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
	@RequestMapping(value = "/api/apig/otd/getCartype", method = RequestMethod.GET)
	@ApiOperationSupport(order = 5)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "channel", value = "渠道码", required = true, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "carSeriesCode", value = "工程车型编码", required = true, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "allVcc", value = "是否查询全量信息,不传默认false，true查全部工程车型，false查默认销售配置下工程车型", required = false, paramType = "query", dataType = "Boolean"),
			@ApiImplicitParam(name = "saleConfId", value = "销售配置ID，不传查默认销售配置下工程车型", required = false, paramType = "query", dataType = "String")})
	@JsonPropFilter(type = String.class)
	public RestResponse<String> getCartype(@RequestParam(value = "channel", required = true) String channel,
			@RequestParam(value = "carSeriesCode", required = true) String carSeriesCode,
			@RequestParam(value = "allVcc", required = false) Boolean allVcc,
			@RequestParam(value = "saleConfId", required = false) String saleConfId) {
		try {
			String result = smpConsumer.getCartype(channel, carSeriesCode, allVcc, saleConfId);
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
	@RequestMapping(value = "/api/apig/otd/getVehicleproduct", method = RequestMethod.GET)
	@ApiOperationSupport(order = 6)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "channel", value = "渠道码", required = true, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "saleConfId", value = "销售配置ID，不传查默认销售配置下工程车型", required = false, paramType = "query", dataType = "String")})
	@JsonPropFilter(type = String.class)
	public RestResponse<String> getVehicleproduct(@RequestParam(value = "channel", required = true) String channel,
			@RequestParam(value = "saleConfId", required = false) String saleConfId) {
		try {
			String result = smpConsumer.getVehicleproduct(channel, saleConfId);
			return new RestResponse<>(result);
		} catch (Exception e) {
			LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
			return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
		}
	}
	
	/**
	 * <p>
	 * Description: 获取交付中心下所有人员数据
	 * </p>
	 * 
	 */
	@ApiOperation(value = "SMP获取获取交付中心所有人员数据", notes = "获取获取交付中心所有人员数据", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/api/apig/ucmp/v1/allUsersInTheDepartment", method = RequestMethod.GET)
	@ApiOperationSupport(order = 7)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "departmentId", value = "门店code", required = true, paramType = "query", dataType = "String")})
	@JsonPropFilter(type = String.class)
	public RestResponse<String> allUsersInTheDepartment(@RequestParam(value = "departmentId", required = true) String departmentId) {
		try {
			String result = smpConsumer.allUsersInTheDepartment(departmentId);
			return new RestResponse<>(result);
		} catch (Exception e) {
			LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
			return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
		}
	}
	
	/**
	 * <p>
	 * Description: 获取交付中心下单个顾问信息
	 * </p>
	 * 
	 */
	@ApiOperation(value = "SMP获取获取交付中心下单个顾问信息", notes = "获取获取交付中心下单个顾问信息", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/api/apig/ucmp/v1/getUserAndSuperiorInfo", method = RequestMethod.GET)
	@ApiOperationSupport(order = 8)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "token", value = "当前用户token", required = true, paramType = "query", dataType = "String")})
	@JsonPropFilter(type = String.class)
	public RestResponse<String> getUserAndSuperiorInfo(@RequestParam(value = "token", required = true) String token) {
		try {
			String result = smpConsumer.getUserAndSuperiorInfo(token);
			return new RestResponse<>(result);
		} catch (Exception e) {
			LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
			return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
		}
	}
	
	/**
	 * <p>
	 * Description: 查询车辆信息以及车主信息
	 * </p>
	 * 
	 */
	@ApiOperation(value = "SMP查询车辆信息以及车主信息", notes = "查询车辆信息以及车主信息", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/api/apig/ucmp/v1/getCarInfoByVin", method = RequestMethod.GET)
	@ApiOperationSupport(order = 9)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "carVin", value = "carVin", required = true, paramType = "query", dataType = "String")})
	@JsonPropFilter(type = String.class)
	public RestResponse<String> getCarInfoByVin(@RequestParam(value = "carVin", required = true) String carVin) {
		try {
			String result = smpConsumer.getCarInfoByVin(carVin);
			return new RestResponse<>(result);
		} catch (Exception e) {
			LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
			return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
		}
	}
	
	@ApiOperation(value = "网上收银统一下单", notes = "网上收银统一下单", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/api/apig/payment/unitorder/pay", method = RequestMethod.POST)
	@ApiOperationSupport(order = 10)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "payDto", value = "统一下单接口参数类", required = true, paramType = "body", dataType = "PayDto")})
	@JsonPropFilter(type = MallReturnDto.class)
	public RestResponse<String> paymentUnitorderPay(@RequestBody PayDto payDto) {
		LOGGER.info("====网上收银统一下单===="+JsonBeanUtil.beanToJson(payDto));
		try {
			//根据车辆主体查询支付相关信息
			SysPayConfigPk sysPayConfigPk = new SysPayConfigPk(payDto.getRevertBody());
			sysPayConfigPk.setRevertBody("7903");
			SysPayConfigEntity sysPayConfigEntity = this.iSysPayConfigDao.load(sysPayConfigPk);
			String result = smpConsumer.paymentUnitorderPay(payDto,sysPayConfigEntity);
			return new RestResponse<>(RestStatusCode.OK,result);
		} catch (Exception e) {
			LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
			return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, "服务异常，请联系系统管理员");
		}
	}
	
	@ApiOperation(value = "退款", notes = "退款", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/api/apig/payment/refund", method = RequestMethod.POST)
	@ApiOperationSupport(order = 11)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "payRefundDto", value = "统一下单接口参数类", required = true, paramType = "body", dataType = "PayRefundDto")})
	@JsonPropFilter(type = String.class)
	public RestResponse<String> paymentRefund(@RequestBody PayRefundDto payRefundDto) {
		LOGGER.info("====退款===="+JsonBeanUtil.beanToJson(payRefundDto));
		try {
			String result = smpConsumer.paymentRefund(payRefundDto);
			return new RestResponse<>(RestStatusCode.OK,result);
		} catch (Exception e) {
			LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
			return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, "服务异常，请联系系统管理员");
		}
	}
}
