package com.exp.ucmp.sample.tools.cache;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.redisson.api.RDelayedQueue;
import org.redisson.api.RList;
import org.redisson.api.RListMultimap;
import org.redisson.api.RListMultimapCache;
import org.redisson.api.RMap;
import org.redisson.api.RMapCache;
import org.redisson.api.RQueue;
import org.redisson.api.RSet;
import org.redisson.api.RSetCache;
import org.redisson.api.RSetMultimap;
import org.redisson.api.RSetMultimapCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egrid.cache.redisson.cache.RedissonCache;
import com.exp.ucmp.sample.dto.CacheReqDto.DelayedQueueValue;

@Service
public class RedissonSample {
	@Autowired
    private RedissonCache redissonCache;

	
	/*-------------------------------------------------- 自增自减 -----------------------------------------------------*/
	/**
	 * 自增
	 * 
	 * @param key
	 * @param value
	 */
	public Long incrBy(String key, Long value) {
		/**
		 * RQueue Java对象实现了java.util.Queue接口。
		 * 
		 */
		String _key = new StringBuilder().append("stock").append(":").append(key).toString();
		return redissonCache.incrBy(_key, value);
	}
	/**
	 * 自减
	 * 自增和自减因为是线程安全的，可以用于商品库存的扣减和增加
	 * 
	 * @param key
	 * @param value
	 */
	public Long decrBy(String key, Long value) {
		/**
		 * RQueue Java对象实现了java.util.Queue接口。
		 * 
		 */
		String _key = new StringBuilder().append("stock").append(":").append(key).toString();
		return redissonCache.decrBy(_key, value);
	}
	
	
	/*--------------------------------------------------- 结构 ------------------------------------------------------*/
	/**
	 * 普通应用
	 * 
	 * @param key
	 * @param value
	 */
	public void general(String key, String value) {
		String _key = new StringBuilder().append("general").append(":").append(key).toString();
		redissonCache.put(_key, value);
	}
	public String general(String key) {
		String _key = new StringBuilder().append("general").append(":").append(key).toString();
		return (String) redissonCache.get(_key);
	}
	
