/**
 * 
 * 初米网络
 * Copyright (C) 2018 Egridcloud, Inc, All rights reserved.
 */
 package com.egrid.ai.talk.service;

import com.egrid.ai.talk.dto.DialogReqDto;
import com.egrid.ai.talk.dto.DialogResultDto;

/**
 * @author lx
 * @date 2018/10/24
 */
public interface ITalkService {

    /**
     * 问答对话
     * @param dialogReqDto 请求参数
     * @return 应答
     */
    public DialogResultDto dialog(DialogReqDto dialogReqDto);
}
