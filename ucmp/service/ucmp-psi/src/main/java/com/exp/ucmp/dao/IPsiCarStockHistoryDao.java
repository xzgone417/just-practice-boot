/**
 * IPsiCarStockHistoryDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package com.exp.ucmp.dao;

import java.util.List;

import com.exp.ucmp.entity.PsiCarStockHistoryEntity;
import com.exp.ucmp.pk.PsiCarStockHistoryPk;
import org.apache.ibatis.annotations.Select;

/**
 * <p>ClassName: IPsiCarStockHistoryDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface IPsiCarStockHistoryDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_psi_car_stock_history.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param psiCarStockHistoryEntity 实体类
     * @return 插入多少行
     */
    public int insert(PsiCarStockHistoryEntity psiCarStockHistoryEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param psiCarStockHistoryEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(PsiCarStockHistoryEntity psiCarStockHistoryEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listPsiCarStockHistoryEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<PsiCarStockHistoryEntity> listPsiCarStockHistoryEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param psiCarStockHistoryEntity 实体类
     * @return 更新了多少行
     */
    public int update(PsiCarStockHistoryEntity psiCarStockHistoryEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param psiCarStockHistoryEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(PsiCarStockHistoryEntity psiCarStockHistoryEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listPsiCarStockHistoryEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<PsiCarStockHistoryEntity> listPsiCarStockHistoryEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listPsiCarStockHistoryEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<PsiCarStockHistoryEntity> listPsiCarStockHistoryEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param psiCarStockHistoryPk 实体类
     * @return 删除了多少行
     */
    public int delete(PsiCarStockHistoryPk psiCarStockHistoryPk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param psiCarStockHistoryEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(PsiCarStockHistoryEntity psiCarStockHistoryEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param psiCarStockHistoryPk 主键实体
     * @return psiCarStockHistoryPk 单个实体对象
     */
    public PsiCarStockHistoryEntity load(PsiCarStockHistoryPk psiCarStockHistoryPk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param psiCarStockHistoryEntity 查询条件
     * @return 实体集合
     */
    public List<PsiCarStockHistoryEntity> selectBySelective(PsiCarStockHistoryEntity psiCarStockHistoryEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param psiCarStockHistoryEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(PsiCarStockHistoryEntity psiCarStockHistoryEntity);
    
}
