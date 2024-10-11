/**
 * IPsiSalesMessageRecordDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package com.exp.ucmp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.exp.ucmp.entity.PsiSalesMessageRecordEntity;
import com.exp.ucmp.pk.PsiSalesMessageRecordPk;
/**
 * <p>ClassName: IPsiSalesMessageRecordDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface IPsiSalesMessageRecordDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_psi_sales_message_record.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param psiSalesMessageRecordEntity 实体类
     * @return 插入多少行
     */
    public int insert(PsiSalesMessageRecordEntity psiSalesMessageRecordEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param psiSalesMessageRecordEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(PsiSalesMessageRecordEntity psiSalesMessageRecordEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listPsiSalesMessageRecordEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<PsiSalesMessageRecordEntity> listPsiSalesMessageRecordEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param psiSalesMessageRecordEntity 实体类
     * @return 更新了多少行
     */
    public int update(PsiSalesMessageRecordEntity psiSalesMessageRecordEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param psiSalesMessageRecordEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(PsiSalesMessageRecordEntity psiSalesMessageRecordEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listPsiSalesMessageRecordEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<PsiSalesMessageRecordEntity> listPsiSalesMessageRecordEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listPsiSalesMessageRecordEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<PsiSalesMessageRecordEntity> listPsiSalesMessageRecordEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param psiSalesMessageRecordPk 实体类
     * @return 删除了多少行
     */
    public int delete(PsiSalesMessageRecordPk psiSalesMessageRecordPk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param psiSalesMessageRecordEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(PsiSalesMessageRecordEntity psiSalesMessageRecordEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param psiSalesMessageRecordPk 主键实体
     * @return psiSalesMessageRecordPk 单个实体对象
     */
    public PsiSalesMessageRecordEntity load(PsiSalesMessageRecordPk psiSalesMessageRecordPk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param psiSalesMessageRecordEntity 查询条件
     * @return 实体集合
     */
    public List<PsiSalesMessageRecordEntity> selectBySelective(PsiSalesMessageRecordEntity psiSalesMessageRecordEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param psiSalesMessageRecordEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(PsiSalesMessageRecordEntity psiSalesMessageRecordEntity);
    
}
