/**
 * ISysDatadictDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package com.exp.ucmp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.exp.ucmp.entity.SysDatadictEntity;
import com.exp.ucmp.pk.SysDatadictPk;
/**
 * <p>ClassName: ISysDatadictDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface ISysDatadictDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_sys_datadict.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param sysDatadictEntity 实体类
     * @return 插入多少行
     */
    public int insert(SysDatadictEntity sysDatadictEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param sysDatadictEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(SysDatadictEntity sysDatadictEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listSysDatadictEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<SysDatadictEntity> listSysDatadictEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param sysDatadictEntity 实体类
     * @return 更新了多少行
     */
    public int update(SysDatadictEntity sysDatadictEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param sysDatadictEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(SysDatadictEntity sysDatadictEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listSysDatadictEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<SysDatadictEntity> listSysDatadictEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listSysDatadictEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<SysDatadictEntity> listSysDatadictEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param sysDatadictPk 实体类
     * @return 删除了多少行
     */
    public int delete(SysDatadictPk sysDatadictPk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param sysDatadictEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(SysDatadictEntity sysDatadictEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param sysDatadictPk 主键实体
     * @return sysDatadictPk 单个实体对象
     */
    public SysDatadictEntity load(SysDatadictPk sysDatadictPk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param sysDatadictEntity 查询条件
     * @return 实体集合
     */
    public List<SysDatadictEntity> selectBySelective(SysDatadictEntity sysDatadictEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param sysDatadictEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(SysDatadictEntity sysDatadictEntity);
    
}
