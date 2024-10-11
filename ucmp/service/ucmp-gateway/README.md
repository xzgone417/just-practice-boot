## 部署到远程
部署地址: http://47.102.132.167:26700/swagger-ui.html#/ws-controller/agentNoticeUsingPOST

部署结果查看: http://47.102.132.167:26700/html/agent/resultCallback

部署参数: 
```
阿里云(/devops/agent/1a62c76e):
{
    "ansibleOtherOptions":[
        "-v"
    ],
    "id":"20220316113355",
    "hosts":{
        "hostname":"[ansible_servers]",
        "hosts":[
            "42.51.3.91 ansible_ssh_user=root ansible_ssh_pass=Zaq!@wsX"
        ]
    },
    "scriptName":"service_deployment_playbook.yml",
    "scriptTag":"Start",
    "scriptUri":"/cmf-service-vmdeploy.tar.gz",
    "scriptVars":"{\"service_names\":[{\"name\":\"ucmp-gateway\"}],\"git_protocol\":\"http\",\"git_base_repo\":\"106.15.88.88\",\"git_access_token\":\"WEXDcXaaHP6CXP5QvGno\",\"project_group\":\"/hiphi/ucmp/ucmp-service-group/\",\"project_name\":\"ucmp-gateway\",\"project_branch\":\"develop_branch\",\"git_dir\":\"/root/workspaces/ucmp-service-group\",\"project_parent\":false,\"register_server\":\"139.224.106.219\",\"register_port\":\"8848\",\"register_namespace\":\"f90801c5-5869-4ec2-868d-5b0a87e13fbe\",\"service_user\":\"ucmp\",\"service_group\":\"ucmp\",\"install_dir\":\"/home/ucmp/workspace/ucmp\",\"jvm_opts\":\"-server -Dfile.encoding=utf-8 -XX:MetaspaceSize=128m -XX:MaxMetaspaceSize=128m -Xmx512m -Xms512m -XX:+UseG1GC -XX:MaxGCPauseMillis=200 -XX:InitiatingHeapOccupancyPercent=35\",\"spring_opts\":\"-Dspring.cloud.nacos.discovery.server-addr=139.224.106.219:8848 -Dspring.cloud.nacos.discovery.namespace=f90801c5-5869-4ec2-868d-5b0a87e13fbe -Dspring.cloud.nacos.config.server-addr=139.224.106.219:8848 -Dspring.cloud.nacos.config.namespace=f90801c5-5869-4ec2-868d-5b0a87e13fbe\"}"
}

华人运通测试环境:
{
    "ansibleOtherOptions":[
        "-v"
    ],
    "id":"20220316113355",
    "hosts":{
        "hostname":"[ansible_servers]",
        "hosts":[
            "10.131.180.118 ansible_ssh_user=ucmpuser ansible_ssh_pass=Zaq12wsX ansible_sudo_pass=Zaq12wsX ansible_become=yes ansible_become_method=sudo ansible_become_user=root"
        ]
    },
    "scriptName":"service_deployment_playbook.yml",
    "scriptTag":"Start",
    "scriptUri":"/cmf-service-vmdeploy.tar.gz",
    "scriptVars":"{\"service_names\":[{\"name\":\"ucmp-gateway\"}],\"git_protocol\":\"http\",\"git_base_repo\":\"106.15.88.88\",\"git_access_token\":\"WEXDcXaaHP6CXP5QvGno\",\"project_group\":\"/hiphi/ucmp/ucmp-service-group/\",\"project_name\":\"ucmp-gateway\",\"project_branch\":\"test_branch\",\"git_dir\":\"/root/workspaces/ucmp-service-group\",\"project_parent\":false,\"register_server\":\"10.131.180.118\",\"register_port\":\"8848\",\"register_namespace\":\"d78c2c8e-d34d-4ce5-a4d9-f7de99a23f81\",\"service_user\":\"ucmp\",\"service_group\":\"ucmp\",\"install_dir\":\"/home/ucmp/workspace/ucmp\",\"jvm_opts\":\"-server -Dfile.encoding=utf-8 -XX:MetaspaceSize=128m -XX:MaxMetaspaceSize=128m -Xmx512m -Xms512m -XX:+UseG1GC -XX:MaxGCPauseMillis=200 -XX:InitiatingHeapOccupancyPercent=35\",\"spring_opts\":\"-Dspring.cloud.nacos.discovery.server-addr=10.131.180.118:8848 -Dspring.cloud.nacos.discovery.namespace=d78c2c8e-d34d-4ce5-a4d9-f7de99a23f81 -Dspring.cloud.nacos.config.server-addr=10.131.180.118:8848 -Dspring.cloud.nacos.config.namespace=d78c2c8e-d34d-4ce5-a4d9-f7de99a23f81\"}"
}

```