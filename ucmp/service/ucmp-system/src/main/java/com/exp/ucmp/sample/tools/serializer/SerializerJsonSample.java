package com.exp.ucmp.sample.tools.serializer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.type.TypeReference;

import com.egrid.core.util.JsonBeanUtil;
import com.egrid.core.json.pool.Type;

import com.exp.ucmp.sample.dto.SamplePagingDto;
import com.exp.ucmp.sample.dto.SampleParameterDto;

/**
 * 序列化和反序列化的样例(Json)
 *
 */
public class SerializerJsonSample {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SerializerJsonSample.class);
	
	/**
	 * 将对象序列化成Json字符串，默认采用了JACKSON。
	 * @param obj 待序列化对象
	 * @return Json字符串
	 */
	public String beanToJson(Object obj) {
		return JsonBeanUtil.beanToJson(obj);
	}
	
	/**
	 * 将Json字符串反序列化成对象
	 * @param jsonString Json字符串
	 * @param clazz 类
	 * @return 对象
	 */
	public <T> T jsonToBean(String jsonString, Class<T> clazz) {
		return JsonBeanUtil.jsonToBean(jsonString, clazz);
	}

	/**
	 * 将Json字符串反序列化成对象
	 * @param jsonString Json字符串
	 * @param type 类
	 * @return 对象
	 */
	public <T> T jsonToBean(String jsonString, Type type) {
		return JsonBeanUtil.jsonToBean(jsonString, type);
	}
	
	public static void main(String[] args) {
		SerializerJsonSample jsonSample = new SerializerJsonSample();
		SamplePagingDto dto = SamplePagingDto.getInstance();
		LOGGER.info("待序列化对象\n{}", dto.toString());
		String json = jsonSample.beanToJson(dto);
		LOGGER.info("序列化后的Json\n{}", json);
		SamplePagingDto pagingDto = jsonSample.jsonToBean(json, SamplePagingDto.class);
		LOGGER.info("Json反序列化后的结果\n{}", pagingDto);
				
		List<SampleParameterDto> list = new ArrayList<>();
		list.add(SampleParameterDto.getInstance("参数一", "Param1", "1"));
    	try {
			Thread.sleep(1 * 1000);
		} catch (InterruptedException e) {
		}
    	list.add(SampleParameterDto.getInstance("参数二", "Param2", "2"));
    	
    	LOGGER.info("待序列化对象\n{}", list);
    	json = jsonSample.beanToJson(list);
    	LOGGER.info("序列化后的Json\n{}", json);
    	List<Map> listResult = jsonSample.jsonToBean(json, ArrayList.class);
    	LOGGER.info("Json反序列化后的结果\n{}\n元素里的类型为{}", listResult, listResult.get(0).getClass());
    	
    	/*对于上面的反序列化，采用下面的方式进行反序列化*/
    	TypeReference<List<SampleParameterDto>> tr = new TypeReference<List<SampleParameterDto>>(){
    		
    	};
    	List<SampleParameterDto> listParameterDto = jsonSample.jsonToBean(json, new Type(tr));
    	LOGGER.info("Json反序列化后的结果\n{}\n元素里的类型为{}", listParameterDto, listParameterDto.get(0).getClass());
	}
}
