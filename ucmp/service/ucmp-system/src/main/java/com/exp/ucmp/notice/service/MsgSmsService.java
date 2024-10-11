package com.exp.ucmp.notice.service;


import com.exp.ucmp.huawei.dto.SmsParamsDto;

public interface MsgSmsService {

	void batchSendSms(SmsParamsDto smsParamsDto) throws Exception;


}
