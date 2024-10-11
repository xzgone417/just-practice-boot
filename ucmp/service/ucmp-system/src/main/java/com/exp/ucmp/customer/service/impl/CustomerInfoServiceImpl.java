package com.exp.ucmp.customer.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.csp.sentinel.util.StringUtil;
import com.egrid.core.util.JsonBeanUtil;
import com.exp.ucmp.apig.urm.consumer.UrmConsumer;
import com.exp.ucmp.customer.service.CustomerInfoService;
import com.exp.ucmp.urm.dto.UserDto;

@Service
public class CustomerInfoServiceImpl implements CustomerInfoService{
	
	/**
	 * <p>
	 * Field LOGGER: log
	 * </p>
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerInfoServiceImpl.class);
	
	@Autowired
	private UrmConsumer urmConsumer;
	
	@Override
	public UserDto getUserInfo(String superIds) throws Exception {
		String result = urmConsumer.userProfilesQuery(superIds);
		UserDto dto=new UserDto();
		if(StringUtil.isNotEmpty(result)){
			Map<String,Object> map=JsonBeanUtil.jsonToBean(result, HashMap.class);
			LOGGER.info("==map="+JsonBeanUtil.beanToJson(map) );
			Map<String,Object> dataMap=(Map<String, Object>) map.get("data");
			List<Map<String,String>> list=(List<Map<String, String>>) dataMap.get("dataList");
			LOGGER.info("==list="+list);
			dto.setIdmId(list.get(0).get("idm_Id"));
			dto.setMobile(list.get(0).get("mobile"));
			dto.setSuperId(list.get(0).get("superId"));
			dto.setName(list.get(0).get("name"));
		}
		LOGGER.info("===dto=="+JsonBeanUtil.beanToJson(dto));
		return dto;
	}
	
	public static void main(String[] args) {
		String result="{\"traceId\":\"TD770693019056738304-userProfilesQuery-166444461837313747\",\"respTime\":\"2022-09-29 17:43:38\",\"success\":true,\"stateCode\":1,\"data\":{\"total\":1,\"dataList\":[{\"name\":\"33333333\",\"idm_Id\":\"-R5AjMRBT5iKEVDskpukQw\",\"superId\":\"PA429284072688517120\"}]},\"stateDesc\":null,\"stateDetail\":null,\"inner\":null}";
		UserDto dto=new UserDto();
		Map<String,Object> map=JsonBeanUtil.jsonToBean(result, HashMap.class);
		LOGGER.info("==map="+JsonBeanUtil.beanToJson(map) );
		Map<String,Object> dataMap=(Map<String, Object>) map.get("data");
		List<Map<String,String>> list=(List<Map<String, String>>) dataMap.get("dataList");
		LOGGER.info("==list="+list);
		dto.setIdmId(list.get(0).get("idm_Id"));
		dto.setMobile(list.get(0).get("mobile"));
		dto.setSuperId(list.get(0).get("superId"));
		dto.setName(list.get(0).get("name"));
		LOGGER.info("===dto=="+JsonBeanUtil.beanToJson(dto));
	}

	@Override
	public UserDto getUserInfoByInquiryId(String inquiryId) {
		
		return null;
	}
}
