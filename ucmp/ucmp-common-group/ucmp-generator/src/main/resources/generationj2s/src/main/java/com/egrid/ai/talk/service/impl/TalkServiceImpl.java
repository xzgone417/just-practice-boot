/**
 * 
 * 初米网络
 * Copyright (C) 2018 Egridcloud, Inc, All rights reserved.
 */
 package com.egrid.ai.talk.service.impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.egrid.ai.constant.Constants;
import com.egrid.ai.dm.consumer.IDialogueManageConsumer;
import com.egrid.ai.entity.DmTalkCyclesRecordEntity;
import com.egrid.ai.entity.DmTalkInterResultEntity;
import com.egrid.ai.nlg.consumer.IReplyGenerateConsumer;
import com.egrid.ai.nlu.consumer.ISemanticUnderstandConsumer;
import com.egrid.ai.talk.dao.ITalkDao;
import com.egrid.ai.talk.dto.ActionResponseDto;
import com.egrid.ai.talk.dto.DialogReqDto;
import com.egrid.ai.talk.dto.DialogResultDto;
import com.egrid.ai.talk.dto.DialogueManageReqDto;
import com.egrid.ai.talk.dto.DmResponseDto;
import com.egrid.ai.talk.dto.ReplyGenerateReqDto;
import com.egrid.ai.talk.dto.ReplyGenerateResultDto;
import com.egrid.ai.talk.dto.TalkActionResultDto;
import com.egrid.ai.talk.dto.TalkContentReqDto;
import com.egrid.ai.talk.dto.TalkIntentResultDto;
import com.egrid.ai.talk.dto.TalkManageResultDto;
import com.egrid.ai.talk.dto.TalkReslutDto;
import com.egrid.ai.talk.service.ITalkService;
import com.egrid.core.web.response.RestResponse;
import com.egrid.core.web.response.RestStatusCode;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author lx
 * @date 2018/10/24
 */
@Service
public class TalkServiceImpl implements ITalkService {
    
    /**
     * <p>
     * Field LOGGER: log
     * </p>
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TalkServiceImpl.class);

    @Autowired
    private IReplyGenerateConsumer replyGenerateConsumer;
    
    @Autowired
    private ISemanticUnderstandConsumer semanticUnderstandConsumer;
    
    @Autowired
    private IDialogueManageConsumer dialogueManageConsumer;
    
    @Autowired
    private ITalkDao talkDao;
    
    @Override
    @Transactional(rollbackFor=Exception.class)
    public DialogResultDto dialog(DialogReqDto dialogReqDto) {
        long startTime = System.currentTimeMillis();
        LOGGER.info("talk开始时间：" + startTime);
        DialogResultDto dialogResultDto = initDialogResult(dialogReqDto);
        TalkIntentResultDto talkIntentResultDto = this.semanticUnderstand(dialogReqDto);
        DmResponseDto dmResponseDto = this.dialogueManage(dialogReqDto, talkIntentResultDto);
        ReplyGenerateResultDto replyGenerateResultDto = this.replyGenerate(dialogReqDto, dmResponseDto);
        
        TalkReslutDto talkReslut = new TalkReslutDto();
        dialogResultDto.setTalkReslut(talkReslut);
        talkReslut.setResult(dmResponseDto.getDmReslut().getResult());
        
        TalkActionResultDto action = this.getTalkAction(dmResponseDto, replyGenerateResultDto);
        talkReslut.setAction(action);
        
        this.updateReplyContent(dmResponseDto.getDmReslut().getResult().getTalkLogId(), 
            dialogReqDto.getRobotId(), replyGenerateResultDto.getNlgResult().getText());
        
        this.updateTalkIntentResult(dialogReqDto, dialogResultDto, dmResponseDto.getDmReslut().getResult().getTalkLogId());
        
        if (Constants.TalkMotion.SATISFY.value().equals(dialogResultDto.getTalkReslut().getAction().getType())) {
            TalkManageResultDto talkManageResultDto = dialogResultDto.getTalkReslut().getResult();
            talkManageResultDto.setTalkId(null);
            talkManageResultDto.setTalkLogId(null);
        }
        long endTime = System.currentTimeMillis();
        LOGGER.info("talk结束时间：" + endTime);
        LOGGER.info("耗时：" + (endTime - startTime));
        return dialogResultDto;
    }
    
    /**
     * 更新对话日志记录
     * @param dialogReqDto 对话请求
     * @param dialogResultDto 对话响应
     * @param talkRecordId 对话id轮次
     */
    private void updateTalkIntentResult(DialogReqDto dialogReqDto, DialogResultDto dialogResultDto, Long talkRecordId) {
        DmTalkInterResultEntity dmTalkInterResultEntity = new DmTalkInterResultEntity();
        dmTalkInterResultEntity.setUpdatedBy(dialogReqDto.getRobotId());
        dmTalkInterResultEntity.setUpdatedDate(new Date());
        ObjectMapper mapper = new ObjectMapper();
        dmTalkInterResultEntity.setTalkRequest(this.objectToString(mapper, dialogReqDto));
        dmTalkInterResultEntity.setTalkResponse(this.objectToString(mapper, dialogResultDto));
        dmTalkInterResultEntity.setTalkRecordId(talkRecordId);
        talkDao.updateTalkInter(dmTalkInterResultEntity);
    }
    
