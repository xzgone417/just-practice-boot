package com.exp.ucmp.evaluate.web;

import java.util.List;

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

import com.egrid.core.json.body.JsonPropFilter;
import com.egrid.core.web.response.RestResponse;
import com.egrid.core.web.response.RestStatusCode;
import com.exp.ucmp.evaluate.service.UscEvaluateService;
import com.exp.ucmp.usc.dto.CreateEvaluationDto;
import com.exp.ucmp.usc.dto.EvaluationDetailDto;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author xiongneng
 * 2022.10.16
 *
 */
@Api(value = "评价", tags = "评价")
@RefreshScope
@Controller
public class UscEvaluateController {
	
	/**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(UscEvaluateController.class);
    
    @Autowired
    private UscEvaluateService uscEvaluateService;
    
    @ApiOperation(value = "创建评价单", notes = "创建评价单", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/usc/createEvaluation", method = RequestMethod.POST)
    @ApiOperationSupport(order = 1)
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "createEvaluationDto", value = "参数信息", required = true, paramType ="body", dataType = "CreateEvaluationDto") })
    @JsonPropFilter(type = String.class)
    public RestResponse<String> createEvaluation(@RequestBody CreateEvaluationDto createEvaluationDto) {
        try {
        	String dto=this.uscEvaluateService.createEvaluation(createEvaluationDto);
        	return new RestResponse<>(dto);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }
    
	@ApiOperation(value = "查询评价详情", notes = "查询评价详情", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/api/usc/getEvaluationDetail", method = RequestMethod.GET)
	@ApiOperationSupport(order = 2)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "businessNo", value = "业务编码", required = true, paramType = "query", dataType = "String")})
	@JsonPropFilter(type = EvaluationDetailDto.class)
	public RestResponse<EvaluationDetailDto> getEvaluationDetail(@RequestParam(value = "businessNo", required = true) String businessNo) {
		try {
			EvaluationDetailDto result = uscEvaluateService.getEvaluationDetail(businessNo);
			return new RestResponse<>(result);
		} catch (Exception e) {
			LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
			return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
		}
	}
}
