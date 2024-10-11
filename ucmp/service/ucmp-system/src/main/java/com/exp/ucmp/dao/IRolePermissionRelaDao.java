/**
 * IRolePermissionRelaDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package com.exp.ucmp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.exp.ucmp.entity.RolePermissionRelaEntity;
import com.exp.ucmp.pk.RolePermissionRelaPk;
/**
 * <p>ClassName: IRolePermissionRelaDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface IRolePermissionRelaDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_role_permission_rela.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param rolePermissionRelaEntity 实体类
     * @return 插入多少行
     */
    public int insert(RolePermissionRelaEntity rolePermissionRelaEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param rolePermissionRelaEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(RolePermissionRelaEntity rolePermissionRelaEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listRolePermissionRelaEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<RolePermissionRelaEntity> listRolePermissionRelaEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param rolePermissionRelaEntity 实体类
     * @return 更新了多少行
     */
    public int update(RolePermissionRelaEntity rolePermissionRelaEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param rolePermissionRelaEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(RolePermissionRelaEntity rolePermissionRelaEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listRolePermissionRelaEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<RolePermissionRelaEntity> listRolePermissionRelaEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listRolePermissionRelaEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<RolePermissionRelaEntity> listRolePermissionRelaEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param rolePermissionRelaPk 实体类
     * @return 删除了多少行
     */
    public int delete(RolePermissionRelaPk rolePermissionRelaPk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param rolePermissionRelaEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(RolePermissionRelaEntity rolePermissionRelaEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param rolePermissionRelaPk 主键实体
     * @return rolePermissionRelaPk 单个实体对象
     */
    public RolePermissionRelaEntity load(RolePermissionRelaPk rolePermissionRelaPk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param rolePermissionRelaEntity 查询条件
     * @return 实体集合
     */
    public List<RolePermissionRelaEntity> selectBySelective(RolePermissionRelaEntity rolePermissionRelaEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param rolePermissionRelaEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(RolePermissionRelaEntity rolePermissionRelaEntity);
    
}
