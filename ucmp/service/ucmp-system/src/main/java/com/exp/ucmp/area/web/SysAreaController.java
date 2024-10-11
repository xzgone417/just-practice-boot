package com.exp.ucmp.area.web;


import com.egrid.core.json.body.JsonPropFilter;
import com.egrid.core.web.response.RestResponse;
import com.egrid.core.web.response.RestStatusCode;
import com.exp.ucmp.area.dto.SysAreaInfoDto;
import com.exp.ucmp.area.service.SysAreaService;
import com.exp.ucmp.permission.web.PermissionController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author zhouchengwei
 * @date 2022年08月24日
 */

@Api(value = "Permission.API", description = "区域信息接口")
@RefreshScope
@Controller
public class SysAreaController {

    /**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(PermissionController.class);

    @Autowired
    private SysAreaService sysAreaService;

    /**
     * Description: 根据条件查询部门信息/查询所有部门信息
     */
    @ApiOperation(value = "查询区域信息", notes = "查询区域信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/areaInfo/findArea", method = RequestMethod.POST)
    @JsonPropFilter(type = String.class)
    public RestResponse<List<SysAreaInfoDto>> findAreaInfo() {

        try {
            List<SysAreaInfoDto> sysAreaInfoDtos = sysAreaService.queryAreaMsg();
            return new RestResponse<>(RestStatusCode.OK, sysAreaInfoDtos);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR,e);
        }
    }


}
