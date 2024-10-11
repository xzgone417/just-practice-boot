/**
 * IPsiCarTransferApplyDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package com.exp.ucmp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.exp.ucmp.entity.PsiCarTransferApplyEntity;
import com.exp.ucmp.pk.PsiCarTransferApplyPk;
/**
 * <p>ClassName: IPsiCarTransferApplyDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface IPsiCarTransferApplyDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_psi_car_transfer_apply.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param psiCarTransferApplyEntity 实体类
     * @return 插入多少行
     */
    public int insert(PsiCarTransferApplyEntity psiCarTransferApplyEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param psiCarTransferApplyEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(PsiCarTransferApplyEntity psiCarTransferApplyEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listPsiCarTransferApplyEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<PsiCarTransferApplyEntity> listPsiCarTransferApplyEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param psiCarTransferApplyEntity 实体类
     * @return 更新了多少行
     */
    public int update(PsiCarTransferApplyEntity psiCarTransferApplyEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param psiCarTransferApplyEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(PsiCarTransferApplyEntity psiCarTransferApplyEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listPsiCarTransferApplyEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<PsiCarTransferApplyEntity> listPsiCarTransferApplyEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listPsiCarTransferApplyEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<PsiCarTransferApplyEntity> listPsiCarTransferApplyEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param psiCarTransferApplyPk 实体类
     * @return 删除了多少行
     */
    public int delete(PsiCarTransferApplyPk psiCarTransferApplyPk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param psiCarTransferApplyEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(PsiCarTransferApplyEntity psiCarTransferApplyEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param psiCarTransferApplyPk 主键实体
     * @return psiCarTransferApplyPk 单个实体对象
     */
    public PsiCarTransferApplyEntity load(PsiCarTransferApplyPk psiCarTransferApplyPk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param psiCarTransferApplyEntity 查询条件
     * @return 实体集合
     */
    public List<PsiCarTransferApplyEntity> selectBySelective(PsiCarTransferApplyEntity psiCarTransferApplyEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param psiCarTransferApplyEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(PsiCarTransferApplyEntity psiCarTransferApplyEntity);
    
}
