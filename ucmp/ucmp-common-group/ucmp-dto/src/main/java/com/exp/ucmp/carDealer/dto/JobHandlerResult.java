package com.exp.ucmp.carDealer.dto;

import java.util.ArrayList;
import java.util.List;

public class JobHandlerResult {
    
	private Integer handlerCount;
	private List<String> handerMessages = new ArrayList<>();
	
	public Integer getHandlerCount() {
		return handlerCount;
	}
	public void setHandlerCount(Integer handlerCount) {
		this.handlerCount = handlerCount;
	}
	public List<String> getHanderMessages() {
		return handerMessages;
	}
	public void addMessasge(String message) {
		handerMessages.add(message);
	}
	
}
