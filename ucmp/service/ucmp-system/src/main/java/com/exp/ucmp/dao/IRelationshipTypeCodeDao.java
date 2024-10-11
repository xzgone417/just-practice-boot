/**
 * IRelationshipTypeCodeDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package com.exp.ucmp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.exp.ucmp.entity.RelationshipTypeCodeEntity;
import com.exp.ucmp.pk.RelationshipTypeCodePk;
/**
 * <p>ClassName: IRelationshipTypeCodeDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface IRelationshipTypeCodeDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_relationship_type_code.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param relationshipTypeCodeEntity 实体类
     * @return 插入多少行
     */
    public int insert(RelationshipTypeCodeEntity relationshipTypeCodeEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param relationshipTypeCodeEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(RelationshipTypeCodeEntity relationshipTypeCodeEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listRelationshipTypeCodeEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<RelationshipTypeCodeEntity> listRelationshipTypeCodeEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param relationshipTypeCodeEntity 实体类
     * @return 更新了多少行
     */
    public int update(RelationshipTypeCodeEntity relationshipTypeCodeEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param relationshipTypeCodeEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(RelationshipTypeCodeEntity relationshipTypeCodeEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listRelationshipTypeCodeEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<RelationshipTypeCodeEntity> listRelationshipTypeCodeEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listRelationshipTypeCodeEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<RelationshipTypeCodeEntity> listRelationshipTypeCodeEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param relationshipTypeCodePk 实体类
     * @return 删除了多少行
     */
    public int delete(RelationshipTypeCodePk relationshipTypeCodePk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param relationshipTypeCodeEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(RelationshipTypeCodeEntity relationshipTypeCodeEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param relationshipTypeCodePk 主键实体
     * @return relationshipTypeCodePk 单个实体对象
     */
    public RelationshipTypeCodeEntity load(RelationshipTypeCodePk relationshipTypeCodePk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param relationshipTypeCodeEntity 查询条件
     * @return 实体集合
     */
    public List<RelationshipTypeCodeEntity> selectBySelective(RelationshipTypeCodeEntity relationshipTypeCodeEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param relationshipTypeCodeEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(RelationshipTypeCodeEntity relationshipTypeCodeEntity);
    
}