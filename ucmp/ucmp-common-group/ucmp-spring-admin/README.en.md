# spring-boot-admin

#### 介绍
Spring Boot Admin是一个开源社区项目，用于管理和监控SpringBoot应用程序。 应用程序作为Spring Boot Admin Client向为Spring Boot Admin Server注册（通过HTTP）或使用SpringCloud注册中心（例如Eureka，Nacos）发现。 UI是的Vue.js应用程序，展示Spring Boot Admin Client的Actuator端点上的一些监控.

#### 软件架构
* 显示健康状况
* 显示详细信息，例如
* JVM和内存指标
* micrometer.io指标
* 数据源指标
* 缓存指标
* 显示内部信息
* 关注并下载日志文件
* 查看JVM系统和环境属性
* 查看Spring Boot配置属性
* 支持Spring Cloud的可发布/ env-和// refresh-endpoint
* 轻松的日志级别管理
* 与JMX-beans交互
* 查看线程转储
* 查看http-traces
* 查看审核事件
* 查看http端点
* 查看预定的任务
* 查看和删除活动会话（使用spring-session）
* 查看Flyway / Liquibase数据库迁移
* 下载heapdump
* 状态更改通知（通过电子邮件，Slack，Hipchat等）
* 状态更改的事件日志（非持久性）

#### 使用说明
Spring Boot Admin Server = 本项目
Spring Boot Admin Client = 你需要监控的项目

**Spring Boot Admin Server**
1.  Spring Boot Admin Server在yml配置文件中配置nacos地址（必须）
![](https://qiqing-1256225409.cos.ap-guangzhou.myqcloud.com/other/20200513165529.png)
2.  Spring Boot Admin Server在yml配置文件中配置登录账号、登录密码
![](https://qiqing-1256225409.cos.ap-guangzhou.myqcloud.com/other/20200513165528.png)

**Spring Boot Admin Client**
1.  Spring Boot Admin Client必须引入actuator依赖（必须）
` <!--健康检查-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>`
2.  Spring Boot Admin Client必须输出日志，admin中打印的日志都是开发者自己指定输出的（必须）
使用logback亦可
![](https://qiqing-1256225409.cos.ap-guangzhou.myqcloud.com/other/20200513170138.png)
3.  Spring Boot Admin Client开放actuator端点（必须）
注意：根据项目实际情况开放端点
![](https://qiqing-1256225409.cos.ap-guangzhou.myqcloud.com/other/20200513170913.png)
4.  Spring Boot Admin Client如果有设置servlet: context-path:属性，必须设置metadata: management: context-path:属性，如下图
![](https://qiqing-1256225409.cos.ap-guangzhou.myqcloud.com/other/20200513171716.png)



#### 部署
部署参数:
```
华人运通生产环境:
{
    "ansibleOtherOptions":[
        "-v"
    ],
    "id":"20220316113355",
    "hosts":{
        "hostname":"[ansible_servers]",
        "hosts":[
            "10.129.181.162 ansible_ssh_user=ucmpuser ansible_ssh_pass=Zaq12wsX ansible_sudo_pass=Zaq12wsX ansible_become=yes ansible_become_method=sudo ansible_become_user=root"
        ]
    },
    "scriptName":"service_deployment_playbook.yml",
    "scriptTag":"Start",
    "scriptUri":"/cmf-service-vmdeploy.tar.gz",
    "scriptVars":"{\"service_names\":[{\"name\":\"ucmp-spring-admin\"}],\"git_protocol\":\"http\",\"git_base_repo\":\"106.15.88.88\",\"git_access_token\":\"WEXDcXaaHP6CXP5QvGno\",\"project_group\":\"/hiphi/ucmp/\",\"project_name\":\"ucmp-common-group\",\"project_branch\":\"release_branch\",\"git_dir\":\"/root/workspaces/ucmp-common-group\",\"project_parent\":true,\"register_server\":\"10.129.181.162\",\"register_port\":\"8848\",\"register_namespace\":\"321f68a4-695b-4ad7-a170-921cc3239843\",\"service_user\":\"ucmpuser\",\"service_group\":\"ucmpuser\",\"install_dir\":\"/home/ucmpuser/workspace/ucmp\",\"jvm_opts\":\"-server -Dfile.encoding=utf-8 -XX:MetaspaceSize=64m -XX:MaxMetaspaceSize=64m -Xmx256m -Xms256m -XX:+UseG1GC -XX:MaxGCPauseMillis=200 -XX:InitiatingHeapOccupancyPercent=50\",\"spring_opts\":\"-Dspring.cloud.nacos.discovery.server-addr=10.129.181.162:8848 -Dspring.cloud.nacos.discovery.namespace=321f68a4-695b-4ad7-a170-921cc3239843\"}"
}
```