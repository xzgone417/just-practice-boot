/**
 * ISysRoleDetailsDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package com.exp.ucmp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.exp.ucmp.entity.SysRoleDetailsEntity;
import com.exp.ucmp.pk.SysRoleDetailsPk;
/**
 * <p>ClassName: ISysRoleDetailsDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface ISysRoleDetailsDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_sys_role_details.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param sysRoleDetailsEntity 实体类
     * @return 插入多少行
     */
    public int insert(SysRoleDetailsEntity sysRoleDetailsEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param sysRoleDetailsEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(SysRoleDetailsEntity sysRoleDetailsEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listSysRoleDetailsEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<SysRoleDetailsEntity> listSysRoleDetailsEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param sysRoleDetailsEntity 实体类
     * @return 更新了多少行
     */
    public int update(SysRoleDetailsEntity sysRoleDetailsEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param sysRoleDetailsEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(SysRoleDetailsEntity sysRoleDetailsEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listSysRoleDetailsEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<SysRoleDetailsEntity> listSysRoleDetailsEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listSysRoleDetailsEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<SysRoleDetailsEntity> listSysRoleDetailsEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param sysRoleDetailsPk 实体类
     * @return 删除了多少行
     */
    public int delete(SysRoleDetailsPk sysRoleDetailsPk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param sysRoleDetailsEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(SysRoleDetailsEntity sysRoleDetailsEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param sysRoleDetailsPk 主键实体
     * @return sysRoleDetailsPk 单个实体对象
     */
    public SysRoleDetailsEntity load(SysRoleDetailsPk sysRoleDetailsPk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param sysRoleDetailsEntity 查询条件
     * @return 实体集合
     */
    public List<SysRoleDetailsEntity> selectBySelective(SysRoleDetailsEntity sysRoleDetailsEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param sysRoleDetailsEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(SysRoleDetailsEntity sysRoleDetailsEntity);
    
}
