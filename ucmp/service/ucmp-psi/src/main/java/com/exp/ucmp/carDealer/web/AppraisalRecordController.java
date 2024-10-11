package com.exp.ucmp.carDealer.web;

import com.egrid.core.json.body.JsonPropFilter;
import com.egrid.core.web.response.RestResponse;
import com.egrid.core.web.response.RestStatusCode;
import com.exp.ucmp.carDealer.dto.*;
import com.exp.ucmp.carDealer.service.AppraisalRecordService;
import com.github.pagehelper.PageInfo;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * @author xiongneng
 * @Description: 估价记录
 * @date 2022/11/16
 */
@Api(value = "AppraisalRecord.API", tags = "车商估价收购记录的接口")
@Controller
public class AppraisalRecordController {
    /**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(AppraisalRecordController.class);

    @Autowired
    private AppraisalRecordService appraisalRecordService;

    @ApiOperation(value = "车商人员查询自己的估价记录", notes = "查询估价记录", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/appraisal/record/list", method = RequestMethod.POST)
    @ApiOperationSupport(order = 1)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "paramDto", value = "查询条件(分页)", required = true, paramType ="body", dataType = "AppraisalRecordParamDto")
    })
    @JsonPropFilter(type = PageInfo.class)
    public RestResponse<PageInfo<AppraisalRecordDto>> queryAppraisalRecord(@RequestBody AppraisalRecordParamDto paramDto){
        try {
        	PageInfo<AppraisalRecordDto> pageInfo= this.appraisalRecordService.queryAppraisalRecord(paramDto);
        	return new RestResponse<>(RestStatusCode.OK,pageInfo);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }
    
    @ApiOperation(value = "车商人员查询自己的收购记录", notes = "查询收购记录", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/acquisition/record/list", method = RequestMethod.POST)
    @ApiOperationSupport(order = 2)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "paramDto", value = "查询条件(分页)", required = true, paramType ="body", dataType = "AppraisalRecordParamDto")
    })
    @JsonPropFilter(type = PageInfo.class)
    public RestResponse<PageInfo<AcquisitionRecordDto>> queryAcquisitionRecord(@RequestBody AppraisalRecordParamDto paramDto){
        try {
        	PageInfo<AcquisitionRecordDto> pageInfo= this.appraisalRecordService.queryAcquisitionRecord(paramDto);
        	return new RestResponse<>(RestStatusCode.OK,pageInfo);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }
    
}
