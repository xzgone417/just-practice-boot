/**
 * IRepReplacementMaterialDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package com.exp.ucmp.dao;

import com.exp.ucmp.entity.RepReplacementMaterialEntity;
import com.exp.ucmp.pk.RepReplacementMaterialPk;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>ClassName: IRepReplacementMaterialDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface IRepReplacementMaterialDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_rep_replacement_material.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param repReplacementMaterialEntity 实体类
     * @return 插入多少行
     */
    public int insert(RepReplacementMaterialEntity repReplacementMaterialEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param repReplacementMaterialEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(RepReplacementMaterialEntity repReplacementMaterialEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listRepReplacementMaterialEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<RepReplacementMaterialEntity> listRepReplacementMaterialEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param repReplacementMaterialEntity 实体类
     * @return 更新了多少行
     */
    public int update(RepReplacementMaterialEntity repReplacementMaterialEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param repReplacementMaterialEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(RepReplacementMaterialEntity repReplacementMaterialEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listRepReplacementMaterialEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<RepReplacementMaterialEntity> listRepReplacementMaterialEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listRepReplacementMaterialEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<RepReplacementMaterialEntity> listRepReplacementMaterialEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param repReplacementMaterialPk 实体类
     * @return 删除了多少行
     */
    public int delete(RepReplacementMaterialPk repReplacementMaterialPk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param repReplacementMaterialEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(RepReplacementMaterialEntity repReplacementMaterialEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param repReplacementMaterialPk 主键实体
     * @return repReplacementMaterialPk 单个实体对象
     */
    public RepReplacementMaterialEntity load(RepReplacementMaterialPk repReplacementMaterialPk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param repReplacementMaterialEntity 查询条件
     * @return 实体集合
     */
    public List<RepReplacementMaterialEntity> selectBySelective(RepReplacementMaterialEntity repReplacementMaterialEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param repReplacementMaterialEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(RepReplacementMaterialEntity repReplacementMaterialEntity);
    
}
