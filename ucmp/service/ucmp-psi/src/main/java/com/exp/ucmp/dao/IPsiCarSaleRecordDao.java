/**
 * IPsiCarSaleRecordDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO EgridCloud, Inc, All rights reserved.
 */
package com.exp.ucmp.dao;

import java.util.List;
import java.math.BigDecimal;
import org.apache.ibatis.annotations.Select;
import com.exp.ucmp.entity.PsiCarSaleRecordEntity;
import com.exp.ucmp.pk.PsiCarSaleRecordPk;
/**
 * <p>ClassName: IPsiCarSaleRecordDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface IPsiCarSaleRecordDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_psi_car_sale_record.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param psiCarSaleRecordEntity 实体类
     * @return 插入多少行
     */
    public int insert(PsiCarSaleRecordEntity psiCarSaleRecordEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param psiCarSaleRecordEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(PsiCarSaleRecordEntity psiCarSaleRecordEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listPsiCarSaleRecordEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<PsiCarSaleRecordEntity> listPsiCarSaleRecordEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param psiCarSaleRecordEntity 实体类
     * @return 更新了多少行
     */
    public int update(PsiCarSaleRecordEntity psiCarSaleRecordEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param psiCarSaleRecordEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(PsiCarSaleRecordEntity psiCarSaleRecordEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listPsiCarSaleRecordEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<PsiCarSaleRecordEntity> listPsiCarSaleRecordEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listPsiCarSaleRecordEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<PsiCarSaleRecordEntity> listPsiCarSaleRecordEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param psiCarSaleRecordPk 实体类
     * @return 删除了多少行
     */
    public int delete(PsiCarSaleRecordPk psiCarSaleRecordPk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param psiCarSaleRecordEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(PsiCarSaleRecordEntity psiCarSaleRecordEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param psiCarSaleRecordPk 主键实体
     * @return psiCarSaleRecordPk 单个实体对象
     */
    public PsiCarSaleRecordEntity load(PsiCarSaleRecordPk psiCarSaleRecordPk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param psiCarSaleRecordEntity 查询条件
     * @return 实体集合
     */
    public List<PsiCarSaleRecordEntity> selectBySelective(PsiCarSaleRecordEntity psiCarSaleRecordEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param psiCarSaleRecordEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(PsiCarSaleRecordEntity psiCarSaleRecordEntity);
    
}
