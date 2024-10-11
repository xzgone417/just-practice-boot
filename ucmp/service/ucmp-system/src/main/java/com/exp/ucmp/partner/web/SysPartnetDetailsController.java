package com.exp.ucmp.partner.web;


import com.egrid.core.json.body.JsonPropFilter;
import com.egrid.core.web.response.RestResponse;
import com.egrid.core.web.response.RestStatusCode;
import com.exp.ucmp.parentUser.dto.SysParentAddStoreListDto;
import com.exp.ucmp.parentUser.dto.SysParentStoreQueryDto;
import com.exp.ucmp.parentUser.dto.SysPartnerStaffInfoInsertDto;
import com.exp.ucmp.parentUser.dto.SysPartnerStoreAuthDto;
import com.exp.ucmp.partner.service.SysPartnetDetailsService;
import com.exp.ucmp.permission.web.PermissionController;
import com.exp.ucmp.pertner.dto.*;
import com.exp.ucmp.store.dto.SysStoreInfoDto;
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
import java.util.Map;

/**
 * @author zhouchengwei
 * @date 2022年09月01日
 */

@Api(value = "Permission.API", description = "合作商信息维护接口")
@RefreshScope
@Controller
public class SysPartnetDetailsController {
    /**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(PermissionController.class);

    @Autowired
    private SysPartnetDetailsService sysPartnetDetailsService;


    /**
     * Description: 查询当前合作商下人员详情
     */
    @ApiOperation(value = "查询当前合作商下人员详情", notes = "查询合作商信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/partnerInfo/findPartnerStaff", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sysPartnerStaffDetailsDto", value = "查询当前合作商下人员详情", required = true, paramType ="body", dataType = "SysPartnerStaffDetailsDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<PageInfo<SysPartnerStaffDetailsDto>> findPartnerStaffInfo(@RequestBody SysPartnerStaffDetailsDto sysPartnerStaffDetailsDto) {

        try {
            PageInfo<SysPartnerStaffDetailsDto> page = sysPartnetDetailsService.queryPartnerStaffMsg(sysPartnerStaffDetailsDto);

            return new RestResponse<>(RestStatusCode.OK, page);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }


    /**
     * Description: 查询公司管辖城市信息（合作商已无管辖城市相关业务)

    @ApiOperation(value = "查询公司管辖城市信息", notes = "查询公司管辖城市信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/partnerInfo/findPartnerCities", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sysPartnerCityQueryDto", value = "查询公司管辖城市信息", required = true, paramType ="body", dataType = "SysPartnerCityQueryDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<PageInfo<SysPartnerCityRelaDto>> findPartnerCitiesInfo(@RequestBody SysPartnerCityQueryDto sysPartnerCityQueryDto) {

        try {
            PageInfo<SysPartnerCityRelaDto> page = sysPartnetDetailsService.queryPartnerCitiesMsg(sysPartnerCityQueryDto);

            return new RestResponse<>(RestStatusCode.OK, page);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }*/


    /**
     * Description: 查询区域省市信息
     */
    @ApiOperation(value = "查询区域省市信息", notes = "查询区域省市信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/partnerInfo/findAreaRegion", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sysAreaRegionDetailsDto", value = "查询区域省市信息", required = true, paramType ="body", dataType = "SysAreaRegionDetailsDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<List<Map>> findAreaRegionInfo(@RequestBody SysAreaRegionDetailsDto sysAreaRegionDetailsDto) {

        try {
            List<Map> page = sysPartnetDetailsService.queryAreaRegionMsg(sysAreaRegionDetailsDto);

            return new RestResponse<>(RestStatusCode.OK, page);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }





    /**
     * Description: 添加当前合作商人员

    @ApiOperation(value = "添加当前合作商人员", notes = "添加当前合作商人员", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/partnerInfo/addPartnerStaff", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sysPartnerStaffDetailsDto", value = "添加当前合作商人员", required = true, paramType ="body", dataType = "SysStaffDetailsDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<String> addPartnerStaffInfo(@RequestBody SysStaffDetailsDto  sysPartnerStaffDetailsDto) {
        try {
            sysPartnetDetailsService.insertPartnerStaff(sysPartnerStaffDetailsDto);
            return new RestResponse<>();
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.BUSINESS_UNKNOWN_ERROR,e.getMessage());
        }

    }*/



    /**
     * Description: 添加当前合作商管辖城市(合作商已无管辖城市相关业务)
    @ApiOperation(value = "添加当前合作商管辖城市", notes = "添加当前合作商管辖城市", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/partnerInfo/addPartnerCities", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sysPartnerCityRelaDto", value = "添加当前合作商管辖城市", required = true, paramType ="body", dataType = "SysPartnerCityRelaDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<String> addPartnerCitiesInfo(@RequestBody SysPartnerCityRelaDto sysPartnerCityRelaDto) {
        try {
            sysPartnetDetailsService.insertPartnerCities(sysPartnerCityRelaDto);
            return new RestResponse<>();
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.BUSINESS_UNKNOWN_ERROR,e.getMessage());
        }

    }*/



    /**
     * Description: 修改当前合作商人员信息
    @ApiOperation(value = "修改当前合作商人员信息", notes = "修改当前合作商人员信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/partnerInfo/modifyPartnerStaff", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sysPartnerStaffDetailsDto", value = "修改当前合作商人员信息", required = true, paramType ="body", dataType = "SysStaffDetailsDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<String> modifyPartnerStaffInfo(@RequestBody SysStaffDetailsDto  sysPartnerStaffDetailsDto) {
        try {
            sysPartnetDetailsService.updatePartnerStaff(sysPartnerStaffDetailsDto);
            return new RestResponse<>();
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.BUSINESS_UNKNOWN_ERROR,e.getMessage());
        }

    }*/



    /**
     * Description: 删除当前合作商城市信息(合作商已无城市信息相关)
    @ApiOperation(value = "删除当前合作商城市信息", notes = "删除当前合作商城市信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/partnerInfo/delPartnerCities", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sysPartnerCityDropDto", value = "删除当前合作商信息", required = true, paramType ="body", dataType = "SysPartnerCityDropDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<String> delPartnerCitiesInfo(@RequestBody SysPartnerCityDropDto sysPartnerCityDropDto) {
        try {
            sysPartnetDetailsService.dropPartnerCitiesMsg(sysPartnerCityDropDto);
            return new RestResponse<>();
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.BUSINESS_UNKNOWN_ERROR,e.getMessage());
        }

    }*/

    /**
     * Description: 删除当前合作商人员信息

    @ApiOperation(value = "删除当前合作商人员信息", notes = "删除当前合作商人员信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/partnerInfo/delPartnerStaff", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sysPartnerStaffDropDto", value = "删除当前合作商人员信息", required = true, paramType ="body", dataType = "SysPartnerStaffDropDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<String> delPartnerStaffInfo(@RequestBody SysPartnerStaffDropDto sysPartnerStaffDropDto) {
        try {
            sysPartnetDetailsService.dropPartnerStaffMsg(sysPartnerStaffDropDto);
            return new RestResponse<>();
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.BUSINESS_UNKNOWN_ERROR,e.getMessage());
        }

    }*/

    /**
     * Description: 查询当前合作商人员的门店信息
     */
    @ApiOperation(value = "查询当前合作商人员的门店信息", notes = "查询当前合作商人员的门店信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/partnerInfo/findStoreIdByStaff", method = RequestMethod.POST)
    @JsonPropFilter(type = String.class)
    public RestResponse<List<Long>> findStoreByCurrPartnerStaff() {
        try {
            List<Long> stores = sysPartnetDetailsService.findStoreIdByCurrPartnerStaff();
            return new RestResponse<>(stores);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.BUSINESS_UNKNOWN_ERROR);
        }

    }

    /**
     * Description: 自动接单所需负责人
     */
    @ApiOperation(value = "查询当前门店的管辖合作商人员最新的那个", notes = "查询当前门店的管辖合作商人员最新的那个", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/partnerInfo/findStaffIdByStoreByAuto", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sysPartnerStoreDto", value = "合作商门店信息", required = true, paramType ="body", dataType = "SysPartnerStoreDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<List<Long>> findPartnerStaffByStoreByAuto(@RequestBody SysPartnerStoreDto sysPartnerStoreDto) {
        try {
            List<Long> staff = sysPartnetDetailsService.findPartnerStaffIdByStoreByAuto(sysPartnerStoreDto.getStoreId(), sysPartnerStoreDto.getPartnerId());
            return new RestResponse<>(staff);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.BUSINESS_UNKNOWN_ERROR);
        }
    }

    /**
     * Description: 查询当前门店的管辖合作商人员
     */
    @ApiOperation(value = "查询当前门店的管辖合作商人员", notes = "查询当前门店的管辖合作商人员", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/partnerInfo/findStaffIdByStore", method = RequestMethod.POST)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "sysPartnerStoreDto", value = "合作商门店信息", required = true, paramType ="body", dataType = "SysPartnerStoreDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<List<Long>> findPartnerStaffByStore(@RequestBody SysPartnerStoreDto sysPartnerStoreDto) {
        try {
            List<Long> staff = sysPartnetDetailsService.findPartnerStaffIdByStore(sysPartnerStoreDto.getStoreId(), sysPartnerStoreDto.getPartnerId());
            return new RestResponse<>(staff);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.BUSINESS_UNKNOWN_ERROR);
        }
    }

    /**
     * Description: 查询当前门店的管辖合作商人员
     */
    @ApiOperation(value = "查询当前门店的管辖合作商人员", notes = "查询当前门店的管辖合作商人员", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/partnerInfo/findStaffId", method = RequestMethod.POST)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "sysPartnerStoreDto", value = "合作商门店信息", required = true, paramType ="body", dataType = "SysPartnerStoreDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<List<Long>> findPartnerStaff(@RequestBody SysPartnerStoreDto sysPartnerStoreDto) {
        try {
            List<Long> staff = sysPartnetDetailsService.findPartnerStaffId(sysPartnerStoreDto.getPartnerId());
            return new RestResponse<>(staff);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.BUSINESS_UNKNOWN_ERROR);
        }
    }
    /** ----------------------------------------分割------------------------------------------------**/

    /**
     * Description: 查询合作商信息列表
     */
    @ApiOperation(value = "查询合作商信息列表", notes = "查询合作商信息列表", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/partnerInfo/findPartner", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sysPartnerDetailsDto", value = "查询合作商信息", required = true, paramType ="body", dataType = "SysPartnerDetailsDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<PageInfo<SysPartnerDetailsDto>> findPartnerInfo(@RequestBody SysPartnerDetailsDto sysPartnerDetailsDto) {

        try {
            PageInfo<SysPartnerDetailsDto> page = sysPartnetDetailsService.queryPartnerMsg(sysPartnerDetailsDto);
            return new RestResponse<>(RestStatusCode.OK, page);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

    /**
     * Description: 添加合作商
     */
    @ApiOperation(value = "添加合作商", notes = "添加合作商", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/partnerInfo/addPartner", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sysPartnerDetailsDto", value = "合作商DTO", required = true, paramType ="body", dataType = "SysPartnerDetailsDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<String> addPartnerInfo(@RequestBody SysPartnerDetailsDto sysPartnerDetailsDto) {
        try {
            String partnerId = sysPartnetDetailsService.insertPartner(sysPartnerDetailsDto);
            return new RestResponse<>(RestStatusCode.OK, partnerId);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.BUSINESS_UNKNOWN_ERROR,e.getMessage());
        }
    }

    /**
     * Description: 修改合作商信息
     */
    @ApiOperation(value = "修改合作商信息", notes = "修改合作商信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/partnerInfo/modifyPartner", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sysPartnerDetailsDto", value = "修改合作商信息", required = true, paramType ="body", dataType = "SysPartnerDetailsDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<String> modifyPartnerInfo(@RequestBody SysPartnerDetailsDto sysPartnerDetailsDto) {
        try {
            sysPartnetDetailsService.updatePartner(sysPartnerDetailsDto);
            return new RestResponse<>();
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.BUSINESS_UNKNOWN_ERROR,e.getMessage());
        }

    }

    /**
     * Description: 删除当前合作商信息
     */
    @ApiOperation(value = "删除当前合作商信息", notes = "删除当前合作商信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/partnerInfo/delPartner", method = RequestMethod.DELETE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "partnerId", value = "当前合作商id", required = true, paramType ="query", dataType = "Long")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<String> delPartnerInfo(Long partnerId) {
        try {
            sysPartnetDetailsService.dropPartnerMsg(partnerId);
            return new RestResponse<>();
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.BUSINESS_UNKNOWN_ERROR,e.getMessage());
        }

    }

    /**
     * Description: 添加当前合作商人员
     */
    @ApiOperation(value = "添加当前合作商人员", notes = "添加当前合作商人员", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/partnerInfo/addParentUserInfo", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sysPartnerStaffDetailsDto", value = "添加当前合作商人员", required = true, paramType ="body", dataType = "SysPartnerStaffInfoInsertDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<String> addParentUserInfo(@RequestBody SysPartnerStaffInfoInsertDto sysPartnerStaffDetailsDto) {
        try {
            sysPartnetDetailsService.insertParentUserInfo(sysPartnerStaffDetailsDto);
            return new RestResponse<>(RestStatusCode.OK);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.BUSINESS_UNKNOWN_ERROR,e.getMessage());
        }
    }

    /**
     * Description: 更新当前合作商人员信息
     */
    @ApiOperation(value = "更新当前合作商人员信息", notes = "更新当前合作商人员信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/partnerInfo/updateParentUserInfo", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sysStaffDetailsDto", value = "最新合作商人员信息", required = true, paramType ="body", dataType = "SysPartnerStaffInfoInsertDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<String> updateParentUserInfo(@RequestBody SysPartnerStaffInfoInsertDto  sysStaffDetailsDto) {
        try {
            sysPartnetDetailsService.updateParentUserInfo(sysStaffDetailsDto);
            return new RestResponse<>(RestStatusCode.OK);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.BUSINESS_UNKNOWN_ERROR,e.getMessage());
        }

    }


    /**
     * Description: 删除当前合作商人员信息
     */
    @ApiOperation(value = "删除当前合作商人员信息", notes = "删除当前合作商人员信息", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/partnerInfo/deleteUserInfoById", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "partnerId", value = "当前合作商id", required = true, paramType ="query", dataType = "Long"),
            @ApiImplicitParam(name = "partyId", value = "人员id", required = true, paramType = "query", dataType = "Long")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<String> deleteUserInfoById(Long partnerId,Long partyId) {
        try {
            sysPartnetDetailsService.deleteUserInfoById(partnerId,partyId);
            return new RestResponse<>(RestStatusCode.OK);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.BUSINESS_UNKNOWN_ERROR,e.getMessage());
        }

    }

    /**
     * Description: 合作商管辖门店列表
     */
    @ApiOperation(value = "合作商管辖门店列表", notes = "合作商管辖门店列表", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/partnerInfo/findPartnerStorePage", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sysPartnerStaffDetailsDto", value = "合作商管辖门店列表", required = true, paramType ="body", dataType = "SysParentStoreQueryDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<PageInfo<SysStoreInfoDto>> findPartnerStorePage(@RequestBody SysParentStoreQueryDto sysPartnerStaffDetailsDto) {
        try {
            PageInfo<SysStoreInfoDto> page = sysPartnetDetailsService.findPartnerStorePage(sysPartnerStaffDetailsDto);
            return new RestResponse<>(RestStatusCode.OK, page);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

    /**
     * Description: 合作商管辖门店集合(提供给合作商详情里面的接口，取消分页限制)
     */
    @ApiOperation(value = "合作商管辖门店集合", notes = "合作商管辖门店列表", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/partnerInfo/getPartnerStoreList", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "partnerId", value = "合作商id", required = true, paramType ="query", dataType = "Long")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<List<SysStoreInfoDto>> getPartnerStoreList(@RequestParam Long partnerId) {
        try {
            List<SysStoreInfoDto> page = sysPartnetDetailsService.getPartnerStoreList(partnerId);
            return new RestResponse<>(RestStatusCode.OK, page);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

    /**
     * Description: 合作商添加门店列表页面
     */
    @ApiOperation(value = "合作商添加门店列表页面", notes = "合作商添加门店列表页面", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/partnerInfo/findAddPartnerStorePage", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sysPartnerStaffDetailsDto", value = "合作商管辖门店列表", required = true, paramType ="body", dataType = "SysParentStoreQueryDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<PageInfo<SysParentAddStoreListDto>> findAddPartnerStorePage(@RequestBody SysParentStoreQueryDto sysPartnerStaffDetailsDto) {
        try {
            PageInfo<SysParentAddStoreListDto> page = sysPartnetDetailsService.findAddPartnerStorePage(sysPartnerStaffDetailsDto);
            return new RestResponse<>(RestStatusCode.OK, page);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

    /**
     * Description: 修改合作商状态
     */
    @ApiOperation(value = "修改合作商状态", notes = "修改合作商状态", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/partnerInfo/modifyPartnerStatus", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sysPartnerStatusDto", value = "合作商状态", required = true, paramType ="body", dataType = "SysPartnerStatusDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<String> modifyPartnerStatus(@RequestBody SysPartnerStatusDto sysPartnerStatusDto) {
        try {
            sysPartnetDetailsService.modifyPartnerStatus(sysPartnerStatusDto);
            return new RestResponse<>(RestStatusCode.OK);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

    /**
     * Description: 批量修改合作商状态
     */
    @ApiOperation(value = "批量修改合作商状态", notes = "批量修改合作商状态", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/partnerInfo/batchModifyPartnerStatus", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sysPartnerStatusDto", value = "合作商状态", required = true, paramType ="body", dataType = "SysPartnerStatusDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<String> batchModifyPartnerStatus(@RequestBody SysPartnerStatusDto sysPartnerStatusDto) {
        try {
            sysPartnetDetailsService.batchModifyPartnerStatus(sysPartnerStatusDto);
            return new RestResponse<>(RestStatusCode.OK);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }


    /**
     * Description: 查询当前合作商人员名单
     */
    @ApiOperation(value = "查询当前合作商人员名单", notes = "查询当前合作商人员名单", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/partnerInfo/findPartnerStaffPage", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "staffQueryDto", value = "合作商门店信息", required = true, paramType ="body", dataType = "SysPartnerStaffQueryDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<PageInfo<SysPartnerStaffDetailsDto>> findPartnerStaffPage(@RequestBody SysPartnerStaffQueryDto staffQueryDto) {
        try {
            PageInfo<SysPartnerStaffDetailsDto> staff = sysPartnetDetailsService.findPartnerStaffPage(staffQueryDto);
            return new RestResponse<>(staff);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.BUSINESS_UNKNOWN_ERROR);
        }
    }

    /**
     * Description: 合作商人员名单删除
     * */
    @ApiOperation(value = "合作商人员名单删除", notes = "合作商人员名单删除", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/partnerInfo/deletePartnerStaffById", method = RequestMethod.DELETE)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "partnerId", value = "合作商id", required = true, paramType ="query", dataType = "Long"),
            @ApiImplicitParam(name = "partyId", value = "人员id", required = true, paramType ="query", dataType = "Long"),
            @ApiImplicitParam(name = "storeIds", value = "门店id(字符串，号分开)", required = true, paramType ="query", dataType = "Long")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<String> deletePartnerStaffById(@RequestParam Long partnerId,@RequestParam  Long partyId,@RequestParam  String storeIds) {
        try {
            sysPartnetDetailsService.deletePartnerStaffById(partnerId,partyId,storeIds);
            return new RestResponse<>(RestStatusCode.OK);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }


    /**
     * Description: 合作商添加门店
     */
    @ApiOperation(value = "合作商添加门店", notes = "合作商添加门店", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/partnerInfo/authorizeStore", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "storeAuthDto", value = "门店对象", required = true, paramType ="body", dataType = "SysPartnerStoreAuthDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<String> authorizeStore(@RequestBody SysPartnerStoreAuthDto storeAuthDto) {
        try {
            sysPartnetDetailsService.authorizeStore(storeAuthDto);
            return new RestResponse<>(RestStatusCode.OK);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR,e.getMessage());
        }
    }

    /**
     * Description: 合作商排名修改
     */
    @ApiOperation(value = "合作商排名修改", notes = "合作商排名修改", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/partnerInfo/updateSort", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sysPartnerDetailsDto", value = "添加合作商", required = true, paramType ="query", dataType = "SysPartnerDetailsDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<String> updateSort(@RequestParam String partnerId, @RequestParam Double sort) {
        try {
            sysPartnetDetailsService.updateSort(partnerId,sort);
            return new RestResponse<>(RestStatusCode.OK);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.BUSINESS_UNKNOWN_ERROR,e.getMessage());
        }
    }

}
