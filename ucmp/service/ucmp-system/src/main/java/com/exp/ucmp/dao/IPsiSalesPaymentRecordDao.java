/**
 * IPsiSalesPaymentRecordDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package com.exp.ucmp.dao;

import java.util.List;
import java.math.BigDecimal;
import org.apache.ibatis.annotations.Select;
import com.exp.ucmp.entity.PsiSalesPaymentRecordEntity;
import com.exp.ucmp.pk.PsiSalesPaymentRecordPk;
/**
 * <p>ClassName: IPsiSalesPaymentRecordDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface IPsiSalesPaymentRecordDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_psi_sales_payment_record.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param psiSalesPaymentRecordEntity 实体类
     * @return 插入多少行
     */
    public int insert(PsiSalesPaymentRecordEntity psiSalesPaymentRecordEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param psiSalesPaymentRecordEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(PsiSalesPaymentRecordEntity psiSalesPaymentRecordEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listPsiSalesPaymentRecordEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<PsiSalesPaymentRecordEntity> listPsiSalesPaymentRecordEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param psiSalesPaymentRecordEntity 实体类
     * @return 更新了多少行
     */
    public int update(PsiSalesPaymentRecordEntity psiSalesPaymentRecordEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param psiSalesPaymentRecordEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(PsiSalesPaymentRecordEntity psiSalesPaymentRecordEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listPsiSalesPaymentRecordEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<PsiSalesPaymentRecordEntity> listPsiSalesPaymentRecordEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listPsiSalesPaymentRecordEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<PsiSalesPaymentRecordEntity> listPsiSalesPaymentRecordEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param psiSalesPaymentRecordPk 实体类
     * @return 删除了多少行
     */
    public int delete(PsiSalesPaymentRecordPk psiSalesPaymentRecordPk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param psiSalesPaymentRecordEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(PsiSalesPaymentRecordEntity psiSalesPaymentRecordEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param psiSalesPaymentRecordPk 主键实体
     * @return psiSalesPaymentRecordPk 单个实体对象
     */
    public PsiSalesPaymentRecordEntity load(PsiSalesPaymentRecordPk psiSalesPaymentRecordPk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param psiSalesPaymentRecordEntity 查询条件
     * @return 实体集合
     */
    public List<PsiSalesPaymentRecordEntity> selectBySelective(PsiSalesPaymentRecordEntity psiSalesPaymentRecordEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param psiSalesPaymentRecordEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(PsiSalesPaymentRecordEntity psiSalesPaymentRecordEntity);
    
}
