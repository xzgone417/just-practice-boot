package com.exp.ucmp.customer.web;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.csp.sentinel.util.StringUtil;
import com.egrid.core.json.body.JsonPropFilter;
import com.egrid.core.web.response.RestResponse;
import com.egrid.core.web.response.RestStatusCode;
import com.exp.ucmp.customer.service.CustomerInfoService;
import com.exp.ucmp.urm.dto.UserDto;
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
@Api(value = "客户信息", tags = "查询客户信息")
@RefreshScope
@Controller
public class CustomerInfoController {

	/**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerInfoController.class);
    
    @Autowired
    private CustomerInfoService customerInfoService;
    
    /**
     * <p>Description: 客户信息获取</p>
     * @return 
     */
    @ApiOperation(value = "客户信息获取", notes = "客户信息获取", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/customer/info", method = RequestMethod.GET)
    @ApiOperationSupport(order = 1)
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "superIds", value = "用户ID", required = false, paramType ="query", dataType = "String"),
    	@ApiImplicitParam(name = "inquiryId", value = "询价ID", required = false, paramType ="query", dataType = "String")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<UserDto> getCustomerInfo(@RequestParam(value="superIds", required=false) String superIds,
    		@RequestParam(value="inquiryId", required=false) String inquiryId) {
        try {
        	UserDto dto;
        	if(StringUtil.isNotEmpty(superIds)){
        		dto = customerInfoService.getUserInfo(superIds);
        	}else{
        		dto = customerInfoService.getUserInfoByInquiryId(inquiryId);
        	}
            return new RestResponse<>(dto);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }
}
