/**
 * IPsiCarServiceInfoDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package com.exp.ucmp.dao;

import java.util.List;
import java.math.BigDecimal;
import org.apache.ibatis.annotations.Select;
import com.exp.ucmp.entity.PsiCarServiceInfoEntity;
import com.exp.ucmp.pk.PsiCarServiceInfoPk;
/**
 * <p>ClassName: IPsiCarServiceInfoDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface IPsiCarServiceInfoDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_psi_car_service_info.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param psiCarServiceInfoEntity 实体类
     * @return 插入多少行
     */
    public int insert(PsiCarServiceInfoEntity psiCarServiceInfoEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param psiCarServiceInfoEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(PsiCarServiceInfoEntity psiCarServiceInfoEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listPsiCarServiceInfoEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<PsiCarServiceInfoEntity> listPsiCarServiceInfoEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param psiCarServiceInfoEntity 实体类
     * @return 更新了多少行
     */
    public int update(PsiCarServiceInfoEntity psiCarServiceInfoEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param psiCarServiceInfoEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(PsiCarServiceInfoEntity psiCarServiceInfoEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listPsiCarServiceInfoEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<PsiCarServiceInfoEntity> listPsiCarServiceInfoEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listPsiCarServiceInfoEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<PsiCarServiceInfoEntity> listPsiCarServiceInfoEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param psiCarServiceInfoPk 实体类
     * @return 删除了多少行
     */
    public int delete(PsiCarServiceInfoPk psiCarServiceInfoPk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param psiCarServiceInfoEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(PsiCarServiceInfoEntity psiCarServiceInfoEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param psiCarServiceInfoPk 主键实体
     * @return psiCarServiceInfoPk 单个实体对象
     */
    public PsiCarServiceInfoEntity load(PsiCarServiceInfoPk psiCarServiceInfoPk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param psiCarServiceInfoEntity 查询条件
     * @return 实体集合
     */
    public List<PsiCarServiceInfoEntity> selectBySelective(PsiCarServiceInfoEntity psiCarServiceInfoEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param psiCarServiceInfoEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(PsiCarServiceInfoEntity psiCarServiceInfoEntity);
    
}
