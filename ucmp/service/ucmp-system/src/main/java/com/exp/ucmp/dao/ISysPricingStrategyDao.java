/**
 * ISysPricingStrategyDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package com.exp.ucmp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.exp.ucmp.entity.SysPricingStrategyEntity;
import com.exp.ucmp.pk.SysPricingStrategyPk;
/**
 * <p>ClassName: ISysPricingStrategyDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface ISysPricingStrategyDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_sys_pricing_strategy.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param sysPricingStrategyEntity 实体类
     * @return 插入多少行
     */
    public int insert(SysPricingStrategyEntity sysPricingStrategyEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param sysPricingStrategyEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(SysPricingStrategyEntity sysPricingStrategyEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listSysPricingStrategyEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<SysPricingStrategyEntity> listSysPricingStrategyEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param sysPricingStrategyEntity 实体类
     * @return 更新了多少行
     */
    public int update(SysPricingStrategyEntity sysPricingStrategyEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param sysPricingStrategyEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(SysPricingStrategyEntity sysPricingStrategyEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listSysPricingStrategyEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<SysPricingStrategyEntity> listSysPricingStrategyEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listSysPricingStrategyEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<SysPricingStrategyEntity> listSysPricingStrategyEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param sysPricingStrategyPk 实体类
     * @return 删除了多少行
     */
    public int delete(SysPricingStrategyPk sysPricingStrategyPk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param sysPricingStrategyEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(SysPricingStrategyEntity sysPricingStrategyEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param sysPricingStrategyPk 主键实体
     * @return sysPricingStrategyPk 单个实体对象
     */
    public SysPricingStrategyEntity load(SysPricingStrategyPk sysPricingStrategyPk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param sysPricingStrategyEntity 查询条件
     * @return 实体集合
     */
    public List<SysPricingStrategyEntity> selectBySelective(SysPricingStrategyEntity sysPricingStrategyEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param sysPricingStrategyEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(SysPricingStrategyEntity sysPricingStrategyEntity);
    
}