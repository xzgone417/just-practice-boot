package com.exp.ucmp.maindata.web;


import com.egrid.core.json.body.JsonPropFilter;
import com.egrid.core.util.JsonBeanUtil;
import com.egrid.core.web.response.RestResponse;
import com.exp.ucmp.maindata.dto.ProvinceDto;
import com.exp.ucmp.maindata.service.AdministrativeRegionService;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


/**
 * 
 * @author xiongneng
 * @date 2022年10月09日
 */
@Api(value = "行政区信息", tags = "查询行政区信息")
@RefreshScope
@Controller
public class AdministrativeRegionController {

	/**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(AdministrativeRegionController.class);
    
    @Autowired
	private AdministrativeRegionService administrativeRegionService;
    
    @ApiOperation(value = "查询上牌城市", notes = "查询上牌城市（省市）", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/main/data/getRegisteredCity", method = RequestMethod.GET)
    @ApiOperationSupport(order = 1)
    @JsonPropFilter(type = ProvinceDto.class)
    public RestResponse<List<ProvinceDto>> getRegisteredCity(){
		List<ProvinceDto> result=this.administrativeRegionService.getRegisteredCity();
		LOGGER.info("======省市列表======"+JsonBeanUtil.beanToJson(result));
		return new RestResponse<>(result);
	}

    @ApiOperation(value = "查询上牌省市区", notes = "查询上牌城市（省市）", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/main/data/getRegisteredCityDistrict", method = RequestMethod.GET)
    @ApiOperationSupport(order = 1)
    @JsonPropFilter(type = ProvinceDto.class)
    public RestResponse<List<ProvinceDto>> getRegisteredCityDistrict(){
        List<ProvinceDto> result=this.administrativeRegionService.getRegisteredCityDistrict();
        return new RestResponse<>(result);
    }
}