	/**
	 * 映射(Map结构)
	 * 
	 * @param key
	 * @param value
	 */
	public void map(String key, Map<String, String> value) {
		/**
		 * RMap Java对象实现了java.util.concurrent.ConcurrentMap接口和java.util.Map接口。
		 * 与HashMap不同的是，RMap保持了元素的插入顺序。该对象的最大容量受Redis限制。
		 * 
		 */
		String _key = new StringBuilder().append("map").append(":").append(key).toString();
		RMap<Object, Object> r = redissonCache.getMap(_key);
		redissonCache.expire(_key, TimeUnit.MINUTES, 30L);
		r.putAll(value);
		r.put("setDate", new Date());
	}
	public Map map(String key) {
		/**
		 * RMap Java对象实现了java.util.concurrent.ConcurrentMap接口和java.util.Map接口。
		 * 与HashMap不同的是，RMap保持了元素的插入顺序。该对象的最大容量受Redis限制。
		 * 
		 */
		String _key = new StringBuilder().append("map").append(":").append(key).toString();
		RMap<Object, Object> r = redissonCache.getMap(_key);
		redissonCache.expire(_key, TimeUnit.MINUTES, 30L);
		Set<Object> keys = r.keySet();
		return r.getAll(keys);
	}
	/**
	 * 映射(Map结构)
	 * 
	 * @param key
	 * @param value
	 */
	public void mapcache(String key, Map<String, String> value) {
		/**
		 * RMapCache Java对象在基于RMap的前提下实现了针对单个元素的淘汰机制。同时仍然保留了元素的插入顺序。
		 * 带有元素淘汰（Eviction）机制的映射类允许针对一个映射中每个元素单独设定 有效时间 和 最长闲置时间 。
		 */
		String _key = new StringBuilder().append("mapcache").append(":").append(key).toString();
		RMapCache<Object, Object> r = redissonCache.getMapCache(_key);
		redissonCache.expire(_key, TimeUnit.MINUTES, 30L);
		for(String str : value.keySet()) {
			// 有效时间 ttl = 3分钟, 最长闲置时间 maxIdleTime = 1分钟
			r.put(str, value.get(str), 3, TimeUnit.MINUTES, 1, TimeUnit.MINUTES);
		}
		r.put("setDate", new Date());
	}
	public Map mapcache(String key) {
		/**
		 * RMapCache Java对象在基于RMap的前提下实现了针对单个元素的淘汰机制。同时仍然保留了元素的插入顺序。
		 * 带有元素淘汰（Eviction）机制的映射类允许针对一个映射中每个元素单独设定 有效时间 和 最长闲置时间 。
		 */
		String _key = new StringBuilder().append("mapcache").append(":").append(key).toString();
		RMapCache<Object, Object> r = redissonCache.getMapCache(_key);
		redissonCache.expire(_key, TimeUnit.MINUTES, 30L);
		Set<Object> keys = r.readAllKeySet();
		return r.getAll(keys);
	}

	
	/**
	 * 多值映射(基于Set)
	 * 
	 * @param key
	 * @param value
	 */
	public void setMultimap(String key, Map<String, Set<String>> value) {
		/**
		 * RSetMultimap Java对象允许Map中的一个字段值包含多个元素。
		 * 基于集（Set）的多值映射不允许一个字段值包含有重复的元素。
		 * 
		 */
		String _key = new StringBuilder().append("multimap").append(":").append("set").append(":").append(key).toString();
		RSetMultimap<Object, Object> r = redissonCache.getSetMultimap(_key);
		redissonCache.expire(_key, TimeUnit.MINUTES, 30L);
		for(String str : value.keySet()) {
			r.put(str, value.get(str));
		}
		r.put("setDate", new Date());
	}
	public Map setMultimap(String key) {
		/**
		 * RSetMultimap Java对象允许Map中的一个字段值包含多个元素。
		 * 基于集（Set）的多值映射不允许一个字段值包含有重复的元素。
		 * 
		 */
		String _key = new StringBuilder().append("multimap").append(":").append("set").append(":").append(key).toString();
		RSetMultimap<Object, Object> r = redissonCache.getSetMultimap(_key);
		redissonCache.expire(_key, TimeUnit.MINUTES, 30L);
		Map<String, Set<Object>> map = new HashMap<>();
		Set<Object> keys = r.readAllKeySet();
		for(Object str : keys) {
			map.put((String)str, r.get(str));
		}
		return map;
	}
	
