package com.exp.ucmp.car.web;

import java.util.List;

import com.exp.ucmp.entity.SysRegionEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.egrid.core.json.body.JsonPropFilter;
import com.egrid.core.web.response.RestResponse;
import com.egrid.core.web.response.RestStatusCode;
import com.exp.ucmp.car.service.CarInfoService;
import com.exp.ucmp.iautos.dto.AssessForReplaceDto;
import com.exp.ucmp.iautos.dto.CarBrandDto;
import com.exp.ucmp.iautos.dto.CarDetailDto;
import com.exp.ucmp.iautos.dto.CarModelDto;
import com.exp.ucmp.iautos.dto.CarSeriesDto;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;


/**
 * 
 * @author xiongneng
 * @date 2022年10月09日
 */
@Api(value = "车辆信息", tags = "查询车辆品牌、车系、年款、车型等信息")
@RefreshScope
@Controller
public class CarInfoController {

	/**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(CarInfoController.class);
    
    @Autowired
    private CarInfoService carInfoService;
    
    /**
     * <p>Description: 获取品牌列表</p>
     * @return 
     */
    @ApiOperation(value = "获取品牌列表", notes = "获取品牌列表", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/iautos/getPassengerBrand", method = RequestMethod.GET)
    @ApiOperationSupport(order = 1)
    @JsonPropFilter(type = CarBrandDto.class)
    public RestResponse<List<CarBrandDto>> getPassengerBrand() {
        try {
        	List<CarBrandDto> resultList = carInfoService.getPassengerBrand();
            return new RestResponse<>(resultList);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }
    
    /**
     * <p>Description:根据品牌查询车系列表(带有厂商信息)</p>
     * @return 
     */
    @ApiOperation(value = "根据品牌查询车系列表", notes = "根据品牌查询车系列表", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/iautos/getPassengerSeries", method = RequestMethod.GET)
    @ApiOperationSupport(order = 2)
    @JsonPropFilter(type = CarSeriesDto.class)
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "brandId", value = "品牌id", required = false, paramType ="query", dataType = "String")
    })
    public RestResponse<List<CarSeriesDto>> getPassengerSeries(@RequestParam(value="brandId", required=false) String brandId) {
        try {
        	List<CarSeriesDto> resultList = carInfoService.getPassengerSeries(brandId);
            return new RestResponse<>(resultList);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }
    
    /**
     * <p>Description:根据车系查询购买年份列表</p>
     * @return 
     */
    @ApiOperation(value = "根据车系查询购买年份列表", notes = "根据车系查询购买年份列表", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/iautos/getPassengerYear", method = RequestMethod.GET)
    @ApiOperationSupport(order = 3)
    @JsonPropFilter(type = String.class)
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "seriesId", value = "车系id", required = true, paramType ="query", dataType = "String")
    })
    public RestResponse<List<String>> getPassengerYear(@RequestParam(value="seriesId", required=true) String seriesId) {
        try {
        	List<String> resultList=carInfoService.getPassengerYear(seriesId);
            return new RestResponse<>(resultList);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }
    
    /**
     * <p>Description:根据车系查询购买年份列表</p>
     * @return 
     */
    @ApiOperation(value = "根据车系和购买年份查询车型列表", notes = "根据车系和购买年份查询车型列表", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/iautos/getPassengerModel", method = RequestMethod.GET)
    @ApiOperationSupport(order = 4)
    @JsonPropFilter(type = CarModelDto.class)
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "seriesId", value = "车系id", required = true, paramType ="query", dataType = "String"),
    	@ApiImplicitParam(name = "purchaseYear", value = "购买年份", required = false, paramType ="query", dataType = "String")
    })
    public RestResponse<List<CarModelDto>> getPassengerModel(@RequestParam(value="seriesId", required=true) String seriesId,
    		@RequestParam(value="purchaseYear", required=false) String purchaseYear) {
        try {
        	List<CarModelDto> resultList=carInfoService.getPassengerModel(seriesId,purchaseYear);
            return new RestResponse<>(resultList);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }
    
    /**
     * <p>Description: 根据车型查询品牌、车系、年款等</p>
     * @return 
     */
    @ApiOperation(value = "根据车型查询品牌、车系、年款等", notes = "根据车型查询品牌、车系、年款等", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/iautos/getMixWithDetail", method = RequestMethod.GET)
    @ApiOperationSupport(order = 5)
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "modelid", value = "车型id", required = true, paramType ="query", dataType = "String")
    })
    @JsonPropFilter(type = CarDetailDto.class)
    public RestResponse<CarDetailDto> getMixWithDetail(@RequestParam(value="modelid", required=true) String modelid) {
        try {
        	CarDetailDto result = carInfoService.getMixWithDetail(modelid);
            return new RestResponse<>(result);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }
    
    @ApiOperation(value = "第一车网根据估价id查询估价信息", notes = "根据估价id查询估价信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/iautos/assessrecordInfo", method = RequestMethod.GET)
    @ApiOperationSupport(order = 6)
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "id", value = "估计id", required = true, paramType ="query", dataType = "String")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<AssessForReplaceDto> assessrecordInfo(@RequestParam(value="id", required=true) String id) {
        try {
        	AssessForReplaceDto result = carInfoService.assessrecordInfo(id);
            return new RestResponse<>(result);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }
    
    /*@ApiOperation(value = "查询第一车网高合车型列表", notes = "查询第一车网高合车型列表", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/iautos/hiphi/model/list", method = RequestMethod.GET)
    @ApiOperationSupport(order = 7)
    @ApiImplicitParams({})
    @JsonPropFilter(type = String.class)
    public RestResponse<List<CarModelDto>> hiphiModelList() {
        try {
        	List<CarModelDto> result = carInfoService.hiphiModelList();
            return new RestResponse<>(result);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }*/

    /**
     * Description: 查询车辆城市列表
     */
    @ApiOperation("查询车辆城市列表")
    @PostMapping("/queryRegionList")
    @JsonPropFilter(type = SysRegionEntity.class)
    public RestResponse<List<SysRegionEntity>> queryRegionList() {
        try {
            List<SysRegionEntity> list = carInfoService.queryRegionList();
            return new RestResponse<>(RestStatusCode.OK, list);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }
}
