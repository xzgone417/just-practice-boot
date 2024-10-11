package com.exp.ucmp.role.service;

import com.exp.ucmp.department.dto.SysDepartmentInfoDto;
import com.exp.ucmp.entity.SysRoleDetailsEntity;
import com.exp.ucmp.role.dto.ResourceInfoDto;
import com.exp.ucmp.role.dto.RolePermissionRelaDto;
import com.exp.ucmp.role.dto.SysRoleDetailsDto;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author zhouchengwei
 * @date 2022年08月11日
 */

public interface SysRoleService {

    /**
     * Description: 根据条件查询集合实体(角色信息)
     * @param sysRoleDetailsDto 查询条件
     * @return 实体集合
     */
    public PageInfo<SysRoleDetailsDto> queryRoleMsg(SysRoleDetailsDto sysRoleDetailsDto) ;





    /**
     * Description: 新增角色信息
     * @param sysRoleDetailsDto 新增内容
     */
    public void addRoleMsg(SysRoleDetailsDto sysRoleDetailsDto);

    /**
     * Description: 修改角色信息
     * @param sysRoleDetailsDto 修改内容
     */
    public void modifyRoleMsg(SysRoleDetailsDto sysRoleDetailsDto);

    /**
     * Description: 维护角色权限信息信息
     * @param rolePermissionRelaDto 修改内容
     */
    public void modifyRolePower(RolePermissionRelaDto rolePermissionRelaDto);


    /**
     * Description: 根据条件查询集合实体(角色授权信息菜单)
     * @param resourceInfoDto 查询条件
     * @return 实体集合
     */

    public List<ResourceInfoDto> queryRoleMenuList(ResourceInfoDto resourceInfoDto) ;

    /**
     * Description: 删除部门信息
     */
    public void delRoleMsg(SysRoleDetailsDto sysRoleDetailsDto);


    /**
     * Description: 查询角色类型
     * @return 角色类型
     */
    public List<String> QueryRoleType();

    /**
     * 角色类型下拉列表查询
     * @return
     */
    List<SysRoleDetailsDto> findSelectRoleType();
}
