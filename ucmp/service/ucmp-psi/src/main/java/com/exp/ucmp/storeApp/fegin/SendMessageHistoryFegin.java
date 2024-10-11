package com.exp.ucmp.storeApp.fegin;


import com.egrid.core.json.body.JsonPropFilter;
import com.egrid.core.web.response.RestResponse;
import com.exp.ucmp.entity.PsiMessageInfoEntity;
import com.exp.ucmp.eos.dto.MessageParamDto;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@FeignClient(value="ucmp-psi", contextId="SendMessageHistoryFegin")

public interface SendMessageHistoryFegin {


    @ApiOperation(value = "插入消息推送记录", notes = "插入消息推送记录", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/message/insertMessage", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "entity", value = "消息模板表", required = true, paramType ="body", dataType = "PsiMessageInfoEntity")
    })
    @JsonPropFilter(type = Boolean.class)
    public RestResponse<Boolean> updateInquiryApprovalStatus(@RequestBody PsiMessageInfoEntity entity);
}
