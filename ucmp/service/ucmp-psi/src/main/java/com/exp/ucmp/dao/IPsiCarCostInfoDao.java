/**
 * IPsiCarCostInfoDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package com.exp.ucmp.dao;

import java.util.List;
import java.math.BigDecimal;
import org.apache.ibatis.annotations.Select;
import com.exp.ucmp.entity.PsiCarCostInfoEntity;
import com.exp.ucmp.pk.PsiCarCostInfoPk;
/**
 * <p>ClassName: IPsiCarCostInfoDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface IPsiCarCostInfoDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_psi_car_cost_info.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param psiCarCostInfoEntity 实体类
     * @return 插入多少行
     */
    public int insert(PsiCarCostInfoEntity psiCarCostInfoEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param psiCarCostInfoEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(PsiCarCostInfoEntity psiCarCostInfoEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listPsiCarCostInfoEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<PsiCarCostInfoEntity> listPsiCarCostInfoEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param psiCarCostInfoEntity 实体类
     * @return 更新了多少行
     */
    public int update(PsiCarCostInfoEntity psiCarCostInfoEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param psiCarCostInfoEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(PsiCarCostInfoEntity psiCarCostInfoEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listPsiCarCostInfoEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<PsiCarCostInfoEntity> listPsiCarCostInfoEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listPsiCarCostInfoEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<PsiCarCostInfoEntity> listPsiCarCostInfoEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param psiCarCostInfoPk 实体类
     * @return 删除了多少行
     */
    public int delete(PsiCarCostInfoPk psiCarCostInfoPk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param psiCarCostInfoEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(PsiCarCostInfoEntity psiCarCostInfoEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param psiCarCostInfoPk 主键实体
     * @return psiCarCostInfoPk 单个实体对象
     */
    public PsiCarCostInfoEntity load(PsiCarCostInfoPk psiCarCostInfoPk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param psiCarCostInfoEntity 查询条件
     * @return 实体集合
     */
    public List<PsiCarCostInfoEntity> selectBySelective(PsiCarCostInfoEntity psiCarCostInfoEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param psiCarCostInfoEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(PsiCarCostInfoEntity psiCarCostInfoEntity);
    
}
