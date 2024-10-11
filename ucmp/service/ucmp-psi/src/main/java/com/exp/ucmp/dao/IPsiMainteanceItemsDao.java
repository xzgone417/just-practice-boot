/**
 * IPsiMainteanceItemsDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package com.exp.ucmp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.exp.ucmp.entity.PsiMainteanceItemsEntity;
import com.exp.ucmp.pk.PsiMainteanceItemsPk;
/**
 * <p>ClassName: IPsiMainteanceItemsDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface IPsiMainteanceItemsDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_psi_mainteance_items.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param psiMainteanceItemsEntity 实体类
     * @return 插入多少行
     */
    public int insert(PsiMainteanceItemsEntity psiMainteanceItemsEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param psiMainteanceItemsEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(PsiMainteanceItemsEntity psiMainteanceItemsEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listPsiMainteanceItemsEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<PsiMainteanceItemsEntity> listPsiMainteanceItemsEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param psiMainteanceItemsEntity 实体类
     * @return 更新了多少行
     */
    public int update(PsiMainteanceItemsEntity psiMainteanceItemsEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param psiMainteanceItemsEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(PsiMainteanceItemsEntity psiMainteanceItemsEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listPsiMainteanceItemsEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<PsiMainteanceItemsEntity> listPsiMainteanceItemsEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listPsiMainteanceItemsEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<PsiMainteanceItemsEntity> listPsiMainteanceItemsEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param psiMainteanceItemsPk 实体类
     * @return 删除了多少行
     */
    public int delete(PsiMainteanceItemsPk psiMainteanceItemsPk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param psiMainteanceItemsEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(PsiMainteanceItemsEntity psiMainteanceItemsEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param psiMainteanceItemsPk 主键实体
     * @return psiMainteanceItemsPk 单个实体对象
     */
    public PsiMainteanceItemsEntity load(PsiMainteanceItemsPk psiMainteanceItemsPk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param psiMainteanceItemsEntity 查询条件
     * @return 实体集合
     */
    public List<PsiMainteanceItemsEntity> selectBySelective(PsiMainteanceItemsEntity psiMainteanceItemsEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param psiMainteanceItemsEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(PsiMainteanceItemsEntity psiMainteanceItemsEntity);
    
}
