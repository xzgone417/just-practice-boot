package com.exp.ucmp.behavior.mq;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.exp.ucmp.behavior.mq.redis.RedissonMq;

@Component
public class MqFactory implements ApplicationContextAware {
	public enum MqType {
		redis, kafka;
	}

	@Value("${behavior.mq.type:redis}")
	private String mqType;
	
	private ApplicationContext applicationContext;
	
    public IMq getMq(){
        if (MqType.kafka.name().equals(mqType)) {
            return null;
        } else {
        	return applicationContext.getBean(RedissonMq.class);
        }
    }

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		this.applicationContext = applicationContext;
	}
}
