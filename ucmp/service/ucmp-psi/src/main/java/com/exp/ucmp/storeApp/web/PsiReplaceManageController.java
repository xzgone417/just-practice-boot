package com.exp.ucmp.storeApp.web;
import com.egrid.core.json.body.JsonPropFilter;
import com.egrid.core.util.JsonBeanUtil;
import com.egrid.core.web.response.RestResponse;
import com.egrid.core.web.response.RestStatusCode;
import com.exp.ucmp.storeApp.dto.*;
import com.exp.ucmp.storeApp.service.PsiReplaceManageService;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author zhouchengwei
 * @date 2022年09月23日
 */
@Api(value = "Permission.API", description = "门店信息查询接口")
@RefreshScope
@Controller
public class PsiReplaceManageController {

    @Autowired
    PsiReplaceManageService psiReplaceManageService;

    /**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(PsiReplaceManageController.class);

    /**
     * Description: 根据条件查询置换单详情
     */
    @ApiOperation(value = "查询置换单详情", notes = "查询置换单详情", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/storeApp/findReplace", method = RequestMethod.POST)
    @ApiOperationSupport(order = 1)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "replaceCluesDetailsQueryDto", value = "查询置换单详情", required = true, paramType ="body", dataType = "ReplaceCluesDetailsQueryDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<List<ReplaceCluesDetailsDto>> findReplace(@RequestBody ReplaceCluesDetailsQueryDto replaceCluesDetailsQueryDto) {

        try {
            List<ReplaceCluesDetailsDto> replaceCluesDetailsDtos = psiReplaceManageService.queryReplaceCluesDetails(replaceCluesDetailsQueryDto);

            return new RestResponse<>(RestStatusCode.OK, replaceCluesDetailsDtos);
        } catch (Exception e) {
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }

    /**
     * Description: 根据条件查询置换单详情
     */
    @ApiOperation(value = "查询置换单详情(解密接口)", notes = "查询置换单详情(解密接口)", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/storeApp/findReplaceTab", method = RequestMethod.POST)
    @ApiOperationSupport(order = 2)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "replaceCluesDetailsQueryDto", value = "查询置换单详情(解密接口)", required = true, paramType ="body", dataType = "ReplaceCluesDetailsQueryDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<List<ReplaceCluesDetailsDto>> findReplaceTabInfo(@RequestBody ReplaceCluesDetailsQueryDto replaceCluesDetailsQueryDto) {

        try {
            List<ReplaceCluesDetailsDto> replaceCluesDetailsDtos = psiReplaceManageService.queryReplaceCluesDetails(replaceCluesDetailsQueryDto);

            return new RestResponse<>(RestStatusCode.OK, replaceCluesDetailsDtos);
        } catch (Exception e) {
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR,e);
        }
    }



