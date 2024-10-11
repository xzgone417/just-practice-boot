package com.exp.ucmp.pay.web;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.egrid.core.json.body.JsonPropFilter;
import com.egrid.core.util.JsonBeanUtil;
import com.egrid.core.web.response.RestResponse;
import com.egrid.core.web.response.RestStatusCode;
import com.exp.ucmp.entity.SysPayConfigEntity;
import com.exp.ucmp.mall.dto.MallReturnDto;
import com.exp.ucmp.pay.dto.AddPaymentRecordDto;
import com.exp.ucmp.pay.dto.PayCallBackDto;
import com.exp.ucmp.pay.dto.PayDto;
import com.exp.ucmp.pay.dto.PayRefundDto;
import com.exp.ucmp.pay.dto.QueryOrderInfoDto;
import com.exp.ucmp.pay.dto.QueryOrderParamsDto;
import com.exp.ucmp.pay.service.PayService;
import com.exp.ucmp.sap.dto.SapBankTransferStatementDto;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author xiongneng
 * @date 2023年09月15日
 */
@Api(tags = "同步SAP流水数据")
@RestController
@RequestMapping("/api/sap")
public class PaySapController {

	/**
	 * <p>
	 * Field LOGGER: log
	 * </p>
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(PaySapController.class);

	@Autowired
	PayService payService;
	
	@ApiOperation(value = "接收银行收款流水", notes = "接收银行收款流水", produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/syn/bank/transfer/statement", method = RequestMethod.POST)
	@ApiOperationSupport(order = 1)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "sapBankTransferStatementDto", value = "银行收款流水参数类", required = true, paramType = "body", dataType = "List<SapBankTransferStatementDto>")})
	@JsonPropFilter(type = MallReturnDto.class)
	public Map<String, String> bankTransferStatement(@RequestBody List<SapBankTransferStatementDto> sapBankTransferStatementDto) {
		LOGGER.info("====接收银行收款流水===="+JsonBeanUtil.beanToJson(sapBankTransferStatementDto));
		Map<String,String> resultMap=new HashMap<>();
		int result=0 ;
		try {
			for (SapBankTransferStatementDto dto : sapBankTransferStatementDto) {
				result = payService.bankTransferStatement(dto);
			}
			if(result<0){
				resultMap.put("Code", "E");
				resultMap.put("Desc", "接收失败,流水已存在");
			}else{
				resultMap.put("Code", "S");
				resultMap.put("Desc", "接收成功");
			}
		} catch (Exception e) {
			LOGGER.error(RestStatusCode.SERVER_UNKNOWN_ERROR.message(), e);
			resultMap.put("Code", "E");
			resultMap.put("Desc", "接收失败"+e.getMessage());
		}
		return resultMap;
	}
}
