package com.exp.ucmp.apig.isp.web;


import java.util.HashMap;
import java.util.Map;

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

import com.egrid.core.json.body.JsonPropFilter;
import com.egrid.core.util.JsonBeanUtil;
import com.egrid.core.web.response.RestResponse;
import com.egrid.core.web.response.RestStatusCode;
import com.exp.ucmp.apig.isp.consumer.IspConsumer;
import com.exp.ucmp.isp.dto.IspOrderCommonReturnDto;
import com.exp.ucmp.isp.dto.IspOrderDetailReturnDto;
import com.exp.ucmp.isp.dto.IspOrderHistoryReturnDto;
import com.exp.ucmp.isp.dto.QuoteApplyDto;
import com.exp.ucmp.isp.dto.QuoteApprovalDto;
import com.exp.ucmp.isp.dto.SiteQueryDto;
import com.exp.ucmp.isp.dto.WorkOrderCommonQueryDto;
import com.exp.ucmp.isp.dto.WorkOrderHistoryDto;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;


/**
 * 
 * @author xiongneng
 * @date 2023年09月11日
 */
@Api(value = "ispApig.API", tags = "ispApig接口调试")
@RefreshScope
@Controller
public class IspController {

	/**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(IspController.class);
    
    @Autowired
	private IspConsumer ispConsumer;
    

    /**
     * <p>Description: 网点查询接口</p>
     */
    @ApiOperation(value = "网点查询接口", notes = "网点查询接口", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/apig/third/site/common/query", method = RequestMethod.POST)
    @ApiOperationSupport(order = 1)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "siteQueryDto", value = "网点查询参数", required = true, paramType ="body", dataType = "SiteQueryDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<String> querySite(@RequestBody SiteQueryDto siteQueryDto) {
        try {
        	Map<String, Object> params = new HashMap<>();
    		params.put("siteTypes", siteQueryDto.getSiteTypes());
    		params.put("siteName", siteQueryDto.getSiteName());
    		params.put("siteId", siteQueryDto.getSiteId());
    		params.put("operatingStatus", siteQueryDto.getOperatingStatus());
    		params.put("siteCode", siteQueryDto.getSiteCode());
    		params.put("isCShow", siteQueryDto.getIsCShow());
    		params.put("isReserve", siteQueryDto.getIsReserve());
        	String result = ispConsumer.querySite(params);
            return new RestResponse<>(result);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }
    
    @ApiOperation(value = "预估报价单申请接口", notes = "预估报价单申请接口", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/apig/third/quote/apply", method = RequestMethod.POST)
    @ApiOperationSupport(order = 2)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "quoteApplyDto", value = "预估报价单申请参数", required = true, paramType ="body", dataType = "QuoteApplyDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<String> quoteApply(@RequestBody QuoteApplyDto quoteApplyDto) {
        try {
        	Map<String, Object> params = new HashMap<>();
    		params.put("ucmpOrderNo", quoteApplyDto.getUcmpOrderNo());
    		params.put("siteType", quoteApplyDto.getSiteType());
    		params.put("siteName", quoteApplyDto.getSiteName());
    		params.put("siteCode", quoteApplyDto.getSiteCode());
    		params.put("vin", quoteApplyDto.getVin());
    		params.put("plateNo", quoteApplyDto.getPlateNo());
    		params.put("creatorName", quoteApplyDto.getCreatorName());
    		params.put("creatorEmpId", quoteApplyDto.getCreatorEmpId());
    		params.put("expectDeliveryTime", quoteApplyDto.getExpectDeliveryTime());
    		params.put("orderSource", quoteApplyDto.getOrderSource());
    		params.put("remark", quoteApplyDto.getRemark());
        	String result = ispConsumer.quoteApply(params);
            return new RestResponse<>(result);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }
    
    @ApiOperation(value = "预估报价单审批接口", notes = "预估报价单审批接口", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/apig/third/quote/approval", method = RequestMethod.POST)
    @ApiOperationSupport(order = 3)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "quoteApprovalDto", value = "预估报价单审批参数", required = true, paramType ="body", dataType = "QuoteApprovalDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<String> quoteApproval(@RequestBody QuoteApprovalDto quoteApprovalDto) {
        try {
        	Map<String, Object> params = new HashMap<>();
    		params.put("ucmpOrderNo", quoteApprovalDto.getUcmpOrderNo());
    		params.put("remark", quoteApprovalDto.getRemark());
    		params.put("approvalName", quoteApprovalDto.getApprovalName());
    		params.put("approvalEmpId", quoteApprovalDto.getApprovalEmpId());
    		params.put("status", quoteApprovalDto.getStatus());
        	String result = ispConsumer.quoteApproval(params);
            return new RestResponse<>(result);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }
    
    @ApiOperation(value = "维修配件查询", notes = "维修配件查询接口", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/apig/third/work/order/ucmp/history", method = RequestMethod.POST)
    @ApiOperationSupport(order = 4)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "workOrderHistoryDto", value = "isp维修配件查询参数类", required = true, paramType ="body", dataType = "WorkOrderHistoryDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<String> workOrderHistory(@RequestBody WorkOrderHistoryDto workOrderHistoryDto) {
        try {
        	Map<String, Object> params = new HashMap<>();
    		params.put("vin", workOrderHistoryDto.getVin());
    		params.put("pageNum", workOrderHistoryDto.getPageNum());
    		params.put("pageSize", workOrderHistoryDto.getPageSize());
    		params.put("workOrderFlags", workOrderHistoryDto.getWorkOrderFlags());
    		String result = ispConsumer.workOrderHistory(params);
    		return new RestResponse<>(result);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }
    
    public static void main(String[] args) {
    	String result="{\n  \"code\" : \"200\",\n  \"msg\" : \"API调用成功\",\n  \"data\" : {\n    \"total\" : 419,\n    \"list\" : [ {\n      \"partCode\" : \"400000262\",\n      \"partName\" : \"IP氛围灯控制模块\",\n      \"workOrderTime\" : 1684291139992,\n      \"maintenanceCode\" : \"RCHS000004003\",\n      \"maintenanceName\" : \"电子稳定控制模块拆卸和安装\",\n      \"feeType\" : 11850040,\n      \"feeTypeLabel\" : \"客户付费\"\n    }, {\n      \"partCode\" : \"400000262\",\n      \"partName\" : \"IP氛围灯控制模块\",\n      \"workOrderTime\" : 1692070017319,\n      \"maintenanceCode\" : \"REXT000008001\",\n      \"maintenanceName\" : \"前保中部雷达支架左件拆卸和安装\",\n      \"feeType\" : 11850455,\n      \"feeTypeLabel\" : \"用户中心-保修\"\n    }, {\n      \"partCode\" : \"400000481\",\n      \"partName\" : \"左后门氛围灯带 - 柔性光导 1\",\n      \"workOrderTime\" : 1686281168682,\n      \"maintenanceCode\" : \"RPWT000061001\",\n      \"maintenanceName\" : \"电池包 - 96kWh拆卸和安装\",\n      \"feeType\" : 11850445,\n      \"feeTypeLabel\" : \"用户中心-卡券\"\n    }, {\n      \"partCode\" : \"400000262\",\n      \"partName\" : \"IP氛围灯控制模块\",\n      \"workOrderTime\" : 1684392055163,\n      \"maintenanceCode\" : \"RCHS000004003\",\n      \"maintenanceName\" : \"电子稳定控制模块拆卸和安装\",\n      \"feeType\" : 11850040,\n      \"feeTypeLabel\" : \"客户付费\"\n    }, {\n      \"partCode\" : \"400000262\",\n      \"partName\" : \"IP氛围灯控制模块\",\n      \"workOrderTime\" : 1690428019829,\n      \"maintenanceCode\" : \"REXT000008001\",\n      \"maintenanceName\" : \"前保中部雷达支架左件拆卸和安装\",\n      \"feeType\" : 11850455,\n      \"feeTypeLabel\" : \"用户中心-保修\"\n    }, {\n      \"partCode\" : \"400000262\",\n      \"partName\" : \"IP氛围灯控制模块\",\n      \"workOrderTime\" : 1687858293224,\n      \"maintenanceCode\" : \"REXT000008001\",\n      \"maintenanceName\" : \"前保中部雷达支架左件拆卸和安装\",\n      \"feeType\" : 11850435,\n      \"feeTypeLabel\" : \"用户中心-客户付费\"\n    }, {\n      \"partCode\" : \"400000262\",\n      \"partName\" : \"IP氛围灯控制模块\",\n      \"workOrderTime\" : 1690428245424,\n      \"maintenanceCode\" : \"REXT000008001\",\n      \"maintenanceName\" : \"前保中部雷达支架左件拆卸和安装\",\n      \"feeType\" : 11850455,\n      \"feeTypeLabel\" : \"用户中心-保修\"\n    }, {\n      \"partCode\" : \"400000262\",\n      \"partName\" : \"IP氛围灯控制模块\",\n      \"workOrderTime\" : 1690428132104,\n      \"maintenanceCode\" : \"REXT000008001\",\n      \"maintenanceName\" : \"前保中部雷达支架左件拆卸和安装\",\n      \"feeType\" : 11850455,\n      \"feeTypeLabel\" : \"用户中心-保修\"\n    }, {\n      \"partCode\" : \"400000262\",\n      \"partName\" : \"IP氛围灯控制模块\",\n      \"workOrderTime\" : 1687858656605,\n      \"maintenanceCode\" : \"REXT000008001\",\n      \"maintenanceName\" : \"前保中部雷达支架左件拆卸和安装\",\n      \"feeType\" : 11850435,\n      \"feeTypeLabel\" : \"用户中心-客户付费\"\n    }, {\n      \"partCode\" : \"400000262\",\n      \"partName\" : \"IP氛围灯控制模块\",\n      \"workOrderTime\" : 1690435493239,\n      \"maintenanceCode\" : \"REXT000008001\",\n      \"maintenanceName\" : \"前保中部雷达支架左件拆卸和安装\",\n      \"feeType\" : 11850495,\n      \"feeTypeLabel\" : \"其他业务索赔\"\n    } ],\n    \"pageNum\" : 1,\n    \"pageSize\" : 10,\n    \"size\" : 10,\n    \"startRow\" : 1,\n    \"endRow\" : 10,\n    \"pages\" : 42,\n    \"prePage\" : 0,\n    \"nextPage\" : 2,\n    \"isFirstPage\" : true,\n    \"isLastPage\" : false,\n    \"hasPreviousPage\" : false,\n    \"hasNextPage\" : true,\n    \"navigatePages\" : 8,\n    \"navigatepageNums\" : [ 1, 2, 3, 4, 5, 6, 7, 8 ],\n    \"navigateFirstPage\" : 1,\n    \"navigateLastPage\" : 8\n  }\n}";
		IspOrderHistoryReturnDto returnDto = JsonBeanUtil.jsonToBean(result, IspOrderHistoryReturnDto.class);
		LOGGER.info("========="+JsonBeanUtil.beanToJson(returnDto.getData().getList()));
		
		String comResult="{\n  \"code\" : \"200\",\n  \"msg\" : \"API调用成功\",\n  \"data\" : {\n    \"total\" : 546,\n    \"list\" : [ {\n      \"id\" : 10001650,\n      \"workOrderNo\" : \"RPH01720230509004\",\n      \"reservationNo\" : null,\n      \"maintenanceTypeCode\" : \"shwx\",\n      \"updateBy\" : \"86834282509254656\",\n      \"createBy\" : \"86834282509254656\",\n      \"createTime\" : 1683623216372,\n      \"updateTime\" : 1684378599023,\n      \"imId\" : \"H017\",\n      \"estimatedDeliveryTime\" : 1683648000000,\n      \"manHourFee\" : 3330.00,\n      \"maintenanceMaterialCost\" : 0.00,\n      \"additionalProjectFee\" : 0.00,\n      \"serviceConsultant\" : \"陈志超\",\n      \"status\" : 6,\n      \"vin\" : \"LJD8AC3FXM0010007\",\n      \"plateNo\" : \"豫A12345\",\n      \"ownerName\" : \"王浩\",\n      \"senderName\" : \"我是车主\",\n      \"senderPhone\" : \"17621070071\",\n      \"faultDesc\" : null,\n      \"remark\" : null,\n      \"inMileage\" : 9999999,\n      \"outMileage\" : 9999999,\n      \"nextMaintenance\" : null,\n      \"preRepair\" : null,\n      \"accidentType\" : null,\n      \"insurancCompany\" : null,\n      \"insuranceValidity\" : null,\n      \"customersSource\" : null,\n      \"finalInspector\" : \"徐皓\",\n      \"pickingStatus\" : 1,\n      \"submitSettlementTime\" : 1683623304040,\n      \"preprint\" : false,\n      \"version\" : 3,\n      \"buyTime\" : 1620576000000,\n      \"motorNo\" : \"1C322014F-1C326008R\",\n      \"vehicleUse\" : \"大客户-滴滴(租赁)\",\n      \"vehicleModelName\" : \"VX1-创始版6座\",\n      \"ownerCode\" : null,\n      \"exemptionClause\" : null,\n      \"deliveryTime\" : 1683623329712,\n      \"settlementOrderNo\" : \"RJH01720230509004\",\n      \"lastMoney\" : 3330.00,\n      \"threeGuarantees\" : false,\n      \"lastRepairDate\" : 1683268658829,\n      \"enterWay\" : 11850075,\n      \"type\" : 11850090,\n      \"displayStatus\" : false,\n      \"settlementTime\" : 1683623320691,\n      \"bSc\" : null,\n      \"qualityProblem\" : false,\n      \"cSc\" : null,\n      \"cMaintenanceMaterialCost\" : 0.00,\n      \"cAdditionalProjectFee\" : 0.00,\n      \"cTotalAmount\" : 0.00,\n      \"noneWarrantyMaintenanceMaterialIncome\" : 0.00,\n      \"cManHourFee\" : 0.00,\n      \"stdTimeAmount\" : 5.00,\n      \"spTotalCost\" : 0.00,\n      \"spNoneGuaranteeCost\" : 0.00,\n      \"interWorkHourTotalFee\" : 0.00,\n      \"interSpTotalFee\" : 0.00,\n      \"claimTotalFee\" : 3330.00,\n      \"goodwillCost\" : 0.00,\n      \"collectionStatus\" : 11850130,\n      \"invoiceStatus\" : 12550015,\n      \"remainingAmount\" : 0.00,\n      \"payStatus\" : null,\n      \"typeLabel\" : \"To C\",\n      \"originNo\" : null,\n      \"statusLabel\" : null,\n      \"maintenanceTypeLabel\" : null,\n      \"maintenanceTimeSum\" : null,\n      \"totalAmount\" : 3330.00,\n      \"activitys\" : \"[]\",\n      \"batterySn\" : null,\n      \"batterySerial\" : null,\n      \"batteryModel\" : \"1C322014F-1C326008R\",\n      \"siteType\" : \"SC\",\n      \"color\" : null,\n      \"bwdAmount\" : 0.00,\n      \"guaranteeOrder\" : true,\n      \"interTotalFee\" : 0.00,\n      \"insuranceFee\" : 0.00,\n      \"goodWillFee\" : 0.00,\n      \"customerPayFee\" : 0.00,\n      \"outSpIncome\" : 0.00,\n      \"completeTime\" : 1683623298467,\n      \"invoicedAmount\" : 0.00,\n      \"confirmStatus\" : true,\n      \"evaluationStatus\" : null,\n      \"confirmUser\" : \"陈志超\",\n      \"confirmTime\" : 1689557163266,\n      \"orderer\" : null,\n      \"ordererName\" : \"我是车主\",\n      \"orderPhone\" : \"17621070071\",\n      \"mainUser\" : null,\n      \"mainUserName\" : \"我是车主\",\n      \"mainUserPhone\" : \"17621070071\",\n      \"authorizer\" : \"\",\n      \"authorizerName\" : null,\n      \"authorizerPhone\" : null,\n      \"paidAmount\" : null,\n      \"discountAmount\" : null,\n      \"innerCustomerCode\" : \"高合服务中心（上海金桥店）\",\n      \"instantId\" : null,\n      \"workOrderFlag\" : \"ISP\",\n      \"maintenanceItems\" : null,\n      \"firstDate\" : null,\n      \"updateDate\" : null,\n      \"residueAmount\" : null,\n      \"affirmBy\" : \"陈志超\",\n      \"affirmTime\" : 1683623304040,\n      \"balanceRemark\" : null,\n      \"inverseSettlementFlag\" : 0,\n      \"inverseSettlementTime\" : null,\n      \"inverseSettlementBy\" : null,\n      \"inverseSettlementEmp\" : null,\n      \"inverseSettlementCount\" : 0,\n      \"negativeWorkOrderSort\" : null,\n      \"negativeOrderFinishFlag\" : null,\n      \"creditCycle\" : null,\n      \"appraiseStatus\" : -1,\n      \"uscCommentId\" : \"1655862377992237057\",\n      \"vehicleBlackFlag\" : 0,\n      \"envOrderNo\" : null,\n      \"quoteOrderNo\" : null,\n      \"customerConfirmFlag\" : null,\n      \"partsNumber\" : null,\n      \"bsc\" : null,\n      \"ctotalAmount\" : 0.00,\n      \"invoiceDate\" : 1620576000000,\n      \"enterWayLabel\" : \"用户进店\",\n      \"collectionStatusLabel\" : \"待收款\",\n      \"invoiceStatusLabel\" : \"未开票\",\n      \"displayStatusLabel\" : \"不展示\",\n      \"maintenanceTypeStr\" : \"售后维修\",\n      \"csc\" : null,\n      \"cmaintenanceMaterialCost\" : 0.00,\n      \"cadditionalProjectFee\" : 0.00,\n      \"cmanHourFee\" : 0.00\n    }, {\n      \"id\" : 10001670,\n      \"workOrderNo\" : \"RPH01720230517001\",\n      \"reservationNo\" : null,\n      \"maintenanceTypeCode\" : \"shwx\",\n      \"updateBy\" : null,\n      \"createBy\" : \"86834282509254656\",\n      \"createTime\" : 1684291136805,\n      \"updateTime\" : 1684895940485,\n      \"imId\" : \"H017\",\n      \"estimatedDeliveryTime\" : 1661443200000,\n      \"manHourFee\" : 22.00,\n      \"maintenanceMaterialCost\" : 3000.00,\n      \"additionalProjectFee\" : 0.00,\n      \"serviceConsultant\" : \"陈志超\",\n      \"status\" : 6,\n      \"vin\" : \"LJD8AC3FXM0010007\",\n      \"plateNo\" : \"豫A99999\",\n      \"ownerName\" : \"测试车辆\",\n      \"senderName\" : \"王浩\",\n      \"senderPhone\" : \"17621070071\",\n      \"faultDesc\" : null,\n      \"remark\" : \"接口自动化测试创建\",\n      \"inMileage\" : 9999999,\n      \"outMileage\" : 10,\n      \"nextMaintenance\" : null,\n      \"preRepair\" : null,\n      \"accidentType\" : null,\n      \"insurancCompany\" : null,\n      \"insuranceValidity\" : null,\n      \"customersSource\" : null,\n      \"finalInspector\" : \"徐皓\",\n      \"pickingStatus\" : 3,\n      \"submitSettlementTime\" : 1684291139289,\n      \"preprint\" : false,\n      \"version\" : 2,\n      \"buyTime\" : 1620748800000,\n      \"motorNo\" : \"IOVTESTZHANG00001\",\n      \"vehicleUse\" : \"\",\n      \"vehicleModelName\" : \"高合\",\n      \"ownerCode\" : \"001\",\n      \"exemptionClause\" : null,\n      \"deliveryTime\" : 1684291139992,\n      \"settlementOrderNo\" : \"RJH01720230517001\",\n      \"lastMoney\" : 3022.00,\n      \"threeGuarantees\" : false,\n      \"lastRepairDate\" : 1657848795973,\n      \"enterWay\" : 11850075,\n      \"type\" : 11850090,\n      \"displayStatus\" : false,\n      \"settlementTime\" : 1684291139455,\n      \"bSc\" : null,\n      \"qualityProblem\" : false,\n      \"cSc\" : null,\n      \"cMaintenanceMaterialCost\" : 3000.00,\n      \"cAdditionalProjectFee\" : 0.00,\n      \"cTotalAmount\" : 3022.00,\n      \"noneWarrantyMaintenanceMaterialIncome\" : 3000.00,\n      \"cManHourFee\" : 22.00,\n      \"stdTimeAmount\" : 2.20,\n      \"spTotalCost\" : 400.00,\n      \"spNoneGuaranteeCost\" : 400.00,\n      \"interWorkHourTotalFee\" : 0.00,\n      \"interSpTotalFee\" : 0.00,\n      \"claimTotalFee\" : 0.00,\n      \"goodwillCost\" : 0.00,\n      \"collectionStatus\" : 11850135,\n      \"invoiceStatus\" : 12550015,\n      \"remainingAmount\" : 0.00,\n      \"payStatus\" : 1,\n      \"typeLabel\" : \"To C\",\n      \"originNo\" : null,\n      \"statusLabel\" : null,\n      \"maintenanceTypeLabel\" : null,\n      \"maintenanceTimeSum\" : null,\n      \"totalAmount\" : 3022.00,\n      \"activitys\" : \"[]\",\n      \"batterySn\" : null,\n      \"batterySerial\" : null,\n      \"batteryModel\" : null,\n      \"siteType\" : \"SC\",\n      \"color\" : null,\n      \"bwdAmount\" : 3022.00,\n      \"guaranteeOrder\" : false,\n      \"interTotalFee\" : 0.00,\n      \"insuranceFee\" : 0.00,\n      \"goodWillFee\" : 0.00,\n      \"customerPayFee\" : 3022.00,\n      \"outSpIncome\" : 0.00,\n      \"completeTime\" : 1684291139164,\n      \"invoicedAmount\" : 3022.00,\n      \"confirmStatus\" : true,\n      \"evaluationStatus\" : null,\n      \"confirmUser\" : \"陈志超\",\n      \"confirmTime\" : 1687939085863,\n      \"orderer\" : null,\n      \"ordererName\" : \"测试车辆\",\n      \"orderPhone\" : \"17621070071\",\n      \"mainUser\" : \"刘明涛\",\n      \"mainUserName\" : \"测试车辆\",\n      \"mainUserPhone\" : \"17621070071\",\n      \"authorizer\" : \"\",\n      \"authorizerName\" : \"\",\n      \"authorizerPhone\" : \"\",\n      \"paidAmount\" : null,\n      \"discountAmount\" : null,\n      \"innerCustomerCode\" : \"高合服务中心（上海金桥店）\",\n      \"instantId\" : null,\n      \"workOrderFlag\" : \"ISP\",\n      \"maintenanceItems\" : null,\n      \"firstDate\" : null,\n      \"updateDate\" : null,\n      \"residueAmount\" : null,\n      \"affirmBy\" : null,\n      \"affirmTime\" : null,\n      \"balanceRemark\" : null,\n      \"inverseSettlementFlag\" : 0,\n      \"inverseSettlementTime\" : null,\n      \"inverseSettlementBy\" : null,\n      \"inverseSettlementEmp\" : null,\n      \"inverseSettlementCount\" : 0,\n      \"negativeWorkOrderSort\" : null,\n      \"negativeOrderFinishFlag\" : null,\n      \"creditCycle\" : null,\n      \"appraiseStatus\" : -1,\n      \"uscCommentId\" : \"1658663377157304322\",\n      \"vehicleBlackFlag\" : 0,\n      \"envOrderNo\" : null,\n      \"quoteOrderNo\" : null,\n      \"customerConfirmFlag\" : null,\n      \"partsNumber\" : null,\n      \"bsc\" : null,\n      \"ctotalAmount\" : 3022.00,\n      \"invoiceDate\" : 1620748800000,\n      \"enterWayLabel\" : \"用户进店\",\n      \"collectionStatusLabel\" : \"已收款\",\n      \"invoiceStatusLabel\" : \"未开票\",\n      \"displayStatusLabel\" : \"不展示\",\n      \"maintenanceTypeStr\" : \"售后维修\",\n      \"csc\" : null,\n      \"cmaintenanceMaterialCost\" : 3000.00,\n      \"cadditionalProjectFee\" : 0.00,\n      \"cmanHourFee\" : 22.00\n    } ],\n    \"pageNum\" : 1,\n    \"pageSize\" : 2,\n    \"size\" : 0,\n    \"startRow\" : 0,\n    \"endRow\" : 0,\n    \"pages\" : 273,\n    \"prePage\" : 0,\n    \"nextPage\" : 2,\n    \"isFirstPage\" : true,\n    \"isLastPage\" : false,\n    \"hasPreviousPage\" : false,\n    \"hasNextPage\" : true,\n    \"navigatePages\" : 8,\n    \"navigatepageNums\" : [ 1, 2, 3, 4, 5, 6, 7, 8 ],\n    \"navigateFirstPage\" : 1,\n    \"navigateLastPage\" : 8\n  }\n}";
		IspOrderCommonReturnDto comReturnDto = JsonBeanUtil.jsonToBean(comResult, IspOrderCommonReturnDto.class);
		LOGGER.info("========="+JsonBeanUtil.beanToJson(comReturnDto.getData().getList()));
		
		String detailResult="{\n  \"code\" : \"200\",\n  \"msg\" : \"API调用成功\",\n  \"data\" : {\n    \"id\" : 10002641,\n    \"workOrderNo\" : \"RPH01720231120007\",\n    \"reservationNo\" : null,\n    \"maintenanceTypeCode\" : \"shwx\",\n    \"updateBy\" : \"86834282509254656\",\n    \"createBy\" : \"86834282509254656\",\n    \"createTime\" : 1700463993860,\n    \"updateTime\" : 1700463912560,\n    \"imId\" : \"H017\",\n    \"estimatedDeliveryTime\" : 1700496000000,\n    \"manHourFee\" : 666.00,\n    \"maintenanceMaterialCost\" : 1000.00,\n    \"additionalProjectFee\" : 0.00,\n    \"serviceConsultant\" : \"陈志超\",\n    \"status\" : 6,\n    \"vin\" : \"LJD8AC3FXM0010007\",\n    \"plateNo\" : \"豫A654321\",\n    \"ownerName\" : \"测试002\",\n    \"senderName\" : \"ISP测试\",\n    \"senderPhone\" : \"17621070071\",\n    \"faultDesc\" : null,\n    \"remark\" : null,\n    \"inMileage\" : 9999999,\n    \"outMileage\" : 9999999,\n    \"nextMaintenance\" : null,\n    \"preRepair\" : null,\n    \"accidentType\" : null,\n    \"insurancCompany\" : null,\n    \"insuranceValidity\" : null,\n    \"customersSource\" : null,\n    \"finalInspector\" : \"低星推评测试01\",\n    \"pickingStatus\" : 1,\n    \"submitSettlementTime\" : 1700463897065,\n    \"preprint\" : false,\n    \"version\" : 2,\n    \"buyTime\" : 1620576000000,\n    \"motorNo\" : \"1C322014F-1C326008R\",\n    \"vehicleUse\" : \"大客户-滴滴(租赁)\",\n    \"vehicleModelName\" : \"VX1-创始版6座\",\n    \"ownerCode\" : null,\n    \"exemptionClause\" : null,\n    \"deliveryTime\" : 1700463912294,\n    \"settlementOrderNo\" : \"RJH01720231120007\",\n    \"lastMoney\" : 1666.00,\n    \"threeGuarantees\" : false,\n    \"lastRepairDate\" : 1700203423190,\n    \"enterWay\" : 11850075,\n    \"type\" : 11850110,\n    \"displayStatus\" : false,\n    \"settlementTime\" : 1700464007453,\n    \"bSc\" : null,\n    \"qualityProblem\" : false,\n    \"cSc\" : null,\n    \"cMaintenanceMaterialCost\" : 1000.00,\n    \"cAdditionalProjectFee\" : 0.00,\n    \"cTotalAmount\" : 1666.00,\n    \"noneWarrantyMaintenanceMaterialIncome\" : 1000.00,\n    \"cManHourFee\" : 666.00,\n    \"stdTimeAmount\" : 1.00,\n    \"spTotalCost\" : 600.00,\n    \"spNoneGuaranteeCost\" : 600.00,\n    \"interWorkHourTotalFee\" : 0.00,\n    \"interSpTotalFee\" : 0.00,\n    \"claimTotalFee\" : 0.00,\n    \"goodwillCost\" : 0.00,\n    \"collectionStatus\" : 11850135,\n    \"invoiceStatus\" : 12550015,\n    \"remainingAmount\" : 0.00,\n    \"payStatus\" : 1,\n    \"typeLabel\" : \"负工单\",\n    \"originNo\" : \"RPH01720231120005\",\n    \"statusLabel\" : null,\n    \"maintenanceTypeLabel\" : null,\n    \"maintenanceTimeSum\" : null,\n    \"totalAmount\" : 1666.00,\n    \"activitys\" : \"[]\",\n    \"batterySn\" : null,\n    \"batterySerial\" : \"0ENPE011011000B4L0000001\",\n    \"batteryModel\" : \"1C322014F-1C326008R\",\n    \"siteType\" : \"SC\",\n    \"color\" : \"蓝色\",\n    \"bwdAmount\" : 1666.00,\n    \"guaranteeOrder\" : false,\n    \"interTotalFee\" : 0.00,\n    \"insuranceFee\" : 0.00,\n    \"goodWillFee\" : 0.00,\n    \"customerPayFee\" : 1666.00,\n    \"outSpIncome\" : 0.00,\n    \"completeTime\" : 1700463890832,\n    \"invoicedAmount\" : 1666.00,\n    \"confirmStatus\" : true,\n    \"evaluationStatus\" : null,\n    \"confirmUser\" : \"陈志超\",\n    \"confirmTime\" : 1700463829605,\n    \"orderer\" : null,\n    \"ordererName\" : \"我是车主\",\n    \"orderPhone\" : \"17621070071\",\n    \"mainUser\" : null,\n    \"mainUserName\" : \"我是车主\",\n    \"mainUserPhone\" : \"17621070071\",\n    \"authorizer\" : \"\",\n    \"authorizerName\" : null,\n    \"authorizerPhone\" : null,\n    \"paidAmount\" : null,\n    \"discountAmount\" : null,\n    \"innerCustomerCode\" : \"金桥高合服务中心\",\n    \"instantId\" : null,\n    \"workOrderFlag\" : \"ISP\",\n    \"maintenanceItems\" : [ {\n      \"concernCode\" : null,\n      \"feeDifferentiation\" : 11850040,\n      \"activityNo\" : null,\n      \"feeDifferentiationLabel\" : \"客户付费\",\n      \"id\" : 146000,\n      \"code\" : \"TEST0000008\",\n      \"name\" : \"万能工时测试89\",\n      \"maintenanceTypeCode\" : \"R\",\n      \"stdTime\" : 1.00,\n      \"manHour\" : 666.00,\n      \"manHourFee\" : 666.00,\n      \"technician\" : \"低星推评测试01\",\n      \"maintenanceTypeLabel\" : null,\n      \"discount\" : 1.00,\n      \"totalPrice\" : null,\n      \"workOrderNo\" : \"RPH01720231120007\",\n      \"receivePrice\" : 666.00,\n      \"preferentialPrice\" : null,\n      \"beginTime\" : 1700463844588,\n      \"expectedFinishTime\" : 1700496000000,\n      \"realFinishTime\" : 1700463849163,\n      \"qualityInspector\" : \"低星推评测试01\",\n      \"qualityInspectorCode\" : null,\n      \"stationName\" : null,\n      \"technicianCode\" : \"450590941993656320\",\n      \"status\" : 3,\n      \"addItem\" : false,\n      \"assignTime\" : 1700463840988,\n      \"workDesc\" : null,\n      \"rootCause\" : null,\n      \"mType\" : 11850120,\n      \"groupCode\" : null,\n      \"posnr\" : \"10\",\n      \"cDesc\" : \"\",\n      \"mainHarmCode\" : \"\",\n      \"mainHarmName\" : \"\",\n      \"activityCategory\" : null,\n      \"discountMoney\" : 0.00,\n      \"couponMetaId\" : \"\",\n      \"couponId\" : \"\",\n      \"autoClaimNo\" : null,\n      \"couponName\" : \"\",\n      \"userId\" : \"\",\n      \"userName\" : \"\",\n      \"partsDTOs\" : null,\n      \"mtype\" : 11850120,\n      \"mtypeLabel\" : \"钣喷\",\n      \"cdesc\" : \"\"\n    } ],\n    \"firstDate\" : null,\n    \"updateDate\" : null,\n    \"residueAmount\" : null,\n    \"affirmBy\" : null,\n    \"affirmTime\" : null,\n    \"balanceRemark\" : null,\n    \"inverseSettlementFlag\" : 0,\n    \"inverseSettlementTime\" : null,\n    \"inverseSettlementBy\" : null,\n    \"inverseSettlementEmp\" : null,\n    \"inverseSettlementCount\" : 0,\n    \"negativeWorkOrderSort\" : 2,\n    \"negativeOrderFinishFlag\" : null,\n    \"creditCycle\" : null,\n    \"appraiseStatus\" : 0,\n    \"uscCommentId\" : null,\n    \"vehicleBlackFlag\" : 0,\n    \"envOrderNo\" : null,\n    \"quoteOrderNo\" : null,\n    \"customerConfirmFlag\" : 0,\n    \"partsNumber\" : null,\n    \"parts\" : [ {\n      \"id\" : 24485,\n      \"spName\" : \"IP氛围灯控制模块\",\n      \"spCode\" : \"400000262\",\n      \"measureUnit\" : \"EA\",\n      \"spType\" : null,\n      \"spReplacementCode\" : null,\n      \"spReplacementName\" : null,\n      \"spRetailIncluTaxPrice\" : 1000.00,\n      \"spRetailExcluTaxPrice\" : null,\n      \"spMassSalesIncluTaxPrice\" : null,\n      \"spMassSalesExcluTaxPrice\" : 600.00,\n      \"spClaimIncluTaxPrice\" : null,\n      \"spPurchaseIncluTaxPrice\" : 600.00,\n      \"spCategory\" : null,\n      \"oemFlg\" : 0,\n      \"safetyStock\" : null,\n      \"availableQuantity\" : null,\n      \"totalStock\" : null,\n      \"amount\" : 1.000,\n      \"totalPrice\" : null,\n      \"receivePrice\" : 1000.00,\n      \"outRepo\" : false,\n      \"outAmount\" : 0.000,\n      \"returnAmount\" : 0.000,\n      \"canReturnAmount\" : 0.000,\n      \"canOutAmount\" : 1.000,\n      \"discount\" : 1.00,\n      \"keySpFlg\" : 1,\n      \"repoLocation\" : \"A001\",\n      \"repoName\" : \"CSYK01\",\n      \"feeDifferentiation\" : 11850040,\n      \"feeDifferentiationLabel\" : \"客户付费\",\n      \"concernCode\" : null,\n      \"groupCode\" : null,\n      \"activityNo\" : null,\n      \"dataFlg\" : 0,\n      \"posnr\" : \"20\",\n      \"lastOutRepoTime\" : 1700463884.010000000,\n      \"maintenanceItemCode\" : \"TEST0000008\",\n      \"maintenanceItemName\" : \"万能工时测试89\",\n      \"discountMoney\" : 0.00,\n      \"returnMaterialFlg\" : 1,\n      \"preferentialPrice\" : null,\n      \"salePrice\" : 1000.00,\n      \"applicableModel\" : null,\n      \"autoClaimNo\" : null\n    } ],\n    \"additionalItems\" : [ ],\n    \"workOrderTrans\" : null,\n    \"maintains\" : [ ],\n    \"bsc\" : null,\n    \"ctotalAmount\" : 1666.00,\n    \"invoiceDate\" : 1620576000000,\n    \"enterWayLabel\" : \"用户进店\",\n    \"displayStatusLabel\" : \"不展示\",\n    \"collectionStatusLabel\" : \"已收款\",\n    \"invoiceStatusLabel\" : \"未开票\",\n    \"maintenanceTypeStr\" : \"售后维修\",\n    \"csc\" : null,\n    \"cmaintenanceMaterialCost\" : 1000.00,\n    \"cadditionalProjectFee\" : 0.00,\n    \"cmanHourFee\" : 666.00\n  }\n}";
		IspOrderDetailReturnDto detailDto = JsonBeanUtil.jsonToBean(detailResult, IspOrderDetailReturnDto.class);
		LOGGER.info("=====其他费用===="+JsonBeanUtil.beanToJson(detailDto.getData().getAdditionalItems()));
		LOGGER.info("=====项目===="+JsonBeanUtil.beanToJson(detailDto.getData().getMaintenanceItems()));
		LOGGER.info("=====配件===="+JsonBeanUtil.beanToJson(detailDto.getData().getParts()));
    }
    
    @ApiOperation(value = "维修历史查询接口", notes = "维修工单列表接口", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/apig/third/work/order/common/query", method = RequestMethod.POST)
    @ApiOperationSupport(order = 5)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "workOrderCommonQueryDto", value = "isp维修历史查询参数类", required = true, paramType ="body", dataType = "WorkOrderCommonQueryDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<String> workOrderQuery(@RequestBody WorkOrderCommonQueryDto workOrderCommonQueryDto) {
        try {
        	Map<String, Object> params = new HashMap<>();
    		params.put("vin", workOrderCommonQueryDto.getVin());
    		params.put("pageNum", workOrderCommonQueryDto.getPageNum());
    		params.put("pageSize", workOrderCommonQueryDto.getPageSize());
    		params.put("workOrderFlags", workOrderCommonQueryDto.getWorkOrderFlags());
    		params.put("siteCode", workOrderCommonQueryDto.getSiteCode());
    		params.put("orderTypes", workOrderCommonQueryDto.getOrderTypes());
    		params.put("maintenanceTypes", workOrderCommonQueryDto.getMaintenanceTypes());
    		params.put("workOrderNo", workOrderCommonQueryDto.getWorkOrderNo());
    		String result = ispConsumer.workOrderQuery(params);
            return new RestResponse<>(result);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }
    
    @ApiOperation(value = "维修历史查询详情接口", notes = "维修历史查询详情接口", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/apig/third/work/order/common/detail", method = RequestMethod.GET)
    @ApiOperationSupport(order = 6)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "workOrderNo", value = "isp维修历史查询参数类", required = true, paramType ="query", dataType = "String")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<String> workOrderQueryDetail(@RequestParam(value="workOrderNo", required=true) String workOrderNo) {
        try {
    		String result = ispConsumer.workOrderQueryDetail(workOrderNo);
            return new RestResponse<>(result);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }
    
}
