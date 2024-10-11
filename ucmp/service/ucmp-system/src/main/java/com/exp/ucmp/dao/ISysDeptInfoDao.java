/**
 * ISysDeptInfoDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package com.exp.ucmp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.exp.ucmp.entity.SysDeptInfoEntity;
import com.exp.ucmp.pk.SysDeptInfoPk;
/**
 * <p>ClassName: ISysDeptInfoDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface ISysDeptInfoDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_sys_dept_info.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param sysDeptInfoEntity 实体类
     * @return 插入多少行
     */
    public int insert(SysDeptInfoEntity sysDeptInfoEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param sysDeptInfoEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(SysDeptInfoEntity sysDeptInfoEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listSysDeptInfoEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<SysDeptInfoEntity> listSysDeptInfoEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param sysDeptInfoEntity 实体类
     * @return 更新了多少行
     */
    public int update(SysDeptInfoEntity sysDeptInfoEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param sysDeptInfoEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(SysDeptInfoEntity sysDeptInfoEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listSysDeptInfoEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<SysDeptInfoEntity> listSysDeptInfoEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listSysDeptInfoEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<SysDeptInfoEntity> listSysDeptInfoEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param sysDeptInfoPk 实体类
     * @return 删除了多少行
     */
    public int delete(SysDeptInfoPk sysDeptInfoPk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param sysDeptInfoEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(SysDeptInfoEntity sysDeptInfoEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param sysDeptInfoPk 主键实体
     * @return sysDeptInfoPk 单个实体对象
     */
    public SysDeptInfoEntity load(SysDeptInfoPk sysDeptInfoPk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param sysDeptInfoEntity 查询条件
     * @return 实体集合
     */
    public List<SysDeptInfoEntity> selectBySelective(SysDeptInfoEntity sysDeptInfoEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param sysDeptInfoEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(SysDeptInfoEntity sysDeptInfoEntity);
    
}