	/**
	 * 多值映射(基于Set)
	 * 
	 * @param key
	 * @param value
	 */
	public void setMultimapCache(String key, Map<String, Set<String>> value) {
		/**
		 * RSetMultimapCache Java对象允许Map中的一个字段值包含多个元素。
		 * 带有元素淘汰（Eviction）机制的映射类允许针对一个映射中每个元素单独设定 有效时间。
		 * 
		 */
		String _key = new StringBuilder().append("multimap").append(":").append("setcache").append(":").append(key).toString();
		RSetMultimapCache<Object, Object> r = redissonCache.getSetMultimapCache(_key);
		redissonCache.expire(_key, TimeUnit.MINUTES, 30L);
		for(String str : value.keySet()) {
			r.put(str, value.get(str));
			// 有效时间 ttl = 2分钟
			r.expireKey(str, 2, TimeUnit.MINUTES);
		}
		r.put("setDate", new Date());
	}
	public Map setMultimapCache(String key) {
		/**
		 * RSetMultimapCache Java对象允许Map中的一个字段值包含多个元素。
		 * 带有元素淘汰（Eviction）机制的映射类允许针对一个映射中每个元素单独设定 有效时间。
		 * 
		 */
		String _key = new StringBuilder().append("multimap").append(":").append("setcache").append(":").append(key).toString();
		RSetMultimapCache<Object, Object> r = redissonCache.getSetMultimapCache(_key);
		redissonCache.expire(_key, TimeUnit.MINUTES, 30L);
		Map<String, Set<Object>> map = new HashMap<>();
		Set<Object> keys = r.readAllKeySet();
		for(Object str : keys) {
			map.put((String)str, r.get(str));
		}
		return map;
	}
	
	
	/**
	 * 多值映射(基于List)
	 * 
	 * @param key
	 * @param value
	 */
	public void listMultimap(String key, Map<String, List<String>> value) {
		/**
		 * RListMultimap Java对象允许Map中的一个字段值包含多个元素。
		 * 
		 */
		String _key = new StringBuilder().append("multimap").append(":").append("list").append(":").append(key).toString();
		RListMultimap<Object, Object> r = redissonCache.getListMultimap(_key);
		redissonCache.expire(_key, TimeUnit.MINUTES, 30L);
		for(String str : value.keySet()) {
			r.put(str, value.get(str));
		}
		r.put("setDate", new Date());
	}
	public Map listMultimap(String key) {
		/**
		 * RListMultimap Java对象允许Map中的一个字段值包含多个元素。
		 * 
		 */
		String _key = new StringBuilder().append("multimap").append(":").append("list").append(":").append(key).toString();
		RListMultimap<Object, Object> r = redissonCache.getListMultimap(_key);
		redissonCache.expire(_key, TimeUnit.MINUTES, 30L);
		Map<String, List<Object>> map = new HashMap<>();
		Set<Object> keys = r.readAllKeySet();
		for(Object str : keys) {
			map.put((String)str, r.get(str));
		}
		return map;
	}
	
	/**
	 * 多值映射(基于Set)
	 * 
	 * @param key
	 * @param value
	 */
	public void listMultimapCache(String key, Map<String, List<String>> value) {
		/**
		 * RListMultimapCache Java对象允许Map中的一个字段值包含多个元素。
		 * 带有元素淘汰（Eviction）机制的映射类允许针对一个映射中每个元素单独设定 有效时间。
		 * 
		 */
		String _key = new StringBuilder().append("multimap").append(":").append("listcache").append(":").append(key).toString();
		RListMultimapCache<Object, Object> r = redissonCache.getListMultimapCache(_key);
		redissonCache.expire(_key, TimeUnit.MINUTES, 30L);
		for(String str : value.keySet()) {
			r.put(str, value.get(str));
			// 有效时间 ttl = 2分钟
			r.expireKey(str, 2, TimeUnit.MINUTES);
		}
		r.put("setDate", new Date());
	}
	public Map listMultimapCache(String key) {
		/**
		 * RListMultimapCache Java对象允许Map中的一个字段值包含多个元素。
		 * 带有元素淘汰（Eviction）机制的映射类允许针对一个映射中每个元素单独设定 有效时间。
		 * 
		 */
		String _key = new StringBuilder().append("multimap").append(":").append("listcache").append(":").append(key).toString();
		RListMultimapCache<Object, Object> r = redissonCache.getListMultimapCache(_key);
		redissonCache.expire(_key, TimeUnit.MINUTES, 30L);
		Map<String, List<Object>> map = new HashMap<>();
		Set<Object> keys = r.readAllKeySet();
		for(Object str : keys) {
			map.put((String)str, r.get(str));
		}
		return map;
	}

	
	/**
	 * 集
	 * 
	 * @param key
	 * @param value
	 */
	public void set(String key, Set<String> value) {
		/**
		 * RSet Java对象实现了java.util.Set接口。通过元素的相互状态比较保证了每个元素的唯一性。
		 * 
		 */
		String _key = new StringBuilder().append("set").append(":").append(key).toString();
		RSet<Object> r = redissonCache.getSet(_key);
		redissonCache.expire(_key, TimeUnit.MINUTES, 30L);
		r.addAll(value);
	}
	public Set set(String key) {
		/**
		 * RSet Java对象实现了java.util.Set接口。通过元素的相互状态比较保证了每个元素的唯一性。
		 * 
		 */
		String _key = new StringBuilder().append("set").append(":").append(key).toString();
		RSet<Object> r = redissonCache.getSet(_key);
		redissonCache.expire(_key, TimeUnit.MINUTES, 30L);
		return r.readAll();
	}
	
