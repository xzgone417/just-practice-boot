package com.exp.ucmp.department.web;


import com.egrid.core.json.body.JsonPropFilter;
import com.egrid.core.web.response.RestResponse;
import com.egrid.core.web.response.RestStatusCode;
import com.exp.ucmp.department.dto.SysDepartmentInfoDelDto;
import com.exp.ucmp.department.dto.SysDepartmentInfoEditDto;
import com.exp.ucmp.department.dto.SysDepartmentInfoDto;
import com.exp.ucmp.department.service.SysDepartmentService;
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
import java.util.Map;

/**
 * @author zhouchengwei
 * @date 2022年08月09日
 */

@Api(value = "Permission.API", description = "部门信息维护接口")
@RefreshScope
@Controller
public class SysDepartmentController {

    /**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(PermissionController.class);

    @Autowired
    private SysDepartmentService sysDepartmentService;

    /**
     * Description: 根据条件查询部门信息/查询所有部门信息
     */
    @ApiOperation(value = "查询部门信息", notes = "查询部门信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/departmentInfo/findDepartment", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sysDepartmentInfoDto", value = "查询部门信息", required = true, paramType ="body", dataType = "SysDepartmentInfoDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<PageInfo<SysDepartmentInfoDto>> findDepartmentInfo(@RequestBody SysDepartmentInfoDto sysDepartmentInfoDto) {

        try {
            PageInfo<SysDepartmentInfoDto> page = sysDepartmentService.queryDepartmentMsg(sysDepartmentInfoDto);

            return new RestResponse<>(RestStatusCode.OK, page);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

    /**
     * Description: 添加部门信息
     */
    @ApiOperation(value = "添加部门信息", notes = "添加部门信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/departmentInfo/addDepartment", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sysDepartmentInfoAddDto", value = "添加部门信息", required = true, paramType ="body", dataType = "SysDepartmentInfoEditDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<String> addDepartmentInfo(@RequestBody SysDepartmentInfoEditDto sysDepartmentInfoAddDto) {
        try {
            sysDepartmentService.addDepartmentMsg(sysDepartmentInfoAddDto);
            return new RestResponse<>();
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.BUSINESS_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.BUSINESS_UNKNOWN_ERROR,e.getMessage());
        }


    }


    /**
     * Description: 修改部门信息
     */
    @ApiOperation(value = "修改部门信息", notes = "修改部门信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/departmentInfo/modifyDepartment", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sysDepartmentInfoEditDto", value = "修改部门信息", required = true, paramType ="body", dataType = "SysDepartmentInfoEditDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<String> modifyDepartmentInfo(@RequestBody SysDepartmentInfoEditDto sysDepartmentInfoEditDto) {
        try {
            sysDepartmentService.modifyDepartmentMsg(sysDepartmentInfoEditDto);
            return new RestResponse<>();
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.BUSINESS_UNKNOWN_ERROR,e.getMessage());
        }
    }


    /**
     * Description: 删除部门信息
     */
    @ApiOperation(value = "删除部门信息", notes = "删除部门信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/departmentInfo/delDepartment", method = RequestMethod.POST)
    @JsonPropFilter(type = String.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sysDepartmentInfoDelDto", value = "删除部门信息", required = true, paramType ="body", dataType = "SysDepartmentInfoDelDto")
    })
    public RestResponse<String> delDepartmentInfo(@RequestBody SysDepartmentInfoDelDto sysDepartmentInfoDelDto) {
        try {
            sysDepartmentService.delDepartmentMsg(sysDepartmentInfoDelDto);
            return new RestResponse<>();
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR,e.getMessage());
        }
    }


    /**
     * Description: 查询部门类型
     */
    @ApiOperation(value = "查询部门类型", notes = "查询部门类型", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/departmentInfo/findDepartmentType", method = RequestMethod.POST)
    @JsonPropFilter(type = String.class)
    public RestResponse<List<Map>> findDepartmentType() {

        try {
            List<Map> departmentType = sysDepartmentService.queryDepartmentType();

            return new RestResponse<>(RestStatusCode.OK, departmentType);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }
}
