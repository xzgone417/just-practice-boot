/**
 * 
 * 初米网络
 * Copyright (C) 2018 Egridcloud, Inc, All rights reserved.
 */
package com.exp.ucmp.auth.service;

import java.util.List;

import com.exp.ucmp.auth.dto.PermissionIdentifierDto;
import com.exp.ucmp.auth.dto.StaffDto;
import com.exp.ucmp.auth.dto.SystemMenuDto;
import com.exp.ucmp.constant.Constants;
import com.egrid.shiro.model.SystemMenu;
import com.exp.ucmp.model.Person;

/**
 * @author Yiyongfei
 */
public interface AuthService {
	public final Long hrytPartyId = 1366656669688804579L;
	
    /**
     * 获取自然人信息
     * @param partyId 自然人
     * @return
     */
    Person loadPersonById(String loginName);
    
    /**
     * 获取某用户所属角色所有权限
     * @param partyId 自然人
     * @return
     */
    List<PermissionIdentifierDto> listRolePermissionByLoginid(Long partyId, Long roleId);
    /**
     * 获取指定角色
     * @param partyId 自然人
     * @return
     */
    SystemMenu listMenuByLoginid(Long partyId, Long roleId);
    /**
     * 给菜单附加扩展信息
     * @param menu
     * @return
     */
    SystemMenu handleMenuExtendedInfo(SystemMenu menu);
    
    /**
     * 给用户发送验证码，并返回验证码
     * 
     * @param loginName 用户
     * @return 验证码
     */
    String sendVerificationCode(String loginName);
    
    StaffDto loadStaffById(Long partyId, String orgId, Constants.StaffType staffType);

	List<SystemMenuDto> transform(SystemMenu systemMenu);

	String checkStroe(String orgId);

	String checkIsControls();
}
