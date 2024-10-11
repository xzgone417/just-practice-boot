/**
 * ISysStoreStaffRelaDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package com.exp.ucmp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.exp.ucmp.entity.SysStoreStaffRelaEntity;
import com.exp.ucmp.pk.SysStoreStaffRelaPk;
/**
 * <p>ClassName: ISysStoreStaffRelaDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface ISysStoreStaffRelaDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_sys_store_staff_rela.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param sysStoreStaffRelaEntity 实体类
     * @return 插入多少行
     */
    public int insert(SysStoreStaffRelaEntity sysStoreStaffRelaEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param sysStoreStaffRelaEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(SysStoreStaffRelaEntity sysStoreStaffRelaEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listSysStoreStaffRelaEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<SysStoreStaffRelaEntity> listSysStoreStaffRelaEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param sysStoreStaffRelaEntity 实体类
     * @return 更新了多少行
     */
    public int update(SysStoreStaffRelaEntity sysStoreStaffRelaEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param sysStoreStaffRelaEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(SysStoreStaffRelaEntity sysStoreStaffRelaEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listSysStoreStaffRelaEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<SysStoreStaffRelaEntity> listSysStoreStaffRelaEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listSysStoreStaffRelaEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<SysStoreStaffRelaEntity> listSysStoreStaffRelaEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param sysStoreStaffRelaPk 实体类
     * @return 删除了多少行
     */
    public int delete(SysStoreStaffRelaPk sysStoreStaffRelaPk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param sysStoreStaffRelaEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(SysStoreStaffRelaEntity sysStoreStaffRelaEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param sysStoreStaffRelaPk 主键实体
     * @return sysStoreStaffRelaPk 单个实体对象
     */
    public SysStoreStaffRelaEntity load(SysStoreStaffRelaPk sysStoreStaffRelaPk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param sysStoreStaffRelaEntity 查询条件
     * @return 实体集合
     */
    public List<SysStoreStaffRelaEntity> selectBySelective(SysStoreStaffRelaEntity sysStoreStaffRelaEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param sysStoreStaffRelaEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(SysStoreStaffRelaEntity sysStoreStaffRelaEntity);
    
}
