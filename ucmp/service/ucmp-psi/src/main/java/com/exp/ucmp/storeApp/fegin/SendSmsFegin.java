package com.exp.ucmp.storeApp.fegin;

import com.egrid.core.json.body.JsonPropFilter;
import com.egrid.core.web.response.RestResponse;
import com.egrid.core.web.response.RestStatusCode;
import com.exp.ucmp.huawei.dto.SmsParamsDto;
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

@FeignClient(value="ucmp-system", contextId="SendSmsFegin")
public interface SendSmsFegin {


    /**
     * <p>Description: 华为云发送短信</p>
     * @return
     */
    @ApiOperation(value = "发送短信", notes = "发送短信", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/huawei/batchSendSms", method = RequestMethod.POST)
    @ApiOperationSupport(order = 1)
    @JsonPropFilter(type = String.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "smsParamsDto", value = "华为云短信消息", required = false, paramType ="body", dataType = "SmsParamsDto")
    })
    public RestResponse<String> batchSendSms(@RequestBody @Valid SmsParamsDto smsParamsDto);
}
