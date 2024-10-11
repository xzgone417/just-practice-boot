package com.exp.ucmp.apig.iautos.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.egrid.core.json.body.JsonPropFilter;
import com.egrid.core.web.response.RestResponse;
import com.egrid.core.web.response.RestStatusCode;
import com.exp.ucmp.apig.iautos.consumer.IautosConsumer;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;


/**
 * 
 * @author xiongneng
 * @date 2022年09月29日
 */
@Api(value = "IautosApig.API", tags = "IautosApig接口调试")
@RefreshScope
@Controller
public class IautosController {

	/**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(IautosController.class);
    
    @Autowired
    private IautosConsumer iautosConsumer;
    
    /**
     * <p>Description: 第一车网 获取品牌列表</p>
     * @return 
     */
    @ApiOperation(value = "第一车网 获取品牌列表", notes = "1车网 获取品牌列表", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/apig/iautos/getPassengerBrand", method = RequestMethod.GET)
    @ApiOperationSupport(order = 1)
    @JsonPropFilter(type = String.class)
    public RestResponse<String> getPassengerBrand(@RequestParam(value="targetSysId", required=true) String targetSysId) {
        try {
        	String result="[{\"ID\":\"175\",\"Initial\":\"A\",\"Name\":\"阿尔法罗密欧\"}]";
            return new RestResponse<>(result);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }
    
    /**
     * <p>Description: 第一车网 根据品牌查询车系列表(带有厂商信息)</p>
     * @return 
     */
    @ApiOperation(value = "第一车网 根据品牌查询车系列表(带有厂商信息)", notes = "根据品牌查询车系列表(带有厂商信息)", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/apig/iautos/getPassengerSeries", method = RequestMethod.GET)
    @ApiOperationSupport(order = 2)
    @JsonPropFilter(type = String.class)
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "brandid", value = "品牌id", required = false, paramType ="query", dataType = "String")
    })
    public RestResponse<String> getPassengerSeries(@RequestParam(value="brandid", required=true) String brandid) {
        try {
        	String result="[{\"CarMfrs\":{\"ID\":\"199\",\"Name\":\"阿尔法·罗密欧[进口]\"},\"CarSeries\":[{\"ID\":\"674\",\"Name\":\"Spider\"}]}]";
            return new RestResponse<>(result);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }
    
    /**
     * <p>Description: 第一车网 根据车系查询购买年份列表</p>
     * @return 
     */
    @ApiOperation(value = "第一车网 根据车系查询购买年份列表", notes = "根据车系查询购买年份列表", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/apig/iautos/getPassengerYear", method = RequestMethod.GET)
    @ApiOperationSupport(order = 3)
    @JsonPropFilter(type = String.class)
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "seriesid", value = "车系id", required = false, paramType ="query", dataType = "String")
    })
    public RestResponse<String> getPassengerYear(@RequestParam(value="seriesid", required=true) String seriesid) {
        try {
        	String result="[\"2013\",\"2012\"]";
            return new RestResponse<>(result);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }
    
    /**
     * <p>Description: 第一车网 根据车系查询购买年份列表</p>
     * @return 
     */
    @ApiOperation(value = "第一车网 根据车系年款查询车型列表", notes = "根据车系年款查询车型列表", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/apig/iautos/getPassengerModel", method = RequestMethod.GET)
    @ApiOperationSupport(order = 4)
    @JsonPropFilter(type = String.class)
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "seriesid", value = "车系id", required = false, paramType ="query", dataType = "String")
    })
    public RestResponse<String> getPassengerModel(@RequestParam(value="seriesid", required=true) String seriesid,@RequestParam(value="purchaseyear", required=true) String purchaseyear) {
        try {
        	String result="[{\"Displacement\":\"3.5\",\"ID\":\"	\",\"Name\":\"日产Skyline-3.5-MT\",\"Price\":\"30.8400\",\"TransmissionType\":\"6档 手动\",\"VersionYear\":\"2006\",\"ProductionYear\":\"2012\",\"VersionDate\":\"200601\"}]";
            return new RestResponse<>(result);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }
    
    /**
     * <p>Description: 第一车网 根据车型查询品牌、车系、年款等</p>
     * @return 
     */
    @ApiOperation(value = "第一车网 根据车型查询品牌、车系、年款等", notes = "根据车型查询品牌、车系、年款等", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/apig/iautos/getMixWithDetail", method = RequestMethod.GET)
    @ApiOperationSupport(order = 5)
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "modelid", value = "车型id", required = true, paramType ="query", dataType = "String")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<String> getMixWithDetail(@RequestParam(value="modelid", required=true) String modelid) {
        try {
        	String result = iautosConsumer.getMixWithDetail(modelid);
            return new RestResponse<>(result);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }
    
    /**
     * <p>Description: 第一车网 根据估价id查询估价信息</p>
     * @return 
     */
    @ApiOperation(value = "第一车网根据估价id查询估价信息", notes = "根据估价id查询估价信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/apig/iautos/assessrecordInfo", method = RequestMethod.GET)
    @ApiOperationSupport(order = 6)
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "id", value = "估计id", required = true, paramType ="query", dataType = "String")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<String> assessrecordInfo(@RequestParam(value="id", required=true) String id) {
        try {
        	String result = iautosConsumer.assessrecordInfo(id);
            return new RestResponse<>(result);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }
}
