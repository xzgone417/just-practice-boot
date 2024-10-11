/**
 * IPsiMessageInfoDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package com.exp.ucmp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.exp.ucmp.entity.PsiMessageInfoEntity;
import com.exp.ucmp.pk.PsiMessageInfoPk;
/**
 * <p>ClassName: IPsiMessageInfoDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface IPsiMessageInfoDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_psi_message_info.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param psiMessageInfoEntity 实体类
     * @return 插入多少行
     */
    public int insert(PsiMessageInfoEntity psiMessageInfoEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param psiMessageInfoEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(PsiMessageInfoEntity psiMessageInfoEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listPsiMessageInfoEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<PsiMessageInfoEntity> listPsiMessageInfoEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param psiMessageInfoEntity 实体类
     * @return 更新了多少行
     */
    public int update(PsiMessageInfoEntity psiMessageInfoEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param psiMessageInfoEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(PsiMessageInfoEntity psiMessageInfoEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listPsiMessageInfoEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<PsiMessageInfoEntity> listPsiMessageInfoEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listPsiMessageInfoEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<PsiMessageInfoEntity> listPsiMessageInfoEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param psiMessageInfoPk 实体类
     * @return 删除了多少行
     */
    public int delete(PsiMessageInfoPk psiMessageInfoPk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param psiMessageInfoEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(PsiMessageInfoEntity psiMessageInfoEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param psiMessageInfoPk 主键实体
     * @return psiMessageInfoPk 单个实体对象
     */
    public PsiMessageInfoEntity load(PsiMessageInfoPk psiMessageInfoPk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param psiMessageInfoEntity 查询条件
     * @return 实体集合
     */
    public List<PsiMessageInfoEntity> selectBySelective(PsiMessageInfoEntity psiMessageInfoEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param psiMessageInfoEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(PsiMessageInfoEntity psiMessageInfoEntity);
    
}
