package com.exp.ucmp.carDealer.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.egrid.core.json.body.JsonPropFilter;
import com.egrid.core.web.response.RestResponse;
import com.egrid.core.web.response.RestStatusCode;
import com.exp.ucmp.carDealer.dto.InquiryQueryParamDto;
import com.exp.ucmp.carDealer.dto.InquiryQueryResultDto;
import com.exp.ucmp.carDealer.dto.InquiryReceivingDto;
import com.exp.ucmp.carDealer.service.InquiryReceivingService;
import com.github.pagehelper.PageInfo;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "InquiryReceiving.API", tags = "询价单接单相关的接口")
@Controller
public class InquiryReceivingController {
	/**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(InquiryReceivingController.class);
    
    @Autowired
    private InquiryReceivingService inquiryReceivingService;
    
    /**
     * Description: 待接单的查询
     */
    @ApiOperation(value = "查询当前车商人员和接单相关的询价单", notes = "查询当前车商人员和接单相关的询价单", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/inquiry/receiving/query", method = RequestMethod.POST)
    @ApiOperationSupport(order = 1)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "paramDto", value = "查询条件(分页)", required = true, paramType ="body", dataType = "InquiryQueryParamDto")
    })
    @JsonPropFilter(type = PageInfo.class)
    public RestResponse<PageInfo<InquiryQueryResultDto>> queryInquiryReceiving(@RequestBody InquiryQueryParamDto paramDto){
		try {
        	PageInfo<InquiryQueryResultDto> page = null;
        	if (InquiryQueryParamDto.InquiryQueryTypeEnum.inquiryReceivingAwait.name().equals(paramDto.getInquiryQueryType())) {
        		page = inquiryReceivingService.queryInquiryReceivingByAwait(paramDto);
        	} else if (InquiryQueryParamDto.InquiryQueryTypeEnum.inquiryReceivingAccept.name().equals(paramDto.getInquiryQueryType())) {
        		page = inquiryReceivingService.queryInquiryReceivingByAccept(paramDto);
        	} else if (InquiryQueryParamDto.InquiryQueryTypeEnum.inquiryReceivingGiveup.name().equals(paramDto.getInquiryQueryType())) {
        		page = inquiryReceivingService.queryInquiryReceivingByGiveup(paramDto);
        	}
        	if (page == null) {
        		throw new Exception("查询时提供的InquiryQueryType不正确");
        	} else {
        		LOGGER.info("欲返回的内容{}", page.getList());
                return new RestResponse<>(RestStatusCode.OK, page);
        	}
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }
    
    /**
     * Description: 接单
     */
    @ApiOperation(value = "本品他品询价单接单", notes = "询价单接单", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/inquiry/receiving/accept", method = RequestMethod.POST)
    @ApiOperationSupport(order = 2, ignoreParameters = {"paramDto.abandonReceivingReason"})
    @ApiImplicitParams({
        @ApiImplicitParam(name = "paramDto", value = "接单", required = true, paramType ="body", dataType = "InquiryReceivingDto")
    })
    @JsonPropFilter(type = Boolean.class)
    public RestResponse<Boolean> acceptInquiryReceiving(@RequestBody InquiryReceivingDto paramDto){
		try {
			boolean result = inquiryReceivingService.acceptInquiryReceiving(paramDto.getInquiryId(), paramDto.getReservationId());
			if(result){
				return new RestResponse<>(RestStatusCode.OK, result);
			}else{
				return new RestResponse<>(RestStatusCode.WEBSERVICE_ERROR, result);
			}
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }
    
    /**
     * Description: 放弃接单
     */
    @ApiOperation(value = "询价单接单放弃", notes = "询价单接单放弃", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/inquiry/receiving/giveup", method = RequestMethod.POST)
    @ApiOperationSupport(order = 3)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "paramDto", value = "放弃接单", required = true, paramType ="body", dataType = "InquiryReceivingDto")
    })
    @JsonPropFilter(type = Boolean.class)
    public RestResponse<Boolean> giveupInquiryReceiving(@RequestBody InquiryReceivingDto paramDto){
		try {
			boolean result = inquiryReceivingService.giveupInquiryReceiving(paramDto.getInquiryId(), paramDto.getReservationId(), paramDto.getAbandonReceivingReason());
			if(result){
				return new RestResponse<>(RestStatusCode.OK, result);
			}else{
				return new RestResponse<>(RestStatusCode.WEBSERVICE_ERROR, result);
			}
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }
    
}
