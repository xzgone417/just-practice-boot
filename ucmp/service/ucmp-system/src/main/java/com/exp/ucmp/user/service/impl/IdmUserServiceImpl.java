package com.exp.ucmp.user.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.csp.sentinel.util.StringUtil;
import com.egrid.core.util.JsonBeanUtil;
import com.exp.ucmp.apig.idm.consumer.IdmConsumer;
import com.exp.ucmp.idm.dto.IdmAccountStatusDto;
import com.exp.ucmp.idm.dto.IdmUserDto;
import com.exp.ucmp.idm.dto.IdmUserStatusDto;
import com.exp.ucmp.user.service.IdmUserService;

@Service
public class IdmUserServiceImpl implements IdmUserService{
	
	/**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(IdmUserServiceImpl.class);
    
    @Autowired
	private IdmConsumer idmConsumer;
    
    protected enum IdmEnum { 
    	// ESB获取EMDM数据接口
    	successStatus("success"),
    	successStatus2("true"),
    	failStatus("fail");

        private String value;

        private IdmEnum(String value) {
            this.value = value;
        }
        public String value() {
            return this.value;
		}
	}

	@Override
	public String createUser(IdmUserDto idmUserDto) throws Exception {
		String result=this.idmConsumer.createUser(idmUserDto);
		LOGGER.info("=idm=createUser="+result);
		if(StringUtil.isNotEmpty(result)){
			Map<String,String> resultMap=JsonBeanUtil.jsonToBean(result, HashMap.class);
			String status=resultMap.get("result");
			if(IdmEnum.successStatus.value.equals(status)||IdmEnum.successStatus2.value.equals(status)){
				return idmUserDto.getUid();
			}else{
				throw new Exception(resultMap.get("Message"));
			}
		}else{
			throw new Exception("创建idm用户异常");
		}
	}

	@Override
	public String updateUser(IdmUserDto idmUserDto) throws Exception {
		String result=this.idmConsumer.updateUser(idmUserDto);
		LOGGER.info("=idm=updateUser="+result);
		if(StringUtil.isNotEmpty(result)){
			Map<String,String> resultMap=JsonBeanUtil.jsonToBean(result, HashMap.class);
			String status=resultMap.get("result");
			if(IdmEnum.successStatus.value.equals(status)||IdmEnum.successStatus2.value.equals(status)){
				return idmUserDto.getUid();
			}else{
				throw new Exception(resultMap.get("Message"));
			}
		}else{
			throw new Exception("更新idm用户异常");
		}
	}

	@Override
	public String updateUserStatus(IdmUserStatusDto idmUserStatusDto) throws Exception {
		String result=this.idmConsumer.updateUserStatus(idmUserStatusDto);
		LOGGER.info("=idm=updateUserStatus="+result);
		if(StringUtil.isNotEmpty(result)){
			Map<String,String> resultMap=JsonBeanUtil.jsonToBean(result, HashMap.class);
			String status=resultMap.get("result");
			if(IdmEnum.successStatus.value.equals(status)||IdmEnum.successStatus2.value.equals(status)){
				return idmUserStatusDto.getUid();
			}else{
				throw new Exception(resultMap.get("Message"));
			}
		}else{
			throw new Exception("更新idm用户状态异常");
		}
	}

	@Override
	public String updateAccountStatus(IdmAccountStatusDto idmAccountStatusDto) throws Exception {
		String result=this.idmConsumer.updateAccountStatus(idmAccountStatusDto);
		LOGGER.info("=idm=updateAccountStatus="+result);
		if(StringUtil.isNotEmpty(result)){
			Map<String,String> resultMap=JsonBeanUtil.jsonToBean(result, HashMap.class);
			String status=resultMap.get("result");
			if(IdmEnum.successStatus.value.equals(status)||IdmEnum.successStatus2.value.equals(status)){
				return idmAccountStatusDto.getAccountNo();
			}else{
				throw new Exception(resultMap.get("Message"));
			}
		}else{
			throw new Exception("更新idm账号状态异常");
		}
	}

}
