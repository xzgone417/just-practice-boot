package com.exp.ucmp.salesDelivery.web;


import java.util.List;

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
import com.exp.ucmp.salesDelivery.dto.DeliveryOrderContractDto;
import com.exp.ucmp.salesDelivery.dto.DeliveryOrderDetailsDto;
import com.exp.ucmp.salesDelivery.dto.DeliveryOrderDto;
import com.exp.ucmp.salesDelivery.dto.DeliveryOrderFinancialDto;
import com.exp.ucmp.salesDelivery.dto.DeliveryOrderParamDto;
import com.exp.ucmp.salesDelivery.dto.DeliveryOrderPicDto;
import com.exp.ucmp.salesDelivery.dto.DeliveryOrderStatisticsDto;
import com.exp.ucmp.salesDelivery.dto.OrderCarTransferDto;
import com.exp.ucmp.salesDelivery.dto.OrderCarTransferInfoDto;
import com.exp.ucmp.salesDelivery.dto.OrderDeliveryProfileDto;
import com.exp.ucmp.salesDelivery.dto.OrderPaymentInfoDto;
import com.exp.ucmp.salesDelivery.dto.OrderPdiInfoDto;
import com.exp.ucmp.salesDelivery.service.SalesDelivryService;
import com.exp.ucmp.storeApp.dto.OneselfAcquirerDto;
import com.github.pagehelper.PageInfo;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "二手车销售交付", tags = "二手车销售交付相关接口")
@RefreshScope
@Controller
public class SalesDelivryController {
	
