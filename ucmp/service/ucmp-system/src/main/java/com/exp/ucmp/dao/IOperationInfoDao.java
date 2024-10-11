/**
 * IOperationInfoDao.java
 * Created at 2018年09月29日
 * Created by TODO
 * Copyright (C) TODO EgridCloud, Inc, All rights reserved.
 */
package com.exp.ucmp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;

import com.exp.ucmp.entity.OperationInfoEntity;
import com.exp.ucmp.pk.OperationInfoPk;
/**
 * ClassName: IOperationInfoDao
 * Description: TODO
 * @author TODO
 * @date 2022年07月12日
 * @since 1.0
 */
public interface IOperationInfoDao {
    /**
     * Description: 获取序列，序列按照SEQ+表名设计
     * @return 序列
     */
    @Select("select SEQ_t_operation_info.Nextval from dual")
    public long selectSequence();
    /**
     * Description: 全字段插入
     * @param operationInfoEntity 实体类
     * @return 插入多少行
     */
    public int insert(OperationInfoEntity operationInfoEntity);
    /**
     * Description: 选择全字段插入
     * @param operationInfoEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(OperationInfoEntity operationInfoEntity);
    /**
     * Description: 全字段插入
     * @param listOperationInfoEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<OperationInfoEntity> listOperationInfoEntity);
    /**
     * Description: 全字段更新
     * @param operationInfoEntity 实体类
     * @return 更新了多少行
     */
    public int update(OperationInfoEntity operationInfoEntity);
    /**
     * Description: 选择字段更新
     * @param operationInfoEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(OperationInfoEntity operationInfoEntity);
    /**
     * Description: 根据主键删除
     * @param operationInfoPk 实体类
     * @return 删除了多少行
     */
    public int delete(OperationInfoPk operationInfoPk);
    /**
     * Description: 根据多个条件删除
     * @param operationInfoEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(OperationInfoEntity operationInfoEntity);
    /**
     * Description: 根据主键查询实体
     * @param operationInfoPk 主键实体
     * @return operationInfoPk 单个实体对象
     */
    public OperationInfoEntity load(OperationInfoPk operationInfoPk);
    /**
     * Description: 根据条件查询集合实体
     * @param operationInfoEntity 查询条件
     * @return 实体集合
     */
    public List<OperationInfoEntity> selectBySelective(OperationInfoEntity operationInfoEntity);
    /**
     * Description: 根据条件查询多少行数据
     * @param operationInfoEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(OperationInfoEntity operationInfoEntity);
    
}
