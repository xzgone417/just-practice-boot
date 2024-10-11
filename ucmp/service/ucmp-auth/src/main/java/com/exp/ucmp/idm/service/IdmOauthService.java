package com.exp.ucmp.idm.service;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.egrid.core.web.response.RestResponse;
import com.exp.ucmp.auth.dto.IdmUserDto;
import com.exp.ucmp.model.LoginResult;

public interface IdmOauthService {

	String buildIdmUrl() throws Exception;

	void callback(HttpServletResponse response, HttpServletRequest request, String code, String target_uri, String access_token) throws IOException;

	String getToken(String code) throws Exception;

	String getTokenInfo(String code) throws Exception;

	IdmUserDto getUserInfo(String accessToken);

	Map<String, String> sendSecurityCodeDto(String mobile) throws Exception;

	Map<String, Object> getAccessTokenBySMS(String uid, String pwd) throws Exception;

	Map<String, String> getTokenByPwd(String uid, String pwd) throws Exception;
	
}
