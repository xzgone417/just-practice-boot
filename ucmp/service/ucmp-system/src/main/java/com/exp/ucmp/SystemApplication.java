package com.exp.ucmp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 系统管理服务的启动器
 * @author Yiyongfei
 *
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableTransactionManagement
@EnableFeignClients
@RefreshScope
@MapperScan({ "com.exp.ucmp.dao", "com.exp.ucmp.*.dao" })
public class SystemApplication {

	public static void main(String[] args) {

			new SpringApplicationBuilder(SystemApplication.class).web(WebApplicationType.SERVLET).run(args);

	}
	
}
