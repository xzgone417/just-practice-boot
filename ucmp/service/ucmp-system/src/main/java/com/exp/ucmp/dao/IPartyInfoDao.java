/**
 * IPartyInfoDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package com.exp.ucmp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.exp.ucmp.entity.PartyInfoEntity;
import com.exp.ucmp.pk.PartyInfoPk;
/**
 * <p>ClassName: IPartyInfoDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface IPartyInfoDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_party_info.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param partyInfoEntity 实体类
     * @return 插入多少行
     */
    public int insert(PartyInfoEntity partyInfoEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param partyInfoEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(PartyInfoEntity partyInfoEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listPartyInfoEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<PartyInfoEntity> listPartyInfoEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param partyInfoEntity 实体类
     * @return 更新了多少行
     */
    public int update(PartyInfoEntity partyInfoEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param partyInfoEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(PartyInfoEntity partyInfoEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listPartyInfoEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<PartyInfoEntity> listPartyInfoEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listPartyInfoEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<PartyInfoEntity> listPartyInfoEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param partyInfoPk 实体类
     * @return 删除了多少行
     */
    public int delete(PartyInfoPk partyInfoPk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param partyInfoEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(PartyInfoEntity partyInfoEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param partyInfoPk 主键实体
     * @return partyInfoPk 单个实体对象
     */
    public PartyInfoEntity load(PartyInfoPk partyInfoPk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param partyInfoEntity 查询条件
     * @return 实体集合
     */
    public List<PartyInfoEntity> selectBySelective(PartyInfoEntity partyInfoEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param partyInfoEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(PartyInfoEntity partyInfoEntity);
    
	public List<Long> getParyId(Long roleId);
    
}
