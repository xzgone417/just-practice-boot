/**
 * ISysAreaRegionRelaDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package com.exp.ucmp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.exp.ucmp.entity.SysAreaRegionRelaEntity;
import com.exp.ucmp.pk.SysAreaRegionRelaPk;
/**
 * <p>ClassName: ISysAreaRegionRelaDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface ISysAreaRegionRelaDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_sys_area_region_rela.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param sysAreaRegionRelaEntity 实体类
     * @return 插入多少行
     */
    public int insert(SysAreaRegionRelaEntity sysAreaRegionRelaEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param sysAreaRegionRelaEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(SysAreaRegionRelaEntity sysAreaRegionRelaEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listSysAreaRegionRelaEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<SysAreaRegionRelaEntity> listSysAreaRegionRelaEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param sysAreaRegionRelaEntity 实体类
     * @return 更新了多少行
     */
    public int update(SysAreaRegionRelaEntity sysAreaRegionRelaEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param sysAreaRegionRelaEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(SysAreaRegionRelaEntity sysAreaRegionRelaEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listSysAreaRegionRelaEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<SysAreaRegionRelaEntity> listSysAreaRegionRelaEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listSysAreaRegionRelaEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<SysAreaRegionRelaEntity> listSysAreaRegionRelaEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param sysAreaRegionRelaPk 实体类
     * @return 删除了多少行
     */
    public int delete(SysAreaRegionRelaPk sysAreaRegionRelaPk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param sysAreaRegionRelaEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(SysAreaRegionRelaEntity sysAreaRegionRelaEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param sysAreaRegionRelaPk 主键实体
     * @return sysAreaRegionRelaPk 单个实体对象
     */
    public SysAreaRegionRelaEntity load(SysAreaRegionRelaPk sysAreaRegionRelaPk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param sysAreaRegionRelaEntity 查询条件
     * @return 实体集合
     */
    public List<SysAreaRegionRelaEntity> selectBySelective(SysAreaRegionRelaEntity sysAreaRegionRelaEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param sysAreaRegionRelaEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(SysAreaRegionRelaEntity sysAreaRegionRelaEntity);
    
}
