package com.exp.ucmp.behavior.mq;

import com.exp.ucmp.behavior.dto.MessageDto;

public interface IMq {

	void publishByStream(String behaviorTopicType, MessageDto messageDto);
	
	void subscribeByStream();
}
