package com.exp.ucmp.notice.service;

import java.util.Map;

import com.exp.ucmp.huawei.dto.RelationNumDto;
import com.exp.ucmp.huawei.dto.VoiceCallDto;
import com.exp.ucmp.huawei.dto.VoiceCallbackDto;

public interface VoiceService {

	RelationNumDto voiceCall(VoiceCallDto voiceCallDto) throws Exception;
	
	void stopCall(String sessionid) throws Exception;

	void callback(VoiceCallbackDto voiceCallbackDto) throws Exception;

	Map<String, String> axbUnbindNumber(VoiceCallDto voiceCallDto) throws Exception;

	Map<String, String> axbQueryBindRelation(VoiceCallDto voiceCallDto) throws Exception;

	Boolean callOutInfo(Long reservationId) throws Exception;



}
