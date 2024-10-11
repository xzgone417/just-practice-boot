package com.exp.ucmp.staff.web;


import com.egrid.core.json.body.JsonPropFilter;
import com.egrid.core.web.response.RestResponse;
import com.egrid.core.web.response.RestStatusCode;
import com.exp.ucmp.area.dto.SysAreaInfoDto;
import com.exp.ucmp.permission.web.PermissionController;
import com.exp.ucmp.pertner.dto.SysPartnerStatusDto;
import com.exp.ucmp.staff.dto.*;
import com.exp.ucmp.staff.service.SysStaffService;
import com.exp.ucmp.store.dto.SysStoreInfoDto;
import com.exp.ucmp.store.dto.SysStoreStaffListDto;
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
 * @date 2022年08月12日
 */
@Api(value = "人员信息维护接口", tags = "人员信息维护接口")
@RefreshScope
@Controller
public class SysStaffController {


    @Autowired
    private SysStaffService sysStaffService;

    /**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(PermissionController.class);


    /**
     * Description: 添加人员信息
    @ApiOperation(value = "添加人员信息", notes = "添加人员信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/staffInfo/addStaff", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sysStaffDetailsAddDto", value = "添加人员信息", required = true, paramType ="body", dataType = "SysStaffDetailsAddDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<String> addStaffInfo(@RequestBody SysStaffDetailsAddDto sysStaffDetailsAddDto) {
        try {
            sysStaffService.addStaffMsg(sysStaffDetailsAddDto);
            return new RestResponse<>();
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.BUSINESS_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.BUSINESS_UNKNOWN_ERROR,e.getMessage());
        }


    }*/


    /**
     * Description: 修改人员信息
    @ApiOperation(value = "修改人员信息", notes = "修改人员信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/staffInfo/modifyStaff", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sysStaffDetailsModifyDto", value = "修改人员信息", required = true, paramType ="body", dataType = "SysStaffDetailsModifyDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<String> modifyStaffInfo(@RequestBody SysStaffDetailsModifyDto sysStaffDetailsModifyDto) {
        try {
            sysStaffService.modifyStaffMsg(sysStaffDetailsModifyDto);
            return new RestResponse<>();
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR,e.getMessage());
        }
    }*/



    /**
     * Description: 修改人员状态
    @ApiOperation(value = "修改人员状态", notes = "修改人员状态", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/staffInfo/editStaffStatus", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "staffDetailsStatusDto", value = "人员状态", required = true, paramType ="body", dataType = "SysStaffDetailsStatusDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<String> editStaffStatusInfo(@RequestBody SysStaffDetailsStatusDto staffDetailsStatusDto) {
        try {
            sysStaffService.StaffStatusEdit(staffDetailsStatusDto);
            return new RestResponse<>();
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }*/

