package com.exp.ucmp.role.web;


import com.egrid.core.json.body.JsonPropFilter;
import com.egrid.core.web.response.RestResponse;
import com.egrid.core.web.response.RestStatusCode;
import com.exp.ucmp.department.dto.SysDepartmentInfoDto;
import com.exp.ucmp.permission.web.PermissionController;
import com.exp.ucmp.role.dto.ResourceInfoDto;
import com.exp.ucmp.role.dto.RolePermissionRelaDto;
import com.exp.ucmp.role.dto.SysRoleDetailsDto;
import com.exp.ucmp.role.service.SysRoleService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author zhouchengwei
 * @date 2022年08月11日
 */

@Api(value = "Permission.API", description = "角色信息维护接口")
@RefreshScope
@Controller
public class SysRoleController {

    /**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(PermissionController.class);

    @Autowired
    private SysRoleService sysRoleService;

    /**
     * Description: 根据条件查询角色信息/查询所有角色信息
     */
    @ApiOperation(value = "查询角色信息", notes = "查询角色信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/roleInfo/findRole", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sysRoleDetailsDto", value = "查询角色信息", required = true, paramType ="body", dataType = "SysRoleDetailsDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<PageInfo<SysRoleDetailsDto>> findDepartmentInfo(@RequestBody SysRoleDetailsDto sysRoleDetailsDto) {

        try {
            PageInfo<SysRoleDetailsDto> page = sysRoleService.queryRoleMsg(sysRoleDetailsDto);

            return new RestResponse<>(RestStatusCode.OK, page);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }


    /**
     * Description: 查询角色授权信息菜单
     */
    @ApiOperation(value = "查询角色授权信息菜单", notes = "查询角色授权信息菜单", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/roleInfo/findRoleMenu", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "resourceInfoDto", value = "查询角色授权信息菜单", required = true, paramType ="body", dataType = "ResourceInfoDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<List<ResourceInfoDto>> findRoleMenu(@RequestBody ResourceInfoDto resourceInfoDto) {

        try {
            List<ResourceInfoDto> resourceInfoDtoList = sysRoleService.queryRoleMenuList(resourceInfoDto);

            return new RestResponse<>(RestStatusCode.OK, resourceInfoDtoList);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }


    /**
     * Description: 添加角色信息
     */
    @ApiOperation(value = "添加角色信息", notes = "添加角色信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/roleInfo/addRole", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sysRoleDetailsDto", value = "添加角色信息", required = true, paramType ="body", dataType = "SysRoleDetailsDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<String> addRoleInfo(@RequestBody SysRoleDetailsDto sysRoleDetailsDto) {
        try {
            sysRoleService.addRoleMsg(sysRoleDetailsDto);
            return new RestResponse<>();
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.BUSINESS_UNKNOWN_ERROR,e.getMessage());
        }

    }


    /**
     * Description: 修改角色信息
     */
    @ApiOperation(value = "修改角色信息", notes = "修改角色信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/roleInfo/modifyRole", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sysRoleDetailsDto", value = "修改角色信息", required = true, paramType ="body", dataType = "SysRoleDetailsDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<String> modifyRoleInfo(@RequestBody SysRoleDetailsDto sysRoleDetailsDto) {
        try {
            sysRoleService.modifyRoleMsg(sysRoleDetailsDto);
            return new RestResponse<>();
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.BUSINESS_UNKNOWN_ERROR,e.getMessage());
        }
    }

    /**
     * Description: 修改角色权限信息
     */
    @ApiOperation(value = "修改角色权限信息", notes = "修改角色权限信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/roleInfo/modifyRolePower", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "rolePermissionRelaDto", value = "修改角色权限信息", required = true, paramType ="body", dataType = "RolePermissionRelaDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<String> modifyRoleInfo(@RequestBody RolePermissionRelaDto rolePermissionRelaDto) {
        try {
            sysRoleService.modifyRolePower(rolePermissionRelaDto);
            return new RestResponse<>();
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.BUSINESS_UNKNOWN_ERROR,e.getMessage());
        }
    }




    /**
     * Description: 删除角色信息
     */
    @ApiOperation(value = "删除角色信息", notes = "删除角色信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/roleInfo/delRole", method = RequestMethod.POST)
    @JsonPropFilter(type = String.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sysRoleDetailsDto", value = "删除部门信息", required = true, paramType ="body", dataType = "SysRoleDetailsDto")
    })
    public RestResponse<String> delRoleInfo(@RequestBody SysRoleDetailsDto sysRoleDetailsDto) {
        try {
            sysRoleService.delRoleMsg(sysRoleDetailsDto);
            return new RestResponse<>();
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.BUSINESS_UNKNOWN_ERROR,e.getMessage());
        }
    }


    /**
     * Description: 查询角色类型
     */
    @ApiOperation(value = "查询角色类型", notes = "查询角色类型", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/roleInfo/findRoleType", method = RequestMethod.POST)
    @JsonPropFilter(type = String.class)
    public RestResponse<List<String>> findRoleType() {

        try {
            List<String> roleType = sysRoleService.QueryRoleType();

            return new RestResponse<>(RestStatusCode.OK, roleType);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

    /**
     * Description: 角色类型下拉列表查询
     */
    @ApiOperation(value = "角色类型下拉列表查询", notes = "角色类型下拉列表查询", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/roleInfo/findSelectRoleType", method = RequestMethod.GET)
    @JsonPropFilter(type = String.class)
    public RestResponse<List<SysRoleDetailsDto>> findSelectRoleType() {
        try {
            List<SysRoleDetailsDto> roleType = sysRoleService.findSelectRoleType();
            return new RestResponse<>(RestStatusCode.OK, roleType);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

}
