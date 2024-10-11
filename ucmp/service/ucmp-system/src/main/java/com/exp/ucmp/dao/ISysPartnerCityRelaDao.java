/**
 * ISysPartnerCityRelaDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package com.exp.ucmp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.exp.ucmp.entity.SysPartnerCityRelaEntity;
import com.exp.ucmp.pk.SysPartnerCityRelaPk;
/**
 * <p>ClassName: ISysPartnerCityRelaDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface ISysPartnerCityRelaDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_sys_partner_city_rela.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param sysPartnerCityRelaEntity 实体类
     * @return 插入多少行
     */
    public int insert(SysPartnerCityRelaEntity sysPartnerCityRelaEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param sysPartnerCityRelaEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(SysPartnerCityRelaEntity sysPartnerCityRelaEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listSysPartnerCityRelaEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<SysPartnerCityRelaEntity> listSysPartnerCityRelaEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param sysPartnerCityRelaEntity 实体类
     * @return 更新了多少行
     */
    public int update(SysPartnerCityRelaEntity sysPartnerCityRelaEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param sysPartnerCityRelaEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(SysPartnerCityRelaEntity sysPartnerCityRelaEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listSysPartnerCityRelaEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<SysPartnerCityRelaEntity> listSysPartnerCityRelaEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listSysPartnerCityRelaEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<SysPartnerCityRelaEntity> listSysPartnerCityRelaEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param sysPartnerCityRelaPk 实体类
     * @return 删除了多少行
     */
    public int delete(SysPartnerCityRelaPk sysPartnerCityRelaPk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param sysPartnerCityRelaEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(SysPartnerCityRelaEntity sysPartnerCityRelaEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param sysPartnerCityRelaPk 主键实体
     * @return sysPartnerCityRelaPk 单个实体对象
     */
    public SysPartnerCityRelaEntity load(SysPartnerCityRelaPk sysPartnerCityRelaPk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param sysPartnerCityRelaEntity 查询条件
     * @return 实体集合
     */
    public List<SysPartnerCityRelaEntity> selectBySelective(SysPartnerCityRelaEntity sysPartnerCityRelaEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param sysPartnerCityRelaEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(SysPartnerCityRelaEntity sysPartnerCityRelaEntity);
    
}
