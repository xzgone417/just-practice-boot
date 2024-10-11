/**
 * ISysUserBehaviorResponseDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package com.exp.ucmp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.exp.ucmp.entity.SysUserBehaviorResponseEntity;
import com.exp.ucmp.pk.SysUserBehaviorResponsePk;
/**
 * <p>ClassName: ISysUserBehaviorResponseDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface ISysUserBehaviorResponseDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_sys_user_behavior_response.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param sysUserBehaviorResponseEntity 实体类
     * @return 插入多少行
     */
    public int insert(SysUserBehaviorResponseEntity sysUserBehaviorResponseEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param sysUserBehaviorResponseEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(SysUserBehaviorResponseEntity sysUserBehaviorResponseEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listSysUserBehaviorResponseEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<SysUserBehaviorResponseEntity> listSysUserBehaviorResponseEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param sysUserBehaviorResponseEntity 实体类
     * @return 更新了多少行
     */
    public int update(SysUserBehaviorResponseEntity sysUserBehaviorResponseEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param sysUserBehaviorResponseEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(SysUserBehaviorResponseEntity sysUserBehaviorResponseEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listSysUserBehaviorResponseEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<SysUserBehaviorResponseEntity> listSysUserBehaviorResponseEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listSysUserBehaviorResponseEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<SysUserBehaviorResponseEntity> listSysUserBehaviorResponseEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param sysUserBehaviorResponsePk 实体类
     * @return 删除了多少行
     */
    public int delete(SysUserBehaviorResponsePk sysUserBehaviorResponsePk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param sysUserBehaviorResponseEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(SysUserBehaviorResponseEntity sysUserBehaviorResponseEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param sysUserBehaviorResponsePk 主键实体
     * @return sysUserBehaviorResponsePk 单个实体对象
     */
    public SysUserBehaviorResponseEntity load(SysUserBehaviorResponsePk sysUserBehaviorResponsePk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param sysUserBehaviorResponseEntity 查询条件
     * @return 实体集合
     */
    public List<SysUserBehaviorResponseEntity> selectBySelective(SysUserBehaviorResponseEntity sysUserBehaviorResponseEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param sysUserBehaviorResponseEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(SysUserBehaviorResponseEntity sysUserBehaviorResponseEntity);
    
}