    /**
     * 更新应答内容
     * @param talkRecordId 对话周期id
     * @param robotId 机器人id
     * @param replyText 应答内容
     */
    private void updateReplyContent(Long talkRecordId, Long robotId, String replyText) {
        DmTalkCyclesRecordEntity dmTalkCyclesRecordEntity = new DmTalkCyclesRecordEntity();
        dmTalkCyclesRecordEntity.setTalkRecordId(talkRecordId);
        dmTalkCyclesRecordEntity.setUpdatedBy(robotId);
        dmTalkCyclesRecordEntity.setUpdatedDate(new Date());
        dmTalkCyclesRecordEntity.setTalkResp(replyText);
        talkDao.updateReplyContent(dmTalkCyclesRecordEntity);
    }
    
    /**
     * 获取响应动作
     * @param dmResponseDto 对话管理响应
     * @param replyGenerateResultDto 应答响应
     * @return 响应动作
     */
    private TalkActionResultDto getTalkAction(DmResponseDto dmResponseDto, ReplyGenerateResultDto replyGenerateResultDto) {
        TalkActionResultDto action = new TalkActionResultDto();
        ActionResponseDto actionResponse = dmResponseDto.getDmReslut().getAction();
        action.setActionId(actionResponse.getActionId());
        action.setType(actionResponse.getType());
        action.setRefineDetail(actionResponse.getRefineDetail());
        action.setReply(replyGenerateResultDto.getNlgResult());
        return action;
    }
    
    /**
     * 初始化对话结果
     * @param dialogReqDto 请求参数
     * @return 对话结果
     */
    private DialogResultDto initDialogResult(DialogReqDto dialogReqDto) {
        LOGGER.info(dialogReqDto.getReqContent());
        LOGGER.info(dialogReqDto.getTalkId() + "");
        LOGGER.info(dialogReqDto.getRobotId() + "");
        DialogResultDto dialogResultDto = new DialogResultDto();
        dialogResultDto.setCustomerId(dialogReqDto.getCustomerId());
        dialogResultDto.setRobotId(dialogReqDto.getRobotId());
        return dialogResultDto;
    }
    
    /**
     * 语义理解
     * @param dialogReqDto 请求参数
     * @return 语义理解结果
     */
    private TalkIntentResultDto semanticUnderstand(DialogReqDto dialogReqDto) {
        long startTime = System.currentTimeMillis();
        LOGGER.info("nlu开始时间：" + startTime);
        TalkContentReqDto talkContentReqDto = new TalkContentReqDto();
        talkContentReqDto.setCustomerId(dialogReqDto.getCustomerId());
        talkContentReqDto.setReqContent(dialogReqDto.getReqContent());
        talkContentReqDto.setCustomerExtended(dialogReqDto.getCustomerExtended());
        talkContentReqDto.setReqSource(dialogReqDto.getReqSource());
        talkContentReqDto.setReqType(dialogReqDto.getReqType());
        talkContentReqDto.setRobotId(dialogReqDto.getRobotId());
        talkContentReqDto.setDomainId(dialogReqDto.getDomainId());
        talkContentReqDto.setTalkId(dialogReqDto.getTalkId());
        RestResponse<TalkIntentResultDto> result = semanticUnderstandConsumer.semanticUnderstand(talkContentReqDto);
        long endTime = System.currentTimeMillis();
        LOGGER.info("nlu结束时间：" + endTime);
        LOGGER.info("耗时：" + (endTime - startTime));
        if (RestStatusCode.OK.code() != result.getCode()) {
            return null;
        }
        return result.getResult();
    }
    
