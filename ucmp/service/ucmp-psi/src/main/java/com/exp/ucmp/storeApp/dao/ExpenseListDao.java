package com.exp.ucmp.storeApp.dao;

import com.exp.ucmp.stock.dto.ExpenseListDto;

import java.util.List;

/**
 * @author gubonai
 * @date 2023/01/30
 * 查询车辆费用清单列表
 */
public interface ExpenseListDao {


    /**
     * 查询车辆费用清单列表
     * @param expenseListParamDto
     * @return
     */
    ExpenseListDto queryExpenseList(String vin);
}
