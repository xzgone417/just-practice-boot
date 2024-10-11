package com.exp.ucmp.mall.web;

import com.egrid.cache.redisson.cache.RedissonCache;
import com.egrid.core.json.body.JsonPropFilter;
import com.egrid.core.web.response.RestResponse;
import com.egrid.core.web.response.RestStatusCode;
import com.exp.ucmp.clues.dto.*;
import com.exp.ucmp.entity.PsiCarStockInfoEntity;
import com.exp.ucmp.exception.IllegalParameterException;
import com.exp.ucmp.mall.service.PsiSalesRetentionService;
import com.exp.ucmp.storeApp.dto.OneselfAcquirerDto;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Objects;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * <p>@ClassName: SalesRetentionController</p>
 * <p>@Description: 销售APP相关接口</p>
 * <p>@Author: fxy</p>
 * <p>@Date: 2023/6/30 15:17<p>
 */
@Api(tags = "销售APP相关接口")
@RestController
@RequestMapping("/SalesRetentionCluesInfo")
public class SalesRetentionController {


    private static final Logger LOGGER = LoggerFactory.getLogger(SalesRetentionController.class);


    @Autowired
    private PsiSalesRetentionService salesRetentionService;

    @Autowired
    private RedissonCache redissonCache;

    /**
     * 查询客户列表
     *
     * @param
     * @return
     */
    @ApiOperation("查询客户列表")
    @GetMapping("/queryCustomerInfoList")
    public RestResponse<PageInfo<SalesCustomerInfoDto>> queryCustomerInfoList(SalesCustomerParamDto paramDto) {
        try {
            PageInfo<SalesCustomerInfoDto> customerInfoDtoList = salesRetentionService.queryCustomerInfoList(paramDto);
            return new RestResponse<>(RestStatusCode.OK, customerInfoDtoList);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

    /**
     * 查询线索客户信息
     *
     * @param customerId
     * @return
     */
    @ApiOperation("查询客户信息")
    @ApiImplicitParams({@ApiImplicitParam(name = "role", value = "角色", required = true),
            @ApiImplicitParam(name = "otherPartyId", value = "除店长外其他人线索：01", required = false),
            @ApiImplicitParam(name = "customerId", value = "客户id", required = true)})
    @GetMapping("/querySalesCustomer")
    public RestResponse<SalesCustomerInfoDto> querySalesCustomer(@RequestParam("role") String role,
                                                                 @RequestParam(value = "otherPartyId",required=false) String otherPartyId,
                                                                 @RequestParam("customerId") Long customerId) {
        try {
            SalesCustomerInfoDto customerInfoDto = salesRetentionService.querySalesCustomer(role,otherPartyId,customerId);
            return new RestResponse<>(RestStatusCode.OK, customerInfoDto);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

    /**
     * Description: 查询商城留资线索列表
     */
    @ApiOperation("查询商城留资线索列表")
    @GetMapping("/queryRetentionCluesList")
    @JsonPropFilter(type = PageInfo.class)
    public RestResponse<PageInfo<SalesRetentionCluesDto>> querySalesRetentionCluesList(SalesCluesParamDto salesCluesParamDto) {

        try {
            PageInfo<SalesRetentionCluesDto> retentionCluesDtoPageInfo = salesRetentionService.querySalesCluesList(salesCluesParamDto);
            return new RestResponse<>(RestStatusCode.OK, retentionCluesDtoPageInfo);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

    /**
     * 新建线索
     *
     * @param createDto
     * @return
     */
    @ApiOperation(value = "新建线索")
    @PostMapping("/createClues")
    public RestResponse<String> createClues(@RequestBody RetentionCluesCreateDto createDto) {
        try {
            salesRetentionService.createClues(createDto);
            return new RestResponse<>("保存成功");
        } catch (IllegalParameterException e){
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR.code(), e.getMessage());
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }

    /**
     * Description: 添加跟进
     */
    @ApiOperation(value = "添加跟进")
    @PostMapping("/saveFollow")
    public RestResponse<String> saveFollow(@RequestBody SalesSaveFollowDto paramDto) {
        try {
            String status = salesRetentionService.saveFollow(paramDto);
            return new RestResponse<>(status);
        } catch (IllegalParameterException e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR.code(), e.getMessage());
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }

    /**
     * Description: 战败
     */
    @ApiOperation(value = "战败")
    @GetMapping("/defeat")
    @ApiImplicitParam(name = "cluesId", value = "线索id", required = true)
    public RestResponse<String> defeat(@RequestParam("cluesId") Long cluesId) {
        try {
            String status = salesRetentionService.defeat(cluesId);
            return new RestResponse<>(status);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }

    /**
     * Description: 查询跟进记录
     */
    @ApiOperation("查询跟进记录")
    @GetMapping("/listCluesFollowRecord")
    @ApiImplicitParam(name = "cluesId", value = "线索id", required = true)
    @JsonPropFilter(type = PageInfo.class)
    public RestResponse<List<PsiCluesFollowRecordDto>> listCluesFollowRecord(@RequestParam("cluesId") Long cluesId) {
        try {
            List<PsiCluesFollowRecordDto> retentionCluesDtoPageInfo = salesRetentionService.listCluesFollowRecord(cluesId);
            return new RestResponse<>(RestStatusCode.OK, retentionCluesDtoPageInfo);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }

    /**
     * Description: 查询订单列表
     */
    @ApiOperation("查询订单列表")
    @GetMapping("/queryOrderList")
    public RestResponse<PageInfo<OrderInfoDto>> queryOrderList(OrderInfoParamDto orderInfoParamDto) {
        try {
            PageInfo<OrderInfoDto> orderInfoDtoPageInfo = salesRetentionService.queryOrderList(orderInfoParamDto);
            return new RestResponse<>(RestStatusCode.OK, orderInfoDtoPageInfo);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }

    /**
     * 查询订单详情
     *
     * @param orderInfoId
     * @return
     */
    @ApiOperation("查询订单详情")
    @ApiImplicitParams({@ApiImplicitParam(name = "orderInfoId", value = "订单id", required = true)})
    @GetMapping("/queryOrderInfo")
    public RestResponse<PsiOrderInfoDto> queryOrderInfo(@RequestParam("orderInfoId") Long orderInfoId) {
        try {
            PsiOrderInfoDto psiOrderInfoDto = salesRetentionService.queryOrderInfo(orderInfoId);
            return new RestResponse<>(RestStatusCode.OK, psiOrderInfoDto);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

    /**
     * Description: 创建订单
     */
    @ApiOperation(value = "创建订单")
    @PostMapping("/createOrder")
    public RestResponse<OrderRespDto> createOrder(@RequestBody SalesOrderCreateDto paramDto) {
        try {
            OrderRespDto status = salesRetentionService.createOrder(paramDto);
            return new RestResponse<>(status);
        } catch (IllegalParameterException e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR.code(), e.getMessage());
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }

    /**
     * Description: 修改订单
     */
    @ApiOperation(value = "修改订单")
    @PostMapping("/updateOrder")
    public RestResponse<String> updateOrder(@RequestBody SalesOrderUpdateDto updateDto) {
        try {
            String status = salesRetentionService.updateOrder(updateDto);
            return new RestResponse<>(status);
        } catch (IllegalParameterException e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR.code(), e.getMessage());
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }

    /**
     * Description: 取消订单
     */
    @ApiOperation(value = "取消订单")
    @PostMapping("/cancelOrder")
    public RestResponse<String> cancelOrder(@RequestBody SalesOrderCancelDto cancelDto) {
        try {
            String status = salesRetentionService.cancelOrder(cancelDto);
            return new RestResponse<>(status);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }

    @ApiOperation(value = "销售新建改配记录")
    @PostMapping("/saleCreateModify")
    public RestResponse<String> saleCreateModify(@RequestBody PsiSalesModifyConfigCreateDto createDto) {
        try {
            salesRetentionService.saleCreateModify(createDto);
            return new RestResponse<>();
        } catch (IllegalParameterException e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR.code(), e.getMessage());
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }

    @ApiOperation(value = "转交付")
    @PostMapping("/escrow")
    public RestResponse<String> escrow(@RequestBody SalesOrderMaterialDto paramDto) {
        try {
            salesRetentionService.escrow(paramDto);
            return new RestResponse<>("保存成功");
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }

    @ApiOperation(value = "查询待分配线索列表")
    @PostMapping("/undistributedClues")
    public RestResponse<PageInfo<SalesRetentionCluesDto>> queryUndistributedCluesList(@RequestBody SalesCluesParamDto paramDto) {
        try {
            PageInfo<SalesRetentionCluesDto> salesRetentionCluesDtoPageInfo = salesRetentionService.queryUndistributedCluesList(paramDto);
            return new RestResponse<>(salesRetentionCluesDtoPageInfo);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }


    @ApiOperation(value = "查询销售中心出行顾问列表", notes = "查询销售中心出行顾问列表", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/salesConsultantList", method = RequestMethod.GET)
    @JsonPropFilter(type = OneselfAcquirerDto.class)
    public RestResponse<List<SalesConsultantDto>> salesConsultantList(SalesConsultantParamDto paramDto) {
        try{
            List<SalesConsultantDto> oneselfAcquirerDto = salesRetentionService.salesConsultantList(paramDto);
            return new RestResponse<>(oneselfAcquirerDto);
        }catch (Exception e) {
            LOGGER.error("===查询销售中心出行顾问列表===",e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }

    /**
     * Description: 线索分配
     */
    @ApiOperation(value = "线索分配")
    @PostMapping("/cluesAllocation")
    public RestResponse<String> cluesAllocation(@RequestBody CluesTransferenceDto transferenceDto) {
        try {
            salesRetentionService.cluesAllocation(transferenceDto);
            return new RestResponse<>(RestStatusCode.OK);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR,e);
        }
    }

    /**
     * Description: 客户分配
     */
    @ApiOperation(value = "客户分配")
    @PostMapping("/customerAllocation")
    public RestResponse<String> customerAllocation(@RequestBody CustomerTransferenceDto transferenceDto) {
        try {
            salesRetentionService.customerAllocation(transferenceDto);
            return new RestResponse<>(RestStatusCode.OK);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR,e);
        }
    }

    /**
     * Description: 校验VIN（在售中、零售）
     */
    @ApiOperation(value = "校验VIN（在售中、零售）")
    @GetMapping("/checkVin")
    public RestResponse<PsiCarStockInfoEntity> checkVin(@RequestParam("orderInfoId") String orderInfoId,
                                                        @RequestParam("vin") String vin) {
        try {

            PsiCarStockInfoEntity psiCarStockInfoEntity = salesRetentionService.checkVinState(orderInfoId,vin);
            return new RestResponse<>(RestStatusCode.OK,psiCarStockInfoEntity);
        } catch (IllegalParameterException e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR.code(), e.getMessage());
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR,e);
        }
    }



}