    /**
     * Description: 删除员工信息
     */
    @ApiOperation(value = "删除员工信息", notes = "删除员工信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/staffInfo/delStaff", method = RequestMethod.POST)
    @JsonPropFilter(type = String.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sysStaffDetailsDelDto", value = "删除员工信息", required = true, paramType ="body", dataType = "SysStaffDetailsDelDto")
    })
    public RestResponse<String> delStaffInfo(@RequestBody SysStaffDetailsDelDto sysStaffDetailsDelDto) {
        try {
            sysStaffService.delStaffMsg(sysStaffDetailsDelDto);
            return new RestResponse<>();
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }


    /**
     * Description: 查询人员状态类型
     */
    @ApiOperation(value = "查询人员状态类型", notes = "查询人员状态类型", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/staffInfo/findStaffStatusType", method = RequestMethod.POST)
    @JsonPropFilter(type = String.class)
    public RestResponse<List<String>> findStaffStatusType() {

        try {
            List<String> staffStatusType = sysStaffService.queryStaffStatus();

            return new RestResponse<>(RestStatusCode.OK, staffStatusType);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }


    /**
     * Description: 查询添加的人员信息
    @ApiOperation(value = "查询添加的人员信息", notes = "查询添加的人员信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/staffInfo/seekADDStaffMsg", method = RequestMethod.POST)
    @JsonPropFilter(type = String.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sysStaffDetailsDto", value = "删除员工信息", required = true, paramType ="body", dataType = "SysStaffDetailsDto")
    })
    public RestResponse<PageInfo<SysStaffDetailsDto>> seekADDStaffMsg(@RequestBody SysStaffDetailsDto sysStaffDetailsDto) {

        try {
            PageInfo<SysStaffDetailsDto> sysStaffDetailsDtoPage = sysStaffService.queryAddStaffMsg(sysStaffDetailsDto);

            return new RestResponse<>(RestStatusCode.OK, sysStaffDetailsDtoPage);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }*/

    /**
     * Description: 人员区域维护
    @ApiOperation(value = "人员区域维护", notes = "人员区域维护", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/staffInfo/editStaffArea", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sysAreaInfoEditDto", value = "人员区域维护", required = true, paramType ="body", dataType = "SysAreaInfoEditDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<String> editStaffAreaInfo(@RequestBody SysAreaInfoEditDto sysAreaInfoEditDto) {
        try {
            sysStaffService.staffAreaEdit(sysAreaInfoEditDto);
            return new RestResponse<>();
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR,e.getMessage());
        }
    }*/


    /**
     * Description: 所有区域信息查询
    @ApiOperation(value = "所有区域信息查询", notes = "所有区域信息查询", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/staffInfo/findStaffArea", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sysAreaInfoQueryDto", value = "所有区域信息查询", required = true, paramType ="body", dataType = "SysAreaInfoQueryDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<List<SysAreaInfoDto>> findStaffAreaInfo(@RequestBody SysAreaInfoQueryDto sysAreaInfoQueryDto) {

        try {
            List<SysAreaInfoDto> sysAreaInfoDtos = sysStaffService.staffAreaQuery(sysAreaInfoQueryDto);
            return new RestResponse<>(RestStatusCode.OK, sysAreaInfoDtos);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }*/
    /** ------------------------------------------------------------ **/


    /**
     * Description: 查询人员管理列表
     */
    @ApiOperation(value = "查询人员管理列表", notes = "查询人员管理列表", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/staffInfo/findStaff", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sysStaffDetailsDto", value = "查询人员管理列表", required = true, paramType ="body", dataType = "SysStaffDetailsDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<PageInfo<SysStaffDetailsDto>> findStaffInfo(@RequestBody SysStaffDetailsDto sysStaffDetailsDto) {
        try {
            PageInfo<SysStaffDetailsDto> page = sysStaffService.queryStaff(sysStaffDetailsDto);
            return new RestResponse<>(RestStatusCode.OK, page);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }
    /**
     * Description: 所有角色信息查询
     */
    @ApiOperation(value = "所有角色信息查询", notes = "所有角色信息查询", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/staffInfo/findStaffRole", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sysStaffDetailsRoleQueryDto", value = "所有角色信息查询", required = true, paramType ="body", dataType = "SysStaffDetailsRoleQueryDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<PageInfo<SysStaffDetailsRoleQueryDto>> findStaffRoleInfo(@RequestBody SysStaffDetailsRoleQueryDto sysStaffDetailsRoleQueryDto) {
        try {
            PageInfo<SysStaffDetailsRoleQueryDto> page = sysStaffService.staffRoleQuery(sysStaffDetailsRoleQueryDto);
            return new RestResponse<>(RestStatusCode.OK, page);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

    /**
     * Description: 人员角色维护
     */
    @ApiOperation(value = "人员角色维护", notes = "人员角色维护", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/staffInfo/editStaffRole", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "partyRoleRelaDto", value = "人员角色维护", required = true, paramType ="body", dataType = "PartyRoleRelaDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<String> editStaffRoleInfo(@RequestBody PartyRoleRelaDto partyRoleRelaDto) {
        try {
            sysStaffService.staffRoleEdit(partyRoleRelaDto);
            return new RestResponse<>(RestStatusCode.OK);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR,e.getMessage());
        }
    }

    /**
     * Description: 授权门店列表查询
     * */
     @ApiOperation(value = "授权门店列表查询", notes = "授权门店列表查询", produces = MediaType.APPLICATION_JSON_VALUE)
     @RequestMapping(value = "/api/staffInfo/findStorePage", method = RequestMethod.POST)
     @ApiImplicitParams({
     @ApiImplicitParam(name = "storeListQueryDto", value = "参数对象", required = true, paramType ="body", dataType = "SysStaffStoreListQueryDto")
     })
     @JsonPropFilter(type = String.class)
     public RestResponse<PageInfo<SysStoreStaffListDto>> findStorePage(@RequestBody SysStaffStoreListQueryDto storeListQueryDto) {
         try {
             PageInfo<SysStoreStaffListDto> sysStaffServiceStorePage = sysStaffService.findStorePage(storeListQueryDto);
             return new RestResponse<>(RestStatusCode.OK,sysStaffServiceStorePage);
         } catch (Exception e) {
             LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
             return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
         }
     }

    /**
     * Description: 查看授权门店
     * */
    @ApiOperation(value = "查看授权门店", notes = "查看授权门店", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/staffInfo/findStorePageByPartyId", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sysStaffStoreListQueryDto", value = "当事人id", required = true, paramType ="query", dataType = "SysStaffStoreListQueryDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<PageInfo<SysStoreInfoDto>> findStorePageByPartyId(@RequestBody SysStaffStoreListQueryDto sysStaffStoreListQueryDto) {
        try {
            PageInfo<SysStoreInfoDto> sysStaffServiceStorePage = sysStaffService.findStorePageByPartyId(sysStaffStoreListQueryDto);
            return new RestResponse<>(RestStatusCode.OK,sysStaffServiceStorePage);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }
    /**
     * Description: 修改人员状态
     */
    @ApiOperation(value = "修改人员状态", notes = "修改人员状态", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/staffInfo/modifyStaffStatus", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "statusEditDto", value = "人员状态", required = true, paramType ="body", dataType = "SysStaffStatusEditDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<String> modifyStaffStatus(@RequestBody SysStaffStatusEditDto statusEditDto) {
        try {
            sysStaffService.modifyStaffStatus(statusEditDto);
            return new RestResponse<>(RestStatusCode.OK);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }


    /**
     * Description: 授权门店
     */
    @ApiOperation(value = "授权门店", notes = "授权门店", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/staffInfo/authorizeStore", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "storeAuthDto", value = "授权门店", required = true, paramType ="body", dataType = "SysStaffStoreAuthDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<String> authorizeStore(@RequestBody SysStaffStoreAuthDto storeAuthDto) {
        try {
            sysStaffService.authorizeStore(storeAuthDto);
            return new RestResponse<>(RestStatusCode.OK);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR,e.getMessage());
        }
    }

    /**
     * Description: 临时接口(手机号统一加密)
     *
     */
    @ApiOperation(value = "临时接口(手机号统一加密)", notes = "临时接口(手机号统一加密)", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/staffInfo/testUpdatePhone", method = RequestMethod.POST)
    @JsonPropFilter(type = String.class)
    public RestResponse<String> testUpdatePhone() {
        try {
            sysStaffService.testUpdatePhone();
            return new RestResponse<>(RestStatusCode.OK);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR,e.getMessage());
        }
    }
    
    /**
     * Description: 临时接口(添加userId映射关系)
     *
     */
    @ApiOperation(value = "临时接口(添加userId映射关系)", notes = "临时接口(添加userId映射关系)", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/staffInfo/testUpdateUserMapping", method = RequestMethod.POST)
    @JsonPropFilter(type = String.class)
    public RestResponse<String> testUpdateUserMapping() {
        try {
            sysStaffService.testUpdateUserMapping();
            return new RestResponse<>(RestStatusCode.OK);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR,e.getMessage());
        }
    }
    
}