    /**
     * json
     * @param mapper Jackson mapper
     * @param obj 对象
     * @return json字符串
     */
    private String objectToString(ObjectMapper mapper, Object obj) {
        String jsonResult = "";
        try {
            jsonResult = mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            LOGGER.error("json转换失败", e);
        }
        return jsonResult;
    }
    
    /**
     * 对话管理
     * @param dialogReqDto 请求参数
     * @param talkIntentResultDto 语义理解结果
     * @return 对话管理结果
     */
    private DmResponseDto dialogueManage(DialogReqDto dialogReqDto, TalkIntentResultDto talkIntentResultDto) {
        long startTime = System.currentTimeMillis();
        LOGGER.info("dm开始时间：" + startTime);
        DialogueManageReqDto dmReqDto = new DialogueManageReqDto();
        dmReqDto.setCustomerId(dialogReqDto.getCustomerId());
        dmReqDto.setCustomerExtended(dialogReqDto.getCustomerExtended());
        dmReqDto.setReqSource(dialogReqDto.getReqSource());
        dmReqDto.setReqType(dialogReqDto.getReqType());
        dmReqDto.setRobotId(dialogReqDto.getRobotId());
        dmReqDto.setDomainId(dialogReqDto.getDomainId());
        dmReqDto.setTalkId(dialogReqDto.getTalkId());
        dmReqDto.setTaskId(dialogReqDto.getTaskId());
        dmReqDto.setBotType(dialogReqDto.getBotType());
        dmReqDto.setChannelId(dialogReqDto.getChannelId());
        dmReqDto.setChannelCode(dialogReqDto.getChannelCode());
        dmReqDto.setNluReslut(talkIntentResultDto.getNluReslut());
        RestResponse<DmResponseDto> result = dialogueManageConsumer.dialogueManageV2(dmReqDto);
        long endTime = System.currentTimeMillis();
        LOGGER.info("dm结束时间：" + endTime);
        LOGGER.info("耗时：" + (endTime - startTime));
        if (RestStatusCode.OK.code() != result.getCode()) {
            return null;
        }
        return result.getResult();
    }
    
    /**
     * 应答生成
     * @param dialogReqDto 请求参数
     * @param dmResponseDto 对话管理响应
     * @return 应答信息
     */
    private ReplyGenerateResultDto replyGenerate(DialogReqDto dialogReqDto, DmResponseDto dmResponseDto) {
        long startTime = System.currentTimeMillis();
        LOGGER.info("nlg开始时间：" + startTime);
        ReplyGenerateReqDto replyGenerateReqDto = new ReplyGenerateReqDto();
        replyGenerateReqDto.setDomainId(dialogReqDto.getDomainId());
        replyGenerateReqDto.setCustomerId(dialogReqDto.getCustomerId());
        replyGenerateReqDto.setCustomerExtended(dialogReqDto.getCustomerExtended());
        replyGenerateReqDto.setRobotId(dialogReqDto.getRobotId());
        replyGenerateReqDto.setTalkId(dmResponseDto.getDmReslut().getResult().getTalkId());
        replyGenerateReqDto.setTalkLogId(dmResponseDto.getDmReslut().getResult().getTalkLogId());
        replyGenerateReqDto.setReplyContent(dmResponseDto.getDmReslut().getAction().getReplyContent());
        replyGenerateReqDto.setReplyTempletParam(dmResponseDto.getDmReslut().getAction().getReplyTempletParam());
        RestResponse<ReplyGenerateResultDto> result = replyGenerateConsumer.generateV2(replyGenerateReqDto);
        long endTime = System.currentTimeMillis();
        LOGGER.info("nlg结束时间：" + endTime);
        LOGGER.info("耗时：" + (endTime - startTime));
        if (RestStatusCode.OK.code() != result.getCode()) {
            return null;
        }
        return result.getResult();
    }
}
