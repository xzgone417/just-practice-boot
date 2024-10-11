/**
 * ISysUserBehaviorDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package com.exp.ucmp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.exp.ucmp.entity.SysUserBehaviorEntity;
import com.exp.ucmp.pk.SysUserBehaviorPk;
/**
 * <p>ClassName: ISysUserBehaviorDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface ISysUserBehaviorDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_sys_user_behavior.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param sysUserBehaviorEntity 实体类
     * @return 插入多少行
     */
    public int insert(SysUserBehaviorEntity sysUserBehaviorEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param sysUserBehaviorEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(SysUserBehaviorEntity sysUserBehaviorEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listSysUserBehaviorEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<SysUserBehaviorEntity> listSysUserBehaviorEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param sysUserBehaviorEntity 实体类
     * @return 更新了多少行
     */
    public int update(SysUserBehaviorEntity sysUserBehaviorEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param sysUserBehaviorEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(SysUserBehaviorEntity sysUserBehaviorEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listSysUserBehaviorEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<SysUserBehaviorEntity> listSysUserBehaviorEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listSysUserBehaviorEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<SysUserBehaviorEntity> listSysUserBehaviorEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param sysUserBehaviorPk 实体类
     * @return 删除了多少行
     */
    public int delete(SysUserBehaviorPk sysUserBehaviorPk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param sysUserBehaviorEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(SysUserBehaviorEntity sysUserBehaviorEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param sysUserBehaviorPk 主键实体
     * @return sysUserBehaviorPk 单个实体对象
     */
    public SysUserBehaviorEntity load(SysUserBehaviorPk sysUserBehaviorPk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param sysUserBehaviorEntity 查询条件
     * @return 实体集合
     */
    public List<SysUserBehaviorEntity> selectBySelective(SysUserBehaviorEntity sysUserBehaviorEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param sysUserBehaviorEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(SysUserBehaviorEntity sysUserBehaviorEntity);
    
}
