package com.exp.ucmp.user.service;



import com.exp.ucmp.urm.dto.UserDto;

public interface UrmUserService {

	UserDto userProfilesQuery(String superIds) throws Exception;

	String urmUserUid(String mobile) throws Exception;

	String urmGrantPoints(int pointsValue, String superId) throws Exception;

}
