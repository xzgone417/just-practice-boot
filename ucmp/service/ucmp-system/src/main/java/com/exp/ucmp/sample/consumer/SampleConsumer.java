/**
 * 
 * 初米网络
 * Copyright (C) 2022 Egridcloud, Inc, All rights reserved.
 */
package com.exp.ucmp.sample.consumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.egrid.core.web.response.RestResponse;
import com.exp.ucmp.PageDto;
import com.exp.ucmp.sample.dto.SampleParameterDto;
import com.github.pagehelper.PageInfo;

/**
 * Feign的样例
 */
@FeignClient(value="ucmp-system", contextId="SampleConsumer")
public interface SampleConsumer {

	@RequestMapping(value = "/api/sample/find", method = RequestMethod.POST)
    public RestResponse<PageInfo<SampleParameterDto>> find(@RequestBody PageDto pageDto);
    
}
