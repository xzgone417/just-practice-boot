/**
 * ISysPricingStrategyDetailsDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package com.exp.ucmp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.exp.ucmp.entity.SysPricingStrategyDetailsEntity;
import com.exp.ucmp.pk.SysPricingStrategyDetailsPk;
/**
 * <p>ClassName: ISysPricingStrategyDetailsDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface ISysPricingStrategyDetailsDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_sys_pricing_strategy_details.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param sysPricingStrategyDetailsEntity 实体类
     * @return 插入多少行
     */
    public int insert(SysPricingStrategyDetailsEntity sysPricingStrategyDetailsEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param sysPricingStrategyDetailsEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(SysPricingStrategyDetailsEntity sysPricingStrategyDetailsEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listSysPricingStrategyDetailsEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<SysPricingStrategyDetailsEntity> listSysPricingStrategyDetailsEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param sysPricingStrategyDetailsEntity 实体类
     * @return 更新了多少行
     */
    public int update(SysPricingStrategyDetailsEntity sysPricingStrategyDetailsEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param sysPricingStrategyDetailsEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(SysPricingStrategyDetailsEntity sysPricingStrategyDetailsEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listSysPricingStrategyDetailsEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<SysPricingStrategyDetailsEntity> listSysPricingStrategyDetailsEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listSysPricingStrategyDetailsEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<SysPricingStrategyDetailsEntity> listSysPricingStrategyDetailsEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param sysPricingStrategyDetailsPk 实体类
     * @return 删除了多少行
     */
    public int delete(SysPricingStrategyDetailsPk sysPricingStrategyDetailsPk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param sysPricingStrategyDetailsEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(SysPricingStrategyDetailsEntity sysPricingStrategyDetailsEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param sysPricingStrategyDetailsPk 主键实体
     * @return sysPricingStrategyDetailsPk 单个实体对象
     */
    public SysPricingStrategyDetailsEntity load(SysPricingStrategyDetailsPk sysPricingStrategyDetailsPk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param sysPricingStrategyDetailsEntity 查询条件
     * @return 实体集合
     */
    public List<SysPricingStrategyDetailsEntity> selectBySelective(SysPricingStrategyDetailsEntity sysPricingStrategyDetailsEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param sysPricingStrategyDetailsEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(SysPricingStrategyDetailsEntity sysPricingStrategyDetailsEntity);
    
}
