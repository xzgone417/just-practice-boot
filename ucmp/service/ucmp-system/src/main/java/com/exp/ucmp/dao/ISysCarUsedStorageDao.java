/**
 * ISysCarUsedStorageDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO EgridCloud, Inc, All rights reserved.
 */
package com.exp.ucmp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.exp.ucmp.entity.SysCarUsedStorageEntity;
import com.exp.ucmp.pk.SysCarUsedStoragePk;
import com.exp.ucmp.usedstorage.dto.UsedStorageInfoDto;
/**
 * <p>ClassName: ISysCarUsedStorageDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface ISysCarUsedStorageDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_sys_car_used_storage.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param sysCarUsedStorageEntity 实体类
     * @return 插入多少行
     */
    public int insert(SysCarUsedStorageEntity sysCarUsedStorageEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param sysCarUsedStorageEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(SysCarUsedStorageEntity sysCarUsedStorageEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listSysCarUsedStorageEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<SysCarUsedStorageEntity> listSysCarUsedStorageEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param sysCarUsedStorageEntity 实体类
     * @return 更新了多少行
     */
    public int update(SysCarUsedStorageEntity sysCarUsedStorageEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param sysCarUsedStorageEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(SysCarUsedStorageEntity sysCarUsedStorageEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listSysCarUsedStorageEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<SysCarUsedStorageEntity> listSysCarUsedStorageEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listSysCarUsedStorageEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<SysCarUsedStorageEntity> listSysCarUsedStorageEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param sysCarUsedStoragePk 实体类
     * @return 删除了多少行
     */
    public int delete(SysCarUsedStoragePk sysCarUsedStoragePk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param sysCarUsedStorageEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(SysCarUsedStorageEntity sysCarUsedStorageEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param sysCarUsedStoragePk 主键实体
     * @return sysCarUsedStoragePk 单个实体对象
     */
    public SysCarUsedStorageEntity load(SysCarUsedStoragePk sysCarUsedStoragePk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param sysCarUsedStorageEntity 查询条件
     * @return 实体集合
     */
    public List<SysCarUsedStorageEntity> selectBySelective(SysCarUsedStorageEntity sysCarUsedStorageEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param sysCarUsedStorageEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(SysCarUsedStorageEntity sysCarUsedStorageEntity);
    
	public List<UsedStorageInfoDto> queryList(String usedstorageName);
    
}
