package com.exp.ucmp.customer.service;


import com.exp.ucmp.urm.dto.UserDto;

public interface CustomerInfoService {

	public UserDto getUserInfo(String superIds) throws Exception;

	public UserDto getUserInfoByInquiryId(String inquiryId);

}
