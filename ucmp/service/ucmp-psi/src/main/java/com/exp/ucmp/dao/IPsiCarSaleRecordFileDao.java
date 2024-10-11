/**
 * IPsiCarSaleRecordFileDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO EgridCloud, Inc, All rights reserved.
 */
package com.exp.ucmp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.exp.ucmp.entity.PsiCarSaleRecordFileEntity;
import com.exp.ucmp.pk.PsiCarSaleRecordFilePk;
/**
 * <p>ClassName: IPsiCarSaleRecordFileDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface IPsiCarSaleRecordFileDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_psi_car_sale_record_file.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param psiCarSaleRecordFileEntity 实体类
     * @return 插入多少行
     */
    public int insert(PsiCarSaleRecordFileEntity psiCarSaleRecordFileEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param psiCarSaleRecordFileEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(PsiCarSaleRecordFileEntity psiCarSaleRecordFileEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listPsiCarSaleRecordFileEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<PsiCarSaleRecordFileEntity> listPsiCarSaleRecordFileEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param psiCarSaleRecordFileEntity 实体类
     * @return 更新了多少行
     */
    public int update(PsiCarSaleRecordFileEntity psiCarSaleRecordFileEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param psiCarSaleRecordFileEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(PsiCarSaleRecordFileEntity psiCarSaleRecordFileEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listPsiCarSaleRecordFileEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<PsiCarSaleRecordFileEntity> listPsiCarSaleRecordFileEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listPsiCarSaleRecordFileEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<PsiCarSaleRecordFileEntity> listPsiCarSaleRecordFileEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param psiCarSaleRecordFilePk 实体类
     * @return 删除了多少行
     */
    public int delete(PsiCarSaleRecordFilePk psiCarSaleRecordFilePk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param psiCarSaleRecordFileEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(PsiCarSaleRecordFileEntity psiCarSaleRecordFileEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param psiCarSaleRecordFilePk 主键实体
     * @return psiCarSaleRecordFilePk 单个实体对象
     */
    public PsiCarSaleRecordFileEntity load(PsiCarSaleRecordFilePk psiCarSaleRecordFilePk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param psiCarSaleRecordFileEntity 查询条件
     * @return 实体集合
     */
    public List<PsiCarSaleRecordFileEntity> selectBySelective(PsiCarSaleRecordFileEntity psiCarSaleRecordFileEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param psiCarSaleRecordFileEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(PsiCarSaleRecordFileEntity psiCarSaleRecordFileEntity);
    
}
