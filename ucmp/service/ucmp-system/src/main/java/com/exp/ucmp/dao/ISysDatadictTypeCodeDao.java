/**
 * ISysDatadictTypeCodeDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package com.exp.ucmp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.exp.ucmp.entity.SysDatadictTypeCodeEntity;
import com.exp.ucmp.pk.SysDatadictTypeCodePk;
/**
 * <p>ClassName: ISysDatadictTypeCodeDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface ISysDatadictTypeCodeDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_sys_datadict_type_code.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param sysDatadictTypeCodeEntity 实体类
     * @return 插入多少行
     */
    public int insert(SysDatadictTypeCodeEntity sysDatadictTypeCodeEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param sysDatadictTypeCodeEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(SysDatadictTypeCodeEntity sysDatadictTypeCodeEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listSysDatadictTypeCodeEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<SysDatadictTypeCodeEntity> listSysDatadictTypeCodeEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param sysDatadictTypeCodeEntity 实体类
     * @return 更新了多少行
     */
    public int update(SysDatadictTypeCodeEntity sysDatadictTypeCodeEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param sysDatadictTypeCodeEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(SysDatadictTypeCodeEntity sysDatadictTypeCodeEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listSysDatadictTypeCodeEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<SysDatadictTypeCodeEntity> listSysDatadictTypeCodeEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listSysDatadictTypeCodeEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<SysDatadictTypeCodeEntity> listSysDatadictTypeCodeEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param sysDatadictTypeCodePk 实体类
     * @return 删除了多少行
     */
    public int delete(SysDatadictTypeCodePk sysDatadictTypeCodePk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param sysDatadictTypeCodeEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(SysDatadictTypeCodeEntity sysDatadictTypeCodeEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param sysDatadictTypeCodePk 主键实体
     * @return sysDatadictTypeCodePk 单个实体对象
     */
    public SysDatadictTypeCodeEntity load(SysDatadictTypeCodePk sysDatadictTypeCodePk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param sysDatadictTypeCodeEntity 查询条件
     * @return 实体集合
     */
    public List<SysDatadictTypeCodeEntity> selectBySelective(SysDatadictTypeCodeEntity sysDatadictTypeCodeEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param sysDatadictTypeCodeEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(SysDatadictTypeCodeEntity sysDatadictTypeCodeEntity);
    
}
