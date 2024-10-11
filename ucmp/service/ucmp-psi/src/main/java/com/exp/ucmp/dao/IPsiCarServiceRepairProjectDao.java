/**
 * IPsiCarServiceRepairProjectDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package com.exp.ucmp.dao;

import java.util.List;
import java.math.BigDecimal;
import org.apache.ibatis.annotations.Select;
import com.exp.ucmp.entity.PsiCarServiceRepairProjectEntity;
import com.exp.ucmp.pk.PsiCarServiceRepairProjectPk;
/**
 * <p>ClassName: IPsiCarServiceRepairProjectDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface IPsiCarServiceRepairProjectDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_psi_car_service_repair_project.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param psiCarServiceRepairProjectEntity 实体类
     * @return 插入多少行
     */
    public int insert(PsiCarServiceRepairProjectEntity psiCarServiceRepairProjectEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param psiCarServiceRepairProjectEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(PsiCarServiceRepairProjectEntity psiCarServiceRepairProjectEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listPsiCarServiceRepairProjectEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<PsiCarServiceRepairProjectEntity> listPsiCarServiceRepairProjectEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param psiCarServiceRepairProjectEntity 实体类
     * @return 更新了多少行
     */
    public int update(PsiCarServiceRepairProjectEntity psiCarServiceRepairProjectEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param psiCarServiceRepairProjectEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(PsiCarServiceRepairProjectEntity psiCarServiceRepairProjectEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listPsiCarServiceRepairProjectEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<PsiCarServiceRepairProjectEntity> listPsiCarServiceRepairProjectEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listPsiCarServiceRepairProjectEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<PsiCarServiceRepairProjectEntity> listPsiCarServiceRepairProjectEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param psiCarServiceRepairProjectPk 实体类
     * @return 删除了多少行
     */
    public int delete(PsiCarServiceRepairProjectPk psiCarServiceRepairProjectPk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param psiCarServiceRepairProjectEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(PsiCarServiceRepairProjectEntity psiCarServiceRepairProjectEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param psiCarServiceRepairProjectPk 主键实体
     * @return psiCarServiceRepairProjectPk 单个实体对象
     */
    public PsiCarServiceRepairProjectEntity load(PsiCarServiceRepairProjectPk psiCarServiceRepairProjectPk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param psiCarServiceRepairProjectEntity 查询条件
     * @return 实体集合
     */
    public List<PsiCarServiceRepairProjectEntity> selectBySelective(PsiCarServiceRepairProjectEntity psiCarServiceRepairProjectEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param psiCarServiceRepairProjectEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(PsiCarServiceRepairProjectEntity psiCarServiceRepairProjectEntity);
    
}
