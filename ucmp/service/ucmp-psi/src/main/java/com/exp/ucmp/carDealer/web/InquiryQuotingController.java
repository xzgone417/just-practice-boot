package com.exp.ucmp.carDealer.web;

import com.egrid.core.json.body.JsonPropFilter;
import com.egrid.core.web.response.RestResponse;
import com.egrid.core.web.response.RestStatusCode;
import com.exp.ucmp.carDealer.dto.*;
import com.exp.ucmp.carDealer.service.InquiryQuotingService;
import com.github.pagehelper.PageInfo;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api(value = "InquiryQuoting.API", tags = "询价单报价相关的接口")
@Controller
public class InquiryQuotingController {
    /**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(InquiryQuotingController.class);

    @Autowired
    private InquiryQuotingService inquiryQuotingService;

    /**
     * Description: 待报价的查询
     */
    @ApiOperation(value = "查询当前车商人员和报价相关的询价单", notes = "查询当前车商人员和报价相关的询价单", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/inquiry/quoting/query", method = RequestMethod.POST)
    @ApiOperationSupport(order = 1)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "paramDto", value = "查询条件(分页)", required = true, paramType = "body", dataType = "QuotingQueryParamDto")
    })
    @JsonPropFilter(type = PageInfo.class)
    public RestResponse<PageInfo<InquiryQuotingResultDto>> queryInquiryQuoting(@RequestBody QuotingQueryParamDto paramDto) {
        try {
            PageInfo<InquiryQuotingResultDto> page = null;
            if (QuotingQueryParamDto.QuotingQueryTypeEnum.inquiryQuotingAwait.name().equals(paramDto.getQuotingQueryType())) {
                page = inquiryQuotingService.queryInquiryQuotingByAwait(paramDto);
            } else if (QuotingQueryParamDto.QuotingQueryTypeEnum.inquiryQuotingAccept.name().equals(paramDto.getQuotingQueryType())) {
                page = inquiryQuotingService.queryInquiryQuotingByAccept(paramDto);
            } else if (QuotingQueryParamDto.QuotingQueryTypeEnum.inquiryQuotingGiveup.name().equals(paramDto.getQuotingQueryType())) {
                page = inquiryQuotingService.queryInquiryQuotingByGiveup(paramDto);
            }
            if (page == null) {
                throw new Exception("查询时提供的QuotingQueryType不正确");
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
     * Description: 报价查询
     */
    @ApiOperation(value = "查询报价相关的询价单", notes = "查询报价相关的询价单", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/inquiry/quoting/select", method = RequestMethod.POST)
    @ApiOperationSupport(order = 2)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "paramDto", value = "查询条件(分页)", required = true, paramType = "body", dataType = "QuotingQueryParamDto")
    })
    @JsonPropFilter(type = PageInfo.class)
    public RestResponse<PageInfo<InquiryQuotingResultDto>> queryInquiryQuote(@RequestBody QuotingQueryParamDto paramDto) {
        try {
            PageInfo<InquiryQuotingResultDto> page = null;
            if (QuotingQueryParamDto.QuotingQueryTypeEnum.inquiryQuotingAwait.name().equals(paramDto.getQuotingQueryType())) {
                page = inquiryQuotingService.queryInquiryQuotingAwait(paramDto);
            } else if (QuotingQueryParamDto.QuotingQueryTypeEnum.inquiryQuotingAccept.name().equals(paramDto.getQuotingQueryType())) {
                page = inquiryQuotingService.queryInquiryQuotingAccept(paramDto);
            } else if (QuotingQueryParamDto.QuotingQueryTypeEnum.customerRefusal.name().equals(paramDto.getQuotingQueryType())) {
                page = inquiryQuotingService.queryInquiryQuotingByRefusal(paramDto);
            }else if(QuotingQueryParamDto.QuotingQueryTypeEnum.all.name().equals(paramDto.getQuotingQueryType())){
                page = inquiryQuotingService.queryInquiryQuotingByAll(paramDto);
            }
            if (page == null) {
                throw new Exception("查询时提供的QuotingQueryType不正确");
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
     * Description: 报价
     */
    @ApiOperation(value = "询价单报价-本品收购评估报价", notes = "询价单报价", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/inquiry/quoting/accept", method = RequestMethod.POST)
    @ApiOperationSupport(order = 3, ignoreParameters = {"paramDto.abandonReceivingReason"})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "paramDto", value = "接单", required = true, paramType ="body", dataType = "InquiryQuotingAcceptDto")
    })
    @JsonPropFilter(type = Boolean.class)
    public RestResponse<Boolean> acceptInquiryQuoting(@RequestBody InquiryQuotingAcceptDto paramDto){
        try {
           inquiryQuotingService.acceptInquiryQuoting(paramDto);
           return new RestResponse<>(RestStatusCode.OK);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }

    /**
     * Description: 放弃报价
     */
    @ApiOperation(value = "询价单报价放弃", notes = "询价单报价放弃", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/inquiry/quoting/giveup", method = RequestMethod.POST)
    @ApiOperationSupport(order = 4)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "paramDto", value = "报价", required = true, paramType ="body", dataType = "InquiryQuotingDto")
    })
    @JsonPropFilter(type = Boolean.class)
    public RestResponse<Boolean> giveupInquiryQuoting(@RequestBody InquiryQuotingDto paramDto){
		try {
			boolean result = inquiryQuotingService.giveupInquiryQuoting(paramDto);
        	return new RestResponse<>(RestStatusCode.OK, result);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }

    /**
     * Description: 报价详情图片
     */
    @ApiOperation(value = "报价详情图片", notes = "报价详情图片",produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/inquiry/quoting/pics", method = RequestMethod.POST)
    @JsonPropFilter(type = AcquisitionDetailsDto.class)
    @ApiOperationSupport(order = 5)
    @ApiImplicitParam(name = "acquisitionDetailQueryDto", value = "查询条件", required = true, paramType ="body", dataType = "AcquisitionDetailQueryDto")
    public RestResponse<List<AcquisitionAllFileDto>> acquisitionDetail(@RequestBody AcquisitionDetailQueryDto acquisitionDetailQueryDto){
        try {
            List<AcquisitionAllFileDto> acquisitionAllFileDto = inquiryQuotingService.quotingPics(acquisitionDetailQueryDto);
            return new RestResponse<>(RestStatusCode.OK, acquisitionAllFileDto);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }
    
}
