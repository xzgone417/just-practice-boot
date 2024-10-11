package com.exp.ucmp.servicing.fegin;

import com.egrid.core.json.body.JsonPropFilter;
import com.egrid.core.web.response.RestResponse;
import com.exp.ucmp.isp.dto.QuoteApplyDto;
import com.exp.ucmp.isp.dto.QuoteApprovalDto;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value="ucmp-system", contextId="servicingFegin")
public interface ServicingFegin {

	@ApiOperation(value = "创建整备", notes = "创建整备", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/api/servicing/create", method = RequestMethod.POST)
	@ApiOperationSupport(order = 1)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "dto", value = "参数信息", required = true, paramType ="body", dataType = "QuoteApplyDto")})
	@JsonPropFilter(type = String.class)
	public RestResponse<String> createServicing(@RequestBody QuoteApplyDto dto);
	
	@ApiOperation(value = "预估报价单审批接口", notes = "预估报价单审批接口", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/quote/approval", method = RequestMethod.POST)
    @ApiOperationSupport(order = 2)
    @ApiImplicitParams({
        @ApiImplicitParam(name = "quoteApprovalDto", value = "预估报价单审批参数", required = true, paramType ="body", dataType = "QuoteApprovalDto")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<String> quoteApproval(@RequestBody QuoteApprovalDto quoteApprovalDto);
}
