/**
 * IPsiCarServiceRepairProjectComponentDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package com.exp.ucmp.dao;

import java.util.List;
import java.math.BigDecimal;
import org.apache.ibatis.annotations.Select;
import com.exp.ucmp.entity.PsiCarServiceRepairProjectComponentEntity;
import com.exp.ucmp.pk.PsiCarServiceRepairProjectComponentPk;
/**
 * <p>ClassName: IPsiCarServiceRepairProjectComponentDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface IPsiCarServiceRepairProjectComponentDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_psi_car_service_repair_project_component.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param psiCarServiceRepairProjectComponentEntity 实体类
     * @return 插入多少行
     */
    public int insert(PsiCarServiceRepairProjectComponentEntity psiCarServiceRepairProjectComponentEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param psiCarServiceRepairProjectComponentEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(PsiCarServiceRepairProjectComponentEntity psiCarServiceRepairProjectComponentEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listPsiCarServiceRepairProjectComponentEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<PsiCarServiceRepairProjectComponentEntity> listPsiCarServiceRepairProjectComponentEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param psiCarServiceRepairProjectComponentEntity 实体类
     * @return 更新了多少行
     */
    public int update(PsiCarServiceRepairProjectComponentEntity psiCarServiceRepairProjectComponentEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param psiCarServiceRepairProjectComponentEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(PsiCarServiceRepairProjectComponentEntity psiCarServiceRepairProjectComponentEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listPsiCarServiceRepairProjectComponentEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<PsiCarServiceRepairProjectComponentEntity> listPsiCarServiceRepairProjectComponentEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listPsiCarServiceRepairProjectComponentEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<PsiCarServiceRepairProjectComponentEntity> listPsiCarServiceRepairProjectComponentEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param psiCarServiceRepairProjectComponentPk 实体类
     * @return 删除了多少行
     */
    public int delete(PsiCarServiceRepairProjectComponentPk psiCarServiceRepairProjectComponentPk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param psiCarServiceRepairProjectComponentEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(PsiCarServiceRepairProjectComponentEntity psiCarServiceRepairProjectComponentEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param psiCarServiceRepairProjectComponentPk 主键实体
     * @return psiCarServiceRepairProjectComponentPk 单个实体对象
     */
    public PsiCarServiceRepairProjectComponentEntity load(PsiCarServiceRepairProjectComponentPk psiCarServiceRepairProjectComponentPk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param psiCarServiceRepairProjectComponentEntity 查询条件
     * @return 实体集合
     */
    public List<PsiCarServiceRepairProjectComponentEntity> selectBySelective(PsiCarServiceRepairProjectComponentEntity psiCarServiceRepairProjectComponentEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param psiCarServiceRepairProjectComponentEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(PsiCarServiceRepairProjectComponentEntity psiCarServiceRepairProjectComponentEntity);
    
}
