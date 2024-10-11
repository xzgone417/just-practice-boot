/**
 * ISysStoreInfoDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package com.exp.ucmp.dao;

import com.exp.ucmp.entity.SysStoreInfoEntity;
import com.exp.ucmp.pk.SysStoreInfoPk;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>ClassName: ISysStoreInfoDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface ISysStoreInfoDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_sys_store_info.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param sysStoreInfoEntity 实体类
     * @return 插入多少行
     */
    public int insert(SysStoreInfoEntity sysStoreInfoEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param sysStoreInfoEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(SysStoreInfoEntity sysStoreInfoEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listSysStoreInfoEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<SysStoreInfoEntity> listSysStoreInfoEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param sysStoreInfoEntity 实体类
     * @return 更新了多少行
     */
    public int update(SysStoreInfoEntity sysStoreInfoEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param sysStoreInfoEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(SysStoreInfoEntity sysStoreInfoEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listSysStoreInfoEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<SysStoreInfoEntity> listSysStoreInfoEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listSysStoreInfoEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<SysStoreInfoEntity> listSysStoreInfoEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param sysStoreInfoPk 实体类
     * @return 删除了多少行
     */
    public int delete(SysStoreInfoPk sysStoreInfoPk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param sysStoreInfoEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(SysStoreInfoEntity sysStoreInfoEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param sysStoreInfoPk 主键实体
     * @return sysStoreInfoPk 单个实体对象
     */
    public SysStoreInfoEntity load(SysStoreInfoPk sysStoreInfoPk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param sysStoreInfoEntity 查询条件
     * @return 实体集合
     */
    public List<SysStoreInfoEntity> selectBySelective(SysStoreInfoEntity sysStoreInfoEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param sysStoreInfoEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(SysStoreInfoEntity sysStoreInfoEntity);
    
}
