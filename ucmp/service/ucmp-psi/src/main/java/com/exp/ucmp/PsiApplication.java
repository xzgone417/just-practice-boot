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
 * 置换业务服务的启动器
 * @author zhouchengwei
 *
 */

@EnableDiscoveryClient
@SpringBootApplication
@EnableTransactionManagement
@EnableFeignClients
@RefreshScope
@MapperScan({ "com.exp.ucmp.dao", "com.exp.ucmp.*.dao" })
public class PsiApplication {

    public static void main(String[] args) {
        try {
            new SpringApplicationBuilder(PsiApplication.class).web(WebApplicationType.SERVLET).run(args);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
