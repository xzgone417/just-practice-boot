package com.exp.ucmp.carDealer.web;

import com.egrid.core.web.response.RestStatusCode;
import com.exp.ucmp.carDealer.dto.AcquisitionFollowDto;
import com.exp.ucmp.carDealer.dto.HomePageStatus;
import com.exp.ucmp.carDealer.dto.ValuationOrderAndOfferFollowDto;
import com.github.pagehelper.PageInfo;
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
import com.egrid.core.util.JsonBeanUtil;
import com.egrid.core.web.response.RestResponse;
import com.exp.ucmp.carDealer.dto.WorkbenchStatisticsDto;
import com.exp.ucmp.carDealer.service.WorkbenchHomePageService;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * @author xiongneng
 * @date 2022年09月28日
 */
@Api(value = "WorkbenchHomePage.API", tags = "工作台首页查询统计数据接口")
@RefreshScope
@Controller
public class WorkbenchHomePageController {
	/**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(WorkbenchHomePageController.class);
    
    @Autowired
    private WorkbenchHomePageService workbenchHomePageService;
    
    /**
     * Description: 工作台首页查询统计数据
     */
//    @ApiOperation(value = "工作台首页查询统计数据", notes = "工作台首页查询统计数据", produces = MediaType.APPLICATION_JSON_VALUE)
//    @RequestMapping(value = "/api/sample/find/filter", method = RequestMethod.GET)
//    @ApiOperationSupport(order = 2)
//    @ApiImplicitParams({
//        @ApiImplicitParam(name = "pageDto", value = "参数信息", required = true, paramType ="body", dataType = "PageDto")
//    })
//    @JsonPropFilter(type = WorkbenchStatisticsDto.class)
//    public RestResponse<WorkbenchStatisticsDto> workbenchStatistics(@RequestParam(value="partyId",required=true) Integer partyId){
//    	WorkbenchStatisticsDto dto=this.workbenchHomePageService.workbenchStatistics(partyId);
//    	LOGGER.info("====工作台首页查询统计数据:"+JsonBeanUtil.beanToJson(dto));
//		return null;
//    }

    @ApiOperation(value = "查询接单及报价数量", notes = "查询接单及报价数量", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/inquiry/home/query", method = RequestMethod.POST)
    @JsonPropFilter(type = ValuationOrderAndOfferFollowDto.class)
    public RestResponse<ValuationOrderAndOfferFollowDto> valuationOrderAndOfferFollowCount(){
        ValuationOrderAndOfferFollowDto valuationOrderAndOfferFollowDto = workbenchHomePageService.queryValuationOrder();
        LOGGER.info("====查询接单及报价数量:"+JsonBeanUtil.beanToJson(valuationOrderAndOfferFollowDto));
        return new RestResponse<>(RestStatusCode.OK,valuationOrderAndOfferFollowDto);
    }

    @ApiOperation(value = "查询收购及审批驳回数量", notes = "查询收购及审批驳回数量", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/inquiry/home/acquisitionAndRejection", method = RequestMethod.POST)
    @JsonPropFilter(type = AcquisitionFollowDto.class)
    public RestResponse<AcquisitionFollowDto> acquisitionAndRejection(){
        AcquisitionFollowDto acquisitionFollowDto = workbenchHomePageService.queryAcquisitionFollow();
        LOGGER.info("====查询收购及审批驳回数量:"+JsonBeanUtil.beanToJson(acquisitionFollowDto));
        return new RestResponse<>(RestStatusCode.OK,acquisitionFollowDto);
    }

    @ApiOperation(value = "新页面红点数据", notes = "新页面红点数据", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/inquiry/home/count", method = RequestMethod.POST)
    @JsonPropFilter(type = HomePageStatus.class)
    public RestResponse<HomePageStatus> homePageStatus(){
        HomePageStatus homePageStatus = workbenchHomePageService.queryStatusCount();
        LOGGER.info("====新页面红点数据:"+JsonBeanUtil.beanToJson(homePageStatus));
        return new RestResponse<>(RestStatusCode.OK,homePageStatus);
    }
    
}
