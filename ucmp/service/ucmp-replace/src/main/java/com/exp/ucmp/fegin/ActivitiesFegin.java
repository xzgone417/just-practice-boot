package com.exp.ucmp.fegin;

import com.egrid.core.json.body.JsonPropFilter;
import com.egrid.core.web.response.RestResponse;
import com.exp.ucmp.urc.dto.RightsGrantDto;
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

@FeignClient(value="ucmp-system", contextId="activitiesFegin")
public interface ActivitiesFegin {

    @ApiOperation(value = "URC(权益发放)", notes = "权益发放", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/urc/rightsGrant", method = RequestMethod.POST)
    @ApiOperationSupport(order = 3)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "rightsGrantDto", value = "权益发放参数类", required = true, paramType = "body", dataType = "RightsGrantDto")})
    @JsonPropFilter(type = Long.class)
    RestResponse<Long> rightsGrant(@RequestBody @Valid RightsGrantDto rightsGrantDto);
}
