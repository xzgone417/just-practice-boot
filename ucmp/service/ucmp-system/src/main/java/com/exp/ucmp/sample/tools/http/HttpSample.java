package com.exp.ucmp.sample.tools.http;

import java.io.IOException;
import java.net.URI;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.egrid.core.httpclient.BodyConverter;
import com.egrid.core.httpclient.HttpCall;
import com.egrid.core.json.jackson.JsonMapper;
import com.egrid.core.json.pool.JsonPool;
import com.fasterxml.jackson.databind.JsonNode;

import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okio.BufferedSource;

/**
 * Http客户端
 * 
 */
public class HttpSample {
	private static final Logger LOGGER = LoggerFactory.getLogger(HttpSample.class);

	/**
	 * Http返回的响应内容是Json
	 * @throws Exception
	 */
	public void postByForm() throws Exception {
		HttpCall.Factory http = new HttpCall.Factory(new OkHttpClient.Builder().connectTimeout(10, TimeUnit.SECONDS)
				.readTimeout(60, TimeUnit.SECONDS).build(),
				HttpUrl.get(new URI("http://apis.juhe.cn/simpleWeather/query")));
		RequestBody formBody = new FormBody.Builder().add("city", "16").add("key", "9dd6217646d5dcd985fe1102e63bdd2c")
				.build();
		Request httpRequest = new Request.Builder().url(http.baseUrl.newBuilder().build()).post(formBody).build();
		String result = http.execute(httpRequest, new BodyConverter.StringBodyConverter());
		LOGGER.info("POST响应结果{}", result);
	}
	
	/**
	 * Get方式
	 * @throws Exception
	 */
	public void get() throws Exception {
		HttpCall.Factory http = new HttpCall.Factory(new OkHttpClient.Builder().connectTimeout(10, TimeUnit.SECONDS)
				.readTimeout(60, TimeUnit.SECONDS).build(),
				HttpUrl.get(new URI("http://apis.juhe.cn/simpleWeather/query?city=16&key=9dd6217646d5dcd985fe1102e63bdd2c")));
		Request httpRequest = new Request.Builder().url(http.baseUrl.newBuilder().build()).get().build();
		String result = http.execute(httpRequest, new StringBodyConverter());
		LOGGER.info(" GET响应结果{}", result);
	}
	
	public static class StringBodyConverter implements BodyConverter<String> {
		@Override
		public String convert(BufferedSource content) throws IOException {
	        JsonPool json = new JsonPool();
	        JsonMapper jsonMapper = (JsonMapper) json.borrow();
	        try {
	            JsonNode root = jsonMapper.readTree(content.readByteArray());
	            return root.toString();
	        } finally {
	            json.restore(jsonMapper);
	        }
	    }
	}
	
	public static void main(String[] args) {
		HttpSample sample = new HttpSample();
		try {
			sample.postByForm();
			sample.get();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
