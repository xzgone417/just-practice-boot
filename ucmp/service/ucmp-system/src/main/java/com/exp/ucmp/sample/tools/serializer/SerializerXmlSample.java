package com.exp.ucmp.sample.tools.serializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.egrid.core.util.XmlBeanUtil;

import com.exp.ucmp.sample.dto.SamplePagingDto;

/**
 * 序列化和反序列化的样例(Xml)
 *
 */
public class SerializerXmlSample {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SerializerXmlSample.class);
	
	/**
	 * 将对象序列化成Xml字符串，采用了JAXB。
	 * @param bean 待序列化对象
	 * @param clazz 类对象
	 * @return xml字符串
	 */
	public <T> String beanToXml(T bean, Class<T> clazz) {
		return XmlBeanUtil.jaxbBeanToXml(bean, clazz);
	}
	
	/**
	 * 将Json字符串反序列化成对象
	 * @param xmlString xml字符串
	 * @param clazz 类
	 * @return 对象
	 */
	public <T> T xmlToBean(String xmlString, Class<T> clazz) {
		return XmlBeanUtil.jaxbXmlToBean(xmlString, clazz);
	}
	
	public static void main(String[] args) {
		SerializerXmlSample xmlSample = new SerializerXmlSample();
		SamplePagingDto dto = SamplePagingDto.getInstance();
		LOGGER.info("待序列化对象\n{}", dto.toString());
		String xml = xmlSample.beanToXml(dto, SamplePagingDto.class);
		/*序列化的Xml格式，将由PagingDto里的注解决定*/
		LOGGER.info("序列化后的Xml\n{}", xml);
		SamplePagingDto pagingDto = xmlSample.xmlToBean(xml, SamplePagingDto.class);
		LOGGER.info("Xml反序列化后的结果\n{}", pagingDto);
	}
}
