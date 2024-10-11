package com.exp.ucmp.fegin;

import com.egrid.core.web.response.RestResponse;
import com.exp.ucmp.tsp.dto.RegAndLoginDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="ucmp-system", contextId="systemFegin")
public interface SystemFegin {

	//手机号获取用户ID
    @RequestMapping(value = "/api/urm/getTokenByAccount", method = RequestMethod.GET)
    public RestResponse<String> urmUserUid(@RequestParam(value = "mobile", required = true) String mobile);

    //手机号直接注册登入
    @RequestMapping(value = "/api/idmc/mobilePhoneRegAndLogin", method = RequestMethod.POST)
    public RestResponse<String> mobilePhoneRegAndLogin(@RequestBody RegAndLoginDto regAndLoginDto);
}
