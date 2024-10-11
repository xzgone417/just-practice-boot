package com.exp.ucmp.carDealer.web;

import com.egrid.core.json.body.JsonPropFilter;
import com.egrid.core.web.response.RestResponse;
import com.egrid.core.web.response.RestStatusCode;
import com.exp.ucmp.carDealer.service.AcquisitionFollowService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author GeYiJiang
 * @Description: 手机号加密
 * @date 2022/11/17 15:29
 */
@Api(value = "DecryptionController.API", tags = "手机号加密")
@Controller
public class DecryptionController {

    @Autowired
    private AcquisitionFollowService acquisitionFollowService;

    private static final Logger LOGGER = LoggerFactory.getLogger(DecryptionController.class);

    @ApiOperation(value = "单一手机号加密", notes = "单一手机号加密", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/decryption/phone", method = RequestMethod.GET)
    @JsonPropFilter(type = String.class)
    public RestResponse<String> decryptionPhone(@RequestParam("phone") String phone){
        return new RestResponse<>(acquisitionFollowService.decryptionPhone(phone));
    }

    @ApiOperation(value = "数据库手机号加密", notes = "数据库手机号加密", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/decryption", method = RequestMethod.GET)
    @JsonPropFilter(type = String.class)
    public RestResponse<String> decryption(){
        try {
            acquisitionFollowService.updateData();
            return new RestResponse<>(RestStatusCode.OK,"OK");
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR,e.getMessage());
        }
    }
}
