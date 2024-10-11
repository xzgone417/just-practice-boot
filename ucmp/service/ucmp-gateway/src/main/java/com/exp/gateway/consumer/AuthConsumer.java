package com.exp.gateway.consumer;

import java.util.Map;

import feign.Headers;
import feign.RequestLine;

import com.egrid.core.web.response.RestResponse;

/**
 * 
 * 
 * @author Yiyongfei
 *
 */
public interface AuthConsumer {
    /**
     * <p>
     * Description: 校验请求是否登陆认证
     * </p>
     * 
     * @return
     */
	@Headers({"Content-Type: application/json","Accept: application/json"})
	@RequestLine("GET /api/auth/isPermitted")
    public RestResponse<Map<String, Object>> isPermitted();
}
