package com.exp.ucmp.notice.web;


import javax.validation.Valid;

import com.exp.ucmp.eos.dto.*;
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
import com.egrid.core.util.StringUtil;
import com.egrid.core.web.response.RestResponse;
import com.egrid.core.web.response.RestStatusCode;
import com.exp.ucmp.notice.service.EosMessageService;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 
 * @author xiongneng
 * 2022.10.16
 *
 */
@Api(value = "APP推送展厅站内信息", tags = "推送展厅站内信息")
@RefreshScope
@Controller
public class EosMessageController {
	
	/**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(EosMessageController.class);
    
    @Autowired
    private EosMessageService eosMessageService;
    
    /**
     * <p>Description: 推送展厅站内信息</p>
     * @return 
     */
    @ApiOperation(value = "推送展厅站内信息", notes = "推送展厅站内信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/eos/sendMessage", method = RequestMethod.POST)
    @ApiOperationSupport(order = 1)
    @JsonPropFilter(type = String.class)
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "messageParamDto", value = "eos消息推送参数类", required = false, paramType ="body", dataType = "MessageParamDto")
    })
    public RestResponse<String> sendMessage(@RequestBody @Valid MessageParamDto messageParamDto) {
        try {
        	EosReturnDto<String> result = eosMessageService.sendMessage(messageParamDto);
        	if(result !=null){
        		if("200".equals(result.getCode())){
        			LOGGER.info("推送展厅站内信息="+result);
        			return new RestResponse<>(result.getData());
        		}else{
        			return new RestResponse<>(RestStatusCode.BAD_REQUEST, result.getData());
        		}
        	}else{
        		return new RestResponse<>("");
        	}
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }


    /**
     * <p>Description: 推送企信公共接口</p>
     * @return
     */
    @ApiOperation(value = "推送企信公共接口", notes = "推送企信公共接口", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/slf/giveMessage", method = RequestMethod.POST)
    @ApiOperationSupport(order = 1)
    @JsonPropFilter(type = String.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "messageParamDto", value = "slf消息推送参数类", required = false, paramType ="body", dataType = "GiveMessageParamDto")
    })
    public RestResponse<String> giveMessage(@RequestBody @Valid GiveMessageParamDto messageParamDto) {
    	LOGGER.info("=========推送企信公共接口=" + JsonBeanUtil.beanToJson(messageParamDto));
        try {
            EosReturnDto<String> result = eosMessageService.giveMessage(messageParamDto);
            if(result !=null){
                if("000000".equals(result.getCode())){
                    LOGGER.info("推送企信公共接口="+result);
                    return new RestResponse<>(result.getData());
                }else{
                    return new RestResponse<>(RestStatusCode.BAD_REQUEST, result.getData());
                }
            }else{
                return new RestResponse<>("");
            }
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }

    /**
     * <p>Description: 查询单个顾问信息以及上级信息</p>
     * @return
     */
    @ApiOperation(value = "查询单个顾问信息以及上级信息", notes = "查询单个顾问信息以及上级信息")
    @RequestMapping(value = "/api/slf/getUserAndHigherLevel", method = RequestMethod.POST)
    @ApiImplicitParams({
    		@ApiImplicitParam(name = "token", value = "用户token 高大麦端传", required = false, dataType = "String"),
            @ApiImplicitParam(name = "userId", value = "用户id salesforce端传", required = false, dataType = "String"),
            @ApiImplicitParam(name = "isCreate", value = "是否是创建预约单页面 0 否 1 是", required = false, paramType ="query", dataType = "String")
    })
    @ApiOperationSupport(order = 1)
    @JsonPropFilter(type = String.class)
    public RestResponse<Object> getUserAndHigherLevel(@RequestParam(value="token", required=false) String token,
    		@RequestParam(value="userId", required=false) String userId,@RequestParam(value="isCreate", required=false,defaultValue="0") int isCreate) {
        LOGGER.info("===token="+token+",=userId="+userId+",=isCreate="+isCreate);
    	try {
        	if(StringUtil.isEmpty(token)&&StringUtil.isEmpty(userId)){
        		throw new Exception("token和userId不能同时为空");
        	}
            UserAndSuperiorInfoDto result = eosMessageService.getUserAndHigherLevel(userId,isCreate,token);
            return new RestResponse<>(result);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, "系统异常，请联系后台管理员");
        }
    }

}
