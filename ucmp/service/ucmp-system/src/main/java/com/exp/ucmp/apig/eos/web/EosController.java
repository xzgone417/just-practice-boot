package com.exp.ucmp.apig.eos.web;

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

import com.egrid.core.json.body.JsonPropFilter;
import com.egrid.core.util.JsonBeanUtil;
import com.egrid.core.util.Md5Util;
import com.egrid.core.web.response.RestResponse;
import com.egrid.core.web.response.RestStatusCode;
import com.exp.ucmp.apig.eos.consumer.EosConsumer;
import com.exp.ucmp.eos.dto.AccountInfoDto;
import com.exp.ucmp.eos.dto.EosReturnDto;
import com.exp.ucmp.eos.dto.MessageParamDto;
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
@Api(value = "EosApig.API", tags = "EosApig接口调试")
@RefreshScope
@Controller
public class EosController {

	/**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(EosController.class);
    
    @Autowired
    private EosConsumer eosConsumer;
    
    /**
     * <p>Description: 查询单个顾问信息以及上级信息</p>
     * @return 
     */
    @ApiOperation(value = "查询单个顾问信息以及上级信息", notes = "查询单个顾问信息以及上级信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/apig/eos/getUserAndSuperiorInfo", method = RequestMethod.GET)
    @ApiOperationSupport(order = 1)
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "token", value = "当前用户token", required = false, paramType ="query", dataType = "String"),
    	@ApiImplicitParam(name = "idmAccountName", value = "当前用户登录名", required = false, paramType ="query", dataType = "String")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<String> getUserAndSuperiorInfo(@RequestParam(value="token", required=true) String token,
    		@RequestParam(value="idmAccountName", required=true) String idmAccountName) {
        try {
        	String result = eosConsumer.getUserAndSuperiorInfo(token, idmAccountName);
        		return new RestResponse<>(result);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }
    
    public static void main(String[] args) {
    	String result="{\"code\":\"200\",\"msg\":\"SUCCESS\",\"data\":{\"idmAccountName\":\"WangBao1\",\"userId\":1,\"userName\":\"baoz\",\"phoneNumber\":\"18600000066\",\"roleCode\":\"RE010\",\"roleName\":\"出行顾问\",\"departmentId\":0,\"superiorIdmAccountName\":\"Jiang1Liu\",\"superiorUserId\":2,\"superiorName\":\"刘江\",\"superiorPhoneNumber\":\"18600000077\",\"superiorRoleCode\":\"RE006\",\"superiorRoleName\":\"出行主管\"}}";
    	LOGGER.info("===result=="+result);
    	Map<String,Object> retrunDto=JsonBeanUtil.jsonToBean(result, HashMap.class);
    	AccountInfoDto dto=JsonBeanUtil.jsonToBean(JsonBeanUtil.beanToJson(retrunDto.get("data")), AccountInfoDto.class);
    	LOGGER.info("===AccountInfoDto=="+JsonBeanUtil.beanToJson(dto));
	}
    
    /**
     * <p>Description: 查询门店下所有顾问信息</p>
     * @return 
     */
    @ApiOperation(value = "查询门店下所有顾问信息", notes = "查询门店下所有顾问信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/apig/eos/allUsersInTheDepartment", method = RequestMethod.GET)
    @ApiOperationSupport(order = 2)
    @JsonPropFilter(type = String.class)
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "departmentCode", value = "门店code", required = false, paramType ="query", dataType = "String")
    })
    public RestResponse<String> allUsersInTheDepartment(@RequestParam(value="departmentCode", required=true) String departmentCode) {
        try {
        	String result = eosConsumer.allUsersInTheDepartment(departmentCode);
        		return new RestResponse<>(result);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }
    
    /**
     * <p>Description: 推送展厅站内信息</p>
     * @return 
     */
    @ApiOperation(value = "推送展厅站内信息", notes = "推送展厅站内信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/apig/eos/sendMessage", method = RequestMethod.POST)
    @ApiOperationSupport(order = 3)
    @JsonPropFilter(type = String.class)
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "messageParamDto", value = "eos消息推送参数类", required = false, paramType ="body", dataType = "MessageParamDto")
    })
    public RestResponse<String> sendMessage(@RequestBody @Valid MessageParamDto messageParamDto) {
        try {
        	String result = eosConsumer.sendMessage(messageParamDto);
        	LOGGER.info("推送展厅站内信息="+result);
        		return new RestResponse<>(result);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }
}
