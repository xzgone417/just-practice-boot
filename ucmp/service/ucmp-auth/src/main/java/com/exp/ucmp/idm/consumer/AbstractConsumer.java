package com.exp.ucmp.idm.consumer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;

import com.huawei.apig.sdk.util.Constant;
import com.huawei.apig.sdk.util.SSLCipherSuiteUtil;

import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.ResponseBody;

import com.alibaba.nacos.common.utils.HttpMethod;
import com.cloud.apigateway.sdk.utils.Client;
import com.cloud.apigateway.sdk.utils.Request;
import com.egrid.core.util.JsonBeanUtil;

public abstract class AbstractConsumer {
	/**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractConsumer.class);
    
	protected String sendRequest(Request request) throws Exception {
		// Sign the request.
		okhttp3.Request signedRequest = Client.signOkhttp(request, Constant.SIGNATURE_ALGORITHM_SDK_HMAC_SHA256);
		// creat okhttpClient.
		OkHttpClient client = SSLCipherSuiteUtil.createOkHttpClient(Constant.INTERNATIONAL_PROTOCOL);
		// Send the request.
		Response response = client.newCall(signedRequest).execute();
		// Print the status line of the response.
		LOGGER.info("status: " + response.code());
		ResponseBody resEntity = response.body();
		return resEntity.string();
	}
	
	public static class RequestBuilder {
		MediaType mediaType;
		String key;
		String secret;
		String method;
		String url;
		List<String[]> header = new ArrayList<>();
		Map<String, Object> param = new HashMap<>();
		
		public static RequestBuilder getInstance() {
			return new RequestBuilder();
		}

		public RequestBuilder mediaType(MediaType mediaType) {
			if (mediaType.equals(MediaType.APPLICATION_JSON)) {
				header("Content-Type", MediaType.APPLICATION_JSON.toString());
			}
			this.mediaType = mediaType;
			return this;
		} 
		public RequestBuilder key(String key) {
			this.key = key;
			return this;
		}
		public RequestBuilder secret(String secret) {
			this.secret = secret;
			return this;
		}
		public RequestBuilder method(String method) {
			this.method = method;
			return this;
		}
		public RequestBuilder url(String url) {
			this.url = url;
			return this;
		}
		public RequestBuilder header(String name, String value) {
			this.header.add(new String[]{name, value});
			return this;
		}
		public RequestBuilder param(String name, Object value) {
			this.param.put(name, value);
			return this;
		}
		public RequestBuilder params(Map<String, Object> params) {
			this.param.putAll(params);
			return this;
		}
		public Request build() throws Exception {
			Request request = new Request();
			request.setUrl(url);
			request.setKey(key);
			request.setSecret(secret);
			request.setMethod(method);
			for (String[] ary : header) {
				request.addHeader(ary[0], ary[1]);
			}
			if (mediaType.equals(MediaType.APPLICATION_JSON)&&(method.equals(HttpMethod.POST)||method.equals(HttpMethod.PUT))) {
				request.setBody(JsonBeanUtil.beanToJson(param));
			}
			return request;
		}
		
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append("向远程服务[").append(method.toUpperCase()).append(" ").append(url).append("]发送调用请求").append("\n");
			sb.append("  Content-Type:").append(mediaType.toString()).append("\n");
			sb.append("  Headers:");
			int i = 0;
			for (String[] ary : header) {
				if (i > 0) {
					sb.append(",");
				}
				sb.append(ary[0]).append("=").append(ary[1]);
				i ++;
			}
			sb.append("\n");
			sb.append("  Params:").append(param.toString());
			return sb.toString();
		}
	}
}
