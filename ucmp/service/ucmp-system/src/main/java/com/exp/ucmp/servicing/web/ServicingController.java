package com.exp.ucmp.servicing.web;




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
import com.exp.ucmp.isp.dto.QueryOrderHistoryDto;
import com.exp.ucmp.isp.dto.QuoteApplyDto;
import com.exp.ucmp.isp.dto.QuoteApprovalDto;
import com.exp.ucmp.isp.dto.QuoteOrderDto;
import com.exp.ucmp.isp.dto.QuoteStatusDto;
import com.exp.ucmp.isp.dto.WorkOrderCommonQueryDto;
import com.exp.ucmp.mall.dto.MallReturnDto;
import com.exp.ucmp.servicing.dto.OrderDetailDto;
import com.exp.ucmp.servicing.dto.QueryWorkOrderCommonDto;
import com.exp.ucmp.servicing.dto.QueryWorkOrderDto;
import com.exp.ucmp.servicing.service.ServicingService;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author xiongneng
 * @date 2023年02月20日
 */
@Api(value = "整备服务", tags = "整备服务")
@RefreshScope
@Controller
public class ServicingController {
	
	/**
	 * <p>
	 * Field LOGGER: log
	 * </p>
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(ServicingController.class);

	@Autowired
	private ServicingService servicingService;
	
	@ApiOperation(value = "创建整备", notes = "创建整备", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/api/servicing/create", method = RequestMethod.POST)
	@ApiOperationSupport(order = 1)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "dto", value = "参数信息", required = true, paramType ="body", dataType = "QuoteApplyDto")})
	@JsonPropFilter(type = String.class)
	public RestResponse<String> createServicing(@RequestBody QuoteApplyDto dto) {
		try {
			LOGGER.info("====创建整备dto===="+JsonBeanUtil.beanToJson(dto));
			String result = servicingService.createServicing(dto);
			LOGGER.info("====创建整备result===="+result);
			return new RestResponse<>(result);
		} catch (Exception e) {
			LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
			return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
		}
	}
	
	@ApiOperation(value = "接收ISP反馈报价单", notes = "接收ISP反馈报价单", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/api/servicing/accept/repair/project", method = RequestMethod.POST)
	@ApiOperationSupport(order = 2)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "dto", value = "参数信息", required = true, paramType ="body", dataType = "QuoteOrderDto")})
	@JsonPropFilter(type = String.class)
	public MallReturnDto<String> acceptRepairProject(@RequestBody QuoteOrderDto dto) {
		MallReturnDto<String> returnDto=new MallReturnDto<>();
		try {
			LOGGER.info("===接收ISP反馈报价单==="+JsonBeanUtil.beanToJson(dto));
			servicingService.acceptRepairProject(dto);
			returnDto.setCode("000000");
            returnDto.setMsg("请求处理成功");
		} catch (Exception e) {
			LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
			returnDto.setCode("50001");
            returnDto.setMsg(e.getMessage());
		}
		return returnDto;
	}
	
	@ApiOperation(value = "接收isp整备状态变更通知", notes = "接收isp整备状态变更通知", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/api/servicing/accept/repair/status/change", method = RequestMethod.POST)
	@ApiOperationSupport(order = 3)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "dto", value = "参数信息", required = true, paramType ="body", dataType = "QuoteStatusDto")})
	@JsonPropFilter(type = String.class)
	public MallReturnDto<String> acceptRepairStatus(@RequestBody QuoteStatusDto dto) {
		MallReturnDto<String> returnDto=new MallReturnDto<>();
		try {
			LOGGER.info("===接收isp整备状态变更通知==="+JsonBeanUtil.beanToJson(dto));
			servicingService.acceptRepairStatus(dto);
			returnDto.setCode("000000");
            returnDto.setMsg("请求处理成功");
		} catch (Exception e) {
			LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
			returnDto.setCode("50001");
            returnDto.setMsg(e.getMessage());
		}
		return returnDto;
	}
	
	@ApiOperation(value = "预估报价单审批接口", notes = "预估报价单审批接口", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/quote/approval", method = RequestMethod.POST)
    @ApiOperationSupport(order = 4)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "quoteApprovalDto", value = "预估报价单审批参数", required = true, paramType ="body", dataType = "QuoteApprovalDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<String> quoteApproval(@RequestBody QuoteApprovalDto quoteApprovalDto) {
        try {
        	String result = servicingService.quoteApproval(quoteApprovalDto);
            return new RestResponse<>(result);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }
	
	@ApiOperation(value = "历史维修数据查询", notes = "历史维修数据接口", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/work/order/ucmp/history", method = RequestMethod.POST)
    @ApiOperationSupport(order = 5)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "queryOrderHistoryDto", value = "查询维修历史数据参数类", required = true, paramType ="body", dataType = "QueryOrderHistoryDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<QueryWorkOrderDto> workOrderHistory(@RequestBody QueryOrderHistoryDto queryOrderHistoryDto) {
        try {
        	QueryWorkOrderDto result = servicingService.workOrderHistory(queryOrderHistoryDto);
    		return new RestResponse<>(result);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }
	
	@ApiOperation(value = "维修历史查询接口", notes = "维修历史查询接口", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/work/order/common/query", method = RequestMethod.POST)
    @ApiOperationSupport(order = 6)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "workOrderCommonQueryDto", value = "isp维修历史查询参数类", required = true, paramType ="body", dataType = "WorkOrderCommonQueryDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<QueryWorkOrderCommonDto> workOrderQuery(@RequestBody WorkOrderCommonQueryDto workOrderCommonQueryDto) {
        try {
        	QueryWorkOrderCommonDto result = servicingService.workOrderQuery(workOrderCommonQueryDto);
            return new RestResponse<>(result);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }
	
	@ApiOperation(value = "维修历史查询详情接口", notes = "维修历史查询详情接口", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/work/order/common/query/details", method = RequestMethod.GET)
    @ApiOperationSupport(order = 7)
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "workOrderNo", value = "isp维修历史查询参数类", required = true, paramType ="query", dataType = "String")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<OrderDetailDto> workOrderQueryDetails(@RequestParam(value="workOrderNo", required=true) String workOrderNo) {
        try {
        	OrderDetailDto result = servicingService.workOrderQueryDetails(workOrderNo);
            return new RestResponse<>(result);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }
	
}
