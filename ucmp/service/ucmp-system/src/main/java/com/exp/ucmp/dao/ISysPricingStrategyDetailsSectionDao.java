/**
 * ISysPricingStrategyDetailsSectionDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package com.exp.ucmp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.exp.ucmp.entity.SysPricingStrategyDetailsSectionEntity;
import com.exp.ucmp.pk.SysPricingStrategyDetailsSectionPk;
/**
 * <p>ClassName: ISysPricingStrategyDetailsSectionDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface ISysPricingStrategyDetailsSectionDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_sys_pricing_strategy_details_section.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param sysPricingStrategyDetailsSectionEntity 实体类
     * @return 插入多少行
     */
    public int insert(SysPricingStrategyDetailsSectionEntity sysPricingStrategyDetailsSectionEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param sysPricingStrategyDetailsSectionEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(SysPricingStrategyDetailsSectionEntity sysPricingStrategyDetailsSectionEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listSysPricingStrategyDetailsSectionEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<SysPricingStrategyDetailsSectionEntity> listSysPricingStrategyDetailsSectionEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param sysPricingStrategyDetailsSectionEntity 实体类
     * @return 更新了多少行
     */
    public int update(SysPricingStrategyDetailsSectionEntity sysPricingStrategyDetailsSectionEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param sysPricingStrategyDetailsSectionEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(SysPricingStrategyDetailsSectionEntity sysPricingStrategyDetailsSectionEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listSysPricingStrategyDetailsSectionEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<SysPricingStrategyDetailsSectionEntity> listSysPricingStrategyDetailsSectionEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listSysPricingStrategyDetailsSectionEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<SysPricingStrategyDetailsSectionEntity> listSysPricingStrategyDetailsSectionEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param sysPricingStrategyDetailsSectionPk 实体类
     * @return 删除了多少行
     */
    public int delete(SysPricingStrategyDetailsSectionPk sysPricingStrategyDetailsSectionPk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param sysPricingStrategyDetailsSectionEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(SysPricingStrategyDetailsSectionEntity sysPricingStrategyDetailsSectionEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param sysPricingStrategyDetailsSectionPk 主键实体
     * @return sysPricingStrategyDetailsSectionPk 单个实体对象
     */
    public SysPricingStrategyDetailsSectionEntity load(SysPricingStrategyDetailsSectionPk sysPricingStrategyDetailsSectionPk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param sysPricingStrategyDetailsSectionEntity 查询条件
     * @return 实体集合
     */
    public List<SysPricingStrategyDetailsSectionEntity> selectBySelective(SysPricingStrategyDetailsSectionEntity sysPricingStrategyDetailsSectionEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param sysPricingStrategyDetailsSectionEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(SysPricingStrategyDetailsSectionEntity sysPricingStrategyDetailsSectionEntity);
    
}
