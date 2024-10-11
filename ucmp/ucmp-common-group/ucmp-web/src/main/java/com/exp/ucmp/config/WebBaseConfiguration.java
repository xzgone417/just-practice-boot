package com.exp.ucmp.config;

import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import feign.RequestInterceptor;
import feign.RequestTemplate;

import com.egrid.core.shiro.context.AuthContext;
import com.egrid.core.shiro.interceptor.HeaderInterceptor;
import com.egrid.core.util.JsonBeanUtil;
import com.exp.ucmp.model.Person;


/**
 * 
 * header拦截器 拦截用户信息
 * @author Yiyongfei
 *
 */
@Configuration
public class WebBaseConfiguration implements WebMvcConfigurer {
    @Value("${auth.userKey:x-auth-user}")
    private String userKey;
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HeaderInterceptor(userKey, Person.class));
    }

    @Bean
    public RequestInterceptor headerInterceptor() {
        return template -> {
            try {
                addHeader(template, URLEncoder.encode(JsonBeanUtil.beanToJson(AuthContext.getInstance(Person.class).getCurrentUser()), "UTF-8"));
            } catch (Exception e) {
            }
        };
    }
    
    private void addHeader(RequestTemplate template, String user) {
        template.header(userKey, encodeHeadInfo(user));
    }
    
    private String encodeHeadInfo( String headInfo ) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0, length = headInfo.length(); i < length; i++) {
            char c = headInfo.charAt(i);
            if (c <= '\u001f' || c >= '\u007f') {
                stringBuffer.append( String.format ("\\u%04x", (int)c) );
            } else {
                stringBuffer.append(c);
            }
        }
        return stringBuffer.toString();
    }
}

