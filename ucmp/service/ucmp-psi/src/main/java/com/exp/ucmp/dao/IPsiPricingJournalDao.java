/**
 * IPsiPricingJournalDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package com.exp.ucmp.dao;

import java.util.List;
import java.math.BigDecimal;
import org.apache.ibatis.annotations.Select;
import com.exp.ucmp.entity.PsiPricingJournalEntity;
import com.exp.ucmp.pk.PsiPricingJournalPk;
/**
 * <p>ClassName: IPsiPricingJournalDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface IPsiPricingJournalDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_psi_pricing_journal.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param psiPricingJournalEntity 实体类
     * @return 插入多少行
     */
    public int insert(PsiPricingJournalEntity psiPricingJournalEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param psiPricingJournalEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(PsiPricingJournalEntity psiPricingJournalEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listPsiPricingJournalEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<PsiPricingJournalEntity> listPsiPricingJournalEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param psiPricingJournalEntity 实体类
     * @return 更新了多少行
     */
    public int update(PsiPricingJournalEntity psiPricingJournalEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param psiPricingJournalEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(PsiPricingJournalEntity psiPricingJournalEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listPsiPricingJournalEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<PsiPricingJournalEntity> listPsiPricingJournalEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listPsiPricingJournalEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<PsiPricingJournalEntity> listPsiPricingJournalEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param psiPricingJournalPk 实体类
     * @return 删除了多少行
     */
    public int delete(PsiPricingJournalPk psiPricingJournalPk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param psiPricingJournalEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(PsiPricingJournalEntity psiPricingJournalEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param psiPricingJournalPk 主键实体
     * @return psiPricingJournalPk 单个实体对象
     */
    public PsiPricingJournalEntity load(PsiPricingJournalPk psiPricingJournalPk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param psiPricingJournalEntity 查询条件
     * @return 实体集合
     */
    public List<PsiPricingJournalEntity> selectBySelective(PsiPricingJournalEntity psiPricingJournalEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param psiPricingJournalEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(PsiPricingJournalEntity psiPricingJournalEntity);
    
}
