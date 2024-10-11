package com.exp.ucmp.notice.service;


import javax.validation.Valid;

import com.exp.ucmp.eos.dto.*;

public interface EosMessageService {

	EosReturnDto<String> sendMessage(@Valid MessageParamDto messageParamDto) throws Exception;

	EosReturnDto<String> giveMessage(@Valid GiveMessageParamDto messageParamDto) throws Exception;

	UserAndSuperiorInfoDto getUserAndHigherLevel(String userId, int isCreate, String token) throws Exception;

}
