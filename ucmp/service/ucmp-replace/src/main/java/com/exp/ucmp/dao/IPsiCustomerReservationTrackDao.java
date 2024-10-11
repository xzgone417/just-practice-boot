/**
 * IPsiCustomerReservationTrackDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package com.exp.ucmp.dao;

import com.exp.ucmp.entity.PsiCustomerReservationTrackEntity;
import com.exp.ucmp.pk.PsiCustomerReservationTrackPk;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>ClassName: IPsiCustomerReservationTrackDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface IPsiCustomerReservationTrackDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_psi_customer_reservation_track.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param psiCustomerReservationTrackEntity 实体类
     * @return 插入多少行
     */
    public int insert(PsiCustomerReservationTrackEntity psiCustomerReservationTrackEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param psiCustomerReservationTrackEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(PsiCustomerReservationTrackEntity psiCustomerReservationTrackEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listPsiCustomerReservationTrackEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<PsiCustomerReservationTrackEntity> listPsiCustomerReservationTrackEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param psiCustomerReservationTrackEntity 实体类
     * @return 更新了多少行
     */
    public int update(PsiCustomerReservationTrackEntity psiCustomerReservationTrackEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param psiCustomerReservationTrackEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(PsiCustomerReservationTrackEntity psiCustomerReservationTrackEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listPsiCustomerReservationTrackEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<PsiCustomerReservationTrackEntity> listPsiCustomerReservationTrackEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listPsiCustomerReservationTrackEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<PsiCustomerReservationTrackEntity> listPsiCustomerReservationTrackEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param psiCustomerReservationTrackPk 实体类
     * @return 删除了多少行
     */
    public int delete(PsiCustomerReservationTrackPk psiCustomerReservationTrackPk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param psiCustomerReservationTrackEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(PsiCustomerReservationTrackEntity psiCustomerReservationTrackEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param psiCustomerReservationTrackPk 主键实体
     * @return psiCustomerReservationTrackPk 单个实体对象
     */
    public PsiCustomerReservationTrackEntity load(PsiCustomerReservationTrackPk psiCustomerReservationTrackPk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param psiCustomerReservationTrackEntity 查询条件
     * @return 实体集合
     */
    public List<PsiCustomerReservationTrackEntity> selectBySelective(PsiCustomerReservationTrackEntity psiCustomerReservationTrackEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param psiCustomerReservationTrackEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(PsiCustomerReservationTrackEntity psiCustomerReservationTrackEntity);
    
}
