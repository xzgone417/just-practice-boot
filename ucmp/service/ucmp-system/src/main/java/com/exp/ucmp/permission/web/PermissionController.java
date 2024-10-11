package com.exp.ucmp.permission.web;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import com.egrid.core.base.id.RandomIDGennerator;
import com.egrid.core.json.body.JsonPropFilter;
import com.egrid.core.web.response.RestResponse;
import com.egrid.core.web.response.RestStatusCode;
import com.exp.ucmp.permission.dto.ApplicationInfoDto;
import com.exp.ucmp.permission.dto.BatchMenuUrlDto;
import com.exp.ucmp.permission.dto.BatchPermissionUrlDto;
import com.exp.ucmp.permission.service.PermissionService;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;

/**
 * 
 * @author Yiyongfei
 * @date 2022年07月12日
 */
@Api(value = "Permission.API", tags = "权限信息维护接口")
@RefreshScope
@Controller
public class PermissionController {

	/**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(PermissionController.class);
	
	@Autowired
	private PermissionService permissionService;
	
	/**
     * <p>Description: 添加应用</p>
     * @return 应用信息
     */
    @ApiOperation(value = "添加应用(用 于添加数据)", notes = "添加应用", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/application/add", method = RequestMethod.POST)
    @ApiOperationSupport(order = 1)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "applicationInfoDto", value = "应用信息", required = true, paramType ="body", dataType = "ApplicationInfoDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<String> addApplication(@RequestBody ApplicationInfoDto applicationInfoDto) {
        try {
            permissionService.addApplication(applicationInfoDto);
            return new RestResponse<>();
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }
    
	/**
	 * <p>Description: 批量添加权限</p>
	 * @return 权限信息
	 */
	@ApiOperation(value = "批量添加权限(用 于添加数据)", notes = "批量添加权限", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/permission/batchAdd", method = RequestMethod.POST)
	@ApiOperationSupport(order = 2)
	@ApiImplicitParams({
        @ApiImplicitParam(name = "batchPermissionUrlDto", value = "权限信息", required = true, paramType ="body", dataType = "BatchPermissionUrlDto")
    })
    @JsonPropFilter(type = String.class)
	public RestResponse<String> batchAddPermission(@RequestBody BatchPermissionUrlDto batchPermissionUrlDto) {
		try {
		    permissionService.batchAddPermission(batchPermissionUrlDto);
			return new RestResponse<>();
		} catch (Exception e) {
			LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
			return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
		}
	}

	/**
     * <p>Description: 批量添加权限</p>
     * @return 权限信息
     */
    @ApiOperation(value = "批量添加菜单(用 于添加数据)", notes = "批量添加菜单", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/menu/batchAdd", method = RequestMethod.POST)
    @ApiOperationSupport(order = 3)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "batchMenuUrlDto", value = "权限信息", required = true, paramType ="body", dataType = "BatchMenuUrlDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<String> batchAddMenu(@RequestBody BatchMenuUrlDto batchMenuUrlDto) {
        try {
            permissionService.batchAddMenu(batchMenuUrlDto);
            return new RestResponse<>();
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }
    
    public static void main(String[] args) {
		System.out.println("====pk="+RandomIDGennerator.get().generate());
	}
}


/**

POST /service/permission/batchAdd
{
  "listPermissionUrl": [
    {
      "accessType": "04",
      "name": "进入人员查询页面",
      "permission": "UCMP二手车平台:系统管理:人员管理:人员维护:页面:查询",
      "url": "/system/staff/list/enter"
    },{
      "accessType": "04",
      "name": "进入人员维护页面",
      "permission": "UCMP二手车平台:系统管理:人员管理:人员维护:页面:新增",
      "url": "/system/staff/add/enter"
    },{
      "accessType": "04",
      "name": "进入人员角色配置页面",
      "permission": "UCMP二手车平台:系统管理:人员管理:角色配置:页面:新增",
      "url": "/system/staff/role/enter"
    },{
      "accessType": "04",
      "name": "进入角色查询页面",
      "permission": "UCMP二手车平台:系统管理:角色管理:角色维护:页面:查询",
      "url": "/system/role/list/enter"
    },{
      "accessType": "04",
      "name": "进入角色维护页面",
      "permission": "UCMP二手车平台:系统管理:角色管理:角色维护:页面:新增",
      "url": "/system/role/add/enter"
    },{
      "accessType": "04",
      "name": "进入角色权限配置页面",
      "permission": "UCMP二手车平台:系统管理:角色管理:权限配置:页面:新增",
      "url": "/system/role/permission/enter"
    }
  ]
}
注意:accessType访问类型：01、匿名访问；02、基于用户（已登录验证或记住我验证均可）；03、登录验证；04、鉴权

加菜单：
POST /service/menu/batchAdd
{
  "listMenuUrl": [
    {
      "menu": "系统菜单:系统管理:人员管理",
      "seq": 1,
      "url": "/system/staff/list/enter"
    },{
      "menu": "系统菜单:系统管理:角色管理",
      "seq": 2,
      "url": "/system/role/list/enter"
    }
  ]
}

**/
