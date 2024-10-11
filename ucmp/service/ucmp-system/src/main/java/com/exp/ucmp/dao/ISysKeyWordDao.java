/**
 * ISysKeyWordDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package com.exp.ucmp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.exp.ucmp.entity.SysKeyWordEntity;
import com.exp.ucmp.pk.SysKeyWordPk;
/**
 * <p>ClassName: ISysKeyWordDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface ISysKeyWordDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_sys_key_word.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param sysKeyWordEntity 实体类
     * @return 插入多少行
     */
    public int insert(SysKeyWordEntity sysKeyWordEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param sysKeyWordEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(SysKeyWordEntity sysKeyWordEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listSysKeyWordEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<SysKeyWordEntity> listSysKeyWordEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param sysKeyWordEntity 实体类
     * @return 更新了多少行
     */
    public int update(SysKeyWordEntity sysKeyWordEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param sysKeyWordEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(SysKeyWordEntity sysKeyWordEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listSysKeyWordEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<SysKeyWordEntity> listSysKeyWordEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listSysKeyWordEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<SysKeyWordEntity> listSysKeyWordEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param sysKeyWordPk 实体类
     * @return 删除了多少行
     */
    public int delete(SysKeyWordPk sysKeyWordPk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param sysKeyWordEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(SysKeyWordEntity sysKeyWordEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param sysKeyWordPk 主键实体
     * @return sysKeyWordPk 单个实体对象
     */
    public SysKeyWordEntity load(SysKeyWordPk sysKeyWordPk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param sysKeyWordEntity 查询条件
     * @return 实体集合
     */
    public List<SysKeyWordEntity> selectBySelective(SysKeyWordEntity sysKeyWordEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param sysKeyWordEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(SysKeyWordEntity sysKeyWordEntity);
    
	public void updateByKeyWord(SysKeyWordEntity entity);
    
}
