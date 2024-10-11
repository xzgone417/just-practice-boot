package com.exp.ucmp.carDealer.web;

import com.egrid.core.json.body.JsonPropFilter;
import com.egrid.core.web.response.RestResponse;
import com.egrid.core.web.response.RestStatusCode;
import com.exp.ucmp.carDealer.dto.UpdateInquiryApprovalStatusDto;
import com.exp.ucmp.carDealer.service.MessagePushService;
import com.exp.ucmp.entity.PsiMessageInfoEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Api(value = "Message.API", tags = "消息相关的接口")
@Controller
public class MessageInfoController {
    /**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageInfoController.class);

    @Autowired
    private MessagePushService messagePushService;

    @ApiOperation(value = "插入消息推送记录", notes = "插入消息推送记录", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/message/insertMessage", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "entity", value = "消息模板表", required = true, paramType ="body", dataType = "PsiMessageInfoEntity")
    })
    @JsonPropFilter(type = Boolean.class)
    public RestResponse<Boolean> updateInquiryApprovalStatus(@RequestBody PsiMessageInfoEntity entity){
        try {
            messagePushService.insertMessage(entity);
            return new RestResponse<>(RestStatusCode.OK);
        }catch (Exception e){
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR, e);
        }
    }
}
