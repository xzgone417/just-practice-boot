package com.exp.ucmp.behavior.mq.redis;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.Properties;

import org.redisson.api.StreamMessageId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.egrid.cache.ICachePool;
import com.egrid.cache.jedis.pool.RedisSentinelPool;
import com.egrid.cache.redisson.cache.RedissonCache;
import com.egrid.core.serializer.pool.SerializePool;
import com.egrid.core.starter.SpringBootBindUtil;
import com.egrid.core.util.StringUtil;
import com.exp.ucmp.behavior.dto.MessageDto;
import com.exp.ucmp.behavior.mq.AbstractMq;
import com.exp.ucmp.behavior.repository.RepositoryFactory;
import com.exp.ucmp.behavior.service.impl.BehaviorServiceImpl.BehaviorTopicType;

@Component
public class RedissonMq extends AbstractMq implements EnvironmentAware {
	private static final Logger LOGGER = LoggerFactory.getLogger(RedissonMq.class);

	@Autowired
	private RepositoryFactory repoFactory;

	private RedissonCache<MessageDto> redissonCache;
	@Value("${behavior.mq.topic:behavior:notice:topic}")
	private String topicName;
	@Value("${behavior.mq.length:100000}")
	private Integer trimLen;
	private String consumer;
	

	@Override
	public void publishByStream(String behaviorTopicType, MessageDto messageDto) {
		if (redissonCache != null) {
			redissonCache.publishByStream(topicName, behaviorTopicType, messageDto, trimLen, false);
		}
	}

	@Override
	public void subscribeByStream() {
		if (redissonCache != null) {
			redissonCache.subscribeByStream(topicName, consumer, new RedissonSubscribe(redissonCache, repoFactory));
			LOGGER.info("用户行为跟踪的消息订阅已完成");
		}
	}
	
	static class RedissonSubscribe extends RedissonCache.StreamSubscribeAbstractListener<MessageDto> {
		private RepositoryFactory repoFactory;
		
		public RedissonSubscribe(RedissonCache<?> client, RepositoryFactory repoFactory) {
			super(client);
			this.repoFactory = repoFactory;
		}
		
		@Override
		protected void action(StreamMessageId id, String key, MessageDto dto) {
			if (StringUtil.isEmpty(key)) {
				return;
			}
			if (BehaviorTopicType.KeepAlive.name().equals(key)) {
				LOGGER.info("收到连接保持消息，消息id:" + dto.getMessageId());
				return;
			}
			try {
				if (BehaviorTopicType.RecordBehavior.name().equals(key)) {
					LOGGER.info("收到消息({}),尝试将消息对应的请求({})登记到行为记录里!", id, dto.getRequestId());
					Executor.getExecutor().execute(new ThreadBehavior(repoFactory, dto));
				} else if (BehaviorTopicType.RecordBehaviorResponse.name().equals(key)) {
					LOGGER.info("收到消息({}),尝试将请求({})对应的响应登记到行为记录里!", id, dto.getRequestId());
					ResponseExecutor.getResponseExecutor().execute(new ThreadBehaviorResponse(repoFactory, dto));
				}
			} catch (Exception e) {
			}
		}
	}
	
