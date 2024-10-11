package com.exp.ucmp.servicing.web;

import com.egrid.core.util.JsonBeanUtil;
import com.egrid.core.web.response.RestResponse;
import com.egrid.core.web.response.RestStatusCode;
import com.exp.ucmp.servicing.dto.*;
import com.exp.ucmp.servicing.service.PsiServicingService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author gubonai
 * @date 2023年01月13日
 */
@Api(tags = "整备工单接口")
@RestController
@RequestMapping("/servicing")
public class PsiServicingController {


    private static final Logger LOGGER = LoggerFactory.getLogger(PsiServicingController.class);

    @Autowired
    private PsiServicingService psiServicingService;


    /**
     * Description: 查询整备工单列表
     */
    @ApiOperation("查询整备工单列表")
    @PostMapping("/queryServicingList")
    public RestResponse<PageInfo<QueryServicingDto>> queryServicingList(QueryServicingParamDto queryServicingParamDto) {
        try {
            PageInfo<QueryServicingDto> queryServicingDtos = psiServicingService.queryServicingList(queryServicingParamDto);
            return new RestResponse<>(RestStatusCode.OK, queryServicingDtos);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

//    @ApiOperation("查询整备审批列表")
//    @PostMapping("/queryServicingApprovalList")
//    public RestResponse<PageInfo<QueryServicingDto>> queryServicingApprovalList(@RequestBody QueryServicingApprovalDto queryServicingParamDto) {
//        try {
//            PageInfo<QueryServicingDto> queryServicingDtos = psiServicingService.queryServicingApprovalList(queryServicingParamDto);
//            return new RestResponse<>(RestStatusCode.OK, queryServicingDtos);
//        } catch (Exception e) {
//            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
//            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
//        }
//    }

    /**
     * Description: 查询整备车辆基本信息
     */
    @ApiOperation("查询整备车辆基本信息--废弃")
    @ApiImplicitParams({@ApiImplicitParam(name = "serviceId", value = "查询整备车辆id", required = true)})
    @PostMapping("/queryServicingCarInfo")
    public RestResponse<ServicingCarInfoDto> queryServicingCarInfo(@RequestParam(value = "serviceId") Long serviceId) {
        try {
            ServicingCarInfoDto carInfoDto = psiServicingService.queryServicingCarInfo(serviceId);
            return new RestResponse<>(RestStatusCode.OK, carInfoDto);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

    /**
     * Description: 维修项目及工单审批
     */
    @ApiOperation("维修项目及工单审批--废弃")
    @PostMapping("/approval")
    public RestResponse<Boolean> approval(@RequestBody ApprovalParamsDto approvalParamsDto) {
    	LOGGER.info("====维修项目及工单审批==="+JsonBeanUtil.beanToJson(approvalParamsDto));
        try {
            boolean approval = psiServicingService.approval(approvalParamsDto);
            return new RestResponse<>(RestStatusCode.OK, approval);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

    /**
     * Description: 查询维修项目
     */
    @ApiOperation("查询维修项目及工单--废弃")
    @PostMapping("/queryMaintenanceApproval")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "serviceId", value = "查询整备车辆id", required = true),
            @ApiImplicitParam(name = "type", value = "1-项目，2-工单", required = true)})
    public RestResponse<MaintenanceApprovalDto> queryMaintenanceApproval(@RequestParam(value = "serviceId") Long serviceId, @RequestParam(value = "type") Integer type) {
        try {
            MaintenanceApprovalDto maintenanceApprovalDto = psiServicingService.queryMaintenanceApproval(type,serviceId);
            return new RestResponse<>(RestStatusCode.OK, maintenanceApprovalDto);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

}
