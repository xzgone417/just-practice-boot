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
    "scriptTag":"Image",
    "scriptUri":"/cmf-service-vmdeploy.tar.gz",
    "scriptVars":"{\"service_names\":[{\"name\":\".\"},{\"name\":\"ucmp-entity\"},{\"name\":\"ucmp-dto\"},{\"name\":\"ucmp-web\"}],\"git_protocol\":\"http\",\"git_base_repo\":\"106.15.88.88\",\"git_access_token\":\"WEXDcXaaHP6CXP5QvGno\",\"project_group\":\"/hiphi/ucmp/\",\"project_name\":\"ucmp-common-group\",\"project_branch\":\"develop_branch\",\"git_dir\":\"/root/workspaces/ucmp-common-group\",\"project_parent\":true,\"mvn_lifecycle\":\"clean install -Dmaven.test.skip=true\"}"
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
            "10.131.180.118 ansible_ssh_user=ucmpuser ansible_ssh_pass=Zaq12wsX ansible_sudo_pass=Zaq12wsX"
        ]
    },
    "scriptName":"service_deployment_playbook.yml",
    "scriptTag":"Image",
    "scriptUri":"/cmf-service-vmdeploy.tar.gz",
    "scriptVars":"{\"service_names\":[{\"name\":\".\"},{\"name\":\"ucmp-entity\"},{\"name\":\"ucmp-dto\"},{\"name\":\"ucmp-web\"}],\"git_protocol\":\"http\",\"git_base_repo\":\"106.15.88.88\",\"git_access_token\":\"WEXDcXaaHP6CXP5QvGno\",\"project_group\":\"/hiphi/ucmp/\",\"project_name\":\"ucmp-common-group\",\"project_branch\":\"test_branch\",\"git_dir\":\"/root/workspaces/ucmp-common-group\",\"project_parent\":true,\"mvn_lifecycle\":\"clean install -Dmaven.test.skip=true\"}"
}
```
