/**
 * 
 * 初米网络
 * Copyright (C) 2018 Egridcloud, Inc, All rights reserved.
 */
package com.egrid.ai.nlu.consumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.egrid.ai.talk.dto.TalkContentReqDto;
import com.egrid.ai.talk.dto.TalkIntentResultDto;
import com.egrid.core.web.response.RestResponse;

/**
 * @author lx
 * @date 2018/10/24
 */
 @FeignClient(value="ai-service-nlu")
public interface ISemanticUnderstandConsumer {

     /**
      * 语义分析
      * @param talkContentReqDto 请求参数
      * @return 语义分析结果
      */
     @RequestMapping(value = "/service/v1/dialog/understand", method = RequestMethod.POST)
     public RestResponse<TalkIntentResultDto> semanticUnderstand (@RequestBody TalkContentReqDto talkContentReqDto);
}
