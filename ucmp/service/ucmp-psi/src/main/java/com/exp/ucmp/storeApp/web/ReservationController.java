package com.exp.ucmp.storeApp.web;


import java.util.List;

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
import com.exp.ucmp.eos.dto.ReservationDto;
import com.exp.ucmp.eos.dto.ReservationParamDto;
import com.exp.ucmp.storeApp.dto.AcquisitionWarehousingDto;
import com.exp.ucmp.storeApp.dto.OneselfAcquirerDto;
import com.exp.ucmp.storeApp.dto.OneselfAcquisitionDto;
import com.exp.ucmp.storeApp.dto.OneselfAcquisitionParamDto;
import com.exp.ucmp.storeApp.dto.OneselfOrderDetailsDto;
import com.exp.ucmp.storeApp.dto.OneselfOrderPicsDto;
import com.exp.ucmp.storeApp.dto.OneselfStatisticsDto;
import com.exp.ucmp.storeApp.dto.TransferOwnershipDto;
import com.exp.ucmp.storeApp.service.ReservationService;
import com.github.pagehelper.PageInfo;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "预约单", tags = "预约单相关接口")
@RefreshScope
@Controller
public class ReservationController {
	
	/**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ReservationController.class);
    
    @Autowired
    private ReservationService reservationService;

	/**
     * <p>
     * Description: 查询客户置换预约单列表
     * </p>
     * 
     */
    @ApiOperation(value = "查询客户置换预约单列表", notes = "查询客户置换预约单列表", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/customer/reservation/list", method = RequestMethod.POST)
    @ApiOperationSupport(order = 1)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "reservationparamdto", value = "参数信息", required = true, paramType ="body", dataType = "ReservationParamDto")
    })
    @JsonPropFilter(type = ReservationDto.class)
    public RestResponse<List<ReservationDto>> reservationList(@RequestBody ReservationParamDto reservationparamdto) {
		List<ReservationDto> reservationList = this.reservationService.reservationList(reservationparamdto);
		return new RestResponse<>(reservationList);
    }
    
    public static void main(String[] args) {
    	String result="[{\"trackId\":\"1903989714081387711\",\"vehicleBrand\":\"大众\",\"vehicleSeries\":\"迈腾\",\"vehicleYear\":\"2020款\",\"vehicleModel\":\"2020款迈腾1.4T自动280TSI领先型\",\"licensedCity\":\"上海\",\"licensedTime\":\"2020-10-01\",\"expectedPrice\":\"\",\"bestPrice\":\"\",\"detectionLocation\":\"华江路189号地下停车库\",\"detectionTime\":\"2022-09-28 10:00:00\",\"trackStatus\":\"0702\",\"trackStatusDesc\":\"已分配\",\"departmentId\":\"5622320210223614000\",\"organizationId\":809084},{\"trackId\":\"1903987304222009762\",\"vehicleBrand\":\"大众\",\"vehicleSeries\":\"迈腾\",\"vehicleYear\":\"2020款\",\"vehicleModel\":\"2020款迈腾1.4T自动280TSI领先型\",\"licensedCity\":\"上海\",\"licensedTime\":\"2020-10-01\",\"expectedPrice\":\"\",\"bestPrice\":\"\",\"detectionLocation\":\"华江路189号地下停车库\",\"detectionTime\":\"2022-08-28 12:00:00\",\"trackStatus\":\"0709\",\"trackStatusDesc\":\"已关闭\",\"departmentId\":\"5622320210223614000\",\"organizationId\":809084}]";
		List<ReservationDto> reservationList=JsonBeanUtil.jsonToBean(result, List.class);
		LOGGER.info("======"+JsonBeanUtil.beanToJson(reservationList));
	}
    
    @ApiOperation(value = "查询本品收购首页数据统计", notes = "查询本品收购首页数据统计", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/oneself/acquisition/statistics", method = RequestMethod.GET)
    @ApiOperationSupport(order = 2)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "userId", value = "用户ID", required = true, paramType ="query", dataType = "String"),
        @ApiImplicitParam(name = "departmentId", value = "门店code", required = true, paramType ="query", dataType = "String")
    })
    @JsonPropFilter(type = OneselfStatisticsDto.class)
    public RestResponse<OneselfStatisticsDto> statistics(@RequestParam("userId") String userId,@RequestParam("departmentId") String departmentId,
    		@RequestParam("roleCode") String roleCode) {
    	OneselfStatisticsDto oneselfStatisticsDto = this.reservationService.statistics(userId,departmentId,roleCode);
		return new RestResponse<>(RestStatusCode.OK,oneselfStatisticsDto);
    }
    
    @ApiOperation(value = "查询本品收购订单列表", notes = "查询本品收购订单列表", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/oneself/acquisition/list", method = RequestMethod.POST)
    @ApiOperationSupport(order = 3)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "paramDto", value = "参数信息", required = true, paramType ="body", dataType = "OneselfAcquisitionParamDto")
    })
    @JsonPropFilter(type = OneselfAcquisitionDto.class)
    public RestResponse<PageInfo<OneselfAcquisitionDto>> acquisitionList(@RequestBody @Valid OneselfAcquisitionParamDto paramDto) {
    	try{
    		PageInfo<OneselfAcquisitionDto> oneselfAcquisitionDto = this.reservationService.acquisitionList(paramDto);
    		return new RestResponse<>(RestStatusCode.OK,oneselfAcquisitionDto);
    	}catch (Exception e) {
    		LOGGER.error("===查询本品收购订单列表异常===",e);
    		return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
		}
    }
    
    @ApiOperation(value = "查询交付中心车辆支持列表", notes = "查询交付中心车辆支持列表", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/oneself/acquirer/list", method = RequestMethod.GET)
    @ApiOperationSupport(order = 4)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "storeId", value = "门店ID", required = true, paramType ="query", dataType = "Long"),
        @ApiImplicitParam(name = "searchWord", value = "搜索词", required = false, paramType ="query", dataType = "String")
    })
    @JsonPropFilter(type = OneselfAcquirerDto.class)
    public RestResponse<List<OneselfAcquirerDto>> acquirerList(@RequestParam("storeId") Long storeId,@RequestParam(value ="searchWord" , required = false) String searchWord) {
    	try{
    		List<OneselfAcquirerDto> oneselfAcquirerDto = this.reservationService.acquirerList(storeId,searchWord);
    		return new RestResponse<>(RestStatusCode.OK,oneselfAcquirerDto);
    	}catch (Exception e) {
    		LOGGER.error("===查询交付中心车辆支持列表===",e);
    		return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
		}
    }
    
    @ApiOperation(value = "分配车辆支持", notes = "分配车辆支持", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/oneself/allot/acquirer", method = RequestMethod.GET)
    @ApiOperationSupport(order = 5)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "inquiryId", value = "询价id", required = true, paramType ="query", dataType = "Long"),
        @ApiImplicitParam(name = "partyId", value = "顾问id", required = true, paramType ="query", dataType = "Long")
    })
    @JsonPropFilter(type = OneselfAcquirerDto.class)
    public RestResponse<Object> allotAcquirer(@RequestParam("inquiryId") Long inquiryId,@RequestParam("partyId") Long partyId) {
    	try{
    		int flag = this.reservationService.allotAcquirer(inquiryId,partyId);
    		if(flag == 0){
    			return new RestResponse<>(RestStatusCode.OK,true);
    		}else if(flag == 1){
    			return new RestResponse<>(RestStatusCode.OK, "顾问不存在或订单不可分配");
    		}else{
    			return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, "分配订单异常");
    		}
    	}catch (Exception e) {
    		LOGGER.error("===分配车辆支持异常===",e);
    		return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
		}
    }
    
    @ApiOperation(value = "查询本品订单详情", notes = "查询本品订单详情", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/oneself/order/details", method = RequestMethod.GET)
    @ApiOperationSupport(order = 6)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "inquiryId", value = "询价id", required = true, paramType ="query", dataType = "String"),
        @ApiImplicitParam(name = "roleCode", value = "角色code", required = true, paramType ="query", dataType = "String")
    })
    @JsonPropFilter(type = OneselfAcquirerDto.class)
    public RestResponse<OneselfOrderDetailsDto> orderDetails(@RequestParam("inquiryId") String inquiryId,@RequestParam("roleCode") String roleCode) {
    	try{
    		OneselfOrderDetailsDto dto = this.reservationService.orderDetails(Long.parseLong(inquiryId),roleCode);
			return new RestResponse<>(RestStatusCode.OK,dto);
    	}catch (Exception e) {
    		LOGGER.error("===查询本品订单详情===",e);
    		return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
		}
    }
    
    @ApiOperation(value = "查询本品订单查询材料集合", notes = "查询本品订单查询材料集合", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/oneself/order/pics", method = RequestMethod.GET)
    @ApiOperationSupport(order = 7)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "reservationId", value = "预约id", required = true, paramType ="query", dataType = "Long")
    })
    @JsonPropFilter(type = OneselfAcquirerDto.class)
    public RestResponse<OneselfOrderPicsDto> orderPics(@RequestParam("reservationId") Long reservationId) {
    	try{
    		OneselfOrderPicsDto dto = this.reservationService.orderPics(reservationId);
			return new RestResponse<>(RestStatusCode.OK,dto);
    	}catch (Exception e) {
    		LOGGER.error("===查询本品订单查询收购材料集合异常===",e);
    		return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
		}
    }
    
    @ApiOperation(value = "本品收购入库", notes = "本品收购入库", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/oneself/acquisition/warehousing", method = RequestMethod.POST)
    @ApiOperationSupport(order = 8)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "dto", value = "参数信息", required = true, paramType ="body", dataType = "AcquisitionWarehousingDto")
    })
    @JsonPropFilter(type = ReservationDto.class)
    public RestResponse<Boolean> acquisitionWarehousing(@RequestBody AcquisitionWarehousingDto dto) {
    	try{
    		this.reservationService.acquisitionWarehousing(dto);
    	}catch (Exception e) {
    		LOGGER.error("===本品收购入库异常===",e);
    		return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, false);
		}
		return new RestResponse<>(RestStatusCode.OK,true);
    }
    
    @ApiOperation(value = "本品过户", notes = "本品过户", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/oneself/transfer/ownership", method = RequestMethod.POST)
    @ApiOperationSupport(order = 9)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "dto", value = "参数信息", required = true, paramType ="body", dataType = "TransferOwnershipDto")
    })
    @JsonPropFilter(type = ReservationDto.class)
    public RestResponse<Boolean> transferOwnership(@RequestBody TransferOwnershipDto dto) {
    	try{
    		this.reservationService.transferOwnership(dto);
    	}catch (Exception e) {
    		LOGGER.error("===本品过户异常===",e);
    		return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, false);
		}
		return new RestResponse<>(RestStatusCode.OK,true);
    }
    
}
