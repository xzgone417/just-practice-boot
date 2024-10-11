/**
 * ISysConfigTopPicDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package com.exp.ucmp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.exp.ucmp.entity.SysConfigTopPicEntity;
import com.exp.ucmp.pk.SysConfigTopPicPk;
/**
 * <p>ClassName: ISysConfigTopPicDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface ISysConfigTopPicDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_sys_config_top_pic.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param sysConfigTopPicEntity 实体类
     * @return 插入多少行
     */
    public int insert(SysConfigTopPicEntity sysConfigTopPicEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param sysConfigTopPicEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(SysConfigTopPicEntity sysConfigTopPicEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listSysConfigTopPicEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<SysConfigTopPicEntity> listSysConfigTopPicEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param sysConfigTopPicEntity 实体类
     * @return 更新了多少行
     */
    public int update(SysConfigTopPicEntity sysConfigTopPicEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param sysConfigTopPicEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(SysConfigTopPicEntity sysConfigTopPicEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listSysConfigTopPicEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<SysConfigTopPicEntity> listSysConfigTopPicEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listSysConfigTopPicEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<SysConfigTopPicEntity> listSysConfigTopPicEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param sysConfigTopPicPk 实体类
     * @return 删除了多少行
     */
    public int delete(SysConfigTopPicPk sysConfigTopPicPk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param sysConfigTopPicEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(SysConfigTopPicEntity sysConfigTopPicEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param sysConfigTopPicPk 主键实体
     * @return sysConfigTopPicPk 单个实体对象
     */
    public SysConfigTopPicEntity load(SysConfigTopPicPk sysConfigTopPicPk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param sysConfigTopPicEntity 查询条件
     * @return 实体集合
     */
    public List<SysConfigTopPicEntity> selectBySelective(SysConfigTopPicEntity sysConfigTopPicEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param sysConfigTopPicEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(SysConfigTopPicEntity sysConfigTopPicEntity);
    
}
