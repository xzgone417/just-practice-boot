package com.exp.ucmp.idm.service.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.egrid.cache.jedis.cache.RedisCache;
import com.alibaba.csp.sentinel.util.StringUtil;
import com.egrid.core.util.JsonBeanUtil;
import com.egrid.core.util.Md5Util;
import com.exp.ucmp.auth.dto.IdmUserDto;
import com.exp.ucmp.idm.consumer.IdmConsumer;
import com.exp.ucmp.idm.service.IdmOauthService;

@Service
public class IdmOauthServiceImpl implements IdmOauthService{
	
	/**
	 * <p>
	 * Field LOGGER: log
	 * </p>
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(IdmOauthServiceImpl.class);

	@Autowired
	private IdmConsumer idmConsumer;
	
	@Autowired
    private RedisCache redissonCache;
	
	@Override
	public String buildIdmUrl() throws Exception {
		return idmConsumer.buildIdmUrl();
	}

	@Override
	public void callback(HttpServletResponse response, HttpServletRequest request, String code, String target_uri,
			String access_token) throws IOException {
		LOGGER.info("====code:"+code);
    	LOGGER.info("====target_uri:"+target_uri);
    	LOGGER.info("====access_token:"+access_token);
		String url=null;
		if(StringUtil.isNotEmpty(target_uri)){
			// 添加参数
			url = target_uri + (target_uri.indexOf('?')>=0 ? "&" : "?") + "code=" + code;
			LOGGER.info("目标页面url --> " + url);
			request.getSession().setAttribute("target_uri", target_uri);
		}
		if(StringUtil.isNotEmpty(access_token)){
			request.getSession().setAttribute("access_token", access_token);
		}
		response.sendRedirect(url);
	}

	@Override
	public String getToken(String code) throws Exception {
		return this.idmConsumer.getAccessTokenParam(code);
	}

	@Override
	public String getTokenInfo(String code) throws Exception {
		return this.idmConsumer.getTokenInfo(code);
		
	}

	@Override
	public IdmUserDto getUserInfo(String accessToken) {
		String result;
		try {
			result = this.idmConsumer.getUserInfo(accessToken);
			LOGGER.info("=======IDM返回的用户信息=="+result);
			IdmUserDto dto=JsonBeanUtil.jsonToBean(result, IdmUserDto.class);
			dto.setMd5Id(Md5Util.getMD5String(dto.getId()));
			return dto;
		} catch (Exception e) {
			LOGGER.error("==获取idm的user信息报错===",e);
		}
		return null;
	}

	@Override
	public Map<String, String> sendSecurityCodeDto(String mobile) throws Exception {
        String result = this.idmConsumer.sendSecurityCodeDto(mobile);
		LOGGER.info("commonDto:"+result);
		if(StringUtil.isNotEmpty(result)){
			return JsonBeanUtil.jsonToBean(result, HashMap.class);
		}else{
			throw new Exception("短信验证码发送异常");
		}
	}

	@Override
	public Map<String, Object> getAccessTokenBySMS(String uid, String pwd) throws Exception{
		//获取等手机号是否被限制 1被限制
		String loginBlackKey = new StringBuilder().append("loginBlack").append(":").append(uid).toString();
		Integer loginBlack = (Integer) redissonCache.get(loginBlackKey);
		LOGGER.info("=====loginBlack====="+loginBlack);
		if(loginBlack !=null && loginBlack==1){
			throw new Exception("超过登录次数，请稍后再试");
		}
		//获取登陆手机号的登录次数
		String loginTimesKey = new StringBuilder().append("loginTimes").append(":").append(uid).toString();
		Long loginTimes = redissonCache.incrBy(loginTimesKey, 1L);
		LOGGER.info("=====loginTimes====="+loginTimes+",ss="+redissonCache.getExpireSeconds());
		if(loginTimes == 1){
			redissonCache.expire(loginTimesKey, TimeUnit.MINUTES, 1L);
		}else if(loginTimes==10){
			redissonCache.put(loginBlackKey,1);
			redissonCache.expire(loginBlackKey, TimeUnit.MINUTES, 5L);
			throw new Exception("超过登录次数，请稍后再试");
		}
		String result=this.idmConsumer.getAccessTokenBySMS(uid,pwd);
		LOGGER.info("=====短信验证码获取idm的token====="+result);
		if(StringUtil.isNotEmpty(result)){
			return JsonBeanUtil.jsonToBean(result, HashMap.class);
		}else{
			throw new Exception("短信验证码获取idm的token异常");
		}
	}
	
	public static void main(String[] args) {
		String result="{\"code\":\"E2000100\",\"msg\":\"SUCCESS\",\"data\":{\"access_token\":\"PAT-mrqEhz6p-cbd309a23cf60b9e64fd40144a4ae3e01a37ffaca6c9772844b28d0a8674d471\",\"refresh_token\":\"PRT-t6d11GyC-70b60cb74657dfafc6260a323ad4e6d1c8fde1be79cbbbbe35cb3382960fb260-591dd2b8b9a10f04f08e024b3339381a\",\"expire\":\"7200\"}}";
		Map<String,Object> map=JsonBeanUtil.jsonToBean(result, HashMap.class);
		Map<String,String> tokenMap=(Map<String, String>) map.get("data");
		LOGGER.info("=======map="+tokenMap);
		LOGGER.info("=======tokenMap="+tokenMap.get("access_token"));
	}

	@Override
	public Map<String, String> getTokenByPwd(String uid, String pwd) throws Exception {
		String result = this.idmConsumer.getTokenByPwd(uid,pwd);
		if(StringUtil.isNotEmpty(result)){
			return JsonBeanUtil.jsonToBean(result, HashMap.class);
		}else{
			throw new Exception("短信验证码获取idm的token异常");
		}
	}

}
