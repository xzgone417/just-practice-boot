/**
 * IRepReplacementApprovalRecordDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package com.exp.ucmp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.exp.ucmp.entity.RepReplacementApprovalRecordEntity;
import com.exp.ucmp.pk.RepReplacementApprovalRecordPk;
/**
 * <p>ClassName: IRepReplacementApprovalRecordDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface IRepReplacementApprovalRecordDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_rep_replacement_approval_record.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param repReplacementApprovalRecordEntity 实体类
     * @return 插入多少行
     */
    public int insert(RepReplacementApprovalRecordEntity repReplacementApprovalRecordEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param repReplacementApprovalRecordEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(RepReplacementApprovalRecordEntity repReplacementApprovalRecordEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listRepReplacementApprovalRecordEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<RepReplacementApprovalRecordEntity> listRepReplacementApprovalRecordEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param repReplacementApprovalRecordEntity 实体类
     * @return 更新了多少行
     */
    public int update(RepReplacementApprovalRecordEntity repReplacementApprovalRecordEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param repReplacementApprovalRecordEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(RepReplacementApprovalRecordEntity repReplacementApprovalRecordEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listRepReplacementApprovalRecordEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<RepReplacementApprovalRecordEntity> listRepReplacementApprovalRecordEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listRepReplacementApprovalRecordEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<RepReplacementApprovalRecordEntity> listRepReplacementApprovalRecordEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param repReplacementApprovalRecordPk 实体类
     * @return 删除了多少行
     */
    public int delete(RepReplacementApprovalRecordPk repReplacementApprovalRecordPk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param repReplacementApprovalRecordEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(RepReplacementApprovalRecordEntity repReplacementApprovalRecordEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param repReplacementApprovalRecordPk 主键实体
     * @return repReplacementApprovalRecordPk 单个实体对象
     */
    public RepReplacementApprovalRecordEntity load(RepReplacementApprovalRecordPk repReplacementApprovalRecordPk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param repReplacementApprovalRecordEntity 查询条件
     * @return 实体集合
     */
    public List<RepReplacementApprovalRecordEntity> selectBySelective(RepReplacementApprovalRecordEntity repReplacementApprovalRecordEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param repReplacementApprovalRecordEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(RepReplacementApprovalRecordEntity repReplacementApprovalRecordEntity);
    
}
