package com.exp.ucmp.rightset.web;

import com.egrid.core.json.body.JsonPropFilter;
import com.egrid.core.util.JsonBeanUtil;
import com.egrid.core.web.response.RestResponse;
import com.egrid.core.web.response.RestStatusCode;
import com.exp.ucmp.rightset.dto.*;
import com.exp.ucmp.rightset.service.RightSetService;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

import java.util.List;
import java.util.Map;

/**
 * @author GeYiJiang
 * @Description: 权益活动设置接口
 * @date 2022/11/18 14:09
 */
@Api(value = "RightSetController.API",tags = "权益活动设置接口")
@Controller
public class RightSetController {

    @Autowired
    private RightSetService rightSetService;

    private static final Logger LOGGER = LoggerFactory.getLogger(RightSetController.class);


    /**
     * Description: 查询权益活动列表
     */
    @ApiOperation(value = "查询权益活动列表", notes = "查询权益活动列表", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/system/findRightActivities", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "paramsDto", value = "查询权益活动列表", required = true, paramType ="body", dataType = "RightSetQueryParamsDto")
    })
    @JsonPropFilter(type = PageInfo.class)
    public RestResponse<PageInfo<RightSetPageDto>> findRightActivitiesList(@RequestBody RightSetQueryParamsDto paramsDto) {

        try {
            PageInfo<RightSetPageDto> page = rightSetService.selectRightSetList(paramsDto);
            return new RestResponse<>(RestStatusCode.OK, page);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

    /**
     * Description: 权益活动设置
     */
    @ApiOperation(value = "权益活动设置", notes = "权益活动设置", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/system/rightSet/saveRightActivity", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "paramsDto", value = "权益活动设置", required = true, paramType ="body", dataType = "RightSetSaveDto")
    })
    @JsonPropFilter(type = Boolean.class)
    public RestResponse<Boolean> saveRightActivity(@RequestBody RightSetSaveDto paramsDto) {
    	LOGGER.info("======="+JsonBeanUtil.beanToJson(paramsDto));
        try {
            return new RestResponse<>(RestStatusCode.OK, rightSetService.savaRightSet(paramsDto));
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

    /**
     * Description: 权益活动创建所需信息
     */
    @ApiOperation(value = "权益活动创建所需信息", notes = "权益活动创建所需信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/system/rightSet/rightActivityNeed", method = RequestMethod.POST)
    @JsonPropFilter(type = Boolean.class)
    public RestResponse<Map<String,String>> rightActivityNeed() {

        try {
            return new RestResponse<>(RestStatusCode.OK, rightSetService.rightSetNeed());
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

    /**
     * Description: 更新权益活动状态
     */
    @ApiOperation(value = "更新权益活动状态", notes = "更新权益活动状态", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/system/rightSet/UpdateRightActivity", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "updateDto", value = "更新权益活动状态", required = true, paramType ="body", dataType = "RightStatusUpdateDto")
    })
    @JsonPropFilter(type = Boolean.class)
    public RestResponse<Boolean> UpdateRightActivity(@RequestBody RightStatusUpdateDto updateDto) {

        try {
            return new RestResponse<>(RestStatusCode.OK, rightSetService.updateRightStatus(updateDto));
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }



    /**
     * Description: 权益明细项目列表查询
     */
    @ApiOperation(value = "权益明细项目列表查询", notes = "权益明细项目列表查询", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/system/findActivitiesDetailsPage", method = RequestMethod.GET)
    @ApiOperationSupport(order = 3)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "rightId", value = "权益活动主键ID", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "pageNum", value = "页数", required = true, paramType = "query", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "行数", required = true, paramType = "query", dataType = "Integer")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<PageInfo<RightActivitiesDetailsPageDto>>  findActivitiesDetailsPage(@RequestParam @Valid String rightId, @RequestParam @Valid Integer pageNum, @RequestParam @Valid Integer pageSize
    ){
        try {
            PageInfo<RightActivitiesDetailsPageDto> page = rightSetService.findActivitiesDetailsPage(rightId,pageNum,pageSize);
            return new RestResponse<>(RestStatusCode.OK, page);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }

    @ApiOperation(value = "权益明细项目详情", notes = "权益明细项目详情", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/system/findActivitiesDetails", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "detailId", value = "明细主键ID", required = true, paramType ="query", dataType = "String")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<RightActivitiesDetailsPageDto> findActivitiesDetails(@RequestParam String detailId) {
        try {
            RightActivitiesDetailsPageDto page = rightSetService.findActivitiesDetails(detailId);
            return new RestResponse<>(RestStatusCode.OK, page);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }


    /**
     * Description: 参与人数列表查询
     */
    @ApiOperation(value = "参与人数列表查询", notes = "参与人数列表查询", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/system/findDistributeDetailsPage", method = RequestMethod.POST)
    @ApiOperationSupport(order = 4)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "detailsPageQueryDto", value = "查询主体参数", required = true, paramType = "body", dataType = "DistributeDetailsPageQueryDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<PageInfo<DistributeDetailsPageDto>>  findDistributeDetailsPage(@RequestBody DistributeDetailsPageQueryDto detailsPageQueryDto
    ){
        try {
            PageInfo<DistributeDetailsPageDto> page = rightSetService.findDistributeDetailsPage(detailsPageQueryDto);
            return new RestResponse<>(RestStatusCode.OK, page);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }
    
    @ApiOperation(value = "查询权益活动列表(不分页)", notes = "查询权益活动列表", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/system/findRightActivities/list", method = RequestMethod.POST)
    @ApiOperationSupport(order = 5)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "paramsDto", value = "查询权益活动列表", required = true, paramType ="body", dataType = "RightSetQueryParamsDto")
    })
    @JsonPropFilter(type = PageInfo.class)
    public RestResponse<List<RightSetPageDto>> findRightActivities(@RequestBody RightSetQueryParamsDto paramsDto) {

        try {
        	List<RightSetPageDto> resultList = rightSetService.findRightActivities(paramsDto);
            return new RestResponse<>(RestStatusCode.OK, resultList);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

}