	public void setEnvironment(Environment environment) {
        Properties property = SpringBootBindUtil.bind(environment, Properties.class, "behavior.redis");
        if (property != null) {
    		String port = environment.getProperty("server.port");
    		String ip;
			try {
				ip = Inet4Address.getLocalHost().getHostAddress();
			} catch (UnknownHostException e1) {
				ip = "localhost";
			}
        	consumer = ip + "_" + port;
        	RedisProperties redisProperties = new RedisProperties();
            redisProperties.maxTotal = (StringUtil.isEmpty(property.getProperty("maxTotal")))
                ? redisProperties.maxTotal : Integer.valueOf(property.getProperty("maxTotal"));
            redisProperties.maxIdle = (StringUtil.isEmpty(property.getProperty("maxIdle")))
                ? redisProperties.maxIdle : Integer.valueOf(property.getProperty("maxIdle"));
            redisProperties.maxWaitMillis = (StringUtil.isEmpty(property.getProperty("maxWaitMillis")))
                ? redisProperties.maxWaitMillis : Long.valueOf(property.getProperty("maxWaitMillis"));
            redisProperties.testOnBorrow = (StringUtil.isEmpty(property.getProperty("testOnBorrow")))
                ? redisProperties.testOnBorrow : Boolean.valueOf(property.getProperty("testOnBorrow"));
            redisProperties.testOnReturn = (StringUtil.isEmpty(property.getProperty("testOnReturn")))
                ? redisProperties.testOnReturn : Boolean.valueOf(property.getProperty("testOnReturn"));
            redisProperties.lifo = (StringUtil.isEmpty(property.getProperty("lifo")))
                ? redisProperties.lifo : Boolean.valueOf(property.getProperty("lifo"));
            redisProperties.deployMode = (StringUtil.isEmpty(property.getProperty("deployMode")))
                ? redisProperties.deployMode : property.getProperty("deployMode");
            redisProperties.servers = (StringUtil.isEmpty(property.getProperty("servers")))
                ? redisProperties.servers : property.getProperty("servers");
            redisProperties.password = (StringUtil.isEmpty(property.getProperty("password")))
                ? redisProperties.password : property.getProperty("password");
            redisProperties.masterName = (StringUtil.isEmpty(property.getProperty("masterName")))
                ? redisProperties.masterName : property.getProperty("masterName");
            redisProperties.expireTime = (StringUtil.isEmpty(property.getProperty("expireTime")))
                ? redisProperties.expireTime : property.getProperty("expireTime");
            redisProperties.cacheName = (StringUtil.isEmpty(property.getProperty("cacheName")))
                ? redisProperties.cacheName : property.getProperty("cacheName");
            redisProperties.dbIndex = (StringUtil.isEmpty(property.getProperty("dbIndex")))
                    ? redisProperties.dbIndex : property.getProperty("dbIndex");
            
            ICachePool cachePool;
			try {
				cachePool = (ICachePool)Class.forName(redisProperties.deployMode).newInstance();
				if (!StringUtil.isEmpty(redisProperties.servers)) {
	                cachePool.setServer(redisProperties.servers);
	                cachePool.setPassword(redisProperties.password);
	                cachePool.setMaxTotal(redisProperties.maxTotal);
	                cachePool.setMaxIdle(redisProperties.maxIdle);
	                cachePool.setMaxWaitMillis(redisProperties.maxWaitMillis);
	                cachePool.setTestOnBorrow(redisProperties.testOnBorrow);
	                cachePool.setTestOnReturn(redisProperties.testOnReturn);
	                cachePool.setLifo(redisProperties.lifo);
	                if (StringUtil.isEmpty(redisProperties.dbIndex)) {
	                	cachePool.setDbIndex(0);
	                } else {
	                	cachePool.setDbIndex(Integer.parseInt(redisProperties.dbIndex));
	                }
	                if (cachePool instanceof RedisSentinelPool) {
	                    ((RedisSentinelPool)cachePool).setMasterName(redisProperties.masterName);
	                }
	                cachePool.initPool();
	            }
	            
	            redissonCache = new RedissonCache<>(new SerializePool());
	            redissonCache.setCacheName(redisProperties.cacheName);
	            redissonCache.setExpireTime(Long.parseLong(redisProperties.expireTime));
	            redissonCache.setCachePool(cachePool);
			} catch (Exception e) {
			}
        }
    }
	
    class RedisProperties {
        private String cacheName = "cmf_redis";
        private Integer maxTotal = 200;
        private Integer maxIdle = 50;
        private Long maxWaitMillis = 500L;
        private Boolean testOnBorrow = true;
        private Boolean testOnReturn = true;
        private Boolean lifo = true;
        private String deployMode = "com.egrid.cache.redisson.pool.RedissonGeneralPool";
        private String servers = "127.0.0.1:6379";
        private String password;
        private String masterName;
        private String expireTime = "1800";
        private String dbIndex = "0";
    }
}
