/**
 * ISysRegionDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package com.exp.ucmp.dao;

import com.exp.ucmp.entity.SysRegionEntity;
import com.exp.ucmp.pk.SysRegionPk;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>ClassName: ISysRegionDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface ISysRegionDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_sys_region.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param sysRegionEntity 实体类
     * @return 插入多少行
     */
    public int insert(SysRegionEntity sysRegionEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param sysRegionEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(SysRegionEntity sysRegionEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listSysRegionEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<SysRegionEntity> listSysRegionEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param sysRegionEntity 实体类
     * @return 更新了多少行
     */
    public int update(SysRegionEntity sysRegionEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param sysRegionEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(SysRegionEntity sysRegionEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listSysRegionEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<SysRegionEntity> listSysRegionEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listSysRegionEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<SysRegionEntity> listSysRegionEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param sysRegionPk 实体类
     * @return 删除了多少行
     */
    public int delete(SysRegionPk sysRegionPk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param sysRegionEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(SysRegionEntity sysRegionEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param sysRegionPk 主键实体
     * @return sysRegionPk 单个实体对象
     */
    public SysRegionEntity load(SysRegionPk sysRegionPk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param sysRegionEntity 查询条件
     * @return 实体集合
     */
    public List<SysRegionEntity> selectBySelective(SysRegionEntity sysRegionEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param sysRegionEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(SysRegionEntity sysRegionEntity);
    
}
