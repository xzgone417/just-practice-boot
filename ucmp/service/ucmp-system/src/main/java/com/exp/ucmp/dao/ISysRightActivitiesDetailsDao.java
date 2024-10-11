/**
 * ISysRightActivitiesDetailsDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package com.exp.ucmp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.exp.ucmp.entity.SysRightActivitiesDetailsEntity;
import com.exp.ucmp.pk.SysRightActivitiesDetailsPk;
/**
 * <p>ClassName: ISysRightActivitiesDetailsDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface ISysRightActivitiesDetailsDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_sys_right_activities_details.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param sysRightActivitiesDetailsEntity 实体类
     * @return 插入多少行
     */
    public int insert(SysRightActivitiesDetailsEntity sysRightActivitiesDetailsEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param sysRightActivitiesDetailsEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(SysRightActivitiesDetailsEntity sysRightActivitiesDetailsEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listSysRightActivitiesDetailsEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<SysRightActivitiesDetailsEntity> listSysRightActivitiesDetailsEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param sysRightActivitiesDetailsEntity 实体类
     * @return 更新了多少行
     */
    public int update(SysRightActivitiesDetailsEntity sysRightActivitiesDetailsEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param sysRightActivitiesDetailsEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(SysRightActivitiesDetailsEntity sysRightActivitiesDetailsEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listSysRightActivitiesDetailsEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<SysRightActivitiesDetailsEntity> listSysRightActivitiesDetailsEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listSysRightActivitiesDetailsEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<SysRightActivitiesDetailsEntity> listSysRightActivitiesDetailsEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param sysRightActivitiesDetailsPk 实体类
     * @return 删除了多少行
     */
    public int delete(SysRightActivitiesDetailsPk sysRightActivitiesDetailsPk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param sysRightActivitiesDetailsEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(SysRightActivitiesDetailsEntity sysRightActivitiesDetailsEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param sysRightActivitiesDetailsPk 主键实体
     * @return sysRightActivitiesDetailsPk 单个实体对象
     */
    public SysRightActivitiesDetailsEntity load(SysRightActivitiesDetailsPk sysRightActivitiesDetailsPk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param sysRightActivitiesDetailsEntity 查询条件
     * @return 实体集合
     */
    public List<SysRightActivitiesDetailsEntity> selectBySelective(SysRightActivitiesDetailsEntity sysRightActivitiesDetailsEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param sysRightActivitiesDetailsEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(SysRightActivitiesDetailsEntity sysRightActivitiesDetailsEntity);
    
}
