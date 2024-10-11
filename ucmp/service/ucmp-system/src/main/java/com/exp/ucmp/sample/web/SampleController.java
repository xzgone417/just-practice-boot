package com.exp.ucmp.sample.web;

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

import com.egrid.core.json.body.JsonBody;
import com.egrid.core.json.body.JsonPropFilter;
import com.egrid.core.web.response.RestResponse;
import com.egrid.core.web.response.RestStatusCode;
import com.exp.ucmp.PageDto;
import com.exp.ucmp.sample.dto.SampleParameterDto;
import com.exp.ucmp.sample.service.SampleService;
import com.github.pagehelper.PageInfo;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "Sample.API", tags = "Sample样例接口")
@RefreshScope
@Controller
public class SampleController {
	 /**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(SampleController.class);

    @Autowired
    private SampleService sampleService;

    /**
     * Description: 保存
     */
    @ApiOperation(value = "保存", notes = "保存", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/sample/save", method = RequestMethod.POST)
    @ApiOperationSupport(order = 1, includeParameters = {"parameterDto.namezh", "parameterDto.nameen", "parameterDto.value"})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "parameterDto", value = "参数信息", required = true, paramType ="body", dataType = "SampleParameterDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<String> save(@RequestBody SampleParameterDto parameterDto) {
        try {
        	LOGGER.info("接收到参数，参数内容{}", parameterDto.toString());
            sampleService.saveParameterDto(parameterDto);
            return new RestResponse<>(RestStatusCode.OK);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }
    
    /**
     * Description: 查询
     */
    @ApiOperation(value = "查询(响应内容过滤)", notes = "查询(响应内容过滤)", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/sample/find/filter", method = RequestMethod.POST)
    @ApiOperationSupport(order = 2)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "pageDto", value = "参数信息", required = true, paramType ="body", dataType = "PageDto")
    })
    @JsonPropFilter(type = SampleParameterDto.class, include = "namezh, nameen, value")
    public RestResponse<PageInfo<SampleParameterDto>> findFilter(@RequestBody PageDto pageDto) {
        try {
        	PageInfo<SampleParameterDto> page = sampleService.findParameterDto(pageDto);
        	LOGGER.info("欲返回的内容内容{}", page.getList());
            return new RestResponse<>(RestStatusCode.OK, page);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }
    /**
     * Description: 查询
     */
    @ApiOperation(value = "查询(复杂响应内容过滤)", notes = "查询(复杂响应内容过滤)", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/sample/find/complexfilter", method = RequestMethod.POST)
    @ApiOperationSupport(order = 3)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "pageDto", value = "参数信息", required = true, paramType ="body", dataType = "PageDto")
    })
	@JsonBody(filters = { @JsonPropFilter(type = SampleParameterDto.class, include = "namezh, nameen, value"),
			@JsonPropFilter(type = PageInfo.class, include = "pageNum, pageSize, startRow, endRow, total, list") })
	public RestResponse<PageInfo<SampleParameterDto>> findComplexFilter(@RequestBody PageDto pageDto) {
		try {
			PageInfo<SampleParameterDto> page = sampleService.findParameterDto(pageDto);
			LOGGER.info("欲返回的内容内容{}", page.getList());
			return new RestResponse<>(RestStatusCode.OK, page);
		} catch (Exception e) {
			LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
			return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
		}
	}
    /**
     * Description: 查询
     */
    @ApiOperation(value = "查询(完整响应内容)", notes = "查询(完整响应内容)", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/sample/find", method = RequestMethod.POST)
    @ApiOperationSupport(order = 4)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "pageDto", value = "参数信息", required = true, paramType ="body", dataType = "PageDto")
    })
    @JsonPropFilter(type = SampleParameterDto.class)
    public RestResponse<PageInfo<SampleParameterDto>> find(@RequestBody PageDto pageDto) {
        try {
        	PageInfo<SampleParameterDto> page = sampleService.findParameterDto(pageDto);
        	LOGGER.info("欲返回的内容内容{}", page.getList());
            return new RestResponse<>(RestStatusCode.OK, page);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }
    
    /**
     * Description: 查询
     */
    @ApiOperation(value = "查询(feign)", notes = "查询(feign)", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/sample/find/consumer", method = RequestMethod.POST)
    @ApiOperationSupport(order = 5)
    @JsonPropFilter(type = SampleParameterDto.class)
    public RestResponse<List<SampleParameterDto>> findByConsumer() {
        try {
        	List<SampleParameterDto> list = sampleService.findParameterDtoByConsumer();
        	LOGGER.info("欲返回的内容内容{}", list);
            return new RestResponse<>(RestStatusCode.OK, list);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }
}
