package com.exp.ucmp.inventory.web;

import com.egrid.core.json.body.JsonPropFilter;
import com.egrid.core.util.JsonBeanUtil;
import com.egrid.core.web.response.RestResponse;
import com.egrid.core.web.response.RestStatusCode;
import com.exp.ucmp.inventory.service.PsiCarStockManageService;
import com.exp.ucmp.mall.dto.InventoryInfoDto;
import com.exp.ucmp.mall.dto.MallReturnDto;
import com.exp.ucmp.stock.dto.*;
import com.github.pagehelper.PageInfo;
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

import javax.validation.Valid;

/**
 * @author gubonai
 * @date 2023年01月13日
 */
@Api(tags = "车辆库存信息查询接口")
@RestController
@RequestMapping("/InventoryInfo")
public class PsiCarStockManageController {


    private static final Logger LOGGER = LoggerFactory.getLogger(PsiCarStockManageController.class);


    @Autowired
   private PsiCarStockManageService psiCarStockManageService;


    /**
     * Description: 根据条件查询查询出入库历史
     */
    @ApiOperation("根据库存车辆id查询出入库历史")
    @ApiImplicitParams({@ApiImplicitParam(name = "stockId", value = "库存车辆id", required = true)})
    @GetMapping("/queryStockHistory")
    public RestResponse<List<StockHistoryDto>> queryStockHistory(@RequestParam("stockId") Long stockId) {

        try {
            List<StockHistoryDto> stockHistoryDtoList = psiCarStockManageService.queryStockHistory(stockId);
            return new RestResponse<>(RestStatusCode.OK, stockHistoryDtoList);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

    /**
     * Description: 根据调拨申请id或vin查询调拨状态信息
     */
    @ApiOperation("根据调拨申请id或vin查询调拨状态信息")
    @ApiImplicitParams({@ApiImplicitParam(name = "param", value = "调拨申请id或vin", required = true),
            @ApiImplicitParam(name = "type", value = "1调拨id2vin", required = true)})
    @GetMapping("/queryAllocationState")
    @JsonPropFilter(type = AllocationStateDto.class)
    public RestResponse<AllocationStateDto> queryAllocationState(@RequestParam("param") String param,@RequestParam("type") String type) {
        try {
            AllocationStateDto allocationStateDto = psiCarStockManageService.queryAllocationState(param,type);
            return new RestResponse<>(RestStatusCode.OK, allocationStateDto);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }


    /**
     * Description: 查询车辆费用
     */
    @ApiOperation("查询车辆费用清单")
    @PostMapping("/queryExpenseInfo")
    public RestResponse<ExpenseListDto> queryExpenseList(@RequestParam("vin") String vin) {
        try {
            ExpenseListDto expenseListDtos = psiCarStockManageService.queryExpenseList(vin);
            return new RestResponse<>(RestStatusCode.OK, expenseListDtos);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

    /**
     * Description: 保存车辆费用
     */
    @ApiOperation(value = "车辆费用保存")
    @PostMapping("/saveExpenseCost")
    public RestResponse<String> saveExpenseCost(@RequestBody SaveExpenseCostParamDto paramDtoList) {
        try {
            String status = psiCarStockManageService.saveExpenseCost(paramDtoList);
            return new RestResponse<>(status);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }


/*    *//**
     * Description: 导出车辆费用清单列表
     *//*
    @ApiOperation("导出车辆费用清单列表")
    @PostMapping("/expenseListExport")
    public void expenseListExport(ExpenseListParamDto expenseListParamDto, HttpServletResponse response) throws IOException {
         psiCarStockManageService.expenseListExport(expenseListParamDto,response);
    }*/

    /**
     * Description: 根据条件查询查询车辆仓储信息
     */
    @ApiOperation("查询车辆仓储信息")
    @ApiImplicitParams({@ApiImplicitParam(name = "stockId", value = "库存车辆id", required = true)})
    @GetMapping("/queryStockInfo")
    public RestResponse<CarStorageInfoDto> queryStockInfo(@RequestParam("stockId") Long stockId) {

        try {
            CarStorageInfoDto carStorageInfoDto = psiCarStockManageService.queryStockInfo(stockId);
            return new RestResponse<>(RestStatusCode.OK, carStorageInfoDto);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

    /**
     * 查询车辆基本信息
     * @param stockId
     * @return
     */
    @ApiOperation("查询车辆基本信息")
    @ApiImplicitParams({@ApiImplicitParam(name = "stockId", value = "库存车辆id", required = false, paramType ="query", dataType = "Long"),
    	@ApiImplicitParam(name = "vin", value = "vin", required = false, paramType ="query", dataType = "String")})
    @GetMapping("/queryStockBasicInfo")
    public RestResponse<CarStockBasicInfoDto> queryStockBasicInfo(@RequestParam(value="stockId",required=false) Long stockId,
    		@RequestParam(value="vin",required=false) String vin) {
        try {
            CarStockBasicInfoDto carStockBasicInfoDto = psiCarStockManageService.queryStockBasicInfo(stockId,vin);
            return new RestResponse<>(RestStatusCode.OK, carStockBasicInfoDto);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

    /**
    /**
     * Description: 根据条件查询查询车辆状态流转
     */
    @ApiOperation("根据stockId查询车辆状态流转")
    @ApiImplicitParams({@ApiImplicitParam(name = "stockId", value = "库存车辆id", required = true)})
    @GetMapping("/queryCarStatusFlow")
    public RestResponse<CarStatusFlowDto> queryCarStatusFlow(@RequestParam("stockId") Long stockId) {

        try {
            CarStatusFlowDto carStorageInfoDto = psiCarStockManageService.queryCarStatusFlow(stockId);
            return new RestResponse<>(RestStatusCode.OK, carStorageInfoDto);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

    /**
     * Description: 根据条件查询查询车辆整备图片
     */
    @ApiOperation("根据stockId查询车辆整备图片")
    @ApiImplicitParams({@ApiImplicitParam(name = "stockId", value = "库存车辆id", required = false),
            @ApiImplicitParam(name = "type", value = "图片类型字典表94", required = true),
            @ApiImplicitParam(name = "serviceId", value = "整备id", required = false)})
    @GetMapping("/queryCarServicingPic")
    public RestResponse<List<CarServiceFileDto>> queryCarServicingPic(@RequestParam(value = "stockId",required = false) Long stockId,
                                                                      @RequestParam(value = "serviceId",required = false) Long serviceId,
                                                                      @RequestParam("type") String type) {
    	LOGGER.info("====stockId="+stockId+",serviceId="+serviceId+",type="+type);
        try {
            List<CarServiceFileDto> list = psiCarStockManageService.queryCarServicingPic(stockId,type,serviceId);
            return new RestResponse<>(RestStatusCode.OK, list);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

    /**
     * Description: 零售上下架
     */
    @ApiOperation("零售上下架")
    @PostMapping("/retailLoading")
    public RestResponse<Boolean> retailLoading(@RequestBody @Valid RetailLoadingDto retailLoadingDto) {
        try {
            boolean loading = psiCarStockManageService.retailLoading(retailLoadingDto);
            return new RestResponse<>(RestStatusCode.OK, loading);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

    /**
     * Description: 查询整备完成车辆列表
     */
    @ApiOperation("查询整备完成车辆列表")
    @PostMapping("/queryServicingCompletedList")
    public RestResponse<PageInfo<ServicingCompletedDto>> queryServicingCompletedList(ServicingCompletedParamDto paramDto) {
        try {
            PageInfo<ServicingCompletedDto> servicingCompletedDtoPageInfo = psiCarStockManageService.queryServicingCompletedList(paramDto);
            return new RestResponse<>(RestStatusCode.OK, servicingCompletedDtoPageInfo);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

    /**
     * Description: 查询维修项目列表
     */
    @ApiOperation("查询维修项目列表")
    @PostMapping("/queryMainteanceList")
    public RestResponse<PageInfo<MaintenceListDto>> queryMainteanceList(MaintenceParamDto paramDto) {
        try {
            PageInfo<MaintenceListDto> maintenceListDtoPageInfo = psiCarStockManageService.queryMainteanceList(paramDto);
            return new RestResponse<>(RestStatusCode.OK, maintenceListDtoPageInfo);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

    /**
     * Description:维修项目信息保存
     */
    @ApiOperation(value = "维修项目信息保存")
    @PostMapping("/saveMaintenceInfo")
    public RestResponse<Boolean> saveMaintenceInfo(@RequestBody List<QueryMaintenceResultDto> paramDtoList) {
        try {
            psiCarStockManageService.saveMaintenceInfo(paramDtoList);
            return new RestResponse<>(RestStatusCode.OK,true);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

    /**
     * Description: 查询调整的维修项目
     */
    @ApiOperation("查询调整的维修项目")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "stockId", value = "stockId", required = false),
            @ApiImplicitParam(name = "vin", value = "vin", required = true),
            @ApiImplicitParam(name = "type", value = "项目类型(1维修工单项目2整备工单项目)", required = true)})
    @PostMapping("/queryAdjustMainteanceList")
    public RestResponse<List<QueryMaintenceResultDto>> queryAdjustMainteanceList(@RequestParam(value = "stockId",required = false) Long stockId,
                                                                                 @RequestParam("vin") String vin,
                                                                                @RequestParam("type") String type) {
        try {
            List<QueryMaintenceResultDto> map = psiCarStockManageService.queryAdjustMainteanceList(stockId,vin,type);
            return new RestResponse<>(RestStatusCode.OK, map);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }


    /**
     * Description: 查询车辆检测报告
     */
    @ApiOperation("查询车辆历史维修信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "stockId", value = "stockId", required = false),
            @ApiImplicitParam(name = "vin", value = "vin", required = true)})
    @PostMapping("/queryHisMaintenanceList")
    public RestResponse<List<MaintenceRecordDto>> queryHisMaintenanceList(@RequestParam(value = "stockId",required = false) Long stockId,
                                                                          @RequestParam("vin") String vin) {
        try {
            List<MaintenceRecordDto> map = psiCarStockManageService.queryHisMaintenanceList(stockId,vin);
            return new RestResponse<>(RestStatusCode.OK, map);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }
    
    /**
     * Description: 查询商城上架车辆列表
     */
    @ApiOperation(value = "查询商城上架车辆列表", produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/queryCarStockGroundingList")
    public MallReturnDto<PageInfo<CarStockGroundingDto>> queryCarStockGroundingList(@RequestBody CarStockGroundingParamDto paramDto) {
    	LOGGER.info("====查询商城上架车辆列表===="+JsonBeanUtil.beanToJson(paramDto));
    	MallReturnDto<PageInfo<CarStockGroundingDto>> returnDto=new MallReturnDto<>();
        try {
            PageInfo<CarStockGroundingDto> pageInfo = psiCarStockManageService.queryCarStockGroundingList(paramDto);
            returnDto.setCode("000000");
            returnDto.setMsg("请求处理成功");
            returnDto.setData(pageInfo);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            returnDto.setCode("50001");
            returnDto.setMsg(e.toString());
        }
        return returnDto;
    }

    /**
     * Description: 查询商城车辆详情
     */
    @ApiOperation(value = "查询商城车辆详情", produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/queryCarStockGroundingDetail")
    public MallReturnDto<CarStockGroundingDetailDto> queryCarStockGroundingDetail(@RequestBody InventoryInfoDto inventoryInfoDto) {
    	MallReturnDto<CarStockGroundingDetailDto> returnDto=new MallReturnDto<>();
        try {
            CarStockGroundingDetailDto dto = psiCarStockManageService.queryCarStockGroundingDetail(inventoryInfoDto.getStockId());
            returnDto.setCode("000000");
            returnDto.setMsg("请求处理成功");
            returnDto.setData(dto);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            returnDto.setCode("50001");
            returnDto.setMsg(e.toString());
        }
        return returnDto;
    }
}
