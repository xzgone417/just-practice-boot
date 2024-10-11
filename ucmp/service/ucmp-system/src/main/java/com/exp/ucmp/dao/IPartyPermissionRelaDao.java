/**
 * IPartyPermissionRelaDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package com.exp.ucmp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.exp.ucmp.entity.PartyPermissionRelaEntity;
import com.exp.ucmp.pk.PartyPermissionRelaPk;
/**
 * <p>ClassName: IPartyPermissionRelaDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface IPartyPermissionRelaDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_party_permission_rela.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param partyPermissionRelaEntity 实体类
     * @return 插入多少行
     */
    public int insert(PartyPermissionRelaEntity partyPermissionRelaEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param partyPermissionRelaEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(PartyPermissionRelaEntity partyPermissionRelaEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listPartyPermissionRelaEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<PartyPermissionRelaEntity> listPartyPermissionRelaEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param partyPermissionRelaEntity 实体类
     * @return 更新了多少行
     */
    public int update(PartyPermissionRelaEntity partyPermissionRelaEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param partyPermissionRelaEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(PartyPermissionRelaEntity partyPermissionRelaEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listPartyPermissionRelaEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<PartyPermissionRelaEntity> listPartyPermissionRelaEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listPartyPermissionRelaEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<PartyPermissionRelaEntity> listPartyPermissionRelaEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param partyPermissionRelaPk 实体类
     * @return 删除了多少行
     */
    public int delete(PartyPermissionRelaPk partyPermissionRelaPk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param partyPermissionRelaEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(PartyPermissionRelaEntity partyPermissionRelaEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param partyPermissionRelaPk 主键实体
     * @return partyPermissionRelaPk 单个实体对象
     */
    public PartyPermissionRelaEntity load(PartyPermissionRelaPk partyPermissionRelaPk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param partyPermissionRelaEntity 查询条件
     * @return 实体集合
     */
    public List<PartyPermissionRelaEntity> selectBySelective(PartyPermissionRelaEntity partyPermissionRelaEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param partyPermissionRelaEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(PartyPermissionRelaEntity partyPermissionRelaEntity);
    
}
