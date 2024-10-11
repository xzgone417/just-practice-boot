package com.exp.ucmp.newcarorder.web;

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
import com.exp.ucmp.newcarorder.service.NewCarOrderService;
import com.exp.ucmp.smp.dto.NewCarOrderDto;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.xxl.job.core.biz.model.ReturnT;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author Yiyongfei
 * @date 2022年07月12日
 */
@Api(value = "NewCarOrderController.API", tags = "新车订单接口")
@RefreshScope
@Controller
public class NewCarOrderController {

	/**
	 * <p>
	 * Field LOGGER: log
	 * </p>
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(NewCarOrderController.class);

	@Autowired
	private NewCarOrderService newCarOrderService;

	/**
	 * <p>
	 * Description: 获取订单详情
	 * </p>
	 * 
	 */
	@ApiOperation(value = "获取订单详情", notes = "获取订单详情", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/api/otd/order/detailed", method = RequestMethod.GET)
	@ApiOperationSupport(order = 1)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "orderNum", value = "订单号", required = false, paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "vin", value = "VIN码，订单号和VIN码必填一项", required = false, paramType = "query", dataType = "String") })
	@JsonPropFilter(type = String.class)
	public RestResponse<NewCarOrderDto> getOrderDetail(@RequestParam(value = "orderNum", required = false) String orderNum,
			@RequestParam(value = "vin", required = false) String vin) {
		try {
			NewCarOrderDto result = newCarOrderService.getOrderDetail(orderNum,vin);
			return new RestResponse<>(result);
		} catch (Exception e) {
			LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
			return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
		}
	}
	
	/**
     * <p>Description: xxljob调试</p>
     */
    @ApiOperation(value = "xxljob调试", notes = "xxljob调试", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/xxljob/newcar/synorderstatus", method = RequestMethod.GET)
    @ApiOperationSupport(order = 1)
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "param", value = "参数", required = false, paramType ="query", dataType = "String")
    })
    @JsonPropFilter(type = String.class)
    public ReturnT<String> synorderstatus(@RequestParam(value="param", required=false)String param) throws Exception {
		try{
			this.newCarOrderService.synorderstatus();
			return ReturnT.SUCCESS;
		}catch(Exception e){
			LOGGER.error("同步emdm人员主数据异常："+e);
			return  ReturnT.FAIL;
		}
	}
}
