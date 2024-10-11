package com.exp.ucmp.department.service;


import com.exp.ucmp.department.dto.SysDepartmentStaffRelaDto;

import com.exp.ucmp.department.dto.SysDepartmentStaffRelaEditDto;
import com.exp.ucmp.department.dto.SysStaffAllDto;
import com.exp.ucmp.entity.SysDepartmentStaffRelaEntity;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author zhouchengwei
 * @date 2022年08月09日
 */
public interface SysDepartmentStaffService {
    /**
     * Description: 查询总部所有部门员工
     * @param staffAllDto 查询条件
     * @return 实体集合
     */

    public PageInfo<SysStaffAllDto> queryDepartmentStaffMsg(SysStaffAllDto staffAllDto);



    /**
     * Description: 查询当前部门下的员工
     * @param staffAllDto 查询条件
     * @return 实体集合
     */

    public PageInfo<SysStaffAllDto> queryDepartmentStaffRoleMsg(SysStaffAllDto staffAllDto);

    /**
     * Description: 编辑部门员工
     * @param sysDepartmentStaffRelaEditDto 部门员工信息
     * @return 实体集合
     */
    public void editDepartmentStaff(SysDepartmentStaffRelaEditDto sysDepartmentStaffRelaEditDto);



}
