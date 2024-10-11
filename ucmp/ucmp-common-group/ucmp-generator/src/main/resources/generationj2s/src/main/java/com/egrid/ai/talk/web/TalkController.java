/**
 * 
 * 初米网络
 * Copyright (C) 2018 Egridcloud, Inc, All rights reserved.
 */
 package com.egrid.ai.talk.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.egrid.ai.constant.Constants;
import com.egrid.ai.talk.dto.DialogReqDto;
import com.egrid.ai.talk.dto.DialogResultDto;
import com.egrid.ai.talk.service.ITalkService;
import com.egrid.core.json.body.JsonPropFilter;
import com.egrid.core.web.response.RestResponse;
import com.egrid.core.web.response.RestStatusCode;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author lx
 * @date 2018/10/24
 */
 @Api(value = "Talk.API", description = "对话")
 @RefreshScope
 @Controller
public class TalkController {

     /**
      * <p>
      * Field LOGGER: log
      * </p>
      */
     private static final Logger LOGGER = LoggerFactory.getLogger(TalkController.class);
     
     
     @Autowired
     private ITalkService talkService;
     
     
     /**
      * 对话
      * @param talkContentReqDto 请求参数
      * @return 应答
      */
     @ApiOperation(value = "对话", notes = "对话", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
     @RequestMapping(value = "/service/v1/italk/dialog", method = RequestMethod.POST)
     @JsonPropFilter(type = DialogResultDto.class)
     public RestResponse<DialogResultDto> dialog(@RequestBody DialogReqDto dialogReqDto) {
         try {
             DialogResultDto dialogResultDto = talkService.dialog(dialogReqDto);
             return new RestResponse<>(RestStatusCode.OK, dialogResultDto);
         } catch (Exception e) {
             LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
             return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, new Exception(Constants.SERVER_ERROR_MESSAGE));
         }
     }
}
