package com.exp.ucmp.inventory.web;

import com.alibaba.excel.util.DateUtils;
import com.egrid.core.json.body.JsonPropFilter;
import com.egrid.core.web.response.RestResponse;
import com.egrid.core.web.response.RestStatusCode;
import com.exp.ucmp.Import.dto.ImportReturnDto;
import com.exp.ucmp.car.dto.ApproveChangePriceDto;
import com.exp.ucmp.car.dto.CarSalePriceDto;
import com.exp.ucmp.car.dto.ChangePriceDetailDto;
import com.exp.ucmp.car.dto.QueryChangePriceDto;
import com.exp.ucmp.car.dto.QueryChangePriceParamDto;
import com.exp.ucmp.inventory.service.CarStockInfoService;
import com.exp.ucmp.stock.dto.*;
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
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author hailele
 * @Description: 库存车辆信息Controller
 * @date 2023/1/31 15:29
 */
@Api(value = "CarStockInfoController.API", tags = "库存车辆信息Controller")
@Controller
public class CarStockInfoController {


    @Autowired
    private CarStockInfoService carStockInfoService;

    private static final Logger LOGGER = LoggerFactory.getLogger(CarStockInfoController.class);

    @ApiOperation(value = "导入库存车辆", notes = "库存车辆信息Controller")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "files", value = "导入文件", required = true, paramType ="form", dataType = "File")
    })
    @RequestMapping(value = "/api/v1/carStock/carStockImport", method = RequestMethod.POST)
    @ApiOperationSupport(order = 1)
    @JsonPropFilter(type = String.class)
    public RestResponse<ImportReturnDto> carStockImport(MultipartFile files, HttpServletRequest request){
    	ImportReturnDto result;
        try {
        	result = carStockInfoService.readExcel(files);
            return new RestResponse<>(RestStatusCode.OK,result);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            result = new ImportReturnDto();
            result.setFlag(2);
            result.setResult("请放入一个合法的Excel模板!");
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR,result);
        }
    }

    @ApiOperation(value = "更改决策类型", notes = "库存车辆信息Controller")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "stockId", value = "库存车辆id", required = true, paramType ="form", dataType = "Long"),
            @ApiImplicitParam(name = "decisionType", value = "决策类型(零售：2301/批售：2302)", required = true, paramType ="form", dataType = "String")
    })
    @RequestMapping(value = "/api/v1/carStock/updateDecisionType", method = RequestMethod.POST)
    @ApiOperationSupport(order = 2)
    @JsonPropFilter(type = String.class)
    public RestResponse<String> updateDecisionType(@RequestParam Long stockId, String decisionType){
        try {
            carStockInfoService.updateDecisionType(stockId,decisionType);
            return new RestResponse<>(RestStatusCode.OK);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR,e.getMessage());
        }
    }

    /**
     * Description: 车辆作废操作
     * */
    @ApiOperation(value = "车辆作废操作", notes = "库存车辆信息Controller", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/carStock/carVoid", method = RequestMethod.PUT)
    @ApiOperationSupport(order = 3)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "stockId", value = "库存车辆id", required = true, paramType ="form", dataType = "Long"),
            @ApiImplicitParam(name = "repealReason", value = "作废理由", required = true, paramType ="form", dataType = "String"),
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<String> carVoid(@RequestParam Long stockId,@RequestParam String repealReason) {
        try {
            carStockInfoService.carVoid(stockId,repealReason);
            return new RestResponse<>(RestStatusCode.OK);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

    /**
     * Description: 查询库存车辆列表
     */
    @ApiOperation(value = "查询库存车辆列表", notes = "库存车辆信息Controller", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/carStock/findList", method = RequestMethod.POST)
    @ApiOperationSupport(order = 4)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "stockInfoListQueryDto", value = "库存车辆列表查询Dto", required = true, paramType ="body", dataType = "CarStockInfoListQueryDto"),
            @ApiImplicitParam(name = "type", value = "tab选项卡类型1：库存车辆;2：作废车辆;3:APP端查询销售车辆", required = true, paramType ="query", dataType = "Integer")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<PageInfo<CarStockInfoDto>> findCarStockList(@RequestBody CarStockInfoListQueryDto stockInfoListQueryDto,Integer type) {
        try {
            PageInfo<CarStockInfoDto> carStockList = carStockInfoService.findCarStockList(stockInfoListQueryDto,type);
            return new RestResponse<>(RestStatusCode.OK, carStockList);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

    /**
     * Description: 库存车辆基本信息更新
     */
    @ApiOperation(value = "库存车辆基本信息更新", notes = "库存车辆信息Controller", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/carStock/updateBaseStockInfo", method = RequestMethod.POST)
    @ApiOperationSupport(order = 5)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "carStockInfo", value = "车辆基础信息", required = true, paramType ="body", dataType = "CarStockBaseInfoDto"),
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<Boolean> updateBaseStockInfo(@RequestBody CarStockBaseInfoDto carStockInfo) {
        try {
            carStockInfoService.updateBaseStockInfo(carStockInfo);
            return new RestResponse<>(RestStatusCode.OK);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

    /**
     * Description: 权益包列表查询
     */
    @ApiOperation(value = "权益包列表查询", notes = "库存车辆信息Controller", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/carStock/findActivitiesList", method = RequestMethod.GET)
    @ApiOperationSupport(order = 6)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页", required = true, paramType ="query", dataType = "int"),
                @ApiImplicitParam(name = "pageSize", value = "每页大小", required = true, paramType ="query", dataType = "int")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<PageInfo<RightActivitiesSelectListDto>> findActivitiesList(@RequestParam Integer pageNum,@RequestParam Integer pageSize) {
        try {
            PageInfo<RightActivitiesSelectListDto> carStockList = carStockInfoService.selectActivitiesList(pageNum,pageSize);
            return new RestResponse<>(RestStatusCode.OK, carStockList);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }


    /**
     * Description: 查询出库车辆列表
     */
    @ApiOperation(value = "查询出库车辆列表", notes = "库存车辆信息Controller", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/carStock/findOutList", method = RequestMethod.POST)
    @ApiOperationSupport(order = 7)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "stockInfoListQueryDto", value = "查询出库车辆列表", required = true, paramType ="body", dataType = "CarStockInfoListQueryDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<PageInfo<CarStockInfoDto>> findCarStockOutList(@RequestBody CarStockInfoListQueryDto stockInfoListQueryDto) {
        try {
            PageInfo<CarStockInfoDto> carStockList = carStockInfoService.findCarStockOutList(stockInfoListQueryDto);
            return new RestResponse<>(RestStatusCode.OK, carStockList);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

    /**
     * Description: 车辆销售定价修改(记录批售方接口)
     */
    @ApiOperation(value = "车辆销售定价修改(记录批售方接口)", notes = "库存车辆信息Controller", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/carStock/updateSalePrices", method = RequestMethod.POST)
    @ApiOperationSupport(order = 8)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "carStockInfoList", value = "选中的车辆信息", required = true, paramType ="body", dataType = "CarStockInfoDto"),
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<Boolean> updateSalePrices(@RequestBody List<CarStockInfoDto> carStockInfoList) {
        try {
            carStockInfoService.updateSalePrices(carStockInfoList);
            return new RestResponse<>(RestStatusCode.OK);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

    /**
     * Description: 记录批售接口
     */
    @ApiOperation(value = "记录批售接口", notes = "库存车辆信息Controller", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/carStock/saveSaleRecord", method = RequestMethod.POST)
    @ApiOperationSupport(order = 9)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "files", value = "收款凭证文件", required = true, paramType ="form", dataType = "MultipartFile"),
            @ApiImplicitParam(name = "partnerName", value = "合作方", required = true, paramType ="form", dataType = "string"),
            @ApiImplicitParam(name = "deliverDate", value = "交付日期", required = true, paramType ="form", dataType = "string"),
            @ApiImplicitParam(name = "remark", value = "备注", required = true, paramType ="form", dataType = "string"),
            @ApiImplicitParam(name = "selectCarStockIds", value = "选中的批售车辆id(字符串逗号拼接)", required = true, paramType ="form", dataType = "string"),
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<Boolean> saveSaleRecord(@RequestParam("files") List<MultipartFile> files,
                                                @RequestParam("partnerName") String partnerName,
                                                @RequestParam("deliverDate") String deliverDate,
                                                @RequestParam("remark") String remark,
                                                @RequestParam("selectCarStockIds") String selectCarStockIds) {
        try {
            CarSaleRecordInfoDto saleRecordInfoDto =  new CarSaleRecordInfoDto();
            saleRecordInfoDto.setPartnerName(partnerName);
            saleRecordInfoDto.setDeliverDate(DateUtils.parseDate(deliverDate));
            saleRecordInfoDto.setRemark(remark);
            saleRecordInfoDto.setSelectCarStockIds(selectCarStockIds);
            carStockInfoService.saveSaleRecord(files,saleRecordInfoDto);
            return new RestResponse<>(RestStatusCode.OK);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

    /**
     * Description: 车辆记录批售信息查看
     */
    @ApiOperation(value = "车辆记录批售信息查看", notes = "库存车辆信息Controller", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/carStock/getSaleRecordInfo", method = RequestMethod.GET)
    @ApiOperationSupport(order = 10)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "stockId", value = "库存车辆id", required = true, paramType ="query", dataType = "Long")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<CarSaleRecordDetailsDto> getSaleRecordInfo(@RequestParam Long stockId) {
        try {
            CarSaleRecordDetailsDto saleRecordInfoDto = carStockInfoService.getSaleRecordInfo(stockId);
            return new RestResponse<>(RestStatusCode.OK,saleRecordInfoDto);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

    /**
     * Description: 上传导入车辆模板文件
     */
    @ApiOperation(value = "上传导入车辆模板文件", notes = "库存车辆信息Controller", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/carStock/uploadFormwork", method = RequestMethod.POST)
    @ApiOperationSupport(order = 11)
    @JsonPropFilter(type = String.class)
    public RestResponse<Boolean> uploadFormwork(@RequestParam("file") MultipartFile file) {
        try {
            carStockInfoService.uploadFormwork(file);
            return new RestResponse<>(RestStatusCode.OK);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }
    
    @ApiOperation(value = "查询可销售车辆的商品编号", notes = "查询可销售车辆的商品编号", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/carStock/findProductCodeList", method = RequestMethod.GET)
    @ApiOperationSupport(order = 12)
    @ApiImplicitParams({})
    @JsonPropFilter(type = String.class)
    public RestResponse<List<String>> findProductCodeList() {
        try {
        	List<String> productCodeList = carStockInfoService.findProductCodeList();
            return new RestResponse<>(RestStatusCode.OK, productCodeList);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }
    
    @ApiOperation(value = "更新车辆定价", notes = "更新车辆定价", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/carStock/updateSalePrice", method = RequestMethod.POST)
    @ApiOperationSupport(order = 13)
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "carSalePriceDto", value = "车辆销售定价实体类", required = true, paramType ="body", dataType = "CarSalePriceDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<String> updateSalePrice(@RequestBody CarSalePriceDto carSalePriceDto) {
        try {
        	carStockInfoService.updateSalePrice(carSalePriceDto);
            return new RestResponse<>(RestStatusCode.OK, "true");
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR,e.getMessage());
        }
    }
    
    @ApiOperation(value = "查询改价车辆的审批列表", notes = "查询改价车辆的审批列表", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/carStock/query/change/price/approve/list", method = RequestMethod.POST)
    @ApiOperationSupport(order = 14)
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "paramDto", value = "查询改价审批参数类", required = true, paramType ="body", dataType = "QueryChangePriceParamDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<PageInfo<QueryChangePriceDto>> queryChangePriceApproveList(@RequestBody QueryChangePriceParamDto paramDto) {
        try {
        	PageInfo<QueryChangePriceDto> pageDto = carStockInfoService.queryChangePriceApproveList(paramDto);
            return new RestResponse<>(RestStatusCode.OK, pageDto);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }
    
    @ApiOperation(value = "查询改价车辆的审批详情", notes = "查询改价车辆的审批详情", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/carStock/query/change/price/approve/detail", method = RequestMethod.GET)
    @ApiOperationSupport(order = 15)
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "stockId", value = "库存车辆id", required = true, paramType ="query", dataType = "Long"),
    	@ApiImplicitParam(name = "recordId", value = "改价记录id", required = true, paramType ="query", dataType = "Long")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<ChangePriceDetailDto> queryChangePriceApproveDetail(@RequestParam("stockId") Long stockId,@RequestParam("recordId") Long recordId) {
        try {
        	ChangePriceDetailDto pageDto = carStockInfoService.queryChangePriceApproveDetail(stockId,recordId);
            return new RestResponse<>(RestStatusCode.OK, pageDto);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }
    
    @ApiOperation(value = "改价车辆的审批", notes = "改价车辆的审批", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/carStock/query/change/price/approve", method = RequestMethod.POST)
    @ApiOperationSupport(order = 16)
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "paramDto", value = "改价审批参数类", required = true, paramType ="body", dataType = "ApproveChangePriceDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<String> queryChangePriceApprove(@RequestBody ApproveChangePriceDto paramDto) {
        try {
        	carStockInfoService.queryChangePriceApprove(paramDto);
            return new RestResponse<>(RestStatusCode.OK, "true");
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR,e.getMessage());
        }
    }

}
