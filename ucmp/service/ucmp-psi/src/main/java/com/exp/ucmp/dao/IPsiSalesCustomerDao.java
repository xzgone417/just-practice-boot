/**
 * IPsiSalesCustomerDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package com.exp.ucmp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.exp.ucmp.entity.PsiSalesCustomerEntity;
import com.exp.ucmp.pk.PsiSalesCustomerPk;
/**
 * <p>ClassName: IPsiSalesCustomerDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface IPsiSalesCustomerDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_psi_sales_customer.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param psiSalesCustomerEntity 实体类
     * @return 插入多少行
     */
    public int insert(PsiSalesCustomerEntity psiSalesCustomerEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param psiSalesCustomerEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(PsiSalesCustomerEntity psiSalesCustomerEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listPsiSalesCustomerEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<PsiSalesCustomerEntity> listPsiSalesCustomerEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param psiSalesCustomerEntity 实体类
     * @return 更新了多少行
     */
    public int update(PsiSalesCustomerEntity psiSalesCustomerEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param psiSalesCustomerEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(PsiSalesCustomerEntity psiSalesCustomerEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listPsiSalesCustomerEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<PsiSalesCustomerEntity> listPsiSalesCustomerEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listPsiSalesCustomerEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<PsiSalesCustomerEntity> listPsiSalesCustomerEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param psiSalesCustomerPk 实体类
     * @return 删除了多少行
     */
    public int delete(PsiSalesCustomerPk psiSalesCustomerPk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param psiSalesCustomerEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(PsiSalesCustomerEntity psiSalesCustomerEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param psiSalesCustomerPk 主键实体
     * @return psiSalesCustomerPk 单个实体对象
     */
    public PsiSalesCustomerEntity load(PsiSalesCustomerPk psiSalesCustomerPk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param psiSalesCustomerEntity 查询条件
     * @return 实体集合
     */
    public List<PsiSalesCustomerEntity> selectBySelective(PsiSalesCustomerEntity psiSalesCustomerEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param psiSalesCustomerEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(PsiSalesCustomerEntity psiSalesCustomerEntity);
    
}
