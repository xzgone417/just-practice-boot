package com.exp.ucmp.parameter.web;


import com.egrid.core.json.body.JsonPropFilter;
import com.egrid.core.web.response.RestResponse;
import com.egrid.core.web.response.RestStatusCode;
import com.exp.ucmp.config.dto.SysParamConfigDto;
import com.exp.ucmp.parameter.service.SysParamConfigService;
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
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author hailele
 * @date 2022年10月27日
 * 参数配置信息Controller
 */

@Api(value = "Permission.API", description = "参数配置信息接口")
@RefreshScope
@Controller
public class SysParamConfigController {


    /**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(PermissionController.class);

    @Autowired
    private SysParamConfigService sysParamConfigService;

    /**
     * Description: 根据参数类型查询对应参数信息
     */
    @ApiOperation(value = "根据参数类型查询对应参数信息", notes = "根据参数类型查询对应参数信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/parameterConfig/findByType", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "parameterType", value = "参数类型", required = true, paramType ="query", dataType = "String")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<SysParamConfigDto> findByType(@RequestParam String parameterType) {
        try {
            SysParamConfigDto byType = sysParamConfigService.findByType(parameterType);
            return new RestResponse<>(RestStatusCode.OK, byType);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

    /**
     * Description: 参数设置页面查询
     */
    @ApiOperation(value = "参数设置页面查询", notes = "参数设置页面查询", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/parameterConfig/findPage", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "当前页", required = true, paramType ="query", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页大小", required = true, paramType ="query", dataType = "Integer"),
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<PageInfo<SysParamConfigDto>> findPage(@RequestParam Integer pageNum,@RequestParam Integer pageSize) {
        try {
            PageInfo<SysParamConfigDto> page = sysParamConfigService.findPage(pageNum,pageSize);
            return new RestResponse<>(RestStatusCode.OK, page);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }
    /**
     * Description: 参数批量修改
     */
    @ApiOperation(value = "参数设置修改", notes = "参数设置修改", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/parameterConfig/updateBatch", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "updateList", value = "参数集合", required = true, paramType ="body", dataType = "List")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse updateBatch(@RequestBody List<SysParamConfigDto> updateList) {
        try {
            sysParamConfigService.updateBatch(updateList);
            return new RestResponse<>(RestStatusCode.OK);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

    /**
     * Description: 参数设置修改
     */
    @ApiOperation(value = "参数设置修改", notes = "参数设置修改", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/parameterConfig/updateById", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "paramId", value = "参数id", required = true, paramType ="body", dataType = "String"),
            @ApiImplicitParam(name = "paramValues", value = "参数值", required = true, paramType ="body", dataType = "String"),
    })
    @JsonPropFilter(type = String.class)
    public RestResponse updateById(@RequestParam String paramId, @RequestParam String paramValues) {
        try {
            sysParamConfigService.updateById(paramId,paramValues);
            return new RestResponse<>(RestStatusCode.OK);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

}
