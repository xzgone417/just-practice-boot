/**
 * 
 * 初米网络
 * Copyright (C) 2022 Egridcloud, Inc, All rights reserved.
 */
package com.exp.ucmp.auth.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.exp.ucmp.auth.dto.PermissionIdentifierDto;
import com.exp.ucmp.entity.SysMenuExtendedInfoEntity;
import com.exp.ucmp.model.Person;
import com.egrid.shiro.model.Menu;

/**
 * @author Yiyongfei
 */
public interface AuthDao {
    
    /**
     * <p>Description: 根据PartyId获取人员信息</p>
     * @param partyId partyId
     * @return Person
     */
    public List<Person> selectPersonByloginname(String loginname);
    
    /**
     * 角色不提供的情况下, 获取某个用户对应角色的所有权限, 否则获取相应角色的权限
     * @param partyId
     * @param roleId
     * @return
     */
    public List<PermissionIdentifierDto> listRolePermissionByLoginid(@Param("partyId") Long partyId, @Param("roleId") Long roleId);
    
    /**
     * 获取相应菜单
     * @param partyId
     * @param roleId
     * @param roleType 
     * @return
     */
    public List<Menu> permissionMenuQuery(@Param("partyId") Long partyId, @Param("roleId") Long roleId,@Param("roleType") String roleType);

    /**
     * 获取父级菜单
     * @param menuIds
     * @return
     */
    public List<Menu> parentMenuQuery(@Param("menuIds") List<Menu> menuIds);
    
    /**
     * 获取指定用户的员工信息（包括门店或合作商的状态信息）
     * @param partyId
     * @return
     */
    public List<Map<String, Object>> selectStaffById(@Param("partyId") Long partyId);
    
    public List<SysMenuExtendedInfoEntity> selectMenuExtendedInfo(SysMenuExtendedInfoEntity entity);

	public List<String> getRoleType(@Param("partyId") Long partyId);

	public String checkStroe(String orgId);

	public String checkIsControls();
}
