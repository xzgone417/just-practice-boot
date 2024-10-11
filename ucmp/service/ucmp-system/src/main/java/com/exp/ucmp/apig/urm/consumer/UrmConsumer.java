package com.exp.ucmp.apig.urm.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.egrid.core.util.JsonBeanUtil;
import com.exp.ucmp.apig.AbstractConsumer;
import com.exp.ucmp.util.UcmpUtils;

@Component
public class UrmConsumer extends AbstractConsumer {
	/**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(UrmConsumer.class);
    
	@Autowired
	private UrmProperties urmProperties;

	protected enum UrmEnum { // URM接口
		userProfilesQuery("/urm-adapter/v1/user/profiles/query"),
		accountGetTokenByAccount("/urm-account/v1/account/getTokenByAccount"),
		PointsTaskGrantInterface("/urm-adapter/v1/pointsTask/points/grant");

        private String url;

        private UrmEnum(String value) {
            this.url = value;
        }
        public String url() {
            return this.url;
		}
	}

	public String userProfilesQuery(String superIds) throws Exception {
		Map<String, Object> params = new HashMap<>();
		String traceId = buildTraceId(UrmEnum.userProfilesQuery.name());
		params.put("traceId", traceId);
		params.put("requestId", traceId);
		params.put("activity", UrmEnum.userProfilesQuery.name());
		params.put("platform", urmProperties.getPlatform());
		params.put("token", urmProperties.getToken());
		params.put("superIds", superIds);
		params.put("type", 1);
		params.put("page", 1);
		params.put("size", 10);
		LOGGER.info("===ak==="+urmProperties.getKey()+"===SK="+urmProperties.getSecret());
		RequestBuilder requestBuilder = RequestBuilder.getInstance().key(urmProperties.getKey()).secret(urmProperties.getSecret())
				.mediaType(MediaType.APPLICATION_JSON).method("POST")
				.url(urmProperties.getUri() + UrmEnum.userProfilesQuery.url)
				.header("platformId", urmProperties.getPlatform()).header("token", urmProperties.getToken())
				.params(params);
		LOGGER.info(requestBuilder.toString());
		
		return sendRequest(requestBuilder.build());
	}
	
	private String buildTraceId(String param) {
		return urmProperties.getPlatform() + "-" + param + "-" + System.currentTimeMillis() + "" + UcmpUtils.generateRandomNumber(5);
	}

	public String urmUserUid(String mobile) throws Exception {
		String traceId = buildTraceId(UrmEnum.accountGetTokenByAccount.name());
		String url=urmProperties.getUri() + UrmEnum.accountGetTokenByAccount.url+"?traceId="+traceId+"&requestId="+traceId
				+"&activity=accountGetTokenByAccount&type=1&account="+mobile;
		LOGGER.info("===ak==="+urmProperties.getKey()+"===SK="+urmProperties.getSecret());
		LOGGER.info("===url==="+url);
		RequestBuilder requestBuilder = RequestBuilder.getInstance().key(urmProperties.getKey()).secret(urmProperties.getSecret())
				.mediaType(MediaType.APPLICATION_JSON).method("GET").url(url).
				header("platformId", urmProperties.getPlatform()).header("token", urmProperties.getToken());
		LOGGER.info(requestBuilder.toString());
		
		return sendRequest(requestBuilder.build());
	}

	public String urmGrantPoints(int pointsValue, String superId) throws Exception {
		Map<String, Object> params = new HashMap<>();
		String traceId = buildTraceId(UrmEnum.PointsTaskGrantInterface.name());
		params.put("traceId", traceId);
		params.put("platform", urmProperties.getPlatform());
		params.put("code", urmProperties.getCode());
		params.put("pointsValue", pointsValue);
		params.put("superId", superId);
		LOGGER.info("===ak==="+urmProperties.getKey()+"===SK="+urmProperties.getSecret());
		RequestBuilder requestBuilder = RequestBuilder.getInstance().key(urmProperties.getKey()).secret(urmProperties.getSecret())
				.mediaType(MediaType.APPLICATION_JSON).method("POST")
				.url(urmProperties.getUri() + UrmEnum.PointsTaskGrantInterface.url)
				.header("platformId", urmProperties.getPlatform()).header("token", urmProperties.getToken())
				.params(params);
		LOGGER.info(requestBuilder.toString());
		
		return sendRequest(requestBuilder.build());
	}
}
