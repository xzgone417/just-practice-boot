/**
 * ISysStoreStaffUserMappingDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package com.exp.ucmp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.exp.ucmp.entity.SysStoreStaffUserMappingEntity;
import com.exp.ucmp.pk.SysStoreStaffUserMappingPk;
/**
 * <p>ClassName: ISysStoreStaffUserMappingDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface ISysStoreStaffUserMappingDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_sys_store_staff_user_mapping.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param sysStoreStaffUserMappingEntity 实体类
     * @return 插入多少行
     */
    public int insert(SysStoreStaffUserMappingEntity sysStoreStaffUserMappingEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param sysStoreStaffUserMappingEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(SysStoreStaffUserMappingEntity sysStoreStaffUserMappingEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listSysStoreStaffUserMappingEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<SysStoreStaffUserMappingEntity> listSysStoreStaffUserMappingEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param sysStoreStaffUserMappingEntity 实体类
     * @return 更新了多少行
     */
    public int update(SysStoreStaffUserMappingEntity sysStoreStaffUserMappingEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param sysStoreStaffUserMappingEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(SysStoreStaffUserMappingEntity sysStoreStaffUserMappingEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listSysStoreStaffUserMappingEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<SysStoreStaffUserMappingEntity> listSysStoreStaffUserMappingEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listSysStoreStaffUserMappingEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<SysStoreStaffUserMappingEntity> listSysStoreStaffUserMappingEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param sysStoreStaffUserMappingPk 实体类
     * @return 删除了多少行
     */
    public int delete(SysStoreStaffUserMappingPk sysStoreStaffUserMappingPk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param sysStoreStaffUserMappingEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(SysStoreStaffUserMappingEntity sysStoreStaffUserMappingEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param sysStoreStaffUserMappingPk 主键实体
     * @return sysStoreStaffUserMappingPk 单个实体对象
     */
    public SysStoreStaffUserMappingEntity load(SysStoreStaffUserMappingPk sysStoreStaffUserMappingPk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param sysStoreStaffUserMappingEntity 查询条件
     * @return 实体集合
     */
    public List<SysStoreStaffUserMappingEntity> selectBySelective(SysStoreStaffUserMappingEntity sysStoreStaffUserMappingEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param sysStoreStaffUserMappingEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(SysStoreStaffUserMappingEntity sysStoreStaffUserMappingEntity);
    
}
