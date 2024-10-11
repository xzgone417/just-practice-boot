package com.exp.ucmp.mall.dao;

import com.exp.ucmp.clues.dto.PsiSalesCustomerDto;
import com.exp.ucmp.clues.dto.SalesCustomerDto;
import com.exp.ucmp.clues.dto.SalesCustomerInfoDto;
import com.exp.ucmp.clues.dto.SalesCustomerParamDto;
import com.exp.ucmp.entity.PsiSalesCustomerEntity;

import java.util.List;

/**
 * <p>@ClassName: PsiSalesCustomerDao</p>
 * <p>@Description: </p>
 * <p>@Author: fxy</p>
 * <p>@Date: 2023/6/21 0:26<p>
 */
public interface PsiSalesCustomerDao {

    List<PsiSalesCustomerEntity> selectByList(PsiSalesCustomerDto psiSalesCustomerDto);

    List<SalesCustomerDto> queryList(PsiSalesCustomerDto psiSalesCustomerDto);

    List<SalesCustomerInfoDto> queryCustomerList(SalesCustomerParamDto paramDto);
}
