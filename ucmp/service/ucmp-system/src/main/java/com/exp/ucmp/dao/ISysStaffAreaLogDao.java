/**
 * ISysStaffAreaLogDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package com.exp.ucmp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.exp.ucmp.entity.SysStaffAreaLogEntity;
import com.exp.ucmp.pk.SysStaffAreaLogPk;
/**
 * <p>ClassName: ISysStaffAreaLogDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface ISysStaffAreaLogDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_sys_staff_area_log.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param sysStaffAreaLogEntity 实体类
     * @return 插入多少行
     */
    public int insert(SysStaffAreaLogEntity sysStaffAreaLogEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param sysStaffAreaLogEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(SysStaffAreaLogEntity sysStaffAreaLogEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listSysStaffAreaLogEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<SysStaffAreaLogEntity> listSysStaffAreaLogEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param sysStaffAreaLogEntity 实体类
     * @return 更新了多少行
     */
    public int update(SysStaffAreaLogEntity sysStaffAreaLogEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param sysStaffAreaLogEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(SysStaffAreaLogEntity sysStaffAreaLogEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listSysStaffAreaLogEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<SysStaffAreaLogEntity> listSysStaffAreaLogEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listSysStaffAreaLogEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<SysStaffAreaLogEntity> listSysStaffAreaLogEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param sysStaffAreaLogPk 实体类
     * @return 删除了多少行
     */
    public int delete(SysStaffAreaLogPk sysStaffAreaLogPk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param sysStaffAreaLogEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(SysStaffAreaLogEntity sysStaffAreaLogEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param sysStaffAreaLogPk 主键实体
     * @return sysStaffAreaLogPk 单个实体对象
     */
    public SysStaffAreaLogEntity load(SysStaffAreaLogPk sysStaffAreaLogPk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param sysStaffAreaLogEntity 查询条件
     * @return 实体集合
     */
    public List<SysStaffAreaLogEntity> selectBySelective(SysStaffAreaLogEntity sysStaffAreaLogEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param sysStaffAreaLogEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(SysStaffAreaLogEntity sysStaffAreaLogEntity);
    
}
