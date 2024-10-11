package com.exp.ucmp.mall.web;

import com.egrid.core.json.body.JsonPropFilter;
import com.egrid.core.web.response.RestResponse;
import com.egrid.core.web.response.RestStatusCode;
import com.exp.ucmp.clues.dto.*;
import com.exp.ucmp.entity.PsiSalesCustomerEntity;
import com.exp.ucmp.entity.PsiSalesModifyConfigEntity;
import com.exp.ucmp.exception.IllegalParameterException;
import com.exp.ucmp.mall.dto.MallReturnDto;
import com.exp.ucmp.mall.service.PsiRetentionService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author gubonai
 * @date 2023年01月13日
 */
@Api(tags = "商城留资线索相关接口")
@RestController
@RequestMapping("/RetentionCluesInfo")
public class PsiRetentionController {


    private static final Logger LOGGER = LoggerFactory.getLogger(PsiRetentionController.class);


    @Autowired
   private PsiRetentionService psiRetentionService;


    /**
     * Description: 查询商城留资线索列表
     */
    @ApiOperation("查询商城留资线索列表")
    @GetMapping("/queryRetentionCluesList")
    @JsonPropFilter(type = PageInfo.class)
    public RestResponse<PageInfo<RetentionCluesDto>> queryRetentionCluesList(RetentionCluesParamDto retentionCluesParamDto) {

        try {
            PageInfo<RetentionCluesDto> retentionCluesDtoPageInfo = psiRetentionService.queryRetentionCluesList(retentionCluesParamDto);
            return new RestResponse<>(RestStatusCode.OK, retentionCluesDtoPageInfo);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

    /**
     * 查询客户列表
     * @param
     * @return
     */
    @ApiOperation("查询客户列表")
    @GetMapping("/queryCustomerInfoList")
    public RestResponse<PageInfo<SalesCustomerDto>> queryCustomerInfoList(PsiSalesCustomerDto psiSalesCustomerDto) {
        try {
            PageInfo<SalesCustomerDto> customerInfoDtoList = psiRetentionService.queryCustomerInfoList(psiSalesCustomerDto);
            return new RestResponse<>(RestStatusCode.OK, customerInfoDtoList);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }
    /**
     * 查询线索客户信息
     * @param customerId
     * @return
     */
    @ApiOperation("查询客户信息")
    @ApiImplicitParams({@ApiImplicitParam(name = "customerId", value = "客户id", required = true)})
    @GetMapping("/querySalesCustomer")
    public RestResponse<PsiSalesCustomerEntity> querySalesCustomer(@RequestParam("customerId") Long customerId) {
        try {
            PsiSalesCustomerEntity customerInfoDto = psiRetentionService.querySalesCustomer(customerId);
            return new RestResponse<>(RestStatusCode.OK, customerInfoDto);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

    /**
     * 查询线索客户信息
     * @param cluesId
     * @return
     */
    @ApiOperation("查询线索客户信息")
    @ApiImplicitParams({@ApiImplicitParam(name = "cluesId", value = "线索id", required = true)})
    @GetMapping("/queryCustomerInfo")
    public RestResponse<CustomerInfoDto> queryCluesCustomerInfo(@RequestParam("cluesId") Long cluesId) {
        try {
            CustomerInfoDto customerInfoDto = psiRetentionService.queryCluesCustomerInfo(cluesId);
            return new RestResponse<>(RestStatusCode.OK, customerInfoDto);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

    /**
     * Description: 查询商城留资线索列表
     */
    @ApiOperation("根据手机号查询线索列表")
    @GetMapping("/queryRetentionListByPhone")
    @ApiImplicitParams({@ApiImplicitParam(name = "pageNum", value = "页码", required = true),
            @ApiImplicitParam(name = "pageSize", value = "页大小", required = true),
            @ApiImplicitParam(name = "customerPhone", value = "手机号", required = true)})
    public RestResponse<PageInfo<RetentionCluesDto>> queryRetentionListByPhone(@RequestParam("customerPhone") String customerPhone,
                                                                             @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                                             @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        try {
            PageInfo<RetentionCluesDto> retentionCluesDtoPageInfo = psiRetentionService.queryRetentionListByPhone(customerPhone,pageNum,pageSize);
            return new RestResponse<>(RestStatusCode.OK, retentionCluesDtoPageInfo);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

    /**
     * Description: 查询跟进记录
     */
    @ApiOperation("查询跟进记录")
    @GetMapping("/queryCluesFollowRecord")
    @ApiImplicitParams({@ApiImplicitParam(name = "pageNum", value = "页码", required = true),
            @ApiImplicitParam(name = "pageSize", value = "页大小", required = true),
            @ApiImplicitParam(name = "cluesId", value = "线索id", required = true)})
    @JsonPropFilter(type = PageInfo.class)
    public RestResponse<PageInfo<PsiCluesFollowRecordDto>> queryCluesFollowRecord(@RequestParam("cluesId") Long cluesId,
                                                                               @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                                               @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        try {
            PageInfo<PsiCluesFollowRecordDto> retentionCluesDtoPageInfo = psiRetentionService.queryCluesFollowRecord(cluesId,pageNum,pageSize);
            return new RestResponse<>(RestStatusCode.OK, retentionCluesDtoPageInfo);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

    /**
     * Description: 查询订单列表
     */
    @ApiOperation("查询订单列表")
    @GetMapping("/queryOrderList")
    public RestResponse<PageInfo<OrderInfoDto>> queryOrderList(OrderInfoParamDto orderInfoParamDto) {
        try {
            PageInfo<OrderInfoDto> orderInfoDtoPageInfo = psiRetentionService.queryOrderList(orderInfoParamDto);
            return new RestResponse<>(RestStatusCode.OK, orderInfoDtoPageInfo);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

    @ApiOperation(value = "查询未审核改配记录")
    @GetMapping("/modifyProcess")
    public RestResponse<PsiSalesModifyConfigEntity> modifyProcess(@RequestParam("orderInfoId") Long orderInfoId) {
        try {
            PsiSalesModifyConfigEntity psiSalesModifyConfig =  psiRetentionService.modifyProcess(orderInfoId);
            return new RestResponse<>(RestStatusCode.OK, psiSalesModifyConfig);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }


    @ApiOperation(value = "总部新建改配")
    @PostMapping("/createModify")
    public RestResponse<String> createModify(@RequestBody PsiSalesModifyConfigCreateDto createDto) {
        try {
            psiRetentionService.createModify(createDto);
            return new RestResponse<>();
        } catch (IllegalParameterException e){
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR.code(), e.getMessage());
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR,e);
        }
    }

    @ApiOperation(value = "订单改配审核")
    @PostMapping("/modifyApprove")
    public RestResponse<String> modifyApprove(@RequestBody PsiSalesModifyConfigApproveDto modifyConfigApproveDto) {
        try {
            psiRetentionService.modifyApprove(modifyConfigApproveDto);
            return new RestResponse<>();
        } catch (IllegalParameterException e){
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR.code(), e.getMessage());
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR,e);
        }
    }



    /**
     * 根据vin查询车辆信息
     * @param vin
     * @return
     */
    @ApiOperation("根据vin查询车辆信息")
    @ApiImplicitParams({@ApiImplicitParam(name = "vin", value = "vin码", required = true)})
    @GetMapping("/queryVhclInfo")
    public RestResponse<VhclInfoDto> queryVhclInfo(@RequestParam("vin") String vin) {
        try {
            VhclInfoDto customerInfoDto = psiRetentionService.queryVhclInfo(vin);
            return new RestResponse<>(RestStatusCode.OK, customerInfoDto);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

    /**
     * 查询商城已上架vin列表
     * @param
     * @return
     */
    @ApiOperation("查询商城已上架vin列表")
    @GetMapping("/queryVinList")
    public RestResponse<List<String>> queryVinList() {
        try {
            List<String> list = psiRetentionService.queryVinList();
            return new RestResponse<>(RestStatusCode.OK, list);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }
//    老接口，pc端不支持该接口，销售端支持
//    /**
//     * Description: 添加跟进
//     */
//    @ApiOperation(value = "添加跟进")
//    @PostMapping("/saveFollow")
//    public RestResponse<String> saveFollow(@RequestBody SaveFollowDto paramDto) {
//        try {
//            String status = psiRetentionService.saveFollow(paramDto);
//            return new RestResponse<>(status);
//        } catch (Exception e) {
//            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
//            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
//        }
//    }

//    /**
//     * Description: 战败
//     */
//    @ApiOperation(value = "战败")
//    @GetMapping("/defeat")
//    @ApiImplicitParam(name = "cluesId", value = "线索id", required = true)
//    public RestResponse<String> defeat(@RequestParam("cluesId") Long cluesId) {
//        try {
//            String status = psiRetentionService.defeat(cluesId);
//            return new RestResponse<>(status);
//        } catch (Exception e) {
//            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
//            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
//        }
//    }

//    /**
//     * Description: 保存订单
//     */
//    @ApiOperation(value = "保存订单")
//    @PostMapping("/saveOrder")
//    public RestResponse<String> saveOrder(@RequestBody SaveOrderDto paramDto) {
//        try {
//            String status = psiRetentionService.saveOrder(paramDto);
//            return new RestResponse<>(status);
//        } catch (Exception e) {
//            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
//            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
//        }
//    }

    /**
     * 查询订单详情
     * @param orderInfoId
     * @return
     */
    @ApiOperation("查询订单详情")
    @ApiImplicitParams({@ApiImplicitParam(name = "orderInfoId", value = "订单id", required = true)})
    @GetMapping("/queryOrderInfo")
    public RestResponse<PsiOrderInfoDto> queryOrderInfo(@RequestParam("orderInfoId") Long orderInfoId) {
        try {
            PsiOrderInfoDto psiOrderInfoDto = psiRetentionService.queryOrderInfo(orderInfoId);
            return new RestResponse<>(RestStatusCode.OK, psiOrderInfoDto);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

    /**
     * Description: 线索转让
     */
    @ApiOperation(value = "线索转让")
    @PostMapping("/transference")
    public RestResponse<String> cluesTransference(@RequestBody CluesTransferenceDto transferenceDto) {
        try {
            psiRetentionService.cluesTransference(transferenceDto);
            return new RestResponse<>();
        } catch (IllegalParameterException e){
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR.code(), e.getMessage());
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR,e);
        }
    }

    @ApiOperation(value = "线索导入模板下载", notes = "线索导入模板下载")
    @RequestMapping(value = "/file/download", method = RequestMethod.GET)
    public RestResponse<String> fileDownload(HttpServletRequest request,  HttpServletResponse response) throws IOException {
        return psiRetentionService.fileDownload(request,response);
//        ArrayList<CluesInfoImportExcelEntity> objects = new ArrayList<>();
//        EasyExcelUtils.webWriteExcel(response, objects, CluesInfoImportExcelEntity.class, "线索导入模板.xlsx");
    }

    @ApiOperation(value = "导入线索管理")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "file", value = "导入文件", required = true, paramType ="form", dataType = "File")
    })
    @RequestMapping(value = "/cluesImport", method = RequestMethod.POST)
    @JsonPropFilter(type = String.class)
    public RestResponse<String> carStockImport(MultipartFile file, HttpServletRequest request){
        try {
            String result = psiRetentionService.readExcel(file);
            return new RestResponse<>(RestStatusCode.OK,result);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
//            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR,"请放入一个合法的Excel模板!");
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR,e);
        }
    }

    /**
     * Description: 激活
     */
    @ApiOperation(value = "激活")
    @GetMapping("/activation")
    @ApiImplicitParam(name = "cluesId", value = "线索id", required = true)
    public RestResponse<String> activation(@RequestParam("cluesId") Long cluesId) {
        try {
            String status = psiRetentionService.activation(cluesId);
            return new RestResponse<>(status);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR,e);
        }
    }
    /**
     * Description: 订单权益发放
     */
    @ApiOperation(value = "订单权益发放")
    @PostMapping("/legalRight")
    public RestResponse<String> legalRight(@RequestBody OrderLegalRightDto orderLegalRightDto) {
        try {
            psiRetentionService.legalRight(orderLegalRightDto);
            return new RestResponse<>();
        } catch (IllegalParameterException e){
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR.code(), e.getMessage());
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR,e);
        }
    }

    /**
     * Description: 订单转让
     */
    @ApiOperation(value = "订单转让")
    @PostMapping("/orderTransference")
    public RestResponse<String> orderTransference(@RequestBody OrderTransferenceDto transferenceDto) {
        try {
            psiRetentionService.orderTransference(transferenceDto);
            return new RestResponse<>(RestStatusCode.OK);
        } catch (IllegalParameterException e){
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR.code(), e.getMessage());
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR,e);
        }
    }
    @ApiOperation(value = "门店客户重新流转线索池")
    @GetMapping("/storeRedistribution")
    @ApiImplicitParam(name = "storeId", value = "门店id", required = true)
    public RestResponse<String> storeRedistribution(@RequestParam("storeId") Long storeId) {
        try {
            psiRetentionService.storeRedistribution(storeId);
            return new RestResponse<>(RestStatusCode.OK);
        } catch (IllegalParameterException e){
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR.code(), e.getMessage());
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR,e);
        }
    }

    @ApiOperation(value = "门店人员客户重新流转线索池")
    @GetMapping("/partyRedistribution")
    @ApiImplicitParam(name = "partyId", value = "人员id", required = true)
    public RestResponse<String> partyRedistribution(@RequestParam("partyId") Long partyId) {
        try {
            psiRetentionService.partyRedistribution(partyId);
            return new RestResponse<>(RestStatusCode.OK);
        } catch (IllegalParameterException e){
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR.code(), e.getMessage());
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR,e);
        }
    }


