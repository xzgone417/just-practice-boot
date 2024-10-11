package com.exp.ucmp.user.service.impl;


import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.csp.sentinel.util.StringUtil;
import com.egrid.core.util.JsonBeanUtil;
import com.exp.ucmp.apig.urm.consumer.UrmConsumer;
import com.exp.ucmp.config.UcmpAesConfig;
import com.exp.ucmp.urm.dto.UrmDataDto;
import com.exp.ucmp.urm.dto.UrmReturnDto;
import com.exp.ucmp.urm.dto.UrmRteurnDto;
import com.exp.ucmp.urm.dto.UserDto;
import com.exp.ucmp.user.service.UrmUserService;
import com.exp.ucmp.util.AesUtils;

@Service
public class UrmUserServiceImpl implements UrmUserService{
	
	/**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(UrmUserServiceImpl.class);

	@Autowired
    private UrmConsumer urmConsumer;
	
	@Autowired
    private UcmpAesConfig ucmpAesConfig;
	
	@Override
	public UserDto userProfilesQuery(String superIds) throws Exception {
		String result = this.urmConsumer.userProfilesQuery(superIds);
		LOGGER.info("===userProfilesQuery=result==="+result);
		if(StringUtil.isNotEmpty(result)){
			UrmRteurnDto returnDto=JsonBeanUtil.jsonToBean(result, UrmRteurnDto.class);
			if(returnDto.isSuccess() && !returnDto.getData().getDataList().isEmpty()){
				UserDto dto=returnDto.getData().getDataList().get(0);
				if(StringUtil.isEmpty(dto.getName())){
					dto.setName("");
				}
				dto.setIdmId(dto.getIdm_Id());
				LOGGER.info("====="+ucmpAesConfig.getSecret());
				dto.setEnMobile(AesUtils.encryptHex(dto.getMobile(), ucmpAesConfig.getSecret()));
				dto.setMobile(UcmpAesConfig.dataMask(dto.getMobile(), 3, 7, "****"));
				LOGGER.info("===dto=="+JsonBeanUtil.beanToJson(dto));
				return dto;
			}else{
				return null;
			}
		}else{
			throw new Exception("调用URM接口异常");
		}
	}

	public static void main(String[] args) {
		String result="{\"traceId\":\"TD770693019056738304-userProfilesQuery-167764532387276998\",\"respTime\":\"2023-03-01 12:35:23\",\"success\":true,\"stateCode\":1,\"data\":{\"total\":1,\"dataList\":[{\"name\":\"测试\",\"superId\":\"PB760179427538636800\",\"mobile\":\"17621565351\"}]},\"stateDesc\":null,\"stateDetail\":null,\"inner\":null}";
		UrmRteurnDto returnDto=JsonBeanUtil.jsonToBean(result, UrmRteurnDto.class);
		LOGGER.info("===returnDto==="+JsonBeanUtil.beanToJson(returnDto));
	}

	@Override
	public String urmUserUid(String mobile) throws Exception {
		String result = this.urmConsumer.urmUserUid(mobile);
		LOGGER.info("===urmUserUid=result==="+result);
		if(StringUtil.isNotEmpty(result)){
			UrmReturnDto returnDto=JsonBeanUtil.jsonToBean(result, UrmReturnDto.class);
			if(returnDto.isSuccess() && returnDto.getData()!= null){
				return returnDto.getData().get("super_id");
			}else{
				throw new Exception(returnDto.getStateDesc());
			}
		}else{
			throw new Exception("调用URM接口异常");
		}
	}

	@Override
	public String urmGrantPoints(int pointsValue, String superId) throws Exception {
		return urmConsumer.urmGrantPoints(pointsValue,superId);
	}
}
