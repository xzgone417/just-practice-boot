package com.exp.ucmp.mall.dao;

import com.exp.ucmp.clues.dto.PsiSalesOrderMaterialDto;

import java.util.List;

/**
 * <p>@ClassName: PsiSalesOrderMaterialDao</p>
 * <p>@Description: </p>
 * <p>@Author: fxy</p>
 * <p>@Date: 2023/6/27 18:50<p>
 */
public interface PsiSalesOrderMaterialDao {

    public List<PsiSalesOrderMaterialDto> selectByOrderInfoId(Long orderInfoId);
}
