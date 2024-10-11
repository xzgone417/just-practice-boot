package com.exp.ucmp.replacement.feign;


import com.egrid.core.web.response.RestResponse;
import com.exp.ucmp.jPush.dto.JPushReqDto;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value="ucmp-psi", contextId="SendJpushFegin")
public interface SendJpushFegin {
	
	@RequestMapping(value = "/api/jPush/sendMessage", method = RequestMethod.POST)
	public RestResponse<String> sendJPush(@RequestBody JPushReqDto jPushReqDto);
}
