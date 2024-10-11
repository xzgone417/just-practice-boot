package com.exp.ucmp.pricing.web;

import com.egrid.core.json.body.JsonPropFilter;
import com.egrid.core.util.JsonBeanUtil;
import com.egrid.core.web.response.RestResponse;
import com.egrid.core.web.response.RestStatusCode;
import com.exp.ucmp.pricing.*;
import com.exp.ucmp.pricing.retail.RuleSaveDto;
import com.exp.ucmp.pricing.service.PricingStrategyService;
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
import java.util.List;

/**
 * @author GeYiJiang
 * @Description: 定价策略控制器
 * @date 2023/1/12 16:00
 */
@Api(value = "PricingStrategySet.API", tags = "定价策略维护接口")
@Controller
public class PricingStrategyController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PricingStrategyController.class);

    @Autowired
    PricingStrategyService pricingStrategyService;

    /**
     * Description: 查询定值定价策略
     */
    @ApiOperation(value = "查询定值定价策略", notes = "查询定值定价策略", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/pricingConfig/find", method = RequestMethod.GET)
    @JsonPropFilter(type = String.class)
    public RestResponse<List<PricingStrategyDto>> find() {
        try {
            List<PricingStrategyDto> pageInfo = pricingStrategyService.queryPricingStrategy();
            return new RestResponse<>(RestStatusCode.OK, pageInfo);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

    /**
     * Description: 查询区间定价策略
     */
    @ApiOperation(value = "查询区间定价策略", notes = "查询区间定价策略", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/pricingConfig/findSection", method = RequestMethod.GET)
    @JsonPropFilter(type = String.class)
    public RestResponse<List<PricingStrategySectionDto>> findSection() {
        try {
            List<PricingStrategySectionDto> pageInfo = pricingStrategyService.queryPricingStrategySection();
            return new RestResponse<>(RestStatusCode.OK, pageInfo);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

    /**
     * Description: 更新定值定价策略
     */
    @ApiOperation(value = "更新定值定价策略", notes = "更新定值定价策略", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/pricingConfig/updateFixed", method = RequestMethod.POST)
    @JsonPropFilter(type = String.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "params", value = "更新定值定价策略参数", required = true, paramType ="body", dataType = "UpdateFixedParamsDto")
    })
    public RestResponse<Boolean> updateFixed(@RequestBody UpdateFixedParamsDto params) {
        try {
            Boolean updateFixed = pricingStrategyService.updateFixed(params);
            return new RestResponse<>(RestStatusCode.OK, updateFixed);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

    /**
     * Description: 更新区间定价策略
     */
    @ApiOperation(value = "更新区间定价策略", notes = "更新区间定价策略", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/pricingConfig/updateSection", method = RequestMethod.POST)
    @JsonPropFilter(type = String.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "params", value = "更新区间定价策略", required = true, paramType ="body", dataType = "UpdateSectionParamsDto")
    })
    public RestResponse<Boolean> updateSection(@RequestBody UpdateSectionParamsDto params) {
    	LOGGER.info("======更新区间定价策略======"+JsonBeanUtil.beanToJson(params));
        try {
            Boolean updateFixed = pricingStrategyService.updateSection(params);
            return new RestResponse<>(RestStatusCode.OK, updateFixed);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

    /**
     * Description: 删除区间定价策略
     */
    @ApiOperation(value = "删除区间定价策略", notes = "删除区间定价策略", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/pricingConfig/deleteSection", method = RequestMethod.POST)
    @JsonPropFilter(type = String.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "params", value = "删除区间定价策略", required = true, paramType ="body", dataType = "DeleteSectionParamsDto")
    })
    public RestResponse<Boolean> deleteSection(@RequestBody DeleteSectionParamsDto params) {
        try {
            Boolean updateFixed = pricingStrategyService.deleteSection(params);
            return new RestResponse<>(RestStatusCode.OK, updateFixed);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

    /**
     * Description: 价格试算
     */
    @ApiOperation(value = "价格试算", notes = "价格试算", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/pricingConfig/priceTrial", method = RequestMethod.POST)
    @JsonPropFilter(type = String.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "params", value = "价格试算", required = true, paramType ="body", dataType = "PriceTrialDto")
    })
    public RestResponse<PriceTrialResultDto> priceTrial(@RequestBody PriceTrialDto params) {
        try {
            PriceTrialResultDto priceTrialResultDto = pricingStrategyService.priceTrial(params);
            return new RestResponse<>(RestStatusCode.OK, priceTrialResultDto);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

    /**
     * Description: 规则保存
     */
    @ApiOperation(value = "规则保存", notes = "规则保存", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/pricingConfig/save", method = RequestMethod.POST)
    @JsonPropFilter(type = String.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "params", value = "规则保存", required = true, paramType ="body", dataType = "RuleSaveDto")
    })
    public RestResponse<Boolean> save(@RequestBody RuleSaveDto params) {
        try {
            return new RestResponse<>(RestStatusCode.OK, pricingStrategyService.save(params));
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

    /**
     * Description: 规则查询
     */
    @ApiOperation(value = "规则查询", notes = "规则查询", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/pricingConfig/rulesQuery", method = RequestMethod.GET)
    @JsonPropFilter(type = String.class)
    public RestResponse<RuleSaveDto> rulesQuery() {
        try {
            return new RestResponse<>(RestStatusCode.OK, pricingStrategyService.query());
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

}
