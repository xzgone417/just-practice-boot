package com.exp.ucmp.servicing.web;

import com.egrid.core.json.body.JsonPropFilter;
import com.egrid.core.web.response.RestResponse;
import com.egrid.core.web.response.RestStatusCode;
import com.exp.ucmp.carService.dto.*;
import com.exp.ucmp.servicing.service.CarServiceInfoService;
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


/**
 * @author hailele
 * @Description: 车辆整备信息Controller
 * @date 2022/02/11
 */
@Api(value = "CarServiceInfoController.API", tags = "车辆整备信息接口")
@Controller
public class CarServiceInfoController {
    /**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(CarServiceInfoController.class);

    @Autowired
    private CarServiceInfoService serviceInfoService;
    /**
     * Description: 根据VIN码查询车辆信息(整备申请详细页)
     */
    @ApiOperation(value = "根据VIN码查询车辆信息(整备申请详细页)", notes = "车辆整备信息接口", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/carService/findCarInfoByVinCode", method = RequestMethod.GET)
    @ApiOperationSupport(order = 1)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "vinCode", value = "VIN码", required = true, paramType ="query", dataType = "string"),
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<Object> findCarInfoByVinCode(@RequestParam String vinCode) {
        try {
            CarServiceInfoDto carServiceInfoDto = serviceInfoService.findCarInfoByVinCode(vinCode);
            return new RestResponse<>(RestStatusCode.OK, carServiceInfoDto);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR,e.getMessage());
        }
    }

    /**
     * Description: 查看整备申请详细
     */
    @ApiOperation(value = "查看整备申请详细--废弃", notes = "车辆整备信息接口", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/carService/findCarServiceInfo", method = RequestMethod.GET)
    @ApiOperationSupport(order = 2)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "stockId", value = "库存id", required = true, paramType ="query", dataType = "long"),
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<CarServiceInfoDto> findCarServiceInfo(@RequestParam Long stockId) {
        try {
            CarServiceInfoDto carServiceInfo = serviceInfoService.findCarServiceInfo(stockId);
            return new RestResponse<>(RestStatusCode.OK,carServiceInfo);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

    /**
     * Description: 提交整备申请
     */
    @ApiOperation(value = "提交整备申请", notes = "车辆整备信息接口", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/carService/submitCarService", method = RequestMethod.POST)
    @ApiOperationSupport(order = 3)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "carServiceInfoDto", value = "车辆整备信息", required = true, paramType ="body", dataType = "CarServiceInfoDto"),
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<Object> submitCarService(@RequestBody CarServiceInfoDto carServiceInfoDto) {
        try {
            serviceInfoService.submitCarService(carServiceInfoDto);
            return new RestResponse<>(RestStatusCode.OK,true);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR,e.getMessage());
        }
    }
    /**
     * Description: 取消整备
     */
    @ApiOperation(value = "取消整备--废弃", notes = "车辆整备信息接口", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/carService/submitCancelService", method = RequestMethod.PUT)
    @ApiOperationSupport(order = 4)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "stockId", value = "库存车辆id", required = true, paramType ="from", dataType = "Long"),
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<Boolean> submitCancelService(@RequestParam Long stockId) {
        try {
            serviceInfoService.submitCancelService(stockId);
            return new RestResponse<>(RestStatusCode.OK);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }


    /**
     * Description: 查询整备车辆信息审批列表
     */
    @ApiOperation(value = "查询整备车辆信息审批列表--废弃", notes = "车辆整备信息接口", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/carService/findApprovalList", method = RequestMethod.POST)
    @ApiOperationSupport(order = 5)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "listParamDto", value = "整备审批列表信息Dto", required = true, paramType ="body", dataType = "CarServiceApprovalListParamDto"),
            @ApiImplicitParam(name = "type", value = "tab页类型(1:维修项目反馈/2:维修工单反馈)", required = true, paramType ="query", dataType = "Integer")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<PageInfo<CarServiceApprovalListInfoDto>> findApprovalList(@RequestBody CarServiceApprovalListParamDto listParamDto,
                                                                                  @RequestParam Integer type
                                                                                  ) {
        try {
            PageInfo<CarServiceApprovalListInfoDto> list = serviceInfoService.findApprovalList(listParamDto,type);
            return new RestResponse<>(RestStatusCode.OK,list);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }
    
    /**
     * Description: 车辆图片审批列表
     */
    @ApiOperation(value = "车辆图片审批列表", notes = "车辆整备信息接口", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/carService/findCarApproveFileList", method = RequestMethod.POST)
    @ApiOperationSupport(order = 6)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "listParamDto", value = "车辆图片审批列表查询Dto", required = true, paramType ="body", dataType = "CarApproveFileListParamDto")})
    @JsonPropFilter(type = String.class)
    public RestResponse<PageInfo<CarApproveFileListInfoDto>> findCarApproveFileList(@RequestBody CarApproveFileListParamDto listParamDto) {
        try {
            PageInfo<CarApproveFileListInfoDto> list = serviceInfoService.findCarApproveFileList(listParamDto);
            return new RestResponse<>(RestStatusCode.OK,list);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }
    /**
     * Description: 查询整备待入库车辆基础信息
     */
    @ApiOperation(value = "查询整备待入库车辆基础信息", notes = "车辆整备信息接口", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/carService/getWarehouCarInfo", method = RequestMethod.GET)
    @ApiOperationSupport(order = 7)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "stockId", value = "库存车辆id", required = true, paramType ="query", dataType = "long"),
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<CarServiceWarehouInfoDto> getWarehouCarInfo(@RequestParam Long stockId) {
        try {
            CarServiceWarehouInfoDto serviceWarehouInfoDto = serviceInfoService.getWarehouCarInfo(stockId);
            return new RestResponse<>(RestStatusCode.OK, serviceWarehouInfoDto);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }
    /**
     * Description: 审批整备车辆图片(单个)
     */
    @ApiOperation(value = "审批整备车辆图片(单个)", notes = "车辆整备信息接口", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/carService/submitServiceMaterialFile", method = RequestMethod.POST)
    @ApiOperationSupport(order = 8)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "materialFileId", value = "业务id", required = true, paramType ="from", dataType = "long"),
            @ApiImplicitParam(name = "rejectReason", value = "驳回原因(多个，号拼接)", required = true, paramType ="from", dataType = "string"),
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<Boolean> submitServiceMaterialFile(@RequestParam Long materialFileId, @RequestParam String rejectReason) {
        try {
            serviceInfoService.submitServiceMaterialFile(materialFileId,rejectReason);
            return new RestResponse<>(RestStatusCode.OK);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }
    /**
     * Description: 审批整备车辆图片提交
     */
    @ApiOperation(value = "审批整备车辆图片提交", notes = "车辆整备信息接口", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/carService/submitServiceMaterial", method = RequestMethod.POST)
    @ApiOperationSupport(order = 9)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "serviceId", value = "整备信息id", required = true, paramType ="from", dataType = "long"),
            @ApiImplicitParam(name = "approvalResult", value = "审批结果00:驳回/01:通过", required = true, paramType ="from", dataType = "string"),
            @ApiImplicitParam(name = "approvalRemark", value = "审批备注", required = true, paramType ="from", dataType = "string")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<Boolean> submitServiceMaterial(@RequestParam Long serviceId, @RequestParam String approvalResult, @RequestParam String approvalRemark) {
        try {
            serviceInfoService.submitServiceMaterial(serviceId,approvalResult,approvalRemark);
            return new RestResponse<>(RestStatusCode.OK);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

    /**
     * Description: 查询审批历史
     */
    @ApiOperation(value = "查询审批历史", notes = "车辆整备信息接口", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/carService/selectApprovalRecordList", method = RequestMethod.GET)
    @ApiOperationSupport(order = 10)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页", required = true, paramType ="query", dataType = "int"),
            @ApiImplicitParam(name = "pageSize", value = "页码", required = true, paramType ="query", dataType = "int"),
            @ApiImplicitParam(name = "serviceId", value = "整备信息id", required = true, paramType ="query", dataType = "long")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<PageInfo<CarServiceMaterialApprovalRecordListDto>> selectApprovalRecordList(@RequestParam Integer pageNum, @RequestParam Integer pageSize, @RequestParam Long serviceId) {
        try {
            PageInfo<CarServiceMaterialApprovalRecordListDto> pageInfo = serviceInfoService.selectApprovalRecordList(pageNum,pageSize,serviceId);
            return new RestResponse<>(RestStatusCode.OK, pageInfo);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }
    
    @ApiOperation(value = "查询整备车辆信息审批列表", notes = "车辆整备信息接口", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/carService/findServicingList", method = RequestMethod.POST)
    @ApiOperationSupport(order = 11)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "paramDto", value = "整备审批列表信息Dto", required = true, paramType ="body", dataType = "QueryServiceParamDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<PageInfo<QueryServiceDto>> findServicingList(@RequestBody QueryServiceParamDto paramDto) {
        try {
            PageInfo<QueryServiceDto> list = serviceInfoService.findServicingList(paramDto);
            return new RestResponse<>(RestStatusCode.OK,list);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }
    
    @ApiOperation(value = "查看整备申请详细", notes = "车辆整备信息接口", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/carService/findServiceDetails", method = RequestMethod.GET)
    @ApiOperationSupport(order = 12)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "serviceId", value = "整备id", required = true, paramType ="query", dataType = "Long")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<QueryServiceDetailsDto> findServiceDetails(@RequestParam Long serviceId) {
        try {
        	QueryServiceDetailsDto carServiceInfo = serviceInfoService.findServiceDetails(serviceId);
            return new RestResponse<>(RestStatusCode.OK,carServiceInfo);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }
    
    @ApiOperation(value = "整备报价单审批", notes = "车辆整备信息接口", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/carService/quoteOrderApproval", method = RequestMethod.POST)
    @ApiOperationSupport(order = 13)
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "approveDto", value = "整备审批Dto", required = true, paramType ="body", dataType = "CarServiceApproveDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<Object> quoteOrderApproval(@RequestBody CarServiceApproveDto approveDto) {
        try {
        	serviceInfoService.quoteOrderApproval(approveDto);
            return new RestResponse<>(RestStatusCode.OK,true);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR,e.getMessage());
        }
    }
    
}
