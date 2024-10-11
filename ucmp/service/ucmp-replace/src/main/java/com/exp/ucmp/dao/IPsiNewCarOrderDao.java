/**
 * IPsiNewCarOrderDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package com.exp.ucmp.dao;

import com.exp.ucmp.entity.PsiNewCarOrderEntity;
import com.exp.ucmp.pk.PsiNewCarOrderPk;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>ClassName: IPsiNewCarOrderDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface IPsiNewCarOrderDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_psi_new_car_order.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param psiNewCarOrderEntity 实体类
     * @return 插入多少行
     */
    public int insert(PsiNewCarOrderEntity psiNewCarOrderEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param psiNewCarOrderEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(PsiNewCarOrderEntity psiNewCarOrderEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listPsiNewCarOrderEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<PsiNewCarOrderEntity> listPsiNewCarOrderEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param psiNewCarOrderEntity 实体类
     * @return 更新了多少行
     */
    public int update(PsiNewCarOrderEntity psiNewCarOrderEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param psiNewCarOrderEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(PsiNewCarOrderEntity psiNewCarOrderEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listPsiNewCarOrderEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<PsiNewCarOrderEntity> listPsiNewCarOrderEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listPsiNewCarOrderEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<PsiNewCarOrderEntity> listPsiNewCarOrderEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param psiNewCarOrderPk 实体类
     * @return 删除了多少行
     */
    public int delete(PsiNewCarOrderPk psiNewCarOrderPk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param psiNewCarOrderEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(PsiNewCarOrderEntity psiNewCarOrderEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param psiNewCarOrderPk 主键实体
     * @return psiNewCarOrderPk 单个实体对象
     */
    public PsiNewCarOrderEntity load(PsiNewCarOrderPk psiNewCarOrderPk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param psiNewCarOrderEntity 查询条件
     * @return 实体集合
     */
    public List<PsiNewCarOrderEntity> selectBySelective(PsiNewCarOrderEntity psiNewCarOrderEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param psiNewCarOrderEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(PsiNewCarOrderEntity psiNewCarOrderEntity);
    
}
