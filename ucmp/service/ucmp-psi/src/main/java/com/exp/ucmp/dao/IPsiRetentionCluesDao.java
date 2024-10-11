/**
 * IPsiRetentionCluesDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package com.exp.ucmp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.exp.ucmp.entity.PsiRetentionCluesEntity;
import com.exp.ucmp.pk.PsiRetentionCluesPk;
/**
 * <p>ClassName: IPsiRetentionCluesDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface IPsiRetentionCluesDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_psi_retention_clues.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param psiRetentionCluesEntity 实体类
     * @return 插入多少行
     */
    public int insert(PsiRetentionCluesEntity psiRetentionCluesEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param psiRetentionCluesEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(PsiRetentionCluesEntity psiRetentionCluesEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listPsiRetentionCluesEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<PsiRetentionCluesEntity> listPsiRetentionCluesEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param psiRetentionCluesEntity 实体类
     * @return 更新了多少行
     */
    public int update(PsiRetentionCluesEntity psiRetentionCluesEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param psiRetentionCluesEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(PsiRetentionCluesEntity psiRetentionCluesEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listPsiRetentionCluesEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<PsiRetentionCluesEntity> listPsiRetentionCluesEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listPsiRetentionCluesEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<PsiRetentionCluesEntity> listPsiRetentionCluesEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param psiRetentionCluesPk 实体类
     * @return 删除了多少行
     */
    public int delete(PsiRetentionCluesPk psiRetentionCluesPk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param psiRetentionCluesEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(PsiRetentionCluesEntity psiRetentionCluesEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param psiRetentionCluesPk 主键实体
     * @return psiRetentionCluesPk 单个实体对象
     */
    public PsiRetentionCluesEntity load(PsiRetentionCluesPk psiRetentionCluesPk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param psiRetentionCluesEntity 查询条件
     * @return 实体集合
     */
    public List<PsiRetentionCluesEntity> selectBySelective(PsiRetentionCluesEntity psiRetentionCluesEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param psiRetentionCluesEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(PsiRetentionCluesEntity psiRetentionCluesEntity);
    
}
