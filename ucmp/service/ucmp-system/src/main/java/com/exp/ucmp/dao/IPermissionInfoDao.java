/**
 * IPermissionInfoDao.java
 * Created at 2018年09月29日
 * Created by TODO
 * Copyright (C) TODO EgridCloud, Inc, All rights reserved.
 */
package com.exp.ucmp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;

import com.exp.ucmp.entity.PermissionInfoEntity;
import com.exp.ucmp.pk.PermissionInfoPk;
/**
 * ClassName: IPermissionInfoDao
 * Description: TODO
 * @author TODO
 * @date 2022年07月12日
 * @since 1.0
 */
public interface IPermissionInfoDao {
    /**
     * Description: 获取序列，序列按照SEQ+表名设计
     * @return 序列
     */
    @Select("select SEQ_t_permission_info.Nextval from dual")
    public long selectSequence();
    /**
     * Description: 全字段插入
     * @param permissionInfoEntity 实体类
     * @return 插入多少行
     */
    public int insert(PermissionInfoEntity permissionInfoEntity);
    /**
     * Description: 选择全字段插入
     * @param permissionInfoEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(PermissionInfoEntity permissionInfoEntity);
    /**
     * Description: 全字段插入
     * @param listPermissionInfoEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<PermissionInfoEntity> listPermissionInfoEntity);
    /**
     * Description: 全字段更新
     * @param permissionInfoEntity 实体类
     * @return 更新了多少行
     */
    public int update(PermissionInfoEntity permissionInfoEntity);
    /**
     * Description: 选择字段更新
     * @param permissionInfoEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(PermissionInfoEntity permissionInfoEntity);
    /**
     * Description: 根据主键删除
     * @param permissionInfoPk 实体类
     * @return 删除了多少行
     */
    public int delete(PermissionInfoPk permissionInfoPk);
    /**
     * Description: 根据多个条件删除
     * @param permissionInfoEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(PermissionInfoEntity permissionInfoEntity);
    /**
     * Description: 根据主键查询实体
     * @param permissionInfoPk 主键实体
     * @return permissionInfoPk 单个实体对象
     */
    public PermissionInfoEntity load(PermissionInfoPk permissionInfoPk);
    /**
     * Description: 根据条件查询集合实体
     * @param permissionInfoEntity 查询条件
     * @return 实体集合
     */
    public List<PermissionInfoEntity> selectBySelective(PermissionInfoEntity permissionInfoEntity);
    /**
     * Description: 根据条件查询多少行数据
     * @param permissionInfoEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(PermissionInfoEntity permissionInfoEntity);
    
}
