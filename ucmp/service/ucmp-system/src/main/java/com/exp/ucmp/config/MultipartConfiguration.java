package com.exp.ucmp.config;


import javax.servlet.MultipartConfigElement;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;


@Configuration
public class MultipartConfiguration{

//	@Bean
	public MultipartResolver multipartResolver() {
		StandardServletMultipartResolver multipartResolver=new StandardServletMultipartResolver();
		return multipartResolver;
	}
	
	public MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		factory.setMaxFileSize(DataSize.ofMegabytes(10));
		factory.setMaxRequestSize(DataSize.ofMegabytes(30));
		return null;
	}
}
