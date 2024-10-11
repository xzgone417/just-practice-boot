package com.exp.ucmp.keywords.service;

import java.util.List;

import com.exp.ucmp.entity.SysKeyWordEntity;
import com.exp.ucmp.keywords.dto.KeyWordsDto;

public interface KeyWordsService {

	List<SysKeyWordEntity> getKeyWordsList(Integer keyWordsType);

	void addKeyWords(KeyWordsDto dto);

}
