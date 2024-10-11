/**
 * ISysPartnerStaffRelaDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package com.exp.ucmp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.exp.ucmp.entity.SysPartnerStaffRelaEntity;
import com.exp.ucmp.pk.SysPartnerStaffRelaPk;
/**
 * <p>ClassName: ISysPartnerStaffRelaDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface ISysPartnerStaffRelaDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_sys_partner_staff_rela.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param sysPartnerStaffRelaEntity 实体类
     * @return 插入多少行
     */
    public int insert(SysPartnerStaffRelaEntity sysPartnerStaffRelaEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param sysPartnerStaffRelaEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(SysPartnerStaffRelaEntity sysPartnerStaffRelaEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listSysPartnerStaffRelaEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<SysPartnerStaffRelaEntity> listSysPartnerStaffRelaEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param sysPartnerStaffRelaEntity 实体类
     * @return 更新了多少行
     */
    public int update(SysPartnerStaffRelaEntity sysPartnerStaffRelaEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param sysPartnerStaffRelaEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(SysPartnerStaffRelaEntity sysPartnerStaffRelaEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listSysPartnerStaffRelaEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<SysPartnerStaffRelaEntity> listSysPartnerStaffRelaEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listSysPartnerStaffRelaEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<SysPartnerStaffRelaEntity> listSysPartnerStaffRelaEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param sysPartnerStaffRelaPk 实体类
     * @return 删除了多少行
     */
    public int delete(SysPartnerStaffRelaPk sysPartnerStaffRelaPk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param sysPartnerStaffRelaEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(SysPartnerStaffRelaEntity sysPartnerStaffRelaEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param sysPartnerStaffRelaPk 主键实体
     * @return sysPartnerStaffRelaPk 单个实体对象
     */
    public SysPartnerStaffRelaEntity load(SysPartnerStaffRelaPk sysPartnerStaffRelaPk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param sysPartnerStaffRelaEntity 查询条件
     * @return 实体集合
     */
    public List<SysPartnerStaffRelaEntity> selectBySelective(SysPartnerStaffRelaEntity sysPartnerStaffRelaEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param sysPartnerStaffRelaEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(SysPartnerStaffRelaEntity sysPartnerStaffRelaEntity);
    
}
