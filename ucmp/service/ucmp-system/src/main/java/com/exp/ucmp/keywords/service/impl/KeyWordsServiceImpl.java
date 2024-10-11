package com.exp.ucmp.keywords.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egrid.core.shiro.context.AuthContext;
import com.egrid.core.util.JsonBeanUtil;
import com.exp.ucmp.dao.ISysKeyWordDao;
import com.exp.ucmp.entity.SysKeyWordEntity;
import com.exp.ucmp.keywords.dto.KeyWordsDto;
import com.exp.ucmp.keywords.service.KeyWordsService;
import com.exp.ucmp.keywords.web.KeyWordsController;
import com.exp.ucmp.model.Person;

@Service
public class KeyWordsServiceImpl implements KeyWordsService{
	
	/**
	 * <p>
	 * Field LOGGER: log
	 * </p>
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(KeyWordsController.class);
	
	@Autowired
	private ISysKeyWordDao iSysKeyWordDao;
	
	@Override
	public List<SysKeyWordEntity> getKeyWordsList(Integer keyWordsType) {
		SysKeyWordEntity entity=new SysKeyWordEntity();
		entity.setKeyWordsType(keyWordsType);
		entity.setIsDelete("00");
		return this.iSysKeyWordDao.selectBySelective(entity);
	}

	@Override
	public void addKeyWords(KeyWordsDto dto) {
		Long partyId=AuthContext.getInstance(Person.class).getCurrentUser().getPartyId();
		//查询所有该类型关键字
		SysKeyWordEntity sysKeyWordEntity=new SysKeyWordEntity();
		sysKeyWordEntity.setKeyWordsType(dto.getKeyWordsType());
		sysKeyWordEntity.setIsDelete("00");
		List<SysKeyWordEntity> list=this.iSysKeyWordDao.selectBySelective(sysKeyWordEntity);
		
		List<String> curList=new ArrayList<>();
		
		if(!list.isEmpty()){
			list.forEach(key ->{
				curList.add(key.getKeyWords());
			});
		}
		
		//添加
		if(!dto.getAddLsit().isEmpty()){
			//取交集
			List<String> updatelist=new ArrayList<>(CollectionUtils.intersection(curList, dto.getAddLsit()));
			LOGGER.info("==updatelist=="+JsonBeanUtil.beanToJson(updatelist));
			//与交集和当前关键字取差集,需要删除的关键字
			List<String> deList=new ArrayList<>(CollectionUtils.subtract(curList, updatelist));
			LOGGER.info("==deList=="+JsonBeanUtil.beanToJson(deList));
			//与交集和新增关键字取差集,需要新增的关键字
			List<String> addList=new ArrayList<>(CollectionUtils.subtract(dto.getAddLsit(), updatelist));
			LOGGER.info("==addList=="+JsonBeanUtil.beanToJson(addList));
			if(CollectionUtils.isNotEmpty(deList)){
				deList.forEach(de ->{
					SysKeyWordEntity entity=new SysKeyWordEntity();
					entity.setIsDelete("01");
					entity.setKeyWords(de);
					entity.setKeyWordsType(dto.getKeyWordsType());
					entity.setUpdatedBy(partyId);
					this.iSysKeyWordDao.updateByKeyWord(entity);
				});
			}
			if(CollectionUtils.isNotEmpty(addList)){
				addList.forEach(add ->{
					SysKeyWordEntity entity=new SysKeyWordEntity();
					entity.setIsDelete("00");
					entity.setKeyWords(add);
					entity.setKeyWordsType(dto.getKeyWordsType());
					entity.generatePk();
					entity.setCreatedBy(partyId);
					entity.setUpdatedBy(partyId);
					this.iSysKeyWordDao.insert(entity);
				});
			}
		}
	}


}
