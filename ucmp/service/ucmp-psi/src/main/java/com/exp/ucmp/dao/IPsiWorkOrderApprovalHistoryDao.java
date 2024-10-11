/**
 * IPsiWorkOrderApprovalHistoryDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package com.exp.ucmp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.exp.ucmp.entity.PsiWorkOrderApprovalHistoryEntity;
import com.exp.ucmp.pk.PsiWorkOrderApprovalHistoryPk;
/**
 * <p>ClassName: IPsiWorkOrderApprovalHistoryDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface IPsiWorkOrderApprovalHistoryDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_psi_work_order_approval_history.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param psiWorkOrderApprovalHistoryEntity 实体类
     * @return 插入多少行
     */
    public int insert(PsiWorkOrderApprovalHistoryEntity psiWorkOrderApprovalHistoryEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param psiWorkOrderApprovalHistoryEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(PsiWorkOrderApprovalHistoryEntity psiWorkOrderApprovalHistoryEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listPsiWorkOrderApprovalHistoryEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<PsiWorkOrderApprovalHistoryEntity> listPsiWorkOrderApprovalHistoryEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param psiWorkOrderApprovalHistoryEntity 实体类
     * @return 更新了多少行
     */
    public int update(PsiWorkOrderApprovalHistoryEntity psiWorkOrderApprovalHistoryEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param psiWorkOrderApprovalHistoryEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(PsiWorkOrderApprovalHistoryEntity psiWorkOrderApprovalHistoryEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listPsiWorkOrderApprovalHistoryEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<PsiWorkOrderApprovalHistoryEntity> listPsiWorkOrderApprovalHistoryEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listPsiWorkOrderApprovalHistoryEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<PsiWorkOrderApprovalHistoryEntity> listPsiWorkOrderApprovalHistoryEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param psiWorkOrderApprovalHistoryPk 实体类
     * @return 删除了多少行
     */
    public int delete(PsiWorkOrderApprovalHistoryPk psiWorkOrderApprovalHistoryPk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param psiWorkOrderApprovalHistoryEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(PsiWorkOrderApprovalHistoryEntity psiWorkOrderApprovalHistoryEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param psiWorkOrderApprovalHistoryPk 主键实体
     * @return psiWorkOrderApprovalHistoryPk 单个实体对象
     */
    public PsiWorkOrderApprovalHistoryEntity load(PsiWorkOrderApprovalHistoryPk psiWorkOrderApprovalHistoryPk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param psiWorkOrderApprovalHistoryEntity 查询条件
     * @return 实体集合
     */
    public List<PsiWorkOrderApprovalHistoryEntity> selectBySelective(PsiWorkOrderApprovalHistoryEntity psiWorkOrderApprovalHistoryEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param psiWorkOrderApprovalHistoryEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(PsiWorkOrderApprovalHistoryEntity psiWorkOrderApprovalHistoryEntity);
    
}
