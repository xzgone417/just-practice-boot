/**
 * IPsiCluesStoreConfigDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package com.exp.ucmp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.exp.ucmp.entity.PsiCluesStoreConfigEntity;
import com.exp.ucmp.pk.PsiCluesStoreConfigPk;
/**
 * <p>ClassName: IPsiCluesStoreConfigDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface IPsiCluesStoreConfigDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_psi_clues_store_config.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param psiCluesStoreConfigEntity 实体类
     * @return 插入多少行
     */
    public int insert(PsiCluesStoreConfigEntity psiCluesStoreConfigEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param psiCluesStoreConfigEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(PsiCluesStoreConfigEntity psiCluesStoreConfigEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listPsiCluesStoreConfigEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<PsiCluesStoreConfigEntity> listPsiCluesStoreConfigEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param psiCluesStoreConfigEntity 实体类
     * @return 更新了多少行
     */
    public int update(PsiCluesStoreConfigEntity psiCluesStoreConfigEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param psiCluesStoreConfigEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(PsiCluesStoreConfigEntity psiCluesStoreConfigEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listPsiCluesStoreConfigEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<PsiCluesStoreConfigEntity> listPsiCluesStoreConfigEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listPsiCluesStoreConfigEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<PsiCluesStoreConfigEntity> listPsiCluesStoreConfigEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param psiCluesStoreConfigPk 实体类
     * @return 删除了多少行
     */
    public int delete(PsiCluesStoreConfigPk psiCluesStoreConfigPk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param psiCluesStoreConfigEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(PsiCluesStoreConfigEntity psiCluesStoreConfigEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param psiCluesStoreConfigPk 主键实体
     * @return psiCluesStoreConfigPk 单个实体对象
     */
    public PsiCluesStoreConfigEntity load(PsiCluesStoreConfigPk psiCluesStoreConfigPk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param psiCluesStoreConfigEntity 查询条件
     * @return 实体集合
     */
    public List<PsiCluesStoreConfigEntity> selectBySelective(PsiCluesStoreConfigEntity psiCluesStoreConfigEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param psiCluesStoreConfigEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(PsiCluesStoreConfigEntity psiCluesStoreConfigEntity);
    
}
