/**
 * IPsiCluesFollowRecordDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package com.exp.ucmp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.exp.ucmp.entity.PsiCluesFollowRecordEntity;
import com.exp.ucmp.pk.PsiCluesFollowRecordPk;
/**
 * <p>ClassName: IPsiCluesFollowRecordDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface IPsiCluesFollowRecordDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_psi_clues_follow_record.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param psiCluesFollowRecordEntity 实体类
     * @return 插入多少行
     */
    public int insert(PsiCluesFollowRecordEntity psiCluesFollowRecordEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param psiCluesFollowRecordEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(PsiCluesFollowRecordEntity psiCluesFollowRecordEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listPsiCluesFollowRecordEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<PsiCluesFollowRecordEntity> listPsiCluesFollowRecordEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param psiCluesFollowRecordEntity 实体类
     * @return 更新了多少行
     */
    public int update(PsiCluesFollowRecordEntity psiCluesFollowRecordEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param psiCluesFollowRecordEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(PsiCluesFollowRecordEntity psiCluesFollowRecordEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listPsiCluesFollowRecordEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<PsiCluesFollowRecordEntity> listPsiCluesFollowRecordEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listPsiCluesFollowRecordEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<PsiCluesFollowRecordEntity> listPsiCluesFollowRecordEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param psiCluesFollowRecordPk 实体类
     * @return 删除了多少行
     */
    public int delete(PsiCluesFollowRecordPk psiCluesFollowRecordPk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param psiCluesFollowRecordEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(PsiCluesFollowRecordEntity psiCluesFollowRecordEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param psiCluesFollowRecordPk 主键实体
     * @return psiCluesFollowRecordPk 单个实体对象
     */
    public PsiCluesFollowRecordEntity load(PsiCluesFollowRecordPk psiCluesFollowRecordPk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param psiCluesFollowRecordEntity 查询条件
     * @return 实体集合
     */
    public List<PsiCluesFollowRecordEntity> selectBySelective(PsiCluesFollowRecordEntity psiCluesFollowRecordEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param psiCluesFollowRecordEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(PsiCluesFollowRecordEntity psiCluesFollowRecordEntity);
    
}
