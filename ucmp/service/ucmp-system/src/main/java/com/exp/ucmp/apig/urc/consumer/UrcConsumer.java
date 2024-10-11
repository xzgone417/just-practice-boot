package com.exp.ucmp.apig.urc.consumer;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import com.alibaba.csp.sentinel.util.StringUtil;
import com.egrid.core.util.JsonBeanUtil;
import com.exp.ucmp.apig.AbstractConsumer;
import com.exp.ucmp.urc.dto.RightPackSaveDto;
import com.exp.ucmp.urc.dto.RightsGrantDto;

@Component
public class UrcConsumer extends AbstractConsumer {
	/**
	 * <p>
	 * Field LOGGER: log
	 * </p>
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(UrcConsumer.class);

	@Autowired
	private UrcProperties urcProperties;

	protected enum UrcEnum { 
		// URC接口
		rightQueryByCondition("/v2/right/rightQueryByCondition"), 
		rightPackSave("/v2/right/rightPackSave"),
		rightsGrant("/v2/right/rightsGrant");

		private String url;

		private UrcEnum(String value) {
			this.url = value;
		}

		public String url() {
			return this.url;
		}
	}

	/**
	 * 权益主数据列表查询
	 * 
	 * @param rightTypeName 权益类型名称 权益类型(服务内容)名称。支持模糊查询
	 * @param grantType 发放类型 文本类00、电度类01、卡券类02、积分类03、流量类04
	 * @return
	 * @throws Exception
	 */
	public String rightQueryByCondition(String rightTypeName,String grantType) throws Exception {
		String url= urcProperties.getUri()+UrcEnum.rightQueryByCondition.url +"?code=1";
		if(StringUtil.isNotEmpty(rightTypeName)){
			url+=("&rightTypeName="+rightTypeName);
		}
		if(StringUtil.isNotEmpty(grantType)){
			url+=("&grantType="+grantType);
		}
		RequestBuilder requestBuilder = RequestBuilder.getInstance().key(urcProperties.getKey())
				.secret(urcProperties.getSecret()).mediaType(MediaType.APPLICATION_JSON).method("GET").url(url);
		LOGGER.info(requestBuilder.toString());
		return sendRequest(requestBuilder.build());
	}
	
	/**
	 * 权益包创建
	 * 
	 * @param rightPackSaveDto
	 * @return
	 * @throws Exception
	 */
	public String rightPackSave(RightPackSaveDto rightPackSaveDto) throws Exception {
		String dtoStr = JsonBeanUtil.beanToJson(rightPackSaveDto);
		Map<String, Object> paramMap = JsonBeanUtil.jsonToBean(dtoStr, HashMap.class);
		RequestBuilder requestBuilder = RequestBuilder.getInstance().key(urcProperties.getKey())
				.secret(urcProperties.getSecret())
				.mediaType(MediaType.APPLICATION_JSON).method("POST").url(urcProperties.getUri() + UrcEnum.rightPackSave.url)
				.params(paramMap);
		LOGGER.info(requestBuilder.toString());
		return sendRequest(requestBuilder.build());
	}

	/**
	 * 权益发放
	 * 
	 * @param rightsGrantDto
	 * @return
	 * @throws Exception
	 */
	public String rightsGrant(RightsGrantDto rightsGrantDto) throws Exception {
		rightsGrantDto.setChannel(urcProperties.getChannle());
		String dtoStr = JsonBeanUtil.beanToJson(rightsGrantDto);
		Map<String, Object> paramMap = JsonBeanUtil.jsonToBean(dtoStr, HashMap.class);
		RequestBuilder requestBuilder = RequestBuilder.getInstance().key(urcProperties.getKey())
				.secret(urcProperties.getSecret())
				.mediaType(MediaType.APPLICATION_JSON).method("POST").url(urcProperties.getUri() + UrcEnum.rightsGrant.url)
				.params(paramMap);
		LOGGER.info(requestBuilder.toString());
		return sendRequest(requestBuilder.build());
	}
	
}
