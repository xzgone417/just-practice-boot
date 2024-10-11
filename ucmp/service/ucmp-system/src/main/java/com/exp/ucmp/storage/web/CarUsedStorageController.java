package com.exp.ucmp.storage.web;


import com.alibaba.fastjson.JSON;
import com.egrid.core.json.body.JsonPropFilter;
import com.egrid.core.web.response.RestResponse;
import com.egrid.core.web.response.RestStatusCode;
import com.exp.ucmp.storage.service.CarUsedStorageService;
import com.exp.ucmp.usedstorage.dto.SysUsedStorageInfoDto;
import com.exp.ucmp.usedstorage.dto.SysUsedStorageListDto;
import com.exp.ucmp.usedstorage.dto.SysUsedStorageSelectListDto;
import com.exp.ucmp.usedstorage.dto.UsedStorageInfoDto;

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
 * @date 2022/02/14
 * 仓储点Controller
 */
@Api(value = "CarUsedStorageController.API", tags = "仓储点接口")
@RefreshScope
@Controller
public class CarUsedStorageController {

    @Autowired
    private CarUsedStorageService usedStorageService;

    /**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(CarUsedStorageController.class);
    /**
     * Description: 仓储点下拉列表查询
     */
    @ApiOperation(value = "仓储点下拉列表查询", notes = "CarUsedStorageController.API", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/usedstorage/findSelectList", method = RequestMethod.GET)
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "storeId", value = "门店ID", required = false, paramType ="query", dataType = "Long")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<List<SysUsedStorageSelectListDto>> findSelectList(@RequestParam(value="storeId",required=false) Long storeId) {
        try {
            List<SysUsedStorageSelectListDto> page = usedStorageService.findSelectList(storeId);
            return new RestResponse<>(RestStatusCode.OK, page);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

    /**
     * Description: 查询仓储点列表
     */
    @ApiOperation(value = "查询仓储点列表", notes = "CarUsedStorageController.API", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/usedstorage/findList", method = RequestMethod.POST)
    @JsonPropFilter(type = String.class)
    public RestResponse<String> findList() {
        try {
            List<SysUsedStorageListDto> page = usedStorageService.findList();
            String jsonString = JSON.toJSONString(page);
            return new RestResponse<>(RestStatusCode.OK, jsonString);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

    /**
     * Description: 添加仓储点
     */
    @ApiOperation(value = "添加仓储点", notes = "CarUsedStorageController.API", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/usedstorage/addUsedStorage", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "usedStorageInfoDto", value = "仓储点Dto", required = true, paramType ="body", dataType = "SysUsedStorageInfoDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<String> addUsedStorage(@RequestBody SysUsedStorageInfoDto usedStorageInfoDto) {
        try {
            usedStorageService.addUsedStorage(usedStorageInfoDto);
            return new RestResponse<>(RestStatusCode.OK);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.BUSINESS_UNKNOWN_ERROR,e.getMessage());
        }
    }

    /**
     * Description: 更新仓储点
     */
    @ApiOperation(value = "更新仓储点", notes = "CarUsedStorageController.API", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/usedstorage/updateUsedStorage", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "usedStorageInfoDto", value = "仓储点Dto", required = true, paramType ="body", dataType = "SysUsedStorageInfoDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<String> updateUsedStorage(@RequestBody SysUsedStorageInfoDto usedStorageInfoDto) {
        try {
            usedStorageService.updateUsedStorage(usedStorageInfoDto);
            return new RestResponse<>(RestStatusCode.OK);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.BUSINESS_UNKNOWN_ERROR,e.getMessage());
        }
    }

    /**
     * Description: 仓储点信息查询
     */
    @ApiOperation(value = "仓储点信息查询", notes = "CarUsedStorageController.API", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/usedstorage/getUsedStorageInfo", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "storageId", value = "仓储点id", required = true, paramType ="query", dataType = "Long")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<SysUsedStorageInfoDto> getUsedStorageInfo(@RequestParam Long storageId) {
        try {
            SysUsedStorageInfoDto storageInfoDto = usedStorageService.getUsedStorageInfo(storageId);
            return new RestResponse<>(RestStatusCode.OK, storageInfoDto);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

    /**
     * 仓储点定时任务测试
     */
    @RequestMapping(value = "/api/usedstorage/test", method = RequestMethod.POST)
    @JsonPropFilter(type = String.class)
    public RestResponse<String> test() {
        try {
            usedStorageService.synUsedStorage();
            return new RestResponse<>(RestStatusCode.OK);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR,e.getMessage());
        }
    }
    
    @ApiOperation(value = "仓储点下拉列表查询", notes = "查询仓储点列表，包含仓库所在城市，不分页,支持仓库名称模糊查询", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/usedstorage/query/list", method = RequestMethod.GET)
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "usedstorageName", value = "仓库名称", required = false, paramType ="query", dataType = "String")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<List<UsedStorageInfoDto>> queryList(@RequestParam(value="usedstorageName",required=false) String usedstorageName) {
        try {
            List<UsedStorageInfoDto> page = usedStorageService.queryList(usedstorageName);
            return new RestResponse<>(RestStatusCode.OK, page);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

}
