/**
 * ISysRightActivitiesDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package com.exp.ucmp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.exp.ucmp.entity.SysRightActivitiesEntity;
import com.exp.ucmp.pk.SysRightActivitiesPk;
/**
 * <p>ClassName: ISysRightActivitiesDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface ISysRightActivitiesDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_sys_right_activities.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param sysRightActivitiesEntity 实体类
     * @return 插入多少行
     */
    public int insert(SysRightActivitiesEntity sysRightActivitiesEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param sysRightActivitiesEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(SysRightActivitiesEntity sysRightActivitiesEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listSysRightActivitiesEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<SysRightActivitiesEntity> listSysRightActivitiesEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param sysRightActivitiesEntity 实体类
     * @return 更新了多少行
     */
    public int update(SysRightActivitiesEntity sysRightActivitiesEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param sysRightActivitiesEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(SysRightActivitiesEntity sysRightActivitiesEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listSysRightActivitiesEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<SysRightActivitiesEntity> listSysRightActivitiesEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listSysRightActivitiesEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<SysRightActivitiesEntity> listSysRightActivitiesEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param sysRightActivitiesPk 实体类
     * @return 删除了多少行
     */
    public int delete(SysRightActivitiesPk sysRightActivitiesPk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param sysRightActivitiesEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(SysRightActivitiesEntity sysRightActivitiesEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param sysRightActivitiesPk 主键实体
     * @return sysRightActivitiesPk 单个实体对象
     */
    public SysRightActivitiesEntity load(SysRightActivitiesPk sysRightActivitiesPk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param sysRightActivitiesEntity 查询条件
     * @return 实体集合
     */
    public List<SysRightActivitiesEntity> selectBySelective(SysRightActivitiesEntity sysRightActivitiesEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param sysRightActivitiesEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(SysRightActivitiesEntity sysRightActivitiesEntity);
    
}
