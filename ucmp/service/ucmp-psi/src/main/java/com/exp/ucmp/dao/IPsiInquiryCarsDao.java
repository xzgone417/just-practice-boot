/**
 * IPsiInquiryCarsDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package com.exp.ucmp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.exp.ucmp.entity.PsiInquiryCarsEntity;
import com.exp.ucmp.pk.PsiInquiryCarsPk;
/**
 * <p>ClassName: IPsiInquiryCarsDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface IPsiInquiryCarsDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_psi_inquiry_cars.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param psiInquiryCarsEntity 实体类
     * @return 插入多少行
     */
    public int insert(PsiInquiryCarsEntity psiInquiryCarsEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param psiInquiryCarsEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(PsiInquiryCarsEntity psiInquiryCarsEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listPsiInquiryCarsEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<PsiInquiryCarsEntity> listPsiInquiryCarsEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param psiInquiryCarsEntity 实体类
     * @return 更新了多少行
     */
    public int update(PsiInquiryCarsEntity psiInquiryCarsEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param psiInquiryCarsEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(PsiInquiryCarsEntity psiInquiryCarsEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listPsiInquiryCarsEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<PsiInquiryCarsEntity> listPsiInquiryCarsEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listPsiInquiryCarsEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<PsiInquiryCarsEntity> listPsiInquiryCarsEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param psiInquiryCarsPk 实体类
     * @return 删除了多少行
     */
    public int delete(PsiInquiryCarsPk psiInquiryCarsPk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param psiInquiryCarsEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(PsiInquiryCarsEntity psiInquiryCarsEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param psiInquiryCarsPk 主键实体
     * @return psiInquiryCarsPk 单个实体对象
     */
    public PsiInquiryCarsEntity load(PsiInquiryCarsPk psiInquiryCarsPk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param psiInquiryCarsEntity 查询条件
     * @return 实体集合
     */
    public List<PsiInquiryCarsEntity> selectBySelective(PsiInquiryCarsEntity psiInquiryCarsEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param psiInquiryCarsEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(PsiInquiryCarsEntity psiInquiryCarsEntity);
    
}
