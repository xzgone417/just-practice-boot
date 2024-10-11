package com.exp.ucmp.fegin;

import com.egrid.core.json.body.JsonPropFilter;
import com.egrid.core.web.response.RestResponse;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="ucmp-system", contextId="pointsFegin")
public interface PointsFegin {

    @ApiOperation(value = "根据积分任务发放积分", notes = "根据积分任务发放积分", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/api/urm/pointsTask/points/grant", method = RequestMethod.GET)
    @ApiOperationSupport(order = 1)
    @ApiImplicitParams({
    	@ApiImplicitParam(name = "pointsValue", value = "积分值", required = false, paramType ="query", dataType = "int"),
    	@ApiImplicitParam(name = "superId", value = "superId", required = true, paramType ="query", dataType = "String")
    })
    @JsonPropFilter(type = String.class)
    public RestResponse<String> urmGrantPoints(@RequestParam(value="pointsValue", required=false) int pointsValue,@RequestParam(value="superId", required=true) String superId);
}
