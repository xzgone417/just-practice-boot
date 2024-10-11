package com.exp.ucmp.user.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.exp.ucmp.config.UcmpAesConfig;
import com.exp.ucmp.constant.Constants;
import com.exp.ucmp.util.AesUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.csp.sentinel.util.StringUtil;
import com.egrid.core.copiers.Copiers;
import com.egrid.core.shiro.context.AuthContext;
import com.egrid.core.util.JsonBeanUtil;
import com.egrid.core.util.Md5Util;
import com.exp.ucmp.apig.eos.consumer.EosConsumer;
import com.exp.ucmp.dao.IPsiCreateOrderAccountInfoDao;
import com.exp.ucmp.entity.PsiCreateOrderAccountInfoEntity;
import com.exp.ucmp.eos.dto.AccountInfoDto;
import com.exp.ucmp.eos.dto.EosReturnDto;
import com.exp.ucmp.model.Person;
import com.exp.ucmp.user.service.EosUserService;

@Service
public class EosUserServiceImpl implements EosUserService{
	
	/**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(EosUserServiceImpl.class);

	@Autowired
    private EosConsumer eosConsumer;
	
	@Autowired
	private IPsiCreateOrderAccountInfoDao iPsiCreateOrderAccountInfoDao;

	@Autowired
	private UcmpAesConfig ucmpAesConfig;

	@Override
	public AccountInfoDto getUserAndSuperiorInfo(String token,String idmAccountName, int isCreate) throws Exception {
		String result=this.eosConsumer.getUserAndSuperiorInfo(token,idmAccountName);
		LOGGER.info("=========result="+result);
		Map<String,Object> retrunMap=JsonBeanUtil.jsonToBean(result, HashMap.class);
		try{
			AccountInfoDto dto=JsonBeanUtil.jsonToBean(JsonBeanUtil.beanToJson(retrunMap.get("data")), AccountInfoDto.class);
			dto.setUserIdMd5(Md5Util.getMD5String(dto.getIdmAccountName()));
			if(Constants.CodeEnum.eosCode.value().equals(retrunMap.get("code").toString())){
				PsiCreateOrderAccountInfoEntity entity=Copiers.beanToBean(dto,AccountInfoDto.class,PsiCreateOrderAccountInfoEntity.class);
				//客户手机号加密存储
				entity.setPhoneNumber(AesUtils.encryptHex(entity.getPhoneNumber(), ucmpAesConfig.getSecret()));
				//上级手机号加密存储
				if(StringUtil.isNotEmpty(entity.getSuperiorPhoneNumber())){
					entity.setSuperiorPhoneNumber(AesUtils.encryptHex(entity.getSuperiorPhoneNumber(), ucmpAesConfig.getSecret()));
					dto.setSuperiorPhoneNumber(UcmpAesConfig.dataMask(dto.getSuperiorPhoneNumber(), 3, 7, "****"));
					dto.setEnSuperiorPhoneNumber(entity.getSuperiorPhoneNumber());
				}else{
					entity.setSuperiorPhoneNumber("");
				}
				Long partyId=AuthContext.getInstance(Person.class).getCurrentUser().getPartyId();
				entity.setCreatedBy(partyId);
				entity.setUpdatedBy(partyId);
				entity.generatePk();
				LOGGER.info("=========创建预约单页面把顾问相关信息保存进表，返回顾问信息id="+JsonBeanUtil.beanToJson(entity));
				if(isCreate==1){
					//创建预约单页面把顾问相关信息保存进表，返回顾问信息id
					this.iPsiCreateOrderAccountInfoDao.insert(entity);
				}
				//脱敏
				dto.setPhoneNumber(UcmpAesConfig.dataMask(dto.getPhoneNumber(), 3, 7, "****"));
				//返回加密手机号
				dto.setEnPhoneNumber(entity.getPhoneNumber());
				dto.setCreateAccountInfoId(entity.getInfoId());
				return dto;
			}else{
				throw new Exception(retrunMap.get("msg").toString());
			}
		}catch(Exception e){
			Map<String,String> dataMap = JsonBeanUtil.jsonToBean(JsonBeanUtil.beanToJson(retrunMap.get("data")), HashMap.class);
			throw new Exception(dataMap.get("msg"));
		}
	}
	
	public static void main(String[] args) throws Exception {
		/*String result="{\"code\":\"200\",\"data\":{\"departmentId\":\"5622320210223614073\",\"idmAccountName\":\"apptest03\",\"organizationId\":809084,\"phoneNumber\":\"17717255502\",\"roleCode\":\"RE010\",\"roleName\":\"出行顾问\",\"superiorIdmAccountName\":\"AlanGu\",\"superiorName\":\"顾旭阳\",\"superiorOrganizationId\":809094,\"superiorPhoneNumber\":\"13162329981\",\"superiorRoleCode\":\"RE006\",\"superiorRoleName\":\"出行主管\",\"superiorUserId\":5198,\"userId\":6255,\"userName\":\"刘毓\"},\"msg\":\"SUCCESS\"}";
		LOGGER.info("=========result="+result);
		Map<String,Object> retrunMap=JsonBeanUtil.jsonToBean(result, HashMap.class);
		AccountInfoDto dto=JsonBeanUtil.jsonToBean(JsonBeanUtil.beanToJson(retrunMap.get("data")), AccountInfoDto.class);
		dto.setUserIdMd5(Md5Util.getMD5String(dto.getIdmAccountName().toString()));
		if("200".equals(retrunMap.get("code").toString())){
			PsiCreateOrderAccountInfoEntity entity=Copiers.beanToBean(dto,AccountInfoDto.class,PsiCreateOrderAccountInfoEntity.class);
				Long partyId=AuthContext.getInstance(Person.class).getCurrentUser().getPartyId();
				entity.setCreatedBy(partyId);
				entity.setUpdatedBy(partyId);
				entity.generatePk();
				//创建预约单页面把顾问相关信息保存进表，返回顾问信息id
				dto.setCreateAccountInfoId(entity.getInfoId());
			LOGGER.info("===dto=="+JsonBeanUtil.beanToJson(dto));
			LOGGER.info("===entity=="+JsonBeanUtil.beanToJson(entity));
		}
		*/
		LOGGER.info("SSS="+AesUtils.decryptHex("8A67044B04B7C6EA3EB4656A934E5803", "Hn9AQTUAYuMFNbUw"));
		
		String u= Md5Util.getMD5String("PhoebeWang");
		LOGGER.info("UUU="+u);
	}
	
	@Override
	public List<AccountInfoDto> allUsersInTheDepartment(String departmentCode) throws Exception {
		String result = eosConsumer.allUsersInTheDepartment(departmentCode);
		LOGGER.info("=========result="+result);
		try{
			EosReturnDto<List<AccountInfoDto>> retrunDto=JsonBeanUtil.jsonToBean(result, EosReturnDto.class);
			if("200".equals(retrunDto.getCode())){
				return retrunDto.getData();
			}else{
				throw new Exception("eos系统响应报错");
			}
		}catch (Exception e) {
			Map<String,Object> retrunMap=JsonBeanUtil.jsonToBean(result, HashMap.class);
			Map<String,String> dataMap = JsonBeanUtil.jsonToBean(JsonBeanUtil.beanToJson(retrunMap.get("data")), HashMap.class);
			throw new Exception(dataMap.get("msg"));
		}
	}

}
