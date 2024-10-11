package com.exp.ucmp.newcarorder.dao;

import java.util.List;

import com.exp.ucmp.entity.PsiNewCarOrderEntity;

public interface NewCarOrderDao {

	List<String> getOrderList();

	void updateOrderInfoByOrderNum(PsiNewCarOrderEntity entity);


}
