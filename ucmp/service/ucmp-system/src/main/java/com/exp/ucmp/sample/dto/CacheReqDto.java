package com.exp.ucmp.sample.dto;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.egrid.core.base.model.BaseModel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "CacheReqDto", description = "缓存请求")
public class CacheReqDto extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8690875193568361886L;
	
	@ApiModelProperty(value = "Key")
	private String key;
	@ApiModelProperty(value = "值, 字符串")
	private String generalValue;
	@ApiModelProperty(value = "值, 数字")
	private BigDecimal numberValue;
	@ApiModelProperty(value = "值, 映射")
	private Map<String, String> mapValue;
	@ApiModelProperty(value = "值, 多值映射")
	private Map<String, List<String>> multimapValue;
	@ApiModelProperty(value = "值, 集合、队列")
	private List<String> collectionValue;
	@ApiModelProperty(value = "值, 延迟队列")
	private List<DelayedQueueValue> delayedQueueValue;
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getGeneralValue() {
		return generalValue;
	}
	public void setGeneralValue(String generalValue) {
		this.generalValue = generalValue;
	}
	public BigDecimal getNumberValue() {
		return numberValue;
	}
	public void setNumberValue(BigDecimal numberValue) {
		this.numberValue = numberValue;
	}
	public Map<String, String> getMapValue() {
		return mapValue;
	}
	public void setMapValue(Map<String, String> mapValue) {
		this.mapValue = mapValue;
	}
	public Map<String, List<String>> getMultimapValue() {
		return multimapValue;
	}
	public void setMultimapValue(Map<String, List<String>> multimapValue) {
		this.multimapValue = multimapValue;
	}
	public Map<String, Set<String>> getSetMultimapValue() {
		Map<String, Set<String>> map = new HashMap<>();
    	Set<String> keys = multimapValue.keySet();
    	for(String str : keys) {
    		map.put(str, new HashSet(multimapValue.get(str)));
    	}
    	return map;
	}
	public List<String> getCollectionValue() {
		return collectionValue;
	}
	public void setCollectionValue(List<String> collectionValue) {
		this.collectionValue = collectionValue;
	}
	
	public List<DelayedQueueValue> getDelayedQueueValue() {
		return delayedQueueValue;
	}
	public void setDelayedQueueValue(List<DelayedQueueValue> delayedQueueValue) {
		this.delayedQueueValue = delayedQueueValue;
	}

	public static class DelayedQueueValue {
		private String value;
		private Long seconds;
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
		public Long getSeconds() {
			return seconds;
		}
		public void setSeconds(Long seconds) {
			this.seconds = seconds;
		}
	}
}
