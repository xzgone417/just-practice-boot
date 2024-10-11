package com.egrid.ai.config;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.egrid.core.json.body.JsonReturnHandler;
import com.egrid.core.util.DateUtil;

/**
 * 
 * Web配置
 * 1、增加Json对日期的处理
 * @author Yiyongfei
 *
 */
@Configuration
public class WebConfiguration extends WebMvcConfigurerAdapter {

    @Autowired
	private Jackson2ObjectMapperBuilder jackson2ObjectMapperBuilder;
    
    @Bean
    public JsonReturnHandler jsonReturnHandler(){
        return new JsonReturnHandler();
    }

    @Override
    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> returnValueHandlers) {
        returnValueHandlers.add(0, jsonReturnHandler());
    }
    
    @Bean
	public MappingJackson2HttpMessageConverter mappingJsonpHttpMessageConverter() {
		ObjectMapper mapper = jackson2ObjectMapperBuilder.build();
		// ObjectMapper为了保障线程安全性，里面的配置类都是一个不可变的对象，所以这里的setDateFormat的内部原理其实是创建了一个新的配置类
		DateFormat dateFormat = mapper.getDateFormat();
		mapper.setDateFormat(new InnerDateFormat(dateFormat));
		MappingJackson2HttpMessageConverter mappingJsonpHttpMessageConverter = new MappingJackson2HttpMessageConverter(mapper);
		return mappingJsonpHttpMessageConverter;
	}
    
    class InnerDateFormat extends DateFormat {
		private static final long serialVersionUID = 1L;

		private DateFormat dateFormat;
    	private SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    	public InnerDateFormat(DateFormat dateFormat) {
    		this.dateFormat = dateFormat;
    	}

		@Override
		public StringBuffer format(Date date, StringBuffer toAppendTo, FieldPosition fieldPosition) {
			return dateFormat.format(date, toAppendTo, fieldPosition);
		}
		
    	@Override
    	public Date parse(String source, ParsePosition pos) {
    		if(!StringUtils.isEmpty(source) && source.trim().length() == DateUtil.FORMAT_DATETIME_YYYY_MM_DD_HH_MM_SS.length()) {
    			return simpleFormat.parse(source, pos);
    		} else {
    			return dateFormat.parse(source, pos);
    		}
    	}

    	@Override
    	public Date parse(String source) throws ParseException {
    		if(!StringUtils.isEmpty(source) && source.trim().length() == DateUtil.FORMAT_DATETIME_YYYY_MM_DD_HH_MM_SS.length()) {
    			return simpleFormat.parse(source);
    		} else {
    			return dateFormat.parse(source);
    		}
    	}

    	@Override
    	public Object clone() {
    		Object format = dateFormat.clone();
    		return new InnerDateFormat((DateFormat) format);
    	}
    }
}
