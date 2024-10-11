/**
 * ISysPayConfigDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package com.exp.ucmp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.exp.ucmp.entity.SysPayConfigEntity;
import com.exp.ucmp.pk.SysPayConfigPk;
/**
 * <p>ClassName: ISysPayConfigDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface ISysPayConfigDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_sys_pay_config.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param sysPayConfigEntity 实体类
     * @return 插入多少行
     */
    public int insert(SysPayConfigEntity sysPayConfigEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param sysPayConfigEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(SysPayConfigEntity sysPayConfigEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listSysPayConfigEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<SysPayConfigEntity> listSysPayConfigEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param sysPayConfigEntity 实体类
     * @return 更新了多少行
     */
    public int update(SysPayConfigEntity sysPayConfigEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param sysPayConfigEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(SysPayConfigEntity sysPayConfigEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listSysPayConfigEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<SysPayConfigEntity> listSysPayConfigEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listSysPayConfigEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<SysPayConfigEntity> listSysPayConfigEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param sysPayConfigPk 实体类
     * @return 删除了多少行
     */
    public int delete(SysPayConfigPk sysPayConfigPk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param sysPayConfigEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(SysPayConfigEntity sysPayConfigEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param sysPayConfigPk 主键实体
     * @return sysPayConfigPk 单个实体对象
     */
    public SysPayConfigEntity load(SysPayConfigPk sysPayConfigPk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param sysPayConfigEntity 查询条件
     * @return 实体集合
     */
    public List<SysPayConfigEntity> selectBySelective(SysPayConfigEntity sysPayConfigEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param sysPayConfigEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(SysPayConfigEntity sysPayConfigEntity);
    
}