    /**
     * Description: 商城APP创建线索
     */
    @ApiOperation(value = "商城APP创建线索")
    @PostMapping("/shoppingClues")
    public MallReturnDto<Map<String,Long>> shoppingClues(@RequestBody CluesCreateDto cluesCreateDto) {
    	MallReturnDto<Map<String,Long>> returnDto=new MallReturnDto<>();
        try {
           Long cluesId = psiRetentionService.shoppingClues(cluesCreateDto);
           Map<String,Long> map=new HashMap<>();
           if(cluesId == -1L){
        	   returnDto.setCode("50002");
           }else if(cluesId == -2L){
        	   returnDto.setCode("50003");
           }else if(cluesId == -3L){
        	   returnDto.setCode("50004");
           }else{
        	   returnDto.setCode("000000");
           }
           map.put("cluesId", cluesId);
           returnDto.setMsg("请求处理成功");
           returnDto.setData(map);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            returnDto.setCode("50001");
            returnDto.setMsg(e.toString());
        }
        return returnDto;
    }

    /**
     * Description: 上传导入车辆模板文件
     */
    @ApiOperation(value = "上传导入模板文件")
    @RequestMapping(value = "/file/uploadTemplate", method = RequestMethod.POST)
    @JsonPropFilter(type = String.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "file", value = "导入文件", required = true, paramType ="form", dataType = "File"),
            @ApiImplicitParam(name = "fileId", value = "文件ID", required = true, paramType ="form"),
    })
    public RestResponse<Boolean> uploadTemplate(@RequestParam("file") MultipartFile file,
                                                @RequestParam("fileId") Long fileId) {
        try {
            psiRetentionService.uploadTemplate(file,fileId);
            return new RestResponse<>(RestStatusCode.OK);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

    @ApiOperation(value = "总部订单改价")
    @PostMapping("/change/price")
    public RestResponse<String> changePrice(@RequestBody OrderChangePriceDto orderChangePriceDto) {
        try {
            psiRetentionService.changePrice(orderChangePriceDto);
           return new RestResponse<>(RestStatusCode.OK,"true");
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR,e.getMessage());
        }
    }
}
