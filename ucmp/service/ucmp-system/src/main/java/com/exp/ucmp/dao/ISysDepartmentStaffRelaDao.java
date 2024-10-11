/**
 * ISysDepartmentStaffRelaDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package com.exp.ucmp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.exp.ucmp.entity.SysDepartmentStaffRelaEntity;
import com.exp.ucmp.pk.SysDepartmentStaffRelaPk;
/**
 * <p>ClassName: ISysDepartmentStaffRelaDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface ISysDepartmentStaffRelaDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_sys_department_staff_rela.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param sysDepartmentStaffRelaEntity 实体类
     * @return 插入多少行
     */
    public int insert(SysDepartmentStaffRelaEntity sysDepartmentStaffRelaEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param sysDepartmentStaffRelaEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(SysDepartmentStaffRelaEntity sysDepartmentStaffRelaEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listSysDepartmentStaffRelaEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<SysDepartmentStaffRelaEntity> listSysDepartmentStaffRelaEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param sysDepartmentStaffRelaEntity 实体类
     * @return 更新了多少行
     */
    public int update(SysDepartmentStaffRelaEntity sysDepartmentStaffRelaEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param sysDepartmentStaffRelaEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(SysDepartmentStaffRelaEntity sysDepartmentStaffRelaEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listSysDepartmentStaffRelaEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<SysDepartmentStaffRelaEntity> listSysDepartmentStaffRelaEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listSysDepartmentStaffRelaEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<SysDepartmentStaffRelaEntity> listSysDepartmentStaffRelaEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param sysDepartmentStaffRelaPk 实体类
     * @return 删除了多少行
     */
    public int delete(SysDepartmentStaffRelaPk sysDepartmentStaffRelaPk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param sysDepartmentStaffRelaEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(SysDepartmentStaffRelaEntity sysDepartmentStaffRelaEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param sysDepartmentStaffRelaPk 主键实体
     * @return sysDepartmentStaffRelaPk 单个实体对象
     */
    public SysDepartmentStaffRelaEntity load(SysDepartmentStaffRelaPk sysDepartmentStaffRelaPk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param sysDepartmentStaffRelaEntity 查询条件
     * @return 实体集合
     */
    public List<SysDepartmentStaffRelaEntity> selectBySelective(SysDepartmentStaffRelaEntity sysDepartmentStaffRelaEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param sysDepartmentStaffRelaEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(SysDepartmentStaffRelaEntity sysDepartmentStaffRelaEntity);
    
}
