package com.exp.ucmp.store.web;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.egrid.core.json.body.JsonPropFilter;
import com.egrid.core.web.response.RestResponse;
import com.egrid.core.web.response.RestStatusCode;
import com.exp.ucmp.constant.Constants;
import com.exp.ucmp.dao.IJobReceiveInfoDao;
import com.exp.ucmp.entity.JobReceiveInfoEntity;
import com.exp.ucmp.entity.JobReceiveRspEntity;
import com.exp.ucmp.entity.SysStoreInfoEntity;
import com.exp.ucmp.pertner.dto.SysPartnerDetailsDto;
import com.exp.ucmp.staff.dto.PartyRoleRelaDto;
import com.exp.ucmp.store.dto.*;
import com.exp.ucmp.store.service.SysStoreDetailsService;
import com.exp.ucmp.store.service.SysStoreInfoService;
import com.exp.ucmp.xxljob.dao.IXxlJobDao;
import com.github.pagehelper.PageInfo;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;

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
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Objects;


/**
 * @author zhouchengwei
 * @date 2022年08月16日
 */

@Api(value = "门店信息相关接口", tags = "门店信息查询接口")
@RefreshScope
@Controller
public class SysStoreController {

    @Autowired
    private IXxlJobDao iXxlJobDao;

    @Autowired
    private SysStoreDetailsService sysStoreDetailsService;

    @Autowired
    private SysStoreInfoService sysStoreInfoService;

