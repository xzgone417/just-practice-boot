package com.exp.ucmp.user.service;

import com.exp.ucmp.idm.dto.IdmAccountStatusDto;
import com.exp.ucmp.idm.dto.IdmUserDto;
import com.exp.ucmp.idm.dto.IdmUserStatusDto;

public interface IdmUserService {

	String createUser(IdmUserDto idmUserDto) throws Exception;

	String updateUser(IdmUserDto idmUserDto) throws Exception;

	String updateUserStatus(IdmUserStatusDto idmUserStatusDto) throws Exception;

	String updateAccountStatus(IdmAccountStatusDto idmAccountStatusDto) throws Exception;

}
