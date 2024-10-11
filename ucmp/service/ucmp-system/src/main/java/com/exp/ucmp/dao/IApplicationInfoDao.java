/**
 * IApplicationInfoDao.java
 * Created at 2018年09月29日
 * Created by TODO
 * Copyright (C) TODO EgridCloud, Inc, All rights reserved.
 */
package com.exp.ucmp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;

import com.exp.ucmp.entity.ApplicationInfoEntity;
import com.exp.ucmp.pk.ApplicationInfoPk;
/**
 * ClassName: IApplicationInfoDao
 * Description: TODO
 * @author TODO
 * @date 2022年07月12日
 * @since 1.0
 */
public interface IApplicationInfoDao {
    /**
     * Description: 获取序列，序列按照SEQ+表名设计
     * @return 序列
     */
    @Select("select SEQ_t_application_info.Nextval from dual")
    public long selectSequence();
    /**
     * Description: 全字段插入
     * @param applicationInfoEntity 实体类
     * @return 插入多少行
     */
    public int insert(ApplicationInfoEntity applicationInfoEntity);
    /**
     * Description: 选择全字段插入
     * @param applicationInfoEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(ApplicationInfoEntity applicationInfoEntity);
    /**
     * Description: 全字段插入
     * @param listApplicationInfoEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<ApplicationInfoEntity> listApplicationInfoEntity);
    /**
     * Description: 全字段更新
     * @param applicationInfoEntity 实体类
     * @return 更新了多少行
     */
    public int update(ApplicationInfoEntity applicationInfoEntity);
    /**
     * Description: 选择字段更新
     * @param applicationInfoEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(ApplicationInfoEntity applicationInfoEntity);
    /**
     * Description: 根据主键删除
     * @param applicationInfoPk 实体类
     * @return 删除了多少行
     */
    public int delete(ApplicationInfoPk applicationInfoPk);
    /**
     * Description: 根据多个条件删除
     * @param applicationInfoEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(ApplicationInfoEntity applicationInfoEntity);
    /**
     * Description: 根据主键查询实体
     * @param applicationInfoPk 主键实体
     * @return applicationInfoPk 单个实体对象
     */
    public ApplicationInfoEntity load(ApplicationInfoPk applicationInfoPk);
    /**
     * Description: 根据条件查询集合实体
     * @param applicationInfoEntity 查询条件
     * @return 实体集合
     */
    public List<ApplicationInfoEntity> selectBySelective(ApplicationInfoEntity applicationInfoEntity);
    /**
     * Description: 根据条件查询多少行数据
     * @param applicationInfoEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(ApplicationInfoEntity applicationInfoEntity);
    
}
