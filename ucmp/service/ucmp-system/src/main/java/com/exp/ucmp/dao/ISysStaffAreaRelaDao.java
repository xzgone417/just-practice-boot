/**
 * ISysStaffAreaRelaDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package com.exp.ucmp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.exp.ucmp.entity.SysStaffAreaRelaEntity;
import com.exp.ucmp.pk.SysStaffAreaRelaPk;
/**
 * <p>ClassName: ISysStaffAreaRelaDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface ISysStaffAreaRelaDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_sys_staff_area_rela.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param sysStaffAreaRelaEntity 实体类
     * @return 插入多少行
     */
    public int insert(SysStaffAreaRelaEntity sysStaffAreaRelaEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param sysStaffAreaRelaEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(SysStaffAreaRelaEntity sysStaffAreaRelaEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listSysStaffAreaRelaEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<SysStaffAreaRelaEntity> listSysStaffAreaRelaEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param sysStaffAreaRelaEntity 实体类
     * @return 更新了多少行
     */
    public int update(SysStaffAreaRelaEntity sysStaffAreaRelaEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param sysStaffAreaRelaEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(SysStaffAreaRelaEntity sysStaffAreaRelaEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listSysStaffAreaRelaEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<SysStaffAreaRelaEntity> listSysStaffAreaRelaEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listSysStaffAreaRelaEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<SysStaffAreaRelaEntity> listSysStaffAreaRelaEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param sysStaffAreaRelaPk 实体类
     * @return 删除了多少行
     */
    public int delete(SysStaffAreaRelaPk sysStaffAreaRelaPk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param sysStaffAreaRelaEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(SysStaffAreaRelaEntity sysStaffAreaRelaEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param sysStaffAreaRelaPk 主键实体
     * @return sysStaffAreaRelaPk 单个实体对象
     */
    public SysStaffAreaRelaEntity load(SysStaffAreaRelaPk sysStaffAreaRelaPk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param sysStaffAreaRelaEntity 查询条件
     * @return 实体集合
     */
    public List<SysStaffAreaRelaEntity> selectBySelective(SysStaffAreaRelaEntity sysStaffAreaRelaEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param sysStaffAreaRelaEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(SysStaffAreaRelaEntity sysStaffAreaRelaEntity);
    
}
