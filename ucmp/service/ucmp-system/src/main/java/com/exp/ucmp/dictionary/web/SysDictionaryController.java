package com.exp.ucmp.dictionary.web;

import com.egrid.core.json.body.JsonPropFilter;
import com.egrid.core.web.response.RestResponse;
import com.egrid.core.web.response.RestStatusCode;
import com.exp.ucmp.department.dto.SysDepartmentInfoDto;
import com.exp.ucmp.dictionary.SysDictionaryDto;
import com.exp.ucmp.dictionary.SysDictionaryQueryDto;
import com.exp.ucmp.dictionary.service.SysDictionaryService;
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
 * @date 2022年10月16日
 */

@Api(value = "Permission.API", description = "字典数据查询接口")
@RefreshScope
@Controller
public class SysDictionaryController {

    /**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(SysDictionaryController.class);

    @Autowired
    private SysDictionaryService sysDictionaryService;


    /**
     * Description: 查询字典信息
     */
    @ApiOperation(value = "查询字典信息", notes = "查询字典信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/systemInfo/findDictionary", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sysDictionaryQueryDto", value = "查询字典信息", required = true, paramType ="body", dataType = "SysDictionaryQueryDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<List<SysDictionaryDto>> findDepartmentInfo(@RequestBody SysDictionaryQueryDto sysDictionaryQueryDto) {

        try {
            List<SysDictionaryDto> sysDictionaryDtos = sysDictionaryService.queryDictionary(sysDictionaryQueryDto);

            return new RestResponse<>(RestStatusCode.OK, sysDictionaryDtos);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }


}
