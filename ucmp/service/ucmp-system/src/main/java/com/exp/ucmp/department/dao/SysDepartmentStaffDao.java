package com.exp.ucmp.department.dao;


import com.exp.ucmp.department.dto.SysDepartmentStaffRelaDto;
import com.exp.ucmp.department.dto.SysDepartmentStaffRelaEditDto;
import com.exp.ucmp.department.dto.SysStaffAllDto;
import com.exp.ucmp.entity.SysDepartmentInfoEntity;
import com.exp.ucmp.entity.SysDepartmentStaffRelaEntity;

import java.util.List;

/**
 * @author zhouchengwei
 * @date 2022/08/09
 * 查询部门员工信息
 */

public interface SysDepartmentStaffDao {


    /**
     * Description: 查询当前部门下的员工
     * @param staffAllDto 查询条件
     * @return 实体集合
     */
    public List<SysStaffAllDto> selectDepartmentStaff(SysStaffAllDto staffAllDto);



    /**
     * Description: 查询当前部门下的员工(如果传入参数存在角色类型或角色名称，调用此方法)
     * @param staffAllDto 查询条件
     * @return 实体集合
     */
    public List<SysStaffAllDto> selectDepartmentStaffRole(SysStaffAllDto staffAllDto);



    /**
     * Description: 查询所有员工信息
     * @param staffAllDto 查询条件
     * @return 实体集合
     */
    public List<SysStaffAllDto> selectDepartmentStaffAll(SysStaffAllDto staffAllDto);



    /**
     * Description: 查询所有员工信息(如果传入参数存在角色类型或角色名称，调用此方法)
     * @param staffAllDto 查询条件
     * @return 实体集合
     */
    public List<SysStaffAllDto> selectDepartmentStaffRoleAll(SysStaffAllDto staffAllDto);












}
