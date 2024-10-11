/**
 * IPsiAcquisitionMaterialDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package com.exp.ucmp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.exp.ucmp.entity.PsiAcquisitionMaterialEntity;
import com.exp.ucmp.pk.PsiAcquisitionMaterialPk;
/**
 * <p>ClassName: IPsiAcquisitionMaterialDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface IPsiAcquisitionMaterialDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_psi_acquisition_material.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param psiAcquisitionMaterialEntity 实体类
     * @return 插入多少行
     */
    public int insert(PsiAcquisitionMaterialEntity psiAcquisitionMaterialEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param psiAcquisitionMaterialEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(PsiAcquisitionMaterialEntity psiAcquisitionMaterialEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listPsiAcquisitionMaterialEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<PsiAcquisitionMaterialEntity> listPsiAcquisitionMaterialEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param psiAcquisitionMaterialEntity 实体类
     * @return 更新了多少行
     */
    public int update(PsiAcquisitionMaterialEntity psiAcquisitionMaterialEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param psiAcquisitionMaterialEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(PsiAcquisitionMaterialEntity psiAcquisitionMaterialEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listPsiAcquisitionMaterialEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<PsiAcquisitionMaterialEntity> listPsiAcquisitionMaterialEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listPsiAcquisitionMaterialEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<PsiAcquisitionMaterialEntity> listPsiAcquisitionMaterialEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param psiAcquisitionMaterialPk 实体类
     * @return 删除了多少行
     */
    public int delete(PsiAcquisitionMaterialPk psiAcquisitionMaterialPk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param psiAcquisitionMaterialEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(PsiAcquisitionMaterialEntity psiAcquisitionMaterialEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param psiAcquisitionMaterialPk 主键实体
     * @return psiAcquisitionMaterialPk 单个实体对象
     */
    public PsiAcquisitionMaterialEntity load(PsiAcquisitionMaterialPk psiAcquisitionMaterialPk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param psiAcquisitionMaterialEntity 查询条件
     * @return 实体集合
     */
    public List<PsiAcquisitionMaterialEntity> selectBySelective(PsiAcquisitionMaterialEntity psiAcquisitionMaterialEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param psiAcquisitionMaterialEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(PsiAcquisitionMaterialEntity psiAcquisitionMaterialEntity);
    
}
