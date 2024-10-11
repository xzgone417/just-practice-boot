package com.exp.ucmp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 系统管理服务的启动器
 * @author Yiyongfei
 *
 */
@EnableDiscoveryClient
@SpringBootApplication
@ServletComponentScan
@EnableFeignClients
@MapperScan({ "com.exp.ucmp.dao", "com.exp.ucmp.*.dao" })
public class AuthApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(AuthApplication.class).web(WebApplicationType.SERVLET).run(args);
    }
    
}
