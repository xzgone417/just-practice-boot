package com.exp.ucmp.behavior.repository.db;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.egrid.core.util.JsonBeanUtil;
import com.egrid.core.util.StringUtil;
import com.exp.ucmp.behavior.dao.IBehaviorDao;
import com.exp.ucmp.behavior.dto.MessageDto;
import com.exp.ucmp.behavior.repository.AbstractRepository;
import com.exp.ucmp.dao.ISysUserBehaviorDao;
import com.exp.ucmp.dao.ISysUserBehaviorParamsDao;
import com.exp.ucmp.dao.ISysUserBehaviorResponseDao;
import com.exp.ucmp.entity.SysUserBehaviorEntity;
import com.exp.ucmp.entity.SysUserBehaviorParamsEntity;
import com.exp.ucmp.entity.SysUserBehaviorResponseEntity;

/**
 * 数据库方式存放行为记录数据
 * @author Administrator
 *
 */
@Component
public class DbRepository extends AbstractRepository implements ApplicationRunner {
	private static final Logger LOGGER = LoggerFactory.getLogger(DbRepository.class);
	
	@Autowired
	ISysUserBehaviorDao dao;
	@Autowired
	ISysUserBehaviorParamsDao paramsDao;
	@Autowired
	ISysUserBehaviorResponseDao responseDao;
	@Autowired
	IBehaviorDao behaviorDao;
    
	private boolean flag = true;
	private ExecutorService executor = Executors.newCachedThreadPool();
	
	@SuppressWarnings("rawtypes")
	@Override
	public void run(ApplicationArguments args) throws Exception {
		executor.execute(new Runnable() {
			@Override
			public void run() {
				Runtime.getRuntime().addShutdownHook(new ShutdownCallbackThread());
				while (flag) {
					try {
						Thread.sleep(100 * 1000L);
						Calendar calendar = GregorianCalendar.getInstance();
						calendar.add(Calendar.MINUTE, -10);
						List<Map<String, Object>> listResult = behaviorDao.queryResponseByUrl(-999L, Long.parseLong(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(calendar.getTime())), "api/auth/login");
						listResult.addAll(behaviorDao.queryResponseByUrl(-999L, Long.parseLong(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(calendar.getTime())), "/api/mobile/verify"));
						if (listResult.size() > 0) {
							LOGGER.info("补全登录行为的用户, 补全数为{}", listResult.size());
							List<SysUserBehaviorEntity> listUpdate = new ArrayList<>();
							for (Map<String, Object> res : listResult) {
								if (res.get("response") != null && String.valueOf(res.get("response")).indexOf("\"code\":20000") > 0) {
									Map map = JsonBeanUtil.jsonToBean(String.valueOf(res.get("response")), HashMap.class);
									if (map.get("result") != null && ((Map)map.get("result")).get("user") != null) {
										Map user = (Map)((Map)map.get("result")).get("user");
										if (user.get("partyId") != null) {
											SysUserBehaviorEntity entity = new SysUserBehaviorEntity();
											entity.setBehaviorId(Long.parseLong(String.valueOf(res.get("id"))));
											entity.setUserId(Long.parseLong(String.valueOf(user.get("partyId"))));
											listUpdate.add(entity);
										}
									}
								}
								
								if (listUpdate.size() > 20) {
									dao.batchUpdateSelective(listUpdate);
									listUpdate = new ArrayList<>();
								}
							}
							if (listUpdate.size() > 0) {
								dao.batchUpdateSelective(listUpdate);
							}
						}
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}});
	}

	class ShutdownCallbackThread extends Thread {
		@Override
		public void run() {
			flag = false;
			LOGGER.info("JVM关闭，进程结束！");
		}
	}
	
	/**
	 * 存储请求的数据
	 */
	@Override
	@Transactional(rollbackFor=Exception.class)
    public Boolean saveBehavior(MessageDto messageDto) {
		LOGGER.info("行为记录, 用户为 {}, 行为为{}, 请求为{}", messageDto.getUserId(), messageDto.getBehaviorTargetUrl(), messageDto.getRequestId());
		
		if (!StringUtil.isEmpty(messageDto.getBehaviorTargetUrl()) && messageDto.getBehaviorTargetUrl().length() > 765) {
			messageDto.setBehaviorTargetUrl(messageDto.getBehaviorTargetUrl().substring(0, 765));
		}
    	SysUserBehaviorEntity entity = new SysUserBehaviorEntity();
    	entity.generatePk();
    	entity.setUserId(messageDto.getUserId());
    	entity.setBehaviorType(messageDto.getBehaviorType());
    	entity.setBehaviorTarget(messageDto.getBehaviorTarget());
    	entity.setBehaviorTargetUrl(messageDto.getBehaviorTargetUrl());
    	entity.setBehaviorTime(Long.parseLong(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(messageDto.getBehaviorTime())));
    	entity.setBehaviorEndpoint(messageDto.getBehaviorEndpoint());
    	
    	SysUserBehaviorParamsEntity paramsEntity = new SysUserBehaviorParamsEntity();
    	paramsEntity.setBehaviorId(entity.getBehaviorId());
    	paramsEntity.setRequestId(messageDto.getRequestId());
    	paramsEntity.setBehaviorTags(messageDto.getBehaviorTags());
    	paramsEntity.setBehaviorTime(entity.getBehaviorTime());
    	paramsEntity.setQueryParams(messageDto.getQueryParams());
    	paramsEntity.setBodyParams(emojiFilter(messageDto.getBodyParams()));
    	
    	this.dao.insert(entity);
    	this.paramsDao.insert(paramsEntity);
    	return true;
    }
    
	/**
	 * 存储响应的数据
	 */
	@Override
	@Transactional(rollbackFor=Exception.class)
    public Boolean saveBehaviorResponse(MessageDto messageDto) {
		LOGGER.info("响应记录, 对应请求为{}", messageDto.getRequestId());
    	SysUserBehaviorResponseEntity responseEntity = new SysUserBehaviorResponseEntity();
    	if (!StringUtil.isEmpty(messageDto.getHttpStatus())) {
    		responseEntity.setHttpStatus(messageDto.getHttpStatus());
    		if (String.valueOf(HttpStatus.OK.value()).equals(messageDto.getHttpStatus())) {
    			/*如果httpstatus是200，则获取响应结果里的code*/
    			try {
    				/*获取响应里的code*/
    				Map map = JsonBeanUtil.jsonToBean(messageDto.getBodyResponse(), Map.class);
    				if (map.containsKey("code")) {
    					responseEntity.setResponseCode(String.valueOf(map.get("code")));
    				}
    			} catch(Exception ex) {
    				/*如果获取code失败，不影响记录响应*/
    			}
    		}
    	}
    	responseEntity.setRequestId(messageDto.getRequestId());
    	responseEntity.setBehaviorResponse(emojiFilter(messageDto.getBodyResponse()));
    	responseEntity.setResponseTime(Long.parseLong(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(messageDto.getResponseTime())));
    	responseDao.insert(responseEntity);
    	return true;
    }
}
