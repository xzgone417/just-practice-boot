/**
 * IStorePartyRoleRelaDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO EgridCloud, Inc, All rights reserved.
 */
package com.exp.ucmp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.exp.ucmp.entity.StorePartyRoleRelaEntity;
import com.exp.ucmp.pk.StorePartyRoleRelaPk;
/**
 * <p>ClassName: IStorePartyRoleRelaDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface IStorePartyRoleRelaDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_store_party_role_rela.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param storePartyRoleRelaEntity 实体类
     * @return 插入多少行
     */
    public int insert(StorePartyRoleRelaEntity storePartyRoleRelaEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param storePartyRoleRelaEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(StorePartyRoleRelaEntity storePartyRoleRelaEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listStorePartyRoleRelaEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<StorePartyRoleRelaEntity> listStorePartyRoleRelaEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param storePartyRoleRelaEntity 实体类
     * @return 更新了多少行
     */
    public int update(StorePartyRoleRelaEntity storePartyRoleRelaEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param storePartyRoleRelaEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(StorePartyRoleRelaEntity storePartyRoleRelaEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listStorePartyRoleRelaEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<StorePartyRoleRelaEntity> listStorePartyRoleRelaEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listStorePartyRoleRelaEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<StorePartyRoleRelaEntity> listStorePartyRoleRelaEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param storePartyRoleRelaPk 实体类
     * @return 删除了多少行
     */
    public int delete(StorePartyRoleRelaPk storePartyRoleRelaPk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param storePartyRoleRelaEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(StorePartyRoleRelaEntity storePartyRoleRelaEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param storePartyRoleRelaPk 主键实体
     * @return storePartyRoleRelaPk 单个实体对象
     */
    public StorePartyRoleRelaEntity load(StorePartyRoleRelaPk storePartyRoleRelaPk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param storePartyRoleRelaEntity 查询条件
     * @return 实体集合
     */
    public List<StorePartyRoleRelaEntity> selectBySelective(StorePartyRoleRelaEntity storePartyRoleRelaEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param storePartyRoleRelaEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(StorePartyRoleRelaEntity storePartyRoleRelaEntity);
    
}
