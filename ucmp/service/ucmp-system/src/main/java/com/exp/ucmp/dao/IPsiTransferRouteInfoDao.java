/**
 * IPsiTransferRouteInfoDao.java
 * Created at TODO
 * Created by TODO
 * Copyright (C) TODO SAIC VOLKSWAGEN, All rights reserved.
 */
package com.exp.ucmp.dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import com.exp.ucmp.entity.PsiTransferRouteInfoEntity;
import com.exp.ucmp.pk.PsiTransferRouteInfoPk;
/**
 * <p>ClassName: IPsiTransferRouteInfoDao</p>
 * <p>Description: TODO</p>
 * <p>Author: TODO</p>
 * <p>Date: TODO</p>
 */
public interface IPsiTransferRouteInfoDao {
    /**
     * <p>Description: 获取序列，序列按照SEQ+表名设计</p>
     * @return 序列
     */
    @Select("select SEQ_t_psi_transfer_route_info.Nextval from dual")
    public long selectSequence();
    /**
     * <p>Description: 全字段插入</p>
     * @param psiTransferRouteInfoEntity 实体类
     * @return 插入多少行
     */
    public int insert(PsiTransferRouteInfoEntity psiTransferRouteInfoEntity);
    /**
     * <p>Description: 选择全字段插入</p>
     * @param psiTransferRouteInfoEntity 实体类
     * @return 插入多少行
     */
    public int insertSelective(PsiTransferRouteInfoEntity psiTransferRouteInfoEntity);
    /**
     * <p>Description: 全字段插入</p>
     * @param listPsiTransferRouteInfoEntity 实体类
     * @return 插入多少行
     */
    public int batchInsert(List<PsiTransferRouteInfoEntity> listPsiTransferRouteInfoEntity);
    /**
     * <p>Description: 全字段更新</p>
     * @param psiTransferRouteInfoEntity 实体类
     * @return 更新了多少行
     */
    public int update(PsiTransferRouteInfoEntity psiTransferRouteInfoEntity);
    /**
     * <p>Description: 选择字段更新</p>
     * @param psiTransferRouteInfoEntity 实体类
     * @return 更新了多少行
     */
    public int updateSelective(PsiTransferRouteInfoEntity psiTransferRouteInfoEntity);
    
    /**
     * <p>Description: 全字段更新</p>
     * @param listPsiTransferRouteInfoEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdate(List<PsiTransferRouteInfoEntity> listPsiTransferRouteInfoEntity);
    
    /**
     * <p>Description: 选择字段更新</p>
     * @param listPsiTransferRouteInfoEntity 实体类
     * @return 更新多少行
     */
    public int batchUpdateSelective(List<PsiTransferRouteInfoEntity> listPsiTransferRouteInfoEntity);
    
    /**
     * <p>Description: 根据主键删除</p>
     * @param psiTransferRouteInfoPk 实体类
     * @return 删除了多少行
     */
    public int delete(PsiTransferRouteInfoPk psiTransferRouteInfoPk);
    /**
     * <p>Description: 根据多个条件删除</p>
     * @param psiTransferRouteInfoEntity 实体类
     * @return 删除了多少行
     */
    public int deleteBySelective(PsiTransferRouteInfoEntity psiTransferRouteInfoEntity);
    /**
     * <p>Description: 根据主键查询实体</p>
     * @param psiTransferRouteInfoPk 主键实体
     * @return psiTransferRouteInfoPk 单个实体对象
     */
    public PsiTransferRouteInfoEntity load(PsiTransferRouteInfoPk psiTransferRouteInfoPk);
    /**
     * <p>Description: 根据条件查询集合实体</p>
     * @param psiTransferRouteInfoEntity 查询条件
     * @return 实体集合
     */
    public List<PsiTransferRouteInfoEntity> selectBySelective(PsiTransferRouteInfoEntity psiTransferRouteInfoEntity);
    /**
     * <p>Description: 根据条件查询多少行数据</p>
     * @param psiTransferRouteInfoEntity 查询条件
     * @return 数据行数
     */
    public int selectBySelectiveCount(PsiTransferRouteInfoEntity psiTransferRouteInfoEntity);
    
}
