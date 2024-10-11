package com.exp.ucmp.user.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.csp.sentinel.util.StringUtil;
import com.egrid.core.util.JsonBeanUtil;
import com.exp.ucmp.apig.tsp.consumer.TspConsumer;
import com.exp.ucmp.constant.Constants;
import com.exp.ucmp.tsp.dto.RegAndLoginDto;
import com.exp.ucmp.tsp.dto.TspIdmcReturnDto;
import com.exp.ucmp.user.service.IdmcUserService;

@Service
public class IdmcUserServiceImpl implements IdmcUserService{
	
	/**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(IdmcUserServiceImpl.class);
    
    @Autowired
	private TspConsumer tspConsumer;

	@Override
	public String mobilePhoneRegAndLogin(RegAndLoginDto regAndLoginDto) throws Exception {
		String result = tspConsumer.mobilePhoneRegAndLogin(regAndLoginDto);
		if(StringUtil.isNotEmpty(result)){
			TspIdmcReturnDto returnDto=JsonBeanUtil.jsonToBean(result, TspIdmcReturnDto.class);
			if(returnDto.getCode().equals(Constants.CodeEnum.smpCode.value())){
				return returnDto.getData().getUrmId();
			}
		}
		return null;
	}
    
	public static void main(String[] args) {
		String result="{\"code\":\"000000\",\"data\":{\"isRegister\":1,\"loginId\":\"17612147473\",\"signKey\":\"75765900902383282955440819518677\",\"superId\":\"6l4KGFwIRD-oS4Sx8Tu8KA\",\"token\":\"86389a6a0ffc4cccfae2c7edd13b3a05\",\"tokenExpire\":\"604800\",\"urmId\":\"PB786351036414562304\"},\"msg\":\"SUCCESS\"}";
		TspIdmcReturnDto returnDto=JsonBeanUtil.jsonToBean(result, TspIdmcReturnDto.class);
		if(returnDto.getCode().equals(Constants.CodeEnum.smpCode.value()))
		LOGGER.info("====="+returnDto.getData().getUrmId());
	}
}
