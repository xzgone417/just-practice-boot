package com.exp.ucmp.department.web;


import com.egrid.core.json.body.JsonPropFilter;
import com.egrid.core.web.response.RestResponse;
import com.egrid.core.web.response.RestStatusCode;
import com.exp.ucmp.department.dto.SysDepartmentInfoDto;
import com.exp.ucmp.department.dto.SysDepartmentStaffRelaDto;
import com.exp.ucmp.department.dto.SysDepartmentStaffRelaEditDto;
import com.exp.ucmp.department.dto.SysStaffAllDto;
import com.exp.ucmp.department.service.SysDepartmentStaffService;
import com.exp.ucmp.permission.web.PermissionController;
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
 * @date 2022年08月09日
 */

@Api(value = "Permission.API", description = "部门员工信息维护接口")
@RefreshScope
@Controller
public class SysDepartmentStaffController {
    /**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(PermissionController.class);

    @Autowired
    private SysDepartmentStaffService sysDepartmentStaffService;

    /**
     * Description: 查询某个部门下所有员工/查询总部所有部门员工
     */
    @ApiOperation(value = "查询某个部门下所有员工/查询总部所有部门员工", notes = "查询某个部门下所有员工/查询总部所有部门员工", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/application/findDepartmentStaff", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "staffAllDto", value = "查询某个部门下所有员工/查询总部所有部门员工", required = true, paramType ="body", dataType = "SysStaffAllDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<PageInfo<SysStaffAllDto>> findDepartmentStaffInfo(@RequestBody SysStaffAllDto staffAllDto) {
        try {
            PageInfo<SysStaffAllDto> page = sysDepartmentStaffService.queryDepartmentStaffMsg(staffAllDto);
            return new RestResponse<>(RestStatusCode.OK, page);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

    /**
     * Description: 查询某个部门下所有员工
     */
    @ApiOperation(value = "查询某个部门下所有员工", notes = "查询某个部门下所有员工", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/application/findDepartmentStaffRole", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "staffAllDto", value = "查询某个部门下所有员工", required = true, paramType ="body", dataType = "SysStaffAllDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<PageInfo<SysStaffAllDto>> findDepartmentStaffRoleInfo(@RequestBody SysStaffAllDto staffAllDto) {
        try {
            PageInfo<SysStaffAllDto> page = sysDepartmentStaffService.queryDepartmentStaffRoleMsg(staffAllDto);
            return new RestResponse<>(RestStatusCode.OK, page);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

    /**
     * Description: 添加部门员工
     */
    @ApiOperation(value = "添加部门员工", notes = "添加部门员工", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/application/addDepartmentStaff", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sysDepartmentStaffRelaEditDto", value = "添加部门员工", required = true, paramType ="body", dataType = "SysDepartmentStaffRelaEditDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<String> addDepartmentStaffInfo(@RequestBody SysDepartmentStaffRelaEditDto sysDepartmentStaffRelaEditDto) {
        try {
            sysDepartmentStaffService.editDepartmentStaff(sysDepartmentStaffRelaEditDto);
            return new RestResponse<>();
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.BUSINESS_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.BUSINESS_UNKNOWN_ERROR,e.getMessage());
        }
    }
}
