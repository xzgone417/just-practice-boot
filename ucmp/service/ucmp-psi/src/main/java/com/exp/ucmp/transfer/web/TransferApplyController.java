package com.exp.ucmp.transfer.web;

import com.egrid.core.json.body.JsonPropFilter;
import com.egrid.core.web.response.RestResponse;
import com.egrid.core.web.response.RestStatusCode;
import com.exp.ucmp.inventory.service.CarStockInfoService;
import com.exp.ucmp.transfer.dto.*;
import com.exp.ucmp.transfer.service.TransferApplyService;
import com.github.pagehelper.PageInfo;
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


/**
 * @author hailele
 * @Description: 调拨管理
 * @date 2022/02/10
 */
@Api(value = "TransferApply.API", tags = "调拨管理接口")
@Controller
public class TransferApplyController {
    /**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TransferApplyController.class);

    @Autowired
    private CarStockInfoService carStockInfoService;
    @Autowired
    private TransferApplyService transferApplyService;
    /**
     * Description: 根据VIN码查询车辆信息(调拨申请详情页)
     */
    @ApiOperation(value = "根据VIN码查询车辆信息(调拨申请详情页)", notes = "调拨管理接口", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/transferApply/findCarInfoByVinCode", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "vinCode", value = "VIN码", required = true, paramType ="query", dataType = "string"),
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<TransferApplyCarInfoDto> findCarInfoByVinCode(@RequestParam String vinCode) {
        try {
            TransferApplyCarInfoDto carStockList = carStockInfoService.findCarInfoByVinCode(vinCode);
            return new RestResponse<>(RestStatusCode.OK, carStockList);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }
    /**
     * Description: 查询调拨车辆基本信息
     */
    @ApiOperation(value = "查询调拨车辆基本信息", notes = "调拨管理接口", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/transferApply/findTransferApplyInfo", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "dispatchApplyId", value = "调度申请id", required = true, paramType ="query", dataType = "long"),
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<TransferApplyCarInfoDto> findTransferApplyInfo(@RequestParam Long dispatchApplyId) {
        try {
            TransferApplyCarInfoDto carStockList = transferApplyService.findTransferApplyInfo(dispatchApplyId);
            return new RestResponse<>(RestStatusCode.OK, carStockList);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

    /**
     * Description: 提交调拨申请
     */
    @ApiOperation(value = "提交调拨申请", notes = "调拨管理接口", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/transferApply/submitTransferApply", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "transferApplyCarInfoDto", value = "调度申请信息", required = true, paramType ="body", dataType = "TransferApplyCarInfoDto"),
            @ApiImplicitParam(name = "operation", value = "操作选项(0:保存/1:提交)", required = true, paramType ="query", dataType = "Integer"),
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<Boolean> submitTransferApply(@RequestParam Integer operation,@RequestBody TransferApplyCarInfoDto transferApplyCarInfoDto) {
        try {
            transferApplyService.submitTransferApply(operation,transferApplyCarInfoDto);
            return new RestResponse<>(RestStatusCode.OK);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }


    /**
     * Description: 查询调拨车辆申请列表
     */
    @ApiOperation(value = "查询调拨车辆申请列表", notes = "调拨管理接口", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/transferApply/findList", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "transferCarApplyQueryDto", value = "查询调拨车辆申请列表条件", required = true, paramType ="body", dataType = "TransferCarApplyQueryDto")})
    @JsonPropFilter(type = String.class)
    public RestResponse<PageInfo<TransferCarApplyResultDto>> findList(@RequestBody TransferCarApplyQueryDto transferCarApplyQueryDto) {
        try {
            PageInfo<TransferCarApplyResultDto> list = transferApplyService.findList(transferCarApplyQueryDto);
            return new RestResponse<>(RestStatusCode.OK,list);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

    /**
     * Description: 查询调拨登记列表
     */
    @ApiOperation(value = "查询调拨登记列表", notes = "调拨管理接口", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/transferApply/registerList", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "transferCarApplyQueryDto", value = "查询调拨登记列表条件", required = true, paramType ="body", dataType = "TransferCarApplyQueryDto")})
    @JsonPropFilter(type = String.class)
    public RestResponse<PageInfo<TransferCarApplyResultDto>> registerList(@RequestBody TransferCarApplyQueryDto transferCarApplyQueryDto) {
        try {
            PageInfo<TransferCarApplyResultDto> list = transferApplyService.registerList(transferCarApplyQueryDto);
            return new RestResponse<>(RestStatusCode.OK,list);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

    /**
     * Description: 查询调拨车辆信息列表
     */
    @ApiOperation(value = "(门店)查询调拨车辆信息列表", notes = "调拨管理接口", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/transferApply/findStatusList", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "transferCarApplyQueryDto", value = "调拨发运状态列表条件", required = true, paramType ="body", dataType = "TransferCarApplyQueryDto")})
    @JsonPropFilter(type = String.class)
    public RestResponse<PageInfo<TransferCarApplyStatusDto>> findStatusList(@RequestBody TransferCarApplyQueryDto transferCarApplyQueryDto) {
        try {
            PageInfo<TransferCarApplyStatusDto> list = transferApplyService.findStatusList(transferCarApplyQueryDto);
            return new RestResponse<>(RestStatusCode.OK,list);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

    /**
     * Description: 调拨出入库
     */
    @ApiOperation(value = "调拨出入库", notes = "调拨管理接口", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/transferApply/warehousing", method = RequestMethod.POST)
    @JsonPropFilter(type = String.class)
    public RestResponse<Boolean> warehousing(@RequestBody TransferWarehousingParamsDto paramsDto) {
        try {
            return new RestResponse<>(RestStatusCode.OK,transferApplyService.transferWarehousing(paramsDto.getOption(),paramsDto.getTransferApplyIds()));
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

    /**
     * Description: 调拨登记[提交/关闭]
     */
    @ApiOperation(value = "调拨登记[提交/关闭]", notes = "调拨管理接口", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/transferApply/submitOrClose", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "option", value = "提交-1 关闭-2", required = true,dataType = "Integer"),
            @ApiImplicitParam(name = "transferApplyId", value = "调拨申请id",required = true,dataType = "Long")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<Boolean> submitOrClose(@RequestParam("option") Integer option,@RequestParam("transferApplyId") Long transferApplyId) {
        try {
            return new RestResponse<>(RestStatusCode.OK,transferApplyService.submitOrClose(option,transferApplyId));
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

}
