package com.exp.ucmp.carDealer.service;

import com.exp.ucmp.carDealer.dto.JobHandlerResult;
import com.exp.ucmp.entity.PsiCustomerReservationTrackEntity;
import com.exp.ucmp.entity.PsiMessageInfoEntity;

public interface MessagePushService {
    /**
     * 检测截止前消息推送
     */
    JobHandlerResult deadlineTimeBeforeTime();

    /**
     * 报价截止前消息推送
     */
    JobHandlerResult quotingDeadlineBefore();

    /**
     * 距离客户同意收购价格时间等于后台定义的时间差，车商未上传收车材料
     */
    JobHandlerResult customerAgreeTimeLater();

    /**
     * 距离首次上报材料时间等于后台定义的时间差，车商未上传过户材料
     */
    JobHandlerResult firstEscalationTimeLater();

    /**
     * 插入消息记录
     * @param entity
     * @return
     */
    Boolean insertMessage(PsiMessageInfoEntity entity);

    /**
     * 查询uid
     */
    String selectUid(PsiCustomerReservationTrackEntity entity);
}
