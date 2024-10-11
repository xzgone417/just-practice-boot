package com.exp.gateway;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableDiscoveryClient
@EnableAsync
public class GatewayApplication {
    
	public static void main(String[] args) {

	    // Webflux方式启动
		new SpringApplicationBuilder(GatewayApplication.class).web(WebApplicationType.REACTIVE).run(args);

	}
}
