package com.egrid.ai.config;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import com.egrid.ai.Application;
import com.egrid.core.swagger.Swagger2Template;
import com.egrid.core.swagger.SwaggerApiInfo;
import com.egrid.core.web.response.RestStatusCode;

import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * Swagger配置
 * @author Yiyongfei
 *
 */
@Configuration
@EnableSwagger2
public class Swagger2Configuration extends Swagger2Template {

	@Value("${spring.application.name}")    
	private String appName;
	
	@Override
    protected SwaggerApiInfo apiInfo() {
		SwaggerApiInfo info = new SwaggerApiInfo();
        return info.title(appName + " RESTful APIs")//设置文档的标题
                .description("更多Swagger相关文章请关注：https://swagger.io/docs/specification/about/")//设置文档的描述
                .version("1.0")//设置文档的版本信息
                .basePackage(Application.class.getPackage().getName());
    }

	@Override
	protected void preConfigure(Docket docket) {
		docket.useDefaultResponseMessages(false)
		  .globalResponseMessage(RequestMethod.GET, extractStatusCodes());
	}
	
	private List<ResponseMessage> extractStatusCodes() {
        final LinkedList<ResponseMessage> list = new LinkedList<>();
        for (RestStatusCode statusCodes : RestStatusCode.values()) {
            final ResponseMessageBuilder builder = new ResponseMessageBuilder();
            final ResponseMessage message = builder
                    .code(statusCodes.code())
                    .message(statusCodes.message())
                    .build();
            list.add(message);
        }
        return list;
    }
}
