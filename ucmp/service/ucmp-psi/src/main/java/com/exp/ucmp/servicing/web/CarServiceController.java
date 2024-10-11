package com.exp.ucmp.servicing.web;

import com.egrid.core.json.body.JsonPropFilter;
import com.egrid.core.web.response.RestResponse;
import com.egrid.core.web.response.RestStatusCode;
import com.exp.ucmp.servicing.dto.OfflineServiceDto;
import com.exp.ucmp.servicing.service.CarServiceService;
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


@Api(value = "CarServiceController.API", tags = "线下整备相关接口")
@Controller
public class CarServiceController {
    /**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(CarServiceController.class);

    @Autowired
    private CarServiceService serviceService;
    
    @ApiOperation(value = "线下整备完成批量", notes = "线下整备完成批量", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/v1/car/service/complete", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "offlineServiceDto", value = "线下整备车辆信息", required = true, paramType ="body", dataType = "OfflineServiceDto"),
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<Boolean> completeCarService(@RequestBody OfflineServiceDto offlineServiceDto) {
        try {
        	serviceService.completeCarService(offlineServiceDto);
            return new RestResponse<>(RestStatusCode.OK,true);
        } catch (Exception e) {
            LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
            return new RestResponse<>(RestStatusCode.SERVER_UNKNOWN_ERROR);
        }
    }

}
