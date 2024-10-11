package com.exp.ucmp.sample.tools.cache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.redisson.api.StreamMessageId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import com.egrid.cache.redisson.cache.RedissonCache;
import com.egrid.core.util.StringUtil;
import com.exp.ucmp.sample.dto.SampleParameterDto;

/**
 * Redis消息发布订阅的消息订阅部分
 * 
 */
@Service
public class RedissonSubscribeSample implements ApplicationRunner {
	private static final Logger LOGGER = LoggerFactory.getLogger(RedissonSubscribeSample.class);
	@Autowired
    private RedissonCache redissonCache;
	
	private boolean flag = true;
	private ExecutorService executor = Executors.newCachedThreadPool();

	@Override
	public void run(ApplicationArguments args) throws Exception {
		/**
		executor.execute(new Runnable() {
			@Override
			public void run() {
				Runtime.getRuntime().addShutdownHook(new ShutdownCallbackThread());

				redissonCache.subscribeByStream(RedissonPublishSample.topic,  RedissonPublishSample.topic + ":Group01", RedissonPublishSample.topic + ":Consumer01", new RedissonPubSub(RedissonPublishSample.topic + ":Consumer01", redissonCache));
				redissonCache.subscribeByStream(RedissonPublishSample.topic,  RedissonPublishSample.topic + ":Group01", RedissonPublishSample.topic + ":Consumer02", new RedissonPubSub(RedissonPublishSample.topic + ":Consumer02", redissonCache));
				redissonCache.subscribeByStream(RedissonPublishSample.topic,  RedissonPublishSample.topic + ":Group02", RedissonPublishSample.topic + ":Consumer", new RedissonPubSub(RedissonPublishSample.topic + ":Consumer", redissonCache));
			}});
		LOGGER.info("----样例的消息订阅完成");
		
		
		executor.execute(new Runnable() {
			@Override
			public void run() {
				Runtime.getRuntime().addShutdownHook(new ShutdownCallbackThread());
				while (flag) {
					try {
						Thread.sleep(60 * 1000L);
						SampleParameterDto dto = new SampleParameterDto();
						redissonCache.publishByStream(RedissonPublishSample.topic, "heartbeat", dto, 10000 * 50, false);
					} catch (Exception ex) {
					}
				}
			}});**/
	}
	
	class ShutdownCallbackThread extends Thread {
		@Override
		public void run() {
			flag = false;
			LOGGER.info("JVM关闭，进程结束！");
		}
	}

	class RedissonPubSub extends RedissonCache.StreamSubscribeAbstractListener<SampleParameterDto> {
		private String consumerName;
		public RedissonPubSub(String consumerName, RedissonCache<?> client) {
			super(client);
			this.consumerName = null;
		}
		
		@Override
		protected void action(StreamMessageId id, String key, SampleParameterDto dto) {
			if (StringUtil.isEmpty(key)) {
				LOGGER.info("消费者{}收到非法消息，不处理", consumerName);
				return;
			}
			if (key.equals("heartbeat")) {
				LOGGER.info("消费者{}收到心跳消息", consumerName);
				return;
			}
			try {
	        	LOGGER.info("消费者{}收到业务消息，消息内容: {}", consumerName, dto);
	        	redissonCache.getQueue("sample:publish-subscribe:queue").add(dto);
			} catch (Exception e) {
				LOGGER.error("消费者{}处理业务消息出现异常，异常内容{}", consumerName, e.getMessage());;
			}
		}
	}
	
}
