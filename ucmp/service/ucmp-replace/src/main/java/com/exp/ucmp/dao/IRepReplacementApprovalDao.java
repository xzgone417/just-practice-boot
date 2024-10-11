/**
 * IRepReplacementApprovalDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package com.exp.ucmp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.exp.ucmp.entity.RepReplacementApprovalEntity;
import com.exp.ucmp.pk.RepReplacementApprovalPk;
/**
 * <p>ClassName: IRepReplacementApprovalDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface IRepReplacementApprovalDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_rep_replacement_approval.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param repReplacementApprovalEntity 实体类
     * @return 插入多少行
     */
    public int insert(RepReplacementApprovalEntity repReplacementApprovalEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param repReplacementApprovalEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(RepReplacementApprovalEntity repReplacementApprovalEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listRepReplacementApprovalEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<RepReplacementApprovalEntity> listRepReplacementApprovalEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param repReplacementApprovalEntity 实体类
     * @return 更新了多少行
     */
    public int update(RepReplacementApprovalEntity repReplacementApprovalEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param repReplacementApprovalEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(RepReplacementApprovalEntity repReplacementApprovalEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listRepReplacementApprovalEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<RepReplacementApprovalEntity> listRepReplacementApprovalEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listRepReplacementApprovalEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<RepReplacementApprovalEntity> listRepReplacementApprovalEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param repReplacementApprovalPk 实体类
     * @return 删除了多少行
     */
    public int delete(RepReplacementApprovalPk repReplacementApprovalPk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param repReplacementApprovalEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(RepReplacementApprovalEntity repReplacementApprovalEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param repReplacementApprovalPk 主键实体
     * @return repReplacementApprovalPk 单个实体对象
     */
    public RepReplacementApprovalEntity load(RepReplacementApprovalPk repReplacementApprovalPk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param repReplacementApprovalEntity 查询条件
     * @return 实体集合
     */
    public List<RepReplacementApprovalEntity> selectBySelective(RepReplacementApprovalEntity repReplacementApprovalEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param repReplacementApprovalEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(RepReplacementApprovalEntity repReplacementApprovalEntity);
    
}
