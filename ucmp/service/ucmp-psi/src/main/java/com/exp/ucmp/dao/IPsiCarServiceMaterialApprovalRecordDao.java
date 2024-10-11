/**
 * IPsiCarServiceMaterialApprovalRecordDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO EgridCloud, Inc, All rights reserved.
 */
package com.exp.ucmp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.exp.ucmp.entity.PsiCarServiceMaterialApprovalRecordEntity;
import com.exp.ucmp.pk.PsiCarServiceMaterialApprovalRecordPk;
/**
 * <p>ClassName: IPsiCarServiceMaterialApprovalRecordDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface IPsiCarServiceMaterialApprovalRecordDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_psi_car_service_material_approval_record.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param psiCarServiceMaterialApprovalRecordEntity 实体类
     * @return 插入多少行
     */
    public int insert(PsiCarServiceMaterialApprovalRecordEntity psiCarServiceMaterialApprovalRecordEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param psiCarServiceMaterialApprovalRecordEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(PsiCarServiceMaterialApprovalRecordEntity psiCarServiceMaterialApprovalRecordEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listPsiCarServiceMaterialApprovalRecordEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<PsiCarServiceMaterialApprovalRecordEntity> listPsiCarServiceMaterialApprovalRecordEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param psiCarServiceMaterialApprovalRecordEntity 实体类
     * @return 更新了多少行
     */
    public int update(PsiCarServiceMaterialApprovalRecordEntity psiCarServiceMaterialApprovalRecordEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param psiCarServiceMaterialApprovalRecordEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(PsiCarServiceMaterialApprovalRecordEntity psiCarServiceMaterialApprovalRecordEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listPsiCarServiceMaterialApprovalRecordEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<PsiCarServiceMaterialApprovalRecordEntity> listPsiCarServiceMaterialApprovalRecordEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listPsiCarServiceMaterialApprovalRecordEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<PsiCarServiceMaterialApprovalRecordEntity> listPsiCarServiceMaterialApprovalRecordEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param psiCarServiceMaterialApprovalRecordPk 实体类
     * @return 删除了多少行
     */
    public int delete(PsiCarServiceMaterialApprovalRecordPk psiCarServiceMaterialApprovalRecordPk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param psiCarServiceMaterialApprovalRecordEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(PsiCarServiceMaterialApprovalRecordEntity psiCarServiceMaterialApprovalRecordEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param psiCarServiceMaterialApprovalRecordPk 主键实体
     * @return psiCarServiceMaterialApprovalRecordPk 单个实体对象
     */
    public PsiCarServiceMaterialApprovalRecordEntity load(PsiCarServiceMaterialApprovalRecordPk psiCarServiceMaterialApprovalRecordPk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param psiCarServiceMaterialApprovalRecordEntity 查询条件
     * @return 实体集合
     */
    public List<PsiCarServiceMaterialApprovalRecordEntity> selectBySelective(PsiCarServiceMaterialApprovalRecordEntity psiCarServiceMaterialApprovalRecordEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param psiCarServiceMaterialApprovalRecordEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(PsiCarServiceMaterialApprovalRecordEntity psiCarServiceMaterialApprovalRecordEntity);
    
}
