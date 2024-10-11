/**
 * IPsiOrderReceivingRecordDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package com.exp.ucmp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.exp.ucmp.entity.PsiOrderReceivingRecordEntity;
import com.exp.ucmp.pk.PsiOrderReceivingRecordPk;
/**
 * <p>ClassName: IPsiOrderReceivingRecordDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface IPsiOrderReceivingRecordDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_psi_order_receiving_record.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param psiOrderReceivingRecordEntity 实体类
     * @return 插入多少行
     */
    public int insert(PsiOrderReceivingRecordEntity psiOrderReceivingRecordEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param psiOrderReceivingRecordEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(PsiOrderReceivingRecordEntity psiOrderReceivingRecordEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listPsiOrderReceivingRecordEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<PsiOrderReceivingRecordEntity> listPsiOrderReceivingRecordEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param psiOrderReceivingRecordEntity 实体类
     * @return 更新了多少行
     */
    public int update(PsiOrderReceivingRecordEntity psiOrderReceivingRecordEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param psiOrderReceivingRecordEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(PsiOrderReceivingRecordEntity psiOrderReceivingRecordEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listPsiOrderReceivingRecordEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<PsiOrderReceivingRecordEntity> listPsiOrderReceivingRecordEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listPsiOrderReceivingRecordEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<PsiOrderReceivingRecordEntity> listPsiOrderReceivingRecordEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param psiOrderReceivingRecordPk 实体类
     * @return 删除了多少行
     */
    public int delete(PsiOrderReceivingRecordPk psiOrderReceivingRecordPk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param psiOrderReceivingRecordEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(PsiOrderReceivingRecordEntity psiOrderReceivingRecordEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param psiOrderReceivingRecordPk 主键实体
     * @return psiOrderReceivingRecordPk 单个实体对象
     */
    public PsiOrderReceivingRecordEntity load(PsiOrderReceivingRecordPk psiOrderReceivingRecordPk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param psiOrderReceivingRecordEntity 查询条件
     * @return 实体集合
     */
    public List<PsiOrderReceivingRecordEntity> selectBySelective(PsiOrderReceivingRecordEntity psiOrderReceivingRecordEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param psiOrderReceivingRecordEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(PsiOrderReceivingRecordEntity psiOrderReceivingRecordEntity);
    
}
