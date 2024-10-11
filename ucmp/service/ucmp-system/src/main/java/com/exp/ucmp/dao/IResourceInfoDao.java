/**
 * IResourceInfoDao.java
 * Created at 2018年09月29日
 * Created by TODO
 * Copyright (C) TODO EgridCloud, Inc, All rights reserved.
 */
package com.exp.ucmp.dao;

import java.util.List;

import com.exp.ucmp.role.dto.ResourceInfoDto;
import org.apache.ibatis.annotations.Select;

import com.exp.ucmp.entity.ResourceInfoEntity;
import com.exp.ucmp.pk.ResourceInfoPk;
/**
 * ClassName: IResourceInfoDao
 * Description: TODO
 * @author TODO
 * @date 2022年07月12日
 * @since 1.0
 */
public interface IResourceInfoDao {
    /**
     * Description: 获取序列，序列按照SEQ+表名设计
     * @return 序列
     */
    @Select("select SEQ_t_resource_info.Nextval from dual")
    public long selectSequence();
    /**
     * Description: 全字段插入
     * @param resourceInfoEntity 实体类
     * @return 插入多少行
     */
    public int insert(ResourceInfoEntity resourceInfoEntity);
    /**
     * Description: 选择全字段插入
     * @param resourceInfoEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(ResourceInfoEntity resourceInfoEntity);
    /**
     * Description: 全字段插入
     * @param listResourceInfoEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<ResourceInfoEntity> listResourceInfoEntity);
    /**
     * Description: 全字段更新
     * @param resourceInfoEntity 实体类
     * @return 更新了多少行
     */
    public int update(ResourceInfoEntity resourceInfoEntity);
    /**
     * Description: 选择字段更新
     * @param resourceInfoEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(ResourceInfoEntity resourceInfoEntity);
    /**
     * Description: 根据主键删除
     * @param resourceInfoPk 实体类
     * @return 删除了多少行
     */
    public int delete(ResourceInfoPk resourceInfoPk);
    /**
     * Description: 根据多个条件删除
     * @param resourceInfoEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(ResourceInfoEntity resourceInfoEntity);
    /**
     * Description: 根据主键查询实体
     * @param resourceInfoPk 主键实体
     * @return resourceInfoPk 单个实体对象
     */
    public ResourceInfoEntity load(ResourceInfoPk resourceInfoPk);
    /**
     * Description: 根据条件查询集合实体
     * @param resourceInfoEntity 查询条件
     * @return 实体集合
     */
    public List<ResourceInfoEntity> selectBySelective(ResourceInfoEntity resourceInfoEntity);
    /**
     * Description: 根据条件查询多少行数据
     * @param resourceInfoEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(ResourceInfoEntity resourceInfoEntity);
    
}
