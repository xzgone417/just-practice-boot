package com.exp.ucmp.replacement.feign;


import com.egrid.core.json.body.JsonPropFilter;
import com.egrid.core.web.response.RestResponse;
import com.exp.ucmp.carDealer.dto.UpdateInquiryApprovalStatusDto;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value="ucmp-psi", contextId="ApprovalStatus")
public interface ApprovalStatus {
	
    @ApiOperation(value = "更新询价表审批状态", notes = "更新询价表审批状态", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/acquisition/updateInquiryApprovalStatus", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "paramDto", value = "更新询价表审批状态参数", required = true, paramType ="body", dataType = "UpdateInquiryApprovalStatusDto")
    })
    @JsonPropFilter(type = Boolean.class)
    public RestResponse<Boolean> updateInquiryApprovalStatus(@RequestBody UpdateInquiryApprovalStatusDto paramDto);
}
