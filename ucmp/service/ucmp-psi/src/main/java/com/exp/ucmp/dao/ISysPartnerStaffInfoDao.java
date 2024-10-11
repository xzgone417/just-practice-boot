/**
 * ISysPartnerStaffInfoDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package com.exp.ucmp.dao;

import com.exp.ucmp.entity.SysPartnerStaffInfoEntity;
import com.exp.ucmp.pk.SysPartnerStaffInfoPk;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>ClassName: ISysPartnerStaffInfoDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface ISysPartnerStaffInfoDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_sys_partner_staff_info.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param sysPartnerStaffInfoEntity 实体类
     * @return 插入多少行
     */
    public int insert(SysPartnerStaffInfoEntity sysPartnerStaffInfoEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param sysPartnerStaffInfoEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(SysPartnerStaffInfoEntity sysPartnerStaffInfoEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listSysPartnerStaffInfoEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<SysPartnerStaffInfoEntity> listSysPartnerStaffInfoEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param sysPartnerStaffInfoEntity 实体类
     * @return 更新了多少行
     */
    public int update(SysPartnerStaffInfoEntity sysPartnerStaffInfoEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param sysPartnerStaffInfoEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(SysPartnerStaffInfoEntity sysPartnerStaffInfoEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listSysPartnerStaffInfoEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<SysPartnerStaffInfoEntity> listSysPartnerStaffInfoEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listSysPartnerStaffInfoEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<SysPartnerStaffInfoEntity> listSysPartnerStaffInfoEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param sysPartnerStaffInfoPk 实体类
     * @return 删除了多少行
     */
    public int delete(SysPartnerStaffInfoPk sysPartnerStaffInfoPk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param sysPartnerStaffInfoEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(SysPartnerStaffInfoEntity sysPartnerStaffInfoEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param sysPartnerStaffInfoPk 主键实体
     * @return sysPartnerStaffInfoPk 单个实体对象
     */
    public SysPartnerStaffInfoEntity load(SysPartnerStaffInfoPk sysPartnerStaffInfoPk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param sysPartnerStaffInfoEntity 查询条件
     * @return 实体集合
     */
    public List<SysPartnerStaffInfoEntity> selectBySelective(SysPartnerStaffInfoEntity sysPartnerStaffInfoEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param sysPartnerStaffInfoEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(SysPartnerStaffInfoEntity sysPartnerStaffInfoEntity);
    
}
