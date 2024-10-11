package com.exp.ucmp.department.service;

import com.exp.ucmp.department.dto.SysDepartmentInfoDelDto;
import com.exp.ucmp.department.dto.SysDepartmentInfoEditDto;
import com.exp.ucmp.department.dto.SysDepartmentInfoDto;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * @author zhouchengwei
 * @date 2022年08月09日
 */

public interface SysDepartmentService {

    /**
     * Description: 根据条件查询集合实体(部门信息)
     * @param sysDepartmentInfoDto 查询条件
     * @return 实体集合
     */
    public PageInfo<SysDepartmentInfoDto> queryDepartmentMsg(SysDepartmentInfoDto sysDepartmentInfoDto) ;
    /**
     * Description: 新增部门信息
     * @param sysDepartmentInfoAddDto 新增内容
     */
    public void addDepartmentMsg(SysDepartmentInfoEditDto sysDepartmentInfoAddDto);

    /**
     * Description: 修改部门信息
     * @param sysDepartmentInfoEditDto 修改内容
     */
    public void modifyDepartmentMsg(SysDepartmentInfoEditDto sysDepartmentInfoEditDto);

    /**
     * Description: 删除部门信息
     */
    public void delDepartmentMsg(SysDepartmentInfoDelDto sysDepartmentInfoDelDto);


    /**
     * Description: 查询部门种类
     * @return 实体集合
     */
    public List<Map> queryDepartmentType();
}
