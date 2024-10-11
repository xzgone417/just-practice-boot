/**
 * IPsiCustomerReservationMsgDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package com.exp.ucmp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.exp.ucmp.entity.PsiCustomerReservationMsgEntity;
import com.exp.ucmp.pk.PsiCustomerReservationMsgPk;
/**
 * <p>ClassName: IPsiCustomerReservationMsgDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface IPsiCustomerReservationMsgDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_psi_customer_reservation_msg.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param psiCustomerReservationMsgEntity 实体类
     * @return 插入多少行
     */
    public int insert(PsiCustomerReservationMsgEntity psiCustomerReservationMsgEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param psiCustomerReservationMsgEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(PsiCustomerReservationMsgEntity psiCustomerReservationMsgEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listPsiCustomerReservationMsgEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<PsiCustomerReservationMsgEntity> listPsiCustomerReservationMsgEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param psiCustomerReservationMsgEntity 实体类
     * @return 更新了多少行
     */
    public int update(PsiCustomerReservationMsgEntity psiCustomerReservationMsgEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param psiCustomerReservationMsgEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(PsiCustomerReservationMsgEntity psiCustomerReservationMsgEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listPsiCustomerReservationMsgEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<PsiCustomerReservationMsgEntity> listPsiCustomerReservationMsgEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listPsiCustomerReservationMsgEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<PsiCustomerReservationMsgEntity> listPsiCustomerReservationMsgEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param psiCustomerReservationMsgPk 实体类
     * @return 删除了多少行
     */
    public int delete(PsiCustomerReservationMsgPk psiCustomerReservationMsgPk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param psiCustomerReservationMsgEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(PsiCustomerReservationMsgEntity psiCustomerReservationMsgEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param psiCustomerReservationMsgPk 主键实体
     * @return psiCustomerReservationMsgPk 单个实体对象
     */
    public PsiCustomerReservationMsgEntity load(PsiCustomerReservationMsgPk psiCustomerReservationMsgPk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param psiCustomerReservationMsgEntity 查询条件
     * @return 实体集合
     */
    public List<PsiCustomerReservationMsgEntity> selectBySelective(PsiCustomerReservationMsgEntity psiCustomerReservationMsgEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param psiCustomerReservationMsgEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(PsiCustomerReservationMsgEntity psiCustomerReservationMsgEntity);
    
}
