/**
 * ISysStoreStaffInfoDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package com.exp.ucmp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.exp.ucmp.entity.SysStoreStaffInfoEntity;
import com.exp.ucmp.pk.SysStoreStaffInfoPk;
/**
 * <p>ClassName: ISysStoreStaffInfoDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface ISysStoreStaffInfoDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_sys_store_staff_info.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param sysStoreStaffInfoEntity 实体类
     * @return 插入多少行
     */
    public int insert(SysStoreStaffInfoEntity sysStoreStaffInfoEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param sysStoreStaffInfoEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(SysStoreStaffInfoEntity sysStoreStaffInfoEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listSysStoreStaffInfoEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<SysStoreStaffInfoEntity> listSysStoreStaffInfoEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param sysStoreStaffInfoEntity 实体类
     * @return 更新了多少行
     */
    public int update(SysStoreStaffInfoEntity sysStoreStaffInfoEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param sysStoreStaffInfoEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(SysStoreStaffInfoEntity sysStoreStaffInfoEntity);

    /**
     * <p>Description: 全字段更新</p>
     * @param listSysStoreStaffInfoEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<SysStoreStaffInfoEntity> listSysStoreStaffInfoEntity);

    /**
     * <p>Description: 选择字段更新</p>
     * @param listSysStoreStaffInfoEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<SysStoreStaffInfoEntity> listSysStoreStaffInfoEntity);

    /**
     * <p>Description: 根据主键删除</p>
     * @param sysStoreStaffInfoPk 实体类
     * @return 删除了多少行
     */
    public int delete(SysStoreStaffInfoPk sysStoreStaffInfoPk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param sysStoreStaffInfoEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(SysStoreStaffInfoEntity sysStoreStaffInfoEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param sysStoreStaffInfoPk 主键实体
     * @return sysStoreStaffInfoPk 单个实体对象
     */
    public SysStoreStaffInfoEntity load(SysStoreStaffInfoPk sysStoreStaffInfoPk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param sysStoreStaffInfoEntity 查询条件
     * @return 实体集合
     */
    public List<SysStoreStaffInfoEntity> selectBySelective(SysStoreStaffInfoEntity sysStoreStaffInfoEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param sysStoreStaffInfoEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(SysStoreStaffInfoEntity sysStoreStaffInfoEntity);

}
