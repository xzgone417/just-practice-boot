package com.exp.gateway.config;

import java.io.Serializable;
import java.util.Properties;

import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import com.egrid.cache.ICachePool;
import com.egrid.cache.jedis.cache.RedisCache;
import com.egrid.cache.jedis.pool.RedisSentinelPool;
import com.egrid.core.serializer.pool.SerializePool;
import com.egrid.core.util.StringUtil;
import com.exp.gateway.constant.GatewayConstants;
import com.exp.gateway.util.SpringBootBindUtil;

/**
 * 
 * @author Yiyongfei
 * @date 2018年8月16日
 */
@Configuration
public class RedisConfiguration implements EnvironmentAware {

	private GatewayConstants.ShiroRedisProperties shiroRedisProperties;

	/**
	 * <p>
	 * Description: 获取redis缓存
	 * </p>
	 * 
	 * @return redis缓存
	 */
	@SuppressWarnings({ "rawtypes" })
	@Bean
	public ICachePool cachePool() throws Exception {
		ICachePool cachePool = (ICachePool) Class.forName(shiroRedisProperties.getDeployMode()).newInstance();
		if (!StringUtil.isEmpty(shiroRedisProperties.getServers())) {
			cachePool.setServer(shiroRedisProperties.getServers());
			cachePool.setPassword(shiroRedisProperties.getPassword());
			if (StringUtil.isEmpty(shiroRedisProperties.getDbIndex())) {
				cachePool.setDbIndex(0);
			} else {
				cachePool.setDbIndex(Integer.parseInt(shiroRedisProperties.getDbIndex()));
			}
			cachePool.setMaxTotal(shiroRedisProperties.getMaxTotal());
			cachePool.setMaxIdle(shiroRedisProperties.getMaxIdle());
			cachePool.setMaxWaitMillis(shiroRedisProperties.getMaxWaitMillis());
			cachePool.setTestOnBorrow(shiroRedisProperties.getTestOnBorrow());
			cachePool.setTestOnReturn(shiroRedisProperties.getTestOnReturn());
			cachePool.setLifo(shiroRedisProperties.getLifo());
			if (cachePool instanceof RedisSentinelPool) {
				((RedisSentinelPool) cachePool).setMasterName(shiroRedisProperties.getMasterName());
			}
			cachePool.initPool();
		}
		return cachePool;
	}

	/**
	 * <p>
	 * Description: 获取redis缓存
	 * </p>
	 * 
	 * @return redis缓存
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	public RedisCache<Serializable, Object> shiroRedisCache(ICachePool cachePool) {
		RedisCache<Serializable, Object> redisCache = new RedisCache<>(new SerializePool());
		redisCache.setCacheName("shiro_redis_session:user");
		redisCache.setExpireTime(Long.parseLong(shiroRedisProperties.getExpireTime()));
		redisCache.setCachePool(cachePool);
		return redisCache;
	}

	@Override
	public void setEnvironment(Environment environment) {
		Properties property = SpringBootBindUtil.bind(environment, Properties.class, "shiro.redis");
		shiroRedisProperties = new GatewayConstants.ShiroRedisProperties();
		shiroRedisProperties.setMaxTotal((StringUtil.isEmpty(property.getProperty("maxTotal")))
				? shiroRedisProperties.getMaxTotal() : Integer.valueOf(property.getProperty("maxTotal")));
		shiroRedisProperties.setMaxIdle((StringUtil.isEmpty(property.getProperty("maxIdle")))
				? shiroRedisProperties.getMaxIdle() : Integer.valueOf(property.getProperty("maxIdle")));
		shiroRedisProperties.setMaxWaitMillis((StringUtil.isEmpty(property.getProperty("maxWaitMillis")))
				? shiroRedisProperties.getMaxWaitMillis() : Long.valueOf(property.getProperty("maxWaitMillis")));
		shiroRedisProperties.setTestOnBorrow((StringUtil.isEmpty(property.getProperty("testOnBorrow")))
				? shiroRedisProperties.getTestOnBorrow() : Boolean.valueOf(property.getProperty("testOnBorrow")));
		shiroRedisProperties.setTestOnReturn((StringUtil.isEmpty(property.getProperty("testOnReturn")))
				? shiroRedisProperties.getTestOnReturn() : Boolean.valueOf(property.getProperty("testOnReturn")));
		shiroRedisProperties.setLifo((StringUtil.isEmpty(property.getProperty("lifo"))) ? shiroRedisProperties.getLifo()
				: Boolean.valueOf(property.getProperty("lifo")));
		shiroRedisProperties.setDeployMode((StringUtil.isEmpty(property.getProperty("deployMode")))
				? shiroRedisProperties.getDeployMode() : property.getProperty("deployMode"));
		shiroRedisProperties.setServers((StringUtil.isEmpty(property.getProperty("servers")))
				? shiroRedisProperties.getServers() : property.getProperty("servers"));
		shiroRedisProperties.setPassword((StringUtil.isEmpty(property.getProperty("password")))
				? shiroRedisProperties.getPassword() : property.getProperty("password"));
		shiroRedisProperties.setDbIndex((StringUtil.isEmpty(property.getProperty("dbIndex")))
				? shiroRedisProperties.getDbIndex() : property.getProperty("dbIndex"));
		shiroRedisProperties.setMasterName((StringUtil.isEmpty(property.getProperty("masterName")))
				? shiroRedisProperties.getMasterName() : property.getProperty("masterName"));
		shiroRedisProperties.setExpireTime((StringUtil.isEmpty(property.getProperty("expireTime")))
				? shiroRedisProperties.getExpireTime() : property.getProperty("expireTime"));

	}

}
