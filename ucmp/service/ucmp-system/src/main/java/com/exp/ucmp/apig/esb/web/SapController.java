package com.exp.ucmp.apig.esb.web;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.csp.sentinel.util.StringUtil;
import com.egrid.core.copiers.Copiers;
import com.egrid.core.json.body.JsonPropFilter;
import com.egrid.core.util.JsonBeanUtil;
import com.egrid.core.web.response.RestResponse;
import com.egrid.core.web.response.RestStatusCode;
import com.exp.ucmp.apig.esb.consumer.EmdmConsumer;
import com.exp.ucmp.emdm.dto.AreaDataDto;
import com.exp.ucmp.emdm.dto.DeptDto;
import com.exp.ucmp.emdm.dto.EmdmAreaReturnDto;
import com.exp.ucmp.emdm.dto.EmdmDeptReturnDto;
import com.exp.ucmp.emdm.dto.EmdmReturnDto;
import com.exp.ucmp.emdm.dto.ModelParamDto;
import com.exp.ucmp.emdm.dto.PersonDto;
import com.exp.ucmp.sap.dto.SapPayDto;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;


/**
 * 
 * @author xiongneng
 * @date 2023年09月20日
 */
@Api(value = "SapEsb.API", tags = "SapEsb接口调试")
@RefreshScope
@Controller
public class SapController {

	/**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(SapController.class);
    
    @Autowired
	private EmdmConsumer emdmConsumer;
    
    /**
     * <p>Description: 营销收款同步</p>
     * @return 营销收款同步
     */
    @ApiOperation(value = "营销收款同步", notes = "营销收款同步", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/esb/sap/zifi014", method = RequestMethod.POST)
    @ApiImplicitParams({
		@ApiImplicitParam(name = "sapPayDto", value = "营销收款同步参数类", required = true, paramType = "body", dataType = "SapPayDto")})
    @ApiOperationSupport(order = 4)
    @JsonPropFilter(type = String.class)
    public RestResponse<String> pushSapPayInfo(@RequestBody SapPayDto sapPayDto) {
    	LOGGER.info("===paramMap==="+JsonBeanUtil.beanToJson(sapPayDto));
        try {
            String result = this.emdmConsumer.pushSapPayInfo(sapPayDto);
        	return new RestResponse<>(result);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }
}
