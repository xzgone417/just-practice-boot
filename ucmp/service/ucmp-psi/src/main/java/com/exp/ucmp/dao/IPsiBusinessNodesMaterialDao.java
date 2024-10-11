/**
 * IPsiBusinessNodesMaterialDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package com.exp.ucmp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.exp.ucmp.entity.PsiBusinessNodesMaterialEntity;
import com.exp.ucmp.pk.PsiBusinessNodesMaterialPk;
/**
 * <p>ClassName: IPsiBusinessNodesMaterialDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface IPsiBusinessNodesMaterialDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_psi_business_nodes_material.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param psiBusinessNodesMaterialEntity 实体类
     * @return 插入多少行
     */
    public int insert(PsiBusinessNodesMaterialEntity psiBusinessNodesMaterialEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param psiBusinessNodesMaterialEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(PsiBusinessNodesMaterialEntity psiBusinessNodesMaterialEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listPsiBusinessNodesMaterialEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<PsiBusinessNodesMaterialEntity> listPsiBusinessNodesMaterialEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param psiBusinessNodesMaterialEntity 实体类
     * @return 更新了多少行
     */
    public int update(PsiBusinessNodesMaterialEntity psiBusinessNodesMaterialEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param psiBusinessNodesMaterialEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(PsiBusinessNodesMaterialEntity psiBusinessNodesMaterialEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listPsiBusinessNodesMaterialEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<PsiBusinessNodesMaterialEntity> listPsiBusinessNodesMaterialEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listPsiBusinessNodesMaterialEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<PsiBusinessNodesMaterialEntity> listPsiBusinessNodesMaterialEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param psiBusinessNodesMaterialPk 实体类
     * @return 删除了多少行
     */
    public int delete(PsiBusinessNodesMaterialPk psiBusinessNodesMaterialPk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param psiBusinessNodesMaterialEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(PsiBusinessNodesMaterialEntity psiBusinessNodesMaterialEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param psiBusinessNodesMaterialPk 主键实体
     * @return psiBusinessNodesMaterialPk 单个实体对象
     */
    public PsiBusinessNodesMaterialEntity load(PsiBusinessNodesMaterialPk psiBusinessNodesMaterialPk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param psiBusinessNodesMaterialEntity 查询条件
     * @return 实体集合
     */
    public List<PsiBusinessNodesMaterialEntity> selectBySelective(PsiBusinessNodesMaterialEntity psiBusinessNodesMaterialEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param psiBusinessNodesMaterialEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(PsiBusinessNodesMaterialEntity psiBusinessNodesMaterialEntity);
    
}
