/**
 * ISysStoreStaffDetailsDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package com.exp.ucmp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.exp.ucmp.entity.SysStoreStaffDetailsEntity;
import com.exp.ucmp.pk.SysStoreStaffDetailsPk;
/**
 * <p>ClassName: ISysStoreStaffDetailsDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface ISysStoreStaffDetailsDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_sys_store_staff_details.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param sysStoreStaffDetailsEntity 实体类
     * @return 插入多少行
     */
    public int insert(SysStoreStaffDetailsEntity sysStoreStaffDetailsEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param sysStoreStaffDetailsEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(SysStoreStaffDetailsEntity sysStoreStaffDetailsEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listSysStoreStaffDetailsEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<SysStoreStaffDetailsEntity> listSysStoreStaffDetailsEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param sysStoreStaffDetailsEntity 实体类
     * @return 更新了多少行
     */
    public int update(SysStoreStaffDetailsEntity sysStoreStaffDetailsEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param sysStoreStaffDetailsEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(SysStoreStaffDetailsEntity sysStoreStaffDetailsEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listSysStoreStaffDetailsEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<SysStoreStaffDetailsEntity> listSysStoreStaffDetailsEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listSysStoreStaffDetailsEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<SysStoreStaffDetailsEntity> listSysStoreStaffDetailsEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param sysStoreStaffDetailsPk 实体类
     * @return 删除了多少行
     */
    public int delete(SysStoreStaffDetailsPk sysStoreStaffDetailsPk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param sysStoreStaffDetailsEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(SysStoreStaffDetailsEntity sysStoreStaffDetailsEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param sysStoreStaffDetailsPk 主键实体
     * @return sysStoreStaffDetailsPk 单个实体对象
     */
    public SysStoreStaffDetailsEntity load(SysStoreStaffDetailsPk sysStoreStaffDetailsPk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param sysStoreStaffDetailsEntity 查询条件
     * @return 实体集合
     */
    public List<SysStoreStaffDetailsEntity> selectBySelective(SysStoreStaffDetailsEntity sysStoreStaffDetailsEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param sysStoreStaffDetailsEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(SysStoreStaffDetailsEntity sysStoreStaffDetailsEntity);
    
}
