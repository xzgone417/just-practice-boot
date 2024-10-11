package com.exp.gateway.interceptor;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;

import feign.RequestInterceptor;
import feign.RequestTemplate;

/**
 * 
 * 用于设置Header内容
 * @author Yiyongfei
 *
 */
public class FeignInterceptor implements RequestInterceptor
{
	private String[] saveToHeader = null;
	private Map<String, String> addHeader = null;
	private ServerHttpRequest request = null;
	
	public FeignInterceptor(ServerHttpRequest request, String[] saveToHeader, Map<String, String> addHeader) {
		this.saveToHeader = saveToHeader;
		this.addHeader = addHeader;
		this.request = request;
	}
	
	@Override
	public void apply(RequestTemplate template) {
	    HttpHeaders headers = request.getHeaders();
	    Set<Entry<String, List<String>>> headerSet = headers.entrySet();
	    if(headerSet != null && !headerSet.isEmpty()) {
	        Iterator<Entry<String, List<String>>> it = headerSet.iterator();
	        while (it.hasNext()) {
	            Entry<String, List<String>> entry = it.next();
                String name = entry.getKey();
                String values = entry.getValue().get(0);
                template.header(name, values);
            }
	    }
	    
        //解决form表单提交无法设置header问题
        for(String paramName : saveToHeader) {
        	String token = headers.getFirst(paramName);
            if (StringUtils.isEmpty(token)) {
                MultiValueMap<String, String> multiValueMap = request.getQueryParams();
                String tokenPm = multiValueMap.getFirst(paramName);
                if (!StringUtils.isEmpty(tokenPm)) {
                    template.header(paramName, tokenPm);
                }
            } else {
                template.header(paramName, token);
            }
        }
        if (addHeader != null && !addHeader.isEmpty()) {
            Set<String> it = addHeader.keySet();
            for(String paramName : it) {
                template.header(paramName, addHeader.get(paramName));
            }
        }
	}

}
