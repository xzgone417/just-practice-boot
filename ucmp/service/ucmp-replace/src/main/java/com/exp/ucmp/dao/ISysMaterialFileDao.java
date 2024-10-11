/**
 * ISysMaterialFileDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package com.exp.ucmp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.exp.ucmp.entity.SysMaterialFileEntity;
import com.exp.ucmp.pk.SysMaterialFilePk;
/**
 * <p>ClassName: ISysMaterialFileDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface ISysMaterialFileDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_sys_material_file.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param sysMaterialFileEntity 实体类
     * @return 插入多少行
     */
    public int insert(SysMaterialFileEntity sysMaterialFileEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param sysMaterialFileEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(SysMaterialFileEntity sysMaterialFileEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listSysMaterialFileEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<SysMaterialFileEntity> listSysMaterialFileEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param sysMaterialFileEntity 实体类
     * @return 更新了多少行
     */
    public int update(SysMaterialFileEntity sysMaterialFileEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param sysMaterialFileEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(SysMaterialFileEntity sysMaterialFileEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listSysMaterialFileEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<SysMaterialFileEntity> listSysMaterialFileEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listSysMaterialFileEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<SysMaterialFileEntity> listSysMaterialFileEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param sysMaterialFilePk 实体类
     * @return 删除了多少行
     */
    public int delete(SysMaterialFilePk sysMaterialFilePk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param sysMaterialFileEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(SysMaterialFileEntity sysMaterialFileEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param sysMaterialFilePk 主键实体
     * @return sysMaterialFilePk 单个实体对象
     */
    public SysMaterialFileEntity load(SysMaterialFilePk sysMaterialFilePk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param sysMaterialFileEntity 查询条件
     * @return 实体集合
     */
    public List<SysMaterialFileEntity> selectBySelective(SysMaterialFileEntity sysMaterialFileEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param sysMaterialFileEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(SysMaterialFileEntity sysMaterialFileEntity);
    
}
