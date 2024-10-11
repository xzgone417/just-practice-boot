package com.exp.ucmp.sample.tools.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egrid.cache.redisson.cache.RedissonCache;
import com.exp.ucmp.sample.dto.SampleParameterDto;

/**
 * Redis消息发布订阅的消息发布部分
 * 
 */
@Service
public class RedissonPublishSample {
	@Autowired
    private RedissonCache redissonCache;
	public static final String topic = "sample:publish-subscribe:topic";

	public void publish(SampleParameterDto parameterDto) {
		/**
		 * 基于Redis5.0新的数据结构Stream实现的发布订阅消息队列
		 * 发布消息时需要设置消息队列的长度，以控制消息占用的内存资源，但也要避免消息尚未被消费就被清理掉(可以跟踪一段时间看一天的消息量，然后根据这个消息量设置队列长度)
		 * Key可以设置为消息的类型，如业务消息、心跳消息等。
		 * Message指消息本身
		 * TrimLen指消息队列的长度，这个需要权衡消息消费的速度和内存资源。
		 * TrimStrict建议设False，这个指当消息达到TrimLen长度时，需要清理缓存数据，设为False时，可能超出TrimLen长度时才清理
		 */
		redissonCache.publishByStream(topic, "business", parameterDto, 10000 * 50, false);
	}
	
}
