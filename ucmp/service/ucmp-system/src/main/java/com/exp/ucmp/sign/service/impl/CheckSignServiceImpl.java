package com.exp.ucmp.sign.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.nacos.api.utils.StringUtils;
import com.egrid.core.util.JsonBeanUtil;
import com.exp.ucmp.sign.properties.UcmpSecretProperties;
import com.exp.ucmp.sign.service.CheckSignService;
import com.exp.ucmp.util.SignUtils;

@Service
public class CheckSignServiceImpl implements CheckSignService{
	
	/**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(CheckSignService.class);

	@Autowired
	private UcmpSecretProperties ucmpSecretProperties;

	@Override
	public String checkSign(Map<String, Object> params) {
		//第三方的签名
		String sign=null;
		//第三方渠道码
		String channel=null;
		//第三方时间戳
		String timestamp=null;
		
		String result="1";
		
		Set<String> keySet = params.keySet();
		List<String> paramNames = new ArrayList<>(keySet);
		Collections.sort(paramNames);
		StringBuilder paramNameValue = new StringBuilder();
		for (String paramName : paramNames) {
			if("channel".equals(paramName)){
				channel=params.get(paramName).toString();
			}else if("timestamp".equals(paramName)){
				timestamp=params.get(paramName).toString();
			}else if("sign".equals(paramName)){
				sign=params.get(paramName).toString();
			}else{
				paramNameValue.append(paramName).append(params.get(paramName));
			}
		}
		
		if(StringUtils.isEmpty(sign)){
			result="-1";
			return result;
		}
		
		if(StringUtils.isEmpty(channel)){
			result="-2";
			return result;
		}
		
		if(StringUtils.isEmpty(timestamp)){
			result="-3";
			return result;
		}
		String secret= ucmpSecretProperties.getAppsecret();
		Map<String,String> secretMap=JsonBeanUtil.jsonToBean(secret, HashMap.class);
		String source= secretMap.get(channel) + channel + timestamp + paramNameValue.toString() + secretMap.get(channel);
		LOGGER.info("==待签名字符串==="+source);
		LOGGER.info("====签名传入参数params===="+JsonBeanUtil.beanToJson(params));
		String ucmpSign = SignUtils.encryptUpper(source);
		LOGGER.info("=====ucmpSign====="+ucmpSign);
		if(!ucmpSign.equals(sign)){
			result="-4";
		}
		return result;
	}
	
	

}
