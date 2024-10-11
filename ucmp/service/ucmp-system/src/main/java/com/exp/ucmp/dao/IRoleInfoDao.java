/**
 * IRoleInfoDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package com.exp.ucmp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.exp.ucmp.entity.RoleInfoEntity;
import com.exp.ucmp.pk.RoleInfoPk;
/**
 * <p>ClassName: IRoleInfoDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface IRoleInfoDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_role_info.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param roleInfoEntity 实体类
     * @return 插入多少行
     */
    public int insert(RoleInfoEntity roleInfoEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param roleInfoEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(RoleInfoEntity roleInfoEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listRoleInfoEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<RoleInfoEntity> listRoleInfoEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param roleInfoEntity 实体类
     * @return 更新了多少行
     */
    public int update(RoleInfoEntity roleInfoEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param roleInfoEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(RoleInfoEntity roleInfoEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listRoleInfoEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<RoleInfoEntity> listRoleInfoEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listRoleInfoEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<RoleInfoEntity> listRoleInfoEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param roleInfoPk 实体类
     * @return 删除了多少行
     */
    public int delete(RoleInfoPk roleInfoPk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param roleInfoEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(RoleInfoEntity roleInfoEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param roleInfoPk 主键实体
     * @return roleInfoPk 单个实体对象
     */
    public RoleInfoEntity load(RoleInfoPk roleInfoPk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param roleInfoEntity 查询条件
     * @return 实体集合
     */
    public List<RoleInfoEntity> selectBySelective(RoleInfoEntity roleInfoEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param roleInfoEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(RoleInfoEntity roleInfoEntity);
    
}
