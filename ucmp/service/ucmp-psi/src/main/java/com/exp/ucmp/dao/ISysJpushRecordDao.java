/**
 * ISysJpushRecordDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package com.exp.ucmp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.exp.ucmp.entity.SysJpushRecordEntity;
import com.exp.ucmp.pk.SysJpushRecordPk;
/**
 * <p>ClassName: ISysJpushRecordDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface ISysJpushRecordDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_sys_jpush_record.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param sysJpushRecordEntity 实体类
     * @return 插入多少行
     */
    public int insert(SysJpushRecordEntity sysJpushRecordEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param sysJpushRecordEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(SysJpushRecordEntity sysJpushRecordEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listSysJpushRecordEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<SysJpushRecordEntity> listSysJpushRecordEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param sysJpushRecordEntity 实体类
     * @return 更新了多少行
     */
    public int update(SysJpushRecordEntity sysJpushRecordEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param sysJpushRecordEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(SysJpushRecordEntity sysJpushRecordEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listSysJpushRecordEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<SysJpushRecordEntity> listSysJpushRecordEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listSysJpushRecordEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<SysJpushRecordEntity> listSysJpushRecordEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param sysJpushRecordPk 实体类
     * @return 删除了多少行
     */
    public int delete(SysJpushRecordPk sysJpushRecordPk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param sysJpushRecordEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(SysJpushRecordEntity sysJpushRecordEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param sysJpushRecordPk 主键实体
     * @return sysJpushRecordPk 单个实体对象
     */
    public SysJpushRecordEntity load(SysJpushRecordPk sysJpushRecordPk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param sysJpushRecordEntity 查询条件
     * @return 实体集合
     */
    public List<SysJpushRecordEntity> selectBySelective(SysJpushRecordEntity sysJpushRecordEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param sysJpushRecordEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(SysJpushRecordEntity sysJpushRecordEntity);
    
}
