package com.exp.ucmp.pay.web;


import javax.servlet.http.HttpServletResponse;
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
import com.egrid.core.util.JsonBeanUtil;
import com.egrid.core.web.response.RestResponse;
import com.egrid.core.web.response.RestStatusCode;
import com.exp.ucmp.constant.Constants;
import com.exp.ucmp.entity.SysPayConfigEntity;
import com.exp.ucmp.mall.dto.MallReturnDto;
import com.exp.ucmp.pay.dto.AddPaymentRecordDto;
import com.exp.ucmp.pay.dto.PayCallBackDto;
import com.exp.ucmp.pay.dto.PayDto;
import com.exp.ucmp.pay.dto.PayMatchingDto;
import com.exp.ucmp.pay.dto.PayRefundDto;
import com.exp.ucmp.pay.dto.PayRejectDto;
import com.exp.ucmp.pay.dto.QueryBankStatementDto;
import com.exp.ucmp.pay.dto.QueryOrderInfoDto;
import com.exp.ucmp.pay.dto.QueryOrderParamsDto;
import com.exp.ucmp.pay.dto.QueryStatementParamsDto;
import com.exp.ucmp.pay.dto.RecordDetailsDto;
import com.exp.ucmp.pay.dto.StatementDetailsDto;
import com.exp.ucmp.pay.service.PayService;
import com.github.pagehelper.PageInfo;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author xiongneng
 * @date 2023年07月23日
 */
@Api(value = "PayController.API", tags = "支付相关接口")
@RefreshScope
@Controller
public class PayController {

