package com.exp.ucmp.inventory.web;

import com.egrid.core.json.body.JsonPropFilter;
import com.egrid.core.web.response.RestResponse;
import com.egrid.core.web.response.RestStatusCode;
import com.exp.ucmp.inventory.service.WarehouseManageService;
import com.exp.ucmp.servicing.dto.StorageHistoryListInfoDto;
import com.exp.ucmp.servicing.web.PsiServicingController;
import com.exp.ucmp.warehouse.dto.*;
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
import org.springframework.web.multipart.MultipartFile;

/**
 * @author GeYiJiang
 * @Description:
 * @date 2023/2/16 17:42
 */

@Api(value = "WarehouseManageController.API", tags = "出入库管理管理接口")
@RestController
@RequestMapping("/api/v2/warehouseManage")
public class WarehouseManageController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PsiServicingController.class);

    @Autowired
    private WarehouseManageService warehouseManageService;

    @ApiOperation("零售、批售出库")
    @PostMapping("/batchDelivery")
    public RestResponse<Boolean> batchDelivery(@RequestBody BatchDeliveryParamsDto paramsDto) {

        try {
            boolean batchDelivery = warehouseManageService.batchDelivery(paramsDto);
            return new RestResponse<>(RestStatusCode.OK, batchDelivery);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

    @ApiOperation(value = "是否是交付中心", notes = "是否交付中心", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/isDeliveryCenter", method = RequestMethod.GET)
    @JsonPropFilter(type = String.class)
    public RestResponse<Boolean> isDeliveryCenter() {
        try {
            return new RestResponse<>(RestStatusCode.OK,warehouseManageService.isDeliveryCenter());
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

    @ApiOperation("[门店]出入库列表")
    @PostMapping("/receiptList")
    public RestResponse<PageInfo<TransferWarehouseResultDto>> batchDelivery(@RequestBody WarehouseQueryDto queryDto) {
        try {
            PageInfo<TransferWarehouseResultDto> pageInfo = new PageInfo<>();
            //调拨入库
            if (WarehouseQueryDto.queryEnum.TransferReceipt.name().equals(queryDto.getQueryEnum())){
                pageInfo = warehouseManageService.transferReceipt(queryDto);
            }//调拨出库
            if (WarehouseQueryDto.queryEnum.TransferIssue.name().equals(queryDto.getQueryEnum())){
                pageInfo = warehouseManageService.transferIssue(queryDto);
            }//零售
            if (WarehouseQueryDto.queryEnum.RetailOutbound.name().equals(queryDto.getQueryEnum())){
                pageInfo = warehouseManageService.retailOutbound(queryDto);
            }//批售
            if (WarehouseQueryDto.queryEnum.BatchIssue.name().equals(queryDto.getQueryEnum())){
                pageInfo = warehouseManageService.batchIssue(queryDto);
            }
            return new RestResponse<>(RestStatusCode.OK,pageInfo);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

    @ApiOperation("[门店]验收入库列表")
    @PostMapping("/checkList")
    public RestResponse<PageInfo<CheckWarehouseResultDto>> checkList(@RequestBody CheckWarehouseQueryDto queryDto) {
        try {
            PageInfo<CheckWarehouseResultDto> pageInfo = warehouseManageService.checkList(queryDto);
            return new RestResponse<>(RestStatusCode.OK,pageInfo);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

    @ApiOperation("[门店]收购验收入库列表")
    @PostMapping("/acquisitionList")
    public RestResponse<PageInfo<AcquisitionWarehouseResultDto>> acquisitionList(@RequestBody CheckWarehouseQueryDto queryDto) {
        try {
            PageInfo<AcquisitionWarehouseResultDto> checkWarehouseResultDtoPageInfo = warehouseManageService.acquisitionList(queryDto);
            return new RestResponse<>(RestStatusCode.OK,checkWarehouseResultDtoPageInfo);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

    @ApiOperation(value = "[门店]整备出库列表", notes = "WarehouseManageController.API", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/serviceList", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "queryDto", value = "查询实体", required = true, paramType ="body", dataType = "WarehouseQueryDto"),
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<PageInfo<CheckWarehouseResultDto>> serviceList(@RequestBody CheckWarehouseQueryDto queryDto) {
        try {
            PageInfo<CheckWarehouseResultDto> pageInfo = warehouseManageService.serviceList(queryDto);
            return new RestResponse<>(RestStatusCode.OK,pageInfo);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

    @ApiOperation(value = "[门店]整备验收图片材料上传", notes = "WarehouseManageController.API", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/uploadServiceMaterialFile", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "serviceId", value = "整备信息id", required = false, paramType ="form", dataType = "long"),
            @ApiImplicitParam(name = "stockId", value = "库存车辆id", required = false, paramType ="form", dataType = "long"),
            @ApiImplicitParam(name = "file", value = "图片文件", required = true, paramType ="form", dataType = "MultipartFile"),
            @ApiImplicitParam(name = "materialType", value = "材料类型(外观图/内饰图)", required = true, paramType ="form", dataType = "string"),
            @ApiImplicitParam(name = "materialFileType", value = "材料文件类型(方向盘/仪表盘)", required = true, paramType ="form", dataType = "string"),
            @ApiImplicitParam(name = "chineseDescription", value = "中文描述", required = true, paramType ="form", dataType = "string"),
            @ApiImplicitParam(name = "fileSort", value = "排序", required = true, paramType ="form", dataType = "int")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<String> uploadServiceMaterialFile(@RequestParam(value="serviceId",required=false) Long serviceId,
    													  @RequestParam(value="stockId",required=false) Long stockId,
                                                           @RequestParam("file") MultipartFile file,
                                                           @RequestParam("materialType") String materialType,
                                                           @RequestParam("materialFileType") String materialFileType,
                                                           @RequestParam("chineseDescription") String chineseDescription,
                                                           @RequestParam("fileSort") Integer fileSort
    ) {
        try {
            Long fileId = warehouseManageService.uploadServiceMaterialFile(serviceId,file,materialType,materialFileType,chineseDescription,fileSort,stockId);
            return new RestResponse<>(RestStatusCode.OK,fileId.toString());
        } catch (RuntimeException e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e.getMessage());
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR.code(),e.getMessage());
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

    @ApiOperation(value = "[门店]整备验收图片材料描述更新", notes = "WarehouseManageController.API", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/updateMaterialFileRemarks", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "materialFileId", value = "业务id", required = true, paramType ="form", dataType = "long"),
            @ApiImplicitParam(name = "chineseDescription", value = "中文描述", required = true, paramType ="form", dataType = "string"),
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<String> updateMaterialFileRemarks(@RequestParam("materialFileId") Long materialFileId,
                                                          @RequestParam("chineseDescription") String chineseDescription
    ) {
        try {
            warehouseManageService.updateMaterialFileRemarks(materialFileId,chineseDescription);
            return new RestResponse<>(RestStatusCode.OK);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

    @ApiOperation(value = "[门店]整备验收图片材料删除", notes = "WarehouseManageController.API", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/deleteServiceMaterialFile", method = RequestMethod.DELETE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "materialFileId", value = "文件id", required = true, paramType ="query", dataType = "long"),
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<String> deleteServiceMaterialFile(@RequestParam("materialFileId") Long materialFileId
    ) {
        try {
            warehouseManageService.deleteServiceMaterialFile(materialFileId);
            return new RestResponse<>(RestStatusCode.OK);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }


    @ApiOperation(value = "[门店]整备验收入库", notes = "WarehouseManageController.API", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/submitStorage", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "serviceId", value = "整备信息id", required = true, paramType ="form", dataType = "string")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<Long> submitStorage(@RequestParam("serviceId") String serviceId) {
        try {
            warehouseManageService.submitStorage(Long.valueOf(serviceId));
            return new RestResponse<>(RestStatusCode.OK);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

    @ApiOperation(value = "[门店]整备验收出库", notes = "WarehouseManageController.API", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/submitOutStorages", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "serviceIds", value = "整备信息id集合(逗号拼接)", required = true, paramType ="form", dataType = "string"),
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<Long> submitOutStorages(@RequestParam("serviceIds") String serviceIds
    ) {
        try {
            warehouseManageService.submitOutStorages(serviceIds);
            return new RestResponse<>(RestStatusCode.OK);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }


    @ApiOperation(value = "[门店]整备验收记录查询", notes = "WarehouseManageController.API", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/selectStorageHistoryList", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "stockId", value = "库存车辆id", required = true, paramType ="form", dataType = "long"),
            @ApiImplicitParam(name = "pageNum", value = "当前页", required = true, paramType ="form", dataType = "long"),
            @ApiImplicitParam(name = "pageSize", value = "页码", required = true, paramType ="form", dataType = "long")

    })
    @JsonPropFilter(type = String.class)
    public RestResponse<PageInfo<StorageHistoryListInfoDto>> selectStorageHistoryList(@RequestParam("stockId") Long stockId,
                                                                                      @RequestParam("pageNum")Integer pageNum,
                                                                                      @RequestParam("pageSize")Integer pageSize
    ) {
        try {
            PageInfo<StorageHistoryListInfoDto> list = warehouseManageService.selectStorageHistoryList(stockId,pageNum,pageSize);
            return new RestResponse<>(RestStatusCode.OK,list);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

}
