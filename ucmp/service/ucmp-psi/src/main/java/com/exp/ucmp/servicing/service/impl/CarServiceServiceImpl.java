package com.exp.ucmp.servicing.service.impl;

import com.egrid.core.shiro.context.AuthContext;
import com.exp.ucmp.constant.Constants;
import com.exp.ucmp.dao.IPsiCarStockInfoDao;
import com.exp.ucmp.entity.PsiCarStockInfoEntity;
import com.exp.ucmp.model.Person;
import com.exp.ucmp.servicing.dto.OfflineServiceDto;
import com.exp.ucmp.servicing.service.CarServiceService;

import cn.hutool.core.collection.CollectionUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarServiceServiceImpl implements CarServiceService {
	
    @Autowired
    private IPsiCarStockInfoDao iPsiCarStockInfoDao;

	@Override
	public void completeCarService(OfflineServiceDto offlineServiceDto) {
		Person user = (Person) AuthContext.getInstance(Person.class).getCurrentUser();
		if(CollectionUtil.isNotEmpty(offlineServiceDto.getStockId())){
			List<PsiCarStockInfoEntity> listPsiCarStockInfoEntity = new ArrayList<>();
			offlineServiceDto.getStockId().forEach(stockId ->{
				PsiCarStockInfoEntity entity = new PsiCarStockInfoEntity();
				entity.setStockId(stockId);
				entity.setUpdatedBy(user.getPartyId());
				entity.setUpdatedDate(new Date());
				entity.setStockState(Constants.STOCK_STATUS.WAIT_PUT.value());
				entity.setServiceTime(new Date());
				listPsiCarStockInfoEntity.add(entity);
			});
			this.iPsiCarStockInfoDao.batchUpdateSelective(listPsiCarStockInfoEntity);
		}
	}

}
