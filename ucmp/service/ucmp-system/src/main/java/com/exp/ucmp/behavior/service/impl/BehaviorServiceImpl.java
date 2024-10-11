package com.exp.ucmp.behavior.service.impl;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import com.egrid.core.base.id.RandomIDGennerator;
import com.exp.ucmp.behavior.dto.MessageDto;
import com.exp.ucmp.behavior.mq.MqFactory;
import com.exp.ucmp.behavior.service.IBehaviorService;


@Service
public class BehaviorServiceImpl implements IBehaviorService, ApplicationRunner {
	private static final Logger LOGGER = LoggerFactory.getLogger(BehaviorServiceImpl.class);

	public enum BehaviorTopicType {
		KeepAlive, RecordBehavior, RecordBehaviorResponse;
	}
	
	@Autowired
	private MqFactory mqFactory;
	
	private boolean flag = true;
	private ExecutorService executor = Executors.newCachedThreadPool();

	@Override
	public void run(ApplicationArguments args) throws Exception {
		executor.execute(new Runnable() {
			@Override
			public void run() {
				/*订阅消息*/
				mqFactory.getMq().subscribeByStream();
			}});
		executor.execute(new Runnable() {
			@Override
			public void run() {
				Runtime.getRuntime().addShutdownHook(new ShutdownCallbackThread());
				while (flag) {
					try {
						Thread.sleep(60 * 1000L);
						Long id = RandomIDGennerator.get().generate();
						LOGGER.info("发送连接保持消息，消息id:" + id);
						mqFactory.getMq().publishByStream(BehaviorTopicType.KeepAlive.name(), new MessageDto(id));
					} catch (Exception ex) {
					}
				}
			}});
	}
	
	@Override
	public void recordBehavior(Long userId, String behaviorType,
			String behaviorTarget, String behaviorTargetUrl, String behaviorEndpoint, String requestId,
			String queryParams, String bodyParams, String bodyResponse, String behaviorTags) {
		if (queryParams == null) {
			queryParams = "";
		}
		if (bodyParams == null) {
			bodyParams = "";
		}
		if (bodyResponse == null) {
			bodyResponse = "";
		}
		if (behaviorTags == null) {
			behaviorTags = "";
		}
		if (behaviorEndpoint == null) {
			behaviorEndpoint = "";
		}
		mqFactory.getMq().publishByStream(BehaviorTopicType.RecordBehavior.name(),
				new MessageDto(RandomIDGennerator.get().generate(), userId, behaviorType,
						behaviorTarget, behaviorTargetUrl, behaviorEndpoint, requestId, queryParams, bodyParams,
						bodyResponse, new Date(), behaviorTags, new Date(), null));
	}

	@Override
	public void recordBehaviorResponse(String httpStatus, String requestId, String bodyResponse) {
		mqFactory.getMq().publishByStream(BehaviorTopicType.RecordBehaviorResponse.name(),
				new MessageDto(RandomIDGennerator.get().generate(), null, null, null, null, null,
						requestId, null, null, bodyResponse, new Date(), null, null, httpStatus));
	}

	class ShutdownCallbackThread extends Thread {
		@Override
		public void run() {
			flag = false;
			LOGGER.info("JVM关闭，进程结束！");
		}
	}
	
}