	/**
	 * <p>
	 * Field LOGGER: log
	 * </p>
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(PayController.class);

	@Autowired
	PayService payService;
	
	@ApiOperation(value = "支付中心回调", notes = "支付中心回调", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/api/pay/call/back", method = RequestMethod.POST)
	@ApiOperationSupport(order = 1)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "payCallBackDto", value = "权益包创建参数类", required = true, paramType = "body", dataType = "PayCallBackDto")})
	@JsonPropFilter(type = MallReturnDto.class)
	public MallReturnDto<String> payCallBack(@RequestBody PayCallBackDto payCallBackDto) {
		LOGGER.info("====支付中心回调===="+JsonBeanUtil.beanToJson(payCallBackDto));
		MallReturnDto<String> returnDto=new MallReturnDto<>();
		try {
			payService.payCallBack(payCallBackDto);
			returnDto.setCode("000000");
            returnDto.setMsg("请求处理成功");
            returnDto.setData(payCallBackDto.getOrderNum());
		} catch (Exception e) {
			LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
			returnDto.setCode("50001");
            returnDto.setMsg(e.toString());
		}
		return returnDto;
	}
	
	@ApiOperation(value = "支付宝或微信或POS支付接口", notes = "支付宝或微信或POS支付接口", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/api/payment/unitorder/pay", method = RequestMethod.POST)
	@ApiOperationSupport(order = 2)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "payDto", value = "统一下单接口参数类", required = true, paramType = "body", dataType = "PayDto")})
	@JsonPropFilter(type = String.class)
	public RestResponse<String> paymentUnitorderPay(@RequestBody PayDto payDto) {
		LOGGER.info("====网上收银统一下单===="+JsonBeanUtil.beanToJson(payDto));
		try {
			String result = payService.paymentUnitorderPay(payDto);
			return new RestResponse<>(RestStatusCode.OK,result);
		} catch (Exception e) {
			LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
			return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e.getMessage());
		}
	}
	
	@ApiOperation(value = "退款", notes = "退款", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/api/payment/refund", method = RequestMethod.POST)
	@ApiOperationSupport(order = 3)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "payRefundDto", value = "统一下单接口参数类", required = true, paramType = "body", dataType = "PayRefundDto")})
	@JsonPropFilter(type = String.class)
	public RestResponse<String> paymentRefund(@RequestBody PayRefundDto payRefundDto) {
		LOGGER.info("====退款===="+JsonBeanUtil.beanToJson(payRefundDto));
		try {
			String result = payService.paymentRefund(payRefundDto);
			return new RestResponse<>(RestStatusCode.OK,result);
		} catch (Exception e) {
			LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
			return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, "服务异常，请联系系统管理员");
		}
	}
	
	@ApiOperation(value = "查询车辆主体支付相关配置参数", notes = "查询车辆主体支付相关配置参数", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/api/revertBody/pay/info", method = RequestMethod.GET)
	@ApiOperationSupport(order = 4)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "revertBody", value = "车辆主体code", required = true, paramType ="query", dataType = "String")})
	@JsonPropFilter(type = SysPayConfigEntity.class)
	public RestResponse<SysPayConfigEntity> revertBodyPayInfo(@RequestParam("revertBody") String revertBody) {
		LOGGER.info("====查询车辆主体支付相关信息===="+revertBody);
		try {
			SysPayConfigEntity result = payService.revertBodyPayInfo(revertBody);
			return new RestResponse<>(RestStatusCode.OK,result);
		} catch (Exception e) {
			LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
			return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
		}
	}
	
	@ApiOperation(value = "线下付款(转账或现金添加付款记录)", notes = "线下付款(转账或现金添加付款记录)", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/api/add/payment/record", method = RequestMethod.POST)
	@ApiOperationSupport(order = 5)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "addPaymentRecordDto", value = "线下付款(转账或现金添加付款记录)参数类", required = true, paramType = "body", dataType = "AddPaymentRecordDto")})
	@JsonPropFilter(type = Boolean.class)
	public RestResponse<Boolean> addPaymentRecord(@RequestBody AddPaymentRecordDto addPaymentRecordDto) {
		LOGGER.info("====线下付款(转账或现金添加付款记录)===="+JsonBeanUtil.beanToJson(addPaymentRecordDto));
		try {
			Boolean result = payService.addPaymentRecord(addPaymentRecordDto);
			return new RestResponse<>(RestStatusCode.OK,result);
		} catch (Exception e) {
			LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
			return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
		}
	}
	
	@ApiOperation(value = "查询收款记录列表", notes = "查询收款记录列表", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/api/query/payment/record/info", method = RequestMethod.POST)
	@ApiOperationSupport(order = 6)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "queryOrderParamsDto", value = "查询订单信息参数类", required = true, paramType = "body", dataType = "QueryOrderParamsDto")})
	@JsonPropFilter(type = PageInfo.class)
	public RestResponse<PageInfo<QueryOrderInfoDto>> queryPaymentRecordInfo(@RequestBody @Valid QueryOrderParamsDto queryOrderParamsDto) {
		LOGGER.info("====查询收款记录列表===="+JsonBeanUtil.beanToJson(queryOrderParamsDto));
		if(queryOrderParamsDto.getStaffType().equals(Constants.StaffType.store.value())&&queryOrderParamsDto.getDeliveryStore()==null){
    		return new RestResponse<>(RestStatusCode.INVALID_PARAMS_CONVERSION);
    	}
		try {
			PageInfo<QueryOrderInfoDto> list = payService.queryPaymentRecordInfo(queryOrderParamsDto);
			return new RestResponse<>(RestStatusCode.OK,list);
		} catch (Exception e) {
			LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
			return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
		}
	}
	
	@ApiOperation(value = "导出收款记录列表", notes = "导出收款记录列表", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	@RequestMapping(value = "/api/export/payment/record/info", method = RequestMethod.POST)
	@ApiOperationSupport(order = 7)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "queryOrderParamsDto", value = "查询订单信息参数类", required = true, paramType = "body", dataType = "QueryOrderParamsDto")})
	@JsonPropFilter(type = MallReturnDto.class)
	public void exportPaymentRecordInfo(@RequestBody QueryOrderParamsDto queryOrderParamsDto, HttpServletResponse response) {
		LOGGER.info("====导出收款记录列表===="+JsonBeanUtil.beanToJson(queryOrderParamsDto));
		try {
			payService.exportPaymentRecordInfo(queryOrderParamsDto,response);
		} catch (Exception e) {
			LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
		}
	}
	
	@ApiOperation(value = "查询收款详情", notes = "查询收款详情", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/api/query/payment/record/details", method = RequestMethod.GET)
	@ApiOperationSupport(order = 8)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "recordCode", value = "收款单号", required = true, paramType ="query", dataType = "String")})
	@JsonPropFilter(type = RecordDetailsDto.class)
	public RestResponse<RecordDetailsDto> queryPaymentRecordDetails(@RequestParam("recordCode") String recordCode) {
		LOGGER.info("====查询收款详情===="+recordCode);
		try {
			RecordDetailsDto result = payService.queryPaymentRecordDetails(recordCode);
			return new RestResponse<>(RestStatusCode.OK,result);
		} catch (Exception e) {
			LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
			return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
		}
	}
	
	@ApiOperation(value = "查询可匹配流水列表", notes = "查询可匹配流水列表", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/api/query/bank/statement/info", method = RequestMethod.POST)
	@ApiOperationSupport(order = 9)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "queryStatementParamsDto", value = "查询订单信息参数类", required = true, paramType = "body", dataType = "QueryStatementParamsDto")})
	@JsonPropFilter(type = PageInfo.class)
	public RestResponse<PageInfo<QueryBankStatementDto>> queryBankStatementInfo(@RequestBody QueryStatementParamsDto queryStatementParamsDto) {
		LOGGER.info("====查询可匹配流水列表===="+JsonBeanUtil.beanToJson(queryStatementParamsDto));
		try {
			PageInfo<QueryBankStatementDto> list = payService.queryBankStatementInfo(queryStatementParamsDto);
			return new RestResponse<>(RestStatusCode.OK,list);
		} catch (Exception e) {
			LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
			return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
		}
	}
	
	@ApiOperation(value = "收款驳回", notes = "收款驳回", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/api/reject/pay/info", method = RequestMethod.POST)
	@ApiOperationSupport(order = 10)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "payRejectDto", value = "驳回收款参数类", required = true, paramType = "body", dataType = "PayRejectDto")})
	@JsonPropFilter(type = String.class)
	public RestResponse<String> rejectPayInfo(@RequestBody PayRejectDto payRejectDto) {
		LOGGER.info("====收款驳回===="+JsonBeanUtil.beanToJson(payRejectDto));
		try {
			payService.rejectPayInfo(payRejectDto);
			return new RestResponse<>(RestStatusCode.OK,"true");
		} catch (Exception e) {
			LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
			return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
		}
	}
	
	@ApiOperation(value = "收款匹配", notes = "收款匹配", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/api/matching/pay/info", method = RequestMethod.POST)
	@ApiOperationSupport(order = 11)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "payMatchingDto", value = "匹配收款参数类", required = true, paramType = "body", dataType = "PayMatchingDto")})
	@JsonPropFilter(type = Object.class)
	public RestResponse<String> matchingPayInfo(@RequestBody PayMatchingDto payMatchingDto) {
		LOGGER.info("====收款匹配===="+JsonBeanUtil.beanToJson(payMatchingDto));
		try {
			int result = payService.matchingPayInfo(payMatchingDto);
			if(result == 1){
				return new RestResponse<>(RestStatusCode.OK,"true");
			}else if(result == -1){
				return new RestResponse<>(RestStatusCode.OK,"操作失败，存在已匹配的流水");
			}else if(result == -2){
				return new RestResponse<>(RestStatusCode.OK,"操作失败，该流水暂时不能匹配，请搜索重试");
			}else{
				return new RestResponse<>(RestStatusCode.OK,"操作失败，请联系系统管理员");
			}
		} catch (Exception e) {
			LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
			return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
		}
	}
	
	@ApiOperation(value = "收款确认", notes = "收款确认", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/api/verify/pay/info", method = RequestMethod.POST)
	@ApiOperationSupport(order = 12)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "statementDetailsDto", value = "收款确认参数类", required = true, paramType = "body", dataType = "StatementDetailsDto")})
	@JsonPropFilter(type = Object.class)
	public RestResponse<String> verifyPayInfo(@RequestBody StatementDetailsDto statementDetailsDto) {
		LOGGER.info("====收款确认===="+JsonBeanUtil.beanToJson(statementDetailsDto));
		try {
			int result = payService.verifyPayInfo(statementDetailsDto);
			if(result == 1){
				return new RestResponse<>(RestStatusCode.OK,"true");
			}else if(result == -1){
				return new RestResponse<>(RestStatusCode.OK,"操作失败，存在已匹配的流水");
			}else{
				return new RestResponse<>(RestStatusCode.OK,"操作失败，请联系系统管理员");
			}
		} catch (Exception e) {
			LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
			return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
		}
	}
	
	@ApiOperation(value = "收款解绑", notes = "收款解绑", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/api/unbind/pay/info", method = RequestMethod.POST)
	@ApiOperationSupport(order = 12)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "payMatchingDto", value = "收款确认参数类", required = true, paramType = "body", dataType = "PayMatchingDto")})
	@JsonPropFilter(type = Object.class)
	public RestResponse<String> unbindPayInfo(@RequestBody PayMatchingDto payMatchingDto) {
		LOGGER.info("====收款解绑===="+JsonBeanUtil.beanToJson(payMatchingDto));
		try {
			int result = payService.unbindPayInfo(payMatchingDto);
			if(result == 1){
				return new RestResponse<>(RestStatusCode.OK,"true");
			}else if(result == -1){
				return new RestResponse<>(RestStatusCode.OK,"操作失败，存在已匹配的流水");
			}else{
				return new RestResponse<>(RestStatusCode.OK,"操作失败，请联系系统管理员");
			}
		} catch (Exception e) {
			LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
			return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
		}
	}
}