	/**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(SalesDelivryController.class);
    
    @Autowired
    private SalesDelivryService salesDelivryService;

    @ApiOperation(value = "查询门店销售交付订单列表", notes = "查询门店销售交付订单列表", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/store/sales/delivry/order/list", method = RequestMethod.POST)
    @ApiOperationSupport(order = 1)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "deliveryOrderParamDto", value = "参数信息", required = true, paramType ="body", dataType = "DeliveryOrderParamDto")
    })
    @JsonPropFilter(type = DeliveryOrderDto.class)
    public RestResponse<PageInfo<DeliveryOrderDto>> delivryOrderList(@RequestBody DeliveryOrderParamDto deliveryOrderParamDto) {
		try {
			PageInfo<DeliveryOrderDto> reservationList = this.salesDelivryService.delivryOrderList(deliveryOrderParamDto);
			return new RestResponse<>(reservationList);
		} catch (Exception e) {
			LOGGER.error("===查询门店销售交付订单列表异常===",e);
			return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
		}
    }
    
    @ApiOperation(value = "查询交付中心交付顾问列表", notes = "查询交付中心交付顾问列表", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/store/delivry/consultant/list", method = RequestMethod.GET)
    @ApiOperationSupport(order = 2)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "storeId", value = "门店ID", required = false, paramType ="query", dataType = "Long"),
        @ApiImplicitParam(name = "searchWord", value = "搜索词", required = false, paramType ="query", dataType = "String"),
        @ApiImplicitParam(name = "staffType", value = "人员类型,总部 0010 门店 0020", required = false, paramType ="query", dataType = "String")
    })
    @JsonPropFilter(type = OneselfAcquirerDto.class)
    public RestResponse<List<OneselfAcquirerDto>> delivryConsultantList(@RequestParam(value="storeId", required = false) Long storeId,
    		@RequestParam(value ="searchWord" , required = false) String searchWord,
    		@RequestParam(value ="staffType" , required = false,defaultValue="0020") String staffType) {
    	if(staffType.equals(Constants.StaffType.store.value())&&storeId==null){
    		return new RestResponse<>(RestStatusCode.INVALID_PARAMS_CONVERSION);
    	}
    	try{
    		List<OneselfAcquirerDto> oneselfAcquirerDto = this.salesDelivryService.delivryConsultantList(storeId,searchWord,staffType);
    		return new RestResponse<>(oneselfAcquirerDto);
    	}catch (Exception e) {
    		LOGGER.error("===查询交付中心交付顾问列表===",e);
    		return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
		}
    }
    
    @ApiOperation(value = "分配交付顾问", notes = "分配交付顾问", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/store/allot/delivry/consultant", method = RequestMethod.GET)
    @ApiOperationSupport(order = 3)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "orderInfoId", value = "订单id", required = true, paramType ="query", dataType = "Long"),
        @ApiImplicitParam(name = "partyId", value = "顾问id", required = true, paramType ="query", dataType = "Long"),
        @ApiImplicitParam(name = "storeId", value = "交付中心id", required = false, paramType ="query", dataType = "Long")
    })
    @JsonPropFilter(type = Object.class)
    public RestResponse<Object> allotDelivryConsultant(@RequestParam("orderInfoId") Long orderInfoId,@RequestParam("partyId") Long partyId,
    		@RequestParam(value="storeId",required=false) Long storeId) {
    	try{
    		int flag = this.salesDelivryService.allotDelivryConsultant(orderInfoId,partyId,storeId);
    		if(flag == 0){
    			return new RestResponse<>(true);
    		}else if(flag == 1){
    			return new RestResponse<>(RestStatusCode.OK, "顾问不存在");
    		}else{
    			return new RestResponse<>(RestStatusCode.OK, "订单不可分配");
    		}
    	}catch (Exception e) {
    		LOGGER.error("===分配交付顾问异常===",e);
    		return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
		}
    }
    
    @ApiOperation(value = "查询销售交付订单详情", notes = "查询销售交付订单详情", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/store/sales/delivry/order/details", method = RequestMethod.GET)
    @ApiOperationSupport(order = 4)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "orderInfoId", value = "订单id", required = true, paramType ="query", dataType = "Long"),
        @ApiImplicitParam(name = "roleCode", value = "角色code", required = true, paramType ="query", dataType = "String")
    })
    @JsonPropFilter(type = DeliveryOrderDetailsDto.class)
    public RestResponse<DeliveryOrderDetailsDto> delivryOrderDetails(@RequestParam("orderInfoId") Long orderInfoId,@RequestParam("roleCode") String roleCode) {
    	try{
    		DeliveryOrderDetailsDto dto = this.salesDelivryService.orderDetails(orderInfoId,roleCode);
			return new RestResponse<>(dto);
    	}catch (Exception e) {
    		LOGGER.error("===查询销售交付订单详情异常===",e);
    		return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
		}
    }
    
    @ApiOperation(value = "上传合同附件", notes = "上传合同附件", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/store/contract/save", method = RequestMethod.POST)
    @ApiOperationSupport(order = 5)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "dto", value = "参数信息", required = true, paramType ="body", dataType = "DeliveryOrderContractDto")
    })
    @JsonPropFilter(type = Boolean.class)
    public RestResponse<Boolean> contractSave(@RequestBody DeliveryOrderContractDto dto) {
    	try{
    		this.salesDelivryService.contractSave(dto);
    	}catch (Exception e) {
    		LOGGER.error("===上传合同附件异常===",e);
    		return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, false);
		}
		return new RestResponse<>(RestStatusCode.OK,true);
    }
    
    @ApiOperation(value = "查询销售交付订单合同材料", notes = "查询销售交付订单合同材料", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/store/contract/list", method = RequestMethod.GET)
    @ApiOperationSupport(order = 6)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "orderInfoId", value = "订单id", required = true, paramType ="query", dataType = "Long")
    })
    @JsonPropFilter(type = DeliveryOrderPicDto.class)
    public RestResponse<List<DeliveryOrderPicDto>> contractList(@RequestParam("orderInfoId") Long orderInfoId) {
    	try{
    		List<DeliveryOrderPicDto> dto = this.salesDelivryService.contractList(orderInfoId);
			return new RestResponse<>(dto);
    	}catch (Exception e) {
    		LOGGER.error("===查询销售交付订单合同材料异常===",e);
    		return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
		}
    }
    
    @ApiOperation(value = "发起物流调拨申请", notes = "发起物流调拨申请", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/store/transfer/apply", method = RequestMethod.POST)
    @ApiOperationSupport(order = 7)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "dto", value = "参数信息", required = true, paramType ="body", dataType = "OrderCarTransferDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<String> transferApply(@RequestBody OrderCarTransferDto dto) {
    	try{
    		Long result = this.salesDelivryService.transferApply(dto);
    		if(result == -1){
    			return new RestResponse<>(RestStatusCode.OK,"大定未支付，无法申请调拨");
    		}else if(result == -2){
    			return new RestResponse<>(RestStatusCode.OK,"订单车辆不存在，无法申请调拨");
    		}else if(result == -3){
    			return new RestResponse<>(RestStatusCode.OK,"存在未完成或未取消的调拨申请，无法再次申请");
    		}else{
    			return new RestResponse<>(RestStatusCode.OK,result.toString());
    		}
    	}catch (Exception e) {
    		LOGGER.error("===发起物流调拨申请异常===",e);
    		return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
		}
    }
    
    @ApiOperation(value = "查询物流调拨申请信息", notes = "查询物流调拨申请信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/store/transfer/apply/info", method = RequestMethod.GET)
    @ApiOperationSupport(order = 8)
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "orderInfoId", value = "订单id", required = true, paramType ="query", dataType = "Long"),
        @ApiImplicitParam(name = "roleCode", value = "角色code", required = true, paramType ="query", dataType = "String")
    })
    @JsonPropFilter(type = OrderCarTransferInfoDto.class)
    public RestResponse<OrderCarTransferInfoDto> transferApplyInfo(@RequestParam("orderInfoId") Long orderInfoId,@RequestParam("roleCode") String roleCode) {
    	try{
    		OrderCarTransferInfoDto result = this.salesDelivryService.transferApplyInfo(orderInfoId,roleCode);
    		return new RestResponse<>(RestStatusCode.OK,result);
    	}catch (Exception e) {
    		LOGGER.error("===查询物流调拨申请信息异常===",e);
    		return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
		}
    }
    
    @ApiOperation(value = "取消物流调拨申请", notes = "取消物流调拨申请", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/store/transfer/apply/cancel", method = RequestMethod.GET)
    @ApiOperationSupport(order = 9)
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "orderInfoId", value = "订单id", required = true, paramType ="query", dataType = "Long"),
        @ApiImplicitParam(name = "roleCode", value = "角色code", required = true, paramType ="query", dataType = "String")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<String> transferCancel(@RequestParam("orderInfoId") Long orderInfoId,@RequestParam("roleCode") String roleCode) {
    	try{
    		Integer result = this.salesDelivryService.transferCancel(orderInfoId,roleCode);
    		if(result == -1){
    			return new RestResponse<>(RestStatusCode.OK,"当前角色无权限");
    		}else if(result == -2){
    			return new RestResponse<>(RestStatusCode.OK,"调拨不存在或已取消");
    		}else{
    			return new RestResponse<>(RestStatusCode.OK,"1");
    		}
    	}catch (Exception e) {
    		LOGGER.error("===取消物流调拨申请异常===",e);
    		return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
		}
    }
    
    @ApiOperation(value = "查询付款与资金单信息", notes = "查询付款与资金单信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/store/payment/info", method = RequestMethod.GET)
    @ApiOperationSupport(order = 10)
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "orderInfoId", value = "订单id", required = true, paramType ="query", dataType = "Long"),
        @ApiImplicitParam(name = "roleCode", value = "角色code", required = true, paramType ="query", dataType = "String")
    })
    @JsonPropFilter(type = OrderPaymentInfoDto.class)
    public RestResponse<OrderPaymentInfoDto> paymentInfo(@RequestParam("orderInfoId") Long orderInfoId,@RequestParam("roleCode") String roleCode) {
    	try{
    		OrderPaymentInfoDto result = this.salesDelivryService.paymentInfo(orderInfoId,roleCode);
    		return new RestResponse<>(RestStatusCode.OK,result);
    	}catch (Exception e) {
    		LOGGER.error("===查询付款与资金单信息异常===",e);
    		return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
		}
    }
    
    @ApiOperation(value = "提交金融凭证", notes = "提交金融凭证", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/store/submit/financial/proof", method = RequestMethod.POST)
    @ApiOperationSupport(order = 11)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "dto", value = "参数信息", required = true, paramType ="body", dataType = "DeliveryOrderFinancialDto")
    })
    @JsonPropFilter(type = Boolean.class)
    public RestResponse<Object> submitFinancialProof(@RequestBody DeliveryOrderFinancialDto dto) {
    	LOGGER.info("=====提交金融凭证====="+JsonBeanUtil.beanToJson(dto));
    	try{
    		int result = this.salesDelivryService.submitFinancialProof(dto);
    		if(result == -1){
    			return new RestResponse<>(RestStatusCode.OK,"上传的凭证金额总和不能超过未收金额");
    		}else if(result == -2){
    			return new RestResponse<>(RestStatusCode.OK,"当前人员无操作权限");
    		}else{
    			return new RestResponse<>(RestStatusCode.OK,true);
    		}
    	}catch (Exception e) {
    		LOGGER.error("===提交金融凭证===",e);
    		return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, false);
		}
    }
    
    @ApiOperation(value = "查询PDI信息", notes = "查询PDI信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/store/pdi/info", method = RequestMethod.GET)
    @ApiOperationSupport(order = 12)
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "orderInfoId", value = "订单id", required = true, paramType ="query", dataType = "Long"),
        @ApiImplicitParam(name = "roleCode", value = "角色code", required = true, paramType ="query", dataType = "String")
    })
    @JsonPropFilter(type = OrderPdiInfoDto.class)
    public RestResponse<OrderPdiInfoDto> pdiInfo(@RequestParam("orderInfoId") Long orderInfoId,@RequestParam("roleCode") String roleCode) {
    	try{
    		OrderPdiInfoDto result = this.salesDelivryService.pdiInfo(orderInfoId,roleCode);
    		return new RestResponse<>(RestStatusCode.OK,result);
    	}catch (Exception e) {
    		LOGGER.error("===查询PDI信息异常===",e);
    		return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
		}
    }
    
    @ApiOperation(value = "提交或保存PDI检测信息", notes = "提交或保存PDI检测信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/store/submit/pdi/info", method = RequestMethod.POST)
    @ApiOperationSupport(order = 13)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "dto", value = "参数信息", required = true, paramType ="body", dataType = "OrderPdiInfoDto")
    })
    @JsonPropFilter(type = Boolean.class)
    public RestResponse<Boolean> submitPdiInfo(@RequestBody OrderPdiInfoDto dto) {
    	try{
    		this.salesDelivryService.submitPdiInfo(dto);
    	}catch (Exception e) {
    		LOGGER.error("===提交或保存PDI检测信息异常===",e);
    		return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, false);
		}
		return new RestResponse<>(RestStatusCode.OK,true);
    }
    
    @ApiOperation(value = "查询交付确认资料和主用车人信息", notes = "查询交付确认资料和主用车人信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/store/delivery/profile", method = RequestMethod.GET)
    @ApiOperationSupport(order = 14)
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "orderInfoId", value = "订单id", required = true, paramType ="query", dataType = "Long"),
        @ApiImplicitParam(name = "roleCode", value = "角色code", required = true, paramType ="query", dataType = "String")
    })
    @JsonPropFilter(type = OrderDeliveryProfileDto.class)
    public RestResponse<OrderDeliveryProfileDto> deliveryProfile(@RequestParam("orderInfoId") Long orderInfoId,@RequestParam("roleCode") String roleCode) {
    	try{
    		OrderDeliveryProfileDto result = this.salesDelivryService.deliveryProfile(orderInfoId,roleCode);
    		return new RestResponse<>(RestStatusCode.OK,result);
    	}catch (Exception e) {
    		LOGGER.error("===查询交付确认资料和主用车人信息异常===",e);
    		return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
		}
    }
    
    @ApiOperation(value = "提交或保存交付确认资料和主用车人信息", notes = "提交或保存交付确认资料和主用车人信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/store/submit/delivery/profile", method = RequestMethod.POST)
    @ApiOperationSupport(order = 15)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "dto", value = "参数信息", required = true, paramType ="body", dataType = "OrderDeliveryProfileDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<String> submitDeliveryProfile(@RequestBody OrderDeliveryProfileDto dto) {
    	try{
    		int flag = this.salesDelivryService.submitDeliveryProfile(dto);
    		if(flag == -1){
    			return new RestResponse<>(RestStatusCode.OK,"全款未支付，无法提交");
    		}else if(flag == -2){
    			return new RestResponse<>(RestStatusCode.OK,"PDI未完成，无法提交");
    		}else if(flag == -3){
    			return new RestResponse<>(RestStatusCode.OK,"登记证图片未上传，无法提交");
    		}else if(flag == -4){
    			return new RestResponse<>(RestStatusCode.OK,"行驶证图片未上传，无法提交");
    		}else if(flag == -5){
    			return new RestResponse<>(RestStatusCode.OK,"交付确认书未上传，无法提交");
    		}else if(flag == -6){
    			return new RestResponse<>(RestStatusCode.OK,"主用车人姓名或手机号未填写，无法提交");
    		}else{
    			return new RestResponse<>(RestStatusCode.OK,"1");
    		}
    	}catch (Exception e) {
    		LOGGER.error("===提交或保存交付确认资料和主用车人信息异常===",e);
    		return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
		}
    }
    
    @ApiOperation(value = "查询官二交付首页数据统计", notes = "查询官二交付首页数据统计", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/sales/acquisition/statistics", method = RequestMethod.GET)
    @ApiOperationSupport(order = 16)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "userId", value = "用户ID", required = true, paramType ="query", dataType = "String"),
        @ApiImplicitParam(name = "departmentId", value = "门店code", required = true, paramType ="query", dataType = "String")
    })
    @JsonPropFilter(type = DeliveryOrderStatisticsDto.class)
    public RestResponse<DeliveryOrderStatisticsDto> statistics(@RequestParam("userId") String userId,@RequestParam("departmentId") String departmentId,
    		@RequestParam("roleCode") String roleCode) {
    	DeliveryOrderStatisticsDto deliveryOrderStatisticsDto = this.salesDelivryService.statistics(userId,departmentId,roleCode);
		return new RestResponse<>(RestStatusCode.OK,deliveryOrderStatisticsDto);
    }
}
