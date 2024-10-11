/**
 * IPsiCreateOrderAccountInfoDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package com.exp.ucmp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.exp.ucmp.entity.PsiCreateOrderAccountInfoEntity;
import com.exp.ucmp.pk.PsiCreateOrderAccountInfoPk;
/**
 * <p>ClassName: IPsiCreateOrderAccountInfoDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface IPsiCreateOrderAccountInfoDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_psi_create_order_account_info.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param psiCreateOrderAccountInfoEntity 实体类
     * @return 插入多少行
     */
    public int insert(PsiCreateOrderAccountInfoEntity psiCreateOrderAccountInfoEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param psiCreateOrderAccountInfoEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(PsiCreateOrderAccountInfoEntity psiCreateOrderAccountInfoEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listPsiCreateOrderAccountInfoEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<PsiCreateOrderAccountInfoEntity> listPsiCreateOrderAccountInfoEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param psiCreateOrderAccountInfoEntity 实体类
     * @return 更新了多少行
     */
    public int update(PsiCreateOrderAccountInfoEntity psiCreateOrderAccountInfoEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param psiCreateOrderAccountInfoEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(PsiCreateOrderAccountInfoEntity psiCreateOrderAccountInfoEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listPsiCreateOrderAccountInfoEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<PsiCreateOrderAccountInfoEntity> listPsiCreateOrderAccountInfoEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listPsiCreateOrderAccountInfoEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<PsiCreateOrderAccountInfoEntity> listPsiCreateOrderAccountInfoEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param psiCreateOrderAccountInfoPk 实体类
     * @return 删除了多少行
     */
    public int delete(PsiCreateOrderAccountInfoPk psiCreateOrderAccountInfoPk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param psiCreateOrderAccountInfoEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(PsiCreateOrderAccountInfoEntity psiCreateOrderAccountInfoEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param psiCreateOrderAccountInfoPk 主键实体
     * @return psiCreateOrderAccountInfoPk 单个实体对象
     */
    public PsiCreateOrderAccountInfoEntity load(PsiCreateOrderAccountInfoPk psiCreateOrderAccountInfoPk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param psiCreateOrderAccountInfoEntity 查询条件
     * @return 实体集合
     */
    public List<PsiCreateOrderAccountInfoEntity> selectBySelective(PsiCreateOrderAccountInfoEntity psiCreateOrderAccountInfoEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param psiCreateOrderAccountInfoEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(PsiCreateOrderAccountInfoEntity psiCreateOrderAccountInfoEntity);
    
}
