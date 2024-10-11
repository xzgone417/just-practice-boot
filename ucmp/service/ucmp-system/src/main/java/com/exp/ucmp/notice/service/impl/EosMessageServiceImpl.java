package com.exp.ucmp.notice.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.alibaba.csp.sentinel.util.StringUtil;
import com.alibaba.fastjson.JSONObject;
import com.egrid.core.copiers.Copiers;
import com.egrid.core.shiro.context.AuthContext;
import com.egrid.core.util.Md5Util;
import com.exp.ucmp.config.UcmpAesConfig;
import com.exp.ucmp.constant.Constants;
import com.exp.ucmp.dao.IPsiCreateOrderAccountInfoDao;
import com.exp.ucmp.entity.PsiCreateOrderAccountInfoEntity;
import com.exp.ucmp.eos.dto.*;
import com.exp.ucmp.model.Person;
import com.exp.ucmp.util.AesUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egrid.core.util.JsonBeanUtil;
import com.exp.ucmp.apig.eos.consumer.EosConsumer;
import com.exp.ucmp.apig.smp.consumer.SmpConsumer;
import com.exp.ucmp.notice.service.EosMessageService;
import org.springframework.util.ObjectUtils;

@Service
public class EosMessageServiceImpl implements EosMessageService {

    /**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(EosMessageServiceImpl.class);

    @Autowired
    private EosConsumer eosConsumer;
    
    @Autowired
    private SmpConsumer smpConsumer;

    @Autowired
    private UcmpAesConfig ucmpAesConfig;
    @Autowired
    private IPsiCreateOrderAccountInfoDao iPsiCreateOrderAccountInfoDao;

    @Override
    public EosReturnDto<String> sendMessage(@Valid MessageParamDto messageParamDto) throws Exception {
        //预留方法，根据模板id判断是否需要发送消息
        Integer isSend = this.checkMessageStatus(messageParamDto.getTemplateId());
        if (isSend == 1) {
            String result = eosConsumer.sendMessage(messageParamDto);
            LOGGER.info("=========result=" + result);
            Map<String, Object> retrunDto = JsonBeanUtil.jsonToBean(result, HashMap.class);
            if ("200".equals(retrunDto.get("code"))) {
                EosReturnDto<String> dto = JsonBeanUtil.jsonToBean(JsonBeanUtil.beanToJson(retrunDto.get("data")), EosReturnDto.class);
                return dto;
            } else {
                throw new Exception("eos系统响应报错");
            }
        }
        return null;
    }

    @Override
    public EosReturnDto<String> giveMessage(@Valid GiveMessageParamDto messageParamDto) throws Exception {
        //预留方法，根据模板id判断是否需要发送消息
        Integer isSend = this.checkMessageStatus(messageParamDto.getTemplateId());
        LOGGER.info("=========推送企信公共接口isSend=" + isSend);
        if (isSend == 1) {
            String result = eosConsumer.giveMessage(messageParamDto);
            LOGGER.info("=========推送企信公共接口结果返回=" + result);
            JSONObject reqObject = JSONObject.parseObject(result);
            if ("000000".equals(reqObject.get("code"))) {
                EosReturnDto<String> dto = null;
                if (!ObjectUtils.isEmpty(reqObject.get("data"))) {
                    dto = JsonBeanUtil.jsonToBean(JsonBeanUtil.beanToJson(reqObject.get("data")), EosReturnDto.class);
                }
                return dto;
            } else {
                throw new Exception(reqObject.get("msg").toString());
            }
        }
        return null;
    }

    @Override
    public UserAndSuperiorInfoDto getUserAndHigherLevel(String userId, int isCreate,String token) throws Exception {
    	String result;
    	if(StringUtil.isNotEmpty(userId)){
    		result = eosConsumer.getUserAndHigherLevel(userId);
    	}else{
    		result = smpConsumer.getUserAndSuperiorInfo(token);
    	}
    	LOGGER.info("=========获取到的顾问信息1=" + result);
    	JSONObject retrunMap = JSONObject.parseObject(result);
		if (retrunMap.get("code").equals(Constants.CodeEnum.slfCode.value()) ||retrunMap.get("code").equals(Constants.CodeEnum.smpCode.value())) {
			LOGGER.info("=========获取到的顾问信息2=" + result);
			UserAndSuperiorInfoDto dto = JsonBeanUtil.jsonToBean(JsonBeanUtil.beanToJson(retrunMap.get("data")), UserAndSuperiorInfoDto.class);
			dto.setUserIdMd5(Md5Util.getMD5String(dto.getIdmAccountName()));
			
			PsiCreateOrderAccountInfoEntity entity = Copiers.beanToBean(dto, UserAndSuperiorInfoDto.class, PsiCreateOrderAccountInfoEntity.class);
			//客户手机号加密存储
			entity.setPhoneNumber(AesUtils.encryptHex(entity.getPhoneNumber(), ucmpAesConfig.getSecret()));
			//上级手机号加密存储
			if (StringUtil.isNotEmpty(entity.getSuperiorPhoneNumber())) {
				entity.setSuperiorPhoneNumber(AesUtils.encryptHex(entity.getSuperiorPhoneNumber(), ucmpAesConfig.getSecret()));
				dto.setSuperiorPhoneNumber(UcmpAesConfig.dataMask(dto.getSuperiorPhoneNumber(), 3, 7, "****"));
				dto.setEnSuperiorPhoneNumber(entity.getSuperiorPhoneNumber());
			} else {
				entity.setSuperiorPhoneNumber("");
			}
			Long partyId = AuthContext.getInstance(Person.class).getCurrentUser().getPartyId();
			entity.setCreatedBy(partyId);
			entity.setUpdatedBy(partyId);
			entity.generatePk();
			entity.setUserId(Long.parseLong(dto.getUserId()));
			LOGGER.info("=========创建预约单页面把顾问相关信息保存进表，返回顾问信息id=" + JsonBeanUtil.beanToJson(entity));
			if (isCreate == 1) {
				//创建预约单页面把顾问相关信息保存进表，返回顾问信息id
				this.iPsiCreateOrderAccountInfoDao.insert(entity);
			}
			/*if(dto.getRoleCode().equals(Constants.slfRole.SH.value())){
				dto.setRoleCode(Constants.slfRole.ME.value());
			}else if(dto.getRoleCode().equals(Constants.slfRole.MO.value())){
				dto.setRoleCode(Constants.slfRole.PMO.value());
			}*/
			//脱敏
			dto.setPhoneNumber(UcmpAesConfig.dataMask(dto.getPhoneNumber(), 3, 7, "****"));
			//返回加密手机号
			dto.setEnPhoneNumber(entity.getPhoneNumber());
			dto.setCreateAccountInfoId(entity.getInfoId());
			return dto;
		} else {
			if(retrunMap.get("msg").toString().contains("非法TOKEN")){
				throw new Exception("TOEKN过期或者无效,请重新登录");
			}else{
				throw new Exception(retrunMap.get("msg").toString());
			}
		}
    }


    private Integer checkMessageStatus(String templateId) {
        return 1;
    }

    public static void main(String[] args) {
        /*String result = "{\"code\":\"200\",\"data\":{\"code\":\"200\",\"data\":\"发送成功\",\"msg \":\"SUCCESS \"},\"msg \":\"SUCCESS \"}";
        LOGGER.info("=========result=" + result);
        Map<String, Object> retrunDto = JsonBeanUtil.jsonToBean(result, HashMap.class);
        EosReturnDto<String> dto = JsonBeanUtil.jsonToBean(JsonBeanUtil.beanToJson(retrunDto.get("data")), EosReturnDto.class);
        LOGGER.info("==dto==" + dto);*/
    	String userId="ChenlongYan";
    	LOGGER.info("========="+Md5Util.getMD5String(userId));
    }

}
