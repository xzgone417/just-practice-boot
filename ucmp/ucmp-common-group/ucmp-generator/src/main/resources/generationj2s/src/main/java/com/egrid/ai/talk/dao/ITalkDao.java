/**
 * 
 * 初米网络
 * Copyright (C) 2018 Egridcloud, Inc, All rights reserved.
 */
 package com.egrid.ai.talk.dao;

import com.egrid.ai.entity.DmTalkCyclesRecordEntity;
import com.egrid.ai.entity.DmTalkInterResultEntity;

/**
 * @author lx
 * @date 2018/10/24
 */
public interface ITalkDao {

    /**
     * 更新应答内容
     * @param dmTalkCyclesRecordEntity 参数
     * @return 更新行数
     */
    public int updateReplyContent(DmTalkCyclesRecordEntity dmTalkCyclesRecordEntity);
    
    /**
     * 更新应答记录
     * @param dmTalkInterResultEntity 参数
     * @return 更新行数
     */
    public int updateTalkInter(DmTalkInterResultEntity dmTalkInterResultEntity);
}