	/**
	 * 集
	 * 
	 * @param key
	 * @param value
	 */
	public void setCache(String key, Set<String> value) {
		/**
		 * RSetMultimapCache Java对象允许Map中的一个字段值包含多个元素。
		 * 带有元素淘汰（Eviction）机制的映射类允许针对一个映射中每个元素单独设定 有效时间。
		 * 
		 */
		String _key = new StringBuilder().append("setcache").append(":").append(key).toString();
		RSetCache<Object> r = redissonCache.getSetCache(_key);
		redissonCache.expire(_key, TimeUnit.MINUTES, 30L);
		for(String str : value) {
			r.add(str, 2, TimeUnit.MINUTES);
		}
		r.add(new Date());
	}
	public Set setCache(String key) {
		/**
		 * RSetMultimapCache Java对象允许Map中的一个字段值包含多个元素。
		 * 带有元素淘汰（Eviction）机制的映射类允许针对一个映射中每个元素单独设定 有效时间。
		 * 
		 */
		String _key = new StringBuilder().append("setcache").append(":").append(key).toString();
		RSetCache<Object> r = redissonCache.getSetCache(_key);
		redissonCache.expire(_key, TimeUnit.MINUTES, 30L);
		return r.readAll();
	}

	
	/**
	 * 列表
	 * 
	 * @param key
	 * @param value
	 */
	public void list(String key, List<String> value) {
		/**
		 * RList Java对象在实现了java.util.List接口的同时，确保了元素插入时的顺序。
		 * 
		 */
		String _key = new StringBuilder().append("list").append(":").append(key).toString();
		RList<Object> r = redissonCache.getList(_key);
		redissonCache.expire(_key, TimeUnit.MINUTES, 30L);
		r.addAll(value);
	}
	public List list(String key) {
		/**
		 * RList Java对象在实现了java.util.List接口的同时，确保了元素插入时的顺序。
		 * 
		 */
		String _key = new StringBuilder().append("list").append(":").append(key).toString();
		RList<Object> r = redissonCache.getList(_key);
		redissonCache.expire(_key, TimeUnit.MINUTES, 30L);
		return r.readAll();
	}

	
	/**
	 * 队列
	 * 
	 * @param key
	 * @param value
	 */
	public void queue(String key, List<String> value) {
		/**
		 * RQueue Java对象实现了java.util.Queue接口。
		 * 
		 */
		String _key = new StringBuilder().append("queue").append(":").append(key).toString();
		RQueue<Object> r = redissonCache.getQueue(_key);
		redissonCache.expire(_key, TimeUnit.MINUTES, 30L);
		r.addAll(value);
	}
	public List queue(String key) {
		/**
		 * RQueue Java对象实现了java.util.Queue接口。
		 * 
		 */
		String _key = new StringBuilder().append("queue").append(":").append(key).toString();
		RQueue<Object> r = redissonCache.getQueue(_key);
		redissonCache.expire(_key, TimeUnit.MINUTES, 30L);
		return r.readAll();
	}
	/**
	 * 延时队列
	 * 
	 * @param key
	 * @param value
	 */
	public void delayedQueue(String key, List<DelayedQueueValue> value) {
		/**
		 * RQueue Java对象实现了java.util.Queue接口。
		 * 
		 */
		String _key = new StringBuilder().append("queue").append(":").append(key).toString();
		RQueue<Object> queue = redissonCache.getQueue(_key);
		redissonCache.expire(_key, TimeUnit.MINUTES, 30L);
		RDelayedQueue r = redissonCache.getDelayedQueue(queue);
		for(DelayedQueueValue temp : value) {
			r.offer(temp.getValue(), temp.getSeconds(), TimeUnit.SECONDS);
		}
	}
	
	
}
