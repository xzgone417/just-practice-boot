package com.exp.ucmp.user.web;



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
import com.egrid.core.util.JsonBeanUtil;
import com.egrid.core.web.response.RestResponse;
import com.egrid.core.web.response.RestStatusCode;
import com.exp.ucmp.tsp.dto.RegAndLoginDto;
import com.exp.ucmp.user.service.IdmcUserService;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;


/**
 * 
 * @author xiongneng
 * @date 2023年08月15日
 */
@Api(value = "二手车销售客户创建", tags = "二手车销售客户创建")
@RefreshScope
@Controller
public class IdmcUserController {

	/**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(IdmcUserController.class);
    
    @Autowired
	private IdmcUserService idmcUserService;
    

    @ApiOperation(value = "手机号直接注册登入", notes = "手机号直接注册登入", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/api/idmc/mobilePhoneRegAndLogin", method = RequestMethod.POST)
	@ApiOperationSupport(order = 1)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "regAndLoginDto", value = "手机号直接注册登入", required = true, paramType = "body", dataType = "RegAndLoginDto")})
	@JsonPropFilter(type = String.class)
	public RestResponse<String> mobilePhoneRegAndLogin(@RequestBody RegAndLoginDto regAndLoginDto) {
		LOGGER.info("====手机号直接注册登入===="+JsonBeanUtil.beanToJson(regAndLoginDto));
		try {
			String result = idmcUserService.mobilePhoneRegAndLogin(regAndLoginDto);
			return new RestResponse<>(RestStatusCode.OK,result);
		} catch (Exception e) {
			LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
			return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, "服务异常，请联系系统管理员");
		}
	}
}
