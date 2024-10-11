package com.exp.ucmp.user.service;

import java.util.List;

import com.exp.ucmp.eos.dto.AccountInfoDto;

public interface EosUserService {

	AccountInfoDto getUserAndSuperiorInfo(String token, String idmAccountName, int isCreate) throws Exception;

	List<AccountInfoDto> allUsersInTheDepartment(String departmentCode) throws Exception;

}