    @Autowired
    private IJobReceiveInfoDao iJobReceiveInfoDao;
    /**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(SysStoreController.class);



    /**
     * Description: 新增门店信息
     */
    @ApiOperation(value = "新增门店信息", notes = "门店信息相关接口", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/staffInfo/addStoreInfo", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sysStoreAddDto", value = "新增门店信息", required = true, paramType ="body", dataType = "SysStoreAddDto")
    })
    @ApiOperationSupport(order = 1)
    @JsonPropFilter(type = String.class)
    public RestResponse<String> addstoreStaffInfo(@RequestBody SysStoreAddDto sysStoreAddDto) {
        try {
            sysStoreDetailsService.insertStore(sysStoreAddDto);
            return new RestResponse<>();
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR,e.getMessage());
        }
    }

    /**
     * 定时器任务测试
     */
    @RequestMapping(value = "/api/staffInfo/test", method = RequestMethod.POST)
    @ApiOperationSupport(order = 2)
    @JsonPropFilter(type = String.class)
    public RestResponse<String> test() {
        try {
            //查询是否有拉取成功未读取的数据
            JobReceiveInfoEntity jobReceiveInfoEntity = new JobReceiveInfoEntity();
            jobReceiveInfoEntity.setReceiveTaskType(Constants.ReceiveTaskType.ORG_LIST_HANDLER.value());
            jobReceiveInfoEntity.setProcessingStatus(Constants.JobProcessingStatus.WAIT.value());
            jobReceiveInfoEntity.setJobType(Constants.JobType.SMP.value());
            List<JobReceiveRspEntity> rspList = iXxlJobDao.selectALLWaitRspStr(jobReceiveInfoEntity);
            if(CollectionUtils.isEmpty(rspList)){
                LOGGER.info("StoreInfoXxlJobHandler[门店管理]没有拉取到需要更新的门店数据....");
            }else{
                LOGGER.info("StoreInfoXxlJobHandler[门店管理]准备开始更新门店数据----");
                rspList.forEach(rsp->{
                    JSONObject jsonObject = JSON.parseObject(rsp.getReceiveRspData());
                    Object data = jsonObject.get("data");
                    if(!Objects.isNull(data) && jsonObject.get("msg").equals("SUCCESS")){
                        List<SysStoreInfoEntity> list  = JSON.parseArray(data.toString(),SysStoreInfoEntity.class);
                        //对数据进行更新
                        sysStoreInfoService.batchInsertorUpdate(list);
                    }
                    //更新接收表状态为已处理
                    JobReceiveInfoEntity jobReceiveInfo = new JobReceiveInfoEntity();
                    jobReceiveInfo.setReceiveId(rsp.getReceiveId());
                    jobReceiveInfo.setProcessingStatus(Constants.JobProcessingStatus.SUCCESS.value());
                    iJobReceiveInfoDao.updateSelective(jobReceiveInfo);
                });
            }
            return new RestResponse<>(RestStatusCode.OK);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR,e.getMessage());
        }
    }


    /**
     * Description: 分页查询门店列表
     */
    @ApiOperation(value = "分页查询门店列表", notes = "门店信息相关接口", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/storeInfo/findStore", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sysStoreInfoQueryDto", value = "查询门店列表", required = true, paramType ="body", dataType = "SysStoreInfoQueryDto")
    })
    @ApiOperationSupport(order = 3)
    @JsonPropFilter(type = String.class)
    public RestResponse<PageInfo<SysStoreInfoDto>> findStoreInfo(@RequestBody SysStoreInfoQueryDto sysStoreInfoQueryDto) {
        try {
            PageInfo<SysStoreInfoDto> page = sysStoreDetailsService.queryStoreMsg(sysStoreInfoQueryDto);
            return new RestResponse<>(RestStatusCode.OK, page);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

    /**
     * Description: 查询门店列表
     */
    @ApiOperation(value = "查询门店列表", notes = "门店信息相关接口", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/storeInfo/listStoreInfo", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sysStoreInfoQueryDto", value = "查询门店列表", required = true, paramType ="body", dataType = "SysStoreInfoQueryDto")
    })
    @ApiOperationSupport(order = 3)
    @JsonPropFilter(type = String.class)
    public RestResponse<List<SysStoreInfoDto>> listStoreInfo(@RequestBody SysStoreInfoQueryDto sysStoreInfoQueryDto) {
        try {
            List<SysStoreInfoDto> list = sysStoreDetailsService.listStoreInfo(sysStoreInfoQueryDto);
            return new RestResponse<>(RestStatusCode.OK, list);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

    @ApiOperation(value = "模糊查询门店列表", notes = "门店信息相关接口", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/storeInfo/findStoreByName", method = RequestMethod.POST)
    @ApiOperationSupport(order = 4)
    @JsonPropFilter(type = String.class)
    public RestResponse<List<SysFindStoreByNameDto>> findStoreByStoreName(@RequestBody SysFindStoreByNameParamsDto paramsDto) {
        try {
            List<SysFindStoreByNameDto> sysStoreInfoDtos = sysStoreDetailsService.queryStoreByStoreName(paramsDto);
            return new RestResponse<>(RestStatusCode.OK, sysStoreInfoDtos);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

    @ApiOperation(value = "模糊查询车商人员列表", notes = "门店信息相关接口", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/storeInfo/findPartnerByName", method = RequestMethod.GET)
    @ApiOperationSupport(order = 5)
    @JsonPropFilter(type = String.class)
    public RestResponse<List<SysFindPartnerByNameDto>> findPartnerByName(@RequestParam(value = "partnerName",required = false) String partnerName) {
        try {
            List<SysFindPartnerByNameDto> sysStoreInfoDtos = sysStoreDetailsService.queryPartnerByName(partnerName);
            return new RestResponse<>(RestStatusCode.OK, sysStoreInfoDtos);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

    /**
     * Description: 修改门店状态
     */
    @ApiOperation(value = "修改门店状态", notes = "门店信息相关接口", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/staffInfo/modifyStoreStatus", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sysStoreStatusDto", value = "修改门店状态", required = true, paramType ="body", dataType = "SysStoreStatusDto")
    })
    @ApiOperationSupport(order = 6)
    @JsonPropFilter(type = String.class)
    public RestResponse<String> modifyStoreStatusInfo(@RequestBody SysStoreStatusDto sysStoreStatusDto) {
        try {
            sysStoreDetailsService.modifyStoreStatus(sysStoreStatusDto);
            return new RestResponse<>(RestStatusCode.OK);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }
    /**
     * Description: 批量修改门店状态
     */
    @ApiOperation(value = "批量修改门店状态", notes = "门店信息相关接口", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/staffInfo/batchModifyStoreStatus", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sysStoreStatusDto", value = "修改门店状态", required = true, paramType ="body", dataType = "SysStoreStatusDto")
    })
    @ApiOperationSupport(order = 7)
    @JsonPropFilter(type = String.class)
    public RestResponse<String> batchModifyStoreStatus(@RequestBody SysStoreStatusDto sysStoreStatusDto) {
        try {
            sysStoreDetailsService.batchModifyStoreStatus(sysStoreStatusDto);
            return new RestResponse<>(RestStatusCode.OK);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }


    /**
     * Description: 修改门店人员状态
     */
    @ApiOperation(value = "修改门店人员状态", notes = "门店信息相关接口", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/staffInfo/modifyStoreStaffStatus", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sysStoreStaffStatusDto", value = "修改门店人员状态", required = true, paramType ="body", dataType = "SysStoreStaffStatusDto")
    })
    @ApiOperationSupport(order = 8)
    @JsonPropFilter(type = String.class)
    public RestResponse<String> modifyStoreStaffStatusInfo(@RequestBody SysStoreStaffStatusDto sysStoreStaffStatusDto) {
        try {
            sysStoreDetailsService.modifyStoreStaffStatus(sysStoreStaffStatusDto);
            return new RestResponse<>();
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

    /**
     * Description: 分页查询门店人员信息列表
     */
    @ApiOperation(value = "分页查询门店人员信息列表", notes = "门店信息相关接口", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/storeInfo/findStoreStaff", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sysStoreStaffInfoQueryDto", value = "查询门店人员信息列表", required = true, paramType ="body", dataType = "SysStoreStaffInfoQueryDto")
    })
    @ApiOperationSupport(order = 9)
    @JsonPropFilter(type = String.class)
    public RestResponse<PageInfo<SysStoreStaffInfoDto>> findStoreStaffInfo(@RequestBody SysStoreStaffInfoQueryDto sysStoreStaffInfoQueryDto) {
        try {
            PageInfo<SysStoreStaffInfoDto> page = sysStoreDetailsService.queryStoreStaff(sysStoreStaffInfoQueryDto);
            return new RestResponse<>(RestStatusCode.OK, page);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }

    }

    /**
     * Description: 查询门店人员信息列表
     */
    @ApiOperation(value = "查询门店人员信息列表", notes = "门店信息相关接口", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/storeInfo/listStoreStaffInfo", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sysStoreStaffInfoQueryDto", value = "查询门店人员信息列表", required = true, paramType ="body", dataType = "SysStoreStaffInfoQueryDto")
    })
    @ApiOperationSupport(order = 9)
    @JsonPropFilter(type = String.class)
    public RestResponse<List<SysStoreStaffInfoDto>> listStoreStaffInfo(@RequestBody SysStoreStaffInfoQueryDto sysStoreStaffInfoQueryDto) {
        try {
            List<SysStoreStaffInfoDto> list = sysStoreDetailsService.listStoreStaffInfo(sysStoreStaffInfoQueryDto);
            return new RestResponse<>(RestStatusCode.OK, list);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }

    }

    /**
     * Description: 查询门店下面的车商指定人信息
     */
    @ApiOperation(value = "查询门店下面的车商指定人信息", notes = "门店信息相关接口", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/storeInfo/findPartnerStaffInfo", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "storeId", value = "门店id", required = true, paramType ="query", dataType = "Long"),
            @ApiImplicitParam(name = "pageNum", value = "页数", required = true, paramType ="query", dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "行数", required = true, paramType ="query", dataType = "Integer")
    })
    @ApiOperationSupport(order = 10)
    @JsonPropFilter(type = String.class)
    public RestResponse<PageInfo<SysPartnerStaffInfoDto>> findPartnerStaffInfo(@RequestParam Long storeId,@RequestParam Integer pageNum,@RequestParam Integer pageSize) {
        try {
            PageInfo<SysPartnerStaffInfoDto> page = sysStoreDetailsService.findPartnerStaffInfo(storeId,pageNum,pageSize);
            return new RestResponse<>(RestStatusCode.OK, page);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

    /**
     * Description: 查询门店上面的车商信息
     */
    @ApiOperation(value = "查询门店上面的车商信息", notes = "门店信息相关接口", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/storeInfo/findPartnerDetails", method = RequestMethod.GET)
    @ApiOperationSupport(order = 11)
    @JsonPropFilter(type = String.class)
    public RestResponse<PageInfo<SysPartnerDetailsDto>> findPartnerDetails(@RequestParam Long storeId,@RequestParam Integer pageNum,@RequestParam Integer pageSize) {
        try {
            PageInfo<SysPartnerDetailsDto> partnerDetails = sysStoreDetailsService.findPartnerDetails(storeId, pageNum, pageSize);
            return new RestResponse<>(RestStatusCode.OK, partnerDetails);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

    /**
     * Description: 服务车商状态更改
     */
    @ApiOperation(value = "服务车商状态更改", notes = "门店信息相关接口", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/staffInfo/modifyPartnerStatus", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "relaId", value = "主键id", required = true, paramType ="query", dataType = "Long"),
            @ApiImplicitParam(name = "isEnable", value = "是否可用00、无效，01、有效", required = true, paramType ="query", dataType = "String")
    })
    @ApiOperationSupport(order = 12)
    @JsonPropFilter(type = String.class)
    public RestResponse<String> modifyPartnerStatus(@RequestParam Long relaId,@RequestParam String isEnable) {
        try {
            sysStoreDetailsService.modifyPartnerStatus(relaId,isEnable);
            return new RestResponse<>();
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }


    /**
     * Description: 车商指定人状态更改
     */
    @ApiOperation(value = "车商指定人状态更改", notes = "门店信息相关接口", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/staffInfo/modifyPartnerStaffStatus", method = RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "relaId", value = "主键id", required = true, paramType ="query", dataType = "Long"),
            @ApiImplicitParam(name = "isEnable", value = "是否可用00、无效，01、有效", required = true, paramType ="query", dataType = "String")
    })
    @ApiOperationSupport(order = 13)
    @JsonPropFilter(type = String.class)
    public RestResponse<String> modifyPartnerStaffStatus(@RequestParam Long relaId,@RequestParam String isEnable) {
        try {
            sysStoreDetailsService.modifyPartnerStaffStatus(relaId,isEnable);
            return new RestResponse<>();
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }
    /**
     * Description: 门店人员角色维护
     */
    @ApiOperation(value = "门店人员角色维护", notes = "门店信息相关接口", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/staffInfo/editStoreStaffRole", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "partyRoleRelaDto", value = "人员角色维护", required = true, paramType ="body", dataType = "PartyRoleRelaDto")
    })
    @ApiOperationSupport(order = 14)
    @JsonPropFilter(type = String.class)
    public RestResponse<String> editStoreStaffRole(@RequestBody PartyRoleRelaDto partyRoleRelaDto) {
        try {
            sysStoreDetailsService.editStoreStaffRole(partyRoleRelaDto);
            return new RestResponse<>(RestStatusCode.OK);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR,e.getMessage());
        }
    }

    /**
     * Description: 临时接口，补充门店t_party_relationship表关系数据
     */
    @RequestMapping(value = "/api/staffInfo/testStoreRelationship", method = RequestMethod.POST)
    @ApiOperationSupport(order = 15)
    @JsonPropFilter(type = String.class)
    public RestResponse<String> testStoreRelationship() {
        try {
            sysStoreDetailsService.testStoreRelationship();
            return new RestResponse<>(RestStatusCode.OK);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }
    
    /**
     * Description: 查询交付中心列表
     */
    @ApiOperation(value = "查询交付中心列表", notes = "交付中心信息相关接口", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/delivery/center/list", method = RequestMethod.GET)
    @ApiOperationSupport(order = 16)
    @ApiImplicitParams({@ApiImplicitParam(name = "storeName", value = "交付中心名称", required = false, paramType ="query", dataType = "String")})
    @JsonPropFilter(type = DeliveryCenterDto.class)
    public RestResponse<List<DeliveryCenterDto>> findDeliveryCenter(@RequestParam(value="storeName",required=false) String storeName ) {
        try {
        	List<DeliveryCenterDto> list = sysStoreDetailsService.findDeliveryCenter(storeName);
            return new RestResponse<>(RestStatusCode.OK, list);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

    /**
     * Description: 修改门店官二资质状态
     */
    @ApiOperation(value = "修改门店官二资质状态", notes = "门店信息相关接口", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/staffInfo/modifyQualificationStatus", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sysStoreStatusDto", value = "修改门店状态", required = true, paramType ="body", dataType = "SysStoreStatusDto")
    })
    @ApiOperationSupport(order = 6)
    @JsonPropFilter(type = String.class)
    public RestResponse<String> modifyQualificationStatus(@RequestBody SysStoreStatusDto sysStoreStatusDto) {
        try {
            String result = sysStoreDetailsService.modifyQualificationStatus(sysStoreStatusDto);
            return new RestResponse<>(RestStatusCode.OK,result);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

    /**
     * Description: 批量修改门店官二资质状态
     */
    @ApiOperation(value = "批量修改门店官二资质状态", notes = "门店信息相关接口", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/staffInfo/batchQualificationStatus", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sysStoreStatusDto", value = "修改门店官二资质状态", required = true, paramType ="body", dataType = "SysStoreStatusDto")
    })
    @ApiOperationSupport(order = 7)
    @JsonPropFilter(type = String.class)
    public RestResponse<String> batchQualificationStatus(@RequestBody SysStoreStatusDto sysStoreStatusDto) {
        try {
            sysStoreDetailsService.batchQualificationStatus(sysStoreStatusDto);
            return new RestResponse<>(RestStatusCode.OK);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

    /**
     * Description: 修改门店人员官二资质状态
     */
    @ApiOperation(value = "修改门店人员官二资质状态", notes = "门店信息相关接口", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/staffInfo/modifyStoreStaffQualificationStatus", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sysStoreStaffQualificationStatusDto", value = "修改门店人员官二资质状态", required = true, paramType ="body", dataType = "SysStoreStaffQualificationStatusDto")
    })
    @ApiOperationSupport(order = 8)
    @JsonPropFilter(type = String.class)
    public RestResponse<String> modifyStoreStaffQualificationStatus(@RequestBody SysStoreStaffQualificationStatusDto sysStoreStaffQualificationStatusDto) {
        try {
            String result = sysStoreDetailsService.modifyStoreStaffQualificationStatus(sysStoreStaffQualificationStatusDto);
            return new RestResponse<>(RestStatusCode.OK,result);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

}
