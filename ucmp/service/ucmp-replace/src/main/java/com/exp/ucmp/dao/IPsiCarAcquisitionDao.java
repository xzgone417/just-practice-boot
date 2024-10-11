/**
 * IPsiCarAcquisitionDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package com.exp.ucmp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.exp.ucmp.entity.PsiCarAcquisitionEntity;
import com.exp.ucmp.pk.PsiCarAcquisitionPk;
/**
 * <p>ClassName: IPsiCarAcquisitionDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface IPsiCarAcquisitionDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_psi_car_acquisition.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param psiCarAcquisitionEntity 实体类
     * @return 插入多少行
     */
    public int insert(PsiCarAcquisitionEntity psiCarAcquisitionEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param psiCarAcquisitionEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(PsiCarAcquisitionEntity psiCarAcquisitionEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listPsiCarAcquisitionEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<PsiCarAcquisitionEntity> listPsiCarAcquisitionEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param psiCarAcquisitionEntity 实体类
     * @return 更新了多少行
     */
    public int update(PsiCarAcquisitionEntity psiCarAcquisitionEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param psiCarAcquisitionEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(PsiCarAcquisitionEntity psiCarAcquisitionEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listPsiCarAcquisitionEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<PsiCarAcquisitionEntity> listPsiCarAcquisitionEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listPsiCarAcquisitionEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<PsiCarAcquisitionEntity> listPsiCarAcquisitionEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param psiCarAcquisitionPk 实体类
     * @return 删除了多少行
     */
    public int delete(PsiCarAcquisitionPk psiCarAcquisitionPk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param psiCarAcquisitionEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(PsiCarAcquisitionEntity psiCarAcquisitionEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param psiCarAcquisitionPk 主键实体
     * @return psiCarAcquisitionPk 单个实体对象
     */
    public PsiCarAcquisitionEntity load(PsiCarAcquisitionPk psiCarAcquisitionPk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param psiCarAcquisitionEntity 查询条件
     * @return 实体集合
     */
    public List<PsiCarAcquisitionEntity> selectBySelective(PsiCarAcquisitionEntity psiCarAcquisitionEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param psiCarAcquisitionEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(PsiCarAcquisitionEntity psiCarAcquisitionEntity);
    
}
