/**
 * IPositionInfoDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package com.exp.ucmp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.exp.ucmp.entity.PositionInfoEntity;
import com.exp.ucmp.pk.PositionInfoPk;
/**
 * <p>ClassName: IPositionInfoDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface IPositionInfoDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_position_info.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param positionInfoEntity 实体类
     * @return 插入多少行
     */
    public int insert(PositionInfoEntity positionInfoEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param positionInfoEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(PositionInfoEntity positionInfoEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listPositionInfoEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<PositionInfoEntity> listPositionInfoEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param positionInfoEntity 实体类
     * @return 更新了多少行
     */
    public int update(PositionInfoEntity positionInfoEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param positionInfoEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(PositionInfoEntity positionInfoEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listPositionInfoEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<PositionInfoEntity> listPositionInfoEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listPositionInfoEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<PositionInfoEntity> listPositionInfoEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param positionInfoPk 实体类
     * @return 删除了多少行
     */
    public int delete(PositionInfoPk positionInfoPk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param positionInfoEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(PositionInfoEntity positionInfoEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param positionInfoPk 主键实体
     * @return positionInfoPk 单个实体对象
     */
    public PositionInfoEntity load(PositionInfoPk positionInfoPk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param positionInfoEntity 查询条件
     * @return 实体集合
     */
    public List<PositionInfoEntity> selectBySelective(PositionInfoEntity positionInfoEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param positionInfoEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(PositionInfoEntity positionInfoEntity);
    
}
