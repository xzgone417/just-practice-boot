## 部署到远程
部署地址: http://47.102.132.167:26700/swagger-ui.html#/ws-controller/agentNoticeUsingPOST

部署结果查看: http://47.102.132.167:26700/html/agent/resultCallback

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
            "10.129.181.162 ansible_ssh_user=ucmpuser ansible_ssh_pass=Zaq12wsX ansible_sudo_pass=Zaq12wsX ansible_become=yes ansible_become_method=sudo ansible_become_user=root",
            "10.129.181.60 ansible_ssh_user=ucmpuser ansible_ssh_pass=Zaq12wsX ansible_sudo_pass=Zaq12wsX ansible_become=yes ansible_become_method=sudo ansible_become_user=root"
        ]
    },
    "scriptName":"service_deployment_playbook.yml",
    "scriptTag":"Start",
    "scriptUri":"/cmf-service-vmdeploy.tar.gz",
    "scriptVars":"{\"service_names\":[{\"name\":\"ucmp-system\"}],\"git_protocol\":\"http\",\"git_base_repo\":\"106.15.88.88\",\"git_access_token\":\"WEXDcXaaHP6CXP5QvGno\",\"project_group\":\"/hiphi/ucmp/ucmp-service-group/\",\"project_name\":\"ucmp-system\",\"project_branch\":\"release_branch\",\"git_dir\":\"/root/workspaces/ucmp-service-group\",\"project_parent\":false,\"register_server\":\"10.129.181.162\",\"register_port\":\"8848\",\"register_namespace\":\"321f68a4-695b-4ad7-a170-921cc3239843\",\"service_user\":\"ucmpuser\",\"service_group\":\"ucmpuser\",\"install_dir\":\"/home/ucmpuser/workspace/ucmp\",\"jvm_opts\":\"-server -Dfile.encoding=utf-8 -XX:MetaspaceSize=256m -XX:MaxMetaspaceSize=256m -Xmx1g -Xms1g -XX:+UseG1GC -XX:MaxGCPauseMillis=200 -XX:InitiatingHeapOccupancyPercent=35\",\"spring_opts\":\"-Djasypt.encryptor.password=hiphi-ucmp -Dspring.cloud.nacos.discovery.server-addr=10.129.181.162:8848 -Dspring.cloud.nacos.discovery.namespace=321f68a4-695b-4ad7-a170-921cc3239843 -Dspring.cloud.nacos.config.server-addr=10.129.181.162:8848 -Dspring.cloud.nacos.config.namespace=321f68a4-695b-4ad7-a170-921cc3239843\"}"
}
```
