package com.exp.ucmp.storeApp.fegin;


import com.egrid.core.json.body.JsonPropFilter;
import com.egrid.core.web.response.RestResponse;
import com.exp.ucmp.entity.PsiMessageInfoEntity;
import com.exp.ucmp.eos.dto.GiveMessageParamDto;
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

@FeignClient(value="ucmp-system", contextId="SendMessageFegin")

public interface SendMessageFegin {

//    /**
//     * <p>Description: 推送展厅站内信息</p>
//     * @return
//     */
//    @ApiOperation(value = "推送展厅站内信息", notes = "推送展厅站内信息", produces = MediaType.APPLICATION_JSON_VALUE)
//    @RequestMapping(value = "/api/eos/sendMessage", method = RequestMethod.POST)
//    @ApiOperationSupport(order = 3)
//    @JsonPropFilter(type = String.class)
//    @ApiImplicitParams({
//            @ApiImplicitParam(name = "messageParamDto", value = "eos消息推送参数类", required = false, paramType ="body", dataType = "MessageParamDto")
//    })
//    public RestResponse<String> sendMessage(@RequestBody @Valid MessageParamDto messageParamDto);
    @RequestMapping(value = "/api/slf/giveMessage", method = RequestMethod.POST)
    public RestResponse<String> giveMessage(@RequestBody @Valid GiveMessageParamDto messageParamDto);

}
