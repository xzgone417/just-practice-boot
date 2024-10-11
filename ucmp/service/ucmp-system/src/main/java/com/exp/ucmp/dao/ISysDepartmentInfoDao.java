/**
 * ISysDepartmentInfoDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package com.exp.ucmp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.exp.ucmp.entity.SysDepartmentInfoEntity;
import com.exp.ucmp.pk.SysDepartmentInfoPk;
/**
 * <p>ClassName: ISysDepartmentInfoDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface ISysDepartmentInfoDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_sys_department_info.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param sysDepartmentInfoEntity 实体类
     * @return 插入多少行
     */
    public int insert(SysDepartmentInfoEntity sysDepartmentInfoEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param sysDepartmentInfoEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(SysDepartmentInfoEntity sysDepartmentInfoEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listSysDepartmentInfoEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<SysDepartmentInfoEntity> listSysDepartmentInfoEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param sysDepartmentInfoEntity 实体类
     * @return 更新了多少行
     */
    public int update(SysDepartmentInfoEntity sysDepartmentInfoEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param sysDepartmentInfoEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(SysDepartmentInfoEntity sysDepartmentInfoEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listSysDepartmentInfoEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<SysDepartmentInfoEntity> listSysDepartmentInfoEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listSysDepartmentInfoEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<SysDepartmentInfoEntity> listSysDepartmentInfoEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param sysDepartmentInfoPk 实体类
     * @return 删除了多少行
     */
    public int delete(SysDepartmentInfoPk sysDepartmentInfoPk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param sysDepartmentInfoEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(SysDepartmentInfoEntity sysDepartmentInfoEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param sysDepartmentInfoPk 主键实体
     * @return sysDepartmentInfoPk 单个实体对象
     */
    public SysDepartmentInfoEntity load(SysDepartmentInfoPk sysDepartmentInfoPk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param sysDepartmentInfoEntity 查询条件
     * @return 实体集合
     */
    public List<SysDepartmentInfoEntity> selectBySelective(SysDepartmentInfoEntity sysDepartmentInfoEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param sysDepartmentInfoEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(SysDepartmentInfoEntity sysDepartmentInfoEntity);
    
}
