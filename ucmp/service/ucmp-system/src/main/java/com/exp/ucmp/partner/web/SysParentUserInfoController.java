package com.exp.ucmp.partner.web;


import com.egrid.core.json.body.JsonPropFilter;
import com.egrid.core.web.response.RestResponse;
import com.egrid.core.web.response.RestStatusCode;
import com.exp.ucmp.parentUser.dto.JobReceiveRspUserInfoDto;
import com.exp.ucmp.permission.web.PermissionController;
import com.exp.ucmp.xxljob.service.JobReceiveRspUserInfoService;
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

/**
 * @author hailele
 * @date 2022年10月19日
 * 总部人员信息Controller
 */

@Api(value = "Permission.API", tags = "总部人员信息维护接口")
@RefreshScope
@Controller
public class SysParentUserInfoController {


    /**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(PermissionController.class);

    @Autowired
    private JobReceiveRspUserInfoService sysParentUserInfoService;

    /**
     * Description: 查询人员管理页面
     */
    @ApiOperation(value = "人员管理页面查询", notes = "人员管理页面查询", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/parentUser/findPage", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "jobReceiveRspUserInfoDto", value = "人员管理页面查询", required = true, paramType ="body", dataType = "JobReceiveRspUserInfoDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<PageInfo<JobReceiveRspUserInfoDto>> findPage(@RequestBody JobReceiveRspUserInfoDto jobReceiveRspUserInfoDto) {
        try {
            PageInfo<JobReceiveRspUserInfoDto> page = sysParentUserInfoService.findPage(jobReceiveRspUserInfoDto);
            return new RestResponse<>(RestStatusCode.OK, page);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }


}
