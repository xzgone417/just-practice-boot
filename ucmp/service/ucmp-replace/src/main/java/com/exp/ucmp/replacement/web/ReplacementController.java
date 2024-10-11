package com.exp.ucmp.replacement.web;

import com.egrid.core.json.body.JsonPropFilter;
import com.egrid.core.util.JsonBeanUtil;
import com.egrid.core.web.response.RestResponse;
import com.egrid.core.web.response.RestStatusCode;
import com.exp.ucmp.carDealer.dto.AcquisitionAllFileDto;
import com.exp.ucmp.carDealer.dto.SaveTransactionPriceDto;
import com.exp.ucmp.carService.dto.OneselfApproveDto;
import com.exp.ucmp.carService.dto.OneselfPutIntoStorageDto;
import com.exp.ucmp.eos.dto.ReservationDto;
import com.exp.ucmp.replacement.dto.*;
import com.exp.ucmp.replacement.service.ReplacementService;
import com.exp.ucmp.storeApp.dto.OneselfAssessPicsDto;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

@Api(value = "ReplacementController.API", tags = "置换审批列表查询")
@RefreshScope
@Controller
public class ReplacementController {

    @Autowired
    private ReplacementService replacementService;

    /**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ReplacementController.class);



    /**
     * Description: 查询置换审批列表
     */
    @ApiOperation(value = "查询置换审批列表", notes = "查询置换审批列表", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/replacement/findReplacement", method = RequestMethod.POST)
    @ApiOperationSupport(order = 1)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "repReplacementApprovalDto", value = "查询置换审批列表", required = true, paramType ="body", dataType = "RepReplacementApprovalDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<PageInfo<RepReplacementApprovalReturnDto>> findReplacementApprovalInfo(@RequestBody RepReplacementApprovalDto repReplacementApprovalDto) {

        try {
            PageInfo<RepReplacementApprovalReturnDto> page = replacementService.queryReplaceApproval(repReplacementApprovalDto);

            return new RestResponse<>(RestStatusCode.OK, page);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

    /**
     * Description: 查询旧车确认列表
     */
    @ApiOperation(value = "查询旧车确认列表", notes = "查询旧车确认列表", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/replacement/findOldConfirm", method = RequestMethod.POST)
    @ApiOperationSupport(order = 2)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "repReplacementApprovalDto", value = "查询置换审批列表", required = true, paramType ="body", dataType = "RepReplacementApprovalDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<PageInfo<RepReplacementApprovalReturnDto>> findOldConfirmInfo(@RequestBody RepReplacementApprovalDto repReplacementApprovalDto) {

        try {
            PageInfo<RepReplacementApprovalReturnDto> page = replacementService.queryOldConfirm(repReplacementApprovalDto);

            return new RestResponse<>(RestStatusCode.OK, page);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

    /**
     * Description: 新车信息查询
     */
    @ApiOperation(value = "新车信息查询", notes = "新车信息查询", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/replacement/findNewCar", method = RequestMethod.POST)
    @ApiOperationSupport(order = 3)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "newCarQueryDto", value = "新车信息查询", required = true, paramType ="body", dataType = "NewCarQueryDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<List<PsiNewCarOrderDto>> findNewCarInfo(@RequestBody NewCarQueryDto newCarQueryDto) {

        try {
            List<PsiNewCarOrderDto> newCarOrder = replacementService.queryNewCar(newCarQueryDto);

            return new RestResponse<>(RestStatusCode.OK, newCarOrder);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

    /**
     * Description: 旧车信息查询
     */
    @ApiOperation(value = "旧车信息查询", notes = "旧车信息查询", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/replacement/findOldCar", method = RequestMethod.POST)
    @ApiOperationSupport(order = 4)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "psiCustomerCarsQueryDto", value = "旧车信息查询", required = true, paramType ="body", dataType = "PsiCustomerCarsQueryDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<List<PsiCustomerCarsDto>> findOldCarInfo(@RequestBody PsiCustomerCarsQueryDto psiCustomerCarsQueryDto) {

        try {
            List<PsiCustomerCarsDto> oldCar = replacementService.queryOldCar(psiCustomerCarsQueryDto);

            return new RestResponse<>(RestStatusCode.OK, oldCar);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }


    /**
     * Description: 材料文件列表
     */
    @ApiOperation(value = "材料文件列表", notes = "材料文件列表", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/replacement/findMaterialList", method = RequestMethod.POST)
    @ApiOperationSupport(order = 5)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "repReplacementMaterialQueryDto", value = "材料文件列表", required = true, paramType ="body", dataType = "RepReplacementMaterialQueryDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<List<RepReplacementMaterialDto>> findMaterialListInfo(@RequestBody RepReplacementMaterialQueryDto repReplacementMaterialQueryDto) {
        try {
            List<RepReplacementMaterialDto> repReplacementMaterialDtos = replacementService.materialSort(repReplacementMaterialQueryDto);
            return new RestResponse<>(RestStatusCode.OK, repReplacementMaterialDtos);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }


    /**
     * Description: 文件列表
     */
    @ApiOperation(value = "文件列表", notes = "文件列表", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/replacement/findFileList", method = RequestMethod.POST)
    @ApiOperationSupport(order = 6)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sysFileMsgQueryDto", value = "文件列表", required = true, paramType ="body", dataType = "SysFileMsgQueryDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<List<SysFileMsgDto>> findFileListInfo(@RequestBody SysFileMsgQueryDto sysFileMsgQueryDto) {
        try {
            List<SysFileMsgDto> sysFileMsgDtos = replacementService.queryFileList(sysFileMsgQueryDto);
            return new RestResponse<>(RestStatusCode.OK, sysFileMsgDtos);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }


    /**
     * Description: 审批/旧车确认
     */
    @ApiOperation(value = "审批/旧车确认", notes = "审批/旧车确认", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/replacement/approval", method = RequestMethod.POST)
    @ApiOperationSupport(order = 7)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "approvalUpdateDto", value = "审批/旧车确认", required = true, paramType ="body", dataType = "ApprovalUpdateDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<String> approvalOperation(@RequestBody ApprovalUpdateDto approvalUpdateDto) {
        try {
            replacementService.approval(approvalUpdateDto);
            return new RestResponse<>(RestStatusCode.OK);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR,e.getMessage());
        }
    }


    /**
     * Description: 审批历史记录
     */
    @ApiOperation(value = "审批历史记录", notes = "审批历史记录", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/replacement/approvalHistory", method = RequestMethod.POST)
    @ApiOperationSupport(order = 8)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "approvalHistoryDto", value = "审批历史记录", required = true, paramType ="body", dataType = "ApprovalHistoryDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<List<RepReplacementApprovalRecordDto>> approvalHistoryInfo(@RequestBody ApprovalHistoryDto approvalHistoryDto) {
        try {
            List<RepReplacementApprovalRecordDto> repReplacementApprovalRecordDtos = replacementService.queryApprovalHistory(approvalHistoryDto);
            return new RestResponse<>(RestStatusCode.OK,repReplacementApprovalRecordDtos);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

    /**
     * Description: 置换单查询
     */
    @ApiOperation(value = "他品本品置换单查询", notes = "他品本品置换单查询", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/replacement/replacementOrder", method = RequestMethod.POST)
    @ApiOperationSupport(order = 9)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "paramsDto", value = "置换单查询", required = true, paramType ="body", dataType = "ReplacementOrderQueryParamsDto")
    })
    @JsonPropFilter(type = PageInfo.class)
    public RestResponse<PageInfo<ReplacementOrderQueryDto>> selectReplacementOrder(@RequestBody ReplacementOrderQueryParamsDto paramsDto) {
        try {
        	LOGGER.info("======置换单查询参数======="+JsonBeanUtil.beanToJson(paramsDto));
            PageInfo<ReplacementOrderQueryDto> replacementOrderQueryDtoPageInfo = replacementService.selectReplacementOrder(paramsDto);
            return new RestResponse<>(RestStatusCode.OK,replacementOrderQueryDtoPageInfo);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

    /**
     * Description: 导出置换单查询
     */
    @ApiOperation(value = "导出他品本品置换单查询", notes = "导出他品本品置换单查询", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    @RequestMapping(value = "/api/v1/replacement/replacementOrderExport", method = RequestMethod.POST)
    @ApiOperationSupport(order = 10)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "paramsDto", value = "导出置换单查询", required = true, paramType ="body", dataType = "ReplacementOrderQueryParamsDto")
    })
    @JsonPropFilter(type = PageInfo.class)
    public void replacementOrderExport(@RequestBody ReplacementOrderQueryParamsDto paramsDto, HttpServletResponse response) {
//            replacementService.replacementOrderExport(paramsDto,response);
    	try{
    		replacementService.replacementOrderExportNew(paramsDto,response);
    	}catch (Exception e) {
    		LOGGER.error("===导出置换单查询异常===",e);;
		}
            
    }

    /**
     * Description: 导出置换审批
     */
    @ApiOperation(value = "导出置换审批", notes = "导出置换审批", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/replacement/replacementApprovalExport", method = RequestMethod.POST)
    @ApiOperationSupport(order = 11)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "paramsDto", value = "导出置换单查询", required = true, paramType ="body", dataType = "RepReplacementApprovalDto")
    })
    @JsonPropFilter(type = PageInfo.class)
    public void replacementApprovalExport(@RequestBody RepReplacementApprovalDto paramsDto, HttpServletResponse response) throws IOException, ParseException {
           replacementService.replacementApprovalExport(paramsDto,response);
    }
    
    /**
     * Description: 根据预约单id查询置换单详情
     */
    @ApiOperation(value = "他品置换单详情", notes = "他品置换单详情", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/replacement/details", method = RequestMethod.GET)
    @ApiOperationSupport(order = 12)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "reservationId", value = "预约单id", required = true, paramType ="query", dataType = "Long")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<ReplaceDetailsDto> getReplaceDetails(@RequestParam("reservationId") Long  reservationId) {
        try {
        	ReplaceDetailsDto dto = replacementService.getReplaceDetails(reservationId);
            return new RestResponse<>(RestStatusCode.OK,dto);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }
    
    /**
     * Description: 根据预约单id查询置换单图片
     */
    @ApiOperation(value = "置换单详情图片", notes = "置换单详情图片", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/replacement/detailsPic", method = RequestMethod.GET)
    @ApiOperationSupport(order = 13)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "reservationId", value = "预约单id", required = true, paramType ="query", dataType = "Long")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<List<AcquisitionAllFileDto>> getReplaceDetailsPic(@RequestParam("reservationId") Long  reservationId) {
        try {
            List<AcquisitionAllFileDto> list = replacementService.getReplaceDetailsPic(reservationId);
            return new RestResponse<>(RestStatusCode.OK,list);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

    /**
     * Description: 置换单激活
     */
    @ApiOperation(value = "置换单激活", notes = "置换单激活", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/replacement/activate", method = RequestMethod.GET)
    @ApiOperationSupport(order = 14)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "reservationId", value = "预约单id", required = true, paramType ="query", dataType = "Long")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<Boolean> activate(@RequestParam("reservationId") Long  reservationId) {
        try {
        	LOGGER.info("====置换单激活===="+reservationId);
            return new RestResponse<>(RestStatusCode.OK,replacementService.activate(reservationId));
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }
    
    @ApiOperation(value = "本品置换图片", notes = "本品置换图片", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/replacement/hipi/detailsPic", method = RequestMethod.GET)
    @ApiOperationSupport(order = 15)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "reservationId", value = "预约单id", required = true, paramType ="query", dataType = "Long")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<OneselfAssessPicsDto> getHipiReplaceDetailsPic(@RequestParam("reservationId") Long  reservationId) {
        try {
        	OneselfAssessPicsDto dto = replacementService.getHipiReplaceDetailsPic(reservationId);
            return new RestResponse<>(RestStatusCode.OK,dto);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }
    
    @ApiOperation(value = "保存成交价和付款凭证", notes = "保存成交价和付款凭证", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/oneself/save/transaction/price", method = RequestMethod.POST)
    @ApiOperationSupport(order = 16)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "dto", value = "参数信息", required = true, paramType ="body", dataType = "SaveTransactionPriceDto")
    })
    @JsonPropFilter(type = ReservationDto.class)
    public RestResponse<Boolean> saveTransactionPrice(@RequestBody SaveTransactionPriceDto dto) {
    	try{
    		this.replacementService.saveTransactionPrice(dto);
    	}catch (Exception e) {
    		LOGGER.error("===保存成交价和付款凭证异常===",e);
    		return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, false);
		}
		return new RestResponse<>(RestStatusCode.OK,true);
    }
    
    @ApiOperation(value = "本品收购审批", notes = "本品收购审批", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/oneself/approval", method = RequestMethod.POST)
    @ApiOperationSupport(order = 17)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "dto", value = "参数信息", required = true, paramType ="body", dataType = "OneselfApproveDto")
    })
    @JsonPropFilter(type = ReservationDto.class)
    public RestResponse<Boolean> oneselfApproval(@RequestBody OneselfApproveDto dto) {
    	try{
    		this.replacementService.oneselfApproval(dto);
    	}catch (Exception e) {
    		LOGGER.error("===本品收购审批异常===",e);
    		return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, false);
		}
    	return new RestResponse<>(RestStatusCode.OK,true);
    }
    
    @ApiOperation(value = "本品收购入库", notes = "本品收购入库", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/oneself/put/into/storage", method = RequestMethod.POST)
    @ApiOperationSupport(order = 18)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "dto", value = "参数信息", required = true, paramType ="body", dataType = "OneselfPutIntoStorageDto")
    })
    @JsonPropFilter(type = ReservationDto.class)
    public RestResponse<Boolean> putIntoStorage(@RequestBody OneselfPutIntoStorageDto dto) {
    	try{
    		this.replacementService.putIntoStorage(dto);
    	}catch (Exception e) {
    		LOGGER.error("===本品收购审批异常===",e);
    		return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, false);
		}
    	return new RestResponse<>(RestStatusCode.OK,true);
    }
    
    @ApiOperation(value = "本品手动发放权益", notes = "本品手动发放权益", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/grant/rights", method = RequestMethod.GET)
    @ApiOperationSupport(order = 19)
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "reservationId", value = "预约单id", required = true, paramType ="query", dataType = "Long"),
    	@ApiImplicitParam(name = "businessClassify", value = "业务标识 1601置换/1602销售", required = true, paramType ="query", dataType = "String"),
    	@ApiImplicitParam(name = "isGrant", value = "是否发放权益 1发放/2不发放", required = true, paramType ="query", dataType = "String")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<Boolean> grantRights(@RequestParam("reservationId")Long reservationId,@RequestParam("businessClassify")String businessClassify,
    		@RequestParam("isGrant")Integer isGrant) {

        try {
        	replacementService.grantRights(reservationId,businessClassify,isGrant);
            return new RestResponse<>(RestStatusCode.OK,true);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR,false);
        }
    }
    
    /**
     * Description: 根据预约单id查询置换单详情
     */
    @ApiOperation(value = "本品置换单详情", notes = "本品置换单详情", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/replacement/details/new", method = RequestMethod.GET)
    @ApiOperationSupport(order = 20)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "reservationId", value = "预约单id", required = true, paramType ="query", dataType = "Long")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<ReplaceDetailsNewDto> getReplaceDetailsNew(@RequestParam("reservationId") Long  reservationId) {
        try {
        	ReplaceDetailsNewDto dto = replacementService.getReplaceDetailsNew(reservationId);
            return new RestResponse<>(RestStatusCode.OK,dto);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }
    
    @ApiOperation(value = "置换单逻辑删除", notes = "置换单逻辑删除", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/replacement/logic/delete", method = RequestMethod.GET)
    @ApiOperationSupport(order = 21)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "reservationId", value = "预约单id", required = true, paramType ="query", dataType = "Long")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<String> logicDeleteReplace(@RequestParam("reservationId") Long  reservationId) {
        try {
        	replacementService.logicDeleteReplace(reservationId);
            return new RestResponse<>(RestStatusCode.OK,"true");
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR,"服务异常，请联系后台管理员");
        }
    }
}
