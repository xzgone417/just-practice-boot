/**
 * ISysPartnerStaffStoreRelaDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package com.exp.ucmp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.exp.ucmp.entity.SysPartnerStaffStoreRelaEntity;
import com.exp.ucmp.pk.SysPartnerStaffStoreRelaPk;
/**
 * <p>ClassName: ISysPartnerStaffStoreRelaDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface ISysPartnerStaffStoreRelaDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_sys_partner_staff_store_rela.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param sysPartnerStaffStoreRelaEntity 实体类
     * @return 插入多少行
     */
    public int insert(SysPartnerStaffStoreRelaEntity sysPartnerStaffStoreRelaEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param sysPartnerStaffStoreRelaEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(SysPartnerStaffStoreRelaEntity sysPartnerStaffStoreRelaEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listSysPartnerStaffStoreRelaEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<SysPartnerStaffStoreRelaEntity> listSysPartnerStaffStoreRelaEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param sysPartnerStaffStoreRelaEntity 实体类
     * @return 更新了多少行
     */
    public int update(SysPartnerStaffStoreRelaEntity sysPartnerStaffStoreRelaEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param sysPartnerStaffStoreRelaEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(SysPartnerStaffStoreRelaEntity sysPartnerStaffStoreRelaEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listSysPartnerStaffStoreRelaEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<SysPartnerStaffStoreRelaEntity> listSysPartnerStaffStoreRelaEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listSysPartnerStaffStoreRelaEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<SysPartnerStaffStoreRelaEntity> listSysPartnerStaffStoreRelaEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param sysPartnerStaffStoreRelaPk 实体类
     * @return 删除了多少行
     */
    public int delete(SysPartnerStaffStoreRelaPk sysPartnerStaffStoreRelaPk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param sysPartnerStaffStoreRelaEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(SysPartnerStaffStoreRelaEntity sysPartnerStaffStoreRelaEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param sysPartnerStaffStoreRelaPk 主键实体
     * @return sysPartnerStaffStoreRelaPk 单个实体对象
     */
    public SysPartnerStaffStoreRelaEntity load(SysPartnerStaffStoreRelaPk sysPartnerStaffStoreRelaPk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param sysPartnerStaffStoreRelaEntity 查询条件
     * @return 实体集合
     */
    public List<SysPartnerStaffStoreRelaEntity> selectBySelective(SysPartnerStaffStoreRelaEntity sysPartnerStaffStoreRelaEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param sysPartnerStaffStoreRelaEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(SysPartnerStaffStoreRelaEntity sysPartnerStaffStoreRelaEntity);
    
}
