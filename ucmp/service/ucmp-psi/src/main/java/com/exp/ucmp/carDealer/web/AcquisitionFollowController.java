package com.exp.ucmp.carDealer.web;

import cn.hutool.core.io.IoUtil;
import com.egrid.core.base.id.RandomIDGennerator;
import com.egrid.core.json.body.JsonPropFilter;
import com.egrid.core.web.response.RestResponse;
import com.egrid.core.web.response.RestStatusCode;
import com.exp.ucmp.carDealer.dto.*;
import com.exp.ucmp.carDealer.service.AcquisitionFollowService;
import com.exp.ucmp.carDealer.service.HwObsService;
import com.exp.ucmp.carDealer.util.FileUtil;
import com.exp.ucmp.config.HwOBSConfig;
import com.exp.ucmp.entity.PsiBusinessNodesMaterialEntity;
import com.exp.ucmp.file.dto.MaterialParamDto;
import com.github.pagehelper.PageInfo;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.obs.services.exception.ObsException;
import io.swagger.annotations.*;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;


/**
 * @author GeYiJiang
 * @Description: 收购
 * @date 2022/10/16 10:44
 */
@Api(value = "AcquisitionFollow.API", tags = "询价单收购相关的接口")
@Controller
public class AcquisitionFollowController {
    /**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(AcquisitionFollowController.class);

    @Autowired
    private AcquisitionFollowService acquisitionFollowService;

    @Autowired
    private HwObsService hwObsService;

    @ApiOperation(value = "Old 查询收购相关的询价单", notes = "查询收购相关的询价单", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/acquisition/acquisitionStatus/query", method = RequestMethod.POST)
    @ApiOperationSupport(order = 1)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "paramDto", value = "查询条件(分页)", required = true, paramType ="body", dataType = "AcquisitionQueryParamDto")
    })
    @JsonPropFilter(type = PageInfo.class)
    public RestResponse<PageInfo<AcquisitionQueryResultDto>> queryAcquisitionUnAcquired(@RequestBody AcquisitionQueryParamDto paramDto){
        try {
            PageInfo<AcquisitionQueryResultDto> pageInfo = null;
            if (AcquisitionQueryParamDto.AcquisitionQueryTypeEnum.acquisitionUnAcquired.name().equals(paramDto.getAcquisitionQueryType())){
                pageInfo = acquisitionFollowService.queryUnAcquired(paramDto);
            }else if(AcquisitionQueryParamDto.AcquisitionQueryTypeEnum.acquisitionUnNegotiated.name().equals(paramDto.getAcquisitionQueryType())){
                pageInfo = acquisitionFollowService.queryUnNegotiated(paramDto);
            }else if(AcquisitionQueryParamDto.AcquisitionQueryTypeEnum.acquisitionAcquired.name().equals(paramDto.getAcquisitionQueryType())){
                pageInfo = acquisitionFollowService.queryAcquired(paramDto);
            }else if(AcquisitionQueryParamDto.AcquisitionQueryTypeEnum.acquisitionNotAcquired.name().equals(paramDto.getAcquisitionQueryType())){
                pageInfo = acquisitionFollowService.queryNotAcquired(paramDto);
            }
                if (pageInfo == null) {
                throw new Exception("查询时提供的AcquisitionQueryType不正确");
            } else {
                LOGGER.info("欲返回的内容{}", pageInfo.getList());
                return new RestResponse<>(RestStatusCode.OK, pageInfo);
            }
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }

    @ApiOperation(value = "Old 放弃收购", notes = "放弃收购",produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/acquisition/abandonAcquisition", method = RequestMethod.POST)
    @ApiOperationSupport(order = 2)
    @ApiImplicitParam(name = "paramDto", value = "查询条件", required = true, paramType ="body", dataType = "AbandonAcquisitionQueryParamDto")
    @JsonPropFilter(type = Boolean.class)
    public RestResponse<Boolean> abandonAcquisition(@RequestBody AbandonAcquisitionQueryParamDto paramDto){
        try {
            boolean result = acquisitionFollowService.abandonAcquisition(paramDto.getReservationId(),paramDto.getAcquisitionAbandonedReason());
            return new RestResponse<>(RestStatusCode.OK, result);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }

    @ApiOperation(value = "New 查询收购相关的询价单", notes = "New 查询收购相关的询价单", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/acquisition/acquisitionStatus/newQuery", method = RequestMethod.POST)
    @ApiOperationSupport(order = 3)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "paramDto", value = "查询条件(分页)", required = true, paramType ="body", dataType = "AcquisitionQueryParamDto")
    })
    @JsonPropFilter(type = PageInfo.class)
    public RestResponse<PageInfo<AcquisitionQueryResultDto>> newQueryAcquisitionUnAcquired(@RequestBody AcquisitionQueryParamDto paramDto)  {
        try {
            PageInfo<AcquisitionQueryResultDto> pageInfo = null;
            //待收购
            if (AcquisitionQueryParamDto.AcquisitionQueryTypeEnum.acquisitionUnAcquired.name().equals(paramDto.getAcquisitionQueryType())){
                pageInfo = acquisitionFollowService.newQueryUnAcquired(paramDto);
            }//待过户
            else if(AcquisitionQueryParamDto.AcquisitionQueryTypeEnum.unTransfer.name().equals(paramDto.getAcquisitionQueryType())){
                pageInfo = acquisitionFollowService.queryUnTransfer(paramDto);
            }//已完成
            else if(AcquisitionQueryParamDto.AcquisitionQueryTypeEnum.completed.name().equals(paramDto.getAcquisitionQueryType())){
                pageInfo = acquisitionFollowService.QueryCompleted(paramDto);
            }//已上报
            else if(AcquisitionQueryParamDto.AcquisitionQueryTypeEnum.reported.name().equals(paramDto.getAcquisitionQueryType())){
                pageInfo = acquisitionFollowService.QueryReported(paramDto);
            }//关闭失效
            else if(AcquisitionQueryParamDto.AcquisitionQueryTypeEnum.closedOrInvalid.name().equals(paramDto.getAcquisitionQueryType())){
                pageInfo = acquisitionFollowService.QueryClosedOrInvalid(paramDto);
            }//驳回处理
            else if(AcquisitionQueryParamDto.AcquisitionQueryTypeEnum.rejected.name().equals(paramDto.getAcquisitionQueryType())){
                pageInfo = acquisitionFollowService.queryRejected(paramDto);
            }
            if (pageInfo == null) {
                throw new Exception("查询时提供的AcquisitionQueryType不正确");
            } else {
                LOGGER.info("欲返回的内容{}", pageInfo.getList());
                return new RestResponse<>(RestStatusCode.OK, pageInfo);
            }
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }

    @ApiOperation(value = "New 放弃收购", notes = "NEW 放弃收购",produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/acquisition/newAbandonAcquisition", method = RequestMethod.POST)
    @ApiOperationSupport(order = 4)
    @ApiImplicitParam(name = "paramDto", value = "查询条件", required = true, paramType ="body", dataType = "AbandonAcquisitionQueryParamDto")
    @JsonPropFilter(type = Boolean.class)
    public RestResponse<Boolean> newAbandonAcquisition(@RequestBody AbandonAcquisitionQueryParamDto paramDto){
        try {
            boolean result = acquisitionFollowService.newAbandonAcquisition(paramDto.getReservationId(),paramDto.getAcquisitionAbandonedReason());
            return new RestResponse<>(RestStatusCode.OK, result);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }

    /**
     * 收购详情
     */
    @ApiOperation(value = "收购详情", notes = "收购详情",produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/acquisition/acquisitionDetail", method = RequestMethod.POST)
    @JsonPropFilter(type = AcquisitionDetailsDto.class)
    @ApiOperationSupport(order = 5)
    @ApiImplicitParam(name = "acquisitionDetailQueryDto", value = "查询条件", required = true, paramType ="body", dataType = "AcquisitionDetailQueryDto")
    public RestResponse<AcquisitionDetailsDto> acquisitionDetail(@RequestBody AcquisitionDetailQueryDto acquisitionDetailQueryDto){
        try {
            AcquisitionDetailsDto acquisitionDetails = acquisitionFollowService.acquisitionDetails(acquisitionDetailQueryDto.getReservationId());
            return new RestResponse<>(RestStatusCode.OK, acquisitionDetails);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }

    /**
     * 返回业务节点数据
     */
    @ApiOperation(value = "返回业务节点数据", notes = "返回业务节点数据",produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/acquisition/businessNodesMaterial", method = RequestMethod.POST)
    @ApiOperationSupport(order = 6)
    @ApiImplicitParam(name = "businessNodesQueryDto", value = "查询条件", required = true, paramType ="body", dataType = "BusinessNodesQueryDto")
    @JsonPropFilter(type = PageInfo.class)
    public RestResponse<PageInfo<PsiBusinessNodesMaterialEntity>> queryBusinessNodesMaterial(@RequestBody BusinessNodesQueryDto businessNodesQueryDto){
        try {
            PageInfo<PsiBusinessNodesMaterialEntity> pageInfo = acquisitionFollowService.queryBusinessNodesMaterialEntity(businessNodesQueryDto);
            if (pageInfo == null) {
                throw new Exception("查询时提供的businessNodesQueryDto不正确");
            } else {
                LOGGER.info("欲返回的内容{}", pageInfo.getList());
                return new RestResponse<>(RestStatusCode.OK, pageInfo);
            }
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }

    @ApiOperation(value = "文件删除", notes = "文件删除",produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/acquisition/batchDeleteFile", method = RequestMethod.POST)
    @ApiOperationSupport(order = 7)
    @ApiImplicitParam(name = "paramDto", value = "查询条件", required = true, paramType ="body", dataType = "BatchDeleteFileDto")
    @JsonPropFilter(type = Boolean.class)
    public RestResponse<Boolean> batchDeleteFile(@RequestBody BatchDeleteFileDto paramDto){
        try {
            Boolean deleteFile = acquisitionFollowService.batchDeleteFile(paramDto);
            return new RestResponse<>(RestStatusCode.OK, deleteFile);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }

    @ApiOperation(value = "文件上传", notes = "文件上传", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/acquisition/file/upload", method = RequestMethod.POST)
    @ApiOperationSupport(order = 8)
    @JsonPropFilter(type = Long.class)
    public RestResponse<Long> thumbnailUpload(
            @RequestParam("file") MultipartFile file,
            @RequestParam("reservationId") String reservationId,
            @RequestParam("materialType") String materialType,
            @RequestParam("materialOrder") Integer materialOrder
    ) throws IOException {
        Long materialFileId = RandomIDGennerator.get().generate();
        String objKey = HwOBSConfig.getObjectKey() + materialFileId.toString()+"/"+file.getOriginalFilename();
        //存入华为obs
        hwObsService.fileUpload(file,objKey);
        //压缩并转base64
        String compressToBASE64 = FileUtil.compressToBASE64(file);

        MaterialParamDto paramDto = new MaterialParamDto();
        paramDto.setMaterialType(materialType);
        paramDto.setMaterialOrder(materialOrder);
        paramDto.setReservationId(Long.parseLong(reservationId));
        paramDto.setThumbnailFile(compressToBASE64);
        paramDto.setOriginalFilename(file.getOriginalFilename());
        paramDto.setContentType(file.getContentType());
        paramDto.setObjKey(objKey);
        Long fileId = acquisitionFollowService.savaMaterials(paramDto);

        return new RestResponse<>(fileId);
    }

    @ApiOperation(value = "文件下载", notes = "文件下载", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/acquisition/file/download", method = RequestMethod.GET)
    @ApiOperationSupport(order = 9)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "fileId", value = "文件id", required = false, paramType ="query", dataType = "String"),
        @ApiImplicitParam(name = "materialId", value = "材料文件ID", required = false, paramType ="query", dataType = "String")
    })
    @JsonPropFilter(type = Long.class)
    public RestResponse<Long> thumbnailUpload1(HttpServletRequest request, HttpServletResponse response,
           @RequestParam(value="fileId",required=false) String fileId,@RequestParam(value="materialId",required=false) String materialId){
        String objKey = acquisitionFollowService.getObjKey(fileId,materialId);
        try (InputStream inputStream = hwObsService.fileDownload(objKey);
             BufferedOutputStream outputStream = new BufferedOutputStream(response.getOutputStream())){
            // 为防止 文件名出现乱码
            final String userAgent = request.getHeader("USER-AGENT");
            // IE浏览器
            if (StringUtils.contains(userAgent, "MSIE")) {
                objKey = URLEncoder.encode(objKey, "UTF-8");
            } else {
                // google,火狐浏览器
                if (StringUtils.contains(userAgent, "Mozilla")) {
                    objKey = new String(objKey.getBytes(), "ISO8859-1");
                } else {
                    // 其他浏览器
                    objKey = URLEncoder.encode(objKey, "UTF-8");
                }
            }
            IoUtil.copy(inputStream, outputStream);
            return null;
        } catch (ObsException | IOException e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
        return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
    }

    @ApiOperation(value = "收购材料上报", notes = "收购材料上报", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/acquisition/acquisitionMaterialUpload", method = RequestMethod.POST)
    @ApiOperationSupport(order = 10)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "paramDto", value = "材料参数", required = true, paramType ="body", dataType = "AcquisitionMaterialUploadDto")
    })
    @JsonPropFilter(type = Boolean.class)
    public RestResponse<Boolean> acquisitionMaterialUpload(@RequestBody AcquisitionMaterialUploadDto paramDto){
        Boolean status = acquisitionFollowService.saveAcquisitionMaterial(paramDto);
        return new RestResponse<>(status);
    }

    @ApiOperation(value = "更新询价表审批状态", notes = "更新询价表审批状态", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/acquisition/updateInquiryApprovalStatus", method = RequestMethod.POST)
    @ApiOperationSupport(order = 11)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "paramDto", value = "更新询价表审批状态参数", required = true, paramType ="body", dataType = "UpdateInquiryApprovalStatusDto")
    })
    @JsonPropFilter(type = Boolean.class)
    public RestResponse<Boolean> updateInquiryApprovalStatus(@RequestBody UpdateInquiryApprovalStatusDto paramDto){
        Boolean status = acquisitionFollowService.updateInquiryApprovalStatus(paramDto.getReservationId(),paramDto.getApprovalStatus());
        return new RestResponse<>(status);
    }

    @ApiOperation(value = "本品收购-分配交付中心", notes = "本品收购-分配交付中心",produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/allot/delivery/center", method = RequestMethod.POST)
    @ApiOperationSupport(order = 12)
    @ApiImplicitParam(name = "paramDto", value = "分配参数", required = true, paramType ="body", dataType = "AllotDeliveryCenterDto")
    @JsonPropFilter(type = Boolean.class)
    public RestResponse<Boolean> allotDeliveryCenter(@RequestBody @Valid AllotDeliveryCenterDto paramDto){
        try {
            boolean result = acquisitionFollowService.allotDeliveryCenter(paramDto);
            return new RestResponse<>(RestStatusCode.OK, result);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }
}
