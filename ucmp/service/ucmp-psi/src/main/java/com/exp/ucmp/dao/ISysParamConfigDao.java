/**
 * ISysParamConfigDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package com.exp.ucmp.dao;

import com.exp.ucmp.entity.SysParamConfigEntity;
import com.exp.ucmp.pk.SysParamConfigPk;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>ClassName: ISysParamConfigDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface ISysParamConfigDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_sys_param_config.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param sysParamConfigEntity 实体类
     * @return 插入多少行
     */
    public int insert(SysParamConfigEntity sysParamConfigEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param sysParamConfigEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(SysParamConfigEntity sysParamConfigEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listSysParamConfigEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<SysParamConfigEntity> listSysParamConfigEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param sysParamConfigEntity 实体类
     * @return 更新了多少行
     */
    public int update(SysParamConfigEntity sysParamConfigEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param sysParamConfigEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(SysParamConfigEntity sysParamConfigEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listSysParamConfigEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<SysParamConfigEntity> listSysParamConfigEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listSysParamConfigEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<SysParamConfigEntity> listSysParamConfigEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param sysParamConfigPk 实体类
     * @return 删除了多少行
     */
    public int delete(SysParamConfigPk sysParamConfigPk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param sysParamConfigEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(SysParamConfigEntity sysParamConfigEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param sysParamConfigPk 主键实体
     * @return sysParamConfigPk 单个实体对象
     */
    public SysParamConfigEntity load(SysParamConfigPk sysParamConfigPk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param sysParamConfigEntity 查询条件
     * @return 实体集合
     */
    public List<SysParamConfigEntity> selectBySelective(SysParamConfigEntity sysParamConfigEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param sysParamConfigEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(SysParamConfigEntity sysParamConfigEntity);
    
}
