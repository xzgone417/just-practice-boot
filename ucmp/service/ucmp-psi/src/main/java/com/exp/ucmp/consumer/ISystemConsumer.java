/**
 * 
 * 初米网络
 * Copyright (C) 2019 Egridcloud, Inc, All rights reserved.
 */
package com.exp.ucmp.consumer;

import java.util.List;

import com.exp.ucmp.car.dto.CarMainInfoDto;
import com.exp.ucmp.config.dto.SysParamConfigDto;
import com.exp.ucmp.eos.dto.GiveMessageParamDto;
import com.exp.ucmp.huawei.dto.SmsParamsDto;
import com.exp.ucmp.logistics.dto.DispatchRequestDto;
import com.exp.ucmp.pricing.PriceTrialDto;
import com.exp.ucmp.pricing.PriceTrialResultDto;
import com.exp.ucmp.pricing.PricingStrategyDto;
import com.exp.ucmp.pricing.PricingStrategySectionDto;
import com.exp.ucmp.tsp.dto.RegAndLoginDto;
import com.exp.ucmp.usc.dto.CreateEvaluationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.egrid.core.web.response.RestResponse;
import com.exp.ucmp.pertner.dto.SysPartnerStoreDto;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;


/**
 * 系统服务
 * @author Administrator
 */
@FeignClient(value="ucmp-system", contextId="SystemConsumer")
public interface ISystemConsumer {

	@RequestMapping(value = "/api/partnerInfo/findStoreIdByStaff", method = RequestMethod.POST)
    public RestResponse<List<Long>> findStoreByCurrPartnerStaff();

	@RequestMapping(value = "/api/partnerInfo/findStaffIdByStoreByAuto", method = RequestMethod.POST)
    public RestResponse<List<Long>> findPartnerStaffByStoreByAuto(@RequestBody SysPartnerStoreDto sysPartnerStoreDto);

    @RequestMapping(value = "/api/partnerInfo/findStaffIdByStore", method = RequestMethod.POST)
    public RestResponse<List<Long>> findPartnerStaffByStore(@RequestBody SysPartnerStoreDto sysPartnerStoreDto);
	
	@RequestMapping(value = "/api/partnerInfo/findStaffId", method = RequestMethod.POST)
    public RestResponse<List<Long>> findPartnerStaff(@RequestBody SysPartnerStoreDto sysPartnerStoreDto);

	//消息推送接口
//    @RequestMapping(value = "/api/eos/sendMessage", method = RequestMethod.POST)
//    public RestResponse<String> sendMessage(@RequestBody @Valid MessageParamDto messageParamDto);

    @RequestMapping(value = "/api/slf/giveMessage", method = RequestMethod.POST)
    public RestResponse<String> giveMessage(@RequestBody @Valid GiveMessageParamDto messageParamDto);

    //查询系统设置时间
    @RequestMapping(value = "/api/parameterConfig/findByType", method = RequestMethod.GET)
    public RestResponse<SysParamConfigDto> findByType(@RequestParam("parameterType") String parameterType);

    //华为云发送短信
    @RequestMapping(value = "/api/huawei/batchSendSms", method = RequestMethod.POST)
    public RestResponse<String> batchSendSms(@RequestBody @Valid SmsParamsDto smsParamsDto);

    //创建评价单
    @RequestMapping(value = "/api/usc/createEvaluation", method = RequestMethod.POST)
    public RestResponse<String> createEvaluation(@RequestBody CreateEvaluationDto createEvaluationDto);

    //价格试算
    @RequestMapping(value = "/api/pricingConfig/priceTrial", method = RequestMethod.POST)
    public RestResponse<PriceTrialResultDto> priceTrial(@RequestBody PriceTrialDto params);

    /**Description: 查询定值定价策略*/
    @RequestMapping(value = "/api/pricingConfig/find", method = RequestMethod.GET)
    public RestResponse<List<PricingStrategyDto>> find();

    /**Description: 查询区间定价策略*/
    @RequestMapping(value = "/api/pricingConfig/findSection", method = RequestMethod.GET)
    public RestResponse<List<PricingStrategySectionDto>> findSection();

    //获取车辆基础数据
    @RequestMapping(value = "/api/basics/getCarseries", method = RequestMethod.GET)
    public RestResponse<CarMainInfoDto> getCarMainInfo(@RequestParam(value = "carVin", required = true) String carVin,@RequestParam(value = "stockId", required = false) Long stockId);

    //手机号获取用户ID
    @RequestMapping(value = "/api/urm/getTokenByAccount", method = RequestMethod.GET)
    public RestResponse<String> urmUserUid(@RequestParam(value = "mobile", required = true) String mobile);

    //手机号直接注册登入
    @RequestMapping(value = "/api/idmc/mobilePhoneRegAndLogin", method = RequestMethod.POST)
    public RestResponse<String> mobilePhoneRegAndLogin(@RequestBody RegAndLoginDto regAndLoginDto);


        //提交调拨申请到VLMS
    @RequestMapping(value = "/api/vlms/submit/transfer/application", method = RequestMethod.POST)
    public RestResponse<String> submitTransferApplication(@RequestBody @Valid DispatchRequestDto dispatchRequestDto);
}
