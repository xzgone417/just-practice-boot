/**
 * ISysAreaInfoDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package com.exp.ucmp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.exp.ucmp.entity.SysAreaInfoEntity;
import com.exp.ucmp.pk.SysAreaInfoPk;
/**
 * <p>ClassName: ISysAreaInfoDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface ISysAreaInfoDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_sys_area_info.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param sysAreaInfoEntity 实体类
     * @return 插入多少行
     */
    public int insert(SysAreaInfoEntity sysAreaInfoEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param sysAreaInfoEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(SysAreaInfoEntity sysAreaInfoEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listSysAreaInfoEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<SysAreaInfoEntity> listSysAreaInfoEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param sysAreaInfoEntity 实体类
     * @return 更新了多少行
     */
    public int update(SysAreaInfoEntity sysAreaInfoEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param sysAreaInfoEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(SysAreaInfoEntity sysAreaInfoEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listSysAreaInfoEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<SysAreaInfoEntity> listSysAreaInfoEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listSysAreaInfoEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<SysAreaInfoEntity> listSysAreaInfoEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param sysAreaInfoPk 实体类
     * @return 删除了多少行
     */
    public int delete(SysAreaInfoPk sysAreaInfoPk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param sysAreaInfoEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(SysAreaInfoEntity sysAreaInfoEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param sysAreaInfoPk 主键实体
     * @return sysAreaInfoPk 单个实体对象
     */
    public SysAreaInfoEntity load(SysAreaInfoPk sysAreaInfoPk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param sysAreaInfoEntity 查询条件
     * @return 实体集合
     */
    public List<SysAreaInfoEntity> selectBySelective(SysAreaInfoEntity sysAreaInfoEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param sysAreaInfoEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(SysAreaInfoEntity sysAreaInfoEntity);
    
}
