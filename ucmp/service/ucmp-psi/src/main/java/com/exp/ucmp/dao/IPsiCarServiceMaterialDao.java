/**
 * IPsiCarServiceMaterialDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package com.exp.ucmp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.exp.ucmp.entity.PsiCarServiceMaterialEntity;
import com.exp.ucmp.pk.PsiCarServiceMaterialPk;
/**
 * <p>ClassName: IPsiCarServiceMaterialDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface IPsiCarServiceMaterialDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_psi_car_service_material.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param psiCarServiceMaterialEntity 实体类
     * @return 插入多少行
     */
    public int insert(PsiCarServiceMaterialEntity psiCarServiceMaterialEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param psiCarServiceMaterialEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(PsiCarServiceMaterialEntity psiCarServiceMaterialEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listPsiCarServiceMaterialEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<PsiCarServiceMaterialEntity> listPsiCarServiceMaterialEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param psiCarServiceMaterialEntity 实体类
     * @return 更新了多少行
     */
    public int update(PsiCarServiceMaterialEntity psiCarServiceMaterialEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param psiCarServiceMaterialEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(PsiCarServiceMaterialEntity psiCarServiceMaterialEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listPsiCarServiceMaterialEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<PsiCarServiceMaterialEntity> listPsiCarServiceMaterialEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listPsiCarServiceMaterialEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<PsiCarServiceMaterialEntity> listPsiCarServiceMaterialEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param psiCarServiceMaterialPk 实体类
     * @return 删除了多少行
     */
    public int delete(PsiCarServiceMaterialPk psiCarServiceMaterialPk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param psiCarServiceMaterialEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(PsiCarServiceMaterialEntity psiCarServiceMaterialEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param psiCarServiceMaterialPk 主键实体
     * @return psiCarServiceMaterialPk 单个实体对象
     */
    public PsiCarServiceMaterialEntity load(PsiCarServiceMaterialPk psiCarServiceMaterialPk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param psiCarServiceMaterialEntity 查询条件
     * @return 实体集合
     */
    public List<PsiCarServiceMaterialEntity> selectBySelective(PsiCarServiceMaterialEntity psiCarServiceMaterialEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param psiCarServiceMaterialEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(PsiCarServiceMaterialEntity psiCarServiceMaterialEntity);
    
}
