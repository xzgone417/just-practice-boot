package com.egrid.ai;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 对话服务的启动器
 * 对话服务暴露API给BOT，由它调用语义理解、对话管理、语言生成服务，完成整个对话
 * @author Yiyongfei
 *
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableTransactionManagement
@EnableFeignClients
@MapperScan({ "com.egrid.ai.dao", "com.egrid.ai.*.dao" })
public class Application {

	public static void main(String[] args) {
		new SpringApplicationBuilder(Application.class).web(WebApplicationType.SERVLET).run(args);
	}
	
}
