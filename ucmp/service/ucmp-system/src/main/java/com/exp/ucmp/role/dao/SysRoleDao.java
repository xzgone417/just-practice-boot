package com.exp.ucmp.role.dao;


import com.exp.ucmp.department.dto.SysDepartmentInfoDto;
import com.exp.ucmp.entity.ResourceInfoEntity;
import com.exp.ucmp.entity.SysDepartmentInfoEntity;
import com.exp.ucmp.entity.SysRoleDetailsEntity;
import com.exp.ucmp.role.dto.ResourceContentDto;
import com.exp.ucmp.role.dto.ResourceInfoDto;
import com.exp.ucmp.role.dto.RolePermissionRelaDto;
import com.exp.ucmp.role.dto.SysRoleDetailsDto;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * @author zhouchengwei
 * @date 2022/08/11
 * 查询角色信息
 */
public interface SysRoleDao {

    /**
     * Description: 根据条件查询集合实体(角色信息)
     * @param sysRoleDetailsDto 查询条件
     * @return 实体集合
     */
    public List<SysRoleDetailsDto> selectRoleMsg(SysRoleDetailsDto sysRoleDetailsDto);



    /**
     * Description: 查询角色类型
     * @return 角色类型
     */
    public List<String> selectRoleType();



    /**
     * Description: 查询资源,权限，操作相关的权限信息总和
     * @param resourceContentDto 查询条件
     * @param type 
     * @return 实体集合
     */

    public List<ResourceContentDto> selectOpeMag(@Param("resourceId")Long resourceId,@Param("type") int type);



    /**
     * Description: 根据条件查询集合实体(角色授权信息菜单)
     * @param resourceInfoDto 查询条件
     * @return 实体集合
     */

    public List<ResourceInfoDto> selectOpeTree(ResourceInfoDto resourceInfoDto);

    /**
     * Description: 查询角色权限关系
     * @param roleId 查询条件
     * @return 实体集合
     */

    public List<RolePermissionRelaDto> selectRolePerRel(Long roleId);

    /**
     * Description: 查询角色类型
     * @param roleId 查询条件
     * @return 实体集合
     */

	public String getRoleType(Long roleId);

















}
