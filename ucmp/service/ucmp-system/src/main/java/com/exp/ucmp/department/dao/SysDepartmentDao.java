package com.exp.ucmp.department.dao;


import com.exp.ucmp.department.dto.SysDepartmentInfoDto;
import com.exp.ucmp.entity.ResourceIdentifierEntity;
import com.exp.ucmp.entity.SysDepartmentInfoEntity;

import java.util.List;
import java.util.Map;

/**
 * @author zhouchengwei
 * @date 2022/08/09
 * 查询部门信息
 */
public interface SysDepartmentDao {

    /**
     * Description: 根据条件查询集合实体(部门信息)
     * @param sysDepartmentInfoDto 查询条件
     * @return 实体集合
     */
    public List<SysDepartmentInfoDto> selectDepartmentMsg(SysDepartmentInfoDto sysDepartmentInfoDto);


    /**
     * Description: 查询部门种类
     * @return 实体集合
     */
    public List<Map> selectDepartmentType();

}
