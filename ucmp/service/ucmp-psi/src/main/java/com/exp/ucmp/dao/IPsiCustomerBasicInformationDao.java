/**
 * IPsiCustomerBasicInformationDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package com.exp.ucmp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.exp.ucmp.entity.PsiCustomerBasicInformationEntity;
import com.exp.ucmp.pk.PsiCustomerBasicInformationPk;
/**
 * <p>ClassName: IPsiCustomerBasicInformationDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface IPsiCustomerBasicInformationDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_psi_customer_basic_information.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param psiCustomerBasicInformationEntity 实体类
     * @return 插入多少行
     */
    public int insert(PsiCustomerBasicInformationEntity psiCustomerBasicInformationEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param psiCustomerBasicInformationEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(PsiCustomerBasicInformationEntity psiCustomerBasicInformationEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listPsiCustomerBasicInformationEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<PsiCustomerBasicInformationEntity> listPsiCustomerBasicInformationEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param psiCustomerBasicInformationEntity 实体类
     * @return 更新了多少行
     */
    public int update(PsiCustomerBasicInformationEntity psiCustomerBasicInformationEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param psiCustomerBasicInformationEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(PsiCustomerBasicInformationEntity psiCustomerBasicInformationEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listPsiCustomerBasicInformationEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<PsiCustomerBasicInformationEntity> listPsiCustomerBasicInformationEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listPsiCustomerBasicInformationEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<PsiCustomerBasicInformationEntity> listPsiCustomerBasicInformationEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param psiCustomerBasicInformationPk 实体类
     * @return 删除了多少行
     */
    public int delete(PsiCustomerBasicInformationPk psiCustomerBasicInformationPk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param psiCustomerBasicInformationEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(PsiCustomerBasicInformationEntity psiCustomerBasicInformationEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param psiCustomerBasicInformationPk 主键实体
     * @return psiCustomerBasicInformationPk 单个实体对象
     */
    public PsiCustomerBasicInformationEntity load(PsiCustomerBasicInformationPk psiCustomerBasicInformationPk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param psiCustomerBasicInformationEntity 查询条件
     * @return 实体集合
     */
    public List<PsiCustomerBasicInformationEntity> selectBySelective(PsiCustomerBasicInformationEntity psiCustomerBasicInformationEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param psiCustomerBasicInformationEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(PsiCustomerBasicInformationEntity psiCustomerBasicInformationEntity);
    
}
