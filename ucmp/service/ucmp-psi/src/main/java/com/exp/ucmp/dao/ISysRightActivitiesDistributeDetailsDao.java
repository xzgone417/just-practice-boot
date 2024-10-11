/**
 * ISysRightActivitiesDistributeDetailsDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package com.exp.ucmp.dao;

import com.exp.ucmp.entity.SysRightActivitiesDistributeDetailsEntity;
import com.exp.ucmp.pk.SysRightActivitiesDistributeDetailsPk;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>ClassName: ISysRightActivitiesDistributeDetailsDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface ISysRightActivitiesDistributeDetailsDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_sys_right_activities_distribute_details.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param sysRightActivitiesDistributeDetailsEntity 实体类
     * @return 插入多少行
     */
    public int insert(SysRightActivitiesDistributeDetailsEntity sysRightActivitiesDistributeDetailsEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param sysRightActivitiesDistributeDetailsEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(SysRightActivitiesDistributeDetailsEntity sysRightActivitiesDistributeDetailsEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listSysRightActivitiesDistributeDetailsEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<SysRightActivitiesDistributeDetailsEntity> listSysRightActivitiesDistributeDetailsEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param sysRightActivitiesDistributeDetailsEntity 实体类
     * @return 更新了多少行
     */
    public int update(SysRightActivitiesDistributeDetailsEntity sysRightActivitiesDistributeDetailsEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param sysRightActivitiesDistributeDetailsEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(SysRightActivitiesDistributeDetailsEntity sysRightActivitiesDistributeDetailsEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listSysRightActivitiesDistributeDetailsEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<SysRightActivitiesDistributeDetailsEntity> listSysRightActivitiesDistributeDetailsEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listSysRightActivitiesDistributeDetailsEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<SysRightActivitiesDistributeDetailsEntity> listSysRightActivitiesDistributeDetailsEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param sysRightActivitiesDistributeDetailsPk 实体类
     * @return 删除了多少行
     */
    public int delete(SysRightActivitiesDistributeDetailsPk sysRightActivitiesDistributeDetailsPk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param sysRightActivitiesDistributeDetailsEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(SysRightActivitiesDistributeDetailsEntity sysRightActivitiesDistributeDetailsEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param sysRightActivitiesDistributeDetailsPk 主键实体
     * @return sysRightActivitiesDistributeDetailsPk 单个实体对象
     */
    public SysRightActivitiesDistributeDetailsEntity load(SysRightActivitiesDistributeDetailsPk sysRightActivitiesDistributeDetailsPk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param sysRightActivitiesDistributeDetailsEntity 查询条件
     * @return 实体集合
     */
    public List<SysRightActivitiesDistributeDetailsEntity> selectBySelective(SysRightActivitiesDistributeDetailsEntity sysRightActivitiesDistributeDetailsEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param sysRightActivitiesDistributeDetailsEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(SysRightActivitiesDistributeDetailsEntity sysRightActivitiesDistributeDetailsEntity);
    
}
