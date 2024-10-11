package com.exp.ucmp.staff.dao;

import com.exp.ucmp.area.dto.SysAreaInfoDto;
import com.exp.ucmp.entity.SysStaffDetailsEntity;
import com.exp.ucmp.staff.dto.SysAreaInfoQueryDto;
import com.exp.ucmp.staff.dto.SysStaffDetailsDto;
import com.exp.ucmp.staff.dto.SysStaffDetailsAddDto;
import com.exp.ucmp.staff.dto.SysStaffDetailsRoleQueryDto;

import java.util.List;

/**
 * @author zhouchengwei
 * @date 2022/08/09
 * 查询人员信息
 */
public interface SysStaffDetailsDao {
    /**
     * Description: 根据条件查询集合实体(人员信息)
     * @param sysStaffDetailsDto 查询条件
     * @return 实体集合
     */
    public List<SysStaffDetailsDto> selectStaffMsg(SysStaffDetailsDto sysStaffDetailsDto);



    /**
     * Description: 查询添加的人员信息(查询添加的人员信息)
     * @param sysStaffDetailsDto 查询条件
     * @return 实体集合
     */
    public List<SysStaffDetailsDto> selectAddStaffMsg(SysStaffDetailsDto sysStaffDetailsDto);


    /**
     * Description: 查询人员状态
     * @return 人员状态类型
     */
    public List<String> selectStaffStatus();

    /**
     * Description: 根据条件查询集合实体(人员信息)
     * @param sysStaffDetailsRoleQueryDto 查询条件
     * @return 实体集合
     */
    public List<SysStaffDetailsRoleQueryDto> selectStaffRole(SysStaffDetailsRoleQueryDto sysStaffDetailsRoleQueryDto);




    /**
     * Description: 人员区域查询
     * @param sysAreaInfoQueryDto 查询条件
     */
    public List<SysAreaInfoDto> selectStaffArea(SysAreaInfoQueryDto sysAreaInfoQueryDto);

    List<SysStaffDetailsRoleQueryDto> selectStoreStaffRole(SysStaffDetailsRoleQueryDto sysStaffDetailsRoleQueryDto);
}
