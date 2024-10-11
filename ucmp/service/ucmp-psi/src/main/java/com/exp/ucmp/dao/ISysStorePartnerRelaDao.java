/**
 * ISysStorePartnerRelaDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package com.exp.ucmp.dao;

import com.exp.ucmp.entity.SysStorePartnerRelaEntity;
import com.exp.ucmp.pk.SysStorePartnerRelaPk;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>ClassName: ISysStorePartnerRelaDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface ISysStorePartnerRelaDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_sys_store_partner_rela.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param sysStorePartnerRelaEntity 实体类
     * @return 插入多少行
     */
    public int insert(SysStorePartnerRelaEntity sysStorePartnerRelaEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param sysStorePartnerRelaEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(SysStorePartnerRelaEntity sysStorePartnerRelaEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listSysStorePartnerRelaEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<SysStorePartnerRelaEntity> listSysStorePartnerRelaEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param sysStorePartnerRelaEntity 实体类
     * @return 更新了多少行
     */
    public int update(SysStorePartnerRelaEntity sysStorePartnerRelaEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param sysStorePartnerRelaEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(SysStorePartnerRelaEntity sysStorePartnerRelaEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listSysStorePartnerRelaEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<SysStorePartnerRelaEntity> listSysStorePartnerRelaEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listSysStorePartnerRelaEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<SysStorePartnerRelaEntity> listSysStorePartnerRelaEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param sysStorePartnerRelaPk 实体类
     * @return 删除了多少行
     */
    public int delete(SysStorePartnerRelaPk sysStorePartnerRelaPk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param sysStorePartnerRelaEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(SysStorePartnerRelaEntity sysStorePartnerRelaEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param sysStorePartnerRelaPk 主键实体
     * @return sysStorePartnerRelaPk 单个实体对象
     */
    public SysStorePartnerRelaEntity load(SysStorePartnerRelaPk sysStorePartnerRelaPk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param sysStorePartnerRelaEntity 查询条件
     * @return 实体集合
     */
    public List<SysStorePartnerRelaEntity> selectBySelective(SysStorePartnerRelaEntity sysStorePartnerRelaEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param sysStorePartnerRelaEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(SysStorePartnerRelaEntity sysStorePartnerRelaEntity);
    
}
