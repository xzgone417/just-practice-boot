/**
 * IResourceIdentifierDao.java
 * Created at 2018年09月29日
 * Created by TODO
 * Copyright (C) TODO EgridCloud, Inc, All rights reserved.
 */
package com.exp.ucmp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;

import com.exp.ucmp.entity.ResourceIdentifierEntity;
import com.exp.ucmp.pk.ResourceIdentifierPk;
/**
 * ClassName: IResourceIdentifierDao
 * Description: TODO
 * @author TODO
 * @date 2022年07月12日
 * @since 1.0
 */
public interface IResourceIdentifierDao {
    /**
     * Description: 获取序列，序列按照SEQ+表名设计
     * @return 序列
     */
    @Select("select SEQ_t_resource_identifier.Nextval from dual")
    public long selectSequence();
    /**
     * Description: 全字段插入
     * @param resourceIdentifierEntity 实体类
     * @return 插入多少行
     */
    public int insert(ResourceIdentifierEntity resourceIdentifierEntity);
    /**
     * Description: 选择全字段插入
     * @param resourceIdentifierEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(ResourceIdentifierEntity resourceIdentifierEntity);
    /**
     * Description: 全字段插入
     * @param listResourceIdentifierEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<ResourceIdentifierEntity> listResourceIdentifierEntity);
    /**
     * Description: 全字段更新
     * @param resourceIdentifierEntity 实体类
     * @return 更新了多少行
     */
    public int update(ResourceIdentifierEntity resourceIdentifierEntity);
    /**
     * Description: 选择字段更新
     * @param resourceIdentifierEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(ResourceIdentifierEntity resourceIdentifierEntity);
    /**
     * Description: 根据主键删除
     * @param resourceIdentifierPk 实体类
     * @return 删除了多少行
     */
    public int delete(ResourceIdentifierPk resourceIdentifierPk);
    /**
     * Description: 根据多个条件删除
     * @param resourceIdentifierEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(ResourceIdentifierEntity resourceIdentifierEntity);
    /**
     * Description: 根据主键查询实体
     * @param resourceIdentifierPk 主键实体
     * @return resourceIdentifierPk 单个实体对象
     */
    public ResourceIdentifierEntity load(ResourceIdentifierPk resourceIdentifierPk);
    /**
     * Description: 根据条件查询集合实体
     * @param resourceIdentifierEntity 查询条件
     * @return 实体集合
     */
    public List<ResourceIdentifierEntity> selectBySelective(ResourceIdentifierEntity resourceIdentifierEntity);
    /**
     * Description: 根据条件查询多少行数据
     * @param resourceIdentifierEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(ResourceIdentifierEntity resourceIdentifierEntity);
    
}
