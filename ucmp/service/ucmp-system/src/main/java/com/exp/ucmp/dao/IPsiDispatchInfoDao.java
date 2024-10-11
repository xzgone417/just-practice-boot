/**
 * IPsiDispatchInfoDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package com.exp.ucmp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.exp.ucmp.entity.PsiDispatchInfoEntity;
import com.exp.ucmp.pk.PsiDispatchInfoPk;
/**
 * <p>ClassName: IPsiDispatchInfoDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface IPsiDispatchInfoDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_psi_dispatch_info.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param psiDispatchInfoEntity 实体类
     * @return 插入多少行
     */
    public int insert(PsiDispatchInfoEntity psiDispatchInfoEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param psiDispatchInfoEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(PsiDispatchInfoEntity psiDispatchInfoEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listPsiDispatchInfoEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<PsiDispatchInfoEntity> listPsiDispatchInfoEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param psiDispatchInfoEntity 实体类
     * @return 更新了多少行
     */
    public int update(PsiDispatchInfoEntity psiDispatchInfoEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param psiDispatchInfoEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(PsiDispatchInfoEntity psiDispatchInfoEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listPsiDispatchInfoEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<PsiDispatchInfoEntity> listPsiDispatchInfoEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listPsiDispatchInfoEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<PsiDispatchInfoEntity> listPsiDispatchInfoEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param psiDispatchInfoPk 实体类
     * @return 删除了多少行
     */
    public int delete(PsiDispatchInfoPk psiDispatchInfoPk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param psiDispatchInfoEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(PsiDispatchInfoEntity psiDispatchInfoEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param psiDispatchInfoPk 主键实体
     * @return psiDispatchInfoPk 单个实体对象
     */
    public PsiDispatchInfoEntity load(PsiDispatchInfoPk psiDispatchInfoPk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param psiDispatchInfoEntity 查询条件
     * @return 实体集合
     */
    public List<PsiDispatchInfoEntity> selectBySelective(PsiDispatchInfoEntity psiDispatchInfoEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param psiDispatchInfoEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(PsiDispatchInfoEntity psiDispatchInfoEntity);
    
}