    /**
     * Description: 根据条件查询置换单tab页
     */
    @ApiOperation(value = "根据条件查询置换单tab页", notes = "根据条件查询置换单tab页", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/storeApp/findReplaceList", method = RequestMethod.POST)
    @ApiOperationSupport(order = 3)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "replaceCluesDetailsQueryDto", value = "根据条件查询置换单tab页", required = true, paramType ="body", dataType = "ReplaceCluesDetailsQueryDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<List<ReplaceCluesDetailsDto>> findReplaceListInfo(@RequestBody ReplaceCluesDetailsQueryDto replaceCluesDetailsQueryDto) {
        try {
            List<ReplaceCluesDetailsDto> replaceCluesDetailsDtos = psiReplaceManageService.queryReplaceClues(replaceCluesDetailsQueryDto);

            return new RestResponse<>(RestStatusCode.OK, replaceCluesDetailsDtos);
        } catch (Exception e) {
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR,e);
        }
    }

    /**
     * Description: 查询车商(分配)
     */
    @ApiOperation(value = "查询车商(分配)", notes = "查询车商(分配)", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/storeApp/findCarDealer", method = RequestMethod.POST)
    @ApiOperationSupport(order = 4)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "carDealerMsgQueryDto", value = "查询车商(分配)", required = true, paramType ="body", dataType = "CarDealerMsgQueryDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<List<CarDealerMsgDto>> findCarDealerInfo(@RequestBody CarDealerMsgQueryDto carDealerMsgQueryDto) {
        try {
            List<CarDealerMsgDto> carDealerMsgDtoDtos = psiReplaceManageService.queryCarDealer(carDealerMsgQueryDto);
            return new RestResponse<>(RestStatusCode.OK, carDealerMsgDtoDtos);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }



    /**
     * Description: 查询车商(参与)
     */
    @ApiOperation(value = "查询车商(参与)", notes = "查询车商(参与)", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/storeApp/findCarDealerJoin", method = RequestMethod.POST)
    @ApiOperationSupport(order = 5)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "carDealerMsgQueryDto", value = "查询车商(参与)", required = true, paramType ="body", dataType = "CarDealerMsgQueryDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<List<CarDealerMsgDto>> findCarDealerJoinInfo(@RequestBody CarDealerMsgQueryDto carDealerMsgQueryDto) {

        try {
            List<CarDealerMsgDto> carDealerMsgDtoDtos = psiReplaceManageService.queryCarDealerInfo(carDealerMsgQueryDto);
            return new RestResponse<>(RestStatusCode.OK, carDealerMsgDtoDtos);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR,e);
        }
    }



    /**
     * Description: 查询车商(签到)
     */
    @ApiOperation(value = "查询车商(签到)", notes = "查询车商(签到)", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/storeApp/findCarDealerSignIn", method = RequestMethod.POST)
    @ApiOperationSupport(order = 6)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "carDealerMsgQueryDto", value = "查询车商(签到)", required = true, paramType ="body", dataType = "CarDealerMsgQueryDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<List<CarDealerMsgDto>> findCarDealerSignInInfo(@RequestBody CarDealerMsgQueryDto carDealerMsgQueryDto) {
        try {
            List<CarDealerMsgDto> carDealerMsgDtoDtos = psiReplaceManageService.queryCarDealerSignIn(carDealerMsgQueryDto);

            return new RestResponse<>(RestStatusCode.OK, carDealerMsgDtoDtos);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR,e);
        }
    }


    /**
     * Description: 创建预约单
     */
    @ApiOperation(value = "创建预约单", notes = "创建预约单", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/storeApp/addReplaceOrder", method = RequestMethod.POST)
    @ApiOperationSupport(order = 7)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "replaceOrderInsertDto", value = "创建预约单", required = true, paramType ="body", dataType = "ReplaceOrderInsertDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<Object> addReplaceOrderInfo(@RequestBody ReplaceOrderInsertDto replaceOrderInsertDto) {

        try {
            ReplaceOrderInsertReturnDto replaceOrderInsertReturnDto = psiReplaceManageService.insertReplaceOrder(replaceOrderInsertDto);
            return new RestResponse<>(RestStatusCode.OK, replaceOrderInsertReturnDto);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR,"服务异常，请联系后台管理员");
        }
    }


    /**
     * Description: 分配车商
     */
    @ApiOperation(value = "分配车商", notes = "分配车商", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/storeApp/divisionCarDealer", method = RequestMethod.POST)
    @ApiOperationSupport(order = 8)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "divisionCarDealerDto", value = "分配车商", required = true, paramType ="body", dataType = "DivisionCarDealerDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<String> divisionCarDealerInfo(@RequestBody DivisionCarDealerDto divisionCarDealerDto) {
    	LOGGER.info("=====分配车商===="+JsonBeanUtil.beanToJson(divisionCarDealerDto));
        try {
            psiReplaceManageService.divisionCarDealer(divisionCarDealerDto);
            return new RestResponse<>(RestStatusCode.OK);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR.code(),"服务异常，请联系后台管理员");
        }
    }


    /**
     * Description: 关闭预约单
     */
    @ApiOperation(value = "关闭预约单", notes = "关闭预约单", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/storeApp/closeReplaceOrder", method = RequestMethod.POST)
    @ApiOperationSupport(order = 9)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "replaceCluesCloseDto", value = "关闭预约单", required = true, paramType ="body", dataType = "ReplaceCluesCloseDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<String> closeReplaceOrderInfo(@RequestBody ReplaceCluesCloseDto replaceCluesCloseDto) {

        try {
            psiReplaceManageService.updateReplaceClues(replaceCluesCloseDto);
            return new RestResponse<>(RestStatusCode.OK);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR,"服务异常，请联系后台管理员");
        }
    }


    /**
     * Description: 车商签到
     */
    @ApiOperation(value = "车商签到", notes = "车商签到", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/storeApp/carDealerSignIn", method = RequestMethod.POST)
    @ApiOperationSupport(order = 10)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "carDealerSignIn", value = "车商签到", required = true, paramType ="body", dataType = "CarDealerSignIn")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<String> carDealerSignInInfo(@RequestBody CarDealerSignIn carDealerSignIn) {

        try {
            psiReplaceManageService.updateCarDealerSignIn(carDealerSignIn);
            return new RestResponse<>(RestStatusCode.OK);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR,"服务异常，请联系后台管理员");
        }
    }



    /**
     * Description: 客户操作
     */
    @ApiOperation(value = "客户操作", notes = "客户操作", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/storeApp/customerOperation", method = RequestMethod.POST)
    @ApiOperationSupport(order = 11)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "customerOperationDto", value = "客户操作", required = true, paramType ="body", dataType = "CustomerOperationDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<String> customerOperationInfo(@RequestBody CustomerOperationDto customerOperationDto) {

        try {
            psiReplaceManageService.customerOperation(customerOperationDto,0);
            return new RestResponse<>(RestStatusCode.OK);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR,"服务异常，请联系后台管理员");
        }
    }


    /**
     * Description: link新车订单
     */
    @ApiOperation(value = "link新车订单", notes = "link新车订单", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/storeApp/linkNewCarOrder", method = RequestMethod.POST)
    @ApiOperationSupport(order = 12)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "psiNewCarOrderDto", value = "link新车订单", required = true, paramType ="body", dataType = "PsiNewCarOrderDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<String> linkNewCarOrderInfo(@RequestBody PsiNewCarOrderDto psiNewCarOrderDto) {

        try {
            psiReplaceManageService.linkNewCarOrder(psiNewCarOrderDto);
            return new RestResponse<>(RestStatusCode.OK);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR,"服务异常，请联系后台管理员");
        }
    }
}
