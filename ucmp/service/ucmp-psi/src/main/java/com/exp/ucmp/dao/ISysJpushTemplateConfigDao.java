/**
 * ISysJpushTemplateConfigDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package com.exp.ucmp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.exp.ucmp.entity.SysJpushTemplateConfigEntity;
import com.exp.ucmp.pk.SysJpushTemplateConfigPk;
/**
 * <p>ClassName: ISysJpushTemplateConfigDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface ISysJpushTemplateConfigDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_sys_jpush_template_config.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param sysJpushTemplateConfigEntity 实体类
     * @return 插入多少行
     */
    public int insert(SysJpushTemplateConfigEntity sysJpushTemplateConfigEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param sysJpushTemplateConfigEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(SysJpushTemplateConfigEntity sysJpushTemplateConfigEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listSysJpushTemplateConfigEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<SysJpushTemplateConfigEntity> listSysJpushTemplateConfigEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param sysJpushTemplateConfigEntity 实体类
     * @return 更新了多少行
     */
    public int update(SysJpushTemplateConfigEntity sysJpushTemplateConfigEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param sysJpushTemplateConfigEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(SysJpushTemplateConfigEntity sysJpushTemplateConfigEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listSysJpushTemplateConfigEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<SysJpushTemplateConfigEntity> listSysJpushTemplateConfigEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listSysJpushTemplateConfigEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<SysJpushTemplateConfigEntity> listSysJpushTemplateConfigEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param sysJpushTemplateConfigPk 实体类
     * @return 删除了多少行
     */
    public int delete(SysJpushTemplateConfigPk sysJpushTemplateConfigPk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param sysJpushTemplateConfigEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(SysJpushTemplateConfigEntity sysJpushTemplateConfigEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param sysJpushTemplateConfigPk 主键实体
     * @return sysJpushTemplateConfigPk 单个实体对象
     */
    public SysJpushTemplateConfigEntity load(SysJpushTemplateConfigPk sysJpushTemplateConfigPk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param sysJpushTemplateConfigEntity 查询条件
     * @return 实体集合
     */
    public List<SysJpushTemplateConfigEntity> selectBySelective(SysJpushTemplateConfigEntity sysJpushTemplateConfigEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param sysJpushTemplateConfigEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(SysJpushTemplateConfigEntity sysJpushTemplateConfigEntity);
    
}
