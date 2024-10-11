/**
 * IPsiSalesOrderMaterialDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package com.exp.ucmp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.exp.ucmp.entity.PsiSalesOrderMaterialEntity;
import com.exp.ucmp.pk.PsiSalesOrderMaterialPk;
/**
 * <p>ClassName: IPsiSalesOrderMaterialDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface IPsiSalesOrderMaterialDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_psi_sales_order_material.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param psiSalesOrderMaterialEntity 实体类
     * @return 插入多少行
     */
    public int insert(PsiSalesOrderMaterialEntity psiSalesOrderMaterialEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param psiSalesOrderMaterialEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(PsiSalesOrderMaterialEntity psiSalesOrderMaterialEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listPsiSalesOrderMaterialEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<PsiSalesOrderMaterialEntity> listPsiSalesOrderMaterialEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param psiSalesOrderMaterialEntity 实体类
     * @return 更新了多少行
     */
    public int update(PsiSalesOrderMaterialEntity psiSalesOrderMaterialEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param psiSalesOrderMaterialEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(PsiSalesOrderMaterialEntity psiSalesOrderMaterialEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listPsiSalesOrderMaterialEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<PsiSalesOrderMaterialEntity> listPsiSalesOrderMaterialEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listPsiSalesOrderMaterialEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<PsiSalesOrderMaterialEntity> listPsiSalesOrderMaterialEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param psiSalesOrderMaterialPk 实体类
     * @return 删除了多少行
     */
    public int delete(PsiSalesOrderMaterialPk psiSalesOrderMaterialPk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param psiSalesOrderMaterialEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(PsiSalesOrderMaterialEntity psiSalesOrderMaterialEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param psiSalesOrderMaterialPk 主键实体
     * @return psiSalesOrderMaterialPk 单个实体对象
     */
    public PsiSalesOrderMaterialEntity load(PsiSalesOrderMaterialPk psiSalesOrderMaterialPk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param psiSalesOrderMaterialEntity 查询条件
     * @return 实体集合
     */
    public List<PsiSalesOrderMaterialEntity> selectBySelective(PsiSalesOrderMaterialEntity psiSalesOrderMaterialEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param psiSalesOrderMaterialEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(PsiSalesOrderMaterialEntity psiSalesOrderMaterialEntity);
    
}
