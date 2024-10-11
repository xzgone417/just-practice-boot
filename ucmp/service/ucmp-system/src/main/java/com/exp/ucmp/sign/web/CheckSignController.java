package com.exp.ucmp.sign.web;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.egrid.core.json.body.JsonPropFilter;
import com.egrid.core.web.RestStatus;
import com.egrid.core.web.response.RestResponse;
import com.egrid.core.web.response.RestStatusCode;
import com.exp.ucmp.sign.service.CheckSignService;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "校验其它系统签名信息", tags = "校验其它系统签名信息")
@RefreshScope
@Controller
public class CheckSignController {
	
	/**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(CheckSignController.class);
	
	@Autowired
	private CheckSignService checkSignService;
	
	/**
     * <p>Description: 校验第三方调用UCMP接口的签名</p>
     * @return 
     */
    @ApiOperation(value = "校验第三方调用UCMP接口的签名", notes = "校验第三方调用UCMP接口的签名", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/check/sign", method = RequestMethod.POST)
    @ApiOperationSupport(order = 1)
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "params", value = "校验头信息", required = true, paramType ="body", dataType = "Map")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<String> checkSign(@RequestBody Map<String,Object> params) {
        try {
        	String reslut = this.checkSignService.checkSign(params);
        	if("-1".equals(reslut)){
        		return new RestResponse<>(RestStatusCode.BAD_REQUEST,"sign不能为空");
        	}else if("-2".equals(reslut)){
        		return new RestResponse<>(RestStatusCode.BAD_REQUEST,"channel不能为空");
        	}else if("-3".equals(reslut)){
        		return new RestResponse<>(RestStatusCode.BAD_REQUEST,"timestamp不能为空");
        	}else if("-4".equals(reslut)){
        		return new RestResponse<>(RestStatusCode.BAD_REQUEST,"sign校验不通过");
        	}else if("1".equals(reslut)){
        		return new RestResponse<>(RestStatusCode.OK);
        	}else{
        		return new RestResponse<>(RestStatusCode.BAD_REQUEST,"未知异常");
        	}
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }
}
