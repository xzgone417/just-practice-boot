/**
 * IOrganizationInfoDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package com.exp.ucmp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.exp.ucmp.entity.OrganizationInfoEntity;
import com.exp.ucmp.pk.OrganizationInfoPk;
/**
 * <p>ClassName: IOrganizationInfoDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface IOrganizationInfoDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_organization_info.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param organizationInfoEntity 实体类
     * @return 插入多少行
     */
    public int insert(OrganizationInfoEntity organizationInfoEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param organizationInfoEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(OrganizationInfoEntity organizationInfoEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listOrganizationInfoEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<OrganizationInfoEntity> listOrganizationInfoEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param organizationInfoEntity 实体类
     * @return 更新了多少行
     */
    public int update(OrganizationInfoEntity organizationInfoEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param organizationInfoEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(OrganizationInfoEntity organizationInfoEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listOrganizationInfoEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<OrganizationInfoEntity> listOrganizationInfoEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listOrganizationInfoEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<OrganizationInfoEntity> listOrganizationInfoEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param organizationInfoPk 实体类
     * @return 删除了多少行
     */
    public int delete(OrganizationInfoPk organizationInfoPk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param organizationInfoEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(OrganizationInfoEntity organizationInfoEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param organizationInfoPk 主键实体
     * @return organizationInfoPk 单个实体对象
     */
    public OrganizationInfoEntity load(OrganizationInfoPk organizationInfoPk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param organizationInfoEntity 查询条件
     * @return 实体集合
     */
    public List<OrganizationInfoEntity> selectBySelective(OrganizationInfoEntity organizationInfoEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param organizationInfoEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(OrganizationInfoEntity organizationInfoEntity);
    
}
