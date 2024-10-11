/**
 * IPsiOrderInfoDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package com.exp.ucmp.dao;

import java.util.List;
import java.math.BigDecimal;
import org.apache.ibatis.annotations.Select;
import com.exp.ucmp.entity.PsiOrderInfoEntity;
import com.exp.ucmp.pk.PsiOrderInfoPk;
/**
 * <p>ClassName: IPsiOrderInfoDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface IPsiOrderInfoDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_psi_order_info.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param psiOrderInfoEntity 实体类
     * @return 插入多少行
     */
    public int insert(PsiOrderInfoEntity psiOrderInfoEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param psiOrderInfoEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(PsiOrderInfoEntity psiOrderInfoEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listPsiOrderInfoEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<PsiOrderInfoEntity> listPsiOrderInfoEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param psiOrderInfoEntity 实体类
     * @return 更新了多少行
     */
    public int update(PsiOrderInfoEntity psiOrderInfoEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param psiOrderInfoEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(PsiOrderInfoEntity psiOrderInfoEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listPsiOrderInfoEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<PsiOrderInfoEntity> listPsiOrderInfoEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listPsiOrderInfoEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<PsiOrderInfoEntity> listPsiOrderInfoEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param psiOrderInfoPk 实体类
     * @return 删除了多少行
     */
    public int delete(PsiOrderInfoPk psiOrderInfoPk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param psiOrderInfoEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(PsiOrderInfoEntity psiOrderInfoEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param psiOrderInfoPk 主键实体
     * @return psiOrderInfoPk 单个实体对象
     */
    public PsiOrderInfoEntity load(PsiOrderInfoPk psiOrderInfoPk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param psiOrderInfoEntity 查询条件
     * @return 实体集合
     */
    public List<PsiOrderInfoEntity> selectBySelective(PsiOrderInfoEntity psiOrderInfoEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param psiOrderInfoEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(PsiOrderInfoEntity psiOrderInfoEntity);
    
}
