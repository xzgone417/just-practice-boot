/**
 * 
 * 初米网络
 * Copyright (C) 2018 Egridcloud, Inc, All rights reserved.
 */
package com.egrid.ai.dm.consumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.egrid.ai.talk.dto.DialogueManageReqDto;
import com.egrid.ai.talk.dto.DmResponseDto;
import com.egrid.core.web.response.RestResponse;

/**
 * @author lx
 * @date 2018/10/24
 */
@FeignClient(value="ai-service-dm")
public interface IDialogueManageConsumer {

    /**
     * 对话管理
     * @param dmReqDto 请求参数
     * @return 处理结果
     */
    @RequestMapping(value = "/service/v1/dialog/manage", method = RequestMethod.POST)
    public RestResponse<DmResponseDto> dialogueManage(@RequestBody DialogueManageReqDto dmReqDto);
    
    /**
     * 对话管理
     * @param dmReqDto 请求参数
     * @return 处理结果
     */
    @RequestMapping(value = "/service/v2/dialog/manage", method = RequestMethod.POST)
    public RestResponse<DmResponseDto> dialogueManageV2(@RequestBody DialogueManageReqDto dmReqDto);
}
