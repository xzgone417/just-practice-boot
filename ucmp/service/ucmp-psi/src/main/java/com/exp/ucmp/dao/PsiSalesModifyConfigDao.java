package com.exp.ucmp.dao;


import com.exp.ucmp.entity.PsiSalesModifyConfigEntity;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface PsiSalesModifyConfigDao {

    int insert(PsiSalesModifyConfigEntity record);

    int insertSelective(PsiSalesModifyConfigEntity record);

    PsiSalesModifyConfigEntity selectByPrimaryKey(Long applyId);

    List<PsiSalesModifyConfigEntity> selectBySelective(PsiSalesModifyConfigEntity entity);

    int updateByPrimaryKeySelective(PsiSalesModifyConfigEntity record);

    int updateByPrimaryKey(PsiSalesModifyConfigEntity record);

	String queryProductCode(@Param("vinCode")String vinCode);
}