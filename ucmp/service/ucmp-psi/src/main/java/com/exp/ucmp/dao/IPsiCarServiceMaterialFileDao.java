/**
 * IPsiCarServiceMaterialFileDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package com.exp.ucmp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.exp.ucmp.entity.PsiCarServiceMaterialFileEntity;
import com.exp.ucmp.pk.PsiCarServiceMaterialFilePk;
/**
 * <p>ClassName: IPsiCarServiceMaterialFileDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface IPsiCarServiceMaterialFileDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_psi_car_service_material_file.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param psiCarServiceMaterialFileEntity 实体类
     * @return 插入多少行
     */
    public int insert(PsiCarServiceMaterialFileEntity psiCarServiceMaterialFileEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param psiCarServiceMaterialFileEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(PsiCarServiceMaterialFileEntity psiCarServiceMaterialFileEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listPsiCarServiceMaterialFileEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<PsiCarServiceMaterialFileEntity> listPsiCarServiceMaterialFileEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param psiCarServiceMaterialFileEntity 实体类
     * @return 更新了多少行
     */
    public int update(PsiCarServiceMaterialFileEntity psiCarServiceMaterialFileEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param psiCarServiceMaterialFileEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(PsiCarServiceMaterialFileEntity psiCarServiceMaterialFileEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listPsiCarServiceMaterialFileEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<PsiCarServiceMaterialFileEntity> listPsiCarServiceMaterialFileEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listPsiCarServiceMaterialFileEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<PsiCarServiceMaterialFileEntity> listPsiCarServiceMaterialFileEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param psiCarServiceMaterialFilePk 实体类
     * @return 删除了多少行
     */
    public int delete(PsiCarServiceMaterialFilePk psiCarServiceMaterialFilePk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param psiCarServiceMaterialFileEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(PsiCarServiceMaterialFileEntity psiCarServiceMaterialFileEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param psiCarServiceMaterialFilePk 主键实体
     * @return psiCarServiceMaterialFilePk 单个实体对象
     */
    public PsiCarServiceMaterialFileEntity load(PsiCarServiceMaterialFilePk psiCarServiceMaterialFilePk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param psiCarServiceMaterialFileEntity 查询条件
     * @return 实体集合
     */
    public List<PsiCarServiceMaterialFileEntity> selectBySelective(PsiCarServiceMaterialFileEntity psiCarServiceMaterialFileEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param psiCarServiceMaterialFileEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(PsiCarServiceMaterialFileEntity psiCarServiceMaterialFileEntity);
    
}
