/**
 * IMenuInfoDao.java
 * Created at 2018年09月29日
 * Created by TODO
 * Copyright (C) TODO EgridCloud, Inc, All rights reserved.
 */
package com.exp.ucmp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;

import com.exp.ucmp.entity.MenuInfoEntity;
import com.exp.ucmp.pk.MenuInfoPk;
/**
 * ClassName: IMenuInfoDao
 * Description: TODO
 * @author TODO
 * @date 2022年07月12日
 * @since 1.0
 */
public interface IMenuInfoDao {
    /**
     * Description: 获取序列，序列按照SEQ+表名设计
     * @return 序列
     */
    @Select("select SEQ_t_menu_info.Nextval from dual")
    public long selectSequence();
    /**
     * Description: 全字段插入
     * @param menuInfoEntity 实体类
     * @return 插入多少行
     */
    public int insert(MenuInfoEntity menuInfoEntity);
    /**
     * Description: 选择全字段插入
     * @param menuInfoEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(MenuInfoEntity menuInfoEntity);
    /**
     * Description: 全字段插入
     * @param listMenuInfoEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<MenuInfoEntity> listMenuInfoEntity);
    /**
     * Description: 全字段更新
     * @param menuInfoEntity 实体类
     * @return 更新了多少行
     */
    public int update(MenuInfoEntity menuInfoEntity);
    /**
     * Description: 选择字段更新
     * @param menuInfoEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(MenuInfoEntity menuInfoEntity);
    /**
     * Description: 根据主键删除
     * @param menuInfoPk 实体类
     * @return 删除了多少行
     */
    public int delete(MenuInfoPk menuInfoPk);
    /**
     * Description: 根据多个条件删除
     * @param menuInfoEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(MenuInfoEntity menuInfoEntity);
    /**
     * Description: 根据主键查询实体
     * @param menuInfoPk 主键实体
     * @return menuInfoPk 单个实体对象
     */
    public MenuInfoEntity load(MenuInfoPk menuInfoPk);
    /**
     * Description: 根据条件查询集合实体
     * @param menuInfoEntity 查询条件
     * @return 实体集合
     */
    public List<MenuInfoEntity> selectBySelective(MenuInfoEntity menuInfoEntity);
    /**
     * Description: 根据条件查询多少行数据
     * @param menuInfoEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(MenuInfoEntity menuInfoEntity);
    
}
