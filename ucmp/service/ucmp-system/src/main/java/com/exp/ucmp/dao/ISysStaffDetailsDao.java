/**
 * ISysStaffDetailsDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package com.exp.ucmp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.exp.ucmp.entity.SysStaffDetailsEntity;
import com.exp.ucmp.pk.SysStaffDetailsPk;
/**
 * <p>ClassName: ISysStaffDetailsDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface ISysStaffDetailsDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_sys_staff_details.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param sysStaffDetailsEntity 实体类
     * @return 插入多少行
     */
    public int insert(SysStaffDetailsEntity sysStaffDetailsEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param sysStaffDetailsEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(SysStaffDetailsEntity sysStaffDetailsEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listSysStaffDetailsEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<SysStaffDetailsEntity> listSysStaffDetailsEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param sysStaffDetailsEntity 实体类
     * @return 更新了多少行
     */
    public int update(SysStaffDetailsEntity sysStaffDetailsEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param sysStaffDetailsEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(SysStaffDetailsEntity sysStaffDetailsEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listSysStaffDetailsEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<SysStaffDetailsEntity> listSysStaffDetailsEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listSysStaffDetailsEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<SysStaffDetailsEntity> listSysStaffDetailsEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param sysStaffDetailsPk 实体类
     * @return 删除了多少行
     */
    public int delete(SysStaffDetailsPk sysStaffDetailsPk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param sysStaffDetailsEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(SysStaffDetailsEntity sysStaffDetailsEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param sysStaffDetailsPk 主键实体
     * @return sysStaffDetailsPk 单个实体对象
     */
    public SysStaffDetailsEntity load(SysStaffDetailsPk sysStaffDetailsPk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param sysStaffDetailsEntity 查询条件
     * @return 实体集合
     */
    public List<SysStaffDetailsEntity> selectBySelective(SysStaffDetailsEntity sysStaffDetailsEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param sysStaffDetailsEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(SysStaffDetailsEntity sysStaffDetailsEntity);
    
}
