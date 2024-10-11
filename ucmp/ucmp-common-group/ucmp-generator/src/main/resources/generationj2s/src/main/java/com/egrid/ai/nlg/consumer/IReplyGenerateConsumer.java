/**
 * 
 * 初米网络
 * Copyright (C) 2018 Egridcloud, Inc, All rights reserved.
 */
package com.egrid.ai.nlg.consumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.egrid.ai.talk.dto.ReplyGenerateReqDto;
import com.egrid.ai.talk.dto.ReplyGenerateResultDto;
import com.egrid.core.web.response.RestResponse;

/**
 * @author lx
 * @date 2018/10/24
 */
@FeignClient(value="ai-service-nlg")
public interface IReplyGenerateConsumer {

     /**
      * 应答生成
      * @param replyGenerateReqDto 请求参数
      * @return 应答
      */
     @RequestMapping(value = "/service/v1/dialog/generate", method = RequestMethod.POST)
     public RestResponse<ReplyGenerateResultDto> generate(@RequestBody ReplyGenerateReqDto replyGenerateReqDto);
     
     /**
      * 应答生成
      * @param replyGenerateReqDto 请求参数
      * @return 应答
      */
     @RequestMapping(value = "/service/v2/dialog/generate", method = RequestMethod.POST)
     public RestResponse<ReplyGenerateResultDto> generateV2(@RequestBody ReplyGenerateReqDto replyGenerateReqDto);
}
