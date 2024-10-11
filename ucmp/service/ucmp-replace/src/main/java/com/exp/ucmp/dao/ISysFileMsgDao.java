/**
 * ISysFileMsgDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package com.exp.ucmp.dao;

import com.exp.ucmp.entity.SysFileMsgEntity;
import com.exp.ucmp.pk.SysFileMsgPk;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>ClassName: ISysFileMsgDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface ISysFileMsgDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_sys_file_msg.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param sysFileMsgEntity 实体类
     * @return 插入多少行
     */
    public int insert(SysFileMsgEntity sysFileMsgEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param sysFileMsgEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(SysFileMsgEntity sysFileMsgEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listSysFileMsgEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<SysFileMsgEntity> listSysFileMsgEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param sysFileMsgEntity 实体类
     * @return 更新了多少行
     */
    public int update(SysFileMsgEntity sysFileMsgEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param sysFileMsgEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(SysFileMsgEntity sysFileMsgEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listSysFileMsgEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<SysFileMsgEntity> listSysFileMsgEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listSysFileMsgEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<SysFileMsgEntity> listSysFileMsgEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param sysFileMsgPk 实体类
     * @return 删除了多少行
     */
    public int delete(SysFileMsgPk sysFileMsgPk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param sysFileMsgEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(SysFileMsgEntity sysFileMsgEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param sysFileMsgPk 主键实体
     * @return sysFileMsgPk 单个实体对象
     */
    public SysFileMsgEntity load(SysFileMsgPk sysFileMsgPk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param sysFileMsgEntity 查询条件
     * @return 实体集合
     */
    public List<SysFileMsgEntity> selectBySelective(SysFileMsgEntity sysFileMsgEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param sysFileMsgEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(SysFileMsgEntity sysFileMsgEntity);
    
}
