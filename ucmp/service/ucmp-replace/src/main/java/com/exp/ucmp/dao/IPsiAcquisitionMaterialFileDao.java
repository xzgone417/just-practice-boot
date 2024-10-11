/**
 * IPsiAcquisitionMaterialFileDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package com.exp.ucmp.dao;

import com.exp.ucmp.entity.PsiAcquisitionMaterialFileEntity;
import com.exp.ucmp.pk.PsiAcquisitionMaterialFilePk;
import org.apache.ibatis.annotations.Select;

import java.util.List;
/**
 * <p>ClassName: IPsiAcquisitionMaterialFileDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface IPsiAcquisitionMaterialFileDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_psi_acquisition_material_file.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param psiAcquisitionMaterialFileEntity 实体类
     * @return 插入多少行
     */
    public int insert(PsiAcquisitionMaterialFileEntity psiAcquisitionMaterialFileEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param psiAcquisitionMaterialFileEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(PsiAcquisitionMaterialFileEntity psiAcquisitionMaterialFileEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listPsiAcquisitionMaterialFileEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<PsiAcquisitionMaterialFileEntity> listPsiAcquisitionMaterialFileEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param psiAcquisitionMaterialFileEntity 实体类
     * @return 更新了多少行
     */
    public int update(PsiAcquisitionMaterialFileEntity psiAcquisitionMaterialFileEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param psiAcquisitionMaterialFileEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(PsiAcquisitionMaterialFileEntity psiAcquisitionMaterialFileEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listPsiAcquisitionMaterialFileEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<PsiAcquisitionMaterialFileEntity> listPsiAcquisitionMaterialFileEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listPsiAcquisitionMaterialFileEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<PsiAcquisitionMaterialFileEntity> listPsiAcquisitionMaterialFileEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param psiAcquisitionMaterialFilePk 实体类
     * @return 删除了多少行
     */
    public int delete(PsiAcquisitionMaterialFilePk psiAcquisitionMaterialFilePk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param psiAcquisitionMaterialFileEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(PsiAcquisitionMaterialFileEntity psiAcquisitionMaterialFileEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param psiAcquisitionMaterialFilePk 主键实体
     * @return psiAcquisitionMaterialFilePk 单个实体对象
     */
    public PsiAcquisitionMaterialFileEntity load(PsiAcquisitionMaterialFilePk psiAcquisitionMaterialFilePk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param psiAcquisitionMaterialFileEntity 查询条件
     * @return 实体集合
     */
    public List<PsiAcquisitionMaterialFileEntity> selectBySelective(PsiAcquisitionMaterialFileEntity psiAcquisitionMaterialFileEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param psiAcquisitionMaterialFileEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(PsiAcquisitionMaterialFileEntity psiAcquisitionMaterialFileEntity);
    
}
