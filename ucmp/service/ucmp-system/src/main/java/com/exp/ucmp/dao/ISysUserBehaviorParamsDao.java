/**
 * ISysUserBehaviorParamsDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package com.exp.ucmp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.exp.ucmp.entity.SysUserBehaviorParamsEntity;
import com.exp.ucmp.pk.SysUserBehaviorParamsPk;
/**
 * <p>ClassName: ISysUserBehaviorParamsDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface ISysUserBehaviorParamsDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_sys_user_behavior_params.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param sysUserBehaviorParamsEntity 实体类
     * @return 插入多少行
     */
    public int insert(SysUserBehaviorParamsEntity sysUserBehaviorParamsEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param sysUserBehaviorParamsEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(SysUserBehaviorParamsEntity sysUserBehaviorParamsEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listSysUserBehaviorParamsEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<SysUserBehaviorParamsEntity> listSysUserBehaviorParamsEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param sysUserBehaviorParamsEntity 实体类
     * @return 更新了多少行
     */
    public int update(SysUserBehaviorParamsEntity sysUserBehaviorParamsEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param sysUserBehaviorParamsEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(SysUserBehaviorParamsEntity sysUserBehaviorParamsEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listSysUserBehaviorParamsEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<SysUserBehaviorParamsEntity> listSysUserBehaviorParamsEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listSysUserBehaviorParamsEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<SysUserBehaviorParamsEntity> listSysUserBehaviorParamsEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param sysUserBehaviorParamsPk 实体类
     * @return 删除了多少行
     */
    public int delete(SysUserBehaviorParamsPk sysUserBehaviorParamsPk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param sysUserBehaviorParamsEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(SysUserBehaviorParamsEntity sysUserBehaviorParamsEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param sysUserBehaviorParamsPk 主键实体
     * @return sysUserBehaviorParamsPk 单个实体对象
     */
    public SysUserBehaviorParamsEntity load(SysUserBehaviorParamsPk sysUserBehaviorParamsPk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param sysUserBehaviorParamsEntity 查询条件
     * @return 实体集合
     */
    public List<SysUserBehaviorParamsEntity> selectBySelective(SysUserBehaviorParamsEntity sysUserBehaviorParamsEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param sysUserBehaviorParamsEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(SysUserBehaviorParamsEntity sysUserBehaviorParamsEntity);
    
}
